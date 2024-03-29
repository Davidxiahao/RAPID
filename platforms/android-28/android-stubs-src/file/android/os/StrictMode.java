/*
 * Copyright (C) 2010 The Android Open Source Project
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

import android.util.Log;
import android.content.Intent;
import android.net.Uri;
import android.app.ActivityManager;
import android.content.pm.ApplicationInfo;
import android.os.strictmode.Violation;
import android.content.ServiceConnection;
import android.content.Context;
import android.content.BroadcastReceiver;
import android.net.TrafficStats;
import android.util.Printer;

/**
 * StrictMode is a developer tool which detects things you might be doing by accident and brings
 * them to your attention so you can fix them.
 *
 * <p>StrictMode is most commonly used to catch accidental disk or network access on the
 * application's main thread, where UI operations are received and animations take place. Keeping
 * disk and network operations off the main thread makes for much smoother, more responsive
 * applications. By keeping your application's main thread responsive, you also prevent <a
 * href="{@docRoot}guide/practices/design/responsiveness.html">ANR dialogs</a> from being shown to
 * users.
 *
 * <p class="note">Note that even though an Android device's disk is often on flash memory, many
 * devices run a filesystem on top of that memory with very limited concurrency. It's often the case
 * that almost all disk accesses are fast, but may in individual cases be dramatically slower when
 * certain I/O is happening in the background from other processes. If possible, it's best to assume
 * that such things are not fast.
 *
 * <p>Example code to enable from early in your {@link android.app.Application}, {@link
 * android.app.Activity}, or other application component's {@link android.app.Application#onCreate}
 * method:
 *
 * <pre>
 * public void onCreate() {
 *     if (DEVELOPER_MODE) {
 *         StrictMode.setThreadPolicy(new {@link ThreadPolicy.Builder StrictMode.ThreadPolicy.Builder}()
 *                 .detectDiskReads()
 *                 .detectDiskWrites()
 *                 .detectNetwork()   // or .detectAll() for all detectable problems
 *                 .penaltyLog()
 *                 .build());
 *         StrictMode.setVmPolicy(new {@link VmPolicy.Builder StrictMode.VmPolicy.Builder}()
 *                 .detectLeakedSqlLiteObjects()
 *                 .detectLeakedClosableObjects()
 *                 .penaltyLog()
 *                 .penaltyDeath()
 *                 .build());
 *     }
 *     super.onCreate();
 * }
 * </pre>
 *
 * <p>You can decide what should happen when a violation is detected. For example, using {@link
 * ThreadPolicy.Builder#penaltyLog} you can watch the output of <code>adb logcat</code> while you
 * use your application to see the violations as they happen.
 *
 * <p>If you find violations that you feel are problematic, there are a variety of tools to help
 * solve them: threads, {@link android.os.Handler}, {@link android.os.AsyncTask}, {@link
 * android.app.IntentService}, etc. But don't feel compelled to fix everything that StrictMode
 * finds. In particular, many cases of disk access are often necessary during the normal activity
 * lifecycle. Use StrictMode to find things you did by accident. Network requests on the UI thread
 * are almost always a problem, though.
 *
 * <p class="note">StrictMode is not a security mechanism and is not guaranteed to find all disk or
 * network accesses. While it does propagate its state across process boundaries when doing {@link
 * android.os.Binder} calls, it's still ultimately a best effort mechanism. Notably, disk or network
 * access from JNI calls won't necessarily trigger it. Future versions of Android may catch more (or
 * fewer) operations, so you should never leave StrictMode enabled in applications distributed on
 * Google Play.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class StrictMode {

StrictMode() { throw new RuntimeException("Stub!"); }

/**
 * Sets the policy for what actions on the current thread should be detected, as well as the
 * penalty if such actions occur.
 *
 * <p>Internally this sets a thread-local variable which is propagated across cross-process IPC
 * calls, meaning you can catch violations when a system service or another process accesses the
 * disk or network on your behalf.
 *
 * @param policy the policy to put into place
 */

