/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package android.media;

import android.os.Handler;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Looper;

/**
 * A class to encapsulate information about an audio focus request.
 * An {@code AudioFocusRequest} instance is built by {@link Builder}, and is used to
 * request and abandon audio focus, respectively
 * with {@link AudioManager#requestAudioFocus(AudioFocusRequest)} and
 * {@link AudioManager#abandonAudioFocusRequest(AudioFocusRequest)}.
 *
 * <h3>What is audio focus?</h3>
 * <p>Audio focus is a concept introduced in API 8. It is used to convey the fact that a user can
 * only focus on a single audio stream at a time, e.g. listening to music or a podcast, but not
 * both at the same time. In some cases, multiple audio streams can be playing at the same time,
 * but there is only one the user would really listen to (focus on), while the other plays in
 * the background. An example of this is driving directions being spoken while music plays at
 * a reduced volume (a.k.a. ducking).
 * <p>When an application requests audio focus, it expresses its intention to “own” audio focus to
 * play audio. Let’s review the different types of focus requests, the return value after a request,
 * and the responses to a loss.
 * <p class="note">Note: applications should not play anything until granted focus.</p>
 *
 * <h3>The different types of focus requests</h3>
 * <p>There are four focus request types. A successful focus request with each will yield different
 * behaviors by the system and the other application that previously held audio focus.
 * <ul>
 * <li>{@link AudioManager#AUDIOFOCUS_GAIN} expresses the fact that your application is now the
 * sole source of audio that the user is listening to. The duration of the audio playback is
 * unknown, and is possibly very long: after the user finishes interacting with your application,
 * (s)he doesn’t expect another audio stream to resume. Examples of uses of this focus gain are
 * for music playback, for a game or a video player.</li>
 *
 * <li>{@link AudioManager#AUDIOFOCUS_GAIN_TRANSIENT} is for a situation when you know your
 * application is temporarily grabbing focus from the current owner, but the user expects playback
 * to go back to where it was once your application no longer requires audio focus. An example is
 * for playing an alarm, or during a VoIP call. The playback is known to be finite: the alarm will
 * time-out or be dismissed, the VoIP call has a beginning and an end. When any of those events
 * ends, and if the user was listening to music when it started, the user expects music to resume,
 * but didn’t wish to listen to both at the same time.</li>
 *
 * <li>{@link AudioManager#AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK}: this focus request type is similar
 * to {@code AUDIOFOCUS_GAIN_TRANSIENT} for the temporary aspect of the focus request, but it also
 * expresses the fact during the time you own focus, you allow another application to keep playing
 * at a reduced volume, “ducked”. Examples are when playing driving directions or notifications,
 * it’s ok for music to keep playing, but not loud enough that it would prevent the directions to
 * be hard to understand. A typical attenuation by the “ducked” application is a factor of 0.2f
 * (or -14dB), that can for instance be applied with {@code MediaPlayer.setVolume(0.2f)} when
 * using this class for playback.</li>
 *
 * <li>{@link AudioManager#AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE} is also for a temporary request,
 * but also expresses that your application expects the device to not play anything else. This is
 * typically used if you are doing audio recording or speech recognition, and don’t want for
 * examples notifications to be played by the system during that time.</li>
 * </ul>
 *
 * <p>An {@code AudioFocusRequest} instance always contains one of the four types of requests
 * explained above. It is passed when building an {@code AudioFocusRequest} instance with its
 * builder in the {@link Builder} constructor
 * {@link AudioFocusRequest.Builder#AudioFocusRequest.Builder(int)}, or
 * with {@link AudioFocusRequest.Builder#setFocusGain(int)} after copying an existing instance with
 * {@link AudioFocusRequest.Builder#AudioFocusRequest.Builder(AudioFocusRequest)}.
 *
 * <h3>Qualifying your focus request</h3>
 * <h4>Use case requiring a focus request</h4>
 * <p>Any focus request is qualified by the {@link AudioAttributes}
 * (see {@link Builder#setAudioAttributes(AudioAttributes)}) that describe the audio use case that
 * will follow the request (once it's successful or granted). It is recommended to use the
 * same {@code AudioAttributes} for the request as the attributes you are using for audio/media
 * playback.
 * <br>If no attributes are set, default attributes of {@link AudioAttributes#USAGE_MEDIA} are used.
 *
 * <h4>Delayed focus</h4>
 * <p>Audio focus can be "locked" by the system for a number of reasons: during a phone call, when
 * the car to which the device is connected plays an emergency message... To support these
 * situations, the application can request to be notified when its request is fulfilled, by flagging
 * its request as accepting delayed focus, with {@link Builder#setAcceptsDelayedFocusGain(boolean)}.
 * <br>If focus is requested while being locked by the system,
 * {@link AudioManager#requestAudioFocus(AudioFocusRequest)} will return
 * {@link AudioManager#AUDIOFOCUS_REQUEST_DELAYED}. When focus isn't locked anymore, the focus
 * listener set with {@link Builder#setOnAudioFocusChangeListener(OnAudioFocusChangeListener)}
 * or with {@link Builder#setOnAudioFocusChangeListener(OnAudioFocusChangeListener, Handler)} will
 * be called to notify the application it now owns audio focus.
 *
 * <h4>Pausing vs ducking</h4>
 * <p>When an application requested audio focus with
 * {@link AudioManager#AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK}, the system will duck the current focus
 * owner.
 * <p class="note">Note: this behavior is <b>new for Android O</b>, whereas applications targeting
 * SDK level up to API 25 had to implement the ducking themselves when they received a focus
 * loss of {@link AudioManager#AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK}.
 * <p>But ducking is not always the behavior expected by the user. A typical example is when the
 * device plays driving directions while the user is listening to an audio book or podcast, and
 * expects the audio playback to pause, instead of duck, as it is hard to understand a navigation
 * prompt and spoken content at the same time. Therefore the system will not automatically duck
 * when it detects it would be ducking spoken content: such content is detected when the
 * {@code AudioAttributes} of the player are qualified by
 * {@link AudioAttributes#CONTENT_TYPE_SPEECH}. Refer for instance to
 * {@link AudioAttributes.Builder#setContentType(int)} and
 * {@link MediaPlayer#setAudioAttributes(AudioAttributes)} if you are writing a media playback
 * application for audio book, podcasts... Since the system will not automatically duck applications
 * that play speech, it calls their focus listener instead to notify them of
 * {@link AudioManager#AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK}, so they can pause instead. Note that
 * this behavior is independent of the use of {@code AudioFocusRequest}, but tied to the use
 * of {@code AudioAttributes}.
 * <p>If your application requires pausing instead of ducking for any other reason than playing
 * speech, you can also declare so with {@link Builder#setWillPauseWhenDucked(boolean)}, which will
 * cause the system to call your focus listener instead of automatically ducking.
 *
 * <h4>Example</h4>
 * <p>The example below covers the following steps to be found in any application that would play
 * audio, and use audio focus. Here we play an audio book, and our application is intended to pause
 * rather than duck when it loses focus. These steps consist in:
 * <ul>
 * <li>Creating {@code AudioAttributes} to be used for the playback and the focus request.</li>
 * <li>Configuring and creating the {@code AudioFocusRequest} instance that defines the intended
 *     focus behaviors.</li>
 * <li>Requesting audio focus and checking the return code to see if playback can happen right
 *     away, or is delayed.</li>
 * <li>Implementing a focus change listener to respond to focus gains and losses.</li>
 * </ul>
 * <p>
 * <pre class="prettyprint">
 * // initialization of the audio attributes and focus request
 * mAudioManager = (AudioManager) Context.getSystemService(Context.AUDIO_SERVICE);
 * mPlaybackAttributes = new AudioAttributes.Builder()
 *         .setUsage(AudioAttributes.USAGE_MEDIA)
 *         .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
 *         .build();
 * mFocusRequest = new AudioFocusRequest.Builder(AudioManager.AUDIOFOCUS_GAIN)
 *         .setAudioAttributes(mPlaybackAttributes)
 *         .setAcceptsDelayedFocusGain(true)
 *         .setWillPauseWhenDucked(true)
 *         .setOnAudioFocusChangeListener(this, mMyHandler)
 *         .build();
 * mMediaPlayer = new MediaPlayer();
 * mMediaPlayer.setAudioAttributes(mPlaybackAttributes);
 * final Object mFocusLock = new Object();
 *
 * boolean mPlaybackDelayed = false;
 *
 * // requesting audio focus
 * int res = mAudioManager.requestAudioFocus(mFocusRequest);
 * synchronized (mFocusLock) {
 *     if (res == AudioManager.AUDIOFOCUS_REQUEST_FAILED) {
 *         mPlaybackDelayed = false;
 *     } else if (res == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
 *         mPlaybackDelayed = false;
 *         playbackNow();
 *     } else if (res == AudioManager.AUDIOFOCUS_REQUEST_DELAYED) {
 *        mPlaybackDelayed = true;
 *     }
 * }
 *
 * // implementation of the OnAudioFocusChangeListener
 * &#64;Override
 * public void onAudioFocusChange(int focusChange) {
 *     switch (focusChange) {
 *         case AudioManager.AUDIOFOCUS_GAIN:
 *             if (mPlaybackDelayed || mResumeOnFocusGain) {
 *                 synchronized (mFocusLock) {
 *                     mPlaybackDelayed = false;
 *                     mResumeOnFocusGain = false;
 *                 }
 *                 playbackNow();
 *             }
 *             break;
 *         case AudioManager.AUDIOFOCUS_LOSS:
 *             synchronized (mFocusLock) {
 *                 // this is not a transient loss, we shouldn't automatically resume for now
 *                 mResumeOnFocusGain = false;
 *                 mPlaybackDelayed = false;
 *             }
 *             pausePlayback();
 *             break;
 *         case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
 *         case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
 *             // we handle all transient losses the same way because we never duck audio books
 *             synchronized (mFocusLock) {
 *                 // we should only resume if playback was interrupted
 *                 mResumeOnFocusGain = mMediaPlayer.isPlaying();
 *                 mPlaybackDelayed = false;
 *             }
 *             pausePlayback();
 *             break;
 *     }
 * }
 *
 * // Important:
 * // Also set "mResumeOnFocusGain" to false when the user pauses or stops playback: this way your
 * // application doesn't automatically restart when it gains focus, even though the user had
 * // stopped it.
 * </pre>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AudioFocusRequest {

AudioFocusRequest(android.media.AudioManager.OnAudioFocusChangeListener listener, android.os.Handler handler, android.media.AudioAttributes attr, int focusGain, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link AudioAttributes} set for this {@code AudioFocusRequest}, or the default
 * attributes if none were set.
 * @return non-null {@link AudioAttributes}.
 */

