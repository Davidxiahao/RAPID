/* //device/java/android/javax/microedition/khronos/opengles/GL11ExtensionPack.java
**
** Copyright 2007, The Android Open Source Project
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


package javax.microedition.khronos.opengles;


@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface GL11ExtensionPack extends javax.microedition.khronos.opengles.GL {

public void glBindFramebufferOES(int target, int framebuffer);

public void glBindRenderbufferOES(int target, int renderbuffer);

public void glBindTexture(int target, int texture);

public void glBlendEquation(int mode);

public void glBlendEquationSeparate(int modeRGB, int modeAlpha);

public void glBlendFuncSeparate(int srcRGB, int dstRGB, int srcAlpha, int dstAlpha);

public int glCheckFramebufferStatusOES(int target);

public void glCompressedTexImage2D(int target, int level, int internalformat, int width, int height, int border, int imageSize, java.nio.Buffer data);

public void glCopyTexImage2D(int target, int level, int internalformat, int x, int y, int width, int height, int border);

public void glDeleteFramebuffersOES(int n, int[] framebuffers, int offset);

public void glDeleteFramebuffersOES(int n, java.nio.IntBuffer framebuffers);

public void glDeleteRenderbuffersOES(int n, int[] renderbuffers, int offset);

public void glDeleteRenderbuffersOES(int n, java.nio.IntBuffer renderbuffers);

public void glEnable(int cap);

public void glFramebufferRenderbufferOES(int target, int attachment, int renderbuffertarget, int renderbuffer);

public void glFramebufferTexture2DOES(int target, int attachment, int textarget, int texture, int level);

public void glGenerateMipmapOES(int target);

public void glGenFramebuffersOES(int n, int[] framebuffers, int offset);

public void glGenFramebuffersOES(int n, java.nio.IntBuffer framebuffers);

public void glGenRenderbuffersOES(int n, int[] renderbuffers, int offset);

public void glGenRenderbuffersOES(int n, java.nio.IntBuffer renderbuffers);

public void glGetFramebufferAttachmentParameterivOES(int target, int attachment, int pname, int[] params, int offset);

public void glGetFramebufferAttachmentParameterivOES(int target, int attachment, int pname, java.nio.IntBuffer params);

public void glGetIntegerv(int pname, int[] params, int offset);

public void glGetIntegerv(int pname, java.nio.IntBuffer params);

public void glGetRenderbufferParameterivOES(int target, int pname, int[] params, int offset);

public void glGetRenderbufferParameterivOES(int target, int pname, java.nio.IntBuffer params);

public void glGetTexGenfv(int coord, int pname, float[] params, int offset);

public void glGetTexGenfv(int coord, int pname, java.nio.FloatBuffer params);

public void glGetTexGeniv(int coord, int pname, int[] params, int offset);

public void glGetTexGeniv(int coord, int pname, java.nio.IntBuffer params);

public void glGetTexGenxv(int coord, int pname, int[] params, int offset);

public void glGetTexGenxv(int coord, int pname, java.nio.IntBuffer params);

public boolean glIsFramebufferOES(int framebuffer);

public boolean glIsRenderbufferOES(int renderbuffer);

public void glRenderbufferStorageOES(int target, int internalformat, int width, int height);

public void glStencilOp(int fail, int zfail, int zpass);

public void glTexEnvf(int target, int pname, float param);

public void glTexEnvfv(int target, int pname, float[] params, int offset);

public void glTexEnvfv(int target, int pname, java.nio.FloatBuffer params);

public void glTexEnvx(int target, int pname, int param);

public void glTexEnvxv(int target, int pname, int[] params, int offset);

public void glTexEnvxv(int target, int pname, java.nio.IntBuffer params);

public void glTexGenf(int coord, int pname, float param);

public void glTexGenfv(int coord, int pname, float[] params, int offset);

public void glTexGenfv(int coord, int pname, java.nio.FloatBuffer params);

public void glTexGeni(int coord, int pname, int param);

public void glTexGeniv(int coord, int pname, int[] params, int offset);

public void glTexGeniv(int coord, int pname, java.nio.IntBuffer params);

public void glTexGenx(int coord, int pname, int param);

public void glTexGenxv(int coord, int pname, int[] params, int offset);

public void glTexGenxv(int coord, int pname, java.nio.IntBuffer params);

public void glTexParameterf(int target, int pname, float param);

public static final int GL_BLEND_DST_ALPHA = 32970; // 0x80ca

public static final int GL_BLEND_DST_RGB = 32968; // 0x80c8

public static final int GL_BLEND_EQUATION = 32777; // 0x8009

public static final int GL_BLEND_EQUATION_ALPHA = 34877; // 0x883d

public static final int GL_BLEND_EQUATION_RGB = 32777; // 0x8009

public static final int GL_BLEND_SRC_ALPHA = 32971; // 0x80cb

public static final int GL_BLEND_SRC_RGB = 32969; // 0x80c9

public static final int GL_COLOR_ATTACHMENT0_OES = 36064; // 0x8ce0

public static final int GL_COLOR_ATTACHMENT10_OES = 36074; // 0x8cea

public static final int GL_COLOR_ATTACHMENT11_OES = 36075; // 0x8ceb

public static final int GL_COLOR_ATTACHMENT12_OES = 36076; // 0x8cec

public static final int GL_COLOR_ATTACHMENT13_OES = 36077; // 0x8ced

public static final int GL_COLOR_ATTACHMENT14_OES = 36078; // 0x8cee

public static final int GL_COLOR_ATTACHMENT15_OES = 36079; // 0x8cef

public static final int GL_COLOR_ATTACHMENT1_OES = 36065; // 0x8ce1

public static final int GL_COLOR_ATTACHMENT2_OES = 36066; // 0x8ce2

public static final int GL_COLOR_ATTACHMENT3_OES = 36067; // 0x8ce3

public static final int GL_COLOR_ATTACHMENT4_OES = 36068; // 0x8ce4

public static final int GL_COLOR_ATTACHMENT5_OES = 36069; // 0x8ce5

public static final int GL_COLOR_ATTACHMENT6_OES = 36070; // 0x8ce6

public static final int GL_COLOR_ATTACHMENT7_OES = 36071; // 0x8ce7

public static final int GL_COLOR_ATTACHMENT8_OES = 36072; // 0x8ce8

public static final int GL_COLOR_ATTACHMENT9_OES = 36073; // 0x8ce9

public static final int GL_DECR_WRAP = 34056; // 0x8508

public static final int GL_DEPTH_ATTACHMENT_OES = 36096; // 0x8d00

public static final int GL_DEPTH_COMPONENT = 6402; // 0x1902

public static final int GL_DEPTH_COMPONENT16 = 33189; // 0x81a5

public static final int GL_DEPTH_COMPONENT24 = 33190; // 0x81a6

public static final int GL_DEPTH_COMPONENT32 = 33191; // 0x81a7

public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME_OES = 36049; // 0x8cd1

public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE_OES = 36048; // 0x8cd0

public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE_OES = 36051; // 0x8cd3

public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL_OES = 36050; // 0x8cd2

public static final int GL_FRAMEBUFFER_BINDING_OES = 36006; // 0x8ca6

public static final int GL_FRAMEBUFFER_COMPLETE_OES = 36053; // 0x8cd5

public static final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT_OES = 36054; // 0x8cd6

public static final int GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS_OES = 36057; // 0x8cd9

public static final int GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER_OES = 36059; // 0x8cdb

public static final int GL_FRAMEBUFFER_INCOMPLETE_FORMATS_OES = 36058; // 0x8cda

public static final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT_OES = 36055; // 0x8cd7

public static final int GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER_OES = 36060; // 0x8cdc

public static final int GL_FRAMEBUFFER_OES = 36160; // 0x8d40

public static final int GL_FRAMEBUFFER_UNSUPPORTED_OES = 36061; // 0x8cdd

public static final int GL_FUNC_ADD = 32774; // 0x8006

public static final int GL_FUNC_REVERSE_SUBTRACT = 32779; // 0x800b

public static final int GL_FUNC_SUBTRACT = 32778; // 0x800a

public static final int GL_INCR_WRAP = 34055; // 0x8507

public static final int GL_INVALID_FRAMEBUFFER_OPERATION_OES = 1286; // 0x506

public static final int GL_MAX_COLOR_ATTACHMENTS_OES = 36063; // 0x8cdf

public static final int GL_MAX_CUBE_MAP_TEXTURE_SIZE = 34076; // 0x851c

public static final int GL_MAX_RENDERBUFFER_SIZE_OES = 34024; // 0x84e8

public static final int GL_MIRRORED_REPEAT = 33648; // 0x8370

public static final int GL_NORMAL_MAP = 34065; // 0x8511

public static final int GL_REFLECTION_MAP = 34066; // 0x8512

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

public static final int GL_RGB565_OES = 36194; // 0x8d62

public static final int GL_RGB5_A1 = 32855; // 0x8057

public static final int GL_RGB8 = 32849; // 0x8051

public static final int GL_RGBA4 = 32854; // 0x8056

public static final int GL_RGBA8 = 32856; // 0x8058

public static final int GL_STENCIL_ATTACHMENT_OES = 36128; // 0x8d20

public static final int GL_STENCIL_INDEX = 6401; // 0x1901

public static final int GL_STENCIL_INDEX1_OES = 36166; // 0x8d46

public static final int GL_STENCIL_INDEX4_OES = 36167; // 0x8d47

public static final int GL_STENCIL_INDEX8_OES = 36168; // 0x8d48

public static final int GL_STR = -1; // 0xffffffff

public static final int GL_TEXTURE_BINDING_CUBE_MAP = 34068; // 0x8514

public static final int GL_TEXTURE_CUBE_MAP = 34067; // 0x8513

public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_X = 34070; // 0x8516

public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Y = 34072; // 0x8518

public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Z = 34074; // 0x851a

public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_X = 34069; // 0x8515

public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Y = 34071; // 0x8517

public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Z = 34073; // 0x8519

public static final int GL_TEXTURE_GEN_MODE = 9472; // 0x2500

public static final int GL_TEXTURE_GEN_STR = 36192; // 0x8d60
}

