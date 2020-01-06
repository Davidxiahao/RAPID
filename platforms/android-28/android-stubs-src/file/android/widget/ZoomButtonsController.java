/*
 * Copyright (C) 2008 The Android Open Source Project
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

import android.view.View;

/**
 * The {@link ZoomButtonsController} handles showing and hiding the zoom
 * controls and positioning it relative to an owner view. It also gives the
 * client access to the zoom controls container, allowing for additional
 * accessory buttons to be shown in the zoom controls window.
 * <p>
 * Typically, clients should call {@link #setVisible(boolean) setVisible(true)}
 * on a touch down or move (no need to call {@link #setVisible(boolean)
 * setVisible(false)} since it will time out on its own). Also, whenever the
 * owner cannot be zoomed further, the client should update
 * {@link #setZoomInEnabled(boolean)} and {@link #setZoomOutEnabled(boolean)}.
 * <p>
 * If you are using this with a custom View, please call
 * {@link #setVisible(boolean) setVisible(false)} from
 * {@link View#onDetachedFromWindow} and from {@link View#onVisibilityChanged}
 * when <code>visibility != View.VISIBLE</code>.
 *
 * @deprecated This functionality and UI is better handled with custom views and layouts
 * rather than a dedicated zoom-control widget
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated public class ZoomButtonsController implements android.view.View.OnTouchListener {

/**
 * Constructor for the {@link ZoomButtonsController}.
 *
 * @param ownerView The view that is being zoomed by the zoom controls. The
 *            zoom controls will be displayed aligned with this view.
 */

public ZoomButtonsController(android.view.View ownerView) { throw new RuntimeException("Stub!"); }

/**
 * Whether to enable the zoom in control.
 *
 * @param enabled Whether to enable the zoom in control.
 */

public void setZoomInEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Whether to enable the zoom out control.
 *
 * @param enabled Whether to enable the zoom out control.
 */

public void setZoomOutEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Sets the delay between zoom callbacks as the user holds a zoom button.
 *
 * @param speed The delay in milliseconds between zoom callbacks.
 */

public void setZoomSpeed(long speed) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link OnZoomListener} listener that receives callbacks to zoom.
 *
 * @param listener The listener that will be told to zoom.
 */

public void setOnZoomListener(android.widget.ZoomButtonsController.OnZoomListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the zoom controls should be focusable. If the controls are
 * focusable, then trackball and arrow key interactions are possible.
 * Otherwise, only touch interactions are possible.
 *
 * @param focusable Whether the zoom controls should be focusable.
 */

public void setFocusable(boolean focusable) { throw new RuntimeException("Stub!"); }

/**
 * Whether the zoom controls will be automatically dismissed after showing.
 *
 * @return Whether the zoom controls will be auto dismissed after showing.
 */

public boolean isAutoDismissed() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the zoom controls will be automatically dismissed after
 * showing.
 */

public void setAutoDismissed(boolean autoDismiss) { throw new RuntimeException("Stub!"); }

/**
 * Whether the zoom controls are visible to the user.
 *
 * @return Whether the zoom controls are visible to the user.
 */

public boolean isVisible() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the zoom controls should be visible to the user.
 *
 * @param visible Whether the zoom controls should be visible to the user.
 */

public void setVisible(boolean visible) { throw new RuntimeException("Stub!"); }

/**
 * Gets the container that is the parent of the zoom controls.
 * <p>
 * The client can add other views to this container to link them with the
 * zoom controls.
 *
 * @return The container of the zoom controls. It will be a layout that
 *         respects the gravity of a child's layout parameters.
 */

public android.view.ViewGroup getContainer() { throw new RuntimeException("Stub!"); }

/**
 * Gets the view for the zoom controls.
 *
 * @return The zoom controls view.
 */

public android.view.View getZoomControls() { throw new RuntimeException("Stub!"); }

/**
 * @hide The ZoomButtonsController implements the OnTouchListener, but this
 *       does not need to be shown in its public API.
 */

public boolean onTouch(android.view.View v, android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }
/**
 * Interface that will be called when the user performs an interaction that
 * triggers some action, for example zooming.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnZoomListener {

/**
 * Called when the zoom controls' visibility changes.
 *
 * @param visible Whether the zoom controls are visible.
 */

public void onVisibilityChanged(boolean visible);

/**
 * Called when the owner view needs to be zoomed.
 *
 * @param zoomIn The direction of the zoom: true to zoom in, false to zoom out.
 */

public void onZoom(boolean zoomIn);
}

}

