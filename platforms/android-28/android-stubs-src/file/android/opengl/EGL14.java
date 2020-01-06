/*
** Copyright 2012, The Android Open Source Project
**
** Licensed under the Apache License, Version 2.0 (the "License");
** you may not use this file except in compliance with the License.
** You may obtain a copy of the License at
**
**     http://www.apache.org/licenses/LICENSE-2.0
**
** Unless required by applicable law or agreed to in writing, software
** distributed under the License is distributed on an "AS IS" BASIS,
** WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
** See the License for the specific language governing permissions and
** limitations under the License.
*/

// This source file is automatically generated


package android.opengl;


/**
 * EGL 1.4
 *
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class EGL14 {

public EGL14() { throw new RuntimeException("Stub!"); }

public static native int eglGetError();

public static native android.opengl.EGLDisplay eglGetDisplay(int display_id);

public static native boolean eglInitialize(android.opengl.EGLDisplay dpy, int[] major, int majorOffset, int[] minor, int minorOffset);

public static native boolean eglTerminate(android.opengl.EGLDisplay dpy);

public static native java.lang.String eglQueryString(android.opengl.EGLDisplay dpy, int name);

public static native boolean eglGetConfigs(android.opengl.EGLDisplay dpy, android.opengl.EGLConfig[] configs, int configsOffset, int config_size, int[] num_config, int num_configOffset);

public static native boolean eglChooseConfig(android.opengl.EGLDisplay dpy, int[] attrib_list, int attrib_listOffset, android.opengl.EGLConfig[] configs, int configsOffset, int config_size, int[] num_config, int num_configOffset);

public static native boolean eglGetConfigAttrib(android.opengl.EGLDisplay dpy, android.opengl.EGLConfig config, int attribute, int[] value, int offset);

public static android.opengl.EGLSurface eglCreateWindowSurface(android.opengl.EGLDisplay dpy, android.opengl.EGLConfig config, java.lang.Object win, int[] attrib_list, int offset) { throw new RuntimeException("Stub!"); }

public static native android.opengl.EGLSurface eglCreatePbufferSurface(android.opengl.EGLDisplay dpy, android.opengl.EGLConfig config, int[] attrib_list, int offset);

@Deprecated public static native android.opengl.EGLSurface eglCreatePixmapSurface(android.opengl.EGLDisplay dpy, android.opengl.EGLConfig config, int pixmap, int[] attrib_list, int offset);

public static native boolean eglDestroySurface(android.opengl.EGLDisplay dpy, android.opengl.EGLSurface surface);

public static native boolean eglQuerySurface(android.opengl.EGLDisplay dpy, android.opengl.EGLSurface surface, int attribute, int[] value, int offset);

public static native boolean eglBindAPI(int api);

public static native int eglQueryAPI();

public static native boolean eglWaitClient();

public static native boolean eglReleaseThread();

public static native android.opengl.EGLSurface eglCreatePbufferFromClientBuffer(android.opengl.EGLDisplay dpy, int buftype, int buffer, android.opengl.EGLConfig config, int[] attrib_list, int offset);

public static native boolean eglSurfaceAttrib(android.opengl.EGLDisplay dpy, android.opengl.EGLSurface surface, int attribute, int value);

public static native boolean eglBindTexImage(android.opengl.EGLDisplay dpy, android.opengl.EGLSurface surface, int buffer);

public static native boolean eglReleaseTexImage(android.opengl.EGLDisplay dpy, android.opengl.EGLSurface surface, int buffer);

public static native boolean eglSwapInterval(android.opengl.EGLDisplay dpy, int interval);

public static native android.opengl.EGLContext eglCreateContext(android.opengl.EGLDisplay dpy, android.opengl.EGLConfig config, android.opengl.EGLContext share_context, int[] attrib_list, int offset);

public static native boolean eglDestroyContext(android.opengl.EGLDisplay dpy, android.opengl.EGLContext ctx);

public static native boolean eglMakeCurrent(android.opengl.EGLDisplay dpy, android.opengl.EGLSurface draw, android.opengl.EGLSurface read, android.opengl.EGLContext ctx);

public static native android.opengl.EGLContext eglGetCurrentContext();

public static native android.opengl.EGLSurface eglGetCurrentSurface(int readdraw);

public static native android.opengl.EGLDisplay eglGetCurrentDisplay();

public static native boolean eglQueryContext(android.opengl.EGLDisplay dpy, android.opengl.EGLContext ctx, int attribute, int[] value, int offset);

public static native boolean eglWaitGL();

public static native boolean eglWaitNative(int engine);

public static native boolean eglSwapBuffers(android.opengl.EGLDisplay dpy, android.opengl.EGLSurface surface);

public static native boolean eglCopyBuffers(android.opengl.EGLDisplay dpy, android.opengl.EGLSurface surface, int target);

public static final int EGL_ALPHA_MASK_SIZE = 12350; // 0x303e

public static final int EGL_ALPHA_SIZE = 12321; // 0x3021

public static final int EGL_BACK_BUFFER = 12420; // 0x3084

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

public static final int EGL_BIND_TO_TEXTURE_RGB = 12345; // 0x3039

public static final int EGL_BIND_TO_TEXTURE_RGBA = 12346; // 0x303a

public static final int EGL_BLUE_SIZE = 12322; // 0x3022

public static final int EGL_BUFFER_DESTROYED = 12437; // 0x3095

public static final int EGL_BUFFER_PRESERVED = 12436; // 0x3094

public static final int EGL_BUFFER_SIZE = 12320; // 0x3020

public static final int EGL_CLIENT_APIS = 12429; // 0x308d

public static final int EGL_COLOR_BUFFER_TYPE = 12351; // 0x303f

public static final int EGL_CONFIG_CAVEAT = 12327; // 0x3027

public static final int EGL_CONFIG_ID = 12328; // 0x3028

public static final int EGL_CONFORMANT = 12354; // 0x3042

public static final int EGL_CONTEXT_CLIENT_TYPE = 12439; // 0x3097

public static final int EGL_CONTEXT_CLIENT_VERSION = 12440; // 0x3098

public static final int EGL_CONTEXT_LOST = 12302; // 0x300e

public static final int EGL_CORE_NATIVE_ENGINE = 12379; // 0x305b

public static final int EGL_DEFAULT_DISPLAY = 0; // 0x0

public static final int EGL_DEPTH_SIZE = 12325; // 0x3025

public static final int EGL_DISPLAY_SCALING = 10000; // 0x2710

public static final int EGL_DRAW = 12377; // 0x3059

public static final int EGL_EXTENSIONS = 12373; // 0x3055

public static final int EGL_FALSE = 0; // 0x0

public static final int EGL_GREEN_SIZE = 12323; // 0x3023

public static final int EGL_HEIGHT = 12374; // 0x3056

public static final int EGL_HORIZONTAL_RESOLUTION = 12432; // 0x3090

public static final int EGL_LARGEST_PBUFFER = 12376; // 0x3058

public static final int EGL_LEVEL = 12329; // 0x3029

public static final int EGL_LUMINANCE_BUFFER = 12431; // 0x308f

public static final int EGL_LUMINANCE_SIZE = 12349; // 0x303d

public static final int EGL_MATCH_NATIVE_PIXMAP = 12353; // 0x3041

public static final int EGL_MAX_PBUFFER_HEIGHT = 12330; // 0x302a

public static final int EGL_MAX_PBUFFER_PIXELS = 12331; // 0x302b

public static final int EGL_MAX_PBUFFER_WIDTH = 12332; // 0x302c

public static final int EGL_MAX_SWAP_INTERVAL = 12348; // 0x303c

public static final int EGL_MIN_SWAP_INTERVAL = 12347; // 0x303b

public static final int EGL_MIPMAP_LEVEL = 12419; // 0x3083

public static final int EGL_MIPMAP_TEXTURE = 12418; // 0x3082

public static final int EGL_MULTISAMPLE_RESOLVE = 12441; // 0x3099

public static final int EGL_MULTISAMPLE_RESOLVE_BOX = 12443; // 0x309b

public static final int EGL_MULTISAMPLE_RESOLVE_BOX_BIT = 512; // 0x200

public static final int EGL_MULTISAMPLE_RESOLVE_DEFAULT = 12442; // 0x309a

public static final int EGL_NATIVE_RENDERABLE = 12333; // 0x302d

public static final int EGL_NATIVE_VISUAL_ID = 12334; // 0x302e

public static final int EGL_NATIVE_VISUAL_TYPE = 12335; // 0x302f

public static final int EGL_NONE = 12344; // 0x3038

public static final int EGL_NON_CONFORMANT_CONFIG = 12369; // 0x3051

public static final int EGL_NOT_INITIALIZED = 12289; // 0x3001

public static android.opengl.EGLContext EGL_NO_CONTEXT;

public static android.opengl.EGLDisplay EGL_NO_DISPLAY;

public static android.opengl.EGLSurface EGL_NO_SURFACE;

public static final int EGL_NO_TEXTURE = 12380; // 0x305c

public static final int EGL_OPENGL_API = 12450; // 0x30a2

public static final int EGL_OPENGL_BIT = 8; // 0x8

public static final int EGL_OPENGL_ES2_BIT = 4; // 0x4

public static final int EGL_OPENGL_ES_API = 12448; // 0x30a0

public static final int EGL_OPENGL_ES_BIT = 1; // 0x1

public static final int EGL_OPENVG_API = 12449; // 0x30a1

public static final int EGL_OPENVG_BIT = 2; // 0x2

public static final int EGL_OPENVG_IMAGE = 12438; // 0x3096

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

public static final int EGL_SWAP_BEHAVIOR = 12435; // 0x3093

public static final int EGL_SWAP_BEHAVIOR_PRESERVED_BIT = 1024; // 0x400

public static final int EGL_TEXTURE_2D = 12383; // 0x305f

public static final int EGL_TEXTURE_FORMAT = 12416; // 0x3080

public static final int EGL_TEXTURE_RGB = 12381; // 0x305d

public static final int EGL_TEXTURE_RGBA = 12382; // 0x305e

public static final int EGL_TEXTURE_TARGET = 12417; // 0x3081

public static final int EGL_TRANSPARENT_BLUE_VALUE = 12341; // 0x3035

public static final int EGL_TRANSPARENT_GREEN_VALUE = 12342; // 0x3036

public static final int EGL_TRANSPARENT_RED_VALUE = 12343; // 0x3037

public static final int EGL_TRANSPARENT_RGB = 12370; // 0x3052

public static final int EGL_TRANSPARENT_TYPE = 12340; // 0x3034

public static final int EGL_TRUE = 1; // 0x1

public static final int EGL_VENDOR = 12371; // 0x3053

public static final int EGL_VERSION = 12372; // 0x3054

public static final int EGL_VERTICAL_RESOLUTION = 12433; // 0x3091

public static final int EGL_VG_ALPHA_FORMAT = 12424; // 0x3088

public static final int EGL_VG_ALPHA_FORMAT_NONPRE = 12427; // 0x308b

public static final int EGL_VG_ALPHA_FORMAT_PRE = 12428; // 0x308c

public static final int EGL_VG_ALPHA_FORMAT_PRE_BIT = 64; // 0x40

public static final int EGL_VG_COLORSPACE = 12423; // 0x3087

public static final int EGL_VG_COLORSPACE_LINEAR = 12426; // 0x308a

public static final int EGL_VG_COLORSPACE_LINEAR_BIT = 32; // 0x20

public static final int EGL_VG_COLORSPACE_sRGB = 12425; // 0x3089

public static final int EGL_WIDTH = 12375; // 0x3057

public static final int EGL_WINDOW_BIT = 4; // 0x4
}

