/*
 * Copyright (C) 2015 The Android Open Source Project
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


package android.printservice;

import android.graphics.drawable.Icon;

/**
 * Callback for {@link PrinterDiscoverySession#onRequestCustomPrinterIcon}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CustomPrinterIconCallback {

CustomPrinterIconCallback() { throw new RuntimeException("Stub!"); }

/**
 * Provide a new icon for a printer. Can be called more than once to update the icon.
 *
 * @param icon The new icon for the printer or null to unset the current icon
 * This value may be {@code null}.
 * @return true iff the icon could be updated
 */

public boolean onCustomPrinterIconLoaded(@androidx.annotation.RecentlyNullable android.graphics.drawable.Icon icon) { throw new RuntimeException("Stub!"); }
}