public static void setThreadPolicy(android.os.StrictMode.ThreadPolicy policy) { throw new RuntimeException("Stub!"); }

/** Returns the current thread's policy. */

public static android.os.StrictMode.ThreadPolicy getThreadPolicy() { throw new RuntimeException("Stub!"); }

/**
 * A convenience wrapper that takes the current {@link ThreadPolicy} from {@link
 * #getThreadPolicy}, modifies it to permit both disk reads &amp; writes, and sets the new
 * policy with {@link #setThreadPolicy}, returning the old policy so you can restore it at the
 * end of a block.
 *
 * @return the old policy, to be passed to {@link #setThreadPolicy} to restore the policy at the
 *     end of a block
 */

public static android.os.StrictMode.ThreadPolicy allowThreadDiskWrites() { throw new RuntimeException("Stub!"); }

/**
 * A convenience wrapper that takes the current {@link ThreadPolicy} from {@link
 * #getThreadPolicy}, modifies it to permit disk reads, and sets the new policy with {@link
 * #setThreadPolicy}, returning the old policy so you can restore it at the end of a block.
 *
 * @return the old policy, to be passed to setThreadPolicy to restore the policy.
 */

public static android.os.StrictMode.ThreadPolicy allowThreadDiskReads() { throw new RuntimeException("Stub!"); }

/**
 * Sets the policy for what actions in the VM process (on any thread) should be detected, as
 * well as the penalty if such actions occur.
 *
 * @param policy the policy to put into place
 */

public static void setVmPolicy(android.os.StrictMode.VmPolicy policy) { throw new RuntimeException("Stub!"); }

/** Gets the current VM policy. */

public static android.os.StrictMode.VmPolicy getVmPolicy() { throw new RuntimeException("Stub!"); }

/**
 * Enable the recommended StrictMode defaults, with violations just being logged.
 *
 * <p>This catches disk and network access on the main thread, as well as leaked SQLite cursors
 * and unclosed resources. This is simply a wrapper around {@link #setVmPolicy} and {@link
 * #setThreadPolicy}.
 */

public static void enableDefaults() { throw new RuntimeException("Stub!"); }

/**
 * For code to note that it's slow. This is a no-op unless the current thread's {@link
 * android.os.StrictMode.ThreadPolicy} has {@link
 * android.os.StrictMode.ThreadPolicy.Builder#detectCustomSlowCalls} enabled.
 *
 * @param name a short string for the exception stack trace that's built if when this fires.
 */

public static void noteSlowCall(java.lang.String name) { throw new RuntimeException("Stub!"); }
/**
 * When #{@link ThreadPolicy.Builder#penaltyListener} is enabled, the listener is called on the
 * provided executor when a Thread violation occurs.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnThreadViolationListener {

/** Called on a thread policy violation. */

public void onThreadViolation(android.os.strictmode.Violation v);
}

/**
 * When #{@link VmPolicy.Builder#penaltyListener} is enabled, the listener is called on the
 * provided executor when a VM violation occurs.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnVmViolationListener {

/** Called on a VM policy violation. */

public void onVmViolation(android.os.strictmode.Violation v);
}

/**
 * {@link StrictMode} policy applied to a certain thread.
 *
 * <p>The policy is enabled by {@link #setThreadPolicy}. The current policy can be retrieved
 * with {@link #getThreadPolicy}.
 *
 * <p>Note that multiple penalties may be provided and they're run in order from least to most
 * severe (logging before process death, for example). There's currently no mechanism to choose
 * different penalties for different detected actions.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class ThreadPolicy {

ThreadPolicy(int mask, android.os.StrictMode.OnThreadViolationListener listener, java.util.concurrent.Executor executor) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** The default, lax policy which doesn't catch anything. */

