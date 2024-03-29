/*
 * Copyright (C) 2014 The Android Open Source Project
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


package android.location;


/**
 * A class representing a GNSS satellite measurement, containing raw and computed information.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class GnssMeasurement implements android.os.Parcelable {

/**
 * @hide
 */

GnssMeasurement() { throw new RuntimeException("Stub!"); }

/**
 * Gets the satellite ID.
 *
 * <p>Interpretation depends on {@link #getConstellationType()}.
 * See {@link GnssStatus#getSvid(int)}.
 */

public int getSvid() { throw new RuntimeException("Stub!"); }

/**
 * Gets the constellation type.
 *
 * <p>The return value is one of those constants with {@code CONSTELLATION_} prefix in
 * {@link GnssStatus}.

 * @return Value is {@link android.location.GnssStatus#CONSTELLATION_UNKNOWN}, {@link android.location.GnssStatus#CONSTELLATION_GPS}, {@link android.location.GnssStatus#CONSTELLATION_SBAS}, {@link android.location.GnssStatus#CONSTELLATION_GLONASS}, {@link android.location.GnssStatus#CONSTELLATION_QZSS}, {@link android.location.GnssStatus#CONSTELLATION_BEIDOU}, or {@link android.location.GnssStatus#CONSTELLATION_GALILEO}
 */

public int getConstellationType() { throw new RuntimeException("Stub!"); }

/**
 * Gets the time offset at which the measurement was taken in nanoseconds.
 *
 * <p>The reference receiver's time from which this is offset is specified by
 * {@link GnssClock#getTimeNanos()}.
 *
 * <p>The sign of this value is given by the following equation:
 * <pre>
 *      measurement time = TimeNanos + TimeOffsetNanos</pre>
 *
 * <p>The value provides an individual time-stamp for the measurement, and allows sub-nanosecond
 * accuracy.
 */

public double getTimeOffsetNanos() { throw new RuntimeException("Stub!"); }

/**
 * Gets per-satellite sync state.
 *
 * <p>It represents the current sync state for the associated satellite.
 *
 * <p>This value helps interpret {@link #getReceivedSvTimeNanos()}.

 * @return Value is either <code>0</code> or a combination of {@link android.location.GnssMeasurement#STATE_CODE_LOCK}, {@link android.location.GnssMeasurement#STATE_BIT_SYNC}, {@link android.location.GnssMeasurement#STATE_SUBFRAME_SYNC}, {@link android.location.GnssMeasurement#STATE_TOW_DECODED}, {@link android.location.GnssMeasurement#STATE_MSEC_AMBIGUOUS}, {@link android.location.GnssMeasurement#STATE_SYMBOL_SYNC}, {@link android.location.GnssMeasurement#STATE_GLO_STRING_SYNC}, {@link android.location.GnssMeasurement#STATE_GLO_TOD_DECODED}, {@link android.location.GnssMeasurement#STATE_BDS_D2_BIT_SYNC}, {@link android.location.GnssMeasurement#STATE_BDS_D2_SUBFRAME_SYNC}, {@link android.location.GnssMeasurement#STATE_GAL_E1BC_CODE_LOCK}, {@link android.location.GnssMeasurement#STATE_GAL_E1C_2ND_CODE_LOCK}, {@link android.location.GnssMeasurement#STATE_GAL_E1B_PAGE_SYNC}, {@link android.location.GnssMeasurement#STATE_SBAS_SYNC}, {@link android.location.GnssMeasurement#STATE_TOW_KNOWN}, and {@link android.location.GnssMeasurement#STATE_GLO_TOD_KNOWN}
 */

public int getState() { throw new RuntimeException("Stub!"); }

