package quickresto.webterminal;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"quickresto/webterminal/AppDatabaseKt$MIGRATION_26_27$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppDatabase.kt */
public final class AppDatabaseKt$MIGRATION_26_27$1 extends Migration {
    AppDatabaseKt$MIGRATION_26_27$1() {
        super(26, 27);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
        supportSQLiteDatabase.execSQL("CREATE TABLE `menu` ('id' INTEGER PRIMARY KEY NOT NULL, 'name' TEXT NOT NULL, 'refId' TEXT NOT NULL, 'dishIdList' TEXT, 'salePlaceIdList' TEXT)");
        supportSQLiteDatabase.execSQL("ALTER TABLE shift RENAME TO shift___");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `shift` (`id` TEXT NOT NULL, `replicationStatus` TEXT NOT NULL, `syncTime` TEXT, `shiftNumber` INTEGER, `shiftId` TEXT, `openUserId` INTEGER NOT NULL, `kkmId` TEXT NOT NULL, `deviceId` TEXT, `deviceType` TEXT NOT NULL, `actionType` TEXT NOT NULL, `closeShiftRequest` TEXT, `createTime` TEXT NOT NULL, `openedTime` TEXT, `salePlaceId` INTEGER,`sellCounters` TEXT, `nonFiscalCounters` TEXT, `writeOffCounters` TEXT, `registerValues` TEXT, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("INSERT INTO shift(`id`, `replicationStatus`, `syncTime`, `shiftNumber`, `shiftId`, `openUserId`, `kkmId`, `deviceId`, `deviceType`, `actionType`, `closeShiftRequest`, `createTime`, `openedTime`, `salePlaceId`, `sellCounters`, `nonFiscalCounters`, `writeOffCounters`, `registerValues`) SELECT `id`, `replicationStatus`, `syncTime`, `shiftNumber`, `shiftId`, `openUserId`, `kkmId`, `deviceId`, `deviceType`, `actionType`, `closeShiftRequest`, `createTime`, `openedTime`, `salePlaceId`, NULL, NULL, NULL, NULL FROM shift___");
        supportSQLiteDatabase.execSQL("DROP TABLE shift___");
        supportSQLiteDatabase.execSQL("ALTER TABLE tableOrders ADD COLUMN waiterUser TEXT DEFAULT '{}' NOT NULL");
        supportSQLiteDatabase.execSQL("UPDATE tableOrders SET waiterUser = creatorUser");
        supportSQLiteDatabase.execSQL("ALTER TABLE tableOrders ADD COLUMN closedUser TEXT");
        supportSQLiteDatabase.execSQL("UPDATE tableOrders SET closedUser = null");
        supportSQLiteDatabase.execSQL("ALTER TABLE tableOrders ADD COLUMN originalTableId INTEGER");
        supportSQLiteDatabase.execSQL("UPDATE tableOrders SET originalTableId = tableId");
        supportSQLiteDatabase.execSQL("ALTER TABLE tableOrders RENAME TO tableOrders_");
        supportSQLiteDatabase.execSQL("CREATE TABLE tableOrders (`terminalId` TEXT NOT NULL, `kkmId` TEXT, `kkmManufacturerDeviceId` TEXT, `openedUser` TEXT NOT NULL, `createTime` TEXT NOT NULL, `updateTime` TEXT NOT NULL, `guestCount` INTEGER, `tableId` INTEGER, `status` TEXT NOT NULL, `waiterName` TEXT, `tableName` TEXT, `floorName` TEXT, `comment` TEXT, `shiftId` TEXT, `shiftDocumentId` TEXT, `organizationId` INTEGER NOT NULL, `organizationName` TEXT, `organizationInn` TEXT, `number` TEXT NOT NULL, `basicPriceModifiers` TEXT NOT NULL, `createLocalDate` TEXT NOT NULL, `id` TEXT NOT NULL, `onlineOfferId` TEXT, `delivery` TEXT, `localTimezoneOffsetMin` INTEGER NOT NULL, `waiterUser` TEXT NOT NULL, `closedUser` TEXT, `originalTableId` INTEGER, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("INSERT INTO tableOrders(`terminalId`, `kkmId`, `kkmManufacturerDeviceId`, `openedUser`, `createTime`, `updateTime`, `guestCount`, `tableId`, `status`, `waiterName`, `tableName`, `floorName`, `comment`, `shiftId`, `shiftDocumentId`, `organizationId`, `organizationName`, `organizationInn`, `number`, `basicPriceModifiers`, `createLocalDate`, `id`, `onlineOfferId`, `delivery`, `localTimezoneOffsetMin`, `waiterUser`, `closedUser`, `originalTableId`) SELECT `terminalId`, `kkmId`, `kkmManufacturerDeviceId`, `creatorUser`, `createTime`, `updateTime`, CASE WHEN `tableId` IS NULL THEN `guestCount` ELSE NULL END, `tableId`, `status`, `waiterName`, `tableName`, `floorName`, `comment`, `shiftId`, `shiftDocumentId`, `organizationId`, `organizationName`, `organizationInn`, `number`, `basicPriceModifiers`, `createLocalDate`, `id`, `onlineOfferId`, delivery, `localTimezoneOffsetMin`, `waiterUser`, `closedUser`, `originalTableId` from tableOrders_");
        supportSQLiteDatabase.execSQL("DROP TABLE tableOrders_");
        supportSQLiteDatabase.execSQL("ALTER TABLE virtualPos ADD COLUMN shift TEXT");
        supportSQLiteDatabase.execSQL("UPDATE virtualPos SET shift = null");
        supportSQLiteDatabase.execSQL("ALTER TABLE virtualKkm ADD COLUMN automaticEncashment INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE scheduledDiscount ADD COLUMN thresholdValue REAL");
        supportSQLiteDatabase.execSQL("UPDATE scheduledDiscount SET thresholdValue = null");
        supportSQLiteDatabase.execSQL("ALTER TABLE scheduledDiscount ADD COLUMN calcAfterDiscountsApplied INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("CREATE TABLE `trueApi` (`id` TEXT NOT NULL, `organizationId` INTEGER NOT NULL, `createTime` TEXT NOT NULL, `hosts` TEXT NOT NULL, `reasonAccident` TEXT, PRIMARY KEY (`id`))");
        supportSQLiteDatabase.execSQL("ALTER TABLE organization ADD COLUMN chestnyZnak TEXT");
        supportSQLiteDatabase.execSQL("UPDATE organization SET chestnyZnak = null");
        supportSQLiteDatabase.execSQL("ALTER TABLE organization ADD COLUMN docsInBox TEXT");
        supportSQLiteDatabase.execSQL("UPDATE organization SET docsInBox = null");
        supportSQLiteDatabase.execSQL("ALTER TABLE applicationSettings ADD COLUMN overriddenTrueApiURI TEXT");
        supportSQLiteDatabase.execSQL("UPDATE applicationSettings SET overriddenTrueApiURI = null");
        supportSQLiteDatabase.execSQL("ALTER TABLE applicationSettings ADD COLUMN overriddenTrueApiRequestTimeoutMs INTEGER");
        supportSQLiteDatabase.execSQL("UPDATE applicationSettings SET overriddenTrueApiRequestTimeoutMs = null");
    }
}
