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


package android.webkit;

import android.graphics.Bitmap;

/**
 * A convenience class for accessing fields in an entry in the back/forward list
 * of a WebView. Each WebHistoryItem is a snapshot of the requested history
 * item. Each history item may be updated during the load of a page.
 * @see WebBackForwardList
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class WebHistoryItem implements java.lang.Cloneable {

public WebHistoryItem() { throw new RuntimeException("Stub!"); }

/**
 * Return the url of this history item. The url is the base url of this
 * history item. See getTargetUrl() for the url that is the actual target of
 * this history item.
 * @return The base url of this history item.
 * Note: The VM ensures 32-bit atomic read/write operations so we don't have
 * to synchronize this method.
 */

public abstract java.lang.String getUrl();

/**
 * Return the original url of this history item. This was the requested
 * url, the final url may be different as there might have been
 * redirects while loading the site.
 * @return The original url of this history item.
 */

public abstract java.lang.String getOriginalUrl();

/**
 * Return the document title of this history item.
 * @return The document title of this history item.
 * Note: The VM ensures 32-bit atomic read/write operations so we don't have
 * to synchronize this method.
 */

public abstract java.lang.String getTitle();

/**
 * Return the favicon of this history item or {@code null} if no favicon was found.
 * @return A Bitmap containing the favicon for this history item or {@code null}.
 * Note: The VM ensures 32-bit atomic read/write operations so we don't have
 * to synchronize this method.
 */

@androidx.annotation.RecentlyNullable public abstract android.graphics.Bitmap getFavicon();

/**
 * Clone the history item for use by clients of WebView.
 */

protected abstract android.webkit.WebHistoryItem clone();
}

