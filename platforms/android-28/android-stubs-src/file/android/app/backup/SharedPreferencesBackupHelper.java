/*
 * Copyright (C) 2009 The Android Open Source Project
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


package android.app.backup;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import java.io.File;

/**
 * A helper class that can be used in conjunction with
 * {@link android.app.backup.BackupAgentHelper} to manage the backup of
 * {@link android.content.SharedPreferences}. Whenever a backup is performed, it
 * will back up all named shared preferences that have changed since the last
 * backup operation.
 * <p>
 * To use this class, the application's backup agent class should extend
 * {@link android.app.backup.BackupAgentHelper}.  Then, in the agent's
 * {@link BackupAgent#onCreate()} method, an instance of this class should be
 * allocated and installed as a backup/restore handler within the BackupAgentHelper
 * framework.  For example, an agent supporting backup and restore for
 * an application with two groups of {@link android.content.SharedPreferences}
 * data might look something like this:
 * <pre>
 * import android.app.backup.BackupAgentHelper;
 * import android.app.backup.SharedPreferencesBackupHelper;
 *
 * public class MyBackupAgent extends BackupAgentHelper {
 *     // The names of the SharedPreferences groups that the application maintains.  These
 *     // are the same strings that are passed to {@link Context#getSharedPreferences(String, int)}.
 *     static final String PREFS_DISPLAY = "displayprefs";
 *     static final String PREFS_SCORES = "highscores";
 *
 *     // An arbitrary string used within the BackupAgentHelper implementation to
 *     // identify the SharedPreferenceBackupHelper's data.
 *     static final String MY_PREFS_BACKUP_KEY = "myprefs";
 *
 *     // Simply allocate a helper and install it
 *     void onCreate() {
 *         SharedPreferencesBackupHelper helper =
 *                 new SharedPreferencesBackupHelper(this, PREFS_DISPLAY, PREFS_SCORES);
 *         addHelper(MY_PREFS_BACKUP_KEY, helper);
 *     }
 * }</pre>
 * <p>
 * No further implementation is needed; the {@link BackupAgentHelper} mechanism automatically
 * dispatches the
 * {@link BackupAgent#onBackup(android.os.ParcelFileDescriptor, BackupDataOutput, android.os.ParcelFileDescriptor) BackupAgent.onBackup()}
 * and
 * {@link BackupAgent#onRestore(BackupDataInput, int, android.os.ParcelFileDescriptor) BackupAgent.onRestore()}
 * callbacks to the SharedPreferencesBackupHelper as appropriate.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SharedPreferencesBackupHelper implements android.app.backup.BackupHelper {

/**
 * Construct a helper for backing up and restoring the
 * {@link android.content.SharedPreferences} under the given names.
 *
 * @param context The application {@link android.content.Context}
 * @param prefGroups The names of each {@link android.content.SharedPreferences} file to
 * back up
 */

public SharedPreferencesBackupHelper(android.content.Context context, java.lang.String... prefGroups) { throw new RuntimeException("Stub!"); }

/**
 * Backs up the configured {@link android.content.SharedPreferences} groups.
 */

public void performBackup(android.os.ParcelFileDescriptor oldState, android.app.backup.BackupDataOutput data, android.os.ParcelFileDescriptor newState) { throw new RuntimeException("Stub!"); }

/**
 * Restores one entity from the restore data stream to its proper shared
 * preferences file store.
 */

public void restoreEntity(android.app.backup.BackupDataInputStream data) { throw new RuntimeException("Stub!"); }

public void writeNewStateDescription(android.os.ParcelFileDescriptor fd) { throw new RuntimeException("Stub!"); }

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }
}

