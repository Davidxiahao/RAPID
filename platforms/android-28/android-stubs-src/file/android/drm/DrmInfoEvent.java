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


package android.drm;


/**
 * An entity class that is passed to the
 * {@link DrmManagerClient.OnInfoListener#onInfo onInfo()} callback.
 *
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DrmInfoEvent extends android.drm.DrmEvent {

/**
 * Creates a <code>DrmInfoEvent</code> object with the specified parameters.
 *
 * @param uniqueId Unique session identifier.
 * @param type Type of the event. Must be any of the event types defined above,
 * or the constants defined in {@link DrmEvent}.
 * @param message Message description. It can be null.
 */

public DrmInfoEvent(int uniqueId, int type, java.lang.String message) { super(0, 0, (java.lang.String)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a <code>DrmInfoEvent</code> object with the specified parameters.
 *
 * @param uniqueId Unique session identifier.
 * @param type Type of the event. Must be any of the event types defined above,
 * or the constants defined in {@link DrmEvent}
 * @param message Message description. It can be null.
 * @param attributes Attributes for extensible information. Could be any
 * information provided by the plug-in.
 */

public DrmInfoEvent(int uniqueId, int type, java.lang.String message, java.util.HashMap<java.lang.String, java.lang.Object> attributes) { super(0, 0, (java.lang.String)null); throw new RuntimeException("Stub!"); }

/**
 * The registration has already been done for the given account.
 */

public static final int TYPE_ACCOUNT_ALREADY_REGISTERED = 5; // 0x5

/**
 * The registration has already been done by another account ID.
 */

public static final int TYPE_ALREADY_REGISTERED_BY_ANOTHER_ACCOUNT = 1; // 0x1

/**
 * The rights need to be removed completely.
 */

public static final int TYPE_REMOVE_RIGHTS = 2; // 0x2

/**
 * The rights have been successfully downloaded and installed.
 */

public static final int TYPE_RIGHTS_INSTALLED = 3; // 0x3

/**
 * The rights have been removed.
 */

public static final int TYPE_RIGHTS_REMOVED = 6; // 0x6

/**
 * The rights object is being delivered to the device. You must wait before
 * calling {@link DrmManagerClient#acquireRights acquireRights()} again.
 */

public static final int TYPE_WAIT_FOR_RIGHTS = 4; // 0x4
}

