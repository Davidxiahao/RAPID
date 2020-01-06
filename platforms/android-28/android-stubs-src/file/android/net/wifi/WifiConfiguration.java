/*
 * Copyright (C) 2008 The Android Open Source Project
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


package android.net.wifi;

import android.net.MacAddress;
import android.net.ProxyInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;

/**
 * A class representing a configured Wi-Fi network, including the
 * security configuration.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class WifiConfiguration implements android.os.Parcelable {

public WifiConfiguration() { throw new RuntimeException("Stub!"); }

/**
 * Identify if this configuration represents a Passpoint network
 */

public boolean isPasspoint() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns the HTTP proxy used by this object.
 * @return a {@link ProxyInfo httpProxy} representing the proxy specified by this
 *                  WifiConfiguration, or {@code null} if no proxy is specified.
 */

public android.net.ProxyInfo getHttpProxy() { throw new RuntimeException("Stub!"); }

/**
 * Set the {@link ProxyInfo} for this WifiConfiguration. This method should only be used by a
 * device owner or profile owner. When other apps attempt to save a {@link WifiConfiguration}
 * with modified proxy settings, the methods {@link WifiManager#addNetwork} and
 * {@link WifiManager#updateNetwork} fail and return {@code -1}.
 *
 * @param httpProxy {@link ProxyInfo} representing the httpProxy to be used by this
 *                  WifiConfiguration. Setting this to {@code null} will explicitly set no
 *                  proxy, removing any proxy that was previously set.
 * @exception IllegalArgumentException for invalid httpProxy
 */

public void setHttpProxy(android.net.ProxyInfo httpProxy) { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface {@hide} */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface {@hide} */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * When set, this network configuration entry should only be used when
 * associating with the AP having the specified BSSID. The value is
 * a string in the format of an Ethernet MAC address, e.g.,
 * <code>XX:XX:XX:XX:XX:XX</code> where each <code>X</code> is a hex digit.
 */

public java.lang.String BSSID;

/**
 * Fully qualified domain name of a Passpoint configuration
 */

public java.lang.String FQDN;

/**
 * The network's SSID. Can either be a UTF-8 string,
 * which must be enclosed in double quotation marks
 * (e.g., {@code "MyNetwork"}), or a string of
 * hex digits, which are not enclosed in quotes
 * (e.g., {@code 01a243f405}).
 */

public java.lang.String SSID;

/**
 * The set of authentication protocols supported by this configuration.
 * See {@link AuthAlgorithm} for descriptions of the values.
 * Defaults to automatic selection.
 */

public java.util.BitSet allowedAuthAlgorithms;

/**
 * The set of group ciphers supported by this configuration.
 * See {@link GroupCipher} for descriptions of the values.
 * Defaults to CCMP TKIP WEP104 WEP40.
 */

public java.util.BitSet allowedGroupCiphers;

/**
 * The set of key management protocols supported by this configuration.
 * See {@link KeyMgmt} for descriptions of the values.
 * Defaults to WPA-PSK WPA-EAP.
 */

public java.util.BitSet allowedKeyManagement;

/**
 * The set of pairwise ciphers for WPA supported by this configuration.
 * See {@link PairwiseCipher} for descriptions of the values.
 * Defaults to CCMP TKIP.
 */

public java.util.BitSet allowedPairwiseCiphers;

/**
 * The set of security protocols supported by this configuration.
 * See {@link Protocol} for descriptions of the values.
 * Defaults to WPA RSN.
 */

public java.util.BitSet allowedProtocols;

/**
 * The enterprise configuration details specifying the EAP method,
 * certificates and other settings associated with the EAP.
 */

public android.net.wifi.WifiEnterpriseConfig enterpriseConfig;

/**
 * This is a network that does not broadcast its SSID, so an
 * SSID-specific probe request must be used for scans.
 */

public boolean hiddenSSID;

/**
 * Flag indicating if this network is provided by a home Passpoint provider or a roaming
 * Passpoint provider.  This flag will be {@code true} if this network is provided by
 * a home Passpoint provider and {@code false} if is provided by a roaming Passpoint provider
 * or is a non-Passpoint network.
 */

public boolean isHomeProviderNetwork;

/**
 * The ID number that the supplicant uses to identify this
 * network configuration entry. This must be passed as an argument
 * to most calls into the supplicant.
 */

public int networkId;

/**
 * Pre-shared key for use with WPA-PSK. Either an ASCII string enclosed in
 * double quotation marks (e.g., {@code "abcdefghij"} for PSK passphrase or
 * a string of 64 hex digits for raw PSK.
 * <p/>
 * When the value of this key is read, the actual key is
 * not returned, just a "*" if the key has a value, or the null
 * string otherwise.
 */

public java.lang.String preSharedKey;

/**
 * Priority determines the preference given to a network by {@code wpa_supplicant}
 * when choosing an access point with which to associate.
 * @deprecated This field does not exist anymore.
 */

@Deprecated public int priority;

/**
 * Name of Passpoint credential provider
 */

public java.lang.String providerFriendlyName;

/**
 * Roaming Consortium Id list for Passpoint credential; identifies a set of networks where
 * Passpoint credential will be considered valid
 */

public long[] roamingConsortiumIds;

/**
 * The current status of this network configuration entry.
 * @see Status
 */

public int status;

/**
 * Up to four WEP keys. Either an ASCII string enclosed in double
 * quotation marks (e.g., {@code "abcdef"}) or a string
 * of hex digits (e.g., {@code 0102030405}).
 * <p/>
 * When the value of one of these keys is read, the actual key is
 * not returned, just a "*" if the key has a value, or the null
 * string otherwise.
 * @deprecated Due to security and performance limitations, use of WEP networks
 * is discouraged.
 */

@Deprecated public java.lang.String[] wepKeys;

/** Default WEP key index, ranging from 0 to 3.
 * @deprecated Due to security and performance limitations, use of WEP networks
 * is discouraged. */

@Deprecated public int wepTxKeyIndex;
/**
 * Recognized IEEE 802.11 authentication algorithms.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class AuthAlgorithm {

AuthAlgorithm() { throw new RuntimeException("Stub!"); }

/** LEAP/Network EAP (only used with LEAP) */

public static final int LEAP = 2; // 0x2

/** Open System authentication (required for WPA/WPA2) */

public static final int OPEN = 0; // 0x0

/** Shared Key authentication (requires static WEP keys)
 * @deprecated Due to security and performance limitations, use of WEP networks
 * is discouraged. */

@Deprecated public static final int SHARED = 1; // 0x1

public static final java.lang.String[] strings;
static { strings = new java.lang.String[0]; }

public static final java.lang.String varName = "auth_alg";
}

