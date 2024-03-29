/*
**
** Copyright 2013, The Android Open Source Project
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


/** OpenGL ES 3.0
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class GLES30 extends android.opengl.GLES20 {

public GLES30() { throw new RuntimeException("Stub!"); }

public static native void glReadBuffer(int mode);

public static native void glDrawRangeElements(int mode, int start, int end, int count, int type, java.nio.Buffer indices);

public static native void glDrawRangeElements(int mode, int start, int end, int count, int type, int offset);

public static native void glTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, java.nio.Buffer pixels);

public static native void glTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, int offset);

public static native void glTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, java.nio.Buffer pixels);

public static native void glTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, int offset);

public static native void glCopyTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height);

public static native void glCompressedTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, java.nio.Buffer data);

public static native void glCompressedTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, int offset);

public static native void glCompressedTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, java.nio.Buffer data);

public static native void glCompressedTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, int offset);

public static native void glGenQueries(int n, int[] ids, int offset);

public static native void glGenQueries(int n, java.nio.IntBuffer ids);

public static native void glDeleteQueries(int n, int[] ids, int offset);

public static native void glDeleteQueries(int n, java.nio.IntBuffer ids);

public static native boolean glIsQuery(int id);

public static native void glBeginQuery(int target, int id);

public static native void glEndQuery(int target);

public static native void glGetQueryiv(int target, int pname, int[] params, int offset);

public static native void glGetQueryiv(int target, int pname, java.nio.IntBuffer params);

public static native void glGetQueryObjectuiv(int id, int pname, int[] params, int offset);

public static native void glGetQueryObjectuiv(int id, int pname, java.nio.IntBuffer params);

public static native boolean glUnmapBuffer(int target);

/**
 * The {@link java.nio.Buffer} instance returned by this method is guaranteed
 * to be an instance of {@link java.nio.ByteBuffer}.
 */

public static native java.nio.Buffer glGetBufferPointerv(int target, int pname);

public static native void glDrawBuffers(int n, int[] bufs, int offset);

public static native void glDrawBuffers(int n, java.nio.IntBuffer bufs);

public static native void glUniformMatrix2x3fv(int location, int count, boolean transpose, float[] value, int offset);

public static native void glUniformMatrix2x3fv(int location, int count, boolean transpose, java.nio.FloatBuffer value);

public static native void glUniformMatrix3x2fv(int location, int count, boolean transpose, float[] value, int offset);

public static native void glUniformMatrix3x2fv(int location, int count, boolean transpose, java.nio.FloatBuffer value);

public static native void glUniformMatrix2x4fv(int location, int count, boolean transpose, float[] value, int offset);

public static native void glUniformMatrix2x4fv(int location, int count, boolean transpose, java.nio.FloatBuffer value);

public static native void glUniformMatrix4x2fv(int location, int count, boolean transpose, float[] value, int offset);

public static native void glUniformMatrix4x2fv(int location, int count, boolean transpose, java.nio.FloatBuffer value);

public static native void glUniformMatrix3x4fv(int location, int count, boolean transpose, float[] value, int offset);

public static native void glUniformMatrix3x4fv(int location, int count, boolean transpose, java.nio.FloatBuffer value);

public static native void glUniformMatrix4x3fv(int location, int count, boolean transpose, float[] value, int offset);

public static native void glUniformMatrix4x3fv(int location, int count, boolean transpose, java.nio.FloatBuffer value);

public static native void glBlitFramebuffer(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter);

public static native void glRenderbufferStorageMultisample(int target, int samples, int internalformat, int width, int height);

public static native void glFramebufferTextureLayer(int target, int attachment, int texture, int level, int layer);

/**
 * The {@link java.nio.Buffer} instance returned by this method is guaranteed
 * to be an instance of {@link java.nio.ByteBuffer}.
 */

public static native java.nio.Buffer glMapBufferRange(int target, int offset, int length, int access);

public static native void glFlushMappedBufferRange(int target, int offset, int length);

public static native void glBindVertexArray(int array);

public static native void glDeleteVertexArrays(int n, int[] arrays, int offset);

public static native void glDeleteVertexArrays(int n, java.nio.IntBuffer arrays);

public static native void glGenVertexArrays(int n, int[] arrays, int offset);

public static native void glGenVertexArrays(int n, java.nio.IntBuffer arrays);

public static native boolean glIsVertexArray(int array);

public static native void glGetIntegeri_v(int target, int index, int[] data, int offset);

public static native void glGetIntegeri_v(int target, int index, java.nio.IntBuffer data);

public static native void glBeginTransformFeedback(int primitiveMode);

public static native void glEndTransformFeedback();

public static native void glBindBufferRange(int target, int index, int buffer, int offset, int size);

public static native void glBindBufferBase(int target, int index, int buffer);

public static native void glTransformFeedbackVaryings(int program, java.lang.String[] varyings, int bufferMode);

public static native void glGetTransformFeedbackVarying(int program, int index, int bufsize, int[] length, int lengthOffset, int[] size, int sizeOffset, int[] type, int typeOffset, byte[] name, int nameOffset);

/**
 * @deprecated
 * Use the version that takes a ByteBuffer as the last argument, or the versions that return a String.
 * */

