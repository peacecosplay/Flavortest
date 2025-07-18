package quickresto.webterminal;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"quickresto/webterminal/AppDatabaseKt$MIGRATION_23_24$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppDatabase.kt */
public final class AppDatabaseKt$MIGRATION_23_24$1 extends Migration {
    AppDatabaseKt$MIGRATION_23_24$1() {
        super(23, 24);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
        supportSQLiteDatabase.execSQL("ALTER TABLE dish RENAME TO dish_");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `dish` (`id` INTEGER NOT NULL, `terminalId` TEXT NOT NULL, `name` TEXT NOT NULL, `parentId` INTEGER, `price` REAL NOT NULL, `imageId` INTEGER, `imageUrl` TEXT, `prevId` INTEGER, `orderIndex` INTEGER NOT NULL, `tagId` INTEGER, `organizationId` INTEGER NOT NULL DEFAULT 0, `cookingPlaceId` INTEGER NOT NULL DEFAULT 0, `salePlaceId` INTEGER NOT NULL DEFAULT 0, `sellingType` TEXT, `deleted` INTEGER NOT NULL, `paths` TEXT NOT NULL, `tagPaths` TEXT NOT NULL, `taxValue` REAL, `minPrice` REAL, `excludeDiscount` INTEGER NOT NULL, `excludeMarkup` INTEGER NOT NULL, `cookingTime` INTEGER, `barCode` TEXT, `categoryName` TEXT, `unitWeight` REAL, `gtin` TEXT, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("INSERT INTO dish(`id`, `terminalId`, `name`, `parentId`, `price`, `imageId`, `imageUrl`, `prevId`, `orderIndex`, `tagId`, `organizationId`, `cookingPlaceId`, `salePlaceId`, `sellingType`, `deleted`, `paths`, `tagPaths`, `taxValue`, `minPrice`, `excludeDiscount`, `excludeMarkup`, `cookingTime`, `barCode`, `categoryName`, `unitWeight`, `gtin`) SELECT `id`, `terminalId`, `name`, `parentId`, `price`, `imageId`, `imageUrl`, `prevId`, `orderIndex`, `tagId`, IFNULL(`organizationId`, 0), IFNULL(`cookingPlaceId`, 0), IFNULL(`salePlaceId`, 0), `sellingType`, `deleted`, `paths`, `tagPaths`, `taxValue`, `minPrice`, `excludeDiscount`, `excludeMarkup`, `cookingTime`, `barCode`, `categoryName`, NULL, NULL FROM dish_");
        supportSQLiteDatabase.execSQL("DROP TABLE dish_");
    }
}
