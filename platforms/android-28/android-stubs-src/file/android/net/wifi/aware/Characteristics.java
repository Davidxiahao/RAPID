/*
 * Copyright (C) 2016 The Android Open Source Project
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


package android.net.wifi.aware;


/**
 * The characteristics of the Wi-Fi Aware implementation.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Characteristics implements android.os.Parcelable {

/** @hide : should not be created by apps */

Characteristics(android.os.Bundle characteristics) { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum string length that can be used to specify a Aware service name. Restricts
 * the parameters of the {@link PublishConfig.Builder#setServiceName(String)} and
 * {@link SubscribeConfig.Builder#setServiceName(String)}.
 *
 * @return A positive integer, maximum string length of Aware service name.
 */

public int getMaxServiceNameLength() { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum length of byte array that can be used to specify a Aware service specific
 * information field: the arbitrary load used in discovery or the message length of Aware
 * message exchange. Restricts the parameters of the
 * {@link PublishConfig.Builder#setServiceSpecificInfo(byte[])},
 * {@link SubscribeConfig.Builder#setServiceSpecificInfo(byte[])}, and
 * {@link DiscoverySession#sendMessage(PeerHandle, int, byte[])}
 * variants.
 *
 * @return A positive integer, maximum length of byte array for Aware messaging.
 */

public int getMaxServiceSpecificInfoLength() { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum length of byte array that can be used to specify a Aware match filter.
 * Restricts the parameters of the
 * {@link PublishConfig.Builder#setMatchFilter(java.util.List)} and
 * {@link SubscribeConfig.Builder#setMatchFilter(java.util.List)}.
 *
 * @return A positive integer, maximum legngth of byte array for Aware discovery match filter.
 */

public int getMaxMatchFilterLength() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.net.wifi.aware.Characteristics> CREATOR;
static { CREATOR = null; }
}