@Deprecated public static native void glGetTransformFeedbackVarying(int program, int index, int bufsize, java.nio.IntBuffer length, java.nio.IntBuffer size, java.nio.IntBuffer type, byte name);

public static native void glGetTransformFeedbackVarying(int program, int index, int bufsize, java.nio.IntBuffer length, java.nio.IntBuffer size, java.nio.IntBuffer type, java.nio.ByteBuffer name);

public static native java.lang.String glGetTransformFeedbackVarying(int program, int index, int[] size, int sizeOffset, int[] type, int typeOffset);

public static native java.lang.String glGetTransformFeedbackVarying(int program, int index, java.nio.IntBuffer size, java.nio.IntBuffer type);

public static void glVertexAttribIPointer(int index, int size, int type, int stride, java.nio.Buffer pointer) { throw new RuntimeException("Stub!"); }

public static native void glVertexAttribIPointer(int index, int size, int type, int stride, int offset);

public static native void glGetVertexAttribIiv(int index, int pname, int[] params, int offset);

public static native void glGetVertexAttribIiv(int index, int pname, java.nio.IntBuffer params);

public static native void glGetVertexAttribIuiv(int index, int pname, int[] params, int offset);

public static native void glGetVertexAttribIuiv(int index, int pname, java.nio.IntBuffer params);

public static native void glVertexAttribI4i(int index, int x, int y, int z, int w);

public static native void glVertexAttribI4ui(int index, int x, int y, int z, int w);

public static native void glVertexAttribI4iv(int index, int[] v, int offset);

public static native void glVertexAttribI4iv(int index, java.nio.IntBuffer v);

public static native void glVertexAttribI4uiv(int index, int[] v, int offset);

public static native void glVertexAttribI4uiv(int index, java.nio.IntBuffer v);

public static native void glGetUniformuiv(int program, int location, int[] params, int offset);

public static native void glGetUniformuiv(int program, int location, java.nio.IntBuffer params);

public static native int glGetFragDataLocation(int program, java.lang.String name);

public static native void glUniform1ui(int location, int v0);

public static native void glUniform2ui(int location, int v0, int v1);

public static native void glUniform3ui(int location, int v0, int v1, int v2);

public static native void glUniform4ui(int location, int v0, int v1, int v2, int v3);

public static native void glUniform1uiv(int location, int count, int[] value, int offset);

public static native void glUniform1uiv(int location, int count, java.nio.IntBuffer value);

public static native void glUniform2uiv(int location, int count, int[] value, int offset);

public static native void glUniform2uiv(int location, int count, java.nio.IntBuffer value);

public static native void glUniform3uiv(int location, int count, int[] value, int offset);

public static native void glUniform3uiv(int location, int count, java.nio.IntBuffer value);

public static native void glUniform4uiv(int location, int count, int[] value, int offset);

public static native void glUniform4uiv(int location, int count, java.nio.IntBuffer value);

public static native void glClearBufferiv(int buffer, int drawbuffer, int[] value, int offset);

public static native void glClearBufferiv(int buffer, int drawbuffer, java.nio.IntBuffer value);

public static native void glClearBufferuiv(int buffer, int drawbuffer, int[] value, int offset);

public static native void glClearBufferuiv(int buffer, int drawbuffer, java.nio.IntBuffer value);

public static native void glClearBufferfv(int buffer, int drawbuffer, float[] value, int offset);

public static native void glClearBufferfv(int buffer, int drawbuffer, java.nio.FloatBuffer value);

public static native void glClearBufferfi(int buffer, int drawbuffer, float depth, int stencil);

public static native java.lang.String glGetStringi(int name, int index);

public static native void glCopyBufferSubData(int readTarget, int writeTarget, int readOffset, int writeOffset, int size);

public static native void glGetUniformIndices(int program, java.lang.String[] uniformNames, int[] uniformIndices, int uniformIndicesOffset);

public static native void glGetUniformIndices(int program, java.lang.String[] uniformNames, java.nio.IntBuffer uniformIndices);

public static native void glGetActiveUniformsiv(int program, int uniformCount, int[] uniformIndices, int uniformIndicesOffset, int pname, int[] params, int paramsOffset);

public static native void glGetActiveUniformsiv(int program, int uniformCount, java.nio.IntBuffer uniformIndices, int pname, java.nio.IntBuffer params);

public static native int glGetUniformBlockIndex(int program, java.lang.String uniformBlockName);

public static native void glGetActiveUniformBlockiv(int program, int uniformBlockIndex, int pname, int[] params, int offset);

public static native void glGetActiveUniformBlockiv(int program, int uniformBlockIndex, int pname, java.nio.IntBuffer params);

public static native void glGetActiveUniformBlockName(int program, int uniformBlockIndex, int bufSize, int[] length, int lengthOffset, byte[] uniformBlockName, int uniformBlockNameOffset);

public static native void glGetActiveUniformBlockName(int program, int uniformBlockIndex, java.nio.Buffer length, java.nio.Buffer uniformBlockName);

public static native java.lang.String glGetActiveUniformBlockName(int program, int uniformBlockIndex);

public static native void glUniformBlockBinding(int program, int uniformBlockIndex, int uniformBlockBinding);

