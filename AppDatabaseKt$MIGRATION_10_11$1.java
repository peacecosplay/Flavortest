package quickresto.webterminal;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"quickresto/webterminal/AppDatabaseKt$MIGRATION_10_11$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppDatabase.kt */
public final class AppDatabaseKt$MIGRATION_10_11$1 extends Migration {
    AppDatabaseKt$MIGRATION_10_11$1() {
        super(10, 11);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
        supportSQLiteDatabase.execSQL("ALTER TABLE ordersV2 RENAME TO ordersV2__");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `ordersV2` (`id` TEXT NOT NULL, `syncTime` TEXT, paymentTransactions TEXT NOT NULL, comments TEXT NOT NULL, replicationStatus TEXT, atolReceiptResponse TEXT, customerSnapshots TEXT NOT NULL, guestIdxes TEXT NOT NULL, returnedComment TEXT, totalSum REAL NOT NULL,  tableOrderDocumentId TEXT NOT NULL, priceModifiers TEXT NOT NULL, updatable INTEGER NOT NULL, receipt TEXT, atolReturnResponse TEXT, returned INTEGER NOT NULL, items TEXT NOT NULL, customerSnapshot TEXT, customerPriceModifiers TEXT NOT NULL, removed INTEGER NOT NULL, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `preorderInfo` (`id` TEXT NOT NULL, `tableOrderId` TEXT NOT NULL, `subOrderId` TEXT NOT NULL, `guestIdxes` TEXT NOT NULL, `waiterId` INTEGER NOT NULL, `cashierId` INTEGER NOT NULL, `cancellerId` INTEGER, `printDeviceId` TEXT, `localPrintDate` TEXT NOT NULL, `localTimezoneOffsetMin` INTEGER NOT NULL, `status` TEXT NOT NULL, `replicationStatus` TEXT NOT NULL, `cancellationReason` TEXT, `items` TEXT NOT NULL, `baseSum` REAL NOT NULL, `sumWithDiscount` REAL NOT NULL, `totalDiscount` REAL NOT NULL, `markupSum` REAL NOT NULL, `terminalSalePlaceId` INTEGER, `tableId` INTEGER, `terminalId` TEXT NOT NULL, `fictitious` INTEGER NOT NULL, PRIMARY KEY(`id`))");
    }
}
