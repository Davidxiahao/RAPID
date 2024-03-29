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


package android.app;

import android.content.Intent;
import android.net.Uri;
import java.util.List;
import android.content.Context;
import android.os.RemoteException;
import android.service.notification.StatusBarNotification;
import android.os.Build;

/**
 * Class to notify the user of events that happen.  This is how you tell
 * the user that something has happened in the background. {@more}
 *
 * Notifications can take different forms:
 * <ul>
 *      <li>A persistent icon that goes in the status bar and is accessible
 *          through the launcher, (when the user selects it, a designated Intent
 *          can be launched),</li>
 *      <li>Turning on or flashing LEDs on the device, or</li>
 *      <li>Alerting the user by flashing the backlight, playing a sound,
 *          or vibrating.</li>
 * </ul>
 *
 * <p>
 * Each of the notify methods takes an int id parameter and optionally a
 * {@link String} tag parameter, which may be {@code null}.  These parameters
 * are used to form a pair (tag, id), or ({@code null}, id) if tag is
 * unspecified.  This pair identifies this notification from your app to the
 * system, so that pair should be unique within your app.  If you call one
 * of the notify methods with a (tag, id) pair that is currently active and
 * a new set of notification parameters, it will be updated.  For example,
 * if you pass a new status bar icon, the old icon in the status bar will
 * be replaced with the new one.  This is also the same tag and id you pass
 * to the {@link #cancel(int)} or {@link #cancel(String, int)} method to clear
 * this notification.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For a guide to creating notifications, read the
 * <a href="{@docRoot}guide/topics/ui/notifiers/notifications.html">Status Bar Notifications</a>
 * developer guide.</p>
 * </div>
 *
 * @see android.app.Notification
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class NotificationManager {

NotificationManager(android.content.Context context, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Post a notification to be shown in the status bar. If a notification with
 * the same id has already been posted by your application and has not yet been canceled, it
 * will be replaced by the updated information.
 *
 * @param id An identifier for this notification unique within your
 *        application.
 * @param notification A {@link Notification} object describing what to show the user. Must not
 *        be null.
 */

public void notify(int id, android.app.Notification notification) { throw new RuntimeException("Stub!"); }

/**
 * Post a notification to be shown in the status bar. If a notification with
 * the same tag and id has already been posted by your application and has not yet been
 * canceled, it will be replaced by the updated information.
 *
 * All {@link android.service.notification.NotificationListenerService listener services} will
 * be granted {@link Intent#FLAG_GRANT_READ_URI_PERMISSION} access to any {@link Uri uris}
 * provided on this notification or the
 * {@link NotificationChannel} this notification is posted to using
 * {@link Context#grantUriPermission(String, Uri, int)}. Permission will be revoked when the
 * notification is canceled, or you can revoke permissions with
 * {@link Context#revokeUriPermission(Uri, int)}.
 *
 * @param tag A string identifier for this notification.  May be {@code null}.
 * @param id An identifier for this notification.  The pair (tag, id) must be unique
 *        within your application.
 * @param notification A {@link Notification} object describing what to
 *        show the user. Must not be null.
 */

public void notify(java.lang.String tag, int id, android.app.Notification notification) { throw new RuntimeException("Stub!"); }

/**
 * Cancel a previously shown notification.  If it's transient, the view
 * will be hidden.  If it's persistent, it will be removed from the status
 * bar.
 */

public void cancel(int id) { throw new RuntimeException("Stub!"); }

/**
 * Cancel a previously shown notification.  If it's transient, the view
 * will be hidden.  If it's persistent, it will be removed from the status
 * bar.
 */

public void cancel(java.lang.String tag, int id) { throw new RuntimeException("Stub!"); }

/**
 * Cancel all previously shown notifications. See {@link #cancel} for the
 * detailed behavior.
 */

public void cancelAll() { throw new RuntimeException("Stub!"); }

/**
 * Creates a group container for {@link NotificationChannel} objects.
 *
 * This can be used to rename an existing group.
 * <p>
 *     Group information is only used for presentation, not for behavior. Groups are optional
 *     for channels, and you can have a mix of channels that belong to groups and channels
 *     that do not.
 * </p>
 * <p>
 *     For example, if your application supports multiple accounts, and those accounts will
 *     have similar channels, you can create a group for each account with account specific
 *     labels instead of appending account information to each channel's label.
 * </p>
 *
 * @param group The group to create

 * This value must never be {@code null}.
 */

