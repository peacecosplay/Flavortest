package quickresto.webterminal;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"quickresto/webterminal/AppDatabaseKt$MIGRATION_17_18$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppDatabase.kt */
public final class AppDatabaseKt$MIGRATION_17_18$1 extends Migration {
    AppDatabaseKt$MIGRATION_17_18$1() {
        super(17, 18);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
        supportSQLiteDatabase.execSQL("ALTER TABLE terminalUser RENAME TO terminalUser___");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `terminalUser` (`id` INTEGER NOT NULL, `lastName` TEXT, `firstName` TEXT, `pin` TEXT, `inn` TEXT, `deleted` INTEGER, `employeeId` INTEGER, `accessRights` TEXT NOT NULL, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("INSERT INTO terminalUser(`id`, `lastName`, `firstName`, `pin`, `inn`, `deleted`, `employeeId`, `accessRights`) SELECT `id`, `lastName`, `firstName`, `pin`, `inn`, `deleted`, `employeeId`, '{}' FROM terminalUser___");
        supportSQLiteDatabase.execSQL("DROP TABLE terminalUser___");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `scheduledDiscount` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `type` TEXT NOT NULL, `kind` TEXT NOT NULL, `value` REAL NOT NULL, `cancellable` INTEGER NOT NULL, `weeklySchedule` TEXT NOT NULL, `startDate` TEXT NOT NULL, `endDate` TEXT NOT NULL, `dishes` TEXT NOT NULL, `tags` TEXT NOT NULL, `dishesGroups` TEXT NOT NULL, `salePlaces` TEXT NOT NULL, `deleted` INTEGER NOT NULL, PRIMARY KEY(`id`))");
    }
}
