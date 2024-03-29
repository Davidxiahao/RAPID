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
 * limitations under the License
 */


package android.telecom;

import android.app.Service;
import android.content.Intent;

/**
 * This service can be implemented by the default dialer (see
 * {@link TelecomManager#getDefaultDialerPackage()}) to allow or disallow incoming calls before
 * they are shown to a user.
 * <p>
 * Below is an example manifest registration for a {@code CallScreeningService}.
 * <pre>
 * {@code
 * <service android:name="your.package.YourCallScreeningServiceImplementation"
 *          android:permission="android.permission.BIND_SCREENING_SERVICE">
 *      <intent-filter>
 *          <action android:name="android.telecom.CallScreeningService"/>
 *      </intent-filter>
 * </service>
 * }
 * </pre>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class CallScreeningService extends android.app.Service {

public CallScreeningService() { throw new RuntimeException("Stub!"); }

public android.os.IBinder onBind(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

public boolean onUnbind(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Called when a new incoming call is added.
 * {@link CallScreeningService#respondToCall(Call.Details, CallScreeningService.CallResponse)}
 * should be called to allow or disallow the call.
 *
 * @param callDetails Information about a new incoming call, see {@link Call.Details}.
 */

public abstract void onScreenCall(android.telecom.Call.Details callDetails);

/**
 * Responds to the given call, either allowing it or disallowing it.
 *
 * @param callDetails The call to allow.
 * @param response The {@link CallScreeningService.CallResponse} which contains information
 * about how to respond to a call.
 */

public final void respondToCall(android.telecom.Call.Details callDetails, android.telecom.CallScreeningService.CallResponse response) { throw new RuntimeException("Stub!"); }

/**
 * The {@link Intent} that must be declared as handled by the service.
 */

public static final java.lang.String SERVICE_INTERFACE = "android.telecom.CallScreeningService";
@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class CallResponse {

CallResponse(boolean shouldDisallowCall, boolean shouldRejectCall, boolean shouldSkipCallLog, boolean shouldSkipNotification) { throw new RuntimeException("Stub!"); }

public boolean getDisallowCall() { throw new RuntimeException("Stub!"); }

public boolean getRejectCall() { throw new RuntimeException("Stub!"); }

public boolean getSkipCallLog() { throw new RuntimeException("Stub!"); }

public boolean getSkipNotification() { throw new RuntimeException("Stub!"); }
@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

public android.telecom.CallScreeningService.CallResponse.Builder setDisallowCall(boolean shouldDisallowCall) { throw new RuntimeException("Stub!"); }

public android.telecom.CallScreeningService.CallResponse.Builder setRejectCall(boolean shouldRejectCall) { throw new RuntimeException("Stub!"); }

public android.telecom.CallScreeningService.CallResponse.Builder setSkipCallLog(boolean shouldSkipCallLog) { throw new RuntimeException("Stub!"); }

public android.telecom.CallScreeningService.CallResponse.Builder setSkipNotification(boolean shouldSkipNotification) { throw new RuntimeException("Stub!"); }

public android.telecom.CallScreeningService.CallResponse build() { throw new RuntimeException("Stub!"); }
}

}

}

