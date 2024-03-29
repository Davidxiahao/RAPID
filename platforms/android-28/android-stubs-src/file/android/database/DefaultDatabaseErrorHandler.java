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

package android.database;

import android.database.sqlite.SQLiteDatabase;

/**
 * Default class used to define the action to take when database corruption is reported
 * by sqlite.
 * <p>
 * An application can specify an implementation of {@link DatabaseErrorHandler} on the
 * following:
 * <ul>
 *   <li>{@link SQLiteDatabase#openOrCreateDatabase(String,
 *      android.database.sqlite.SQLiteDatabase.CursorFactory, DatabaseErrorHandler)}</li>
 *   <li>{@link SQLiteDatabase#openDatabase(String,
 *      android.database.sqlite.SQLiteDatabase.CursorFactory, int, DatabaseErrorHandler)}</li>
 * </ul>
 * The specified {@link DatabaseErrorHandler} is used to handle database corruption errors, if they
 * occur.
 * <p>
 * If null is specified for the DatabaseErrorHandler param in the above calls, this class is used
 * as the default {@link DatabaseErrorHandler}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class DefaultDatabaseErrorHandler implements android.database.DatabaseErrorHandler {

public DefaultDatabaseErrorHandler() { throw new RuntimeException("Stub!"); }

/**
 * defines the default method to be invoked when database corruption is detected.
 * @param dbObj the {@link SQLiteDatabase} object representing the database on which corruption
 * is detected.
 */

public void onCorruption(android.database.sqlite.SQLiteDatabase dbObj) { throw new RuntimeException("Stub!"); }
}

