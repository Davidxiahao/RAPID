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


package android.nfc;

import android.content.Context;

/**
 * High level manager used to obtain an instance of an {@link NfcAdapter}.
 * <p>
 * Use {@link android.content.Context#getSystemService(java.lang.String)}
 * with {@link Context#NFC_SERVICE} to create an {@link NfcManager},
 * then call {@link #getDefaultAdapter} to obtain the {@link NfcAdapter}.
 * <p>
 * Alternately, you can just call the static helper
 * {@link NfcAdapter#getDefaultAdapter(android.content.Context)}.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about using NFC, read the
 * <a href="{@docRoot}guide/topics/nfc/index.html">Near Field Communication</a> developer guide.</p>
 * </div>
 *
 * @see NfcAdapter#getDefaultAdapter(android.content.Context)
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class NfcManager {

/**
 * @hide
 */

NfcManager(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Get the default NFC Adapter for this device.
 *
 * @return the default NFC Adapter
 */

public android.nfc.NfcAdapter getDefaultAdapter() { throw new RuntimeException("Stub!"); }
}