public static native void glDrawArraysInstanced(int mode, int first, int count, int instanceCount);

public static native void glDrawElementsInstanced(int mode, int count, int type, java.nio.Buffer indices, int instanceCount);

public static native void glDrawElementsInstanced(int mode, int count, int type, int indicesOffset, int instanceCount);

public static native long glFenceSync(int condition, int flags);

public static native boolean glIsSync(long sync);

public static native void glDeleteSync(long sync);

public static native int glClientWaitSync(long sync, int flags, long timeout);

public static native void glWaitSync(long sync, int flags, long timeout);

public static native void glGetInteger64v(int pname, long[] params, int offset);

public static native void glGetInteger64v(int pname, java.nio.LongBuffer params);

public static native void glGetSynciv(long sync, int pname, int bufSize, int[] length, int lengthOffset, int[] values, int valuesOffset);

public static native void glGetSynciv(long sync, int pname, int bufSize, java.nio.IntBuffer length, java.nio.IntBuffer values);

public static native void glGetInteger64i_v(int target, int index, long[] data, int offset);

public static native void glGetInteger64i_v(int target, int index, java.nio.LongBuffer data);

public static native void glGetBufferParameteri64v(int target, int pname, long[] params, int offset);

public static native void glGetBufferParameteri64v(int target, int pname, java.nio.LongBuffer params);

public static native void glGenSamplers(int count, int[] samplers, int offset);

public static native void glGenSamplers(int count, java.nio.IntBuffer samplers);

public static native void glDeleteSamplers(int count, int[] samplers, int offset);

public static native void glDeleteSamplers(int count, java.nio.IntBuffer samplers);

public static native boolean glIsSampler(int sampler);

public static native void glBindSampler(int unit, int sampler);

public static native void glSamplerParameteri(int sampler, int pname, int param);

public static native void glSamplerParameteriv(int sampler, int pname, int[] param, int offset);

public static native void glSamplerParameteriv(int sampler, int pname, java.nio.IntBuffer param);

public static native void glSamplerParameterf(int sampler, int pname, float param);

public static native void glSamplerParameterfv(int sampler, int pname, float[] param, int offset);

public static native void glSamplerParameterfv(int sampler, int pname, java.nio.FloatBuffer param);

public static native void glGetSamplerParameteriv(int sampler, int pname, int[] params, int offset);

public static native void glGetSamplerParameteriv(int sampler, int pname, java.nio.IntBuffer params);

public static native void glGetSamplerParameterfv(int sampler, int pname, float[] params, int offset);

public static native void glGetSamplerParameterfv(int sampler, int pname, java.nio.FloatBuffer params);

public static native void glVertexAttribDivisor(int index, int divisor);

public static native void glBindTransformFeedback(int target, int id);

public static native void glDeleteTransformFeedbacks(int n, int[] ids, int offset);

public static native void glDeleteTransformFeedbacks(int n, java.nio.IntBuffer ids);

public static native void glGenTransformFeedbacks(int n, int[] ids, int offset);

public static native void glGenTransformFeedbacks(int n, java.nio.IntBuffer ids);

public static native boolean glIsTransformFeedback(int id);

public static native void glPauseTransformFeedback();

public static native void glResumeTransformFeedback();

public static native void glGetProgramBinary(int program, int bufSize, int[] length, int lengthOffset, int[] binaryFormat, int binaryFormatOffset, java.nio.Buffer binary);

public static native void glGetProgramBinary(int program, int bufSize, java.nio.IntBuffer length, java.nio.IntBuffer binaryFormat, java.nio.Buffer binary);

public static native void glProgramBinary(int program, int binaryFormat, java.nio.Buffer binary, int length);

public static native void glProgramParameteri(int program, int pname, int value);

public static native void glInvalidateFramebuffer(int target, int numAttachments, int[] attachments, int offset);

public static native void glInvalidateFramebuffer(int target, int numAttachments, java.nio.IntBuffer attachments);

public static native void glInvalidateSubFramebuffer(int target, int numAttachments, int[] attachments, int offset, int x, int y, int width, int height);

public static native void glInvalidateSubFramebuffer(int target, int numAttachments, java.nio.IntBuffer attachments, int x, int y, int width, int height);

public static native void glTexStorage2D(int target, int levels, int internalformat, int width, int height);

public static native void glTexStorage3D(int target, int levels, int internalformat, int width, int height, int depth);

public static native void glGetInternalformativ(int target, int internalformat, int pname, int bufSize, int[] params, int offset);

public static native void glGetInternalformativ(int target, int internalformat, int pname, int bufSize, java.nio.IntBuffer params);

public static native void glReadPixels(int x, int y, int width, int height, int format, int type, int offset);

public static final int GL_ACTIVE_UNIFORM_BLOCKS = 35382; // 0x8a36

public static final int GL_ACTIVE_UNIFORM_BLOCK_MAX_NAME_LENGTH = 35381; // 0x8a35

public static final int GL_ALREADY_SIGNALED = 37146; // 0x911a

public static final int GL_ANY_SAMPLES_PASSED = 35887; // 0x8c2f