/**
 * Gets the received GNSS satellite time, at the measurement time, in nanoseconds.
 *
 * <p>For GPS &amp; QZSS, this is:
 * <ul>
 * <li>Received GPS Time-of-Week at the measurement time, in nanoseconds.</li>
 * <li>The value is relative to the beginning of the current GPS week.</li>
 * </ul>
 *
 * <p>Given the highest sync state that can be achieved, per each satellite, valid range
 * for this field can be:
 * <pre>
 *     Searching       : [ 0       ]   : STATE_UNKNOWN
 *     C/A code lock   : [ 0   1ms ]   : STATE_CODE_LOCK is set
 *     Bit sync        : [ 0  20ms ]   : STATE_BIT_SYNC is set
 *     Subframe sync   : [ 0    6s ]   : STATE_SUBFRAME_SYNC is set
 *     TOW decoded     : [ 0 1week ]   : STATE_TOW_DECODED is set
 *     TOW Known       : [ 0 1week ]   : STATE_TOW_KNOWN set</pre>
 *
 * Note: TOW Known refers to the case where TOW is possibly not decoded over the air but has
 * been determined from other sources. If TOW decoded is set then TOW Known must also be set.
 *
 * <p>Note well: if there is any ambiguity in integer millisecond, {@code STATE_MSEC_AMBIGUOUS}
 * must be set accordingly, in the 'state' field.
 *
 * <p>This value must be populated if 'state' != {@code STATE_UNKNOWN}.
 *
 * <p>For Glonass, this is:
 * <ul>
 * <li>Received Glonass time of day, at the measurement time in nanoseconds.</li>
 * </ul>
 *
 * <p>Given the highest sync state that can be achieved, per each satellite, valid range for
 * this field can be:
 * <pre>
 *     Searching           : [ 0       ]   : STATE_UNKNOWN
 *     C/A code lock       : [ 0   1ms ]   : STATE_CODE_LOCK is set
 *     Symbol sync         : [ 0  10ms ]   : STATE_SYMBOL_SYNC is set
 *     Bit sync            : [ 0  20ms ]   : STATE_BIT_SYNC is set
 *     String sync         : [ 0    2s ]   : STATE_GLO_STRING_SYNC is set
 *     Time of day decoded : [ 0  1day ]   : STATE_GLO_TOD_DECODED is set
 *     Time of day known   : [ 0  1day ]   : STATE_GLO_TOD_KNOWN set</pre>
 *
 * Note: Time of day known refers to the case where it is possibly not decoded over the air but
 * has been determined from other sources. If Time of day decoded is set then Time of day known
 * must also be set.
 *
 * <p>For Beidou, this is:
 * <ul>
 * <li>Received Beidou time of week, at the measurement time in nanoseconds.</li>
 * </ul>
 *
 * <p>Given the highest sync state that can be achieved, per each satellite, valid range for
 * this field can be:
 * <pre>
 *     Searching              : [ 0       ]   : STATE_UNKNOWN
 *     C/A code lock          : [ 0   1ms ]   : STATE_CODE_LOCK is set
 *     Bit sync (D2)          : [ 0   2ms ]   : STATE_BDS_D2_BIT_SYNC is set
 *     Bit sync (D1)          : [ 0  20ms ]   : STATE_BIT_SYNC is set
 *     Subframe (D2)          : [ 0  0.6s ]   : STATE_BDS_D2_SUBFRAME_SYNC is set
 *     Subframe (D1)          : [ 0    6s ]   : STATE_SUBFRAME_SYNC is set
 *     Time of week decoded   : [ 0 1week ]   : STATE_TOW_DECODED is set
 *     Time of week known     : [ 0 1week ]   : STATE_TOW_KNOWN set</pre>
 *
 * Note: TOW Known refers to the case where TOW is possibly not decoded over the air but has
 * been determined from other sources. If TOW decoded is set then TOW Known must also be set.
 *
 * <p>For Galileo, this is:
 * <ul>
 * <li>Received Galileo time of week, at the measurement time in nanoseconds.</li>
 * </ul>
 * <pre>
 *     E1BC code lock       : [ 0   4ms ]  : STATE_GAL_E1BC_CODE_LOCK is set
 *     E1C 2nd code lock    : [ 0 100ms ]  : STATE_GAL_E1C_2ND_CODE_LOCK is set
 *     E1B page             : [ 0    2s ]  : STATE_GAL_E1B_PAGE_SYNC is set
 *     Time of week decoded : [ 0 1week ]  : STATE_TOW_DECODED is set
 *     Time of week known   : [ 0 1week ]  : STATE_TOW_KNOWN set</pre>
 *
 * Note: TOW Known refers to the case where TOW is possibly not decoded over the air but has
 * been determined from other sources. If TOW decoded is set then TOW Known must also be set.
 *
 * <p>For SBAS, this is:
 * <ul>
 * <li>Received SBAS time, at the measurement time in nanoseconds.</li>
 * </ul>
 *
 * <p>Given the highest sync state that can be achieved, per each satellite, valid range for
 * this field can be:
 * <pre>
 *     Searching       : [ 0       ]   : STATE_UNKNOWN
 *     C/A code lock   : [ 0   1ms ]   : STATE_CODE_LOCK is set
 *     Symbol sync     : [ 0   2ms ]   : STATE_SYMBOL_SYNC is set
 *     Message         : [ 0    1s ]   : STATE_SBAS_SYNC is set</pre>
 */