public static final android.os.StrictMode.ThreadPolicy LAX;
static { LAX = null; }
/**
 * Creates {@link ThreadPolicy} instances. Methods whose names start with {@code detect}
 * specify what problems we should look for. Methods whose names start with {@code penalty}
 * specify what we should do when we detect a problem.
 *
 * <p>You can call as many {@code detect} and {@code penalty} methods as you like. Currently
 * order is insignificant: all penalties apply to all detected problems.
 *
 * <p>For example, detect everything and log anything that's found:
 *
 * <pre>
 * StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
 *     .detectAll()
 *     .penaltyLog()
 *     .build();
 * StrictMode.setThreadPolicy(policy);
 * </pre>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Create a Builder that detects nothing and has no violations. (but note that {@link
 * #build} will default to enabling {@link #penaltyLog} if no other penalties are
 * specified)
 */

public Builder() { throw new RuntimeException("Stub!"); }

/** Initialize a Builder from an existing ThreadPolicy. */

public Builder(android.os.StrictMode.ThreadPolicy policy) { throw new RuntimeException("Stub!"); }

/**
 * Detect everything that's potentially suspect.
 *
 * <p>As of the Gingerbread release this includes network and disk operations but will
 * likely expand in future releases.
 */

public android.os.StrictMode.ThreadPolicy.Builder detectAll() { throw new RuntimeException("Stub!"); }

/** Disable the detection of everything. */

public android.os.StrictMode.ThreadPolicy.Builder permitAll() { throw new RuntimeException("Stub!"); }

/** Enable detection of network operations. */

public android.os.StrictMode.ThreadPolicy.Builder detectNetwork() { throw new RuntimeException("Stub!"); }

/** Disable detection of network operations. */

public android.os.StrictMode.ThreadPolicy.Builder permitNetwork() { throw new RuntimeException("Stub!"); }

/** Enable detection of disk reads. */

public android.os.StrictMode.ThreadPolicy.Builder detectDiskReads() { throw new RuntimeException("Stub!"); }

/** Disable detection of disk reads. */

public android.os.StrictMode.ThreadPolicy.Builder permitDiskReads() { throw new RuntimeException("Stub!"); }

/** Enable detection of slow calls. */

public android.os.StrictMode.ThreadPolicy.Builder detectCustomSlowCalls() { throw new RuntimeException("Stub!"); }

/** Disable detection of slow calls. */

public android.os.StrictMode.ThreadPolicy.Builder permitCustomSlowCalls() { throw new RuntimeException("Stub!"); }

/** Disable detection of mismatches between defined resource types and getter calls. */

public android.os.StrictMode.ThreadPolicy.Builder permitResourceMismatches() { throw new RuntimeException("Stub!"); }

/** Detect unbuffered input/output operations. */

public android.os.StrictMode.ThreadPolicy.Builder detectUnbufferedIo() { throw new RuntimeException("Stub!"); }

/** Disable detection of unbuffered input/output operations. */

public android.os.StrictMode.ThreadPolicy.Builder permitUnbufferedIo() { throw new RuntimeException("Stub!"); }

/**
 * Enables detection of mismatches between defined resource types and getter calls.
 *
 * <p>This helps detect accidental type mismatches and potentially expensive type
 * conversions when obtaining typed resources.
 *
 * <p>For example, a strict mode violation would be thrown when calling {@link
 * android.content.res.TypedArray#getInt(int, int)} on an index that contains a
 * String-type resource. If the string value can be parsed as an integer, this method
 * call will return a value without crashing; however, the developer should format the
 * resource as an integer to avoid unnecessary type conversion.
 */

public android.os.StrictMode.ThreadPolicy.Builder detectResourceMismatches() { throw new RuntimeException("Stub!"); }

/** Enable detection of disk writes. */

public android.os.StrictMode.ThreadPolicy.Builder detectDiskWrites() { throw new RuntimeException("Stub!"); }

/** Disable detection of disk writes. */

