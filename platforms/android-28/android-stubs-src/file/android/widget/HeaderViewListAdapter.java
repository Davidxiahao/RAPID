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


package android.widget;

import android.view.View;

/**
 * ListAdapter used when a ListView has header views. This ListAdapter
 * wraps another one and also keeps track of the header views and their
 * associated data objects.
 *<p>This is intended as a base class; you will probably not need to
 * use this class directly in your own code.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class HeaderViewListAdapter implements android.widget.WrapperListAdapter, android.widget.Filterable {

public HeaderViewListAdapter(java.util.ArrayList<android.widget.ListView.FixedViewInfo> headerViewInfos, java.util.ArrayList<android.widget.ListView.FixedViewInfo> footerViewInfos, android.widget.ListAdapter adapter) { throw new RuntimeException("Stub!"); }

public int getHeadersCount() { throw new RuntimeException("Stub!"); }

public int getFootersCount() { throw new RuntimeException("Stub!"); }

public boolean isEmpty() { throw new RuntimeException("Stub!"); }

public boolean removeHeader(android.view.View v) { throw new RuntimeException("Stub!"); }

public boolean removeFooter(android.view.View v) { throw new RuntimeException("Stub!"); }

public int getCount() { throw new RuntimeException("Stub!"); }

public boolean areAllItemsEnabled() { throw new RuntimeException("Stub!"); }

public boolean isEnabled(int position) { throw new RuntimeException("Stub!"); }

public java.lang.Object getItem(int position) { throw new RuntimeException("Stub!"); }

public long getItemId(int position) { throw new RuntimeException("Stub!"); }

public boolean hasStableIds() { throw new RuntimeException("Stub!"); }

public android.view.View getView(int position, android.view.View convertView, android.view.ViewGroup parent) { throw new RuntimeException("Stub!"); }

public int getItemViewType(int position) { throw new RuntimeException("Stub!"); }

public int getViewTypeCount() { throw new RuntimeException("Stub!"); }

public void registerDataSetObserver(android.database.DataSetObserver observer) { throw new RuntimeException("Stub!"); }

public void unregisterDataSetObserver(android.database.DataSetObserver observer) { throw new RuntimeException("Stub!"); }

public android.widget.Filter getFilter() { throw new RuntimeException("Stub!"); }

public android.widget.ListAdapter getWrappedAdapter() { throw new RuntimeException("Stub!"); }
}

