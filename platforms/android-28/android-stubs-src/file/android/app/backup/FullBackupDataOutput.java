
package android.app.backup;


/**
 * Provides the interface through which a {@link BackupAgent} writes entire files
 * to a full backup data set, via its {@link BackupAgent#onFullBackup(FullBackupDataOutput)}
 * method.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class FullBackupDataOutput {

/** @hide - used only in measure operation */

FullBackupDataOutput(long quota) { throw new RuntimeException("Stub!"); }

/**
 * Returns the quota in bytes for the application's current backup operation.  The
 * value can vary for each operation.
 *
 * @see BackupDataOutput#getQuota()
 */

public long getQuota() { throw new RuntimeException("Stub!"); }

/**
 * Returns flags with additional information about the backup transport. For supported flags see
 * {@link android.app.backup.BackupAgent}
 *
 * @see BackupDataOutput#getTransportFlags()
 */

public int getTransportFlags() { throw new RuntimeException("Stub!"); }
}

