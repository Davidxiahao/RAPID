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


package android.net;

import java.net.URLConnection;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Describes a proxy configuration.
 *
 * Proxy configurations are already integrated within the {@code java.net} and
 * Apache HTTP stack. So {@link URLConnection} and Apache's {@code HttpClient} will use
 * them automatically.
 *
 * Other HTTP stacks will need to obtain the proxy info from
 * {@link Proxy#PROXY_CHANGE_ACTION} broadcast as the extra {@link Proxy#EXTRA_PROXY_INFO}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ProxyInfo implements android.os.Parcelable {

/**
 * Create a ProxyProperties that points at a PAC URL.
 * @hide
 */

ProxyInfo(android.net.Uri pacFileUrl) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a {@link ProxyInfo} object that points at a Direct proxy
 * on the specified host and port.
 */

public static android.net.ProxyInfo buildDirectProxy(java.lang.String host, int port) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a {@link ProxyInfo} object that points at a Direct proxy
 * on the specified host and port.
 *
 * The proxy will not be used to access any host in exclusion list, exclList.
 *
 * @param exclList Hosts to exclude using the proxy on connections for.  These
 *                 hosts can use wildcards such as *.example.com.
 */

public static android.net.ProxyInfo buildDirectProxy(java.lang.String host, int port, java.util.List<java.lang.String> exclList) { throw new RuntimeException("Stub!"); }

/**
 * Construct a {@link ProxyInfo} that will download and run the PAC script
 * at the specified URL.
 */

public static android.net.ProxyInfo buildPacProxy(android.net.Uri pacUri) { throw new RuntimeException("Stub!"); }

/**
 * Returns the URL of the current PAC script or null if there is
 * no PAC script.
 */

public android.net.Uri getPacFileUrl() { throw new RuntimeException("Stub!"); }

/**
 * When configured to use a Direct Proxy this returns the host
 * of the proxy.
 */

public java.lang.String getHost() { throw new RuntimeException("Stub!"); }

/**
 * When configured to use a Direct Proxy this returns the port
 * of the proxy
 */

public int getPort() { throw new RuntimeException("Stub!"); }

/**
 * When configured to use a Direct Proxy this returns the list
 * of hosts for which the proxy is ignored.
 */

public java.lang.String[] getExclusionList() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 * @hide
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface.
 * @hide
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.net.ProxyInfo> CREATOR;
static { CREATOR = null; }
}

