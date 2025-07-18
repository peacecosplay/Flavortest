package quickresto.webterminal;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"quickresto/webterminal/AppDatabaseKt$SPEC_MIGRATION_1_2$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppDatabase.kt */
public final class AppDatabaseKt$SPEC_MIGRATION_1_2$1 extends Migration {
    AppDatabaseKt$SPEC_MIGRATION_1_2$1() {
        super(1, 2);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
        supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS ordersV2__");
        supportSQLiteDatabase.execSQL("ALTER TABLE ordersV2 RENAME TO ordersV2__");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `ordersV2` (`id` TEXT NOT NULL, `syncTime` TEXT, paymentTransactions TEXT NOT NULL, comments TEXT NOT NULL, replicationStatus TEXT, atolReceiptResponse TEXT, customerSnapshots TEXT NOT NULL, guestIdxes TEXT NOT NULL, returnedComment TEXT, totalSum REAL NOT NULL, tableOrderDocumentId TEXT NOT NULL, priceModifiers TEXT NOT NULL, updatable INTEGER NOT NULL, receipt TEXT, atolReturnResponse TEXT, returned INTEGER NOT NULL, items TEXT NOT NULL, customerSnapshot TEXT, customerPriceModifiers TEXT NOT NULL, removed INTEGER NOT NULL, deliveryItem TEXT, orderDueDateDelta INTEGER NOT NULL DEFAULT 0, courierCheckPrinted INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("INSERT INTO ordersV2(`id`, `syncTime`, `paymentTransactions`, `comments`, `replicationStatus`, `atolReceiptResponse`, `customerSnapshots`, `guestIdxes`, `returnedComment`, `totalSum`,  `tableOrderDocumentId`, `priceModifiers`, `updatable`, `receipt`, `atolReturnResponse`, `returned`, `items`, `customerSnapshot`, `customerPriceModifiers`, `removed`, `deliveryItem`, `orderDueDateDelta`, `courierCheckPrinted`) SELECT `id`, `syncTime`, `paymentTransactions`, `comments`, `replicationStatus`, `atolReceiptResponse`, `customerSnapshots`, `guestIdxes`, `returnedComment`, `totalSum`,  `tableOrderDocumentId`, `priceModifiers`, `updatable`, `receipt`, `atolReturnResponse`, `returned`, `items`, `customerSnapshot`, `customerPriceModifiers`, `removed`, NULL, 0, 0 FROM ordersV2__");
        supportSQLiteDatabase.execSQL("DROP TABLE ordersV2__");
        supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS onlineOffers_");
        supportSQLiteDatabase.execSQL("ALTER TABLE onlineOffers RENAME TO onlineOffers_");
        supportSQLiteDatabase.execSQL("CREATE TABLE onlineOffers (id INTEGER NOT NULL, createDate TEXT NOT NULL, refId TEXT NOT NULL, offerStatus TEXT NOT NULL, paystatus TEXT NOT NULL, cancellationaccepted INTEGER NOT NULL, version INTEGER NOT NULL, cancellationComment TEXT, data TEXT NOT NULL, replicationStatus TEXT, wlPreOrderStatus TEXT NOT NULL, deliveryAmount REAL, ownerRefId TEXT, PRIMARY KEY(id))");
        supportSQLiteDatabase.execSQL("INSERT INTO onlineOffers(`id`, `createDate`, `refId`, `offerStatus`, `paystatus`, `cancellationaccepted`, `version`, `cancellationComment`, `data`, `replicationStatus`, `wlPreOrderStatus`, `deliveryAmount`, `ownerRefId`) SELECT `id`, `createDate`, `refId`, `offerStatus`, `paystatus`, `cancellationaccepted`, `version`, `cancellationComment`, `data`, `replicationStatus`, IFNULL(`wlPreOrderStatus`, 'DONE' ), `deliveryAmount`, NULL FROM onlineOffers_");
        supportSQLiteDatabase.execSQL("DROP TABLE onlineOffers_");
    }
}
