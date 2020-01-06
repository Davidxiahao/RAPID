/* //device/java/android/javax/microedition/khronos/opengles/GL10.java
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
public interface GL10 extends javax.microedition.khronos.opengles.GL {

public void glActiveTexture(int texture);

public void glAlphaFunc(int func, float ref);

public void glAlphaFuncx(int func, int ref);

public void glBindTexture(int target, int texture);

public void glBlendFunc(int sfactor, int dfactor);

public void glClear(int mask);

public void glClearColor(float red, float green, float blue, float alpha);

public void glClearColorx(int red, int green, int blue, int alpha);

public void glClearDepthf(float depth);

public void glClearDepthx(int depth);

public void glClearStencil(int s);

public void glClientActiveTexture(int texture);

public void glColor4f(float red, float green, float blue, float alpha);

public void glColor4x(int red, int green, int blue, int alpha);

public void glColorMask(boolean red, boolean green, boolean blue, boolean alpha);

public void glColorPointer(int size, int type, int stride, java.nio.Buffer pointer);

public void glCompressedTexImage2D(int target, int level, int internalformat, int width, int height, int border, int imageSize, java.nio.Buffer data);

public void glCompressedTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, java.nio.Buffer data);

public void glCopyTexImage2D(int target, int level, int internalformat, int x, int y, int width, int height, int border);

public void glCopyTexSubImage2D(int target, int level, int xoffset, int yoffset, int x, int y, int width, int height);

public void glCullFace(int mode);

public void glDeleteTextures(int n, int[] textures, int offset);

public void glDeleteTextures(int n, java.nio.IntBuffer textures);

public void glDepthFunc(int func);

public void glDepthMask(boolean flag);

public void glDepthRangef(float zNear, float zFar);

public void glDepthRangex(int zNear, int zFar);

public void glDisable(int cap);

public void glDisableClientState(int array);

public void glDrawArrays(int mode, int first, int count);

public void glDrawElements(int mode, int count, int type, java.nio.Buffer indices);

public void glEnable(int cap);

public void glEnableClientState(int array);

public void glFinish();

public void glFlush();

public void glFogf(int pname, float param);

public void glFogfv(int pname, float[] params, int offset);

public void glFogfv(int pname, java.nio.FloatBuffer params);

public void glFogx(int pname, int param);

public void glFogxv(int pname, int[] params, int offset);

public void glFogxv(int pname, java.nio.IntBuffer params);

public void glFrontFace(int mode);

public void glFrustumf(float left, float right, float bottom, float top, float zNear, float zFar);

public void glFrustumx(int left, int right, int bottom, int top, int zNear, int zFar);

public void glGenTextures(int n, int[] textures, int offset);

public void glGenTextures(int n, java.nio.IntBuffer textures);

public int glGetError();

public void glGetIntegerv(int pname, int[] params, int offset);

public void glGetIntegerv(int pname, java.nio.IntBuffer params);

public java.lang.String glGetString(int name);

public void glHint(int target, int mode);

public void glLightModelf(int pname, float param);

public void glLightModelfv(int pname, float[] params, int offset);

public void glLightModelfv(int pname, java.nio.FloatBuffer params);

public void glLightModelx(int pname, int param);

public void glLightModelxv(int pname, int[] params, int offset);

public void glLightModelxv(int pname, java.nio.IntBuffer params);

public void glLightf(int light, int pname, float param);

public void glLightfv(int light, int pname, float[] params, int offset);

public void glLightfv(int light, int pname, java.nio.FloatBuffer params);

public void glLightx(int light, int pname, int param);

public void glLightxv(int light, int pname, int[] params, int offset);

public void glLightxv(int light, int pname, java.nio.IntBuffer params);

public void glLineWidth(float width);

public void glLineWidthx(int width);

public void glLoadIdentity();

public void glLoadMatrixf(float[] m, int offset);

public void glLoadMatrixf(java.nio.FloatBuffer m);

public void glLoadMatrixx(int[] m, int offset);

public void glLoadMatrixx(java.nio.IntBuffer m);

public void glLogicOp(int opcode);

public void glMaterialf(int face, int pname, float param);

public void glMaterialfv(int face, int pname, float[] params, int offset);

public void glMaterialfv(int face, int pname, java.nio.FloatBuffer params);

public void glMaterialx(int face, int pname, int param);

public void glMaterialxv(int face, int pname, int[] params, int offset);

public void glMaterialxv(int face, int pname, java.nio.IntBuffer params);

public void glMatrixMode(int mode);

public void glMultMatrixf(float[] m, int offset);

public void glMultMatrixf(java.nio.FloatBuffer m);

public void glMultMatrixx(int[] m, int offset);

public void glMultMatrixx(java.nio.IntBuffer m);

public void glMultiTexCoord4f(int target, float s, float t, float r, float q);

public void glMultiTexCoord4x(int target, int s, int t, int r, int q);

public void glNormal3f(float nx, float ny, float nz);

public void glNormal3x(int nx, int ny, int nz);

public void glNormalPointer(int type, int stride, java.nio.Buffer pointer);

public void glOrthof(float left, float right, float bottom, float top, float zNear, float zFar);

public void glOrthox(int left, int right, int bottom, int top, int zNear, int zFar);

public void glPixelStorei(int pname, int param);

public void glPointSize(float size);

public void glPointSizex(int size);

public void glPolygonOffset(float factor, float units);

public void glPolygonOffsetx(int factor, int units);

public void glPopMatrix();

public void glPushMatrix();

public void glReadPixels(int x, int y, int width, int height, int format, int type, java.nio.Buffer pixels);

public void glRotatef(float angle, float x, float y, float z);

public void glRotatex(int angle, int x, int y, int z);

public void glSampleCoverage(float value, boolean invert);

public void glSampleCoveragex(int value, boolean invert);

public void glScalef(float x, float y, float z);

public void glScalex(int x, int y, int z);

public void glScissor(int x, int y, int width, int height);

public void glShadeModel(int mode);

public void glStencilFunc(int func, int ref, int mask);

public void glStencilMask(int mask);

public void glStencilOp(int fail, int zfail, int zpass);

public void glTexCoordPointer(int size, int type, int stride, java.nio.Buffer pointer);

public void glTexEnvf(int target, int pname, float param);

public void glTexEnvfv(int target, int pname, float[] params, int offset);

public void glTexEnvfv(int target, int pname, java.nio.FloatBuffer params);

public void glTexEnvx(int target, int pname, int param);

public void glTexEnvxv(int target, int pname, int[] params, int offset);

public void glTexEnvxv(int target, int pname, java.nio.IntBuffer params);

public void glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, java.nio.Buffer pixels);

public void glTexParameterf(int target, int pname, float param);

public void glTexParameterx(int target, int pname, int param);

public void glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, java.nio.Buffer pixels);

public void glTranslatef(float x, float y, float z);

public void glTranslatex(int x, int y, int z);

public void glVertexPointer(int size, int type, int stride, java.nio.Buffer pointer);

public void glViewport(int x, int y, int width, int height);

public static final int GL_ADD = 260; // 0x104

public static final int GL_ALIASED_LINE_WIDTH_RANGE = 33902; // 0x846e

public static final int GL_ALIASED_POINT_SIZE_RANGE = 33901; // 0x846d

public static final int GL_ALPHA = 6406; // 0x1906

public static final int GL_ALPHA_BITS = 3413; // 0xd55

public static final int GL_ALPHA_TEST = 3008; // 0xbc0

public static final int GL_ALWAYS = 519; // 0x207

public static final int GL_AMBIENT = 4608; // 0x1200

public static final int GL_AMBIENT_AND_DIFFUSE = 5634; // 0x1602

public static final int GL_AND = 5377; // 0x1501

public static final int GL_AND_INVERTED = 5380; // 0x1504

public static final int GL_AND_REVERSE = 5378; // 0x1502

public static final int GL_BACK = 1029; // 0x405

public static final int GL_BLEND = 3042; // 0xbe2

public static final int GL_BLUE_BITS = 3412; // 0xd54

public static final int GL_BYTE = 5120; // 0x1400

public static final int GL_CCW = 2305; // 0x901

public static final int GL_CLAMP_TO_EDGE = 33071; // 0x812f

public static final int GL_CLEAR = 5376; // 0x1500

public static final int GL_COLOR_ARRAY = 32886; // 0x8076

public static final int GL_COLOR_BUFFER_BIT = 16384; // 0x4000

public static final int GL_COLOR_LOGIC_OP = 3058; // 0xbf2

public static final int GL_COLOR_MATERIAL = 2903; // 0xb57

public static final int GL_COMPRESSED_TEXTURE_FORMATS = 34467; // 0x86a3

public static final int GL_CONSTANT_ATTENUATION = 4615; // 0x1207

public static final int GL_COPY = 5379; // 0x1503

public static final int GL_COPY_INVERTED = 5388; // 0x150c

public static final int GL_CULL_FACE = 2884; // 0xb44

public static final int GL_CW = 2304; // 0x900

public static final int GL_DECAL = 8449; // 0x2101

public static final int GL_DECR = 7683; // 0x1e03

public static final int GL_DEPTH_BITS = 3414; // 0xd56

public static final int GL_DEPTH_BUFFER_BIT = 256; // 0x100

public static final int GL_DEPTH_TEST = 2929; // 0xb71

public static final int GL_DIFFUSE = 4609; // 0x1201

public static final int GL_DITHER = 3024; // 0xbd0

public static final int GL_DONT_CARE = 4352; // 0x1100

public static final int GL_DST_ALPHA = 772; // 0x304

public static final int GL_DST_COLOR = 774; // 0x306

public static final int GL_EMISSION = 5632; // 0x1600

public static final int GL_EQUAL = 514; // 0x202

public static final int GL_EQUIV = 5385; // 0x1509

public static final int GL_EXP = 2048; // 0x800

public static final int GL_EXP2 = 2049; // 0x801

public static final int GL_EXTENSIONS = 7939; // 0x1f03

public static final int GL_FALSE = 0; // 0x0

public static final int GL_FASTEST = 4353; // 0x1101

public static final int GL_FIXED = 5132; // 0x140c

public static final int GL_FLAT = 7424; // 0x1d00

public static final int GL_FLOAT = 5126; // 0x1406

public static final int GL_FOG = 2912; // 0xb60

public static final int GL_FOG_COLOR = 2918; // 0xb66

public static final int GL_FOG_DENSITY = 2914; // 0xb62

public static final int GL_FOG_END = 2916; // 0xb64

public static final int GL_FOG_HINT = 3156; // 0xc54

public static final int GL_FOG_MODE = 2917; // 0xb65

public static final int GL_FOG_START = 2915; // 0xb63

public static final int GL_FRONT = 1028; // 0x404

public static final int GL_FRONT_AND_BACK = 1032; // 0x408

public static final int GL_GEQUAL = 518; // 0x206

public static final int GL_GREATER = 516; // 0x204

public static final int GL_GREEN_BITS = 3411; // 0xd53

public static final int GL_IMPLEMENTATION_COLOR_READ_FORMAT_OES = 35739; // 0x8b9b

public static final int GL_IMPLEMENTATION_COLOR_READ_TYPE_OES = 35738; // 0x8b9a

public static final int GL_INCR = 7682; // 0x1e02

public static final int GL_INVALID_ENUM = 1280; // 0x500

public static final int GL_INVALID_OPERATION = 1282; // 0x502

public static final int GL_INVALID_VALUE = 1281; // 0x501

public static final int GL_INVERT = 5386; // 0x150a

public static final int GL_KEEP = 7680; // 0x1e00

public static final int GL_LEQUAL = 515; // 0x203

public static final int GL_LESS = 513; // 0x201

public static final int GL_LIGHT0 = 16384; // 0x4000

public static final int GL_LIGHT1 = 16385; // 0x4001

public static final int GL_LIGHT2 = 16386; // 0x4002

public static final int GL_LIGHT3 = 16387; // 0x4003

public static final int GL_LIGHT4 = 16388; // 0x4004

public static final int GL_LIGHT5 = 16389; // 0x4005

public static final int GL_LIGHT6 = 16390; // 0x4006

public static final int GL_LIGHT7 = 16391; // 0x4007

public static final int GL_LIGHTING = 2896; // 0xb50

public static final int GL_LIGHT_MODEL_AMBIENT = 2899; // 0xb53

public static final int GL_LIGHT_MODEL_TWO_SIDE = 2898; // 0xb52

public static final int GL_LINEAR = 9729; // 0x2601

public static final int GL_LINEAR_ATTENUATION = 4616; // 0x1208

public static final int GL_LINEAR_MIPMAP_LINEAR = 9987; // 0x2703

public static final int GL_LINEAR_MIPMAP_NEAREST = 9985; // 0x2701

public static final int GL_LINES = 1; // 0x1

public static final int GL_LINE_LOOP = 2; // 0x2

public static final int GL_LINE_SMOOTH = 2848; // 0xb20

public static final int GL_LINE_SMOOTH_HINT = 3154; // 0xc52

public static final int GL_LINE_STRIP = 3; // 0x3

public static final int GL_LUMINANCE = 6409; // 0x1909

public static final int GL_LUMINANCE_ALPHA = 6410; // 0x190a

public static final int GL_MAX_ELEMENTS_INDICES = 33001; // 0x80e9

public static final int GL_MAX_ELEMENTS_VERTICES = 33000; // 0x80e8

public static final int GL_MAX_LIGHTS = 3377; // 0xd31

public static final int GL_MAX_MODELVIEW_STACK_DEPTH = 3382; // 0xd36

public static final int GL_MAX_PROJECTION_STACK_DEPTH = 3384; // 0xd38

public static final int GL_MAX_TEXTURE_SIZE = 3379; // 0xd33

public static final int GL_MAX_TEXTURE_STACK_DEPTH = 3385; // 0xd39

public static final int GL_MAX_TEXTURE_UNITS = 34018; // 0x84e2

public static final int GL_MAX_VIEWPORT_DIMS = 3386; // 0xd3a

public static final int GL_MODELVIEW = 5888; // 0x1700

public static final int GL_MODULATE = 8448; // 0x2100

public static final int GL_MULTISAMPLE = 32925; // 0x809d

public static final int GL_NAND = 5390; // 0x150e

public static final int GL_NEAREST = 9728; // 0x2600

public static final int GL_NEAREST_MIPMAP_LINEAR = 9986; // 0x2702

public static final int GL_NEAREST_MIPMAP_NEAREST = 9984; // 0x2700

public static final int GL_NEVER = 512; // 0x200

public static final int GL_NICEST = 4354; // 0x1102

public static final int GL_NOOP = 5381; // 0x1505

public static final int GL_NOR = 5384; // 0x1508

public static final int GL_NORMALIZE = 2977; // 0xba1

public static final int GL_NORMAL_ARRAY = 32885; // 0x8075

public static final int GL_NOTEQUAL = 517; // 0x205

public static final int GL_NO_ERROR = 0; // 0x0

public static final int GL_NUM_COMPRESSED_TEXTURE_FORMATS = 34466; // 0x86a2

public static final int GL_ONE = 1; // 0x1

public static final int GL_ONE_MINUS_DST_ALPHA = 773; // 0x305

public static final int GL_ONE_MINUS_DST_COLOR = 775; // 0x307

public static final int GL_ONE_MINUS_SRC_ALPHA = 771; // 0x303

public static final int GL_ONE_MINUS_SRC_COLOR = 769; // 0x301

public static final int GL_OR = 5383; // 0x1507

public static final int GL_OR_INVERTED = 5389; // 0x150d

public static final int GL_OR_REVERSE = 5387; // 0x150b

public static final int GL_OUT_OF_MEMORY = 1285; // 0x505

public static final int GL_PACK_ALIGNMENT = 3333; // 0xd05

public static final int GL_PALETTE4_R5_G6_B5_OES = 35730; // 0x8b92

public static final int GL_PALETTE4_RGB5_A1_OES = 35732; // 0x8b94

public static final int GL_PALETTE4_RGB8_OES = 35728; // 0x8b90

public static final int GL_PALETTE4_RGBA4_OES = 35731; // 0x8b93

public static final int GL_PALETTE4_RGBA8_OES = 35729; // 0x8b91

public static final int GL_PALETTE8_R5_G6_B5_OES = 35735; // 0x8b97

public static final int GL_PALETTE8_RGB5_A1_OES = 35737; // 0x8b99

public static final int GL_PALETTE8_RGB8_OES = 35733; // 0x8b95

public static final int GL_PALETTE8_RGBA4_OES = 35736; // 0x8b98

public static final int GL_PALETTE8_RGBA8_OES = 35734; // 0x8b96

public static final int GL_PERSPECTIVE_CORRECTION_HINT = 3152; // 0xc50

public static final int GL_POINTS = 0; // 0x0

public static final int GL_POINT_FADE_THRESHOLD_SIZE = 33064; // 0x8128

public static final int GL_POINT_SIZE = 2833; // 0xb11

public static final int GL_POINT_SMOOTH = 2832; // 0xb10

public static final int GL_POINT_SMOOTH_HINT = 3153; // 0xc51

public static final int GL_POLYGON_OFFSET_FILL = 32823; // 0x8037

public static final int GL_POLYGON_SMOOTH_HINT = 3155; // 0xc53

public static final int GL_POSITION = 4611; // 0x1203

public static final int GL_PROJECTION = 5889; // 0x1701

public static final int GL_QUADRATIC_ATTENUATION = 4617; // 0x1209

public static final int GL_RED_BITS = 3410; // 0xd52

public static final int GL_RENDERER = 7937; // 0x1f01

public static final int GL_REPEAT = 10497; // 0x2901

public static final int GL_REPLACE = 7681; // 0x1e01

public static final int GL_RESCALE_NORMAL = 32826; // 0x803a

public static final int GL_RGB = 6407; // 0x1907

public static final int GL_RGBA = 6408; // 0x1908

public static final int GL_SAMPLE_ALPHA_TO_COVERAGE = 32926; // 0x809e

public static final int GL_SAMPLE_ALPHA_TO_ONE = 32927; // 0x809f

public static final int GL_SAMPLE_COVERAGE = 32928; // 0x80a0

public static final int GL_SCISSOR_TEST = 3089; // 0xc11

public static final int GL_SET = 5391; // 0x150f

public static final int GL_SHININESS = 5633; // 0x1601

public static final int GL_SHORT = 5122; // 0x1402

public static final int GL_SMOOTH = 7425; // 0x1d01

public static final int GL_SMOOTH_LINE_WIDTH_RANGE = 2850; // 0xb22

public static final int GL_SMOOTH_POINT_SIZE_RANGE = 2834; // 0xb12

public static final int GL_SPECULAR = 4610; // 0x1202

public static final int GL_SPOT_CUTOFF = 4614; // 0x1206

public static final int GL_SPOT_DIRECTION = 4612; // 0x1204

public static final int GL_SPOT_EXPONENT = 4613; // 0x1205

public static final int GL_SRC_ALPHA = 770; // 0x302

public static final int GL_SRC_ALPHA_SATURATE = 776; // 0x308

public static final int GL_SRC_COLOR = 768; // 0x300

public static final int GL_STACK_OVERFLOW = 1283; // 0x503

public static final int GL_STACK_UNDERFLOW = 1284; // 0x504

public static final int GL_STENCIL_BITS = 3415; // 0xd57

public static final int GL_STENCIL_BUFFER_BIT = 1024; // 0x400

public static final int GL_STENCIL_TEST = 2960; // 0xb90

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

public static final int GL_TEXTURE_COORD_ARRAY = 32888; // 0x8078

public static final int GL_TEXTURE_ENV = 8960; // 0x2300

public static final int GL_TEXTURE_ENV_COLOR = 8705; // 0x2201

public static final int GL_TEXTURE_ENV_MODE = 8704; // 0x2200

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

public static final int GL_UNSIGNED_SHORT = 5123; // 0x1403

public static final int GL_UNSIGNED_SHORT_4_4_4_4 = 32819; // 0x8033

public static final int GL_UNSIGNED_SHORT_5_5_5_1 = 32820; // 0x8034

public static final int GL_UNSIGNED_SHORT_5_6_5 = 33635; // 0x8363

public static final int GL_VENDOR = 7936; // 0x1f00

public static final int GL_VERSION = 7938; // 0x1f02

public static final int GL_VERTEX_ARRAY = 32884; // 0x8074

public static final int GL_XOR = 5382; // 0x1506

public static final int GL_ZERO = 0; // 0x0
}

