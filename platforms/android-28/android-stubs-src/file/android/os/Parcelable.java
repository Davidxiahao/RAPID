/*
 * Copyright (C) 2006 The Android Open Source Project
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


package android.os;


/**
 * Interface for classes whose instances can be written to
 * and restored from a {@link Parcel}.  Classes implementing the Parcelable
 * interface must also have a non-null static field called <code>CREATOR</code>
 * of a type that implements the {@link Parcelable.Creator} interface.
 *
 * <p>A typical implementation of Parcelable is:</p>
 *
 * <pre>
 * public class MyParcelable implements Parcelable {
 *     private int mData;
 *
 *     public int describeContents() {
 *         return 0;
 *     }
 *
 *     public void writeToParcel(Parcel out, int flags) {
 *         out.writeInt(mData);
 *     }
 *
 *     public static final Parcelable.Creator&lt;MyParcelable&gt; CREATOR
 *             = new Parcelable.Creator&lt;MyParcelable&gt;() {
 *         public MyParcelable createFromParcel(Parcel in) {
 *             return new MyParcelable(in);
 *         }
 *
 *         public MyParcelable[] newArray(int size) {
 *             return new MyParcelable[size];
 *         }
 *     };
 *
 *     private MyParcelable(Parcel in) {
 *         mData = in.readInt();
 *     }
 * }</pre>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface Parcelable {

/**
 * Describe the kinds of special objects contained in this Parcelable
 * instance's marshaled representation. For example, if the object will
 * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
 * the return value of this method must include the
 * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
 *
 * @return a bitmask indicating the set of special object types marshaled
 * by this Parcelable object instance.

 * Value is either <code>0</code> or {@link android.os.Parcelable#CONTENTS_FILE_DESCRIPTOR}
 */

public int describeContents();

/**
 * Flatten this object in to a Parcel.
 *
 * @param dest The Parcel in which the object should be written.
 * @param flags Additional flags about how the object should be written.
 * May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.

 * Value is either <code>0</code> or a combination of {@link android.os.Parcelable#PARCELABLE_WRITE_RETURN_VALUE}, and android.os.Parcelable.PARCELABLE_ELIDE_DUPLICATES
 */

public void writeToParcel(android.os.Parcel dest, int flags);

/**
 * Descriptor bit used with {@link #describeContents()}: indicates that
 * the Parcelable object's flattened representation includes a file descriptor.
 *
 * @see #describeContents()
 */

public static final int CONTENTS_FILE_DESCRIPTOR = 1; // 0x1

/**
 * Flag for use with {@link #writeToParcel}: the object being written
 * is a return value, that is the result of a function such as
 * "<code>Parcelable someFunction()</code>",
 * "<code>void someFunction(out Parcelable)</code>", or
 * "<code>void someFunction(inout Parcelable)</code>".  Some implementations
 * may want to release resources at this point.
 */

public static final int PARCELABLE_WRITE_RETURN_VALUE = 1; // 0x1
/**
 * Specialization of {@link Creator} that allows you to receive the
 * ClassLoader the object is being created in.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface ClassLoaderCreator<T> extends android.os.Parcelable.Creator<T> {

/**
 * Create a new instance of the Parcelable class, instantiating it
 * from the given Parcel whose data had previously been written by
 * {@link Parcelable#writeToParcel Parcelable.writeToParcel()} and
 * using the given ClassLoader.
 *
 * @param source The Parcel to read the object's data from.
 * @param loader The ClassLoader that this object is being created in.
 * @return Returns a new instance of the Parcelable class.
 */

public T createFromParcel(android.os.Parcel source, java.lang.ClassLoader loader);
}

/**
 * Interface that must be implemented and provided as a public CREATOR
 * field that generates instances of your Parcelable class from a Parcel.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface Creator<T> {

/**
 * Create a new instance of the Parcelable class, instantiating it
 * from the given Parcel whose data had previously been written by
 * {@link Parcelable#writeToParcel Parcelable.writeToParcel()}.
 *
 * @param source The Parcel to read the object's data from.
 * @return Returns a new instance of the Parcelable class.
 */

public T createFromParcel(android.os.Parcel source);

/**
 * Create a new array of the Parcelable class.
 *
 * @param size Size of the array.
 * @return Returns an array of the Parcelable class, with every entry
 * initialized to null.
 */

public T[] newArray(int size);
}

}