public void createNotificationChannelGroup(@androidx.annotation.RecentlyNonNull android.app.NotificationChannelGroup group) { throw new RuntimeException("Stub!"); }

/**
 * Creates multiple notification channel groups.
 *
 * @param groups The list of groups to create

 * This value must never be {@code null}.
 */

public void createNotificationChannelGroups(@androidx.annotation.RecentlyNonNull java.util.List<android.app.NotificationChannelGroup> groups) { throw new RuntimeException("Stub!"); }

/**
 * Creates a notification channel that notifications can be posted to.
 *
 * This can also be used to restore a deleted channel and to update an existing channel's
 * name, description, group, and/or importance.
 *
 * <p>The name and description should only be changed if the locale changes
 * or in response to the user renaming this channel. For example, if a user has a channel
 * named 'John Doe' that represents messages from a 'John Doe', and 'John Doe' changes his name
 * to 'John Smith,' the channel can be renamed to match.
 *
 * <p>The importance of an existing channel will only be changed if the new importance is lower
 * than the current value and the user has not altered any settings on this channel.
 *
 * <p>The group an existing channel will only be changed if the channel does not already
 * belong to a group.
 *
 * All other fields are ignored for channels that already exist.
 *
 * @param channel  the channel to create.  Note that the created channel may differ from this
 *                 value. If the provided channel is malformed, a RemoteException will be
 *                 thrown.

 * This value must never be {@code null}.
 */

public void createNotificationChannel(@androidx.annotation.RecentlyNonNull android.app.NotificationChannel channel) { throw new RuntimeException("Stub!"); }

/**
 * Creates multiple notification channels that different notifications can be posted to. See
 * {@link #createNotificationChannel(NotificationChannel)}.
 *
 * @param channels the list of channels to attempt to create.

 * This value must never be {@code null}.
 */

public void createNotificationChannels(@androidx.annotation.RecentlyNonNull java.util.List<android.app.NotificationChannel> channels) { throw new RuntimeException("Stub!"); }

/**
 * Returns the notification channel settings for a given channel id.
 *
 * The channel must belong to your package, or it will not be returned.
 */

public android.app.NotificationChannel getNotificationChannel(java.lang.String channelId) { throw new RuntimeException("Stub!"); }

/**
 * Returns all notification channels belonging to the calling package.
 */

public java.util.List<android.app.NotificationChannel> getNotificationChannels() { throw new RuntimeException("Stub!"); }

/**
 * Deletes the given notification channel.
 *
 * <p>If you {@link #createNotificationChannel(NotificationChannel) create} a new channel with
 * this same id, the deleted channel will be un-deleted with all of the same settings it
 * had before it was deleted.
 */

public void deleteNotificationChannel(java.lang.String channelId) { throw new RuntimeException("Stub!"); }

/**
 * Returns the notification channel group settings for a given channel group id.
 *
 * The channel group must belong to your package, or null will be returned.
 */

public android.app.NotificationChannelGroup getNotificationChannelGroup(java.lang.String channelGroupId) { throw new RuntimeException("Stub!"); }

/**
 * Returns all notification channel groups belonging to the calling app.
 */

public java.util.List<android.app.NotificationChannelGroup> getNotificationChannelGroups() { throw new RuntimeException("Stub!"); }

/**
 * Deletes the given notification channel group, and all notification channels that
 * belong to it.
 */

public void deleteNotificationChannelGroup(java.lang.String groupId) { throw new RuntimeException("Stub!"); }

/**
 * Returns AutomaticZenRules owned by the caller.
 *
 * <p>
 * Throws a SecurityException if policy access is granted to this package.
 * See {@link #isNotificationPolicyAccessGranted}.
 */

public java.util.Map<java.lang.String, android.app.AutomaticZenRule> getAutomaticZenRules() { throw new RuntimeException("Stub!"); }

/**
 * Returns the AutomaticZenRule with the given id, if it exists and the caller has access.
 *
 * <p>
 * Throws a SecurityException if policy access is granted to this package.
 * See {@link #isNotificationPolicyAccessGranted}.
 *
 * <p>
 * Returns null if there are no zen rules that match the given id, or if the calling package
 * doesn't own the matching rule. See {@link AutomaticZenRule#getOwner}.
 */

public android.app.AutomaticZenRule getAutomaticZenRule(java.lang.String id) { throw new RuntimeException("Stub!"); }

