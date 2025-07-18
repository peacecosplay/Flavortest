package quickresto.webterminal;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"quickresto/webterminal/AppDatabaseKt$MIGRATION_5_6$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppDatabase.kt */
public final class AppDatabaseKt$MIGRATION_5_6$1 extends Migration {
    AppDatabaseKt$MIGRATION_5_6$1() {
        super(5, 6);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
        supportSQLiteDatabase.execSQL("ALTER TABLE terminalUser RENAME TO terminalUser_");
        supportSQLiteDatabase.execSQL("CREATE TABLE terminalUser(`id` INTEGER NOT NULL, `lastName` TEXT, `firstName` TEXT, `pin` TEXT NOT NULL, `inn` TEXT, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("INSERT INTO terminalUser(id, lastName , firstName , pin , inn) SELECT id, lastName , firstName , pin , inn from terminalUser_");
        supportSQLiteDatabase.execSQL("ALTER TABLE modifier ADD COLUMN cookingPlaceId INTEGER");
        supportSQLiteDatabase.execSQL("ALTER TABLE modifier ADD COLUMN salePlaceId INTEGER");
        supportSQLiteDatabase.execSQL("ALTER TABLE modifierLink ADD COLUMN cookingPlaceId INTEGER");
        supportSQLiteDatabase.execSQL("ALTER TABLE modifierLink ADD COLUMN price REAL");
        supportSQLiteDatabase.execSQL("ALTER TABLE dish ADD COLUMN cookingPlaceId INTEGER");
        supportSQLiteDatabase.execSQL("ALTER TABLE dish ADD COLUMN salePlaceId INTEGER");
        supportSQLiteDatabase.execSQL("ALTER TABLE fixedMarkup ADD COLUMN deleted INTEGER NOT NULL DEFAULT 0");
    }
}
