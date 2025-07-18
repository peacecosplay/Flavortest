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
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import quickresto.webterminal.database.PosPaymentDocumentDao;
import quickresto.webterminal.database.PosPaymentDocumentDao_Impl;
import quickresto.webterminal.database.PosRefundDocumentDao;
import quickresto.webterminal.database.PosRefundDocumentDao_Impl;
import quickresto.webterminal.database.PosShiftDocumentDao;
import quickresto.webterminal.database.PosShiftDocumentDao_Impl;
import quickresto.webterminal.database.ShiftDocumentDao;
import quickresto.webterminal.database.ShiftDocumentDao_ShiftAppDatabase_Impl;

public final class ShiftAppDatabase_Impl extends ShiftAppDatabase {
    private volatile PosPaymentDocumentDao _posPaymentDocumentDao;
    private volatile PosRefundDocumentDao _posRefundDocumentDao;
    private volatile PosShiftDocumentDao _posShiftDocumentDao;
    private volatile ShiftDocumentDao _shiftDocumentDao;

    /* access modifiers changed from: protected */
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(5) {
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `shift` (`id` TEXT NOT NULL, `replicationStatus` TEXT NOT NULL, `syncTime` TEXT, `shiftNumber` INTEGER, `shiftId` TEXT, `openUserId` INTEGER NOT NULL, `kkmId` TEXT NOT NULL, `deviceId` TEXT, `deviceType` TEXT NOT NULL, `actionType` TEXT NOT NULL, `closeShiftRequest` TEXT, `createTime` TEXT NOT NULL, `openedTime` TEXT, `salePlaceId` INTEGER, `sellCounters` TEXT, `nonFiscalCounters` TEXT, `writeOffCounters` TEXT, `registerValues` TEXT, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `posShift` (`id` TEXT NOT NULL, `deviceId` TEXT NOT NULL, `createUserId` INTEGER NOT NULL, `createTime` TEXT NOT NULL, `status` TEXT NOT NULL, `salePlaceId` INTEGER NOT NULL, `organizationId` INTEGER NOT NULL, `lastCloseShiftTime` TEXT NOT NULL, `closedUserId` INTEGER, `closedTime` TEXT, `closedTickets` TEXT, `closedWithEmergency` INTEGER, `sellCounters` TEXT NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `posPayment` (`id` TEXT NOT NULL, `status` TEXT NOT NULL, `deviceId` TEXT NOT NULL, `createUserId` INTEGER NOT NULL, `createTime` TEXT NOT NULL, `posShiftDocumentId` TEXT NOT NULL, `time` TEXT NOT NULL, `amount` REAL NOT NULL, `rrn` TEXT, `authorizationCode` TEXT NOT NULL, `tickets` TEXT, `salePlaceId` INTEGER NOT NULL, `organizationId` INTEGER NOT NULL, `tableOrderDocumentId` TEXT NOT NULL, `orderDocumentId` TEXT NOT NULL, `cancelledUserId` INTEGER, `cancelledTime` TEXT, `cancelledTickets` TEXT, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `posRefund` (`id` TEXT NOT NULL, `status` TEXT NOT NULL, `deviceId` TEXT NOT NULL, `createUserId` INTEGER NOT NULL, `createTime` TEXT NOT NULL, `posShiftDocumentId` TEXT NOT NULL, `time` TEXT NOT NULL, `amount` REAL NOT NULL, `rrn` TEXT, `authorizationCode` TEXT NOT NULL, `tickets` TEXT, `salePlaceId` INTEGER NOT NULL, `organizationId` INTEGER NOT NULL, `posPaymentDocumentId` TEXT, `tableOrderDocumentId` TEXT, `orderDocumentId` TEXT, `paymentRrn` TEXT, `paymentAuthorizationCode` TEXT, `cancelledUserId` INTEGER, `cancelledTime` TEXT, `cancelledTickets` TEXT, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '636fd34c418784a729811bb98fe0b6b3')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `shift`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `posShift`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `posPayment`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `posRefund`");
                if (ShiftAppDatabase_Impl.this.mCallbacks != null) {
                    int size = ShiftAppDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ShiftAppDatabase_Impl.this.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (ShiftAppDatabase_Impl.this.mCallbacks != null) {
                    int size = ShiftAppDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ShiftAppDatabase_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = ShiftAppDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                ShiftAppDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (ShiftAppDatabase_Impl.this.mCallbacks != null) {
                    int size = ShiftAppDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ShiftAppDatabase_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
                HashMap hashMap = new HashMap(18);
                hashMap.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                hashMap.put("replicationStatus", new TableInfo.Column("replicationStatus", "TEXT", true, 0, (String) null, 1));
                hashMap.put("syncTime", new TableInfo.Column("syncTime", "TEXT", false, 0, (String) null, 1));
                hashMap.put("shiftNumber", new TableInfo.Column("shiftNumber", "INTEGER", false, 0, (String) null, 1));
                hashMap.put("shiftId", new TableInfo.Column("shiftId", "TEXT", false, 0, (String) null, 1));
                hashMap.put("openUserId", new TableInfo.Column("openUserId", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("kkmId", new TableInfo.Column("kkmId", "TEXT", true, 0, (String) null, 1));
                hashMap.put("deviceId", new TableInfo.Column("deviceId", "TEXT", false, 0, (String) null, 1));
                hashMap.put("deviceType", new TableInfo.Column("deviceType", "TEXT", true, 0, (String) null, 1));
                hashMap.put("actionType", new TableInfo.Column("actionType", "TEXT", true, 0, (String) null, 1));
                hashMap.put("closeShiftRequest", new TableInfo.Column("closeShiftRequest", "TEXT", false, 0, (String) null, 1));
                hashMap.put("createTime", new TableInfo.Column("createTime", "TEXT", true, 0, (String) null, 1));
                hashMap.put("openedTime", new TableInfo.Column("openedTime", "TEXT", false, 0, (String) null, 1));
                hashMap.put("salePlaceId", new TableInfo.Column("salePlaceId", "INTEGER", false, 0, (String) null, 1));
                hashMap.put("sellCounters", new TableInfo.Column("sellCounters", "TEXT", false, 0, (String) null, 1));
                hashMap.put("nonFiscalCounters", new TableInfo.Column("nonFiscalCounters", "TEXT", false, 0, (String) null, 1));
                hashMap.put("writeOffCounters", new TableInfo.Column("writeOffCounters", "TEXT", false, 0, (String) null, 1));
                hashMap.put("registerValues", new TableInfo.Column("registerValues", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo = new TableInfo("shift", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase2, "shift");
                if (!tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(false, "shift(ru.quickresto.terminal.client.database.ShiftDocument).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                HashMap hashMap2 = new HashMap(13);
                hashMap2.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                hashMap2.put("deviceId", new TableInfo.Column("deviceId", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("createUserId", new TableInfo.Column("createUserId", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("createTime", new TableInfo.Column("createTime", "TEXT", true, 0, (String) null, 1));
                hashMap2.put(NotificationCompat.CATEGORY_STATUS, new TableInfo.Column(NotificationCompat.CATEGORY_STATUS, "TEXT", true, 0, (String) null, 1));
                hashMap2.put("salePlaceId", new TableInfo.Column("salePlaceId", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("organizationId", new TableInfo.Column("organizationId", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("lastCloseShiftTime", new TableInfo.Column("lastCloseShiftTime", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("closedUserId", new TableInfo.Column("closedUserId", "INTEGER", false, 0, (String) null, 1));
                hashMap2.put("closedTime", new TableInfo.Column("closedTime", "TEXT", false, 0, (String) null, 1));
                hashMap2.put("closedTickets", new TableInfo.Column("closedTickets", "TEXT", false, 0, (String) null, 1));
                hashMap2.put("closedWithEmergency", new TableInfo.Column("closedWithEmergency", "INTEGER", false, 0, (String) null, 1));
                hashMap2.put("sellCounters", new TableInfo.Column("sellCounters", "TEXT", true, 0, (String) null, 1));
                TableInfo tableInfo2 = new TableInfo("posShift", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo read2 = TableInfo.read(supportSQLiteDatabase2, "posShift");
                if (!tableInfo2.equals(read2)) {
                    return new RoomOpenHelper.ValidationResult(false, "posShift(ru.quickresto.terminal.client.database.PosShiftDocument).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
                }
                HashMap hashMap3 = new HashMap(18);
                hashMap3.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                hashMap3.put(NotificationCompat.CATEGORY_STATUS, new TableInfo.Column(NotificationCompat.CATEGORY_STATUS, "TEXT", true, 0, (String) null, 1));
                hashMap3.put("deviceId", new TableInfo.Column("deviceId", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("createUserId", new TableInfo.Column("createUserId", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("createTime", new TableInfo.Column("createTime", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("posShiftDocumentId", new TableInfo.Column("posShiftDocumentId", "TEXT", true, 0, (String) null, 1));
                hashMap3.put(RtspHeaders.Values.TIME, new TableInfo.Column(RtspHeaders.Values.TIME, "TEXT", true, 0, (String) null, 1));
                hashMap3.put("amount", new TableInfo.Column("amount", "REAL", true, 0, (String) null, 1));
                hashMap3.put("rrn", new TableInfo.Column("rrn", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("authorizationCode", new TableInfo.Column("authorizationCode", "TEXT", true, 0, (String) null, 1));
                Object obj = "authorizationCode";
                hashMap3.put("tickets", new TableInfo.Column("tickets", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("salePlaceId", new TableInfo.Column("salePlaceId", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("organizationId", new TableInfo.Column("organizationId", "INTEGER", true, 0, (String) null, 1));
                Object obj2 = "organizationId";
                hashMap3.put("tableOrderDocumentId", new TableInfo.Column("tableOrderDocumentId", "TEXT", true, 0, (String) null, 1));
                Object obj3 = "tableOrderDocumentId";
                hashMap3.put("orderDocumentId", new TableInfo.Column("orderDocumentId", "TEXT", true, 0, (String) null, 1));
                Object obj4 = "orderDocumentId";
                hashMap3.put("cancelledUserId", new TableInfo.Column("cancelledUserId", "INTEGER", false, 0, (String) null, 1));
                Object obj5 = "cancelledUserId";
                hashMap3.put("cancelledTime", new TableInfo.Column("cancelledTime", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("cancelledTickets", new TableInfo.Column("cancelledTickets", "TEXT", false, 0, (String) null, 1));
                Object obj6 = "salePlaceId";
                Object obj7 = "tickets";
                TableInfo tableInfo3 = new TableInfo("posPayment", hashMap3, new HashSet(0), new HashSet(0));
                TableInfo read3 = TableInfo.read(supportSQLiteDatabase2, "posPayment");
                if (!tableInfo3.equals(read3)) {
                    return new RoomOpenHelper.ValidationResult(false, "posPayment(ru.quickresto.terminal.client.database.PosPaymentDocument).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
                }
                HashMap hashMap4 = new HashMap(21);
                hashMap4.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                hashMap4.put(NotificationCompat.CATEGORY_STATUS, new TableInfo.Column(NotificationCompat.CATEGORY_STATUS, "TEXT", true, 0, (String) null, 1));
                hashMap4.put("deviceId", new TableInfo.Column("deviceId", "TEXT", true, 0, (String) null, 1));
                hashMap4.put("createUserId", new TableInfo.Column("createUserId", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("createTime", new TableInfo.Column("createTime", "TEXT", true, 0, (String) null, 1));
                hashMap4.put("posShiftDocumentId", new TableInfo.Column("posShiftDocumentId", "TEXT", true, 0, (String) null, 1));
                hashMap4.put(RtspHeaders.Values.TIME, new TableInfo.Column(RtspHeaders.Values.TIME, "TEXT", true, 0, (String) null, 1));
                hashMap4.put("amount", new TableInfo.Column("amount", "REAL", true, 0, (String) null, 1));
                hashMap4.put("rrn", new TableInfo.Column("rrn", "TEXT", false, 0, (String) null, 1));
                hashMap4.put(obj, new TableInfo.Column("authorizationCode", "TEXT", true, 0, (String) null, 1));
                hashMap4.put(obj7, new TableInfo.Column("tickets", "TEXT", false, 0, (String) null, 1));
                hashMap4.put(obj6, new TableInfo.Column("salePlaceId", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put(obj2, new TableInfo.Column("organizationId", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("posPaymentDocumentId", new TableInfo.Column("posPaymentDocumentId", "TEXT", false, 0, (String) null, 1));
                hashMap4.put(obj3, new TableInfo.Column("tableOrderDocumentId", "TEXT", false, 0, (String) null, 1));
                hashMap4.put(obj4, new TableInfo.Column("orderDocumentId", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("paymentRrn", new TableInfo.Column("paymentRrn", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("paymentAuthorizationCode", new TableInfo.Column("paymentAuthorizationCode", "TEXT", false, 0, (String) null, 1));
                hashMap4.put(obj5, new TableInfo.Column("cancelledUserId", "INTEGER", false, 0, (String) null, 1));
                hashMap4.put("cancelledTime", new TableInfo.Column("cancelledTime", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("cancelledTickets", new TableInfo.Column("cancelledTickets", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo4 = new TableInfo("posRefund", hashMap4, new HashSet(0), new HashSet(0));
                TableInfo read4 = TableInfo.read(supportSQLiteDatabase2, "posRefund");
                if (!tableInfo4.equals(read4)) {
                    return new RoomOpenHelper.ValidationResult(false, "posRefund(ru.quickresto.terminal.client.database.PosRefundDocument).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
                }
                return new RoomOpenHelper.ValidationResult(true, (String) null);
            }
        }, "636fd34c418784a729811bb98fe0b6b3", "98f92224ea89f5e896ca38ae8334bbca")).build());
    }

    /* access modifiers changed from: protected */
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "shift", "posShift", "posPayment", "posRefund");
    }

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `shift`");
            writableDatabase.execSQL("DELETE FROM `posShift`");
            writableDatabase.execSQL("DELETE FROM `posPayment`");
            writableDatabase.execSQL("DELETE FROM `posRefund`");
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
        hashMap.put(ShiftDocumentDao.class, ShiftDocumentDao_ShiftAppDatabase_Impl.getRequiredConverters());
        hashMap.put(PosShiftDocumentDao.class, PosShiftDocumentDao_Impl.getRequiredConverters());
        hashMap.put(PosPaymentDocumentDao.class, PosPaymentDocumentDao_Impl.getRequiredConverters());
        hashMap.put(PosRefundDocumentDao.class, PosRefundDocumentDao_Impl.getRequiredConverters());
        return hashMap;
    }

    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return Arrays.asList(new Migration[0]);
    }

    public ShiftDocumentDao shiftDocumentDao() {
        ShiftDocumentDao shiftDocumentDao;
        if (this._shiftDocumentDao != null) {
            return this._shiftDocumentDao;
        }
        synchronized (this) {
            if (this._shiftDocumentDao == null) {
                this._shiftDocumentDao = new ShiftDocumentDao_ShiftAppDatabase_Impl(this);
            }
            shiftDocumentDao = this._shiftDocumentDao;
        }
        return shiftDocumentDao;
    }

    public PosShiftDocumentDao posShiftDocumentDao() {
        PosShiftDocumentDao posShiftDocumentDao;
        if (this._posShiftDocumentDao != null) {
            return this._posShiftDocumentDao;
        }
        synchronized (this) {
            if (this._posShiftDocumentDao == null) {
                this._posShiftDocumentDao = new PosShiftDocumentDao_Impl(this);
            }
            posShiftDocumentDao = this._posShiftDocumentDao;
        }
        return posShiftDocumentDao;
    }

    public PosPaymentDocumentDao posPaymentDocumentDao() {
        PosPaymentDocumentDao posPaymentDocumentDao;
        if (this._posPaymentDocumentDao != null) {
            return this._posPaymentDocumentDao;
        }
        synchronized (this) {
            if (this._posPaymentDocumentDao == null) {
                this._posPaymentDocumentDao = new PosPaymentDocumentDao_Impl(this);
            }
            posPaymentDocumentDao = this._posPaymentDocumentDao;
        }
        return posPaymentDocumentDao;
    }

    public PosRefundDocumentDao posRefundDocumentDao() {
        PosRefundDocumentDao posRefundDocumentDao;
        if (this._posRefundDocumentDao != null) {
            return this._posRefundDocumentDao;
        }
        synchronized (this) {
            if (this._posRefundDocumentDao == null) {
                this._posRefundDocumentDao = new PosRefundDocumentDao_Impl(this);
            }
            posRefundDocumentDao = this._posRefundDocumentDao;
        }
        return posRefundDocumentDao;
    }
}
