/*
 * Copyright (C) 2009 The Android Open Source Project
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


package android.service.wallpaper;

import android.content.Intent;
import android.app.Service;
import android.app.WallpaperManager;
import android.view.MotionEvent;
import android.os.IBinder;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.graphics.Bitmap;
import android.app.WallpaperColors;
import android.graphics.drawable.Drawable;

/**
 * A wallpaper service is responsible for showing a live wallpaper behind
 * applications that would like to sit on top of it.  This service object
 * itself does very little -- its only purpose is to generate instances of
 * {@link Engine} as needed.  Implementing a wallpaper thus
 * involves subclassing from this, subclassing an Engine implementation,
 * and implementing {@link #onCreateEngine()} to return a new instance of
 * your engine.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class WallpaperService extends android.app.Service {

public WallpaperService() { throw new RuntimeException("Stub!"); }

public void onCreate() { throw new RuntimeException("Stub!"); }

public void onDestroy() { throw new RuntimeException("Stub!"); }

/**
 * Implement to return the implementation of the internal accessibility
 * service interface.  Subclasses should not override.
 */

public final android.os.IBinder onBind(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Must be implemented to return a new instance of the wallpaper's engine.
 * Note that multiple instances may be active at the same time, such as
 * when the wallpaper is currently set as the active wallpaper and the user
 * is in the wallpaper picker viewing a preview of it as well.
 */

public abstract android.service.wallpaper.WallpaperService.Engine onCreateEngine();

protected void dump(java.io.FileDescriptor fd, java.io.PrintWriter out, java.lang.String[] args) { throw new RuntimeException("Stub!"); }

/**
 * The {@link Intent} that must be declared as handled by the service.
 * To be supported, the service must also require the
 * {@link android.Manifest.permission#BIND_WALLPAPER} permission so
 * that other applications can not abuse it.
 */

public static final java.lang.String SERVICE_INTERFACE = "android.service.wallpaper.WallpaperService";

/**
 * Name under which a WallpaperService component publishes information
 * about itself.  This meta-data must reference an XML resource containing
 * a <code>&lt;{@link android.R.styleable#Wallpaper wallpaper}&gt;</code>
 * tag.
 */

public static final java.lang.String SERVICE_META_DATA = "android.service.wallpaper";
/**
 * The actual implementation of a wallpaper.  A wallpaper service may
 * have multiple instances running (for example as a real wallpaper
 * and as a preview), each of which is represented by its own Engine
 * instance.  You must implement {@link WallpaperService#onCreateEngine()}
 * to return your concrete Engine implementation.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Engine {

/**
 * Default constructor
 */

public Engine() { throw new RuntimeException("Stub!"); }

/**
 * Provides access to the surface in which this wallpaper is drawn.
 */

public android.view.SurfaceHolder getSurfaceHolder() { throw new RuntimeException("Stub!"); }

/**
 * Convenience for {@link WallpaperManager#getDesiredMinimumWidth()
 * WallpaperManager.getDesiredMinimumWidth()}, returning the width
 * that the system would like this wallpaper to run in.
 */

public int getDesiredMinimumWidth() { throw new RuntimeException("Stub!"); }

/**
 * Convenience for {@link WallpaperManager#getDesiredMinimumHeight()
 * WallpaperManager.getDesiredMinimumHeight()}, returning the height
 * that the system would like this wallpaper to run in.
 */

public int getDesiredMinimumHeight() { throw new RuntimeException("Stub!"); }

/**
 * Return whether the wallpaper is currently visible to the user,
 * this is the last value supplied to
 * {@link #onVisibilityChanged(boolean)}.
 */

public boolean isVisible() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this engine is running in preview mode -- that is,
 * it is being shown to the user before they select it as the actual
 * wallpaper.
 */

public boolean isPreview() { throw new RuntimeException("Stub!"); }

/**
 * Control whether this wallpaper will receive raw touch events
 * from the window manager as the user interacts with the window
 * that is currently displaying the wallpaper.  By default they
 * are turned off.  If enabled, the events will be received in
 * {@link #onTouchEvent(MotionEvent)}.
 */

public void setTouchEventsEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Control whether this wallpaper will receive notifications when the wallpaper
 * has been scrolled. By default, wallpapers will receive notifications, although
 * the default static image wallpapers do not. It is a performance optimization to
 * set this to false.
 *
 * @param enabled whether the wallpaper wants to receive offset notifications
 */

public void setOffsetNotificationsEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Called once to initialize the engine.  After returning, the
 * engine's surface will be created by the framework.
 */

public void onCreate(android.view.SurfaceHolder surfaceHolder) { throw new RuntimeException("Stub!"); }

/**
 * Called right before the engine is going away.  After this the
 * surface will be destroyed and this Engine object is no longer
 * valid.
 */

public void onDestroy() { throw new RuntimeException("Stub!"); }

/**
 * Called to inform you of the wallpaper becoming visible or
 * hidden.  <em>It is very important that a wallpaper only use
 * CPU while it is visible.</em>.
 */

public void onVisibilityChanged(boolean visible) { throw new RuntimeException("Stub!"); }

/**
 * Called with the current insets that are in effect for the wallpaper.
 * This gives you the part of the overall wallpaper surface that will
 * generally be visible to the user (ignoring position offsets applied to it).
 *
 * @param insets Insets to apply.
 */

public void onApplyWindowInsets(android.view.WindowInsets insets) { throw new RuntimeException("Stub!"); }

/**
 * Called as the user performs touch-screen interaction with the
 * window that is currently showing this wallpaper.  Note that the
 * events you receive here are driven by the actual application the
 * user is interacting with, so if it is slow you will get fewer
 * move events.
 */

public void onTouchEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Called to inform you of the wallpaper's offsets changing
 * within its contain, corresponding to the container's
 * call to {@link WallpaperManager#setWallpaperOffsets(IBinder, float, float)
 * WallpaperManager.setWallpaperOffsets()}.
 */

public void onOffsetsChanged(float xOffset, float yOffset, float xOffsetStep, float yOffsetStep, int xPixelOffset, int yPixelOffset) { throw new RuntimeException("Stub!"); }

/**
 * Process a command that was sent to the wallpaper with
 * {@link WallpaperManager#sendWallpaperCommand}.
 * The default implementation does nothing, and always returns null
 * as the result.
 *
 * @param action The name of the command to perform.  This tells you
 * what to do and how to interpret the rest of the arguments.
 * @param x Generic integer parameter.
 * @param y Generic integer parameter.
 * @param z Generic integer parameter.
 * @param extras Any additional parameters.
 * @param resultRequested If true, the caller is requesting that
 * a result, appropriate for the command, be returned back.
 * @return If returning a result, create a Bundle and place the
 * result data in to it.  Otherwise return null.
 */

public android.os.Bundle onCommand(java.lang.String action, int x, int y, int z, android.os.Bundle extras, boolean resultRequested) { throw new RuntimeException("Stub!"); }

/**
 * Called when an application has changed the desired virtual size of
 * the wallpaper.
 */

public void onDesiredSizeChanged(int desiredWidth, int desiredHeight) { throw new RuntimeException("Stub!"); }

/**
 * Convenience for {@link SurfaceHolder.Callback#surfaceChanged
 * SurfaceHolder.Callback.surfaceChanged()}.
 */

public void onSurfaceChanged(android.view.SurfaceHolder holder, int format, int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Convenience for {@link SurfaceHolder.Callback2#surfaceRedrawNeeded
 * SurfaceHolder.Callback.surfaceRedrawNeeded()}.
 */

public void onSurfaceRedrawNeeded(android.view.SurfaceHolder holder) { throw new RuntimeException("Stub!"); }

/**
 * Convenience for {@link SurfaceHolder.Callback#surfaceCreated
 * SurfaceHolder.Callback.surfaceCreated()}.
 */

public void onSurfaceCreated(android.view.SurfaceHolder holder) { throw new RuntimeException("Stub!"); }

/**
 * Convenience for {@link SurfaceHolder.Callback#surfaceDestroyed
 * SurfaceHolder.Callback.surfaceDestroyed()}.
 */

public void onSurfaceDestroyed(android.view.SurfaceHolder holder) { throw new RuntimeException("Stub!"); }

/**
 * Notifies the engine that wallpaper colors changed significantly.
 * This will trigger a {@link #onComputeColors()} call.
 */

public void notifyColorsChanged() { throw new RuntimeException("Stub!"); }

/**
 * Called by the system when it needs to know what colors the wallpaper is using.
 * You might return null if no color information is available at the moment.
 * In that case you might want to call {@link #notifyColorsChanged()} when
 * color information becomes available.
 * <p>
 * The simplest way of creating a {@link android.app.WallpaperColors} object is by using
 * {@link android.app.WallpaperColors#fromBitmap(Bitmap)} or
 * {@link android.app.WallpaperColors#fromDrawable(Drawable)}, but you can also specify
 * your main colors by constructing a {@link android.app.WallpaperColors} object manually.
 *
 * @return Wallpaper colors.
 */

@androidx.annotation.RecentlyNullable public android.app.WallpaperColors onComputeColors() { throw new RuntimeException("Stub!"); }

protected void dump(java.lang.String prefix, java.io.FileDescriptor fd, java.io.PrintWriter out, java.lang.String[] args) { throw new RuntimeException("Stub!"); }
}

}