public static final int GL_ANY_SAMPLES_PASSED_CONSERVATIVE = 36202; // 0x8d6a

public static final int GL_BLUE = 6405; // 0x1905

public static final int GL_BUFFER_ACCESS_FLAGS = 37151; // 0x911f

public static final int GL_BUFFER_MAPPED = 35004; // 0x88bc

public static final int GL_BUFFER_MAP_LENGTH = 37152; // 0x9120

public static final int GL_BUFFER_MAP_OFFSET = 37153; // 0x9121

public static final int GL_BUFFER_MAP_POINTER = 35005; // 0x88bd

public static final int GL_COLOR = 6144; // 0x1800

public static final int GL_COLOR_ATTACHMENT1 = 36065; // 0x8ce1

public static final int GL_COLOR_ATTACHMENT10 = 36074; // 0x8cea

public static final int GL_COLOR_ATTACHMENT11 = 36075; // 0x8ceb

public static final int GL_COLOR_ATTACHMENT12 = 36076; // 0x8cec

public static final int GL_COLOR_ATTACHMENT13 = 36077; // 0x8ced

public static final int GL_COLOR_ATTACHMENT14 = 36078; // 0x8cee

public static final int GL_COLOR_ATTACHMENT15 = 36079; // 0x8cef

public static final int GL_COLOR_ATTACHMENT2 = 36066; // 0x8ce2

public static final int GL_COLOR_ATTACHMENT3 = 36067; // 0x8ce3

public static final int GL_COLOR_ATTACHMENT4 = 36068; // 0x8ce4

public static final int GL_COLOR_ATTACHMENT5 = 36069; // 0x8ce5

public static final int GL_COLOR_ATTACHMENT6 = 36070; // 0x8ce6

public static final int GL_COLOR_ATTACHMENT7 = 36071; // 0x8ce7

public static final int GL_COLOR_ATTACHMENT8 = 36072; // 0x8ce8

public static final int GL_COLOR_ATTACHMENT9 = 36073; // 0x8ce9

public static final int GL_COMPARE_REF_TO_TEXTURE = 34894; // 0x884e

public static final int GL_COMPRESSED_R11_EAC = 37488; // 0x9270

public static final int GL_COMPRESSED_RG11_EAC = 37490; // 0x9272

public static final int GL_COMPRESSED_RGB8_ETC2 = 37492; // 0x9274

public static final int GL_COMPRESSED_RGB8_PUNCHTHROUGH_ALPHA1_ETC2 = 37494; // 0x9276

public static final int GL_COMPRESSED_RGBA8_ETC2_EAC = 37496; // 0x9278

public static final int GL_COMPRESSED_SIGNED_R11_EAC = 37489; // 0x9271

public static final int GL_COMPRESSED_SIGNED_RG11_EAC = 37491; // 0x9273

public static final int GL_COMPRESSED_SRGB8_ALPHA8_ETC2_EAC = 37497; // 0x9279

public static final int GL_COMPRESSED_SRGB8_ETC2 = 37493; // 0x9275

public static final int GL_COMPRESSED_SRGB8_PUNCHTHROUGH_ALPHA1_ETC2 = 37495; // 0x9277

public static final int GL_CONDITION_SATISFIED = 37148; // 0x911c

public static final int GL_COPY_READ_BUFFER = 36662; // 0x8f36

public static final int GL_COPY_READ_BUFFER_BINDING = 36662; // 0x8f36

public static final int GL_COPY_WRITE_BUFFER = 36663; // 0x8f37

public static final int GL_COPY_WRITE_BUFFER_BINDING = 36663; // 0x8f37

public static final int GL_CURRENT_QUERY = 34917; // 0x8865

public static final int GL_DEPTH = 6145; // 0x1801

public static final int GL_DEPTH24_STENCIL8 = 35056; // 0x88f0

public static final int GL_DEPTH32F_STENCIL8 = 36013; // 0x8cad

public static final int GL_DEPTH_COMPONENT24 = 33190; // 0x81a6

public static final int GL_DEPTH_COMPONENT32F = 36012; // 0x8cac

public static final int GL_DEPTH_STENCIL = 34041; // 0x84f9

public static final int GL_DEPTH_STENCIL_ATTACHMENT = 33306; // 0x821a

public static final int GL_DRAW_BUFFER0 = 34853; // 0x8825

public static final int GL_DRAW_BUFFER1 = 34854; // 0x8826

public static final int GL_DRAW_BUFFER10 = 34863; // 0x882f

public static final int GL_DRAW_BUFFER11 = 34864; // 0x8830

public static final int GL_DRAW_BUFFER12 = 34865; // 0x8831

public static final int GL_DRAW_BUFFER13 = 34866; // 0x8832

public static final int GL_DRAW_BUFFER14 = 34867; // 0x8833

public static final int GL_DRAW_BUFFER15 = 34868; // 0x8834

public static final int GL_DRAW_BUFFER2 = 34855; // 0x8827

public static final int GL_DRAW_BUFFER3 = 34856; // 0x8828

public static final int GL_DRAW_BUFFER4 = 34857; // 0x8829

public static final int GL_DRAW_BUFFER5 = 34858; // 0x882a

public static final int GL_DRAW_BUFFER6 = 34859; // 0x882b

