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


package android.database.sqlite;


/**
 * Thrown if  the database engine was unable to acquire the
 * database locks it needs to do its job.  If the statement is a [COMMIT]
 * or occurs outside of an explicit transaction, then you can retry the
 * statement.  If the statement is not a [COMMIT] and occurs within a
 * explicit transaction then you should rollback the transaction before
 * continuing.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SQLiteDatabaseLockedException extends android.database.sqlite.SQLiteException {

public SQLiteDatabaseLockedException() { throw new RuntimeException("Stub!"); }

public SQLiteDatabaseLockedException(java.lang.String error) { throw new RuntimeException("Stub!"); }
}