public long getReceivedSvTimeNanos() { throw new RuntimeException("Stub!"); }

/**
 * Gets the error estimate (1-sigma) for the received GNSS time, in nanoseconds.
 */

public long getReceivedSvTimeUncertaintyNanos() { throw new RuntimeException("Stub!"); }

/**
 * Gets the Carrier-to-noise density in dB-Hz.
 *
 * <p>Typical range: 10-50 db-Hz.
 *
 * <p>The value contains the measured C/N0 for the signal at the antenna input.
 */

public double getCn0DbHz() { throw new RuntimeException("Stub!"); }

/**
 * Gets the Pseudorange rate at the timestamp in m/s.
 *
 * <p>The error estimate for this value is
 * {@link #getPseudorangeRateUncertaintyMetersPerSecond()}.
 *
 * <p>The value is uncorrected, i.e. corrections for receiver and satellite clock frequency
 * errors are not included.
 *
 * <p>A positive 'uncorrected' value indicates that the SV is moving away from the receiver. The
 * sign of the 'uncorrected' 'pseudorange rate' and its relation to the sign of 'doppler shift'
 * is given by the equation:
 *
 * <pre>
 *      pseudorange rate = -k * doppler shift   (where k is a constant)</pre>
 */

public double getPseudorangeRateMetersPerSecond() { throw new RuntimeException("Stub!"); }

/**
 * Gets the pseudorange's rate uncertainty (1-Sigma) in m/s.
 *
 * <p>The uncertainty is represented as an absolute (single sided) value.
 */

public double getPseudorangeRateUncertaintyMetersPerSecond() { throw new RuntimeException("Stub!"); }

/**
 * Gets 'Accumulated Delta Range' state.
 *
 * <p>It indicates whether {@link #getAccumulatedDeltaRangeMeters()} is reset or there is a
 * cycle slip (indicating 'loss of lock').

 * @return Value is either <code>0</code> or a combination of {@link android.location.GnssMeasurement#ADR_STATE_VALID}, {@link android.location.GnssMeasurement#ADR_STATE_RESET}, {@link android.location.GnssMeasurement#ADR_STATE_CYCLE_SLIP}, {@link android.location.GnssMeasurement#ADR_STATE_HALF_CYCLE_RESOLVED}, and {@link android.location.GnssMeasurement#ADR_STATE_HALF_CYCLE_REPORTED}
 */

public int getAccumulatedDeltaRangeState() { throw new RuntimeException("Stub!"); }

