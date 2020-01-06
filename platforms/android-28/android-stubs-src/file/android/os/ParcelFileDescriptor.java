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

import java.io.FileDescriptor;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.Socket;
import java.net.DatagramSocket;
import android.content.ContentProvider;
import java.io.IOException;
import android.content.BroadcastReceiver;

/**
 * The FileDescriptor returned by {@link Parcel#readFileDescriptor}, allowing
 * you to close it when done with it.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ParcelFileDescriptor implements android.os.Parcelable, java.io.Closeable {

/**
 * Create a new ParcelFileDescriptor wrapped around another descriptor. By
 * default all method calls are delegated to the wrapped descriptor.
 */

public ParcelFileDescriptor(android.os.ParcelFileDescriptor wrapped) { throw new RuntimeException("Stub!"); }

/**
 * Create a new ParcelFileDescriptor accessing a given file.
 *
 * @param file The file to be opened.
 * @param mode The desired access mode, must be one of
 *            {@link #MODE_READ_ONLY}, {@link #MODE_WRITE_ONLY}, or
 *            {@link #MODE_READ_WRITE}; may also be any combination of
 *            {@link #MODE_CREATE}, {@link #MODE_TRUNCATE},
 *            {@link #MODE_WORLD_READABLE}, and
 *            {@link #MODE_WORLD_WRITEABLE}.
 * @return a new ParcelFileDescriptor pointing to the given file.
 * @throws FileNotFoundException if the given file does not exist or can not
 *             be opened with the requested mode.
 * @see #parseMode(String)
 */

