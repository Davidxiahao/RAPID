/* //device/java/android/javax/microedition/khronos/opengles/GL11Ext.java
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
public interface GL11Ext extends javax.microedition.khronos.opengles.GL {

public void glTexParameterfv(int target, int pname, float[] param, int offset);

public void glCurrentPaletteMatrixOES(int matrixpaletteindex);

public void glDrawTexfOES(float x, float y, float z, float width, float height);

public void glDrawTexfvOES(float[] coords, int offset);

public void glDrawTexfvOES(java.nio.FloatBuffer coords);

public void glDrawTexiOES(int x, int y, int z, int width, int height);

public void glDrawTexivOES(int[] coords, int offset);

public void glDrawTexivOES(java.nio.IntBuffer coords);

public void glDrawTexsOES(short x, short y, short z, short width, short height);

public void glDrawTexsvOES(short[] coords, int offset);

public void glDrawTexsvOES(java.nio.ShortBuffer coords);

public void glDrawTexxOES(int x, int y, int z, int width, int height);

public void glDrawTexxvOES(int[] coords, int offset);

public void glDrawTexxvOES(java.nio.IntBuffer coords);

public void glEnable(int cap);

public void glEnableClientState(int array);

public void glLoadPaletteFromModelViewMatrixOES();

public void glMatrixIndexPointerOES(int size, int type, int stride, java.nio.Buffer pointer);

public void glMatrixIndexPointerOES(int size, int type, int stride, int offset);

public void glWeightPointerOES(int size, int type, int stride, java.nio.Buffer pointer);

public void glWeightPointerOES(int size, int type, int stride, int offset);

public static final int GL_MATRIX_INDEX_ARRAY_BUFFER_BINDING_OES = 35742; // 0x8b9e

public static final int GL_MATRIX_INDEX_ARRAY_OES = 34884; // 0x8844

public static final int GL_MATRIX_INDEX_ARRAY_POINTER_OES = 34889; // 0x8849

public static final int GL_MATRIX_INDEX_ARRAY_SIZE_OES = 34886; // 0x8846

public static final int GL_MATRIX_INDEX_ARRAY_STRIDE_OES = 34888; // 0x8848

public static final int GL_MATRIX_INDEX_ARRAY_TYPE_OES = 34887; // 0x8847

public static final int GL_MATRIX_PALETTE_OES = 34880; // 0x8840

public static final int GL_MAX_PALETTE_MATRICES_OES = 34882; // 0x8842

public static final int GL_MAX_VERTEX_UNITS_OES = 34468; // 0x86a4

public static final int GL_TEXTURE_CROP_RECT_OES = 35741; // 0x8b9d

public static final int GL_WEIGHT_ARRAY_BUFFER_BINDING_OES = 34974; // 0x889e

public static final int GL_WEIGHT_ARRAY_OES = 34477; // 0x86ad

public static final int GL_WEIGHT_ARRAY_POINTER_OES = 34476; // 0x86ac

public static final int GL_WEIGHT_ARRAY_SIZE_OES = 34475; // 0x86ab

public static final int GL_WEIGHT_ARRAY_STRIDE_OES = 34474; // 0x86aa

public static final int GL_WEIGHT_ARRAY_TYPE_OES = 34473; // 0x86a9
}

