package quickresto.webterminal;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"quickresto/webterminal/AppDatabaseKt$SHIFT_MIGRATION_4_5$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppDatabase.kt */
public final class AppDatabaseKt$SHIFT_MIGRATION_4_5$1 extends Migration {
    AppDatabaseKt$SHIFT_MIGRATION_4_5$1() {
        super(4, 5);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
        supportSQLiteDatabase.execSQL("ALTER TABLE shift RENAME TO shift___");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `shift` (`id` TEXT NOT NULL, `replicationStatus` TEXT NOT NULL, `syncTime` TEXT, `shiftNumber` INTEGER, `shiftId` TEXT, `openUserId` INTEGER NOT NULL, `kkmId` TEXT NOT NULL, `deviceId` TEXT, `deviceType` TEXT NOT NULL, `actionType` TEXT NOT NULL, `closeShiftRequest` TEXT, `createTime` TEXT NOT NULL, `openedTime` TEXT, `salePlaceId` INTEGER,`sellCounters` TEXT, `nonFiscalCounters` TEXT, `writeOffCounters` TEXT, `registerValues` TEXT, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("INSERT INTO shift(`id`, `replicationStatus`, `syncTime`, `shiftNumber`, `shiftId`, `openUserId`, `kkmId`, `deviceId`, `deviceType`, `actionType`, `closeShiftRequest`, `createTime`, `openedTime`, `salePlaceId`, `sellCounters`, `nonFiscalCounters`, `writeOffCounters`, `registerValues`) SELECT `id`, `replicationStatus`, `syncTime`, `shiftNumber`, `shiftId`, `openUserId`, `kkmId`, `deviceId`, `deviceType`, `actionType`, `closeShiftRequest`, `createTime`, `openedTime`, `salePlaceId`, NULL, NULL, NULL, NULL FROM shift___");
        supportSQLiteDatabase.execSQL("DROP TABLE shift___");
    }
}
