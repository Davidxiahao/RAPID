/*
 * Copyright (C) 2011 The Android Open Source Project
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

package android.util;


/**
 * An implementation of {@link android.util.Property} to be used specifically with fields of type
 * <code>float</code>. This type-specific subclass enables performance benefit by allowing
 * calls to a {@link #setValue(Object, float) setValue()} function that takes the primitive
 * <code>float</code> type and avoids autoboxing and other overhead associated with the
 * <code>Float</code> class.
 *
 * @param <T> The class on which the Property is declared.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class FloatProperty<T> extends android.util.Property<T, java.lang.Float> {

public FloatProperty(java.lang.String name) { super(null, null); throw new RuntimeException("Stub!"); }

/**
 * A type-specific variant of {@link #set(Object, Float)} that is faster when dealing
 * with fields of type <code>float</code>.
 */

public abstract void setValue(T object, float value);

public final void set(T object, java.lang.Float value) { throw new RuntimeException("Stub!"); }
}

