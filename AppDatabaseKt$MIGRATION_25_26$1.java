package quickresto.webterminal;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"quickresto/webterminal/AppDatabaseKt$MIGRATION_25_26$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppDatabase.kt */
public final class AppDatabaseKt$MIGRATION_25_26$1 extends Migration {
    AppDatabaseKt$MIGRATION_25_26$1() {
        super(25, 26);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
        supportSQLiteDatabase.execSQL("CREATE TABLE `image` (`name` TEXT NOT NULL, `data` BLOB NOT NULL, `typeTemplate` TEXT NOT NULL, PRIMARY KEY (`name`))");
        supportSQLiteDatabase.execSQL("CREATE TABLE `template` (`name` TEXT NOT NULL, `data` TEXT NOT NULL, PRIMARY KEY (`name`))");
        supportSQLiteDatabase.execSQL("ALTER TABLE tableScheme RENAME TO tableScheme_");
        supportSQLiteDatabase.execSQL("CREATE TABLE tableScheme (id INTEGER NOT NULL, name TEXT, fullAddress TEXT,deleted INTEGER NOT NULL, width INTEGER, height INTEGER, wlcrmPreorderAvailable INTEGER NOT NULL, halls TEXT NOT NULL, PRIMARY KEY(id))");
        supportSQLiteDatabase.execSQL("INSERT INTO tableScheme(id, name , fullAddress , deleted , width , height , wlcrmPreorderAvailable, halls) SELECT id, name, null, deleted, width, height, wlcrmPreorderAvailable, halls from tableScheme_");
        supportSQLiteDatabase.execSQL("DROP TABLE tableScheme_");
        supportSQLiteDatabase.execSQL("ALTER TABLE terminalUser RENAME TO terminalUser___");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `terminalUser` (`id` INTEGER NOT NULL, `lastName` TEXT, `firstName` TEXT, `tipsUri` TEXT, `pin` TEXT, `inn` TEXT, `deleted` INTEGER, `employeeId` INTEGER, `accessRights` TEXT NOT NULL, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("INSERT INTO terminalUser(`id`, `lastName`, `firstName`, `tipsUri`, `pin`, `inn`, `deleted`, `employeeId`, `accessRights`) SELECT `id`, `lastName`, `firstName`, null, `pin`, `inn`, `deleted`, `employeeId`, '{}' FROM terminalUser___");
        supportSQLiteDatabase.execSQL("DROP TABLE terminalUser___");
        supportSQLiteDatabase.execSQL("ALTER TABLE scheduledDiscount ADD COLUMN promoCustomerId INTEGER");
        supportSQLiteDatabase.execSQL("UPDATE scheduledDiscount SET promoCustomerId = null");
        supportSQLiteDatabase.execSQL("ALTER TABLE scheduledDiscount ADD COLUMN promoAccountTypeId INTEGER");
        supportSQLiteDatabase.execSQL("UPDATE scheduledDiscount SET promoAccountTypeId = null");
        supportSQLiteDatabase.execSQL("ALTER TABLE scheduledDiscount ADD COLUMN preorderOnly INTEGER DEFAULT 0 NOT NULL");
        supportSQLiteDatabase.execSQL("UPDATE scheduledDiscount SET preorderOnly = 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE ordersV2 ADD COLUMN promoCodes TEXT DEFAULT '{}' NOT NULL");
        supportSQLiteDatabase.execSQL("UPDATE ordersV2 SET promoCodes = '{}'");
        supportSQLiteDatabase.execSQL("ALTER TABLE ordersV2 ADD COLUMN bonusTransactions TEXT DEFAULT '[]' NOT NULL");
        supportSQLiteDatabase.execSQL("UPDATE ordersV2 SET bonusTransactions = '[]'");
    }
}
