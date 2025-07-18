package quickresto.webterminal;

import android.content.Context;
import androidx.room.Room;
import androidx.room.migration.Migration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\bG\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020M\u001a\u0016\u0010N\u001a\u00020O2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020M\u001a\u0016\u0010P\u001a\u00020Q2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020M\u001a\u0016\u0010R\u001a\u00020S2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020M\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003\"\u0011\u0010\b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0003\"\u0011\u0010\n\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0003\"\u0011\u0010\f\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0003\"\u0011\u0010\u000e\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0003\"\u0011\u0010\u0010\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0003\"\u0011\u0010\u0012\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0003\"\u0011\u0010\u0014\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0003\"\u0011\u0010\u0016\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0003\"\u0011\u0010\u0018\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0003\"\u0011\u0010\u001a\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0003\"\u0011\u0010\u001c\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0003\"\u0011\u0010\u001e\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0003\"\u0011\u0010 \u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0003\"\u0011\u0010\"\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0003\"\u0011\u0010$\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0003\"\u0011\u0010&\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0003\"\u0011\u0010(\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0003\"\u0011\u0010*\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0003\"\u0011\u0010,\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0003\"\u0011\u0010.\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0003\"\u0011\u00100\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0003\"\u0011\u00102\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0003\"\u0011\u00104\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0003\"\u0011\u00106\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0003\"\u0011\u00108\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0003\"\u0011\u0010:\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0003\"\u0011\u0010<\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0003\"\u0011\u0010>\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0003\"\u0011\u0010@\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0003\"\u0011\u0010B\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0003\"\u0011\u0010D\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u0003\"\u0011\u0010F\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u0003¨\u0006T"}, d2 = {"MIGRATION_10_11", "Landroidx/room/migration/Migration;", "getMIGRATION_10_11", "()Landroidx/room/migration/Migration;", "MIGRATION_11_12", "getMIGRATION_11_12", "MIGRATION_12_13", "getMIGRATION_12_13", "MIGRATION_13_14", "getMIGRATION_13_14", "MIGRATION_14_15", "getMIGRATION_14_15", "MIGRATION_15_16", "getMIGRATION_15_16", "MIGRATION_16_17", "getMIGRATION_16_17", "MIGRATION_17_18", "getMIGRATION_17_18", "MIGRATION_18_19", "getMIGRATION_18_19", "MIGRATION_19_20", "getMIGRATION_19_20", "MIGRATION_20_21", "getMIGRATION_20_21", "MIGRATION_21_22", "getMIGRATION_21_22", "MIGRATION_22_23", "getMIGRATION_22_23", "MIGRATION_23_24", "getMIGRATION_23_24", "MIGRATION_24_25", "getMIGRATION_24_25", "MIGRATION_25_26", "getMIGRATION_25_26", "MIGRATION_26_27", "getMIGRATION_26_27", "MIGRATION_27_28", "getMIGRATION_27_28", "MIGRATION_28_29", "getMIGRATION_28_29", "MIGRATION_2_3", "getMIGRATION_2_3", "MIGRATION_3_4", "getMIGRATION_3_4", "MIGRATION_4_5", "getMIGRATION_4_5", "MIGRATION_5_6", "getMIGRATION_5_6", "MIGRATION_6_7", "getMIGRATION_6_7", "MIGRATION_7_8", "getMIGRATION_7_8", "MIGRATION_8_9", "getMIGRATION_8_9", "MIGRATION_9_10", "getMIGRATION_9_10", "SHIFT_MIGRATION_1_2", "getSHIFT_MIGRATION_1_2", "SHIFT_MIGRATION_2_3", "getSHIFT_MIGRATION_2_3", "SHIFT_MIGRATION_3_4", "getSHIFT_MIGRATION_3_4", "SHIFT_MIGRATION_4_5", "getSHIFT_MIGRATION_4_5", "SPEC_MIGRATION_1_2", "getSPEC_MIGRATION_1_2", "SPEC_MIGRATION_2_3", "getSPEC_MIGRATION_2_3", "TABLE_ORDER_MIGRATION_1_2", "getTABLE_ORDER_MIGRATION_1_2", "TABLE_ORDER_MIGRATION_2_3", "getTABLE_ORDER_MIGRATION_2_3", "createDatabase", "Lquickresto/webterminal/AppDatabase;", "databaseName", "", "applicationContext", "Landroid/content/Context;", "createShiftDatabase", "Lquickresto/webterminal/ShiftAppDatabase;", "createSpecialDatabase", "Lquickresto/webterminal/SpecialAppDatabase;", "createTableOrderDatabase", "Lquickresto/webterminal/TableOrderAppDatabase;", "quickresto.webterminal-9.5.7(254)_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppDatabase.kt */
public final class AppDatabaseKt {
    private static final Migration MIGRATION_10_11 = new AppDatabaseKt$MIGRATION_10_11$1();
    private static final Migration MIGRATION_11_12 = new AppDatabaseKt$MIGRATION_11_12$1();
    private static final Migration MIGRATION_12_13 = new AppDatabaseKt$MIGRATION_12_13$1();
    private static final Migration MIGRATION_13_14 = new AppDatabaseKt$MIGRATION_13_14$1();
    private static final Migration MIGRATION_14_15 = new AppDatabaseKt$MIGRATION_14_15$1();
    private static final Migration MIGRATION_15_16 = new AppDatabaseKt$MIGRATION_15_16$1();
    private static final Migration MIGRATION_16_17 = new AppDatabaseKt$MIGRATION_16_17$1();
    private static final Migration MIGRATION_17_18 = new AppDatabaseKt$MIGRATION_17_18$1();
    private static final Migration MIGRATION_18_19 = new AppDatabaseKt$MIGRATION_18_19$1();
    private static final Migration MIGRATION_19_20 = new AppDatabaseKt$MIGRATION_19_20$1();
    private static final Migration MIGRATION_20_21 = new AppDatabaseKt$MIGRATION_20_21$1();
    private static final Migration MIGRATION_21_22 = new AppDatabaseKt$MIGRATION_21_22$1();
    private static final Migration MIGRATION_22_23 = new AppDatabaseKt$MIGRATION_22_23$1();
    private static final Migration MIGRATION_23_24 = new AppDatabaseKt$MIGRATION_23_24$1();
    private static final Migration MIGRATION_24_25 = new AppDatabaseKt$MIGRATION_24_25$1();
    private static final Migration MIGRATION_25_26 = new AppDatabaseKt$MIGRATION_25_26$1();
    private static final Migration MIGRATION_26_27 = new AppDatabaseKt$MIGRATION_26_27$1();
    private static final Migration MIGRATION_27_28 = new AppDatabaseKt$MIGRATION_27_28$1();
    private static final Migration MIGRATION_28_29 = new AppDatabaseKt$MIGRATION_28_29$1();
    private static final Migration MIGRATION_2_3 = new AppDatabaseKt$MIGRATION_2_3$1();
    private static final Migration MIGRATION_3_4 = new AppDatabaseKt$MIGRATION_3_4$1();
    private static final Migration MIGRATION_4_5 = new AppDatabaseKt$MIGRATION_4_5$1();
    private static final Migration MIGRATION_5_6 = new AppDatabaseKt$MIGRATION_5_6$1();
    private static final Migration MIGRATION_6_7 = new AppDatabaseKt$MIGRATION_6_7$1();
    private static final Migration MIGRATION_7_8 = new AppDatabaseKt$MIGRATION_7_8$1();
    private static final Migration MIGRATION_8_9 = new AppDatabaseKt$MIGRATION_8_9$1();
    private static final Migration MIGRATION_9_10 = new AppDatabaseKt$MIGRATION_9_10$1();
    private static final Migration SHIFT_MIGRATION_1_2 = new AppDatabaseKt$SHIFT_MIGRATION_1_2$1();
    private static final Migration SHIFT_MIGRATION_2_3 = new AppDatabaseKt$SHIFT_MIGRATION_2_3$1();
    private static final Migration SHIFT_MIGRATION_3_4 = new AppDatabaseKt$SHIFT_MIGRATION_3_4$1();
    private static final Migration SHIFT_MIGRATION_4_5 = new AppDatabaseKt$SHIFT_MIGRATION_4_5$1();
    private static final Migration SPEC_MIGRATION_1_2 = new AppDatabaseKt$SPEC_MIGRATION_1_2$1();
    private static final Migration SPEC_MIGRATION_2_3 = new AppDatabaseKt$SPEC_MIGRATION_2_3$1();
    private static final Migration TABLE_ORDER_MIGRATION_1_2 = new AppDatabaseKt$TABLE_ORDER_MIGRATION_1_2$1();
    private static final Migration TABLE_ORDER_MIGRATION_2_3 = new AppDatabaseKt$TABLE_ORDER_MIGRATION_2_3$1();

    public static final AppDatabase createDatabase(String str, Context context) {
        Intrinsics.checkNotNullParameter(str, "databaseName");
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        return Room.databaseBuilder(context, AppDatabase.class, str).allowMainThreadQueries().addMigrations(MIGRATION_2_3, MIGRATION_3_4, MIGRATION_4_5, MIGRATION_5_6, MIGRATION_6_7, MIGRATION_7_8, MIGRATION_8_9, MIGRATION_9_10, MIGRATION_10_11, MIGRATION_11_12, MIGRATION_12_13, MIGRATION_13_14, MIGRATION_14_15, MIGRATION_15_16, MIGRATION_16_17, MIGRATION_17_18, MIGRATION_18_19, MIGRATION_19_20, MIGRATION_20_21, MIGRATION_21_22, MIGRATION_22_23, MIGRATION_23_24, MIGRATION_24_25, MIGRATION_25_26, MIGRATION_26_27, MIGRATION_27_28, MIGRATION_28_29).build();
    }

    public static final SpecialAppDatabase createSpecialDatabase(String str, Context context) {
        Intrinsics.checkNotNullParameter(str, "databaseName");
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        return Room.databaseBuilder(context, SpecialAppDatabase.class, str).allowMainThreadQueries().addMigrations(SPEC_MIGRATION_1_2, SPEC_MIGRATION_2_3).build();
    }

    public static final ShiftAppDatabase createShiftDatabase(String str, Context context) {
        Intrinsics.checkNotNullParameter(str, "databaseName");
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        return Room.databaseBuilder(context, ShiftAppDatabase.class, str).allowMainThreadQueries().addMigrations(SHIFT_MIGRATION_1_2, SHIFT_MIGRATION_2_3, SHIFT_MIGRATION_3_4, SHIFT_MIGRATION_4_5).build();
    }

    public static final TableOrderAppDatabase createTableOrderDatabase(String str, Context context) {
        Intrinsics.checkNotNullParameter(str, "databaseName");
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        return Room.databaseBuilder(context, TableOrderAppDatabase.class, str).allowMainThreadQueries().addMigrations(TABLE_ORDER_MIGRATION_1_2, TABLE_ORDER_MIGRATION_2_3).build();
    }

    public static final Migration getMIGRATION_2_3() {
        return MIGRATION_2_3;
    }

    public static final Migration getMIGRATION_3_4() {
        return MIGRATION_3_4;
    }

    public static final Migration getMIGRATION_4_5() {
        return MIGRATION_4_5;
    }

    public static final Migration getMIGRATION_5_6() {
        return MIGRATION_5_6;
    }

    public static final Migration getMIGRATION_6_7() {
        return MIGRATION_6_7;
    }

    public static final Migration getMIGRATION_7_8() {
        return MIGRATION_7_8;
    }

    public static final Migration getMIGRATION_8_9() {
        return MIGRATION_8_9;
    }

    public static final Migration getMIGRATION_9_10() {
        return MIGRATION_9_10;
    }

    public static final Migration getMIGRATION_10_11() {
        return MIGRATION_10_11;
    }

    public static final Migration getMIGRATION_11_12() {
        return MIGRATION_11_12;
    }

    public static final Migration getMIGRATION_12_13() {
        return MIGRATION_12_13;
    }

    public static final Migration getMIGRATION_13_14() {
        return MIGRATION_13_14;
    }

    public static final Migration getMIGRATION_14_15() {
        return MIGRATION_14_15;
    }

    public static final Migration getMIGRATION_15_16() {
        return MIGRATION_15_16;
    }

    public static final Migration getMIGRATION_16_17() {
        return MIGRATION_16_17;
    }

    public static final Migration getMIGRATION_17_18() {
        return MIGRATION_17_18;
    }

    public static final Migration getMIGRATION_18_19() {
        return MIGRATION_18_19;
    }

    public static final Migration getMIGRATION_19_20() {
        return MIGRATION_19_20;
    }

    public static final Migration getMIGRATION_20_21() {
        return MIGRATION_20_21;
    }

    public static final Migration getMIGRATION_21_22() {
        return MIGRATION_21_22;
    }

    public static final Migration getMIGRATION_22_23() {
        return MIGRATION_22_23;
    }

    public static final Migration getMIGRATION_23_24() {
        return MIGRATION_23_24;
    }

    public static final Migration getMIGRATION_24_25() {
        return MIGRATION_24_25;
    }

    public static final Migration getMIGRATION_25_26() {
        return MIGRATION_25_26;
    }

    public static final Migration getMIGRATION_26_27() {
        return MIGRATION_26_27;
    }

    public static final Migration getMIGRATION_27_28() {
        return MIGRATION_27_28;
    }

    public static final Migration getMIGRATION_28_29() {
        return MIGRATION_28_29;
    }

    public static final Migration getSPEC_MIGRATION_1_2() {
        return SPEC_MIGRATION_1_2;
    }

    public static final Migration getSPEC_MIGRATION_2_3() {
        return SPEC_MIGRATION_2_3;
    }

    public static final Migration getTABLE_ORDER_MIGRATION_1_2() {
        return TABLE_ORDER_MIGRATION_1_2;
    }

    public static final Migration getTABLE_ORDER_MIGRATION_2_3() {
        return TABLE_ORDER_MIGRATION_2_3;
    }

    public static final Migration getSHIFT_MIGRATION_1_2() {
        return SHIFT_MIGRATION_1_2;
    }

    public static final Migration getSHIFT_MIGRATION_2_3() {
        return SHIFT_MIGRATION_2_3;
    }

    public static final Migration getSHIFT_MIGRATION_3_4() {
        return SHIFT_MIGRATION_3_4;
    }

    public static final Migration getSHIFT_MIGRATION_4_5() {
        return SHIFT_MIGRATION_4_5;
    }
}
