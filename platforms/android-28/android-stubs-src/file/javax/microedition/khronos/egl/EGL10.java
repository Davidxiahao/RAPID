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


package javax.microedition.khronos.egl;


@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface EGL10 extends javax.microedition.khronos.egl.EGL {

public boolean eglChooseConfig(javax.microedition.khronos.egl.EGLDisplay display, int[] attrib_list, javax.microedition.khronos.egl.EGLConfig[] configs, int config_size, int[] num_config);

public boolean eglCopyBuffers(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLSurface surface, java.lang.Object native_pixmap);

public javax.microedition.khronos.egl.EGLContext eglCreateContext(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLConfig config, javax.microedition.khronos.egl.EGLContext share_context, int[] attrib_list);

public javax.microedition.khronos.egl.EGLSurface eglCreatePbufferSurface(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLConfig config, int[] attrib_list);

@Deprecated public javax.microedition.khronos.egl.EGLSurface eglCreatePixmapSurface(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLConfig config, java.lang.Object native_pixmap, int[] attrib_list);

public javax.microedition.khronos.egl.EGLSurface eglCreateWindowSurface(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLConfig config, java.lang.Object native_window, int[] attrib_list);

public boolean eglDestroyContext(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLContext context);

public boolean eglDestroySurface(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLSurface surface);

public boolean eglGetConfigAttrib(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLConfig config, int attribute, int[] value);

public boolean eglGetConfigs(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLConfig[] configs, int config_size, int[] num_config);

public javax.microedition.khronos.egl.EGLContext eglGetCurrentContext();

public javax.microedition.khronos.egl.EGLDisplay eglGetCurrentDisplay();

public javax.microedition.khronos.egl.EGLSurface eglGetCurrentSurface(int readdraw);

public javax.microedition.khronos.egl.EGLDisplay eglGetDisplay(java.lang.Object native_display);

public int eglGetError();

public boolean eglInitialize(javax.microedition.khronos.egl.EGLDisplay display, int[] major_minor);

public boolean eglMakeCurrent(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLSurface draw, javax.microedition.khronos.egl.EGLSurface read, javax.microedition.khronos.egl.EGLContext context);

public boolean eglQueryContext(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLContext context, int attribute, int[] value);

public java.lang.String eglQueryString(javax.microedition.khronos.egl.EGLDisplay display, int name);

public boolean eglQuerySurface(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLSurface surface, int attribute, int[] value);

public boolean eglSwapBuffers(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLSurface surface);

public boolean eglTerminate(javax.microedition.khronos.egl.EGLDisplay display);

public boolean eglWaitGL();

public boolean eglWaitNative(int engine, java.lang.Object bindTarget);

public static final int EGL_ALPHA_FORMAT = 12424; // 0x3088

public static final int EGL_ALPHA_MASK_SIZE = 12350; // 0x303e

public static final int EGL_ALPHA_SIZE = 12321; // 0x3021

public static final int EGL_BAD_ACCESS = 12290; // 0x3002

public static final int EGL_BAD_ALLOC = 12291; // 0x3003

public static final int EGL_BAD_ATTRIBUTE = 12292; // 0x3004

public static final int EGL_BAD_CONFIG = 12293; // 0x3005

public static final int EGL_BAD_CONTEXT = 12294; // 0x3006

public static final int EGL_BAD_CURRENT_SURFACE = 12295; // 0x3007

public static final int EGL_BAD_DISPLAY = 12296; // 0x3008

public static final int EGL_BAD_MATCH = 12297; // 0x3009

public static final int EGL_BAD_NATIVE_PIXMAP = 12298; // 0x300a

public static final int EGL_BAD_NATIVE_WINDOW = 12299; // 0x300b

public static final int EGL_BAD_PARAMETER = 12300; // 0x300c

public static final int EGL_BAD_SURFACE = 12301; // 0x300d

public static final int EGL_BLUE_SIZE = 12322; // 0x3022

public static final int EGL_BUFFER_SIZE = 12320; // 0x3020

public static final int EGL_COLORSPACE = 12423; // 0x3087

public static final int EGL_COLOR_BUFFER_TYPE = 12351; // 0x303f

public static final int EGL_CONFIG_CAVEAT = 12327; // 0x3027

public static final int EGL_CONFIG_ID = 12328; // 0x3028

public static final int EGL_CORE_NATIVE_ENGINE = 12379; // 0x305b

public static final java.lang.Object EGL_DEFAULT_DISPLAY = null;

public static final int EGL_DEPTH_SIZE = 12325; // 0x3025

public static final int EGL_DONT_CARE = -1; // 0xffffffff

public static final int EGL_DRAW = 12377; // 0x3059

public static final int EGL_EXTENSIONS = 12373; // 0x3055

public static final int EGL_GREEN_SIZE = 12323; // 0x3023

public static final int EGL_HEIGHT = 12374; // 0x3056

public static final int EGL_HORIZONTAL_RESOLUTION = 12432; // 0x3090

public static final int EGL_LARGEST_PBUFFER = 12376; // 0x3058

public static final int EGL_LEVEL = 12329; // 0x3029

public static final int EGL_LUMINANCE_BUFFER = 12431; // 0x308f

public static final int EGL_LUMINANCE_SIZE = 12349; // 0x303d

public static final int EGL_MAX_PBUFFER_HEIGHT = 12330; // 0x302a

public static final int EGL_MAX_PBUFFER_PIXELS = 12331; // 0x302b

public static final int EGL_MAX_PBUFFER_WIDTH = 12332; // 0x302c

public static final int EGL_NATIVE_RENDERABLE = 12333; // 0x302d

public static final int EGL_NATIVE_VISUAL_ID = 12334; // 0x302e

public static final int EGL_NATIVE_VISUAL_TYPE = 12335; // 0x302f

public static final int EGL_NONE = 12344; // 0x3038

public static final int EGL_NON_CONFORMANT_CONFIG = 12369; // 0x3051

public static final int EGL_NOT_INITIALIZED = 12289; // 0x3001

public static final javax.microedition.khronos.egl.EGLContext EGL_NO_CONTEXT = null;

public static final javax.microedition.khronos.egl.EGLDisplay EGL_NO_DISPLAY = null;

public static final javax.microedition.khronos.egl.EGLSurface EGL_NO_SURFACE = null;

public static final int EGL_PBUFFER_BIT = 1; // 0x1

public static final int EGL_PIXEL_ASPECT_RATIO = 12434; // 0x3092

public static final int EGL_PIXMAP_BIT = 2; // 0x2

public static final int EGL_READ = 12378; // 0x305a

public static final int EGL_RED_SIZE = 12324; // 0x3024

public static final int EGL_RENDERABLE_TYPE = 12352; // 0x3040

public static final int EGL_RENDER_BUFFER = 12422; // 0x3086

public static final int EGL_RGB_BUFFER = 12430; // 0x308e

public static final int EGL_SAMPLES = 12337; // 0x3031

public static final int EGL_SAMPLE_BUFFERS = 12338; // 0x3032

public static final int EGL_SINGLE_BUFFER = 12421; // 0x3085

public static final int EGL_SLOW_CONFIG = 12368; // 0x3050

public static final int EGL_STENCIL_SIZE = 12326; // 0x3026

public static final int EGL_SUCCESS = 12288; // 0x3000

public static final int EGL_SURFACE_TYPE = 12339; // 0x3033

public static final int EGL_TRANSPARENT_BLUE_VALUE = 12341; // 0x3035

public static final int EGL_TRANSPARENT_GREEN_VALUE = 12342; // 0x3036

public static final int EGL_TRANSPARENT_RED_VALUE = 12343; // 0x3037

public static final int EGL_TRANSPARENT_RGB = 12370; // 0x3052

public static final int EGL_TRANSPARENT_TYPE = 12340; // 0x3034

public static final int EGL_VENDOR = 12371; // 0x3053

public static final int EGL_VERSION = 12372; // 0x3054

public static final int EGL_VERTICAL_RESOLUTION = 12433; // 0x3091

public static final int EGL_WIDTH = 12375; // 0x3057

public static final int EGL_WINDOW_BIT = 4; // 0x4
}

