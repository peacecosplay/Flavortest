package quickresto.webterminal;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"quickresto/webterminal/AppDatabaseKt$MIGRATION_2_3$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppDatabase.kt */
public final class AppDatabaseKt$MIGRATION_2_3$1 extends Migration {
    AppDatabaseKt$MIGRATION_2_3$1() {
        super(2, 3);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
        supportSQLiteDatabase.execSQL("ALTER TABLE tableScheme RENAME TO tableScheme_");
        supportSQLiteDatabase.execSQL("CREATE TABLE tableScheme (id INTEGER NOT NULL, name TEXT, deleted INTEGER NOT NULL, width INTEGER, height INTEGER, halls TEXT NOT NULL, PRIMARY KEY(id))");
        supportSQLiteDatabase.execSQL("INSERT INTO tableScheme(id, name , deleted , width , height , halls) SELECT id, name, 0, null, null, '[]' from tableScheme_");
        supportSQLiteDatabase.execSQL("ALTER TABLE orders ADD COLUMN atolReceiptResponse TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE encashment RENAME TO encashment_");
        supportSQLiteDatabase.execSQL("CREATE TABLE encashment (id TEXT NOT NULL, type TEXT NOT NULL, amount REAL NOT NULL, replicationStatus TEXT NOT NULL, comment TEXT, timeEncashment TEXT NOT NULL, kkmDeviceId TEXT NOT NULL, shiftId TEXT NOT NULL, salePlaceId INTEGER NOT NULL, emergency INTEGER NOT NULL, employeeId INTEGER NOT NULL, documentShiftId TEXT NOT NULL, PRIMARY KEY(id))");
        supportSQLiteDatabase.execSQL("INSERT INTO encashment(id, type , amount , replicationStatus , comment , timeEncashment, kkmDeviceId, shiftId, salePlaceId, emergency, employeeId, documentShiftId) SELECT id, type , amount , replicationStatus , comment , timeEncashment, kkmDeviceId, shiftId, salePlaceId, emergency, employeeId, '' from encashment_");
    }
}
