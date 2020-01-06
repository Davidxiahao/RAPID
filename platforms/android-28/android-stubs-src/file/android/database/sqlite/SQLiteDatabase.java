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


package android.database.sqlite;

import java.util.List;
import java.util.Locale;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.Cursor;
import android.os.OperationCanceledException;
import android.content.ContentValues;
import android.util.Log;
import java.util.ArrayList;

/**
 * Exposes methods to manage a SQLite database.
 *
 * <p>
 * SQLiteDatabase has methods to create, delete, execute SQL commands, and
 * perform other common database management tasks.
 * </p><p>
 * See the Notepad sample application in the SDK for an example of creating
 * and managing a database.
 * </p><p>
 * Database names must be unique within an application, not across all applications.
 * </p>
 *
 * <h3>Localized Collation - ORDER BY</h3>
 * <p>
 * In addition to SQLite's default <code>BINARY</code> collator, Android supplies
 * two more, <code>LOCALIZED</code>, which changes with the system's current locale,
 * and <code>UNICODE</code>, which is the Unicode Collation Algorithm and not tailored
 * to the current locale.
 * </p>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SQLiteDatabase extends android.database.sqlite.SQLiteClosable {

SQLiteDatabase(java.lang.String path, int openFlags, android.database.sqlite.SQLiteDatabase.CursorFactory cursorFactory, android.database.DatabaseErrorHandler errorHandler, int lookasideSlotSize, int lookasideSlotCount, long idleConnectionTimeoutMs, java.lang.String journalMode, java.lang.String syncMode) { throw new RuntimeException("Stub!"); }

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

protected void onAllReferencesReleased() { throw new RuntimeException("Stub!"); }

/**
 * Attempts to release memory that SQLite holds but does not require to
 * operate properly. Typically this memory will come from the page cache.
 *
 * @return the number of bytes actually released
 */

public static int releaseMemory() { throw new RuntimeException("Stub!"); }

/**
 * Control whether or not the SQLiteDatabase is made thread-safe by using locks
 * around critical sections. This is pretty expensive, so if you know that your
 * DB will only be used by a single thread then you should set this to false.
 * The default is true.
 * @param lockingEnabled set to true to enable locks, false otherwise
 *
 * @deprecated This method now does nothing.  Do not use.
 */

@Deprecated public void setLockingEnabled(boolean lockingEnabled) { throw new RuntimeException("Stub!"); }

/**
 * Begins a transaction in EXCLUSIVE mode.
 * <p>
 * Transactions can be nested.
 * When the outer transaction is ended all of
 * the work done in that transaction and all of the nested transactions will be committed or
 * rolled back. The changes will be rolled back if any transaction is ended without being
 * marked as clean (by calling setTransactionSuccessful). Otherwise they will be committed.
 * </p>
 * <p>Here is the standard idiom for transactions:
 *
 * <pre>
 *   db.beginTransaction();
 *   try {
 *     ...
 *     db.setTransactionSuccessful();
 *   } finally {
 *     db.endTransaction();
 *   }
 * </pre>
 */

public void beginTransaction() { throw new RuntimeException("Stub!"); }

/**
 * Begins a transaction in IMMEDIATE mode. Transactions can be nested. When
 * the outer transaction is ended all of the work done in that transaction
 * and all of the nested transactions will be committed or rolled back. The
 * changes will be rolled back if any transaction is ended without being
 * marked as clean (by calling setTransactionSuccessful). Otherwise they
 * will be committed.
 * <p>
 * Here is the standard idiom for transactions:
 *
 * <pre>
 *   db.beginTransactionNonExclusive();
 *   try {
 *     ...
 *     db.setTransactionSuccessful();
 *   } finally {
 *     db.endTransaction();
 *   }
 * </pre>
 */

public void beginTransactionNonExclusive() { throw new RuntimeException("Stub!"); }

/**
 * Begins a transaction in EXCLUSIVE mode.
 * <p>
 * Transactions can be nested.
 * When the outer transaction is ended all of
 * the work done in that transaction and all of the nested transactions will be committed or
 * rolled back. The changes will be rolled back if any transaction is ended without being
 * marked as clean (by calling setTransactionSuccessful). Otherwise they will be committed.
 * </p>
 * <p>Here is the standard idiom for transactions:
 *
 * <pre>
 *   db.beginTransactionWithListener(listener);
 *   try {
 *     ...
 *     db.setTransactionSuccessful();
 *   } finally {
 *     db.endTransaction();
 *   }
 * </pre>
 *
 * @param transactionListener listener that should be notified when the transaction begins,
 * commits, or is rolled back, either explicitly or by a call to
 * {@link #yieldIfContendedSafely}.
 */

public void beginTransactionWithListener(android.database.sqlite.SQLiteTransactionListener transactionListener) { throw new RuntimeException("Stub!"); }

/**
 * Begins a transaction in IMMEDIATE mode. Transactions can be nested. When
 * the outer transaction is ended all of the work done in that transaction
 * and all of the nested transactions will be committed or rolled back. The
 * changes will be rolled back if any transaction is ended without being
 * marked as clean (by calling setTransactionSuccessful). Otherwise they
 * will be committed.
 * <p>
 * Here is the standard idiom for transactions:
 *
 * <pre>
 *   db.beginTransactionWithListenerNonExclusive(listener);
 *   try {
 *     ...
 *     db.setTransactionSuccessful();
 *   } finally {
 *     db.endTransaction();
 *   }
 * </pre>
 *
 * @param transactionListener listener that should be notified when the
 *            transaction begins, commits, or is rolled back, either
 *            explicitly or by a call to {@link #yieldIfContendedSafely}.
 */

public void beginTransactionWithListenerNonExclusive(android.database.sqlite.SQLiteTransactionListener transactionListener) { throw new RuntimeException("Stub!"); }

/**
 * End a transaction. See beginTransaction for notes about how to use this and when transactions
 * are committed and rolled back.
 */

public void endTransaction() { throw new RuntimeException("Stub!"); }

/**
 * Marks the current transaction as successful. Do not do any more database work between
 * calling this and calling endTransaction. Do as little non-database work as possible in that
 * situation too. If any errors are encountered between this and endTransaction the transaction
 * will still be committed.
 *
 * @throws IllegalStateException if the current thread is not in a transaction or the
 * transaction is already marked as successful.
 */

public void setTransactionSuccessful() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the current thread has a transaction pending.
 *
 * @return True if the current thread is in a transaction.
 */

public boolean inTransaction() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the current thread is holding an active connection to the database.
 * <p>
 * The name of this method comes from a time when having an active connection
 * to the database meant that the thread was holding an actual lock on the
 * database.  Nowadays, there is no longer a true "database lock" although threads
 * may block if they cannot acquire a database connection to perform a
 * particular operation.
 * </p>
 *
 * @return True if the current thread is holding an active connection to the database.
 */

public boolean isDbLockedByCurrentThread() { throw new RuntimeException("Stub!"); }

/**
 * Always returns false.
 * <p>
 * There is no longer the concept of a database lock, so this method always returns false.
 * </p>
 *
 * @return False.
 * @deprecated Always returns false.  Do not use this method.
 */

@Deprecated public boolean isDbLockedByOtherThreads() { throw new RuntimeException("Stub!"); }

/**
 * Temporarily end the transaction to let other threads run. The transaction is assumed to be
 * successful so far. Do not call setTransactionSuccessful before calling this. When this
 * returns a new transaction will have been created but not marked as successful.
 * @return true if the transaction was yielded
 * @deprecated if the db is locked more than once (becuase of nested transactions) then the lock
 *   will not be yielded. Use yieldIfContendedSafely instead.
 */

@Deprecated public boolean yieldIfContended() { throw new RuntimeException("Stub!"); }

/**
 * Temporarily end the transaction to let other threads run. The transaction is assumed to be
 * successful so far. Do not call setTransactionSuccessful before calling this. When this
 * returns a new transaction will have been created but not marked as successful. This assumes
 * that there are no nested transactions (beginTransaction has only been called once) and will
 * throw an exception if that is not the case.
 * @return true if the transaction was yielded
 */

public boolean yieldIfContendedSafely() { throw new RuntimeException("Stub!"); }

