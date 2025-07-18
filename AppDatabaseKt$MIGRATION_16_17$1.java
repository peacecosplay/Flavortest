package quickresto.webterminal;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"quickresto/webterminal/AppDatabaseKt$MIGRATION_16_17$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppDatabase.kt */
public final class AppDatabaseKt$MIGRATION_16_17$1 extends Migration {
    AppDatabaseKt$MIGRATION_16_17$1() {
        super(16, 17);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `soldout` (`id` INTEGER NOT NULL, `tableSchemeId` INTEGER NOT NULL, `stopListDishes` TEXT NOT NULL, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `currency` (`id` INTEGER NOT NULL, `deleted` INTEGER NOT NULL, `abbreviation` TEXT NOT NULL, `name` TEXT NOT NULL, `currencySign` TEXT NOT NULL, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("ALTER TABLE applicationSettings RENAME TO applicationSettings___");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `applicationSettings` (`id` TEXT NOT NULL, `terminalId` TEXT NOT NULL, `salePlaceId` INTEGER, `backofficeLayer` TEXT, `backofficeSession` TEXT, `accessLevel` TEXT NOT NULL, `currentUser` TEXT, `virtualPosDevice` TEXT, `currentOrderDocumentId` TEXT, `orderNumberPrefix` TEXT NOT NULL, `orderNumberCounterLastValue` INTEGER NOT NULL, `startupTime` TEXT, `orderPrinterSetting` TEXT NOT NULL, `preorderPrinterSetting` TEXT NOT NULL, `preorderDeviceId` TEXT, `autoPasteContactSetting` TEXT NOT NULL, `activationStatus` TEXT NOT NULL, `currencyId` INTEGER, `currencySign` TEXT, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("INSERT INTO applicationSettings(`id`, `terminalId`, `salePlaceId`, `backofficeLayer`, `backofficeSession`, `accessLevel`, `currentUser`, `virtualPosDevice`, `currentOrderDocumentId`, `orderNumberPrefix`, `orderNumberCounterLastValue`, `startupTime`, `orderPrinterSetting`, `preorderPrinterSetting`, `preorderDeviceId`, `autoPasteContactSetting`, `activationStatus`, `currencyId`, `currencySign`) SELECT `id`, `terminalId`, `salePlaceId`, `backofficeLayer`, `backofficeSession`, `accessLevel`, `currentUser`, `virtualPosDevice`, `currentOrderDocumentId`, `orderNumberPrefix`, `orderNumberCounterLastValue`, `startupTime`, `orderPrinterSetting`, `preorderPrinterSetting`, `preorderDeviceId`, `autoPasteContactSetting`, `activationStatus`, 193, '\\u20BD' FROM applicationSettings___");
        supportSQLiteDatabase.execSQL("DROP TABLE applicationSettings___");
    }
}
