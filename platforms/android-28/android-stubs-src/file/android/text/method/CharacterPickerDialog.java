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


package android.text.method;

import android.app.Dialog;

/**
 * Dialog for choosing accented characters related to a base character.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CharacterPickerDialog extends android.app.Dialog implements android.widget.AdapterView.OnItemClickListener, android.view.View.OnClickListener {

/**
 * Creates a new CharacterPickerDialog that presents the specified
 * <code>options</code> for insertion or replacement (depending on
 * the sense of <code>insert</code>) into <code>text</code>.
 */

public CharacterPickerDialog(android.content.Context context, android.view.View view, android.text.Editable text, java.lang.String options, boolean insert) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

protected void onCreate(android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/**
 * Handles clicks on the character buttons.
 */

public void onItemClick(android.widget.AdapterView parent, android.view.View view, int position, long id) { throw new RuntimeException("Stub!"); }

/**
 * Handles clicks on the Cancel button.
 */

public void onClick(android.view.View v) { throw new RuntimeException("Stub!"); }
}

