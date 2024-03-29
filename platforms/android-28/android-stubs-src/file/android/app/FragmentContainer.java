/*
 * Copyright (C) 2015 The Android Open Source Project
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

import android.content.Context;
import android.os.Bundle;

/**
 * Callbacks to a {@link Fragment}'s container.
 *
 * @deprecated Use the <a href="{@docRoot}tools/extras/support-library.html">Support Library</a>
 *      {@link android.support.v4.app.FragmentContainer}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated public abstract class FragmentContainer {

public FragmentContainer() { throw new RuntimeException("Stub!"); }

/**
 * Return the view with the given resource ID. May return {@code null} if the
 * view is not a child of this container.
 */

@androidx.annotation.RecentlyNullable public abstract <T extends android.view.View> T onFindViewById(int id);

/**
 * Return {@code true} if the container holds any view.
 */

public abstract boolean onHasView();
}

