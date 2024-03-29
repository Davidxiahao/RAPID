/*
**
** Copyright 2009, The Android Open Source Project
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


@SuppressWarnings({"unchecked", "deprecation", "all"})
public class GLES11Ext {

public GLES11Ext() { throw new RuntimeException("Stub!"); }

public static native void glBlendEquationSeparateOES(int modeRGB, int modeAlpha);

public static native void glBlendFuncSeparateOES(int srcRGB, int dstRGB, int srcAlpha, int dstAlpha);

public static native void glBlendEquationOES(int mode);

public static native void glDrawTexsOES(short x, short y, short z, short width, short height);

public static native void glDrawTexiOES(int x, int y, int z, int width, int height);

public static native void glDrawTexxOES(int x, int y, int z, int width, int height);

public static native void glDrawTexsvOES(short[] coords, int offset);

public static native void glDrawTexsvOES(java.nio.ShortBuffer coords);

public static native void glDrawTexivOES(int[] coords, int offset);

public static native void glDrawTexivOES(java.nio.IntBuffer coords);

public static native void glDrawTexxvOES(int[] coords, int offset);

public static native void glDrawTexxvOES(java.nio.IntBuffer coords);

public static native void glDrawTexfOES(float x, float y, float z, float width, float height);

public static native void glDrawTexfvOES(float[] coords, int offset);

public static native void glDrawTexfvOES(java.nio.FloatBuffer coords);

public static native void glEGLImageTargetTexture2DOES(int target, java.nio.Buffer image);

public static native void glEGLImageTargetRenderbufferStorageOES(int target, java.nio.Buffer image);

public static native void glAlphaFuncxOES(int func, int ref);

public static native void glClearColorxOES(int red, int green, int blue, int alpha);

public static native void glClearDepthxOES(int depth);

public static native void glClipPlanexOES(int plane, int[] equation, int offset);

public static native void glClipPlanexOES(int plane, java.nio.IntBuffer equation);

public static native void glColor4xOES(int red, int green, int blue, int alpha);

public static native void glDepthRangexOES(int zNear, int zFar);

public static native void glFogxOES(int pname, int param);

public static native void glFogxvOES(int pname, int[] params, int offset);

public static native void glFogxvOES(int pname, java.nio.IntBuffer params);

public static native void glFrustumxOES(int left, int right, int bottom, int top, int zNear, int zFar);

public static native void glGetClipPlanexOES(int pname, int[] eqn, int offset);

public static native void glGetClipPlanexOES(int pname, java.nio.IntBuffer eqn);

public static native void glGetFixedvOES(int pname, int[] params, int offset);

public static native void glGetFixedvOES(int pname, java.nio.IntBuffer params);

public static native void glGetLightxvOES(int light, int pname, int[] params, int offset);

public static native void glGetLightxvOES(int light, int pname, java.nio.IntBuffer params);

public static native void glGetMaterialxvOES(int face, int pname, int[] params, int offset);

public static native void glGetMaterialxvOES(int face, int pname, java.nio.IntBuffer params);

public static native void glGetTexEnvxvOES(int env, int pname, int[] params, int offset);

public static native void glGetTexEnvxvOES(int env, int pname, java.nio.IntBuffer params);

public static native void glGetTexParameterxvOES(int target, int pname, int[] params, int offset);

public static native void glGetTexParameterxvOES(int target, int pname, java.nio.IntBuffer params);

public static native void glLightModelxOES(int pname, int param);

public static native void glLightModelxvOES(int pname, int[] params, int offset);

public static native void glLightModelxvOES(int pname, java.nio.IntBuffer params);

public static native void glLightxOES(int light, int pname, int param);

public static native void glLightxvOES(int light, int pname, int[] params, int offset);

public static native void glLightxvOES(int light, int pname, java.nio.IntBuffer params);

public static native void glLineWidthxOES(int width);

public static native void glLoadMatrixxOES(int[] m, int offset);

public static native void glLoadMatrixxOES(java.nio.IntBuffer m);

public static native void glMaterialxOES(int face, int pname, int param);

public static native void glMaterialxvOES(int face, int pname, int[] params, int offset);

public static native void glMaterialxvOES(int face, int pname, java.nio.IntBuffer params);

public static native void glMultMatrixxOES(int[] m, int offset);

public static native void glMultMatrixxOES(java.nio.IntBuffer m);

public static native void glMultiTexCoord4xOES(int target, int s, int t, int r, int q);

public static native void glNormal3xOES(int nx, int ny, int nz);

public static native void glOrthoxOES(int left, int right, int bottom, int top, int zNear, int zFar);

public static native void glPointParameterxOES(int pname, int param);

public static native void glPointParameterxvOES(int pname, int[] params, int offset);

public static native void glPointParameterxvOES(int pname, java.nio.IntBuffer params);

public static native void glPointSizexOES(int size);

public static native void glPolygonOffsetxOES(int factor, int units);

public static native void glRotatexOES(int angle, int x, int y, int z);

public static native void glSampleCoveragexOES(int value, boolean invert);

public static native void glScalexOES(int x, int y, int z);

public static native void glTexEnvxOES(int target, int pname, int param);

public static native void glTexEnvxvOES(int target, int pname, int[] params, int offset);

public static native void glTexEnvxvOES(int target, int pname, java.nio.IntBuffer params);

public static native void glTexParameterxOES(int target, int pname, int param);

public static native void glTexParameterxvOES(int target, int pname, int[] params, int offset);

public static native void glTexParameterxvOES(int target, int pname, java.nio.IntBuffer params);

public static native void glTranslatexOES(int x, int y, int z);

public static native boolean glIsRenderbufferOES(int renderbuffer);

public static native void glBindRenderbufferOES(int target, int renderbuffer);

public static native void glDeleteRenderbuffersOES(int n, int[] renderbuffers, int offset);

public static native void glDeleteRenderbuffersOES(int n, java.nio.IntBuffer renderbuffers);

public static native void glGenRenderbuffersOES(int n, int[] renderbuffers, int offset);

public static native void glGenRenderbuffersOES(int n, java.nio.IntBuffer renderbuffers);

public static native void glRenderbufferStorageOES(int target, int internalformat, int width, int height);

public static native void glGetRenderbufferParameterivOES(int target, int pname, int[] params, int offset);

public static native void glGetRenderbufferParameterivOES(int target, int pname, java.nio.IntBuffer params);

public static native boolean glIsFramebufferOES(int framebuffer);

public static native void glBindFramebufferOES(int target, int framebuffer);

public static native void glDeleteFramebuffersOES(int n, int[] framebuffers, int offset);

public static native void glDeleteFramebuffersOES(int n, java.nio.IntBuffer framebuffers);

public static native void glGenFramebuffersOES(int n, int[] framebuffers, int offset);

public static native void glGenFramebuffersOES(int n, java.nio.IntBuffer framebuffers);

public static native int glCheckFramebufferStatusOES(int target);

public static native void glFramebufferRenderbufferOES(int target, int attachment, int renderbuffertarget, int renderbuffer);

public static native void glFramebufferTexture2DOES(int target, int attachment, int textarget, int texture, int level);

public static native void glGetFramebufferAttachmentParameterivOES(int target, int attachment, int pname, int[] params, int offset);

public static native void glGetFramebufferAttachmentParameterivOES(int target, int attachment, int pname, java.nio.IntBuffer params);

public static native void glGenerateMipmapOES(int target);

public static native void glCurrentPaletteMatrixOES(int matrixpaletteindex);

public static native void glLoadPaletteFromModelViewMatrixOES();

public static void glMatrixIndexPointerOES(int size, int type, int stride, java.nio.Buffer pointer) { throw new RuntimeException("Stub!"); }

public static void glWeightPointerOES(int size, int type, int stride, java.nio.Buffer pointer) { throw new RuntimeException("Stub!"); }

public static native void glDepthRangefOES(float zNear, float zFar);

public static native void glFrustumfOES(float left, float right, float bottom, float top, float zNear, float zFar);

public static native void glOrthofOES(float left, float right, float bottom, float top, float zNear, float zFar);

public static native void glClipPlanefOES(int plane, float[] equation, int offset);

public static native void glClipPlanefOES(int plane, java.nio.FloatBuffer equation);

public static native void glGetClipPlanefOES(int pname, float[] eqn, int offset);

public static native void glGetClipPlanefOES(int pname, java.nio.FloatBuffer eqn);

public static native void glClearDepthfOES(float depth);

public static native void glTexGenfOES(int coord, int pname, float param);

public static native void glTexGenfvOES(int coord, int pname, float[] params, int offset);

public static native void glTexGenfvOES(int coord, int pname, java.nio.FloatBuffer params);

public static native void glTexGeniOES(int coord, int pname, int param);

public static native void glTexGenivOES(int coord, int pname, int[] params, int offset);

public static native void glTexGenivOES(int coord, int pname, java.nio.IntBuffer params);

public static native void glTexGenxOES(int coord, int pname, int param);

public static native void glTexGenxvOES(int coord, int pname, int[] params, int offset);

public static native void glTexGenxvOES(int coord, int pname, java.nio.IntBuffer params);

public static native void glGetTexGenfvOES(int coord, int pname, float[] params, int offset);

public static native void glGetTexGenfvOES(int coord, int pname, java.nio.FloatBuffer params);

public static native void glGetTexGenivOES(int coord, int pname, int[] params, int offset);

public static native void glGetTexGenivOES(int coord, int pname, java.nio.IntBuffer params);

public static native void glGetTexGenxvOES(int coord, int pname, int[] params, int offset);

public static native void glGetTexGenxvOES(int coord, int pname, java.nio.IntBuffer params);

public static final int GL_3DC_XY_AMD = 34810; // 0x87fa

public static final int GL_3DC_X_AMD = 34809; // 0x87f9

public static final int GL_ATC_RGBA_EXPLICIT_ALPHA_AMD = 35987; // 0x8c93

public static final int GL_ATC_RGBA_INTERPOLATED_ALPHA_AMD = 34798; // 0x87ee

public static final int GL_ATC_RGB_AMD = 35986; // 0x8c92

public static final int GL_BGRA = 32993; // 0x80e1

public static final int GL_BLEND_DST_ALPHA_OES = 32970; // 0x80ca

public static final int GL_BLEND_DST_RGB_OES = 32968; // 0x80c8

public static final int GL_BLEND_EQUATION_ALPHA_OES = 34877; // 0x883d

public static final int GL_BLEND_EQUATION_OES = 32777; // 0x8009

public static final int GL_BLEND_EQUATION_RGB_OES = 32777; // 0x8009

public static final int GL_BLEND_SRC_ALPHA_OES = 32971; // 0x80cb

public static final int GL_BLEND_SRC_RGB_OES = 32969; // 0x80c9

public static final int GL_BUFFER_ACCESS_OES = 35003; // 0x88bb

public static final int GL_BUFFER_MAPPED_OES = 35004; // 0x88bc

public static final int GL_BUFFER_MAP_POINTER_OES = 35005; // 0x88bd

public static final int GL_COLOR_ATTACHMENT0_OES = 36064; // 0x8ce0

public static final int GL_CURRENT_PALETTE_MATRIX_OES = 34883; // 0x8843

public static final int GL_DECR_WRAP_OES = 34056; // 0x8508

public static final int GL_DEPTH24_STENCIL8_OES = 35056; // 0x88f0

public static final int GL_DEPTH_ATTACHMENT_OES = 36096; // 0x8d00

public static final int GL_DEPTH_COMPONENT16_OES = 33189; // 0x81a5

public static final int GL_DEPTH_COMPONENT24_OES = 33190; // 0x81a6

public static final int GL_DEPTH_COMPONENT32_OES = 33191; // 0x81a7

public static final int GL_DEPTH_STENCIL_OES = 34041; // 0x84f9

public static final int GL_ETC1_RGB8_OES = 36196; // 0x8d64

public static final int GL_FIXED_OES = 5132; // 0x140c

public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME_OES = 36049; // 0x8cd1

public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE_OES = 36048; // 0x8cd0

public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE_OES = 36051; // 0x8cd3

public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL_OES = 36050; // 0x8cd2

public static final int GL_FRAMEBUFFER_BINDING_OES = 36006; // 0x8ca6

public static final int GL_FRAMEBUFFER_COMPLETE_OES = 36053; // 0x8cd5

public static final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT_OES = 36054; // 0x8cd6

public static final int GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS_OES = 36057; // 0x8cd9

public static final int GL_FRAMEBUFFER_INCOMPLETE_FORMATS_OES = 36058; // 0x8cda

public static final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT_OES = 36055; // 0x8cd7

public static final int GL_FRAMEBUFFER_OES = 36160; // 0x8d40

public static final int GL_FRAMEBUFFER_UNSUPPORTED_OES = 36061; // 0x8cdd

public static final int GL_FUNC_ADD_OES = 32774; // 0x8006

public static final int GL_FUNC_REVERSE_SUBTRACT_OES = 32779; // 0x800b

public static final int GL_FUNC_SUBTRACT_OES = 32778; // 0x800a

public static final int GL_INCR_WRAP_OES = 34055; // 0x8507

public static final int GL_INVALID_FRAMEBUFFER_OPERATION_OES = 1286; // 0x506

public static final int GL_MATRIX_INDEX_ARRAY_BUFFER_BINDING_OES = 35742; // 0x8b9e

public static final int GL_MATRIX_INDEX_ARRAY_OES = 34884; // 0x8844

public static final int GL_MATRIX_INDEX_ARRAY_POINTER_OES = 34889; // 0x8849

public static final int GL_MATRIX_INDEX_ARRAY_SIZE_OES = 34886; // 0x8846

public static final int GL_MATRIX_INDEX_ARRAY_STRIDE_OES = 34888; // 0x8848

public static final int GL_MATRIX_INDEX_ARRAY_TYPE_OES = 34887; // 0x8847

public static final int GL_MATRIX_PALETTE_OES = 34880; // 0x8840

public static final int GL_MAX_CUBE_MAP_TEXTURE_SIZE_OES = 34076; // 0x851c

public static final int GL_MAX_PALETTE_MATRICES_OES = 34882; // 0x8842

public static final int GL_MAX_RENDERBUFFER_SIZE_OES = 34024; // 0x84e8

public static final int GL_MAX_TEXTURE_MAX_ANISOTROPY_EXT = 34047; // 0x84ff

public static final int GL_MAX_VERTEX_UNITS_OES = 34468; // 0x86a4

public static final int GL_MIRRORED_REPEAT_OES = 33648; // 0x8370

public static final int GL_MODELVIEW_MATRIX_FLOAT_AS_INT_BITS_OES = 35213; // 0x898d

public static final int GL_NONE_OES = 0; // 0x0

public static final int GL_NORMAL_MAP_OES = 34065; // 0x8511

public static final int GL_PROJECTION_MATRIX_FLOAT_AS_INT_BITS_OES = 35214; // 0x898e

public static final int GL_REFLECTION_MAP_OES = 34066; // 0x8512

public static final int GL_RENDERBUFFER_ALPHA_SIZE_OES = 36179; // 0x8d53

public static final int GL_RENDERBUFFER_BINDING_OES = 36007; // 0x8ca7

public static final int GL_RENDERBUFFER_BLUE_SIZE_OES = 36178; // 0x8d52

public static final int GL_RENDERBUFFER_DEPTH_SIZE_OES = 36180; // 0x8d54

public static final int GL_RENDERBUFFER_GREEN_SIZE_OES = 36177; // 0x8d51

public static final int GL_RENDERBUFFER_HEIGHT_OES = 36163; // 0x8d43

public static final int GL_RENDERBUFFER_INTERNAL_FORMAT_OES = 36164; // 0x8d44

public static final int GL_RENDERBUFFER_OES = 36161; // 0x8d41

public static final int GL_RENDERBUFFER_RED_SIZE_OES = 36176; // 0x8d50

public static final int GL_RENDERBUFFER_STENCIL_SIZE_OES = 36181; // 0x8d55

public static final int GL_RENDERBUFFER_WIDTH_OES = 36162; // 0x8d42

public static final int GL_REQUIRED_TEXTURE_IMAGE_UNITS_OES = 36200; // 0x8d68

public static final int GL_RGB565_OES = 36194; // 0x8d62

public static final int GL_RGB5_A1_OES = 32855; // 0x8057

public static final int GL_RGB8_OES = 32849; // 0x8051

public static final int GL_RGBA4_OES = 32854; // 0x8056

public static final int GL_RGBA8_OES = 32856; // 0x8058

public static final int GL_SAMPLER_EXTERNAL_OES = 36198; // 0x8d66

public static final int GL_STENCIL_ATTACHMENT_OES = 36128; // 0x8d20

public static final int GL_STENCIL_INDEX1_OES = 36166; // 0x8d46

public static final int GL_STENCIL_INDEX4_OES = 36167; // 0x8d47

public static final int GL_STENCIL_INDEX8_OES = 36168; // 0x8d48

public static final int GL_TEXTURE_BINDING_CUBE_MAP_OES = 34068; // 0x8514

public static final int GL_TEXTURE_BINDING_EXTERNAL_OES = 36199; // 0x8d67

public static final int GL_TEXTURE_CROP_RECT_OES = 35741; // 0x8b9d

public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_X_OES = 34070; // 0x8516

public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Y_OES = 34072; // 0x8518

public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Z_OES = 34074; // 0x851a

public static final int GL_TEXTURE_CUBE_MAP_OES = 34067; // 0x8513

public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_X_OES = 34069; // 0x8515

public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Y_OES = 34071; // 0x8517

public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Z_OES = 34073; // 0x8519

public static final int GL_TEXTURE_EXTERNAL_OES = 36197; // 0x8d65

public static final int GL_TEXTURE_GEN_MODE_OES = 9472; // 0x2500

public static final int GL_TEXTURE_GEN_STR_OES = 36192; // 0x8d60

public static final int GL_TEXTURE_MATRIX_FLOAT_AS_INT_BITS_OES = 35215; // 0x898f

public static final int GL_TEXTURE_MAX_ANISOTROPY_EXT = 34046; // 0x84fe

public static final int GL_UNSIGNED_INT_24_8_OES = 34042; // 0x84fa

public static final int GL_WEIGHT_ARRAY_BUFFER_BINDING_OES = 34974; // 0x889e

public static final int GL_WEIGHT_ARRAY_OES = 34477; // 0x86ad

public static final int GL_WEIGHT_ARRAY_POINTER_OES = 34476; // 0x86ac

public static final int GL_WEIGHT_ARRAY_SIZE_OES = 34475; // 0x86ab

public static final int GL_WEIGHT_ARRAY_STRIDE_OES = 34474; // 0x86aa

public static final int GL_WEIGHT_ARRAY_TYPE_OES = 34473; // 0x86a9

public static final int GL_WRITE_ONLY_OES = 35001; // 0x88b9
}