@androidx.annotation.RecentlyNonNull public android.media.AudioAttributes getAudioAttributes() { throw new RuntimeException("Stub!"); }

/**
 * Returns the type of audio focus request configured for this {@code AudioFocusRequest}.
 * @return one of {@link AudioManager#AUDIOFOCUS_GAIN},
 * {@link AudioManager#AUDIOFOCUS_GAIN_TRANSIENT},
 * {@link AudioManager#AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK}, and
 * {@link AudioManager#AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE}.
 */

public int getFocusGain() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the application that would use this {@code AudioFocusRequest} would pause
 * when it is requested to duck.
 * @return the duck/pause behavior.
 */

public boolean willPauseWhenDucked() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the application that would use this {@code AudioFocusRequest} supports
 * a focus gain granted after a temporary request failure.
 * @return whether delayed focus gain is supported.
 */

public boolean acceptsDelayedFocusGain() { throw new RuntimeException("Stub!"); }
/**
 * Builder class for {@link AudioFocusRequest} objects.
 * <p>See {@link AudioFocusRequest} for an example of building an instance with this builder.
 * <br>The default values for the instance to be built are:
 * <table>
 * <tr><td>focus listener and handler</td><td>none</td></tr>
 * <tr><td>{@code AudioAttributes}</td><td>attributes with usage set to
 *     {@link AudioAttributes#USAGE_MEDIA}</td></tr>
 * <tr><td>pauses on duck</td><td>false</td></tr>
 * <tr><td>supports delayed focus grant</td><td>false</td></tr>
 * </table>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Constructs a new {@code Builder}, and specifies how audio focus
 * will be requested. Valid values for focus requests are
 * {@link AudioManager#AUDIOFOCUS_GAIN}, {@link AudioManager#AUDIOFOCUS_GAIN_TRANSIENT},
 * {@link AudioManager#AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK}, and
 * {@link AudioManager#AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE}.
 * <p>By default there is no focus change listener, delayed focus is not supported, ducking
 * is suitable for the application, and the <code>AudioAttributes</code>
 * have a usage of {@link AudioAttributes#USAGE_MEDIA}.
 * @param focusGain the type of audio focus gain that will be requested
 * @throws IllegalArgumentException thrown when an invalid focus gain type is used
 */

