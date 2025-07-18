package quickresto.webterminal;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"quickresto/webterminal/AppDatabaseKt$MIGRATION_24_25$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppDatabase.kt */
public final class AppDatabaseKt$MIGRATION_24_25$1 extends Migration {
    AppDatabaseKt$MIGRATION_24_25$1() {
        super(24, 25);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
        supportSQLiteDatabase.execSQL("ALTER TABLE paymentType RENAME TO paymentType___");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `paymentType` (`id` INTEGER NOT NULL, `refId` TEXT NOT NULL, `name` TEXT NOT NULL, `type` TEXT NOT NULL, `paymentMechanism` TEXT NOT NULL, `disabled` INTEGER NOT NULL, `partialAllowed` INTEGER NOT NULL, `requireCustomerConfirmation` INTEGER NOT NULL, `operationType` TEXT NOT NULL, `customerType` TEXT NOT NULL, `requireConfirmation` INTEGER NOT NULL, `seq` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("INSERT INTO paymentType(`id`, `refId`, `name`, `type`, `paymentMechanism`, `disabled`, `partialAllowed`, `requireCustomerConfirmation`, `operationType`, `customerType`, `requireConfirmation`, `seq`) SELECT `id`, '', `name`, `type`, `paymentMechanism`, 0, 0, 0, 'FISCAL', 'ORGANIZATION', 0, 0 FROM paymentType___");
        supportSQLiteDatabase.execSQL("DROP TABLE paymentType___");
        supportSQLiteDatabase.execSQL("ALTER TABLE dishGroup RENAME TO dishGroup_");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `dishGroup` (`id` INTEGER NOT NULL, `terminalId` TEXT NOT NULL, `name` TEXT NOT NULL, `parentId` INTEGER, `color` TEXT, `image` TEXT, `prevId` INTEGER, `orderIndex` INTEGER NOT NULL, `tagId` INTEGER, `deleted` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("INSERT INTO dishGroup(`id`, `terminalId`, `name`, `parentId`, `color`, `image`, `prevId`, `orderIndex`, `tagId`, `deleted`) SELECT `id`, `terminalId`, `name`, `parentId`, `color`, `image`, `prevId`, `orderIndex`, `tagId`, 0 FROM dishGroup_");
        supportSQLiteDatabase.execSQL("DROP TABLE dishGroup_");
        supportSQLiteDatabase.execSQL("ALTER TABLE modifierGroup RENAME TO modifierGroup_");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `modifierGroup` (`id` INTEGER NOT NULL, `terminalId` TEXT NOT NULL, `name` TEXT NOT NULL, `parentId` INTEGER, `color` TEXT, `prevId` INTEGER, `orderIndex` INTEGER NOT NULL, `tagId` INTEGER, `deleted` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("INSERT INTO modifierGroup(`id`, `terminalId`, `name`, `parentId`, `color`, `prevId`, `orderIndex`, `tagId`, `deleted`) SELECT `id`, `terminalId`, `name`, `parentId`, `color`, `prevId`, `orderIndex`, `tagId`, 0 FROM modifierGroup_");
        supportSQLiteDatabase.execSQL("DROP TABLE modifierGroup_");
        supportSQLiteDatabase.execSQL("ALTER TABLE modifier RENAME TO modifier_");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `modifier` (`id` INTEGER NOT NULL, `terminalId` TEXT NOT NULL, `name` TEXT NOT NULL, `parentId` INTEGER, `price` REAL NOT NULL, `prevId` INTEGER, `orderIndex` INTEGER NOT NULL, `withDish` INTEGER NOT NULL, `tagId` INTEGER, `minPrice` REAL, `excludeDiscount` INTEGER NOT NULL, `excludeMarkup` INTEGER NOT NULL, `deleted` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("INSERT INTO modifier(`id`, `terminalId`, `name`, `parentId`, `price`, `prevId`, `orderIndex`, `withDish`, `tagId`, `minPrice`, `excludeDiscount`, `excludeMarkup`, `deleted`) SELECT `id`, `terminalId`, `name`, `parentId`, `price`, `prevId`, `orderIndex`, `withDish`, `tagId`, `minPrice`, `excludeDiscount`, `excludeMarkup`, 0 FROM modifier_");
        supportSQLiteDatabase.execSQL("DROP TABLE modifier_");
        supportSQLiteDatabase.execSQL("ALTER TABLE kitchenDisplays RENAME TO kitchenDisplays_");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `kitchenDisplays` (`name` TEXT, `model` TEXT NOT NULL, `deviceAddress` TEXT, `deviceType` TEXT NOT NULL, `mac` TEXT, `deviceId` TEXT, `deviceDescription` TEXT, `id` TEXT NOT NULL, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("INSERT INTO kitchenDisplays(`name`, `model`, `deviceAddress`, `deviceType`, `mac`, `deviceId`, `deviceDescription`, `id`) SELECT `name`, `model`, `deviceAddress`, `deviceType`, `mac`, null, `deviceDescription`, `id` FROM kitchenDisplays_");
        supportSQLiteDatabase.execSQL("DROP TABLE kitchenDisplays_");
        supportSQLiteDatabase.execSQL("ALTER TABLE applicationSettings ADD COLUMN processedTouchTerminalGuid TEXT");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `posDevice` \n(\n`id` TEXT NOT NULL, \n`deviceId` TEXT NOT NULL, \n`type` TEXT NOT NULL, \n`deviceAddress` TEXT NOT NULL, \n`identifier` TEXT NOT NULL, \n`model` TEXT NOT NULL, \n`manufacturer` TEXT NOT NULL, \n`name` TEXT, \n`enabled` INTEGER NOT NULL, \n`deleted` INTEGER NOT NULL, \n`state` TEXT NOT NULL, \n`organizationId` INTEGER, \n`printSetting` TEXT NOT NULL, \n`printerDeviceId` TEXT, \nPRIMARY KEY(`id`)\n)");
    }
}
