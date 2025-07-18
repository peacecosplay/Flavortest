package quickresto.webterminal;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"quickresto/webterminal/AppDatabaseKt$MIGRATION_3_4$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppDatabase.kt */
public final class AppDatabaseKt$MIGRATION_3_4$1 extends Migration {
    AppDatabaseKt$MIGRATION_3_4$1() {
        super(3, 4);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
        supportSQLiteDatabase.execSQL("ALTER TABLE orders RENAME TO orders_");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `orders` (`id` TEXT NOT NULL, `terminalId` TEXT NOT NULL, `kkmId` TEXT, `kkmManufacturerDeviceId` TEXT, `creatorUser` TEXT NOT NULL, `createTime` TEXT NOT NULL, `updateTime` TEXT NOT NULL, `items` TEXT NOT NULL, `status` TEXT NOT NULL, `waiterName` TEXT, `tableName` TEXT, `floorName` TEXT, `comment` TEXT, `replicationStatus` TEXT, `syncTime` TEXT, `shiftId` TEXT, `shiftDocumentId` TEXT, `paymentTransactions` TEXT NOT NULL, `organizationId` INTEGER NOT NULL, `organizationName` TEXT, `organizationInn` TEXT, `receipt` TEXT, `atolReceiptResponse` TEXT, `number` TEXT NOT NULL, `returned` INTEGER NOT NULL, `returnedComment` TEXT, `priceModifiers` TEXT NOT NULL, `createLocalDate` TEXT NOT NULL, `customerSnapshot` TEXT, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("INSERT INTO orders(`id` , `terminalId` , `kkmId` , `kkmManufacturerDeviceId` , `creatorUser` , `createTime` , `updateTime` , `items` , `status` , `waiterName` , `tableName` , `floorName` , `comment` , `replicationStatus` , `syncTime` , `shiftId` , `shiftDocumentId` , `paymentTransactions` , `organizationId` , `organizationName` , `organizationInn` , `receipt` , `atolReceiptResponse` , `number` , `returned` , `returnedComment` , `priceModifiers` , `createLocalDate`, `customerSnapshot`) SELECT `id` , `terminalId` , `kkmId` , `kkmManufacturerDeviceId` , `creatorUser` , `createTime` , `updateTime` , `items` , `status` , `waiterName` , `tableName` , `floorName` , `comment` , `replicationStatus` , `syncTime` , `shiftId` , `shiftDocumentId` , `paymentTransactions` , `organizationId` , `organizationName` , `organizationInn` , `receipt` , `atolReceiptResponse` , `number` , `returned` , `returnedComment` , `priceModifiers` , '', `customerSnapshot` from orders_");
    }
}