public android.os.StrictMode.ThreadPolicy.Builder permitDiskWrites() { throw new RuntimeException("Stub!"); }

/**
 * Show an annoying dialog to the developer on detected violations, rate-limited to be
 * only a little annoying.
 */

public android.os.StrictMode.ThreadPolicy.Builder penaltyDialog() { throw new RuntimeException("Stub!"); }

/**
 * Crash the whole process on violation. This penalty runs at the end of all enabled
 * penalties so you'll still get see logging or other violations before the process
 * dies.
 *
 * <p>Unlike {@link #penaltyDeathOnNetwork}, this applies to disk reads, disk writes,
 * and network usage if their corresponding detect flags are set.
 */

public android.os.StrictMode.ThreadPolicy.Builder penaltyDeath() { throw new RuntimeException("Stub!"); }

/**
 * Crash the whole process on any network usage. Unlike {@link #penaltyDeath}, this
 * penalty runs <em>before</em> anything else. You must still have called {@link
 * #detectNetwork} to enable this.
 *
 * <p>In the Honeycomb or later SDKs, this is on by default.
 */

public android.os.StrictMode.ThreadPolicy.Builder penaltyDeathOnNetwork() { throw new RuntimeException("Stub!"); }

/** Flash the screen during a violation. */

public android.os.StrictMode.ThreadPolicy.Builder penaltyFlashScreen() { throw new RuntimeException("Stub!"); }

/** Log detected violations to the system log. */

public android.os.StrictMode.ThreadPolicy.Builder penaltyLog() { throw new RuntimeException("Stub!"); }

/**
 * Enable detected violations log a stacktrace and timing data to the {@link
 * android.os.DropBoxManager DropBox} on policy violation. Intended mostly for platform
 * integrators doing beta user field data collection.
 */

public android.os.StrictMode.ThreadPolicy.Builder penaltyDropBox() { throw new RuntimeException("Stub!"); }

/**
 * Call #{@link OnThreadViolationListener#onThreadViolation(Violation)} on specified
 * executor every violation.
 
 * @param executor This value must never be {@code null}.

 * @param listener This value must never be {@code null}.
 */

public android.os.StrictMode.ThreadPolicy.Builder penaltyListener(@androidx.annotation.RecentlyNonNull java.util.concurrent.Executor executor, @androidx.annotation.RecentlyNonNull android.os.StrictMode.OnThreadViolationListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Construct the ThreadPolicy instance.
 *
 * <p>Note: if no penalties are enabled before calling <code>build</code>, {@link
 * #penaltyLog} is implicitly set.
 */

public android.os.StrictMode.ThreadPolicy build() { throw new RuntimeException("Stub!"); }
}

}

/**
 * {@link StrictMode} policy applied to all threads in the virtual machine's process.
 *
 * <p>The policy is enabled by {@link #setVmPolicy}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class VmPolicy {

VmPolicy(int mask, java.util.HashMap<java.lang.Class,java.lang.Integer> classInstanceLimit, android.os.StrictMode.OnVmViolationListener listener, java.util.concurrent.Executor executor) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** The default, lax policy which doesn't catch anything. */

public static final android.os.StrictMode.VmPolicy LAX;
static { LAX = null; }
/**
 * Creates {@link VmPolicy} instances. Methods whose names start with {@code detect} specify
 * what problems we should look for. Methods whose names start with {@code penalty} specify
 * what we should do when we detect a problem.
 *
 * <p>You can call as many {@code detect} and {@code penalty} methods as you like. Currently
 * order is insignificant: all penalties apply to all detected problems.
 *
 * <p>For example, detect everything and log anything that's found:
 *
 * <pre>
 * StrictMode.VmPolicy policy = new StrictMode.VmPolicy.Builder()
 *     .detectAll()
 *     .penaltyLog()
 *     .build();
 * StrictMode.setVmPolicy(policy);
 * </pre>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

/** Build upon an existing VmPolicy. */

