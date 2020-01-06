/*
 * Copyright (C) 2017 The Android Open Source Project
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


package android.telephony;


/**
 * Contains access network related constants.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AccessNetworkConstants {

/** @hide */

AccessNetworkConstants() { throw new RuntimeException("Stub!"); }
@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class AccessNetworkType {

/** @hide */

AccessNetworkType() { throw new RuntimeException("Stub!"); }

public static final int CDMA2000 = 4; // 0x4

public static final int EUTRAN = 3; // 0x3

public static final int GERAN = 1; // 0x1

public static final int IWLAN = 5; // 0x5

public static final int UNKNOWN = 0; // 0x0

public static final int UTRAN = 2; // 0x2
}

/**
 * Frenquency bands for EUTRAN.
 * http://www.etsi.org/deliver/etsi_ts/136100_136199/136101/14.03.00_60/ts_136101v140p.pdf
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class EutranBand {

/** @hide */

EutranBand() { throw new RuntimeException("Stub!"); }

public static final int BAND_1 = 1; // 0x1

public static final int BAND_10 = 10; // 0xa

public static final int BAND_11 = 11; // 0xb

public static final int BAND_12 = 12; // 0xc

public static final int BAND_13 = 13; // 0xd

public static final int BAND_14 = 14; // 0xe

public static final int BAND_17 = 17; // 0x11

public static final int BAND_18 = 18; // 0x12

public static final int BAND_19 = 19; // 0x13

public static final int BAND_2 = 2; // 0x2

public static final int BAND_20 = 20; // 0x14

public static final int BAND_21 = 21; // 0x15

public static final int BAND_22 = 22; // 0x16

public static final int BAND_23 = 23; // 0x17

public static final int BAND_24 = 24; // 0x18

public static final int BAND_25 = 25; // 0x19

public static final int BAND_26 = 26; // 0x1a

public static final int BAND_27 = 27; // 0x1b

public static final int BAND_28 = 28; // 0x1c

public static final int BAND_3 = 3; // 0x3

public static final int BAND_30 = 30; // 0x1e

public static final int BAND_31 = 31; // 0x1f

public static final int BAND_33 = 33; // 0x21

public static final int BAND_34 = 34; // 0x22

public static final int BAND_35 = 35; // 0x23

public static final int BAND_36 = 36; // 0x24

public static final int BAND_37 = 37; // 0x25

public static final int BAND_38 = 38; // 0x26

public static final int BAND_39 = 39; // 0x27

public static final int BAND_4 = 4; // 0x4

public static final int BAND_40 = 40; // 0x28

public static final int BAND_41 = 41; // 0x29

public static final int BAND_42 = 42; // 0x2a

public static final int BAND_43 = 43; // 0x2b

public static final int BAND_44 = 44; // 0x2c

public static final int BAND_45 = 45; // 0x2d

public static final int BAND_46 = 46; // 0x2e

public static final int BAND_47 = 47; // 0x2f

public static final int BAND_48 = 48; // 0x30

public static final int BAND_5 = 5; // 0x5

public static final int BAND_6 = 6; // 0x6

public static final int BAND_65 = 65; // 0x41

public static final int BAND_66 = 66; // 0x42

public static final int BAND_68 = 68; // 0x44

public static final int BAND_7 = 7; // 0x7

public static final int BAND_70 = 70; // 0x46

public static final int BAND_8 = 8; // 0x8

public static final int BAND_9 = 9; // 0x9
}

/**
 * Frenquency bands for GERAN.
 * http://www.etsi.org/deliver/etsi_ts/145000_145099/145005/14.00.00_60/ts_145005v140000p.pdf
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class GeranBand {

/** @hide */

GeranBand() { throw new RuntimeException("Stub!"); }

public static final int BAND_450 = 3; // 0x3

public static final int BAND_480 = 4; // 0x4

public static final int BAND_710 = 5; // 0x5

public static final int BAND_750 = 6; // 0x6

public static final int BAND_850 = 8; // 0x8

public static final int BAND_DCS1800 = 12; // 0xc

public static final int BAND_E900 = 10; // 0xa

public static final int BAND_ER900 = 14; // 0xe

public static final int BAND_P900 = 9; // 0x9

public static final int BAND_PCS1900 = 13; // 0xd

public static final int BAND_R900 = 11; // 0xb

public static final int BAND_T380 = 1; // 0x1

public static final int BAND_T410 = 2; // 0x2

public static final int BAND_T810 = 7; // 0x7
}

/**
 * Frenquency bands for UTRAN.
 * http://www.etsi.org/deliver/etsi_ts/125100_125199/125104/13.03.00_60/ts_125104v130p.pdf
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class UtranBand {

/** @hide */

UtranBand() { throw new RuntimeException("Stub!"); }

public static final int BAND_1 = 1; // 0x1

public static final int BAND_10 = 10; // 0xa

public static final int BAND_11 = 11; // 0xb

public static final int BAND_12 = 12; // 0xc

public static final int BAND_13 = 13; // 0xd

public static final int BAND_14 = 14; // 0xe

/** band 15, 16, 17, 18 are reserved */

public static final int BAND_19 = 19; // 0x13

public static final int BAND_2 = 2; // 0x2

public static final int BAND_20 = 20; // 0x14

public static final int BAND_21 = 21; // 0x15

public static final int BAND_22 = 22; // 0x16

/** band 23, 24 are reserved */

public static final int BAND_25 = 25; // 0x19

public static final int BAND_26 = 26; // 0x1a

public static final int BAND_3 = 3; // 0x3

public static final int BAND_4 = 4; // 0x4

public static final int BAND_5 = 5; // 0x5

public static final int BAND_6 = 6; // 0x6

public static final int BAND_7 = 7; // 0x7

public static final int BAND_8 = 8; // 0x8

public static final int BAND_9 = 9; // 0x9
}

}

