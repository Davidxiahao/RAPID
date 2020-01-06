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


package android.widget;

import android.app.Service;

/**
 * The service to be connected to for a remote adapter to request RemoteViews.  Users should
 * extend the RemoteViewsService to provide the appropriate RemoteViewsFactory's used to
 * populate the remote collection view (ListView, GridView, etc).
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class RemoteViewsService extends android.app.Service {

public RemoteViewsService() { throw new RuntimeException("Stub!"); }

public android.os.IBinder onBind(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * To be implemented by the derived service to generate appropriate factories for
 * the data.
 */

public abstract android.widget.RemoteViewsService.RemoteViewsFactory onGetViewFactory(android.content.Intent intent);
/**
 * An interface for an adapter between a remote collection view (ListView, GridView, etc) and
 * the underlying data for that view.  The implementor is responsible for making a RemoteView
 * for each item in the data set. This interface is a thin wrapper around {@link Adapter}.
 *
 * @see android.widget.Adapter
 * @see android.appwidget.AppWidgetManager
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface RemoteViewsFactory {

/**
 * Called when your factory is first constructed. The same factory may be shared across
 * multiple RemoteViewAdapters depending on the intent passed.
 */

public void onCreate();

/**
 * Called when notifyDataSetChanged() is triggered on the remote adapter. This allows a
 * RemoteViewsFactory to respond to data changes by updating any internal references.
 *
 * Note: expensive tasks can be safely performed synchronously within this method. In the
 * interim, the old data will be displayed within the widget.
 *
 * @see android.appwidget.AppWidgetManager#notifyAppWidgetViewDataChanged(int[], int)
 */

public void onDataSetChanged();

/**
 * Called when the last RemoteViewsAdapter that is associated with this factory is
 * unbound.
 */

public void onDestroy();

/**
 * See {@link Adapter#getCount()}
 *
 * @return Count of items.
 */

public int getCount();

/**
 * See {@link Adapter#getView(int, android.view.View, android.view.ViewGroup)}.
 *
 * Note: expensive tasks can be safely performed synchronously within this method, and a
 * loading view will be displayed in the interim. See {@link #getLoadingView()}.
 *
 * @param position The position of the item within the Factory's data set of the item whose
 *        view we want.
 * @return A RemoteViews object corresponding to the data at the specified position.
 */

public android.widget.RemoteViews getViewAt(int position);

/**
 * This allows for the use of a custom loading view which appears between the time that
 * {@link #getViewAt(int)} is called and returns. If null is returned, a default loading
 * view will be used.
 *
 * @return The RemoteViews representing the desired loading view.
 */

public android.widget.RemoteViews getLoadingView();

/**
 * See {@link Adapter#getViewTypeCount()}.
 *
 * @return The number of types of Views that will be returned by this factory.
 */

public int getViewTypeCount();

/**
 * See {@link Adapter#getItemId(int)}.
 *
 * @param position The position of the item within the data set whose row id we want.
 * @return The id of the item at the specified position.
 */

public long getItemId(int position);

/**
 * See {@link Adapter#hasStableIds()}.
 *
 * @return True if the same id always refers to the same object.
 */

public boolean hasStableIds();
}

}

