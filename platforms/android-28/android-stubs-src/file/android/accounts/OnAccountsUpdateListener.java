/*
 * Copyright (C) 2007 The Android Open Source Project
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


package android.accounts;


/**
 * An interface that contains the callback used by the AccountManager
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface OnAccountsUpdateListener {

/**
 * This invoked when the AccountManager starts up and whenever the account
 * set changes.
 * @param accounts the current accounts
 */

public void onAccountsUpdated(android.accounts.Account[] accounts);
}

