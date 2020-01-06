/*
 * Copyright (C) 2018 The Android Open Source Project
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


package android.media;


/**
 * The AudioPresentation class encapsulates the information that describes an audio presentation
 * which is available in next generation audio content.
 *
 * Used by {@link MediaExtractor} {@link MediaExtractor#getAudioPresentations(int)} and
 * {@link AudioTrack} {@link AudioTrack#setPresentation(AudioPresentation)} to query available
 * presentations and to select one.
 *
 * A list of available audio presentations in a media source can be queried using
 * {@link MediaExtractor#getAudioPresentations(int)}. This list can be presented to a user for
 * selection.
 * An AudioPresentation can be passed to an offloaded audio decoder via
 * {@link AudioTrack#setPresentation(AudioPresentation)} to request decoding of the selected
 * presentation. An audio stream may contain multiple presentations that differ by language,
 * accessibility, end point mastering and dialogue enhancement. An audio presentation may also have
 * a set of description labels in different languages to help the user to make an informed
 * selection.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AudioPresentation {

/**
 * @hide
 */

AudioPresentation(int presentationId, int programId, @androidx.annotation.RecentlyNonNull java.util.Map<java.lang.String, java.lang.String> labels, @androidx.annotation.RecentlyNonNull java.lang.String language, int masteringIndication, boolean audioDescriptionAvailable, boolean spokenSubtitlesAvailable, boolean dialogueEnhancementAvailable) { throw new RuntimeException("Stub!"); }

/**
 * @return a map of available text labels for this presentation. Each label is indexed by its
 * locale corresponding to the language code as specified by ISO 639-2. Either ISO 639-2/B
 * or ISO 639-2/T could be used.
 */

public java.util.Map<java.util.Locale, java.lang.String> getLabels() { throw new RuntimeException("Stub!"); }

/**
 * @return the locale corresponding to audio presentation's ISO 639-1/639-2 language code.
 */

public java.util.Locale getLocale() { throw new RuntimeException("Stub!"); }

/**
 * @return the mastering indication of the audio presentation.
 * See {@link #MASTERING_NOT_INDICATED}, {@link #MASTERED_FOR_STEREO},
 * {@link #MASTERED_FOR_SURROUND}, {@link #MASTERED_FOR_3D}, {@link #MASTERED_FOR_HEADPHONE}

 * Value is {@link android.media.AudioPresentation#MASTERING_NOT_INDICATED}, {@link android.media.AudioPresentation#MASTERED_FOR_STEREO}, {@link android.media.AudioPresentation#MASTERED_FOR_SURROUND}, {@link android.media.AudioPresentation#MASTERED_FOR_3D}, or {@link android.media.AudioPresentation#MASTERED_FOR_HEADPHONE}
 */

public int getMasteringIndication() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether an audio description for the visually impaired is available.
 * @return {@code true} if audio description is available.
 */

public boolean hasAudioDescription() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether spoken subtitles for the visually impaired are available.
 * @return {@code true} if spoken subtitles are available.
 */

public boolean hasSpokenSubtitles() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether dialogue enhancement is available.
 * @return {@code true} if dialogue enhancement is available.
 */

public boolean hasDialogueEnhancement() { throw new RuntimeException("Stub!"); }

/**
 * Three-dimensional (e.g.&nbsp;5.1.2) speaker layout.
 */

public static final int MASTERED_FOR_3D = 3; // 0x3

/**
 * Prerendered for headphone playback.
 */

public static final int MASTERED_FOR_HEADPHONE = 4; // 0x4

/**
 * Stereo speaker layout.
 */

public static final int MASTERED_FOR_STEREO = 1; // 0x1

/**
 * Two-dimensional (e.g.&nbsp;5.1) speaker layout.
 */

public static final int MASTERED_FOR_SURROUND = 2; // 0x2

/**
 * No preferred reproduction channel layout.
 */

public static final int MASTERING_NOT_INDICATED = 0; // 0x0
}