/**
 * Creates the given zen rule.
 *
 * <p>
 * Throws a SecurityException if policy access is granted to this package.
 * See {@link #isNotificationPolicyAccessGranted}.
 *
 * @param automaticZenRule the rule to create.
 * @return The id of the newly created rule; null if the rule could not be created.
 */

public java.lang.String addAutomaticZenRule(android.app.AutomaticZenRule automaticZenRule) { throw new RuntimeException("Stub!"); }

/**
 * Updates the given zen rule.
 *
 * <p>
 * Throws a SecurityException if policy access is granted to this package.
 * See {@link #isNotificationPolicyAccessGranted}.
 *
 * <p>
 * Callers can only update rules that they own. See {@link AutomaticZenRule#getOwner}.
 * @param id The id of the rule to update
 * @param automaticZenRule the rule to update.
 * @return Whether the rule was successfully updated.
 */

public boolean updateAutomaticZenRule(java.lang.String id, android.app.AutomaticZenRule automaticZenRule) { throw new RuntimeException("Stub!"); }

/**
 * Deletes the automatic zen rule with the given id.
 *
 * <p>
 * Throws a SecurityException if policy access is granted to this package.
 * See {@link #isNotificationPolicyAccessGranted}.
 *
 * <p>
 * Callers can only delete rules that they own. See {@link AutomaticZenRule#getOwner}.
 * @param id the id of the rule to delete.
 * @return Whether the rule was successfully deleted.
 */

public boolean removeAutomaticZenRule(java.lang.String id) { throw new RuntimeException("Stub!"); }

/**
 * Returns the user specified importance for notifications from the calling
 * package.

 * @return Value is {@link android.app.NotificationManager#IMPORTANCE_UNSPECIFIED}, {@link android.app.NotificationManager#IMPORTANCE_NONE}, {@link android.app.NotificationManager#IMPORTANCE_MIN}, {@link android.app.NotificationManager#IMPORTANCE_LOW}, {@link android.app.NotificationManager#IMPORTANCE_DEFAULT}, or {@link android.app.NotificationManager#IMPORTANCE_HIGH}
 */

public int getImportance() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether notifications from the calling package are blocked.
 */