public Builder(android.os.StrictMode.VmPolicy base) { throw new RuntimeException("Stub!"); }

/**
 * Set an upper bound on how many instances of a class can be in memory at once. Helps
 * to prevent object leaks.
 */

public android.os.StrictMode.VmPolicy.Builder setClassInstanceLimit(java.lang.Class klass, int instanceLimit) { throw new RuntimeException("Stub!"); }

/** Detect leaks of {@link android.app.Activity} subclasses. */

public android.os.StrictMode.VmPolicy.Builder detectActivityLeaks() { throw new RuntimeException("Stub!"); }

/**
 * Detect reflective usage of APIs that are not part of the public Android SDK.
 *
 * <p>Note that any non-SDK APIs that this processes accesses before this detection is
 * enabled may not be detected. To ensure that all such API accesses are detected,
 * you should apply this policy as early as possible after process creation.
 */

public android.os.StrictMode.VmPolicy.Builder detectNonSdkApiUsage() { throw new RuntimeException("Stub!"); }

/**
 * Permit reflective usage of APIs that are not part of the public Android SDK. Note
 * that this <b>only</b> affects {@code StrictMode}, the underlying runtime may
 * continue to restrict or warn on access to methods that are not part of the
 * public SDK.
 */

public android.os.StrictMode.VmPolicy.Builder permitNonSdkApiUsage() { throw new RuntimeException("Stub!"); }

/**
 * Detect everything that's potentially suspect.
 *
 * <p>In the Honeycomb release this includes leaks of SQLite cursors, Activities, and
 * other closable objects but will likely expand in future releases.
 */

public android.os.StrictMode.VmPolicy.Builder detectAll() { throw new RuntimeException("Stub!"); }

/**
 * Detect when an {@link android.database.sqlite.SQLiteCursor} or other SQLite object is
 * finalized without having been closed.
 *
 * <p>You always want to explicitly close your SQLite cursors to avoid unnecessary
 * database contention and temporary memory leaks.
 */

public android.os.StrictMode.VmPolicy.Builder detectLeakedSqlLiteObjects() { throw new RuntimeException("Stub!"); }

/**
 * Detect when an {@link java.io.Closeable} or other object with an explicit termination
 * method is finalized without having been closed.
 *
 * <p>You always want to explicitly close such objects to avoid unnecessary resources
 * leaks.
 */

public android.os.StrictMode.VmPolicy.Builder detectLeakedClosableObjects() { throw new RuntimeException("Stub!"); }

/**
 * Detect when a {@link BroadcastReceiver} or {@link ServiceConnection} is leaked during
 * {@link Context} teardown.
 */

public android.os.StrictMode.VmPolicy.Builder detectLeakedRegistrationObjects() { throw new RuntimeException("Stub!"); }

/**
 * Detect when the calling application exposes a {@code file://} {@link android.net.Uri}
 * to another app.
 *
 * <p>This exposure is discouraged since the receiving app may not have access to the
 * shared path. For example, the receiving app may not have requested the {@link
 * android.Manifest.permission#READ_EXTERNAL_STORAGE} runtime permission, or the
 * platform may be sharing the {@link android.net.Uri} across user profile boundaries.
 *
 * <p>Instead, apps should use {@code content://} Uris so the platform can extend
 * temporary permission for the receiving app to access the resource.
 *
 * @see android.support.v4.content.FileProvider
 * @see Intent#FLAG_GRANT_READ_URI_PERMISSION
 */

public android.os.StrictMode.VmPolicy.Builder detectFileUriExposure() { throw new RuntimeException("Stub!"); }

