package quickresto.webterminal;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"quickresto/webterminal/AppDatabaseKt$MIGRATION_18_19$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppDatabase.kt */
public final class AppDatabaseKt$MIGRATION_18_19$1 extends Migration {
    AppDatabaseKt$MIGRATION_18_19$1() {
        super(18, 19);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `onlineOffers` \n(\n`id` INTEGER NOT NULL, \n`createDate` TEXT, \n`refId` TEXT, \n`offerStatus` TEXT, \n`cancellationaccepted` INTEGER, \n`version` INTEGER, \n`cancellationComment` TEXT, \n`data` TEXT,\n`replicationStatus` TEXT,\n`wlPreOrderStatus` TEXT,\n`deliveryAmount` REAL,\nPRIMARY KEY(`id`)\n)");
        supportSQLiteDatabase.execSQL("ALTER TABLE tableScheme RENAME TO tableScheme_");
        supportSQLiteDatabase.execSQL("CREATE TABLE tableScheme (id INTEGER NOT NULL, name TEXT, deleted INTEGER NOT NULL, width INTEGER, height INTEGER, wlcrmPreorderAvailable INTEGER, halls TEXT NOT NULL, PRIMARY KEY(id))");
        supportSQLiteDatabase.execSQL("INSERT INTO tableScheme(id, name , deleted , width , height , wlcrmPreorderAvailable, halls) SELECT id, name, deleted, width, height, 0, halls from tableScheme_");
        supportSQLiteDatabase.execSQL("DROP TABLE tableScheme_");
        supportSQLiteDatabase.execSQL("ALTER TABLE specialSet RENAME TO specialSet_");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `specialSet` \n    (\n        id INTEGER NOT NULL, \n        name TEXT, \n        start TEXT, \n        `end` TEXT, \n        quantity REAL, \n        dishesFilters TEXT, \n        weeklySchedule TEXT, \n        discountValue REAL, \n        salePlaces TEXT, \n        deleted INTEGER, \n        crmGroups TEXT, \n        triggerThreshold REAL,\n        conditionType TEXT,\n        specialOfferAccountTypeId INTEGER,\n        PRIMARY KEY(id)\n)");
        supportSQLiteDatabase.execSQL("INSERT INTO specialSet(id, name, start, `end`, quantity, dishesFilters, weeklySchedule, discountValue, salePlaces, deleted, crmGroups, triggerThreshold, conditionType, specialOfferAccountTypeId) \nSELECT id, name, start,`end`, quantity, dishesFilters, weeklySchedule, discountValue, salePlaces, deleted, crmGroups, triggerThreshold, conditionType, 0 from specialSet_");
        supportSQLiteDatabase.execSQL("DROP TABLE specialSet_");
    }
}
