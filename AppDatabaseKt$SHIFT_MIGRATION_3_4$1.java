package quickresto.webterminal;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"quickresto/webterminal/AppDatabaseKt$SHIFT_MIGRATION_3_4$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppDatabase.kt */
public final class AppDatabaseKt$SHIFT_MIGRATION_3_4$1 extends Migration {
    AppDatabaseKt$SHIFT_MIGRATION_3_4$1() {
        super(3, 4);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `posShift` \n(\n`id` TEXT NOT NULL, \n`deviceId` TEXT NOT NULL,\n`createUserId` INTEGER NOT NULL,\n`createTime` TEXT NOT NULL,\n`status` TEXT NOT NULL,\n`salePlaceId` INTEGER NOT NULL,\n`organizationId` INTEGER NOT NULL,\n`lastCloseShiftTime` TEXT NOT NULL,\n`closedUserId` INTEGER,\n`closedTime` TEXT,\n`closedTickets` TEXT,\n`closedWithEmergency` INTEGER,\n`sellCounters` TEXT NOT NULL,\nPRIMARY KEY(`id`)\n)");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `posPayment` \n(\n`id` TEXT NOT NULL, \n`status` TEXT NOT NULL,\n`deviceId` TEXT NOT NULL,\n`createUserId` INTEGER NOT NULL,\n`createTime` TEXT NOT NULL,\n`posShiftDocumentId` TEXT NOT NULL,\n`time` TEXT NOT NULL,\n`amount` REAL NOT NULL,\n`rrn` TEXT,\n`authorizationCode` TEXT NOT NULL,\n`tickets` TEXT,\n`salePlaceId` INTEGER NOT NULL,\n`organizationId` INTEGER NOT NULL,\n`tableOrderDocumentId` TEXT NOT NULL,\n`orderDocumentId` TEXT NOT NULL,\n`cancelledUserId` INTEGER,\n`cancelledTime` TEXT,\n`cancelledTickets` TEXT,\nPRIMARY KEY(`id`)\n)");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `posRefund` \n(\n`id` TEXT NOT NULL, \n`status` TEXT NOT NULL,\n`deviceId` TEXT NOT NULL,\n`createUserId` INTEGER NOT NULL,\n`createTime` TEXT NOT NULL,\n`posShiftDocumentId` TEXT NOT NULL,\n`time` TEXT NOT NULL,\n`amount` REAL NOT NULL,\n`rrn` TEXT,\n`authorizationCode` TEXT NOT NULL,\n`tickets` TEXT,\n`salePlaceId` INTEGER NOT NULL,\n`organizationId` INTEGER NOT NULL,\n`posPaymentDocumentId` TEXT,\n`tableOrderDocumentId` TEXT,\n`orderDocumentId` TEXT,\n`paymentRrn` TEXT,\n`paymentAuthorizationCode` TEXT,\n`cancelledUserId` INTEGER,\n`cancelledTime` TEXT,\n`cancelledTickets` TEXT,\nPRIMARY KEY(`id`)\n)");
    }
}
