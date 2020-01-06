/* //device/java/android/javax/microedition/khronos/opengles/GL11.java
**
** Copyright 2006, The Android Open Source Project
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
public interface GL11 extends javax.microedition.khronos.opengles.GL10 {

public void glGetPointerv(int pname, java.nio.Buffer[] params);

public void glBindBuffer(int target, int buffer);

public void glBufferData(int target, int size, java.nio.Buffer data, int usage);

public void glBufferSubData(int target, int offset, int size, java.nio.Buffer data);

public void glClipPlanef(int plane, float[] equation, int offset);

public void glClipPlanef(int plane, java.nio.FloatBuffer equation);

public void glClipPlanex(int plane, int[] equation, int offset);

public void glClipPlanex(int plane, java.nio.IntBuffer equation);

public void glColor4ub(byte red, byte green, byte blue, byte alpha);

public void glColorPointer(int size, int type, int stride, int offset);

public void glDeleteBuffers(int n, int[] buffers, int offset);

public void glDeleteBuffers(int n, java.nio.IntBuffer buffers);

public void glDrawElements(int mode, int count, int type, int offset);

public void glGenBuffers(int n, int[] buffers, int offset);

public void glGenBuffers(int n, java.nio.IntBuffer buffers);

public void glGetBooleanv(int pname, boolean[] params, int offset);

public void glGetBooleanv(int pname, java.nio.IntBuffer params);

public void glGetBufferParameteriv(int target, int pname, int[] params, int offset);

public void glGetBufferParameteriv(int target, int pname, java.nio.IntBuffer params);

public void glGetClipPlanef(int pname, float[] eqn, int offset);

public void glGetClipPlanef(int pname, java.nio.FloatBuffer eqn);

public void glGetClipPlanex(int pname, int[] eqn, int offset);

public void glGetClipPlanex(int pname, java.nio.IntBuffer eqn);

public void glGetFixedv(int pname, int[] params, int offset);

public void glGetFixedv(int pname, java.nio.IntBuffer params);

public void glGetFloatv(int pname, float[] params, int offset);

public void glGetFloatv(int pname, java.nio.FloatBuffer params);

public void glGetLightfv(int light, int pname, float[] params, int offset);

public void glGetLightfv(int light, int pname, java.nio.FloatBuffer params);

public void glGetLightxv(int light, int pname, int[] params, int offset);

public void glGetLightxv(int light, int pname, java.nio.IntBuffer params);

public void glGetMaterialfv(int face, int pname, float[] params, int offset);

public void glGetMaterialfv(int face, int pname, java.nio.FloatBuffer params);

public void glGetMaterialxv(int face, int pname, int[] params, int offset);

public void glGetMaterialxv(int face, int pname, java.nio.IntBuffer params);

public void glGetTexEnviv(int env, int pname, int[] params, int offset);

public void glGetTexEnviv(int env, int pname, java.nio.IntBuffer params);

public void glGetTexEnvxv(int env, int pname, int[] params, int offset);

public void glGetTexEnvxv(int env, int pname, java.nio.IntBuffer params);

public void glGetTexParameterfv(int target, int pname, float[] params, int offset);

public void glGetTexParameterfv(int target, int pname, java.nio.FloatBuffer params);

public void glGetTexParameteriv(int target, int pname, int[] params, int offset);

public void glGetTexParameteriv(int target, int pname, java.nio.IntBuffer params);

public void glGetTexParameterxv(int target, int pname, int[] params, int offset);

public void glGetTexParameterxv(int target, int pname, java.nio.IntBuffer params);

public boolean glIsBuffer(int buffer);

public boolean glIsEnabled(int cap);

public boolean glIsTexture(int texture);

public void glNormalPointer(int type, int stride, int offset);

public void glPointParameterf(int pname, float param);

public void glPointParameterfv(int pname, float[] params, int offset);

public void glPointParameterfv(int pname, java.nio.FloatBuffer params);

public void glPointParameterx(int pname, int param);

public void glPointParameterxv(int pname, int[] params, int offset);

public void glPointParameterxv(int pname, java.nio.IntBuffer params);

public void glPointSizePointerOES(int type, int stride, java.nio.Buffer pointer);

public void glTexCoordPointer(int size, int type, int stride, int offset);

public void glTexEnvi(int target, int pname, int param);

public void glTexEnviv(int target, int pname, int[] params, int offset);

public void glTexEnviv(int target, int pname, java.nio.IntBuffer params);

public void glTexParameterfv(int target, int pname, float[] params, int offset);

public void glTexParameterfv(int target, int pname, java.nio.FloatBuffer params);

public void glTexParameteri(int target, int pname, int param);

public void glTexParameteriv(int target, int pname, int[] params, int offset);

public void glTexParameteriv(int target, int pname, java.nio.IntBuffer params);

public void glTexParameterxv(int target, int pname, int[] params, int offset);

public void glTexParameterxv(int target, int pname, java.nio.IntBuffer params);

public void glVertexPointer(int size, int type, int stride, int offset);

public static final int GL_ACTIVE_TEXTURE = 34016; // 0x84e0

public static final int GL_ADD_SIGNED = 34164; // 0x8574

public static final int GL_ALPHA_SCALE = 3356; // 0xd1c

public static final int GL_ALPHA_TEST_FUNC = 3009; // 0xbc1

public static final int GL_ALPHA_TEST_REF = 3010; // 0xbc2

public static final int GL_ARRAY_BUFFER = 34962; // 0x8892

public static final int GL_ARRAY_BUFFER_BINDING = 34964; // 0x8894

public static final int GL_BLEND_DST = 3040; // 0xbe0

public static final int GL_BLEND_SRC = 3041; // 0xbe1

public static final int GL_BUFFER_ACCESS = 35003; // 0x88bb

public static final int GL_BUFFER_SIZE = 34660; // 0x8764

public static final int GL_BUFFER_USAGE = 34661; // 0x8765

public static final int GL_CLIENT_ACTIVE_TEXTURE = 34017; // 0x84e1

public static final int GL_CLIP_PLANE0 = 12288; // 0x3000

public static final int GL_CLIP_PLANE1 = 12289; // 0x3001

public static final int GL_CLIP_PLANE2 = 12290; // 0x3002

public static final int GL_CLIP_PLANE3 = 12291; // 0x3003

public static final int GL_CLIP_PLANE4 = 12292; // 0x3004

public static final int GL_CLIP_PLANE5 = 12293; // 0x3005

public static final int GL_COLOR_ARRAY_BUFFER_BINDING = 34968; // 0x8898

public static final int GL_COLOR_ARRAY_POINTER = 32912; // 0x8090

public static final int GL_COLOR_ARRAY_SIZE = 32897; // 0x8081

public static final int GL_COLOR_ARRAY_STRIDE = 32899; // 0x8083

public static final int GL_COLOR_ARRAY_TYPE = 32898; // 0x8082

public static final int GL_COLOR_CLEAR_VALUE = 3106; // 0xc22

public static final int GL_COLOR_WRITEMASK = 3107; // 0xc23

public static final int GL_COMBINE = 34160; // 0x8570

public static final int GL_COMBINE_ALPHA = 34162; // 0x8572

public static final int GL_COMBINE_RGB = 34161; // 0x8571

public static final int GL_CONSTANT = 34166; // 0x8576

public static final int GL_COORD_REPLACE_OES = 34914; // 0x8862

public static final int GL_CULL_FACE_MODE = 2885; // 0xb45

public static final int GL_CURRENT_COLOR = 2816; // 0xb00

public static final int GL_CURRENT_NORMAL = 2818; // 0xb02

public static final int GL_CURRENT_TEXTURE_COORDS = 2819; // 0xb03

public static final int GL_DEPTH_CLEAR_VALUE = 2931; // 0xb73

public static final int GL_DEPTH_FUNC = 2932; // 0xb74

public static final int GL_DEPTH_RANGE = 2928; // 0xb70

public static final int GL_DEPTH_WRITEMASK = 2930; // 0xb72

public static final int GL_DOT3_RGB = 34478; // 0x86ae

public static final int GL_DOT3_RGBA = 34479; // 0x86af

public static final int GL_DYNAMIC_DRAW = 35048; // 0x88e8

public static final int GL_ELEMENT_ARRAY_BUFFER = 34963; // 0x8893

public static final int GL_ELEMENT_ARRAY_BUFFER_BINDING = 34965; // 0x8895

public static final int GL_FRONT_FACE = 2886; // 0xb46

public static final int GL_GENERATE_MIPMAP = 33169; // 0x8191

public static final int GL_GENERATE_MIPMAP_HINT = 33170; // 0x8192

public static final int GL_INTERPOLATE = 34165; // 0x8575

public static final int GL_LINE_WIDTH = 2849; // 0xb21

public static final int GL_LOGIC_OP_MODE = 3056; // 0xbf0

public static final int GL_MATRIX_MODE = 2976; // 0xba0

public static final int GL_MAX_CLIP_PLANES = 3378; // 0xd32

public static final int GL_MODELVIEW_MATRIX = 2982; // 0xba6

public static final int GL_MODELVIEW_MATRIX_FLOAT_AS_INT_BITS_OES = 35213; // 0x898d

public static final int GL_MODELVIEW_STACK_DEPTH = 2979; // 0xba3

public static final int GL_NORMAL_ARRAY_BUFFER_BINDING = 34967; // 0x8897

public static final int GL_NORMAL_ARRAY_POINTER = 32911; // 0x808f

public static final int GL_NORMAL_ARRAY_STRIDE = 32895; // 0x807f

public static final int GL_NORMAL_ARRAY_TYPE = 32894; // 0x807e

public static final int GL_OPERAND0_ALPHA = 34200; // 0x8598

public static final int GL_OPERAND0_RGB = 34192; // 0x8590

public static final int GL_OPERAND1_ALPHA = 34201; // 0x8599

public static final int GL_OPERAND1_RGB = 34193; // 0x8591

public static final int GL_OPERAND2_ALPHA = 34202; // 0x859a

public static final int GL_OPERAND2_RGB = 34194; // 0x8592

public static final int GL_POINT_DISTANCE_ATTENUATION = 33065; // 0x8129

public static final int GL_POINT_FADE_THRESHOLD_SIZE = 33064; // 0x8128

public static final int GL_POINT_SIZE = 2833; // 0xb11

public static final int GL_POINT_SIZE_ARRAY_BUFFER_BINDING_OES = 35743; // 0x8b9f

public static final int GL_POINT_SIZE_ARRAY_OES = 35740; // 0x8b9c

public static final int GL_POINT_SIZE_ARRAY_POINTER_OES = 35212; // 0x898c

public static final int GL_POINT_SIZE_ARRAY_STRIDE_OES = 35211; // 0x898b

public static final int GL_POINT_SIZE_ARRAY_TYPE_OES = 35210; // 0x898a

public static final int GL_POINT_SIZE_MAX = 33063; // 0x8127

public static final int GL_POINT_SIZE_MIN = 33062; // 0x8126

public static final int GL_POINT_SPRITE_OES = 34913; // 0x8861

public static final int GL_POLYGON_OFFSET_FACTOR = 32824; // 0x8038

public static final int GL_POLYGON_OFFSET_UNITS = 10752; // 0x2a00

public static final int GL_PREVIOUS = 34168; // 0x8578

public static final int GL_PRIMARY_COLOR = 34167; // 0x8577

public static final int GL_PROJECTION_MATRIX = 2983; // 0xba7

public static final int GL_PROJECTION_MATRIX_FLOAT_AS_INT_BITS_OES = 35214; // 0x898e

public static final int GL_PROJECTION_STACK_DEPTH = 2980; // 0xba4

public static final int GL_RGB_SCALE = 34163; // 0x8573

public static final int GL_SAMPLES = 32937; // 0x80a9

public static final int GL_SAMPLE_BUFFERS = 32936; // 0x80a8

public static final int GL_SAMPLE_COVERAGE_INVERT = 32939; // 0x80ab

public static final int GL_SAMPLE_COVERAGE_VALUE = 32938; // 0x80aa

public static final int GL_SCISSOR_BOX = 3088; // 0xc10

public static final int GL_SHADE_MODEL = 2900; // 0xb54

public static final int GL_SRC0_ALPHA = 34184; // 0x8588

public static final int GL_SRC0_RGB = 34176; // 0x8580

public static final int GL_SRC1_ALPHA = 34185; // 0x8589

public static final int GL_SRC1_RGB = 34177; // 0x8581

public static final int GL_SRC2_ALPHA = 34186; // 0x858a

public static final int GL_SRC2_RGB = 34178; // 0x8582

public static final int GL_STATIC_DRAW = 35044; // 0x88e4

public static final int GL_STENCIL_CLEAR_VALUE = 2961; // 0xb91

public static final int GL_STENCIL_FAIL = 2964; // 0xb94

public static final int GL_STENCIL_FUNC = 2962; // 0xb92

public static final int GL_STENCIL_PASS_DEPTH_FAIL = 2965; // 0xb95

public static final int GL_STENCIL_PASS_DEPTH_PASS = 2966; // 0xb96

public static final int GL_STENCIL_REF = 2967; // 0xb97

public static final int GL_STENCIL_VALUE_MASK = 2963; // 0xb93

public static final int GL_STENCIL_WRITEMASK = 2968; // 0xb98

public static final int GL_SUBTRACT = 34023; // 0x84e7

public static final int GL_TEXTURE_BINDING_2D = 32873; // 0x8069

public static final int GL_TEXTURE_COORD_ARRAY_BUFFER_BINDING = 34970; // 0x889a

public static final int GL_TEXTURE_COORD_ARRAY_POINTER = 32914; // 0x8092

public static final int GL_TEXTURE_COORD_ARRAY_SIZE = 32904; // 0x8088

public static final int GL_TEXTURE_COORD_ARRAY_STRIDE = 32906; // 0x808a

public static final int GL_TEXTURE_COORD_ARRAY_TYPE = 32905; // 0x8089

public static final int GL_TEXTURE_MATRIX = 2984; // 0xba8

public static final int GL_TEXTURE_MATRIX_FLOAT_AS_INT_BITS_OES = 35215; // 0x898f

public static final int GL_TEXTURE_STACK_DEPTH = 2981; // 0xba5

public static final int GL_VERTEX_ARRAY_BUFFER_BINDING = 34966; // 0x8896

public static final int GL_VERTEX_ARRAY_POINTER = 32910; // 0x808e

public static final int GL_VERTEX_ARRAY_SIZE = 32890; // 0x807a

public static final int GL_VERTEX_ARRAY_STRIDE = 32892; // 0x807c

public static final int GL_VERTEX_ARRAY_TYPE = 32891; // 0x807b

public static final int GL_VIEWPORT = 2978; // 0xba2

public static final int GL_WRITE_ONLY = 35001; // 0x88b9
}