/**
 * Recognized group ciphers.
 * <pre>
 * CCMP = AES in Counter mode with CBC-MAC [RFC 3610, IEEE 802.11i/D7.0]
 * TKIP = Temporal Key Integrity Protocol [IEEE 802.11i/D7.0]
 * WEP104 = WEP (Wired Equivalent Privacy) with 104-bit key
 * WEP40 = WEP (Wired Equivalent Privacy) with 40-bit key (original 802.11)
 * </pre>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class GroupCipher {

GroupCipher() { throw new RuntimeException("Stub!"); }

/** AES in Counter mode with CBC-MAC [RFC 3610, IEEE 802.11i/D7.0] */

public static final int CCMP = 3; // 0x3

/** Temporal Key Integrity Protocol [IEEE 802.11i/D7.0] */

public static final int TKIP = 2; // 0x2

/** WEP104 = WEP (Wired Equivalent Privacy) with 104-bit key
 * @deprecated Due to security and performance limitations, use of WEP networks
 * is discouraged. */

@Deprecated public static final int WEP104 = 1; // 0x1

/** WEP40 = WEP (Wired Equivalent Privacy) with 40-bit key (original 802.11)
 * @deprecated Due to security and performance limitations, use of WEP networks
 * is discouraged. */

@Deprecated public static final int WEP40 = 0; // 0x0

public static final java.lang.String[] strings;
static { strings = new java.lang.String[0]; }

public static final java.lang.String varName = "group";
}

/**
 * Recognized key management schemes.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class KeyMgmt {

KeyMgmt() { throw new RuntimeException("Stub!"); }

/** IEEE 802.1X using EAP authentication and (optionally) dynamically
 * generated WEP keys. */

public static final int IEEE8021X = 3; // 0x3

/** WPA is not used; plaintext or static WEP could be used. */

public static final int NONE = 0; // 0x0

/** WPA using EAP authentication. Generally used with an external authentication server. */

public static final int WPA_EAP = 2; // 0x2

/** WPA pre-shared key (requires {@code preSharedKey} to be specified). */

public static final int WPA_PSK = 1; // 0x1

public static final java.lang.String[] strings;
static { strings = new java.lang.String[0]; }

public static final java.lang.String varName = "key_mgmt";
}

/**
 * Recognized pairwise ciphers for WPA.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class PairwiseCipher {

PairwiseCipher() { throw new RuntimeException("Stub!"); }

/** AES in Counter mode with CBC-MAC [RFC 3610, IEEE 802.11i/D7.0] */

public static final int CCMP = 2; // 0x2

/** Use only Group keys (deprecated) */

public static final int NONE = 0; // 0x0

/** Temporal Key Integrity Protocol [IEEE 802.11i/D7.0]
 * @deprecated Due to security and performance limitations, use of WPA-1 networks
 * is discouraged. WPA-2 (RSN) should be used instead. */

@Deprecated public static final int TKIP = 1; // 0x1

public static final java.lang.String[] strings;
static { strings = new java.lang.String[0]; }

public static final java.lang.String varName = "pairwise";
}

/**
 * Recognized security protocols.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Protocol {

Protocol() { throw new RuntimeException("Stub!"); }

/** WPA2/IEEE 802.11i */

public static final int RSN = 1; // 0x1

/** WPA/IEEE 802.11i/D3.0
 * @deprecated Due to security and performance limitations, use of WPA-1 networks
 * is discouraged. WPA-2 (RSN) should be used instead. */

@Deprecated public static final int WPA = 0; // 0x0

public static final java.lang.String[] strings;
static { strings = new java.lang.String[0]; }

public static final java.lang.String varName = "proto";
}

/** Possible status of a network configuration. */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Status {

Status() { throw new RuntimeException("Stub!"); }

/** this is the network we are currently connected to */

public static final int CURRENT = 0; // 0x0

/** supplicant will not attempt to use this network */

public static final int DISABLED = 1; // 0x1

/** supplicant will consider this network available for association */

public static final int ENABLED = 2; // 0x2

public static final java.lang.String[] strings;
static { strings = new java.lang.String[0]; }
}

}