/**
 * Gets the accumulated delta range since the last channel reset, in meters.
 *
 * <p>The error estimate for this value is {@link #getAccumulatedDeltaRangeUncertaintyMeters()}.
 *
 * <p>The availability of the value is represented by {@link #getAccumulatedDeltaRangeState()}.
 *
 * <p>A positive value indicates that the SV is moving away from the receiver.
 * The sign of {@link #getAccumulatedDeltaRangeMeters()} and its relation to the sign of
 * {@link #getCarrierPhase()} is given by the equation:
 *
 * <pre>
 *          accumulated delta range = -k * carrier phase    (where k is a constant)</pre>
 *
 * <p>Similar to the concept of an RTCM "Phaserange", when the accumulated delta range is
 * initially chosen, and whenever it is reset, it will retain the integer nature
 * of the relative carrier phase offset between satellites observed by this receiver, such that
 * the double difference of this value between receivers and satellites may be used, together
 * with integer ambiguity resolution, to determine highly precise relative location between
 * receivers.
 *
 * <p>This includes ensuring that all half-cycle ambiguities are resolved before this value is
 * reported as {@link #ADR_STATE_VALID}.
 */

public double getAccumulatedDeltaRangeMeters() { throw new RuntimeException("Stub!"); }

/**
 * Gets the accumulated delta range's uncertainty (1-Sigma) in meters.
 *
 * <p>The uncertainty is represented as an absolute (single sided) value.
 *
 * <p>The status of the value is represented by {@link #getAccumulatedDeltaRangeState()}.
 */