/**
 * Temporarily end the transaction to let other threads run. The transaction is assumed to be
 * successful so far. Do not call setTransactionSuccessful before calling this. When this
 * returns a new transaction will have been created but not marked as successful. This assumes
 * that there are no nested transactions (beginTransaction has only been called once) and will
 * throw an exception if that is not the case.
 * @param sleepAfterYieldDelay if > 0, sleep this long before starting a new transaction if
 *   the lock was actually yielded. This will allow other background threads to make some
 *   more progress than they would if we started the transaction immediately.
 * @return true if the transaction was yielded
 */

public boolean yieldIfContendedSafely(long sleepAfterYieldDelay) { throw new RuntimeException("Stub!"); }

/**
 * Deprecated.
 * @deprecated This method no longer serves any useful purpose and has been deprecated.
 */

@Deprecated public java.util.Map<java.lang.String, java.lang.String> getSyncedTables() { throw new RuntimeException("Stub!"); }

/**
 * Open the database according to the flags {@link #OPEN_READWRITE}
 * {@link #OPEN_READONLY} {@link #CREATE_IF_NECESSARY} and/or {@link #NO_LOCALIZED_COLLATORS}.
 *
 * <p>Sets the locale of the database to the  the system's current locale.
 * Call {@link #setLocale} if you would like something else.</p>
 *
 * @param path to database file to open and/or create
 * This value must never be {@code null}.
 * @param factory an optional factory class that is called to instantiate a
 *            cursor when query is called, or null for default
 * This value may be {@code null}.
 * @param flags to control database access mode
 * Value is either <code>0</code> or a combination of {@link android.database.sqlite.SQLiteDatabase#OPEN_READWRITE}, {@link android.database.sqlite.SQLiteDatabase#OPEN_READONLY}, {@link android.database.sqlite.SQLiteDatabase#CREATE_IF_NECESSARY}, {@link android.database.sqlite.SQLiteDatabase#NO_LOCALIZED_COLLATORS}, and {@link android.database.sqlite.SQLiteDatabase#ENABLE_WRITE_AHEAD_LOGGING}
 * @return the newly opened database
 * @throws SQLiteException if the database cannot be opened
 */

