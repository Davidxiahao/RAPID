/*
 * Copyright (C) 2008-2012 The Android Open Source Project
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


package android.renderscript;


/**
 * The parent class for all executable scripts. This should not be used by
 * applications.
 **/

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Script extends android.renderscript.BaseObj {

Script(long id, android.renderscript.RenderScript rs) { super(0, null); throw new RuntimeException("Stub!"); }

/**
 * Only to be used by generated reflected classes.
 */

protected android.renderscript.Script.KernelID createKernelID(int slot, int sig, android.renderscript.Element ein, android.renderscript.Element eout) { throw new RuntimeException("Stub!"); }

/**
 * Only to be used by generated reflected classes.
 */

protected android.renderscript.Script.InvokeID createInvokeID(int slot) { throw new RuntimeException("Stub!"); }

/**
 * Only to be used by generated reflected classes.
 */

protected android.renderscript.Script.FieldID createFieldID(int slot, android.renderscript.Element e) { throw new RuntimeException("Stub!"); }

/**
 * Only intended for use by generated reflected code.
 *
 */

protected void invoke(int slot) { throw new RuntimeException("Stub!"); }

/**
 * Only intended for use by generated reflected code.
 *
 */

protected void invoke(int slot, android.renderscript.FieldPacker v) { throw new RuntimeException("Stub!"); }

/**
 * Only intended for use by generated reflected code.
 *
 */

protected void forEach(int slot, android.renderscript.Allocation ain, android.renderscript.Allocation aout, android.renderscript.FieldPacker v) { throw new RuntimeException("Stub!"); }

/**
 * Only intended for use by generated reflected code.
 *
 */

protected void forEach(int slot, android.renderscript.Allocation ain, android.renderscript.Allocation aout, android.renderscript.FieldPacker v, android.renderscript.Script.LaunchOptions sc) { throw new RuntimeException("Stub!"); }

/**
 * Only intended for use by generated reflected code.
 */

protected void forEach(int slot, android.renderscript.Allocation[] ains, android.renderscript.Allocation aout, android.renderscript.FieldPacker v) { throw new RuntimeException("Stub!"); }

/**
 * Only intended for use by generated reflected code.
 */

protected void forEach(int slot, android.renderscript.Allocation[] ains, android.renderscript.Allocation aout, android.renderscript.FieldPacker v, android.renderscript.Script.LaunchOptions sc) { throw new RuntimeException("Stub!"); }

/**
 * Only intended for use by generated reflected code.  (General reduction)
 *
 */

protected void reduce(int slot, android.renderscript.Allocation[] ains, android.renderscript.Allocation aout, android.renderscript.Script.LaunchOptions sc) { throw new RuntimeException("Stub!"); }

/**
 * Only intended for use by generated reflected code.
 *
 */

public void bindAllocation(android.renderscript.Allocation va, int slot) { throw new RuntimeException("Stub!"); }

/**
 * Only intended for use by generated reflected code.
 *
 */

public void setVar(int index, float v) { throw new RuntimeException("Stub!"); }

public float getVarF(int index) { throw new RuntimeException("Stub!"); }

/**
 * Only intended for use by generated reflected code.
 *
 */

public void setVar(int index, double v) { throw new RuntimeException("Stub!"); }

public double getVarD(int index) { throw new RuntimeException("Stub!"); }

/**
 * Only intended for use by generated reflected code.
 *
 */

public void setVar(int index, int v) { throw new RuntimeException("Stub!"); }

public int getVarI(int index) { throw new RuntimeException("Stub!"); }

/**
 * Only intended for use by generated reflected code.
 *
 */

public void setVar(int index, long v) { throw new RuntimeException("Stub!"); }

public long getVarJ(int index) { throw new RuntimeException("Stub!"); }

/**
 * Only intended for use by generated reflected code.
 *
 */

public void setVar(int index, boolean v) { throw new RuntimeException("Stub!"); }

public boolean getVarB(int index) { throw new RuntimeException("Stub!"); }

/**
 * Only intended for use by generated reflected code.
 *
 */

public void setVar(int index, android.renderscript.BaseObj o) { throw new RuntimeException("Stub!"); }

/**
 * Only intended for use by generated reflected code.
 *
 */

public void setVar(int index, android.renderscript.FieldPacker v) { throw new RuntimeException("Stub!"); }

/**
 * Only intended for use by generated reflected code.
 *
 */

public void setVar(int index, android.renderscript.FieldPacker v, android.renderscript.Element e, int[] dims) { throw new RuntimeException("Stub!"); }

/**
 * Only intended for use by generated reflected code.
 *
 */

public void getVarV(int index, android.renderscript.FieldPacker v) { throw new RuntimeException("Stub!"); }

public void setTimeZone(java.lang.String timeZone) { throw new RuntimeException("Stub!"); }
/**
 * Only intended for use by generated reflected code.
 *
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

Builder(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }
}

/**
 * Only intended for use by generated reflected code.
 *
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class FieldBase {

protected FieldBase() { throw new RuntimeException("Stub!"); }

protected void init(android.renderscript.RenderScript rs, int dimx) { throw new RuntimeException("Stub!"); }

protected void init(android.renderscript.RenderScript rs, int dimx, int usages) { throw new RuntimeException("Stub!"); }

public android.renderscript.Element getElement() { throw new RuntimeException("Stub!"); }

public android.renderscript.Type getType() { throw new RuntimeException("Stub!"); }

public android.renderscript.Allocation getAllocation() { throw new RuntimeException("Stub!"); }

public void updateAllocation() { throw new RuntimeException("Stub!"); }

protected android.renderscript.Allocation mAllocation;

protected android.renderscript.Element mElement;
}

/**
 * FieldID is an identifier for a Script + exported field pair. It is used
 * as an identifier for ScriptGroup creation.
 *
 * This class should not be directly created. Instead use the method in the
 * reflected or intrinsic code "getFieldID_funcname()".
 *
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class FieldID extends android.renderscript.BaseObj {

FieldID(long id, android.renderscript.RenderScript rs, android.renderscript.Script s, int slot) { super(0, null); throw new RuntimeException("Stub!"); }
}

/**
 * InvokeID is an identifier for an invoke function. It is used
 * as an identifier for ScriptGroup creation.
 *
 * This class should not be directly created. Instead use the method in the
 * reflected or intrinsic code "getInvokeID_funcname()".
 *
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class InvokeID extends android.renderscript.BaseObj {

InvokeID(long id, android.renderscript.RenderScript rs, android.renderscript.Script s, int slot) { super(0, null); throw new RuntimeException("Stub!"); }
}

/**
 * KernelID is an identifier for a Script + root function pair. It is used
 * as an identifier for ScriptGroup creation.
 *
 * This class should not be directly created. Instead use the method in the
 * reflected or intrinsic code "getKernelID_funcname()".
 *
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class KernelID extends android.renderscript.BaseObj {

KernelID(long id, android.renderscript.RenderScript rs, android.renderscript.Script s, int slot, int sig) { super(0, null); throw new RuntimeException("Stub!"); }
}

/**
 * Class for specifying the specifics about how a kernel will be
 * launched.
 *
 * This class can specify a potential range of cells on which to
 * run a kernel.  If no set is called for a dimension then this
 * class will have no impact on that dimension when the kernel
 * is executed.
 *
 * The forEach kernel launch will operate over the intersection of
 * the dimensions.
 *
 * Example:
 * LaunchOptions with setX(5, 15)
 * Allocation with dimension X=10, Y=10
 * The resulting forEach run would execute over:
 * x = 5 to 9 (inclusive) and
 * y = 0 to 9 (inclusive).
 *
 *
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class LaunchOptions {

public LaunchOptions() { throw new RuntimeException("Stub!"); }

/**
 * Set the X range. xstartArg is the lowest coordinate of the range,
 * and xendArg-1 is the highest coordinate of the range.
 *
 * @param xstartArg Must be >= 0
 * @param xendArg Must be > xstartArg
 *
 * @return LaunchOptions
 */

public android.renderscript.Script.LaunchOptions setX(int xstartArg, int xendArg) { throw new RuntimeException("Stub!"); }

/**
 * Set the Y range. ystartArg is the lowest coordinate of the range,
 * and yendArg-1 is the highest coordinate of the range.
 *
 * @param ystartArg Must be >= 0
 * @param yendArg Must be > ystartArg
 *
 * @return LaunchOptions
 */

public android.renderscript.Script.LaunchOptions setY(int ystartArg, int yendArg) { throw new RuntimeException("Stub!"); }

/**
 * Set the Z range. zstartArg is the lowest coordinate of the range,
 * and zendArg-1 is the highest coordinate of the range.
 *
 * @param zstartArg Must be >= 0
 * @param zendArg Must be > zstartArg
 *
 * @return LaunchOptions
 */

public android.renderscript.Script.LaunchOptions setZ(int zstartArg, int zendArg) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current X start
 *
 * @return int current value
 */

public int getXStart() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current X end
 *
 * @return int current value
 */

public int getXEnd() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current Y start
 *
 * @return int current value
 */

public int getYStart() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current Y end
 *
 * @return int current value
 */

public int getYEnd() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current Z start
 *
 * @return int current value
 */

public int getZStart() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current Z end
 *
 * @return int current value
 */

public int getZEnd() { throw new RuntimeException("Stub!"); }
}

}