public static final int GL_DRAW_BUFFER7 = 34860; // 0x882c

public static final int GL_DRAW_BUFFER8 = 34861; // 0x882d

public static final int GL_DRAW_BUFFER9 = 34862; // 0x882e

public static final int GL_DRAW_FRAMEBUFFER = 36009; // 0x8ca9

public static final int GL_DRAW_FRAMEBUFFER_BINDING = 36006; // 0x8ca6

public static final int GL_DYNAMIC_COPY = 35050; // 0x88ea

public static final int GL_DYNAMIC_READ = 35049; // 0x88e9

public static final int GL_FLOAT_32_UNSIGNED_INT_24_8_REV = 36269; // 0x8dad

public static final int GL_FLOAT_MAT2x3 = 35685; // 0x8b65

public static final int GL_FLOAT_MAT2x4 = 35686; // 0x8b66

public static final int GL_FLOAT_MAT3x2 = 35687; // 0x8b67

public static final int GL_FLOAT_MAT3x4 = 35688; // 0x8b68

public static final int GL_FLOAT_MAT4x2 = 35689; // 0x8b69

public static final int GL_FLOAT_MAT4x3 = 35690; // 0x8b6a

public static final int GL_FRAGMENT_SHADER_DERIVATIVE_HINT = 35723; // 0x8b8b

public static final int GL_FRAMEBUFFER_ATTACHMENT_ALPHA_SIZE = 33301; // 0x8215

public static final int GL_FRAMEBUFFER_ATTACHMENT_BLUE_SIZE = 33300; // 0x8214

public static final int GL_FRAMEBUFFER_ATTACHMENT_COLOR_ENCODING = 33296; // 0x8210

public static final int GL_FRAMEBUFFER_ATTACHMENT_COMPONENT_TYPE = 33297; // 0x8211

public static final int GL_FRAMEBUFFER_ATTACHMENT_DEPTH_SIZE = 33302; // 0x8216

public static final int GL_FRAMEBUFFER_ATTACHMENT_GREEN_SIZE = 33299; // 0x8213

public static final int GL_FRAMEBUFFER_ATTACHMENT_RED_SIZE = 33298; // 0x8212

public static final int GL_FRAMEBUFFER_ATTACHMENT_STENCIL_SIZE = 33303; // 0x8217

public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LAYER = 36052; // 0x8cd4

public static final int GL_FRAMEBUFFER_DEFAULT = 33304; // 0x8218

public static final int GL_FRAMEBUFFER_INCOMPLETE_MULTISAMPLE = 36182; // 0x8d56

public static final int GL_FRAMEBUFFER_UNDEFINED = 33305; // 0x8219

public static final int GL_GREEN = 6404; // 0x1904

public static final int GL_HALF_FLOAT = 5131; // 0x140b

public static final int GL_INTERLEAVED_ATTRIBS = 35980; // 0x8c8c

public static final int GL_INT_2_10_10_10_REV = 36255; // 0x8d9f

public static final int GL_INT_SAMPLER_2D = 36298; // 0x8dca

public static final int GL_INT_SAMPLER_2D_ARRAY = 36303; // 0x8dcf

public static final int GL_INT_SAMPLER_3D = 36299; // 0x8dcb

public static final int GL_INT_SAMPLER_CUBE = 36300; // 0x8dcc

public static final int GL_INVALID_INDEX = -1; // 0xffffffff

public static final int GL_MAJOR_VERSION = 33307; // 0x821b

public static final int GL_MAP_FLUSH_EXPLICIT_BIT = 16; // 0x10

public static final int GL_MAP_INVALIDATE_BUFFER_BIT = 8; // 0x8

public static final int GL_MAP_INVALIDATE_RANGE_BIT = 4; // 0x4

public static final int GL_MAP_READ_BIT = 1; // 0x1

public static final int GL_MAP_UNSYNCHRONIZED_BIT = 32; // 0x20

public static final int GL_MAP_WRITE_BIT = 2; // 0x2

public static final int GL_MAX = 32776; // 0x8008

public static final int GL_MAX_3D_TEXTURE_SIZE = 32883; // 0x8073

public static final int GL_MAX_ARRAY_TEXTURE_LAYERS = 35071; // 0x88ff

public static final int GL_MAX_COLOR_ATTACHMENTS = 36063; // 0x8cdf

public static final int GL_MAX_COMBINED_FRAGMENT_UNIFORM_COMPONENTS = 35379; // 0x8a33

public static final int GL_MAX_COMBINED_UNIFORM_BLOCKS = 35374; // 0x8a2e

public static final int GL_MAX_COMBINED_VERTEX_UNIFORM_COMPONENTS = 35377; // 0x8a31

public static final int GL_MAX_DRAW_BUFFERS = 34852; // 0x8824

public static final int GL_MAX_ELEMENTS_INDICES = 33001; // 0x80e9

public static final int GL_MAX_ELEMENTS_VERTICES = 33000; // 0x80e8

public static final int GL_MAX_ELEMENT_INDEX = 36203; // 0x8d6b

public static final int GL_MAX_FRAGMENT_INPUT_COMPONENTS = 37157; // 0x9125