public boolean areNotificationsEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Checks the ability to modify notification do not disturb policy for the calling package.
 *
 * <p>
 * Returns true if the calling package can modify notification policy.
 *
 * <p>
 * Apps can request policy access by sending the user to the activity that matches the system
 * intent action {@link android.provider.Settings#ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS}.
 *
 * <p>
 * Use {@link #ACTION_NOTIFICATION_POLICY_ACCESS_GRANTED_CHANGED} to listen for
 * user grant or denial of this access.
 */

public boolean isNotificationPolicyAccessGranted() { throw new RuntimeException("Stub!"); }

/**
 * Checks whether the user has approved a given
 * {@link android.service.notification.NotificationListenerService}.
 *
 * <p>
 * The listener service must belong to the calling app.
 *
 * <p>
 * Apps can request notification listener access by sending the user to the activity that
 * matches the system intent action
 * {@link android.provider.Settings#ACTION_NOTIFICATION_LISTENER_SETTINGS}.
 */

public boolean isNotificationListenerAccessGranted(android.content.ComponentName listener) { throw new RuntimeException("Stub!"); }

/**
 * Gets the current notification policy.
 *
 * <p>
 */

public android.app.NotificationManager.Policy getNotificationPolicy() { throw new RuntimeException("Stub!"); }

/**
 * Sets the current notification policy.
 *
 * <p>
 * Only available if policy access is granted to this package.
 * See {@link #isNotificationPolicyAccessGranted}.
 *
 * @param policy The new desired policy.

 * This value must never be {@code null}.
 */

public void setNotificationPolicy(@androidx.annotation.RecentlyNonNull android.app.NotificationManager.Policy policy) { throw new RuntimeException("Stub!"); }

/**
 * Recover a list of active notifications: ones that have been posted by the calling app that
 * have not yet been dismissed by the user or {@link #cancel(String, int)}ed by the app.
 *
 * Each notification is embedded in a {@link StatusBarNotification} object, including the
 * original <code>tag</code> and <code>id</code> supplied to
 * {@link #notify(String, int, Notification) notify()}
 * (via {@link StatusBarNotification#getTag() getTag()} and
 * {@link StatusBarNotification#getId() getId()}) as well as a copy of the original
 * {@link Notification} object (via {@link StatusBarNotification#getNotification()}).
 *
 * @return An array of {@link StatusBarNotification}.
 */

public android.service.notification.StatusBarNotification[] getActiveNotifications() { throw new RuntimeException("Stub!"); }

/**
 * Gets the current notification interruption filter.
 * <p>
 * The interruption filter defines which notifications are allowed to
 * interrupt the user (e.g. via sound &amp; vibration) and is applied
 * globally.

 * @return Value is {@link android.app.NotificationManager#INTERRUPTION_FILTER_NONE}, {@link android.app.NotificationManager#INTERRUPTION_FILTER_PRIORITY}, {@link android.app.NotificationManager#INTERRUPTION_FILTER_ALARMS}, {@link android.app.NotificationManager#INTERRUPTION_FILTER_ALL}, or {@link android.app.NotificationManager#INTERRUPTION_FILTER_UNKNOWN}
 */

public final int getCurrentInterruptionFilter() { throw new RuntimeException("Stub!"); }

/**
 * Sets the current notification interruption filter.
 * <p>
 * The interruption filter defines which notifications are allowed to
 * interrupt the user (e.g. via sound &amp; vibration) and is applied
 * globally.
 * <p>
 * Only available if policy access is granted to this package. See
 * {@link #isNotificationPolicyAccessGranted}.

 * @param interruptionFilter Value is {@link android.app.NotificationManager#INTERRUPTION_FILTER_NONE}, {@link android.app.NotificationManager#INTERRUPTION_FILTER_PRIORITY}, {@link android.app.NotificationManager#INTERRUPTION_FILTER_ALARMS}, {@link android.app.NotificationManager#INTERRUPTION_FILTER_ALL}, or {@link android.app.NotificationManager#INTERRUPTION_FILTER_UNKNOWN}
 */

public final void setInterruptionFilter(int interruptionFilter) { throw new RuntimeException("Stub!"); }

/**
 * Intent that is broadcast when an application is blocked or unblocked.
 *
 * This broadcast is only sent to the app whose block state has changed.
 *
 * Input: nothing
 * Output: {@link #EXTRA_BLOCKED_STATE}
 */

public static final java.lang.String ACTION_APP_BLOCK_STATE_CHANGED = "android.app.action.APP_BLOCK_STATE_CHANGED";

/**
 * Intent that is broadcast when the state of getCurrentInterruptionFilter() changes.
 * This broadcast is only sent to registered receivers.
 */

public static final java.lang.String ACTION_INTERRUPTION_FILTER_CHANGED = "android.app.action.INTERRUPTION_FILTER_CHANGED";

/**
 * Intent that is broadcast when a {@link NotificationChannel} is blocked
 * (when {@link NotificationChannel#getImportance()} is {@link #IMPORTANCE_NONE}) or unblocked
 * (when {@link NotificationChannel#getImportance()} is anything other than
 * {@link #IMPORTANCE_NONE}).
 *
 * This broadcast is only sent to the app that owns the channel that has changed.
 *
 * Input: nothing
 * Output: {@link #EXTRA_NOTIFICATION_CHANNEL_ID}
 * Output: {@link #EXTRA_BLOCKED_STATE}
 */

public static final java.lang.String ACTION_NOTIFICATION_CHANNEL_BLOCK_STATE_CHANGED = "android.app.action.NOTIFICATION_CHANNEL_BLOCK_STATE_CHANGED";

/**
 * Intent that is broadcast when a {@link NotificationChannelGroup} is
 * {@link NotificationChannelGroup#isBlocked() blocked} or unblocked.
 *
 * This broadcast is only sent to the app that owns the channel group that has changed.
 *
 * Input: nothing
 * Output: {@link #EXTRA_NOTIFICATION_CHANNEL_GROUP_ID}
 * Output: {@link #EXTRA_BLOCKED_STATE}
 */

public static final java.lang.String ACTION_NOTIFICATION_CHANNEL_GROUP_BLOCK_STATE_CHANGED = "android.app.action.NOTIFICATION_CHANNEL_GROUP_BLOCK_STATE_CHANGED";

/**
 * Intent that is broadcast when the state of {@link #isNotificationPolicyAccessGranted()}
 * changes.
 *
 * This broadcast is only sent to registered receivers, and only to the apps that have changed.
 */

public static final java.lang.String ACTION_NOTIFICATION_POLICY_ACCESS_GRANTED_CHANGED = "android.app.action.NOTIFICATION_POLICY_ACCESS_GRANTED_CHANGED";

/**
 * Intent that is broadcast when the state of getNotificationPolicy() changes.
 * This broadcast is only sent to registered receivers.
 */

public static final java.lang.String ACTION_NOTIFICATION_POLICY_CHANGED = "android.app.action.NOTIFICATION_POLICY_CHANGED";

/**
 * Extra for {@link #ACTION_NOTIFICATION_CHANNEL_BLOCK_STATE_CHANGED} or
 * {@link #ACTION_NOTIFICATION_CHANNEL_GROUP_BLOCK_STATE_CHANGED} containing the new blocked
 * state as a boolean.
 *
 * The value will be {@code true} if this channel or group is now blocked and {@code false} if
 * this channel or group is now unblocked.
 */

public static final java.lang.String EXTRA_BLOCKED_STATE = "android.app.extra.BLOCKED_STATE";

/**
 * Extra for {@link #ACTION_NOTIFICATION_CHANNEL_GROUP_BLOCK_STATE_CHANGED} containing the id
 * of the {@link NotificationChannelGroup} which has a new blocked state.
 *
 * The value will be the {@link NotificationChannelGroup#getId()} of the group.
 */

public static final java.lang.String EXTRA_NOTIFICATION_CHANNEL_GROUP_ID = "android.app.extra.NOTIFICATION_CHANNEL_GROUP_ID";

/**
 * Extra for {@link #ACTION_NOTIFICATION_CHANNEL_BLOCK_STATE_CHANGED} containing the id of the
 * {@link NotificationChannel} which has a new blocked state.
 *
 * The value will be the {@link NotificationChannel#getId()} of the channel.
 */

public static final java.lang.String EXTRA_NOTIFICATION_CHANNEL_ID = "android.app.extra.NOTIFICATION_CHANNEL_ID";

/**
 * Default notification importance: shows everywhere, makes noise, but does not visually
 * intrude.
 */

public static final int IMPORTANCE_DEFAULT = 3; // 0x3

/**
 * Higher notification importance: shows everywhere, makes noise and peeks. May use full screen
 * intents.
 */

public static final int IMPORTANCE_HIGH = 4; // 0x4

/**
 * Low notification importance: shows everywhere, but is not intrusive.
 */

public static final int IMPORTANCE_LOW = 2; // 0x2

/**
 * Unused.
 */

public static final int IMPORTANCE_MAX = 5; // 0x5

/**
 * Min notification importance: only shows in the shade, below the fold.  This should
 * not be used with {@link Service#startForeground(int, Notification) Service.startForeground}
 * since a foreground service is supposed to be something the user cares about so it does
 * not make semantic sense to mark its notification as minimum importance.  If you do this
 * as of Android version {@link android.os.Build.VERSION_CODES#O}, the system will show
 * a higher-priority notification about your app running in the background.
 */

public static final int IMPORTANCE_MIN = 1; // 0x1

/**
 * A notification with no importance: does not show in the shade.
 */

public static final int IMPORTANCE_NONE = 0; // 0x0

/**
 * Value signifying that the user has not expressed an importance.
 *
 * This value is for persisting preferences, and should never be associated with
 * an actual notification.
 */

public static final int IMPORTANCE_UNSPECIFIED = -1000; // 0xfffffc18

/**
 * {@link #getCurrentInterruptionFilter() Interruption filter} constant -
 *     Alarms only interruption filter - all notifications except those of category
 *     {@link Notification#CATEGORY_ALARM} are suppressed. Some audio streams are muted.
 */

public static final int INTERRUPTION_FILTER_ALARMS = 4; // 0x4

/**
 * {@link #getCurrentInterruptionFilter() Interruption filter} constant -
 *     Normal interruption filter - no notifications are suppressed.
 */

public static final int INTERRUPTION_FILTER_ALL = 1; // 0x1

/**
 * {@link #getCurrentInterruptionFilter() Interruption filter} constant -
 *     No interruptions filter - all notifications are suppressed and all audio streams (except
 *     those used for phone calls) and vibrations are muted.
 */

public static final int INTERRUPTION_FILTER_NONE = 3; // 0x3

/**
 * {@link #getCurrentInterruptionFilter() Interruption filter} constant -
 *     Priority interruption filter - all notifications are suppressed except those that match
 *     the priority criteria. Some audio streams are muted. See
 *     {@link Policy#priorityCallSenders}, {@link Policy#priorityCategories},
 *     {@link Policy#priorityMessageSenders} to define or query this criteria. Users can
 *     additionally specify packages that can bypass this interruption filter.
 */

public static final int INTERRUPTION_FILTER_PRIORITY = 2; // 0x2

/** {@link #getCurrentInterruptionFilter() Interruption filter} constant - returned when
 * the value is unavailable for any reason.
 */

public static final int INTERRUPTION_FILTER_UNKNOWN = 0; // 0x0
/**
 * Notification policy configuration.  Represents user-preferences for notification
 * filtering.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Policy implements android.os.Parcelable {

/**
 * Constructs a policy for Do Not Disturb priority mode behavior.
 *
 * <p>
 *     Apps that target API levels below {@link Build.VERSION_CODES#P} cannot
 *     change user-designated values to allow or disallow
 *     {@link Policy#PRIORITY_CATEGORY_ALARMS}, {@link Policy#PRIORITY_CATEGORY_SYSTEM}, and
 *     {@link Policy#PRIORITY_CATEGORY_MEDIA} from bypassing dnd.
 *
 * @param priorityCategories bitmask of categories of notifications that can bypass DND.
 * @param priorityCallSenders which callers can bypass DND.
 * @param priorityMessageSenders which message senders can bypass DND.
 */

public Policy(int priorityCategories, int priorityCallSenders, int priorityMessageSenders) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a policy for Do Not Disturb priority mode behavior.
 *
 * <p>
 *     Apps that target API levels below {@link Build.VERSION_CODES#P} cannot
 *     change user-designated values to allow or disallow
 *     {@link Policy#PRIORITY_CATEGORY_ALARMS}, {@link Policy#PRIORITY_CATEGORY_SYSTEM}, and
 *     {@link Policy#PRIORITY_CATEGORY_MEDIA} from bypassing dnd.
 * <p>
 *     Additionally, apps that target API levels below {@link Build.VERSION_CODES#P} can
 *     only modify the {@link #SUPPRESSED_EFFECT_SCREEN_ON} and
 *     {@link #SUPPRESSED_EFFECT_SCREEN_OFF} bits of the suppressed visual effects field.
 *     All other suppressed effects will be ignored and reconstituted from the screen on
 *     and screen off values.
 * <p>
 *     Apps that target {@link Build.VERSION_CODES#P} or above can set any
 *     suppressed visual effects. However, if any suppressed effects >
 *     {@link #SUPPRESSED_EFFECT_SCREEN_ON} are set, {@link #SUPPRESSED_EFFECT_SCREEN_ON}
 *     and {@link #SUPPRESSED_EFFECT_SCREEN_OFF} will be ignored and reconstituted from
 *     the more specific suppressed visual effect bits. Apps should migrate to targeting
 *     specific effects instead of the deprecated {@link #SUPPRESSED_EFFECT_SCREEN_ON} and
 *     {@link #SUPPRESSED_EFFECT_SCREEN_OFF} effects.
 *
 * @param priorityCategories bitmask of categories of notifications that can bypass DND.
 * @param priorityCallSenders which callers can bypass DND.
 * @param priorityMessageSenders which message senders can bypass DND.
 * @param suppressedVisualEffects which visual interruptions should be suppressed from
 *                                notifications that are filtered by DND.
 */

public Policy(int priorityCategories, int priorityCallSenders, int priorityMessageSenders, int suppressedVisualEffects) { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public static java.lang.String suppressedEffectsToString(int effects) { throw new RuntimeException("Stub!"); }

public static java.lang.String priorityCategoriesToString(int priorityCategories) { throw new RuntimeException("Stub!"); }

public static java.lang.String prioritySendersToString(int prioritySenders) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.app.NotificationManager.Policy> CREATOR;
static { CREATOR = null; }

/** Alarms are prioritized */

public static final int PRIORITY_CATEGORY_ALARMS = 32; // 0x20

/** Calls are prioritized. */

public static final int PRIORITY_CATEGORY_CALLS = 8; // 0x8

/** Event notifications are prioritized. */

public static final int PRIORITY_CATEGORY_EVENTS = 2; // 0x2

/** Media, game, voice navigation are prioritized */

public static final int PRIORITY_CATEGORY_MEDIA = 64; // 0x40

/** Message notifications are prioritized. */

public static final int PRIORITY_CATEGORY_MESSAGES = 4; // 0x4

/** Reminder notifications are prioritized. */

public static final int PRIORITY_CATEGORY_REMINDERS = 1; // 0x1

/** Calls from repeat callers are prioritized. */

public static final int PRIORITY_CATEGORY_REPEAT_CALLERS = 16; // 0x10

/**System (catch-all for non-never suppressible sounds) are prioritized */

public static final int PRIORITY_CATEGORY_SYSTEM = 128; // 0x80

/** Any sender is prioritized. */

public static final int PRIORITY_SENDERS_ANY = 0; // 0x0

/** Saved contacts are prioritized. */

public static final int PRIORITY_SENDERS_CONTACTS = 1; // 0x1

/** Only starred contacts are prioritized. */

public static final int PRIORITY_SENDERS_STARRED = 2; // 0x2

/**
 * Whether notification intercepted by DND are prevented from appearing on ambient displays
 * on devices that support ambient display.
 */

public static final int SUPPRESSED_EFFECT_AMBIENT = 128; // 0x80

/**
 * Whether {@link NotificationChannel#canShowBadge() badges} from
 * notifications intercepted by DND are blocked on devices that support badging.
 */

public static final int SUPPRESSED_EFFECT_BADGE = 64; // 0x40

/**
 * Whether {@link Notification#fullScreenIntent full screen intents} from
 * notifications intercepted by DND are blocked.
 */

public static final int SUPPRESSED_EFFECT_FULL_SCREEN_INTENT = 4; // 0x4

/**
 * Whether {@link NotificationChannel#shouldShowLights() notification lights} from
 * notifications intercepted by DND are blocked.
 */

public static final int SUPPRESSED_EFFECT_LIGHTS = 8; // 0x8

/**
 * Whether notification intercepted by DND are prevented from appearing in notification
 * list views like the notification shade or lockscreen on devices that support those
 * views.
 */

public static final int SUPPRESSED_EFFECT_NOTIFICATION_LIST = 256; // 0x100

/**
 * Whether notifications intercepted by DND are prevented from peeking.
 */

public static final int SUPPRESSED_EFFECT_PEEK = 16; // 0x10

/**
 * Whether notifications suppressed by DND should not interrupt visually (e.g.&nbsp;with
 * notification lights or by turning the screen on) when the screen is off.
 *
 * @deprecated use {@link #SUPPRESSED_EFFECT_FULL_SCREEN_INTENT} and
 * {@link #SUPPRESSED_EFFECT_AMBIENT} and {@link #SUPPRESSED_EFFECT_LIGHTS} individually.
 */

@Deprecated public static final int SUPPRESSED_EFFECT_SCREEN_OFF = 1; // 0x1

/**
 * Whether notifications suppressed by DND should not interrupt visually when the screen
 * is on (e.g.&nbsp;by peeking onto the screen).
 *
 * @deprecated use {@link #SUPPRESSED_EFFECT_PEEK}.
 */

@Deprecated public static final int SUPPRESSED_EFFECT_SCREEN_ON = 2; // 0x2

/**
 * Whether notifications intercepted by DND are prevented from appearing in the status bar,
 * on devices that support status bars.
 */

public static final int SUPPRESSED_EFFECT_STATUS_BAR = 32; // 0x20

/** Notification senders to prioritize for calls. One of:
 * PRIORITY_SENDERS_ANY, PRIORITY_SENDERS_CONTACTS, PRIORITY_SENDERS_STARRED */

public final int priorityCallSenders;
{ priorityCallSenders = 0; }

/** Notification categories to prioritize. Bitmask of PRIORITY_CATEGORY_* constants. */

public final int priorityCategories;
{ priorityCategories = 0; }

/** Notification senders to prioritize for messages. One of:
 * PRIORITY_SENDERS_ANY, PRIORITY_SENDERS_CONTACTS, PRIORITY_SENDERS_STARRED */

public final int priorityMessageSenders;
{ priorityMessageSenders = 0; }

/**
 * Visual effects to suppress for a notification that is filtered by Do Not Disturb mode.
 * Bitmask of SUPPRESSED_EFFECT_* constants.
 */

public final int suppressedVisualEffects;
{ suppressedVisualEffects = 0; }
}

}

