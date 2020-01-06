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


/** OpenGL ES 2.0
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class GLES20 {

public GLES20() { throw new RuntimeException("Stub!"); }

public static native void glActiveTexture(int texture);

public static native void glAttachShader(int program, int shader);

public static native void glBindAttribLocation(int program, int index, java.lang.String name);

public static native void glBindBuffer(int target, int buffer);

public static native void glBindFramebuffer(int target, int framebuffer);

public static native void glBindRenderbuffer(int target, int renderbuffer);

public static native void glBindTexture(int target, int texture);

public static native void glBlendColor(float red, float green, float blue, float alpha);

public static native void glBlendEquation(int mode);

public static native void glBlendEquationSeparate(int modeRGB, int modeAlpha);

public static native void glBlendFunc(int sfactor, int dfactor);

public static native void glBlendFuncSeparate(int srcRGB, int dstRGB, int srcAlpha, int dstAlpha);

public static native void glBufferData(int target, int size, java.nio.Buffer data, int usage);

public static native void glBufferSubData(int target, int offset, int size, java.nio.Buffer data);

public static native int glCheckFramebufferStatus(int target);

public static native void glClear(int mask);

public static native void glClearColor(float red, float green, float blue, float alpha);

public static native void glClearDepthf(float depth);

public static native void glClearStencil(int s);

public static native void glColorMask(boolean red, boolean green, boolean blue, boolean alpha);

public static native void glCompileShader(int shader);

public static native void glCompressedTexImage2D(int target, int level, int internalformat, int width, int height, int border, int imageSize, java.nio.Buffer data);

public static native void glCompressedTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, java.nio.Buffer data);

public static native void glCopyTexImage2D(int target, int level, int internalformat, int x, int y, int width, int height, int border);

public static native void glCopyTexSubImage2D(int target, int level, int xoffset, int yoffset, int x, int y, int width, int height);

public static native int glCreateProgram();

public static native int glCreateShader(int type);

public static native void glCullFace(int mode);

public static native void glDeleteBuffers(int n, int[] buffers, int offset);

public static native void glDeleteBuffers(int n, java.nio.IntBuffer buffers);

public static native void glDeleteFramebuffers(int n, int[] framebuffers, int offset);

public static native void glDeleteFramebuffers(int n, java.nio.IntBuffer framebuffers);

public static native void glDeleteProgram(int program);

public static native void glDeleteRenderbuffers(int n, int[] renderbuffers, int offset);

public static native void glDeleteRenderbuffers(int n, java.nio.IntBuffer renderbuffers);

public static native void glDeleteShader(int shader);

public static native void glDeleteTextures(int n, int[] textures, int offset);

public static native void glDeleteTextures(int n, java.nio.IntBuffer textures);

public static native void glDepthFunc(int func);

public static native void glDepthMask(boolean flag);

public static native void glDepthRangef(float zNear, float zFar);

public static native void glDetachShader(int program, int shader);

public static native void glDisable(int cap);

public static native void glDisableVertexAttribArray(int index);

public static native void glDrawArrays(int mode, int first, int count);

public static native void glDrawElements(int mode, int count, int type, int offset);

public static native void glDrawElements(int mode, int count, int type, java.nio.Buffer indices);

public static native void glEnable(int cap);

public static native void glEnableVertexAttribArray(int index);

public static native void glFinish();

public static native void glFlush();

public static native void glFramebufferRenderbuffer(int target, int attachment, int renderbuffertarget, int renderbuffer);

public static native void glFramebufferTexture2D(int target, int attachment, int textarget, int texture, int level);

public static native void glFrontFace(int mode);

public static native void glGenBuffers(int n, int[] buffers, int offset);

public static native void glGenBuffers(int n, java.nio.IntBuffer buffers);

public static native void glGenerateMipmap(int target);

public static native void glGenFramebuffers(int n, int[] framebuffers, int offset);

public static native void glGenFramebuffers(int n, java.nio.IntBuffer framebuffers);

public static native void glGenRenderbuffers(int n, int[] renderbuffers, int offset);

public static native void glGenRenderbuffers(int n, java.nio.IntBuffer renderbuffers);

public static native void glGenTextures(int n, int[] textures, int offset);

public static native void glGenTextures(int n, java.nio.IntBuffer textures);

public static native void glGetActiveAttrib(int program, int index, int bufsize, int[] length, int lengthOffset, int[] size, int sizeOffset, int[] type, int typeOffset, byte[] name, int nameOffset);

public static native java.lang.String glGetActiveAttrib(int program, int index, int[] size, int sizeOffset, int[] type, int typeOffset);

public static native java.lang.String glGetActiveAttrib(int program, int index, java.nio.IntBuffer size, java.nio.IntBuffer type);

public static native void glGetActiveUniform(int program, int index, int bufsize, int[] length, int lengthOffset, int[] size, int sizeOffset, int[] type, int typeOffset, byte[] name, int nameOffset);

public static native java.lang.String glGetActiveUniform(int program, int index, int[] size, int sizeOffset, int[] type, int typeOffset);

public static native java.lang.String glGetActiveUniform(int program, int index, java.nio.IntBuffer size, java.nio.IntBuffer type);

public static native void glGetAttachedShaders(int program, int maxcount, int[] count, int countOffset, int[] shaders, int shadersOffset);

public static native void glGetAttachedShaders(int program, int maxcount, java.nio.IntBuffer count, java.nio.IntBuffer shaders);

public static native int glGetAttribLocation(int program, java.lang.String name);

public static native void glGetBooleanv(int pname, boolean[] params, int offset);

public static native void glGetBooleanv(int pname, java.nio.IntBuffer params);

public static native void glGetBufferParameteriv(int target, int pname, int[] params, int offset);

public static native void glGetBufferParameteriv(int target, int pname, java.nio.IntBuffer params);

public static native int glGetError();

public static native void glGetFloatv(int pname, float[] params, int offset);

public static native void glGetFloatv(int pname, java.nio.FloatBuffer params);

public static native void glGetFramebufferAttachmentParameteriv(int target, int attachment, int pname, int[] params, int offset);

public static native void glGetFramebufferAttachmentParameteriv(int target, int attachment, int pname, java.nio.IntBuffer params);

public static native void glGetIntegerv(int pname, int[] params, int offset);

public static native void glGetIntegerv(int pname, java.nio.IntBuffer params);

public static native void glGetProgramiv(int program, int pname, int[] params, int offset);

public static native void glGetProgramiv(int program, int pname, java.nio.IntBuffer params);

public static native java.lang.String glGetProgramInfoLog(int program);

public static native void glGetRenderbufferParameteriv(int target, int pname, int[] params, int offset);

public static native void glGetRenderbufferParameteriv(int target, int pname, java.nio.IntBuffer params);

public static native void glGetShaderiv(int shader, int pname, int[] params, int offset);

public static native void glGetShaderiv(int shader, int pname, java.nio.IntBuffer params);

public static native java.lang.String glGetShaderInfoLog(int shader);

public static native void glGetShaderPrecisionFormat(int shadertype, int precisiontype, int[] range, int rangeOffset, int[] precision, int precisionOffset);

public static native void glGetShaderPrecisionFormat(int shadertype, int precisiontype, java.nio.IntBuffer range, java.nio.IntBuffer precision);

public static native void glGetShaderSource(int shader, int bufsize, int[] length, int lengthOffset, byte[] source, int sourceOffset);

public static native java.lang.String glGetShaderSource(int shader);

public static native java.lang.String glGetString(int name);

public static native void glGetTexParameterfv(int target, int pname, float[] params, int offset);

public static native void glGetTexParameterfv(int target, int pname, java.nio.FloatBuffer params);

public static native void glGetTexParameteriv(int target, int pname, int[] params, int offset);

public static native void glGetTexParameteriv(int target, int pname, java.nio.IntBuffer params);

public static native void glGetUniformfv(int program, int location, float[] params, int offset);

public static native void glGetUniformfv(int program, int location, java.nio.FloatBuffer params);

public static native void glGetUniformiv(int program, int location, int[] params, int offset);

public static native void glGetUniformiv(int program, int location, java.nio.IntBuffer params);

public static native int glGetUniformLocation(int program, java.lang.String name);

public static native void glGetVertexAttribfv(int index, int pname, float[] params, int offset);

public static native void glGetVertexAttribfv(int index, int pname, java.nio.FloatBuffer params);

public static native void glGetVertexAttribiv(int index, int pname, int[] params, int offset);

public static native void glGetVertexAttribiv(int index, int pname, java.nio.IntBuffer params);

public static native void glHint(int target, int mode);

public static native boolean glIsBuffer(int buffer);

public static native boolean glIsEnabled(int cap);

public static native boolean glIsFramebuffer(int framebuffer);

public static native boolean glIsProgram(int program);

public static native boolean glIsRenderbuffer(int renderbuffer);

public static native boolean glIsShader(int shader);

public static native boolean glIsTexture(int texture);

public static native void glLineWidth(float width);

public static native void glLinkProgram(int program);

public static native void glPixelStorei(int pname, int param);

public static native void glPolygonOffset(float factor, float units);

public static native void glReadPixels(int x, int y, int width, int height, int format, int type, java.nio.Buffer pixels);

public static native void glReleaseShaderCompiler();

public static native void glRenderbufferStorage(int target, int internalformat, int width, int height);

public static native void glSampleCoverage(float value, boolean invert);

public static native void glScissor(int x, int y, int width, int height);

public static native void glShaderBinary(int n, int[] shaders, int offset, int binaryformat, java.nio.Buffer binary, int length);

public static native void glShaderBinary(int n, java.nio.IntBuffer shaders, int binaryformat, java.nio.Buffer binary, int length);

public static native void glShaderSource(int shader, java.lang.String string);

public static native void glStencilFunc(int func, int ref, int mask);

public static native void glStencilFuncSeparate(int face, int func, int ref, int mask);

public static native void glStencilMask(int mask);

public static native void glStencilMaskSeparate(int face, int mask);

public static native void glStencilOp(int fail, int zfail, int zpass);

public static native void glStencilOpSeparate(int face, int fail, int zfail, int zpass);

public static native void glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, java.nio.Buffer pixels);

public static native void glTexParameterf(int target, int pname, float param);

public static native void glTexParameterfv(int target, int pname, float[] params, int offset);

public static native void glTexParameterfv(int target, int pname, java.nio.FloatBuffer params);

public static native void glTexParameteri(int target, int pname, int param);

public static native void glTexParameteriv(int target, int pname, int[] params, int offset);

public static native void glTexParameteriv(int target, int pname, java.nio.IntBuffer params);

public static native void glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, java.nio.Buffer pixels);

public static native void glUniform1f(int location, float x);

public static native void glUniform1fv(int location, int count, float[] v, int offset);

public static native void glUniform1fv(int location, int count, java.nio.FloatBuffer v);

public static native void glUniform1i(int location, int x);

public static native void glUniform1iv(int location, int count, int[] v, int offset);

public static native void glUniform1iv(int location, int count, java.nio.IntBuffer v);

public static native void glUniform2f(int location, float x, float y);

public static native void glUniform2fv(int location, int count, float[] v, int offset);

public static native void glUniform2fv(int location, int count, java.nio.FloatBuffer v);

public static native void glUniform2i(int location, int x, int y);

public static native void glUniform2iv(int location, int count, int[] v, int offset);

public static native void glUniform2iv(int location, int count, java.nio.IntBuffer v);

public static native void glUniform3f(int location, float x, float y, float z);

public static native void glUniform3fv(int location, int count, float[] v, int offset);

public static native void glUniform3fv(int location, int count, java.nio.FloatBuffer v);

public static native void glUniform3i(int location, int x, int y, int z);

public static native void glUniform3iv(int location, int count, int[] v, int offset);

public static native void glUniform3iv(int location, int count, java.nio.IntBuffer v);

public static native void glUniform4f(int location, float x, float y, float z, float w);

public static native void glUniform4fv(int location, int count, float[] v, int offset);

public static native void glUniform4fv(int location, int count, java.nio.FloatBuffer v);

public static native void glUniform4i(int location, int x, int y, int z, int w);

public static native void glUniform4iv(int location, int count, int[] v, int offset);

public static native void glUniform4iv(int location, int count, java.nio.IntBuffer v);

public static native void glUniformMatrix2fv(int location, int count, boolean transpose, float[] value, int offset);

public static native void glUniformMatrix2fv(int location, int count, boolean transpose, java.nio.FloatBuffer value);

public static native void glUniformMatrix3fv(int location, int count, boolean transpose, float[] value, int offset);

public static native void glUniformMatrix3fv(int location, int count, boolean transpose, java.nio.FloatBuffer value);

public static native void glUniformMatrix4fv(int location, int count, boolean transpose, float[] value, int offset);

public static native void glUniformMatrix4fv(int location, int count, boolean transpose, java.nio.FloatBuffer value);

public static native void glUseProgram(int program);

public static native void glValidateProgram(int program);

public static native void glVertexAttrib1f(int indx, float x);

public static native void glVertexAttrib1fv(int indx, float[] values, int offset);

public static native void glVertexAttrib1fv(int indx, java.nio.FloatBuffer values);

public static native void glVertexAttrib2f(int indx, float x, float y);

public static native void glVertexAttrib2fv(int indx, float[] values, int offset);

public static native void glVertexAttrib2fv(int indx, java.nio.FloatBuffer values);

public static native void glVertexAttrib3f(int indx, float x, float y, float z);

public static native void glVertexAttrib3fv(int indx, float[] values, int offset);

public static native void glVertexAttrib3fv(int indx, java.nio.FloatBuffer values);

public static native void glVertexAttrib4f(int indx, float x, float y, float z, float w);

public static native void glVertexAttrib4fv(int indx, float[] values, int offset);

public static native void glVertexAttrib4fv(int indx, java.nio.FloatBuffer values);

public static native void glVertexAttribPointer(int indx, int size, int type, boolean normalized, int stride, int offset);

public static void glVertexAttribPointer(int indx, int size, int type, boolean normalized, int stride, java.nio.Buffer ptr) { throw new RuntimeException("Stub!"); }

public static native void glViewport(int x, int y, int width, int height);

public static final int GL_ACTIVE_ATTRIBUTES = 35721; // 0x8b89

public static final int GL_ACTIVE_ATTRIBUTE_MAX_LENGTH = 35722; // 0x8b8a

public static final int GL_ACTIVE_TEXTURE = 34016; // 0x84e0

public static final int GL_ACTIVE_UNIFORMS = 35718; // 0x8b86

public static final int GL_ACTIVE_UNIFORM_MAX_LENGTH = 35719; // 0x8b87

public static final int GL_ALIASED_LINE_WIDTH_RANGE = 33902; // 0x846e

public static final int GL_ALIASED_POINT_SIZE_RANGE = 33901; // 0x846d

public static final int GL_ALPHA = 6406; // 0x1906

public static final int GL_ALPHA_BITS = 3413; // 0xd55

public static final int GL_ALWAYS = 519; // 0x207

public static final int GL_ARRAY_BUFFER = 34962; // 0x8892

public static final int GL_ARRAY_BUFFER_BINDING = 34964; // 0x8894

public static final int GL_ATTACHED_SHADERS = 35717; // 0x8b85

public static final int GL_BACK = 1029; // 0x405

public static final int GL_BLEND = 3042; // 0xbe2

public static final int GL_BLEND_COLOR = 32773; // 0x8005

public static final int GL_BLEND_DST_ALPHA = 32970; // 0x80ca

public static final int GL_BLEND_DST_RGB = 32968; // 0x80c8

public static final int GL_BLEND_EQUATION = 32777; // 0x8009

public static final int GL_BLEND_EQUATION_ALPHA = 34877; // 0x883d

public static final int GL_BLEND_EQUATION_RGB = 32777; // 0x8009

public static final int GL_BLEND_SRC_ALPHA = 32971; // 0x80cb

public static final int GL_BLEND_SRC_RGB = 32969; // 0x80c9

public static final int GL_BLUE_BITS = 3412; // 0xd54

public static final int GL_BOOL = 35670; // 0x8b56

public static final int GL_BOOL_VEC2 = 35671; // 0x8b57

public static final int GL_BOOL_VEC3 = 35672; // 0x8b58

public static final int GL_BOOL_VEC4 = 35673; // 0x8b59

public static final int GL_BUFFER_SIZE = 34660; // 0x8764

public static final int GL_BUFFER_USAGE = 34661; // 0x8765

public static final int GL_BYTE = 5120; // 0x1400

public static final int GL_CCW = 2305; // 0x901

public static final int GL_CLAMP_TO_EDGE = 33071; // 0x812f

public static final int GL_COLOR_ATTACHMENT0 = 36064; // 0x8ce0

public static final int GL_COLOR_BUFFER_BIT = 16384; // 0x4000

public static final int GL_COLOR_CLEAR_VALUE = 3106; // 0xc22

public static final int GL_COLOR_WRITEMASK = 3107; // 0xc23

public static final int GL_COMPILE_STATUS = 35713; // 0x8b81

public static final int GL_COMPRESSED_TEXTURE_FORMATS = 34467; // 0x86a3

public static final int GL_CONSTANT_ALPHA = 32771; // 0x8003

public static final int GL_CONSTANT_COLOR = 32769; // 0x8001

public static final int GL_CULL_FACE = 2884; // 0xb44

public static final int GL_CULL_FACE_MODE = 2885; // 0xb45

public static final int GL_CURRENT_PROGRAM = 35725; // 0x8b8d

public static final int GL_CURRENT_VERTEX_ATTRIB = 34342; // 0x8626

public static final int GL_CW = 2304; // 0x900

public static final int GL_DECR = 7683; // 0x1e03

public static final int GL_DECR_WRAP = 34056; // 0x8508

public static final int GL_DELETE_STATUS = 35712; // 0x8b80

public static final int GL_DEPTH_ATTACHMENT = 36096; // 0x8d00

public static final int GL_DEPTH_BITS = 3414; // 0xd56

public static final int GL_DEPTH_BUFFER_BIT = 256; // 0x100

public static final int GL_DEPTH_CLEAR_VALUE = 2931; // 0xb73

public static final int GL_DEPTH_COMPONENT = 6402; // 0x1902

public static final int GL_DEPTH_COMPONENT16 = 33189; // 0x81a5

public static final int GL_DEPTH_FUNC = 2932; // 0xb74

public static final int GL_DEPTH_RANGE = 2928; // 0xb70

public static final int GL_DEPTH_TEST = 2929; // 0xb71

public static final int GL_DEPTH_WRITEMASK = 2930; // 0xb72

public static final int GL_DITHER = 3024; // 0xbd0

public static final int GL_DONT_CARE = 4352; // 0x1100

public static final int GL_DST_ALPHA = 772; // 0x304

public static final int GL_DST_COLOR = 774; // 0x306

public static final int GL_DYNAMIC_DRAW = 35048; // 0x88e8

public static final int GL_ELEMENT_ARRAY_BUFFER = 34963; // 0x8893

public static final int GL_ELEMENT_ARRAY_BUFFER_BINDING = 34965; // 0x8895

public static final int GL_EQUAL = 514; // 0x202

public static final int GL_EXTENSIONS = 7939; // 0x1f03

public static final int GL_FALSE = 0; // 0x0

public static final int GL_FASTEST = 4353; // 0x1101

public static final int GL_FIXED = 5132; // 0x140c

public static final int GL_FLOAT = 5126; // 0x1406

public static final int GL_FLOAT_MAT2 = 35674; // 0x8b5a

public static final int GL_FLOAT_MAT3 = 35675; // 0x8b5b

public static final int GL_FLOAT_MAT4 = 35676; // 0x8b5c

public static final int GL_FLOAT_VEC2 = 35664; // 0x8b50

public static final int GL_FLOAT_VEC3 = 35665; // 0x8b51

public static final int GL_FLOAT_VEC4 = 35666; // 0x8b52

public static final int GL_FRAGMENT_SHADER = 35632; // 0x8b30

public static final int GL_FRAMEBUFFER = 36160; // 0x8d40

public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME = 36049; // 0x8cd1

public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE = 36048; // 0x8cd0

public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE = 36051; // 0x8cd3

public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL = 36050; // 0x8cd2

public static final int GL_FRAMEBUFFER_BINDING = 36006; // 0x8ca6

public static final int GL_FRAMEBUFFER_COMPLETE = 36053; // 0x8cd5

public static final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT = 36054; // 0x8cd6

public static final int GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS = 36057; // 0x8cd9

public static final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT = 36055; // 0x8cd7

public static final int GL_FRAMEBUFFER_UNSUPPORTED = 36061; // 0x8cdd

public static final int GL_FRONT = 1028; // 0x404

public static final int GL_FRONT_AND_BACK = 1032; // 0x408

public static final int GL_FRONT_FACE = 2886; // 0xb46

public static final int GL_FUNC_ADD = 32774; // 0x8006

public static final int GL_FUNC_REVERSE_SUBTRACT = 32779; // 0x800b

public static final int GL_FUNC_SUBTRACT = 32778; // 0x800a

public static final int GL_GENERATE_MIPMAP_HINT = 33170; // 0x8192

public static final int GL_GEQUAL = 518; // 0x206

public static final int GL_GREATER = 516; // 0x204

public static final int GL_GREEN_BITS = 3411; // 0xd53

public static final int GL_HIGH_FLOAT = 36338; // 0x8df2

public static final int GL_HIGH_INT = 36341; // 0x8df5

public static final int GL_IMPLEMENTATION_COLOR_READ_FORMAT = 35739; // 0x8b9b

public static final int GL_IMPLEMENTATION_COLOR_READ_TYPE = 35738; // 0x8b9a

public static final int GL_INCR = 7682; // 0x1e02

public static final int GL_INCR_WRAP = 34055; // 0x8507

public static final int GL_INFO_LOG_LENGTH = 35716; // 0x8b84

public static final int GL_INT = 5124; // 0x1404

public static final int GL_INT_VEC2 = 35667; // 0x8b53

public static final int GL_INT_VEC3 = 35668; // 0x8b54

public static final int GL_INT_VEC4 = 35669; // 0x8b55

public static final int GL_INVALID_ENUM = 1280; // 0x500

public static final int GL_INVALID_FRAMEBUFFER_OPERATION = 1286; // 0x506

public static final int GL_INVALID_OPERATION = 1282; // 0x502

public static final int GL_INVALID_VALUE = 1281; // 0x501

public static final int GL_INVERT = 5386; // 0x150a

public static final int GL_KEEP = 7680; // 0x1e00

public static final int GL_LEQUAL = 515; // 0x203

public static final int GL_LESS = 513; // 0x201

public static final int GL_LINEAR = 9729; // 0x2601

public static final int GL_LINEAR_MIPMAP_LINEAR = 9987; // 0x2703

public static final int GL_LINEAR_MIPMAP_NEAREST = 9985; // 0x2701

public static final int GL_LINES = 1; // 0x1

public static final int GL_LINE_LOOP = 2; // 0x2

public static final int GL_LINE_STRIP = 3; // 0x3

public static final int GL_LINE_WIDTH = 2849; // 0xb21

public static final int GL_LINK_STATUS = 35714; // 0x8b82

public static final int GL_LOW_FLOAT = 36336; // 0x8df0

public static final int GL_LOW_INT = 36339; // 0x8df3

public static final int GL_LUMINANCE = 6409; // 0x1909

public static final int GL_LUMINANCE_ALPHA = 6410; // 0x190a

public static final int GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS = 35661; // 0x8b4d

public static final int GL_MAX_CUBE_MAP_TEXTURE_SIZE = 34076; // 0x851c

public static final int GL_MAX_FRAGMENT_UNIFORM_VECTORS = 36349; // 0x8dfd

public static final int GL_MAX_RENDERBUFFER_SIZE = 34024; // 0x84e8

public static final int GL_MAX_TEXTURE_IMAGE_UNITS = 34930; // 0x8872

public static final int GL_MAX_TEXTURE_SIZE = 3379; // 0xd33

public static final int GL_MAX_VARYING_VECTORS = 36348; // 0x8dfc

public static final int GL_MAX_VERTEX_ATTRIBS = 34921; // 0x8869

public static final int GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS = 35660; // 0x8b4c

public static final int GL_MAX_VERTEX_UNIFORM_VECTORS = 36347; // 0x8dfb

public static final int GL_MAX_VIEWPORT_DIMS = 3386; // 0xd3a

public static final int GL_MEDIUM_FLOAT = 36337; // 0x8df1

public static final int GL_MEDIUM_INT = 36340; // 0x8df4

public static final int GL_MIRRORED_REPEAT = 33648; // 0x8370

public static final int GL_NEAREST = 9728; // 0x2600

public static final int GL_NEAREST_MIPMAP_LINEAR = 9986; // 0x2702

public static final int GL_NEAREST_MIPMAP_NEAREST = 9984; // 0x2700

public static final int GL_NEVER = 512; // 0x200

public static final int GL_NICEST = 4354; // 0x1102

public static final int GL_NONE = 0; // 0x0

public static final int GL_NOTEQUAL = 517; // 0x205

public static final int GL_NO_ERROR = 0; // 0x0

public static final int GL_NUM_COMPRESSED_TEXTURE_FORMATS = 34466; // 0x86a2

public static final int GL_NUM_SHADER_BINARY_FORMATS = 36345; // 0x8df9

public static final int GL_ONE = 1; // 0x1

public static final int GL_ONE_MINUS_CONSTANT_ALPHA = 32772; // 0x8004

public static final int GL_ONE_MINUS_CONSTANT_COLOR = 32770; // 0x8002

public static final int GL_ONE_MINUS_DST_ALPHA = 773; // 0x305

public static final int GL_ONE_MINUS_DST_COLOR = 775; // 0x307

public static final int GL_ONE_MINUS_SRC_ALPHA = 771; // 0x303

public static final int GL_ONE_MINUS_SRC_COLOR = 769; // 0x301

public static final int GL_OUT_OF_MEMORY = 1285; // 0x505

public static final int GL_PACK_ALIGNMENT = 3333; // 0xd05

public static final int GL_POINTS = 0; // 0x0

public static final int GL_POLYGON_OFFSET_FACTOR = 32824; // 0x8038

public static final int GL_POLYGON_OFFSET_FILL = 32823; // 0x8037

public static final int GL_POLYGON_OFFSET_UNITS = 10752; // 0x2a00

public static final int GL_RED_BITS = 3410; // 0xd52

public static final int GL_RENDERBUFFER = 36161; // 0x8d41

public static final int GL_RENDERBUFFER_ALPHA_SIZE = 36179; // 0x8d53

public static final int GL_RENDERBUFFER_BINDING = 36007; // 0x8ca7

public static final int GL_RENDERBUFFER_BLUE_SIZE = 36178; // 0x8d52

public static final int GL_RENDERBUFFER_DEPTH_SIZE = 36180; // 0x8d54

public static final int GL_RENDERBUFFER_GREEN_SIZE = 36177; // 0x8d51

public static final int GL_RENDERBUFFER_HEIGHT = 36163; // 0x8d43

public static final int GL_RENDERBUFFER_INTERNAL_FORMAT = 36164; // 0x8d44

public static final int GL_RENDERBUFFER_RED_SIZE = 36176; // 0x8d50

public static final int GL_RENDERBUFFER_STENCIL_SIZE = 36181; // 0x8d55

public static final int GL_RENDERBUFFER_WIDTH = 36162; // 0x8d42

public static final int GL_RENDERER = 7937; // 0x1f01

public static final int GL_REPEAT = 10497; // 0x2901

public static final int GL_REPLACE = 7681; // 0x1e01

public static final int GL_RGB = 6407; // 0x1907

public static final int GL_RGB565 = 36194; // 0x8d62

public static final int GL_RGB5_A1 = 32855; // 0x8057

public static final int GL_RGBA = 6408; // 0x1908

public static final int GL_RGBA4 = 32854; // 0x8056

public static final int GL_SAMPLER_2D = 35678; // 0x8b5e

public static final int GL_SAMPLER_CUBE = 35680; // 0x8b60

public static final int GL_SAMPLES = 32937; // 0x80a9

public static final int GL_SAMPLE_ALPHA_TO_COVERAGE = 32926; // 0x809e

public static final int GL_SAMPLE_BUFFERS = 32936; // 0x80a8

public static final int GL_SAMPLE_COVERAGE = 32928; // 0x80a0

public static final int GL_SAMPLE_COVERAGE_INVERT = 32939; // 0x80ab

public static final int GL_SAMPLE_COVERAGE_VALUE = 32938; // 0x80aa

public static final int GL_SCISSOR_BOX = 3088; // 0xc10

public static final int GL_SCISSOR_TEST = 3089; // 0xc11

public static final int GL_SHADER_BINARY_FORMATS = 36344; // 0x8df8

public static final int GL_SHADER_COMPILER = 36346; // 0x8dfa

public static final int GL_SHADER_SOURCE_LENGTH = 35720; // 0x8b88

public static final int GL_SHADER_TYPE = 35663; // 0x8b4f

public static final int GL_SHADING_LANGUAGE_VERSION = 35724; // 0x8b8c

public static final int GL_SHORT = 5122; // 0x1402

public static final int GL_SRC_ALPHA = 770; // 0x302

public static final int GL_SRC_ALPHA_SATURATE = 776; // 0x308

public static final int GL_SRC_COLOR = 768; // 0x300

public static final int GL_STATIC_DRAW = 35044; // 0x88e4

public static final int GL_STENCIL_ATTACHMENT = 36128; // 0x8d20

public static final int GL_STENCIL_BACK_FAIL = 34817; // 0x8801

public static final int GL_STENCIL_BACK_FUNC = 34816; // 0x8800

public static final int GL_STENCIL_BACK_PASS_DEPTH_FAIL = 34818; // 0x8802

public static final int GL_STENCIL_BACK_PASS_DEPTH_PASS = 34819; // 0x8803

public static final int GL_STENCIL_BACK_REF = 36003; // 0x8ca3

public static final int GL_STENCIL_BACK_VALUE_MASK = 36004; // 0x8ca4

public static final int GL_STENCIL_BACK_WRITEMASK = 36005; // 0x8ca5

public static final int GL_STENCIL_BITS = 3415; // 0xd57

public static final int GL_STENCIL_BUFFER_BIT = 1024; // 0x400

public static final int GL_STENCIL_CLEAR_VALUE = 2961; // 0xb91

public static final int GL_STENCIL_FAIL = 2964; // 0xb94

public static final int GL_STENCIL_FUNC = 2962; // 0xb92

@Deprecated public static final int GL_STENCIL_INDEX = 6401; // 0x1901

public static final int GL_STENCIL_INDEX8 = 36168; // 0x8d48

public static final int GL_STENCIL_PASS_DEPTH_FAIL = 2965; // 0xb95

public static final int GL_STENCIL_PASS_DEPTH_PASS = 2966; // 0xb96

public static final int GL_STENCIL_REF = 2967; // 0xb97

public static final int GL_STENCIL_TEST = 2960; // 0xb90

public static final int GL_STENCIL_VALUE_MASK = 2963; // 0xb93

public static final int GL_STENCIL_WRITEMASK = 2968; // 0xb98

public static final int GL_STREAM_DRAW = 35040; // 0x88e0

public static final int GL_SUBPIXEL_BITS = 3408; // 0xd50

public static final int GL_TEXTURE = 5890; // 0x1702

public static final int GL_TEXTURE0 = 33984; // 0x84c0

public static final int GL_TEXTURE1 = 33985; // 0x84c1

public static final int GL_TEXTURE10 = 33994; // 0x84ca

public static final int GL_TEXTURE11 = 33995; // 0x84cb

public static final int GL_TEXTURE12 = 33996; // 0x84cc

public static final int GL_TEXTURE13 = 33997; // 0x84cd

public static final int GL_TEXTURE14 = 33998; // 0x84ce

public static final int GL_TEXTURE15 = 33999; // 0x84cf

public static final int GL_TEXTURE16 = 34000; // 0x84d0

public static final int GL_TEXTURE17 = 34001; // 0x84d1

public static final int GL_TEXTURE18 = 34002; // 0x84d2

public static final int GL_TEXTURE19 = 34003; // 0x84d3

public static final int GL_TEXTURE2 = 33986; // 0x84c2

public static final int GL_TEXTURE20 = 34004; // 0x84d4

public static final int GL_TEXTURE21 = 34005; // 0x84d5

public static final int GL_TEXTURE22 = 34006; // 0x84d6

public static final int GL_TEXTURE23 = 34007; // 0x84d7

public static final int GL_TEXTURE24 = 34008; // 0x84d8

public static final int GL_TEXTURE25 = 34009; // 0x84d9

public static final int GL_TEXTURE26 = 34010; // 0x84da

public static final int GL_TEXTURE27 = 34011; // 0x84db

public static final int GL_TEXTURE28 = 34012; // 0x84dc

public static final int GL_TEXTURE29 = 34013; // 0x84dd

public static final int GL_TEXTURE3 = 33987; // 0x84c3

public static final int GL_TEXTURE30 = 34014; // 0x84de

public static final int GL_TEXTURE31 = 34015; // 0x84df

public static final int GL_TEXTURE4 = 33988; // 0x84c4

public static final int GL_TEXTURE5 = 33989; // 0x84c5

public static final int GL_TEXTURE6 = 33990; // 0x84c6

public static final int GL_TEXTURE7 = 33991; // 0x84c7

public static final int GL_TEXTURE8 = 33992; // 0x84c8

public static final int GL_TEXTURE9 = 33993; // 0x84c9

public static final int GL_TEXTURE_2D = 3553; // 0xde1

public static final int GL_TEXTURE_BINDING_2D = 32873; // 0x8069

public static final int GL_TEXTURE_BINDING_CUBE_MAP = 34068; // 0x8514

public static final int GL_TEXTURE_CUBE_MAP = 34067; // 0x8513

public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_X = 34070; // 0x8516

public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Y = 34072; // 0x8518

public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Z = 34074; // 0x851a

public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_X = 34069; // 0x8515

public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Y = 34071; // 0x8517

public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Z = 34073; // 0x8519

public static final int GL_TEXTURE_MAG_FILTER = 10240; // 0x2800

public static final int GL_TEXTURE_MIN_FILTER = 10241; // 0x2801

public static final int GL_TEXTURE_WRAP_S = 10242; // 0x2802

public static final int GL_TEXTURE_WRAP_T = 10243; // 0x2803

public static final int GL_TRIANGLES = 4; // 0x4

public static final int GL_TRIANGLE_FAN = 6; // 0x6

public static final int GL_TRIANGLE_STRIP = 5; // 0x5

public static final int GL_TRUE = 1; // 0x1

public static final int GL_UNPACK_ALIGNMENT = 3317; // 0xcf5

public static final int GL_UNSIGNED_BYTE = 5121; // 0x1401

public static final int GL_UNSIGNED_INT = 5125; // 0x1405

public static final int GL_UNSIGNED_SHORT = 5123; // 0x1403

public static final int GL_UNSIGNED_SHORT_4_4_4_4 = 32819; // 0x8033

public static final int GL_UNSIGNED_SHORT_5_5_5_1 = 32820; // 0x8034

public static final int GL_UNSIGNED_SHORT_5_6_5 = 33635; // 0x8363

public static final int GL_VALIDATE_STATUS = 35715; // 0x8b83

public static final int GL_VENDOR = 7936; // 0x1f00

public static final int GL_VERSION = 7938; // 0x1f02

public static final int GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING = 34975; // 0x889f

public static final int GL_VERTEX_ATTRIB_ARRAY_ENABLED = 34338; // 0x8622

public static final int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED = 34922; // 0x886a

public static final int GL_VERTEX_ATTRIB_ARRAY_POINTER = 34373; // 0x8645

public static final int GL_VERTEX_ATTRIB_ARRAY_SIZE = 34339; // 0x8623

public static final int GL_VERTEX_ATTRIB_ARRAY_STRIDE = 34340; // 0x8624

public static final int GL_VERTEX_ATTRIB_ARRAY_TYPE = 34341; // 0x8625

public static final int GL_VERTEX_SHADER = 35633; // 0x8b31

public static final int GL_VIEWPORT = 2978; // 0xba2

public static final int GL_ZERO = 0; // 0x0
}