public double getAccumulatedDeltaRangeUncertaintyMeters() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if {@link #getCarrierFrequencyHz()} is available, {@code false}
 * otherwise.
 */

public boolean hasCarrierFrequencyHz() { throw new RuntimeException("Stub!"); }

/**
 * Gets the carrier frequency of the tracked signal.
 *
 * <p>For example it can be the GPS central frequency for L1 = 1575.45 MHz, or L2 = 1227.60 MHz,
 * L5 = 1176.45 MHz, varying GLO channels, etc. If the field is not set, it is the primary
 * common use central frequency, e.g. L1 = 1575.45 MHz for GPS.
 *
 * <p> For an L1, L5 receiver tracking a satellite on L1 and L5 at the same time, two raw
 * measurement objects will be reported for this same satellite, in one of the measurement
 * objects, all the values related to L1 will be filled, and in the other all of the values
 * related to L5 will be filled.
 *
 * <p>The value is only available if {@link #hasCarrierFrequencyHz()} is {@code true}.
 *
 * @return the carrier frequency of the signal tracked in Hz.
 */

public float getCarrierFrequencyHz() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if {@link #getCarrierCycles()} is available, {@code false} otherwise.
 *
 * @deprecated use {@link #getAccumulatedDeltaRangeState()} instead.
 */

@Deprecated public boolean hasCarrierCycles() { throw new RuntimeException("Stub!"); }

/**
 * The number of full carrier cycles between the satellite and the receiver.
 *
 * <p>The reference frequency is given by the value of {@link #getCarrierFrequencyHz()}.
 *
 * <p>The value is only available if {@link #hasCarrierCycles()} is {@code true}.
 *
 * @deprecated use {@link #getAccumulatedDeltaRangeMeters()} instead.
 */

@Deprecated public long getCarrierCycles() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if {@link #getCarrierPhase()} is available, {@code false} otherwise.
 *
 * @deprecated use {@link #getAccumulatedDeltaRangeState()} instead.
 */

@Deprecated public boolean hasCarrierPhase() { throw new RuntimeException("Stub!"); }

/**
 * Gets the RF phase detected by the receiver.
 *
 * <p>Range: [0.0, 1.0].
 *
 * <p>This is the fractional part of the complete carrier phase measurement.
 *
 * <p>The reference frequency is given by the value of {@link #getCarrierFrequencyHz()}.
 *
 * <p>The error estimate for this value is {@link #getCarrierPhaseUncertainty()}.
 *
 * <p>The value is only available if {@link #hasCarrierPhase()} is {@code true}.
 *
 * @deprecated use {@link #getAccumulatedDeltaRangeMeters()} instead.
 */

@Deprecated public double getCarrierPhase() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if {@link #getCarrierPhaseUncertainty()} is available, {@code false}
 * otherwise.
 *
 * @deprecated use {@link #getAccumulatedDeltaRangeState()} instead.
 */

@Deprecated public boolean hasCarrierPhaseUncertainty() { throw new RuntimeException("Stub!"); }

/**
 * Gets the carrier-phase's uncertainty (1-Sigma).
 *
 * <p>The uncertainty is represented as an absolute (single sided) value.
 *
 * <p>The value is only available if {@link #hasCarrierPhaseUncertainty()} is {@code true}.
 *
 * @deprecated use {@link #getAccumulatedDeltaRangeUncertaintyMeters()} instead.
 */

@Deprecated public double getCarrierPhaseUncertainty() { throw new RuntimeException("Stub!"); }

/**
 * Gets a value indicating the 'multipath' state of the event.

 * @return Value is {@link android.location.GnssMeasurement#MULTIPATH_INDICATOR_UNKNOWN}, {@link android.location.GnssMeasurement#MULTIPATH_INDICATOR_DETECTED}, or {@link android.location.GnssMeasurement#MULTIPATH_INDICATOR_NOT_DETECTED}
 */

public int getMultipathIndicator() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if {@link #getSnrInDb()} is available, {@code false} otherwise.
 */

public boolean hasSnrInDb() { throw new RuntimeException("Stub!"); }

/**
 * Gets the (post-correlation & integration) Signal-to-Noise ratio (SNR) in dB.
 *
 * <p>The value is only available if {@link #hasSnrInDb()} is {@code true}.
 */

public double getSnrInDb() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if {@link #getAutomaticGainControlLevelDb()} is available,
 * {@code false} otherwise.
 */

public boolean hasAutomaticGainControlLevelDb() { throw new RuntimeException("Stub!"); }

/**
 * Gets the Automatic Gain Control level in dB.
 *
 * <p> AGC acts as a variable gain amplifier adjusting the power of the incoming signal. The AGC
 * level may be used to indicate potential interference. When AGC is at a nominal level, this
 * value must be set as 0. Higher gain (and/or lower input power) shall be output as a positive
 * number. Hence in cases of strong jamming, in the band of this signal, this value will go more
 * negative.
 *
 * <p> Note: Different hardware designs (e.g. antenna, pre-amplification, or other RF HW
 * components) may also affect the typical output of of this value on any given hardware design
 * in an open sky test - the important aspect of this output is that changes in this value are
 * indicative of changes on input signal power in the frequency band for this measurement.
 *
 * <p> The value is only available if {@link #hasAutomaticGainControlLevelDb()} is {@code true}
 */

public double getAutomaticGainControlLevelDb() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * The state of the {@link #getAccumulatedDeltaRangeMeters()} has a cycle slip detected.
 */

public static final int ADR_STATE_CYCLE_SLIP = 4; // 0x4

/**
 * Reports whether the flag {@link #ADR_STATE_HALF_CYCLE_RESOLVED} has been reported by the
 * GNSS hardware.
 *
 * <p> When this bit is set, the value of {@link #getAccumulatedDeltaRangeUncertaintyMeters()}
 * can be low (centimeter level) whether or not the half cycle ambiguity is resolved.
 *
 * <p> When this bit is unset, the value of {@link #getAccumulatedDeltaRangeUncertaintyMeters()}
 * is larger, to cover the potential error due to half cycle ambiguity being unresolved.
 */

public static final int ADR_STATE_HALF_CYCLE_REPORTED = 16; // 0x10

/**
 * Reports whether the value {@link #getAccumulatedDeltaRangeMeters()} has resolved the half
 * cycle ambiguity.
 *
 * <p> When this bit is set, the {@link #getAccumulatedDeltaRangeMeters()} corresponds to the
 * carrier phase measurement plus an accumulated integer number of carrier full cycles.
 *
 * <p> When this bit is unset, the {@link #getAccumulatedDeltaRangeMeters()} corresponds to the
 * carrier phase measurement plus an accumulated integer number of carrier half cycles.
 */

public static final int ADR_STATE_HALF_CYCLE_RESOLVED = 8; // 0x8

/**
 * The state of the {@link #getAccumulatedDeltaRangeMeters()} has detected a reset.
 */

public static final int ADR_STATE_RESET = 2; // 0x2

/**
 * The state of the value {@link #getAccumulatedDeltaRangeMeters()} is invalid or unknown.
 */

public static final int ADR_STATE_UNKNOWN = 0; // 0x0

/**
 * The state of the {@link #getAccumulatedDeltaRangeMeters()} is valid.
 */

public static final int ADR_STATE_VALID = 1; // 0x1

public static final android.os.Parcelable.Creator<android.location.GnssMeasurement> CREATOR;
static { CREATOR = null; }

/**
 * The measurement shows signs of multi-path.
 */

public static final int MULTIPATH_INDICATOR_DETECTED = 1; // 0x1

/**
 * The measurement shows no signs of multi-path.
 */

public static final int MULTIPATH_INDICATOR_NOT_DETECTED = 2; // 0x2

/**
 * The indicator is not available or the presence or absence of multipath is unknown.
 */

public static final int MULTIPATH_INDICATOR_UNKNOWN = 0; // 0x0

/** This Beidou measurement's tracking state has D2 bit sync. */

public static final int STATE_BDS_D2_BIT_SYNC = 256; // 0x100

/** This Beidou measurement's tracking state has D2 sub-frame sync. */

public static final int STATE_BDS_D2_SUBFRAME_SYNC = 512; // 0x200

/** This GNSS measurement's tracking state has bit sync. */

public static final int STATE_BIT_SYNC = 2; // 0x2

/** This GNSS measurement's tracking state has code lock. */

public static final int STATE_CODE_LOCK = 1; // 0x1

/** This Galileo measurement's tracking state has E1B/C code lock. */

public static final int STATE_GAL_E1BC_CODE_LOCK = 1024; // 0x400

/** This Galileo measurement's tracking state has E1B page sync. */

public static final int STATE_GAL_E1B_PAGE_SYNC = 4096; // 0x1000

/** This Galileo measurement's tracking state has E1C secondary code lock. */

public static final int STATE_GAL_E1C_2ND_CODE_LOCK = 2048; // 0x800

/** This Glonass measurement's tracking state has string sync. */

public static final int STATE_GLO_STRING_SYNC = 64; // 0x40

/** This Glonass measurement's tracking state has time-of-day decoded. */

public static final int STATE_GLO_TOD_DECODED = 128; // 0x80

/**
 * This Glonass measurement's tracking state has time-of-day known, possibly not decoded
 * over the air but has been determined from other sources. If TOD decoded is set then TOD Known
 * will also be set.
 */

public static final int STATE_GLO_TOD_KNOWN = 32768; // 0x8000

/** This GNSS measurement's tracking state contains millisecond ambiguity. */

public static final int STATE_MSEC_AMBIGUOUS = 16; // 0x10

/** This SBAS measurement's tracking state has whole second level sync. */

public static final int STATE_SBAS_SYNC = 8192; // 0x2000

/** This GNSS measurement's tracking state has sub-frame sync. */

public static final int STATE_SUBFRAME_SYNC = 4; // 0x4

/** This GNSS measurement's tracking state has symbol sync. */

public static final int STATE_SYMBOL_SYNC = 32; // 0x20

/** This GNSS measurement's tracking state has time-of-week decoded. */

public static final int STATE_TOW_DECODED = 8; // 0x8

/**
 * This GNSS measurement's tracking state has time-of-week known, possibly not decoded
 * over the air but has been determined from other sources. If TOW decoded is set then TOW Known
 * will also be set.
 */

public static final int STATE_TOW_KNOWN = 16384; // 0x4000

/** This GNSS measurement's tracking state is invalid or unknown. */

public static final int STATE_UNKNOWN = 0; // 0x0
}

