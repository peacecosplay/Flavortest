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
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.http.LinkHeader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import quickresto.webterminal.database.EncashmentDocumentDao;
import quickresto.webterminal.database.EncashmentDocumentDao_SpecialAppDatabase_Impl;
import quickresto.webterminal.database.OnlineOfferDocumentDao;
import quickresto.webterminal.database.OnlineOfferDocumentDao_SpecialAppDatabase_Impl;
import quickresto.webterminal.database.OrderDocumentV2Dao;
import quickresto.webterminal.database.OrderDocumentV2Dao_SpecialAppDatabase_Impl;
import quickresto.webterminal.database.PreorderInfoDocumentDao;
import quickresto.webterminal.database.PreorderInfoDocumentDao_SpecialAppDatabase_Impl;

public final class SpecialAppDatabase_Impl extends SpecialAppDatabase {
    private volatile EncashmentDocumentDao _encashmentDocumentDao;
    private volatile OnlineOfferDocumentDao _onlineOfferDocumentDao;
    private volatile OrderDocumentV2Dao _orderDocumentV2Dao;
    private volatile PreorderInfoDocumentDao _preorderInfoDocumentDao;

    /* access modifiers changed from: protected */
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(3) {
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `encashment` (`id` TEXT NOT NULL, `type` TEXT NOT NULL, `amount` REAL NOT NULL, `replicationStatus` TEXT NOT NULL, `comment` TEXT, `timeEncashment` TEXT NOT NULL, `kkmDeviceId` TEXT NOT NULL, `shiftId` TEXT, `salePlaceId` INTEGER NOT NULL, `emergency` INTEGER NOT NULL, `employeeId` INTEGER NOT NULL, `documentShiftId` TEXT NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `ordersV2` (`id` TEXT NOT NULL, `tableOrderDocumentId` TEXT NOT NULL, `guestIdxes` TEXT NOT NULL, `items` TEXT NOT NULL, `replicationStatus` TEXT, `syncTime` TEXT, `paymentTransactions` TEXT NOT NULL, `receipt` TEXT, `atolReceiptResponse` TEXT, `atolReturnResponse` TEXT, `returned` INTEGER NOT NULL, `updatable` INTEGER NOT NULL, `returnedComment` TEXT, `priceModifiers` TEXT NOT NULL, `customerPriceModifiers` TEXT NOT NULL, `comments` TEXT NOT NULL, `customerSnapshots` TEXT NOT NULL, `totalSum` REAL NOT NULL, `removed` INTEGER NOT NULL, `deliveryItem` TEXT, `orderDueDateDelta` INTEGER NOT NULL, `courierCheckPrinted` INTEGER NOT NULL, `promoCodes` TEXT NOT NULL, `bonusTransactions` TEXT NOT NULL, `customerSnapshot` TEXT, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `preorderInfo` (`id` TEXT NOT NULL, `tableOrderId` TEXT NOT NULL, `subOrderId` TEXT NOT NULL, `guestIdxes` TEXT NOT NULL, `waiterId` INTEGER NOT NULL, `cashierId` INTEGER NOT NULL, `cancellerId` INTEGER, `printDeviceId` TEXT, `localPrintDate` TEXT NOT NULL, `localTimezoneOffsetMin` INTEGER NOT NULL, `status` TEXT NOT NULL, `replicationStatus` TEXT NOT NULL, `cancellationReason` TEXT, `items` TEXT NOT NULL, `baseSum` REAL NOT NULL, `sumWithDiscount` REAL NOT NULL, `totalDiscount` REAL NOT NULL, `markupSum` REAL NOT NULL, `terminalSalePlaceId` INTEGER, `tableId` INTEGER, `terminalId` TEXT NOT NULL, `fictitious` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `onlineOffers` (`id` INTEGER NOT NULL, `createDate` TEXT NOT NULL, `refId` TEXT NOT NULL, `offerStatus` TEXT NOT NULL, `paystatus` TEXT NOT NULL, `cancellationaccepted` INTEGER NOT NULL, `version` INTEGER NOT NULL, `cancellationComment` TEXT, `data` TEXT NOT NULL, `replicationStatus` TEXT, `wlPreOrderStatus` TEXT NOT NULL, `deliveryAmount` REAL, `ownerRefId` TEXT, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '6ba38c1fd75d68214adb940edb7b2720')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `encashment`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `ordersV2`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `preorderInfo`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `onlineOffers`");
                if (SpecialAppDatabase_Impl.this.mCallbacks != null) {
                    int size = SpecialAppDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) SpecialAppDatabase_Impl.this.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (SpecialAppDatabase_Impl.this.mCallbacks != null) {
                    int size = SpecialAppDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) SpecialAppDatabase_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = SpecialAppDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                SpecialAppDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (SpecialAppDatabase_Impl.this.mCallbacks != null) {
                    int size = SpecialAppDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) SpecialAppDatabase_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
                HashMap hashMap = new HashMap(12);
                hashMap.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                hashMap.put(LinkHeader.Parameters.Type, new TableInfo.Column(LinkHeader.Parameters.Type, "TEXT", true, 0, (String) null, 1));
                hashMap.put("amount", new TableInfo.Column("amount", "REAL", true, 0, (String) null, 1));
                hashMap.put("replicationStatus", new TableInfo.Column("replicationStatus", "TEXT", true, 0, (String) null, 1));
                hashMap.put("comment", new TableInfo.Column("comment", "TEXT", false, 0, (String) null, 1));
                hashMap.put("timeEncashment", new TableInfo.Column("timeEncashment", "TEXT", true, 0, (String) null, 1));
                hashMap.put("kkmDeviceId", new TableInfo.Column("kkmDeviceId", "TEXT", true, 0, (String) null, 1));
                hashMap.put("shiftId", new TableInfo.Column("shiftId", "TEXT", false, 0, (String) null, 1));
                hashMap.put("salePlaceId", new TableInfo.Column("salePlaceId", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("emergency", new TableInfo.Column("emergency", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("employeeId", new TableInfo.Column("employeeId", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("documentShiftId", new TableInfo.Column("documentShiftId", "TEXT", true, 0, (String) null, 1));
                TableInfo tableInfo = new TableInfo("encashment", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase2, "encashment");
                if (!tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(false, "encashment(ru.quickresto.terminal.client.database.EncashmentDocument).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                HashMap hashMap2 = new HashMap(25);
                hashMap2.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                hashMap2.put("tableOrderDocumentId", new TableInfo.Column("tableOrderDocumentId", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("guestIdxes", new TableInfo.Column("guestIdxes", "TEXT", true, 0, (String) null, 1));
                hashMap2.put(FirebaseAnalytics.Param.ITEMS, new TableInfo.Column(FirebaseAnalytics.Param.ITEMS, "TEXT", true, 0, (String) null, 1));
                hashMap2.put("replicationStatus", new TableInfo.Column("replicationStatus", "TEXT", false, 0, (String) null, 1));
                hashMap2.put("syncTime", new TableInfo.Column("syncTime", "TEXT", false, 0, (String) null, 1));
                hashMap2.put("paymentTransactions", new TableInfo.Column("paymentTransactions", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("receipt", new TableInfo.Column("receipt", "TEXT", false, 0, (String) null, 1));
                hashMap2.put("atolReceiptResponse", new TableInfo.Column("atolReceiptResponse", "TEXT", false, 0, (String) null, 1));
                hashMap2.put("atolReturnResponse", new TableInfo.Column("atolReturnResponse", "TEXT", false, 0, (String) null, 1));
                hashMap2.put("returned", new TableInfo.Column("returned", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("updatable", new TableInfo.Column("updatable", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("returnedComment", new TableInfo.Column("returnedComment", "TEXT", false, 0, (String) null, 1));
                hashMap2.put("priceModifiers", new TableInfo.Column("priceModifiers", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("customerPriceModifiers", new TableInfo.Column("customerPriceModifiers", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("comments", new TableInfo.Column("comments", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("customerSnapshots", new TableInfo.Column("customerSnapshots", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("totalSum", new TableInfo.Column("totalSum", "REAL", true, 0, (String) null, 1));
                hashMap2.put("removed", new TableInfo.Column("removed", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("deliveryItem", new TableInfo.Column("deliveryItem", "TEXT", false, 0, (String) null, 1));
                hashMap2.put("orderDueDateDelta", new TableInfo.Column("orderDueDateDelta", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("courierCheckPrinted", new TableInfo.Column("courierCheckPrinted", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("promoCodes", new TableInfo.Column("promoCodes", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("bonusTransactions", new TableInfo.Column("bonusTransactions", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("customerSnapshot", new TableInfo.Column("customerSnapshot", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo2 = new TableInfo("ordersV2", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo read2 = TableInfo.read(supportSQLiteDatabase2, "ordersV2");
                if (!tableInfo2.equals(read2)) {
                    return new RoomOpenHelper.ValidationResult(false, "ordersV2(ru.quickresto.terminal.client.database.OrderDocumentV2).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
                }
                HashMap hashMap3 = new HashMap(22);
                hashMap3.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                hashMap3.put("tableOrderId", new TableInfo.Column("tableOrderId", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("subOrderId", new TableInfo.Column("subOrderId", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("guestIdxes", new TableInfo.Column("guestIdxes", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("waiterId", new TableInfo.Column("waiterId", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("cashierId", new TableInfo.Column("cashierId", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("cancellerId", new TableInfo.Column("cancellerId", "INTEGER", false, 0, (String) null, 1));
                hashMap3.put("printDeviceId", new TableInfo.Column("printDeviceId", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("localPrintDate", new TableInfo.Column("localPrintDate", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("localTimezoneOffsetMin", new TableInfo.Column("localTimezoneOffsetMin", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put(NotificationCompat.CATEGORY_STATUS, new TableInfo.Column(NotificationCompat.CATEGORY_STATUS, "TEXT", true, 0, (String) null, 1));
                hashMap3.put("replicationStatus", new TableInfo.Column("replicationStatus", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("cancellationReason", new TableInfo.Column("cancellationReason", "TEXT", false, 0, (String) null, 1));
                hashMap3.put(FirebaseAnalytics.Param.ITEMS, new TableInfo.Column(FirebaseAnalytics.Param.ITEMS, "TEXT", true, 0, (String) null, 1));
                hashMap3.put("baseSum", new TableInfo.Column("baseSum", "REAL", true, 0, (String) null, 1));
                hashMap3.put("sumWithDiscount", new TableInfo.Column("sumWithDiscount", "REAL", true, 0, (String) null, 1));
                hashMap3.put("totalDiscount", new TableInfo.Column("totalDiscount", "REAL", true, 0, (String) null, 1));
                hashMap3.put("markupSum", new TableInfo.Column("markupSum", "REAL", true, 0, (String) null, 1));
                hashMap3.put("terminalSalePlaceId", new TableInfo.Column("terminalSalePlaceId", "INTEGER", false, 0, (String) null, 1));
                hashMap3.put("tableId", new TableInfo.Column("tableId", "INTEGER", false, 0, (String) null, 1));
                hashMap3.put("terminalId", new TableInfo.Column("terminalId", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("fictitious", new TableInfo.Column("fictitious", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo3 = new TableInfo("preorderInfo", hashMap3, new HashSet(0), new HashSet(0));
                TableInfo read3 = TableInfo.read(supportSQLiteDatabase2, "preorderInfo");
                if (!tableInfo3.equals(read3)) {
                    return new RoomOpenHelper.ValidationResult(false, "preorderInfo(ru.quickresto.terminal.client.database.PreorderDocument).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
                }
                HashMap hashMap4 = new HashMap(13);
                hashMap4.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap4.put("createDate", new TableInfo.Column("createDate", "TEXT", true, 0, (String) null, 1));
                hashMap4.put("refId", new TableInfo.Column("refId", "TEXT", true, 0, (String) null, 1));
                hashMap4.put("offerStatus", new TableInfo.Column("offerStatus", "TEXT", true, 0, (String) null, 1));
                hashMap4.put("paystatus", new TableInfo.Column("paystatus", "TEXT", true, 0, (String) null, 1));
                hashMap4.put("cancellationaccepted", new TableInfo.Column("cancellationaccepted", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("version", new TableInfo.Column("version", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("cancellationComment", new TableInfo.Column("cancellationComment", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("data", new TableInfo.Column("data", "TEXT", true, 0, (String) null, 1));
                hashMap4.put("replicationStatus", new TableInfo.Column("replicationStatus", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("wlPreOrderStatus", new TableInfo.Column("wlPreOrderStatus", "TEXT", true, 0, (String) null, 1));
                hashMap4.put("deliveryAmount", new TableInfo.Column("deliveryAmount", "REAL", false, 0, (String) null, 1));
                hashMap4.put("ownerRefId", new TableInfo.Column("ownerRefId", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo4 = new TableInfo("onlineOffers", hashMap4, new HashSet(0), new HashSet(0));
                TableInfo read4 = TableInfo.read(supportSQLiteDatabase2, "onlineOffers");
                if (!tableInfo4.equals(read4)) {
                    return new RoomOpenHelper.ValidationResult(false, "onlineOffers(ru.quickresto.terminal.client.database.OnlineOfferDocument).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
                }
                return new RoomOpenHelper.ValidationResult(true, (String) null);
            }
        }, "6ba38c1fd75d68214adb940edb7b2720", "95c78acd1f10573742c425260b342875")).build());
    }

    /* access modifiers changed from: protected */
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "encashment", "ordersV2", "preorderInfo", "onlineOffers");
    }

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `encashment`");
            writableDatabase.execSQL("DELETE FROM `ordersV2`");
            writableDatabase.execSQL("DELETE FROM `preorderInfo`");
            writableDatabase.execSQL("DELETE FROM `onlineOffers`");
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
        hashMap.put(OrderDocumentV2Dao.class, OrderDocumentV2Dao_SpecialAppDatabase_Impl.getRequiredConverters());
        hashMap.put(EncashmentDocumentDao.class, EncashmentDocumentDao_SpecialAppDatabase_Impl.getRequiredConverters());
        hashMap.put(PreorderInfoDocumentDao.class, PreorderInfoDocumentDao_SpecialAppDatabase_Impl.getRequiredConverters());
        hashMap.put(OnlineOfferDocumentDao.class, OnlineOfferDocumentDao_SpecialAppDatabase_Impl.getRequiredConverters());
        return hashMap;
    }

    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return Arrays.asList(new Migration[0]);
    }

    public OrderDocumentV2Dao orderDocumentV2Dao() {
        OrderDocumentV2Dao orderDocumentV2Dao;
        if (this._orderDocumentV2Dao != null) {
            return this._orderDocumentV2Dao;
        }
        synchronized (this) {
            if (this._orderDocumentV2Dao == null) {
                this._orderDocumentV2Dao = new OrderDocumentV2Dao_SpecialAppDatabase_Impl(this);
            }
            orderDocumentV2Dao = this._orderDocumentV2Dao;
        }
        return orderDocumentV2Dao;
    }

    public EncashmentDocumentDao encashmentDocumentDao() {
        EncashmentDocumentDao encashmentDocumentDao;
        if (this._encashmentDocumentDao != null) {
            return this._encashmentDocumentDao;
        }
        synchronized (this) {
            if (this._encashmentDocumentDao == null) {
                this._encashmentDocumentDao = new EncashmentDocumentDao_SpecialAppDatabase_Impl(this);
            }
            encashmentDocumentDao = this._encashmentDocumentDao;
        }
        return encashmentDocumentDao;
    }

    public PreorderInfoDocumentDao preorderInfoDocumentDao() {
        PreorderInfoDocumentDao preorderInfoDocumentDao;
        if (this._preorderInfoDocumentDao != null) {
            return this._preorderInfoDocumentDao;
        }
        synchronized (this) {
            if (this._preorderInfoDocumentDao == null) {
                this._preorderInfoDocumentDao = new PreorderInfoDocumentDao_SpecialAppDatabase_Impl(this);
            }
            preorderInfoDocumentDao = this._preorderInfoDocumentDao;
        }
        return preorderInfoDocumentDao;
    }

    public OnlineOfferDocumentDao onlineOfferDocumentDao() {
        OnlineOfferDocumentDao onlineOfferDocumentDao;
        if (this._onlineOfferDocumentDao != null) {
            return this._onlineOfferDocumentDao;
        }
        synchronized (this) {
            if (this._onlineOfferDocumentDao == null) {
                this._onlineOfferDocumentDao = new OnlineOfferDocumentDao_SpecialAppDatabase_Impl(this);
            }
            onlineOfferDocumentDao = this._onlineOfferDocumentDao;
        }
        return onlineOfferDocumentDao;
    }
}
