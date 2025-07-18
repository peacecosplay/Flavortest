package quickresto.webterminal;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"quickresto/webterminal/AppDatabaseKt$MIGRATION_20_21$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppDatabase.kt */
public final class AppDatabaseKt$MIGRATION_20_21$1 extends Migration {
    AppDatabaseKt$MIGRATION_20_21$1() {
        super(20, 21);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
        supportSQLiteDatabase.execSQL("ALTER TABLE tableOrders RENAME TO tableOrders_");
        supportSQLiteDatabase.execSQL("CREATE TABLE tableOrders (`terminalId` TEXT NOT NULL, `kkmId` TEXT, `kkmManufacturerDeviceId` TEXT, `creatorUser` TEXT NOT NULL, `createTime` TEXT NOT NULL, `updateTime` TEXT NOT NULL, `guestCount` INTEGER NOT NULL, `tableId` INTEGER, `status` TEXT NOT NULL, `waiterName` TEXT, `tableName` TEXT, `floorName` TEXT, `comment` TEXT, `shiftId` TEXT, `shiftDocumentId` TEXT, `organizationId` INTEGER NOT NULL, `organizationName` TEXT, `organizationInn` TEXT, `number` TEXT NOT NULL, `basicPriceModifiers` TEXT NOT NULL, `createLocalDate` TEXT NOT NULL, `id` TEXT NOT NULL, `onlineOfferId` TEXT, `deliveryAmount` REAL, `deliveryDocument` TEXT, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("INSERT INTO tableOrders(`terminalId`, `kkmId`, `kkmManufacturerDeviceId`, `creatorUser`, `createTime`, `updateTime`, `guestCount`, `tableId`, `status`, `waiterName`, `tableName`, `floorName`, `comment`, `shiftId`, `shiftDocumentId`, `organizationId`, `organizationName`, `organizationInn`, `number`, `basicPriceModifiers`, `createLocalDate`, `id`, `onlineOfferId`, `deliveryAmount`, `deliveryDocument`) SELECT `terminalId`, `kkmId`, `kkmManufacturerDeviceId`, `creatorUser`, `createTime`, `updateTime`, `guestCount`, `tableId`, `status`, `waiterName`, `tableName`, `floorName`, `comment`, `shiftId`, `shiftDocumentId`, `organizationId`, `organizationName`, `organizationInn`, `number`, `basicPriceModifiers`, `createLocalDate`, `id`, `onlineOfferId`, `deliveryAmount`, NULL from tableOrders_");
        supportSQLiteDatabase.execSQL("DROP TABLE tableOrders_");
    }
}
