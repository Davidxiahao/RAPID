/*
 * Copyright (C) 2017 The Android Open Source Project
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



package android.companion;

import android.os.Parcelable;

/**
 * A filter for companion devices of type {@code D}
 *
 * @param <D> Type of devices, filtered by this filter,
 *           e.g.&nbsp;{@link android.bluetooth.BluetoothDevice}, {@link android.net.wifi.ScanResult}
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface DeviceFilter<D extends android.os.Parcelable> extends android.os.Parcelable {
}

