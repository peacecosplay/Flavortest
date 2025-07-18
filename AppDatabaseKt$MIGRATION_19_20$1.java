package quickresto.webterminal;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"quickresto/webterminal/AppDatabaseKt$MIGRATION_19_20$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppDatabase.kt */
public final class AppDatabaseKt$MIGRATION_19_20$1 extends Migration {
    AppDatabaseKt$MIGRATION_19_20$1() {
        super(19, 20);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
        supportSQLiteDatabase.execSQL("ALTER TABLE terminalUser RENAME TO terminalUser___");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `terminalUser` (`id` INTEGER NOT NULL, `lastName` TEXT, `firstName` TEXT, `pin` TEXT, `inn` TEXT, `deleted` INTEGER, `employeeId` INTEGER, `accessRights` TEXT NOT NULL, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("INSERT INTO terminalUser(`id`, `lastName`, `firstName`, `pin`, `inn`, `deleted`, `employeeId`, `accessRights`) SELECT `id`, `lastName`, `firstName`, `pin`, `inn`, `deleted`, `employeeId`, '{}' FROM terminalUser___");
        supportSQLiteDatabase.execSQL("DROP TABLE terminalUser___");
        supportSQLiteDatabase.execSQL("ALTER TABLE tableScheme RENAME TO tableScheme_");
        supportSQLiteDatabase.execSQL("CREATE TABLE tableScheme (id INTEGER NOT NULL, name TEXT, deleted INTEGER NOT NULL, width INTEGER, height INTEGER, wlcrmPreorderAvailable INTEGER NOT NULL, halls TEXT NOT NULL, PRIMARY KEY(id))");
        supportSQLiteDatabase.execSQL("INSERT INTO tableScheme(id, name , deleted , width , height , wlcrmPreorderAvailable, halls) SELECT id, name, deleted, width, height, 0, halls from tableScheme_");
        supportSQLiteDatabase.execSQL("DROP TABLE tableScheme_");
        supportSQLiteDatabase.execSQL("ALTER TABLE orders__ RENAME TO orders___");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `orders__` (`id` TEXT NOT NULL, `terminalId` TEXT NOT NULL, `kkmId` TEXT, `kkmManufacturerDeviceId` TEXT, `creatorUser` TEXT NOT NULL, `createTime` TEXT NOT NULL, `updateTime` TEXT NOT NULL, `guestCount` INTEGER NOT NULL, `tableId` INTEGER, `items` TEXT NOT NULL, `status` TEXT NOT NULL, `waiterName` TEXT, `tableName` TEXT, `floorName` TEXT, `comment` TEXT, `replicationStatus` TEXT, `syncTime` TEXT, `shiftId` TEXT, `shiftDocumentId` TEXT, `paymentTransactions` TEXT NOT NULL, `organizationId` INTEGER NOT NULL, `organizationName` TEXT, `organizationInn` TEXT, `receipt` TEXT, `atolReceiptResponse` TEXT, `atolReturnResponse` TEXT, `number` TEXT NOT NULL, `returned` INTEGER NOT NULL, `updatable` INTEGER NOT NULL, `returnedComment` TEXT, `priceModifiers` TEXT NOT NULL, `basicPriceModifiers` TEXT NOT NULL, `customerPriceModifiers` TEXT NOT NULL, `createLocalDate` TEXT NOT NULL, `comments` TEXT NOT NULL, `onlineOfferId` TEXT, `customerSnapshot` TEXT, `customerSnapshots` TEXT NOT NULL, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("INSERT INTO orders__(`id`, `terminalId`, `kkmId`, `kkmManufacturerDeviceId`, `creatorUser`, `createTime`, `updateTime`, `guestCount`, `tableId`, `items`, `status`, `waiterName`, `tableName`, `floorName`, `comment`, `replicationStatus`, `syncTime`, `shiftId`, `shiftDocumentId`, `paymentTransactions`, `organizationId`, `organizationName`, `organizationInn`, `receipt`, `atolReceiptResponse`, `atolReturnResponse`, `number`, `returned`, `updatable`, `returnedComment`, `priceModifiers`, `basicPriceModifiers`, `customerPriceModifiers`, `createLocalDate`, `comments`, `onlineOfferId`, `customerSnapshot`, `customerSnapshots`) SELECT `id`, `terminalId`, `kkmId`, `kkmManufacturerDeviceId`, `creatorUser`, `createTime`, `updateTime`, `guestCount`, `tableId`, `items`, `status`, `waiterName`, `tableName`, `floorName`, `comment`, `replicationStatus`, `syncTime`, `shiftId`, `shiftDocumentId`, `paymentTransactions`, `organizationId`, `organizationName`, `organizationInn`, `receipt`, `atolReceiptResponse`, `atolReturnResponse`, `number`, `returned`, `updatable`, `returnedComment`, `priceModifiers`, `basicPriceModifiers`, `customerPriceModifiers`, `createLocalDate`, `comments`, 'null', `customerSnapshot`, `customerSnapshots` FROM orders___");
        supportSQLiteDatabase.execSQL("DROP TABLE orders___");
        supportSQLiteDatabase.execSQL("ALTER TABLE specialSet RENAME TO specialSet_");
        supportSQLiteDatabase.execSQL("CREATE TABLE specialSet (`triggerThreshold` REAL NOT NULL, `conditionType` TEXT NOT NULL, `specialOfferAccountTypeId` INTEGER NOT NULL, `id` INTEGER, `name` TEXT, `start` TEXT, `end` TEXT, `quantity` REAL, `dishesFilters` TEXT NOT NULL, `weeklySchedule` TEXT NOT NULL, `discountValue` REAL, `salePlaces` TEXT NOT NULL, `deleted` INTEGER NOT NULL, `crmGroups` TEXT NOT NULL, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("INSERT INTO specialSet(`triggerThreshold`, `conditionType`, `specialOfferAccountTypeId`, `id`, `name`, `start`, `end`, `quantity`, `dishesFilters`, `weeklySchedule`, `discountValue`, `salePlaces`, `deleted`, `crmGroups`) SELECT `triggerThreshold`, `conditionType`, `specialOfferAccountTypeId`, `id`, `name`, `start`, `end`, `quantity`, `dishesFilters`, `weeklySchedule`, `discountValue`, `salePlaces`, `deleted`, `crmGroups` from specialSet_");
        supportSQLiteDatabase.execSQL("DROP TABLE specialSet_");
        supportSQLiteDatabase.execSQL("ALTER TABLE tableOrders RENAME TO tableOrders_");
        supportSQLiteDatabase.execSQL("CREATE TABLE tableOrders (`terminalId` TEXT NOT NULL, `kkmId` TEXT, `kkmManufacturerDeviceId` TEXT, `creatorUser` TEXT NOT NULL, `createTime` TEXT NOT NULL, `updateTime` TEXT NOT NULL, `guestCount` INTEGER NOT NULL, `tableId` INTEGER, `status` TEXT NOT NULL, `waiterName` TEXT, `tableName` TEXT, `floorName` TEXT, `comment` TEXT, `shiftId` TEXT, `shiftDocumentId` TEXT, `organizationId` INTEGER NOT NULL, `organizationName` TEXT, `organizationInn` TEXT, `number` TEXT NOT NULL, `basicPriceModifiers` TEXT NOT NULL, `createLocalDate` TEXT NOT NULL, `id` TEXT NOT NULL, `onlineOfferId` TEXT, `deliveryAmount` REAL, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("INSERT INTO tableOrders(`terminalId`, `kkmId`, `kkmManufacturerDeviceId`, `creatorUser`, `createTime`, `updateTime`, `guestCount`, `tableId`, `status`, `waiterName`, `tableName`, `floorName`, `comment`, `shiftId`, `shiftDocumentId`, `organizationId`, `organizationName`, `organizationInn`, `number`, `basicPriceModifiers`, `createLocalDate`, `id`, `onlineOfferId`, `deliveryAmount`) SELECT `terminalId`, `kkmId`, `kkmManufacturerDeviceId`, `creatorUser`, `createTime`, `updateTime`, `guestCount`, `tableId`, `status`, `waiterName`, `tableName`, `floorName`, `comment`, `shiftId`, `shiftDocumentId`, `organizationId`, `organizationName`, `organizationInn`, `number`, `basicPriceModifiers`, `createLocalDate`, `id`, NULL, NULL from tableOrders_");
        supportSQLiteDatabase.execSQL("DROP TABLE tableOrders_");
        supportSQLiteDatabase.execSQL("DROP TABLE onlineOffers");
        supportSQLiteDatabase.execSQL("CREATE TABLE onlineOffers (id INTEGER NOT NULL, createDate TEXT NOT NULL, refId TEXT NOT NULL, offerStatus TEXT NOT NULL, paystatus TEXT NOT NULL, cancellationaccepted INTEGER NOT NULL, version INTEGER NOT NULL, cancellationComment TEXT, data TEXT NOT NULL, replicationStatus TEXT, wlPreOrderStatus TEXT, deliveryAmount REAL, PRIMARY KEY(id))");
    }
}