public static android.os.ParcelFileDescriptor open(java.io.File file, int mode) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Create a new ParcelFileDescriptor accessing a given file.
 *
 * @param file The file to be opened.
 * @param mode The desired access mode, must be one of
 *            {@link #MODE_READ_ONLY}, {@link #MODE_WRITE_ONLY}, or
 *            {@link #MODE_READ_WRITE}; may also be any combination of
 *            {@link #MODE_CREATE}, {@link #MODE_TRUNCATE},
 *            {@link #MODE_WORLD_READABLE}, and
 *            {@link #MODE_WORLD_WRITEABLE}.
 * @param handler to call listener from; must not be null.
 * @param listener to be invoked when the returned descriptor has been
 *            closed; must not be null.
 * @return a new ParcelFileDescriptor pointing to the given file.
 * @throws FileNotFoundException if the given file does not exist or can not
 *             be opened with the requested mode.
 * @see #parseMode(String)
 */

public static android.os.ParcelFileDescriptor open(java.io.File file, int mode, android.os.Handler handler, android.os.ParcelFileDescriptor.OnCloseListener listener) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Create a new ParcelFileDescriptor that is a dup of an existing
 * FileDescriptor.  This obeys standard POSIX semantics, where the
 * new file descriptor shared state such as file position with the
 * original file descriptor.
 */

public static android.os.ParcelFileDescriptor dup(java.io.FileDescriptor orig) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Create a new ParcelFileDescriptor that is a dup of the existing
 * FileDescriptor.  This obeys standard POSIX semantics, where the
 * new file descriptor shared state such as file position with the
 * original file descriptor.
 */

public android.os.ParcelFileDescriptor dup() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Create a new ParcelFileDescriptor from a raw native fd.  The new
 * ParcelFileDescriptor holds a dup of the original fd passed in here,
 * so you must still close that fd as well as the new ParcelFileDescriptor.
 *
 * @param fd The native fd that the ParcelFileDescriptor should dup.
 *
 * @return Returns a new ParcelFileDescriptor holding a FileDescriptor
 * for a dup of the given fd.
 */

public static android.os.ParcelFileDescriptor fromFd(int fd) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Take ownership of a raw native fd in to a new ParcelFileDescriptor.
 * The returned ParcelFileDescriptor now owns the given fd, and will be
 * responsible for closing it.  You must not close the fd yourself.
 *
 * @param fd The native fd that the ParcelFileDescriptor should adopt.
 *
 * @return Returns a new ParcelFileDescriptor holding a FileDescriptor
 * for the given fd.
 */

public static android.os.ParcelFileDescriptor adoptFd(int fd) { throw new RuntimeException("Stub!"); }

/**
 * Create a new ParcelFileDescriptor from the specified Socket.  The new
 * ParcelFileDescriptor holds a dup of the original FileDescriptor in
 * the Socket, so you must still close the Socket as well as the new
 * ParcelFileDescriptor.
 *
 * @param socket The Socket whose FileDescriptor is used to create
 *               a new ParcelFileDescriptor.
 *
 * @return A new ParcelFileDescriptor with the FileDescriptor of the
 *         specified Socket.
 */

public static android.os.ParcelFileDescriptor fromSocket(java.net.Socket socket) { throw new RuntimeException("Stub!"); }

/**
 * Create a new ParcelFileDescriptor from the specified DatagramSocket.
 *
 * @param datagramSocket The DatagramSocket whose FileDescriptor is used
 *               to create a new ParcelFileDescriptor.
 *
 * @return A new ParcelFileDescriptor with the FileDescriptor of the
 *         specified DatagramSocket.
 */

public static android.os.ParcelFileDescriptor fromDatagramSocket(java.net.DatagramSocket datagramSocket) { throw new RuntimeException("Stub!"); }

/**
 * Create two ParcelFileDescriptors structured as a data pipe.  The first
 * ParcelFileDescriptor in the returned array is the read side; the second
 * is the write side.
 */

public static android.os.ParcelFileDescriptor[] createPipe() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Create two ParcelFileDescriptors structured as a data pipe. The first
 * ParcelFileDescriptor in the returned array is the read side; the second
 * is the write side.
 * <p>
 * The write end has the ability to deliver an error message through
 * {@link #closeWithError(String)} which can be handled by the read end
 * calling {@link #checkError()}, usually after detecting an EOF.
 * This can also be used to detect remote crashes.
 */

public static android.os.ParcelFileDescriptor[] createReliablePipe() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Create two ParcelFileDescriptors structured as a pair of sockets
 * connected to each other. The two sockets are indistinguishable.
 */

public static android.os.ParcelFileDescriptor[] createSocketPair() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Create two ParcelFileDescriptors structured as a pair of sockets
 * connected to each other. The two sockets are indistinguishable.
 * <p>
 * Both ends have the ability to deliver an error message through
 * {@link #closeWithError(String)} which can be detected by the other end
 * calling {@link #checkError()}, usually after detecting an EOF.
 * This can also be used to detect remote crashes.
 */

public static android.os.ParcelFileDescriptor[] createReliableSocketPair() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Converts a string representing a file mode, such as "rw", into a bitmask suitable for use
 * with {@link #open}.
 * <p>
 * @param mode The string representation of the file mode. Can be "r", "w", "wt", "wa", "rw"
 *             or "rwt".
 * @return A bitmask representing the given file mode.
 * @throws IllegalArgumentException if the given string does not match a known file mode.
 */

public static int parseMode(java.lang.String mode) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the actual FileDescriptor associated with this object.
 *
 * @return Returns the FileDescriptor associated with this object.
 */

public java.io.FileDescriptor getFileDescriptor() { throw new RuntimeException("Stub!"); }

/**
 * Return the total size of the file representing this fd, as determined by
 * {@code stat()}. Returns -1 if the fd is not a file.
 */

public long getStatSize() { throw new RuntimeException("Stub!"); }

/**
 * Return the native fd int for this ParcelFileDescriptor.  The
 * ParcelFileDescriptor still owns the fd, and it still must be closed
 * through this API.
 */

public int getFd() { throw new RuntimeException("Stub!"); }

/**
 * Return the native fd int for this ParcelFileDescriptor and detach it from
 * the object here. You are now responsible for closing the fd in native
 * code.
 * <p>
 * You should not detach when the original creator of the descriptor is
 * expecting a reliable signal through {@link #close()} or
 * {@link #closeWithError(String)}.
 *
 * @see #canDetectErrors()
 */

public int detachFd() { throw new RuntimeException("Stub!"); }

/**
 * Close the ParcelFileDescriptor. This implementation closes the underlying
 * OS resources allocated to represent this stream.
 *
 * @throws IOException
 *             If an error occurs attempting to close this ParcelFileDescriptor.
 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Close the ParcelFileDescriptor, informing any peer that an error occurred
 * while processing. If the creator of this descriptor is not observing
 * errors, it will close normally.
 *
 * @param msg describing the error; must not be null.
 */

public void closeWithError(java.lang.String msg) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Indicates if this ParcelFileDescriptor can communicate and detect remote
 * errors/crashes.
 *
 * @see #checkError()
 */

public boolean canDetectErrors() { throw new RuntimeException("Stub!"); }

/**
 * Detect and throw if the other end of a pipe or socket pair encountered an
 * error or crashed. This allows a reader to distinguish between a valid EOF
 * and an error/crash.
 * <p>
 * If this ParcelFileDescriptor is unable to detect remote errors, it will
 * return silently.
 *
 * @throws IOException for normal errors.
 * @throws FileDescriptorDetachedException
 *            if the remote side called {@link #detachFd()}. Once detached, the remote
 *            side is unable to communicate any errors through
 *            {@link #closeWithError(String)}.
 * @see #canDetectErrors()
 */

public void checkError() throws java.io.IOException { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * If {@link Parcelable#PARCELABLE_WRITE_RETURN_VALUE} is set in flags,
 * the file descriptor will be closed after a copy is written to the Parcel.
 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.os.ParcelFileDescriptor> CREATOR;
static { CREATOR = null; }

/**
 * For use with {@link #open}: append to end of file while writing.
 */

public static final int MODE_APPEND = 33554432; // 0x2000000

/**
 * For use with {@link #open}: create the file if it doesn't already exist.
 */

public static final int MODE_CREATE = 134217728; // 0x8000000

/**
 * For use with {@link #open}: open the file with read-only access.
 */

public static final int MODE_READ_ONLY = 268435456; // 0x10000000

/**
 * For use with {@link #open}: open the file with read and write access.
 */

public static final int MODE_READ_WRITE = 805306368; // 0x30000000

/**
 * For use with {@link #open}: erase contents of file when opening.
 */

public static final int MODE_TRUNCATE = 67108864; // 0x4000000

/**
 * For use with {@link #open}: if {@link #MODE_CREATE} has been supplied and
 * this file doesn't already exist, then create the file with permissions
 * such that any application can read it.
 *
 * @deprecated Creating world-readable files is very dangerous, and likely
 *             to cause security holes in applications. It is strongly
 *             discouraged; instead, applications should use more formal
 *             mechanism for interactions such as {@link ContentProvider},
 *             {@link BroadcastReceiver}, and {@link android.app.Service}.
 *             There are no guarantees that this access mode will remain on
 *             a file, such as when it goes through a backup and restore.
 */

@Deprecated public static final int MODE_WORLD_READABLE = 1; // 0x1

/**
 * For use with {@link #open}: if {@link #MODE_CREATE} has been supplied and
 * this file doesn't already exist, then create the file with permissions
 * such that any application can write it.
 *
 * @deprecated Creating world-writable files is very dangerous, and likely
 *             to cause security holes in applications. It is strongly
 *             discouraged; instead, applications should use more formal
 *             mechanism for interactions such as {@link ContentProvider},
 *             {@link BroadcastReceiver}, and {@link android.app.Service}.
 *             There are no guarantees that this access mode will remain on
 *             a file, such as when it goes through a backup and restore.
 */

@Deprecated public static final int MODE_WORLD_WRITEABLE = 2; // 0x2

/**
 * For use with {@link #open}: open the file with write-only access.
 */

public static final int MODE_WRITE_ONLY = 536870912; // 0x20000000
/**
 * An InputStream you can create on a ParcelFileDescriptor, which will
 * take care of calling {@link ParcelFileDescriptor#close
 * ParcelFileDescriptor.close()} for you when the stream is closed.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class AutoCloseInputStream extends java.io.FileInputStream {

public AutoCloseInputStream(android.os.ParcelFileDescriptor pfd) { super((java.io.FileDescriptor)null); throw new RuntimeException("Stub!"); }

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

public int read() throws java.io.IOException { throw new RuntimeException("Stub!"); }

public int read(byte[] b) throws java.io.IOException { throw new RuntimeException("Stub!"); }

public int read(byte[] b, int off, int len) throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

/**
 * An OutputStream you can create on a ParcelFileDescriptor, which will
 * take care of calling {@link ParcelFileDescriptor#close
 * ParcelFileDescriptor.close()} for you when the stream is closed.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class AutoCloseOutputStream extends java.io.FileOutputStream {

public AutoCloseOutputStream(android.os.ParcelFileDescriptor pfd) { super((java.io.FileDescriptor)null); throw new RuntimeException("Stub!"); }

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

/**
 * Exception that indicates that the file descriptor was detached.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class FileDescriptorDetachedException extends java.io.IOException {

public FileDescriptorDetachedException() { throw new RuntimeException("Stub!"); }
}

/**
 * Callback indicating that a ParcelFileDescriptor has been closed.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnCloseListener {

/**
 * Event indicating the ParcelFileDescriptor to which this listener was
 * attached has been closed.
 *
 * @param e error state, or {@code null} if closed cleanly.
 *        If the close event was the result of
 *        {@link ParcelFileDescriptor#detachFd()}, this will be a
 *        {@link FileDescriptorDetachedException}. After detach the
 *        remote side may continue reading/writing to the underlying
 *        {@link FileDescriptor}, but they can no longer deliver
 *        reliable close/error events.
 */

public void onClose(java.io.IOException e);
}

}

