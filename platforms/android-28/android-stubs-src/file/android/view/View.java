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


package android.view;

import java.util.List;
import android.graphics.Rect;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import java.lang.reflect.Method;
import android.util.Property;
import android.content.Context;
import android.view.animation.Animation;
import android.util.AttributeSet;
import android.os.Bundle;
import android.content.Intent;
import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.Map;
import android.text.InputType;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import android.view.autofill.AutofillManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.util.SparseArray;
import android.graphics.Paint;
import android.graphics.Bitmap;
import android.view.accessibility.AccessibilityManager;
import android.graphics.Region;
import android.content.res.Configuration;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.ContextMenu.ContextMenuInfo;
import android.graphics.Matrix;
import android.content.res.Resources;
import android.animation.StateListAnimator;
import android.graphics.Outline;
import android.view.animation.AnimationUtils;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.FrameLayout;
import android.content.ClipData;
import android.graphics.Point;
import android.util.Log;
import java.util.Calendar;
import java.util.ArrayList;
import android.util.LayoutDirection;
import java.util.Locale;
import java.util.function.Predicate;
import android.net.Uri;

/**
 * <p>
 * This class represents the basic building block for user interface components. A View
 * occupies a rectangular area on the screen and is responsible for drawing and
 * event handling. View is the base class for <em>widgets</em>, which are
 * used to create interactive UI components (buttons, text fields, etc.). The
 * {@link android.view.ViewGroup} subclass is the base class for <em>layouts</em>, which
 * are invisible containers that hold other Views (or other ViewGroups) and define
 * their layout properties.
 * </p>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For information about using this class to develop your application's user interface,
 * read the <a href="{@docRoot}guide/topics/ui/index.html">User Interface</a> developer guide.
 * </div>
 *
 * <a name="Using"></a>
 * <h3>Using Views</h3>
 * <p>
 * All of the views in a window are arranged in a single tree. You can add views
 * either from code or by specifying a tree of views in one or more XML layout
 * files. There are many specialized subclasses of views that act as controls or
 * are capable of displaying text, images, or other content.
 * </p>
 * <p>
 * Once you have created a tree of views, there are typically a few types of
 * common operations you may wish to perform:
 * <ul>
 * <li><strong>Set properties:</strong> for example setting the text of a
 * {@link android.widget.TextView}. The available properties and the methods
 * that set them will vary among the different subclasses of views. Note that
 * properties that are known at build time can be set in the XML layout
 * files.</li>
 * <li><strong>Set focus:</strong> The framework will handle moving focus in
 * response to user input. To force focus to a specific view, call
 * {@link #requestFocus}.</li>
 * <li><strong>Set up listeners:</strong> Views allow clients to set listeners
 * that will be notified when something interesting happens to the view. For
 * example, all views will let you set a listener to be notified when the view
 * gains or loses focus. You can register such a listener using
 * {@link #setOnFocusChangeListener(android.view.View.OnFocusChangeListener)}.
 * Other view subclasses offer more specialized listeners. For example, a Button
 * exposes a listener to notify clients when the button is clicked.</li>
 * <li><strong>Set visibility:</strong> You can hide or show views using
 * {@link #setVisibility(int)}.</li>
 * </ul>
 * </p>
 * <p><em>
 * Note: The Android framework is responsible for measuring, laying out and
 * drawing views. You should not call methods that perform these actions on
 * views yourself unless you are actually implementing a
 * {@link android.view.ViewGroup}.
 * </em></p>
 *
 * <a name="Lifecycle"></a>
 * <h3>Implementing a Custom View</h3>
 *
 * <p>
 * To implement a custom view, you will usually begin by providing overrides for
 * some of the standard methods that the framework calls on all views. You do
 * not need to override all of these methods. In fact, you can start by just
 * overriding {@link #onDraw(android.graphics.Canvas)}.
 * <table border="2" width="85%" align="center" cellpadding="5">
 *     <thead>
 *         <tr><th>Category</th> <th>Methods</th> <th>Description</th></tr>
 *     </thead>
 *
 *     <tbody>
 *     <tr>
 *         <td rowspan="2">Creation</td>
 *         <td>Constructors</td>
 *         <td>There is a form of the constructor that are called when the view
 *         is created from code and a form that is called when the view is
 *         inflated from a layout file. The second form should parse and apply
 *         any attributes defined in the layout file.
 *         </td>
 *     </tr>
 *     <tr>
 *         <td><code>{@link #onFinishInflate()}</code></td>
 *         <td>Called after a view and all of its children has been inflated
 *         from XML.</td>
 *     </tr>
 *
 *     <tr>
 *         <td rowspan="3">Layout</td>
 *         <td><code>{@link #onMeasure(int, int)}</code></td>
 *         <td>Called to determine the size requirements for this view and all
 *         of its children.
 *         </td>
 *     </tr>
 *     <tr>
 *         <td><code>{@link #onLayout(boolean, int, int, int, int)}</code></td>
 *         <td>Called when this view should assign a size and position to all
 *         of its children.
 *         </td>
 *     </tr>
 *     <tr>
 *         <td><code>{@link #onSizeChanged(int, int, int, int)}</code></td>
 *         <td>Called when the size of this view has changed.
 *         </td>
 *     </tr>
 *
 *     <tr>
 *         <td>Drawing</td>
 *         <td><code>{@link #onDraw(android.graphics.Canvas)}</code></td>
 *         <td>Called when the view should render its content.
 *         </td>
 *     </tr>
 *
 *     <tr>
 *         <td rowspan="4">Event processing</td>
 *         <td><code>{@link #onKeyDown(int, KeyEvent)}</code></td>
 *         <td>Called when a new hardware key event occurs.
 *         </td>
 *     </tr>
 *     <tr>
 *         <td><code>{@link #onKeyUp(int, KeyEvent)}</code></td>
 *         <td>Called when a hardware key up event occurs.
 *         </td>
 *     </tr>
 *     <tr>
 *         <td><code>{@link #onTrackballEvent(MotionEvent)}</code></td>
 *         <td>Called when a trackball motion event occurs.
 *         </td>
 *     </tr>
 *     <tr>
 *         <td><code>{@link #onTouchEvent(MotionEvent)}</code></td>
 *         <td>Called when a touch screen motion event occurs.
 *         </td>
 *     </tr>
 *
 *     <tr>
 *         <td rowspan="2">Focus</td>
 *         <td><code>{@link #onFocusChanged(boolean, int, android.graphics.Rect)}</code></td>
 *         <td>Called when the view gains or loses focus.
 *         </td>
 *     </tr>
 *
 *     <tr>
 *         <td><code>{@link #onWindowFocusChanged(boolean)}</code></td>
 *         <td>Called when the window containing the view gains or loses focus.
 *         </td>
 *     </tr>
 *
 *     <tr>
 *         <td rowspan="3">Attaching</td>
 *         <td><code>{@link #onAttachedToWindow()}</code></td>
 *         <td>Called when the view is attached to a window.
 *         </td>
 *     </tr>
 *
 *     <tr>
 *         <td><code>{@link #onDetachedFromWindow}</code></td>
 *         <td>Called when the view is detached from its window.
 *         </td>
 *     </tr>
 *
 *     <tr>
 *         <td><code>{@link #onWindowVisibilityChanged(int)}</code></td>
 *         <td>Called when the visibility of the window containing the view
 *         has changed.
 *         </td>
 *     </tr>
 *     </tbody>
 *
 * </table>
 * </p>
 *
 * <a name="IDs"></a>
 * <h3>IDs</h3>
 * Views may have an integer id associated with them. These ids are typically
 * assigned in the layout XML files, and are used to find specific views within
 * the view tree. A common pattern is to:
 * <ul>
 * <li>Define a Button in the layout file and assign it a unique ID.
 * <pre>
 * &lt;Button
 *     android:id="@+id/my_button"
 *     android:layout_width="wrap_content"
 *     android:layout_height="wrap_content"
 *     android:text="@string/my_button_text"/&gt;
 * </pre></li>
 * <li>From the onCreate method of an Activity, find the Button
 * <pre class="prettyprint">
 *      Button myButton = findViewById(R.id.my_button);
 * </pre></li>
 * </ul>
 * <p>
 * View IDs need not be unique throughout the tree, but it is good practice to
 * ensure that they are at least unique within the part of the tree you are
 * searching.
 * </p>
 *
 * <a name="Position"></a>
 * <h3>Position</h3>
 * <p>
 * The geometry of a view is that of a rectangle. A view has a location,
 * expressed as a pair of <em>left</em> and <em>top</em> coordinates, and
 * two dimensions, expressed as a width and a height. The unit for location
 * and dimensions is the pixel.
 * </p>
 *
 * <p>
 * It is possible to retrieve the location of a view by invoking the methods
 * {@link #getLeft()} and {@link #getTop()}. The former returns the left, or X,
 * coordinate of the rectangle representing the view. The latter returns the
 * top, or Y, coordinate of the rectangle representing the view. These methods
 * both return the location of the view relative to its parent. For instance,
 * when getLeft() returns 20, that means the view is located 20 pixels to the
 * right of the left edge of its direct parent.
 * </p>
 *
 * <p>
 * In addition, several convenience methods are offered to avoid unnecessary
 * computations, namely {@link #getRight()} and {@link #getBottom()}.
 * These methods return the coordinates of the right and bottom edges of the
 * rectangle representing the view. For instance, calling {@link #getRight()}
 * is similar to the following computation: <code>getLeft() + getWidth()</code>
 * (see <a href="#SizePaddingMargins">Size</a> for more information about the width.)
 * </p>
 *
 * <a name="SizePaddingMargins"></a>
 * <h3>Size, padding and margins</h3>
 * <p>
 * The size of a view is expressed with a width and a height. A view actually
 * possess two pairs of width and height values.
 * </p>
 *
 * <p>
 * The first pair is known as <em>measured width</em> and
 * <em>measured height</em>. These dimensions define how big a view wants to be
 * within its parent (see <a href="#Layout">Layout</a> for more details.) The
 * measured dimensions can be obtained by calling {@link #getMeasuredWidth()}
 * and {@link #getMeasuredHeight()}.
 * </p>
 *
 * <p>
 * The second pair is simply known as <em>width</em> and <em>height</em>, or
 * sometimes <em>drawing width</em> and <em>drawing height</em>. These
 * dimensions define the actual size of the view on screen, at drawing time and
 * after layout. These values may, but do not have to, be different from the
 * measured width and height. The width and height can be obtained by calling
 * {@link #getWidth()} and {@link #getHeight()}.
 * </p>
 *
 * <p>
 * To measure its dimensions, a view takes into account its padding. The padding
 * is expressed in pixels for the left, top, right and bottom parts of the view.
 * Padding can be used to offset the content of the view by a specific amount of
 * pixels. For instance, a left padding of 2 will push the view's content by
 * 2 pixels to the right of the left edge. Padding can be set using the
 * {@link #setPadding(int, int, int, int)} or {@link #setPaddingRelative(int, int, int, int)}
 * method and queried by calling {@link #getPaddingLeft()}, {@link #getPaddingTop()},
 * {@link #getPaddingRight()}, {@link #getPaddingBottom()}, {@link #getPaddingStart()},
 * {@link #getPaddingEnd()}.
 * </p>
 *
 * <p>
 * Even though a view can define a padding, it does not provide any support for
 * margins. However, view groups provide such a support. Refer to
 * {@link android.view.ViewGroup} and
 * {@link android.view.ViewGroup.MarginLayoutParams} for further information.
 * </p>
 *
 * <a name="Layout"></a>
 * <h3>Layout</h3>
 * <p>
 * Layout is a two pass process: a measure pass and a layout pass. The measuring
 * pass is implemented in {@link #measure(int, int)} and is a top-down traversal
 * of the view tree. Each view pushes dimension specifications down the tree
 * during the recursion. At the end of the measure pass, every view has stored
 * its measurements. The second pass happens in
 * {@link #layout(int,int,int,int)} and is also top-down. During
 * this pass each parent is responsible for positioning all of its children
 * using the sizes computed in the measure pass.
 * </p>
 *
 * <p>
 * When a view's measure() method returns, its {@link #getMeasuredWidth()} and
 * {@link #getMeasuredHeight()} values must be set, along with those for all of
 * that view's descendants. A view's measured width and measured height values
 * must respect the constraints imposed by the view's parents. This guarantees
 * that at the end of the measure pass, all parents accept all of their
 * children's measurements. A parent view may call measure() more than once on
 * its children. For example, the parent may measure each child once with
 * unspecified dimensions to find out how big they want to be, then call
 * measure() on them again with actual numbers if the sum of all the children's
 * unconstrained sizes is too big or too small.
 * </p>
 *
 * <p>
 * The measure pass uses two classes to communicate dimensions. The
 * {@link MeasureSpec} class is used by views to tell their parents how they
 * want to be measured and positioned. The base LayoutParams class just
 * describes how big the view wants to be for both width and height. For each
 * dimension, it can specify one of:
 * <ul>
 * <li> an exact number
 * <li>MATCH_PARENT, which means the view wants to be as big as its parent
 * (minus padding)
 * <li> WRAP_CONTENT, which means that the view wants to be just big enough to
 * enclose its content (plus padding).
 * </ul>
 * There are subclasses of LayoutParams for different subclasses of ViewGroup.
 * For example, AbsoluteLayout has its own subclass of LayoutParams which adds
 * an X and Y value.
 * </p>
 *
 * <p>
 * MeasureSpecs are used to push requirements down the tree from parent to
 * child. A MeasureSpec can be in one of three modes:
 * <ul>
 * <li>UNSPECIFIED: This is used by a parent to determine the desired dimension
 * of a child view. For example, a LinearLayout may call measure() on its child
 * with the height set to UNSPECIFIED and a width of EXACTLY 240 to find out how
 * tall the child view wants to be given a width of 240 pixels.
 * <li>EXACTLY: This is used by the parent to impose an exact size on the
 * child. The child must use this size, and guarantee that all of its
 * descendants will fit within this size.
 * <li>AT_MOST: This is used by the parent to impose a maximum size on the
 * child. The child must guarantee that it and all of its descendants will fit
 * within this size.
 * </ul>
 * </p>
 *
 * <p>
 * To initiate a layout, call {@link #requestLayout}. This method is typically
 * called by a view on itself when it believes that is can no longer fit within
 * its current bounds.
 * </p>
 *
 * <a name="Drawing"></a>
 * <h3>Drawing</h3>
 * <p>
 * Drawing is handled by walking the tree and recording the drawing commands of
 * any View that needs to update. After this, the drawing commands of the
 * entire tree are issued to screen, clipped to the newly damaged area.
 * </p>
 *
 * <p>
 * The tree is largely recorded and drawn in order, with parents drawn before
 * (i.e., behind) their children, with siblings drawn in the order they appear
 * in the tree. If you set a background drawable for a View, then the View will
 * draw it before calling back to its <code>onDraw()</code> method. The child
 * drawing order can be overridden with
 * {@link ViewGroup#setChildrenDrawingOrderEnabled(boolean) custom child drawing order}
 * in a ViewGroup, and with {@link #setZ(float)} custom Z values} set on Views.
 * </p>
 *
 * <p>
 * To force a view to draw, call {@link #invalidate()}.
 * </p>
 *
 * <a name="EventHandlingThreading"></a>
 * <h3>Event Handling and Threading</h3>
 * <p>
 * The basic cycle of a view is as follows:
 * <ol>
 * <li>An event comes in and is dispatched to the appropriate view. The view
 * handles the event and notifies any listeners.</li>
 * <li>If in the course of processing the event, the view's bounds may need
 * to be changed, the view will call {@link #requestLayout()}.</li>
 * <li>Similarly, if in the course of processing the event the view's appearance
 * may need to be changed, the view will call {@link #invalidate()}.</li>
 * <li>If either {@link #requestLayout()} or {@link #invalidate()} were called,
 * the framework will take care of measuring, laying out, and drawing the tree
 * as appropriate.</li>
 * </ol>
 * </p>
 *
 * <p><em>Note: The entire view tree is single threaded. You must always be on
 * the UI thread when calling any method on any view.</em>
 * If you are doing work on other threads and want to update the state of a view
 * from that thread, you should use a {@link Handler}.
 * </p>
 *
 * <a name="FocusHandling"></a>
 * <h3>Focus Handling</h3>
 * <p>
 * The framework will handle routine focus movement in response to user input.
 * This includes changing the focus as views are removed or hidden, or as new
 * views become available. Views indicate their willingness to take focus
 * through the {@link #isFocusable} method. To change whether a view can take
 * focus, call {@link #setFocusable(boolean)}.  When in touch mode (see notes below)
 * views indicate whether they still would like focus via {@link #isFocusableInTouchMode}
 * and can change this via {@link #setFocusableInTouchMode(boolean)}.
 * </p>
 * <p>
 * Focus movement is based on an algorithm which finds the nearest neighbor in a
 * given direction. In rare cases, the default algorithm may not match the
 * intended behavior of the developer. In these situations, you can provide
 * explicit overrides by using these XML attributes in the layout file:
 * <pre>
 * nextFocusDown
 * nextFocusLeft
 * nextFocusRight
 * nextFocusUp
 * </pre>
 * </p>
 *
 *
 * <p>
 * To get a particular view to take focus, call {@link #requestFocus()}.
 * </p>
 *
 * <a name="TouchMode"></a>
 * <h3>Touch Mode</h3>
 * <p>
 * When a user is navigating a user interface via directional keys such as a D-pad, it is
 * necessary to give focus to actionable items such as buttons so the user can see
 * what will take input.  If the device has touch capabilities, however, and the user
 * begins interacting with the interface by touching it, it is no longer necessary to
 * always highlight, or give focus to, a particular view.  This motivates a mode
 * for interaction named 'touch mode'.
 * </p>
 * <p>
 * For a touch capable device, once the user touches the screen, the device
 * will enter touch mode.  From this point onward, only views for which
 * {@link #isFocusableInTouchMode} is true will be focusable, such as text editing widgets.
 * Other views that are touchable, like buttons, will not take focus when touched; they will
 * only fire the on click listeners.
 * </p>
 * <p>
 * Any time a user hits a directional key, such as a D-pad direction, the view device will
 * exit touch mode, and find a view to take focus, so that the user may resume interacting
 * with the user interface without touching the screen again.
 * </p>
 * <p>
 * The touch mode state is maintained across {@link android.app.Activity}s.  Call
 * {@link #isInTouchMode} to see whether the device is currently in touch mode.
 * </p>
 *
 * <a name="Scrolling"></a>
 * <h3>Scrolling</h3>
 * <p>
 * The framework provides basic support for views that wish to internally
 * scroll their content. This includes keeping track of the X and Y scroll
 * offset as well as mechanisms for drawing scrollbars. See
 * {@link #scrollBy(int, int)}, {@link #scrollTo(int, int)}, and
 * {@link #awakenScrollBars()} for more details.
 * </p>
 *
 * <a name="Tags"></a>
 * <h3>Tags</h3>
 * <p>
 * Unlike IDs, tags are not used to identify views. Tags are essentially an
 * extra piece of information that can be associated with a view. They are most
 * often used as a convenience to store data related to views in the views
 * themselves rather than by putting them in a separate structure.
 * </p>
 * <p>
 * Tags may be specified with character sequence values in layout XML as either
 * a single tag using the {@link android.R.styleable#View_tag android:tag}
 * attribute or multiple tags using the {@code <tag>} child element:
 * <pre>
 *     &lt;View ...
 *           android:tag="@string/mytag_value" /&gt;
 *     &lt;View ...&gt;
 *         &lt;tag android:id="@+id/mytag"
 *              android:value="@string/mytag_value" /&gt;
 *     &lt;/View>
 * </pre>
 * </p>
 * <p>
 * Tags may also be specified with arbitrary objects from code using
 * {@link #setTag(Object)} or {@link #setTag(int, Object)}.
 * </p>
 *
 * <a name="Themes"></a>
 * <h3>Themes</h3>
 * <p>
 * By default, Views are created using the theme of the Context object supplied
 * to their constructor; however, a different theme may be specified by using
 * the {@link android.R.styleable#View_theme android:theme} attribute in layout
 * XML or by passing a {@link ContextThemeWrapper} to the constructor from
 * code.
 * </p>
 * <p>
 * When the {@link android.R.styleable#View_theme android:theme} attribute is
 * used in XML, the specified theme is applied on top of the inflation
 * context's theme (see {@link LayoutInflater}) and used for the view itself as
 * well as any child elements.
 * </p>
 * <p>
 * In the following example, both views will be created using the Material dark
 * color scheme; however, because an overlay theme is used which only defines a
 * subset of attributes, the value of
 * {@link android.R.styleable#Theme_colorAccent android:colorAccent} defined on
 * the inflation context's theme (e.g. the Activity theme) will be preserved.
 * <pre>
 *     &lt;LinearLayout
 *             ...
 *             android:theme="@android:theme/ThemeOverlay.Material.Dark"&gt;
 *         &lt;View ...&gt;
 *     &lt;/LinearLayout&gt;
 * </pre>
 * </p>
 *
 * <a name="Properties"></a>
 * <h3>Properties</h3>
 * <p>
 * The View class exposes an {@link #ALPHA} property, as well as several transform-related
 * properties, such as {@link #TRANSLATION_X} and {@link #TRANSLATION_Y}. These properties are
 * available both in the {@link Property} form as well as in similarly-named setter/getter
 * methods (such as {@link #setAlpha(float)} for {@link #ALPHA}). These properties can
 * be used to set persistent state associated with these rendering-related properties on the view.
 * The properties and methods can also be used in conjunction with
 * {@link android.animation.Animator Animator}-based animations, described more in the
 * <a href="#Animation">Animation</a> section.
 * </p>
 *
 * <a name="Animation"></a>
 * <h3>Animation</h3>
 * <p>
 * Starting with Android 3.0, the preferred way of animating views is to use the
 * {@link android.animation} package APIs. These {@link android.animation.Animator Animator}-based
 * classes change actual properties of the View object, such as {@link #setAlpha(float) alpha} and
 * {@link #setTranslationX(float) translationX}. This behavior is contrasted to that of the pre-3.0
 * {@link android.view.animation.Animation Animation}-based classes, which instead animate only
 * how the view is drawn on the display. In particular, the {@link ViewPropertyAnimator} class
 * makes animating these View properties particularly easy and efficient.
 * </p>
 * <p>
 * Alternatively, you can use the pre-3.0 animation classes to animate how Views are rendered.
 * You can attach an {@link Animation} object to a view using
 * {@link #setAnimation(Animation)} or
 * {@link #startAnimation(Animation)}. The animation can alter the scale,
 * rotation, translation and alpha of a view over time. If the animation is
 * attached to a view that has children, the animation will affect the entire
 * subtree rooted by that node. When an animation is started, the framework will
 * take care of redrawing the appropriate views until the animation completes.
 * </p>
 *
 * <a name="Security"></a>
 * <h3>Security</h3>
 * <p>
 * Sometimes it is essential that an application be able to verify that an action
 * is being performed with the full knowledge and consent of the user, such as
 * granting a permission request, making a purchase or clicking on an advertisement.
 * Unfortunately, a malicious application could try to spoof the user into
 * performing these actions, unaware, by concealing the intended purpose of the view.
 * As a remedy, the framework offers a touch filtering mechanism that can be used to
 * improve the security of views that provide access to sensitive functionality.
 * </p><p>
 * To enable touch filtering, call {@link #setFilterTouchesWhenObscured(boolean)} or set the
 * android:filterTouchesWhenObscured layout attribute to true.  When enabled, the framework
 * will discard touches that are received whenever the view's window is obscured by
 * another visible window.  As a result, the view will not receive touches whenever a
 * toast, dialog or other window appears above the view's window.
 * </p><p>
 * For more fine-grained control over security, consider overriding the
 * {@link #onFilterTouchEventForSecurity(MotionEvent)} method to implement your own
 * security policy. See also {@link MotionEvent#FLAG_WINDOW_IS_OBSCURED}.
 * </p>
 *
 * @attr ref android.R.styleable#View_accessibilityHeading
 * @attr ref android.R.styleable#View_alpha
 * @attr ref android.R.styleable#View_background
 * @attr ref android.R.styleable#View_clickable
 * @attr ref android.R.styleable#View_contentDescription
 * @attr ref android.R.styleable#View_drawingCacheQuality
 * @attr ref android.R.styleable#View_duplicateParentState
 * @attr ref android.R.styleable#View_id
 * @attr ref android.R.styleable#View_requiresFadingEdge
 * @attr ref android.R.styleable#View_fadeScrollbars
 * @attr ref android.R.styleable#View_fadingEdgeLength
 * @attr ref android.R.styleable#View_filterTouchesWhenObscured
 * @attr ref android.R.styleable#View_fitsSystemWindows
 * @attr ref android.R.styleable#View_isScrollContainer
 * @attr ref android.R.styleable#View_focusable
 * @attr ref android.R.styleable#View_focusableInTouchMode
 * @attr ref android.R.styleable#View_focusedByDefault
 * @attr ref android.R.styleable#View_hapticFeedbackEnabled
 * @attr ref android.R.styleable#View_keepScreenOn
 * @attr ref android.R.styleable#View_keyboardNavigationCluster
 * @attr ref android.R.styleable#View_layerType
 * @attr ref android.R.styleable#View_layoutDirection
 * @attr ref android.R.styleable#View_longClickable
 * @attr ref android.R.styleable#View_minHeight
 * @attr ref android.R.styleable#View_minWidth
 * @attr ref android.R.styleable#View_nextClusterForward
 * @attr ref android.R.styleable#View_nextFocusDown
 * @attr ref android.R.styleable#View_nextFocusLeft
 * @attr ref android.R.styleable#View_nextFocusRight
 * @attr ref android.R.styleable#View_nextFocusUp
 * @attr ref android.R.styleable#View_onClick
 * @attr ref android.R.styleable#View_outlineSpotShadowColor
 * @attr ref android.R.styleable#View_outlineAmbientShadowColor
 * @attr ref android.R.styleable#View_padding
 * @attr ref android.R.styleable#View_paddingHorizontal
 * @attr ref android.R.styleable#View_paddingVertical
 * @attr ref android.R.styleable#View_paddingBottom
 * @attr ref android.R.styleable#View_paddingLeft
 * @attr ref android.R.styleable#View_paddingRight
 * @attr ref android.R.styleable#View_paddingTop
 * @attr ref android.R.styleable#View_paddingStart
 * @attr ref android.R.styleable#View_paddingEnd
 * @attr ref android.R.styleable#View_saveEnabled
 * @attr ref android.R.styleable#View_rotation
 * @attr ref android.R.styleable#View_rotationX
 * @attr ref android.R.styleable#View_rotationY
 * @attr ref android.R.styleable#View_scaleX
 * @attr ref android.R.styleable#View_scaleY
 * @attr ref android.R.styleable#View_scrollX
 * @attr ref android.R.styleable#View_scrollY
 * @attr ref android.R.styleable#View_scrollbarSize
 * @attr ref android.R.styleable#View_scrollbarStyle
 * @attr ref android.R.styleable#View_scrollbars
 * @attr ref android.R.styleable#View_scrollbarDefaultDelayBeforeFade
 * @attr ref android.R.styleable#View_scrollbarFadeDuration
 * @attr ref android.R.styleable#View_scrollbarTrackHorizontal
 * @attr ref android.R.styleable#View_scrollbarThumbHorizontal
 * @attr ref android.R.styleable#View_scrollbarThumbVertical
 * @attr ref android.R.styleable#View_scrollbarTrackVertical
 * @attr ref android.R.styleable#View_scrollbarAlwaysDrawHorizontalTrack
 * @attr ref android.R.styleable#View_scrollbarAlwaysDrawVerticalTrack
 * @attr ref android.R.styleable#View_stateListAnimator
 * @attr ref android.R.styleable#View_transitionName
 * @attr ref android.R.styleable#View_soundEffectsEnabled
 * @attr ref android.R.styleable#View_tag
 * @attr ref android.R.styleable#View_textAlignment
 * @attr ref android.R.styleable#View_textDirection
 * @attr ref android.R.styleable#View_transformPivotX
 * @attr ref android.R.styleable#View_transformPivotY
 * @attr ref android.R.styleable#View_translationX
 * @attr ref android.R.styleable#View_translationY
 * @attr ref android.R.styleable#View_translationZ
 * @attr ref android.R.styleable#View_visibility
 * @attr ref android.R.styleable#View_theme
 *
 * @see android.view.ViewGroup
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class View implements android.graphics.drawable.Drawable.Callback, android.view.KeyEvent.Callback, android.view.accessibility.AccessibilityEventSource {

/**
 * Simple constructor to use when creating a view from code.
 *
 * @param context The Context the view is running in, through which it can
 *        access the current theme, resources, etc.
 */

public View(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Constructor that is called when inflating a view from XML. This is called
 * when a view is being constructed from an XML file, supplying attributes
 * that were specified in the XML file. This version uses a default style of
 * 0, so the only attribute values applied are those in the Context's Theme
 * and the given AttributeSet.
 *
 * <p>
 * The method onFinishInflate() will be called after all children have been
 * added.
 *
 * @param context The Context the view is running in, through which it can
 *        access the current theme, resources, etc.
 * @param attrs The attributes of the XML tag that is inflating the view.
 * This value may be {@code null}.
 * @see #View(Context, AttributeSet, int)
 */

public View(android.content.Context context, @androidx.annotation.RecentlyNullable android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/**
 * Perform inflation from XML and apply a class-specific base style from a
 * theme attribute. This constructor of View allows subclasses to use their
 * own base style when they are inflating. For example, a Button class's
 * constructor would call this version of the super class constructor and
 * supply <code>R.attr.buttonStyle</code> for <var>defStyleAttr</var>; this
 * allows the theme's button style to modify all of the base view attributes
 * (in particular its background) as well as the Button class's attributes.
 *
 * @param context The Context the view is running in, through which it can
 *        access the current theme, resources, etc.
 * @param attrs The attributes of the XML tag that is inflating the view.
 * This value may be {@code null}.
 * @param defStyleAttr An attribute in the current theme that contains a
 *        reference to a style resource that supplies default values for
 *        the view. Can be 0 to not look for defaults.
 * @see #View(Context, AttributeSet)
 */

public View(android.content.Context context, @androidx.annotation.RecentlyNullable android.util.AttributeSet attrs, int defStyleAttr) { throw new RuntimeException("Stub!"); }

/**
 * Perform inflation from XML and apply a class-specific base style from a
 * theme attribute or style resource. This constructor of View allows
 * subclasses to use their own base style when they are inflating.
 * <p>
 * When determining the final value of a particular attribute, there are
 * four inputs that come into play:
 * <ol>
 * <li>Any attribute values in the given AttributeSet.
 * <li>The style resource specified in the AttributeSet (named "style").
 * <li>The default style specified by <var>defStyleAttr</var>.
 * <li>The default style specified by <var>defStyleRes</var>.
 * <li>The base values in this theme.
 * </ol>
 * <p>
 * Each of these inputs is considered in-order, with the first listed taking
 * precedence over the following ones. In other words, if in the
 * AttributeSet you have supplied <code>&lt;Button * textColor="#ff000000"&gt;</code>
 * , then the button's text will <em>always</em> be black, regardless of
 * what is specified in any of the styles.
 *
 * @param context The Context the view is running in, through which it can
 *        access the current theme, resources, etc.
 * @param attrs The attributes of the XML tag that is inflating the view.
 * This value may be {@code null}.
 * @param defStyleAttr An attribute in the current theme that contains a
 *        reference to a style resource that supplies default values for
 *        the view. Can be 0 to not look for defaults.
 * @param defStyleRes A resource identifier of a style resource that
 *        supplies default values for the view, used only if
 *        defStyleAttr is 0 or can not be found in the theme. Can be 0
 *        to not look for defaults.
 * @see #View(Context, AttributeSet, int)
 */

public View(android.content.Context context, @androidx.annotation.RecentlyNullable android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns the size of the vertical faded edges used to indicate that more
 * content in this view is visible.
 *
 * @return The size in pixels of the vertical faded edge or 0 if vertical
 *         faded edges are not enabled for this view.
 * @attr ref android.R.styleable#View_fadingEdgeLength
 */

public int getVerticalFadingEdgeLength() { throw new RuntimeException("Stub!"); }

/**
 * Set the size of the faded edge used to indicate that more content in this
 * view is available.  Will not change whether the fading edge is enabled; use
 * {@link #setVerticalFadingEdgeEnabled(boolean)} or
 * {@link #setHorizontalFadingEdgeEnabled(boolean)} to enable the fading edge
 * for the vertical or horizontal fading edges.
 *
 * @param length The size in pixels of the faded edge used to indicate that more
 *        content in this view is visible.
 */

public void setFadingEdgeLength(int length) { throw new RuntimeException("Stub!"); }

/**
 * Returns the size of the horizontal faded edges used to indicate that more
 * content in this view is visible.
 *
 * @return The size in pixels of the horizontal faded edge or 0 if horizontal
 *         faded edges are not enabled for this view.
 * @attr ref android.R.styleable#View_fadingEdgeLength
 */

public int getHorizontalFadingEdgeLength() { throw new RuntimeException("Stub!"); }

/**
 * Returns the width of the vertical scrollbar.
 *
 * @return The width in pixels of the vertical scrollbar or 0 if there
 *         is no vertical scrollbar.
 */

public int getVerticalScrollbarWidth() { throw new RuntimeException("Stub!"); }

/**
 * Returns the height of the horizontal scrollbar.
 *
 * @return The height in pixels of the horizontal scrollbar or 0 if
 *         there is no horizontal scrollbar.
 */

protected int getHorizontalScrollbarHeight() { throw new RuntimeException("Stub!"); }

/**
 * Set the position of the vertical scroll bar. Should be one of
 * {@link #SCROLLBAR_POSITION_DEFAULT}, {@link #SCROLLBAR_POSITION_LEFT} or
 * {@link #SCROLLBAR_POSITION_RIGHT}.
 *
 * @param position Where the vertical scroll bar should be positioned.
 */

public void setVerticalScrollbarPosition(int position) { throw new RuntimeException("Stub!"); }

/**
 * @return The position where the vertical scroll bar will show, if applicable.
 * @see #setVerticalScrollbarPosition(int)
 */

public int getVerticalScrollbarPosition() { throw new RuntimeException("Stub!"); }

/**
 * Sets the state of all scroll indicators.
 * <p>
 * See {@link #setScrollIndicators(int, int)} for usage information.
 *
 * @param indicators a bitmask of indicators that should be enabled, or
 *                   {@code 0} to disable all indicators
 * Value is either <code>0</code> or a combination of {@link android.view.View#SCROLL_INDICATOR_TOP}, {@link android.view.View#SCROLL_INDICATOR_BOTTOM}, {@link android.view.View#SCROLL_INDICATOR_LEFT}, {@link android.view.View#SCROLL_INDICATOR_RIGHT}, {@link android.view.View#SCROLL_INDICATOR_START}, and {@link android.view.View#SCROLL_INDICATOR_END}
 * @see #setScrollIndicators(int, int)
 * @see #getScrollIndicators()
 * @attr ref android.R.styleable#View_scrollIndicators
 */

public void setScrollIndicators(int indicators) { throw new RuntimeException("Stub!"); }

/**
 * Sets the state of the scroll indicators specified by the mask. To change
 * all scroll indicators at once, see {@link #setScrollIndicators(int)}.
 * <p>
 * When a scroll indicator is enabled, it will be displayed if the view
 * can scroll in the direction of the indicator.
 * <p>
 * Multiple indicator types may be enabled or disabled by passing the
 * logical OR of the desired types. If multiple types are specified, they
 * will all be set to the same enabled state.
 * <p>
 * For example, to enable the top scroll indicatorExample: {@code setScrollIndicators
 *
 * @param indicators the indicator direction, or the logical OR of multiple
 *             indicator directions. One or more of:
 *             <ul>
 *               <li>{@link #SCROLL_INDICATOR_TOP}</li>
 *               <li>{@link #SCROLL_INDICATOR_BOTTOM}</li>
 *               <li>{@link #SCROLL_INDICATOR_LEFT}</li>
 *               <li>{@link #SCROLL_INDICATOR_RIGHT}</li>
 *               <li>{@link #SCROLL_INDICATOR_START}</li>
 *               <li>{@link #SCROLL_INDICATOR_END}</li>
 *             </ul>
 * @see #setScrollIndicators(int)
 * @see #getScrollIndicators()
 * @attr ref android.R.styleable#View_scrollIndicators
 
 * @param indicators Value is either <code>0</code> or a combination of {@link android.view.View#SCROLL_INDICATOR_TOP}, {@link android.view.View#SCROLL_INDICATOR_BOTTOM}, {@link android.view.View#SCROLL_INDICATOR_LEFT}, {@link android.view.View#SCROLL_INDICATOR_RIGHT}, {@link android.view.View#SCROLL_INDICATOR_START}, and {@link android.view.View#SCROLL_INDICATOR_END}

 * @param mask Value is either <code>0</code> or a combination of {@link android.view.View#SCROLL_INDICATOR_TOP}, {@link android.view.View#SCROLL_INDICATOR_BOTTOM}, {@link android.view.View#SCROLL_INDICATOR_LEFT}, {@link android.view.View#SCROLL_INDICATOR_RIGHT}, {@link android.view.View#SCROLL_INDICATOR_START}, and {@link android.view.View#SCROLL_INDICATOR_END}
 */

public void setScrollIndicators(int indicators, int mask) { throw new RuntimeException("Stub!"); }

/**
 * Returns a bitmask representing the enabled scroll indicators.
 * <p>
 * For example, if the top and left scroll indicators are enabled and all
 * other indicators are disabled, the return value will be
 * {@code View.SCROLL_INDICATOR_TOP | View.SCROLL_INDICATOR_LEFT}.
 * <p>
 * To check whether the bottom scroll indicator is enabled, use the value
 * of {@code (getScrollIndicators() & View.SCROLL_INDICATOR_BOTTOM) != 0}.
 *
 * @return a bitmask representing the enabled scroll indicators

 * Value is either <code>0</code> or a combination of {@link android.view.View#SCROLL_INDICATOR_TOP}, {@link android.view.View#SCROLL_INDICATOR_BOTTOM}, {@link android.view.View#SCROLL_INDICATOR_LEFT}, {@link android.view.View#SCROLL_INDICATOR_RIGHT}, {@link android.view.View#SCROLL_INDICATOR_START}, and {@link android.view.View#SCROLL_INDICATOR_END}
 */

public int getScrollIndicators() { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when the scroll X or Y positions of
 * this view change.
 * <p>
 * <b>Note:</b> Some views handle scrolling independently from View and may
 * have their own separate listeners for scroll-type events. For example,
 * {@link android.widget.ListView ListView} allows clients to register an
 * {@link android.widget.ListView#setOnScrollListener(android.widget.AbsListView.OnScrollListener) AbsListView.OnScrollListener}
 * to listen for changes in list scroll position.
 *
 * @param l The listener to notify when the scroll X or Y position changes.
 * @see android.view.View#getScrollX()
 * @see android.view.View#getScrollY()
 */

public void setOnScrollChangeListener(android.view.View.OnScrollChangeListener l) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when focus of this view changed.
 *
 * @param l The callback that will run.
 */

public void setOnFocusChangeListener(android.view.View.OnFocusChangeListener l) { throw new RuntimeException("Stub!"); }

/**
 * Add a listener that will be called when the bounds of the view change due to
 * layout processing.
 *
 * @param listener The listener that will be called when layout bounds change.
 */

public void addOnLayoutChangeListener(android.view.View.OnLayoutChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Remove a listener for layout changes.
 *
 * @param listener The listener for layout bounds change.
 */

public void removeOnLayoutChangeListener(android.view.View.OnLayoutChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Add a listener for attach state changes.
 *
 * This listener will be called whenever this view is attached or detached
 * from a window. Remove the listener using
 * {@link #removeOnAttachStateChangeListener(OnAttachStateChangeListener)}.
 *
 * @param listener Listener to attach
 * @see #removeOnAttachStateChangeListener(OnAttachStateChangeListener)
 */

public void addOnAttachStateChangeListener(android.view.View.OnAttachStateChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Remove a listener for attach state changes. The listener will receive no further
 * notification of window attach/detach events.
 *
 * @param listener Listener to remove
 * @see #addOnAttachStateChangeListener(OnAttachStateChangeListener)
 */

public void removeOnAttachStateChangeListener(android.view.View.OnAttachStateChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Returns the focus-change callback registered for this view.
 *
 * @return The callback, or null if one is not registered.
 */

public android.view.View.OnFocusChangeListener getOnFocusChangeListener() { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when this view is clicked. If this view is not
 * clickable, it becomes clickable.
 *
 * @param l The callback that will run
 *
 * This value may be {@code null}.
 * @see #setClickable(boolean)
 */

public void setOnClickListener(@androidx.annotation.RecentlyNullable android.view.View.OnClickListener l) { throw new RuntimeException("Stub!"); }

/**
 * Return whether this view has an attached OnClickListener.  Returns
 * true if there is a listener, false if there is none.
 */

public boolean hasOnClickListeners() { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when this view is clicked and held. If this view is not
 * long clickable, it becomes long clickable.
 *
 * @param l The callback that will run
 *
 * This value may be {@code null}.
 * @see #setLongClickable(boolean)
 */

public void setOnLongClickListener(@androidx.annotation.RecentlyNullable android.view.View.OnLongClickListener l) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when this view is context clicked. If the view is not
 * context clickable, it becomes context clickable.
 *
 * @param l The callback that will run
 * This value may be {@code null}.
 * @see #setContextClickable(boolean)
 */

public void setOnContextClickListener(@androidx.annotation.RecentlyNullable android.view.View.OnContextClickListener l) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when the context menu for this view is
 * being built. If this view is not long clickable, it becomes long clickable.
 *
 * @param l The callback that will run
 *
 */

public void setOnCreateContextMenuListener(android.view.View.OnCreateContextMenuListener l) { throw new RuntimeException("Stub!"); }

/**
 * Call this view's OnClickListener, if it is defined.  Performs all normal
 * actions associated with clicking: reporting accessibility event, playing
 * a sound, etc.
 *
 * @return True there was an assigned OnClickListener that was called, false
 *         otherwise is returned.
 */

public boolean performClick() { throw new RuntimeException("Stub!"); }

/**
 * Directly call any attached OnClickListener.  Unlike {@link #performClick()},
 * this only calls the listener, and does not do any associated clicking
 * actions like reporting an accessibility event.
 *
 * @return True there was an assigned OnClickListener that was called, false
 *         otherwise is returned.
 */

public boolean callOnClick() { throw new RuntimeException("Stub!"); }

/**
 * Calls this view's OnLongClickListener, if it is defined. Invokes the
 * context menu if the OnLongClickListener did not consume the event.
 *
 * @return {@code true} if one of the above receivers consumed the event,
 *         {@code false} otherwise
 */

public boolean performLongClick() { throw new RuntimeException("Stub!"); }

/**
 * Calls this view's OnLongClickListener, if it is defined. Invokes the
 * context menu if the OnLongClickListener did not consume the event,
 * anchoring it to an (x,y) coordinate.
 *
 * @param x x coordinate of the anchoring touch event, or {@link Float#NaN}
 *          to disable anchoring
 * @param y y coordinate of the anchoring touch event, or {@link Float#NaN}
 *          to disable anchoring
 * @return {@code true} if one of the above receivers consumed the event,
 *         {@code false} otherwise
 */

public boolean performLongClick(float x, float y) { throw new RuntimeException("Stub!"); }

/**
 * Call this view's OnContextClickListener, if it is defined.
 *
 * @param x the x coordinate of the context click
 * @param y the y coordinate of the context click
 * @return True if there was an assigned OnContextClickListener that consumed the event, false
 *         otherwise.
 */

public boolean performContextClick(float x, float y) { throw new RuntimeException("Stub!"); }

/**
 * Call this view's OnContextClickListener, if it is defined.
 *
 * @return True if there was an assigned OnContextClickListener that consumed the event, false
 *         otherwise.
 */

public boolean performContextClick() { throw new RuntimeException("Stub!"); }

/**
 * Shows the context menu for this view.
 *
 * @return {@code true} if the context menu was shown, {@code false}
 *         otherwise
 * @see #showContextMenu(float, float)
 */

public boolean showContextMenu() { throw new RuntimeException("Stub!"); }

/**
 * Shows the context menu for this view anchored to the specified
 * view-relative coordinate.
 *
 * @param x the X coordinate in pixels relative to the view to which the
 *          menu should be anchored, or {@link Float#NaN} to disable anchoring
 * @param y the Y coordinate in pixels relative to the view to which the
 *          menu should be anchored, or {@link Float#NaN} to disable anchoring
 * @return {@code true} if the context menu was shown, {@code false}
 *         otherwise
 */

public boolean showContextMenu(float x, float y) { throw new RuntimeException("Stub!"); }

/**
 * Start an action mode with the default type {@link ActionMode#TYPE_PRIMARY}.
 *
 * @param callback Callback that will control the lifecycle of the action mode
 * @return The new action mode if it is started, null otherwise
 *
 * @see ActionMode
 * @see #startActionMode(android.view.ActionMode.Callback, int)
 */

public android.view.ActionMode startActionMode(android.view.ActionMode.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * Start an action mode with the given type.
 *
 * @param callback Callback that will control the lifecycle of the action mode
 * @param type One of {@link ActionMode#TYPE_PRIMARY} or {@link ActionMode#TYPE_FLOATING}.
 * @return The new action mode if it is started, null otherwise
 *
 * @see ActionMode
 */

public android.view.ActionMode startActionMode(android.view.ActionMode.Callback callback, int type) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when a hardware key is pressed in this view.
 * Key presses in software input methods will generally not trigger the methods of
 * this listener.
 * @param l the key listener to attach to this view
 */

public void setOnKeyListener(android.view.View.OnKeyListener l) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when a touch event is sent to this view.
 * @param l the touch listener to attach to this view
 */

public void setOnTouchListener(android.view.View.OnTouchListener l) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when a generic motion event is sent to this view.
 * @param l the generic motion listener to attach to this view
 */

public void setOnGenericMotionListener(android.view.View.OnGenericMotionListener l) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when a hover event is sent to this view.
 * @param l the hover listener to attach to this view
 */

public void setOnHoverListener(android.view.View.OnHoverListener l) { throw new RuntimeException("Stub!"); }

/**
 * Register a drag event listener callback object for this View. The parameter is
 * an implementation of {@link android.view.View.OnDragListener}. To send a drag event to a
 * View, the system calls the
 * {@link android.view.View.OnDragListener#onDrag(View,DragEvent)} method.
 * @param l An implementation of {@link android.view.View.OnDragListener}.
 */

public void setOnDragListener(android.view.View.OnDragListener l) { throw new RuntimeException("Stub!"); }

/**
 * Sets this view's preference for reveal behavior when it gains focus.
 *
 * <p>When set to true, this is a signal to ancestor views in the hierarchy that
 * this view would prefer to be brought fully into view when it gains focus.
 * For example, a text field that a user is meant to type into. Other views such
 * as scrolling containers may prefer to opt-out of this behavior.</p>
 *
 * <p>The default value for views is true, though subclasses may change this
 * based on their preferred behavior.</p>
 *
 * @param revealOnFocus true to request reveal on focus in ancestors, false otherwise
 *
 * @see #getRevealOnFocusHint()
 */

public final void setRevealOnFocusHint(boolean revealOnFocus) { throw new RuntimeException("Stub!"); }

/**
 * Returns this view's preference for reveal behavior when it gains focus.
 *
 * <p>When this method returns true for a child view requesting focus, ancestor
 * views responding to a focus change in {@link ViewParent#requestChildFocus(View, View)}
 * should make a best effort to make the newly focused child fully visible to the user.
 * When it returns false, ancestor views should preferably not disrupt scroll positioning or
 * other properties affecting visibility to the user as part of the focus change.</p>
 *
 * @return true if this view would prefer to become fully visible when it gains focus,
 *         false if it would prefer not to disrupt scroll positioning
 *
 * @see #setRevealOnFocusHint(boolean)
 */

public final boolean getRevealOnFocusHint() { throw new RuntimeException("Stub!"); }

/**
 * Request that a rectangle of this view be visible on the screen,
 * scrolling if necessary just enough.
 *
 * <p>A View should call this if it maintains some notion of which part
 * of its content is interesting.  For example, a text editing view
 * should call this when its cursor moves.
 * <p>The Rectangle passed into this method should be in the View's content coordinate space.
 * It should not be affected by which part of the View is currently visible or its scroll
 * position.
 *
 * @param rectangle The rectangle in the View's content coordinate space
 * @return Whether any parent scrolled.
 */

public boolean requestRectangleOnScreen(android.graphics.Rect rectangle) { throw new RuntimeException("Stub!"); }

/**
 * Request that a rectangle of this view be visible on the screen,
 * scrolling if necessary just enough.
 *
 * <p>A View should call this if it maintains some notion of which part
 * of its content is interesting.  For example, a text editing view
 * should call this when its cursor moves.
 * <p>The Rectangle passed into this method should be in the View's content coordinate space.
 * It should not be affected by which part of the View is currently visible or its scroll
 * position.
 * <p>When <code>immediate</code> is set to true, scrolling will not be
 * animated.
 *
 * @param rectangle The rectangle in the View's content coordinate space
 * @param immediate True to forbid animated scrolling, false otherwise
 * @return Whether any parent scrolled.
 */

public boolean requestRectangleOnScreen(android.graphics.Rect rectangle, boolean immediate) { throw new RuntimeException("Stub!"); }

/**
 * Called when this view wants to give up focus. If focus is cleared
 * {@link #onFocusChanged(boolean, int, android.graphics.Rect)} is called.
 * <p>
 * <strong>Note:</strong> When not in touch-mode, the framework will try to give focus
 * to the first focusable View from the top after focus is cleared. Hence, if this
 * View is the first from the top that can take focus, then all callbacks
 * related to clearing focus will be invoked after which the framework will
 * give focus to this view.
 * </p>
 */

public void clearFocus() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this view has focus itself, or is the ancestor of the
 * view that has focus.
 *
 * @return True if this view has or contains focus, false otherwise.
 */

@android.view.ViewDebug.ExportedProperty(category="focus") public boolean hasFocus() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this view is focusable or if it contains a reachable View
 * for which {@link #hasFocusable()} returns {@code true}. A "reachable hasFocusable()"
 * is a view whose parents do not block descendants focus.
 * Only {@link #VISIBLE} views are considered focusable.
 *
 * <p>As of {@link Build.VERSION_CODES#O} views that are determined to be focusable
 * through {@link #FOCUSABLE_AUTO} will also cause this method to return {@code true}.
 * Apps that declare a {@link android.content.pm.ApplicationInfo#targetSdkVersion} of
 * earlier than {@link Build.VERSION_CODES#O} will continue to see this method return
 * {@code false} for views not explicitly marked as focusable.
 * Use {@link #hasExplicitFocusable()} if you require the pre-{@link Build.VERSION_CODES#O}
 * behavior.</p>
 *
 * @return {@code true} if the view is focusable or if the view contains a focusable
 *         view, {@code false} otherwise
 *
 * @see ViewGroup#FOCUS_BLOCK_DESCENDANTS
 * @see ViewGroup#getTouchscreenBlocksFocus()
 * @see #hasExplicitFocusable()
 */

public boolean hasFocusable() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this view is focusable or if it contains a reachable View
 * for which {@link #hasExplicitFocusable()} returns {@code true}.
 * A "reachable hasExplicitFocusable()" is a view whose parents do not block descendants focus.
 * Only {@link #VISIBLE} views for which {@link #getFocusable()} would return
 * {@link #FOCUSABLE} are considered focusable.
 *
 * <p>This method preserves the pre-{@link Build.VERSION_CODES#O} behavior of
 * {@link #hasFocusable()} in that only views explicitly set focusable will cause
 * this method to return true. A view set to {@link #FOCUSABLE_AUTO} that resolves
 * to focusable will not.</p>
 *
 * @return {@code true} if the view is focusable or if the view contains a focusable
 *         view, {@code false} otherwise
 *
 * @see #hasFocusable()
 */

public boolean hasExplicitFocusable() { throw new RuntimeException("Stub!"); }

/**
 * Called by the view system when the focus state of this view changes.
 * When the focus change event is caused by directional navigation, direction
 * and previouslyFocusedRect provide insight into where the focus is coming from.
 * When overriding, be sure to call up through to the super class so that
 * the standard focus handling will occur.
 *
 * If you override this method you <em>must</em> call through to the
 *  *            superclass implementation.
 * @param gainFocus True if the View has focus; false otherwise.
 * @param direction The direction focus has moved when requestFocus()
 *                  is called to give this view focus. Values are
 *                  {@link #FOCUS_UP}, {@link #FOCUS_DOWN}, {@link #FOCUS_LEFT},
 *                  {@link #FOCUS_RIGHT}, {@link #FOCUS_FORWARD}, or {@link #FOCUS_BACKWARD}.
 *                  It may not always apply, in which case use the default.
 * Value is {@link android.view.View#FOCUS_BACKWARD}, {@link android.view.View#FOCUS_FORWARD}, {@link android.view.View#FOCUS_LEFT}, {@link android.view.View#FOCUS_UP}, {@link android.view.View#FOCUS_RIGHT}, or {@link android.view.View#FOCUS_DOWN}
 * @param previouslyFocusedRect The rectangle, in this view's coordinate
 *        system, of the previously focused view.  If applicable, this will be
 *        passed in as finer grained information about where the focus is coming
 *        from (in addition to direction).  Will be <code>null</code> otherwise.

 * This value may be {@code null}.
 */

protected void onFocusChanged(boolean gainFocus, int direction, @androidx.annotation.RecentlyNullable android.graphics.Rect previouslyFocusedRect) { throw new RuntimeException("Stub!"); }

/**
 * Visually distinct portion of a window with window-like semantics are considered panes for
 * accessibility purposes. One example is the content view of a fragment that is replaced.
 * In order for accessibility services to understand a pane's window-like behavior, panes
 * should have descriptive titles. Views with pane titles produce {@link AccessibilityEvent}s
 * when they appear, disappear, or change title.
 *
 * @param accessibilityPaneTitle The pane's title. Setting to {@code null} indicates that this
 *                               View is not a pane.
 *
 * {@see AccessibilityNodeInfo#setPaneTitle(CharSequence)}

 * This value may be {@code null}.
 */

public void setAccessibilityPaneTitle(@androidx.annotation.RecentlyNullable java.lang.CharSequence accessibilityPaneTitle) { throw new RuntimeException("Stub!"); }

/**
 * Get the title of the pane for purposes of accessibility.
 *
 * @return The current pane title.
 *
 * {@see #setAccessibilityPaneTitle}.

 * This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public java.lang.CharSequence getAccessibilityPaneTitle() { throw new RuntimeException("Stub!"); }

/**
 * Sends an accessibility event of the given type. If accessibility is
 * not enabled this method has no effect. The default implementation calls
 * {@link #onInitializeAccessibilityEvent(AccessibilityEvent)} first
 * to populate information about the event source (this View), then calls
 * {@link #dispatchPopulateAccessibilityEvent(AccessibilityEvent)} to
 * populate the text content of the event source including its descendants,
 * and last calls
 * {@link ViewParent#requestSendAccessibilityEvent(View, AccessibilityEvent)}
 * on its parent to request sending of the event to interested parties.
 * <p>
 * If an {@link AccessibilityDelegate} has been specified via calling
 * {@link #setAccessibilityDelegate(AccessibilityDelegate)} its
 * {@link AccessibilityDelegate#sendAccessibilityEvent(View, int)} is
 * responsible for handling this call.
 * </p>
 *
 * @param eventType The type of the event to send, as defined by several types from
 * {@link android.view.accessibility.AccessibilityEvent}, such as
 * {@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_CLICKED} or
 * {@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_HOVER_ENTER}.
 *
 * @see #onInitializeAccessibilityEvent(AccessibilityEvent)
 * @see #dispatchPopulateAccessibilityEvent(AccessibilityEvent)
 * @see ViewParent#requestSendAccessibilityEvent(View, AccessibilityEvent)
 * @see AccessibilityDelegate
 */

public void sendAccessibilityEvent(int eventType) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method for sending a {@link AccessibilityEvent#TYPE_ANNOUNCEMENT}
 * {@link AccessibilityEvent} to make an announcement which is related to some
 * sort of a context change for which none of the events representing UI transitions
 * is a good fit. For example, announcing a new page in a book. If accessibility
 * is not enabled this method does nothing.
 *
 * @param text The announcement text.
 */

public void announceForAccessibility(java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/**
 * This method behaves exactly as {@link #sendAccessibilityEvent(int)} but
 * takes as an argument an empty {@link AccessibilityEvent} and does not
 * perform a check whether accessibility is enabled.
 * <p>
 * If an {@link AccessibilityDelegate} has been specified via calling
 * {@link #setAccessibilityDelegate(AccessibilityDelegate)} its
 * {@link AccessibilityDelegate#sendAccessibilityEventUnchecked(View, AccessibilityEvent)}
 * is responsible for handling this call.
 * </p>
 *
 * @param event The event to send.
 *
 * @see #sendAccessibilityEvent(int)
 */

public void sendAccessibilityEventUnchecked(android.view.accessibility.AccessibilityEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Dispatches an {@link AccessibilityEvent} to the {@link View} first and then
 * to its children for adding their text content to the event. Note that the
 * event text is populated in a separate dispatch path since we add to the
 * event not only the text of the source but also the text of all its descendants.
 * A typical implementation will call
 * {@link #onPopulateAccessibilityEvent(AccessibilityEvent)} on the this view
 * and then call the {@link #dispatchPopulateAccessibilityEvent(AccessibilityEvent)}
 * on each child. Override this method if custom population of the event text
 * content is required.
 * <p>
 * If an {@link AccessibilityDelegate} has been specified via calling
 * {@link #setAccessibilityDelegate(AccessibilityDelegate)} its
 * {@link AccessibilityDelegate#dispatchPopulateAccessibilityEvent(View, AccessibilityEvent)}
 * is responsible for handling this call.
 * </p>
 * <p>
 * <em>Note:</em> Accessibility events of certain types are not dispatched for
 * populating the event text via this method. For details refer to {@link AccessibilityEvent}.
 * </p>
 *
 * @param event The event.
 *
 * @return True if the event population was completed.
 */

public boolean dispatchPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Called from {@link #dispatchPopulateAccessibilityEvent(AccessibilityEvent)}
 * giving a chance to this View to populate the accessibility event with its
 * text content. While this method is free to modify event
 * attributes other than text content, doing so should normally be performed in
 * {@link #onInitializeAccessibilityEvent(AccessibilityEvent)}.
 * <p>
 * Example: Adding formatted date string to an accessibility event in addition
 *          to the text added by the super implementation:
 * <pre> public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
 *     super.onPopulateAccessibilityEvent(event);
 *     final int flags = DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_WEEKDAY;
 *     String selectedDateUtterance = DateUtils.formatDateTime(mContext,
 *         mCurrentDate.getTimeInMillis(), flags);
 *     event.getText().add(selectedDateUtterance);
 * }</pre>
 * <p>
 * If an {@link AccessibilityDelegate} has been specified via calling
 * {@link #setAccessibilityDelegate(AccessibilityDelegate)} its
 * {@link AccessibilityDelegate#onPopulateAccessibilityEvent(View, AccessibilityEvent)}
 * is responsible for handling this call.
 * </p>
 * <p class="note"><strong>Note:</strong> Always call the super implementation before adding
 * information to the event, in case the default implementation has basic information to add.
 * </p>
 *
 * If you override this method you <em>must</em> call through to the
 *  *            superclass implementation.
 * @param event The accessibility event which to populate.
 *
 * @see #sendAccessibilityEvent(int)
 * @see #dispatchPopulateAccessibilityEvent(AccessibilityEvent)
 */

public void onPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Initializes an {@link AccessibilityEvent} with information about
 * this View which is the event source. In other words, the source of
 * an accessibility event is the view whose state change triggered firing
 * the event.
 * <p>
 * Example: Setting the password property of an event in addition
 *          to properties set by the super implementation:
 * <pre> public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
 *     super.onInitializeAccessibilityEvent(event);
 *     event.setPassword(true);
 * }</pre>
 * <p>
 * If an {@link AccessibilityDelegate} has been specified via calling
 * {@link #setAccessibilityDelegate(AccessibilityDelegate)} its
 * {@link AccessibilityDelegate#onInitializeAccessibilityEvent(View, AccessibilityEvent)}
 * is responsible for handling this call.
 * </p>
 * <p class="note"><strong>Note:</strong> Always call the super implementation before adding
 * information to the event, in case the default implementation has basic information to add.
 * </p>
 * If you override this method you <em>must</em> call through to the
 *  *            superclass implementation.
 * @param event The event to initialize.
 *
 * @see #sendAccessibilityEvent(int)
 * @see #dispatchPopulateAccessibilityEvent(AccessibilityEvent)
 */

public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Returns an {@link AccessibilityNodeInfo} representing this view from the
 * point of view of an {@link android.accessibilityservice.AccessibilityService}.
 * This method is responsible for obtaining an accessibility node info from a
 * pool of reusable instances and calling
 * {@link #onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo)} on this view to
 * initialize the former.
 * <p>
 * Note: The client is responsible for recycling the obtained instance by calling
 *       {@link AccessibilityNodeInfo#recycle()} to minimize object creation.
 * </p>
 *
 * @return A populated {@link AccessibilityNodeInfo}.
 *
 * @see AccessibilityNodeInfo
 */

public android.view.accessibility.AccessibilityNodeInfo createAccessibilityNodeInfo() { throw new RuntimeException("Stub!"); }

/**
 * Initializes an {@link AccessibilityNodeInfo} with information about this view.
 * The base implementation sets:
 * <ul>
 *   <li>{@link AccessibilityNodeInfo#setParent(View)},</li>
 *   <li>{@link AccessibilityNodeInfo#setBoundsInParent(Rect)},</li>
 *   <li>{@link AccessibilityNodeInfo#setBoundsInScreen(Rect)},</li>
 *   <li>{@link AccessibilityNodeInfo#setPackageName(CharSequence)},</li>
 *   <li>{@link AccessibilityNodeInfo#setClassName(CharSequence)},</li>
 *   <li>{@link AccessibilityNodeInfo#setContentDescription(CharSequence)},</li>
 *   <li>{@link AccessibilityNodeInfo#setEnabled(boolean)},</li>
 *   <li>{@link AccessibilityNodeInfo#setClickable(boolean)},</li>
 *   <li>{@link AccessibilityNodeInfo#setFocusable(boolean)},</li>
 *   <li>{@link AccessibilityNodeInfo#setFocused(boolean)},</li>
 *   <li>{@link AccessibilityNodeInfo#setLongClickable(boolean)},</li>
 *   <li>{@link AccessibilityNodeInfo#setSelected(boolean)},</li>
 *   <li>{@link AccessibilityNodeInfo#setContextClickable(boolean)}</li>
 * </ul>
 * <p>
 * Subclasses should override this method, call the super implementation,
 * and set additional attributes.
 * </p>
 * <p>
 * If an {@link AccessibilityDelegate} has been specified via calling
 * {@link #setAccessibilityDelegate(AccessibilityDelegate)} its
 * {@link AccessibilityDelegate#onInitializeAccessibilityNodeInfo(View, AccessibilityNodeInfo)}
 * is responsible for handling this call.
 * </p>
 *
 * If you override this method you <em>must</em> call through to the
 *  *            superclass implementation.
 * @param info The instance to initialize.
 */

public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo info) { throw new RuntimeException("Stub!"); }

/**
 * Return the class name of this object to be used for accessibility purposes.
 * Subclasses should only override this if they are implementing something that
 * should be seen as a completely new class of view when used by accessibility,
 * unrelated to the class it is deriving from.  This is used to fill in
 * {@link AccessibilityNodeInfo#setClassName AccessibilityNodeInfo.setClassName}.
 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }

/**
 * Called when assist structure is being retrieved from a view as part of
 * {@link android.app.Activity#onProvideAssistData Activity.onProvideAssistData}.
 * @param structure Fill in with structured view data.  The default implementation
 * fills in all data that can be inferred from the view itself.
 */

public void onProvideStructure(android.view.ViewStructure structure) { throw new RuntimeException("Stub!"); }

/**
 * Populates a {@link ViewStructure} to fullfil an autofill request.
 *
 * <p>The structure should contain at least the following properties:
 * <ul>
 *   <li>Autofill id ({@link ViewStructure#setAutofillId(AutofillId, int)}).
 *   <li>Autofill type ({@link ViewStructure#setAutofillType(int)}).
 *   <li>Autofill value ({@link ViewStructure#setAutofillValue(AutofillValue)}).
 *   <li>Whether the data is sensitive ({@link ViewStructure#setDataIsSensitive(boolean)}).
 * </ul>
 *
 * <p>It's also recommended to set the following properties - the more properties the structure
 * has, the higher the changes of an {@link android.service.autofill.AutofillService} properly
 * using the structure:
 *
 * <ul>
 *   <li>Autofill hints ({@link ViewStructure#setAutofillHints(String[])}).
 *   <li>Autofill options ({@link ViewStructure#setAutofillOptions(CharSequence[])}) when the
 *       view can only be filled with predefined values (typically used when the autofill type
 *       is {@link #AUTOFILL_TYPE_LIST}).
 *   <li>Resource id ({@link ViewStructure#setId(int, String, String, String)}).
 *   <li>Class name ({@link ViewStructure#setClassName(String)}).
 *   <li>Content description ({@link ViewStructure#setContentDescription(CharSequence)}).
 *   <li>Visual properties such as visibility ({@link ViewStructure#setVisibility(int)}),
 *       dimensions ({@link ViewStructure#setDimens(int, int, int, int, int, int)}), and
 *       opacity ({@link ViewStructure#setOpaque(boolean)}).
 *   <li>For views representing text fields, text properties such as the text itself
 *       ({@link ViewStructure#setText(CharSequence)}), text hints
 *       ({@link ViewStructure#setHint(CharSequence)}, input type
 *       ({@link ViewStructure#setInputType(int)}),
 *   <li>For views representing HTML nodes, its web domain
 *       ({@link ViewStructure#setWebDomain(String)}) and HTML properties
 *       (({@link ViewStructure#setHtmlInfo(android.view.ViewStructure.HtmlInfo)}).
 * </ul>
 *
 * <p>The default implementation of this method already sets most of these properties based on
 * related {@link View} methods (for example, the autofill id is set using
 * {@link #getAutofillId()}, the autofill type set using {@link #getAutofillType()}, etc.),
 * and views in the standard Android widgets library also override it to set their
 * relevant properties (for example, {@link android.widget.TextView} already sets the text
 * properties), so it's recommended to only override this method
 * (and call {@code super.onProvideAutofillStructure()}) when:
 *
 * <ul>
 *   <li>The view contents does not include PII (Personally Identifiable Information), so it
 *       can call {@link ViewStructure#setDataIsSensitive(boolean)} passing {@code false}.
 *   <li>The view can only be autofilled with predefined options, so it can call
 *       {@link ViewStructure#setAutofillOptions(CharSequence[])}.
 * </ul>
 *
 * <p><b>Note:</b> The {@code left} and {@code top} values set in
 * {@link ViewStructure#setDimens(int, int, int, int, int, int)} must be relative to the next
 * {@link ViewGroup#isImportantForAutofill()} predecessor view included in the structure.
 *
 * <p>Views support the Autofill Framework mainly by:
 * <ul>
 *   <li>Providing the metadata defining what the view means and how it can be autofilled.
 *   <li>Notifying the Android System when the view value changed by calling
 *       {@link AutofillManager#notifyValueChanged(View)}.
 *   <li>Implementing the methods that autofill the view.
 * </ul>
 * <p>This method is responsible for the former; {@link #autofill(AutofillValue)} is responsible
 * for the latter.
 *
 * @param structure fill in with structured view data for autofill purposes.
 * @param flags optional flags.
 *
 * Value is either <code>0</code> or {@link android.view.View#AUTOFILL_FLAG_INCLUDE_NOT_IMPORTANT_VIEWS}
 * @see #AUTOFILL_FLAG_INCLUDE_NOT_IMPORTANT_VIEWS
 */

public void onProvideAutofillStructure(android.view.ViewStructure structure, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Called when assist structure is being retrieved from a view as part of
 * {@link android.app.Activity#onProvideAssistData Activity.onProvideAssistData} to
 * generate additional virtual structure under this view.  The defaullt implementation
 * uses {@link #getAccessibilityNodeProvider()} to try to generate this from the
 * view's virtual accessibility nodes, if any.  You can override this for a more
 * optimal implementation providing this data.
 */

public void onProvideVirtualStructure(android.view.ViewStructure structure) { throw new RuntimeException("Stub!"); }

/**
 * Populates a {@link ViewStructure} containing virtual children to fullfil an autofill
 * request.
 *
 * <p>This method should be used when the view manages a virtual structure under this view. For
 * example, a view that draws input fields using {@link #draw(Canvas)}.
 *
 * <p>When implementing this method, subclasses must follow the rules below:
 *
 * <ul>
 *   <li>Add virtual children by calling the {@link ViewStructure#newChild(int)} or
 *       {@link ViewStructure#asyncNewChild(int)} methods, where the {@code id} is an unique id
 *       identifying the children in the virtual structure.
 *   <li>The children hierarchy can have multiple levels if necessary, but ideally it should
 *       exclude intermediate levels that are irrelevant for autofill; that would improve the
 *       autofill performance.
 *   <li>Also implement {@link #autofill(SparseArray)} to autofill the virtual
 *       children.
 *   <li>Set the autofill properties of the child structure as defined by
 *       {@link #onProvideAutofillStructure(ViewStructure, int)}, using
 *       {@link ViewStructure#setAutofillId(AutofillId, int)} to set its autofill id.
 *   <li>Call {@link android.view.autofill.AutofillManager#notifyViewEntered(View, int, Rect)}
 *       and/or {@link android.view.autofill.AutofillManager#notifyViewExited(View, int)}
 *       when the focused virtual child changed.
 *   <li>Override {@link #isVisibleToUserForAutofill(int)} to allow the platform to query
 *       whether a given virtual view is visible to the user in order to support triggering
 *       save when all views of interest go away.
 *   <li>Call
 *    {@link android.view.autofill.AutofillManager#notifyValueChanged(View, int, AutofillValue)}
 *       when the value of a virtual child changed.
 *   <li>Call {@link
 *    android.view.autofill.AutofillManager#notifyViewVisibilityChanged(View, int, boolean)}
 *       when the visibility of a virtual child changed.
 *   <li>Call
 *    {@link android.view.autofill.AutofillManager#notifyViewClicked(View, int)} when a virtual
 *       child is clicked.
 *   <li>Call {@link AutofillManager#commit()} when the autofill context of the view structure
 *       changed and the current context should be committed (for example, when the user tapped
 *       a {@code SUBMIT} button in an HTML page).
 *   <li>Call {@link AutofillManager#cancel()} when the autofill context of the view structure
 *       changed and the current context should be canceled (for example, when the user tapped
 *       a {@code CANCEL} button in an HTML page).
 *   <li>Provide ways for users to manually request autofill by calling
 *       {@link AutofillManager#requestAutofill(View, int, Rect)}.
 *   <li>The {@code left} and {@code top} values set in
 *       {@link ViewStructure#setDimens(int, int, int, int, int, int)} must be relative to the
 *       next {@link ViewGroup#isImportantForAutofill()} predecessor view included in the
 *       structure.
 * </ul>
 *
 * <p>Views with virtual children support the Autofill Framework mainly by:
 * <ul>
 *   <li>Providing the metadata defining what the virtual children mean and how they can be
 *       autofilled.
 *   <li>Implementing the methods that autofill the virtual children.
 * </ul>
 * <p>This method is responsible for the former; {@link #autofill(SparseArray)} is responsible
 * for the latter.
 *
 * @param structure fill in with virtual children data for autofill purposes.
 * @param flags optional flags.
 *
 * @see #AUTOFILL_FLAG_INCLUDE_NOT_IMPORTANT_VIEWS
 */

public void onProvideAutofillVirtualStructure(android.view.ViewStructure structure, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Automatically fills the content of this view with the {@code value}.
 *
 * <p>Views support the Autofill Framework mainly by:
 * <ul>
 *   <li>Providing the metadata defining what the view means and how it can be autofilled.
 *   <li>Implementing the methods that autofill the view.
 * </ul>
 * <p>{@link #onProvideAutofillStructure(ViewStructure, int)} is responsible for the former,
 * this method is responsible for latter.
 *
 * <p>This method does nothing by default, but when overridden it typically:
 * <ol>
 *   <li>Checks if the provided value matches the expected type (which is defined by
 *       {@link #getAutofillType()}).
 *   <li>Checks if the view is editable - if it isn't, it should return right away.
 *   <li>Call the proper getter method on {@link AutofillValue} to fetch the actual value.
 *   <li>Pass the actual value to the equivalent setter in the view.
 * </ol>
 *
 * <p>For example, a text-field view could implement the method this way:
 *
 * <pre class="prettyprint">
 * &#64;Override
 * public void autofill(AutofillValue value) {
 *   if (!value.isText() || !this.isEditable()) {
 *      return;
 *   }
 *   CharSequence text = value.getTextValue();
 *   if (text != null) {
 *     this.setText(text);
 *   }
 * }
 * </pre>
 *
 * <p>If the value is updated asynchronously, the next call to
 * {@link AutofillManager#notifyValueChanged(View)} must happen <b>after</b> the value was
 * changed to the autofilled value. If not, the view will not be considered autofilled.
 *
 * <p><b>Note:</b> After this method is called, the value returned by
 * {@link #getAutofillValue()} must be equal to the {@code value} passed to it, otherwise the
 * view will not be highlighted as autofilled.
 *
 * @param value value to be autofilled.
 */

public void autofill(android.view.autofill.AutofillValue value) { throw new RuntimeException("Stub!"); }

/**
 * Automatically fills the content of the virtual children within this view.
 *
 * <p>Views with virtual children support the Autofill Framework mainly by:
 * <ul>
 *   <li>Providing the metadata defining what the virtual children mean and how they can be
 *       autofilled.
 *   <li>Implementing the methods that autofill the virtual children.
 * </ul>
 * <p>{@link #onProvideAutofillVirtualStructure(ViewStructure, int)} is responsible for the
 * former, this method is responsible for the latter - see {@link #autofill(AutofillValue)} and
 * {@link #onProvideAutofillVirtualStructure(ViewStructure, int)} for more info about autofill.
 *
 * <p>If a child value is updated asynchronously, the next call to
 * {@link AutofillManager#notifyValueChanged(View, int, AutofillValue)} must happen
 * <b>after</b> the value was changed to the autofilled value. If not, the child will not be
 * considered autofilled.
 *
 * <p><b>Note:</b> To indicate that a virtual view was autofilled,
 * <code>?android:attr/autofilledHighlight</code> should be drawn over it until the data
 * changes.
 *
 * @param values map of values to be autofilled, keyed by virtual child id.
 *
 * This value must never be {@code null}.
 * @attr ref android.R.styleable#Theme_autofilledHighlight
 */

public void autofill(@androidx.annotation.RecentlyNonNull android.util.SparseArray<android.view.autofill.AutofillValue> values) { throw new RuntimeException("Stub!"); }

/**
 * Gets the unique, logical identifier of this view in the activity, for autofill purposes.
 *
 * <p>The autofill id is created on demand, unless it is explicitly set by
 * {@link #setAutofillId(AutofillId)}.
 *
 * <p>See {@link #setAutofillId(AutofillId)} for more info.
 *
 * @return The View's autofill id.
 */

public final android.view.autofill.AutofillId getAutofillId() { throw new RuntimeException("Stub!"); }

/**
 * Sets the unique, logical identifier of this view in the activity, for autofill purposes.
 *
 * <p>The autofill id is created on demand, and this method should only be called when a view is
 * reused after {@link #dispatchProvideAutofillStructure(ViewStructure, int)} is called, as
 * that method creates a snapshot of the view that is passed along to the autofill service.
 *
 * <p>This method is typically used when view subtrees are recycled to represent different
 * content* &mdash;in this case, the autofill id can be saved before the view content is swapped
 * out, and restored later when it's swapped back in. For example:
 *
 * <pre>
 * EditText reusableView = ...;
 * ViewGroup parentView = ...;
 * AutofillManager afm = ...;
 *
 * // Swap out the view and change its contents
 * AutofillId oldId = reusableView.getAutofillId();
 * CharSequence oldText = reusableView.getText();
 * parentView.removeView(reusableView);
 * AutofillId newId = afm.getNextAutofillId();
 * reusableView.setText("New I am");
 * reusableView.setAutofillId(newId);
 * parentView.addView(reusableView);
 *
 * // Later, swap the old content back in
 * parentView.removeView(reusableView);
 * reusableView.setAutofillId(oldId);
 * reusableView.setText(oldText);
 * parentView.addView(reusableView);
 * </pre>
 *
 * @param id an autofill ID that is unique in the {@link android.app.Activity} hosting the view,
 * or {@code null} to reset it. Usually it's an id previously allocated to another view (and
 * obtained through {@link #getAutofillId()}), or a new value obtained through
 * {@link AutofillManager#getNextAutofillId()}.
 *
 * This value may be {@code null}.
 * @throws IllegalStateException if the view is already {@link #isAttachedToWindow() attached to
 * a window}.
 *
 * @throws IllegalArgumentException if the id is an autofill id associated with a virtual view.
 */

public void setAutofillId(@androidx.annotation.RecentlyNullable android.view.autofill.AutofillId id) { throw new RuntimeException("Stub!"); }

/**
 * Describes the autofill type of this view, so an
 * {@link android.service.autofill.AutofillService} can create the proper {@link AutofillValue}
 * when autofilling the view.
 *
 * <p>By default returns {@link #AUTOFILL_TYPE_NONE}, but views should override it to properly
 * support the Autofill Framework.
 *
 * @return either {@link #AUTOFILL_TYPE_NONE}, {@link #AUTOFILL_TYPE_TEXT},
 * {@link #AUTOFILL_TYPE_LIST}, {@link #AUTOFILL_TYPE_DATE}, or {@link #AUTOFILL_TYPE_TOGGLE}.
 *
 * Value is {@link android.view.View#AUTOFILL_TYPE_NONE}, {@link android.view.View#AUTOFILL_TYPE_TEXT}, {@link android.view.View#AUTOFILL_TYPE_TOGGLE}, {@link android.view.View#AUTOFILL_TYPE_LIST}, or {@link android.view.View#AUTOFILL_TYPE_DATE}
 * @see #onProvideAutofillStructure(ViewStructure, int)
 * @see #autofill(AutofillValue)
 */

public int getAutofillType() { throw new RuntimeException("Stub!"); }

/**
 * Gets the hints that help an {@link android.service.autofill.AutofillService} determine how
 * to autofill the view with the user's data.
 *
 * <p>See {@link #setAutofillHints(String...)} for more info about these hints.
 *
 * @return The hints set via the attribute or {@link #setAutofillHints(String...)}, or
 * {@code null} if no hints were set.
 *
 * @attr ref android.R.styleable#View_autofillHints
 */

@android.view.ViewDebug.ExportedProperty @androidx.annotation.RecentlyNullable public java.lang.String[] getAutofillHints() { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@link View}'s current autofill value.
 *
 * <p>By default returns {@code null}, but subclasses should override it and return an
 * appropriate value to properly support the Autofill Framework.
 *
 * @see #onProvideAutofillStructure(ViewStructure, int)
 * @see #autofill(AutofillValue)
 */

@androidx.annotation.RecentlyNullable public android.view.autofill.AutofillValue getAutofillValue() { throw new RuntimeException("Stub!"); }

/**
 * Gets the mode for determining whether this view is important for autofill.
 *
 * <p>See {@link #setImportantForAutofill(int)} and {@link #isImportantForAutofill()} for more
 * info about this mode.
 *
 * @return {@link #IMPORTANT_FOR_AUTOFILL_AUTO} by default, or value passed to
 * {@link #setImportantForAutofill(int)}.
 *
 * Value is {@link android.view.View#IMPORTANT_FOR_AUTOFILL_AUTO}, {@link android.view.View#IMPORTANT_FOR_AUTOFILL_YES}, {@link android.view.View#IMPORTANT_FOR_AUTOFILL_NO}, {@link android.view.View#IMPORTANT_FOR_AUTOFILL_YES_EXCLUDE_DESCENDANTS}, or {@link android.view.View#IMPORTANT_FOR_AUTOFILL_NO_EXCLUDE_DESCENDANTS}
 * @attr ref android.R.styleable#View_importantForAutofill
 */

@android.view.ViewDebug.ExportedProperty(mapping={@android.view.ViewDebug.IntToString(from=android.view.View.IMPORTANT_FOR_AUTOFILL_AUTO, to="auto"), @android.view.ViewDebug.IntToString(from=android.view.View.IMPORTANT_FOR_AUTOFILL_YES, to="yes"), @android.view.ViewDebug.IntToString(from=android.view.View.IMPORTANT_FOR_AUTOFILL_NO, to="no"), @android.view.ViewDebug.IntToString(from=android.view.View.IMPORTANT_FOR_AUTOFILL_YES_EXCLUDE_DESCENDANTS, to="yesExcludeDescendants"), @android.view.ViewDebug.IntToString(from=android.view.View.IMPORTANT_FOR_AUTOFILL_NO_EXCLUDE_DESCENDANTS, to="noExcludeDescendants")}) public int getImportantForAutofill() { throw new RuntimeException("Stub!"); }

/**
 * Sets the mode for determining whether this view is considered important for autofill.
 *
 * <p>The platform determines the importance for autofill automatically but you
 * can use this method to customize the behavior. For example:
 *
 * <ol>
 *   <li>When the view contents is irrelevant for autofill (for example, a text field used in a
 *       "Captcha" challenge), it should be {@link #IMPORTANT_FOR_AUTOFILL_NO}.
 *   <li>When both the view and its children are irrelevant for autofill (for example, the root
 *       view of an activity containing a spreadhseet editor), it should be
 *       {@link #IMPORTANT_FOR_AUTOFILL_NO_EXCLUDE_DESCENDANTS}.
 *   <li>When the view content is relevant for autofill but its children aren't (for example,
 *       a credit card expiration date represented by a custom view that overrides the proper
 *       autofill methods and has 2 children representing the month and year), it should
 *       be {@link #IMPORTANT_FOR_AUTOFILL_YES_EXCLUDE_DESCENDANTS}.
 * </ol>
 *
 * <p><b>Note:</b> Setting the mode as {@link #IMPORTANT_FOR_AUTOFILL_NO} or
 * {@link #IMPORTANT_FOR_AUTOFILL_NO_EXCLUDE_DESCENDANTS} does not guarantee the view (and its
 * children) will be always be considered not important; for example, when the user explicitly
 * makes an autofill request, all views are considered important. See
 * {@link #isImportantForAutofill()} for more details about how the View's importance for
 * autofill is used.
 *
 * @param mode {@link #IMPORTANT_FOR_AUTOFILL_AUTO}, {@link #IMPORTANT_FOR_AUTOFILL_YES},
 * {@link #IMPORTANT_FOR_AUTOFILL_NO}, {@link #IMPORTANT_FOR_AUTOFILL_YES_EXCLUDE_DESCENDANTS},
 * or {@link #IMPORTANT_FOR_AUTOFILL_NO_EXCLUDE_DESCENDANTS}.
 *
 * Value is {@link android.view.View#IMPORTANT_FOR_AUTOFILL_AUTO}, {@link android.view.View#IMPORTANT_FOR_AUTOFILL_YES}, {@link android.view.View#IMPORTANT_FOR_AUTOFILL_NO}, {@link android.view.View#IMPORTANT_FOR_AUTOFILL_YES_EXCLUDE_DESCENDANTS}, or {@link android.view.View#IMPORTANT_FOR_AUTOFILL_NO_EXCLUDE_DESCENDANTS}
 * @attr ref android.R.styleable#View_importantForAutofill
 */

public void setImportantForAutofill(int mode) { throw new RuntimeException("Stub!"); }

/**
 * Hints the Android System whether the {@link android.app.assist.AssistStructure.ViewNode}
 * associated with this view is considered important for autofill purposes.
 *
 * <p>Generally speaking, a view is important for autofill if:
 * <ol>
 * <li>The view can be autofilled by an {@link android.service.autofill.AutofillService}.
 * <li>The view contents can help an {@link android.service.autofill.AutofillService}
 *     determine how other views can be autofilled.
 * <ol>
 *
 * <p>For example, view containers should typically return {@code false} for performance reasons
 * (since the important info is provided by their children), but if its properties have relevant
 * information (for example, a resource id called {@code credentials}, it should return
 * {@code true}. On the other hand, views representing labels or editable fields should
 * typically return {@code true}, but in some cases they could return {@code false}
 * (for example, if they're part of a "Captcha" mechanism).
 *
 * <p>The value returned by this method depends on the value returned by
 * {@link #getImportantForAutofill()}:
 *
 * <ol>
 *   <li>if it returns {@link #IMPORTANT_FOR_AUTOFILL_YES} or
 *       {@link #IMPORTANT_FOR_AUTOFILL_YES_EXCLUDE_DESCENDANTS}, then it returns {@code true}
 *   <li>if it returns {@link #IMPORTANT_FOR_AUTOFILL_NO} or
 *       {@link #IMPORTANT_FOR_AUTOFILL_NO_EXCLUDE_DESCENDANTS}, then it returns {@code false}
 *   <li>if it returns {@link #IMPORTANT_FOR_AUTOFILL_AUTO}, then it uses some simple heuristics
 *       that can return {@code true} in some cases (like a container with a resource id),
 *       but {@code false} in most.
 *   <li>otherwise, it returns {@code false}.
 * </ol>
 *
 * <p>When a view is considered important for autofill:
 * <ul>
 *   <li>The view might automatically trigger an autofill request when focused on.
 *   <li>The contents of the view are included in the {@link ViewStructure} used in an autofill
 *       request.
 * </ul>
 *
 * <p>On the other hand, when a view is considered not important for autofill:
 * <ul>
 *   <li>The view never automatically triggers autofill requests, but it can trigger a manual
 *       request through {@link AutofillManager#requestAutofill(View)}.
 *   <li>The contents of the view are not included in the {@link ViewStructure} used in an
 *       autofill request, unless the request has the
 *       {@link #AUTOFILL_FLAG_INCLUDE_NOT_IMPORTANT_VIEWS} flag.
 * </ul>
 *
 * @return whether the view is considered important for autofill.
 *
 * @see #setImportantForAutofill(int)
 * @see #IMPORTANT_FOR_AUTOFILL_AUTO
 * @see #IMPORTANT_FOR_AUTOFILL_YES
 * @see #IMPORTANT_FOR_AUTOFILL_NO
 * @see #IMPORTANT_FOR_AUTOFILL_YES_EXCLUDE_DESCENDANTS
 * @see #IMPORTANT_FOR_AUTOFILL_NO_EXCLUDE_DESCENDANTS
 * @see AutofillManager#requestAutofill(View)
 */

public final boolean isImportantForAutofill() { throw new RuntimeException("Stub!"); }

/**
 * Dispatch creation of {@link ViewStructure} down the hierarchy.  The default
 * implementation calls {@link #onProvideStructure} and
 * {@link #onProvideVirtualStructure}.
 */

public void dispatchProvideStructure(android.view.ViewStructure structure) { throw new RuntimeException("Stub!"); }

/**
 * Dispatches creation of a {@link ViewStructure}s for autofill purposes down the hierarchy,
 * when an Assist structure is being created as part of an autofill request.
 *
 * <p>The default implementation does the following:
 * <ul>
 *   <li>Sets the {@link AutofillId} in the structure.
 *   <li>Calls {@link #onProvideAutofillStructure(ViewStructure, int)}.
 *   <li>Calls {@link #onProvideAutofillVirtualStructure(ViewStructure, int)}.
 * </ul>
 *
 * <p>Typically, this method should only be overridden by subclasses that provide a view
 * hierarchy (such as {@link ViewGroup}) - other classes should override
 * {@link #onProvideAutofillStructure(ViewStructure, int)} or
 * {@link #onProvideAutofillVirtualStructure(ViewStructure, int)} instead.
 *
 * <p>When overridden, it must:
 *
 * <ul>
 *   <li>Either call
 *       {@code super.dispatchProvideAutofillStructure(structure, flags)} or explicitly
 *       set the {@link AutofillId} in the structure (for example, by calling
 *       {@code structure.setAutofillId(getAutofillId())}).
 *   <li>Decide how to handle the {@link #AUTOFILL_FLAG_INCLUDE_NOT_IMPORTANT_VIEWS} flag - when
 *       set, all views in the structure should be considered important for autofill,
 *       regardless of what {@link #isImportantForAutofill()} returns. We encourage you to
 *       respect this flag to provide a better user experience - this flag is typically used
 *       when an user explicitly requested autofill. If the flag is not set,
 *       then only views marked as important for autofill should be included in the
 *       structure - skipping non-important views optimizes the overall autofill performance.
 * </ul>
 *
 * @param structure fill in with structured view data for autofill purposes.
 * This value must never be {@code null}.
 * @param flags optional flags.
 *
 * Value is either <code>0</code> or {@link android.view.View#AUTOFILL_FLAG_INCLUDE_NOT_IMPORTANT_VIEWS}
 * @see #AUTOFILL_FLAG_INCLUDE_NOT_IMPORTANT_VIEWS
 */

public void dispatchProvideAutofillStructure(@androidx.annotation.RecentlyNonNull android.view.ViewStructure structure, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Adds extra data to an {@link AccessibilityNodeInfo} based on an explicit request for the
 * additional data.
 * <p>
 * This method only needs overloading if the node is marked as having extra data available.
 * </p>
 *
 * @param info The info to which to add the extra data. Never {@code null}.
 * This value must never be {@code null}.
 * @param extraDataKey A key specifying the type of extra data to add to the info. The
 *                     extra data should be added to the {@link Bundle} returned by
 *                     the info's {@link AccessibilityNodeInfo#getExtras} method. Never
 *                     {@code null}.
 * This value must never be {@code null}.
 * @param arguments A {@link Bundle} holding any arguments relevant for this request. May be
 *                  {@code null} if the service provided no arguments.
 *
 * This value may be {@code null}.
 * @see AccessibilityNodeInfo#setAvailableExtraData(List)
 */

public void addExtraDataToAccessibilityNodeInfo(@androidx.annotation.RecentlyNonNull android.view.accessibility.AccessibilityNodeInfo info, @androidx.annotation.RecentlyNonNull java.lang.String extraDataKey, @androidx.annotation.RecentlyNullable android.os.Bundle arguments) { throw new RuntimeException("Stub!"); }

/**
 * Computes whether this virtual autofill view is visible to the user.
 *
 * <p><b>Note: </b>By default it returns {@code true}, but views providing a virtual hierarchy
 * view must override it.
 *
 * @return Whether the view is visible on the screen.
 */

public boolean isVisibleToUserForAutofill(int virtualId) { throw new RuntimeException("Stub!"); }

/**
 * Sets a delegate for implementing accessibility support via composition
 * (as opposed to inheritance). For more details, see
 * {@link AccessibilityDelegate}.
 * <p>
 * <strong>Note:</strong> On platform versions prior to
 * {@link android.os.Build.VERSION_CODES#M API 23}, delegate methods on
 * views in the {@code android.widget.*} package are called <i>before</i>
 * host methods. This prevents certain properties such as class name from
 * being modified by overriding
 * {@link AccessibilityDelegate#onInitializeAccessibilityNodeInfo(View, AccessibilityNodeInfo)},
 * as any changes will be overwritten by the host class.
 * <p>
 * Starting in {@link android.os.Build.VERSION_CODES#M API 23}, delegate
 * methods are called <i>after</i> host methods, which all properties to be
 * modified without being overwritten by the host class.
 *
 * @param delegate the object to which accessibility method calls should be
 *                 delegated
 * This value may be {@code null}.
 * @see AccessibilityDelegate
 */

public void setAccessibilityDelegate(@androidx.annotation.RecentlyNullable android.view.View.AccessibilityDelegate delegate) { throw new RuntimeException("Stub!"); }

/**
 * Gets the provider for managing a virtual view hierarchy rooted at this View
 * and reported to {@link android.accessibilityservice.AccessibilityService}s
 * that explore the window content.
 * <p>
 * If this method returns an instance, this instance is responsible for managing
 * {@link AccessibilityNodeInfo}s describing the virtual sub-tree rooted at this
 * View including the one representing the View itself. Similarly the returned
 * instance is responsible for performing accessibility actions on any virtual
 * view or the root view itself.
 * </p>
 * <p>
 * If an {@link AccessibilityDelegate} has been specified via calling
 * {@link #setAccessibilityDelegate(AccessibilityDelegate)} its
 * {@link AccessibilityDelegate#getAccessibilityNodeProvider(View)}
 * is responsible for handling this call.
 * </p>
 *
 * @return The provider.
 *
 * @see AccessibilityNodeProvider
 */

public android.view.accessibility.AccessibilityNodeProvider getAccessibilityNodeProvider() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link View}'s content description.
 * <p>
 * <strong>Note:</strong> Do not override this method, as it will have no
 * effect on the content description presented to accessibility services.
 * You must call {@link #setContentDescription(CharSequence)} to modify the
 * content description.
 *
 * @return the content description
 * @see #setContentDescription(CharSequence)
 * @attr ref android.R.styleable#View_contentDescription
 */

@android.view.ViewDebug.ExportedProperty(category="accessibility") public java.lang.CharSequence getContentDescription() { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link View}'s content description.
 * <p>
 * A content description briefly describes the view and is primarily used
 * for accessibility support to determine how a view should be presented to
 * the user. In the case of a view with no textual representation, such as
 * {@link android.widget.ImageButton}, a useful content description
 * explains what the view does. For example, an image button with a phone
 * icon that is used to place a call may use "Call" as its content
 * description. An image of a floppy disk that is used to save a file may
 * use "Save".
 *
 * @param contentDescription The content description.
 * @see #getContentDescription()
 * @attr ref android.R.styleable#View_contentDescription
 */

public void setContentDescription(java.lang.CharSequence contentDescription) { throw new RuntimeException("Stub!"); }

/**
 * Sets the id of a view before which this one is visited in accessibility traversal.
 * A screen-reader must visit the content of this view before the content of the one
 * it precedes. For example, if view B is set to be before view A, then a screen-reader
 * will traverse the entire content of B before traversing the entire content of A,
 * regardles of what traversal strategy it is using.
 * <p>
 * Views that do not have specified before/after relationships are traversed in order
 * determined by the screen-reader.
 * </p>
 * <p>
 * Setting that this view is before a view that is not important for accessibility
 * or if this view is not important for accessibility will have no effect as the
 * screen-reader is not aware of unimportant views.
 * </p>
 *
 * @param beforeId The id of a view this one precedes in accessibility traversal.
 *
 * @attr ref android.R.styleable#View_accessibilityTraversalBefore
 *
 * @see #setImportantForAccessibility(int)
 */

public void setAccessibilityTraversalBefore(int beforeId) { throw new RuntimeException("Stub!"); }

/**
 * Gets the id of a view before which this one is visited in accessibility traversal.
 *
 * @return The id of a view this one precedes in accessibility traversal if
 *         specified, otherwise {@link #NO_ID}.
 *
 * @see #setAccessibilityTraversalBefore(int)
 */

public int getAccessibilityTraversalBefore() { throw new RuntimeException("Stub!"); }

/**
 * Sets the id of a view after which this one is visited in accessibility traversal.
 * A screen-reader must visit the content of the other view before the content of this
 * one. For example, if view B is set to be after view A, then a screen-reader
 * will traverse the entire content of A before traversing the entire content of B,
 * regardles of what traversal strategy it is using.
 * <p>
 * Views that do not have specified before/after relationships are traversed in order
 * determined by the screen-reader.
 * </p>
 * <p>
 * Setting that this view is after a view that is not important for accessibility
 * or if this view is not important for accessibility will have no effect as the
 * screen-reader is not aware of unimportant views.
 * </p>
 *
 * @param afterId The id of a view this one succedees in accessibility traversal.
 *
 * @attr ref android.R.styleable#View_accessibilityTraversalAfter
 *
 * @see #setImportantForAccessibility(int)
 */

public void setAccessibilityTraversalAfter(int afterId) { throw new RuntimeException("Stub!"); }

/**
 * Gets the id of a view after which this one is visited in accessibility traversal.
 *
 * @return The id of a view this one succeedes in accessibility traversal if
 *         specified, otherwise {@link #NO_ID}.
 *
 * @see #setAccessibilityTraversalAfter(int)
 */

public int getAccessibilityTraversalAfter() { throw new RuntimeException("Stub!"); }

/**
 * Gets the id of a view for which this view serves as a label for
 * accessibility purposes.
 *
 * @return The labeled view id.
 */

@android.view.ViewDebug.ExportedProperty(category="accessibility") public int getLabelFor() { throw new RuntimeException("Stub!"); }

/**
 * Sets the id of a view for which this view serves as a label for
 * accessibility purposes.
 *
 * @param id The labeled view id.
 */

public void setLabelFor(int id) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this view has focus
 *
 * @return True if this view has focus, false otherwise.
 */

@android.view.ViewDebug.ExportedProperty(category="focus") public boolean isFocused() { throw new RuntimeException("Stub!"); }

/**
 * Find the view in the hierarchy rooted at this view that currently has
 * focus.
 *
 * @return The view that currently has focus, or null if no focused view can
 *         be found.
 */

public android.view.View findFocus() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether this view is one of the set of scrollable containers in
 * its window.
 *
 * @return whether this view is one of the set of scrollable containers in
 * its window
 *
 * @attr ref android.R.styleable#View_isScrollContainer
 */

public boolean isScrollContainer() { throw new RuntimeException("Stub!"); }

/**
 * Change whether this view is one of the set of scrollable containers in
 * its window.  This will be used to determine whether the window can
 * resize or must pan when a soft input area is open -- scrollable
 * containers allow the window to use resize mode since the container
 * will appropriately shrink.
 *
 * @attr ref android.R.styleable#View_isScrollContainer
 */

public void setScrollContainer(boolean isScrollContainer) { throw new RuntimeException("Stub!"); }

/**
 * Returns the quality of the drawing cache.
 *
 * @return One of {@link #DRAWING_CACHE_QUALITY_AUTO},
 *         {@link #DRAWING_CACHE_QUALITY_LOW}, or {@link #DRAWING_CACHE_QUALITY_HIGH}
 *
 * Value is {@link android.view.View#DRAWING_CACHE_QUALITY_LOW}, {@link android.view.View#DRAWING_CACHE_QUALITY_HIGH}, or {@link android.view.View#DRAWING_CACHE_QUALITY_AUTO}
 * @see #setDrawingCacheQuality(int)
 * @see #setDrawingCacheEnabled(boolean)
 * @see #isDrawingCacheEnabled()
 *
 * @attr ref android.R.styleable#View_drawingCacheQuality
 *
 * @deprecated The view drawing cache was largely made obsolete with the introduction of
 * hardware-accelerated rendering in API 11. With hardware-acceleration, intermediate cache
 * layers are largely unnecessary and can easily result in a net loss in performance due to the
 * cost of creating and updating the layer. In the rare cases where caching layers are useful,
 * such as for alpha animations, {@link #setLayerType(int, Paint)} handles this with hardware
 * rendering. For software-rendered snapshots of a small part of the View hierarchy or
 * individual Views it is recommended to create a {@link Canvas} from either a {@link Bitmap} or
 * {@link android.graphics.Picture} and call {@link #draw(Canvas)} on the View. However these
 * software-rendered usages are discouraged and have compatibility issues with hardware-only
 * rendering features such as {@link android.graphics.Bitmap.Config#HARDWARE Config.HARDWARE}
 * bitmaps, real-time shadows, and outline clipping. For screenshots of the UI for feedback
 * reports or unit testing the {@link PixelCopy} API is recommended.
 */

@Deprecated public int getDrawingCacheQuality() { throw new RuntimeException("Stub!"); }

/**
 * Set the drawing cache quality of this view. This value is used only when the
 * drawing cache is enabled
 *
 * @param quality One of {@link #DRAWING_CACHE_QUALITY_AUTO},
 *        {@link #DRAWING_CACHE_QUALITY_LOW}, or {@link #DRAWING_CACHE_QUALITY_HIGH}
 *
 * Value is {@link android.view.View#DRAWING_CACHE_QUALITY_LOW}, {@link android.view.View#DRAWING_CACHE_QUALITY_HIGH}, or {@link android.view.View#DRAWING_CACHE_QUALITY_AUTO}
 * @see #getDrawingCacheQuality()
 * @see #setDrawingCacheEnabled(boolean)
 * @see #isDrawingCacheEnabled()
 *
 * @attr ref android.R.styleable#View_drawingCacheQuality
 *
 * @deprecated The view drawing cache was largely made obsolete with the introduction of
 * hardware-accelerated rendering in API 11. With hardware-acceleration, intermediate cache
 * layers are largely unnecessary and can easily result in a net loss in performance due to the
 * cost of creating and updating the layer. In the rare cases where caching layers are useful,
 * such as for alpha animations, {@link #setLayerType(int, Paint)} handles this with hardware
 * rendering. For software-rendered snapshots of a small part of the View hierarchy or
 * individual Views it is recommended to create a {@link Canvas} from either a {@link Bitmap} or
 * {@link android.graphics.Picture} and call {@link #draw(Canvas)} on the View. However these
 * software-rendered usages are discouraged and have compatibility issues with hardware-only
 * rendering features such as {@link android.graphics.Bitmap.Config#HARDWARE Config.HARDWARE}
 * bitmaps, real-time shadows, and outline clipping. For screenshots of the UI for feedback
 * reports or unit testing the {@link PixelCopy} API is recommended.
 */

@Deprecated public void setDrawingCacheQuality(int quality) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the screen should remain on, corresponding to the current
 * value of {@link #KEEP_SCREEN_ON}.
 *
 * @return Returns true if {@link #KEEP_SCREEN_ON} is set.
 *
 * @see #setKeepScreenOn(boolean)
 *
 * @attr ref android.R.styleable#View_keepScreenOn
 */

public boolean getKeepScreenOn() { throw new RuntimeException("Stub!"); }

/**
 * Controls whether the screen should remain on, modifying the
 * value of {@link #KEEP_SCREEN_ON}.
 *
 * @param keepScreenOn Supply true to set {@link #KEEP_SCREEN_ON}.
 *
 * @see #getKeepScreenOn()
 *
 * @attr ref android.R.styleable#View_keepScreenOn
 */

public void setKeepScreenOn(boolean keepScreenOn) { throw new RuntimeException("Stub!"); }

/**
 * Gets the id of the view to use when the next focus is {@link #FOCUS_LEFT}.
 * @return The next focus ID, or {@link #NO_ID} if the framework should decide automatically.
 *
 * @attr ref android.R.styleable#View_nextFocusLeft
 */

public int getNextFocusLeftId() { throw new RuntimeException("Stub!"); }

/**
 * Sets the id of the view to use when the next focus is {@link #FOCUS_LEFT}.
 * @param nextFocusLeftId The next focus ID, or {@link #NO_ID} if the framework should
 * decide automatically.
 *
 * @attr ref android.R.styleable#View_nextFocusLeft
 */

public void setNextFocusLeftId(int nextFocusLeftId) { throw new RuntimeException("Stub!"); }

/**
 * Gets the id of the view to use when the next focus is {@link #FOCUS_RIGHT}.
 * @return The next focus ID, or {@link #NO_ID} if the framework should decide automatically.
 *
 * @attr ref android.R.styleable#View_nextFocusRight
 */

public int getNextFocusRightId() { throw new RuntimeException("Stub!"); }

/**
 * Sets the id of the view to use when the next focus is {@link #FOCUS_RIGHT}.
 * @param nextFocusRightId The next focus ID, or {@link #NO_ID} if the framework should
 * decide automatically.
 *
 * @attr ref android.R.styleable#View_nextFocusRight
 */

public void setNextFocusRightId(int nextFocusRightId) { throw new RuntimeException("Stub!"); }

/**
 * Gets the id of the view to use when the next focus is {@link #FOCUS_UP}.
 * @return The next focus ID, or {@link #NO_ID} if the framework should decide automatically.
 *
 * @attr ref android.R.styleable#View_nextFocusUp
 */

public int getNextFocusUpId() { throw new RuntimeException("Stub!"); }

/**
 * Sets the id of the view to use when the next focus is {@link #FOCUS_UP}.
 * @param nextFocusUpId The next focus ID, or {@link #NO_ID} if the framework should
 * decide automatically.
 *
 * @attr ref android.R.styleable#View_nextFocusUp
 */

public void setNextFocusUpId(int nextFocusUpId) { throw new RuntimeException("Stub!"); }

/**
 * Gets the id of the view to use when the next focus is {@link #FOCUS_DOWN}.
 * @return The next focus ID, or {@link #NO_ID} if the framework should decide automatically.
 *
 * @attr ref android.R.styleable#View_nextFocusDown
 */

public int getNextFocusDownId() { throw new RuntimeException("Stub!"); }

/**
 * Sets the id of the view to use when the next focus is {@link #FOCUS_DOWN}.
 * @param nextFocusDownId The next focus ID, or {@link #NO_ID} if the framework should
 * decide automatically.
 *
 * @attr ref android.R.styleable#View_nextFocusDown
 */

public void setNextFocusDownId(int nextFocusDownId) { throw new RuntimeException("Stub!"); }

/**
 * Gets the id of the view to use when the next focus is {@link #FOCUS_FORWARD}.
 * @return The next focus ID, or {@link #NO_ID} if the framework should decide automatically.
 *
 * @attr ref android.R.styleable#View_nextFocusForward
 */

public int getNextFocusForwardId() { throw new RuntimeException("Stub!"); }

/**
 * Sets the id of the view to use when the next focus is {@link #FOCUS_FORWARD}.
 * @param nextFocusForwardId The next focus ID, or {@link #NO_ID} if the framework should
 * decide automatically.
 *
 * @attr ref android.R.styleable#View_nextFocusForward
 */

public void setNextFocusForwardId(int nextFocusForwardId) { throw new RuntimeException("Stub!"); }

/**
 * Gets the id of the root of the next keyboard navigation cluster.
 * @return The next keyboard navigation cluster ID, or {@link #NO_ID} if the framework should
 * decide automatically.
 *
 * @attr ref android.R.styleable#View_nextClusterForward
 */

public int getNextClusterForwardId() { throw new RuntimeException("Stub!"); }

/**
 * Sets the id of the view to use as the root of the next keyboard navigation cluster.
 * @param nextClusterForwardId The next cluster ID, or {@link #NO_ID} if the framework should
 * decide automatically.
 *
 * @attr ref android.R.styleable#View_nextClusterForward
 */

public void setNextClusterForwardId(int nextClusterForwardId) { throw new RuntimeException("Stub!"); }

/**
 * Returns the visibility of this view and all of its ancestors
 *
 * @return True if this view and all of its ancestors are {@link #VISIBLE}
 */

public boolean isShown() { throw new RuntimeException("Stub!"); }

/**
 * Called by the view hierarchy when the content insets for a window have
 * changed, to allow it to adjust its content to fit within those windows.
 * The content insets tell you the space that the status bar, input method,
 * and other system windows infringe on the application's window.
 *
 * <p>You do not normally need to deal with this function, since the default
 * window decoration given to applications takes care of applying it to the
 * content of the window.  If you use {@link #SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN}
 * or {@link #SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION} this will not be the case,
 * and your content can be placed under those system elements.  You can then
 * use this method within your view hierarchy if you have parts of your UI
 * which you would like to ensure are not being covered.
 *
 * <p>The default implementation of this method simply applies the content
 * insets to the view's padding, consuming that content (modifying the
 * insets to be 0), and returning true.  This behavior is off by default, but can
 * be enabled through {@link #setFitsSystemWindows(boolean)}.
 *
 * <p>This function's traversal down the hierarchy is depth-first.  The same content
 * insets object is propagated down the hierarchy, so any changes made to it will
 * be seen by all following views (including potentially ones above in
 * the hierarchy since this is a depth-first traversal).  The first view
 * that returns true will abort the entire traversal.
 *
 * <p>The default implementation works well for a situation where it is
 * used with a container that covers the entire window, allowing it to
 * apply the appropriate insets to its content on all edges.  If you need
 * a more complicated layout (such as two different views fitting system
 * windows, one on the top of the window, and one on the bottom),
 * you can override the method and handle the insets however you would like.
 * Note that the insets provided by the framework are always relative to the
 * far edges of the window, not accounting for the location of the called view
 * within that window.  (In fact when this method is called you do not yet know
 * where the layout will place the view, as it is done before layout happens.)
 *
 * <p>Note: unlike many View methods, there is no dispatch phase to this
 * call.  If you are overriding it in a ViewGroup and want to allow the
 * call to continue to your children, you must be sure to call the super
 * implementation.
 *
 * <p>Here is a sample layout that makes use of fitting system windows
 * to have controls for a video view placed inside of the window decorations
 * that it hides and shows.  This can be used with code like the second
 * sample (video player) shown in {@link #setSystemUiVisibility(int)}.
 *
 * {@sample development/samples/ApiDemos/res/layout/video_player.xml complete}
 *
 * @param insets Current content insets of the window.  Prior to
 * {@link android.os.Build.VERSION_CODES#JELLY_BEAN} you must not modify
 * the insets or else you and Android will be unhappy.
 *
 * @return {@code true} if this view applied the insets and it should not
 * continue propagating further down the hierarchy, {@code false} otherwise.
 * @see #getFitsSystemWindows()
 * @see #setFitsSystemWindows(boolean)
 * @see #setSystemUiVisibility(int)
 *
 * @deprecated As of API 20 use {@link #dispatchApplyWindowInsets(WindowInsets)} to apply
 * insets to views. Views should override {@link #onApplyWindowInsets(WindowInsets)} or use
 * {@link #setOnApplyWindowInsetsListener(android.view.View.OnApplyWindowInsetsListener)}
 * to implement handling their own insets.
 */

@Deprecated protected boolean fitSystemWindows(android.graphics.Rect insets) { throw new RuntimeException("Stub!"); }

/**
 * Called when the view should apply {@link WindowInsets} according to its internal policy.
 *
 * <p>This method should be overridden by views that wish to apply a policy different from or
 * in addition to the default behavior. Clients that wish to force a view subtree
 * to apply insets should call {@link #dispatchApplyWindowInsets(WindowInsets)}.</p>
 *
 * <p>Clients may supply an {@link OnApplyWindowInsetsListener} to a view. If one is set
 * it will be called during dispatch instead of this method. The listener may optionally
 * call this method from its own implementation if it wishes to apply the view's default
 * insets policy in addition to its own.</p>
 *
 * <p>Implementations of this method should either return the insets parameter unchanged
 * or a new {@link WindowInsets} cloned from the supplied insets with any insets consumed
 * that this view applied itself. This allows new inset types added in future platform
 * versions to pass through existing implementations unchanged without being erroneously
 * consumed.</p>
 *
 * <p>By default if a view's {@link #setFitsSystemWindows(boolean) fitsSystemWindows}
 * property is set then the view will consume the system window insets and apply them
 * as padding for the view.</p>
 *
 * @param insets Insets to apply
 * @return The supplied insets with any applied insets consumed
 */

public android.view.WindowInsets onApplyWindowInsets(android.view.WindowInsets insets) { throw new RuntimeException("Stub!"); }

/**
 * Set an {@link OnApplyWindowInsetsListener} to take over the policy for applying
 * window insets to this view. The listener's
 * {@link OnApplyWindowInsetsListener#onApplyWindowInsets(View, WindowInsets) onApplyWindowInsets}
 * method will be called instead of the view's
 * {@link #onApplyWindowInsets(WindowInsets) onApplyWindowInsets} method.
 *
 * @param listener Listener to set
 *
 * @see #onApplyWindowInsets(WindowInsets)
 */

public void setOnApplyWindowInsetsListener(android.view.View.OnApplyWindowInsetsListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Request to apply the given window insets to this view or another view in its subtree.
 *
 * <p>This method should be called by clients wishing to apply insets corresponding to areas
 * obscured by window decorations or overlays. This can include the status and navigation bars,
 * action bars, input methods and more. New inset categories may be added in the future.
 * The method returns the insets provided minus any that were applied by this view or its
 * children.</p>
 *
 * <p>Clients wishing to provide custom behavior should override the
 * {@link #onApplyWindowInsets(WindowInsets)} method or alternatively provide a
 * {@link OnApplyWindowInsetsListener} via the
 * {@link #setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener) setOnApplyWindowInsetsListener}
 * method.</p>
 *
 * <p>This method replaces the older {@link #fitSystemWindows(Rect) fitSystemWindows} method.
 * </p>
 *
 * @param insets Insets to apply
 * @return The provided insets minus the insets that were consumed
 */

public android.view.WindowInsets dispatchApplyWindowInsets(android.view.WindowInsets insets) { throw new RuntimeException("Stub!"); }

/**
 * Provide original WindowInsets that are dispatched to the view hierarchy. The insets are
 * only available if the view is attached.
 *
 * @return WindowInsets from the top of the view hierarchy or null if View is detached
 */

public android.view.WindowInsets getRootWindowInsets() { throw new RuntimeException("Stub!"); }

/**
 * Compute insets that should be consumed by this view and the ones that should propagate
 * to those under it.
 *
 * @param in Insets currently being processed by this View, likely received as a parameter
 *           to {@link #onApplyWindowInsets(WindowInsets)}.
 * @param outLocalInsets A Rect that will receive the insets that should be consumed
 *                       by this view
 * @return Insets that should be passed along to views under this one
 */

public android.view.WindowInsets computeSystemWindowInsets(android.view.WindowInsets in, android.graphics.Rect outLocalInsets) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether or not this view should account for system screen decorations
 * such as the status bar and inset its content; that is, controlling whether
 * the default implementation of {@link #fitSystemWindows(Rect)} will be
 * executed.  See that method for more details.
 *
 * <p>Note that if you are providing your own implementation of
 * {@link #fitSystemWindows(Rect)}, then there is no need to set this
 * flag to true -- your implementation will be overriding the default
 * implementation that checks this flag.
 *
 * @param fitSystemWindows If true, then the default implementation of
 * {@link #fitSystemWindows(Rect)} will be executed.
 *
 * @attr ref android.R.styleable#View_fitsSystemWindows
 * @see #getFitsSystemWindows()
 * @see #fitSystemWindows(Rect)
 * @see #setSystemUiVisibility(int)
 */

public void setFitsSystemWindows(boolean fitSystemWindows) { throw new RuntimeException("Stub!"); }

/**
 * Check for state of {@link #setFitsSystemWindows(boolean)}. If this method
 * returns {@code true}, the default implementation of {@link #fitSystemWindows(Rect)}
 * will be executed.
 *
 * @return {@code true} if the default implementation of
 * {@link #fitSystemWindows(Rect)} will be executed.
 *
 * @attr ref android.R.styleable#View_fitsSystemWindows
 * @see #setFitsSystemWindows(boolean)
 * @see #fitSystemWindows(Rect)
 * @see #setSystemUiVisibility(int)
 */

@android.view.ViewDebug.ExportedProperty public boolean getFitsSystemWindows() { throw new RuntimeException("Stub!"); }

/**
 * Ask that a new dispatch of {@link #fitSystemWindows(Rect)} be performed.
 * @deprecated Use {@link #requestApplyInsets()} for newer platform versions.
 */

@Deprecated public void requestFitSystemWindows() { throw new RuntimeException("Stub!"); }

/**
 * Ask that a new dispatch of {@link #onApplyWindowInsets(WindowInsets)} be performed.
 */

public void requestApplyInsets() { throw new RuntimeException("Stub!"); }

/**
 * Returns the visibility status for this view.
 *
 * @return One of {@link #VISIBLE}, {@link #INVISIBLE}, or {@link #GONE}.
 * Value is {@link android.view.View#VISIBLE}, {@link android.view.View#INVISIBLE}, or {@link android.view.View#GONE}
 * @attr ref android.R.styleable#View_visibility
 */

@android.view.ViewDebug.ExportedProperty(mapping={@android.view.ViewDebug.IntToString(from=android.view.View.VISIBLE, to="VISIBLE"), @android.view.ViewDebug.IntToString(from=android.view.View.INVISIBLE, to="INVISIBLE"), @android.view.ViewDebug.IntToString(from=android.view.View.GONE, to="GONE")}) public int getVisibility() { throw new RuntimeException("Stub!"); }

/**
 * Set the visibility state of this view.
 *
 * @param visibility One of {@link #VISIBLE}, {@link #INVISIBLE}, or {@link #GONE}.
 * Value is {@link android.view.View#VISIBLE}, {@link android.view.View#INVISIBLE}, or {@link android.view.View#GONE}
 * @attr ref android.R.styleable#View_visibility
 */

public void setVisibility(int visibility) { throw new RuntimeException("Stub!"); }

/**
 * Returns the enabled status for this view. The interpretation of the
 * enabled state varies by subclass.
 *
 * @return True if this view is enabled, false otherwise.
 */

@android.view.ViewDebug.ExportedProperty public boolean isEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Set the enabled state of this view. The interpretation of the enabled
 * state varies by subclass.
 *
 * @param enabled True if this view is enabled, false otherwise.
 */

public void setEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Set whether this view can receive the focus.
 * <p>
 * Setting this to false will also ensure that this view is not focusable
 * in touch mode.
 *
 * @param focusable If true, this view can receive the focus.
 *
 * @see #setFocusableInTouchMode(boolean)
 * @see #setFocusable(int)
 * @attr ref android.R.styleable#View_focusable
 */

public void setFocusable(boolean focusable) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this view can receive focus.
 * <p>
 * Setting this to {@link #FOCUSABLE_AUTO} tells the framework to determine focusability
 * automatically based on the view's interactivity. This is the default.
 * <p>
 * Setting this to NOT_FOCUSABLE will ensure that this view is also not focusable
 * in touch mode.
 *
 * @param focusable One of {@link #NOT_FOCUSABLE}, {@link #FOCUSABLE},
 *                  or {@link #FOCUSABLE_AUTO}.
 * Value is {@link android.view.View#NOT_FOCUSABLE}, {@link android.view.View#FOCUSABLE}, or {@link android.view.View#FOCUSABLE_AUTO}
 * @see #setFocusableInTouchMode(boolean)
 * @attr ref android.R.styleable#View_focusable
 */

public void setFocusable(int focusable) { throw new RuntimeException("Stub!"); }

/**
 * Set whether this view can receive focus while in touch mode.
 *
 * Setting this to true will also ensure that this view is focusable.
 *
 * @param focusableInTouchMode If true, this view can receive the focus while
 *   in touch mode.
 *
 * @see #setFocusable(boolean)
 * @attr ref android.R.styleable#View_focusableInTouchMode
 */

public void setFocusableInTouchMode(boolean focusableInTouchMode) { throw new RuntimeException("Stub!"); }

/**
 * Sets the hints that help an {@link android.service.autofill.AutofillService} determine how
 * to autofill the view with the user's data.
 *
 * <p>Typically, there is only one way to autofill a view, but there could be more than one.
 * For example, if the application accepts either an username or email address to identify
 * an user.
 *
 * <p>These hints are not validated by the Android System, but passed "as is" to the service.
 * Hence, they can have any value, but it's recommended to use the {@code AUTOFILL_HINT_}
 * constants such as:
 * {@link #AUTOFILL_HINT_USERNAME}, {@link #AUTOFILL_HINT_PASSWORD},
 * {@link #AUTOFILL_HINT_EMAIL_ADDRESS},
 * {@link #AUTOFILL_HINT_NAME},
 * {@link #AUTOFILL_HINT_PHONE},
 * {@link #AUTOFILL_HINT_POSTAL_ADDRESS}, {@link #AUTOFILL_HINT_POSTAL_CODE},
 * {@link #AUTOFILL_HINT_CREDIT_CARD_NUMBER}, {@link #AUTOFILL_HINT_CREDIT_CARD_SECURITY_CODE},
 * {@link #AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DATE},
 * {@link #AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DAY},
 * {@link #AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_MONTH} or
 * {@link #AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_YEAR}.
 *
 * @param autofillHints The autofill hints to set. If the array is emtpy, {@code null} is set.
 * This value may be {@code null}.
 * @attr ref android.R.styleable#View_autofillHints
 */

public void setAutofillHints(@androidx.annotation.RecentlyNullable java.lang.String... autofillHints) { throw new RuntimeException("Stub!"); }

/**
 * Set whether this view should have sound effects enabled for events such as
 * clicking and touching.
 *
 * <p>You may wish to disable sound effects for a view if you already play sounds,
 * for instance, a dial key that plays dtmf tones.
 *
 * @param soundEffectsEnabled whether sound effects are enabled for this view.
 * @see #isSoundEffectsEnabled()
 * @see #playSoundEffect(int)
 * @attr ref android.R.styleable#View_soundEffectsEnabled
 */

public void setSoundEffectsEnabled(boolean soundEffectsEnabled) { throw new RuntimeException("Stub!"); }

/**
 * @return whether this view should have sound effects enabled for events such as
 *     clicking and touching.
 *
 * @see #setSoundEffectsEnabled(boolean)
 * @see #playSoundEffect(int)
 * @attr ref android.R.styleable#View_soundEffectsEnabled
 */

@android.view.ViewDebug.ExportedProperty public boolean isSoundEffectsEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Set whether this view should have haptic feedback for events such as
 * long presses.
 *
 * <p>You may wish to disable haptic feedback if your view already controls
 * its own haptic feedback.
 *
 * @param hapticFeedbackEnabled whether haptic feedback enabled for this view.
 * @see #isHapticFeedbackEnabled()
 * @see #performHapticFeedback(int)
 * @attr ref android.R.styleable#View_hapticFeedbackEnabled
 */

public void setHapticFeedbackEnabled(boolean hapticFeedbackEnabled) { throw new RuntimeException("Stub!"); }

/**
 * @return whether this view should have haptic feedback enabled for events
 * long presses.
 *
 * @see #setHapticFeedbackEnabled(boolean)
 * @see #performHapticFeedback(int)
 * @attr ref android.R.styleable#View_hapticFeedbackEnabled
 */

@android.view.ViewDebug.ExportedProperty public boolean isHapticFeedbackEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Set the layout direction for this view. This will propagate a reset of layout direction
 * resolution to the view's children and resolve layout direction for this view.
 *
 * @param layoutDirection the layout direction to set. Should be one of:
 *
 * {@link #LAYOUT_DIRECTION_LTR},
 * {@link #LAYOUT_DIRECTION_RTL},
 * {@link #LAYOUT_DIRECTION_INHERIT},
 * {@link #LAYOUT_DIRECTION_LOCALE}.
 *
 * Resolution will be done if the value is set to LAYOUT_DIRECTION_INHERIT. The resolution
 * proceeds up the parent chain of the view to get the value. If there is no parent, then it
 * will return the default {@link #LAYOUT_DIRECTION_LTR}.
 *
 * Value is {@link android.view.View#LAYOUT_DIRECTION_LTR}, {@link android.view.View#LAYOUT_DIRECTION_RTL}, {@link android.view.View#LAYOUT_DIRECTION_INHERIT}, or {@link android.view.View#LAYOUT_DIRECTION_LOCALE}
 * @attr ref android.R.styleable#View_layoutDirection
 */

public void setLayoutDirection(int layoutDirection) { throw new RuntimeException("Stub!"); }

/**
 * Returns the resolved layout direction for this view.
 *
 * @return {@link #LAYOUT_DIRECTION_RTL} if the layout direction is RTL or returns
 * {@link #LAYOUT_DIRECTION_LTR} if the layout direction is not RTL.
 *
 * For compatibility, this will return {@link #LAYOUT_DIRECTION_LTR} if API version
 * is lower than {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR1}.
 *
 * Value is {@link android.view.View#LAYOUT_DIRECTION_LTR}, or {@link android.view.View#LAYOUT_DIRECTION_RTL}
 * @attr ref android.R.styleable#View_layoutDirection
 */

@android.view.ViewDebug.ExportedProperty(category="layout", mapping={@android.view.ViewDebug.IntToString(from=android.view.View.LAYOUT_DIRECTION_LTR, to="RESOLVED_DIRECTION_LTR"), @android.view.ViewDebug.IntToString(from=android.view.View.LAYOUT_DIRECTION_RTL, to="RESOLVED_DIRECTION_RTL")}) public int getLayoutDirection() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the view is currently tracking transient state that the
 * app should not need to concern itself with saving and restoring, but that
 * the framework should take special note to preserve when possible.
 *
 * <p>A view with transient state cannot be trivially rebound from an external
 * data source, such as an adapter binding item views in a list. This may be
 * because the view is performing an animation, tracking user selection
 * of content, or similar.</p>
 *
 * @return true if the view has transient state
 */

@android.view.ViewDebug.ExportedProperty(category="layout") public boolean hasTransientState() { throw new RuntimeException("Stub!"); }

/**
 * Set whether this view is currently tracking transient state that the
 * framework should attempt to preserve when possible. This flag is reference counted,
 * so every call to setHasTransientState(true) should be paired with a later call
 * to setHasTransientState(false).
 *
 * <p>A view with transient state cannot be trivially rebound from an external
 * data source, such as an adapter binding item views in a list. This may be
 * because the view is performing an animation, tracking user selection
 * of content, or similar.</p>
 *
 * @param hasTransientState true if this view has transient state
 */

public void setHasTransientState(boolean hasTransientState) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this view is currently attached to a window.
 */

public boolean isAttachedToWindow() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this view has been through at least one layout since it
 * was last attached to or detached from a window.
 */

public boolean isLaidOut() { throw new RuntimeException("Stub!"); }

/**
 * If this view doesn't do any drawing on its own, set this flag to
 * allow further optimizations. By default, this flag is not set on
 * View, but could be set on some View subclasses such as ViewGroup.
 *
 * Typically, if you override {@link #onDraw(android.graphics.Canvas)}
 * you should clear this flag.
 *
 * @param willNotDraw whether or not this View draw on its own
 */

public void setWillNotDraw(boolean willNotDraw) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether or not this View draws on its own.
 *
 * @return true if this view has nothing to draw, false otherwise
 */

@android.view.ViewDebug.ExportedProperty(category="drawing") public boolean willNotDraw() { throw new RuntimeException("Stub!"); }

/**
 * When a View's drawing cache is enabled, drawing is redirected to an
 * offscreen bitmap. Some views, like an ImageView, must be able to
 * bypass this mechanism if they already draw a single bitmap, to avoid
 * unnecessary usage of the memory.
 *
 * @param willNotCacheDrawing true if this view does not cache its
 *        drawing, false otherwise
 *
 * @deprecated The view drawing cache was largely made obsolete with the introduction of
 * hardware-accelerated rendering in API 11. With hardware-acceleration, intermediate cache
 * layers are largely unnecessary and can easily result in a net loss in performance due to the
 * cost of creating and updating the layer. In the rare cases where caching layers are useful,
 * such as for alpha animations, {@link #setLayerType(int, Paint)} handles this with hardware
 * rendering. For software-rendered snapshots of a small part of the View hierarchy or
 * individual Views it is recommended to create a {@link Canvas} from either a {@link Bitmap} or
 * {@link android.graphics.Picture} and call {@link #draw(Canvas)} on the View. However these
 * software-rendered usages are discouraged and have compatibility issues with hardware-only
 * rendering features such as {@link android.graphics.Bitmap.Config#HARDWARE Config.HARDWARE}
 * bitmaps, real-time shadows, and outline clipping. For screenshots of the UI for feedback
 * reports or unit testing the {@link PixelCopy} API is recommended.
 */

@Deprecated public void setWillNotCacheDrawing(boolean willNotCacheDrawing) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether or not this View can cache its drawing or not.
 *
 * @return true if this view does not cache its drawing, false otherwise
 *
 * @deprecated The view drawing cache was largely made obsolete with the introduction of
 * hardware-accelerated rendering in API 11. With hardware-acceleration, intermediate cache
 * layers are largely unnecessary and can easily result in a net loss in performance due to the
 * cost of creating and updating the layer. In the rare cases where caching layers are useful,
 * such as for alpha animations, {@link #setLayerType(int, Paint)} handles this with hardware
 * rendering. For software-rendered snapshots of a small part of the View hierarchy or
 * individual Views it is recommended to create a {@link Canvas} from either a {@link Bitmap} or
 * {@link android.graphics.Picture} and call {@link #draw(Canvas)} on the View. However these
 * software-rendered usages are discouraged and have compatibility issues with hardware-only
 * rendering features such as {@link android.graphics.Bitmap.Config#HARDWARE Config.HARDWARE}
 * bitmaps, real-time shadows, and outline clipping. For screenshots of the UI for feedback
 * reports or unit testing the {@link PixelCopy} API is recommended.
 */

@Deprecated @android.view.ViewDebug.ExportedProperty(category="drawing") public boolean willNotCacheDrawing() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether this view reacts to click events or not.
 *
 * @return true if the view is clickable, false otherwise
 *
 * @see #setClickable(boolean)
 * @attr ref android.R.styleable#View_clickable
 */

@android.view.ViewDebug.ExportedProperty public boolean isClickable() { throw new RuntimeException("Stub!"); }

/**
 * Enables or disables click events for this view. When a view
 * is clickable it will change its state to "pressed" on every click.
 * Subclasses should set the view clickable to visually react to
 * user's clicks.
 *
 * @param clickable true to make the view clickable, false otherwise
 *
 * @see #isClickable()
 * @attr ref android.R.styleable#View_clickable
 */

public void setClickable(boolean clickable) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether this view reacts to long click events or not.
 *
 * @return true if the view is long clickable, false otherwise
 *
 * @see #setLongClickable(boolean)
 * @attr ref android.R.styleable#View_longClickable
 */

public boolean isLongClickable() { throw new RuntimeException("Stub!"); }

/**
 * Enables or disables long click events for this view. When a view is long
 * clickable it reacts to the user holding down the button for a longer
 * duration than a tap. This event can either launch the listener or a
 * context menu.
 *
 * @param longClickable true to make the view long clickable, false otherwise
 * @see #isLongClickable()
 * @attr ref android.R.styleable#View_longClickable
 */

public void setLongClickable(boolean longClickable) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether this view reacts to context clicks or not.
 *
 * @return true if the view is context clickable, false otherwise
 * @see #setContextClickable(boolean)
 * @attr ref android.R.styleable#View_contextClickable
 */

public boolean isContextClickable() { throw new RuntimeException("Stub!"); }

/**
 * Enables or disables context clicking for this view. This event can launch the listener.
 *
 * @param contextClickable true to make the view react to a context click, false otherwise
 * @see #isContextClickable()
 * @attr ref android.R.styleable#View_contextClickable
 */

public void setContextClickable(boolean contextClickable) { throw new RuntimeException("Stub!"); }

/**
 * Sets the pressed state for this view.
 *
 * @see #isClickable()
 * @see #setClickable(boolean)
 *
 * @param pressed Pass true to set the View's internal state to "pressed", or false to reverts
 *        the View's internal state from a previously set "pressed" state.
 */

public void setPressed(boolean pressed) { throw new RuntimeException("Stub!"); }

/**
 * Dispatch setPressed to all of this View's children.
 *
 * @see #setPressed(boolean)
 *
 * @param pressed The new pressed state
 */

protected void dispatchSetPressed(boolean pressed) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the view is currently in pressed state. Unless
 * {@link #setPressed(boolean)} is explicitly called, only clickable views can enter
 * the pressed state.
 *
 * @see #setPressed(boolean)
 * @see #isClickable()
 * @see #setClickable(boolean)
 *
 * @return true if the view is currently pressed, false otherwise
 */

@android.view.ViewDebug.ExportedProperty public boolean isPressed() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether this view will save its state (that is,
 * whether its {@link #onSaveInstanceState} method will be called).
 *
 * @return Returns true if the view state saving is enabled, else false.
 *
 * @see #setSaveEnabled(boolean)
 * @attr ref android.R.styleable#View_saveEnabled
 */

public boolean isSaveEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Controls whether the saving of this view's state is
 * enabled (that is, whether its {@link #onSaveInstanceState} method
 * will be called).  Note that even if freezing is enabled, the
 * view still must have an id assigned to it (via {@link #setId(int)})
 * for its state to be saved.  This flag can only disable the
 * saving of this view; any child views may still have their state saved.
 *
 * @param enabled Set to false to <em>disable</em> state saving, or true
 * (the default) to allow it.
 *
 * @see #isSaveEnabled()
 * @see #setId(int)
 * @see #onSaveInstanceState()
 * @attr ref android.R.styleable#View_saveEnabled
 */

public void setSaveEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Gets whether the framework should discard touches when the view's
 * window is obscured by another visible window.
 * Refer to the {@link View} security documentation for more details.
 *
 * @return True if touch filtering is enabled.
 *
 * @see #setFilterTouchesWhenObscured(boolean)
 * @attr ref android.R.styleable#View_filterTouchesWhenObscured
 */

@android.view.ViewDebug.ExportedProperty public boolean getFilterTouchesWhenObscured() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the framework should discard touches when the view's
 * window is obscured by another visible window.
 * Refer to the {@link View} security documentation for more details.
 *
 * @param enabled True if touch filtering should be enabled.
 *
 * @see #getFilterTouchesWhenObscured
 * @attr ref android.R.styleable#View_filterTouchesWhenObscured
 */

public void setFilterTouchesWhenObscured(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the entire hierarchy under this view will save its
 * state when a state saving traversal occurs from its parent.  The default
 * is true; if false, these views will not be saved unless
 * {@link #saveHierarchyState(SparseArray)} is called directly on this view.
 *
 * @return Returns true if the view state saving from parent is enabled, else false.
 *
 * @see #setSaveFromParentEnabled(boolean)
 */

public boolean isSaveFromParentEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Controls whether the entire hierarchy under this view will save its
 * state when a state saving traversal occurs from its parent.  The default
 * is true; if false, these views will not be saved unless
 * {@link #saveHierarchyState(SparseArray)} is called directly on this view.
 *
 * @param enabled Set to false to <em>disable</em> state saving, or true
 * (the default) to allow it.
 *
 * @see #isSaveFromParentEnabled()
 * @see #setId(int)
 * @see #onSaveInstanceState()
 */

public void setSaveFromParentEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether this View is currently able to take focus.
 *
 * @return True if this view can take focus, or false otherwise.
 */

@android.view.ViewDebug.ExportedProperty(category="focus") public final boolean isFocusable() { throw new RuntimeException("Stub!"); }

/**
 * Returns the focusable setting for this view.
 *
 * @return One of {@link #NOT_FOCUSABLE}, {@link #FOCUSABLE}, or {@link #FOCUSABLE_AUTO}.
 * Value is {@link android.view.View#NOT_FOCUSABLE}, {@link android.view.View#FOCUSABLE}, or {@link android.view.View#FOCUSABLE_AUTO}
 * @attr ref android.R.styleable#View_focusable
 */

@android.view.ViewDebug.ExportedProperty(mapping={@android.view.ViewDebug.IntToString(from=android.view.View.NOT_FOCUSABLE, to="NOT_FOCUSABLE"), @android.view.ViewDebug.IntToString(from=android.view.View.FOCUSABLE, to="FOCUSABLE"), @android.view.ViewDebug.IntToString(from=android.view.View.FOCUSABLE_AUTO, to="FOCUSABLE_AUTO")}, category="focus") public int getFocusable() { throw new RuntimeException("Stub!"); }

/**
 * When a view is focusable, it may not want to take focus when in touch mode.
 * For example, a button would like focus when the user is navigating via a D-pad
 * so that the user can click on it, but once the user starts touching the screen,
 * the button shouldn't take focus
 * @return Whether the view is focusable in touch mode.
 * @attr ref android.R.styleable#View_focusableInTouchMode
 */

@android.view.ViewDebug.ExportedProperty(category="focus") public final boolean isFocusableInTouchMode() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the view should be treated as a focusable unit by screen reader
 * accessibility tools.
 * @see #setScreenReaderFocusable(boolean)
 *
 * @return Whether the view should be treated as a focusable unit by screen reader.
 */

public boolean isScreenReaderFocusable() { throw new RuntimeException("Stub!"); }

/**
 * When screen readers (one type of accessibility tool) decide what should be read to the
 * user, they typically look for input focusable ({@link #isFocusable()}) parents of
 * non-focusable text items, and read those focusable parents and their non-focusable children
 * as a unit. In some situations, this behavior is desirable for views that should not take
 * input focus. Setting an item to be screen reader focusable requests that the view be
 * treated as a unit by screen readers without any effect on input focusability. The default
 * value of {@code false} lets screen readers use other signals, like focusable, to determine
 * how to group items.
 *
 * @param screenReaderFocusable Whether the view should be treated as a unit by screen reader
 *                              accessibility tools.
 */

public void setScreenReaderFocusable(boolean screenReaderFocusable) { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this view is a heading for accessibility purposes.
 *
 * @return {@code true} if the view is a heading, {@code false} otherwise.
 *
 * @attr ref android.R.styleable#View_accessibilityHeading
 */

public boolean isAccessibilityHeading() { throw new RuntimeException("Stub!"); }

/**
 * Set if view is a heading for a section of content for accessibility purposes.
 *
 * @param isHeading {@code true} if the view is a heading, {@code false} otherwise.
 *
 * @attr ref android.R.styleable#View_accessibilityHeading
 */

public void setAccessibilityHeading(boolean isHeading) { throw new RuntimeException("Stub!"); }

/**
 * Find the nearest view in the specified direction that can take focus.
 * This does not actually give focus to that view.
 *
 * @param direction One of FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, and FOCUS_RIGHT
 *
 * Value is {@link android.view.View#FOCUS_LEFT}, {@link android.view.View#FOCUS_UP}, {@link android.view.View#FOCUS_RIGHT}, or {@link android.view.View#FOCUS_DOWN}
 * @return The nearest focusable in the specified direction, or null if none
 *         can be found.
 */

public android.view.View focusSearch(int direction) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether this View is a root of a keyboard navigation cluster.
 *
 * @return True if this view is a root of a cluster, or false otherwise.
 * @attr ref android.R.styleable#View_keyboardNavigationCluster
 */

@android.view.ViewDebug.ExportedProperty(category="focus") public final boolean isKeyboardNavigationCluster() { throw new RuntimeException("Stub!"); }

/**
 * Set whether this view is a root of a keyboard navigation cluster.
 *
 * @param isCluster If true, this view is a root of a cluster.
 *
 * @attr ref android.R.styleable#View_keyboardNavigationCluster
 */

public void setKeyboardNavigationCluster(boolean isCluster) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether this View should receive focus when the focus is restored for the view
 * hierarchy containing this view.
 * <p>
 * Focus gets restored for a view hierarchy when the root of the hierarchy gets added to a
 * window or serves as a target of cluster navigation.
 *
 * @see #restoreDefaultFocus()
 *
 * @return {@code true} if this view is the default-focus view, {@code false} otherwise
 * @attr ref android.R.styleable#View_focusedByDefault
 */

@android.view.ViewDebug.ExportedProperty(category="focus") public final boolean isFocusedByDefault() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this View should receive focus when the focus is restored for the view
 * hierarchy containing this view.
 * <p>
 * Focus gets restored for a view hierarchy when the root of the hierarchy gets added to a
 * window or serves as a target of cluster navigation.
 *
 * @param isFocusedByDefault {@code true} to set this view as the default-focus view,
 *                           {@code false} otherwise.
 *
 * @see #restoreDefaultFocus()
 *
 * @attr ref android.R.styleable#View_focusedByDefault
 */

public void setFocusedByDefault(boolean isFocusedByDefault) { throw new RuntimeException("Stub!"); }

/**
 * Find the nearest keyboard navigation cluster in the specified direction.
 * This does not actually give focus to that cluster.
 *
 * @param currentCluster The starting point of the search. Null means the current cluster is not
 *                       found yet
 * @param direction Direction to look
 *
 * Value is {@link android.view.View#FOCUS_BACKWARD}, {@link android.view.View#FOCUS_FORWARD}, {@link android.view.View#FOCUS_LEFT}, {@link android.view.View#FOCUS_UP}, {@link android.view.View#FOCUS_RIGHT}, or {@link android.view.View#FOCUS_DOWN}
 * @return The nearest keyboard navigation cluster in the specified direction, or null if none
 *         can be found
 */

public android.view.View keyboardNavigationClusterSearch(android.view.View currentCluster, int direction) { throw new RuntimeException("Stub!"); }

/**
 * This method is the last chance for the focused view and its ancestors to
 * respond to an arrow key. This is called when the focused view did not
 * consume the key internally, nor could the view system find a new view in
 * the requested direction to give focus to.
 *
 * @param focused The currently focused view.
 * @param direction The direction focus wants to move. One of FOCUS_UP,
 *        FOCUS_DOWN, FOCUS_LEFT, and FOCUS_RIGHT.
 * Value is {@link android.view.View#FOCUS_LEFT}, {@link android.view.View#FOCUS_UP}, {@link android.view.View#FOCUS_RIGHT}, or {@link android.view.View#FOCUS_DOWN}
 * @return True if the this view consumed this unhandled move.
 */

public boolean dispatchUnhandledMove(android.view.View focused, int direction) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this View should use a default focus highlight when it gets focused but doesn't
 * have {@link android.R.attr#state_focused} defined in its background.
 *
 * @param defaultFocusHighlightEnabled {@code true} to set this view to use a default focus
 *                                      highlight, {@code false} otherwise.
 *
 * @attr ref android.R.styleable#View_defaultFocusHighlightEnabled
 */

public void setDefaultFocusHighlightEnabled(boolean defaultFocusHighlightEnabled) { throw new RuntimeException("Stub!"); }

/**
 /**
 * Returns whether this View should use a default focus highlight when it gets focused but
 * doesn't have {@link android.R.attr#state_focused} defined in its background.
 *
 * @return True if this View should use a default focus highlight.
 * @attr ref android.R.styleable#View_defaultFocusHighlightEnabled
 */

@android.view.ViewDebug.ExportedProperty(category="focus") public final boolean getDefaultFocusHighlightEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Find and return all focusable views that are descendants of this view,
 * possibly including this view if it is focusable itself.
 *
 * @param direction The direction of the focus
 * Value is {@link android.view.View#FOCUS_BACKWARD}, {@link android.view.View#FOCUS_FORWARD}, {@link android.view.View#FOCUS_LEFT}, {@link android.view.View#FOCUS_UP}, {@link android.view.View#FOCUS_RIGHT}, or {@link android.view.View#FOCUS_DOWN}
 * @return A list of focusable views
 */

public java.util.ArrayList<android.view.View> getFocusables(int direction) { throw new RuntimeException("Stub!"); }

/**
 * Add any focusable views that are descendants of this view (possibly
 * including this view if it is focusable itself) to views.  If we are in touch mode,
 * only add views that are also focusable in touch mode.
 *
 * @param views Focusable views found so far
 * @param direction The direction of the focus

 * Value is {@link android.view.View#FOCUS_BACKWARD}, {@link android.view.View#FOCUS_FORWARD}, {@link android.view.View#FOCUS_LEFT}, {@link android.view.View#FOCUS_UP}, {@link android.view.View#FOCUS_RIGHT}, or {@link android.view.View#FOCUS_DOWN}
 */

public void addFocusables(java.util.ArrayList<android.view.View> views, int direction) { throw new RuntimeException("Stub!"); }

/**
 * Adds any focusable views that are descendants of this view (possibly
 * including this view if it is focusable itself) to views. This method
 * adds all focusable views regardless if we are in touch mode or
 * only views focusable in touch mode if we are in touch mode or
 * only views that can take accessibility focus if accessibility is enabled
 * depending on the focusable mode parameter.
 *
 * @param views Focusable views found so far or null if all we are interested is
 *        the number of focusables.
 * @param direction The direction of the focus.
 * Value is {@link android.view.View#FOCUS_BACKWARD}, {@link android.view.View#FOCUS_FORWARD}, {@link android.view.View#FOCUS_LEFT}, {@link android.view.View#FOCUS_UP}, {@link android.view.View#FOCUS_RIGHT}, or {@link android.view.View#FOCUS_DOWN}
 * @param focusableMode The type of focusables to be added.
 *
 * Value is either <code>0</code> or a combination of {@link android.view.View#FOCUSABLES_ALL}, and {@link android.view.View#FOCUSABLES_TOUCH_MODE}
 * @see #FOCUSABLES_ALL
 * @see #FOCUSABLES_TOUCH_MODE
 */

public void addFocusables(java.util.ArrayList<android.view.View> views, int direction, int focusableMode) { throw new RuntimeException("Stub!"); }

/**
 * Adds any keyboard navigation cluster roots that are descendants of this view (possibly
 * including this view if it is a cluster root itself) to views.
 *
 * @param views Keyboard navigation cluster roots found so far
 * This value must never be {@code null}.
 * @param direction Direction to look
 */

public void addKeyboardNavigationClusters(@androidx.annotation.RecentlyNonNull java.util.Collection<android.view.View> views, int direction) { throw new RuntimeException("Stub!"); }

/**
 * Finds the Views that contain given text. The containment is case insensitive.
 * The search is performed by either the text that the View renders or the content
 * description that describes the view for accessibility purposes and the view does
 * not render or both. Clients can specify how the search is to be performed via
 * passing the {@link #FIND_VIEWS_WITH_TEXT} and
 * {@link #FIND_VIEWS_WITH_CONTENT_DESCRIPTION} flags.
 *
 * @param outViews The output list of matching Views.
 * @param searched The text to match against.
 *
 * @see #FIND_VIEWS_WITH_TEXT
 * @see #FIND_VIEWS_WITH_CONTENT_DESCRIPTION
 * @see #setContentDescription(CharSequence)

 * @param flags Value is either <code>0</code> or a combination of {@link android.view.View#FIND_VIEWS_WITH_TEXT}, and {@link android.view.View#FIND_VIEWS_WITH_CONTENT_DESCRIPTION}
 */

public void findViewsWithText(java.util.ArrayList<android.view.View> outViews, java.lang.CharSequence searched, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Find and return all touchable views that are descendants of this view,
 * possibly including this view if it is touchable itself.
 *
 * @return A list of touchable views
 */

public java.util.ArrayList<android.view.View> getTouchables() { throw new RuntimeException("Stub!"); }

/**
 * Add any touchable views that are descendants of this view (possibly
 * including this view if it is touchable itself) to views.
 *
 * @param views Touchable views found so far
 */

public void addTouchables(java.util.ArrayList<android.view.View> views) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether this View is accessibility focused.
 *
 * @return True if this View is accessibility focused.
 */

public boolean isAccessibilityFocused() { throw new RuntimeException("Stub!"); }

/**
 * Call this to try to give focus to a specific view or to one of its
 * descendants.
 *
 * A view will not actually take focus if it is not focusable ({@link #isFocusable} returns
 * false), or if it can't be focused due to other conditions (not focusable in touch mode
 * ({@link #isFocusableInTouchMode}) while the device is in touch mode, not visible, not
 * enabled, or has no size).
 *
 * See also {@link #focusSearch(int)}, which is what you call to say that you
 * have focus, and you want your parent to look for the next one.
 *
 * This is equivalent to calling {@link #requestFocus(int, Rect)} with arguments
 * {@link #FOCUS_DOWN} and <code>null</code>.
 *
 * @return Whether this view or one of its descendants actually took focus.
 */

public final boolean requestFocus() { throw new RuntimeException("Stub!"); }

/**
 * Gives focus to the default-focus view in the view hierarchy that has this view as a root.
 * If the default-focus view cannot be found, falls back to calling {@link #requestFocus(int)}.
 *
 * @return Whether this view or one of its descendants actually took focus
 */

public boolean restoreDefaultFocus() { throw new RuntimeException("Stub!"); }

/**
 * Call this to try to give focus to a specific view or to one of its
 * descendants and give it a hint about what direction focus is heading.
 *
 * A view will not actually take focus if it is not focusable ({@link #isFocusable} returns
 * false), or if it is focusable and it is not focusable in touch mode
 * ({@link #isFocusableInTouchMode}) while the device is in touch mode.
 *
 * See also {@link #focusSearch(int)}, which is what you call to say that you
 * have focus, and you want your parent to look for the next one.
 *
 * This is equivalent to calling {@link #requestFocus(int, Rect)} with
 * <code>null</code> set for the previously focused rectangle.
 *
 * @param direction One of FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, and FOCUS_RIGHT
 * @return Whether this view or one of its descendants actually took focus.
 */

public final boolean requestFocus(int direction) { throw new RuntimeException("Stub!"); }

/**
 * Call this to try to give focus to a specific view or to one of its descendants
 * and give it hints about the direction and a specific rectangle that the focus
 * is coming from.  The rectangle can help give larger views a finer grained hint
 * about where focus is coming from, and therefore, where to show selection, or
 * forward focus change internally.
 *
 * A view will not actually take focus if it is not focusable ({@link #isFocusable} returns
 * false), or if it is focusable and it is not focusable in touch mode
 * ({@link #isFocusableInTouchMode}) while the device is in touch mode.
 *
 * A View will not take focus if it is not visible.
 *
 * A View will not take focus if one of its parents has
 * {@link android.view.ViewGroup#getDescendantFocusability()} equal to
 * {@link ViewGroup#FOCUS_BLOCK_DESCENDANTS}.
 *
 * See also {@link #focusSearch(int)}, which is what you call to say that you
 * have focus, and you want your parent to look for the next one.
 *
 * You may wish to override this method if your custom {@link View} has an internal
 * {@link View} that it wishes to forward the request to.
 *
 * @param direction One of FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, and FOCUS_RIGHT
 * @param previouslyFocusedRect The rectangle (in this View's coordinate system)
 *        to give a finer grained hint about where focus is coming from.  May be null
 *        if there is no hint.
 * @return Whether this view or one of its descendants actually took focus.
 */

public boolean requestFocus(int direction, android.graphics.Rect previouslyFocusedRect) { throw new RuntimeException("Stub!"); }

/**
 * Call this to try to give focus to a specific view or to one of its descendants. This is a
 * special variant of {@link #requestFocus() } that will allow views that are not focusable in
 * touch mode to request focus when they are touched.
 *
 * @return Whether this view or one of its descendants actually took focus.
 *
 * @see #isInTouchMode()
 *
 */

public final boolean requestFocusFromTouch() { throw new RuntimeException("Stub!"); }

/**
 * Gets the mode for determining whether this View is important for accessibility.
 * A view is important for accessibility if it fires accessibility events and if it
 * is reported to accessibility services that query the screen.
 *
 * @return The mode for determining whether a view is important for accessibility, one
 * of {@link #IMPORTANT_FOR_ACCESSIBILITY_AUTO}, {@link #IMPORTANT_FOR_ACCESSIBILITY_YES},
 * {@link #IMPORTANT_FOR_ACCESSIBILITY_NO}, or
 * {@link #IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS}.
 *
 * @attr ref android.R.styleable#View_importantForAccessibility
 *
 * @see #IMPORTANT_FOR_ACCESSIBILITY_YES
 * @see #IMPORTANT_FOR_ACCESSIBILITY_NO
 * @see #IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS
 * @see #IMPORTANT_FOR_ACCESSIBILITY_AUTO
 */

@android.view.ViewDebug.ExportedProperty(category="accessibility", mapping={@android.view.ViewDebug.IntToString(from=android.view.View.IMPORTANT_FOR_ACCESSIBILITY_AUTO, to="auto"), @android.view.ViewDebug.IntToString(from=android.view.View.IMPORTANT_FOR_ACCESSIBILITY_YES, to="yes"), @android.view.ViewDebug.IntToString(from=android.view.View.IMPORTANT_FOR_ACCESSIBILITY_NO, to="no"), @android.view.ViewDebug.IntToString(from=android.view.View.IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS, to="noHideDescendants")}) public int getImportantForAccessibility() { throw new RuntimeException("Stub!"); }

/**
 * Sets the live region mode for this view. This indicates to accessibility
 * services whether they should automatically notify the user about changes
 * to the view's content description or text, or to the content descriptions
 * or text of the view's children (where applicable).
 * <p>
 * For example, in a login screen with a TextView that displays an "incorrect
 * password" notification, that view should be marked as a live region with
 * mode {@link #ACCESSIBILITY_LIVE_REGION_POLITE}.
 * <p>
 * To disable change notifications for this view, use
 * {@link #ACCESSIBILITY_LIVE_REGION_NONE}. This is the default live region
 * mode for most views.
 * <p>
 * To indicate that the user should be notified of changes, use
 * {@link #ACCESSIBILITY_LIVE_REGION_POLITE}.
 * <p>
 * If the view's changes should interrupt ongoing speech and notify the user
 * immediately, use {@link #ACCESSIBILITY_LIVE_REGION_ASSERTIVE}.
 *
 * @param mode The live region mode for this view, one of:
 *        <ul>
 *        <li>{@link #ACCESSIBILITY_LIVE_REGION_NONE}
 *        <li>{@link #ACCESSIBILITY_LIVE_REGION_POLITE}
 *        <li>{@link #ACCESSIBILITY_LIVE_REGION_ASSERTIVE}
 *        </ul>
 * @attr ref android.R.styleable#View_accessibilityLiveRegion
 */

public void setAccessibilityLiveRegion(int mode) { throw new RuntimeException("Stub!"); }

/**
 * Gets the live region mode for this View.
 *
 * @return The live region mode for the view.
 *
 * @attr ref android.R.styleable#View_accessibilityLiveRegion
 *
 * @see #setAccessibilityLiveRegion(int)
 */

public int getAccessibilityLiveRegion() { throw new RuntimeException("Stub!"); }

/**
 * Sets how to determine whether this view is important for accessibility
 * which is if it fires accessibility events and if it is reported to
 * accessibility services that query the screen.
 *
 * @param mode How to determine whether this view is important for accessibility.
 *
 * @attr ref android.R.styleable#View_importantForAccessibility
 *
 * @see #IMPORTANT_FOR_ACCESSIBILITY_YES
 * @see #IMPORTANT_FOR_ACCESSIBILITY_NO
 * @see #IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS
 * @see #IMPORTANT_FOR_ACCESSIBILITY_AUTO
 */

public void setImportantForAccessibility(int mode) { throw new RuntimeException("Stub!"); }

/**
 * Computes whether this view should be exposed for accessibility. In
 * general, views that are interactive or provide information are exposed
 * while views that serve only as containers are hidden.
 * <p>
 * If an ancestor of this view has importance
 * {@link #IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS}, this method
 * returns <code>false</code>.
 * <p>
 * Otherwise, the value is computed according to the view's
 * {@link #getImportantForAccessibility()} value:
 * <ol>
 * <li>{@link #IMPORTANT_FOR_ACCESSIBILITY_NO} or
 * {@link #IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS}, return <code>false
 * </code>
 * <li>{@link #IMPORTANT_FOR_ACCESSIBILITY_YES}, return <code>true</code>
 * <li>{@link #IMPORTANT_FOR_ACCESSIBILITY_AUTO}, return <code>true</code> if
 * view satisfies any of the following:
 * <ul>
 * <li>Is actionable, e.g. {@link #isClickable()},
 * {@link #isLongClickable()}, or {@link #isFocusable()}
 * <li>Has an {@link AccessibilityDelegate}
 * <li>Has an interaction listener, e.g. {@link OnTouchListener},
 * {@link OnKeyListener}, etc.
 * <li>Is an accessibility live region, e.g.
 * {@link #getAccessibilityLiveRegion()} is not
 * {@link #ACCESSIBILITY_LIVE_REGION_NONE}.
 * </ul>
 * <li>Has an accessibility pane title, see {@link #setAccessibilityPaneTitle}</li>
 * </ol>
 *
 * @return Whether the view is exposed for accessibility.
 * @see #setImportantForAccessibility(int)
 * @see #getImportantForAccessibility()
 */

public boolean isImportantForAccessibility() { throw new RuntimeException("Stub!"); }

/**
 * Gets the parent for accessibility purposes. Note that the parent for
 * accessibility is not necessary the immediate parent. It is the first
 * predecessor that is important for accessibility.
 *
 * @return The parent for accessibility purposes.
 */

public android.view.ViewParent getParentForAccessibility() { throw new RuntimeException("Stub!"); }

/**
 * Adds the children of this View relevant for accessibility to the given list
 * as output. Since some Views are not important for accessibility the added
 * child views are not necessarily direct children of this view, rather they are
 * the first level of descendants important for accessibility.
 *
 * @param outChildren The output list that will receive children for accessibility.
 */

public void addChildrenForAccessibility(java.util.ArrayList<android.view.View> outChildren) { throw new RuntimeException("Stub!"); }

/**
 * Report an accessibility action to this view's parents for delegated processing.
 *
 * <p>Implementations of {@link #performAccessibilityAction(int, Bundle)} may internally
 * call this method to delegate an accessibility action to a supporting parent. If the parent
 * returns true from its
 * {@link ViewParent#onNestedPrePerformAccessibilityAction(View, int, android.os.Bundle)}
 * method this method will return true to signify that the action was consumed.</p>
 *
 * <p>This method is useful for implementing nested scrolling child views. If
 * {@link #isNestedScrollingEnabled()} returns true and the action is a scrolling action
 * a custom view implementation may invoke this method to allow a parent to consume the
 * scroll first. If this method returns true the custom view should skip its own scrolling
 * behavior.</p>
 *
 * @param action Accessibility action to delegate
 * @param arguments Optional action arguments
 * @return true if the action was consumed by a parent
 */

public boolean dispatchNestedPrePerformAccessibilityAction(int action, android.os.Bundle arguments) { throw new RuntimeException("Stub!"); }

/**
 * Performs the specified accessibility action on the view. For
 * possible accessibility actions look at {@link AccessibilityNodeInfo}.
 * <p>
 * If an {@link AccessibilityDelegate} has been specified via calling
 * {@link #setAccessibilityDelegate(AccessibilityDelegate)} its
 * {@link AccessibilityDelegate#performAccessibilityAction(View, int, Bundle)}
 * is responsible for handling this call.
 * </p>
 *
 * <p>The default implementation will delegate
 * {@link AccessibilityNodeInfo#ACTION_SCROLL_BACKWARD} and
 * {@link AccessibilityNodeInfo#ACTION_SCROLL_FORWARD} to nested scrolling parents if
 * {@link #isNestedScrollingEnabled() nested scrolling is enabled} on this view.</p>
 *
 * @param action The action to perform.
 * @param arguments Optional action arguments.
 * @return Whether the action was performed.
 */

public boolean performAccessibilityAction(int action, android.os.Bundle arguments) { throw new RuntimeException("Stub!"); }

/**
 * Tells whether the {@link View} is in the state between {@link #onStartTemporaryDetach()}
 * and {@link #onFinishTemporaryDetach()}.
 *
 * <p>This method always returns {@code true} when called directly or indirectly from
 * {@link #onStartTemporaryDetach()}. The return value when called directly or indirectly from
 * {@link #onFinishTemporaryDetach()}, however, depends on the OS version.
 * <ul>
 *     <li>{@code true} on {@link android.os.Build.VERSION_CODES#N API 24}</li>
 *     <li>{@code false} on {@link android.os.Build.VERSION_CODES#N_MR1 API 25}} and later</li>
 * </ul>
 * </p>
 *
 * @return {@code true} when the View is in the state between {@link #onStartTemporaryDetach()}
 * and {@link #onFinishTemporaryDetach()}.
 */

public final boolean isTemporarilyDetached() { throw new RuntimeException("Stub!"); }

/**
 * Dispatch {@link #onStartTemporaryDetach()} to this View and its direct children if this is
 * a container View.

 * If you override this method you <em>must</em> call through to the
 *  *            superclass implementation.
 */

public void dispatchStartTemporaryDetach() { throw new RuntimeException("Stub!"); }

/**
 * This is called when a container is going to temporarily detach a child, with
 * {@link ViewGroup#detachViewFromParent(View) ViewGroup.detachViewFromParent}.
 * It will either be followed by {@link #onFinishTemporaryDetach()} or
 * {@link #onDetachedFromWindow()} when the container is done.
 */

public void onStartTemporaryDetach() { throw new RuntimeException("Stub!"); }

/**
 * Dispatch {@link #onFinishTemporaryDetach()} to this View and its direct children if this is
 * a container View.

 * If you override this method you <em>must</em> call through to the
 *  *            superclass implementation.
 */

public void dispatchFinishTemporaryDetach() { throw new RuntimeException("Stub!"); }

/**
 * Called after {@link #onStartTemporaryDetach} when the container is done
 * changing the view.
 */

public void onFinishTemporaryDetach() { throw new RuntimeException("Stub!"); }

/**
 * Return the global {@link KeyEvent.DispatcherState KeyEvent.DispatcherState}
 * for this view's window.  Returns null if the view is not currently attached
 * to the window.  Normally you will not need to use this directly, but
 * just use the standard high-level event callbacks like
 * {@link #onKeyDown(int, KeyEvent)}.
 */

public android.view.KeyEvent.DispatcherState getKeyDispatcherState() { throw new RuntimeException("Stub!"); }

/**
 * Dispatch a key event before it is processed by any input method
 * associated with the view hierarchy.  This can be used to intercept
 * key events in special situations before the IME consumes them; a
 * typical example would be handling the BACK key to update the application's
 * UI instead of allowing the IME to see it and close itself.
 *
 * @param event The key event to be dispatched.
 * @return True if the event was handled, false otherwise.
 */

public boolean dispatchKeyEventPreIme(android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Dispatch a key event to the next view on the focus path. This path runs
 * from the top of the view tree down to the currently focused view. If this
 * view has focus, it will dispatch to itself. Otherwise it will dispatch
 * the next node down the focus path. This method also fires any key
 * listeners.
 *
 * @param event The key event to be dispatched.
 * @return True if the event was handled, false otherwise.
 */

public boolean dispatchKeyEvent(android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Dispatches a key shortcut event.
 *
 * @param event The key event to be dispatched.
 * @return True if the event was handled by the view, false otherwise.
 */

public boolean dispatchKeyShortcutEvent(android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Pass the touch screen motion event down to the target view, or this
 * view if it is the target.
 *
 * @param event The motion event to be dispatched.
 * @return True if the event was handled by the view, false otherwise.
 */

public boolean dispatchTouchEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Filter the touch event to apply security policies.
 *
 * @param event The motion event to be filtered.
 * @return True if the event should be dispatched, false if the event should be dropped.
 *
 * @see #getFilterTouchesWhenObscured
 */

public boolean onFilterTouchEventForSecurity(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Pass a trackball motion event down to the focused view.
 *
 * @param event The motion event to be dispatched.
 * @return True if the event was handled by the view, false otherwise.
 */

public boolean dispatchTrackballEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Pass a captured pointer event down to the focused view.
 *
 * @param event The motion event to be dispatched.
 * @return True if the event was handled by the view, false otherwise.
 */

public boolean dispatchCapturedPointerEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Dispatch a generic motion event.
 * <p>
 * Generic motion events with source class {@link InputDevice#SOURCE_CLASS_POINTER}
 * are delivered to the view under the pointer.  All other generic motion events are
 * delivered to the focused view.  Hover events are handled specially and are delivered
 * to {@link #onHoverEvent(MotionEvent)}.
 * </p>
 *
 * @param event The motion event to be dispatched.
 * @return True if the event was handled by the view, false otherwise.
 */

public boolean dispatchGenericMotionEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Dispatch a hover event.
 * <p>
 * Do not call this method directly.
 * Call {@link #dispatchGenericMotionEvent(MotionEvent)} instead.
 * </p>
 *
 * @param event The motion event to be dispatched.
 * @return True if the event was handled by the view, false otherwise.
 */

protected boolean dispatchHoverEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Dispatch a generic motion event to the view under the first pointer.
 * <p>
 * Do not call this method directly.
 * Call {@link #dispatchGenericMotionEvent(MotionEvent)} instead.
 * </p>
 *
 * @param event The motion event to be dispatched.
 * @return True if the event was handled by the view, false otherwise.
 */

protected boolean dispatchGenericPointerEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Dispatch a generic motion event to the currently focused view.
 * <p>
 * Do not call this method directly.
 * Call {@link #dispatchGenericMotionEvent(MotionEvent)} instead.
 * </p>
 *
 * @param event The motion event to be dispatched.
 * @return True if the event was handled by the view, false otherwise.
 */

protected boolean dispatchGenericFocusedEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Called when the window containing this view gains or loses window focus.
 * ViewGroups should override to route to their children.
 *
 * @param hasFocus True if the window containing this view now has focus,
 *        false otherwise.
 */

public void dispatchWindowFocusChanged(boolean hasFocus) { throw new RuntimeException("Stub!"); }

/**
 * Called when the window containing this view gains or loses focus.  Note
 * that this is separate from view focus: to receive key events, both
 * your view and its window must have focus.  If a window is displayed
 * on top of yours that takes input focus, then your own window will lose
 * focus but the view focus will remain unchanged.
 *
 * @param hasWindowFocus True if the window containing this view now has
 *        focus, false otherwise.
 */

public void onWindowFocusChanged(boolean hasWindowFocus) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this view is in a window that currently has window focus.
 * Note that this is not the same as the view itself having focus.
 *
 * @return True if this view is in a window that currently has window focus.
 */

public boolean hasWindowFocus() { throw new RuntimeException("Stub!"); }

/**
 * Dispatch a view visibility change down the view hierarchy.
 * ViewGroups should override to route to their children.
 * @param changedView The view whose visibility changed. Could be 'this' or
 * an ancestor view.
 * This value must never be {@code null}.
 * @param visibility The new visibility of changedView: {@link #VISIBLE},
 * {@link #INVISIBLE} or {@link #GONE}.

 * Value is {@link android.view.View#VISIBLE}, {@link android.view.View#INVISIBLE}, or {@link android.view.View#GONE}
 */

protected void dispatchVisibilityChanged(@androidx.annotation.RecentlyNonNull android.view.View changedView, int visibility) { throw new RuntimeException("Stub!"); }

/**
 * Called when the visibility of the view or an ancestor of the view has
 * changed.
 *
 * @param changedView The view whose visibility changed. May be
 *                    {@code this} or an ancestor view.
 * This value must never be {@code null}.
 * @param visibility The new visibility, one of {@link #VISIBLE},
 *                   {@link #INVISIBLE} or {@link #GONE}.

 * Value is {@link android.view.View#VISIBLE}, {@link android.view.View#INVISIBLE}, or {@link android.view.View#GONE}
 */

protected void onVisibilityChanged(@androidx.annotation.RecentlyNonNull android.view.View changedView, int visibility) { throw new RuntimeException("Stub!"); }

/**
 * Dispatch a hint about whether this view is displayed. For instance, when
 * a View moves out of the screen, it might receives a display hint indicating
 * the view is not displayed. Applications should not <em>rely</em> on this hint
 * as there is no guarantee that they will receive one.
 *
 * @param hint A hint about whether or not this view is displayed:
 * {@link #VISIBLE} or {@link #INVISIBLE}.

 * Value is {@link android.view.View#VISIBLE}, {@link android.view.View#INVISIBLE}, or {@link android.view.View#GONE}
 */

public void dispatchDisplayHint(int hint) { throw new RuntimeException("Stub!"); }

/**
 * Gives this view a hint about whether is displayed or not. For instance, when
 * a View moves out of the screen, it might receives a display hint indicating
 * the view is not displayed. Applications should not <em>rely</em> on this hint
 * as there is no guarantee that they will receive one.
 *
 * @param hint A hint about whether or not this view is displayed:
 * {@link #VISIBLE} or {@link #INVISIBLE}.

 * Value is {@link android.view.View#VISIBLE}, {@link android.view.View#INVISIBLE}, or {@link android.view.View#GONE}
 */

protected void onDisplayHint(int hint) { throw new RuntimeException("Stub!"); }

/**
 * Dispatch a window visibility change down the view hierarchy.
 * ViewGroups should override to route to their children.
 *
 * @param visibility The new visibility of the window.
 *
 * Value is {@link android.view.View#VISIBLE}, {@link android.view.View#INVISIBLE}, or {@link android.view.View#GONE}
 * @see #onWindowVisibilityChanged(int)
 */

public void dispatchWindowVisibilityChanged(int visibility) { throw new RuntimeException("Stub!"); }

/**
 * Called when the window containing has change its visibility
 * (between {@link #GONE}, {@link #INVISIBLE}, and {@link #VISIBLE}).  Note
 * that this tells you whether or not your window is being made visible
 * to the window manager; this does <em>not</em> tell you whether or not
 * your window is obscured by other windows on the screen, even if it
 * is itself visible.
 *
 * @param visibility The new visibility of the window.

 * Value is {@link android.view.View#VISIBLE}, {@link android.view.View#INVISIBLE}, or {@link android.view.View#GONE}
 */

protected void onWindowVisibilityChanged(int visibility) { throw new RuntimeException("Stub!"); }

/**
 * Called when the user-visibility of this View is potentially affected by a change
 * to this view itself, an ancestor view or the window this view is attached to.
 *
 * If you override this method you <em>must</em> call through to the
 *  *            superclass implementation.
 * @param isVisible true if this view and all of its ancestors are {@link #VISIBLE}
 *                  and this view's window is also visible
 */

public void onVisibilityAggregated(boolean isVisible) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current visibility of the window this view is attached to
 * (either {@link #GONE}, {@link #INVISIBLE}, or {@link #VISIBLE}).
 *
 * @return Returns the current visibility of the view's window.

 * Value is {@link android.view.View#VISIBLE}, {@link android.view.View#INVISIBLE}, or {@link android.view.View#GONE}
 */

public int getWindowVisibility() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the overall visible display size in which the window this view is
 * attached to has been positioned in.  This takes into account screen
 * decorations above the window, for both cases where the window itself
 * is being position inside of them or the window is being placed under
 * then and covered insets are used for the window to position its content
 * inside.  In effect, this tells you the available area where content can
 * be placed and remain visible to users.
 *
 * <p>This function requires an IPC back to the window manager to retrieve
 * the requested information, so should not be used in performance critical
 * code like drawing.
 *
 * @param outRect Filled in with the visible display frame.  If the view
 * is not attached to a window, this is simply the raw display size.
 */

public void getWindowVisibleDisplayFrame(android.graphics.Rect outRect) { throw new RuntimeException("Stub!"); }

/**
 * Dispatch a notification about a resource configuration change down
 * the view hierarchy.
 * ViewGroups should override to route to their children.
 *
 * @param newConfig The new resource configuration.
 *
 * @see #onConfigurationChanged(android.content.res.Configuration)
 */

public void dispatchConfigurationChanged(android.content.res.Configuration newConfig) { throw new RuntimeException("Stub!"); }

/**
 * Called when the current configuration of the resources being used
 * by the application have changed.  You can use this to decide when
 * to reload resources that can changed based on orientation and other
 * configuration characteristics.  You only need to use this if you are
 * not relying on the normal {@link android.app.Activity} mechanism of
 * recreating the activity instance upon a configuration change.
 *
 * @param newConfig The new resource configuration.
 */

protected void onConfigurationChanged(android.content.res.Configuration newConfig) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the device is currently in touch mode.  Touch mode is entered
 * once the user begins interacting with the device by touch, and affects various
 * things like whether focus is always visible to the user.
 *
 * @return Whether the device is in touch mode.
 */

@android.view.ViewDebug.ExportedProperty public boolean isInTouchMode() { throw new RuntimeException("Stub!"); }

/**
 * Returns the context the view is running in, through which it can
 * access the current theme, resources, etc.
 *
 * @return The view's Context.
 */

@android.view.ViewDebug.CapturedViewProperty public final android.content.Context getContext() { throw new RuntimeException("Stub!"); }

/**
 * Handle a key event before it is processed by any input method
 * associated with the view hierarchy.  This can be used to intercept
 * key events in special situations before the IME consumes them; a
 * typical example would be handling the BACK key to update the application's
 * UI instead of allowing the IME to see it and close itself.
 *
 * @param keyCode The value in event.getKeyCode().
 * @param event Description of the key event.
 * @return If you handled the event, return true. If you want to allow the
 *         event to be handled by the next receiver, return false.
 */

public boolean onKeyPreIme(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Default implementation of {@link KeyEvent.Callback#onKeyDown(int, KeyEvent)
 * KeyEvent.Callback.onKeyDown()}: perform press of the view
 * when {@link KeyEvent#KEYCODE_DPAD_CENTER} or {@link KeyEvent#KEYCODE_ENTER}
 * is released, if the view is enabled and clickable.
 * <p>
 * Key presses in software keyboards will generally NOT trigger this
 * listener, although some may elect to do so in some situations. Do not
 * rely on this to catch software key presses.
 *
 * @param keyCode a key code that represents the button pressed, from
 *                {@link android.view.KeyEvent}
 * @param event the KeyEvent object that defines the button action
 */

public boolean onKeyDown(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Default implementation of {@link KeyEvent.Callback#onKeyLongPress(int, KeyEvent)
 * KeyEvent.Callback.onKeyLongPress()}: always returns false (doesn't handle
 * the event).
 * <p>Key presses in software keyboards will generally NOT trigger this listener,
 * although some may elect to do so in some situations. Do not rely on this to
 * catch software key presses.
 */

public boolean onKeyLongPress(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Default implementation of {@link KeyEvent.Callback#onKeyUp(int, KeyEvent)
 * KeyEvent.Callback.onKeyUp()}: perform clicking of the view
 * when {@link KeyEvent#KEYCODE_DPAD_CENTER}, {@link KeyEvent#KEYCODE_ENTER}
 * or {@link KeyEvent#KEYCODE_SPACE} is released.
 * <p>Key presses in software keyboards will generally NOT trigger this listener,
 * although some may elect to do so in some situations. Do not rely on this to
 * catch software key presses.
 *
 * @param keyCode A key code that represents the button pressed, from
 *                {@link android.view.KeyEvent}.
 * @param event   The KeyEvent object that defines the button action.
 */

public boolean onKeyUp(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Default implementation of {@link KeyEvent.Callback#onKeyMultiple(int, int, KeyEvent)
 * KeyEvent.Callback.onKeyMultiple()}: always returns false (doesn't handle
 * the event).
 * <p>Key presses in software keyboards will generally NOT trigger this listener,
 * although some may elect to do so in some situations. Do not rely on this to
 * catch software key presses.
 *
 * @param keyCode     A key code that represents the button pressed, from
 *                    {@link android.view.KeyEvent}.
 * @param repeatCount The number of times the action was made.
 * @param event       The KeyEvent object that defines the button action.
 */

public boolean onKeyMultiple(int keyCode, int repeatCount, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Called on the focused view when a key shortcut event is not handled.
 * Override this method to implement local key shortcuts for the View.
 * Key shortcuts can also be implemented by setting the
 * {@link MenuItem#setShortcut(char, char) shortcut} property of menu items.
 *
 * @param keyCode The value in event.getKeyCode().
 * @param event Description of the key event.
 * @return If you handled the event, return true. If you want to allow the
 *         event to be handled by the next receiver, return false.
 */

public boolean onKeyShortcut(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Check whether the called view is a text editor, in which case it
 * would make sense to automatically display a soft input window for
 * it.  Subclasses should override this if they implement
 * {@link #onCreateInputConnection(EditorInfo)} to return true if
 * a call on that method would return a non-null InputConnection, and
 * they are really a first-class editor that the user would normally
 * start typing on when the go into a window containing your view.
 *
 * <p>The default implementation always returns false.  This does
 * <em>not</em> mean that its {@link #onCreateInputConnection(EditorInfo)}
 * will not be called or the user can not otherwise perform edits on your
 * view; it is just a hint to the system that this is not the primary
 * purpose of this view.
 *
 * @return Returns true if this view is a text editor, else false.
 */

public boolean onCheckIsTextEditor() { throw new RuntimeException("Stub!"); }

/**
 * Create a new InputConnection for an InputMethod to interact
 * with the view.  The default implementation returns null, since it doesn't
 * support input methods.  You can override this to implement such support.
 * This is only needed for views that take focus and text input.
 *
 * <p>When implementing this, you probably also want to implement
 * {@link #onCheckIsTextEditor()} to indicate you will return a
 * non-null InputConnection.</p>
 *
 * <p>Also, take good care to fill in the {@link android.view.inputmethod.EditorInfo}
 * object correctly and in its entirety, so that the connected IME can rely
 * on its values. For example, {@link android.view.inputmethod.EditorInfo#initialSelStart}
 * and  {@link android.view.inputmethod.EditorInfo#initialSelEnd} members
 * must be filled in with the correct cursor position for IMEs to work correctly
 * with your application.</p>
 *
 * @param outAttrs Fill in with attribute information about the connection.
 */

public android.view.inputmethod.InputConnection onCreateInputConnection(android.view.inputmethod.EditorInfo outAttrs) { throw new RuntimeException("Stub!"); }

/**
 * Called by the {@link android.view.inputmethod.InputMethodManager}
 * when a view who is not the current
 * input connection target is trying to make a call on the manager.  The
 * default implementation returns false; you can override this to return
 * true for certain views if you are performing InputConnection proxying
 * to them.
 * @param view The View that is making the InputMethodManager call.
 * @return Return true to allow the call, false to reject.
 */

public boolean checkInputConnectionProxy(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Show the context menu for this view. It is not safe to hold on to the
 * menu after returning from this method.
 *
 * You should normally not overload this method. Overload
 * {@link #onCreateContextMenu(ContextMenu)} or define an
 * {@link OnCreateContextMenuListener} to add items to the context menu.
 *
 * @param menu The context menu to populate
 */

public void createContextMenu(android.view.ContextMenu menu) { throw new RuntimeException("Stub!"); }

/**
 * Views should implement this if they have extra information to associate
 * with the context menu. The return result is supplied as a parameter to
 * the {@link OnCreateContextMenuListener#onCreateContextMenu(ContextMenu, View, ContextMenuInfo)}
 * callback.
 *
 * @return Extra information about the item for which the context menu
 *         should be shown. This information will vary across different
 *         subclasses of View.
 */

protected android.view.ContextMenu.ContextMenuInfo getContextMenuInfo() { throw new RuntimeException("Stub!"); }

/**
 * Views should implement this if the view itself is going to add items to
 * the context menu.
 *
 * @param menu the context menu to populate
 */

protected void onCreateContextMenu(android.view.ContextMenu menu) { throw new RuntimeException("Stub!"); }

/**
 * Implement this method to handle trackball motion events.  The
 * <em>relative</em> movement of the trackball since the last event
 * can be retrieve with {@link MotionEvent#getX MotionEvent.getX()} and
 * {@link MotionEvent#getY MotionEvent.getY()}.  These are normalized so
 * that a movement of 1 corresponds to the user pressing one DPAD key (so
 * they will often be fractional values, representing the more fine-grained
 * movement information available from a trackball).
 *
 * @param event The motion event.
 * @return True if the event was handled, false otherwise.
 */

public boolean onTrackballEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Implement this method to handle generic motion events.
 * <p>
 * Generic motion events describe joystick movements, mouse hovers, track pad
 * touches, scroll wheel movements and other input events.  The
 * {@link MotionEvent#getSource() source} of the motion event specifies
 * the class of input that was received.  Implementations of this method
 * must examine the bits in the source before processing the event.
 * The following code example shows how this is done.
 * </p><p>
 * Generic motion events with source class {@link InputDevice#SOURCE_CLASS_POINTER}
 * are delivered to the view under the pointer.  All other generic motion events are
 * delivered to the focused view.
 * </p>
 * <pre> public boolean onGenericMotionEvent(MotionEvent event) {
 *     if (event.isFromSource(InputDevice.SOURCE_CLASS_JOYSTICK)) {
 *         if (event.getAction() == MotionEvent.ACTION_MOVE) {
 *             // process the joystick movement...
 *             return true;
 *         }
 *     }
 *     if (event.isFromSource(InputDevice.SOURCE_CLASS_POINTER)) {
 *         switch (event.getAction()) {
 *             case MotionEvent.ACTION_HOVER_MOVE:
 *                 // process the mouse hover movement...
 *                 return true;
 *             case MotionEvent.ACTION_SCROLL:
 *                 // process the scroll wheel movement...
 *                 return true;
 *         }
 *     }
 *     return super.onGenericMotionEvent(event);
 * }</pre>
 *
 * @param event The generic motion event being processed.
 * @return True if the event was handled, false otherwise.
 */

public boolean onGenericMotionEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Implement this method to handle hover events.
 * <p>
 * This method is called whenever a pointer is hovering into, over, or out of the
 * bounds of a view and the view is not currently being touched.
 * Hover events are represented as pointer events with action
 * {@link MotionEvent#ACTION_HOVER_ENTER}, {@link MotionEvent#ACTION_HOVER_MOVE},
 * or {@link MotionEvent#ACTION_HOVER_EXIT}.
 * </p>
 * <ul>
 * <li>The view receives a hover event with action {@link MotionEvent#ACTION_HOVER_ENTER}
 * when the pointer enters the bounds of the view.</li>
 * <li>The view receives a hover event with action {@link MotionEvent#ACTION_HOVER_MOVE}
 * when the pointer has already entered the bounds of the view and has moved.</li>
 * <li>The view receives a hover event with action {@link MotionEvent#ACTION_HOVER_EXIT}
 * when the pointer has exited the bounds of the view or when the pointer is
 * about to go down due to a button click, tap, or similar user action that
 * causes the view to be touched.</li>
 * </ul>
 * <p>
 * The view should implement this method to return true to indicate that it is
 * handling the hover event, such as by changing its drawable state.
 * </p><p>
 * The default implementation calls {@link #setHovered} to update the hovered state
 * of the view when a hover enter or hover exit event is received, if the view
 * is enabled and is clickable.  The default implementation also sends hover
 * accessibility events.
 * </p>
 *
 * @param event The motion event that describes the hover.
 * @return True if the view handled the hover event.
 *
 * @see #isHovered
 * @see #setHovered
 * @see #onHoverChanged
 */

public boolean onHoverEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the view is currently hovered.
 *
 * @return True if the view is currently hovered.
 *
 * @see #setHovered
 * @see #onHoverChanged
 */

@android.view.ViewDebug.ExportedProperty public boolean isHovered() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the view is currently hovered.
 * <p>
 * Calling this method also changes the drawable state of the view.  This
 * enables the view to react to hover by using different drawable resources
 * to change its appearance.
 * </p><p>
 * The {@link #onHoverChanged} method is called when the hovered state changes.
 * </p>
 *
 * @param hovered True if the view is hovered.
 *
 * @see #isHovered
 * @see #onHoverChanged
 */

public void setHovered(boolean hovered) { throw new RuntimeException("Stub!"); }

/**
 * Implement this method to handle hover state changes.
 * <p>
 * This method is called whenever the hover state changes as a result of a
 * call to {@link #setHovered}.
 * </p>
 *
 * @param hovered The current hover state, as returned by {@link #isHovered}.
 *
 * @see #isHovered
 * @see #setHovered
 */

public void onHoverChanged(boolean hovered) { throw new RuntimeException("Stub!"); }

/**
 * Implement this method to handle touch screen motion events.
 * <p>
 * If this method is used to detect click actions, it is recommended that
 * the actions be performed by implementing and calling
 * {@link #performClick()}. This will ensure consistent system behavior,
 * including:
 * <ul>
 * <li>obeying click sound preferences
 * <li>dispatching OnClickListener calls
 * <li>handling {@link AccessibilityNodeInfo#ACTION_CLICK ACTION_CLICK} when
 * accessibility features are enabled
 * </ul>
 *
 * @param event The motion event.
 * @return True if the event was handled, false otherwise.
 */

public boolean onTouchEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Cancels a pending long press.  Your subclass can use this if you
 * want the context menu to come up if the user presses and holds
 * at the same place, but you don't want it to come up if they press
 * and then move around enough to cause scrolling.
 */

public void cancelLongPress() { throw new RuntimeException("Stub!"); }

/**
 * Sets the TouchDelegate for this View.
 */

public void setTouchDelegate(android.view.TouchDelegate delegate) { throw new RuntimeException("Stub!"); }

/**
 * Gets the TouchDelegate for this View.
 */

public android.view.TouchDelegate getTouchDelegate() { throw new RuntimeException("Stub!"); }

/**
 * Request unbuffered dispatch of the given stream of MotionEvents to this View.
 *
 * Until this View receives a corresponding {@link MotionEvent#ACTION_UP}, ask that the input
 * system not batch {@link MotionEvent}s but instead deliver them as soon as they're
 * available. This method should only be called for touch events.
 *
 * <p class="note">This api is not intended for most applications. Buffered dispatch
 * provides many of benefits, and just requesting unbuffered dispatch on most MotionEvent
 * streams will not improve your input latency. Side effects include: increased latency,
 * jittery scrolls and inability to take advantage of system resampling. Talk to your input
 * professional to see if {@link #requestUnbufferedDispatch(MotionEvent)} is right for
 * you.</p>
 */

public final void requestUnbufferedDispatch(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Change the view's z order in the tree, so it's on top of other sibling
 * views. This ordering change may affect layout, if the parent container
 * uses an order-dependent layout scheme (e.g., LinearLayout). Prior
 * to {@link android.os.Build.VERSION_CODES#KITKAT} this
 * method should be followed by calls to {@link #requestLayout()} and
 * {@link View#invalidate()} on the view's parent to force the parent to redraw
 * with the new child ordering.
 *
 * @see ViewGroup#bringChildToFront(View)
 */

public void bringToFront() { throw new RuntimeException("Stub!"); }

/**
 * This is called in response to an internal scroll in this view (i.e., the
 * view scrolled its own contents). This is typically as a result of
 * {@link #scrollBy(int, int)} or {@link #scrollTo(int, int)} having been
 * called.
 *
 * @param l Current horizontal scroll origin.
 * @param t Current vertical scroll origin.
 * @param oldl Previous horizontal scroll origin.
 * @param oldt Previous vertical scroll origin.
 */

protected void onScrollChanged(int l, int t, int oldl, int oldt) { throw new RuntimeException("Stub!"); }

/**
 * This is called during layout when the size of this view has changed. If
 * you were just added to the view hierarchy, you're called with the old
 * values of 0.
 *
 * @param w Current width of this view.
 * @param h Current height of this view.
 * @param oldw Old width of this view.
 * @param oldh Old height of this view.
 */

protected void onSizeChanged(int w, int h, int oldw, int oldh) { throw new RuntimeException("Stub!"); }

/**
 * Called by draw to draw the child views. This may be overridden
 * by derived classes to gain control just before its children are drawn
 * (but after its own view has been drawn).
 * @param canvas the canvas on which to draw the view
 */

protected void dispatchDraw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * Gets the parent of this view. Note that the parent is a
 * ViewParent and not necessarily a View.
 *
 * @return Parent of this view.
 */

public final android.view.ViewParent getParent() { throw new RuntimeException("Stub!"); }

/**
 * Set the horizontal scrolled position of your view. This will cause a call to
 * {@link #onScrollChanged(int, int, int, int)} and the view will be
 * invalidated.
 * @param value the x position to scroll to
 */

public void setScrollX(int value) { throw new RuntimeException("Stub!"); }

/**
 * Set the vertical scrolled position of your view. This will cause a call to
 * {@link #onScrollChanged(int, int, int, int)} and the view will be
 * invalidated.
 * @param value the y position to scroll to
 */

public void setScrollY(int value) { throw new RuntimeException("Stub!"); }

/**
 * Return the scrolled left position of this view. This is the left edge of
 * the displayed part of your view. You do not need to draw any pixels
 * farther left, since those are outside of the frame of your view on
 * screen.
 *
 * @return The left edge of the displayed part of your view, in pixels.
 */

public final int getScrollX() { throw new RuntimeException("Stub!"); }

/**
 * Return the scrolled top position of this view. This is the top edge of
 * the displayed part of your view. You do not need to draw any pixels above
 * it, since those are outside of the frame of your view on screen.
 *
 * @return The top edge of the displayed part of your view, in pixels.
 */

public final int getScrollY() { throw new RuntimeException("Stub!"); }

/**
 * Return the width of your view.
 *
 * @return The width of your view, in pixels.
 */

@android.view.ViewDebug.ExportedProperty(category="layout") public final int getWidth() { throw new RuntimeException("Stub!"); }

/**
 * Return the height of your view.
 *
 * @return The height of your view, in pixels.
 */

@android.view.ViewDebug.ExportedProperty(category="layout") public final int getHeight() { throw new RuntimeException("Stub!"); }

/**
 * Return the visible drawing bounds of your view. Fills in the output
 * rectangle with the values from getScrollX(), getScrollY(),
 * getWidth(), and getHeight(). These bounds do not account for any
 * transformation properties currently set on the view, such as
 * {@link #setScaleX(float)} or {@link #setRotation(float)}.
 *
 * @param outRect The (scrolled) drawing bounds of the view.
 */

public void getDrawingRect(android.graphics.Rect outRect) { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #getMeasuredWidthAndState()}, but only returns the
 * raw width component (that is the result is masked by
 * {@link #MEASURED_SIZE_MASK}).
 *
 * @return The raw measured width of this view.
 */

public final int getMeasuredWidth() { throw new RuntimeException("Stub!"); }

/**
 * Return the full width measurement information for this view as computed
 * by the most recent call to {@link #measure(int, int)}.  This result is a bit mask
 * as defined by {@link #MEASURED_SIZE_MASK} and {@link #MEASURED_STATE_TOO_SMALL}.
 * This should be used during measurement and layout calculations only. Use
 * {@link #getWidth()} to see how wide a view is after layout.
 *
 * @return The measured width of this view as a bit mask.
 */

@android.view.ViewDebug.ExportedProperty(category="measurement", flagMapping={@android.view.ViewDebug.FlagToString(mask=android.view.View.MEASURED_STATE_MASK, equals=android.view.View.MEASURED_STATE_TOO_SMALL, name="MEASURED_STATE_TOO_SMALL")}) public final int getMeasuredWidthAndState() { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #getMeasuredHeightAndState()}, but only returns the
 * raw height component (that is the result is masked by
 * {@link #MEASURED_SIZE_MASK}).
 *
 * @return The raw measured height of this view.
 */

public final int getMeasuredHeight() { throw new RuntimeException("Stub!"); }

/**
 * Return the full height measurement information for this view as computed
 * by the most recent call to {@link #measure(int, int)}.  This result is a bit mask
 * as defined by {@link #MEASURED_SIZE_MASK} and {@link #MEASURED_STATE_TOO_SMALL}.
 * This should be used during measurement and layout calculations only. Use
 * {@link #getHeight()} to see how wide a view is after layout.
 *
 * @return The measured height of this view as a bit mask.
 */

@android.view.ViewDebug.ExportedProperty(category="measurement", flagMapping={@android.view.ViewDebug.FlagToString(mask=android.view.View.MEASURED_STATE_MASK, equals=android.view.View.MEASURED_STATE_TOO_SMALL, name="MEASURED_STATE_TOO_SMALL")}) public final int getMeasuredHeightAndState() { throw new RuntimeException("Stub!"); }

/**
 * Return only the state bits of {@link #getMeasuredWidthAndState()}
 * and {@link #getMeasuredHeightAndState()}, combined into one integer.
 * The width component is in the regular bits {@link #MEASURED_STATE_MASK}
 * and the height component is at the shifted bits
 * {@link #MEASURED_HEIGHT_STATE_SHIFT}>>{@link #MEASURED_STATE_MASK}.
 */

public final int getMeasuredState() { throw new RuntimeException("Stub!"); }

/**
 * The transform matrix of this view, which is calculated based on the current
 * rotation, scale, and pivot properties.
 *
 * @see #getRotation()
 * @see #getScaleX()
 * @see #getScaleY()
 * @see #getPivotX()
 * @see #getPivotY()
 * @return The current transform matrix for the view
 */

public android.graphics.Matrix getMatrix() { throw new RuntimeException("Stub!"); }

/**
 * Gets the distance along the Z axis from the camera to this view.
 *
 * @see #setCameraDistance(float)
 *
 * @return The distance along the Z axis.
 */

public float getCameraDistance() { throw new RuntimeException("Stub!"); }

/**
 * <p>Sets the distance along the Z axis (orthogonal to the X/Y plane on which
 * views are drawn) from the camera to this view. The camera's distance
 * affects 3D transformations, for instance rotations around the X and Y
 * axis. If the rotationX or rotationY properties are changed and this view is
 * large (more than half the size of the screen), it is recommended to always
 * use a camera distance that's greater than the height (X axis rotation) or
 * the width (Y axis rotation) of this view.</p>
 *
 * <p>The distance of the camera from the view plane can have an affect on the
 * perspective distortion of the view when it is rotated around the x or y axis.
 * For example, a large distance will result in a large viewing angle, and there
 * will not be much perspective distortion of the view as it rotates. A short
 * distance may cause much more perspective distortion upon rotation, and can
 * also result in some drawing artifacts if the rotated view ends up partially
 * behind the camera (which is why the recommendation is to use a distance at
 * least as far as the size of the view, if the view is to be rotated.)</p>
 *
 * <p>The distance is expressed in "depth pixels." The default distance depends
 * on the screen density. For instance, on a medium density display, the
 * default distance is 1280. On a high density display, the default distance
 * is 1920.</p>
 *
 * <p>If you want to specify a distance that leads to visually consistent
 * results across various densities, use the following formula:</p>
 * <pre>
 * float scale = context.getResources().getDisplayMetrics().density;
 * view.setCameraDistance(distance * scale);
 * </pre>
 *
 * <p>The density scale factor of a high density display is 1.5,
 * and 1920 = 1280 * 1.5.</p>
 *
 * @param distance The distance in "depth pixels", if negative the opposite
 *        value is used
 *
 * @see #setRotationX(float)
 * @see #setRotationY(float)
 */

public void setCameraDistance(float distance) { throw new RuntimeException("Stub!"); }

/**
 * The degrees that the view is rotated around the pivot point.
 *
 * @see #setRotation(float)
 * @see #getPivotX()
 * @see #getPivotY()
 *
 * @return The degrees of rotation.
 */

@android.view.ViewDebug.ExportedProperty(category="drawing") public float getRotation() { throw new RuntimeException("Stub!"); }

/**
 * Sets the degrees that the view is rotated around the pivot point. Increasing values
 * result in clockwise rotation.
 *
 * @param rotation The degrees of rotation.
 *
 * @see #getRotation()
 * @see #getPivotX()
 * @see #getPivotY()
 * @see #setRotationX(float)
 * @see #setRotationY(float)
 *
 * @attr ref android.R.styleable#View_rotation
 */

public void setRotation(float rotation) { throw new RuntimeException("Stub!"); }

/**
 * The degrees that the view is rotated around the vertical axis through the pivot point.
 *
 * @see #getPivotX()
 * @see #getPivotY()
 * @see #setRotationY(float)
 *
 * @return The degrees of Y rotation.
 */

@android.view.ViewDebug.ExportedProperty(category="drawing") public float getRotationY() { throw new RuntimeException("Stub!"); }

/**
 * Sets the degrees that the view is rotated around the vertical axis through the pivot point.
 * Increasing values result in counter-clockwise rotation from the viewpoint of looking
 * down the y axis.
 *
 * When rotating large views, it is recommended to adjust the camera distance
 * accordingly. Refer to {@link #setCameraDistance(float)} for more information.
 *
 * @param rotationY The degrees of Y rotation.
 *
 * @see #getRotationY()
 * @see #getPivotX()
 * @see #getPivotY()
 * @see #setRotation(float)
 * @see #setRotationX(float)
 * @see #setCameraDistance(float)
 *
 * @attr ref android.R.styleable#View_rotationY
 */

public void setRotationY(float rotationY) { throw new RuntimeException("Stub!"); }

/**
 * The degrees that the view is rotated around the horizontal axis through the pivot point.
 *
 * @see #getPivotX()
 * @see #getPivotY()
 * @see #setRotationX(float)
 *
 * @return The degrees of X rotation.
 */

@android.view.ViewDebug.ExportedProperty(category="drawing") public float getRotationX() { throw new RuntimeException("Stub!"); }

/**
 * Sets the degrees that the view is rotated around the horizontal axis through the pivot point.
 * Increasing values result in clockwise rotation from the viewpoint of looking down the
 * x axis.
 *
 * When rotating large views, it is recommended to adjust the camera distance
 * accordingly. Refer to {@link #setCameraDistance(float)} for more information.
 *
 * @param rotationX The degrees of X rotation.
 *
 * @see #getRotationX()
 * @see #getPivotX()
 * @see #getPivotY()
 * @see #setRotation(float)
 * @see #setRotationY(float)
 * @see #setCameraDistance(float)
 *
 * @attr ref android.R.styleable#View_rotationX
 */

public void setRotationX(float rotationX) { throw new RuntimeException("Stub!"); }

/**
 * The amount that the view is scaled in x around the pivot point, as a proportion of
 * the view's unscaled width. A value of 1, the default, means that no scaling is applied.
 *
 * <p>By default, this is 1.0f.
 *
 * @see #getPivotX()
 * @see #getPivotY()
 * @return The scaling factor.
 */

@android.view.ViewDebug.ExportedProperty(category="drawing") public float getScaleX() { throw new RuntimeException("Stub!"); }

/**
 * Sets the amount that the view is scaled in x around the pivot point, as a proportion of
 * the view's unscaled width. A value of 1 means that no scaling is applied.
 *
 * @param scaleX The scaling factor.
 * @see #getPivotX()
 * @see #getPivotY()
 *
 * @attr ref android.R.styleable#View_scaleX
 */

public void setScaleX(float scaleX) { throw new RuntimeException("Stub!"); }

/**
 * The amount that the view is scaled in y around the pivot point, as a proportion of
 * the view's unscaled height. A value of 1, the default, means that no scaling is applied.
 *
 * <p>By default, this is 1.0f.
 *
 * @see #getPivotX()
 * @see #getPivotY()
 * @return The scaling factor.
 */

@android.view.ViewDebug.ExportedProperty(category="drawing") public float getScaleY() { throw new RuntimeException("Stub!"); }

/**
 * Sets the amount that the view is scaled in Y around the pivot point, as a proportion of
 * the view's unscaled width. A value of 1 means that no scaling is applied.
 *
 * @param scaleY The scaling factor.
 * @see #getPivotX()
 * @see #getPivotY()
 *
 * @attr ref android.R.styleable#View_scaleY
 */

public void setScaleY(float scaleY) { throw new RuntimeException("Stub!"); }

/**
 * The x location of the point around which the view is {@link #setRotation(float) rotated}
 * and {@link #setScaleX(float) scaled}.
 *
 * @see #getRotation()
 * @see #getScaleX()
 * @see #getScaleY()
 * @see #getPivotY()
 * @return The x location of the pivot point.
 *
 * @attr ref android.R.styleable#View_transformPivotX
 */

@android.view.ViewDebug.ExportedProperty(category="drawing") public float getPivotX() { throw new RuntimeException("Stub!"); }

/**
 * Sets the x location of the point around which the view is
 * {@link #setRotation(float) rotated} and {@link #setScaleX(float) scaled}.
 * By default, the pivot point is centered on the object.
 * Setting this property disables this behavior and causes the view to use only the
 * explicitly set pivotX and pivotY values.
 *
 * @param pivotX The x location of the pivot point.
 * @see #getRotation()
 * @see #getScaleX()
 * @see #getScaleY()
 * @see #getPivotY()
 *
 * @attr ref android.R.styleable#View_transformPivotX
 */

public void setPivotX(float pivotX) { throw new RuntimeException("Stub!"); }

/**
 * The y location of the point around which the view is {@link #setRotation(float) rotated}
 * and {@link #setScaleY(float) scaled}.
 *
 * @see #getRotation()
 * @see #getScaleX()
 * @see #getScaleY()
 * @see #getPivotY()
 * @return The y location of the pivot point.
 *
 * @attr ref android.R.styleable#View_transformPivotY
 */

@android.view.ViewDebug.ExportedProperty(category="drawing") public float getPivotY() { throw new RuntimeException("Stub!"); }

/**
 * Sets the y location of the point around which the view is {@link #setRotation(float) rotated}
 * and {@link #setScaleY(float) scaled}. By default, the pivot point is centered on the object.
 * Setting this property disables this behavior and causes the view to use only the
 * explicitly set pivotX and pivotY values.
 *
 * @param pivotY The y location of the pivot point.
 * @see #getRotation()
 * @see #getScaleX()
 * @see #getScaleY()
 * @see #getPivotY()
 *
 * @attr ref android.R.styleable#View_transformPivotY
 */

public void setPivotY(float pivotY) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether or not a pivot has been set by a call to {@link #setPivotX(float)} or
 * {@link #setPivotY(float)}. If no pivot has been set then the pivot will be the center
 * of the view.
 *
 * @return True if a pivot has been set, false if the default pivot is being used
 */

public boolean isPivotSet() { throw new RuntimeException("Stub!"); }

/**
 * Clears any pivot previously set by a call to  {@link #setPivotX(float)} or
 * {@link #setPivotY(float)}. After calling this {@link #isPivotSet()} will be false
 * and the pivot used for rotation will return to default of being centered on the view.
 */

public void resetPivot() { throw new RuntimeException("Stub!"); }

/**
 * The opacity of the view. This is a value from 0 to 1, where 0 means the view is
 * completely transparent and 1 means the view is completely opaque.
 *
 * <p>By default this is 1.0f.
 * @return The opacity of the view.
 */

@android.view.ViewDebug.ExportedProperty(category="drawing") public float getAlpha() { throw new RuntimeException("Stub!"); }

/**
 * Sets the behavior for overlapping rendering for this view (see {@link
 * #hasOverlappingRendering()} for more details on this behavior). Calling this method
 * is an alternative to overriding {@link #hasOverlappingRendering()} in a subclass,
 * providing the value which is then used internally. That is, when {@link
 * #forceHasOverlappingRendering(boolean)} is called, the value of {@link
 * #hasOverlappingRendering()} is ignored and the value passed into this method is used
 * instead.
 *
 * @param hasOverlappingRendering The value for overlapping rendering to be used internally
 * instead of that returned by {@link #hasOverlappingRendering()}.
 *
 * @attr ref android.R.styleable#View_forceHasOverlappingRendering
 */

public void forceHasOverlappingRendering(boolean hasOverlappingRendering) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value for overlapping rendering that is used internally. This is either
 * the value passed into {@link #forceHasOverlappingRendering(boolean)}, if called, or
 * the return value of {@link #hasOverlappingRendering()}, otherwise.
 *
 * @return The value for overlapping rendering being used internally.
 */

public final boolean getHasOverlappingRendering() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether this View has content which overlaps.
 *
 * <p>This function, intended to be overridden by specific View types, is an optimization when
 * alpha is set on a view. If rendering overlaps in a view with alpha < 1, that view is drawn to
 * an offscreen buffer and then composited into place, which can be expensive. If the view has
 * no overlapping rendering, the view can draw each primitive with the appropriate alpha value
 * directly. An example of overlapping rendering is a TextView with a background image, such as
 * a Button. An example of non-overlapping rendering is a TextView with no background, or an
 * ImageView with only the foreground image. The default implementation returns true; subclasses
 * should override if they have cases which can be optimized.</p>
 *
 * <p><strong>Note:</strong> The return value of this method is ignored if {@link
 * #forceHasOverlappingRendering(boolean)} has been called on this view.</p>
 *
 * @return true if the content in this view might overlap, false otherwise.
 */

@android.view.ViewDebug.ExportedProperty(category="drawing") public boolean hasOverlappingRendering() { throw new RuntimeException("Stub!"); }

/**
 * Sets the opacity of the view to a value from 0 to 1, where 0 means the view is
 * completely transparent and 1 means the view is completely opaque.
 *
 * <p class="note"><strong>Note:</strong> setting alpha to a translucent value (0 < alpha < 1)
 * can have significant performance implications, especially for large views. It is best to use
 * the alpha property sparingly and transiently, as in the case of fading animations.</p>
 *
 * <p>For a view with a frequently changing alpha, such as during a fading animation, it is
 * strongly recommended for performance reasons to either override
 * {@link #hasOverlappingRendering()} to return <code>false</code> if appropriate, or setting a
 * {@link #setLayerType(int, android.graphics.Paint) layer type} on the view for the duration
 * of the animation. On versions {@link android.os.Build.VERSION_CODES#M} and below,
 * the default path for rendering an unlayered View with alpha could add multiple milliseconds
 * of rendering cost, even for simple or small views. Starting with
 * {@link android.os.Build.VERSION_CODES#M}, {@link #LAYER_TYPE_HARDWARE} is automatically
 * applied to the view at the rendering level.</p>
 *
 * <p>If this view overrides {@link #onSetAlpha(int)} to return true, then this view is
 * responsible for applying the opacity itself.</p>
 *
 * <p>On versions {@link android.os.Build.VERSION_CODES#LOLLIPOP_MR1} and below, note that if
 * the view is backed by a {@link #setLayerType(int, android.graphics.Paint) layer} and is
 * associated with a {@link #setLayerPaint(android.graphics.Paint) layer paint}, setting an
 * alpha value less than 1.0 will supersede the alpha of the layer paint.</p>
 *
 * <p>Starting with {@link android.os.Build.VERSION_CODES#M}, setting a translucent alpha
 * value will clip a View to its bounds, unless the View returns <code>false</code> from
 * {@link #hasOverlappingRendering}.</p>
 *
 * @param alpha The opacity of the view.
 *
 * Value is between 0.0 and 1.0 inclusive
 * @see #hasOverlappingRendering()
 * @see #setLayerType(int, android.graphics.Paint)
 *
 * @attr ref android.R.styleable#View_alpha
 */

public void setAlpha(float alpha) { throw new RuntimeException("Stub!"); }

/**
 * Top position of this view relative to its parent.
 *
 * @return The top of this view, in pixels.
 */

@android.view.ViewDebug.CapturedViewProperty public final int getTop() { throw new RuntimeException("Stub!"); }

/**
 * Sets the top position of this view relative to its parent. This method is meant to be called
 * by the layout system and should not generally be called otherwise, because the property
 * may be changed at any time by the layout.
 *
 * @param top The top of this view, in pixels.
 */

public final void setTop(int top) { throw new RuntimeException("Stub!"); }

/**
 * Bottom position of this view relative to its parent.
 *
 * @return The bottom of this view, in pixels.
 */

@android.view.ViewDebug.CapturedViewProperty public final int getBottom() { throw new RuntimeException("Stub!"); }

/**
 * True if this view has changed since the last time being drawn.
 *
 * @return The dirty state of this view.
 */

public boolean isDirty() { throw new RuntimeException("Stub!"); }

/**
 * Sets the bottom position of this view relative to its parent. This method is meant to be
 * called by the layout system and should not generally be called otherwise, because the
 * property may be changed at any time by the layout.
 *
 * @param bottom The bottom of this view, in pixels.
 */

public final void setBottom(int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Left position of this view relative to its parent.
 *
 * @return The left edge of this view, in pixels.
 */

@android.view.ViewDebug.CapturedViewProperty public final int getLeft() { throw new RuntimeException("Stub!"); }

/**
 * Sets the left position of this view relative to its parent. This method is meant to be called
 * by the layout system and should not generally be called otherwise, because the property
 * may be changed at any time by the layout.
 *
 * @param left The left of this view, in pixels.
 */

public final void setLeft(int left) { throw new RuntimeException("Stub!"); }

/**
 * Right position of this view relative to its parent.
 *
 * @return The right edge of this view, in pixels.
 */

@android.view.ViewDebug.CapturedViewProperty public final int getRight() { throw new RuntimeException("Stub!"); }

/**
 * Sets the right position of this view relative to its parent. This method is meant to be called
 * by the layout system and should not generally be called otherwise, because the property
 * may be changed at any time by the layout.
 *
 * @param right The right of this view, in pixels.
 */

public final void setRight(int right) { throw new RuntimeException("Stub!"); }

/**
 * The visual x position of this view, in pixels. This is equivalent to the
 * {@link #setTranslationX(float) translationX} property plus the current
 * {@link #getLeft() left} property.
 *
 * @return The visual x position of this view, in pixels.
 */

@android.view.ViewDebug.ExportedProperty(category="drawing") public float getX() { throw new RuntimeException("Stub!"); }

/**
 * Sets the visual x position of this view, in pixels. This is equivalent to setting the
 * {@link #setTranslationX(float) translationX} property to be the difference between
 * the x value passed in and the current {@link #getLeft() left} property.
 *
 * @param x The visual x position of this view, in pixels.
 */

public void setX(float x) { throw new RuntimeException("Stub!"); }

/**
 * The visual y position of this view, in pixels. This is equivalent to the
 * {@link #setTranslationY(float) translationY} property plus the current
 * {@link #getTop() top} property.
 *
 * @return The visual y position of this view, in pixels.
 */

@android.view.ViewDebug.ExportedProperty(category="drawing") public float getY() { throw new RuntimeException("Stub!"); }

/**
 * Sets the visual y position of this view, in pixels. This is equivalent to setting the
 * {@link #setTranslationY(float) translationY} property to be the difference between
 * the y value passed in and the current {@link #getTop() top} property.
 *
 * @param y The visual y position of this view, in pixels.
 */

public void setY(float y) { throw new RuntimeException("Stub!"); }

/**
 * The visual z position of this view, in pixels. This is equivalent to the
 * {@link #setTranslationZ(float) translationZ} property plus the current
 * {@link #getElevation() elevation} property.
 *
 * @return The visual z position of this view, in pixels.
 */

@android.view.ViewDebug.ExportedProperty(category="drawing") public float getZ() { throw new RuntimeException("Stub!"); }

/**
 * Sets the visual z position of this view, in pixels. This is equivalent to setting the
 * {@link #setTranslationZ(float) translationZ} property to be the difference between
 * the x value passed in and the current {@link #getElevation() elevation} property.
 *
 * @param z The visual z position of this view, in pixels.
 */

public void setZ(float z) { throw new RuntimeException("Stub!"); }

/**
 * The base elevation of this view relative to its parent, in pixels.
 *
 * @return The base depth position of the view, in pixels.
 */

@android.view.ViewDebug.ExportedProperty(category="drawing") public float getElevation() { throw new RuntimeException("Stub!"); }

/**
 * Sets the base elevation of this view, in pixels.
 *
 * @attr ref android.R.styleable#View_elevation
 */

public void setElevation(float elevation) { throw new RuntimeException("Stub!"); }

/**
 * The horizontal location of this view relative to its {@link #getLeft() left} position.
 * This position is post-layout, in addition to wherever the object's
 * layout placed it.
 *
 * @return The horizontal position of this view relative to its left position, in pixels.
 */

@android.view.ViewDebug.ExportedProperty(category="drawing") public float getTranslationX() { throw new RuntimeException("Stub!"); }

/**
 * Sets the horizontal location of this view relative to its {@link #getLeft() left} position.
 * This effectively positions the object post-layout, in addition to wherever the object's
 * layout placed it.
 *
 * @param translationX The horizontal position of this view relative to its left position,
 * in pixels.
 *
 * @attr ref android.R.styleable#View_translationX
 */

public void setTranslationX(float translationX) { throw new RuntimeException("Stub!"); }

/**
 * The vertical location of this view relative to its {@link #getTop() top} position.
 * This position is post-layout, in addition to wherever the object's
 * layout placed it.
 *
 * @return The vertical position of this view relative to its top position,
 * in pixels.
 */

@android.view.ViewDebug.ExportedProperty(category="drawing") public float getTranslationY() { throw new RuntimeException("Stub!"); }

/**
 * Sets the vertical location of this view relative to its {@link #getTop() top} position.
 * This effectively positions the object post-layout, in addition to wherever the object's
 * layout placed it.
 *
 * @param translationY The vertical position of this view relative to its top position,
 * in pixels.
 *
 * @attr ref android.R.styleable#View_translationY
 */

public void setTranslationY(float translationY) { throw new RuntimeException("Stub!"); }

/**
 * The depth location of this view relative to its {@link #getElevation() elevation}.
 *
 * @return The depth of this view relative to its elevation.
 */

@android.view.ViewDebug.ExportedProperty(category="drawing") public float getTranslationZ() { throw new RuntimeException("Stub!"); }

/**
 * Sets the depth location of this view relative to its {@link #getElevation() elevation}.
 *
 * @attr ref android.R.styleable#View_translationZ
 */

public void setTranslationZ(float translationZ) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current StateListAnimator if exists.
 *
 * @return StateListAnimator or null if it does not exists
 * @see    #setStateListAnimator(android.animation.StateListAnimator)
 */

public android.animation.StateListAnimator getStateListAnimator() { throw new RuntimeException("Stub!"); }

/**
 * Attaches the provided StateListAnimator to this View.
 * <p>
 * Any previously attached StateListAnimator will be detached.
 *
 * @param stateListAnimator The StateListAnimator to update the view
 * @see android.animation.StateListAnimator
 */

public void setStateListAnimator(android.animation.StateListAnimator stateListAnimator) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the Outline should be used to clip the contents of the View.
 * <p>
 * Note that this flag will only be respected if the View's Outline returns true from
 * {@link Outline#canClip()}.
 *
 * @see #setOutlineProvider(ViewOutlineProvider)
 * @see #setClipToOutline(boolean)
 */

public final boolean getClipToOutline() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the View's Outline should be used to clip the contents of the View.
 * <p>
 * Only a single non-rectangular clip can be applied on a View at any time.
 * Circular clips from a {@link ViewAnimationUtils#createCircularReveal(View, int, int, float, float)
 * circular reveal} animation take priority over Outline clipping, and
 * child Outline clipping takes priority over Outline clipping done by a
 * parent.
 * <p>
 * Note that this flag will only be respected if the View's Outline returns true from
 * {@link Outline#canClip()}.
 *
 * @see #setOutlineProvider(ViewOutlineProvider)
 * @see #getClipToOutline()
 */

public void setClipToOutline(boolean clipToOutline) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link ViewOutlineProvider} of the view, which generates the Outline that defines
 * the shape of the shadow it casts, and enables outline clipping.
 * <p>
 * The default ViewOutlineProvider, {@link ViewOutlineProvider#BACKGROUND}, queries the Outline
 * from the View's background drawable, via {@link Drawable#getOutline(Outline)}. Changing the
 * outline provider with this method allows this behavior to be overridden.
 * <p>
 * If the ViewOutlineProvider is null, if querying it for an outline returns false,
 * or if the produced Outline is {@link Outline#isEmpty()}, shadows will not be cast.
 * <p>
 * Only outlines that return true from {@link Outline#canClip()} may be used for clipping.
 *
 * @see #setClipToOutline(boolean)
 * @see #getClipToOutline()
 * @see #getOutlineProvider()
 */

public void setOutlineProvider(android.view.ViewOutlineProvider provider) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current {@link ViewOutlineProvider} of the view, which generates the Outline
 * that defines the shape of the shadow it casts, and enables outline clipping.
 *
 * @see #setOutlineProvider(ViewOutlineProvider)
 */

public android.view.ViewOutlineProvider getOutlineProvider() { throw new RuntimeException("Stub!"); }

/**
 * Called to rebuild this View's Outline from its {@link ViewOutlineProvider outline provider}
 *
 * @see #setOutlineProvider(ViewOutlineProvider)
 */

public void invalidateOutline() { throw new RuntimeException("Stub!"); }

/**
 * Sets the color of the spot shadow that is drawn when the view has a positive Z or
 * elevation value.
 * <p>
 * By default the shadow color is black. Generally, this color will be opaque so the intensity
 * of the shadow is consistent between different views with different colors.
 * <p>
 * The opacity of the final spot shadow is a function of the shadow caster height, the
 * alpha channel of the outlineSpotShadowColor (typically opaque), and the
 * {@link android.R.attr#spotShadowAlpha} theme attribute.
 *
 * @attr ref android.R.styleable#View_outlineSpotShadowColor
 * @param color The color this View will cast for its elevation spot shadow.
 */

public void setOutlineSpotShadowColor(int color) { throw new RuntimeException("Stub!"); }

/**
 * @return The shadow color set by {@link #setOutlineSpotShadowColor(int)}, or black if nothing
 * was set
 */

public int getOutlineSpotShadowColor() { throw new RuntimeException("Stub!"); }

/**
 * Sets the color of the ambient shadow that is drawn when the view has a positive Z or
 * elevation value.
 * <p>
 * By default the shadow color is black. Generally, this color will be opaque so the intensity
 * of the shadow is consistent between different views with different colors.
 * <p>
 * The opacity of the final ambient shadow is a function of the shadow caster height, the
 * alpha channel of the outlineAmbientShadowColor (typically opaque), and the
 * {@link android.R.attr#ambientShadowAlpha} theme attribute.
 *
 * @attr ref android.R.styleable#View_outlineAmbientShadowColor
 * @param color The color this View will cast for its elevation shadow.
 */

public void setOutlineAmbientShadowColor(int color) { throw new RuntimeException("Stub!"); }

/**
 * @return The shadow color set by {@link #setOutlineAmbientShadowColor(int)}, or black if
 * nothing was set
 */

public int getOutlineAmbientShadowColor() { throw new RuntimeException("Stub!"); }

/**
 * Hit rectangle in parent's coordinates
 *
 * @param outRect The hit rectangle of the view.
 */

public void getHitRect(android.graphics.Rect outRect) { throw new RuntimeException("Stub!"); }

/**
 * When a view has focus and the user navigates away from it, the next view is searched for
 * starting from the rectangle filled in by this method.
 *
 * By default, the rectangle is the {@link #getDrawingRect(android.graphics.Rect)})
 * of the view.  However, if your view maintains some idea of internal selection,
 * such as a cursor, or a selected row or column, you should override this method and
 * fill in a more specific rectangle.
 *
 * @param r The rectangle to fill in, in this view's coordinates.
 */

public void getFocusedRect(android.graphics.Rect r) { throw new RuntimeException("Stub!"); }

/**
 * If some part of this view is not clipped by any of its parents, then
 * return that area in r in global (root) coordinates. To convert r to local
 * coordinates (without taking possible View rotations into account), offset
 * it by -globalOffset (e.g. r.offset(-globalOffset.x, -globalOffset.y)).
 * If the view is completely clipped or translated out, return false.
 *
 * @param r If true is returned, r holds the global coordinates of the
 *        visible portion of this view.
 * @param globalOffset If true is returned, globalOffset holds the dx,dy
 *        between this view and its root. globalOffet may be null.
 * @return true if r is non-empty (i.e. part of the view is visible at the
 *         root level.
 */

public boolean getGlobalVisibleRect(android.graphics.Rect r, android.graphics.Point globalOffset) { throw new RuntimeException("Stub!"); }

public final boolean getGlobalVisibleRect(android.graphics.Rect r) { throw new RuntimeException("Stub!"); }

public final boolean getLocalVisibleRect(android.graphics.Rect r) { throw new RuntimeException("Stub!"); }

/**
 * Offset this view's vertical location by the specified number of pixels.
 *
 * @param offset the number of pixels to offset the view by
 */

public void offsetTopAndBottom(int offset) { throw new RuntimeException("Stub!"); }

/**
 * Offset this view's horizontal location by the specified amount of pixels.
 *
 * @param offset the number of pixels to offset the view by
 */

public void offsetLeftAndRight(int offset) { throw new RuntimeException("Stub!"); }

/**
 * Get the LayoutParams associated with this view. All views should have
 * layout parameters. These supply parameters to the <i>parent</i> of this
 * view specifying how it should be arranged. There are many subclasses of
 * ViewGroup.LayoutParams, and these correspond to the different subclasses
 * of ViewGroup that are responsible for arranging their children.
 *
 * This method may return null if this View is not attached to a parent
 * ViewGroup or {@link #setLayoutParams(android.view.ViewGroup.LayoutParams)}
 * was not invoked successfully. When a View is attached to a parent
 * ViewGroup, this method must not return null.
 *
 * @return The LayoutParams associated with this view, or null if no
 *         parameters have been set yet
 */

@android.view.ViewDebug.ExportedProperty(deepExport=true, prefix="layout_") public android.view.ViewGroup.LayoutParams getLayoutParams() { throw new RuntimeException("Stub!"); }

/**
 * Set the layout parameters associated with this view. These supply
 * parameters to the <i>parent</i> of this view specifying how it should be
 * arranged. There are many subclasses of ViewGroup.LayoutParams, and these
 * correspond to the different subclasses of ViewGroup that are responsible
 * for arranging their children.
 *
 * @param params The layout parameters for this view, cannot be null
 */

public void setLayoutParams(android.view.ViewGroup.LayoutParams params) { throw new RuntimeException("Stub!"); }

/**
 * Set the scrolled position of your view. This will cause a call to
 * {@link #onScrollChanged(int, int, int, int)} and the view will be
 * invalidated.
 * @param x the x position to scroll to
 * @param y the y position to scroll to
 */

public void scrollTo(int x, int y) { throw new RuntimeException("Stub!"); }

/**
 * Move the scrolled position of your view. This will cause a call to
 * {@link #onScrollChanged(int, int, int, int)} and the view will be
 * invalidated.
 * @param x the amount of pixels to scroll by horizontally
 * @param y the amount of pixels to scroll by vertically
 */

public void scrollBy(int x, int y) { throw new RuntimeException("Stub!"); }

/**
 * <p>Trigger the scrollbars to draw. When invoked this method starts an
 * animation to fade the scrollbars out after a default delay. If a subclass
 * provides animated scrolling, the start delay should equal the duration
 * of the scrolling animation.</p>
 *
 * <p>The animation starts only if at least one of the scrollbars is
 * enabled, as specified by {@link #isHorizontalScrollBarEnabled()} and
 * {@link #isVerticalScrollBarEnabled()}. When the animation is started,
 * this method returns true, and false otherwise. If the animation is
 * started, this method calls {@link #invalidate()}; in that case the
 * caller should not call {@link #invalidate()}.</p>
 *
 * <p>This method should be invoked every time a subclass directly updates
 * the scroll parameters.</p>
 *
 * <p>This method is automatically invoked by {@link #scrollBy(int, int)}
 * and {@link #scrollTo(int, int)}.</p>
 *
 * @return true if the animation is played, false otherwise
 *
 * @see #awakenScrollBars(int)
 * @see #scrollBy(int, int)
 * @see #scrollTo(int, int)
 * @see #isHorizontalScrollBarEnabled()
 * @see #isVerticalScrollBarEnabled()
 * @see #setHorizontalScrollBarEnabled(boolean)
 * @see #setVerticalScrollBarEnabled(boolean)
 */

protected boolean awakenScrollBars() { throw new RuntimeException("Stub!"); }

/**
 * <p>
 * Trigger the scrollbars to draw. When invoked this method starts an
 * animation to fade the scrollbars out after a fixed delay. If a subclass
 * provides animated scrolling, the start delay should equal the duration of
 * the scrolling animation.
 * </p>
 *
 * <p>
 * The animation starts only if at least one of the scrollbars is enabled,
 * as specified by {@link #isHorizontalScrollBarEnabled()} and
 * {@link #isVerticalScrollBarEnabled()}. When the animation is started,
 * this method returns true, and false otherwise. If the animation is
 * started, this method calls {@link #invalidate()}; in that case the caller
 * should not call {@link #invalidate()}.
 * </p>
 *
 * <p>
 * This method should be invoked every time a subclass directly updates the
 * scroll parameters.
 * </p>
 *
 * @param startDelay the delay, in milliseconds, after which the animation
 *        should start; when the delay is 0, the animation starts
 *        immediately
 * @return true if the animation is played, false otherwise
 *
 * @see #scrollBy(int, int)
 * @see #scrollTo(int, int)
 * @see #isHorizontalScrollBarEnabled()
 * @see #isVerticalScrollBarEnabled()
 * @see #setHorizontalScrollBarEnabled(boolean)
 * @see #setVerticalScrollBarEnabled(boolean)
 */

protected boolean awakenScrollBars(int startDelay) { throw new RuntimeException("Stub!"); }

/**
 * <p>
 * Trigger the scrollbars to draw. When invoked this method starts an
 * animation to fade the scrollbars out after a fixed delay. If a subclass
 * provides animated scrolling, the start delay should equal the duration of
 * the scrolling animation.
 * </p>
 *
 * <p>
 * The animation starts only if at least one of the scrollbars is enabled,
 * as specified by {@link #isHorizontalScrollBarEnabled()} and
 * {@link #isVerticalScrollBarEnabled()}. When the animation is started,
 * this method returns true, and false otherwise. If the animation is
 * started, this method calls {@link #invalidate()} if the invalidate parameter
 * is set to true; in that case the caller
 * should not call {@link #invalidate()}.
 * </p>
 *
 * <p>
 * This method should be invoked every time a subclass directly updates the
 * scroll parameters.
 * </p>
 *
 * @param startDelay the delay, in milliseconds, after which the animation
 *        should start; when the delay is 0, the animation starts
 *        immediately
 *
 * @param invalidate Whether this method should call invalidate
 *
 * @return true if the animation is played, false otherwise
 *
 * @see #scrollBy(int, int)
 * @see #scrollTo(int, int)
 * @see #isHorizontalScrollBarEnabled()
 * @see #isVerticalScrollBarEnabled()
 * @see #setHorizontalScrollBarEnabled(boolean)
 * @see #setVerticalScrollBarEnabled(boolean)
 */

protected boolean awakenScrollBars(int startDelay, boolean invalidate) { throw new RuntimeException("Stub!"); }

/**
 * Mark the area defined by dirty as needing to be drawn. If the view is
 * visible, {@link #onDraw(android.graphics.Canvas)} will be called at some
 * point in the future.
 * <p>
 * This must be called from a UI thread. To call from a non-UI thread, call
 * {@link #postInvalidate()}.
 * <p>
 * <b>WARNING:</b> In API 19 and below, this method may be destructive to
 * {@code dirty}.
 *
 * @param dirty the rectangle representing the bounds of the dirty region
 *
 * @deprecated The switch to hardware accelerated rendering in API 14 reduced
 * the importance of the dirty rectangle. In API 21 the given rectangle is
 * ignored entirely in favor of an internally-calculated area instead.
 * Because of this, clients are encouraged to just call {@link #invalidate()}.
 */

@Deprecated public void invalidate(android.graphics.Rect dirty) { throw new RuntimeException("Stub!"); }

/**
 * Mark the area defined by the rect (l,t,r,b) as needing to be drawn. The
 * coordinates of the dirty rect are relative to the view. If the view is
 * visible, {@link #onDraw(android.graphics.Canvas)} will be called at some
 * point in the future.
 * <p>
 * This must be called from a UI thread. To call from a non-UI thread, call
 * {@link #postInvalidate()}.
 *
 * @param l the left position of the dirty region
 * @param t the top position of the dirty region
 * @param r the right position of the dirty region
 * @param b the bottom position of the dirty region
 *
 * @deprecated The switch to hardware accelerated rendering in API 14 reduced
 * the importance of the dirty rectangle. In API 21 the given rectangle is
 * ignored entirely in favor of an internally-calculated area instead.
 * Because of this, clients are encouraged to just call {@link #invalidate()}.
 */

@Deprecated public void invalidate(int l, int t, int r, int b) { throw new RuntimeException("Stub!"); }

/**
 * Invalidate the whole view. If the view is visible,
 * {@link #onDraw(android.graphics.Canvas)} will be called at some point in
 * the future.
 * <p>
 * This must be called from a UI thread. To call from a non-UI thread, call
 * {@link #postInvalidate()}.
 */

public void invalidate() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether this View is opaque. An opaque View guarantees that it will
 * draw all the pixels overlapping its bounds using a fully opaque color.
 *
 * Subclasses of View should override this method whenever possible to indicate
 * whether an instance is opaque. Opaque Views are treated in a special way by
 * the View hierarchy, possibly allowing it to perform optimizations during
 * invalidate/draw passes.
 *
 * @return True if this View is guaranteed to be fully opaque, false otherwise.
 */

@android.view.ViewDebug.ExportedProperty(category="drawing") public boolean isOpaque() { throw new RuntimeException("Stub!"); }

/**
 * @return A handler associated with the thread running the View. This
 * handler can be used to pump events in the UI events queue.
 */

public android.os.Handler getHandler() { throw new RuntimeException("Stub!"); }

/**
 * <p>Causes the Runnable to be added to the message queue.
 * The runnable will be run on the user interface thread.</p>
 *
 * @param action The Runnable that will be executed.
 *
 * @return Returns true if the Runnable was successfully placed in to the
 *         message queue.  Returns false on failure, usually because the
 *         looper processing the message queue is exiting.
 *
 * @see #postDelayed
 * @see #removeCallbacks
 */

public boolean post(java.lang.Runnable action) { throw new RuntimeException("Stub!"); }

/**
 * <p>Causes the Runnable to be added to the message queue, to be run
 * after the specified amount of time elapses.
 * The runnable will be run on the user interface thread.</p>
 *
 * @param action The Runnable that will be executed.
 * @param delayMillis The delay (in milliseconds) until the Runnable
 *        will be executed.
 *
 * @return true if the Runnable was successfully placed in to the
 *         message queue.  Returns false on failure, usually because the
 *         looper processing the message queue is exiting.  Note that a
 *         result of true does not mean the Runnable will be processed --
 *         if the looper is quit before the delivery time of the message
 *         occurs then the message will be dropped.
 *
 * @see #post
 * @see #removeCallbacks
 */

public boolean postDelayed(java.lang.Runnable action, long delayMillis) { throw new RuntimeException("Stub!"); }

/**
 * <p>Causes the Runnable to execute on the next animation time step.
 * The runnable will be run on the user interface thread.</p>
 *
 * @param action The Runnable that will be executed.
 *
 * @see #postOnAnimationDelayed
 * @see #removeCallbacks
 */

public void postOnAnimation(java.lang.Runnable action) { throw new RuntimeException("Stub!"); }

/**
 * <p>Causes the Runnable to execute on the next animation time step,
 * after the specified amount of time elapses.
 * The runnable will be run on the user interface thread.</p>
 *
 * @param action The Runnable that will be executed.
 * @param delayMillis The delay (in milliseconds) until the Runnable
 *        will be executed.
 *
 * @see #postOnAnimation
 * @see #removeCallbacks
 */

public void postOnAnimationDelayed(java.lang.Runnable action, long delayMillis) { throw new RuntimeException("Stub!"); }

/**
 * <p>Removes the specified Runnable from the message queue.</p>
 *
 * @param action The Runnable to remove from the message handling queue
 *
 * @return true if this view could ask the Handler to remove the Runnable,
 *         false otherwise. When the returned value is true, the Runnable
 *         may or may not have been actually removed from the message queue
 *         (for instance, if the Runnable was not in the queue already.)
 *
 * @see #post
 * @see #postDelayed
 * @see #postOnAnimation
 * @see #postOnAnimationDelayed
 */

public boolean removeCallbacks(java.lang.Runnable action) { throw new RuntimeException("Stub!"); }

/**
 * <p>Cause an invalidate to happen on a subsequent cycle through the event loop.
 * Use this to invalidate the View from a non-UI thread.</p>
 *
 * <p>This method can be invoked from outside of the UI thread
 * only when this View is attached to a window.</p>
 *
 * @see #invalidate()
 * @see #postInvalidateDelayed(long)
 */

public void postInvalidate() { throw new RuntimeException("Stub!"); }

/**
 * <p>Cause an invalidate of the specified area to happen on a subsequent cycle
 * through the event loop. Use this to invalidate the View from a non-UI thread.</p>
 *
 * <p>This method can be invoked from outside of the UI thread
 * only when this View is attached to a window.</p>
 *
 * @param left The left coordinate of the rectangle to invalidate.
 * @param top The top coordinate of the rectangle to invalidate.
 * @param right The right coordinate of the rectangle to invalidate.
 * @param bottom The bottom coordinate of the rectangle to invalidate.
 *
 * @see #invalidate(int, int, int, int)
 * @see #invalidate(Rect)
 * @see #postInvalidateDelayed(long, int, int, int, int)
 */

public void postInvalidate(int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * <p>Cause an invalidate to happen on a subsequent cycle through the event
 * loop. Waits for the specified amount of time.</p>
 *
 * <p>This method can be invoked from outside of the UI thread
 * only when this View is attached to a window.</p>
 *
 * @param delayMilliseconds the duration in milliseconds to delay the
 *         invalidation by
 *
 * @see #invalidate()
 * @see #postInvalidate()
 */

public void postInvalidateDelayed(long delayMilliseconds) { throw new RuntimeException("Stub!"); }

/**
 * <p>Cause an invalidate of the specified area to happen on a subsequent cycle
 * through the event loop. Waits for the specified amount of time.</p>
 *
 * <p>This method can be invoked from outside of the UI thread
 * only when this View is attached to a window.</p>
 *
 * @param delayMilliseconds the duration in milliseconds to delay the
 *         invalidation by
 * @param left The left coordinate of the rectangle to invalidate.
 * @param top The top coordinate of the rectangle to invalidate.
 * @param right The right coordinate of the rectangle to invalidate.
 * @param bottom The bottom coordinate of the rectangle to invalidate.
 *
 * @see #invalidate(int, int, int, int)
 * @see #invalidate(Rect)
 * @see #postInvalidate(int, int, int, int)
 */

public void postInvalidateDelayed(long delayMilliseconds, int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * <p>Cause an invalidate to happen on the next animation time step, typically the
 * next display frame.</p>
 *
 * <p>This method can be invoked from outside of the UI thread
 * only when this View is attached to a window.</p>
 *
 * @see #invalidate()
 */

public void postInvalidateOnAnimation() { throw new RuntimeException("Stub!"); }

/**
 * <p>Cause an invalidate of the specified area to happen on the next animation
 * time step, typically the next display frame.</p>
 *
 * <p>This method can be invoked from outside of the UI thread
 * only when this View is attached to a window.</p>
 *
 * @param left The left coordinate of the rectangle to invalidate.
 * @param top The top coordinate of the rectangle to invalidate.
 * @param right The right coordinate of the rectangle to invalidate.
 * @param bottom The bottom coordinate of the rectangle to invalidate.
 *
 * @see #invalidate(int, int, int, int)
 * @see #invalidate(Rect)
 */

public void postInvalidateOnAnimation(int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Called by a parent to request that a child update its values for mScrollX
 * and mScrollY if necessary. This will typically be done if the child is
 * animating a scroll using a {@link android.widget.Scroller Scroller}
 * object.
 */

public void computeScroll() { throw new RuntimeException("Stub!"); }

/**
 * <p>Indicate whether the horizontal edges are faded when the view is
 * scrolled horizontally.</p>
 *
 * @return true if the horizontal edges should are faded on scroll, false
 *         otherwise
 *
 * @see #setHorizontalFadingEdgeEnabled(boolean)
 *
 * @attr ref android.R.styleable#View_requiresFadingEdge
 */

public boolean isHorizontalFadingEdgeEnabled() { throw new RuntimeException("Stub!"); }

/**
 * <p>Define whether the horizontal edges should be faded when this view
 * is scrolled horizontally.</p>
 *
 * @param horizontalFadingEdgeEnabled true if the horizontal edges should
 *                                    be faded when the view is scrolled
 *                                    horizontally
 *
 * @see #isHorizontalFadingEdgeEnabled()
 *
 * @attr ref android.R.styleable#View_requiresFadingEdge
 */

public void setHorizontalFadingEdgeEnabled(boolean horizontalFadingEdgeEnabled) { throw new RuntimeException("Stub!"); }

/**
 * <p>Indicate whether the vertical edges are faded when the view is
 * scrolled horizontally.</p>
 *
 * @return true if the vertical edges should are faded on scroll, false
 *         otherwise
 *
 * @see #setVerticalFadingEdgeEnabled(boolean)
 *
 * @attr ref android.R.styleable#View_requiresFadingEdge
 */

public boolean isVerticalFadingEdgeEnabled() { throw new RuntimeException("Stub!"); }

/**
 * <p>Define whether the vertical edges should be faded when this view
 * is scrolled vertically.</p>
 *
 * @param verticalFadingEdgeEnabled true if the vertical edges should
 *                                  be faded when the view is scrolled
 *                                  vertically
 *
 * @see #isVerticalFadingEdgeEnabled()
 *
 * @attr ref android.R.styleable#View_requiresFadingEdge
 */

public void setVerticalFadingEdgeEnabled(boolean verticalFadingEdgeEnabled) { throw new RuntimeException("Stub!"); }

/**
 * Returns the strength, or intensity, of the top faded edge. The strength is
 * a value between 0.0 (no fade) and 1.0 (full fade). The default implementation
 * returns 0.0 or 1.0 but no value in between.
 *
 * Subclasses should override this method to provide a smoother fade transition
 * when scrolling occurs.
 *
 * @return the intensity of the top fade as a float between 0.0f and 1.0f
 */

protected float getTopFadingEdgeStrength() { throw new RuntimeException("Stub!"); }

/**
 * Returns the strength, or intensity, of the bottom faded edge. The strength is
 * a value between 0.0 (no fade) and 1.0 (full fade). The default implementation
 * returns 0.0 or 1.0 but no value in between.
 *
 * Subclasses should override this method to provide a smoother fade transition
 * when scrolling occurs.
 *
 * @return the intensity of the bottom fade as a float between 0.0f and 1.0f
 */

protected float getBottomFadingEdgeStrength() { throw new RuntimeException("Stub!"); }

/**
 * Returns the strength, or intensity, of the left faded edge. The strength is
 * a value between 0.0 (no fade) and 1.0 (full fade). The default implementation
 * returns 0.0 or 1.0 but no value in between.
 *
 * Subclasses should override this method to provide a smoother fade transition
 * when scrolling occurs.
 *
 * @return the intensity of the left fade as a float between 0.0f and 1.0f
 */

protected float getLeftFadingEdgeStrength() { throw new RuntimeException("Stub!"); }

/**
 * Returns the strength, or intensity, of the right faded edge. The strength is
 * a value between 0.0 (no fade) and 1.0 (full fade). The default implementation
 * returns 0.0 or 1.0 but no value in between.
 *
 * Subclasses should override this method to provide a smoother fade transition
 * when scrolling occurs.
 *
 * @return the intensity of the right fade as a float between 0.0f and 1.0f
 */

protected float getRightFadingEdgeStrength() { throw new RuntimeException("Stub!"); }

/**
 * <p>Indicate whether the horizontal scrollbar should be drawn or not. The
 * scrollbar is not drawn by default.</p>
 *
 * @return true if the horizontal scrollbar should be painted, false
 *         otherwise
 *
 * @see #setHorizontalScrollBarEnabled(boolean)
 */

public boolean isHorizontalScrollBarEnabled() { throw new RuntimeException("Stub!"); }

/**
 * <p>Define whether the horizontal scrollbar should be drawn or not. The
 * scrollbar is not drawn by default.</p>
 *
 * @param horizontalScrollBarEnabled true if the horizontal scrollbar should
 *                                   be painted
 *
 * @see #isHorizontalScrollBarEnabled()
 */

public void setHorizontalScrollBarEnabled(boolean horizontalScrollBarEnabled) { throw new RuntimeException("Stub!"); }

/**
 * <p>Indicate whether the vertical scrollbar should be drawn or not. The
 * scrollbar is not drawn by default.</p>
 *
 * @return true if the vertical scrollbar should be painted, false
 *         otherwise
 *
 * @see #setVerticalScrollBarEnabled(boolean)
 */

public boolean isVerticalScrollBarEnabled() { throw new RuntimeException("Stub!"); }

/**
 * <p>Define whether the vertical scrollbar should be drawn or not. The
 * scrollbar is not drawn by default.</p>
 *
 * @param verticalScrollBarEnabled true if the vertical scrollbar should
 *                                 be painted
 *
 * @see #isVerticalScrollBarEnabled()
 */

public void setVerticalScrollBarEnabled(boolean verticalScrollBarEnabled) { throw new RuntimeException("Stub!"); }

/**
 * Define whether scrollbars will fade when the view is not scrolling.
 *
 * @param fadeScrollbars whether to enable fading
 *
 * @attr ref android.R.styleable#View_fadeScrollbars
 */

public void setScrollbarFadingEnabled(boolean fadeScrollbars) { throw new RuntimeException("Stub!"); }

/**
 *
 * Returns true if scrollbars will fade when this view is not scrolling
 *
 * @return true if scrollbar fading is enabled
 *
 * @attr ref android.R.styleable#View_fadeScrollbars
 */

public boolean isScrollbarFadingEnabled() { throw new RuntimeException("Stub!"); }

/**
 *
 * Returns the delay before scrollbars fade.
 *
 * @return the delay before scrollbars fade
 *
 * @attr ref android.R.styleable#View_scrollbarDefaultDelayBeforeFade
 */

public int getScrollBarDefaultDelayBeforeFade() { throw new RuntimeException("Stub!"); }

/**
 * Define the delay before scrollbars fade.
 *
 * @param scrollBarDefaultDelayBeforeFade - the delay before scrollbars fade
 *
 * @attr ref android.R.styleable#View_scrollbarDefaultDelayBeforeFade
 */

public void setScrollBarDefaultDelayBeforeFade(int scrollBarDefaultDelayBeforeFade) { throw new RuntimeException("Stub!"); }

/**
 *
 * Returns the scrollbar fade duration.
 *
 * @return the scrollbar fade duration, in milliseconds
 *
 * @attr ref android.R.styleable#View_scrollbarFadeDuration
 */

public int getScrollBarFadeDuration() { throw new RuntimeException("Stub!"); }

/**
 * Define the scrollbar fade duration.
 *
 * @param scrollBarFadeDuration - the scrollbar fade duration, in milliseconds
 *
 * @attr ref android.R.styleable#View_scrollbarFadeDuration
 */

public void setScrollBarFadeDuration(int scrollBarFadeDuration) { throw new RuntimeException("Stub!"); }

/**
 *
 * Returns the scrollbar size.
 *
 * @return the scrollbar size
 *
 * @attr ref android.R.styleable#View_scrollbarSize
 */

public int getScrollBarSize() { throw new RuntimeException("Stub!"); }

/**
 * Define the scrollbar size.
 *
 * @param scrollBarSize - the scrollbar size
 *
 * @attr ref android.R.styleable#View_scrollbarSize
 */

public void setScrollBarSize(int scrollBarSize) { throw new RuntimeException("Stub!"); }

/**
 * <p>Specify the style of the scrollbars. The scrollbars can be overlaid or
 * inset. When inset, they add to the padding of the view. And the scrollbars
 * can be drawn inside the padding area or on the edge of the view. For example,
 * if a view has a background drawable and you want to draw the scrollbars
 * inside the padding specified by the drawable, you can use
 * SCROLLBARS_INSIDE_OVERLAY or SCROLLBARS_INSIDE_INSET. If you want them to
 * appear at the edge of the view, ignoring the padding, then you can use
 * SCROLLBARS_OUTSIDE_OVERLAY or SCROLLBARS_OUTSIDE_INSET.</p>
 * @param style the style of the scrollbars. Should be one of
 * SCROLLBARS_INSIDE_OVERLAY, SCROLLBARS_INSIDE_INSET,
 * SCROLLBARS_OUTSIDE_OVERLAY or SCROLLBARS_OUTSIDE_INSET.
 * Value is {@link android.view.View#SCROLLBARS_INSIDE_OVERLAY}, {@link android.view.View#SCROLLBARS_INSIDE_INSET}, {@link android.view.View#SCROLLBARS_OUTSIDE_OVERLAY}, or {@link android.view.View#SCROLLBARS_OUTSIDE_INSET}
 * @see #SCROLLBARS_INSIDE_OVERLAY
 * @see #SCROLLBARS_INSIDE_INSET
 * @see #SCROLLBARS_OUTSIDE_OVERLAY
 * @see #SCROLLBARS_OUTSIDE_INSET
 *
 * @attr ref android.R.styleable#View_scrollbarStyle
 */

public void setScrollBarStyle(int style) { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the current scrollbar style.</p>
 * @return the current scrollbar style
 * Value is {@link android.view.View#SCROLLBARS_INSIDE_OVERLAY}, {@link android.view.View#SCROLLBARS_INSIDE_INSET}, {@link android.view.View#SCROLLBARS_OUTSIDE_OVERLAY}, or {@link android.view.View#SCROLLBARS_OUTSIDE_INSET}
 * @see #SCROLLBARS_INSIDE_OVERLAY
 * @see #SCROLLBARS_INSIDE_INSET
 * @see #SCROLLBARS_OUTSIDE_OVERLAY
 * @see #SCROLLBARS_OUTSIDE_INSET
 *
 * @attr ref android.R.styleable#View_scrollbarStyle
 */

@android.view.ViewDebug.ExportedProperty(mapping={@android.view.ViewDebug.IntToString(from=android.view.View.SCROLLBARS_INSIDE_OVERLAY, to="INSIDE_OVERLAY"), @android.view.ViewDebug.IntToString(from=android.view.View.SCROLLBARS_INSIDE_INSET, to="INSIDE_INSET"), @android.view.ViewDebug.IntToString(from=android.view.View.SCROLLBARS_OUTSIDE_OVERLAY, to="OUTSIDE_OVERLAY"), @android.view.ViewDebug.IntToString(from=android.view.View.SCROLLBARS_OUTSIDE_INSET, to="OUTSIDE_INSET")}) public int getScrollBarStyle() { throw new RuntimeException("Stub!"); }

/**
 * <p>Compute the horizontal range that the horizontal scrollbar
 * represents.</p>
 *
 * <p>The range is expressed in arbitrary units that must be the same as the
 * units used by {@link #computeHorizontalScrollExtent()} and
 * {@link #computeHorizontalScrollOffset()}.</p>
 *
 * <p>The default range is the drawing width of this view.</p>
 *
 * @return the total horizontal range represented by the horizontal
 *         scrollbar
 *
 * @see #computeHorizontalScrollExtent()
 * @see #computeHorizontalScrollOffset()
 * @see android.widget.ScrollBarDrawable
 */

protected int computeHorizontalScrollRange() { throw new RuntimeException("Stub!"); }

/**
 * <p>Compute the horizontal offset of the horizontal scrollbar's thumb
 * within the horizontal range. This value is used to compute the position
 * of the thumb within the scrollbar's track.</p>
 *
 * <p>The range is expressed in arbitrary units that must be the same as the
 * units used by {@link #computeHorizontalScrollRange()} and
 * {@link #computeHorizontalScrollExtent()}.</p>
 *
 * <p>The default offset is the scroll offset of this view.</p>
 *
 * @return the horizontal offset of the scrollbar's thumb
 *
 * @see #computeHorizontalScrollRange()
 * @see #computeHorizontalScrollExtent()
 * @see android.widget.ScrollBarDrawable
 */

protected int computeHorizontalScrollOffset() { throw new RuntimeException("Stub!"); }

/**
 * <p>Compute the horizontal extent of the horizontal scrollbar's thumb
 * within the horizontal range. This value is used to compute the length
 * of the thumb within the scrollbar's track.</p>
 *
 * <p>The range is expressed in arbitrary units that must be the same as the
 * units used by {@link #computeHorizontalScrollRange()} and
 * {@link #computeHorizontalScrollOffset()}.</p>
 *
 * <p>The default extent is the drawing width of this view.</p>
 *
 * @return the horizontal extent of the scrollbar's thumb
 *
 * @see #computeHorizontalScrollRange()
 * @see #computeHorizontalScrollOffset()
 * @see android.widget.ScrollBarDrawable
 */

protected int computeHorizontalScrollExtent() { throw new RuntimeException("Stub!"); }

/**
 * <p>Compute the vertical range that the vertical scrollbar represents.</p>
 *
 * <p>The range is expressed in arbitrary units that must be the same as the
 * units used by {@link #computeVerticalScrollExtent()} and
 * {@link #computeVerticalScrollOffset()}.</p>
 *
 * @return the total vertical range represented by the vertical scrollbar
 *
 * <p>The default range is the drawing height of this view.</p>
 *
 * @see #computeVerticalScrollExtent()
 * @see #computeVerticalScrollOffset()
 * @see android.widget.ScrollBarDrawable
 */

protected int computeVerticalScrollRange() { throw new RuntimeException("Stub!"); }

/**
 * <p>Compute the vertical offset of the vertical scrollbar's thumb
 * within the horizontal range. This value is used to compute the position
 * of the thumb within the scrollbar's track.</p>
 *
 * <p>The range is expressed in arbitrary units that must be the same as the
 * units used by {@link #computeVerticalScrollRange()} and
 * {@link #computeVerticalScrollExtent()}.</p>
 *
 * <p>The default offset is the scroll offset of this view.</p>
 *
 * @return the vertical offset of the scrollbar's thumb
 *
 * @see #computeVerticalScrollRange()
 * @see #computeVerticalScrollExtent()
 * @see android.widget.ScrollBarDrawable
 */

protected int computeVerticalScrollOffset() { throw new RuntimeException("Stub!"); }

/**
 * <p>Compute the vertical extent of the vertical scrollbar's thumb
 * within the vertical range. This value is used to compute the length
 * of the thumb within the scrollbar's track.</p>
 *
 * <p>The range is expressed in arbitrary units that must be the same as the
 * units used by {@link #computeVerticalScrollRange()} and
 * {@link #computeVerticalScrollOffset()}.</p>
 *
 * <p>The default extent is the drawing height of this view.</p>
 *
 * @return the vertical extent of the scrollbar's thumb
 *
 * @see #computeVerticalScrollRange()
 * @see #computeVerticalScrollOffset()
 * @see android.widget.ScrollBarDrawable
 */

protected int computeVerticalScrollExtent() { throw new RuntimeException("Stub!"); }

/**
 * Check if this view can be scrolled horizontally in a certain direction.
 *
 * @param direction Negative to check scrolling left, positive to check scrolling right.
 * @return true if this view can be scrolled in the specified direction, false otherwise.
 */

public boolean canScrollHorizontally(int direction) { throw new RuntimeException("Stub!"); }

/**
 * Check if this view can be scrolled vertically in a certain direction.
 *
 * @param direction Negative to check scrolling up, positive to check scrolling down.
 * @return true if this view can be scrolled in the specified direction, false otherwise.
 */

public boolean canScrollVertically(int direction) { throw new RuntimeException("Stub!"); }

/**
 * <p>Request the drawing of the horizontal and the vertical scrollbar. The
 * scrollbars are painted only if they have been awakened first.</p>
 *
 * @param canvas the canvas on which to draw the scrollbars
 *
 * @see #awakenScrollBars(int)
 */

protected final void onDrawScrollBars(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * Implement this to do your drawing.
 *
 * @param canvas the canvas on which the background will be drawn
 */

protected void onDraw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * This is called when the view is attached to a window.  At this point it
 * has a Surface and will start drawing.  Note that this function is
 * guaranteed to be called before {@link #onDraw(android.graphics.Canvas)},
 * however it may be called any time before the first onDraw -- including
 * before or after {@link #onMeasure(int, int)}.
 *
 * If you override this method you <em>must</em> call through to the
 *  *            superclass implementation.
 * @see #onDetachedFromWindow()
 */

protected void onAttachedToWindow() { throw new RuntimeException("Stub!"); }

/**
 * This method is called whenever the state of the screen this view is
 * attached to changes. A state change will usually occurs when the screen
 * turns on or off (whether it happens automatically or the user does it
 * manually.)
 *
 * @param screenState The new state of the screen. Can be either
 *                    {@link #SCREEN_STATE_ON} or {@link #SCREEN_STATE_OFF}
 */

public void onScreenStateChanged(int screenState) { throw new RuntimeException("Stub!"); }

/**
 * Called when any RTL property (layout direction or text direction or text alignment) has
 * been changed.
 *
 * Subclasses need to override this method to take care of cached information that depends on the
 * resolved layout direction, or to inform child views that inherit their layout direction.
 *
 * The default implementation does nothing.
 *
 * @param layoutDirection the direction of the layout
 *
 * Value is {@link android.view.View#LAYOUT_DIRECTION_LTR}, or {@link android.view.View#LAYOUT_DIRECTION_RTL}
 * @see #LAYOUT_DIRECTION_LTR
 * @see #LAYOUT_DIRECTION_RTL
 */

public void onRtlPropertiesChanged(int layoutDirection) { throw new RuntimeException("Stub!"); }

/**
 * Check if layout direction resolution can be done.
 *
 * @return true if layout direction resolution can be done otherwise return false.
 */

public boolean canResolveLayoutDirection() { throw new RuntimeException("Stub!"); }

/**
 * @return true if layout direction has been resolved.
 */

public boolean isLayoutDirectionResolved() { throw new RuntimeException("Stub!"); }

/**
 * This is called when the view is detached from a window.  At this point it
 * no longer has a surface for drawing.
 *
 * If you override this method you <em>must</em> call through to the
 *  *            superclass implementation.
 * @see #onAttachedToWindow()
 */

protected void onDetachedFromWindow() { throw new RuntimeException("Stub!"); }

/**
 * @return The number of times this view has been attached to a window
 */

protected int getWindowAttachCount() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a unique token identifying the window this view is attached to.
 * @return Return the window's token for use in
 * {@link WindowManager.LayoutParams#token WindowManager.LayoutParams.token}.
 */

public android.os.IBinder getWindowToken() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the {@link WindowId} for the window this view is
 * currently attached to.
 */

public android.view.WindowId getWindowId() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a unique token identifying the top-level "real" window of
 * the window that this view is attached to.  That is, this is like
 * {@link #getWindowToken}, except if the window this view in is a panel
 * window (attached to another containing window), then the token of
 * the containing window is returned instead.
 *
 * @return Returns the associated window token, either
 * {@link #getWindowToken()} or the containing window's token.
 */

public android.os.IBinder getApplicationWindowToken() { throw new RuntimeException("Stub!"); }

/**
 * Gets the logical display to which the view's window has been attached.
 *
 * @return The logical display, or null if the view is not currently attached to a window.
 */

public android.view.Display getDisplay() { throw new RuntimeException("Stub!"); }

/**
 * Cancel any deferred high-level input events that were previously posted to the event queue.
 *
 * <p>Many views post high-level events such as click handlers to the event queue
 * to run deferred in order to preserve a desired user experience - clearing visible
 * pressed states before executing, etc. This method will abort any events of this nature
 * that are currently in flight.</p>
 *
 * <p>Custom views that generate their own high-level deferred input events should override
 * {@link #onCancelPendingInputEvents()} and remove those pending events from the queue.</p>
 *
 * <p>This will also cancel pending input events for any child views.</p>
 *
 * <p>Note that this may not be sufficient as a debouncing strategy for clicks in all cases.
 * This will not impact newer events posted after this call that may occur as a result of
 * lower-level input events still waiting in the queue. If you are trying to prevent
 * double-submitted  events for the duration of some sort of asynchronous transaction
 * you should also take other steps to protect against unexpected double inputs e.g. calling
 * {@link #setEnabled(boolean) setEnabled(false)} and re-enabling the view when
 * the transaction completes, tracking already submitted transaction IDs, etc.</p>
 */

public final void cancelPendingInputEvents() { throw new RuntimeException("Stub!"); }

/**
 * Called as the result of a call to {@link #cancelPendingInputEvents()} on this view or
 * a parent view.
 *
 * <p>This method is responsible for removing any pending high-level input events that were
 * posted to the event queue to run later. Custom view classes that post their own deferred
 * high-level events via {@link #post(Runnable)}, {@link #postDelayed(Runnable, long)} or
 * {@link android.os.Handler} should override this method, call
 * <code>super.onCancelPendingInputEvents()</code> and remove those callbacks as appropriate.
 * </p>
 */

public void onCancelPendingInputEvents() { throw new RuntimeException("Stub!"); }

/**
 * Store this view hierarchy's frozen state into the given container.
 *
 * @param container The SparseArray in which to save the view's state.
 *
 * @see #restoreHierarchyState(android.util.SparseArray)
 * @see #dispatchSaveInstanceState(android.util.SparseArray)
 * @see #onSaveInstanceState()
 */

public void saveHierarchyState(android.util.SparseArray<android.os.Parcelable> container) { throw new RuntimeException("Stub!"); }

/**
 * Called by {@link #saveHierarchyState(android.util.SparseArray)} to store the state for
 * this view and its children. May be overridden to modify how freezing happens to a
 * view's children; for example, some views may want to not store state for their children.
 *
 * @param container The SparseArray in which to save the view's state.
 *
 * @see #dispatchRestoreInstanceState(android.util.SparseArray)
 * @see #saveHierarchyState(android.util.SparseArray)
 * @see #onSaveInstanceState()
 */

protected void dispatchSaveInstanceState(android.util.SparseArray<android.os.Parcelable> container) { throw new RuntimeException("Stub!"); }

/**
 * Hook allowing a view to generate a representation of its internal state
 * that can later be used to create a new instance with that same state.
 * This state should only contain information that is not persistent or can
 * not be reconstructed later. For example, you will never store your
 * current position on screen because that will be computed again when a
 * new instance of the view is placed in its view hierarchy.
 * <p>
 * Some examples of things you may store here: the current cursor position
 * in a text view (but usually not the text itself since that is stored in a
 * content provider or other persistent storage), the currently selected
 * item in a list view.
 *
 * If you override this method you <em>must</em> call through to the
 *  *            superclass implementation.
 * @return Returns a Parcelable object containing the view's current dynamic
 *         state, or null if there is nothing interesting to save.
 * @see #onRestoreInstanceState(Parcelable)
 * @see #saveHierarchyState(SparseArray)
 * @see #dispatchSaveInstanceState(SparseArray)
 * @see #setSaveEnabled(boolean)
 */

@androidx.annotation.RecentlyNullable protected android.os.Parcelable onSaveInstanceState() { throw new RuntimeException("Stub!"); }

/**
 * Restore this view hierarchy's frozen state from the given container.
 *
 * @param container The SparseArray which holds previously frozen states.
 *
 * @see #saveHierarchyState(android.util.SparseArray)
 * @see #dispatchRestoreInstanceState(android.util.SparseArray)
 * @see #onRestoreInstanceState(android.os.Parcelable)
 */

public void restoreHierarchyState(android.util.SparseArray<android.os.Parcelable> container) { throw new RuntimeException("Stub!"); }

/**
 * Called by {@link #restoreHierarchyState(android.util.SparseArray)} to retrieve the
 * state for this view and its children. May be overridden to modify how restoring
 * happens to a view's children; for example, some views may want to not store state
 * for their children.
 *
 * @param container The SparseArray which holds previously saved state.
 *
 * @see #dispatchSaveInstanceState(android.util.SparseArray)
 * @see #restoreHierarchyState(android.util.SparseArray)
 * @see #onRestoreInstanceState(android.os.Parcelable)
 */

protected void dispatchRestoreInstanceState(android.util.SparseArray<android.os.Parcelable> container) { throw new RuntimeException("Stub!"); }

/**
 * Hook allowing a view to re-apply a representation of its internal state that had previously
 * been generated by {@link #onSaveInstanceState}. This function will never be called with a
 * null state.
 *
 * If you override this method you <em>must</em> call through to the
 *  *            superclass implementation.
 * @param state The frozen state that had previously been returned by
 *        {@link #onSaveInstanceState}.
 *
 * @see #onSaveInstanceState()
 * @see #restoreHierarchyState(android.util.SparseArray)
 * @see #dispatchRestoreInstanceState(android.util.SparseArray)
 */

protected void onRestoreInstanceState(android.os.Parcelable state) { throw new RuntimeException("Stub!"); }

/**
 * <p>Return the time at which the drawing of the view hierarchy started.</p>
 *
 * @return the drawing start time in milliseconds
 */

public long getDrawingTime() { throw new RuntimeException("Stub!"); }

/**
 * <p>Enables or disables the duplication of the parent's state into this view. When
 * duplication is enabled, this view gets its drawable state from its parent rather
 * than from its own internal properties.</p>
 *
 * <p>Note: in the current implementation, setting this property to true after the
 * view was added to a ViewGroup might have no effect at all. This property should
 * always be used from XML or set to true before adding this view to a ViewGroup.</p>
 *
 * <p>Note: if this view's parent addStateFromChildren property is enabled and this
 * property is enabled, an exception will be thrown.</p>
 *
 * <p>Note: if the child view uses and updates additional states which are unknown to the
 * parent, these states should not be affected by this method.</p>
 *
 * @param enabled True to enable duplication of the parent's drawable state, false
 *                to disable it.
 *
 * @see #getDrawableState()
 * @see #isDuplicateParentStateEnabled()
 */

public void setDuplicateParentStateEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * <p>Indicates whether this duplicates its drawable state from its parent.</p>
 *
 * @return True if this view's drawable state is duplicated from the parent,
 *         false otherwise
 *
 * @see #getDrawableState()
 * @see #setDuplicateParentStateEnabled(boolean)
 */

public boolean isDuplicateParentStateEnabled() { throw new RuntimeException("Stub!"); }

/**
 * <p>Specifies the type of layer backing this view. The layer can be
 * {@link #LAYER_TYPE_NONE}, {@link #LAYER_TYPE_SOFTWARE} or
 * {@link #LAYER_TYPE_HARDWARE}.</p>
 *
 * <p>A layer is associated with an optional {@link android.graphics.Paint}
 * instance that controls how the layer is composed on screen. The following
 * properties of the paint are taken into account when composing the layer:</p>
 * <ul>
 * <li>{@link android.graphics.Paint#getAlpha() Translucency (alpha)}</li>
 * <li>{@link android.graphics.Paint#getXfermode() Blending mode}</li>
 * <li>{@link android.graphics.Paint#getColorFilter() Color filter}</li>
 * </ul>
 *
 * <p>If this view has an alpha value set to < 1.0 by calling
 * {@link #setAlpha(float)}, the alpha value of the layer's paint is superseded
 * by this view's alpha value.</p>
 *
 * <p>Refer to the documentation of {@link #LAYER_TYPE_NONE},
 * {@link #LAYER_TYPE_SOFTWARE} and {@link #LAYER_TYPE_HARDWARE}
 * for more information on when and how to use layers.</p>
 *
 * @param layerType The type of layer to use with this view, must be one of
 *        {@link #LAYER_TYPE_NONE}, {@link #LAYER_TYPE_SOFTWARE} or
 *        {@link #LAYER_TYPE_HARDWARE}
 * @param paint The paint used to compose the layer. This argument is optional
 *        and can be null. It is ignored when the layer type is
 *        {@link #LAYER_TYPE_NONE}
 *
 * This value may be {@code null}.
 * @see #getLayerType()
 * @see #LAYER_TYPE_NONE
 * @see #LAYER_TYPE_SOFTWARE
 * @see #LAYER_TYPE_HARDWARE
 * @see #setAlpha(float)
 *
 * @attr ref android.R.styleable#View_layerType
 */

public void setLayerType(int layerType, @androidx.annotation.RecentlyNullable android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Updates the {@link Paint} object used with the current layer (used only if the current
 * layer type is not set to {@link #LAYER_TYPE_NONE}). Changed properties of the Paint
 * provided to {@link #setLayerType(int, android.graphics.Paint)} will be used the next time
 * the View is redrawn, but {@link #setLayerPaint(android.graphics.Paint)} must be called to
 * ensure that the view gets redrawn immediately.
 *
 * <p>A layer is associated with an optional {@link android.graphics.Paint}
 * instance that controls how the layer is composed on screen. The following
 * properties of the paint are taken into account when composing the layer:</p>
 * <ul>
 * <li>{@link android.graphics.Paint#getAlpha() Translucency (alpha)}</li>
 * <li>{@link android.graphics.Paint#getXfermode() Blending mode}</li>
 * <li>{@link android.graphics.Paint#getColorFilter() Color filter}</li>
 * </ul>
 *
 * <p>If this view has an alpha value set to < 1.0 by calling {@link #setAlpha(float)}, the
 * alpha value of the layer's paint is superseded by this view's alpha value.</p>
 *
 * @param paint The paint used to compose the layer. This argument is optional
 *        and can be null. It is ignored when the layer type is
 *        {@link #LAYER_TYPE_NONE}
 *
 * This value may be {@code null}.
 * @see #setLayerType(int, android.graphics.Paint)
 */

public void setLayerPaint(@androidx.annotation.RecentlyNullable android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Indicates what type of layer is currently associated with this view. By default
 * a view does not have a layer, and the layer type is {@link #LAYER_TYPE_NONE}.
 * Refer to the documentation of {@link #setLayerType(int, android.graphics.Paint)}
 * for more information on the different types of layers.
 *
 * @return {@link #LAYER_TYPE_NONE}, {@link #LAYER_TYPE_SOFTWARE} or
 *         {@link #LAYER_TYPE_HARDWARE}
 *
 * @see #setLayerType(int, android.graphics.Paint)
 * @see #buildLayer()
 * @see #LAYER_TYPE_NONE
 * @see #LAYER_TYPE_SOFTWARE
 * @see #LAYER_TYPE_HARDWARE
 */

public int getLayerType() { throw new RuntimeException("Stub!"); }

/**
 * Forces this view's layer to be created and this view to be rendered
 * into its layer. If this view's layer type is set to {@link #LAYER_TYPE_NONE},
 * invoking this method will have no effect.
 *
 * This method can for instance be used to render a view into its layer before
 * starting an animation. If this view is complex, rendering into the layer
 * before starting the animation will avoid skipping frames.
 *
 * @throws IllegalStateException If this view is not attached to a window
 *
 * @see #setLayerType(int, android.graphics.Paint)
 */

public void buildLayer() { throw new RuntimeException("Stub!"); }

/**
 * <p>Enables or disables the drawing cache. When the drawing cache is enabled, the next call
 * to {@link #getDrawingCache()} or {@link #buildDrawingCache()} will draw the view in a
 * bitmap. Calling {@link #draw(android.graphics.Canvas)} will not draw from the cache when
 * the cache is enabled. To benefit from the cache, you must request the drawing cache by
 * calling {@link #getDrawingCache()} and draw it on screen if the returned bitmap is not
 * null.</p>
 *
 * <p>Enabling the drawing cache is similar to
 * {@link #setLayerType(int, android.graphics.Paint) setting a layer} when hardware
 * acceleration is turned off. When hardware acceleration is turned on, enabling the
 * drawing cache has no effect on rendering because the system uses a different mechanism
 * for acceleration which ignores the flag. If you want to use a Bitmap for the view, even
 * when hardware acceleration is enabled, see {@link #setLayerType(int, android.graphics.Paint)}
 * for information on how to enable software and hardware layers.</p>
 *
 * <p>This API can be used to manually generate
 * a bitmap copy of this view, by setting the flag to <code>true</code> and calling
 * {@link #getDrawingCache()}.</p>
 *
 * @param enabled true to enable the drawing cache, false otherwise
 *
 * @see #isDrawingCacheEnabled()
 * @see #getDrawingCache()
 * @see #buildDrawingCache()
 * @see #setLayerType(int, android.graphics.Paint)
 *
 * @deprecated The view drawing cache was largely made obsolete with the introduction of
 * hardware-accelerated rendering in API 11. With hardware-acceleration, intermediate cache
 * layers are largely unnecessary and can easily result in a net loss in performance due to the
 * cost of creating and updating the layer. In the rare cases where caching layers are useful,
 * such as for alpha animations, {@link #setLayerType(int, Paint)} handles this with hardware
 * rendering. For software-rendered snapshots of a small part of the View hierarchy or
 * individual Views it is recommended to create a {@link Canvas} from either a {@link Bitmap} or
 * {@link android.graphics.Picture} and call {@link #draw(Canvas)} on the View. However these
 * software-rendered usages are discouraged and have compatibility issues with hardware-only
 * rendering features such as {@link android.graphics.Bitmap.Config#HARDWARE Config.HARDWARE}
 * bitmaps, real-time shadows, and outline clipping. For screenshots of the UI for feedback
 * reports or unit testing the {@link PixelCopy} API is recommended.
 */

@Deprecated public void setDrawingCacheEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * <p>Indicates whether the drawing cache is enabled for this view.</p>
 *
 * @return true if the drawing cache is enabled
 *
 * @see #setDrawingCacheEnabled(boolean)
 * @see #getDrawingCache()
 *
 * @deprecated The view drawing cache was largely made obsolete with the introduction of
 * hardware-accelerated rendering in API 11. With hardware-acceleration, intermediate cache
 * layers are largely unnecessary and can easily result in a net loss in performance due to the
 * cost of creating and updating the layer. In the rare cases where caching layers are useful,
 * such as for alpha animations, {@link #setLayerType(int, Paint)} handles this with hardware
 * rendering. For software-rendered snapshots of a small part of the View hierarchy or
 * individual Views it is recommended to create a {@link Canvas} from either a {@link Bitmap} or
 * {@link android.graphics.Picture} and call {@link #draw(Canvas)} on the View. However these
 * software-rendered usages are discouraged and have compatibility issues with hardware-only
 * rendering features such as {@link android.graphics.Bitmap.Config#HARDWARE Config.HARDWARE}
 * bitmaps, real-time shadows, and outline clipping. For screenshots of the UI for feedback
 * reports or unit testing the {@link PixelCopy} API is recommended.
 */

@Deprecated @android.view.ViewDebug.ExportedProperty(category="drawing") public boolean isDrawingCacheEnabled() { throw new RuntimeException("Stub!"); }

/**
 * <p>Calling this method is equivalent to calling <code>getDrawingCache(false)</code>.</p>
 *
 * @return A non-scaled bitmap representing this view or null if cache is disabled.
 *
 * @see #getDrawingCache(boolean)
 *
 * @deprecated The view drawing cache was largely made obsolete with the introduction of
 * hardware-accelerated rendering in API 11. With hardware-acceleration, intermediate cache
 * layers are largely unnecessary and can easily result in a net loss in performance due to the
 * cost of creating and updating the layer. In the rare cases where caching layers are useful,
 * such as for alpha animations, {@link #setLayerType(int, Paint)} handles this with hardware
 * rendering. For software-rendered snapshots of a small part of the View hierarchy or
 * individual Views it is recommended to create a {@link Canvas} from either a {@link Bitmap} or
 * {@link android.graphics.Picture} and call {@link #draw(Canvas)} on the View. However these
 * software-rendered usages are discouraged and have compatibility issues with hardware-only
 * rendering features such as {@link android.graphics.Bitmap.Config#HARDWARE Config.HARDWARE}
 * bitmaps, real-time shadows, and outline clipping. For screenshots of the UI for feedback
 * reports or unit testing the {@link PixelCopy} API is recommended.
 */

@Deprecated public android.graphics.Bitmap getDrawingCache() { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the bitmap in which this view drawing is cached. The returned bitmap
 * is null when caching is disabled. If caching is enabled and the cache is not ready,
 * this method will create it. Calling {@link #draw(android.graphics.Canvas)} will not
 * draw from the cache when the cache is enabled. To benefit from the cache, you must
 * request the drawing cache by calling this method and draw it on screen if the
 * returned bitmap is not null.</p>
 *
 * <p>Note about auto scaling in compatibility mode: When auto scaling is not enabled,
 * this method will create a bitmap of the same size as this view. Because this bitmap
 * will be drawn scaled by the parent ViewGroup, the result on screen might show
 * scaling artifacts. To avoid such artifacts, you should call this method by setting
 * the auto scaling to true. Doing so, however, will generate a bitmap of a different
 * size than the view. This implies that your application must be able to handle this
 * size.</p>
 *
 * @param autoScale Indicates whether the generated bitmap should be scaled based on
 *        the current density of the screen when the application is in compatibility
 *        mode.
 *
 * @return A bitmap representing this view or null if cache is disabled.
 *
 * @see #setDrawingCacheEnabled(boolean)
 * @see #isDrawingCacheEnabled()
 * @see #buildDrawingCache(boolean)
 * @see #destroyDrawingCache()
 *
 * @deprecated The view drawing cache was largely made obsolete with the introduction of
 * hardware-accelerated rendering in API 11. With hardware-acceleration, intermediate cache
 * layers are largely unnecessary and can easily result in a net loss in performance due to the
 * cost of creating and updating the layer. In the rare cases where caching layers are useful,
 * such as for alpha animations, {@link #setLayerType(int, Paint)} handles this with hardware
 * rendering. For software-rendered snapshots of a small part of the View hierarchy or
 * individual Views it is recommended to create a {@link Canvas} from either a {@link Bitmap} or
 * {@link android.graphics.Picture} and call {@link #draw(Canvas)} on the View. However these
 * software-rendered usages are discouraged and have compatibility issues with hardware-only
 * rendering features such as {@link android.graphics.Bitmap.Config#HARDWARE Config.HARDWARE}
 * bitmaps, real-time shadows, and outline clipping. For screenshots of the UI for feedback
 * reports or unit testing the {@link PixelCopy} API is recommended.
 */

@Deprecated public android.graphics.Bitmap getDrawingCache(boolean autoScale) { throw new RuntimeException("Stub!"); }

/**
 * <p>Frees the resources used by the drawing cache. If you call
 * {@link #buildDrawingCache()} manually without calling
 * {@link #setDrawingCacheEnabled(boolean) setDrawingCacheEnabled(true)}, you
 * should cleanup the cache with this method afterwards.</p>
 *
 * @see #setDrawingCacheEnabled(boolean)
 * @see #buildDrawingCache()
 * @see #getDrawingCache()
 *
 * @deprecated The view drawing cache was largely made obsolete with the introduction of
 * hardware-accelerated rendering in API 11. With hardware-acceleration, intermediate cache
 * layers are largely unnecessary and can easily result in a net loss in performance due to the
 * cost of creating and updating the layer. In the rare cases where caching layers are useful,
 * such as for alpha animations, {@link #setLayerType(int, Paint)} handles this with hardware
 * rendering. For software-rendered snapshots of a small part of the View hierarchy or
 * individual Views it is recommended to create a {@link Canvas} from either a {@link Bitmap} or
 * {@link android.graphics.Picture} and call {@link #draw(Canvas)} on the View. However these
 * software-rendered usages are discouraged and have compatibility issues with hardware-only
 * rendering features such as {@link android.graphics.Bitmap.Config#HARDWARE Config.HARDWARE}
 * bitmaps, real-time shadows, and outline clipping. For screenshots of the UI for feedback
 * reports or unit testing the {@link PixelCopy} API is recommended.
 */

@Deprecated public void destroyDrawingCache() { throw new RuntimeException("Stub!"); }

/**
 * Setting a solid background color for the drawing cache's bitmaps will improve
 * performance and memory usage. Note, though that this should only be used if this
 * view will always be drawn on top of a solid color.
 *
 * @param color The background color to use for the drawing cache's bitmap
 *
 * @see #setDrawingCacheEnabled(boolean)
 * @see #buildDrawingCache()
 * @see #getDrawingCache()
 *
 * @deprecated The view drawing cache was largely made obsolete with the introduction of
 * hardware-accelerated rendering in API 11. With hardware-acceleration, intermediate cache
 * layers are largely unnecessary and can easily result in a net loss in performance due to the
 * cost of creating and updating the layer. In the rare cases where caching layers are useful,
 * such as for alpha animations, {@link #setLayerType(int, Paint)} handles this with hardware
 * rendering. For software-rendered snapshots of a small part of the View hierarchy or
 * individual Views it is recommended to create a {@link Canvas} from either a {@link Bitmap} or
 * {@link android.graphics.Picture} and call {@link #draw(Canvas)} on the View. However these
 * software-rendered usages are discouraged and have compatibility issues with hardware-only
 * rendering features such as {@link android.graphics.Bitmap.Config#HARDWARE Config.HARDWARE}
 * bitmaps, real-time shadows, and outline clipping. For screenshots of the UI for feedback
 * reports or unit testing the {@link PixelCopy} API is recommended.
 */

@Deprecated public void setDrawingCacheBackgroundColor(int color) { throw new RuntimeException("Stub!"); }

/**
 * @see #setDrawingCacheBackgroundColor(int)
 *
 * @return The background color to used for the drawing cache's bitmap
 *
 * @deprecated The view drawing cache was largely made obsolete with the introduction of
 * hardware-accelerated rendering in API 11. With hardware-acceleration, intermediate cache
 * layers are largely unnecessary and can easily result in a net loss in performance due to the
 * cost of creating and updating the layer. In the rare cases where caching layers are useful,
 * such as for alpha animations, {@link #setLayerType(int, Paint)} handles this with hardware
 * rendering. For software-rendered snapshots of a small part of the View hierarchy or
 * individual Views it is recommended to create a {@link Canvas} from either a {@link Bitmap} or
 * {@link android.graphics.Picture} and call {@link #draw(Canvas)} on the View. However these
 * software-rendered usages are discouraged and have compatibility issues with hardware-only
 * rendering features such as {@link android.graphics.Bitmap.Config#HARDWARE Config.HARDWARE}
 * bitmaps, real-time shadows, and outline clipping. For screenshots of the UI for feedback
 * reports or unit testing the {@link PixelCopy} API is recommended.
 */

@Deprecated public int getDrawingCacheBackgroundColor() { throw new RuntimeException("Stub!"); }

/**
 * <p>Calling this method is equivalent to calling <code>buildDrawingCache(false)</code>.</p>
 *
 * @see #buildDrawingCache(boolean)
 *
 * @deprecated The view drawing cache was largely made obsolete with the introduction of
 * hardware-accelerated rendering in API 11. With hardware-acceleration, intermediate cache
 * layers are largely unnecessary and can easily result in a net loss in performance due to the
 * cost of creating and updating the layer. In the rare cases where caching layers are useful,
 * such as for alpha animations, {@link #setLayerType(int, Paint)} handles this with hardware
 * rendering. For software-rendered snapshots of a small part of the View hierarchy or
 * individual Views it is recommended to create a {@link Canvas} from either a {@link Bitmap} or
 * {@link android.graphics.Picture} and call {@link #draw(Canvas)} on the View. However these
 * software-rendered usages are discouraged and have compatibility issues with hardware-only
 * rendering features such as {@link android.graphics.Bitmap.Config#HARDWARE Config.HARDWARE}
 * bitmaps, real-time shadows, and outline clipping. For screenshots of the UI for feedback
 * reports or unit testing the {@link PixelCopy} API is recommended.
 */

@Deprecated public void buildDrawingCache() { throw new RuntimeException("Stub!"); }

/**
 * <p>Forces the drawing cache to be built if the drawing cache is invalid.</p>
 *
 * <p>If you call {@link #buildDrawingCache()} manually without calling
 * {@link #setDrawingCacheEnabled(boolean) setDrawingCacheEnabled(true)}, you
 * should cleanup the cache by calling {@link #destroyDrawingCache()} afterwards.</p>
 *
 * <p>Note about auto scaling in compatibility mode: When auto scaling is not enabled,
 * this method will create a bitmap of the same size as this view. Because this bitmap
 * will be drawn scaled by the parent ViewGroup, the result on screen might show
 * scaling artifacts. To avoid such artifacts, you should call this method by setting
 * the auto scaling to true. Doing so, however, will generate a bitmap of a different
 * size than the view. This implies that your application must be able to handle this
 * size.</p>
 *
 * <p>You should avoid calling this method when hardware acceleration is enabled. If
 * you do not need the drawing cache bitmap, calling this method will increase memory
 * usage and cause the view to be rendered in software once, thus negatively impacting
 * performance.</p>
 *
 * @see #getDrawingCache()
 * @see #destroyDrawingCache()
 *
 * @deprecated The view drawing cache was largely made obsolete with the introduction of
 * hardware-accelerated rendering in API 11. With hardware-acceleration, intermediate cache
 * layers are largely unnecessary and can easily result in a net loss in performance due to the
 * cost of creating and updating the layer. In the rare cases where caching layers are useful,
 * such as for alpha animations, {@link #setLayerType(int, Paint)} handles this with hardware
 * rendering. For software-rendered snapshots of a small part of the View hierarchy or
 * individual Views it is recommended to create a {@link Canvas} from either a {@link Bitmap} or
 * {@link android.graphics.Picture} and call {@link #draw(Canvas)} on the View. However these
 * software-rendered usages are discouraged and have compatibility issues with hardware-only
 * rendering features such as {@link android.graphics.Bitmap.Config#HARDWARE Config.HARDWARE}
 * bitmaps, real-time shadows, and outline clipping. For screenshots of the UI for feedback
 * reports or unit testing the {@link PixelCopy} API is recommended.
 */

@Deprecated public void buildDrawingCache(boolean autoScale) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether this View is currently in edit mode. A View is usually
 * in edit mode when displayed within a developer tool. For instance, if
 * this View is being drawn by a visual user interface builder, this method
 * should return true.
 *
 * Subclasses should check the return value of this method to provide
 * different behaviors if their normal behavior might interfere with the
 * host environment. For instance: the class spawns a thread in its
 * constructor, the drawing code relies on device-specific features, etc.
 *
 * This method is usually checked in the drawing code of custom widgets.
 *
 * @return True if this View is in edit mode, false otherwise.
 */

public boolean isInEditMode() { throw new RuntimeException("Stub!"); }

/**
 * If the View draws content inside its padding and enables fading edges,
 * it needs to support padding offsets. Padding offsets are added to the
 * fading edges to extend the length of the fade so that it covers pixels
 * drawn inside the padding.
 *
 * Subclasses of this class should override this method if they need
 * to draw content inside the padding.
 *
 * @return True if padding offset must be applied, false otherwise.
 *
 * @see #getLeftPaddingOffset()
 * @see #getRightPaddingOffset()
 * @see #getTopPaddingOffset()
 * @see #getBottomPaddingOffset()
 *
 * @since CURRENT
 */

protected boolean isPaddingOffsetRequired() { throw new RuntimeException("Stub!"); }

/**
 * Amount by which to extend the left fading region. Called only when
 * {@link #isPaddingOffsetRequired()} returns true.
 *
 * @return The left padding offset in pixels.
 *
 * @see #isPaddingOffsetRequired()
 *
 * @since CURRENT
 */

protected int getLeftPaddingOffset() { throw new RuntimeException("Stub!"); }

/**
 * Amount by which to extend the right fading region. Called only when
 * {@link #isPaddingOffsetRequired()} returns true.
 *
 * @return The right padding offset in pixels.
 *
 * @see #isPaddingOffsetRequired()
 *
 * @since CURRENT
 */

protected int getRightPaddingOffset() { throw new RuntimeException("Stub!"); }

/**
 * Amount by which to extend the top fading region. Called only when
 * {@link #isPaddingOffsetRequired()} returns true.
 *
 * @return The top padding offset in pixels.
 *
 * @see #isPaddingOffsetRequired()
 *
 * @since CURRENT
 */

protected int getTopPaddingOffset() { throw new RuntimeException("Stub!"); }

/**
 * Amount by which to extend the bottom fading region. Called only when
 * {@link #isPaddingOffsetRequired()} returns true.
 *
 * @return The bottom padding offset in pixels.
 *
 * @see #isPaddingOffsetRequired()
 *
 * @since CURRENT
 */

protected int getBottomPaddingOffset() { throw new RuntimeException("Stub!"); }

/**
 * <p>Indicates whether this view is attached to a hardware accelerated
 * window or not.</p>
 *
 * <p>Even if this method returns true, it does not mean that every call
 * to {@link #draw(android.graphics.Canvas)} will be made with an hardware
 * accelerated {@link android.graphics.Canvas}. For instance, if this view
 * is drawn onto an offscreen {@link android.graphics.Bitmap} and its
 * window is hardware accelerated,
 * {@link android.graphics.Canvas#isHardwareAccelerated()} will likely
 * return false, and this method will return true.</p>
 *
 * @return True if the view is attached to a window and the window is
 *         hardware accelerated; false in any other case.
 */

@android.view.ViewDebug.ExportedProperty(category="drawing") public boolean isHardwareAccelerated() { throw new RuntimeException("Stub!"); }

/**
 * Sets a rectangular area on this view to which the view will be clipped
 * when it is drawn. Setting the value to null will remove the clip bounds
 * and the view will draw normally, using its full bounds.
 *
 * @param clipBounds The rectangular area, in the local coordinates of
 * this view, to which future drawing operations will be clipped.
 */

public void setClipBounds(android.graphics.Rect clipBounds) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of the current {@link #setClipBounds(Rect) clipBounds}.
 *
 * @return A copy of the current clip bounds if clip bounds are set,
 * otherwise null.
 */

public android.graphics.Rect getClipBounds() { throw new RuntimeException("Stub!"); }

/**
 * Populates an output rectangle with the clip bounds of the view,
 * returning {@code true} if successful or {@code false} if the view's
 * clip bounds are {@code null}.
 *
 * @param outRect rectangle in which to place the clip bounds of the view
 * @return {@code true} if successful or {@code false} if the view's
 *         clip bounds are {@code null}
 */

public boolean getClipBounds(android.graphics.Rect outRect) { throw new RuntimeException("Stub!"); }

/**
 * Manually render this view (and all of its children) to the given Canvas.
 * The view must have already done a full layout before this function is
 * called.  When implementing a view, implement
 * {@link #onDraw(android.graphics.Canvas)} instead of overriding this method.
 * If you do need to override this method, call the superclass version.
 *
 * If you override this method you <em>must</em> call through to the
 *  *            superclass implementation.
 * @param canvas The Canvas to which the View is rendered.
 */

public void draw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * Returns the overlay for this view, creating it if it does not yet exist.
 * Adding drawables to the overlay will cause them to be displayed whenever
 * the view itself is redrawn. Objects in the overlay should be actively
 * managed: remove them when they should not be displayed anymore. The
 * overlay will always have the same size as its host view.
 *
 * <p>Note: Overlays do not currently work correctly with {@link
 * SurfaceView} or {@link TextureView}; contents in overlays for these
 * types of views may not display correctly.</p>
 *
 * @return The ViewOverlay object for this view.
 * @see ViewOverlay
 */

public android.view.ViewOverlay getOverlay() { throw new RuntimeException("Stub!"); }

/**
 * Override this if your view is known to always be drawn on top of a solid color background,
 * and needs to draw fading edges. Returning a non-zero color enables the view system to
 * optimize the drawing of the fading edges. If you do return a non-zero color, the alpha
 * should be set to 0xFF.
 *
 * @see #setVerticalFadingEdgeEnabled(boolean)
 * @see #setHorizontalFadingEdgeEnabled(boolean)
 *
 * @return The known solid color background for this view, or 0 if the color may vary
 */

@android.view.ViewDebug.ExportedProperty(category="drawing") public int getSolidColor() { throw new RuntimeException("Stub!"); }

/**
 * <p>Indicates whether or not this view's layout will be requested during
 * the next hierarchy layout pass.</p>
 *
 * @return true if the layout will be forced during next layout pass
 */

public boolean isLayoutRequested() { throw new RuntimeException("Stub!"); }

/**
 * Assign a size and position to a view and all of its
 * descendants
 *
 * <p>This is the second phase of the layout mechanism.
 * (The first is measuring). In this phase, each parent calls
 * layout on all of its children to position them.
 * This is typically done using the child measurements
 * that were stored in the measure pass().</p>
 *
 * <p>Derived classes should not override this method.
 * Derived classes with children should override
 * onLayout. In that method, they should
 * call layout on each of their children.</p>
 *
 * @param l Left position, relative to parent
 * @param t Top position, relative to parent
 * @param r Right position, relative to parent
 * @param b Bottom position, relative to parent
 */

public void layout(int l, int t, int r, int b) { throw new RuntimeException("Stub!"); }

/**
 * Called from layout when this view should
 * assign a size and position to each of its children.
 *
 * Derived classes with children should override
 * this method and call layout on each of
 * their children.
 * @param changed This is a new size or position for this view
 * @param left Left position, relative to parent
 * @param top Top position, relative to parent
 * @param right Right position, relative to parent
 * @param bottom Bottom position, relative to parent
 */

protected void onLayout(boolean changed, int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Finalize inflating a view from XML.  This is called as the last phase
 * of inflation, after all child views have been added.
 *
 * <p>Even if the subclass overrides onFinishInflate, they should always be
 * sure to call the super method, so that we get called.

 * If you override this method you <em>must</em> call through to the
 *  *            superclass implementation.
 */

protected void onFinishInflate() { throw new RuntimeException("Stub!"); }

/**
 * Returns the resources associated with this view.
 *
 * @return Resources object.
 */

public android.content.res.Resources getResources() { throw new RuntimeException("Stub!"); }

/**
 * Invalidates the specified Drawable.
 *
 * @param drawable the drawable to invalidate

 * This value must never be {@code null}.
 */

public void invalidateDrawable(@androidx.annotation.RecentlyNonNull android.graphics.drawable.Drawable drawable) { throw new RuntimeException("Stub!"); }

/**
 * Schedules an action on a drawable to occur at a specified time.
 *
 * @param who the recipient of the action
 * This value must never be {@code null}.
 * @param what the action to run on the drawable
 * This value must never be {@code null}.
 * @param when the time at which the action must occur. Uses the
 *        {@link SystemClock#uptimeMillis} timebase.
 */

public void scheduleDrawable(@androidx.annotation.RecentlyNonNull android.graphics.drawable.Drawable who, @androidx.annotation.RecentlyNonNull java.lang.Runnable what, long when) { throw new RuntimeException("Stub!"); }

/**
 * Cancels a scheduled action on a drawable.
 *
 * @param who the recipient of the action
 * This value must never be {@code null}.
 * @param what the action to cancel

 * This value must never be {@code null}.
 */

public void unscheduleDrawable(@androidx.annotation.RecentlyNonNull android.graphics.drawable.Drawable who, @androidx.annotation.RecentlyNonNull java.lang.Runnable what) { throw new RuntimeException("Stub!"); }

/**
 * Unschedule any events associated with the given Drawable.  This can be
 * used when selecting a new Drawable into a view, so that the previous
 * one is completely unscheduled.
 *
 * @param who The Drawable to unschedule.
 *
 * @see #drawableStateChanged
 */

public void unscheduleDrawable(android.graphics.drawable.Drawable who) { throw new RuntimeException("Stub!"); }

/**
 * If your view subclass is displaying its own Drawable objects, it should
 * override this function and return true for any Drawable it is
 * displaying.  This allows animations for those drawables to be
 * scheduled.
 *
 * <p>Be sure to call through to the super class when overriding this
 * function.
 *
 * If you override this method you <em>must</em> call through to the
 *  *            superclass implementation.
 * @param who The Drawable to verify.  Return true if it is one you are
 *            displaying, else return the result of calling through to the
 *            super class.
 *
 * This value must never be {@code null}.
 * @return boolean If true than the Drawable is being displayed in the
 *         view; else false and it is not allowed to animate.
 *
 * @see #unscheduleDrawable(android.graphics.drawable.Drawable)
 * @see #drawableStateChanged()
 */

protected boolean verifyDrawable(@androidx.annotation.RecentlyNonNull android.graphics.drawable.Drawable who) { throw new RuntimeException("Stub!"); }

/**
 * This function is called whenever the state of the view changes in such
 * a way that it impacts the state of drawables being shown.
 * <p>
 * If the View has a StateListAnimator, it will also be called to run necessary state
 * change animations.
 * <p>
 * Be sure to call through to the superclass when overriding this function.
 *
 * If you override this method you <em>must</em> call through to the
 *  *            superclass implementation.
 * @see Drawable#setState(int[])
 */

protected void drawableStateChanged() { throw new RuntimeException("Stub!"); }

/**
 * This function is called whenever the view hotspot changes and needs to
 * be propagated to drawables or child views managed by the view.
 * <p>
 * Dispatching to child views is handled by
 * {@link #dispatchDrawableHotspotChanged(float, float)}.
 * <p>
 * Be sure to call through to the superclass when overriding this function.
 *
 * If you override this method you <em>must</em> call through to the
 *  *            superclass implementation.
 * @param x hotspot x coordinate
 * @param y hotspot y coordinate
 */

public void drawableHotspotChanged(float x, float y) { throw new RuntimeException("Stub!"); }

/**
 * Dispatches drawableHotspotChanged to all of this View's children.
 *
 * @param x hotspot x coordinate
 * @param y hotspot y coordinate
 * @see #drawableHotspotChanged(float, float)
 */

public void dispatchDrawableHotspotChanged(float x, float y) { throw new RuntimeException("Stub!"); }

/**
 * Call this to force a view to update its drawable state. This will cause
 * drawableStateChanged to be called on this view. Views that are interested
 * in the new state should call getDrawableState.
 *
 * @see #drawableStateChanged
 * @see #getDrawableState
 */

public void refreshDrawableState() { throw new RuntimeException("Stub!"); }

/**
 * Return an array of resource IDs of the drawable states representing the
 * current state of the view.
 *
 * @return The current drawable state
 *
 * @see Drawable#setState(int[])
 * @see #drawableStateChanged()
 * @see #onCreateDrawableState(int)
 */

public final int[] getDrawableState() { throw new RuntimeException("Stub!"); }

/**
 * Generate the new {@link android.graphics.drawable.Drawable} state for
 * this view. This is called by the view
 * system when the cached Drawable state is determined to be invalid.  To
 * retrieve the current state, you should use {@link #getDrawableState}.
 *
 * @param extraSpace if non-zero, this is the number of extra entries you
 * would like in the returned array in which you can place your own
 * states.
 *
 * @return Returns an array holding the current {@link Drawable} state of
 * the view.
 *
 * @see #mergeDrawableStates(int[], int[])
 */

protected int[] onCreateDrawableState(int extraSpace) { throw new RuntimeException("Stub!"); }

/**
 * Merge your own state values in <var>additionalState</var> into the base
 * state values <var>baseState</var> that were returned by
 * {@link #onCreateDrawableState(int)}.
 *
 * @param baseState The base state values returned by
 * {@link #onCreateDrawableState(int)}, which will be modified to also hold your
 * own additional state values.
 *
 * @param additionalState The additional state values you would like
 * added to <var>baseState</var>; this array is not modified.
 *
 * @return As a convenience, the <var>baseState</var> array you originally
 * passed into the function is returned.
 *
 * @see #onCreateDrawableState(int)
 */

protected static int[] mergeDrawableStates(int[] baseState, int[] additionalState) { throw new RuntimeException("Stub!"); }

/**
 * Call {@link Drawable#jumpToCurrentState() Drawable.jumpToCurrentState()}
 * on all Drawable objects associated with this view.
 * <p>
 * Also calls {@link StateListAnimator#jumpToCurrentState()} if there is a StateListAnimator
 * attached to this view.

 * If you override this method you <em>must</em> call through to the
 *  *            superclass implementation.
 */

public void jumpDrawablesToCurrentState() { throw new RuntimeException("Stub!"); }

/**
 * Sets the background color for this view.
 * @param color the color of the background
 */

public void setBackgroundColor(int color) { throw new RuntimeException("Stub!"); }

/**
 * Set the background to a given resource. The resource should refer to
 * a Drawable object or 0 to remove the background.
 * @param resid The identifier of the resource.
 *
 * @attr ref android.R.styleable#View_background
 */

public void setBackgroundResource(int resid) { throw new RuntimeException("Stub!"); }

/**
 * Set the background to a given Drawable, or remove the background. If the
 * background has padding, this View's padding is set to the background's
 * padding. However, when a background is removed, this View's padding isn't
 * touched. If setting the padding is desired, please use
 * {@link #setPadding(int, int, int, int)}.
 *
 * @param background The Drawable to use as the background, or null to remove the
 *        background
 */

public void setBackground(android.graphics.drawable.Drawable background) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated use {@link #setBackground(Drawable)} instead
 */

@Deprecated public void setBackgroundDrawable(android.graphics.drawable.Drawable background) { throw new RuntimeException("Stub!"); }

/**
 * Gets the background drawable
 *
 * @return The drawable used as the background for this view, if any.
 *
 * @see #setBackground(Drawable)
 *
 * @attr ref android.R.styleable#View_background
 */

public android.graphics.drawable.Drawable getBackground() { throw new RuntimeException("Stub!"); }

/**
 * Applies a tint to the background drawable. Does not modify the current tint
 * mode, which is {@link PorterDuff.Mode#SRC_IN} by default.
 * <p>
 * Subsequent calls to {@link #setBackground(Drawable)} will automatically
 * mutate the drawable and apply the specified tint and tint mode using
 * {@link Drawable#setTintList(ColorStateList)}.
 *
 * @param tint the tint to apply, may be {@code null} to clear tint
 *
 * This value may be {@code null}.
 * @attr ref android.R.styleable#View_backgroundTint
 * @see #getBackgroundTintList()
 * @see Drawable#setTintList(ColorStateList)
 */

public void setBackgroundTintList(@androidx.annotation.RecentlyNullable android.content.res.ColorStateList tint) { throw new RuntimeException("Stub!"); }

/**
 * Return the tint applied to the background drawable, if specified.
 *
 * @return the tint applied to the background drawable
 * This value may be {@code null}.
 * @attr ref android.R.styleable#View_backgroundTint
 * @see #setBackgroundTintList(ColorStateList)
 */

@androidx.annotation.RecentlyNullable public android.content.res.ColorStateList getBackgroundTintList() { throw new RuntimeException("Stub!"); }

/**
 * Specifies the blending mode used to apply the tint specified by
 * {@link #setBackgroundTintList(ColorStateList)}} to the background
 * drawable. The default mode is {@link PorterDuff.Mode#SRC_IN}.
 *
 * @param tintMode the blending mode used to apply the tint, may be
 *                 {@code null} to clear tint
 * This value may be {@code null}.
 * @attr ref android.R.styleable#View_backgroundTintMode
 * @see #getBackgroundTintMode()
 * @see Drawable#setTintMode(PorterDuff.Mode)
 */

public void setBackgroundTintMode(@androidx.annotation.RecentlyNullable android.graphics.PorterDuff.Mode tintMode) { throw new RuntimeException("Stub!"); }

/**
 * Return the blending mode used to apply the tint to the background
 * drawable, if specified.
 *
 * @return the blending mode used to apply the tint to the background
 *         drawable
 * This value may be {@code null}.
 * @attr ref android.R.styleable#View_backgroundTintMode
 * @see #setBackgroundTintMode(PorterDuff.Mode)
 */

@androidx.annotation.RecentlyNullable public android.graphics.PorterDuff.Mode getBackgroundTintMode() { throw new RuntimeException("Stub!"); }

/**
 * Returns the drawable used as the foreground of this View. The
 * foreground drawable, if non-null, is always drawn on top of the view's content.
 *
 * @return a Drawable or null if no foreground was set
 *
 * @see #onDrawForeground(Canvas)
 */

public android.graphics.drawable.Drawable getForeground() { throw new RuntimeException("Stub!"); }

/**
 * Supply a Drawable that is to be rendered on top of all of the content in the view.
 *
 * @param foreground the Drawable to be drawn on top of the children
 *
 * @attr ref android.R.styleable#View_foreground
 */

public void setForeground(android.graphics.drawable.Drawable foreground) { throw new RuntimeException("Stub!"); }

/**
 * Describes how the foreground is positioned.
 *
 * @return foreground gravity.
 *
 * @see #setForegroundGravity(int)
 *
 * @attr ref android.R.styleable#View_foregroundGravity
 */

public int getForegroundGravity() { throw new RuntimeException("Stub!"); }

/**
 * Describes how the foreground is positioned. Defaults to START and TOP.
 *
 * @param gravity see {@link android.view.Gravity}
 *
 * @see #getForegroundGravity()
 *
 * @attr ref android.R.styleable#View_foregroundGravity
 */

public void setForegroundGravity(int gravity) { throw new RuntimeException("Stub!"); }

/**
 * Applies a tint to the foreground drawable. Does not modify the current tint
 * mode, which is {@link PorterDuff.Mode#SRC_IN} by default.
 * <p>
 * Subsequent calls to {@link #setForeground(Drawable)} will automatically
 * mutate the drawable and apply the specified tint and tint mode using
 * {@link Drawable#setTintList(ColorStateList)}.
 *
 * @param tint the tint to apply, may be {@code null} to clear tint
 *
 * This value may be {@code null}.
 * @attr ref android.R.styleable#View_foregroundTint
 * @see #getForegroundTintList()
 * @see Drawable#setTintList(ColorStateList)
 */

public void setForegroundTintList(@androidx.annotation.RecentlyNullable android.content.res.ColorStateList tint) { throw new RuntimeException("Stub!"); }

/**
 * Return the tint applied to the foreground drawable, if specified.
 *
 * @return the tint applied to the foreground drawable
 * This value may be {@code null}.
 * @attr ref android.R.styleable#View_foregroundTint
 * @see #setForegroundTintList(ColorStateList)
 */

@androidx.annotation.RecentlyNullable public android.content.res.ColorStateList getForegroundTintList() { throw new RuntimeException("Stub!"); }

/**
 * Specifies the blending mode used to apply the tint specified by
 * {@link #setForegroundTintList(ColorStateList)}} to the background
 * drawable. The default mode is {@link PorterDuff.Mode#SRC_IN}.
 *
 * @param tintMode the blending mode used to apply the tint, may be
 *                 {@code null} to clear tint
 * This value may be {@code null}.
 * @attr ref android.R.styleable#View_foregroundTintMode
 * @see #getForegroundTintMode()
 * @see Drawable#setTintMode(PorterDuff.Mode)
 */

public void setForegroundTintMode(@androidx.annotation.RecentlyNullable android.graphics.PorterDuff.Mode tintMode) { throw new RuntimeException("Stub!"); }

/**
 * Return the blending mode used to apply the tint to the foreground
 * drawable, if specified.
 *
 * @return the blending mode used to apply the tint to the foreground
 *         drawable
 * This value may be {@code null}.
 * @attr ref android.R.styleable#View_foregroundTintMode
 * @see #setForegroundTintMode(PorterDuff.Mode)
 */

@androidx.annotation.RecentlyNullable public android.graphics.PorterDuff.Mode getForegroundTintMode() { throw new RuntimeException("Stub!"); }

/**
 * Draw any foreground content for this view.
 *
 * <p>Foreground content may consist of scroll bars, a {@link #setForeground foreground}
 * drawable or other view-specific decorations. The foreground is drawn on top of the
 * primary view content.</p>
 *
 * @param canvas canvas to draw into
 */

public void onDrawForeground(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * Sets the padding. The view may add on the space required to display
 * the scrollbars, depending on the style and visibility of the scrollbars.
 * So the values returned from {@link #getPaddingLeft}, {@link #getPaddingTop},
 * {@link #getPaddingRight} and {@link #getPaddingBottom} may be different
 * from the values set in this call.
 *
 * @attr ref android.R.styleable#View_padding
 * @attr ref android.R.styleable#View_paddingBottom
 * @attr ref android.R.styleable#View_paddingLeft
 * @attr ref android.R.styleable#View_paddingRight
 * @attr ref android.R.styleable#View_paddingTop
 * @param left the left padding in pixels
 * @param top the top padding in pixels
 * @param right the right padding in pixels
 * @param bottom the bottom padding in pixels
 */

public void setPadding(int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Sets the relative padding. The view may add on the space required to display
 * the scrollbars, depending on the style and visibility of the scrollbars.
 * So the values returned from {@link #getPaddingStart}, {@link #getPaddingTop},
 * {@link #getPaddingEnd} and {@link #getPaddingBottom} may be different
 * from the values set in this call.
 *
 * @attr ref android.R.styleable#View_padding
 * @attr ref android.R.styleable#View_paddingBottom
 * @attr ref android.R.styleable#View_paddingStart
 * @attr ref android.R.styleable#View_paddingEnd
 * @attr ref android.R.styleable#View_paddingTop
 * @param start the start padding in pixels
 * @param top the top padding in pixels
 * @param end the end padding in pixels
 * @param bottom the bottom padding in pixels
 */

public void setPaddingRelative(int start, int top, int end, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Returns the top padding of this view.
 *
 * @return the top padding in pixels
 */

public int getPaddingTop() { throw new RuntimeException("Stub!"); }

/**
 * Returns the bottom padding of this view. If there are inset and enabled
 * scrollbars, this value may include the space required to display the
 * scrollbars as well.
 *
 * @return the bottom padding in pixels
 */

public int getPaddingBottom() { throw new RuntimeException("Stub!"); }

/**
 * Returns the left padding of this view. If there are inset and enabled
 * scrollbars, this value may include the space required to display the
 * scrollbars as well.
 *
 * @return the left padding in pixels
 */

public int getPaddingLeft() { throw new RuntimeException("Stub!"); }

/**
 * Returns the start padding of this view depending on its resolved layout direction.
 * If there are inset and enabled scrollbars, this value may include the space
 * required to display the scrollbars as well.
 *
 * @return the start padding in pixels
 */

public int getPaddingStart() { throw new RuntimeException("Stub!"); }

/**
 * Returns the right padding of this view. If there are inset and enabled
 * scrollbars, this value may include the space required to display the
 * scrollbars as well.
 *
 * @return the right padding in pixels
 */

public int getPaddingRight() { throw new RuntimeException("Stub!"); }

/**
 * Returns the end padding of this view depending on its resolved layout direction.
 * If there are inset and enabled scrollbars, this value may include the space
 * required to display the scrollbars as well.
 *
 * @return the end padding in pixels
 */

public int getPaddingEnd() { throw new RuntimeException("Stub!"); }

/**
 * Return if the padding has been set through relative values
 * {@link #setPaddingRelative(int, int, int, int)} or through
 * @attr ref android.R.styleable#View_paddingStart or
 * @attr ref android.R.styleable#View_paddingEnd
 *
 * @return true if the padding is relative or false if it is not.
 */

public boolean isPaddingRelative() { throw new RuntimeException("Stub!"); }

/**
 * Changes the selection state of this view. A view can be selected or not.
 * Note that selection is not the same as focus. Views are typically
 * selected in the context of an AdapterView like ListView or GridView;
 * the selected view is the view that is highlighted.
 *
 * @param selected true if the view must be selected, false otherwise
 */

public void setSelected(boolean selected) { throw new RuntimeException("Stub!"); }

/**
 * Dispatch setSelected to all of this View's children.
 *
 * @see #setSelected(boolean)
 *
 * @param selected The new selected state
 */

protected void dispatchSetSelected(boolean selected) { throw new RuntimeException("Stub!"); }

/**
 * Indicates the selection state of this view.
 *
 * @return true if the view is selected, false otherwise
 */

@android.view.ViewDebug.ExportedProperty public boolean isSelected() { throw new RuntimeException("Stub!"); }

/**
 * Changes the activated state of this view. A view can be activated or not.
 * Note that activation is not the same as selection.  Selection is
 * a transient property, representing the view (hierarchy) the user is
 * currently interacting with.  Activation is a longer-term state that the
 * user can move views in and out of.  For example, in a list view with
 * single or multiple selection enabled, the views in the current selection
 * set are activated.  (Um, yeah, we are deeply sorry about the terminology
 * here.)  The activated state is propagated down to children of the view it
 * is set on.
 *
 * @param activated true if the view must be activated, false otherwise
 */

public void setActivated(boolean activated) { throw new RuntimeException("Stub!"); }

/**
 * Dispatch setActivated to all of this View's children.
 *
 * @see #setActivated(boolean)
 *
 * @param activated The new activated state
 */

protected void dispatchSetActivated(boolean activated) { throw new RuntimeException("Stub!"); }

/**
 * Indicates the activation state of this view.
 *
 * @return true if the view is activated, false otherwise
 */

@android.view.ViewDebug.ExportedProperty public boolean isActivated() { throw new RuntimeException("Stub!"); }

/**
 * Returns the ViewTreeObserver for this view's hierarchy. The view tree
 * observer can be used to get notifications when global events, like
 * layout, happen.
 *
 * The returned ViewTreeObserver observer is not guaranteed to remain
 * valid for the lifetime of this View. If the caller of this method keeps
 * a long-lived reference to ViewTreeObserver, it should always check for
 * the return value of {@link ViewTreeObserver#isAlive()}.
 *
 * @return The ViewTreeObserver for this view's hierarchy.
 */

public android.view.ViewTreeObserver getViewTreeObserver() { throw new RuntimeException("Stub!"); }

/**
 * <p>Finds the topmost view in the current view hierarchy.</p>
 *
 * @return the topmost view containing this view
 */

public android.view.View getRootView() { throw new RuntimeException("Stub!"); }

/**
 * <p>Computes the coordinates of this view on the screen. The argument
 * must be an array of two integers. After the method returns, the array
 * contains the x and y location in that order.</p>
 *
 * @param outLocation an array of two integers in which to hold the coordinates
 */

public void getLocationOnScreen(int[] outLocation) { throw new RuntimeException("Stub!"); }

/**
 * <p>Computes the coordinates of this view in its window. The argument
 * must be an array of two integers. After the method returns, the array
 * contains the x and y location in that order.</p>
 *
 * @param outLocation an array of two integers in which to hold the coordinates
 */

public void getLocationInWindow(int[] outLocation) { throw new RuntimeException("Stub!"); }

/**
 * Finds the first descendant view with the given ID, the view itself if
 * the ID matches {@link #getId()}, or {@code null} if the ID is invalid
 * (< 0) or there is no matching view in the hierarchy.
 * <p>
 * <strong>Note:</strong> In most cases -- depending on compiler support --
 * the resulting view is automatically cast to the target class type. If
 * the target class type is unconstrained, an explicit cast may be
 * necessary.
 *
 * @param id the ID to search for
 * @return a view with given ID if found, or {@code null} otherwise
 * @see View#requireViewById(int)
 */

public final <T extends android.view.View> T findViewById(int id) { throw new RuntimeException("Stub!"); }

/**
 * Finds the first descendant view with the given ID, the view itself if the ID matches
 * {@link #getId()}, or throws an IllegalArgumentException if the ID is invalid or there is no
 * matching view in the hierarchy.
 * <p>
 * <strong>Note:</strong> In most cases -- depending on compiler support --
 * the resulting view is automatically cast to the target class type. If
 * the target class type is unconstrained, an explicit cast may be
 * necessary.
 *
 * @param id the ID to search for
 * @return a view with given ID
 * This value will never be {@code null}.
 * @see View#findViewById(int)
 */

@androidx.annotation.RecentlyNonNull public final <T extends android.view.View> T requireViewById(int id) { throw new RuntimeException("Stub!"); }

/**
 * Look for a child view with the given tag.  If this view has the given
 * tag, return this view.
 *
 * @param tag The tag to search for, using "tag.equals(getTag())".
 * @return The View that has the given tag in the hierarchy or null
 */

public final <T extends android.view.View> T findViewWithTag(java.lang.Object tag) { throw new RuntimeException("Stub!"); }

/**
 * Sets the identifier for this view. The identifier does not have to be
 * unique in this view's hierarchy. The identifier should be a positive
 * number.
 *
 * @see #NO_ID
 * @see #getId()
 * @see #findViewById(int)
 *
 * @param id a number used to identify the view
 *
 * @attr ref android.R.styleable#View_id
 */

public void setId(int id) { throw new RuntimeException("Stub!"); }

/**
 * Returns this view's identifier.
 *
 * @return a positive integer used to identify the view or {@link #NO_ID}
 *         if the view has no ID
 *
 * @see #setId(int)
 * @see #findViewById(int)
 * @attr ref android.R.styleable#View_id
 */

@android.view.ViewDebug.CapturedViewProperty public int getId() { throw new RuntimeException("Stub!"); }

/**
 * Returns this view's tag.
 *
 * @return the Object stored in this view as a tag, or {@code null} if not
 *         set
 *
 * @see #setTag(Object)
 * @see #getTag(int)
 */

@android.view.ViewDebug.ExportedProperty public java.lang.Object getTag() { throw new RuntimeException("Stub!"); }

/**
 * Sets the tag associated with this view. A tag can be used to mark
 * a view in its hierarchy and does not have to be unique within the
 * hierarchy. Tags can also be used to store data within a view without
 * resorting to another data structure.
 *
 * @param tag an Object to tag the view with
 *
 * @see #getTag()
 * @see #setTag(int, Object)
 */

public void setTag(java.lang.Object tag) { throw new RuntimeException("Stub!"); }

/**
 * Returns the tag associated with this view and the specified key.
 *
 * @param key The key identifying the tag
 *
 * @return the Object stored in this view as a tag, or {@code null} if not
 *         set
 *
 * @see #setTag(int, Object)
 * @see #getTag()
 */

public java.lang.Object getTag(int key) { throw new RuntimeException("Stub!"); }

/**
 * Sets a tag associated with this view and a key. A tag can be used
 * to mark a view in its hierarchy and does not have to be unique within
 * the hierarchy. Tags can also be used to store data within a view
 * without resorting to another data structure.
 *
 * The specified key should be an id declared in the resources of the
 * application to ensure it is unique (see the <a
 * href="{@docRoot}guide/topics/resources/more-resources.html#Id">ID resource type</a>).
 * Keys identified as belonging to
 * the Android framework or not associated with any package will cause
 * an {@link IllegalArgumentException} to be thrown.
 *
 * @param key The key identifying the tag
 * @param tag An Object to tag the view with
 *
 * @throws IllegalArgumentException If they specified key is not valid
 *
 * @see #setTag(Object)
 * @see #getTag(int)
 */

public void setTag(int key, java.lang.Object tag) { throw new RuntimeException("Stub!"); }

/**
 * <p>Return the offset of the widget's text baseline from the widget's top
 * boundary. If this widget does not support baseline alignment, this
 * method returns -1. </p>
 *
 * @return the offset of the baseline within the widget's bounds or -1
 *         if baseline alignment is not supported
 */

@android.view.ViewDebug.ExportedProperty(category="layout") public int getBaseline() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the view hierarchy is currently undergoing a layout pass. This
 * information is useful to avoid situations such as calling {@link #requestLayout()} during
 * a layout pass.
 *
 * @return whether the view hierarchy is currently undergoing a layout pass
 */

public boolean isInLayout() { throw new RuntimeException("Stub!"); }

/**
 * Call this when something has changed which has invalidated the
 * layout of this view. This will schedule a layout pass of the view
 * tree. This should not be called while the view hierarchy is currently in a layout
 * pass ({@link #isInLayout()}. If layout is happening, the request may be honored at the
 * end of the current layout pass (and then layout will run again) or after the current
 * frame is drawn and the next layout occurs.
 *
 * <p>Subclasses which override this method should call the superclass method to
 * handle possible request-during-layout errors correctly.</p>

 * If you override this method you <em>must</em> call through to the
 *  *            superclass implementation.
 */

public void requestLayout() { throw new RuntimeException("Stub!"); }

/**
 * Forces this view to be laid out during the next layout pass.
 * This method does not call requestLayout() or forceLayout()
 * on the parent.
 */

public void forceLayout() { throw new RuntimeException("Stub!"); }

/**
 * <p>
 * This is called to find out how big a view should be. The parent
 * supplies constraint information in the width and height parameters.
 * </p>
 *
 * <p>
 * The actual measurement work of a view is performed in
 * {@link #onMeasure(int, int)}, called by this method. Therefore, only
 * {@link #onMeasure(int, int)} can and must be overridden by subclasses.
 * </p>
 *
 *
 * @param widthMeasureSpec Horizontal space requirements as imposed by the
 *        parent
 * @param heightMeasureSpec Vertical space requirements as imposed by the
 *        parent
 *
 * @see #onMeasure(int, int)
 */

public final void measure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

/**
 * <p>
 * Measure the view and its content to determine the measured width and the
 * measured height. This method is invoked by {@link #measure(int, int)} and
 * should be overridden by subclasses to provide accurate and efficient
 * measurement of their contents.
 * </p>
 *
 * <p>
 * <strong>CONTRACT:</strong> When overriding this method, you
 * <em>must</em> call {@link #setMeasuredDimension(int, int)} to store the
 * measured width and height of this view. Failure to do so will trigger an
 * <code>IllegalStateException</code>, thrown by
 * {@link #measure(int, int)}. Calling the superclass'
 * {@link #onMeasure(int, int)} is a valid use.
 * </p>
 *
 * <p>
 * The base class implementation of measure defaults to the background size,
 * unless a larger size is allowed by the MeasureSpec. Subclasses should
 * override {@link #onMeasure(int, int)} to provide better measurements of
 * their content.
 * </p>
 *
 * <p>
 * If this method is overridden, it is the subclass's responsibility to make
 * sure the measured height and width are at least the view's minimum height
 * and width ({@link #getSuggestedMinimumHeight()} and
 * {@link #getSuggestedMinimumWidth()}).
 * </p>
 *
 * @param widthMeasureSpec horizontal space requirements as imposed by the parent.
 *                         The requirements are encoded with
 *                         {@link android.view.View.MeasureSpec}.
 * @param heightMeasureSpec vertical space requirements as imposed by the parent.
 *                         The requirements are encoded with
 *                         {@link android.view.View.MeasureSpec}.
 *
 * @see #getMeasuredWidth()
 * @see #getMeasuredHeight()
 * @see #setMeasuredDimension(int, int)
 * @see #getSuggestedMinimumHeight()
 * @see #getSuggestedMinimumWidth()
 * @see android.view.View.MeasureSpec#getMode(int)
 * @see android.view.View.MeasureSpec#getSize(int)
 */

protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

/**
 * <p>This method must be called by {@link #onMeasure(int, int)} to store the
 * measured width and measured height. Failing to do so will trigger an
 * exception at measurement time.</p>
 *
 * @param measuredWidth The measured width of this view.  May be a complex
 * bit mask as defined by {@link #MEASURED_SIZE_MASK} and
 * {@link #MEASURED_STATE_TOO_SMALL}.
 * @param measuredHeight The measured height of this view.  May be a complex
 * bit mask as defined by {@link #MEASURED_SIZE_MASK} and
 * {@link #MEASURED_STATE_TOO_SMALL}.
 */

protected final void setMeasuredDimension(int measuredWidth, int measuredHeight) { throw new RuntimeException("Stub!"); }

/**
 * Merge two states as returned by {@link #getMeasuredState()}.
 * @param curState The current state as returned from a view or the result
 * of combining multiple views.
 * @param newState The new view state to combine.
 * @return Returns a new integer reflecting the combination of the two
 * states.
 */

public static int combineMeasuredStates(int curState, int newState) { throw new RuntimeException("Stub!"); }

/**
 * Version of {@link #resolveSizeAndState(int, int, int)}
 * returning only the {@link #MEASURED_SIZE_MASK} bits of the result.
 */

public static int resolveSize(int size, int measureSpec) { throw new RuntimeException("Stub!"); }

/**
 * Utility to reconcile a desired size and state, with constraints imposed
 * by a MeasureSpec. Will take the desired size, unless a different size
 * is imposed by the constraints. The returned value is a compound integer,
 * with the resolved size in the {@link #MEASURED_SIZE_MASK} bits and
 * optionally the bit {@link #MEASURED_STATE_TOO_SMALL} set if the
 * resulting size is smaller than the size the view wants to be.
 *
 * @param size How big the view wants to be.
 * @param measureSpec Constraints imposed by the parent.
 * @param childMeasuredState Size information bit mask for the view's
 *                           children.
 * @return Size information bit mask as defined by
 *         {@link #MEASURED_SIZE_MASK} and
 *         {@link #MEASURED_STATE_TOO_SMALL}.
 */

public static int resolveSizeAndState(int size, int measureSpec, int childMeasuredState) { throw new RuntimeException("Stub!"); }

/**
 * Utility to return a default size. Uses the supplied size if the
 * MeasureSpec imposed no constraints. Will get larger if allowed
 * by the MeasureSpec.
 *
 * @param size Default size for this view
 * @param measureSpec Constraints imposed by the parent
 * @return The size this view should be.
 */

public static int getDefaultSize(int size, int measureSpec) { throw new RuntimeException("Stub!"); }

/**
 * Returns the suggested minimum height that the view should use. This
 * returns the maximum of the view's minimum height
 * and the background's minimum height
 * ({@link android.graphics.drawable.Drawable#getMinimumHeight()}).
 * <p>
 * When being used in {@link #onMeasure(int, int)}, the caller should still
 * ensure the returned height is within the requirements of the parent.
 *
 * @return The suggested minimum height of the view.
 */

protected int getSuggestedMinimumHeight() { throw new RuntimeException("Stub!"); }

/**
 * Returns the suggested minimum width that the view should use. This
 * returns the maximum of the view's minimum width
 * and the background's minimum width
 *  ({@link android.graphics.drawable.Drawable#getMinimumWidth()}).
 * <p>
 * When being used in {@link #onMeasure(int, int)}, the caller should still
 * ensure the returned width is within the requirements of the parent.
 *
 * @return The suggested minimum width of the view.
 */

protected int getSuggestedMinimumWidth() { throw new RuntimeException("Stub!"); }

/**
 * Returns the minimum height of the view.
 *
 * @return the minimum height the view will try to be, in pixels
 *
 * @see #setMinimumHeight(int)
 *
 * @attr ref android.R.styleable#View_minHeight
 */

public int getMinimumHeight() { throw new RuntimeException("Stub!"); }

/**
 * Sets the minimum height of the view. It is not guaranteed the view will
 * be able to achieve this minimum height (for example, if its parent layout
 * constrains it with less available height).
 *
 * @param minHeight The minimum height the view will try to be, in pixels
 *
 * @see #getMinimumHeight()
 *
 * @attr ref android.R.styleable#View_minHeight
 */

public void setMinimumHeight(int minHeight) { throw new RuntimeException("Stub!"); }

/**
 * Returns the minimum width of the view.
 *
 * @return the minimum width the view will try to be, in pixels
 *
 * @see #setMinimumWidth(int)
 *
 * @attr ref android.R.styleable#View_minWidth
 */

public int getMinimumWidth() { throw new RuntimeException("Stub!"); }

/**
 * Sets the minimum width of the view. It is not guaranteed the view will
 * be able to achieve this minimum width (for example, if its parent layout
 * constrains it with less available width).
 *
 * @param minWidth The minimum width the view will try to be, in pixels
 *
 * @see #getMinimumWidth()
 *
 * @attr ref android.R.styleable#View_minWidth
 */

public void setMinimumWidth(int minWidth) { throw new RuntimeException("Stub!"); }

/**
 * Get the animation currently associated with this view.
 *
 * @return The animation that is currently playing or
 *         scheduled to play for this view.
 */

public android.view.animation.Animation getAnimation() { throw new RuntimeException("Stub!"); }

/**
 * Start the specified animation now.
 *
 * @param animation the animation to start now
 */

public void startAnimation(android.view.animation.Animation animation) { throw new RuntimeException("Stub!"); }

/**
 * Cancels any animations for this view.
 */

public void clearAnimation() { throw new RuntimeException("Stub!"); }

/**
 * Sets the next animation to play for this view.
 * If you want the animation to play immediately, use
 * {@link #startAnimation(android.view.animation.Animation)} instead.
 * This method provides allows fine-grained
 * control over the start time and invalidation, but you
 * must make sure that 1) the animation has a start time set, and
 * 2) the view's parent (which controls animations on its children)
 * will be invalidated when the animation is supposed to
 * start.
 *
 * @param animation The next animation, or null.
 */

public void setAnimation(android.view.animation.Animation animation) { throw new RuntimeException("Stub!"); }

/**
 * Invoked by a parent ViewGroup to notify the start of the animation
 * currently associated with this view. If you override this method,
 * always call super.onAnimationStart();
 *
 * If you override this method you <em>must</em> call through to the
 *  *            superclass implementation.
 * @see #setAnimation(android.view.animation.Animation)
 * @see #getAnimation()
 */

protected void onAnimationStart() { throw new RuntimeException("Stub!"); }

/**
 * Invoked by a parent ViewGroup to notify the end of the animation
 * currently associated with this view. If you override this method,
 * always call super.onAnimationEnd();
 *
 * If you override this method you <em>must</em> call through to the
 *  *            superclass implementation.
 * @see #setAnimation(android.view.animation.Animation)
 * @see #getAnimation()
 */

protected void onAnimationEnd() { throw new RuntimeException("Stub!"); }

/**
 * Invoked if there is a Transform that involves alpha. Subclass that can
 * draw themselves with the specified alpha should return true, and then
 * respect that alpha when their onDraw() is called. If this returns false
 * then the view may be redirected to draw into an offscreen buffer to
 * fulfill the request, which will look fine, but may be slower than if the
 * subclass handles it internally. The default implementation returns false.
 *
 * @param alpha The alpha (0..255) to apply to the view's drawing
 * @return true if the view can draw with the specified alpha.
 */

protected boolean onSetAlpha(int alpha) { throw new RuntimeException("Stub!"); }

/**
 * Play a sound effect for this view.
 *
 * <p>The framework will play sound effects for some built in actions, such as
 * clicking, but you may wish to play these effects in your widget,
 * for instance, for internal navigation.
 *
 * <p>The sound effect will only be played if sound effects are enabled by the user, and
 * {@link #isSoundEffectsEnabled()} is true.
 *
 * @param soundConstant One of the constants defined in {@link SoundEffectConstants}
 */

public void playSoundEffect(int soundConstant) { throw new RuntimeException("Stub!"); }

/**
 * BZZZTT!!1!
 *
 * <p>Provide haptic feedback to the user for this view.
 *
 * <p>The framework will provide haptic feedback for some built in actions,
 * such as long presses, but you may wish to provide feedback for your
 * own widget.
 *
 * <p>The feedback will only be performed if
 * {@link #isHapticFeedbackEnabled()} is true.
 *
 * @param feedbackConstant One of the constants defined in
 * {@link HapticFeedbackConstants}
 */

public boolean performHapticFeedback(int feedbackConstant) { throw new RuntimeException("Stub!"); }

/**
 * BZZZTT!!1!
 *
 * <p>Like {@link #performHapticFeedback(int)}, with additional options.
 *
 * @param feedbackConstant One of the constants defined in
 * {@link HapticFeedbackConstants}
 * @param flags Additional flags as per {@link HapticFeedbackConstants}.
 */

public boolean performHapticFeedback(int feedbackConstant, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Request that the visibility of the status bar or other screen/window
 * decorations be changed.
 *
 * <p>This method is used to put the over device UI into temporary modes
 * where the user's attention is focused more on the application content,
 * by dimming or hiding surrounding system affordances.  This is typically
 * used in conjunction with {@link Window#FEATURE_ACTION_BAR_OVERLAY
 * Window.FEATURE_ACTION_BAR_OVERLAY}, allowing the applications content
 * to be placed behind the action bar (and with these flags other system
 * affordances) so that smooth transitions between hiding and showing them
 * can be done.
 *
 * <p>Two representative examples of the use of system UI visibility is
 * implementing a content browsing application (like a magazine reader)
 * and a video playing application.
 *
 * <p>The first code shows a typical implementation of a View in a content
 * browsing application.  In this implementation, the application goes
 * into a content-oriented mode by hiding the status bar and action bar,
 * and putting the navigation elements into lights out mode.  The user can
 * then interact with content while in this mode.  Such an application should
 * provide an easy way for the user to toggle out of the mode (such as to
 * check information in the status bar or access notifications).  In the
 * implementation here, this is done simply by tapping on the content.
 *
 * {@sample development/samples/ApiDemos/src/com/example/android/apis/view/ContentBrowserActivity.java
 *      content}
 *
 * <p>This second code sample shows a typical implementation of a View
 * in a video playing application.  In this situation, while the video is
 * playing the application would like to go into a complete full-screen mode,
 * to use as much of the display as possible for the video.  When in this state
 * the user can not interact with the application; the system intercepts
 * touching on the screen to pop the UI out of full screen mode.  See
 * {@link #fitSystemWindows(Rect)} for a sample layout that goes with this code.
 *
 * {@sample development/samples/ApiDemos/src/com/example/android/apis/view/VideoPlayerActivity.java
 *      content}
 *
 * @param visibility  Bitwise-or of flags {@link #SYSTEM_UI_FLAG_LOW_PROFILE},
 * {@link #SYSTEM_UI_FLAG_HIDE_NAVIGATION}, {@link #SYSTEM_UI_FLAG_FULLSCREEN},
 * {@link #SYSTEM_UI_FLAG_LAYOUT_STABLE}, {@link #SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION},
 * {@link #SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN}, {@link #SYSTEM_UI_FLAG_IMMERSIVE},
 * and {@link #SYSTEM_UI_FLAG_IMMERSIVE_STICKY}.
 */

public void setSystemUiVisibility(int visibility) { throw new RuntimeException("Stub!"); }

/**
 * Returns the last {@link #setSystemUiVisibility(int)} that this view has requested.
 * @return  Bitwise-or of flags {@link #SYSTEM_UI_FLAG_LOW_PROFILE},
 * {@link #SYSTEM_UI_FLAG_HIDE_NAVIGATION}, {@link #SYSTEM_UI_FLAG_FULLSCREEN},
 * {@link #SYSTEM_UI_FLAG_LAYOUT_STABLE}, {@link #SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION},
 * {@link #SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN}, {@link #SYSTEM_UI_FLAG_IMMERSIVE},
 * and {@link #SYSTEM_UI_FLAG_IMMERSIVE_STICKY}.
 */

public int getSystemUiVisibility() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current system UI visibility that is currently set for
 * the entire window.  This is the combination of the
 * {@link #setSystemUiVisibility(int)} values supplied by all of the
 * views in the window.
 */

public int getWindowSystemUiVisibility() { throw new RuntimeException("Stub!"); }

/**
 * Override to find out when the window's requested system UI visibility
 * has changed, that is the value returned by {@link #getWindowSystemUiVisibility()}.
 * This is different from the callbacks received through
 * {@link #setOnSystemUiVisibilityChangeListener(OnSystemUiVisibilityChangeListener)}
 * in that this is only telling you about the local request of the window,
 * not the actual values applied by the system.
 */

public void onWindowSystemUiVisibilityChanged(int visible) { throw new RuntimeException("Stub!"); }

/**
 * Dispatch callbacks to {@link #onWindowSystemUiVisibilityChanged(int)} down
 * the view hierarchy.
 */

public void dispatchWindowSystemUiVisiblityChanged(int visible) { throw new RuntimeException("Stub!"); }

/**
 * Set a listener to receive callbacks when the visibility of the system bar changes.
 * @param l  The {@link OnSystemUiVisibilityChangeListener} to receive callbacks.
 */

public void setOnSystemUiVisibilityChangeListener(android.view.View.OnSystemUiVisibilityChangeListener l) { throw new RuntimeException("Stub!"); }

/**
 * Dispatch callbacks to {@link #setOnSystemUiVisibilityChangeListener} down
 * the view hierarchy.
 */

public void dispatchSystemUiVisibilityChanged(int visibility) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #startDragAndDrop(ClipData, DragShadowBuilder, Object, int)
 * startDragAndDrop()} for newer platform versions.
 */

@Deprecated public final boolean startDrag(android.content.ClipData data, android.view.View.DragShadowBuilder shadowBuilder, java.lang.Object myLocalState, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Starts a drag and drop operation. When your application calls this method, it passes a
 * {@link android.view.View.DragShadowBuilder} object to the system. The
 * system calls this object's {@link DragShadowBuilder#onProvideShadowMetrics(Point, Point)}
 * to get metrics for the drag shadow, and then calls the object's
 * {@link DragShadowBuilder#onDrawShadow(Canvas)} to draw the drag shadow itself.
 * <p>
 *  Once the system has the drag shadow, it begins the drag and drop operation by sending
 *  drag events to all the View objects in your application that are currently visible. It does
 *  this either by calling the View object's drag listener (an implementation of
 *  {@link android.view.View.OnDragListener#onDrag(View,DragEvent) onDrag()} or by calling the
 *  View object's {@link android.view.View#onDragEvent(DragEvent) onDragEvent()} method.
 *  Both are passed a {@link android.view.DragEvent} object that has a
 *  {@link android.view.DragEvent#getAction()} value of
 *  {@link android.view.DragEvent#ACTION_DRAG_STARTED}.
 * </p>
 * <p>
 * Your application can invoke {@link #startDragAndDrop(ClipData, DragShadowBuilder, Object,
 * int) startDragAndDrop()} on any attached View object. The View object does not need to be
 * the one used in {@link android.view.View.DragShadowBuilder}, nor does it need to be related
 * to the View the user selected for dragging.
 * </p>
 * @param data A {@link android.content.ClipData} object pointing to the data to be
 * transferred by the drag and drop operation.
 * @param shadowBuilder A {@link android.view.View.DragShadowBuilder} object for building the
 * drag shadow.
 * @param myLocalState An {@link java.lang.Object} containing local data about the drag and
 * drop operation. When dispatching drag events to views in the same activity this object
 * will be available through {@link android.view.DragEvent#getLocalState()}. Views in other
 * activities will not have access to this data ({@link android.view.DragEvent#getLocalState()}
 * will return null).
 * <p>
 * myLocalState is a lightweight mechanism for the sending information from the dragged View
 * to the target Views. For example, it can contain flags that differentiate between a
 * a copy operation and a move operation.
 * </p>
 * @param flags Flags that control the drag and drop operation. This can be set to 0 for no
 * flags, or any combination of the following:
 *     <ul>
 *         <li>{@link #DRAG_FLAG_GLOBAL}</li>
 *         <li>{@link #DRAG_FLAG_GLOBAL_PERSISTABLE_URI_PERMISSION}</li>
 *         <li>{@link #DRAG_FLAG_GLOBAL_PREFIX_URI_PERMISSION}</li>
 *         <li>{@link #DRAG_FLAG_GLOBAL_URI_READ}</li>
 *         <li>{@link #DRAG_FLAG_GLOBAL_URI_WRITE}</li>
 *         <li>{@link #DRAG_FLAG_OPAQUE}</li>
 *     </ul>
 * @return {@code true} if the method completes successfully, or
 * {@code false} if it fails anywhere. Returning {@code false} means the system was unable to
 * do a drag, and so no drag operation is in progress.
 */

public final boolean startDragAndDrop(android.content.ClipData data, android.view.View.DragShadowBuilder shadowBuilder, java.lang.Object myLocalState, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Cancels an ongoing drag and drop operation.
 * <p>
 * A {@link android.view.DragEvent} object with
 * {@link android.view.DragEvent#getAction()} value of
 * {@link android.view.DragEvent#ACTION_DRAG_ENDED} and
 * {@link android.view.DragEvent#getResult()} value of {@code false}
 * will be sent to every
 * View that received {@link android.view.DragEvent#ACTION_DRAG_STARTED}
 * even if they are not currently visible.
 * </p>
 * <p>
 * This method can be called on any View in the same window as the View on which
 * {@link #startDragAndDrop(ClipData, DragShadowBuilder, Object, int) startDragAndDrop}
 * was called.
 * </p>
 */

public final void cancelDragAndDrop() { throw new RuntimeException("Stub!"); }

/**
 * Updates the drag shadow for the ongoing drag and drop operation.
 *
 * @param shadowBuilder A {@link android.view.View.DragShadowBuilder} object for building the
 * new drag shadow.
 */

public final void updateDragShadow(android.view.View.DragShadowBuilder shadowBuilder) { throw new RuntimeException("Stub!"); }

/**
 * Handles drag events sent by the system following a call to
 * {@link android.view.View#startDragAndDrop(ClipData,DragShadowBuilder,Object,int)
 * startDragAndDrop()}.
 *<p>
 * When the system calls this method, it passes a
 * {@link android.view.DragEvent} object. A call to
 * {@link android.view.DragEvent#getAction()} returns one of the action type constants defined
 * in DragEvent. The method uses these to determine what is happening in the drag and drop
 * operation.
 * @param event The {@link android.view.DragEvent} sent by the system.
 * The {@link android.view.DragEvent#getAction()} method returns an action type constant defined
 * in DragEvent, indicating the type of drag event represented by this object.
 * @return {@code true} if the method was successful, otherwise {@code false}.
 * <p>
 *  The method should return {@code true} in response to an action type of
 *  {@link android.view.DragEvent#ACTION_DRAG_STARTED} to receive drag events for the current
 *  operation.
 * </p>
 * <p>
 *  The method should also return {@code true} in response to an action type of
 *  {@link android.view.DragEvent#ACTION_DROP} if it consumed the drop, or
 *  {@code false} if it didn't.
 * </p>
 * <p>
 *  For all other events, the return value is ignored.
 * </p>
 */

public boolean onDragEvent(android.view.DragEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Detects if this View is enabled and has a drag event listener.
 * If both are true, then it calls the drag event listener with the
 * {@link android.view.DragEvent} it received. If the drag event listener returns
 * {@code true}, then dispatchDragEvent() returns {@code true}.
 * <p>
 * For all other cases, the method calls the
 * {@link android.view.View#onDragEvent(DragEvent) onDragEvent()} drag event handler
 * method and returns its result.
 * </p>
 * <p>
 * This ensures that a drag event is always consumed, even if the View does not have a drag
 * event listener. However, if the View has a listener and the listener returns true, then
 * onDragEvent() is not called.
 * </p>
 */

public boolean dispatchDragEvent(android.view.DragEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Inflate a view from an XML resource.  This convenience method wraps the {@link
 * LayoutInflater} class, which provides a full range of options for view inflation.
 *
 * @param context The Context object for your activity or application.
 * @param resource The resource ID to inflate
 * @param root A view group that will be the parent.  Used to properly inflate the
 * layout_* parameters.
 * @see LayoutInflater
 */

public static android.view.View inflate(android.content.Context context, int resource, android.view.ViewGroup root) { throw new RuntimeException("Stub!"); }

/**
 * Scroll the view with standard behavior for scrolling beyond the normal
 * content boundaries. Views that call this method should override
 * {@link #onOverScrolled(int, int, boolean, boolean)} to respond to the
 * results of an over-scroll operation.
 *
 * Views can use this method to handle any touch or fling-based scrolling.
 *
 * @param deltaX Change in X in pixels
 * @param deltaY Change in Y in pixels
 * @param scrollX Current X scroll value in pixels before applying deltaX
 * @param scrollY Current Y scroll value in pixels before applying deltaY
 * @param scrollRangeX Maximum content scroll range along the X axis
 * @param scrollRangeY Maximum content scroll range along the Y axis
 * @param maxOverScrollX Number of pixels to overscroll by in either direction
 *          along the X axis.
 * @param maxOverScrollY Number of pixels to overscroll by in either direction
 *          along the Y axis.
 * @param isTouchEvent true if this scroll operation is the result of a touch event.
 * @return true if scrolling was clamped to an over-scroll boundary along either
 *          axis, false otherwise.
 */

protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) { throw new RuntimeException("Stub!"); }

/**
 * Called by {@link #overScrollBy(int, int, int, int, int, int, int, int, boolean)} to
 * respond to the results of an over-scroll operation.
 *
 * @param scrollX New X scroll value in pixels
 * @param scrollY New Y scroll value in pixels
 * @param clampedX True if scrollX was clamped to an over-scroll boundary
 * @param clampedY True if scrollY was clamped to an over-scroll boundary
 */

protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) { throw new RuntimeException("Stub!"); }

/**
 * Returns the over-scroll mode for this view. The result will be
 * one of {@link #OVER_SCROLL_ALWAYS} (default), {@link #OVER_SCROLL_IF_CONTENT_SCROLLS}
 * (allow over-scrolling only if the view content is larger than the container),
 * or {@link #OVER_SCROLL_NEVER}.
 *
 * @return This view's over-scroll mode.
 */

public int getOverScrollMode() { throw new RuntimeException("Stub!"); }

/**
 * Set the over-scroll mode for this view. Valid over-scroll modes are
 * {@link #OVER_SCROLL_ALWAYS} (default), {@link #OVER_SCROLL_IF_CONTENT_SCROLLS}
 * (allow over-scrolling only if the view content is larger than the container),
 * or {@link #OVER_SCROLL_NEVER}.
 *
 * Setting the over-scroll mode of a view will have an effect only if the
 * view is capable of scrolling.
 *
 * @param overScrollMode The new over-scroll mode for this view.
 */

public void setOverScrollMode(int overScrollMode) { throw new RuntimeException("Stub!"); }

/**
 * Enable or disable nested scrolling for this view.
 *
 * <p>If this property is set to true the view will be permitted to initiate nested
 * scrolling operations with a compatible parent view in the current hierarchy. If this
 * view does not implement nested scrolling this will have no effect. Disabling nested scrolling
 * while a nested scroll is in progress has the effect of {@link #stopNestedScroll() stopping}
 * the nested scroll.</p>
 *
 * @param enabled true to enable nested scrolling, false to disable
 *
 * @see #isNestedScrollingEnabled()
 */

public void setNestedScrollingEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if nested scrolling is enabled for this view.
 *
 * <p>If nested scrolling is enabled and this View class implementation supports it,
 * this view will act as a nested scrolling child view when applicable, forwarding data
 * about the scroll operation in progress to a compatible and cooperating nested scrolling
 * parent.</p>
 *
 * @return true if nested scrolling is enabled
 *
 * @see #setNestedScrollingEnabled(boolean)
 */

public boolean isNestedScrollingEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Begin a nestable scroll operation along the given axes.
 *
 * <p>A view starting a nested scroll promises to abide by the following contract:</p>
 *
 * <p>The view will call startNestedScroll upon initiating a scroll operation. In the case
 * of a touch scroll this corresponds to the initial {@link MotionEvent#ACTION_DOWN}.
 * In the case of touch scrolling the nested scroll will be terminated automatically in
 * the same manner as {@link ViewParent#requestDisallowInterceptTouchEvent(boolean)}.
 * In the event of programmatic scrolling the caller must explicitly call
 * {@link #stopNestedScroll()} to indicate the end of the nested scroll.</p>
 *
 * <p>If <code>startNestedScroll</code> returns true, a cooperative parent was found.
 * If it returns false the caller may ignore the rest of this contract until the next scroll.
 * Calling startNestedScroll while a nested scroll is already in progress will return true.</p>
 *
 * <p>At each incremental step of the scroll the caller should invoke
 * {@link #dispatchNestedPreScroll(int, int, int[], int[]) dispatchNestedPreScroll}
 * once it has calculated the requested scrolling delta. If it returns true the nested scrolling
 * parent at least partially consumed the scroll and the caller should adjust the amount it
 * scrolls by.</p>
 *
 * <p>After applying the remainder of the scroll delta the caller should invoke
 * {@link #dispatchNestedScroll(int, int, int, int, int[]) dispatchNestedScroll}, passing
 * both the delta consumed and the delta unconsumed. A nested scrolling parent may treat
 * these values differently. See {@link ViewParent#onNestedScroll(View, int, int, int, int)}.
 * </p>
 *
 * @param axes Flags consisting of a combination of {@link #SCROLL_AXIS_HORIZONTAL} and/or
 *             {@link #SCROLL_AXIS_VERTICAL}.
 * @return true if a cooperative parent was found and nested scrolling has been enabled for
 *         the current gesture.
 *
 * @see #stopNestedScroll()
 * @see #dispatchNestedPreScroll(int, int, int[], int[])
 * @see #dispatchNestedScroll(int, int, int, int, int[])
 */

public boolean startNestedScroll(int axes) { throw new RuntimeException("Stub!"); }

/**
 * Stop a nested scroll in progress.
 *
 * <p>Calling this method when a nested scroll is not currently in progress is harmless.</p>
 *
 * @see #startNestedScroll(int)
 */

public void stopNestedScroll() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this view has a nested scrolling parent.
 *
 * <p>The presence of a nested scrolling parent indicates that this view has initiated
 * a nested scroll and it was accepted by an ancestor view further up the view hierarchy.</p>
 *
 * @return whether this view has a nested scrolling parent
 */

public boolean hasNestedScrollingParent() { throw new RuntimeException("Stub!"); }

/**
 * Dispatch one step of a nested scroll in progress.
 *
 * <p>Implementations of views that support nested scrolling should call this to report
 * info about a scroll in progress to the current nested scrolling parent. If a nested scroll
 * is not currently in progress or nested scrolling is not
 * {@link #isNestedScrollingEnabled() enabled} for this view this method does nothing.</p>
 *
 * <p>Compatible View implementations should also call
 * {@link #dispatchNestedPreScroll(int, int, int[], int[]) dispatchNestedPreScroll} before
 * consuming a component of the scroll event themselves.</p>
 *
 * @param dxConsumed Horizontal distance in pixels consumed by this view during this scroll step
 * @param dyConsumed Vertical distance in pixels consumed by this view during this scroll step
 * @param dxUnconsumed Horizontal scroll distance in pixels not consumed by this view
 * @param dyUnconsumed Horizontal scroll distance in pixels not consumed by this view
 * @param offsetInWindow Optional. If not null, on return this will contain the offset
 *                       in local view coordinates of this view from before this operation
 *                       to after it completes. View implementations may use this to adjust
 *                       expected input coordinate tracking.
 * This value may be {@code null}.
 * @return true if the event was dispatched, false if it could not be dispatched.
 * @see #dispatchNestedPreScroll(int, int, int[], int[])
 */

public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, @androidx.annotation.RecentlyNullable int[] offsetInWindow) { throw new RuntimeException("Stub!"); }

/**
 * Dispatch one step of a nested scroll in progress before this view consumes any portion of it.
 *
 * <p>Nested pre-scroll events are to nested scroll events what touch intercept is to touch.
 * <code>dispatchNestedPreScroll</code> offers an opportunity for the parent view in a nested
 * scrolling operation to consume some or all of the scroll operation before the child view
 * consumes it.</p>
 *
 * @param dx Horizontal scroll distance in pixels
 * @param dy Vertical scroll distance in pixels
 * @param consumed Output. If not null, consumed[0] will contain the consumed component of dx
 *                 and consumed[1] the consumed dy.
 * This value may be {@code null}.
 * @param offsetInWindow Optional. If not null, on return this will contain the offset
 *                       in local view coordinates of this view from before this operation
 *                       to after it completes. View implementations may use this to adjust
 *                       expected input coordinate tracking.
 * This value may be {@code null}.
 * @return true if the parent consumed some or all of the scroll delta
 * @see #dispatchNestedScroll(int, int, int, int, int[])
 */

public boolean dispatchNestedPreScroll(int dx, int dy, @androidx.annotation.RecentlyNullable int[] consumed, @androidx.annotation.RecentlyNullable int[] offsetInWindow) { throw new RuntimeException("Stub!"); }

/**
 * Dispatch a fling to a nested scrolling parent.
 *
 * <p>This method should be used to indicate that a nested scrolling child has detected
 * suitable conditions for a fling. Generally this means that a touch scroll has ended with a
 * {@link VelocityTracker velocity} in the direction of scrolling that meets or exceeds
 * the {@link ViewConfiguration#getScaledMinimumFlingVelocity() minimum fling velocity}
 * along a scrollable axis.</p>
 *
 * <p>If a nested scrolling child view would normally fling but it is at the edge of
 * its own content, it can use this method to delegate the fling to its nested scrolling
 * parent instead. The parent may optionally consume the fling or observe a child fling.</p>
 *
 * @param velocityX Horizontal fling velocity in pixels per second
 * @param velocityY Vertical fling velocity in pixels per second
 * @param consumed true if the child consumed the fling, false otherwise
 * @return true if the nested scrolling parent consumed or otherwise reacted to the fling
 */

public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) { throw new RuntimeException("Stub!"); }

/**
 * Dispatch a fling to a nested scrolling parent before it is processed by this view.
 *
 * <p>Nested pre-fling events are to nested fling events what touch intercept is to touch
 * and what nested pre-scroll is to nested scroll. <code>dispatchNestedPreFling</code>
 * offsets an opportunity for the parent view in a nested fling to fully consume the fling
 * before the child view consumes it. If this method returns <code>true</code>, a nested
 * parent view consumed the fling and this view should not scroll as a result.</p>
 *
 * <p>For a better user experience, only one view in a nested scrolling chain should consume
 * the fling at a time. If a parent view consumed the fling this method will return false.
 * Custom view implementations should account for this in two ways:</p>
 *
 * <ul>
 *     <li>If a custom view is paged and needs to settle to a fixed page-point, do not
 *     call <code>dispatchNestedPreFling</code>; consume the fling and settle to a valid
 *     position regardless.</li>
 *     <li>If a nested parent does consume the fling, this view should not scroll at all,
 *     even to settle back to a valid idle position.</li>
 * </ul>
 *
 * <p>Views should also not offer fling velocities to nested parent views along an axis
 * where scrolling is not currently supported; a {@link android.widget.ScrollView ScrollView}
 * should not offer a horizontal fling velocity to its parents since scrolling along that
 * axis is not permitted and carrying velocity along that motion does not make sense.</p>
 *
 * @param velocityX Horizontal fling velocity in pixels per second
 * @param velocityY Vertical fling velocity in pixels per second
 * @return true if a nested scrolling parent consumed the fling
 */

public boolean dispatchNestedPreFling(float velocityX, float velocityY) { throw new RuntimeException("Stub!"); }

/**
 * Set the text direction.
 *
 * @param textDirection the direction to set. Should be one of:
 *
 * {@link #TEXT_DIRECTION_INHERIT},
 * {@link #TEXT_DIRECTION_FIRST_STRONG},
 * {@link #TEXT_DIRECTION_ANY_RTL},
 * {@link #TEXT_DIRECTION_LTR},
 * {@link #TEXT_DIRECTION_RTL},
 * {@link #TEXT_DIRECTION_LOCALE}
 * {@link #TEXT_DIRECTION_FIRST_STRONG_LTR},
 * {@link #TEXT_DIRECTION_FIRST_STRONG_RTL},
 *
 * Resolution will be done if the value is set to TEXT_DIRECTION_INHERIT. The resolution
 * proceeds up the parent chain of the view to get the value. If there is no parent, then it will
 * return the default {@link #TEXT_DIRECTION_FIRST_STRONG}.
 *
 * @attr ref android.R.styleable#View_textDirection
 */

public void setTextDirection(int textDirection) { throw new RuntimeException("Stub!"); }

/**
 * Return the resolved text direction.
 *
 * @return the resolved text direction. Returns one of:
 *
 * {@link #TEXT_DIRECTION_FIRST_STRONG},
 * {@link #TEXT_DIRECTION_ANY_RTL},
 * {@link #TEXT_DIRECTION_LTR},
 * {@link #TEXT_DIRECTION_RTL},
 * {@link #TEXT_DIRECTION_LOCALE},
 * {@link #TEXT_DIRECTION_FIRST_STRONG_LTR},
 * {@link #TEXT_DIRECTION_FIRST_STRONG_RTL}
 *
 * @attr ref android.R.styleable#View_textDirection
 */

@android.view.ViewDebug.ExportedProperty(category="text", mapping={@android.view.ViewDebug.IntToString(from=android.view.View.TEXT_DIRECTION_INHERIT, to="INHERIT"), @android.view.ViewDebug.IntToString(from=android.view.View.TEXT_DIRECTION_FIRST_STRONG, to="FIRST_STRONG"), @android.view.ViewDebug.IntToString(from=android.view.View.TEXT_DIRECTION_ANY_RTL, to="ANY_RTL"), @android.view.ViewDebug.IntToString(from=android.view.View.TEXT_DIRECTION_LTR, to="LTR"), @android.view.ViewDebug.IntToString(from=android.view.View.TEXT_DIRECTION_RTL, to="RTL"), @android.view.ViewDebug.IntToString(from=android.view.View.TEXT_DIRECTION_LOCALE, to="LOCALE"), @android.view.ViewDebug.IntToString(from=android.view.View.TEXT_DIRECTION_FIRST_STRONG_LTR, to="FIRST_STRONG_LTR"), @android.view.ViewDebug.IntToString(from=android.view.View.TEXT_DIRECTION_FIRST_STRONG_RTL, to="FIRST_STRONG_RTL")}) public int getTextDirection() { throw new RuntimeException("Stub!"); }

/**
 * Check if text direction resolution can be done.
 *
 * @return true if text direction resolution can be done otherwise return false.
 */

public boolean canResolveTextDirection() { throw new RuntimeException("Stub!"); }

/**
 * @return true if text direction is resolved.
 */

public boolean isTextDirectionResolved() { throw new RuntimeException("Stub!"); }

/**
 * Set the text alignment.
 *
 * @param textAlignment The text alignment to set. Should be one of
 *
 * {@link #TEXT_ALIGNMENT_INHERIT},
 * {@link #TEXT_ALIGNMENT_GRAVITY},
 * {@link #TEXT_ALIGNMENT_CENTER},
 * {@link #TEXT_ALIGNMENT_TEXT_START},
 * {@link #TEXT_ALIGNMENT_TEXT_END},
 * {@link #TEXT_ALIGNMENT_VIEW_START},
 * {@link #TEXT_ALIGNMENT_VIEW_END}
 *
 * Resolution will be done if the value is set to TEXT_ALIGNMENT_INHERIT. The resolution
 * proceeds up the parent chain of the view to get the value. If there is no parent, then it
 * will return the default {@link #TEXT_ALIGNMENT_GRAVITY}.
 *
 * Value is {@link android.view.View#TEXT_ALIGNMENT_INHERIT}, {@link android.view.View#TEXT_ALIGNMENT_GRAVITY}, {@link android.view.View#TEXT_ALIGNMENT_CENTER}, {@link android.view.View#TEXT_ALIGNMENT_TEXT_START}, {@link android.view.View#TEXT_ALIGNMENT_TEXT_END}, {@link android.view.View#TEXT_ALIGNMENT_VIEW_START}, or {@link android.view.View#TEXT_ALIGNMENT_VIEW_END}
 * @attr ref android.R.styleable#View_textAlignment
 */

public void setTextAlignment(int textAlignment) { throw new RuntimeException("Stub!"); }

/**
 * Return the resolved text alignment.
 *
 * @return the resolved text alignment. Returns one of:
 *
 * {@link #TEXT_ALIGNMENT_GRAVITY},
 * {@link #TEXT_ALIGNMENT_CENTER},
 * {@link #TEXT_ALIGNMENT_TEXT_START},
 * {@link #TEXT_ALIGNMENT_TEXT_END},
 * {@link #TEXT_ALIGNMENT_VIEW_START},
 * {@link #TEXT_ALIGNMENT_VIEW_END}
 *
 * Value is {@link android.view.View#TEXT_ALIGNMENT_INHERIT}, {@link android.view.View#TEXT_ALIGNMENT_GRAVITY}, {@link android.view.View#TEXT_ALIGNMENT_CENTER}, {@link android.view.View#TEXT_ALIGNMENT_TEXT_START}, {@link android.view.View#TEXT_ALIGNMENT_TEXT_END}, {@link android.view.View#TEXT_ALIGNMENT_VIEW_START}, or {@link android.view.View#TEXT_ALIGNMENT_VIEW_END}
 * @attr ref android.R.styleable#View_textAlignment
 */

@android.view.ViewDebug.ExportedProperty(category="text", mapping={@android.view.ViewDebug.IntToString(from=android.view.View.TEXT_ALIGNMENT_INHERIT, to="INHERIT"), @android.view.ViewDebug.IntToString(from=android.view.View.TEXT_ALIGNMENT_GRAVITY, to="GRAVITY"), @android.view.ViewDebug.IntToString(from=android.view.View.TEXT_ALIGNMENT_TEXT_START, to="TEXT_START"), @android.view.ViewDebug.IntToString(from=android.view.View.TEXT_ALIGNMENT_TEXT_END, to="TEXT_END"), @android.view.ViewDebug.IntToString(from=android.view.View.TEXT_ALIGNMENT_CENTER, to="CENTER"), @android.view.ViewDebug.IntToString(from=android.view.View.TEXT_ALIGNMENT_VIEW_START, to="VIEW_START"), @android.view.ViewDebug.IntToString(from=android.view.View.TEXT_ALIGNMENT_VIEW_END, to="VIEW_END")}) public int getTextAlignment() { throw new RuntimeException("Stub!"); }

/**
 * Check if text alignment resolution can be done.
 *
 * @return true if text alignment resolution can be done otherwise return false.
 */

public boolean canResolveTextAlignment() { throw new RuntimeException("Stub!"); }

/**
 * @return true if text alignment is resolved.
 */

public boolean isTextAlignmentResolved() { throw new RuntimeException("Stub!"); }

/**
 * Generate a value suitable for use in {@link #setId(int)}.
 * This value will not collide with ID values generated at build time by aapt for R.id.
 *
 * @return a generated ID value
 */

public static int generateViewId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the pointer icon for the motion event, or null if it doesn't specify the icon.
 * The default implementation does not care the location or event types, but some subclasses
 * may use it (such as WebViews).
 * @param event The MotionEvent from a mouse
 * @param pointerIndex The index of the pointer for which to retrieve the {@link PointerIcon}.
 *                     This will be between 0 and {@link MotionEvent#getPointerCount()}.
 * @see PointerIcon
 */

public android.view.PointerIcon onResolvePointerIcon(android.view.MotionEvent event, int pointerIndex) { throw new RuntimeException("Stub!"); }

/**
 * Set the pointer icon for the current view.
 * Passing {@code null} will restore the pointer icon to its default value.
 * @param pointerIcon A PointerIcon instance which will be shown when the mouse hovers.
 */

public void setPointerIcon(android.view.PointerIcon pointerIcon) { throw new RuntimeException("Stub!"); }

/**
 * Gets the pointer icon for the current view.
 */

public android.view.PointerIcon getPointerIcon() { throw new RuntimeException("Stub!"); }

/**
 * Checks pointer capture status.
 *
 * @return true if the view has pointer capture.
 * @see #requestPointerCapture()
 * @see #hasPointerCapture()
 */

public boolean hasPointerCapture() { throw new RuntimeException("Stub!"); }

/**
 * Requests pointer capture mode.
 * <p>
 * When the window has pointer capture, the mouse pointer icon will disappear and will not
 * change its position. Further mouse will be dispatched with the source
 * {@link InputDevice#SOURCE_MOUSE_RELATIVE}, and relative position changes will be available
 * through {@link MotionEvent#getX} and {@link MotionEvent#getY}. Non-mouse events
 * (touchscreens, or stylus) will not be affected.
 * <p>
 * If the window already has pointer capture, this call does nothing.
 * <p>
 * The capture may be released through {@link #releasePointerCapture()}, or will be lost
 * automatically when the window loses focus.
 *
 * @see #releasePointerCapture()
 * @see #hasPointerCapture()
 */

public void requestPointerCapture() { throw new RuntimeException("Stub!"); }

/**
 * Releases the pointer capture.
 * <p>
 * If the window does not have pointer capture, this call will do nothing.
 * @see #requestPointerCapture()
 * @see #hasPointerCapture()
 */

public void releasePointerCapture() { throw new RuntimeException("Stub!"); }

/**
 * Called when the window has just acquired or lost pointer capture.
 *
 * If you override this method you <em>must</em> call through to the
 *  *            superclass implementation.
 * @param hasCapture True if the view now has pointerCapture, false otherwise.
 */

public void onPointerCaptureChange(boolean hasCapture) { throw new RuntimeException("Stub!"); }

/**
 * @see #onPointerCaptureChange
 */

public void dispatchPointerCaptureChanged(boolean hasCapture) { throw new RuntimeException("Stub!"); }

/**
 * Implement this method to handle captured pointer events
 *
 * @param event The captured pointer event.
 * @return True if the event was handled, false otherwise.
 * @see #requestPointerCapture()
 */

public boolean onCapturedPointerEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Set a listener to receive callbacks when the pointer capture state of a view changes.
 * @param l  The {@link OnCapturedPointerListener} to receive callbacks.
 */

public void setOnCapturedPointerListener(android.view.View.OnCapturedPointerListener l) { throw new RuntimeException("Stub!"); }

/**
 * This method returns a ViewPropertyAnimator object, which can be used to animate
 * specific properties on this View.
 *
 * @return ViewPropertyAnimator The ViewPropertyAnimator associated with this View.
 */

public android.view.ViewPropertyAnimator animate() { throw new RuntimeException("Stub!"); }

/**
 * Sets the name of the View to be used to identify Views in Transitions.
 * Names should be unique in the View hierarchy.
 *
 * @param transitionName The name of the View to uniquely identify it for Transitions.
 */

public final void setTransitionName(java.lang.String transitionName) { throw new RuntimeException("Stub!"); }

/**
 * Returns the name of the View to be used to identify Views in Transitions.
 * Names should be unique in the View hierarchy.
 *
 * <p>This returns null if the View has not been given a name.</p>
 *
 * @return The name used of the View to be used to identify Views in Transitions or null
 * if no name has been given.
 */

@android.view.ViewDebug.ExportedProperty public java.lang.String getTransitionName() { throw new RuntimeException("Stub!"); }

/**
 * Sets the tooltip text which will be displayed in a small popup next to the view.
 * <p>
 * The tooltip will be displayed:
 * <ul>
 * <li>On long click, unless it is handled otherwise (by OnLongClickListener or a context
 * menu). </li>
 * <li>On hover, after a brief delay since the pointer has stopped moving </li>
 * </ul>
 * <p>
 * <strong>Note:</strong> Do not override this method, as it will have no
 * effect on the text displayed in the tooltip.
 *
 * @param tooltipText the tooltip text, or null if no tooltip is required
 * This value may be {@code null}.
 * @see #getTooltipText()
 * @attr ref android.R.styleable#View_tooltipText
 */

public void setTooltipText(@androidx.annotation.RecentlyNullable java.lang.CharSequence tooltipText) { throw new RuntimeException("Stub!"); }

/**
 * Returns the view's tooltip text.
 *
 * <strong>Note:</strong> Do not override this method, as it will have no
 * effect on the text displayed in the tooltip. You must call
 * {@link #setTooltipText(CharSequence)} to modify the tooltip text.
 *
 * @return the tooltip text
 * This value may be {@code null}.
 * @see #setTooltipText(CharSequence)
 * @attr ref android.R.styleable#View_tooltipText
 */

@androidx.annotation.RecentlyNullable public java.lang.CharSequence getTooltipText() { throw new RuntimeException("Stub!"); }

/**
 * Adds a listener which will receive unhandled {@link KeyEvent}s. This must be called on the
 * UI thread.
 *
 * @param listener a receiver of unhandled {@link KeyEvent}s.
 * @see #removeOnUnhandledKeyEventListener
 */

public void addOnUnhandledKeyEventListener(android.view.View.OnUnhandledKeyEventListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Removes a listener which will receive unhandled {@link KeyEvent}s. This must be called on the
 * UI thread.
 *
 * @param listener a receiver of unhandled {@link KeyEvent}s.
 * @see #addOnUnhandledKeyEventListener
 */

public void removeOnUnhandledKeyEventListener(android.view.View.OnUnhandledKeyEventListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Live region mode specifying that accessibility services should interrupt
 * ongoing speech to immediately announce changes to this view.
 * <p>
 * Use with {@link #setAccessibilityLiveRegion(int)}.
 */

public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2; // 0x2

/**
 * Live region mode specifying that accessibility services should not
 * automatically announce changes to this view. This is the default live
 * region mode for most views.
 * <p>
 * Use with {@link #setAccessibilityLiveRegion(int)}.
 */

public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0; // 0x0

/**
 * Live region mode specifying that accessibility services should announce
 * changes to this view.
 * <p>
 * Use with {@link #setAccessibilityLiveRegion(int)}.
 */

public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1; // 0x1

/**
 * A Property wrapper around the <code>alpha</code> functionality handled by the
 * {@link View#setAlpha(float)} and {@link View#getAlpha()} methods.
 */

public static final android.util.Property<android.view.View, java.lang.Float> ALPHA;
static { ALPHA = null; }

/**
 * Flag requesting you to add views that are marked as not important for autofill
 * (see {@link #setImportantForAutofill(int)}) to a {@link ViewStructure}.
 */

public static final int AUTOFILL_FLAG_INCLUDE_NOT_IMPORTANT_VIEWS = 1; // 0x1

/**
 * Hint indicating that this view can be autofilled with a credit card expiration date.
 *
 * <p>It should be used when the credit card expiration date is represented by just one view;
 * if it is represented by more than one (for example, one view for the month and another view
 * for the year), then each of these views should use the hint specific for the unit
 * ({@link #AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DAY},
 * {@link #AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_MONTH},
 * or {@link #AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_YEAR}).
 *
 * <p>Can be used with either {@link #setAutofillHints(String[])} or
 * <a href="#attr_android:autofillHint"> {@code android:autofillHint}</a> (in which case the
 * value should be <code>{@value #AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DATE}</code>).
 *
 * <p>When annotating a view with this hint, it's recommended to use a date autofill value to
 * avoid ambiguity when the autofill service provides a value for it. To understand why a
 * value can be ambiguous, consider "April of 2020", which could be represented as either of
 * the following options:
 *
 * <ul>
 *   <li>{@code "04/2020"}
 *   <li>{@code "4/2020"}
 *   <li>{@code "2020/04"}
 *   <li>{@code "2020/4"}
 *   <li>{@code "April/2020"}
 *   <li>{@code "Apr/2020"}
 * </ul>
 *
 * <p>You define a date autofill value for the view by overriding the following methods:
 *
 * <ol>
 *   <li>{@link #getAutofillType()} to return {@link #AUTOFILL_TYPE_DATE}.
 *   <li>{@link #getAutofillValue()} to return a
 *       {@link AutofillValue#forDate(long) date autofillvalue}.
 *   <li>{@link #autofill(AutofillValue)} to expect a data autofillvalue.
 * </ol>
 *
 * <p>See {@link #setAutofillHints(String...)} for more info about autofill hints.
 */

public static final java.lang.String AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DATE = "creditCardExpirationDate";

/**
 * Hint indicating that this view can be autofilled with a credit card expiration day.
 *
 * <p>Can be used with either {@link #setAutofillHints(String[])} or
 * <a href="#attr_android:autofillHint"> {@code android:autofillHint}</a> (in which case the
 * value should be <code>{@value #AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DAY}</code>).
 *
 * <p>See {@link #setAutofillHints(String...)} for more info about autofill hints.
 */

public static final java.lang.String AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DAY = "creditCardExpirationDay";

/**
 * Hint indicating that this view can be autofilled with a credit card expiration month.
 *
 * <p>Can be used with either {@link #setAutofillHints(String[])} or
 * <a href="#attr_android:autofillHint"> {@code android:autofillHint}</a> (in which case the
 * value should be <code>{@value #AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_MONTH}</code>).
 *
 * <p>When annotating a view with this hint, it's recommended to use a text autofill value
 * whose value is the numerical representation of the month, starting on {@code 1} to avoid
 * ambiguity when the autofill service provides a value for it. To understand why a
 * value can be ambiguous, consider "January", which could be represented as either of
 *
 * <ul>
 *   <li>{@code "1"}: recommended way.
 *   <li>{@code "0"}: if following the {@link Calendar#MONTH} convention.
 *   <li>{@code "January"}: full name, in English.
 *   <li>{@code "jan"}: abbreviated name, in English.
 *   <li>{@code "Janeiro"}: full name, in another language.
 * </ul>
 *
 * <p>Another recommended approach is to use a date autofill value - see
 * {@link #AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DATE} for more details.
 *
 * <p>See {@link #setAutofillHints(String...)} for more info about autofill hints.
 */

public static final java.lang.String AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_MONTH = "creditCardExpirationMonth";

/**
 * Hint indicating that this view can be autofilled with a credit card expiration year.
 *
 * <p>Can be used with either {@link #setAutofillHints(String[])} or
 * <a href="#attr_android:autofillHint"> {@code android:autofillHint}</a> (in which case the
 * value should be <code>{@value #AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_YEAR}</code>).
 *
 * <p>See {@link #setAutofillHints(String...)} for more info about autofill hints.
 */

public static final java.lang.String AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_YEAR = "creditCardExpirationYear";

/**
 * Hint indicating that this view can be autofilled with a credit card number.
 *
 * <p>Can be used with either {@link #setAutofillHints(String[])} or
 * <a href="#attr_android:autofillHint"> {@code android:autofillHint}</a> (in which case the
 * value should be <code>{@value #AUTOFILL_HINT_CREDIT_CARD_NUMBER}</code>).
 *
 * <p>See {@link #setAutofillHints(String...)} for more info about autofill hints.
 */

public static final java.lang.String AUTOFILL_HINT_CREDIT_CARD_NUMBER = "creditCardNumber";

/**
 * Hint indicating that this view can be autofilled with a credit card security code.
 *
 * <p>Can be used with either {@link #setAutofillHints(String[])} or
 * <a href="#attr_android:autofillHint"> {@code android:autofillHint}</a> (in which case the
 * value should be <code>{@value #AUTOFILL_HINT_CREDIT_CARD_SECURITY_CODE}</code>).
 *
 * <p>See {@link #setAutofillHints(String...)} for more info about autofill hints.
 */

public static final java.lang.String AUTOFILL_HINT_CREDIT_CARD_SECURITY_CODE = "creditCardSecurityCode";

/**
 * Hint indicating that this view can be autofilled with an email address.
 *
 * <p>Can be used with either {@link #setAutofillHints(String[])} or
 * <a href="#attr_android:autofillHint"> {@code android:autofillHint}</a> (in which case the
 * value should be <code>{@value #AUTOFILL_HINT_EMAIL_ADDRESS}</code>).
 *
 * <p>See {@link #setAutofillHints(String...)} for more info about autofill hints.
 */

public static final java.lang.String AUTOFILL_HINT_EMAIL_ADDRESS = "emailAddress";

/**
 * Hint indicating that this view can be autofilled with a user's real name.
 *
 * <p>Can be used with either {@link #setAutofillHints(String[])} or
 * <a href="#attr_android:autofillHint"> {@code android:autofillHint}</a> (in which case the
 * value should be <code>{@value #AUTOFILL_HINT_NAME}</code>).
 *
 * <p>See {@link #setAutofillHints(String...)} for more info about autofill hints.
 */

public static final java.lang.String AUTOFILL_HINT_NAME = "name";

/**
 * Hint indicating that this view can be autofilled with a password.
 *
 * <p>Can be used with either {@link #setAutofillHints(String[])} or
 * <a href="#attr_android:autofillHint"> {@code android:autofillHint}</a> (in which case the
 * value should be <code>{@value #AUTOFILL_HINT_PASSWORD}</code>).
 *
 * <p>See {@link #setAutofillHints(String...)} for more info about autofill hints.
 */

public static final java.lang.String AUTOFILL_HINT_PASSWORD = "password";

/**
 * Hint indicating that this view can be autofilled with a phone number.
 *
 * <p>Can be used with either {@link #setAutofillHints(String[])} or
 * <a href="#attr_android:autofillHint"> {@code android:autofillHint}</a> (in which case the
 * value should be <code>{@value #AUTOFILL_HINT_PHONE}</code>).
 *
 * <p>See {@link #setAutofillHints(String...)} for more info about autofill hints.
 */

public static final java.lang.String AUTOFILL_HINT_PHONE = "phone";

/**
 * Hint indicating that this view can be autofilled with a postal address.
 *
 * <p>Can be used with either {@link #setAutofillHints(String[])} or
 * <a href="#attr_android:autofillHint"> {@code android:autofillHint}</a> (in which case the
 * value should be <code>{@value #AUTOFILL_HINT_POSTAL_ADDRESS}</code>).
 *
 * <p>See {@link #setAutofillHints(String...)} for more info about autofill hints.
 */

public static final java.lang.String AUTOFILL_HINT_POSTAL_ADDRESS = "postalAddress";

/**
 * Hint indicating that this view can be autofilled with a postal code.
 *
 * <p>Can be used with either {@link #setAutofillHints(String[])} or
 * <a href="#attr_android:autofillHint"> {@code android:autofillHint}</a> (in which case the
 * value should be <code>{@value #AUTOFILL_HINT_POSTAL_CODE}</code>).
 *
 * <p>See {@link #setAutofillHints(String...)} for more info about autofill hints.
 */

public static final java.lang.String AUTOFILL_HINT_POSTAL_CODE = "postalCode";

/**
 * Hint indicating that this view can be autofilled with a username.
 *
 * <p>Can be used with either {@link #setAutofillHints(String[])} or
 * <a href="#attr_android:autofillHint"> {@code android:autofillHint}</a> (in which case the
 * value should be <code>{@value #AUTOFILL_HINT_USERNAME}</code>).
 *
 * <p>See {@link #setAutofillHints(String...)} for more info about autofill hints.
 */

public static final java.lang.String AUTOFILL_HINT_USERNAME = "username";

/**
 * Autofill type for a field that contains a date, which is represented by a long representing
 * the number of milliseconds since the standard base time known as "the epoch", namely
 * January 1, 1970, 00:00:00 GMT (see {@link java.util.Date#getTime()}.
 *
 * <p>{@link AutofillValue} instances for autofilling a {@link View} can be obtained through
 * {@link AutofillValue#forDate(long)}, and the values passed to
 * autofill a {@link View} can be fetched through {@link AutofillValue#getDateValue()}.
 *
 * @see #getAutofillType()
 */

public static final int AUTOFILL_TYPE_DATE = 4; // 0x4

/**
 * Autofill type for a selection list field, which is filled by an {@code int}
 * representing the element index inside the list (starting at {@code 0}).
 *
 * <p>{@link AutofillValue} instances for autofilling a {@link View} can be obtained through
 * {@link AutofillValue#forList(int)}, and the value passed to autofill a
 * {@link View} can be fetched through {@link AutofillValue#getListValue()}.
 *
 * <p>The available options in the selection list are typically provided by
 * {@link android.app.assist.AssistStructure.ViewNode#getAutofillOptions()}.
 *
 * @see #getAutofillType()
 */

public static final int AUTOFILL_TYPE_LIST = 3; // 0x3

/**
 * Autofill type for views that cannot be autofilled.
 *
 * <p>Typically used when the view is read-only; for example, a text label.
 *
 * @see #getAutofillType()
 */

public static final int AUTOFILL_TYPE_NONE = 0; // 0x0

/**
 * Autofill type for a text field, which is filled by a {@link CharSequence}.
 *
 * <p>{@link AutofillValue} instances for autofilling a {@link View} can be obtained through
 * {@link AutofillValue#forText(CharSequence)}, and the value passed to autofill a
 * {@link View} can be fetched through {@link AutofillValue#getTextValue()}.
 *
 * @see #getAutofillType()
 */

public static final int AUTOFILL_TYPE_TEXT = 1; // 0x1

/**
 * Autofill type for a togglable field, which is filled by a {@code boolean}.
 *
 * <p>{@link AutofillValue} instances for autofilling a {@link View} can be obtained through
 * {@link AutofillValue#forToggle(boolean)}, and the value passed to autofill a
 * {@link View} can be fetched through {@link AutofillValue#getToggleValue()}.
 *
 * @see #getAutofillType()
 */

public static final int AUTOFILL_TYPE_TOGGLE = 2; // 0x2

/**
 * Flag indicating that a drag can cross window boundaries.  When
 * {@link #startDragAndDrop(ClipData, DragShadowBuilder, Object, int)} is called
 * with this flag set, all visible applications with targetSdkVersion >=
 * {@link android.os.Build.VERSION_CODES#N API 24} will be able to participate
 * in the drag operation and receive the dragged content.
 *
 * <p>If this is the only flag set, then the drag recipient will only have access to text data
 * and intents contained in the {@link ClipData} object. Access to URIs contained in the
 * {@link ClipData} is determined by other DRAG_FLAG_GLOBAL_* flags</p>
 */

public static final int DRAG_FLAG_GLOBAL = 256; // 0x100

/**
 * When this flag is used with {@link #DRAG_FLAG_GLOBAL_URI_READ} and/or {@link
 * #DRAG_FLAG_GLOBAL_URI_WRITE}, the URI permission grant can be persisted across device
 * reboots until explicitly revoked with
 * {@link android.content.Context#revokeUriPermission(Uri, int)} Context.revokeUriPermission}.
 * @see android.content.Intent#FLAG_GRANT_PERSISTABLE_URI_PERMISSION
 */

public static final int DRAG_FLAG_GLOBAL_PERSISTABLE_URI_PERMISSION = 64; // 0x40

/**
 * When this flag is used with {@link #DRAG_FLAG_GLOBAL_URI_READ} and/or {@link
 * #DRAG_FLAG_GLOBAL_URI_WRITE}, the URI permission grant applies to any URI that is a prefix
 * match against the original granted URI.
 * @see android.content.Intent#FLAG_GRANT_PREFIX_URI_PERMISSION
 */

public static final int DRAG_FLAG_GLOBAL_PREFIX_URI_PERMISSION = 128; // 0x80

/**
 * When this flag is used with {@link #DRAG_FLAG_GLOBAL}, the drag recipient will be able to
 * request read access to the content URI(s) contained in the {@link ClipData} object.
 * @see android.content.Intent#FLAG_GRANT_READ_URI_PERMISSION
 */

public static final int DRAG_FLAG_GLOBAL_URI_READ = 1; // 0x1

/**
 * When this flag is used with {@link #DRAG_FLAG_GLOBAL}, the drag recipient will be able to
 * request write access to the content URI(s) contained in the {@link ClipData} object.
 * @see android.content.Intent#FLAG_GRANT_WRITE_URI_PERMISSION
 */

public static final int DRAG_FLAG_GLOBAL_URI_WRITE = 2; // 0x2

/**
 * Flag indicating that the drag shadow will be opaque.  When
 * {@link #startDragAndDrop(ClipData, DragShadowBuilder, Object, int)} is called
 * with this flag set, the drag shadow will be opaque, otherwise, it will be semitransparent.
 */

public static final int DRAG_FLAG_OPAQUE = 512; // 0x200

/**
 * <p>Enables automatic quality mode for the drawing cache.</p>
 *
 * @deprecated The view drawing cache was largely made obsolete with the introduction of
 * hardware-accelerated rendering in API 11. With hardware-acceleration, intermediate cache
 * layers are largely unnecessary and can easily result in a net loss in performance due to the
 * cost of creating and updating the layer. In the rare cases where caching layers are useful,
 * such as for alpha animations, {@link #setLayerType(int, Paint)} handles this with hardware
 * rendering. For software-rendered snapshots of a small part of the View hierarchy or
 * individual Views it is recommended to create a {@link Canvas} from either a {@link Bitmap} or
 * {@link android.graphics.Picture} and call {@link #draw(Canvas)} on the View. However these
 * software-rendered usages are discouraged and have compatibility issues with hardware-only
 * rendering features such as {@link android.graphics.Bitmap.Config#HARDWARE Config.HARDWARE}
 * bitmaps, real-time shadows, and outline clipping. For screenshots of the UI for feedback
 * reports or unit testing the {@link PixelCopy} API is recommended.
 */

@Deprecated public static final int DRAWING_CACHE_QUALITY_AUTO = 0; // 0x0

/**
 * <p>Enables high quality mode for the drawing cache.</p>
 *
 * @deprecated The view drawing cache was largely made obsolete with the introduction of
 * hardware-accelerated rendering in API 11. With hardware-acceleration, intermediate cache
 * layers are largely unnecessary and can easily result in a net loss in performance due to the
 * cost of creating and updating the layer. In the rare cases where caching layers are useful,
 * such as for alpha animations, {@link #setLayerType(int, Paint)} handles this with hardware
 * rendering. For software-rendered snapshots of a small part of the View hierarchy or
 * individual Views it is recommended to create a {@link Canvas} from either a {@link Bitmap} or
 * {@link android.graphics.Picture} and call {@link #draw(Canvas)} on the View. However these
 * software-rendered usages are discouraged and have compatibility issues with hardware-only
 * rendering features such as {@link android.graphics.Bitmap.Config#HARDWARE Config.HARDWARE}
 * bitmaps, real-time shadows, and outline clipping. For screenshots of the UI for feedback
 * reports or unit testing the {@link PixelCopy} API is recommended.
 */

@Deprecated public static final int DRAWING_CACHE_QUALITY_HIGH = 1048576; // 0x100000

/**
 * <p>Enables low quality mode for the drawing cache.</p>
 *
 * @deprecated The view drawing cache was largely made obsolete with the introduction of
 * hardware-accelerated rendering in API 11. With hardware-acceleration, intermediate cache
 * layers are largely unnecessary and can easily result in a net loss in performance due to the
 * cost of creating and updating the layer. In the rare cases where caching layers are useful,
 * such as for alpha animations, {@link #setLayerType(int, Paint)} handles this with hardware
 * rendering. For software-rendered snapshots of a small part of the View hierarchy or
 * individual Views it is recommended to create a {@link Canvas} from either a {@link Bitmap} or
 * {@link android.graphics.Picture} and call {@link #draw(Canvas)} on the View. However these
 * software-rendered usages are discouraged and have compatibility issues with hardware-only
 * rendering features such as {@link android.graphics.Bitmap.Config#HARDWARE Config.HARDWARE}
 * bitmaps, real-time shadows, and outline clipping. For screenshots of the UI for feedback
 * reports or unit testing the {@link PixelCopy} API is recommended.
 */

@Deprecated public static final int DRAWING_CACHE_QUALITY_LOW = 524288; // 0x80000

/**
 * Indicates the view has no states set. States are used with
 * {@link android.graphics.drawable.Drawable} to change the drawing of the
 * view depending on its state.
 *
 * @see android.graphics.drawable.Drawable
 * @see #getDrawableState()
 */

protected static final int[] EMPTY_STATE_SET;
static { EMPTY_STATE_SET = new int[0]; }

/**
 * Indicates the view is enabled, focused and selected.
 *
 * @see #ENABLED_STATE_SET
 * @see #FOCUSED_STATE_SET
 * @see #SELECTED_STATE_SET
 */

protected static final int[] ENABLED_FOCUSED_SELECTED_STATE_SET;
static { ENABLED_FOCUSED_SELECTED_STATE_SET = new int[0]; }

/**
 * Indicates the view is enabled, focused, selected and its window
 * has the focus.
 *
 * @see #ENABLED_STATE_SET
 * @see #FOCUSED_STATE_SET
 * @see #SELECTED_STATE_SET
 * @see #WINDOW_FOCUSED_STATE_SET
 */

protected static final int[] ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
static { ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET = new int[0]; }

/**
 * Indicates the view is enabled and has the focus.
 *
 * @see #ENABLED_STATE_SET
 * @see #FOCUSED_STATE_SET
 */

protected static final int[] ENABLED_FOCUSED_STATE_SET;
static { ENABLED_FOCUSED_STATE_SET = new int[0]; }

/**
 * Indicates the view is enabled, focused and its window has the focus.
 *
 * @see #ENABLED_STATE_SET
 * @see #FOCUSED_STATE_SET
 * @see #WINDOW_FOCUSED_STATE_SET
 */

protected static final int[] ENABLED_FOCUSED_WINDOW_FOCUSED_STATE_SET;
static { ENABLED_FOCUSED_WINDOW_FOCUSED_STATE_SET = new int[0]; }

/**
 * Indicates the view is enabled and selected.
 *
 * @see #ENABLED_STATE_SET
 * @see #SELECTED_STATE_SET
 */

protected static final int[] ENABLED_SELECTED_STATE_SET;
static { ENABLED_SELECTED_STATE_SET = new int[0]; }

/**
 * Indicates the view is enabled, selected and its window has the focus.
 *
 * @see #ENABLED_STATE_SET
 * @see #SELECTED_STATE_SET
 * @see #WINDOW_FOCUSED_STATE_SET
 */

protected static final int[] ENABLED_SELECTED_WINDOW_FOCUSED_STATE_SET;
static { ENABLED_SELECTED_WINDOW_FOCUSED_STATE_SET = new int[0]; }

/**
 * Indicates the view is enabled. States are used with
 * {@link android.graphics.drawable.Drawable} to change the drawing of the
 * view depending on its state.
 *
 * @see android.graphics.drawable.Drawable
 * @see #getDrawableState()
 */

protected static final int[] ENABLED_STATE_SET;
static { ENABLED_STATE_SET = new int[0]; }

/**
 * Indicates the view is enabled and that its window has focus.
 *
 * @see #ENABLED_STATE_SET
 * @see #WINDOW_FOCUSED_STATE_SET
 */

protected static final int[] ENABLED_WINDOW_FOCUSED_STATE_SET;
static { ENABLED_WINDOW_FOCUSED_STATE_SET = new int[0]; }

/**
 * Find find views that contain the specified content description.
 *
 * @see #findViewsWithText(ArrayList, CharSequence, int)
 */

public static final int FIND_VIEWS_WITH_CONTENT_DESCRIPTION = 2; // 0x2

/**
 * Find views that render the specified text.
 *
 * @see #findViewsWithText(ArrayList, CharSequence, int)
 */

public static final int FIND_VIEWS_WITH_TEXT = 1; // 0x1

/**
 * This view wants keystrokes.
 * <p>
 * Use with {@link #setFocusable(int)} and <a href="#attr_android:focusable">{@code
 * android:focusable}.
 */

public static final int FOCUSABLE = 1; // 0x1

/**
 * View flag indicating whether {@link #addFocusables(ArrayList, int, int)}
 * should add all focusable Views regardless if they are focusable in touch mode.
 */

public static final int FOCUSABLES_ALL = 0; // 0x0

/**
 * View flag indicating whether {@link #addFocusables(ArrayList, int, int)}
 * should add only Views focusable in touch mode.
 */

public static final int FOCUSABLES_TOUCH_MODE = 1; // 0x1

/**
 * This view determines focusability automatically. This is the default.
 * <p>
 * Use with {@link #setFocusable(int)} and <a href="#attr_android:focusable">{@code
 * android:focusable}.
 */

public static final int FOCUSABLE_AUTO = 16; // 0x10

/**
 * Indicates the view is focused and selected.
 *
 * @see #FOCUSED_STATE_SET
 * @see #SELECTED_STATE_SET
 */

protected static final int[] FOCUSED_SELECTED_STATE_SET;
static { FOCUSED_SELECTED_STATE_SET = new int[0]; }

/**
 * Indicates the view is focused, selected and its window has the focus.
 *
 * @see #FOCUSED_STATE_SET
 * @see #SELECTED_STATE_SET
 * @see #WINDOW_FOCUSED_STATE_SET
 */

protected static final int[] FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
static { FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET = new int[0]; }

/**
 * Indicates the view is focused. States are used with
 * {@link android.graphics.drawable.Drawable} to change the drawing of the
 * view depending on its state.
 *
 * @see android.graphics.drawable.Drawable
 * @see #getDrawableState()
 */

protected static final int[] FOCUSED_STATE_SET;
static { FOCUSED_STATE_SET = new int[0]; }

/**
 * Indicates the view has the focus and that its window has the focus.
 *
 * @see #FOCUSED_STATE_SET
 * @see #WINDOW_FOCUSED_STATE_SET
 */

protected static final int[] FOCUSED_WINDOW_FOCUSED_STATE_SET;
static { FOCUSED_WINDOW_FOCUSED_STATE_SET = new int[0]; }

/**
 * Use with {@link #focusSearch(int)}. Move focus to the previous selectable
 * item.
 */

public static final int FOCUS_BACKWARD = 1; // 0x1

/**
 * Use with {@link #focusSearch(int)}. Move focus down.
 */

public static final int FOCUS_DOWN = 130; // 0x82

/**
 * Use with {@link #focusSearch(int)}. Move focus to the next selectable
 * item.
 */

public static final int FOCUS_FORWARD = 2; // 0x2

/**
 * Use with {@link #focusSearch(int)}. Move focus to the left.
 */

public static final int FOCUS_LEFT = 17; // 0x11

/**
 * Use with {@link #focusSearch(int)}. Move focus to the right.
 */

public static final int FOCUS_RIGHT = 66; // 0x42

/**
 * Use with {@link #focusSearch(int)}. Move focus up.
 */

public static final int FOCUS_UP = 33; // 0x21

/**
 * This view is invisible, and it doesn't take any space for layout
 * purposes. Use with {@link #setVisibility} and <a href="#attr_android:visibility">{@code
 * android:visibility}.
 */

public static final int GONE = 8; // 0x8

/**
 * View flag indicating whether this view should have haptic feedback
 * enabled for events such as long presses.
 */

public static final int HAPTIC_FEEDBACK_ENABLED = 268435456; // 0x10000000

/**
 * Automatically determine whether a view is important for accessibility.
 */

public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0; // 0x0

/**
 * The view is not important for accessibility.
 */

public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2; // 0x2

/**
 * The view is not important for accessibility, nor are any of its
 * descendant views.
 */

public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4; // 0x4

/**
 * The view is important for accessibility.
 */

public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1; // 0x1

/**
 * Automatically determine whether a view is important for autofill.
 *
 * @see #isImportantForAutofill()
 * @see #setImportantForAutofill(int)
 */

public static final int IMPORTANT_FOR_AUTOFILL_AUTO = 0; // 0x0

/**
 * The view is not important for autofill, but its children (if any) will be traversed.
 *
 * @see #isImportantForAutofill()
 * @see #setImportantForAutofill(int)
 */

public static final int IMPORTANT_FOR_AUTOFILL_NO = 2; // 0x2

/**
 * The view is not important for autofill, and its children (if any) will not be traversed.
 *
 * @see #isImportantForAutofill()
 * @see #setImportantForAutofill(int)
 */

public static final int IMPORTANT_FOR_AUTOFILL_NO_EXCLUDE_DESCENDANTS = 8; // 0x8

/**
 * The view is important for autofill, and its children (if any) will be traversed.
 *
 * @see #isImportantForAutofill()
 * @see #setImportantForAutofill(int)
 */

public static final int IMPORTANT_FOR_AUTOFILL_YES = 1; // 0x1

/**
 * The view is important for autofill, but its children (if any) will not be traversed.
 *
 * @see #isImportantForAutofill()
 * @see #setImportantForAutofill(int)
 */

public static final int IMPORTANT_FOR_AUTOFILL_YES_EXCLUDE_DESCENDANTS = 4; // 0x4

/**
 * This view is invisible, but it still takes up space for layout purposes.
 * Use with {@link #setVisibility} and <a href="#attr_android:visibility">{@code
 * android:visibility}.
 */

public static final int INVISIBLE = 4; // 0x4

/**
 * View flag indicating that the screen should remain on while the
 * window containing this view is visible to the user.  This effectively
 * takes care of automatically setting the WindowManager's
 * {@link WindowManager.LayoutParams#FLAG_KEEP_SCREEN_ON}.
 */

public static final int KEEP_SCREEN_ON = 67108864; // 0x4000000

/**
 * <p>Indicates that the view has a hardware layer. A hardware layer is backed
 * by a hardware specific texture (generally Frame Buffer Objects or FBO on
 * OpenGL hardware) and causes the view to be rendered using Android's hardware
 * rendering pipeline, but only if hardware acceleration is turned on for the
 * view hierarchy. When hardware acceleration is turned off, hardware layers
 * behave exactly as {@link #LAYER_TYPE_SOFTWARE software layers}.</p>
 *
 * <p>A hardware layer is useful to apply a specific color filter and/or
 * blending mode and/or translucency to a view and all its children.</p>
 * <p>A hardware layer can be used to cache a complex view tree into a
 * texture and reduce the complexity of drawing operations. For instance,
 * when animating a complex view tree with a translation, a hardware layer can
 * be used to render the view tree only once.</p>
 * <p>A hardware layer can also be used to increase the rendering quality when
 * rotation transformations are applied on a view. It can also be used to
 * prevent potential clipping issues when applying 3D transforms on a view.</p>
 *
 * @see #getLayerType()
 * @see #setLayerType(int, android.graphics.Paint)
 * @see #LAYER_TYPE_NONE
 * @see #LAYER_TYPE_SOFTWARE
 */

public static final int LAYER_TYPE_HARDWARE = 2; // 0x2

/**
 * Indicates that the view does not have a layer.
 *
 * @see #getLayerType()
 * @see #setLayerType(int, android.graphics.Paint)
 * @see #LAYER_TYPE_SOFTWARE
 * @see #LAYER_TYPE_HARDWARE
 */

public static final int LAYER_TYPE_NONE = 0; // 0x0

/**
 * <p>Indicates that the view has a software layer. A software layer is backed
 * by a bitmap and causes the view to be rendered using Android's software
 * rendering pipeline, even if hardware acceleration is enabled.</p>
 *
 * <p>Software layers have various usages:</p>
 * <p>When the application is not using hardware acceleration, a software layer
 * is useful to apply a specific color filter and/or blending mode and/or
 * translucency to a view and all its children.</p>
 * <p>When the application is using hardware acceleration, a software layer
 * is useful to render drawing primitives not supported by the hardware
 * accelerated pipeline. It can also be used to cache a complex view tree
 * into a texture and reduce the complexity of drawing operations. For instance,
 * when animating a complex view tree with a translation, a software layer can
 * be used to render the view tree only once.</p>
 * <p>Software layers should be avoided when the affected view tree updates
 * often. Every update will require to re-render the software layer, which can
 * potentially be slow (particularly when hardware acceleration is turned on
 * since the layer will have to be uploaded into a hardware texture after every
 * update.)</p>
 *
 * @see #getLayerType()
 * @see #setLayerType(int, android.graphics.Paint)
 * @see #LAYER_TYPE_NONE
 * @see #LAYER_TYPE_HARDWARE
 */

public static final int LAYER_TYPE_SOFTWARE = 1; // 0x1

/**
 * Horizontal layout direction of this view is inherited from its parent.
 * Use with {@link #setLayoutDirection}.
 */

public static final int LAYOUT_DIRECTION_INHERIT = 2; // 0x2

/**
 * Horizontal layout direction of this view is from deduced from the default language
 * script for the locale. Use with {@link #setLayoutDirection}.
 */

public static final int LAYOUT_DIRECTION_LOCALE = 3; // 0x3

/**
 * Horizontal layout direction of this view is from Left to Right.
 * Use with {@link #setLayoutDirection}.
 */

public static final int LAYOUT_DIRECTION_LTR = 0; // 0x0

/**
 * Horizontal layout direction of this view is from Right to Left.
 * Use with {@link #setLayoutDirection}.
 */

public static final int LAYOUT_DIRECTION_RTL = 1; // 0x1

/**
 * Bit shift of {@link #MEASURED_STATE_MASK} to get to the height bits
 * for functions that combine both width and height into a single int,
 * such as {@link #getMeasuredState()} and the childState argument of
 * {@link #resolveSizeAndState(int, int, int)}.
 */

public static final int MEASURED_HEIGHT_STATE_SHIFT = 16; // 0x10

/**
 * Bits of {@link #getMeasuredWidthAndState()} and
 * {@link #getMeasuredWidthAndState()} that provide the actual measured size.
 */

public static final int MEASURED_SIZE_MASK = 16777215; // 0xffffff

/**
 * Bits of {@link #getMeasuredWidthAndState()} and
 * {@link #getMeasuredWidthAndState()} that provide the additional state bits.
 */

public static final int MEASURED_STATE_MASK = -16777216; // 0xff000000

/**
 * Bit of {@link #getMeasuredWidthAndState()} and
 * {@link #getMeasuredWidthAndState()} that indicates the measured size
 * is smaller that the space the view would like to have.
 */

public static final int MEASURED_STATE_TOO_SMALL = 16777216; // 0x1000000

/**
 * This view does not want keystrokes.
 * <p>
 * Use with {@link #setFocusable(int)} and <a href="#attr_android:focusable">{@code
 * android:focusable}.
 */

public static final int NOT_FOCUSABLE = 0; // 0x0

/**
 * Used to mark a View that has no ID.
 */

public static final int NO_ID = -1; // 0xffffffff

/**
 * Always allow a user to over-scroll this view, provided it is a
 * view that can scroll.
 *
 * @see #getOverScrollMode()
 * @see #setOverScrollMode(int)
 */

public static final int OVER_SCROLL_ALWAYS = 0; // 0x0

/**
 * Allow a user to over-scroll this view only if the content is large
 * enough to meaningfully scroll, provided it is a view that can scroll.
 *
 * @see #getOverScrollMode()
 * @see #setOverScrollMode(int)
 */

public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1; // 0x1

/**
 * Never allow a user to over-scroll this view.
 *
 * @see #getOverScrollMode()
 * @see #setOverScrollMode(int)
 */

public static final int OVER_SCROLL_NEVER = 2; // 0x2

/**
 * Indicates the view is pressed, enabled, focused and selected.
 *
 * @see #PRESSED_STATE_SET
 * @see #ENABLED_STATE_SET
 * @see #SELECTED_STATE_SET
 * @see #FOCUSED_STATE_SET
 */

protected static final int[] PRESSED_ENABLED_FOCUSED_SELECTED_STATE_SET;
static { PRESSED_ENABLED_FOCUSED_SELECTED_STATE_SET = new int[0]; }

/**
 * Indicates the view is pressed, enabled, focused, selected and its window
 * has the focus.
 *
 * @see #PRESSED_STATE_SET
 * @see #ENABLED_STATE_SET
 * @see #SELECTED_STATE_SET
 * @see #FOCUSED_STATE_SET
 * @see #WINDOW_FOCUSED_STATE_SET
 */

protected static final int[] PRESSED_ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
static { PRESSED_ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET = new int[0]; }

/**
 * Indicates the view is pressed, enabled and focused.
 *
 * @see #PRESSED_STATE_SET
 * @see #ENABLED_STATE_SET
 * @see #FOCUSED_STATE_SET
 */

protected static final int[] PRESSED_ENABLED_FOCUSED_STATE_SET;
static { PRESSED_ENABLED_FOCUSED_STATE_SET = new int[0]; }

/**
 * Indicates the view is pressed, enabled, focused and its window has the
 * focus.
 *
 * @see #PRESSED_STATE_SET
 * @see #ENABLED_STATE_SET
 * @see #FOCUSED_STATE_SET
 * @see #WINDOW_FOCUSED_STATE_SET
 */

protected static final int[] PRESSED_ENABLED_FOCUSED_WINDOW_FOCUSED_STATE_SET;
static { PRESSED_ENABLED_FOCUSED_WINDOW_FOCUSED_STATE_SET = new int[0]; }

/**
 * Indicates the view is pressed, enabled and selected.
 *
 * @see #PRESSED_STATE_SET
 * @see #ENABLED_STATE_SET
 * @see #SELECTED_STATE_SET
 */

protected static final int[] PRESSED_ENABLED_SELECTED_STATE_SET;
static { PRESSED_ENABLED_SELECTED_STATE_SET = new int[0]; }

/**
 * Indicates the view is pressed, enabled, selected and its window has the
 * focus.
 *
 * @see #PRESSED_STATE_SET
 * @see #ENABLED_STATE_SET
 * @see #SELECTED_STATE_SET
 * @see #WINDOW_FOCUSED_STATE_SET
 */

protected static final int[] PRESSED_ENABLED_SELECTED_WINDOW_FOCUSED_STATE_SET;
static { PRESSED_ENABLED_SELECTED_WINDOW_FOCUSED_STATE_SET = new int[0]; }

/**
 * Indicates the view is pressed and enabled.
 *
 * @see #PRESSED_STATE_SET
 * @see #ENABLED_STATE_SET
 */

protected static final int[] PRESSED_ENABLED_STATE_SET;
static { PRESSED_ENABLED_STATE_SET = new int[0]; }

/**
 * Indicates the view is pressed, enabled and its window has the focus.
 *
 * @see #PRESSED_STATE_SET
 * @see #ENABLED_STATE_SET
 * @see #WINDOW_FOCUSED_STATE_SET
 */

protected static final int[] PRESSED_ENABLED_WINDOW_FOCUSED_STATE_SET;
static { PRESSED_ENABLED_WINDOW_FOCUSED_STATE_SET = new int[0]; }

/**
 * Indicates the view is pressed, focused and selected.
 *
 * @see #PRESSED_STATE_SET
 * @see #SELECTED_STATE_SET
 * @see #FOCUSED_STATE_SET
 */

protected static final int[] PRESSED_FOCUSED_SELECTED_STATE_SET;
static { PRESSED_FOCUSED_SELECTED_STATE_SET = new int[0]; }

/**
 * Indicates the view is pressed, focused, selected and its window has the focus.
 *
 * @see #PRESSED_STATE_SET
 * @see #FOCUSED_STATE_SET
 * @see #SELECTED_STATE_SET
 * @see #WINDOW_FOCUSED_STATE_SET
 */

protected static final int[] PRESSED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
static { PRESSED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET = new int[0]; }

/**
 * Indicates the view is pressed and focused.
 *
 * @see #PRESSED_STATE_SET
 * @see #FOCUSED_STATE_SET
 */

protected static final int[] PRESSED_FOCUSED_STATE_SET;
static { PRESSED_FOCUSED_STATE_SET = new int[0]; }

/**
 * Indicates the view is pressed, focused and its window has the focus.
 *
 * @see #PRESSED_STATE_SET
 * @see #FOCUSED_STATE_SET
 * @see #WINDOW_FOCUSED_STATE_SET
 */

protected static final int[] PRESSED_FOCUSED_WINDOW_FOCUSED_STATE_SET;
static { PRESSED_FOCUSED_WINDOW_FOCUSED_STATE_SET = new int[0]; }

/**
 * Indicates the view is pressed and selected.
 *
 * @see #PRESSED_STATE_SET
 * @see #SELECTED_STATE_SET
 */

protected static final int[] PRESSED_SELECTED_STATE_SET;
static { PRESSED_SELECTED_STATE_SET = new int[0]; }

/**
 * Indicates the view is pressed, selected and its window has the focus.
 *
 * @see #PRESSED_STATE_SET
 * @see #SELECTED_STATE_SET
 * @see #WINDOW_FOCUSED_STATE_SET
 */

protected static final int[] PRESSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
static { PRESSED_SELECTED_WINDOW_FOCUSED_STATE_SET = new int[0]; }

/**
 * Indicates the view is pressed. States are used with
 * {@link android.graphics.drawable.Drawable} to change the drawing of the
 * view depending on its state.
 *
 * @see android.graphics.drawable.Drawable
 * @see #getDrawableState()
 */

protected static final int[] PRESSED_STATE_SET;
static { PRESSED_STATE_SET = new int[0]; }

/**
 * Indicates the view is pressed and its window has the focus.
 *
 * @see #PRESSED_STATE_SET
 * @see #WINDOW_FOCUSED_STATE_SET
 */

protected static final int[] PRESSED_WINDOW_FOCUSED_STATE_SET;
static { PRESSED_WINDOW_FOCUSED_STATE_SET = new int[0]; }

/**
 * A Property wrapper around the <code>rotation</code> functionality handled by the
 * {@link View#setRotation(float)} and {@link View#getRotation()} methods.
 */

public static final android.util.Property<android.view.View, java.lang.Float> ROTATION;
static { ROTATION = null; }

/**
 * A Property wrapper around the <code>rotationX</code> functionality handled by the
 * {@link View#setRotationX(float)} and {@link View#getRotationX()} methods.
 */

public static final android.util.Property<android.view.View, java.lang.Float> ROTATION_X;
static { ROTATION_X = null; }

/**
 * A Property wrapper around the <code>rotationY</code> functionality handled by the
 * {@link View#setRotationY(float)} and {@link View#getRotationY()} methods.
 */

public static final android.util.Property<android.view.View, java.lang.Float> ROTATION_Y;
static { ROTATION_Y = null; }

/**
 * A Property wrapper around the <code>scaleX</code> functionality handled by the
 * {@link View#setScaleX(float)} and {@link View#getScaleX()} methods.
 */

public static final android.util.Property<android.view.View, java.lang.Float> SCALE_X;
static { SCALE_X = null; }

/**
 * A Property wrapper around the <code>scaleY</code> functionality handled by the
 * {@link View#setScaleY(float)} and {@link View#getScaleY()} methods.
 */

public static final android.util.Property<android.view.View, java.lang.Float> SCALE_Y;
static { SCALE_Y = null; }

/**
 * Indicates that the screen has changed state and is now off.
 *
 * @see #onScreenStateChanged(int)
 */

public static final int SCREEN_STATE_OFF = 0; // 0x0

/**
 * Indicates that the screen has changed state and is now on.
 *
 * @see #onScreenStateChanged(int)
 */

public static final int SCREEN_STATE_ON = 1; // 0x1

/**
 * The scrollbar style to display the scrollbars inside the padded area,
 * increasing the padding of the view. The scrollbars will not overlap the
 * content area of the view.
 */

public static final int SCROLLBARS_INSIDE_INSET = 16777216; // 0x1000000

/**
 * The scrollbar style to display the scrollbars inside the content area,
 * without increasing the padding. The scrollbars will be overlaid with
 * translucency on the view's content.
 */

public static final int SCROLLBARS_INSIDE_OVERLAY = 0; // 0x0

/**
 * The scrollbar style to display the scrollbars at the edge of the view,
 * increasing the padding of the view. The scrollbars will only overlap the
 * background, if any.
 */

public static final int SCROLLBARS_OUTSIDE_INSET = 50331648; // 0x3000000

/**
 * The scrollbar style to display the scrollbars at the edge of the view,
 * without increasing the padding. The scrollbars will be overlaid with
 * translucency.
 */

public static final int SCROLLBARS_OUTSIDE_OVERLAY = 33554432; // 0x2000000

/**
 * Position the scroll bar at the default position as determined by the system.
 */

public static final int SCROLLBAR_POSITION_DEFAULT = 0; // 0x0

/**
 * Position the scroll bar along the left edge.
 */

public static final int SCROLLBAR_POSITION_LEFT = 1; // 0x1

/**
 * Position the scroll bar along the right edge.
 */

public static final int SCROLLBAR_POSITION_RIGHT = 2; // 0x2

/**
 * Indicates scrolling along the horizontal axis.
 */

public static final int SCROLL_AXIS_HORIZONTAL = 1; // 0x1

/**
 * Indicates no axis of view scrolling.
 */

public static final int SCROLL_AXIS_NONE = 0; // 0x0

/**
 * Indicates scrolling along the vertical axis.
 */

public static final int SCROLL_AXIS_VERTICAL = 2; // 0x2

/**
 * Scroll indicator direction for the bottom edge of the view.
 *
 * @see #setScrollIndicators(int)
 * @see #setScrollIndicators(int, int)
 * @see #getScrollIndicators()
 */

public static final int SCROLL_INDICATOR_BOTTOM = 2; // 0x2

/**
 * Scroll indicator direction for the ending edge of the view.
 * <p>
 * Resolved according to the view's layout direction, see
 * {@link #getLayoutDirection()} for more information.
 *
 * @see #setScrollIndicators(int)
 * @see #setScrollIndicators(int, int)
 * @see #getScrollIndicators()
 */

public static final int SCROLL_INDICATOR_END = 32; // 0x20

/**
 * Scroll indicator direction for the left edge of the view.
 *
 * @see #setScrollIndicators(int)
 * @see #setScrollIndicators(int, int)
 * @see #getScrollIndicators()
 */

public static final int SCROLL_INDICATOR_LEFT = 4; // 0x4

/**
 * Scroll indicator direction for the right edge of the view.
 *
 * @see #setScrollIndicators(int)
 * @see #setScrollIndicators(int, int)
 * @see #getScrollIndicators()
 */

public static final int SCROLL_INDICATOR_RIGHT = 8; // 0x8

/**
 * Scroll indicator direction for the starting edge of the view.
 * <p>
 * Resolved according to the view's layout direction, see
 * {@link #getLayoutDirection()} for more information.
 *
 * @see #setScrollIndicators(int)
 * @see #setScrollIndicators(int, int)
 * @see #getScrollIndicators()
 */

public static final int SCROLL_INDICATOR_START = 16; // 0x10

/**
 * Scroll indicator direction for the top edge of the view.
 *
 * @see #setScrollIndicators(int)
 * @see #setScrollIndicators(int, int)
 * @see #getScrollIndicators()
 */

public static final int SCROLL_INDICATOR_TOP = 1; // 0x1

/**
 * Indicates the view is selected. States are used with
 * {@link android.graphics.drawable.Drawable} to change the drawing of the
 * view depending on its state.
 *
 * @see android.graphics.drawable.Drawable
 * @see #getDrawableState()
 */

protected static final int[] SELECTED_STATE_SET;
static { SELECTED_STATE_SET = new int[0]; }

/**
 * Indicates the view is selected and that its window has the focus.
 *
 * @see #SELECTED_STATE_SET
 * @see #WINDOW_FOCUSED_STATE_SET
 */

protected static final int[] SELECTED_WINDOW_FOCUSED_STATE_SET;
static { SELECTED_WINDOW_FOCUSED_STATE_SET = new int[0]; }

/**
 * View flag indicating whether this view should have sound effects enabled
 * for events such as clicking and touching.
 */

public static final int SOUND_EFFECTS_ENABLED = 134217728; // 0x8000000

/**
 * @deprecated Use {@link #SYSTEM_UI_FLAG_LOW_PROFILE} instead.
 */

@Deprecated public static final int STATUS_BAR_HIDDEN = 1; // 0x1

/**
 * @deprecated Use {@link #SYSTEM_UI_FLAG_VISIBLE} instead.
 */

@Deprecated public static final int STATUS_BAR_VISIBLE = 0; // 0x0

/**
 * Flag for {@link #setSystemUiVisibility(int)}: View has requested to go
 * into the normal fullscreen mode so that its content can take over the screen
 * while still allowing the user to interact with the application.
 *
 * <p>This has the same visual effect as
 * {@link android.view.WindowManager.LayoutParams#FLAG_FULLSCREEN
 * WindowManager.LayoutParams.FLAG_FULLSCREEN},
 * meaning that non-critical screen decorations (such as the status bar) will be
 * hidden while the user is in the View's window, focusing the experience on
 * that content.  Unlike the window flag, if you are using ActionBar in
 * overlay mode with {@link Window#FEATURE_ACTION_BAR_OVERLAY
 * Window.FEATURE_ACTION_BAR_OVERLAY}, then enabling this flag will also
 * hide the action bar.
 *
 * <p>This approach to going fullscreen is best used over the window flag when
 * it is a transient state -- that is, the application does this at certain
 * points in its user interaction where it wants to allow the user to focus
 * on content, but not as a continuous state.  For situations where the application
 * would like to simply stay full screen the entire time (such as a game that
 * wants to take over the screen), the
 * {@link android.view.WindowManager.LayoutParams#FLAG_FULLSCREEN window flag}
 * is usually a better approach.  The state set here will be removed by the system
 * in various situations (such as the user moving to another application) like
 * the other system UI states.
 *
 * <p>When using this flag, the application should provide some easy facility
 * for the user to go out of it.  A common example would be in an e-book
 * reader, where tapping on the screen brings back whatever screen and UI
 * decorations that had been hidden while the user was immersed in reading
 * the book.
 *
 * @see #setSystemUiVisibility(int)
 */

public static final int SYSTEM_UI_FLAG_FULLSCREEN = 4; // 0x4

/**
 * Flag for {@link #setSystemUiVisibility(int)}: View has requested that the
 * system navigation be temporarily hidden.
 *
 * <p>This is an even less obtrusive state than that called for by
 * {@link #SYSTEM_UI_FLAG_LOW_PROFILE}; on devices that draw essential navigation controls
 * (Home, Back, and the like) on screen, <code>SYSTEM_UI_FLAG_HIDE_NAVIGATION</code> will cause
 * those to disappear. This is useful (in conjunction with the
 * {@link android.view.WindowManager.LayoutParams#FLAG_FULLSCREEN FLAG_FULLSCREEN} and
 * {@link android.view.WindowManager.LayoutParams#FLAG_LAYOUT_IN_SCREEN FLAG_LAYOUT_IN_SCREEN}
 * window flags) for displaying content using every last pixel on the display.
 *
 * <p>There is a limitation: because navigation controls are so important, the least user
 * interaction will cause them to reappear immediately.  When this happens, both
 * this flag and {@link #SYSTEM_UI_FLAG_FULLSCREEN} will be cleared automatically,
 * so that both elements reappear at the same time.
 *
 * @see #setSystemUiVisibility(int)
 */

public static final int SYSTEM_UI_FLAG_HIDE_NAVIGATION = 2; // 0x2

/**
 * Flag for {@link #setSystemUiVisibility(int)}: View would like to remain interactive when
 * hiding the navigation bar with {@link #SYSTEM_UI_FLAG_HIDE_NAVIGATION}.  If this flag is
 * not set, {@link #SYSTEM_UI_FLAG_HIDE_NAVIGATION} will be force cleared by the system on any
 * user interaction.
 * <p>Since this flag is a modifier for {@link #SYSTEM_UI_FLAG_HIDE_NAVIGATION}, it only
 * has an effect when used in combination with that flag.</p>
 */

public static final int SYSTEM_UI_FLAG_IMMERSIVE = 2048; // 0x800

/**
 * Flag for {@link #setSystemUiVisibility(int)}: View would like to remain interactive when
 * hiding the status bar with {@link #SYSTEM_UI_FLAG_FULLSCREEN} and/or hiding the navigation
 * bar with {@link #SYSTEM_UI_FLAG_HIDE_NAVIGATION}.  Use this flag to create an immersive
 * experience while also hiding the system bars.  If this flag is not set,
 * {@link #SYSTEM_UI_FLAG_HIDE_NAVIGATION} will be force cleared by the system on any user
 * interaction, and {@link #SYSTEM_UI_FLAG_FULLSCREEN} will be force-cleared by the system
 * if the user swipes from the top of the screen.
 * <p>When system bars are hidden in immersive mode, they can be revealed temporarily with
 * system gestures, such as swiping from the top of the screen.  These transient system bars
 * will overlay app’s content, may have some degree of transparency, and will automatically
 * hide after a short timeout.
 * </p><p>Since this flag is a modifier for {@link #SYSTEM_UI_FLAG_FULLSCREEN} and
 * {@link #SYSTEM_UI_FLAG_HIDE_NAVIGATION}, it only has an effect when used in combination
 * with one or both of those flags.</p>
 */

public static final int SYSTEM_UI_FLAG_IMMERSIVE_STICKY = 4096; // 0x1000

/**
 * Flag for {@link #setSystemUiVisibility(int)}: View would like its window
 * to be laid out as if it has requested
 * {@link #SYSTEM_UI_FLAG_FULLSCREEN}, even if it currently hasn't.  This
 * allows it to avoid artifacts when switching in and out of that mode, at
 * the expense that some of its user interface may be covered by screen
 * decorations when they are shown.  You can perform layout of your inner
 * UI elements to account for non-fullscreen system UI through the
 * {@link #fitSystemWindows(Rect)} method.
 *
 * <p>Note: on displays that have a {@link DisplayCutout}, the window may still be placed
 *  differently than if {@link #SYSTEM_UI_FLAG_FULLSCREEN} was set, if the
 *  window's {@link WindowManager.LayoutParams#layoutInDisplayCutoutMode
 *  layoutInDisplayCutoutMode} is
 *  {@link WindowManager.LayoutParams#LAYOUT_IN_DISPLAY_CUTOUT_MODE_DEFAULT
 *  LAYOUT_IN_DISPLAY_CUTOUT_MODE_DEFAULT}. To avoid this, use either of the other modes.
 *
 * @see WindowManager.LayoutParams#layoutInDisplayCutoutMode
 * @see WindowManager.LayoutParams#LAYOUT_IN_DISPLAY_CUTOUT_MODE_DEFAULT
 * @see WindowManager.LayoutParams#LAYOUT_IN_DISPLAY_CUTOUT_MODE_ALWAYS
 * @see WindowManager.LayoutParams#LAYOUT_IN_DISPLAY_CUTOUT_MODE_NEVER
 */

public static final int SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN = 1024; // 0x400

/**
 * Flag for {@link #setSystemUiVisibility(int)}: View would like its window
 * to be laid out as if it has requested
 * {@link #SYSTEM_UI_FLAG_HIDE_NAVIGATION}, even if it currently hasn't.  This
 * allows it to avoid artifacts when switching in and out of that mode, at
 * the expense that some of its user interface may be covered by screen
 * decorations when they are shown.  You can perform layout of your inner
 * UI elements to account for the navigation system UI through the
 * {@link #fitSystemWindows(Rect)} method.
 */

public static final int SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION = 512; // 0x200

/**
 * Flag for {@link #setSystemUiVisibility(int)}: When using other layout
 * flags, we would like a stable view of the content insets given to
 * {@link #fitSystemWindows(Rect)}.  This means that the insets seen there
 * will always represent the worst case that the application can expect
 * as a continuous state.  In the stock Android UI this is the space for
 * the system bar, nav bar, and status bar, but not more transient elements
 * such as an input method.
 *
 * The stable layout your UI sees is based on the system UI modes you can
 * switch to.  That is, if you specify {@link #SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN}
 * then you will get a stable layout for changes of the
 * {@link #SYSTEM_UI_FLAG_FULLSCREEN} mode; if you specify
 * {@link #SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN} and
 * {@link #SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION}, then you can transition
 * to {@link #SYSTEM_UI_FLAG_FULLSCREEN} and {@link #SYSTEM_UI_FLAG_HIDE_NAVIGATION}
 * with a stable layout.  (Note that you should avoid using
 * {@link #SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION} by itself.)
 *
 * If you have set the window flag {@link WindowManager.LayoutParams#FLAG_FULLSCREEN}
 * to hide the status bar (instead of using {@link #SYSTEM_UI_FLAG_FULLSCREEN}),
 * then a hidden status bar will be considered a "stable" state for purposes
 * here.  This allows your UI to continually hide the status bar, while still
 * using the system UI flags to hide the action bar while still retaining
 * a stable layout.  Note that changing the window fullscreen flag will never
 * provide a stable layout for a clean transition.
 *
 * <p>If you are using ActionBar in
 * overlay mode with {@link Window#FEATURE_ACTION_BAR_OVERLAY
 * Window.FEATURE_ACTION_BAR_OVERLAY}, this flag will also impact the
 * insets it adds to those given to the application.
 */

public static final int SYSTEM_UI_FLAG_LAYOUT_STABLE = 256; // 0x100

/**
 * Flag for {@link #setSystemUiVisibility(int)}: Requests the navigation bar to draw in a mode
 * that is compatible with light navigation bar backgrounds.
 *
 * <p>For this to take effect, the window must request
 * {@link android.view.WindowManager.LayoutParams#FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS
 *         FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS} but not
 * {@link android.view.WindowManager.LayoutParams#FLAG_TRANSLUCENT_NAVIGATION
 *         FLAG_TRANSLUCENT_NAVIGATION}.
 *
 * @see android.R.attr#windowLightNavigationBar
 */

public static final int SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR = 16; // 0x10

/**
 * Flag for {@link #setSystemUiVisibility(int)}: Requests the status bar to draw in a mode that
 * is compatible with light status bar backgrounds.
 *
 * <p>For this to take effect, the window must request
 * {@link android.view.WindowManager.LayoutParams#FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS
 *         FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS} but not
 * {@link android.view.WindowManager.LayoutParams#FLAG_TRANSLUCENT_STATUS
 *         FLAG_TRANSLUCENT_STATUS}.
 *
 * @see android.R.attr#windowLightStatusBar
 */

public static final int SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = 8192; // 0x2000

/**
 * Flag for {@link #setSystemUiVisibility(int)}: View has requested the
 * system UI to enter an unobtrusive "low profile" mode.
 *
 * <p>This is for use in games, book readers, video players, or any other
 * "immersive" application where the usual system chrome is deemed too distracting.
 *
 * <p>In low profile mode, the status bar and/or navigation icons may dim.
 *
 * @see #setSystemUiVisibility(int)
 */

public static final int SYSTEM_UI_FLAG_LOW_PROFILE = 1; // 0x1

/**
 * Special constant for {@link #setSystemUiVisibility(int)}: View has
 * requested the system UI (status bar) to be visible (the default).
 *
 * @see #setSystemUiVisibility(int)
 */

public static final int SYSTEM_UI_FLAG_VISIBLE = 0; // 0x0

/**
 * Flags that can impact the layout in relation to system UI.
 */

public static final int SYSTEM_UI_LAYOUT_FLAGS = 1536; // 0x600

/**
 * Center the paragraph, e.g.&nbsp;ALIGN_CENTER.
 *
 * Use with {@link #setTextAlignment(int)}
 */

public static final int TEXT_ALIGNMENT_CENTER = 4; // 0x4

/**
 * Default for the root view. The gravity determines the text alignment, ALIGN_NORMAL,
 * ALIGN_CENTER, or ALIGN_OPPOSITE, which are relative to each paragraph’s text direction.
 *
 * Use with {@link #setTextAlignment(int)}
 */

public static final int TEXT_ALIGNMENT_GRAVITY = 1; // 0x1

/**
 * Default text alignment. The text alignment of this View is inherited from its parent.
 * Use with {@link #setTextAlignment(int)}
 */

public static final int TEXT_ALIGNMENT_INHERIT = 0; // 0x0

/**
 * Align to the end of the paragraph, e.g.&nbsp;ALIGN_OPPOSITE.
 *
 * Use with {@link #setTextAlignment(int)}
 */

public static final int TEXT_ALIGNMENT_TEXT_END = 3; // 0x3

/**
 * Align to the start of the paragraph, e.g.&nbsp;ALIGN_NORMAL.
 *
 * Use with {@link #setTextAlignment(int)}
 */

public static final int TEXT_ALIGNMENT_TEXT_START = 2; // 0x2

/**
 * Align to the end of the view, which is ALIGN_RIGHT if the view’s resolved
 * layoutDirection is LTR, and ALIGN_LEFT otherwise.
 *
 * Use with {@link #setTextAlignment(int)}
 */

public static final int TEXT_ALIGNMENT_VIEW_END = 6; // 0x6

/**
 * Align to the start of the view, which is ALIGN_LEFT if the view’s resolved
 * layoutDirection is LTR, and ALIGN_RIGHT otherwise.
 *
 * Use with {@link #setTextAlignment(int)}
 */

public static final int TEXT_ALIGNMENT_VIEW_START = 5; // 0x5

/**
 * Text direction is using "any-RTL" algorithm. The paragraph direction is RTL if it contains
 * any strong RTL character, otherwise it is LTR if it contains any strong LTR characters.
 * If there are neither, the paragraph direction is the view's resolved layout direction.
 */

public static final int TEXT_DIRECTION_ANY_RTL = 2; // 0x2

/**
 * Text direction is using "first strong algorithm". The first strong directional character
 * determines the paragraph direction. If there is no strong directional character, the
 * paragraph direction is the view's resolved layout direction.
 */

public static final int TEXT_DIRECTION_FIRST_STRONG = 1; // 0x1

/**
 * Text direction is using "first strong algorithm". The first strong directional character
 * determines the paragraph direction. If there is no strong directional character, the
 * paragraph direction is LTR.
 */

public static final int TEXT_DIRECTION_FIRST_STRONG_LTR = 6; // 0x6

/**
 * Text direction is using "first strong algorithm". The first strong directional character
 * determines the paragraph direction. If there is no strong directional character, the
 * paragraph direction is RTL.
 */

public static final int TEXT_DIRECTION_FIRST_STRONG_RTL = 7; // 0x7

/**
 * Text direction is inherited through {@link ViewGroup}
 */

public static final int TEXT_DIRECTION_INHERIT = 0; // 0x0

/**
 * Text direction is coming from the system Locale.
 */

public static final int TEXT_DIRECTION_LOCALE = 5; // 0x5

/**
 * Text direction is forced to LTR.
 */

public static final int TEXT_DIRECTION_LTR = 3; // 0x3

/**
 * Text direction is forced to RTL.
 */

public static final int TEXT_DIRECTION_RTL = 4; // 0x4

/**
 * A Property wrapper around the <code>translationX</code> functionality handled by the
 * {@link View#setTranslationX(float)} and {@link View#getTranslationX()} methods.
 */

public static final android.util.Property<android.view.View, java.lang.Float> TRANSLATION_X;
static { TRANSLATION_X = null; }

/**
 * A Property wrapper around the <code>translationY</code> functionality handled by the
 * {@link View#setTranslationY(float)} and {@link View#getTranslationY()} methods.
 */

public static final android.util.Property<android.view.View, java.lang.Float> TRANSLATION_Y;
static { TRANSLATION_Y = null; }

/**
 * A Property wrapper around the <code>translationZ</code> functionality handled by the
 * {@link View#setTranslationZ(float)} and {@link View#getTranslationZ()} methods.
 */

public static final android.util.Property<android.view.View, java.lang.Float> TRANSLATION_Z;
static { TRANSLATION_Z = null; }

/**
 * The logging tag used by this class with android.util.Log.
 */

protected static final java.lang.String VIEW_LOG_TAG = "View";

/**
 * This view is visible.
 * Use with {@link #setVisibility} and <a href="#attr_android:visibility">{@code
 * android:visibility}.
 */

public static final int VISIBLE = 0; // 0x0

/**
 * Indicates the view's window has focus. States are used with
 * {@link android.graphics.drawable.Drawable} to change the drawing of the
 * view depending on its state.
 *
 * @see android.graphics.drawable.Drawable
 * @see #getDrawableState()
 */

protected static final int[] WINDOW_FOCUSED_STATE_SET;
static { WINDOW_FOCUSED_STATE_SET = new int[0]; }

/**
 * A Property wrapper around the <code>x</code> functionality handled by the
 * {@link View#setX(float)} and {@link View#getX()} methods.
 */

public static final android.util.Property<android.view.View, java.lang.Float> X;
static { X = null; }

/**
 * A Property wrapper around the <code>y</code> functionality handled by the
 * {@link View#setY(float)} and {@link View#getY()} methods.
 */

public static final android.util.Property<android.view.View, java.lang.Float> Y;
static { Y = null; }

/**
 * A Property wrapper around the <code>z</code> functionality handled by the
 * {@link View#setZ(float)} and {@link View#getZ()} methods.
 */

public static final android.util.Property<android.view.View, java.lang.Float> Z;
static { Z = null; }
/**
 * <p>
 * This class represents a delegate that can be registered in a {@link View}
 * to enhance accessibility support via composition rather via inheritance.
 * It is specifically targeted to widget developers that extend basic View
 * classes i.e. classes in package android.view, that would like their
 * applications to be backwards compatible.
 * </p>
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about making applications accessible, read the
 * <a href="{@docRoot}guide/topics/ui/accessibility/index.html">Accessibility</a>
 * developer guide.</p>
 * </div>
 * <p>
 * A scenario in which a developer would like to use an accessibility delegate
 * is overriding a method introduced in a later API version than the minimal API
 * version supported by the application. For example, the method
 * {@link View#onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo)} is not available
 * in API version 4 when the accessibility APIs were first introduced. If a
 * developer would like their application to run on API version 4 devices (assuming
 * all other APIs used by the application are version 4 or lower) and take advantage
 * of this method, instead of overriding the method which would break the application's
 * backwards compatibility, they can override the corresponding method in this
 * delegate and register the delegate in the target View if the API version of
 * the system is high enough, i.e. the API version is the same as or higher than the API
 * version that introduced
 * {@link View#onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo)}.
 * </p>
 * <p>
 * Here is an example implementation:
 * </p>
 * <code><pre><p>
 * if (Build.VERSION.SDK_INT >= 14) {
 *     // If the API version is equal of higher than the version in
 *     // which onInitializeAccessibilityNodeInfo was introduced we
 *     // register a delegate with a customized implementation.
 *     View view = findViewById(R.id.view_id);
 *     view.setAccessibilityDelegate(new AccessibilityDelegate() {
 *         public void onInitializeAccessibilityNodeInfo(View host,
 *                 AccessibilityNodeInfo info) {
 *             // Let the default implementation populate the info.
 *             super.onInitializeAccessibilityNodeInfo(host, info);
 *             // Set some other information.
 *             info.setEnabled(host.isEnabled());
 *         }
 *     });
 * }
 * </code></pre></p>
 * <p>
 * This delegate contains methods that correspond to the accessibility methods
 * in View. If a delegate has been specified the implementation in View hands
 * off handling to the corresponding method in this delegate. The default
 * implementation the delegate methods behaves exactly as the corresponding
 * method in View for the case of no accessibility delegate been set. Hence,
 * to customize the behavior of a View method, clients can override only the
 * corresponding delegate method without altering the behavior of the rest
 * accessibility related methods of the host view.
 * </p>
 * <p>
 * <strong>Note:</strong> On platform versions prior to
 * {@link android.os.Build.VERSION_CODES#M API 23}, delegate methods on
 * views in the {@code android.widget.*} package are called <i>before</i>
 * host methods. This prevents certain properties such as class name from
 * being modified by overriding
 * {@link AccessibilityDelegate#onInitializeAccessibilityNodeInfo(View, AccessibilityNodeInfo)},
 * as any changes will be overwritten by the host class.
 * <p>
 * Starting in {@link android.os.Build.VERSION_CODES#M API 23}, delegate
 * methods are called <i>after</i> host methods, which all properties to be
 * modified without being overwritten by the host class.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class AccessibilityDelegate {

public AccessibilityDelegate() { throw new RuntimeException("Stub!"); }

/**
 * Sends an accessibility event of the given type. If accessibility is not
 * enabled this method has no effect.
 * <p>
 * The default implementation behaves as {@link View#sendAccessibilityEvent(int)
 *  View#sendAccessibilityEvent(int)} for the case of no accessibility delegate
 * been set.
 * </p>
 *
 * @param host The View hosting the delegate.
 * @param eventType The type of the event to send.
 *
 * @see View#sendAccessibilityEvent(int) View#sendAccessibilityEvent(int)
 */

public void sendAccessibilityEvent(android.view.View host, int eventType) { throw new RuntimeException("Stub!"); }

/**
 * Performs the specified accessibility action on the view. For
 * possible accessibility actions look at {@link AccessibilityNodeInfo}.
 * <p>
 * The default implementation behaves as
 * {@link View#performAccessibilityAction(int, Bundle)
 *  View#performAccessibilityAction(int, Bundle)} for the case of
 *  no accessibility delegate been set.
 * </p>
 *
 * @param action The action to perform.
 * @return Whether the action was performed.
 *
 * @see View#performAccessibilityAction(int, Bundle)
 *      View#performAccessibilityAction(int, Bundle)
 */

public boolean performAccessibilityAction(android.view.View host, int action, android.os.Bundle args) { throw new RuntimeException("Stub!"); }

/**
 * Sends an accessibility event. This method behaves exactly as
 * {@link #sendAccessibilityEvent(View, int)} but takes as an argument an
 * empty {@link AccessibilityEvent} and does not perform a check whether
 * accessibility is enabled.
 * <p>
 * The default implementation behaves as
 * {@link View#sendAccessibilityEventUnchecked(AccessibilityEvent)
 *  View#sendAccessibilityEventUnchecked(AccessibilityEvent)} for
 * the case of no accessibility delegate been set.
 * </p>
 *
 * @param host The View hosting the delegate.
 * @param event The event to send.
 *
 * @see View#sendAccessibilityEventUnchecked(AccessibilityEvent)
 *      View#sendAccessibilityEventUnchecked(AccessibilityEvent)
 */

public void sendAccessibilityEventUnchecked(android.view.View host, android.view.accessibility.AccessibilityEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Dispatches an {@link AccessibilityEvent} to the host {@link View} first and then
 * to its children for adding their text content to the event.
 * <p>
 * The default implementation behaves as
 * {@link View#dispatchPopulateAccessibilityEvent(AccessibilityEvent)
 *  View#dispatchPopulateAccessibilityEvent(AccessibilityEvent)} for
 * the case of no accessibility delegate been set.
 * </p>
 *
 * @param host The View hosting the delegate.
 * @param event The event.
 * @return True if the event population was completed.
 *
 * @see View#dispatchPopulateAccessibilityEvent(AccessibilityEvent)
 *      View#dispatchPopulateAccessibilityEvent(AccessibilityEvent)
 */

public boolean dispatchPopulateAccessibilityEvent(android.view.View host, android.view.accessibility.AccessibilityEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Gives a chance to the host View to populate the accessibility event with its
 * text content.
 * <p>
 * The default implementation behaves as
 * {@link View#onPopulateAccessibilityEvent(AccessibilityEvent)
 *  View#onPopulateAccessibilityEvent(AccessibilityEvent)} for
 * the case of no accessibility delegate been set.
 * </p>
 *
 * @param host The View hosting the delegate.
 * @param event The accessibility event which to populate.
 *
 * @see View#onPopulateAccessibilityEvent(AccessibilityEvent)
 *      View#onPopulateAccessibilityEvent(AccessibilityEvent)
 */

public void onPopulateAccessibilityEvent(android.view.View host, android.view.accessibility.AccessibilityEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Initializes an {@link AccessibilityEvent} with information about the
 * the host View which is the event source.
 * <p>
 * The default implementation behaves as
 * {@link View#onInitializeAccessibilityEvent(AccessibilityEvent)
 *  View#onInitializeAccessibilityEvent(AccessibilityEvent)} for
 * the case of no accessibility delegate been set.
 * </p>
 *
 * @param host The View hosting the delegate.
 * @param event The event to initialize.
 *
 * @see View#onInitializeAccessibilityEvent(AccessibilityEvent)
 *      View#onInitializeAccessibilityEvent(AccessibilityEvent)
 */

public void onInitializeAccessibilityEvent(android.view.View host, android.view.accessibility.AccessibilityEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Initializes an {@link AccessibilityNodeInfo} with information about the host view.
 * <p>
 * The default implementation behaves as
 * {@link View#onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo)
 *  View#onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo)} for
 * the case of no accessibility delegate been set.
 * </p>
 *
 * @param host The View hosting the delegate.
 * @param info The instance to initialize.
 *
 * @see View#onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo)
 *      View#onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo)
 */

public void onInitializeAccessibilityNodeInfo(android.view.View host, android.view.accessibility.AccessibilityNodeInfo info) { throw new RuntimeException("Stub!"); }

/**
 * Adds extra data to an {@link AccessibilityNodeInfo} based on an explicit request for the
 * additional data.
 * <p>
 * This method only needs to be implemented if the View offers to provide additional data.
 * </p>
 * <p>
 * The default implementation behaves as
 * {@link View#addExtraDataToAccessibilityNodeInfo(AccessibilityNodeInfo, String, Bundle)
 * for the case where no accessibility delegate is set.
 * </p>
 *
 * @param host The View hosting the delegate. Never {@code null}.
 * @param info The info to which to add the extra data. Never {@code null}.
 * @param extraDataKey A key specifying the type of extra data to add to the info. The
 *                     extra data should be added to the {@link Bundle} returned by
 *                     the info's {@link AccessibilityNodeInfo#getExtras} method.  Never
 *                     {@code null}.
 * @param arguments A {@link Bundle} holding any arguments relevant for this request.
 *                  May be {@code null} if the if the service provided no arguments.
 *
 * @see AccessibilityNodeInfo#setExtraAvailableData
 
 * @param host This value must never be {@code null}.

 * @param info This value must never be {@code null}.
 
 * @param extraDataKey This value must never be {@code null}.

 * @param arguments This value may be {@code null}.
 */

public void addExtraDataToAccessibilityNodeInfo(@androidx.annotation.RecentlyNonNull android.view.View host, @androidx.annotation.RecentlyNonNull android.view.accessibility.AccessibilityNodeInfo info, @androidx.annotation.RecentlyNonNull java.lang.String extraDataKey, @androidx.annotation.RecentlyNullable android.os.Bundle arguments) { throw new RuntimeException("Stub!"); }

/**
 * Called when a child of the host View has requested sending an
 * {@link AccessibilityEvent} and gives an opportunity to the parent (the host)
 * to augment the event.
 * <p>
 * The default implementation behaves as
 * {@link ViewGroup#onRequestSendAccessibilityEvent(View, AccessibilityEvent)
 *  ViewGroup#onRequestSendAccessibilityEvent(View, AccessibilityEvent)} for
 * the case of no accessibility delegate been set.
 * </p>
 *
 * @param host The View hosting the delegate.
 * @param child The child which requests sending the event.
 * @param event The event to be sent.
 * @return True if the event should be sent
 *
 * @see ViewGroup#onRequestSendAccessibilityEvent(View, AccessibilityEvent)
 *      ViewGroup#onRequestSendAccessibilityEvent(View, AccessibilityEvent)
 */

public boolean onRequestSendAccessibilityEvent(android.view.ViewGroup host, android.view.View child, android.view.accessibility.AccessibilityEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Gets the provider for managing a virtual view hierarchy rooted at this View
 * and reported to {@link android.accessibilityservice.AccessibilityService}s
 * that explore the window content.
 * <p>
 * The default implementation behaves as
 * {@link View#getAccessibilityNodeProvider() View#getAccessibilityNodeProvider()} for
 * the case of no accessibility delegate been set.
 * </p>
 *
 * @return The provider.
 *
 * @see AccessibilityNodeProvider
 */

public android.view.accessibility.AccessibilityNodeProvider getAccessibilityNodeProvider(android.view.View host) { throw new RuntimeException("Stub!"); }
}

/**
 * Base class for derived classes that want to save and restore their own
 * state in {@link android.view.View#onSaveInstanceState()}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class BaseSavedState extends android.view.AbsSavedState {

/**
 * Constructor used when reading from a parcel. Reads the state of the superclass.
 *
 * @param source parcel to read from
 */

public BaseSavedState(android.os.Parcel source) { super((android.os.Parcelable)null); throw new RuntimeException("Stub!"); }

/**
 * Constructor used when reading from a parcel using a given class loader.
 * Reads the state of the superclass.
 *
 * @param source parcel to read from
 * @param loader ClassLoader to use for reading
 */

public BaseSavedState(android.os.Parcel source, java.lang.ClassLoader loader) { super((android.os.Parcelable)null); throw new RuntimeException("Stub!"); }

/**
 * Constructor called by derived classes when creating their SavedState objects
 *
 * @param superState The state of the superclass of this view
 */

public BaseSavedState(android.os.Parcelable superState) { super((android.os.Parcelable)null); throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.view.View.BaseSavedState> CREATOR;
static { CREATOR = null; }
}

/**
 * Creates an image that the system displays during the drag and drop
 * operation. This is called a &quot;drag shadow&quot;. The default implementation
 * for a DragShadowBuilder based on a View returns an image that has exactly the same
 * appearance as the given View. The default also positions the center of the drag shadow
 * directly under the touch point. If no View is provided (the constructor with no parameters
 * is used), and {@link #onProvideShadowMetrics(Point,Point) onProvideShadowMetrics()} and
 * {@link #onDrawShadow(Canvas) onDrawShadow()} are not overridden, then the
 * default is an invisible drag shadow.
 * <p>
 * You are not required to use the View you provide to the constructor as the basis of the
 * drag shadow. The {@link #onDrawShadow(Canvas) onDrawShadow()} method allows you to draw
 * anything you want as the drag shadow.
 * </p>
 * <p>
 *  You pass a DragShadowBuilder object to the system when you start the drag. The system
 *  calls {@link #onProvideShadowMetrics(Point,Point) onProvideShadowMetrics()} to get the
 *  size and position of the drag shadow. It uses this data to construct a
 *  {@link android.graphics.Canvas} object, then it calls {@link #onDrawShadow(Canvas) onDrawShadow()}
 *  so that your application can draw the shadow image in the Canvas.
 * </p>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For a guide to implementing drag and drop features, read the
 * <a href="{@docRoot}guide/topics/ui/drag-drop.html">Drag and Drop</a> developer guide.</p>
 * </div>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class DragShadowBuilder {

/**
 * Constructs a shadow image builder based on a View. By default, the resulting drag
 * shadow will have the same appearance and dimensions as the View, with the touch point
 * over the center of the View.
 * @param view A View. Any View in scope can be used.
 */

public DragShadowBuilder(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Construct a shadow builder object with no associated View.  This
 * constructor variant is only useful when the {@link #onProvideShadowMetrics(Point, Point)}
 * and {@link #onDrawShadow(Canvas)} methods are also overridden in order
 * to supply the drag shadow's dimensions and appearance without
 * reference to any View object.
 */

public DragShadowBuilder() { throw new RuntimeException("Stub!"); }

/**
 * Returns the View object that had been passed to the
 * {@link #View.DragShadowBuilder(View)}
 * constructor.  If that View parameter was {@code null} or if the
 * {@link #View.DragShadowBuilder()}
 * constructor was used to instantiate the builder object, this method will return
 * null.
 *
 * @return The View object associate with this builder object.
 */

public final android.view.View getView() { throw new RuntimeException("Stub!"); }

/**
 * Provides the metrics for the shadow image. These include the dimensions of
 * the shadow image, and the point within that shadow that should
 * be centered under the touch location while dragging.
 * <p>
 * The default implementation sets the dimensions of the shadow to be the
 * same as the dimensions of the View itself and centers the shadow under
 * the touch point.
 * </p>
 *
 * @param outShadowSize A {@link android.graphics.Point} containing the width and height
 * of the shadow image. Your application must set {@link android.graphics.Point#x} to the
 * desired width and must set {@link android.graphics.Point#y} to the desired height of the
 * image.
 *
 * @param outShadowTouchPoint A {@link android.graphics.Point} for the position within the
 * shadow image that should be underneath the touch point during the drag and drop
 * operation. Your application must set {@link android.graphics.Point#x} to the
 * X coordinate and {@link android.graphics.Point#y} to the Y coordinate of this position.
 */

public void onProvideShadowMetrics(android.graphics.Point outShadowSize, android.graphics.Point outShadowTouchPoint) { throw new RuntimeException("Stub!"); }

/**
 * Draws the shadow image. The system creates the {@link android.graphics.Canvas} object
 * based on the dimensions it received from the
 * {@link #onProvideShadowMetrics(Point, Point)} callback.
 *
 * @param canvas A {@link android.graphics.Canvas} object in which to draw the shadow image.
 */

public void onDrawShadow(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }
}

/**
 * A MeasureSpec encapsulates the layout requirements passed from parent to child.
 * Each MeasureSpec represents a requirement for either the width or the height.
 * A MeasureSpec is comprised of a size and a mode. There are three possible
 * modes:
 * <dl>
 * <dt>UNSPECIFIED</dt>
 * <dd>
 * The parent has not imposed any constraint on the child. It can be whatever size
 * it wants.
 * </dd>
 *
 * <dt>EXACTLY</dt>
 * <dd>
 * The parent has determined an exact size for the child. The child is going to be
 * given those bounds regardless of how big it wants to be.
 * </dd>
 *
 * <dt>AT_MOST</dt>
 * <dd>
 * The child can be as large as it wants up to the specified size.
 * </dd>
 * </dl>
 *
 * MeasureSpecs are implemented as ints to reduce object allocation. This class
 * is provided to pack and unpack the &lt;size, mode&gt; tuple into the int.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class MeasureSpec {

public MeasureSpec() { throw new RuntimeException("Stub!"); }

/**
 * Creates a measure specification based on the supplied size and mode.
 *
 * The mode must always be one of the following:
 * <ul>
 *  <li>{@link android.view.View.MeasureSpec#UNSPECIFIED}</li>
 *  <li>{@link android.view.View.MeasureSpec#EXACTLY}</li>
 *  <li>{@link android.view.View.MeasureSpec#AT_MOST}</li>
 * </ul>
 *
 * <p><strong>Note:</strong> On API level 17 and lower, makeMeasureSpec's
 * implementation was such that the order of arguments did not matter
 * and overflow in either value could impact the resulting MeasureSpec.
 * {@link android.widget.RelativeLayout} was affected by this bug.
 * Apps targeting API levels greater than 17 will get the fixed, more strict
 * behavior.</p>
 *
 * @param size the size of the measure specification
 * Value is between 0 and (1 << MeasureSpec.MODE_SHIFT) - 1 inclusive
 * @param mode the mode of the measure specification
 * Value is {@link android.view.View.MeasureSpec#UNSPECIFIED}, {@link android.view.View.MeasureSpec#EXACTLY}, or {@link android.view.View.MeasureSpec#AT_MOST}
 * @return the measure specification based on size and mode
 */

public static int makeMeasureSpec(int size, int mode) { throw new RuntimeException("Stub!"); }

/**
 * Extracts the mode from the supplied measure specification.
 *
 * @param measureSpec the measure specification to extract the mode from
 * @return {@link android.view.View.MeasureSpec#UNSPECIFIED},
 *         {@link android.view.View.MeasureSpec#AT_MOST} or
 *         {@link android.view.View.MeasureSpec#EXACTLY}

 * Value is {@link android.view.View.MeasureSpec#UNSPECIFIED}, {@link android.view.View.MeasureSpec#EXACTLY}, or {@link android.view.View.MeasureSpec#AT_MOST}
 */

public static int getMode(int measureSpec) { throw new RuntimeException("Stub!"); }

/**
 * Extracts the size from the supplied measure specification.
 *
 * @param measureSpec the measure specification to extract the size from
 * @return the size in pixels defined in the supplied measure specification
 */

public static int getSize(int measureSpec) { throw new RuntimeException("Stub!"); }

/**
 * Returns a String representation of the specified measure
 * specification.
 *
 * @param measureSpec the measure specification to convert to a String
 * @return a String with the following format: "MeasureSpec: MODE SIZE"
 */

public static java.lang.String toString(int measureSpec) { throw new RuntimeException("Stub!"); }

/**
 * Measure specification mode: The child can be as large as it wants up
 * to the specified size.
 */

public static final int AT_MOST = -2147483648; // 0x80000000

/**
 * Measure specification mode: The parent has determined an exact size
 * for the child. The child is going to be given those bounds regardless
 * of how big it wants to be.
 */

public static final int EXACTLY = 1073741824; // 0x40000000

/**
 * Measure specification mode: The parent has not imposed any constraint
 * on the child. It can be whatever size it wants.
 */

public static final int UNSPECIFIED = 0; // 0x0
}

/**
 * Listener for applying window insets on a view in a custom way.
 *
 * <p>Apps may choose to implement this interface if they want to apply custom policy
 * to the way that window insets are treated for a view. If an OnApplyWindowInsetsListener
 * is set, its
 * {@link OnApplyWindowInsetsListener#onApplyWindowInsets(View, WindowInsets) onApplyWindowInsets}
 * method will be called instead of the View's own
 * {@link #onApplyWindowInsets(WindowInsets) onApplyWindowInsets} method. The listener
 * may optionally call the parameter View's <code>onApplyWindowInsets</code> method to apply
 * the View's normal behavior as part of its own.</p>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnApplyWindowInsetsListener {

/**
 * When {@link View#setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener) set}
 * on a View, this listener method will be called instead of the view's own
 * {@link View#onApplyWindowInsets(WindowInsets) onApplyWindowInsets} method.
 *
 * @param v The view applying window insets
 * @param insets The insets to apply
 * @return The insets supplied, minus any insets that were consumed
 */

public android.view.WindowInsets onApplyWindowInsets(android.view.View v, android.view.WindowInsets insets);
}

/**
 * Interface definition for a callback to be invoked when this view is attached
 * or detached from its window.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnAttachStateChangeListener {

/**
 * Called when the view is attached to a window.
 * @param v The view that was attached
 */

public void onViewAttachedToWindow(android.view.View v);

/**
 * Called when the view is detached from a window.
 * @param v The view that was detached
 */

public void onViewDetachedFromWindow(android.view.View v);
}

/**
 * Interface definition for a callback to be invoked when a captured pointer event
 * is being dispatched this view. The callback will be invoked before the event is
 * given to the view.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnCapturedPointerListener {

/**
 * Called when a captured pointer event is dispatched to a view.
 * @param view The view this event has been dispatched to.
 * @param event The captured event.
 * @return True if the listener has consumed the event, false otherwise.
 */

public boolean onCapturedPointer(android.view.View view, android.view.MotionEvent event);
}

/**
 * Interface definition for a callback to be invoked when a view is clicked.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnClickListener {

/**
 * Called when a view has been clicked.
 *
 * @param v The view that was clicked.
 */

public void onClick(android.view.View v);
}

/**
 * Interface definition for a callback to be invoked when a view is context clicked.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnContextClickListener {

/**
 * Called when a view is context clicked.
 *
 * @param v The view that has been context clicked.
 * @return true if the callback consumed the context click, false otherwise.
 */

public boolean onContextClick(android.view.View v);
}

/**
 * Interface definition for a callback to be invoked when the context menu
 * for this view is being built.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnCreateContextMenuListener {

/**
 * Called when the context menu for this view is being built. It is not
 * safe to hold onto the menu after this method returns.
 *
 * @param menu The context menu that is being built
 * @param v The view for which the context menu is being built
 * @param menuInfo Extra information about the item for which the
 *            context menu should be shown. This information will vary
 *            depending on the class of v.
 */

public void onCreateContextMenu(android.view.ContextMenu menu, android.view.View v, android.view.ContextMenu.ContextMenuInfo menuInfo);
}

/**
 * Interface definition for a callback to be invoked when a drag is being dispatched
 * to this view.  The callback will be invoked before the hosting view's own
 * onDrag(event) method.  If the listener wants to fall back to the hosting view's
 * onDrag(event) behavior, it should return 'false' from this callback.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For a guide to implementing drag and drop features, read the
 * <a href="{@docRoot}guide/topics/ui/drag-drop.html">Drag and Drop</a> developer guide.</p>
 * </div>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnDragListener {

/**
 * Called when a drag event is dispatched to a view. This allows listeners
 * to get a chance to override base View behavior.
 *
 * @param v The View that received the drag event.
 * @param event The {@link android.view.DragEvent} object for the drag event.
 * @return {@code true} if the drag event was handled successfully, or {@code false}
 * if the drag event was not handled. Note that {@code false} will trigger the View
 * to call its {@link #onDragEvent(DragEvent) onDragEvent()} handler.
 */

public boolean onDrag(android.view.View v, android.view.DragEvent event);
}

/**
 * Interface definition for a callback to be invoked when the focus state of
 * a view changed.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnFocusChangeListener {

/**
 * Called when the focus state of a view has changed.
 *
 * @param v The view whose state has changed.
 * @param hasFocus The new focus state of v.
 */

public void onFocusChange(android.view.View v, boolean hasFocus);
}

/**
 * Interface definition for a callback to be invoked when a generic motion event is
 * dispatched to this view. The callback will be invoked before the generic motion
 * event is given to the view.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnGenericMotionListener {

/**
 * Called when a generic motion event is dispatched to a view. This allows listeners to
 * get a chance to respond before the target view.
 *
 * @param v The view the generic motion event has been dispatched to.
 * @param event The MotionEvent object containing full information about
 *        the event.
 * @return True if the listener has consumed the event, false otherwise.
 */

public boolean onGenericMotion(android.view.View v, android.view.MotionEvent event);
}

/**
 * Interface definition for a callback to be invoked when a hover event is
 * dispatched to this view. The callback will be invoked before the hover
 * event is given to the view.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnHoverListener {

/**
 * Called when a hover event is dispatched to a view. This allows listeners to
 * get a chance to respond before the target view.
 *
 * @param v The view the hover event has been dispatched to.
 * @param event The MotionEvent object containing full information about
 *        the event.
 * @return True if the listener has consumed the event, false otherwise.
 */

public boolean onHover(android.view.View v, android.view.MotionEvent event);
}

/**
 * Interface definition for a callback to be invoked when a hardware key event is
 * dispatched to this view. The callback will be invoked before the key event is
 * given to the view. This is only useful for hardware keyboards; a software input
 * method has no obligation to trigger this listener.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnKeyListener {

/**
 * Called when a hardware key is dispatched to a view. This allows listeners to
 * get a chance to respond before the target view.
 * <p>Key presses in software keyboards will generally NOT trigger this method,
 * although some may elect to do so in some situations. Do not assume a
 * software input method has to be key-based; even if it is, it may use key presses
 * in a different way than you expect, so there is no way to reliably catch soft
 * input key presses.
 *
 * @param v The view the key has been dispatched to.
 * @param keyCode The code for the physical key that was pressed
 * @param event The KeyEvent object containing full information about
 *        the event.
 * @return True if the listener has consumed the event, false otherwise.
 */

public boolean onKey(android.view.View v, int keyCode, android.view.KeyEvent event);
}

/**
 * Interface definition for a callback to be invoked when the layout bounds of a view
 * changes due to layout processing.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnLayoutChangeListener {

/**
 * Called when the layout bounds of a view changes due to layout processing.
 *
 * @param v The view whose bounds have changed.
 * @param left The new value of the view's left property.
 * @param top The new value of the view's top property.
 * @param right The new value of the view's right property.
 * @param bottom The new value of the view's bottom property.
 * @param oldLeft The previous value of the view's left property.
 * @param oldTop The previous value of the view's top property.
 * @param oldRight The previous value of the view's right property.
 * @param oldBottom The previous value of the view's bottom property.
 */

public void onLayoutChange(android.view.View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom);
}

/**
 * Interface definition for a callback to be invoked when a view has been clicked and held.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnLongClickListener {

/**
 * Called when a view has been clicked and held.
 *
 * @param v The view that was clicked and held.
 *
 * @return true if the callback consumed the long click, false otherwise.
 */

public boolean onLongClick(android.view.View v);
}

/**
 * Interface definition for a callback to be invoked when the scroll
 * X or Y positions of a view change.
 * <p>
 * <b>Note:</b> Some views handle scrolling independently from View and may
 * have their own separate listeners for scroll-type events. For example,
 * {@link android.widget.ListView ListView} allows clients to register an
 * {@link android.widget.ListView#setOnScrollListener(android.widget.AbsListView.OnScrollListener) AbsListView.OnScrollListener}
 * to listen for changes in list scroll position.
 *
 * @see #setOnScrollChangeListener(View.OnScrollChangeListener)
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnScrollChangeListener {

/**
 * Called when the scroll position of a view changes.
 *
 * @param v The view whose scroll position has changed.
 * @param scrollX Current horizontal scroll origin.
 * @param scrollY Current vertical scroll origin.
 * @param oldScrollX Previous horizontal scroll origin.
 * @param oldScrollY Previous vertical scroll origin.
 */

public void onScrollChange(android.view.View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY);
}

/**
 * Interface definition for a callback to be invoked when the status bar changes
 * visibility.  This reports <strong>global</strong> changes to the system UI
 * state, not what the application is requesting.
 *
 * @see View#setOnSystemUiVisibilityChangeListener(android.view.View.OnSystemUiVisibilityChangeListener)
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnSystemUiVisibilityChangeListener {

/**
 * Called when the status bar changes visibility because of a call to
 * {@link View#setSystemUiVisibility(int)}.
 *
 * @param visibility  Bitwise-or of flags {@link #SYSTEM_UI_FLAG_LOW_PROFILE},
 * {@link #SYSTEM_UI_FLAG_HIDE_NAVIGATION}, and {@link #SYSTEM_UI_FLAG_FULLSCREEN}.
 * This tells you the <strong>global</strong> state of these UI visibility
 * flags, not what your app is currently applying.
 */

public void onSystemUiVisibilityChange(int visibility);
}

/**
 * Interface definition for a callback to be invoked when a touch event is
 * dispatched to this view. The callback will be invoked before the touch
 * event is given to the view.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnTouchListener {

/**
 * Called when a touch event is dispatched to a view. This allows listeners to
 * get a chance to respond before the target view.
 *
 * @param v The view the touch event has been dispatched to.
 * @param event The MotionEvent object containing full information about
 *        the event.
 * @return True if the listener has consumed the event, false otherwise.
 */

public boolean onTouch(android.view.View v, android.view.MotionEvent event);
}

/**
 * Interface definition for a callback to be invoked when a hardware key event hasn't
 * been handled by the view hierarchy.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnUnhandledKeyEventListener {

/**
 * Called when a hardware key is dispatched to a view after being unhandled during normal
 * {@link KeyEvent} dispatch.
 *
 * @param v The view the key has been dispatched to.
 * @param event The KeyEvent object containing information about the event.
 * @return {@code true} if the listener has consumed the event, {@code false} otherwise.
 */

public boolean onUnhandledKeyEvent(android.view.View v, android.view.KeyEvent event);
}

}