/**
 * Detect any network traffic from the calling app which is not wrapped in SSL/TLS. This
 * can help you detect places that your app is inadvertently sending cleartext data
 * across the network.
 *
 * <p>Using {@link #penaltyDeath()} or {@link #penaltyDeathOnCleartextNetwork()} will
 * block further traffic on that socket to prevent accidental data leakage, in addition
 * to crashing your process.
 *
 * <p>Using {@link #penaltyDropBox()} will log the raw contents of the packet that
 * triggered the violation.
 *
 * <p>This inspects both IPv4/IPv6 and TCP/UDP network traffic, but it may be subject to
 * false positives, such as when STARTTLS protocols or HTTP proxies are used.
 */

public android.os.StrictMode.VmPolicy.Builder detectCleartextNetwork() { throw new RuntimeException("Stub!"); }

/**
 * Detect when the calling application sends a {@code content://} {@link
 * android.net.Uri} to another app without setting {@link
 * Intent#FLAG_GRANT_READ_URI_PERMISSION} or {@link
 * Intent#FLAG_GRANT_WRITE_URI_PERMISSION}.
 *
 * <p>Forgetting to include one or more of these flags when sending an intent is
 * typically an app bug.
 *
 * @see Intent#FLAG_GRANT_READ_URI_PERMISSION
 * @see Intent#FLAG_GRANT_WRITE_URI_PERMISSION
 */

public android.os.StrictMode.VmPolicy.Builder detectContentUriWithoutPermission() { throw new RuntimeException("Stub!"); }

/**
 * Detect any sockets in the calling app which have not been tagged using {@link
 * TrafficStats}. Tagging sockets can help you investigate network usage inside your
 * app, such as a narrowing down heavy usage to a specific library or component.
 *
 * <p>This currently does not detect sockets created in native code.
 *
 * @see TrafficStats#setThreadStatsTag(int)
 * @see TrafficStats#tagSocket(java.net.Socket)
 * @see TrafficStats#tagDatagramSocket(java.net.DatagramSocket)
 */

public android.os.StrictMode.VmPolicy.Builder detectUntaggedSockets() { throw new RuntimeException("Stub!"); }

/**
 * Crashes the whole process on violation. This penalty runs at the end of all enabled
 * penalties so you'll still get your logging or other violations before the process
 * dies.
 */

public android.os.StrictMode.VmPolicy.Builder penaltyDeath() { throw new RuntimeException("Stub!"); }

/**
 * Crashes the whole process when cleartext network traffic is detected.
 *
 * @see #detectCleartextNetwork()
 */

public android.os.StrictMode.VmPolicy.Builder penaltyDeathOnCleartextNetwork() { throw new RuntimeException("Stub!"); }

/**
 * Crashes the whole process when a {@code file://} {@link android.net.Uri} is exposed
 * beyond this app.
 *
 * @see #detectFileUriExposure()
 */

public android.os.StrictMode.VmPolicy.Builder penaltyDeathOnFileUriExposure() { throw new RuntimeException("Stub!"); }

/** Log detected violations to the system log. */

public android.os.StrictMode.VmPolicy.Builder penaltyLog() { throw new RuntimeException("Stub!"); }

/**
 * Enable detected violations log a stacktrace and timing data to the {@link
 * android.os.DropBoxManager DropBox} on policy violation. Intended mostly for platform
 * integrators doing beta user field data collection.
 */

public android.os.StrictMode.VmPolicy.Builder penaltyDropBox() { throw new RuntimeException("Stub!"); }

/**
 * Call #{@link OnVmViolationListener#onVmViolation(Violation)} on every violation.
 
 * @param executor This value must never be {@code null}.

 * @param listener This value must never be {@code null}.
 */

public android.os.StrictMode.VmPolicy.Builder penaltyListener(@androidx.annotation.RecentlyNonNull java.util.concurrent.Executor executor, @androidx.annotation.RecentlyNonNull android.os.StrictMode.OnVmViolationListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Construct the VmPolicy instance.
 *
 * <p>Note: if no penalties are enabled before calling <code>build</code>, {@link
 * #penaltyLog} is implicitly set.
 */

public android.os.StrictMode.VmPolicy build() { throw new RuntimeException("Stub!"); }
}

}

}