public static final int GL_MAX_FRAGMENT_UNIFORM_BLOCKS = 35373; // 0x8a2d

public static final int GL_MAX_FRAGMENT_UNIFORM_COMPONENTS = 35657; // 0x8b49

public static final int GL_MAX_PROGRAM_TEXEL_OFFSET = 35077; // 0x8905

public static final int GL_MAX_SAMPLES = 36183; // 0x8d57

public static final int GL_MAX_SERVER_WAIT_TIMEOUT = 37137; // 0x9111

public static final int GL_MAX_TEXTURE_LOD_BIAS = 34045; // 0x84fd

public static final int GL_MAX_TRANSFORM_FEEDBACK_INTERLEAVED_COMPONENTS = 35978; // 0x8c8a

public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_ATTRIBS = 35979; // 0x8c8b

public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_COMPONENTS = 35968; // 0x8c80

public static final int GL_MAX_UNIFORM_BLOCK_SIZE = 35376; // 0x8a30

public static final int GL_MAX_UNIFORM_BUFFER_BINDINGS = 35375; // 0x8a2f

public static final int GL_MAX_VARYING_COMPONENTS = 35659; // 0x8b4b

public static final int GL_MAX_VERTEX_OUTPUT_COMPONENTS = 37154; // 0x9122

public static final int GL_MAX_VERTEX_UNIFORM_BLOCKS = 35371; // 0x8a2b

public static final int GL_MAX_VERTEX_UNIFORM_COMPONENTS = 35658; // 0x8b4a

public static final int GL_MIN = 32775; // 0x8007

public static final int GL_MINOR_VERSION = 33308; // 0x821c

public static final int GL_MIN_PROGRAM_TEXEL_OFFSET = 35076; // 0x8904

public static final int GL_NUM_EXTENSIONS = 33309; // 0x821d

public static final int GL_NUM_PROGRAM_BINARY_FORMATS = 34814; // 0x87fe

public static final int GL_NUM_SAMPLE_COUNTS = 37760; // 0x9380

public static final int GL_OBJECT_TYPE = 37138; // 0x9112

public static final int GL_PACK_ROW_LENGTH = 3330; // 0xd02

public static final int GL_PACK_SKIP_PIXELS = 3332; // 0xd04

public static final int GL_PACK_SKIP_ROWS = 3331; // 0xd03

public static final int GL_PIXEL_PACK_BUFFER = 35051; // 0x88eb

public static final int GL_PIXEL_PACK_BUFFER_BINDING = 35053; // 0x88ed

public static final int GL_PIXEL_UNPACK_BUFFER = 35052; // 0x88ec

public static final int GL_PIXEL_UNPACK_BUFFER_BINDING = 35055; // 0x88ef

public static final int GL_PRIMITIVE_RESTART_FIXED_INDEX = 36201; // 0x8d69

public static final int GL_PROGRAM_BINARY_FORMATS = 34815; // 0x87ff

public static final int GL_PROGRAM_BINARY_LENGTH = 34625; // 0x8741

public static final int GL_PROGRAM_BINARY_RETRIEVABLE_HINT = 33367; // 0x8257

public static final int GL_QUERY_RESULT = 34918; // 0x8866

public static final int GL_QUERY_RESULT_AVAILABLE = 34919; // 0x8867

public static final int GL_R11F_G11F_B10F = 35898; // 0x8c3a

public static final int GL_R16F = 33325; // 0x822d

public static final int GL_R16I = 33331; // 0x8233

public static final int GL_R16UI = 33332; // 0x8234

public static final int GL_R32F = 33326; // 0x822e

public static final int GL_R32I = 33333; // 0x8235

public static final int GL_R32UI = 33334; // 0x8236

public static final int GL_R8 = 33321; // 0x8229

public static final int GL_R8I = 33329; // 0x8231

public static final int GL_R8UI = 33330; // 0x8232

public static final int GL_R8_SNORM = 36756; // 0x8f94

public static final int GL_RASTERIZER_DISCARD = 35977; // 0x8c89

public static final int GL_READ_BUFFER = 3074; // 0xc02

public static final int GL_READ_FRAMEBUFFER = 36008; // 0x8ca8

public static final int GL_READ_FRAMEBUFFER_BINDING = 36010; // 0x8caa

public static final int GL_RED = 6403; // 0x1903

public static final int GL_RED_INTEGER = 36244; // 0x8d94

public static final int GL_RENDERBUFFER_SAMPLES = 36011; // 0x8cab

public static final int GL_RG = 33319; // 0x8227

public static final int GL_RG16F = 33327; // 0x822f

public static final int GL_RG16I = 33337; // 0x8239

public static final int GL_RG16UI = 33338; // 0x823a

public static final int GL_RG32F = 33328; // 0x8230

public static final int GL_RG32I = 33339; // 0x823b

public static final int GL_RG32UI = 33340; // 0x823c

public static final int GL_RG8 = 33323; // 0x822b

public static final int GL_RG8I = 33335; // 0x8237

public static final int GL_RG8UI = 33336; // 0x8238

public static final int GL_RG8_SNORM = 36757; // 0x8f95

public static final int GL_RGB10_A2 = 32857; // 0x8059