public Builder(int focusGain) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code Builder} with all the properties of the {@code AudioFocusRequest}
 * passed as parameter.
 * Use this method when you want a new request to differ only by some properties.
 * @param requestToCopy the non-null {@code AudioFocusRequest} to build a duplicate from.
 * This value must never be {@code null}.
 * @throws IllegalArgumentException thrown when a null {@code AudioFocusRequest} is used.
 */

public Builder(@androidx.annotation.RecentlyNonNull android.media.AudioFocusRequest requestToCopy) { throw new RuntimeException("Stub!"); }

/**
 * Sets the type of focus gain that will be requested.
 * Use this method to replace the focus gain when building a request by modifying an
 * existing {@code AudioFocusRequest} instance.
 * @param focusGain the type of audio focus gain that will be requested.
 * @return this {@code Builder} instance
 * This value will never be {@code null}.
 * @throws IllegalArgumentException thrown when an invalid focus gain type is used
 */

@androidx.annotation.RecentlyNonNull public android.media.AudioFocusRequest.Builder setFocusGain(int focusGain) { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener called when audio focus changes after being requested with
 *   {@link AudioManager#requestAudioFocus(AudioFocusRequest)}, and until being abandoned
 *   with {@link AudioManager#abandonAudioFocusRequest(AudioFocusRequest)}.
 *   Note that only focus changes (gains and losses) affecting the focus owner are reported,
 *   not gains and losses of other focus requesters in the system.<br>
 *   Notifications are delivered on the {@link Looper} associated with the one of
 *   the creation of the {@link AudioManager} used to request focus
 *   (see {@link AudioManager#requestAudioFocus(AudioFocusRequest)}).
 * @param listener the listener receiving the focus change notifications.
 * This value must never be {@code null}.
 * @return this {@code Builder} instance.
 * @throws NullPointerException thrown when a null focus listener is used.
 */

@androidx.annotation.RecentlyNonNull public android.media.AudioFocusRequest.Builder setOnAudioFocusChangeListener(@androidx.annotation.RecentlyNonNull android.media.AudioManager.OnAudioFocusChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener called when audio focus changes after being requested with
 *   {@link AudioManager#requestAudioFocus(AudioFocusRequest)}, and until being abandoned
 *   with {@link AudioManager#abandonAudioFocusRequest(AudioFocusRequest)}.
 *   Note that only focus changes (gains and losses) affecting the focus owner are reported,
 *   not gains and losses of other focus requesters in the system.
 * @param listener the listener receiving the focus change notifications.
 * This value must never be {@code null}.
 * @param handler the {@link Handler} for the thread on which to execute
 *   the notifications.
 * This value must never be {@code null}.
 * @return this {@code Builder} instance.
 * @throws NullPointerException thrown when a null focus listener or handler is used.
 */

@androidx.annotation.RecentlyNonNull public android.media.AudioFocusRequest.Builder setOnAudioFocusChangeListener(@androidx.annotation.RecentlyNonNull android.media.AudioManager.OnAudioFocusChangeListener listener, @androidx.annotation.RecentlyNonNull android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link AudioAttributes} to be associated with the focus request, and which
 * describe the use case for which focus is requested.
 * As the focus requests typically precede audio playback, this information is used on
 * certain platforms to declare the subsequent playback use case. It is therefore good
 * practice to use in this method the same {@code AudioAttributes} as used for
 * playback, see for example {@link MediaPlayer#setAudioAttributes(AudioAttributes)} in
 * {@code MediaPlayer} or {@link AudioTrack.Builder#setAudioAttributes(AudioAttributes)}
 * in {@code AudioTrack}.
 * @param attributes the {@link AudioAttributes} for the focus request.
 * This value must never be {@code null}.
 * @return this {@code Builder} instance.
 * @throws NullPointerException thrown when using null for the attributes.
 */

@androidx.annotation.RecentlyNonNull public android.media.AudioFocusRequest.Builder setAudioAttributes(@androidx.annotation.RecentlyNonNull android.media.AudioAttributes attributes) { throw new RuntimeException("Stub!"); }

/**
 * Declare the intended behavior of the application with regards to audio ducking.
 * See more details in the {@link AudioFocusRequest} class documentation.
 * @param pauseOnDuck use {@code true} if the application intends to pause audio playback
 *    when losing focus with {@link AudioManager#AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK}.
 *    If {@code true}, note that you must also set a focus listener to receive such an
 *    event, with
 *    {@link #setOnAudioFocusChangeListener(OnAudioFocusChangeListener, Handler)}.
 * @return this {@code Builder} instance.

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.media.AudioFocusRequest.Builder setWillPauseWhenDucked(boolean pauseOnDuck) { throw new RuntimeException("Stub!"); }

/**
 * Marks this focus request as compatible with delayed focus.
 * See more details about delayed focus in the {@link AudioFocusRequest} class
 * documentation.
 * @param acceptsDelayedFocusGain use {@code true} if the application supports delayed
 *    focus. If {@code true}, note that you must also set a focus listener to be notified
 *    of delayed focus gain, with
 *    {@link #setOnAudioFocusChangeListener(OnAudioFocusChangeListener, Handler)}.
 * @return this {@code Builder} instance

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.media.AudioFocusRequest.Builder setAcceptsDelayedFocusGain(boolean acceptsDelayedFocusGain) { throw new RuntimeException("Stub!"); }

/**
 * Marks this focus request as forcing ducking, regardless of the conditions in which
 * the system would or would not enforce ducking.
 * Forcing ducking will only be honored when requesting AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK
 * with an {@link AudioAttributes} usage of
 * {@link AudioAttributes#USAGE_ASSISTANCE_ACCESSIBILITY}, coming from an accessibility
 * service, and will be ignored otherwise.
 * @param forceDucking {@code true} to force ducking
 * @return this {@code Builder} instance

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.media.AudioFocusRequest.Builder setForceDucking(boolean forceDucking) { throw new RuntimeException("Stub!"); }

/**
 * Builds a new {@code AudioFocusRequest} instance combining all the information gathered
 * by this {@code Builder}'s configuration methods.
 * @return the {@code AudioFocusRequest} instance qualified by all the properties set
 *   on this {@code Builder}.
 * @throws IllegalStateException thrown when attempting to build a focus request that is set
 *    to accept delayed focus, or to pause on duck, but no focus change listener was set.
 */

public android.media.AudioFocusRequest build() { throw new RuntimeException("Stub!"); }
}

}

