/*
 * Copyright (C) 2010 The Android Open Source Project
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


package android.media.audiofx;

import java.util.UUID;
import android.os.Handler;

/**
 * AudioEffect is the base class for controlling audio effects provided by the android audio
 * framework.
 * <p>Applications should not use the AudioEffect class directly but one of its derived classes to
 * control specific effects:
 * <ul>
 *   <li> {@link android.media.audiofx.Equalizer}</li>
 *   <li> {@link android.media.audiofx.Virtualizer}</li>
 *   <li> {@link android.media.audiofx.BassBoost}</li>
 *   <li> {@link android.media.audiofx.PresetReverb}</li>
 *   <li> {@link android.media.audiofx.EnvironmentalReverb}</li>
 *   <li> {@link android.media.audiofx.DynamicsProcessing}</li>
 * </ul>
 * <p>To apply the audio effect to a specific AudioTrack or MediaPlayer instance,
 * the application must specify the audio session ID of that instance when creating the AudioEffect.
 * (see {@link android.media.MediaPlayer#getAudioSessionId()} for details on audio sessions).
 * <p>NOTE: attaching insert effects (equalizer, bass boost, virtualizer) to the global audio output
 * mix by use of session 0 is deprecated.
 * <p>Creating an AudioEffect object will create the corresponding effect engine in the audio
 * framework if no instance of the same effect type exists in the specified audio session.
 * If one exists, this instance will be used.
 * <p>The application creating the AudioEffect object (or a derived class) will either receive
 * control of the effect engine or not depending on the priority parameter. If priority is higher
 * than the priority used by the current effect engine owner, the control will be transfered to the
 * new object. Otherwise control will remain with the previous object. In this case, the new
 * application will be notified of changes in effect engine state or control ownership by the
 * appropriate listener.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AudioEffect {

/**
 * Class constructor.
 *
 * @param type type of effect engine created. See {@link #EFFECT_TYPE_ENV_REVERB},
 *            {@link #EFFECT_TYPE_EQUALIZER} ... Types corresponding to
 *            built-in effects are defined by AudioEffect class. Other types
 *            can be specified provided they correspond an existing OpenSL
 *            ES interface ID and the corresponsing effect is available on
 *            the platform. If an unspecified effect type is requested, the
 *            constructor with throw the IllegalArgumentException. This
 *            parameter can be set to {@link #EFFECT_TYPE_NULL} in which
 *            case only the uuid will be used to select the effect.
 * @param uuid unique identifier of a particular effect implementation.
 *            Must be specified if the caller wants to use a particular
 *            implementation of an effect type. This parameter can be set to
 *            {@link #EFFECT_TYPE_NULL} in which case only the type will
 *            be used to select the effect.
 * @param priority the priority level requested by the application for
 *            controlling the effect engine. As the same effect engine can
 *            be shared by several applications, this parameter indicates
 *            how much the requesting application needs control of effect
 *            parameters. The normal priority is 0, above normal is a
 *            positive number, below normal a negative number.
 * @param audioSession system wide unique audio session identifier.
 *            The effect will be attached to the MediaPlayer or AudioTrack in
 *            the same audio session.
 *
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @throws java.lang.RuntimeException
 * @hide
 */

AudioEffect(java.util.UUID type, java.util.UUID uuid, int priority, int audioSession) throws java.lang.IllegalArgumentException, java.lang.RuntimeException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Releases the native AudioEffect resources. It is a good practice to
 * release the effect engine when not in use as control can be returned to
 * other applications or the native resources released.
 */

public void release() { throw new RuntimeException("Stub!"); }

protected void finalize() { throw new RuntimeException("Stub!"); }

/**
 * Get the effect descriptor.
 *
 * @see android.media.audiofx.AudioEffect.Descriptor
 * @throws IllegalStateException
 */

public android.media.audiofx.AudioEffect.Descriptor getDescriptor() throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Query all effects available on the platform. Returns an array of
 * {@link android.media.audiofx.AudioEffect.Descriptor} objects
 *
 * @throws IllegalStateException
 */

public static android.media.audiofx.AudioEffect.Descriptor[] queryEffects() { throw new RuntimeException("Stub!"); }

