/*
 * Copyright (C) 2006 The Android Open Source Project
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


package android.widget;

import android.content.Context;
import android.view.View;

/**
 * A view containing controls for a MediaPlayer. Typically contains the
 * buttons like "Play/Pause", "Rewind", "Fast Forward" and a progress
 * slider. It takes care of synchronizing the controls with the state
 * of the MediaPlayer.
 * <p>
 * The way to use this class is to instantiate it programmatically.
 * The MediaController will create a default set of controls
 * and put them in a window floating above your application. Specifically,
 * the controls will float above the view specified with setAnchorView().
 * The window will disappear if left idle for three seconds and reappear
 * when the user touches the anchor view.
 * <p>
 * Functions like show() and hide() have no effect when MediaController
 * is created in an xml layout.
 *
 * MediaController will hide and
 * show the buttons according to these rules:
 * <ul>
 * <li> The "previous" and "next" buttons are hidden until setPrevNextListeners()
 *   has been called
 * <li> The "previous" and "next" buttons are visible but disabled if
 *   setPrevNextListeners() was called with null listeners
 * <li> The "rewind" and "fastforward" buttons are shown unless requested
 *   otherwise by using the MediaController(Context, boolean) constructor
 *   with the boolean set to false
 * </ul>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MediaController extends android.widget.FrameLayout {

public MediaController(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public MediaController(android.content.Context context, boolean useFastForward) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public MediaController(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public void onFinishInflate() { throw new RuntimeException("Stub!"); }

public void setMediaPlayer(android.widget.MediaController.MediaPlayerControl player) { throw new RuntimeException("Stub!"); }

/**
 * Set the view that acts as the anchor for the control view.
 * This can for example be a VideoView, or your Activity's main view.
 * When VideoView calls this method, it will use the VideoView's parent
 * as the anchor.
 * @param view The view to which to anchor the controller when it is visible.
 */

public void setAnchorView(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Show the controller on screen. It will go away
 * automatically after 3 seconds of inactivity.
 */

public void show() { throw new RuntimeException("Stub!"); }

/**
 * Show the controller on screen. It will go away
 * automatically after 'timeout' milliseconds of inactivity.
 * @param timeout The timeout in milliseconds. Use 0 to show
 * the controller until hide() is called.
 */

public void show(int timeout) { throw new RuntimeException("Stub!"); }

public boolean isShowing() { throw new RuntimeException("Stub!"); }

/**
 * Remove the controller from the screen.
 */

public void hide() { throw new RuntimeException("Stub!"); }

public boolean onTouchEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

public boolean onTrackballEvent(android.view.MotionEvent ev) { throw new RuntimeException("Stub!"); }

public boolean dispatchKeyEvent(android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

public void setEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }

public void setPrevNextListeners(android.view.View.OnClickListener next, android.view.View.OnClickListener prev) { throw new RuntimeException("Stub!"); }
@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface MediaPlayerControl {

public void start();

public void pause();

public int getDuration();

public int getCurrentPosition();

public void seekTo(int pos);

public boolean isPlaying();

public int getBufferPercentage();

public boolean canPause();

public boolean canSeekBackward();

public boolean canSeekForward();

/**
 * Get the audio session id for the player used by this VideoView. This can be used to
 * apply audio effects to the audio track of a video.
 * @return The audio session, or 0 if there was an error.
 */

public int getAudioSessionId();
}

}