public static android.database.sqlite.SQLiteDatabase openDatabase(@androidx.annotation.RecentlyNonNull java.lang.String path, @androidx.annotation.RecentlyNullable android.database.sqlite.SQLiteDatabase.CursorFactory factory, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Open the database according to the specified {@link OpenParams parameters}
 *
 * @param path path to database file to open and/or create.
 * <p><strong>Important:</strong> The file should be constructed either from an absolute path or
 * by using {@link android.content.Context#getDatabasePath(String)}.
 * This value must never be {@code null}.
 * @param openParams configuration parameters that are used for opening {@link SQLiteDatabase}
 * This value must never be {@code null}.
 * @return the newly opened database
 * @throws SQLiteException if the database cannot be opened
 */

public static android.database.sqlite.SQLiteDatabase openDatabase(@androidx.annotation.RecentlyNonNull java.io.File path, @androidx.annotation.RecentlyNonNull android.database.sqlite.SQLiteDatabase.OpenParams openParams) { throw new RuntimeException("Stub!"); }

/**
 * Open the database according to the flags {@link #OPEN_READWRITE}
 * {@link #OPEN_READONLY} {@link #CREATE_IF_NECESSARY} and/or {@link #NO_LOCALIZED_COLLATORS}.
 *
 * <p>Sets the locale of the database to the  the system's current locale.
 * Call {@link #setLocale} if you would like something else.</p>
 *
 * <p>Accepts input param: a concrete instance of {@link DatabaseErrorHandler} to be
 * used to handle corruption when sqlite reports database corruption.</p>
 *
 * @param path to database file to open and/or create
 * This value must never be {@code null}.
 * @param factory an optional factory class that is called to instantiate a
 *            cursor when query is called, or null for default
 * This value may be {@code null}.
 * @param flags to control database access mode
 * Value is either <code>0</code> or a combination of {@link android.database.sqlite.SQLiteDatabase#OPEN_READWRITE}, {@link android.database.sqlite.SQLiteDatabase#OPEN_READONLY}, {@link android.database.sqlite.SQLiteDatabase#CREATE_IF_NECESSARY}, {@link android.database.sqlite.SQLiteDatabase#NO_LOCALIZED_COLLATORS}, and {@link android.database.sqlite.SQLiteDatabase#ENABLE_WRITE_AHEAD_LOGGING}
 * @param errorHandler the {@link DatabaseErrorHandler} obj to be used to handle corruption
 * when sqlite reports database corruption
 * This value may be {@code null}.
 * @return the newly opened database
 * @throws SQLiteException if the database cannot be opened
 */

public static android.database.sqlite.SQLiteDatabase openDatabase(@androidx.annotation.RecentlyNonNull java.lang.String path, @androidx.annotation.RecentlyNullable android.database.sqlite.SQLiteDatabase.CursorFactory factory, int flags, @androidx.annotation.RecentlyNullable android.database.DatabaseErrorHandler errorHandler) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to openDatabase(file.getPath(), factory, CREATE_IF_NECESSARY).
 
 * @param file This value must never be {@code null}.

 * @param factory This value may be {@code null}.
 */

public static android.database.sqlite.SQLiteDatabase openOrCreateDatabase(@androidx.annotation.RecentlyNonNull java.io.File file, @androidx.annotation.RecentlyNullable android.database.sqlite.SQLiteDatabase.CursorFactory factory) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to openDatabase(path, factory, CREATE_IF_NECESSARY).
 
 * @param path This value must never be {@code null}.

 * @param factory This value may be {@code null}.
 */

public static android.database.sqlite.SQLiteDatabase openOrCreateDatabase(@androidx.annotation.RecentlyNonNull java.lang.String path, @androidx.annotation.RecentlyNullable android.database.sqlite.SQLiteDatabase.CursorFactory factory) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to openDatabase(path, factory, CREATE_IF_NECESSARY, errorHandler).

 * @param path This value must never be {@code null}.
 
 * @param factory This value may be {@code null}.

 * @param errorHandler This value may be {@code null}.
 */

public static android.database.sqlite.SQLiteDatabase openOrCreateDatabase(@androidx.annotation.RecentlyNonNull java.lang.String path, @androidx.annotation.RecentlyNullable android.database.sqlite.SQLiteDatabase.CursorFactory factory, @androidx.annotation.RecentlyNullable android.database.DatabaseErrorHandler errorHandler) { throw new RuntimeException("Stub!"); }

/**
 * Deletes a database including its journal file and other auxiliary files
 * that may have been created by the database engine.
 *
 * @param file The database file path.
 * This value must never be {@code null}.
 * @return True if the database was successfully deleted.
 */

public static boolean deleteDatabase(@androidx.annotation.RecentlyNonNull java.io.File file) { throw new RuntimeException("Stub!"); }

/**
 * Create a memory backed SQLite database.  Its contents will be destroyed
 * when the database is closed.
 *
 * <p>Sets the locale of the database to the  the system's current locale.
 * Call {@link #setLocale} if you would like something else.</p>
 *
 * @param factory an optional factory class that is called to instantiate a
 *            cursor when query is called
 * This value may be {@code null}.
 * @return a SQLiteDatabase instance
 * This value will never be {@code null}.
 * @throws SQLiteException if the database cannot be created
 */

@androidx.annotation.RecentlyNonNull public static android.database.sqlite.SQLiteDatabase create(@androidx.annotation.RecentlyNullable android.database.sqlite.SQLiteDatabase.CursorFactory factory) { throw new RuntimeException("Stub!"); }

/**
 * Create a memory backed SQLite database.  Its contents will be destroyed
 * when the database is closed.
 *
 * <p>Sets the locale of the database to the  the system's current locale.
 * Call {@link #setLocale} if you would like something else.</p>
 * @param openParams configuration parameters that are used for opening SQLiteDatabase
 * This value must never be {@code null}.
 * @return a SQLiteDatabase instance
 * This value will never be {@code null}.
 * @throws SQLException if the database cannot be created
 */

@androidx.annotation.RecentlyNonNull public static android.database.sqlite.SQLiteDatabase createInMemory(@androidx.annotation.RecentlyNonNull android.database.sqlite.SQLiteDatabase.OpenParams openParams) { throw new RuntimeException("Stub!"); }

/**
 * Gets the database version.
 *
 * @return the database version
 */

public int getVersion() { throw new RuntimeException("Stub!"); }

/**
 * Sets the database version.
 *
 * @param version the new database version
 */

public void setVersion(int version) { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum size the database may grow to.
 *
 * @return the new maximum database size
 */

public long getMaximumSize() { throw new RuntimeException("Stub!"); }

/**
 * Sets the maximum size the database will grow to. The maximum size cannot
 * be set below the current size.
 *
 * @param numBytes the maximum database size, in bytes
 * @return the new maximum database size
 */

public long setMaximumSize(long numBytes) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current database page size, in bytes.
 *
 * @return the database page size, in bytes
 */

public long getPageSize() { throw new RuntimeException("Stub!"); }

/**
 * Sets the database page size. The page size must be a power of two. This
 * method does not work if any data has been written to the database file,
 * and must be called right after the database has been created.
 *
 * @param numBytes the database page size, in bytes
 */

public void setPageSize(long numBytes) { throw new RuntimeException("Stub!"); }

/**
 * Mark this table as syncable. When an update occurs in this table the
 * _sync_dirty field will be set to ensure proper syncing operation.
 *
 * @param table the table to mark as syncable
 * @param deletedTable The deleted table that corresponds to the
 *          syncable table
 * @deprecated This method no longer serves any useful purpose and has been deprecated.
 */

@Deprecated public void markTableSyncable(java.lang.String table, java.lang.String deletedTable) { throw new RuntimeException("Stub!"); }

/**
 * Mark this table as syncable, with the _sync_dirty residing in another
 * table. When an update occurs in this table the _sync_dirty field of the
 * row in updateTable with the _id in foreignKey will be set to
 * ensure proper syncing operation.
 *
 * @param table an update on this table will trigger a sync time removal
 * @param foreignKey this is the column in table whose value is an _id in
 *          updateTable
 * @param updateTable this is the table that will have its _sync_dirty
 * @deprecated This method no longer serves any useful purpose and has been deprecated.
 */

@Deprecated public void markTableSyncable(java.lang.String table, java.lang.String foreignKey, java.lang.String updateTable) { throw new RuntimeException("Stub!"); }

/**
 * Finds the name of the first table, which is editable.
 *
 * @param tables a list of tables
 * @return the first table listed
 */

public static java.lang.String findEditTable(java.lang.String tables) { throw new RuntimeException("Stub!"); }

/**
 * Compiles an SQL statement into a reusable pre-compiled statement object.
 * The parameters are identical to {@link #execSQL(String)}. You may put ?s in the
 * statement and fill in those values with {@link SQLiteProgram#bindString}
 * and {@link SQLiteProgram#bindLong} each time you want to run the
 * statement. Statements may not return result sets larger than 1x1.
 *<p>
 * No two threads should be using the same {@link SQLiteStatement} at the same time.
 *
 * @param sql The raw SQL statement, may contain ? for unknown values to be
 *            bound later.
 * @return A pre-compiled {@link SQLiteStatement} object. Note that
 * {@link SQLiteStatement}s are not synchronized, see the documentation for more details.
 */

public android.database.sqlite.SQLiteStatement compileStatement(java.lang.String sql) throws android.database.SQLException { throw new RuntimeException("Stub!"); }

/**
 * Query the given URL, returning a {@link Cursor} over the result set.
 *
 * @param distinct true if you want each row to be unique, false otherwise.
 * @param table The table name to compile the query against.
 * @param columns A list of which columns to return. Passing null will
 *            return all columns, which is discouraged to prevent reading
 *            data from storage that isn't going to be used.
 * @param selection A filter declaring which rows to return, formatted as an
 *            SQL WHERE clause (excluding the WHERE itself). Passing null
 *            will return all rows for the given table.
 * @param selectionArgs You may include ?s in selection, which will be
 *         replaced by the values from selectionArgs, in order that they
 *         appear in the selection. The values will be bound as Strings.
 * @param groupBy A filter declaring how to group rows, formatted as an SQL
 *            GROUP BY clause (excluding the GROUP BY itself). Passing null
 *            will cause the rows to not be grouped.
 * @param having A filter declare which row groups to include in the cursor,
 *            if row grouping is being used, formatted as an SQL HAVING
 *            clause (excluding the HAVING itself). Passing null will cause
 *            all row groups to be included, and is required when row
 *            grouping is not being used.
 * @param orderBy How to order the rows, formatted as an SQL ORDER BY clause
 *            (excluding the ORDER BY itself). Passing null will use the
 *            default sort order, which may be unordered.
 * @param limit Limits the number of rows returned by the query,
 *            formatted as LIMIT clause. Passing null denotes no LIMIT clause.
 * @return A {@link Cursor} object, which is positioned before the first entry. Note that
 * {@link Cursor}s are not synchronized, see the documentation for more details.
 * @see Cursor
 */

public android.database.Cursor query(boolean distinct, java.lang.String table, java.lang.String[] columns, java.lang.String selection, java.lang.String[] selectionArgs, java.lang.String groupBy, java.lang.String having, java.lang.String orderBy, java.lang.String limit) { throw new RuntimeException("Stub!"); }

/**
 * Query the given URL, returning a {@link Cursor} over the result set.
 *
 * @param distinct true if you want each row to be unique, false otherwise.
 * @param table The table name to compile the query against.
 * @param columns A list of which columns to return. Passing null will
 *            return all columns, which is discouraged to prevent reading
 *            data from storage that isn't going to be used.
 * @param selection A filter declaring which rows to return, formatted as an
 *            SQL WHERE clause (excluding the WHERE itself). Passing null
 *            will return all rows for the given table.
 * @param selectionArgs You may include ?s in selection, which will be
 *         replaced by the values from selectionArgs, in order that they
 *         appear in the selection. The values will be bound as Strings.
 * @param groupBy A filter declaring how to group rows, formatted as an SQL
 *            GROUP BY clause (excluding the GROUP BY itself). Passing null
 *            will cause the rows to not be grouped.
 * @param having A filter declare which row groups to include in the cursor,
 *            if row grouping is being used, formatted as an SQL HAVING
 *            clause (excluding the HAVING itself). Passing null will cause
 *            all row groups to be included, and is required when row
 *            grouping is not being used.
 * @param orderBy How to order the rows, formatted as an SQL ORDER BY clause
 *            (excluding the ORDER BY itself). Passing null will use the
 *            default sort order, which may be unordered.
 * @param limit Limits the number of rows returned by the query,
 *            formatted as LIMIT clause. Passing null denotes no LIMIT clause.
 * @param cancellationSignal A signal to cancel the operation in progress, or null if none.
 * If the operation is canceled, then {@link OperationCanceledException} will be thrown
 * when the query is executed.
 * @return A {@link Cursor} object, which is positioned before the first entry. Note that
 * {@link Cursor}s are not synchronized, see the documentation for more details.
 * @see Cursor
 */

public android.database.Cursor query(boolean distinct, java.lang.String table, java.lang.String[] columns, java.lang.String selection, java.lang.String[] selectionArgs, java.lang.String groupBy, java.lang.String having, java.lang.String orderBy, java.lang.String limit, android.os.CancellationSignal cancellationSignal) { throw new RuntimeException("Stub!"); }

/**
 * Query the given URL, returning a {@link Cursor} over the result set.
 *
 * @param cursorFactory the cursor factory to use, or null for the default factory
 * @param distinct true if you want each row to be unique, false otherwise.
 * @param table The table name to compile the query against.
 * @param columns A list of which columns to return. Passing null will
 *            return all columns, which is discouraged to prevent reading
 *            data from storage that isn't going to be used.
 * @param selection A filter declaring which rows to return, formatted as an
 *            SQL WHERE clause (excluding the WHERE itself). Passing null
 *            will return all rows for the given table.
 * @param selectionArgs You may include ?s in selection, which will be
 *         replaced by the values from selectionArgs, in order that they
 *         appear in the selection. The values will be bound as Strings.
 * @param groupBy A filter declaring how to group rows, formatted as an SQL
 *            GROUP BY clause (excluding the GROUP BY itself). Passing null
 *            will cause the rows to not be grouped.
 * @param having A filter declare which row groups to include in the cursor,
 *            if row grouping is being used, formatted as an SQL HAVING
 *            clause (excluding the HAVING itself). Passing null will cause
 *            all row groups to be included, and is required when row
 *            grouping is not being used.
 * @param orderBy How to order the rows, formatted as an SQL ORDER BY clause
 *            (excluding the ORDER BY itself). Passing null will use the
 *            default sort order, which may be unordered.
 * @param limit Limits the number of rows returned by the query,
 *            formatted as LIMIT clause. Passing null denotes no LIMIT clause.
 * @return A {@link Cursor} object, which is positioned before the first entry. Note that
 * {@link Cursor}s are not synchronized, see the documentation for more details.
 * @see Cursor
 */

public android.database.Cursor queryWithFactory(android.database.sqlite.SQLiteDatabase.CursorFactory cursorFactory, boolean distinct, java.lang.String table, java.lang.String[] columns, java.lang.String selection, java.lang.String[] selectionArgs, java.lang.String groupBy, java.lang.String having, java.lang.String orderBy, java.lang.String limit) { throw new RuntimeException("Stub!"); }

/**
 * Query the given URL, returning a {@link Cursor} over the result set.
 *
 * @param cursorFactory the cursor factory to use, or null for the default factory
 * @param distinct true if you want each row to be unique, false otherwise.
 * @param table The table name to compile the query against.
 * @param columns A list of which columns to return. Passing null will
 *            return all columns, which is discouraged to prevent reading
 *            data from storage that isn't going to be used.
 * @param selection A filter declaring which rows to return, formatted as an
 *            SQL WHERE clause (excluding the WHERE itself). Passing null
 *            will return all rows for the given table.
 * @param selectionArgs You may include ?s in selection, which will be
 *         replaced by the values from selectionArgs, in order that they
 *         appear in the selection. The values will be bound as Strings.
 * @param groupBy A filter declaring how to group rows, formatted as an SQL
 *            GROUP BY clause (excluding the GROUP BY itself). Passing null
 *            will cause the rows to not be grouped.
 * @param having A filter declare which row groups to include in the cursor,
 *            if row grouping is being used, formatted as an SQL HAVING
 *            clause (excluding the HAVING itself). Passing null will cause
 *            all row groups to be included, and is required when row
 *            grouping is not being used.
 * @param orderBy How to order the rows, formatted as an SQL ORDER BY clause
 *            (excluding the ORDER BY itself). Passing null will use the
 *            default sort order, which may be unordered.
 * @param limit Limits the number of rows returned by the query,
 *            formatted as LIMIT clause. Passing null denotes no LIMIT clause.
 * @param cancellationSignal A signal to cancel the operation in progress, or null if none.
 * If the operation is canceled, then {@link OperationCanceledException} will be thrown
 * when the query is executed.
 * @return A {@link Cursor} object, which is positioned before the first entry. Note that
 * {@link Cursor}s are not synchronized, see the documentation for more details.
 * @see Cursor
 */

public android.database.Cursor queryWithFactory(android.database.sqlite.SQLiteDatabase.CursorFactory cursorFactory, boolean distinct, java.lang.String table, java.lang.String[] columns, java.lang.String selection, java.lang.String[] selectionArgs, java.lang.String groupBy, java.lang.String having, java.lang.String orderBy, java.lang.String limit, android.os.CancellationSignal cancellationSignal) { throw new RuntimeException("Stub!"); }

/**
 * Query the given table, returning a {@link Cursor} over the result set.
 *
 * @param table The table name to compile the query against.
 * @param columns A list of which columns to return. Passing null will
 *            return all columns, which is discouraged to prevent reading
 *            data from storage that isn't going to be used.
 * @param selection A filter declaring which rows to return, formatted as an
 *            SQL WHERE clause (excluding the WHERE itself). Passing null
 *            will return all rows for the given table.
 * @param selectionArgs You may include ?s in selection, which will be
 *         replaced by the values from selectionArgs, in order that they
 *         appear in the selection. The values will be bound as Strings.
 * @param groupBy A filter declaring how to group rows, formatted as an SQL
 *            GROUP BY clause (excluding the GROUP BY itself). Passing null
 *            will cause the rows to not be grouped.
 * @param having A filter declare which row groups to include in the cursor,
 *            if row grouping is being used, formatted as an SQL HAVING
 *            clause (excluding the HAVING itself). Passing null will cause
 *            all row groups to be included, and is required when row
 *            grouping is not being used.
 * @param orderBy How to order the rows, formatted as an SQL ORDER BY clause
 *            (excluding the ORDER BY itself). Passing null will use the
 *            default sort order, which may be unordered.
 * @return A {@link Cursor} object, which is positioned before the first entry. Note that
 * {@link Cursor}s are not synchronized, see the documentation for more details.
 * @see Cursor
 */

public android.database.Cursor query(java.lang.String table, java.lang.String[] columns, java.lang.String selection, java.lang.String[] selectionArgs, java.lang.String groupBy, java.lang.String having, java.lang.String orderBy) { throw new RuntimeException("Stub!"); }

/**
 * Query the given table, returning a {@link Cursor} over the result set.
 *
 * @param table The table name to compile the query against.
 * @param columns A list of which columns to return. Passing null will
 *            return all columns, which is discouraged to prevent reading
 *            data from storage that isn't going to be used.
 * @param selection A filter declaring which rows to return, formatted as an
 *            SQL WHERE clause (excluding the WHERE itself). Passing null
 *            will return all rows for the given table.
 * @param selectionArgs You may include ?s in selection, which will be
 *         replaced by the values from selectionArgs, in order that they
 *         appear in the selection. The values will be bound as Strings.
 * @param groupBy A filter declaring how to group rows, formatted as an SQL
 *            GROUP BY clause (excluding the GROUP BY itself). Passing null
 *            will cause the rows to not be grouped.
 * @param having A filter declare which row groups to include in the cursor,
 *            if row grouping is being used, formatted as an SQL HAVING
 *            clause (excluding the HAVING itself). Passing null will cause
 *            all row groups to be included, and is required when row
 *            grouping is not being used.
 * @param orderBy How to order the rows, formatted as an SQL ORDER BY clause
 *            (excluding the ORDER BY itself). Passing null will use the
 *            default sort order, which may be unordered.
 * @param limit Limits the number of rows returned by the query,
 *            formatted as LIMIT clause. Passing null denotes no LIMIT clause.
 * @return A {@link Cursor} object, which is positioned before the first entry. Note that
 * {@link Cursor}s are not synchronized, see the documentation for more details.
 * @see Cursor
 */

public android.database.Cursor query(java.lang.String table, java.lang.String[] columns, java.lang.String selection, java.lang.String[] selectionArgs, java.lang.String groupBy, java.lang.String having, java.lang.String orderBy, java.lang.String limit) { throw new RuntimeException("Stub!"); }

/**
 * Runs the provided SQL and returns a {@link Cursor} over the result set.
 *
 * @param sql the SQL query. The SQL string must not be ; terminated
 * @param selectionArgs You may include ?s in where clause in the query,
 *     which will be replaced by the values from selectionArgs. The
 *     values will be bound as Strings.
 * @return A {@link Cursor} object, which is positioned before the first entry. Note that
 * {@link Cursor}s are not synchronized, see the documentation for more details.
 */

public android.database.Cursor rawQuery(java.lang.String sql, java.lang.String[] selectionArgs) { throw new RuntimeException("Stub!"); }

/**
 * Runs the provided SQL and returns a {@link Cursor} over the result set.
 *
 * @param sql the SQL query. The SQL string must not be ; terminated
 * @param selectionArgs You may include ?s in where clause in the query,
 *     which will be replaced by the values from selectionArgs. The
 *     values will be bound as Strings.
 * @param cancellationSignal A signal to cancel the operation in progress, or null if none.
 * If the operation is canceled, then {@link OperationCanceledException} will be thrown
 * when the query is executed.
 * @return A {@link Cursor} object, which is positioned before the first entry. Note that
 * {@link Cursor}s are not synchronized, see the documentation for more details.
 */

public android.database.Cursor rawQuery(java.lang.String sql, java.lang.String[] selectionArgs, android.os.CancellationSignal cancellationSignal) { throw new RuntimeException("Stub!"); }

/**
 * Runs the provided SQL and returns a cursor over the result set.
 *
 * @param cursorFactory the cursor factory to use, or null for the default factory
 * @param sql the SQL query. The SQL string must not be ; terminated
 * @param selectionArgs You may include ?s in where clause in the query,
 *     which will be replaced by the values from selectionArgs. The
 *     values will be bound as Strings.
 * @param editTable the name of the first table, which is editable
 * @return A {@link Cursor} object, which is positioned before the first entry. Note that
 * {@link Cursor}s are not synchronized, see the documentation for more details.
 */

public android.database.Cursor rawQueryWithFactory(android.database.sqlite.SQLiteDatabase.CursorFactory cursorFactory, java.lang.String sql, java.lang.String[] selectionArgs, java.lang.String editTable) { throw new RuntimeException("Stub!"); }

/**
 * Runs the provided SQL and returns a cursor over the result set.
 *
 * @param cursorFactory the cursor factory to use, or null for the default factory
 * @param sql the SQL query. The SQL string must not be ; terminated
 * @param selectionArgs You may include ?s in where clause in the query,
 *     which will be replaced by the values from selectionArgs. The
 *     values will be bound as Strings.
 * @param editTable the name of the first table, which is editable
 * @param cancellationSignal A signal to cancel the operation in progress, or null if none.
 * If the operation is canceled, then {@link OperationCanceledException} will be thrown
 * when the query is executed.
 * @return A {@link Cursor} object, which is positioned before the first entry. Note that
 * {@link Cursor}s are not synchronized, see the documentation for more details.
 */

public android.database.Cursor rawQueryWithFactory(android.database.sqlite.SQLiteDatabase.CursorFactory cursorFactory, java.lang.String sql, java.lang.String[] selectionArgs, java.lang.String editTable, android.os.CancellationSignal cancellationSignal) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method for inserting a row into the database.
 *
 * @param table the table to insert the row into
 * @param nullColumnHack optional; may be <code>null</code>.
 *            SQL doesn't allow inserting a completely empty row without
 *            naming at least one column name.  If your provided <code>values</code> is
 *            empty, no column names are known and an empty row can't be inserted.
 *            If not set to null, the <code>nullColumnHack</code> parameter
 *            provides the name of nullable column name to explicitly insert a NULL into
 *            in the case where your <code>values</code> is empty.
 * @param values this map contains the initial column values for the
 *            row. The keys should be the column names and the values the
 *            column values
 * @return the row ID of the newly inserted row, or -1 if an error occurred
 */

public long insert(java.lang.String table, java.lang.String nullColumnHack, android.content.ContentValues values) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method for inserting a row into the database.
 *
 * @param table the table to insert the row into
 * @param nullColumnHack optional; may be <code>null</code>.
 *            SQL doesn't allow inserting a completely empty row without
 *            naming at least one column name.  If your provided <code>values</code> is
 *            empty, no column names are known and an empty row can't be inserted.
 *            If not set to null, the <code>nullColumnHack</code> parameter
 *            provides the name of nullable column name to explicitly insert a NULL into
 *            in the case where your <code>values</code> is empty.
 * @param values this map contains the initial column values for the
 *            row. The keys should be the column names and the values the
 *            column values
 * @throws SQLException
 * @return the row ID of the newly inserted row, or -1 if an error occurred
 */

public long insertOrThrow(java.lang.String table, java.lang.String nullColumnHack, android.content.ContentValues values) throws android.database.SQLException { throw new RuntimeException("Stub!"); }

/**
 * Convenience method for replacing a row in the database.
 * Inserts a new row if a row does not already exist.
 *
 * @param table the table in which to replace the row
 * @param nullColumnHack optional; may be <code>null</code>.
 *            SQL doesn't allow inserting a completely empty row without
 *            naming at least one column name.  If your provided <code>initialValues</code> is
 *            empty, no column names are known and an empty row can't be inserted.
 *            If not set to null, the <code>nullColumnHack</code> parameter
 *            provides the name of nullable column name to explicitly insert a NULL into
 *            in the case where your <code>initialValues</code> is empty.
 * @param initialValues this map contains the initial column values for
 *   the row. The keys should be the column names and the values the column values.
 * @return the row ID of the newly inserted row, or -1 if an error occurred
 */

public long replace(java.lang.String table, java.lang.String nullColumnHack, android.content.ContentValues initialValues) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method for replacing a row in the database.
 * Inserts a new row if a row does not already exist.
 *
 * @param table the table in which to replace the row
 * @param nullColumnHack optional; may be <code>null</code>.
 *            SQL doesn't allow inserting a completely empty row without
 *            naming at least one column name.  If your provided <code>initialValues</code> is
 *            empty, no column names are known and an empty row can't be inserted.
 *            If not set to null, the <code>nullColumnHack</code> parameter
 *            provides the name of nullable column name to explicitly insert a NULL into
 *            in the case where your <code>initialValues</code> is empty.
 * @param initialValues this map contains the initial column values for
 *   the row. The keys should be the column names and the values the column values.
 * @throws SQLException
 * @return the row ID of the newly inserted row, or -1 if an error occurred
 */

public long replaceOrThrow(java.lang.String table, java.lang.String nullColumnHack, android.content.ContentValues initialValues) throws android.database.SQLException { throw new RuntimeException("Stub!"); }

/**
 * General method for inserting a row into the database.
 *
 * @param table the table to insert the row into
 * @param nullColumnHack optional; may be <code>null</code>.
 *            SQL doesn't allow inserting a completely empty row without
 *            naming at least one column name.  If your provided <code>initialValues</code> is
 *            empty, no column names are known and an empty row can't be inserted.
 *            If not set to null, the <code>nullColumnHack</code> parameter
 *            provides the name of nullable column name to explicitly insert a NULL into
 *            in the case where your <code>initialValues</code> is empty.
 * @param initialValues this map contains the initial column values for the
 *            row. The keys should be the column names and the values the
 *            column values
 * @param conflictAlgorithm for insert conflict resolver
 * @return the row ID of the newly inserted row OR <code>-1</code> if either the
 *            input parameter <code>conflictAlgorithm</code> = {@link #CONFLICT_IGNORE}
 *            or an error occurred.
 */

public long insertWithOnConflict(java.lang.String table, java.lang.String nullColumnHack, android.content.ContentValues initialValues, int conflictAlgorithm) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method for deleting rows in the database.
 *
 * @param table the table to delete from
 * @param whereClause the optional WHERE clause to apply when deleting.
 *            Passing null will delete all rows.
 * @param whereArgs You may include ?s in the where clause, which
 *            will be replaced by the values from whereArgs. The values
 *            will be bound as Strings.
 * @return the number of rows affected if a whereClause is passed in, 0
 *         otherwise. To remove all rows and get a count pass "1" as the
 *         whereClause.
 */

public int delete(java.lang.String table, java.lang.String whereClause, java.lang.String[] whereArgs) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method for updating rows in the database.
 *
 * @param table the table to update in
 * @param values a map from column names to new column values. null is a
 *            valid value that will be translated to NULL.
 * @param whereClause the optional WHERE clause to apply when updating.
 *            Passing null will update all rows.
 * @param whereArgs You may include ?s in the where clause, which
 *            will be replaced by the values from whereArgs. The values
 *            will be bound as Strings.
 * @return the number of rows affected
 */

public int update(java.lang.String table, android.content.ContentValues values, java.lang.String whereClause, java.lang.String[] whereArgs) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method for updating rows in the database.
 *
 * @param table the table to update in
 * @param values a map from column names to new column values. null is a
 *            valid value that will be translated to NULL.
 * @param whereClause the optional WHERE clause to apply when updating.
 *            Passing null will update all rows.
 * @param whereArgs You may include ?s in the where clause, which
 *            will be replaced by the values from whereArgs. The values
 *            will be bound as Strings.
 * @param conflictAlgorithm for update conflict resolver
 * @return the number of rows affected
 */

public int updateWithOnConflict(java.lang.String table, android.content.ContentValues values, java.lang.String whereClause, java.lang.String[] whereArgs, int conflictAlgorithm) { throw new RuntimeException("Stub!"); }

/**
 * Execute a single SQL statement that is NOT a SELECT
 * or any other SQL statement that returns data.
 * <p>
 * It has no means to return any data (such as the number of affected rows).
 * Instead, you're encouraged to use {@link #insert(String, String, ContentValues)},
 * {@link #update(String, ContentValues, String, String[])}, et al, when possible.
 * </p>
 * <p>
 * When using {@link #enableWriteAheadLogging()}, journal_mode is
 * automatically managed by this class. So, do not set journal_mode
 * using "PRAGMA journal_mode'<value>" statement if your app is using
 * {@link #enableWriteAheadLogging()}
 * </p>
 *
 * @param sql the SQL statement to be executed. Multiple statements separated by semicolons are
 * not supported.
 * @throws SQLException if the SQL string is invalid
 */

public void execSQL(java.lang.String sql) throws android.database.SQLException { throw new RuntimeException("Stub!"); }

/**
 * Execute a single SQL statement that is NOT a SELECT/INSERT/UPDATE/DELETE.
 * <p>
 * For INSERT statements, use any of the following instead.
 * <ul>
 *   <li>{@link #insert(String, String, ContentValues)}</li>
 *   <li>{@link #insertOrThrow(String, String, ContentValues)}</li>
 *   <li>{@link #insertWithOnConflict(String, String, ContentValues, int)}</li>
 * </ul>
 * <p>
 * For UPDATE statements, use any of the following instead.
 * <ul>
 *   <li>{@link #update(String, ContentValues, String, String[])}</li>
 *   <li>{@link #updateWithOnConflict(String, ContentValues, String, String[], int)}</li>
 * </ul>
 * <p>
 * For DELETE statements, use any of the following instead.
 * <ul>
 *   <li>{@link #delete(String, String, String[])}</li>
 * </ul>
 * <p>
 * For example, the following are good candidates for using this method:
 * <ul>
 *   <li>ALTER TABLE</li>
 *   <li>CREATE or DROP table / trigger / view / index / virtual table</li>
 *   <li>REINDEX</li>
 *   <li>RELEASE</li>
 *   <li>SAVEPOINT</li>
 *   <li>PRAGMA that returns no data</li>
 * </ul>
 * </p>
 * <p>
 * When using {@link #enableWriteAheadLogging()}, journal_mode is
 * automatically managed by this class. So, do not set journal_mode
 * using "PRAGMA journal_mode'<value>" statement if your app is using
 * {@link #enableWriteAheadLogging()}
 * </p>
 *
 * @param sql the SQL statement to be executed. Multiple statements separated by semicolons are
 * not supported.
 * @param bindArgs only byte[], String, Long and Double are supported in bindArgs.
 * @throws SQLException if the SQL string is invalid
 */

public void execSQL(java.lang.String sql, java.lang.Object[] bindArgs) throws android.database.SQLException { throw new RuntimeException("Stub!"); }

/**
 * Verifies that a SQL SELECT statement is valid by compiling it.
 * If the SQL statement is not valid, this method will throw a {@link SQLiteException}.
 *
 * @param sql SQL to be validated
 * This value must never be {@code null}.
 * @param cancellationSignal A signal to cancel the operation in progress, or null if none.
 * If the operation is canceled, then {@link OperationCanceledException} will be thrown
 * when the query is executed.
 * This value may be {@code null}.
 * @throws SQLiteException if {@code sql} is invalid
 */

public void validateSql(@androidx.annotation.RecentlyNonNull java.lang.String sql, @androidx.annotation.RecentlyNullable android.os.CancellationSignal cancellationSignal) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the database is opened as read only.
 *
 * @return True if database is opened as read only.
 */

public boolean isReadOnly() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the database is currently open.
 *
 * @return True if the database is currently open (has not been closed).
 */

public boolean isOpen() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the new version code is greater than the current database version.
 *
 * @param newVersion The new version code.
 * @return True if the new version code is greater than the current database version.
 */

public boolean needUpgrade(int newVersion) { throw new RuntimeException("Stub!"); }

/**
 * Gets the path to the database file.
 *
 * @return The path to the database file.
 */

public java.lang.String getPath() { throw new RuntimeException("Stub!"); }

/**
 * Sets the locale for this database.  Does nothing if this database has
 * the {@link #NO_LOCALIZED_COLLATORS} flag set or was opened read only.
 *
 * @param locale The new locale.
 *
 * @throws SQLException if the locale could not be set.  The most common reason
 * for this is that there is no collator available for the locale you requested.
 * In this case the database remains unchanged.
 */

public void setLocale(java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Sets the maximum size of the prepared-statement cache for this database.
 * (size of the cache = number of compiled-sql-statements stored in the cache).
 *<p>
 * Maximum cache size can ONLY be increased from its current size (default = 10).
 * If this method is called with smaller size than the current maximum value,
 * then IllegalStateException is thrown.
 *<p>
 * This method is thread-safe.
 *
 * @param cacheSize the size of the cache. can be (0 to {@link #MAX_SQL_CACHE_SIZE})
 * @throws IllegalStateException if input cacheSize > {@link #MAX_SQL_CACHE_SIZE}.
 */

public void setMaxSqlCacheSize(int cacheSize) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether foreign key constraints are enabled for the database.
 * <p>
 * By default, foreign key constraints are not enforced by the database.
 * This method allows an application to enable foreign key constraints.
 * It must be called each time the database is opened to ensure that foreign
 * key constraints are enabled for the session.
 * </p><p>
 * A good time to call this method is right after calling {@link #openOrCreateDatabase}
 * or in the {@link SQLiteOpenHelper#onConfigure} callback.
 * </p><p>
 * When foreign key constraints are disabled, the database does not check whether
 * changes to the database will violate foreign key constraints.  Likewise, when
 * foreign key constraints are disabled, the database will not execute cascade
 * delete or update triggers.  As a result, it is possible for the database
 * state to become inconsistent.  To perform a database integrity check,
 * call {@link #isDatabaseIntegrityOk}.
 * </p><p>
 * This method must not be called while a transaction is in progress.
 * </p><p>
 * See also <a href="http://sqlite.org/foreignkeys.html">SQLite Foreign Key Constraints</a>
 * for more details about foreign key constraint support.
 * </p>
 *
 * @param enable True to enable foreign key constraints, false to disable them.
 *
 * @throws IllegalStateException if the are transactions is in progress
 * when this method is called.
 */

public void setForeignKeyConstraintsEnabled(boolean enable) { throw new RuntimeException("Stub!"); }

/**
 * This method enables parallel execution of queries from multiple threads on the
 * same database.  It does this by opening multiple connections to the database
 * and using a different database connection for each query.  The database
 * journal mode is also changed to enable writes to proceed concurrently with reads.
 * <p>
 * When write-ahead logging is not enabled (the default), it is not possible for
 * reads and writes to occur on the database at the same time.  Before modifying the
 * database, the writer implicitly acquires an exclusive lock on the database which
 * prevents readers from accessing the database until the write is completed.
 * </p><p>
 * In contrast, when write-ahead logging is enabled (by calling this method), write
 * operations occur in a separate log file which allows reads to proceed concurrently.
 * While a write is in progress, readers on other threads will perceive the state
 * of the database as it was before the write began.  When the write completes, readers
 * on other threads will then perceive the new state of the database.
 * </p><p>
 * It is a good idea to enable write-ahead logging whenever a database will be
 * concurrently accessed and modified by multiple threads at the same time.
 * However, write-ahead logging uses significantly more memory than ordinary
 * journaling because there are multiple connections to the same database.
 * So if a database will only be used by a single thread, or if optimizing
 * concurrency is not very important, then write-ahead logging should be disabled.
 * </p><p>
 * After calling this method, execution of queries in parallel is enabled as long as
 * the database remains open.  To disable execution of queries in parallel, either
 * call {@link #disableWriteAheadLogging} or close the database and reopen it.
 * </p><p>
 * The maximum number of connections used to execute queries in parallel is
 * dependent upon the device memory and possibly other properties.
 * </p><p>
 * If a query is part of a transaction, then it is executed on the same database handle the
 * transaction was begun.
 * </p><p>
 * Writers should use {@link #beginTransactionNonExclusive()} or
 * {@link #beginTransactionWithListenerNonExclusive(SQLiteTransactionListener)}
 * to start a transaction.  Non-exclusive mode allows database file to be in readable
 * by other threads executing queries.
 * </p><p>
 * If the database has any attached databases, then execution of queries in parallel is NOT
 * possible.  Likewise, write-ahead logging is not supported for read-only databases
 * or memory databases.  In such cases, {@link #enableWriteAheadLogging} returns false.
 * </p><p>
 * The best way to enable write-ahead logging is to pass the
 * {@link #ENABLE_WRITE_AHEAD_LOGGING} flag to {@link #openDatabase}.  This is
 * more efficient than calling {@link #enableWriteAheadLogging}.
 * <code><pre>
 *     SQLiteDatabase db = SQLiteDatabase.openDatabase("db_filename", cursorFactory,
 *             SQLiteDatabase.CREATE_IF_NECESSARY | SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING,
 *             myDatabaseErrorHandler);
 * </pre></code>
 * </p><p>
 * Another way to enable write-ahead logging is to call {@link #enableWriteAheadLogging}
 * after opening the database.
 * <code><pre>
 *     SQLiteDatabase db = SQLiteDatabase.openDatabase("db_filename", cursorFactory,
 *             SQLiteDatabase.CREATE_IF_NECESSARY, myDatabaseErrorHandler);
 *     db.enableWriteAheadLogging();
 * </pre></code>
 * </p><p>
 * See also <a href="http://sqlite.org/wal.html">SQLite Write-Ahead Logging</a> for
 * more details about how write-ahead logging works.
 * </p>
 *
 * @return True if write-ahead logging is enabled.
 *
 * @throws IllegalStateException if there are transactions in progress at the
 * time this method is called.  WAL mode can only be changed when there are no
 * transactions in progress.
 *
 * @see #ENABLE_WRITE_AHEAD_LOGGING
 * @see #disableWriteAheadLogging
 */

public boolean enableWriteAheadLogging() { throw new RuntimeException("Stub!"); }

/**
 * This method disables the features enabled by {@link #enableWriteAheadLogging()}.
 *
 * @throws IllegalStateException if there are transactions in progress at the
 * time this method is called.  WAL mode can only be changed when there are no
 * transactions in progress.
 *
 * @see #enableWriteAheadLogging
 */

public void disableWriteAheadLogging() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if write-ahead logging has been enabled for this database.
 *
 * @return True if write-ahead logging has been enabled for this database.
 *
 * @see #enableWriteAheadLogging
 * @see #ENABLE_WRITE_AHEAD_LOGGING
 */

public boolean isWriteAheadLoggingEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Returns list of full pathnames of all attached databases including the main database
 * by executing 'pragma database_list' on the database.
 *
 * @return ArrayList of pairs of (database name, database file path) or null if the database
 * is not open.
 */

public java.util.List<android.util.Pair<java.lang.String, java.lang.String>> getAttachedDbs() { throw new RuntimeException("Stub!"); }

/**
 * Runs 'pragma integrity_check' on the given database (and all the attached databases)
 * and returns true if the given database (and all its attached databases) pass integrity_check,
 * false otherwise.
 *<p>
 * If the result is false, then this method logs the errors reported by the integrity_check
 * command execution.
 *<p>
 * Note that 'pragma integrity_check' on a database can take a long time.
 *
 * @return true if the given database (and all its attached databases) pass integrity_check,
 * false otherwise.
 */

public boolean isDatabaseIntegrityOk() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * When a constraint violation occurs,no ROLLBACK is executed
 * so changes from prior commands within the same transaction
 * are preserved. This is the default behavior.
 */

public static final int CONFLICT_ABORT = 2; // 0x2

/**
 * When a constraint violation occurs, the command aborts with a return
 * code SQLITE_CONSTRAINT. But any changes to the database that
 * the command made prior to encountering the constraint violation
 * are preserved and are not backed out.
 */

public static final int CONFLICT_FAIL = 3; // 0x3

/**
 * When a constraint violation occurs, the one row that contains
 * the constraint violation is not inserted or changed.
 * But the command continues executing normally. Other rows before and
 * after the row that contained the constraint violation continue to be
 * inserted or updated normally. No error is returned.
 */

public static final int CONFLICT_IGNORE = 4; // 0x4

/**
 * Use the following when no conflict action is specified.
 */

public static final int CONFLICT_NONE = 0; // 0x0

/**
 * When a UNIQUE constraint violation occurs, the pre-existing rows that
 * are causing the constraint violation are removed prior to inserting
 * or updating the current row. Thus the insert or update always occurs.
 * The command continues executing normally. No error is returned.
 * If a NOT NULL constraint violation occurs, the NULL value is replaced
 * by the default value for that column. If the column has no default
 * value, then the ABORT algorithm is used. If a CHECK constraint
 * violation occurs then the IGNORE algorithm is used. When this conflict
 * resolution strategy deletes rows in order to satisfy a constraint,
 * it does not invoke delete triggers on those rows.
 * This behavior might change in a future release.
 */

public static final int CONFLICT_REPLACE = 5; // 0x5

/**
 * When a constraint violation occurs, an immediate ROLLBACK occurs,
 * thus ending the current transaction, and the command aborts with a
 * return code of SQLITE_CONSTRAINT. If no transaction is active
 * (other than the implied transaction that is created on every command)
 * then this algorithm works the same as ABORT.
 */

public static final int CONFLICT_ROLLBACK = 1; // 0x1

/**
 * Open flag: Flag for {@link #openDatabase} to create the database file if it does not
 * already exist.
 */

public static final int CREATE_IF_NECESSARY = 268435456; // 0x10000000

/**
 * Open flag: Flag for {@link #openDatabase} to open the database file with
 * write-ahead logging enabled by default.  Using this flag is more efficient
 * than calling {@link #enableWriteAheadLogging}.
 *
 * Write-ahead logging cannot be used with read-only databases so the value of
 * this flag is ignored if the database is opened read-only.
 *
 * @see #enableWriteAheadLogging
 */

public static final int ENABLE_WRITE_AHEAD_LOGGING = 536870912; // 0x20000000

/**
 * Absolute max value that can be set by {@link #setMaxSqlCacheSize(int)}.
 *
 * Each prepared-statement is between 1K - 6K, depending on the complexity of the
 * SQL statement & schema.  A large SQL cache may use a significant amount of memory.
 */

public static final int MAX_SQL_CACHE_SIZE = 100; // 0x64

/**
 * Open flag: Flag for {@link #openDatabase} to open the database without support for
 * localized collators.
 *
 * {@more} This causes the collator <code>LOCALIZED</code> not to be created.
 * You must be consistent when using this flag to use the setting the database was
 * created with.  If this is set, {@link #setLocale} will do nothing.
 */

public static final int NO_LOCALIZED_COLLATORS = 16; // 0x10

/**
 * Open flag: Flag for {@link #openDatabase} to open the database for reading only.
 * This is the only reliable way to open a database if the disk may be full.
 */

public static final int OPEN_READONLY = 1; // 0x1

/**
 * Open flag: Flag for {@link #openDatabase} to open the database for reading and writing.
 * If the disk is full, this may fail even before you actually write anything.
 *
 * {@more} Note that the value of this flag is 0, so it is the default.
 */

public static final int OPEN_READWRITE = 0; // 0x0

/**
 * Maximum Length Of A LIKE Or GLOB Pattern
 * The pattern matching algorithm used in the default LIKE and GLOB implementation
 * of SQLite can exhibit O(N^2) performance (where N is the number of characters in
 * the pattern) for certain pathological cases. To avoid denial-of-service attacks
 * the length of the LIKE or GLOB pattern is limited to SQLITE_MAX_LIKE_PATTERN_LENGTH bytes.
 * The default value of this limit is 50000. A modern workstation can evaluate
 * even a pathological LIKE or GLOB pattern of 50000 bytes relatively quickly.
 * The denial of service problem only comes into play when the pattern length gets
 * into millions of bytes. Nevertheless, since most useful LIKE or GLOB patterns
 * are at most a few dozen bytes in length, paranoid application developers may
 * want to reduce this parameter to something in the range of a few hundred
 * if they know that external users are able to generate arbitrary patterns.
 */

public static final int SQLITE_MAX_LIKE_PATTERN_LENGTH = 50000; // 0xc350
/**
 * Used to allow returning sub-classes of {@link Cursor} when calling query.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface CursorFactory {

/**
 * See {@link SQLiteCursor#SQLiteCursor(SQLiteCursorDriver, String, SQLiteQuery)}.
 */

public android.database.Cursor newCursor(android.database.sqlite.SQLiteDatabase db, android.database.sqlite.SQLiteCursorDriver masterQuery, java.lang.String editTable, android.database.sqlite.SQLiteQuery query);
}

/**
 * Wrapper for configuration parameters that are used for opening {@link SQLiteDatabase}
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class OpenParams {

OpenParams(int openFlags, android.database.sqlite.SQLiteDatabase.CursorFactory cursorFactory, android.database.DatabaseErrorHandler errorHandler, int lookasideSlotSize, int lookasideSlotCount, long idleConnectionTimeout, java.lang.String journalMode, java.lang.String syncMode) { throw new RuntimeException("Stub!"); }

/**
 * Returns size in bytes of each lookaside slot or -1 if not set.
 *
 * @see Builder#setLookasideConfig(int, int)

 * @return Value is -1 or greater
 */

public int getLookasideSlotSize() { throw new RuntimeException("Stub!"); }

/**
 * Returns total number of lookaside memory slots per database connection or -1 if not
 * set.
 *
 * @see Builder#setLookasideConfig(int, int)

 * @return Value is -1 or greater
 */

public int getLookasideSlotCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns flags to control database access mode. Default value is 0.
 *
 * @see Builder#setOpenFlags(int)

 * @return Value is either <code>0</code> or a combination of {@link android.database.sqlite.SQLiteDatabase#OPEN_READWRITE}, {@link android.database.sqlite.SQLiteDatabase#OPEN_READONLY}, {@link android.database.sqlite.SQLiteDatabase#CREATE_IF_NECESSARY}, {@link android.database.sqlite.SQLiteDatabase#NO_LOCALIZED_COLLATORS}, and {@link android.database.sqlite.SQLiteDatabase#ENABLE_WRITE_AHEAD_LOGGING}
 */

public int getOpenFlags() { throw new RuntimeException("Stub!"); }

/**
 * Returns an optional factory class that is called to instantiate a cursor when query
 * is called
 *
 * @see Builder#setCursorFactory(CursorFactory)

 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.database.sqlite.SQLiteDatabase.CursorFactory getCursorFactory() { throw new RuntimeException("Stub!"); }

/**
 * Returns handler for database corruption errors
 *
 * @see Builder#setErrorHandler(DatabaseErrorHandler)

 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.database.DatabaseErrorHandler getErrorHandler() { throw new RuntimeException("Stub!"); }

/**
 * Returns maximum number of milliseconds that SQLite connection is allowed to be idle
 * before it is closed and removed from the pool.
 * <p>If the value isn't set, the timeout defaults to the system wide timeout
 *
 * @return timeout in milliseconds or -1 if the value wasn't set.
 */

public long getIdleConnectionTimeout() { throw new RuntimeException("Stub!"); }

/**
 * Returns <a href="https://sqlite.org/pragma.html#pragma_journal_mode">journal mode</a>.
 * This journal mode will only be used if {@link SQLiteDatabase#ENABLE_WRITE_AHEAD_LOGGING}
 * flag is not set, otherwise a platform will use "WAL" journal mode.
 * @see Builder#setJournalMode(String)

 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public java.lang.String getJournalMode() { throw new RuntimeException("Stub!"); }

/**
 * Returns <a href="https://sqlite.org/pragma.html#pragma_synchronous">synchronous mode</a>.
 * If not set, a system wide default will be used.
 * @see Builder#setSynchronousMode(String)

 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public java.lang.String getSynchronousMode() { throw new RuntimeException("Stub!"); }
/**
 * Builder for {@link OpenParams}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

public Builder(android.database.sqlite.SQLiteDatabase.OpenParams params) { throw new RuntimeException("Stub!"); }

/**
 * Configures
 * <a href="https://sqlite.org/malloc.html#lookaside">lookaside memory allocator</a>
 *
 * <p>SQLite default settings will be used, if this method isn't called.
 * Use {@code setLookasideConfig(0,0)} to disable lookaside
 *
 * <p><strong>Note:</strong> Provided slotSize/slotCount configuration is just a
 * recommendation. The system may choose different values depending on a device, e.g.
 * lookaside allocations can be disabled on low-RAM devices
 *
 * @param slotSize The size in bytes of each lookaside slot.
 * Value is 0 or greater
 * @param slotCount The total number of lookaside memory slots per database connection.

 * Value is 0 or greater
 */

public android.database.sqlite.SQLiteDatabase.OpenParams.Builder setLookasideConfig(int slotSize, int slotCount) { throw new RuntimeException("Stub!"); }

/**
 * Sets flags to control database access mode
 * @param openFlags The new flags to set
 * Value is either <code>0</code> or a combination of {@link android.database.sqlite.SQLiteDatabase#OPEN_READWRITE}, {@link android.database.sqlite.SQLiteDatabase#OPEN_READONLY}, {@link android.database.sqlite.SQLiteDatabase#CREATE_IF_NECESSARY}, {@link android.database.sqlite.SQLiteDatabase#NO_LOCALIZED_COLLATORS}, and {@link android.database.sqlite.SQLiteDatabase#ENABLE_WRITE_AHEAD_LOGGING}
 * @see #OPEN_READWRITE
 * @see #OPEN_READONLY
 * @see #CREATE_IF_NECESSARY
 * @see #NO_LOCALIZED_COLLATORS
 * @see #ENABLE_WRITE_AHEAD_LOGGING
 * @return same builder instance for chaining multiple calls into a single statement
 
 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.database.sqlite.SQLiteDatabase.OpenParams.Builder setOpenFlags(int openFlags) { throw new RuntimeException("Stub!"); }

/**
 * Adds flags to control database access mode
 *
 * @param openFlags The new flags to add
 * Value is either <code>0</code> or a combination of {@link android.database.sqlite.SQLiteDatabase#OPEN_READWRITE}, {@link android.database.sqlite.SQLiteDatabase#OPEN_READONLY}, {@link android.database.sqlite.SQLiteDatabase#CREATE_IF_NECESSARY}, {@link android.database.sqlite.SQLiteDatabase#NO_LOCALIZED_COLLATORS}, and {@link android.database.sqlite.SQLiteDatabase#ENABLE_WRITE_AHEAD_LOGGING}
 * @return same builder instance for chaining multiple calls into a single statement
 
 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.database.sqlite.SQLiteDatabase.OpenParams.Builder addOpenFlags(int openFlags) { throw new RuntimeException("Stub!"); }

/**
 * Removes database access mode flags
 *
 * @param openFlags Flags to remove
 * Value is either <code>0</code> or a combination of {@link android.database.sqlite.SQLiteDatabase#OPEN_READWRITE}, {@link android.database.sqlite.SQLiteDatabase#OPEN_READONLY}, {@link android.database.sqlite.SQLiteDatabase#CREATE_IF_NECESSARY}, {@link android.database.sqlite.SQLiteDatabase#NO_LOCALIZED_COLLATORS}, and {@link android.database.sqlite.SQLiteDatabase#ENABLE_WRITE_AHEAD_LOGGING}
 * @return same builder instance for chaining multiple calls into a single statement
 
 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.database.sqlite.SQLiteDatabase.OpenParams.Builder removeOpenFlags(int openFlags) { throw new RuntimeException("Stub!"); }

/**
 * Set an optional factory class that is called to instantiate a cursor when query
 * is called.
 *
 * @param cursorFactory instance
 * This value may be {@code null}.
 * @return same builder instance for chaining multiple calls into a single statement
 
 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.database.sqlite.SQLiteDatabase.OpenParams.Builder setCursorFactory(@androidx.annotation.RecentlyNullable android.database.sqlite.SQLiteDatabase.CursorFactory cursorFactory) { throw new RuntimeException("Stub!"); }

/**
 * Sets {@link DatabaseErrorHandler} object to handle db corruption errors
 
 * @param errorHandler This value may be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.database.sqlite.SQLiteDatabase.OpenParams.Builder setErrorHandler(@androidx.annotation.RecentlyNullable android.database.DatabaseErrorHandler errorHandler) { throw new RuntimeException("Stub!"); }

/**
 * Sets the maximum number of milliseconds that SQLite connection is allowed to be idle
 * before it is closed and removed from the pool.
 *
 * @param idleConnectionTimeoutMs timeout in milliseconds. Use {@link Long#MAX_VALUE}
 * to allow unlimited idle connections.
 
 * Value is 0 or greater
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.database.sqlite.SQLiteDatabase.OpenParams.Builder setIdleConnectionTimeout(long idleConnectionTimeoutMs) { throw new RuntimeException("Stub!"); }

/**
 * Sets <a href="https://sqlite.org/pragma.html#pragma_journal_mode">journal mode</a>
 * to use when {@link SQLiteDatabase#ENABLE_WRITE_AHEAD_LOGGING} flag is not set.
 
 * @param journalMode This value must never be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.database.sqlite.SQLiteDatabase.OpenParams.Builder setJournalMode(@androidx.annotation.RecentlyNonNull java.lang.String journalMode) { throw new RuntimeException("Stub!"); }

/**
 * Sets <a href="https://sqlite.org/pragma.html#pragma_synchronous">synchronous mode</a>
 * .
 * @param syncMode This value must never be {@code null}.
 * @return
 
 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.database.sqlite.SQLiteDatabase.OpenParams.Builder setSynchronousMode(@androidx.annotation.RecentlyNonNull java.lang.String syncMode) { throw new RuntimeException("Stub!"); }

/**
 * Creates an instance of {@link OpenParams} with the options that were previously set
 * on this builder

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.database.sqlite.SQLiteDatabase.OpenParams build() { throw new RuntimeException("Stub!"); }
}

}

}