public static final int GL_RGB10_A2UI = 36975; // 0x906f

public static final int GL_RGB16F = 34843; // 0x881b

public static final int GL_RGB16I = 36233; // 0x8d89

public static final int GL_RGB16UI = 36215; // 0x8d77

public static final int GL_RGB32F = 34837; // 0x8815

public static final int GL_RGB32I = 36227; // 0x8d83

public static final int GL_RGB32UI = 36209; // 0x8d71

public static final int GL_RGB8 = 32849; // 0x8051

public static final int GL_RGB8I = 36239; // 0x8d8f

public static final int GL_RGB8UI = 36221; // 0x8d7d

public static final int GL_RGB8_SNORM = 36758; // 0x8f96

public static final int GL_RGB9_E5 = 35901; // 0x8c3d

public static final int GL_RGBA16F = 34842; // 0x881a

public static final int GL_RGBA16I = 36232; // 0x8d88

public static final int GL_RGBA16UI = 36214; // 0x8d76

public static final int GL_RGBA32F = 34836; // 0x8814

public static final int GL_RGBA32I = 36226; // 0x8d82

public static final int GL_RGBA32UI = 36208; // 0x8d70

public static final int GL_RGBA8 = 32856; // 0x8058

public static final int GL_RGBA8I = 36238; // 0x8d8e

public static final int GL_RGBA8UI = 36220; // 0x8d7c

public static final int GL_RGBA8_SNORM = 36759; // 0x8f97

public static final int GL_RGBA_INTEGER = 36249; // 0x8d99

public static final int GL_RGB_INTEGER = 36248; // 0x8d98

public static final int GL_RG_INTEGER = 33320; // 0x8228

public static final int GL_SAMPLER_2D_ARRAY = 36289; // 0x8dc1

public static final int GL_SAMPLER_2D_ARRAY_SHADOW = 36292; // 0x8dc4

public static final int GL_SAMPLER_2D_SHADOW = 35682; // 0x8b62

public static final int GL_SAMPLER_3D = 35679; // 0x8b5f

public static final int GL_SAMPLER_BINDING = 35097; // 0x8919

public static final int GL_SAMPLER_CUBE_SHADOW = 36293; // 0x8dc5

public static final int GL_SEPARATE_ATTRIBS = 35981; // 0x8c8d

public static final int GL_SIGNALED = 37145; // 0x9119

public static final int GL_SIGNED_NORMALIZED = 36764; // 0x8f9c

public static final int GL_SRGB = 35904; // 0x8c40

public static final int GL_SRGB8 = 35905; // 0x8c41

public static final int GL_SRGB8_ALPHA8 = 35907; // 0x8c43

public static final int GL_STATIC_COPY = 35046; // 0x88e6

public static final int GL_STATIC_READ = 35045; // 0x88e5

public static final int GL_STENCIL = 6146; // 0x1802

public static final int GL_STREAM_COPY = 35042; // 0x88e2

public static final int GL_STREAM_READ = 35041; // 0x88e1

public static final int GL_SYNC_CONDITION = 37139; // 0x9113

public static final int GL_SYNC_FENCE = 37142; // 0x9116

public static final int GL_SYNC_FLAGS = 37141; // 0x9115

public static final int GL_SYNC_FLUSH_COMMANDS_BIT = 1; // 0x1

public static final int GL_SYNC_GPU_COMMANDS_COMPLETE = 37143; // 0x9117

public static final int GL_SYNC_STATUS = 37140; // 0x9114

public static final int GL_TEXTURE_2D_ARRAY = 35866; // 0x8c1a

public static final int GL_TEXTURE_3D = 32879; // 0x806f

public static final int GL_TEXTURE_BASE_LEVEL = 33084; // 0x813c

public static final int GL_TEXTURE_BINDING_2D_ARRAY = 35869; // 0x8c1d

public static final int GL_TEXTURE_BINDING_3D = 32874; // 0x806a

public static final int GL_TEXTURE_COMPARE_FUNC = 34893; // 0x884d

public static final int GL_TEXTURE_COMPARE_MODE = 34892; // 0x884c

public static final int GL_TEXTURE_IMMUTABLE_FORMAT = 37167; // 0x912f

public static final int GL_TEXTURE_IMMUTABLE_LEVELS = 33503; // 0x82df

public static final int GL_TEXTURE_MAX_LEVEL = 33085; // 0x813d

public static final int GL_TEXTURE_MAX_LOD = 33083; // 0x813b

public static final int GL_TEXTURE_MIN_LOD = 33082; // 0x813a

public static final int GL_TEXTURE_SWIZZLE_A = 36421; // 0x8e45

public static final int GL_TEXTURE_SWIZZLE_B = 36420; // 0x8e44

public static final int GL_TEXTURE_SWIZZLE_G = 36419; // 0x8e43

public static final int GL_TEXTURE_SWIZZLE_R = 36418; // 0x8e42

public static final int GL_TEXTURE_WRAP_R = 32882; // 0x8072

public static final int GL_TIMEOUT_EXPIRED = 37147; // 0x911b

public static final long GL_TIMEOUT_IGNORED = -1L; // 0xffffffffffffffffL

public static final int GL_TRANSFORM_FEEDBACK = 36386; // 0x8e22