/**
 * Enable or disable the effect.
 * Creating an audio effect does not automatically apply this effect on the audio source. It
 * creates the resources necessary to process this effect but the audio signal is still bypassed
 * through the effect engine. Calling this method will make that the effect is actually applied
 * or not to the audio content being played in the corresponding audio session.
 *
 * @param enabled the requested enable state
 * @return {@link #SUCCESS} in case of success, {@link #ERROR_INVALID_OPERATION}
 *         or {@link #ERROR_DEAD_OBJECT} in case of failure.
 * @throws IllegalStateException
 */

public int setEnabled(boolean enabled) throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Returns effect unique identifier. This system wide unique identifier can
 * be used to attach this effect to a MediaPlayer or an AudioTrack when the
 * effect is an auxiliary effect (Reverb)
 *
 * @return the effect identifier.
 * @throws IllegalStateException
 */

public int getId() throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Returns effect enabled state
 *
 * @return true if the effect is enabled, false otherwise.
 * @throws IllegalStateException
 */

public boolean getEnabled() throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Checks if this AudioEffect object is controlling the effect engine.
 *
 * @return true if this instance has control of effect engine, false
 *         otherwise.
 * @throws IllegalStateException
 */

public boolean hasControl() throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener AudioEffect notifies when the effect engine is enabled
 * or disabled.
 *
 * @param listener
 */

