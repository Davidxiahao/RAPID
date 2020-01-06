/*
 * Copyright (C) 2006 The Android Open Source Project
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



package android.provider;

import android.util.Log;
import android.content.ContentResolver;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.os.UserHandle;
import android.content.Intent;
import android.telecom.PhoneAccount;
import android.telecom.TelecomManager;

/**
 * The CallLog provider contains information about placed and received calls.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CallLog {

public CallLog() { throw new RuntimeException("Stub!"); }

public static final java.lang.String AUTHORITY = "call_log";

/**
 * The content:// style URL for this provider
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }
/**
 * Contains the recent calls.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Calls implements android.provider.BaseColumns {

public Calls() { throw new RuntimeException("Stub!"); }

/**
 * Query the call log database for the last dialed number.
 * @param context Used to get the content resolver.
 * @return The last phone number dialed (outgoing) or an empty
 * string if none exist yet.
 */

public static java.lang.String getLastOutgoingCall(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Call log type for a call which was answered on another device.  Used in situations where
 * a call rings on multiple devices simultaneously and it ended up being answered on a
 * device other than the current one.
 */

public static final int ANSWERED_EXTERNALLY_TYPE = 7; // 0x7

/** Call log type for calls blocked automatically. */

public static final int BLOCKED_TYPE = 6; // 0x6

/**
 * The cached phone number, formatted with formatting rules based on the country the
 * user was in when the call was made or received.
 *
 * <p>This value is typically filled in by the dialer app for the caching purpose,
 * so it's not guaranteed to be present, and may not be current if the contact
 * information associated with this number has changed.
 * <P>Type: TEXT</P>
 */

public static final java.lang.String CACHED_FORMATTED_NUMBER = "formatted_number";

/**
 * The cached URI to look up the contact associated with the phone number, if it exists.
 *
 * <p>This value is typically filled in by the dialer app for the caching purpose,
 * so it's not guaranteed to be present, and may not be current if the contact
 * information associated with this number has changed.
 * <P>Type: TEXT</P>
 */

public static final java.lang.String CACHED_LOOKUP_URI = "lookup_uri";

/**
 * The cached phone number of the contact which matches this entry, if it exists.
 *
 * <p>This value is typically filled in by the dialer app for the caching purpose,
 * so it's not guaranteed to be present, and may not be current if the contact
 * information associated with this number has changed.
 * <P>Type: TEXT</P>
 */

public static final java.lang.String CACHED_MATCHED_NUMBER = "matched_number";

/**
 * The cached name associated with the phone number, if it exists.
 *
 * <p>This value is typically filled in by the dialer app for the caching purpose,
 * so it's not guaranteed to be present, and may not be current if the contact
 * information associated with this number has changed.
 * <P>Type: TEXT</P>
 */

public static final java.lang.String CACHED_NAME = "name";

/**
 * The cached normalized(E164) version of the phone number, if it exists.
 *
 * <p>This value is typically filled in by the dialer app for the caching purpose,
 * so it's not guaranteed to be present, and may not be current if the contact
 * information associated with this number has changed.
 * <P>Type: TEXT</P>
 */

public static final java.lang.String CACHED_NORMALIZED_NUMBER = "normalized_number";

/**
 * The cached number label, for a custom number type, associated with the
 * phone number, if it exists.
 *
 * <p>This value is typically filled in by the dialer app for the caching purpose,
 * so it's not guaranteed to be present, and may not be current if the contact
 * information associated with this number has changed.
 * <P>Type: TEXT</P>
 */

public static final java.lang.String CACHED_NUMBER_LABEL = "numberlabel";

/**
 * The cached number type (Home, Work, etc) associated with the
 * phone number, if it exists.
 *
 * <p>This value is typically filled in by the dialer app for the caching purpose,
 * so it's not guaranteed to be present, and may not be current if the contact
 * information associated with this number has changed.
 * <P>Type: INTEGER</P>
 */

public static final java.lang.String CACHED_NUMBER_TYPE = "numbertype";

/**
 * The cached photo id of the picture associated with the phone number, if it exists.
 *
 * <p>This value is typically filled in by the dialer app for the caching purpose,
 * so it's not guaranteed to be present, and may not be current if the contact
 * information associated with this number has changed.
 * <P>Type: INTEGER (long)</P>
 */

public static final java.lang.String CACHED_PHOTO_ID = "photo_id";

/**
 * The cached photo URI of the picture associated with the phone number, if it exists.
 *
 * <p>This value is typically filled in by the dialer app for the caching purpose,
 * so it's not guaranteed to be present, and may not be current if the contact
 * information associated with this number has changed.
 * <P>Type: TEXT (URI)</P>
 */

public static final java.lang.String CACHED_PHOTO_URI = "photo_uri";

/**
 * The content:// style URL for filtering this table on phone numbers
 */

public static final android.net.Uri CONTENT_FILTER_URI;
static { CONTENT_FILTER_URI = null; }

/**
 * The MIME type of a {@link #CONTENT_URI} sub-directory of a single
 * call.
 */

public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/calls";

/**
 * The MIME type of {@link #CONTENT_URI} and {@link #CONTENT_FILTER_URI}
 * providing a directory of calls.
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/calls";

/**
 * The content:// style URL for this table
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * Content uri used to access call log entries, including voicemail records. You must have
 * the READ_CALL_LOG and WRITE_CALL_LOG permissions to read and write to the call log, as
 * well as READ_VOICEMAIL and WRITE_VOICEMAIL permissions to read and write voicemails.
 */

public static final android.net.Uri CONTENT_URI_WITH_VOICEMAIL;
static { CONTENT_URI_WITH_VOICEMAIL = null; }

/**
 * The ISO 3166-1 two letters country code of the country where the
 * user received or made the call.
 * <P>
 * Type: TEXT
 * </P>
 */

public static final java.lang.String COUNTRY_ISO = "countryiso";

/**
 * The data usage of the call in bytes.
 * <P>Type: INTEGER (long)</P>
 */

public static final java.lang.String DATA_USAGE = "data_usage";

/**
 * The date the call occured, in milliseconds since the epoch
 * <P>Type: INTEGER (long)</P>
 */

public static final java.lang.String DATE = "date";

/**
 * The default sort order for this table
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "date DESC";

/**
 * The duration of the call in seconds
 * <P>Type: INTEGER (long)</P>
 */

public static final java.lang.String DURATION = "duration";

/**
 * An optional extra used with {@link #CONTENT_TYPE Calls.CONTENT_TYPE} and
 * {@link Intent#ACTION_VIEW} to specify that the presented list of calls should be
 * filtered for a particular call type.
 *
 * Applications implementing a call log UI should check for this extra, and display a
 * filtered list of calls based on the specified call type. If not applicable within the
 * application's UI, it should be silently ignored.
 *
 * <p>
 * The following example brings up the call log, showing only missed calls.
 * <pre>
 * Intent intent = new Intent(Intent.ACTION_VIEW);
 * intent.setType(CallLog.Calls.CONTENT_TYPE);
 * intent.putExtra(CallLog.Calls.EXTRA_CALL_TYPE_FILTER, CallLog.Calls.MISSED_TYPE);
 * startActivity(intent);
 * </pre>
 * </p>
 */

public static final java.lang.String EXTRA_CALL_TYPE_FILTER = "android.provider.extra.CALL_TYPE_FILTER";

/**
 * Bit-mask describing features of the call (e.g.&nbsp;video).
 *
 * <P>Type: INTEGER (int)</P>
 */

public static final java.lang.String FEATURES = "features";

/** Call was HD. */

public static final int FEATURES_HD_CALL = 4; // 0x4

/** Call was pulled externally. */

public static final int FEATURES_PULLED_EXTERNALLY = 2; // 0x2

/** Call was on RTT at some point */

public static final int FEATURES_RTT = 32; // 0x20

/** Call had video. */

public static final int FEATURES_VIDEO = 1; // 0x1

/** Call was WIFI call. */

public static final int FEATURES_WIFI = 8; // 0x8

/**
 * A geocoded location for the number associated with this call.
 * <p>
 * The string represents a city, state, or country associated with the number.
 * <P>Type: TEXT</P>
 */

public static final java.lang.String GEOCODED_LOCATION = "geocoded_location";

/** Call log type for incoming calls. */

public static final int INCOMING_TYPE = 1; // 0x1

/**
 * Whether this item has been read or otherwise consumed by the user.
 * <p>
 * Unlike the {@link #NEW} field, which requires the user to have acknowledged the
 * existence of the entry, this implies the user has interacted with the entry.
 * <P>Type: INTEGER (boolean)</P>
 */

public static final java.lang.String IS_READ = "is_read";

/**
 * The date the row is last inserted, updated, or marked as deleted, in milliseconds
 * since the epoch. Read only.
 * <P>Type: INTEGER (long)</P>
 */

public static final java.lang.String LAST_MODIFIED = "last_modified";

/**
 * Query parameter used to limit the number of call logs returned.
 * <p>
 * TYPE: integer
 */

public static final java.lang.String LIMIT_PARAM_KEY = "limit";

/** Call log type for missed calls. */

public static final int MISSED_TYPE = 3; // 0x3

/**
 * Whether or not the call has been acknowledged
 * <P>Type: INTEGER (boolean)</P>
 */

public static final java.lang.String NEW = "new";

/**
 * The phone number as the user entered it.
 * <P>Type: TEXT</P>
 */

public static final java.lang.String NUMBER = "number";

/**
 * The number presenting rules set by the network.
 *
 * <p>
 * Allowed values:
 * <ul>
 * <li>{@link #PRESENTATION_ALLOWED}</li>
 * <li>{@link #PRESENTATION_RESTRICTED}</li>
 * <li>{@link #PRESENTATION_UNKNOWN}</li>
 * <li>{@link #PRESENTATION_PAYPHONE}</li>
 * </ul>
 * </p>
 *
 * <P>Type: INTEGER</P>
 */

public static final java.lang.String NUMBER_PRESENTATION = "presentation";

/**
 * Query parameter used to specify the starting record to return.
 * <p>
 * TYPE: integer
 */

public static final java.lang.String OFFSET_PARAM_KEY = "offset";

/** Call log type for outgoing calls. */

public static final int OUTGOING_TYPE = 2; // 0x2

/**
 * The component name of the account used to place or receive the call; in string form.
 * <P>Type: TEXT</P>
 */

public static final java.lang.String PHONE_ACCOUNT_COMPONENT_NAME = "subscription_component_name";

/**
 * The identifier for the account used to place or receive the call.
 * <P>Type: TEXT</P>
 */

public static final java.lang.String PHONE_ACCOUNT_ID = "subscription_id";

/**
 * The post-dial portion of a dialed number, including any digits dialed after a
 * {@link TelecomManager#DTMF_CHARACTER_PAUSE} or a {@link
 * TelecomManager#DTMF_CHARACTER_WAIT} and these characters themselves.
 * <P>Type: TEXT</P>
 */

public static final java.lang.String POST_DIAL_DIGITS = "post_dial_digits";

/** Number is allowed to display for caller id. */

public static final int PRESENTATION_ALLOWED = 1; // 0x1

/** Number is a pay phone. */

public static final int PRESENTATION_PAYPHONE = 4; // 0x4

/** Number is blocked by user. */

public static final int PRESENTATION_RESTRICTED = 2; // 0x2

/** Number is not specified or unknown by network. */

public static final int PRESENTATION_UNKNOWN = 3; // 0x3

/** Call log type for calls rejected by direct user action. */

public static final int REJECTED_TYPE = 5; // 0x5

/**
 * Transcription of the call or voicemail entry. This will only be populated for call log
 * entries of type {@link #VOICEMAIL_TYPE} that have valid transcriptions.
 */

public static final java.lang.String TRANSCRIPTION = "transcription";

/**
 * The type of the call (incoming, outgoing or missed).
 * <P>Type: INTEGER (int)</P>
 *
 * <p>
 * Allowed values:
 * <ul>
 * <li>{@link #INCOMING_TYPE}</li>
 * <li>{@link #OUTGOING_TYPE}</li>
 * <li>{@link #MISSED_TYPE}</li>
 * <li>{@link #VOICEMAIL_TYPE}</li>
 * <li>{@link #REJECTED_TYPE}</li>
 * <li>{@link #BLOCKED_TYPE}</li>
 * <li>{@link #ANSWERED_EXTERNALLY_TYPE}</li>
 * </ul>
 * </p>
 */

public static final java.lang.String TYPE = "type";

/**
 * For an incoming call, the secondary line number the call was received via.
 * When a SIM card has multiple phone numbers associated with it, the via number indicates
 * which of the numbers associated with the SIM was called.
 */

public static final java.lang.String VIA_NUMBER = "via_number";

/** Call log type for voicemails. */

public static final int VOICEMAIL_TYPE = 4; // 0x4

/**
 * URI of the voicemail entry. Populated only for {@link #VOICEMAIL_TYPE}.
 * <P>Type: TEXT</P>
 */

public static final java.lang.String VOICEMAIL_URI = "voicemail_uri";
}

}