public static final int GL_TRANSFORM_FEEDBACK_ACTIVE = 36388; // 0x8e24

public static final int GL_TRANSFORM_FEEDBACK_BINDING = 36389; // 0x8e25

public static final int GL_TRANSFORM_FEEDBACK_BUFFER = 35982; // 0x8c8e

public static final int GL_TRANSFORM_FEEDBACK_BUFFER_BINDING = 35983; // 0x8c8f

public static final int GL_TRANSFORM_FEEDBACK_BUFFER_MODE = 35967; // 0x8c7f

public static final int GL_TRANSFORM_FEEDBACK_BUFFER_SIZE = 35973; // 0x8c85

public static final int GL_TRANSFORM_FEEDBACK_BUFFER_START = 35972; // 0x8c84

public static final int GL_TRANSFORM_FEEDBACK_PAUSED = 36387; // 0x8e23

public static final int GL_TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN = 35976; // 0x8c88

public static final int GL_TRANSFORM_FEEDBACK_VARYINGS = 35971; // 0x8c83

public static final int GL_TRANSFORM_FEEDBACK_VARYING_MAX_LENGTH = 35958; // 0x8c76

public static final int GL_UNIFORM_ARRAY_STRIDE = 35388; // 0x8a3c

public static final int GL_UNIFORM_BLOCK_ACTIVE_UNIFORMS = 35394; // 0x8a42

public static final int GL_UNIFORM_BLOCK_ACTIVE_UNIFORM_INDICES = 35395; // 0x8a43

public static final int GL_UNIFORM_BLOCK_BINDING = 35391; // 0x8a3f

public static final int GL_UNIFORM_BLOCK_DATA_SIZE = 35392; // 0x8a40

public static final int GL_UNIFORM_BLOCK_INDEX = 35386; // 0x8a3a

public static final int GL_UNIFORM_BLOCK_NAME_LENGTH = 35393; // 0x8a41

public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_FRAGMENT_SHADER = 35398; // 0x8a46

public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_VERTEX_SHADER = 35396; // 0x8a44

public static final int GL_UNIFORM_BUFFER = 35345; // 0x8a11

public static final int GL_UNIFORM_BUFFER_BINDING = 35368; // 0x8a28

public static final int GL_UNIFORM_BUFFER_OFFSET_ALIGNMENT = 35380; // 0x8a34

public static final int GL_UNIFORM_BUFFER_SIZE = 35370; // 0x8a2a

public static final int GL_UNIFORM_BUFFER_START = 35369; // 0x8a29

public static final int GL_UNIFORM_IS_ROW_MAJOR = 35390; // 0x8a3e

public static final int GL_UNIFORM_MATRIX_STRIDE = 35389; // 0x8a3d

public static final int GL_UNIFORM_NAME_LENGTH = 35385; // 0x8a39

public static final int GL_UNIFORM_OFFSET = 35387; // 0x8a3b

public static final int GL_UNIFORM_SIZE = 35384; // 0x8a38

public static final int GL_UNIFORM_TYPE = 35383; // 0x8a37

public static final int GL_UNPACK_IMAGE_HEIGHT = 32878; // 0x806e

public static final int GL_UNPACK_ROW_LENGTH = 3314; // 0xcf2

public static final int GL_UNPACK_SKIP_IMAGES = 32877; // 0x806d

public static final int GL_UNPACK_SKIP_PIXELS = 3316; // 0xcf4

public static final int GL_UNPACK_SKIP_ROWS = 3315; // 0xcf3

public static final int GL_UNSIGNALED = 37144; // 0x9118

public static final int GL_UNSIGNED_INT_10F_11F_11F_REV = 35899; // 0x8c3b

public static final int GL_UNSIGNED_INT_24_8 = 34042; // 0x84fa

public static final int GL_UNSIGNED_INT_2_10_10_10_REV = 33640; // 0x8368

public static final int GL_UNSIGNED_INT_5_9_9_9_REV = 35902; // 0x8c3e

public static final int GL_UNSIGNED_INT_SAMPLER_2D = 36306; // 0x8dd2

public static final int GL_UNSIGNED_INT_SAMPLER_2D_ARRAY = 36311; // 0x8dd7

public static final int GL_UNSIGNED_INT_SAMPLER_3D = 36307; // 0x8dd3

public static final int GL_UNSIGNED_INT_SAMPLER_CUBE = 36308; // 0x8dd4

public static final int GL_UNSIGNED_INT_VEC2 = 36294; // 0x8dc6

public static final int GL_UNSIGNED_INT_VEC3 = 36295; // 0x8dc7

public static final int GL_UNSIGNED_INT_VEC4 = 36296; // 0x8dc8

public static final int GL_UNSIGNED_NORMALIZED = 35863; // 0x8c17

public static final int GL_VERTEX_ARRAY_BINDING = 34229; // 0x85b5

public static final int GL_VERTEX_ATTRIB_ARRAY_DIVISOR = 35070; // 0x88fe

public static final int GL_VERTEX_ATTRIB_ARRAY_INTEGER = 35069; // 0x88fd

public static final int GL_WAIT_FAILED = 37149; // 0x911d
}

