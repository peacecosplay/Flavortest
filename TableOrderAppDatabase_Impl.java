package quickresto.webterminal;

import androidx.core.app.NotificationCompat;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import quickresto.webterminal.database.TableOrderDocumentDao;
import quickresto.webterminal.database.TableOrderDocumentDao_TableOrderAppDatabase_Impl;

public final class TableOrderAppDatabase_Impl extends TableOrderAppDatabase {
    private volatile TableOrderDocumentDao _tableOrderDocumentDao;

    /* access modifiers changed from: protected */
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(3) {
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `tableOrders` (`terminalId` TEXT NOT NULL, `kkmId` TEXT, `kkmManufacturerDeviceId` TEXT, `openedUser` TEXT NOT NULL, `waiterUser` TEXT NOT NULL, `closedUser` TEXT, `createTime` TEXT NOT NULL, `localTimezoneOffsetMin` INTEGER NOT NULL, `updateTime` TEXT NOT NULL, `guestCount` INTEGER, `tableId` INTEGER, `originalTableId` INTEGER, `status` TEXT NOT NULL, `waiterName` TEXT, `tableName` TEXT, `floorName` TEXT, `comment` TEXT, `shiftId` TEXT, `shiftDocumentId` TEXT, `organizationId` INTEGER NOT NULL, `organizationName` TEXT, `organizationInn` TEXT, `number` TEXT NOT NULL, `basicPriceModifiers` TEXT NOT NULL, `createLocalDate` TEXT NOT NULL, `id` TEXT NOT NULL, `onlineOfferId` TEXT, `delivery` TEXT, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '4290b35b103b6afabc5f6632621ebe3c')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `tableOrders`");
                if (TableOrderAppDatabase_Impl.this.mCallbacks != null) {
                    int size = TableOrderAppDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) TableOrderAppDatabase_Impl.this.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (TableOrderAppDatabase_Impl.this.mCallbacks != null) {
                    int size = TableOrderAppDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) TableOrderAppDatabase_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = TableOrderAppDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                TableOrderAppDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (TableOrderAppDatabase_Impl.this.mCallbacks != null) {
                    int size = TableOrderAppDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) TableOrderAppDatabase_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap hashMap = new HashMap(28);
                hashMap.put("terminalId", new TableInfo.Column("terminalId", "TEXT", true, 0, (String) null, 1));
                hashMap.put("kkmId", new TableInfo.Column("kkmId", "TEXT", false, 0, (String) null, 1));
                hashMap.put("kkmManufacturerDeviceId", new TableInfo.Column("kkmManufacturerDeviceId", "TEXT", false, 0, (String) null, 1));
                hashMap.put("openedUser", new TableInfo.Column("openedUser", "TEXT", true, 0, (String) null, 1));
                hashMap.put("waiterUser", new TableInfo.Column("waiterUser", "TEXT", true, 0, (String) null, 1));
                hashMap.put("closedUser", new TableInfo.Column("closedUser", "TEXT", false, 0, (String) null, 1));
                hashMap.put("createTime", new TableInfo.Column("createTime", "TEXT", true, 0, (String) null, 1));
                hashMap.put("localTimezoneOffsetMin", new TableInfo.Column("localTimezoneOffsetMin", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("updateTime", new TableInfo.Column("updateTime", "TEXT", true, 0, (String) null, 1));
                hashMap.put("guestCount", new TableInfo.Column("guestCount", "INTEGER", false, 0, (String) null, 1));
                hashMap.put("tableId", new TableInfo.Column("tableId", "INTEGER", false, 0, (String) null, 1));
                hashMap.put("originalTableId", new TableInfo.Column("originalTableId", "INTEGER", false, 0, (String) null, 1));
                hashMap.put(NotificationCompat.CATEGORY_STATUS, new TableInfo.Column(NotificationCompat.CATEGORY_STATUS, "TEXT", true, 0, (String) null, 1));
                hashMap.put("waiterName", new TableInfo.Column("waiterName", "TEXT", false, 0, (String) null, 1));
                hashMap.put("tableName", new TableInfo.Column("tableName", "TEXT", false, 0, (String) null, 1));
                hashMap.put("floorName", new TableInfo.Column("floorName", "TEXT", false, 0, (String) null, 1));
                hashMap.put("comment", new TableInfo.Column("comment", "TEXT", false, 0, (String) null, 1));
                hashMap.put("shiftId", new TableInfo.Column("shiftId", "TEXT", false, 0, (String) null, 1));
                hashMap.put("shiftDocumentId", new TableInfo.Column("shiftDocumentId", "TEXT", false, 0, (String) null, 1));
                hashMap.put("organizationId", new TableInfo.Column("organizationId", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("organizationName", new TableInfo.Column("organizationName", "TEXT", false, 0, (String) null, 1));
                hashMap.put("organizationInn", new TableInfo.Column("organizationInn", "TEXT", false, 0, (String) null, 1));
                hashMap.put("number", new TableInfo.Column("number", "TEXT", true, 0, (String) null, 1));
                hashMap.put("basicPriceModifiers", new TableInfo.Column("basicPriceModifiers", "TEXT", true, 0, (String) null, 1));
                hashMap.put("createLocalDate", new TableInfo.Column("createLocalDate", "TEXT", true, 0, (String) null, 1));
                hashMap.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                hashMap.put("onlineOfferId", new TableInfo.Column("onlineOfferId", "TEXT", false, 0, (String) null, 1));
                hashMap.put("delivery", new TableInfo.Column("delivery", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo = new TableInfo("tableOrders", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase, "tableOrders");
                if (!tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(false, "tableOrders(ru.quickresto.terminal.client.database.TableOrderDocument).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                return new RoomOpenHelper.ValidationResult(true, (String) null);
            }
        }, "4290b35b103b6afabc5f6632621ebe3c", "c274b445a58fca673526fb432703a54e")).build());
    }

    /* access modifiers changed from: protected */
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "tableOrders");
    }

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `tableOrders`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    /* access modifiers changed from: protected */
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(TableOrderDocumentDao.class, TableOrderDocumentDao_TableOrderAppDatabase_Impl.getRequiredConverters());
        return hashMap;
    }

    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return Arrays.asList(new Migration[0]);
    }

    public TableOrderDocumentDao tableOrderDocumentDao() {
        TableOrderDocumentDao tableOrderDocumentDao;
        if (this._tableOrderDocumentDao != null) {
            return this._tableOrderDocumentDao;
        }
        synchronized (this) {
            if (this._tableOrderDocumentDao == null) {
                this._tableOrderDocumentDao = new TableOrderDocumentDao_TableOrderAppDatabase_Impl(this);
            }
            tableOrderDocumentDao = this._tableOrderDocumentDao;
        }
        return tableOrderDocumentDao;
    }
}