public void setEnableStatusListener(android.media.audiofx.AudioEffect.OnEnableStatusChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener AudioEffect notifies when the effect engine control is
 * taken or returned.
 *
 * @param listener
 */

public void setControlStatusListener(android.media.audiofx.AudioEffect.OnControlStatusChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 *  Intent to signal to the effect control application or service that an audio session
 *  is closed and that effects should not be applied anymore.
 *  <p>The effect control application receiving this intent will delete all effects on
 *  this session and store current settings in package specific storage.
 *  <p>The calling package name is indicated by the {@link #EXTRA_PACKAGE_NAME} extra and the
 *  audio session ID by the {@link #EXTRA_AUDIO_SESSION} extra. Both extras are mandatory.
 *  <p>It is good practice for applications to broadcast this intent when music playback stops
 *  and/or when exiting to free system resources consumed by audio effect engines.
 */

public static final java.lang.String ACTION_CLOSE_AUDIO_EFFECT_CONTROL_SESSION = "android.media.action.CLOSE_AUDIO_EFFECT_CONTROL_SESSION";

/**
 *  Intent to launch an audio effect control panel UI.
 *  <p>The goal of this intent is to enable separate implementations of music/media player
 *  applications and audio effect control application or services.
 *  This will allow platform vendors to offer more advanced control options for standard effects
 *  or control for platform specific effects.
 *  <p>The intent carries a number of extras used by the player application to communicate
 *  necessary pieces of information to the control panel application.
 *  <p>The calling application must use the
 *  {@link android.app.Activity#startActivityForResult(Intent, int)} method to launch the
 *  control panel so that its package name is indicated and used by the control panel
 *  application to keep track of changes for this particular application.
 *  <p>The {@link #EXTRA_AUDIO_SESSION} extra will indicate an audio session to which the
 *  audio effects should be applied. If no audio session is specified, either one of the
 *  follownig will happen:
 *  <p>- If an audio session was previously opened by the calling application with
 *  {@link #ACTION_OPEN_AUDIO_EFFECT_CONTROL_SESSION} intent, the effect changes will
 *  be applied to that session.
 *  <p>- If no audio session is opened, the changes will be stored in the package specific
 *  storage area and applied whenever a new audio session is opened by this application.
 *  <p>The {@link #EXTRA_CONTENT_TYPE} extra will help the control panel application
 *  customize both the UI layout and the default audio effect settings if none are already
 *  stored for the calling application.
 */

public static final java.lang.String ACTION_DISPLAY_AUDIO_EFFECT_CONTROL_PANEL = "android.media.action.DISPLAY_AUDIO_EFFECT_CONTROL_PANEL";

/**
 *  Intent to signal to the effect control application or service that a new audio session
 *  is opened and requires audio effects to be applied.
 *  <p>This is different from {@link #ACTION_DISPLAY_AUDIO_EFFECT_CONTROL_PANEL} in that no
 *  UI should be displayed in this case. Music player applications can broadcast this intent
 *  before starting playback to make sure that any audio effect settings previously selected
 *  by the user are applied.
 *  <p>The effect control application receiving this intent will look for previously stored
 *  settings for the calling application, create all required audio effects and apply the
 *  effect settings to the specified audio session.
 *  <p>The calling package name is indicated by the {@link #EXTRA_PACKAGE_NAME} extra and the
 *  audio session ID by the {@link #EXTRA_AUDIO_SESSION} extra. Both extras are mandatory.
 *  <p>If no stored settings are found for the calling application, default settings for the
 *  content type indicated by {@link #EXTRA_CONTENT_TYPE} will be applied. The default settings
 *  for a given content type are platform specific.
 */

public static final java.lang.String ACTION_OPEN_AUDIO_EFFECT_CONTROL_SESSION = "android.media.action.OPEN_AUDIO_EFFECT_CONTROL_SESSION";

/**
 * Internal operation status. Not returned by any method.
 */

public static final int ALREADY_EXISTS = -2; // 0xfffffffe

/**
 * Value for {@link #EXTRA_CONTENT_TYPE} when the type of content played is game audio
 */

public static final int CONTENT_TYPE_GAME = 2; // 0x2

/**
 * Value for {@link #EXTRA_CONTENT_TYPE} when the type of content played is video or movie
 */

public static final int CONTENT_TYPE_MOVIE = 1; // 0x1

/**
 * Value for {@link #EXTRA_CONTENT_TYPE} when the type of content played is music
 */

public static final int CONTENT_TYPE_MUSIC = 0; // 0x0

/**
 * Value for {@link #EXTRA_CONTENT_TYPE} when the type of content played is voice audio
 */

public static final int CONTENT_TYPE_VOICE = 3; // 0x3

/**
 * Effect connection mode is auxiliary.
 * <p>Auxiliary effects must be created on session 0 (global output mix). In order for a
 * MediaPlayer or AudioTrack to be fed into this effect, they must be explicitely attached to
 * this effect and a send level must be specified.
 * <p>Use the effect ID returned by {@link #getId()} to designate this particular effect when
 * attaching it to the MediaPlayer or AudioTrack.
 */

public static final java.lang.String EFFECT_AUXILIARY = "Auxiliary";

/**
 * Effect connection mode is insert. Specifying an audio session ID when creating the effect
 * will insert this effect after all players in the same audio session.
 */

public static final java.lang.String EFFECT_INSERT = "Insert";

/**
 * UUID for Acoustic Echo Canceler (AEC)
 */

public static final java.util.UUID EFFECT_TYPE_AEC;
static { EFFECT_TYPE_AEC = null; }

/**
 * UUID for Automatic Gain Control (AGC)
 */

public static final java.util.UUID EFFECT_TYPE_AGC;
static { EFFECT_TYPE_AGC = null; }

/**
 * UUID for bass boost effect
 */

public static final java.util.UUID EFFECT_TYPE_BASS_BOOST;
static { EFFECT_TYPE_BASS_BOOST = null; }

/**
 * UUID for Dynamics Processing
 */

public static final java.util.UUID EFFECT_TYPE_DYNAMICS_PROCESSING;
static { EFFECT_TYPE_DYNAMICS_PROCESSING = null; }

/**
 * UUID for environmental reverberation effect
 */

public static final java.util.UUID EFFECT_TYPE_ENV_REVERB;
static { EFFECT_TYPE_ENV_REVERB = null; }

/**
 * UUID for equalizer effect
 */

public static final java.util.UUID EFFECT_TYPE_EQUALIZER;
static { EFFECT_TYPE_EQUALIZER = null; }

/**
 * UUID for Loudness Enhancer
 */

public static final java.util.UUID EFFECT_TYPE_LOUDNESS_ENHANCER;
static { EFFECT_TYPE_LOUDNESS_ENHANCER = null; }

/**
 * UUID for Noise Suppressor (NS)
 */

public static final java.util.UUID EFFECT_TYPE_NS;
static { EFFECT_TYPE_NS = null; }

/**
 * UUID for preset reverberation effect
 */

public static final java.util.UUID EFFECT_TYPE_PRESET_REVERB;
static { EFFECT_TYPE_PRESET_REVERB = null; }

/**
 * UUID for virtualizer effect
 */

public static final java.util.UUID EFFECT_TYPE_VIRTUALIZER;
static { EFFECT_TYPE_VIRTUALIZER = null; }

/**
 * Unspecified error.
 */

public static final int ERROR = -1; // 0xffffffff

/**
 * Operation failed due to bad parameter value.
 */

public static final int ERROR_BAD_VALUE = -4; // 0xfffffffc

/**
 * Operation failed due to dead remote object.
 */

public static final int ERROR_DEAD_OBJECT = -7; // 0xfffffff9

/**
 * Operation failed because it was requested in wrong state.
 */

public static final int ERROR_INVALID_OPERATION = -5; // 0xfffffffb

/**
 * Operation failed due to bad object initialization.
 */

public static final int ERROR_NO_INIT = -3; // 0xfffffffd

/**
 * Operation failed due to lack of memory.
 */

public static final int ERROR_NO_MEMORY = -6; // 0xfffffffa

/**
 * Contains the ID of the audio session the effects should be applied to.
 * <p>This extra is for use with {@link #ACTION_DISPLAY_AUDIO_EFFECT_CONTROL_PANEL},
 * {@link #ACTION_OPEN_AUDIO_EFFECT_CONTROL_SESSION} and
 * {@link #ACTION_CLOSE_AUDIO_EFFECT_CONTROL_SESSION} intents.
 * <p>The extra value is of type int and is the audio session ID.
 *  @see android.media.MediaPlayer#getAudioSessionId() for details on audio sessions.
 */

public static final java.lang.String EXTRA_AUDIO_SESSION = "android.media.extra.AUDIO_SESSION";

/**
 * Indicates which type of content is played by the application.
 * <p>This extra is for use with {@link #ACTION_DISPLAY_AUDIO_EFFECT_CONTROL_PANEL} and
 * {@link #ACTION_OPEN_AUDIO_EFFECT_CONTROL_SESSION} intents.
 * <p>This information is used by the effect control application to customize UI and select
 * appropriate default effect settings. The content type is one of the following:
 * <ul>
 *   <li>{@link #CONTENT_TYPE_MUSIC}</li>
 *   <li>{@link #CONTENT_TYPE_MOVIE}</li>
 *   <li>{@link #CONTENT_TYPE_GAME}</li>
 *   <li>{@link #CONTENT_TYPE_VOICE}</li>
 * </ul>
 * If omitted, the content type defaults to {@link #CONTENT_TYPE_MUSIC}.
 */

public static final java.lang.String EXTRA_CONTENT_TYPE = "android.media.extra.CONTENT_TYPE";

/**
 * Contains the package name of the calling application.
 * <p>This extra is for use with {@link #ACTION_OPEN_AUDIO_EFFECT_CONTROL_SESSION} and
 * {@link #ACTION_CLOSE_AUDIO_EFFECT_CONTROL_SESSION} intents.
 * <p>The extra value is a string containing the full package name.
 */

public static final java.lang.String EXTRA_PACKAGE_NAME = "android.media.extra.PACKAGE_NAME";

/**
 * Successful operation.
 */

public static final int SUCCESS = 0; // 0x0
/**
 * The effect descriptor contains information on a particular effect implemented in the
 * audio framework:<br>
 * <ul>
 *  <li>type: UUID identifying the effect type. May be one of:
 * {@link AudioEffect#EFFECT_TYPE_AEC}, {@link AudioEffect#EFFECT_TYPE_AGC},
 * {@link AudioEffect#EFFECT_TYPE_BASS_BOOST}, {@link AudioEffect#EFFECT_TYPE_ENV_REVERB},
 * {@link AudioEffect#EFFECT_TYPE_EQUALIZER}, {@link AudioEffect#EFFECT_TYPE_NS},
 * {@link AudioEffect#EFFECT_TYPE_PRESET_REVERB}, {@link AudioEffect#EFFECT_TYPE_VIRTUALIZER},
 * {@link AudioEffect#EFFECT_TYPE_DYNAMICS_PROCESSING}.
 *  </li>
 *  <li>uuid: UUID for this particular implementation</li>
 *  <li>connectMode: {@link #EFFECT_INSERT} or {@link #EFFECT_AUXILIARY}</li>
 *  <li>name: human readable effect name</li>
 *  <li>implementor: human readable effect implementor name</li>
 * </ul>
 * The method {@link #queryEffects()} returns an array of Descriptors to facilitate effects
 * enumeration.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Descriptor {

public Descriptor() { throw new RuntimeException("Stub!"); }

/**
 * @param type          UUID identifying the effect type. May be one of:
 * {@link AudioEffect#EFFECT_TYPE_AEC}, {@link AudioEffect#EFFECT_TYPE_AGC},
 * {@link AudioEffect#EFFECT_TYPE_BASS_BOOST}, {@link AudioEffect#EFFECT_TYPE_ENV_REVERB},
 * {@link AudioEffect#EFFECT_TYPE_EQUALIZER}, {@link AudioEffect#EFFECT_TYPE_NS},
 * {@link AudioEffect#EFFECT_TYPE_PRESET_REVERB},
 * {@link AudioEffect#EFFECT_TYPE_VIRTUALIZER},
 * {@link AudioEffect#EFFECT_TYPE_DYNAMICS_PROCESSING}.
 * @param uuid         UUID for this particular implementation
 * @param connectMode  {@link #EFFECT_INSERT} or {@link #EFFECT_AUXILIARY}
 * @param name         human readable effect name
 * @param implementor  human readable effect implementor name
 *
 */

public Descriptor(java.lang.String type, java.lang.String uuid, java.lang.String connectMode, java.lang.String name, java.lang.String implementor) { throw new RuntimeException("Stub!"); }

/**
 *  Indicates if the effect is of insert category {@link #EFFECT_INSERT} or auxiliary
 *  category {@link #EFFECT_AUXILIARY}.
 *  Insert effects (typically an {@link Equalizer}) are applied
 *  to the entire audio source and usually not shared by several sources. Auxiliary effects
 *  (typically a reverberator) are applied to part of the signal (wet) and the effect output
 *  is added to the original signal (dry).
 *  Audio pre processing are applied to audio captured on a particular
 * {@link android.media.AudioRecord}.
 */

public java.lang.String connectMode;

/**
 * Human readable effect implementor name
 */

public java.lang.String implementor;

/**
 * Human readable effect name
 */

public java.lang.String name;

/**
 *  Indicates the generic type of the effect (Equalizer, Bass boost ...).
 *  One of {@link AudioEffect#EFFECT_TYPE_AEC},
 *  {@link AudioEffect#EFFECT_TYPE_AGC}, {@link AudioEffect#EFFECT_TYPE_BASS_BOOST},
 *  {@link AudioEffect#EFFECT_TYPE_ENV_REVERB}, {@link AudioEffect#EFFECT_TYPE_EQUALIZER},
 *  {@link AudioEffect#EFFECT_TYPE_NS}, {@link AudioEffect#EFFECT_TYPE_PRESET_REVERB}
 *  {@link AudioEffect#EFFECT_TYPE_VIRTUALIZER}
 *   or {@link AudioEffect#EFFECT_TYPE_DYNAMICS_PROCESSING}.<br>
 *  For reverberation, bass boost, EQ and virtualizer, the UUID
 *  corresponds to the OpenSL ES Interface ID.
 */

public java.util.UUID type;

/**
 *  Indicates the particular implementation of the effect in that type. Several effects
 *  can have the same type but this uuid is unique to a given implementation.
 */

public java.util.UUID uuid;
}

/**
 * The OnControlStatusChangeListener interface defines a method called by the AudioEffect
 * when a the control of the effect engine is gained or lost by the application
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnControlStatusChangeListener {

/**
 * Called on the listener to notify it that the effect engine control
 * has been taken or returned.
 * @param effect the effect on which the interface is registered.
 * @param controlGranted true if the application has been granted control of the effect
 * engine, false otherwise.
 */

public void onControlStatusChange(android.media.audiofx.AudioEffect effect, boolean controlGranted);
}

/**
 * The OnEnableStatusChangeListener interface defines a method called by the AudioEffect
 * when a the enabled state of the effect engine was changed by the controlling application.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnEnableStatusChangeListener {

/**
 * Called on the listener to notify it that the effect engine has been
 * enabled or disabled.
 * @param effect the effect on which the interface is registered.
 * @param enabled new effect state.
 */

public void onEnableStatusChange(android.media.audiofx.AudioEffect effect, boolean enabled);
}

}

