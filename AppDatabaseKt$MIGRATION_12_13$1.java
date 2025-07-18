package quickresto.webterminal;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"quickresto/webterminal/AppDatabaseKt$MIGRATION_12_13$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppDatabase.kt */
public final class AppDatabaseKt$MIGRATION_12_13$1 extends Migration {
    AppDatabaseKt$MIGRATION_12_13$1() {
        super(12, 13);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
        supportSQLiteDatabase.execSQL("ALTER TABLE kkmDevice RENAME TO kkmDevice_");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `kkmDevice` (`type` TEXT NOT NULL, `name` TEXT NOT NULL, `status` TEXT NOT NULL, `serialNumber` TEXT NOT NULL, `model` TEXT NOT NULL, `firmwareVersion` TEXT NOT NULL, `dateTime` TEXT NOT NULL, `deviceAddress` TEXT, `organizationId` INTEGER, `enabled` INTEGER NOT NULL, `deleted` INTEGER NOT NULL, `deviceId` TEXT NOT NULL, `shift` TEXT, `mac` TEXT, `receiptLineLength` INTEGER, `id` TEXT NOT NULL, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("INSERT INTO kkmDevice(`type`, `name`, `status`, `serialNumber`, `model`, `firmwareVersion`, `dateTime`, `deviceAddress`, `organizationId`, `enabled`, `deleted` , `deviceId`, `shift`, `mac`, `receiptLineLength`, `id`) SELECT `type`, `name`, `status`, `serialNumber`, `model`, `firmwareVersion`, `dateTime`, `deviceAddress`, `organizationId`, `enabled`, `deleted` , `deviceId`, `shift`, null, `receiptLineLength`, `id` FROM kkmDevice_");
        supportSQLiteDatabase.execSQL("DROP TABLE kkmDevice_");
        supportSQLiteDatabase.execSQL("ALTER TABLE orders__ RENAME TO orders___");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `orders__` (`id` TEXT NOT NULL, `terminalId` TEXT NOT NULL, `kkmId` TEXT, `kkmManufacturerDeviceId` TEXT, `creatorUser` TEXT NOT NULL, `createTime` TEXT NOT NULL, `updateTime` TEXT NOT NULL, `guestCount` INTEGER NOT NULL, `tableId` INTEGER, `items` TEXT NOT NULL, `status` TEXT NOT NULL, `waiterName` TEXT, `tableName` TEXT, `floorName` TEXT, `comment` TEXT, `replicationStatus` TEXT, `syncTime` TEXT, `shiftId` TEXT, `shiftDocumentId` TEXT, `paymentTransactions` TEXT NOT NULL, `organizationId` INTEGER NOT NULL, `organizationName` TEXT, `organizationInn` TEXT, `receipt` TEXT, `atolReceiptResponse` TEXT, `atolReturnResponse` TEXT, `number` TEXT NOT NULL, `returned` INTEGER NOT NULL, `updatable` INTEGER NOT NULL, `returnedComment` TEXT, `priceModifiers` TEXT NOT NULL, `basicPriceModifiers` TEXT NOT NULL, `customerPriceModifiers` TEXT NOT NULL, `createLocalDate` TEXT NOT NULL, `comments` TEXT NOT NULL, `customerSnapshot` TEXT, `customerSnapshots` TEXT NOT NULL, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("INSERT INTO orders__(`id`, `terminalId`, `kkmId`, `kkmManufacturerDeviceId`, `creatorUser`, `createTime`, `updateTime`, `guestCount`, `tableId`, `items`, `status`, `waiterName`, `tableName`, `floorName`, `comment`, `replicationStatus`, `syncTime`, `shiftId`, `shiftDocumentId`, `paymentTransactions` , `organizationId`, `organizationName`, `organizationInn`, `receipt`, `atolReceiptResponse`, `atolReturnResponse`, `number`, `returned`, `updatable`, `returnedComment`, `priceModifiers`, `basicPriceModifiers`, `customerPriceModifiers`, `createLocalDate`, `comments`, `customerSnapshot`, `customerSnapshots`) SELECT `id`, `terminalId`, `kkmId`, `kkmManufacturerDeviceId`, `creatorUser`, `createTime`, `updateTime`, 'null', null, `items`, `status`, `waiterName`, `tableName`, `floorName`, `comment`, `replicationStatus`, `syncTime`, `shiftId`, `shiftDocumentId`, `paymentTransactions` , `organizationId`, `organizationName`, `organizationInn`, `receipt`, `atolReceiptResponse`, `atolReturnResponse`, `number`, `returned`, `updatable`, `returnedComment`, `priceModifiers`, 'null', 'null', `createLocalDate`, 'null', `customerSnapshot`, 'null' FROM orders___");
        supportSQLiteDatabase.execSQL("DROP TABLE orders___");
        supportSQLiteDatabase.execSQL("ALTER TABLE kitchenDisplays RENAME TO kitchenDisplays_");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `kitchenDisplays` (`name` TEXT, `model` TEXT NOT NULL, `deviceAddress` TEXT, `deviceType` TEXT NOT NULL, `mac` TEXT, `deviceDescription` TEXT, `id` TEXT NOT NULL, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("INSERT INTO kitchenDisplays(`name`, `model`, `deviceAddress`, `deviceType`, `mac`, `deviceDescription`, `id`) SELECT `name`, `model`, `deviceAddress`, `deviceType`, null, `deviceDescription`, `id` FROM kitchenDisplays_");
        supportSQLiteDatabase.execSQL("DROP TABLE kitchenDisplays_");
        supportSQLiteDatabase.execSQL("ALTER TABLE dish RENAME TO dish_");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `dish` (`id` INTEGER NOT NULL, `terminalId` TEXT NOT NULL, `name` TEXT NOT NULL, `parentId` INTEGER, `price` REAL NOT NULL, `imageId` INTEGER, `imageUrl` TEXT, `prevId` INTEGER, `orderIndex` INTEGER NOT NULL, `tagId` INTEGER, `organizationId` INTEGER, `organizationIds` TEXT NOT NULL, `cookingPlaceId` INTEGER, `salePlaceId` INTEGER, `sellingType` TEXT, `deleted` INTEGER NOT NULL, `paths` TEXT NOT NULL, `tagPaths` TEXT NOT NULL, `taxValue` REAL, `minPrice` REAL, `excludeDiscount` INTEGER NOT NULL, `excludeMarkup` INTEGER NOT NULL, `cookingTime` INTEGER, `barCode` TEXT, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("INSERT INTO dish(`id`, `terminalId`, `name`, `parentId`, `price`, `imageId`, `imageUrl`, `prevId`, `orderIndex`, `tagId`, `organizationId`, `organizationIds`, `cookingPlaceId`, `salePlaceId`, `sellingType`, `deleted`, `paths`, `tagPaths`, `taxValue`, `minPrice`, `excludeDiscount`, `excludeMarkup`, `cookingTime`, `barCode`) SELECT `id`, `terminalId`, `name`, `parentId`, `price`, `imageId`, `imageUrl`, `prevId`, `orderIndex`, `tagId`, `organizationId`, `organizationIds`, `cookingPlaceId`, `salePlaceId`, `sellingType`, `deleted`, `paths`, `tagPaths`, `taxValue`, `minPrice`, `excludeDiscount`, `excludeMarkup`, `cookingTime`, null FROM dish_");
        supportSQLiteDatabase.execSQL("DROP TABLE dish_");
    }
}
