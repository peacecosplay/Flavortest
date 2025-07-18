package quickresto.webterminal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
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
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import quickresto.webterminal.database.ApplicationSettingsDocumentRepositoryImpl;
import quickresto.webterminal.database.ApplicationSettingsDocumentRepositoryImpl_ApplicationSettingsDocumentDao_Impl;
import quickresto.webterminal.database.CancellationReasonDocumentRepositoryImpl;
import quickresto.webterminal.database.CancellationReasonDocumentRepositoryImpl_CancellationReasonDocumentDao_Impl;
import quickresto.webterminal.database.ComboDocumentDao;
import quickresto.webterminal.database.ComboDocumentDao_Impl;
import quickresto.webterminal.database.CookingPlaceDocumentDao;
import quickresto.webterminal.database.CookingPlaceDocumentDao_Impl;
import quickresto.webterminal.database.CurrencyDocumentDao;
import quickresto.webterminal.database.CurrencyDocumentDao_Impl;
import quickresto.webterminal.database.DishDocumentDao;
import quickresto.webterminal.database.DishDocumentDao_Impl;
import quickresto.webterminal.database.DishGroupDocumentDao;
import quickresto.webterminal.database.DishGroupDocumentDao_Impl;
import quickresto.webterminal.database.DxBxTaskDocumentDao;
import quickresto.webterminal.database.DxBxTaskDocumentDao_Impl;
import quickresto.webterminal.database.EncashmentDocumentDao;
import quickresto.webterminal.database.EncashmentDocumentDao_AppDatabase_Impl;
import quickresto.webterminal.database.FixedDiscountDocumentDao;
import quickresto.webterminal.database.FixedDiscountDocumentDao_Impl;
import quickresto.webterminal.database.FixedMarkupDocumentDao;
import quickresto.webterminal.database.FixedMarkupDocumentDao_Impl;
import quickresto.webterminal.database.ImageDocumentDao;
import quickresto.webterminal.database.ImageDocumentDao_Impl;
import quickresto.webterminal.database.KitchenDisplayDocumentDao;
import quickresto.webterminal.database.KitchenDisplayDocumentDao_Impl;
import quickresto.webterminal.database.KkmDeviceDocumentDao;
import quickresto.webterminal.database.KkmDeviceDocumentDao_Impl;
import quickresto.webterminal.database.MenuDocumentDao;
import quickresto.webterminal.database.MenuDocumentDao_Impl;
import quickresto.webterminal.database.ModifierDocumentDao;
import quickresto.webterminal.database.ModifierDocumentDao_Impl;
import quickresto.webterminal.database.ModifierGroupDocumentDao;
import quickresto.webterminal.database.ModifierGroupDocumentDao_Impl;
import quickresto.webterminal.database.ModifierLinkDocumentDao;
import quickresto.webterminal.database.ModifierLinkDocumentDao_Impl;
import quickresto.webterminal.database.NomenclatureItemSaleDocumentDao;
import quickresto.webterminal.database.NomenclatureItemSaleDocumentDao_Impl;
import quickresto.webterminal.database.OnlineInterfaceDocumentDao;
import quickresto.webterminal.database.OnlineInterfaceDocumentDao_Impl;
import quickresto.webterminal.database.OnlineOfferDocumentDao;
import quickresto.webterminal.database.OnlineOfferDocumentDao_AppDatabase_Impl;
import quickresto.webterminal.database.OrderDocumentDao;
import quickresto.webterminal.database.OrderDocumentDao_Impl;
import quickresto.webterminal.database.OrderDocumentV2Dao;
import quickresto.webterminal.database.OrderDocumentV2Dao_AppDatabase_Impl;
import quickresto.webterminal.database.OrganizationDocumentDao;
import quickresto.webterminal.database.OrganizationDocumentDao_Impl;
import quickresto.webterminal.database.PaymentTypeDocumentDao;
import quickresto.webterminal.database.PaymentTypeDocumentDao_Impl;
import quickresto.webterminal.database.PosDeviceDocumentDao;
import quickresto.webterminal.database.PosDeviceDocumentDao_Impl;
import quickresto.webterminal.database.PreorderInfoDocumentDao;
import quickresto.webterminal.database.PreorderInfoDocumentDao_AppDatabase_Impl;
import quickresto.webterminal.database.SalePlaceDocumentDao;
import quickresto.webterminal.database.SalePlaceDocumentDao_Impl;
import quickresto.webterminal.database.ScheduledDiscountDocumentDao;
import quickresto.webterminal.database.ScheduledDiscountDocumentDao_Impl;
import quickresto.webterminal.database.ShiftDocumentDao;
import quickresto.webterminal.database.ShiftDocumentDao_AppDatabase_Impl;
import quickresto.webterminal.database.SoldoutListDocumentDao;
import quickresto.webterminal.database.SoldoutListDocumentDao_Impl;
import quickresto.webterminal.database.SpecialSetDocumentDao;
import quickresto.webterminal.database.SpecialSetDocumentDao_Impl;
import quickresto.webterminal.database.TableHashDocumentDao;
import quickresto.webterminal.database.TableHashDocumentDao_Impl;
import quickresto.webterminal.database.TableOrderDocumentDao;
import quickresto.webterminal.database.TableOrderDocumentDao_AppDatabase_Impl;
import quickresto.webterminal.database.TableSchemeDocumentDao;
import quickresto.webterminal.database.TableSchemeDocumentDao_Impl;
import quickresto.webterminal.database.TagDocumentDao;
import quickresto.webterminal.database.TagDocumentDao_Impl;
import quickresto.webterminal.database.TemplateDocumentDao;
import quickresto.webterminal.database.TemplateDocumentDao_Impl;
import quickresto.webterminal.database.TerminalDocumentDao;
import quickresto.webterminal.database.TerminalDocumentDao_Impl;
import quickresto.webterminal.database.TerminalUserDocumentDao;
import quickresto.webterminal.database.TerminalUserDocumentDao_Impl;
import quickresto.webterminal.database.TrueApiDocumentDao;
import quickresto.webterminal.database.TrueApiDocumentDao_Impl;
import quickresto.webterminal.database.VirtualKkmDeviceDocumentDao;
import quickresto.webterminal.database.VirtualKkmDeviceDocumentDao_Impl;
import quickresto.webterminal.database.VirtualPosDeviceDocumentDao;
import quickresto.webterminal.database.VirtualPosDeviceDocumentDao_Impl;
import ru.quickresto.terminal.client.database.ApplicationSettingsDocument;
import ru.quickresto.terminal.client.database.SysExtrasDocumentDao;
import ru.quickresto.terminal.client.database.SysExtrasDocumentDao_Impl;

public final class AppDatabase_Impl extends AppDatabase {
    private volatile ApplicationSettingsDocumentRepositoryImpl.ApplicationSettingsDocumentDao _applicationSettingsDocumentDao;
    private volatile CancellationReasonDocumentRepositoryImpl.CancellationReasonDocumentDao _cancellationReasonDocumentDao;
    private volatile ComboDocumentDao _comboDocumentDao;
    private volatile CookingPlaceDocumentDao _cookingPlaceDocumentDao;
    private volatile CurrencyDocumentDao _currencyDocumentDao;
    private volatile DishDocumentDao _dishDocumentDao;
    private volatile DishGroupDocumentDao _dishGroupDocumentDao;
    private volatile DxBxTaskDocumentDao _dxBxTaskDocumentDao;
    private volatile EncashmentDocumentDao _encashmentDocumentDao;
    private volatile FixedDiscountDocumentDao _fixedDiscountDocumentDao;
    private volatile FixedMarkupDocumentDao _fixedMarkupDocumentDao;
    private volatile ImageDocumentDao _imageDocumentDao;
    private volatile KitchenDisplayDocumentDao _kitchenDisplayDocumentDao;
    private volatile KkmDeviceDocumentDao _kkmDeviceDocumentDao;
    private volatile MenuDocumentDao _menuDocumentDao;
    private volatile ModifierDocumentDao _modifierDocumentDao;
    private volatile ModifierGroupDocumentDao _modifierGroupDocumentDao;
    private volatile ModifierLinkDocumentDao _modifierLinkDocumentDao;
    private volatile NomenclatureItemSaleDocumentDao _nomenclatureItemSaleDocumentDao;
    private volatile OnlineInterfaceDocumentDao _onlineInterfaceDocumentDao;
    private volatile OnlineOfferDocumentDao _onlineOfferDocumentDao;
    private volatile OrderDocumentDao _orderDocumentDao;
    private volatile OrderDocumentV2Dao _orderDocumentV2Dao;
    private volatile OrganizationDocumentDao _organizationDocumentDao;
    private volatile PaymentTypeDocumentDao _paymentTypeDocumentDao;
    private volatile PosDeviceDocumentDao _posDeviceDocumentDao;
    private volatile PreorderInfoDocumentDao _preorderInfoDocumentDao;
    private volatile SalePlaceDocumentDao _salePlaceDocumentDao;
    private volatile ScheduledDiscountDocumentDao _scheduledDiscountDocumentDao;
    private volatile ShiftDocumentDao _shiftDocumentDao;
    private volatile SoldoutListDocumentDao _soldoutListDocumentDao;
    private volatile SpecialSetDocumentDao _specialSetDocumentDao;
    private volatile SysExtrasDocumentDao _sysExtrasDocumentDao;
    private volatile TableHashDocumentDao _tableHashDocumentDao;
    private volatile TableOrderDocumentDao _tableOrderDocumentDao;
    private volatile TableSchemeDocumentDao _tableSchemeDocumentDao;
    private volatile TagDocumentDao _tagDocumentDao;
    private volatile TemplateDocumentDao _templateDocumentDao;
    private volatile TerminalDocumentDao _terminalDocumentDao;
    private volatile TerminalUserDocumentDao _terminalUserDocumentDao;
    private volatile TrueApiDocumentDao _trueApiDocumentDao;
    private volatile VirtualKkmDeviceDocumentDao _virtualKkmDeviceDocumentDao;
    private volatile VirtualPosDeviceDocumentDao _virtualPosDeviceDocumentDao;

    /* access modifiers changed from: protected */
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(29) {
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `paymentType` (`id` INTEGER NOT NULL, `refId` TEXT NOT NULL, `name` TEXT NOT NULL, `type` TEXT NOT NULL, `paymentMechanism` TEXT NOT NULL, `disabled` INTEGER NOT NULL, `partialAllowed` INTEGER NOT NULL, `requireCustomerConfirmation` INTEGER NOT NULL, `operationType` TEXT NOT NULL, `customerType` TEXT NOT NULL, `requireConfirmation` INTEGER NOT NULL, `seq` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `tableHash` (`name` TEXT NOT NULL, `hash` TEXT, PRIMARY KEY(`name`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `applicationSettings` (`id` TEXT NOT NULL, `terminalId` TEXT NOT NULL, `salePlaceId` INTEGER, `backofficeLayer` TEXT, `backofficeSession` TEXT, `accessLevel` TEXT NOT NULL, `currentUser` TEXT, `virtualPosDevice` TEXT, `currentOrderDocumentId` TEXT, `orderNumberPrefix` TEXT NOT NULL, `orderNumberCounterLastValue` INTEGER NOT NULL, `startupTime` TEXT, `orderPrinterSetting` TEXT NOT NULL, `preorderPrinterSetting` TEXT NOT NULL, `preorderDeviceId` TEXT, `courierPrinterSetting` TEXT NOT NULL, `courierDeviceId` TEXT, `autoPasteContactSetting` TEXT NOT NULL, `activationStatus` TEXT NOT NULL, `currencyId` INTEGER, `currencySign` TEXT, `processedTouchTerminalGuid` TEXT, `overriddenTrueApiURI` TEXT, `overriddenTrueApiRequestTimeoutMs` INTEGER, `overriddenDxBxRequestTimeoutMs` INTEGER, `overriddenDocsInBoxURI` TEXT, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `terminal` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `kkmDevice` (`type` TEXT NOT NULL, `name` TEXT NOT NULL, `status` TEXT NOT NULL, `serialNumber` TEXT NOT NULL, `model` TEXT NOT NULL, `firmwareVersion` TEXT NOT NULL, `dateTime` TEXT NOT NULL, `deviceAddress` TEXT, `organizationId` INTEGER, `enabled` INTEGER NOT NULL, `deleted` INTEGER NOT NULL, `deviceId` TEXT NOT NULL, `shift` TEXT, `mac` TEXT, `receiptLineLength` INTEGER, `id` TEXT NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `posDevice` (`deviceId` TEXT NOT NULL, `type` TEXT NOT NULL, `deviceAddress` TEXT NOT NULL, `identifier` TEXT NOT NULL, `model` TEXT NOT NULL, `manufacturer` TEXT NOT NULL, `name` TEXT, `enabled` INTEGER NOT NULL, `deleted` INTEGER NOT NULL, `state` TEXT NOT NULL, `organizationId` INTEGER, `printSetting` TEXT NOT NULL, `printerDeviceId` TEXT, `id` TEXT NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `virtualKkm` (`backofficeId` INTEGER NOT NULL, `shift` TEXT, `deviceId` TEXT NOT NULL, `deleted` INTEGER NOT NULL, `name` TEXT, `enabled` INTEGER NOT NULL, `state` TEXT NOT NULL, `terminalId` TEXT, `printSetting` TEXT NOT NULL, `kdsId` TEXT, `organizationId` INTEGER, `automaticEncashment` INTEGER NOT NULL, `id` TEXT NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `virtualPos` (`backofficeId` INTEGER NOT NULL, `shift` TEXT, `deviceId` TEXT NOT NULL, `deleted` INTEGER NOT NULL, `name` TEXT, `enabled` INTEGER NOT NULL, `state` TEXT NOT NULL, `terminalId` TEXT, `printSetting` TEXT NOT NULL, `kdsId` TEXT, `organizationId` INTEGER, `id` TEXT NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `terminalUser` (`id` INTEGER NOT NULL, `lastName` TEXT, `firstName` TEXT, `tipsUri` TEXT, `pin` TEXT, `inn` TEXT, `deleted` INTEGER, `employeeId` INTEGER, `accessRights` TEXT NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `tableScheme` (`id` INTEGER NOT NULL, `name` TEXT, `fullAddress` TEXT, `deleted` INTEGER NOT NULL, `width` INTEGER, `height` INTEGER, `wlcrmPreorderAvailable` INTEGER NOT NULL, `halls` TEXT NOT NULL, `orderBeforePayment` INTEGER, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `salePlace` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `tableSchemeId` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `organization` (`id` INTEGER NOT NULL, `name` TEXT, `deleted` INTEGER NOT NULL, `inn` TEXT, `chestnyZnak` TEXT, `docsInBox` TEXT, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `cookingPlaces` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `kdsId` TEXT, `printSetting` TEXT NOT NULL, `organizationId` INTEGER, `deleted` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `orders__` (`id` TEXT NOT NULL, `terminalId` TEXT NOT NULL, `kkmId` TEXT, `kkmManufacturerDeviceId` TEXT, `creatorUser` TEXT NOT NULL, `createTime` TEXT NOT NULL, `updateTime` TEXT NOT NULL, `guestCount` INTEGER NOT NULL, `tableId` INTEGER, `items` TEXT NOT NULL, `status` TEXT NOT NULL, `waiterName` TEXT, `tableName` TEXT, `floorName` TEXT, `comment` TEXT, `replicationStatus` TEXT, `syncTime` TEXT, `shiftId` TEXT, `shiftDocumentId` TEXT, `paymentTransactions` TEXT NOT NULL, `organizationId` INTEGER NOT NULL, `organizationName` TEXT, `organizationInn` TEXT, `receipt` TEXT, `atolReceiptResponse` TEXT, `atolReturnResponse` TEXT, `number` TEXT NOT NULL, `returned` INTEGER NOT NULL, `updatable` INTEGER NOT NULL, `returnedComment` TEXT, `priceModifiers` TEXT NOT NULL, `basicPriceModifiers` TEXT NOT NULL, `customerPriceModifiers` TEXT NOT NULL, `createLocalDate` TEXT NOT NULL, `comments` TEXT NOT NULL, `onlineOfferId` TEXT, `customerSnapshot` TEXT, `customerSnapshots` TEXT NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `kitchenDisplays` (`name` TEXT, `model` TEXT NOT NULL, `deviceAddress` TEXT, `deviceType` TEXT NOT NULL, `mac` TEXT, `deviceId` TEXT, `deviceDescription` TEXT, `id` TEXT NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `nomenclatureItemSale` (`id` TEXT NOT NULL, `itemType` TEXT NOT NULL, `organizationId` INTEGER NOT NULL, `cookingPlaceId` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `modifierGroup` (`id` INTEGER NOT NULL, `terminalId` TEXT NOT NULL, `name` TEXT NOT NULL, `parentId` INTEGER, `color` TEXT, `prevId` INTEGER, `orderIndex` INTEGER NOT NULL, `tagId` INTEGER, `deleted` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `modifier` (`id` INTEGER NOT NULL, `terminalId` TEXT NOT NULL, `name` TEXT NOT NULL, `parentId` INTEGER, `price` REAL NOT NULL, `prevId` INTEGER, `orderIndex` INTEGER NOT NULL, `withDish` INTEGER NOT NULL, `tagId` INTEGER, `minPrice` REAL, `excludeDiscount` INTEGER NOT NULL, `excludeMarkup` INTEGER NOT NULL, `deleted` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `modifierLink` (`id` INTEGER NOT NULL, `modifierId` INTEGER NOT NULL, `dishId` INTEGER NOT NULL, `default` INTEGER NOT NULL, `min` INTEGER NOT NULL, `max` INTEGER NOT NULL, `group` INTEGER NOT NULL, `price` REAL NOT NULL, `cookingPlaceId` INTEGER NOT NULL, `organizationId` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `dishGroup` (`id` INTEGER NOT NULL, `terminalId` TEXT NOT NULL, `name` TEXT NOT NULL, `parentId` INTEGER, `color` TEXT, `image` TEXT, `prevId` INTEGER, `orderIndex` INTEGER NOT NULL, `tagId` INTEGER, `deleted` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `dish` (`id` INTEGER NOT NULL, `terminalId` TEXT NOT NULL, `name` TEXT NOT NULL, `parentId` INTEGER, `price` REAL NOT NULL, `imageId` INTEGER, `imageUrl` TEXT, `prevId` INTEGER, `orderIndex` INTEGER NOT NULL, `tagId` INTEGER, `organizationId` INTEGER NOT NULL, `cookingPlaceId` INTEGER NOT NULL, `salePlaceId` INTEGER NOT NULL, `sellingType` TEXT, `deleted` INTEGER NOT NULL, `paths` TEXT NOT NULL, `tagPaths` TEXT NOT NULL, `taxValue` REAL, `minPrice` REAL, `excludeDiscount` INTEGER NOT NULL, `excludeMarkup` INTEGER NOT NULL, `cookingTime` INTEGER, `barCode` TEXT, `categoryName` TEXT, `unitWeight` REAL, `gtin` TEXT, `nomenclatureGuid` TEXT, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `encashment` (`id` TEXT NOT NULL, `type` TEXT NOT NULL, `amount` REAL NOT NULL, `replicationStatus` TEXT NOT NULL, `comment` TEXT, `timeEncashment` TEXT NOT NULL, `kkmDeviceId` TEXT NOT NULL, `shiftId` TEXT, `salePlaceId` INTEGER NOT NULL, `emergency` INTEGER NOT NULL, `employeeId` INTEGER NOT NULL, `documentShiftId` TEXT NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `fixedDiscount` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `type` TEXT NOT NULL, `kind` TEXT NOT NULL, `value` REAL NOT NULL, `dishes` TEXT NOT NULL, `tags` TEXT NOT NULL, `dishesGroups` TEXT NOT NULL, `modifiersGroups` TEXT NOT NULL, `salePlaces` TEXT NOT NULL, `deleted` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `comboOffers` (`activeConditions` TEXT NOT NULL, `id` INTEGER, `name` TEXT, `start` TEXT, `end` TEXT, `quantity` REAL, `dishesFilters` TEXT NOT NULL, `weeklySchedule` TEXT NOT NULL, `discountValue` REAL, `salePlaces` TEXT NOT NULL, `deleted` INTEGER NOT NULL, `crmGroups` TEXT NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `fixedMarkup` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `type` TEXT NOT NULL, `value` REAL NOT NULL, `dishes` TEXT NOT NULL, `tags` TEXT NOT NULL, `dishesGroups` TEXT NOT NULL, `modifiersGroups` TEXT NOT NULL, `salePlaces` TEXT NOT NULL, `deleted` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `cancellationReason` (`id` INTEGER NOT NULL, `deleted` INTEGER NOT NULL, `name` TEXT NOT NULL, `useComment` INTEGER NOT NULL, `withdrawFromStore` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `tag` (`id` INTEGER NOT NULL, `title` TEXT NOT NULL, `deleted` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `specialSet` (`triggerThreshold` REAL NOT NULL, `conditionType` TEXT NOT NULL, `specialOfferAccountTypeId` INTEGER, `id` INTEGER, `name` TEXT, `start` TEXT, `end` TEXT, `quantity` REAL, `dishesFilters` TEXT NOT NULL, `weeklySchedule` TEXT NOT NULL, `discountValue` REAL, `salePlaces` TEXT NOT NULL, `deleted` INTEGER NOT NULL, `crmGroups` TEXT NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `shift` (`id` TEXT NOT NULL, `replicationStatus` TEXT NOT NULL, `syncTime` TEXT, `shiftNumber` INTEGER, `shiftId` TEXT, `openUserId` INTEGER NOT NULL, `kkmId` TEXT NOT NULL, `deviceId` TEXT, `deviceType` TEXT NOT NULL, `actionType` TEXT NOT NULL, `closeShiftRequest` TEXT, `createTime` TEXT NOT NULL, `openedTime` TEXT, `salePlaceId` INTEGER, `sellCounters` TEXT, `nonFiscalCounters` TEXT, `writeOffCounters` TEXT, `registerValues` TEXT, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `ordersV2` (`id` TEXT NOT NULL, `tableOrderDocumentId` TEXT NOT NULL, `guestIdxes` TEXT NOT NULL, `items` TEXT NOT NULL, `replicationStatus` TEXT, `syncTime` TEXT, `paymentTransactions` TEXT NOT NULL, `receipt` TEXT, `atolReceiptResponse` TEXT, `atolReturnResponse` TEXT, `returned` INTEGER NOT NULL, `updatable` INTEGER NOT NULL, `returnedComment` TEXT, `priceModifiers` TEXT NOT NULL, `customerPriceModifiers` TEXT NOT NULL, `comments` TEXT NOT NULL, `customerSnapshots` TEXT NOT NULL, `totalSum` REAL NOT NULL, `removed` INTEGER NOT NULL, `deliveryItem` TEXT, `orderDueDateDelta` INTEGER NOT NULL, `courierCheckPrinted` INTEGER NOT NULL, `promoCodes` TEXT NOT NULL, `bonusTransactions` TEXT NOT NULL, `customerSnapshot` TEXT, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `tableOrders` (`terminalId` TEXT NOT NULL, `kkmId` TEXT, `kkmManufacturerDeviceId` TEXT, `openedUser` TEXT NOT NULL, `waiterUser` TEXT NOT NULL, `closedUser` TEXT, `createTime` TEXT NOT NULL, `localTimezoneOffsetMin` INTEGER NOT NULL, `updateTime` TEXT NOT NULL, `guestCount` INTEGER, `tableId` INTEGER, `originalTableId` INTEGER, `status` TEXT NOT NULL, `waiterName` TEXT, `tableName` TEXT, `floorName` TEXT, `comment` TEXT, `shiftId` TEXT, `shiftDocumentId` TEXT, `organizationId` INTEGER NOT NULL, `organizationName` TEXT, `organizationInn` TEXT, `number` TEXT NOT NULL, `basicPriceModifiers` TEXT NOT NULL, `createLocalDate` TEXT NOT NULL, `id` TEXT NOT NULL, `onlineOfferId` TEXT, `delivery` TEXT, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `preorderInfo` (`id` TEXT NOT NULL, `tableOrderId` TEXT NOT NULL, `subOrderId` TEXT NOT NULL, `guestIdxes` TEXT NOT NULL, `waiterId` INTEGER NOT NULL, `cashierId` INTEGER NOT NULL, `cancellerId` INTEGER, `printDeviceId` TEXT, `localPrintDate` TEXT NOT NULL, `localTimezoneOffsetMin` INTEGER NOT NULL, `status` TEXT NOT NULL, `replicationStatus` TEXT NOT NULL, `cancellationReason` TEXT, `items` TEXT NOT NULL, `baseSum` REAL NOT NULL, `sumWithDiscount` REAL NOT NULL, `totalDiscount` REAL NOT NULL, `markupSum` REAL NOT NULL, `terminalSalePlaceId` INTEGER, `tableId` INTEGER, `terminalId` TEXT NOT NULL, `fictitious` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `soldout` (`id` INTEGER NOT NULL, `tableSchemeId` INTEGER NOT NULL, `stopListDishes` TEXT NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `currency` (`id` INTEGER NOT NULL, `deleted` INTEGER NOT NULL, `abbreviation` TEXT NOT NULL, `name` TEXT NOT NULL, `currencySign` TEXT NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `scheduledDiscount` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `type` TEXT NOT NULL, `kind` TEXT NOT NULL, `value` REAL NOT NULL, `cancellable` INTEGER NOT NULL, `weeklySchedule` TEXT NOT NULL, `startDate` TEXT NOT NULL, `endDate` TEXT NOT NULL, `dishes` TEXT NOT NULL, `tags` TEXT NOT NULL, `dishesGroups` TEXT NOT NULL, `salePlaces` TEXT NOT NULL, `deleted` INTEGER NOT NULL, `promoCustomerId` INTEGER, `promoAccountTypeId` INTEGER, `preorderOnly` INTEGER NOT NULL, `thresholdValue` REAL, `calcAfterDiscountsApplied` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `onlineOffers` (`id` INTEGER NOT NULL, `createDate` TEXT NOT NULL, `refId` TEXT NOT NULL, `offerStatus` TEXT NOT NULL, `paystatus` TEXT NOT NULL, `cancellationaccepted` INTEGER NOT NULL, `version` INTEGER NOT NULL, `cancellationComment` TEXT, `data` TEXT NOT NULL, `replicationStatus` TEXT, `wlPreOrderStatus` TEXT NOT NULL, `deliveryAmount` REAL, `ownerRefId` TEXT, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `sysExtras` (`tenantId` TEXT NOT NULL, `layerStopTime` TEXT, `timeZone` TEXT NOT NULL, PRIMARY KEY(`tenantId`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `onlineInterface` (`id` INTEGER NOT NULL, `encodedCredentials` TEXT NOT NULL, `serverUri` TEXT NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `template` (`name` TEXT NOT NULL, `data` TEXT NOT NULL, PRIMARY KEY(`name`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `image` (`name` TEXT NOT NULL, `data` BLOB NOT NULL, `typeTemplate` TEXT NOT NULL, PRIMARY KEY(`name`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `menu` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `dishIdList` TEXT, `salePlaceIdList` TEXT, `refId` TEXT NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `trueApi` (`id` TEXT NOT NULL, `organizationId` INTEGER NOT NULL, `createTime` TEXT NOT NULL, `hosts` TEXT NOT NULL, `reasonAccident` TEXT, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `dxBxTask` (`id` TEXT NOT NULL, `orderDocumentId` TEXT NOT NULL, `tableOrderDocumentId` TEXT NOT NULL, `organizationId` INTEGER NOT NULL, `createTime` TEXT NOT NULL, `responseTime` TEXT, `status` TEXT NOT NULL, `type` TEXT NOT NULL, `request` TEXT, `response` TEXT, `error` TEXT, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '62877b40e919f71777200cb6820bf78f')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `paymentType`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `tableHash`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `applicationSettings`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `terminal`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `kkmDevice`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `posDevice`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `virtualKkm`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `virtualPos`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `terminalUser`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `tableScheme`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `salePlace`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `organization`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `cookingPlaces`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `orders__`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `kitchenDisplays`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `nomenclatureItemSale`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `modifierGroup`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `modifier`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `modifierLink`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `dishGroup`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `dish`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `encashment`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `fixedDiscount`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `comboOffers`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `fixedMarkup`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `cancellationReason`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `tag`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `specialSet`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `shift`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `ordersV2`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `tableOrders`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `preorderInfo`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `soldout`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `currency`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `scheduledDiscount`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `onlineOffers`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `sysExtras`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `onlineInterface`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `template`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `image`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `menu`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `trueApi`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `dxBxTask`");
                if (AppDatabase_Impl.this.mCallbacks != null) {
                    int size = AppDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) AppDatabase_Impl.this.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (AppDatabase_Impl.this.mCallbacks != null) {
                    int size = AppDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) AppDatabase_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = AppDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                AppDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (AppDatabase_Impl.this.mCallbacks != null) {
                    int size = AppDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) AppDatabase_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
                HashMap hashMap = new HashMap(12);
                hashMap.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap.put("refId", new TableInfo.Column("refId", "TEXT", true, 0, (String) null, 1));
                hashMap.put("name", new TableInfo.Column("name", "TEXT", true, 0, (String) null, 1));
                hashMap.put(LinkHeader.Parameters.Type, new TableInfo.Column(LinkHeader.Parameters.Type, "TEXT", true, 0, (String) null, 1));
                hashMap.put("paymentMechanism", new TableInfo.Column("paymentMechanism", "TEXT", true, 0, (String) null, 1));
                hashMap.put("disabled", new TableInfo.Column("disabled", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("partialAllowed", new TableInfo.Column("partialAllowed", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("requireCustomerConfirmation", new TableInfo.Column("requireCustomerConfirmation", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("operationType", new TableInfo.Column("operationType", "TEXT", true, 0, (String) null, 1));
                hashMap.put("customerType", new TableInfo.Column("customerType", "TEXT", true, 0, (String) null, 1));
                hashMap.put("requireConfirmation", new TableInfo.Column("requireConfirmation", "INTEGER", true, 0, (String) null, 1));
                hashMap.put(RtspHeaders.Values.SEQ, new TableInfo.Column(RtspHeaders.Values.SEQ, "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo = new TableInfo("paymentType", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase2, "paymentType");
                if (!tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(false, "paymentType(ru.quickresto.terminal.client.database.PaymentTypeDocument).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                HashMap hashMap2 = new HashMap(2);
                hashMap2.put("name", new TableInfo.Column("name", "TEXT", true, 1, (String) null, 1));
                hashMap2.put("hash", new TableInfo.Column("hash", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo2 = new TableInfo("tableHash", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo read2 = TableInfo.read(supportSQLiteDatabase2, "tableHash");
                if (!tableInfo2.equals(read2)) {
                    return new RoomOpenHelper.ValidationResult(false, "tableHash(ru.quickresto.terminal.client.database.TableHashDocument).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
                }
                HashMap hashMap3 = new HashMap(26);
                hashMap3.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                hashMap3.put("terminalId", new TableInfo.Column("terminalId", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("salePlaceId", new TableInfo.Column("salePlaceId", "INTEGER", false, 0, (String) null, 1));
                hashMap3.put("backofficeLayer", new TableInfo.Column("backofficeLayer", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("backofficeSession", new TableInfo.Column("backofficeSession", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("accessLevel", new TableInfo.Column("accessLevel", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("currentUser", new TableInfo.Column("currentUser", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("virtualPosDevice", new TableInfo.Column("virtualPosDevice", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("currentOrderDocumentId", new TableInfo.Column("currentOrderDocumentId", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("orderNumberPrefix", new TableInfo.Column("orderNumberPrefix", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("orderNumberCounterLastValue", new TableInfo.Column("orderNumberCounterLastValue", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("startupTime", new TableInfo.Column("startupTime", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("orderPrinterSetting", new TableInfo.Column("orderPrinterSetting", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("preorderPrinterSetting", new TableInfo.Column("preorderPrinterSetting", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("preorderDeviceId", new TableInfo.Column("preorderDeviceId", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("courierPrinterSetting", new TableInfo.Column("courierPrinterSetting", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("courierDeviceId", new TableInfo.Column("courierDeviceId", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("autoPasteContactSetting", new TableInfo.Column("autoPasteContactSetting", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("activationStatus", new TableInfo.Column("activationStatus", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("currencyId", new TableInfo.Column("currencyId", "INTEGER", false, 0, (String) null, 1));
                hashMap3.put("currencySign", new TableInfo.Column("currencySign", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("processedTouchTerminalGuid", new TableInfo.Column("processedTouchTerminalGuid", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("overriddenTrueApiURI", new TableInfo.Column("overriddenTrueApiURI", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("overriddenTrueApiRequestTimeoutMs", new TableInfo.Column("overriddenTrueApiRequestTimeoutMs", "INTEGER", false, 0, (String) null, 1));
                hashMap3.put("overriddenDxBxRequestTimeoutMs", new TableInfo.Column("overriddenDxBxRequestTimeoutMs", "INTEGER", false, 0, (String) null, 1));
                hashMap3.put("overriddenDocsInBoxURI", new TableInfo.Column("overriddenDocsInBoxURI", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo3 = new TableInfo(ApplicationSettingsDocument.APPLICATION_SETTINGS_ID, hashMap3, new HashSet(0), new HashSet(0));
                TableInfo read3 = TableInfo.read(supportSQLiteDatabase2, ApplicationSettingsDocument.APPLICATION_SETTINGS_ID);
                if (!tableInfo3.equals(read3)) {
                    return new RoomOpenHelper.ValidationResult(false, "applicationSettings(ru.quickresto.terminal.client.database.ApplicationSettingsDocument).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
                }
                HashMap hashMap4 = new HashMap(2);
                hashMap4.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                hashMap4.put("name", new TableInfo.Column("name", "TEXT", true, 0, (String) null, 1));
                TableInfo tableInfo4 = new TableInfo("terminal", hashMap4, new HashSet(0), new HashSet(0));
                TableInfo read4 = TableInfo.read(supportSQLiteDatabase2, "terminal");
                if (!tableInfo4.equals(read4)) {
                    return new RoomOpenHelper.ValidationResult(false, "terminal(ru.quickresto.terminal.client.database.TerminalDocument).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
                }
                HashMap hashMap5 = new HashMap(16);
                hashMap5.put(LinkHeader.Parameters.Type, new TableInfo.Column(LinkHeader.Parameters.Type, "TEXT", true, 0, (String) null, 1));
                hashMap5.put("name", new TableInfo.Column("name", "TEXT", true, 0, (String) null, 1));
                hashMap5.put(NotificationCompat.CATEGORY_STATUS, new TableInfo.Column(NotificationCompat.CATEGORY_STATUS, "TEXT", true, 0, (String) null, 1));
                hashMap5.put("serialNumber", new TableInfo.Column("serialNumber", "TEXT", true, 0, (String) null, 1));
                hashMap5.put("model", new TableInfo.Column("model", "TEXT", true, 0, (String) null, 1));
                hashMap5.put("firmwareVersion", new TableInfo.Column("firmwareVersion", "TEXT", true, 0, (String) null, 1));
                hashMap5.put("dateTime", new TableInfo.Column("dateTime", "TEXT", true, 0, (String) null, 1));
                hashMap5.put("deviceAddress", new TableInfo.Column("deviceAddress", "TEXT", false, 0, (String) null, 1));
                hashMap5.put("organizationId", new TableInfo.Column("organizationId", "INTEGER", false, 0, (String) null, 1));
                hashMap5.put("enabled", new TableInfo.Column("enabled", "INTEGER", true, 0, (String) null, 1));
                hashMap5.put("deleted", new TableInfo.Column("deleted", "INTEGER", true, 0, (String) null, 1));
                hashMap5.put("deviceId", new TableInfo.Column("deviceId", "TEXT", true, 0, (String) null, 1));
                hashMap5.put("shift", new TableInfo.Column("shift", "TEXT", false, 0, (String) null, 1));
                hashMap5.put("mac", new TableInfo.Column("mac", "TEXT", false, 0, (String) null, 1));
                hashMap5.put("receiptLineLength", new TableInfo.Column("receiptLineLength", "INTEGER", false, 0, (String) null, 1));
                hashMap5.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                HashSet hashSet = new HashSet(0);
                Object obj = "salePlaceId";
                HashSet hashSet2 = new HashSet(0);
                Object obj2 = NotificationCompat.CATEGORY_STATUS;
                TableInfo tableInfo5 = new TableInfo("kkmDevice", hashMap5, hashSet, hashSet2);
                TableInfo read5 = TableInfo.read(supportSQLiteDatabase2, "kkmDevice");
                if (!tableInfo5.equals(read5)) {
                    return new RoomOpenHelper.ValidationResult(false, "kkmDevice(ru.quickresto.terminal.client.database.KkmDeviceDocument).\n Expected:\n" + tableInfo5 + "\n Found:\n" + read5);
                }
                HashMap hashMap6 = new HashMap(14);
                hashMap6.put("deviceId", new TableInfo.Column("deviceId", "TEXT", true, 0, (String) null, 1));
                hashMap6.put(LinkHeader.Parameters.Type, new TableInfo.Column(LinkHeader.Parameters.Type, "TEXT", true, 0, (String) null, 1));
                hashMap6.put("deviceAddress", new TableInfo.Column("deviceAddress", "TEXT", true, 0, (String) null, 1));
                hashMap6.put("identifier", new TableInfo.Column("identifier", "TEXT", true, 0, (String) null, 1));
                hashMap6.put("model", new TableInfo.Column("model", "TEXT", true, 0, (String) null, 1));
                hashMap6.put("manufacturer", new TableInfo.Column("manufacturer", "TEXT", true, 0, (String) null, 1));
                hashMap6.put("name", new TableInfo.Column("name", "TEXT", false, 0, (String) null, 1));
                hashMap6.put("enabled", new TableInfo.Column("enabled", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("deleted", new TableInfo.Column("deleted", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("state", new TableInfo.Column("state", "TEXT", true, 0, (String) null, 1));
                hashMap6.put("organizationId", new TableInfo.Column("organizationId", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("printSetting", new TableInfo.Column("printSetting", "TEXT", true, 0, (String) null, 1));
                hashMap6.put("printerDeviceId", new TableInfo.Column("printerDeviceId", "TEXT", false, 0, (String) null, 1));
                hashMap6.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                HashSet hashSet3 = new HashSet(0);
                HashSet hashSet4 = new HashSet(0);
                Object obj3 = LinkHeader.Parameters.Type;
                TableInfo tableInfo6 = new TableInfo("posDevice", hashMap6, hashSet3, hashSet4);
                TableInfo read6 = TableInfo.read(supportSQLiteDatabase2, "posDevice");
                if (!tableInfo6.equals(read6)) {
                    return new RoomOpenHelper.ValidationResult(false, "posDevice(ru.quickresto.terminal.client.database.PosDeviceDocument).\n Expected:\n" + tableInfo6 + "\n Found:\n" + read6);
                }
                HashMap hashMap7 = new HashMap(13);
                hashMap7.put("backofficeId", new TableInfo.Column("backofficeId", "INTEGER", true, 0, (String) null, 1));
                hashMap7.put("shift", new TableInfo.Column("shift", "TEXT", false, 0, (String) null, 1));
                hashMap7.put("deviceId", new TableInfo.Column("deviceId", "TEXT", true, 0, (String) null, 1));
                hashMap7.put("deleted", new TableInfo.Column("deleted", "INTEGER", true, 0, (String) null, 1));
                hashMap7.put("name", new TableInfo.Column("name", "TEXT", false, 0, (String) null, 1));
                hashMap7.put("enabled", new TableInfo.Column("enabled", "INTEGER", true, 0, (String) null, 1));
                hashMap7.put("state", new TableInfo.Column("state", "TEXT", true, 0, (String) null, 1));
                hashMap7.put("terminalId", new TableInfo.Column("terminalId", "TEXT", false, 0, (String) null, 1));
                hashMap7.put("printSetting", new TableInfo.Column("printSetting", "TEXT", true, 0, (String) null, 1));
                hashMap7.put("kdsId", new TableInfo.Column("kdsId", "TEXT", false, 0, (String) null, 1));
                hashMap7.put("organizationId", new TableInfo.Column("organizationId", "INTEGER", false, 0, (String) null, 1));
                hashMap7.put("automaticEncashment", new TableInfo.Column("automaticEncashment", "INTEGER", true, 0, (String) null, 1));
                hashMap7.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                TableInfo tableInfo7 = new TableInfo("virtualKkm", hashMap7, new HashSet(0), new HashSet(0));
                TableInfo read7 = TableInfo.read(supportSQLiteDatabase2, "virtualKkm");
                if (!tableInfo7.equals(read7)) {
                    return new RoomOpenHelper.ValidationResult(false, "virtualKkm(ru.quickresto.terminal.client.database.VirtualKkmDeviceDocument).\n Expected:\n" + tableInfo7 + "\n Found:\n" + read7);
                }
                HashMap hashMap8 = new HashMap(12);
                hashMap8.put("backofficeId", new TableInfo.Column("backofficeId", "INTEGER", true, 0, (String) null, 1));
                hashMap8.put("shift", new TableInfo.Column("shift", "TEXT", false, 0, (String) null, 1));
                hashMap8.put("deviceId", new TableInfo.Column("deviceId", "TEXT", true, 0, (String) null, 1));
                hashMap8.put("deleted", new TableInfo.Column("deleted", "INTEGER", true, 0, (String) null, 1));
                hashMap8.put("name", new TableInfo.Column("name", "TEXT", false, 0, (String) null, 1));
                hashMap8.put("enabled", new TableInfo.Column("enabled", "INTEGER", true, 0, (String) null, 1));
                hashMap8.put("state", new TableInfo.Column("state", "TEXT", true, 0, (String) null, 1));
                hashMap8.put("terminalId", new TableInfo.Column("terminalId", "TEXT", false, 0, (String) null, 1));
                hashMap8.put("printSetting", new TableInfo.Column("printSetting", "TEXT", true, 0, (String) null, 1));
                hashMap8.put("kdsId", new TableInfo.Column("kdsId", "TEXT", false, 0, (String) null, 1));
                hashMap8.put("organizationId", new TableInfo.Column("organizationId", "INTEGER", false, 0, (String) null, 1));
                hashMap8.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                TableInfo tableInfo8 = new TableInfo("virtualPos", hashMap8, new HashSet(0), new HashSet(0));
                TableInfo read8 = TableInfo.read(supportSQLiteDatabase2, "virtualPos");
                if (!tableInfo8.equals(read8)) {
                    return new RoomOpenHelper.ValidationResult(false, "virtualPos(ru.quickresto.terminal.client.database.VirtualPosDeviceDocument).\n Expected:\n" + tableInfo8 + "\n Found:\n" + read8);
                }
                HashMap hashMap9 = new HashMap(9);
                hashMap9.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap9.put("lastName", new TableInfo.Column("lastName", "TEXT", false, 0, (String) null, 1));
                hashMap9.put("firstName", new TableInfo.Column("firstName", "TEXT", false, 0, (String) null, 1));
                hashMap9.put("tipsUri", new TableInfo.Column("tipsUri", "TEXT", false, 0, (String) null, 1));
                hashMap9.put("pin", new TableInfo.Column("pin", "TEXT", false, 0, (String) null, 1));
                hashMap9.put("inn", new TableInfo.Column("inn", "TEXT", false, 0, (String) null, 1));
                hashMap9.put("deleted", new TableInfo.Column("deleted", "INTEGER", false, 0, (String) null, 1));
                hashMap9.put("employeeId", new TableInfo.Column("employeeId", "INTEGER", false, 0, (String) null, 1));
                hashMap9.put("accessRights", new TableInfo.Column("accessRights", "TEXT", true, 0, (String) null, 1));
                TableInfo tableInfo9 = new TableInfo("terminalUser", hashMap9, new HashSet(0), new HashSet(0));
                TableInfo read9 = TableInfo.read(supportSQLiteDatabase2, "terminalUser");
                if (!tableInfo9.equals(read9)) {
                    return new RoomOpenHelper.ValidationResult(false, "terminalUser(ru.quickresto.terminal.client.database.TerminalUserDocument).\n Expected:\n" + tableInfo9 + "\n Found:\n" + read9);
                }
                HashMap hashMap10 = new HashMap(9);
                hashMap10.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap10.put("name", new TableInfo.Column("name", "TEXT", false, 0, (String) null, 1));
                hashMap10.put("fullAddress", new TableInfo.Column("fullAddress", "TEXT", false, 0, (String) null, 1));
                hashMap10.put("deleted", new TableInfo.Column("deleted", "INTEGER", true, 0, (String) null, 1));
                hashMap10.put("width", new TableInfo.Column("width", "INTEGER", false, 0, (String) null, 1));
                hashMap10.put("height", new TableInfo.Column("height", "INTEGER", false, 0, (String) null, 1));
                hashMap10.put("wlcrmPreorderAvailable", new TableInfo.Column("wlcrmPreorderAvailable", "INTEGER", true, 0, (String) null, 1));
                hashMap10.put("halls", new TableInfo.Column("halls", "TEXT", true, 0, (String) null, 1));
                hashMap10.put("orderBeforePayment", new TableInfo.Column("orderBeforePayment", "INTEGER", false, 0, (String) null, 1));
                TableInfo tableInfo10 = new TableInfo("tableScheme", hashMap10, new HashSet(0), new HashSet(0));
                TableInfo read10 = TableInfo.read(supportSQLiteDatabase2, "tableScheme");
                if (!tableInfo10.equals(read10)) {
                    return new RoomOpenHelper.ValidationResult(false, "tableScheme(ru.quickresto.terminal.client.database.TableSchemeDocument).\n Expected:\n" + tableInfo10 + "\n Found:\n" + read10);
                }
                HashMap hashMap11 = new HashMap(3);
                hashMap11.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap11.put("name", new TableInfo.Column("name", "TEXT", true, 0, (String) null, 1));
                hashMap11.put("tableSchemeId", new TableInfo.Column("tableSchemeId", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo11 = new TableInfo("salePlace", hashMap11, new HashSet(0), new HashSet(0));
                TableInfo read11 = TableInfo.read(supportSQLiteDatabase2, "salePlace");
                if (!tableInfo11.equals(read11)) {
                    return new RoomOpenHelper.ValidationResult(false, "salePlace(ru.quickresto.terminal.client.database.SalePlaceDocument).\n Expected:\n" + tableInfo11 + "\n Found:\n" + read11);
                }
                HashMap hashMap12 = new HashMap(6);
                hashMap12.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap12.put("name", new TableInfo.Column("name", "TEXT", false, 0, (String) null, 1));
                hashMap12.put("deleted", new TableInfo.Column("deleted", "INTEGER", true, 0, (String) null, 1));
                hashMap12.put("inn", new TableInfo.Column("inn", "TEXT", false, 0, (String) null, 1));
                hashMap12.put("chestnyZnak", new TableInfo.Column("chestnyZnak", "TEXT", false, 0, (String) null, 1));
                hashMap12.put("docsInBox", new TableInfo.Column("docsInBox", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo12 = new TableInfo("organization", hashMap12, new HashSet(0), new HashSet(0));
                TableInfo read12 = TableInfo.read(supportSQLiteDatabase2, "organization");
                if (!tableInfo12.equals(read12)) {
                    return new RoomOpenHelper.ValidationResult(false, "organization(ru.quickresto.terminal.client.database.OrganizationDocument).\n Expected:\n" + tableInfo12 + "\n Found:\n" + read12);
                }
                HashMap hashMap13 = new HashMap(6);
                hashMap13.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap13.put("name", new TableInfo.Column("name", "TEXT", true, 0, (String) null, 1));
                hashMap13.put("kdsId", new TableInfo.Column("kdsId", "TEXT", false, 0, (String) null, 1));
                hashMap13.put("printSetting", new TableInfo.Column("printSetting", "TEXT", true, 0, (String) null, 1));
                hashMap13.put("organizationId", new TableInfo.Column("organizationId", "INTEGER", false, 0, (String) null, 1));
                hashMap13.put("deleted", new TableInfo.Column("deleted", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo13 = new TableInfo("cookingPlaces", hashMap13, new HashSet(0), new HashSet(0));
                TableInfo read13 = TableInfo.read(supportSQLiteDatabase2, "cookingPlaces");
                if (!tableInfo13.equals(read13)) {
                    return new RoomOpenHelper.ValidationResult(false, "cookingPlaces(ru.quickresto.terminal.client.database.CookingPlaceDocument).\n Expected:\n" + tableInfo13 + "\n Found:\n" + read13);
                }
                HashMap hashMap14 = new HashMap(38);
                hashMap14.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                hashMap14.put("terminalId", new TableInfo.Column("terminalId", "TEXT", true, 0, (String) null, 1));
                hashMap14.put("kkmId", new TableInfo.Column("kkmId", "TEXT", false, 0, (String) null, 1));
                hashMap14.put("kkmManufacturerDeviceId", new TableInfo.Column("kkmManufacturerDeviceId", "TEXT", false, 0, (String) null, 1));
                hashMap14.put("creatorUser", new TableInfo.Column("creatorUser", "TEXT", true, 0, (String) null, 1));
                hashMap14.put("createTime", new TableInfo.Column("createTime", "TEXT", true, 0, (String) null, 1));
                hashMap14.put("updateTime", new TableInfo.Column("updateTime", "TEXT", true, 0, (String) null, 1));
                hashMap14.put("guestCount", new TableInfo.Column("guestCount", "INTEGER", true, 0, (String) null, 1));
                hashMap14.put("tableId", new TableInfo.Column("tableId", "INTEGER", false, 0, (String) null, 1));
                hashMap14.put(FirebaseAnalytics.Param.ITEMS, new TableInfo.Column(FirebaseAnalytics.Param.ITEMS, "TEXT", true, 0, (String) null, 1));
                Object obj4 = obj2;
                hashMap14.put(obj4, new TableInfo.Column(NotificationCompat.CATEGORY_STATUS, "TEXT", true, 0, (String) null, 1));
                hashMap14.put("waiterName", new TableInfo.Column("waiterName", "TEXT", false, 0, (String) null, 1));
                hashMap14.put("tableName", new TableInfo.Column("tableName", "TEXT", false, 0, (String) null, 1));
                hashMap14.put("floorName", new TableInfo.Column("floorName", "TEXT", false, 0, (String) null, 1));
                hashMap14.put("comment", new TableInfo.Column("comment", "TEXT", false, 0, (String) null, 1));
                hashMap14.put("replicationStatus", new TableInfo.Column("replicationStatus", "TEXT", false, 0, (String) null, 1));
                hashMap14.put("syncTime", new TableInfo.Column("syncTime", "TEXT", false, 0, (String) null, 1));
                hashMap14.put("shiftId", new TableInfo.Column("shiftId", "TEXT", false, 0, (String) null, 1));
                hashMap14.put("shiftDocumentId", new TableInfo.Column("shiftDocumentId", "TEXT", false, 0, (String) null, 1));
                hashMap14.put("paymentTransactions", new TableInfo.Column("paymentTransactions", "TEXT", true, 0, (String) null, 1));
                hashMap14.put("organizationId", new TableInfo.Column("organizationId", "INTEGER", true, 0, (String) null, 1));
                hashMap14.put("organizationName", new TableInfo.Column("organizationName", "TEXT", false, 0, (String) null, 1));
                hashMap14.put("organizationInn", new TableInfo.Column("organizationInn", "TEXT", false, 0, (String) null, 1));
                hashMap14.put("receipt", new TableInfo.Column("receipt", "TEXT", false, 0, (String) null, 1));
                hashMap14.put("atolReceiptResponse", new TableInfo.Column("atolReceiptResponse", "TEXT", false, 0, (String) null, 1));
                hashMap14.put("atolReturnResponse", new TableInfo.Column("atolReturnResponse", "TEXT", false, 0, (String) null, 1));
                hashMap14.put("number", new TableInfo.Column("number", "TEXT", true, 0, (String) null, 1));
                hashMap14.put("returned", new TableInfo.Column("returned", "INTEGER", true, 0, (String) null, 1));
                hashMap14.put("updatable", new TableInfo.Column("updatable", "INTEGER", true, 0, (String) null, 1));
                hashMap14.put("returnedComment", new TableInfo.Column("returnedComment", "TEXT", false, 0, (String) null, 1));
                hashMap14.put("priceModifiers", new TableInfo.Column("priceModifiers", "TEXT", true, 0, (String) null, 1));
                hashMap14.put("basicPriceModifiers", new TableInfo.Column("basicPriceModifiers", "TEXT", true, 0, (String) null, 1));
                hashMap14.put("customerPriceModifiers", new TableInfo.Column("customerPriceModifiers", "TEXT", true, 0, (String) null, 1));
                hashMap14.put("createLocalDate", new TableInfo.Column("createLocalDate", "TEXT", true, 0, (String) null, 1));
                hashMap14.put("comments", new TableInfo.Column("comments", "TEXT", true, 0, (String) null, 1));
                hashMap14.put("onlineOfferId", new TableInfo.Column("onlineOfferId", "TEXT", false, 0, (String) null, 1));
                hashMap14.put("customerSnapshot", new TableInfo.Column("customerSnapshot", "TEXT", false, 0, (String) null, 1));
                hashMap14.put("customerSnapshots", new TableInfo.Column("customerSnapshots", "TEXT", true, 0, (String) null, 1));
                Object obj5 = obj4;
                String str = "shift";
                TableInfo tableInfo14 = new TableInfo("orders__", hashMap14, new HashSet(0), new HashSet(0));
                TableInfo read14 = TableInfo.read(supportSQLiteDatabase2, "orders__");
                if (!tableInfo14.equals(read14)) {
                    return new RoomOpenHelper.ValidationResult(false, "orders__(ru.quickresto.terminal.client.database.OrderDocument).\n Expected:\n" + tableInfo14 + "\n Found:\n" + read14);
                }
                HashMap hashMap15 = new HashMap(8);
                hashMap15.put("name", new TableInfo.Column("name", "TEXT", false, 0, (String) null, 1));
                hashMap15.put("model", new TableInfo.Column("model", "TEXT", true, 0, (String) null, 1));
                hashMap15.put("deviceAddress", new TableInfo.Column("deviceAddress", "TEXT", false, 0, (String) null, 1));
                hashMap15.put("deviceType", new TableInfo.Column("deviceType", "TEXT", true, 0, (String) null, 1));
                hashMap15.put("mac", new TableInfo.Column("mac", "TEXT", false, 0, (String) null, 1));
                hashMap15.put("deviceId", new TableInfo.Column("deviceId", "TEXT", false, 0, (String) null, 1));
                hashMap15.put("deviceDescription", new TableInfo.Column("deviceDescription", "TEXT", false, 0, (String) null, 1));
                hashMap15.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                TableInfo tableInfo15 = new TableInfo("kitchenDisplays", hashMap15, new HashSet(0), new HashSet(0));
                TableInfo read15 = TableInfo.read(supportSQLiteDatabase2, "kitchenDisplays");
                if (!tableInfo15.equals(read15)) {
                    return new RoomOpenHelper.ValidationResult(false, "kitchenDisplays(ru.quickresto.terminal.client.database.KitchenDisplayDocument).\n Expected:\n" + tableInfo15 + "\n Found:\n" + read15);
                }
                HashMap hashMap16 = new HashMap(4);
                hashMap16.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                hashMap16.put("itemType", new TableInfo.Column("itemType", "TEXT", true, 0, (String) null, 1));
                hashMap16.put("organizationId", new TableInfo.Column("organizationId", "INTEGER", true, 0, (String) null, 1));
                hashMap16.put("cookingPlaceId", new TableInfo.Column("cookingPlaceId", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo16 = new TableInfo("nomenclatureItemSale", hashMap16, new HashSet(0), new HashSet(0));
                TableInfo read16 = TableInfo.read(supportSQLiteDatabase2, "nomenclatureItemSale");
                if (!tableInfo16.equals(read16)) {
                    return new RoomOpenHelper.ValidationResult(false, "nomenclatureItemSale(ru.quickresto.terminal.client.database.NomenclatureItemSaleDocument).\n Expected:\n" + tableInfo16 + "\n Found:\n" + read16);
                }
                HashMap hashMap17 = new HashMap(9);
                hashMap17.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap17.put("terminalId", new TableInfo.Column("terminalId", "TEXT", true, 0, (String) null, 1));
                hashMap17.put("name", new TableInfo.Column("name", "TEXT", true, 0, (String) null, 1));
                hashMap17.put("parentId", new TableInfo.Column("parentId", "INTEGER", false, 0, (String) null, 1));
                hashMap17.put(TypedValues.Custom.S_COLOR, new TableInfo.Column(TypedValues.Custom.S_COLOR, "TEXT", false, 0, (String) null, 1));
                hashMap17.put("prevId", new TableInfo.Column("prevId", "INTEGER", false, 0, (String) null, 1));
                hashMap17.put("orderIndex", new TableInfo.Column("orderIndex", "INTEGER", true, 0, (String) null, 1));
                hashMap17.put("tagId", new TableInfo.Column("tagId", "INTEGER", false, 0, (String) null, 1));
                hashMap17.put("deleted", new TableInfo.Column("deleted", "INTEGER", true, 0, (String) null, 1));
                Object obj6 = "createTime";
                Object obj7 = "deviceId";
                TableInfo tableInfo17 = new TableInfo("modifierGroup", hashMap17, new HashSet(0), new HashSet(0));
                TableInfo read17 = TableInfo.read(supportSQLiteDatabase2, "modifierGroup");
                if (!tableInfo17.equals(read17)) {
                    return new RoomOpenHelper.ValidationResult(false, "modifierGroup(ru.quickresto.terminal.client.database.ModifierGroupDocument).\n Expected:\n" + tableInfo17 + "\n Found:\n" + read17);
                }
                HashMap hashMap18 = new HashMap(13);
                hashMap18.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap18.put("terminalId", new TableInfo.Column("terminalId", "TEXT", true, 0, (String) null, 1));
                hashMap18.put("name", new TableInfo.Column("name", "TEXT", true, 0, (String) null, 1));
                hashMap18.put("parentId", new TableInfo.Column("parentId", "INTEGER", false, 0, (String) null, 1));
                hashMap18.put(FirebaseAnalytics.Param.PRICE, new TableInfo.Column(FirebaseAnalytics.Param.PRICE, "REAL", true, 0, (String) null, 1));
                hashMap18.put("prevId", new TableInfo.Column("prevId", "INTEGER", false, 0, (String) null, 1));
                hashMap18.put("orderIndex", new TableInfo.Column("orderIndex", "INTEGER", true, 0, (String) null, 1));
                hashMap18.put("withDish", new TableInfo.Column("withDish", "INTEGER", true, 0, (String) null, 1));
                hashMap18.put("tagId", new TableInfo.Column("tagId", "INTEGER", false, 0, (String) null, 1));
                hashMap18.put("minPrice", new TableInfo.Column("minPrice", "REAL", false, 0, (String) null, 1));
                hashMap18.put("excludeDiscount", new TableInfo.Column("excludeDiscount", "INTEGER", true, 0, (String) null, 1));
                hashMap18.put("excludeMarkup", new TableInfo.Column("excludeMarkup", "INTEGER", true, 0, (String) null, 1));
                hashMap18.put("deleted", new TableInfo.Column("deleted", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo18 = new TableInfo("modifier", hashMap18, new HashSet(0), new HashSet(0));
                TableInfo read18 = TableInfo.read(supportSQLiteDatabase2, "modifier");
                if (!tableInfo18.equals(read18)) {
                    return new RoomOpenHelper.ValidationResult(false, "modifier(ru.quickresto.terminal.client.database.ModifierDocument).\n Expected:\n" + tableInfo18 + "\n Found:\n" + read18);
                }
                HashMap hashMap19 = new HashMap(10);
                hashMap19.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap19.put("modifierId", new TableInfo.Column("modifierId", "INTEGER", true, 0, (String) null, 1));
                hashMap19.put("dishId", new TableInfo.Column("dishId", "INTEGER", true, 0, (String) null, 1));
                hashMap19.put("default", new TableInfo.Column("default", "INTEGER", true, 0, (String) null, 1));
                hashMap19.put("min", new TableInfo.Column("min", "INTEGER", true, 0, (String) null, 1));
                hashMap19.put("max", new TableInfo.Column("max", "INTEGER", true, 0, (String) null, 1));
                hashMap19.put("group", new TableInfo.Column("group", "INTEGER", true, 0, (String) null, 1));
                hashMap19.put(FirebaseAnalytics.Param.PRICE, new TableInfo.Column(FirebaseAnalytics.Param.PRICE, "REAL", true, 0, (String) null, 1));
                hashMap19.put("cookingPlaceId", new TableInfo.Column("cookingPlaceId", "INTEGER", true, 0, (String) null, 1));
                hashMap19.put("organizationId", new TableInfo.Column("organizationId", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo19 = new TableInfo("modifierLink", hashMap19, new HashSet(0), new HashSet(0));
                TableInfo read19 = TableInfo.read(supportSQLiteDatabase2, "modifierLink");
                if (!tableInfo19.equals(read19)) {
                    return new RoomOpenHelper.ValidationResult(false, "modifierLink(ru.quickresto.terminal.client.database.ModifierLinkDocument).\n Expected:\n" + tableInfo19 + "\n Found:\n" + read19);
                }
                HashMap hashMap20 = new HashMap(10);
                hashMap20.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap20.put("terminalId", new TableInfo.Column("terminalId", "TEXT", true, 0, (String) null, 1));
                hashMap20.put("name", new TableInfo.Column("name", "TEXT", true, 0, (String) null, 1));
                hashMap20.put("parentId", new TableInfo.Column("parentId", "INTEGER", false, 0, (String) null, 1));
                hashMap20.put(TypedValues.Custom.S_COLOR, new TableInfo.Column(TypedValues.Custom.S_COLOR, "TEXT", false, 0, (String) null, 1));
                hashMap20.put("image", new TableInfo.Column("image", "TEXT", false, 0, (String) null, 1));
                hashMap20.put("prevId", new TableInfo.Column("prevId", "INTEGER", false, 0, (String) null, 1));
                hashMap20.put("orderIndex", new TableInfo.Column("orderIndex", "INTEGER", true, 0, (String) null, 1));
                hashMap20.put("tagId", new TableInfo.Column("tagId", "INTEGER", false, 0, (String) null, 1));
                hashMap20.put("deleted", new TableInfo.Column("deleted", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo20 = new TableInfo("dishGroup", hashMap20, new HashSet(0), new HashSet(0));
                TableInfo read20 = TableInfo.read(supportSQLiteDatabase2, "dishGroup");
                if (!tableInfo20.equals(read20)) {
                    return new RoomOpenHelper.ValidationResult(false, "dishGroup(ru.quickresto.terminal.client.database.DishGroupDocument).\n Expected:\n" + tableInfo20 + "\n Found:\n" + read20);
                }
                HashMap hashMap21 = new HashMap(27);
                hashMap21.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap21.put("terminalId", new TableInfo.Column("terminalId", "TEXT", true, 0, (String) null, 1));
                hashMap21.put("name", new TableInfo.Column("name", "TEXT", true, 0, (String) null, 1));
                hashMap21.put("parentId", new TableInfo.Column("parentId", "INTEGER", false, 0, (String) null, 1));
                hashMap21.put(FirebaseAnalytics.Param.PRICE, new TableInfo.Column(FirebaseAnalytics.Param.PRICE, "REAL", true, 0, (String) null, 1));
                hashMap21.put("imageId", new TableInfo.Column("imageId", "INTEGER", false, 0, (String) null, 1));
                hashMap21.put("imageUrl", new TableInfo.Column("imageUrl", "TEXT", false, 0, (String) null, 1));
                hashMap21.put("prevId", new TableInfo.Column("prevId", "INTEGER", false, 0, (String) null, 1));
                hashMap21.put("orderIndex", new TableInfo.Column("orderIndex", "INTEGER", true, 0, (String) null, 1));
                hashMap21.put("tagId", new TableInfo.Column("tagId", "INTEGER", false, 0, (String) null, 1));
                hashMap21.put("organizationId", new TableInfo.Column("organizationId", "INTEGER", true, 0, (String) null, 1));
                hashMap21.put("cookingPlaceId", new TableInfo.Column("cookingPlaceId", "INTEGER", true, 0, (String) null, 1));
                Object obj8 = obj;
                hashMap21.put(obj8, new TableInfo.Column("salePlaceId", "INTEGER", true, 0, (String) null, 1));
                hashMap21.put("sellingType", new TableInfo.Column("sellingType", "TEXT", false, 0, (String) null, 1));
                hashMap21.put("deleted", new TableInfo.Column("deleted", "INTEGER", true, 0, (String) null, 1));
                hashMap21.put("paths", new TableInfo.Column("paths", "TEXT", true, 0, (String) null, 1));
                hashMap21.put("tagPaths", new TableInfo.Column("tagPaths", "TEXT", true, 0, (String) null, 1));
                hashMap21.put("taxValue", new TableInfo.Column("taxValue", "REAL", false, 0, (String) null, 1));
                hashMap21.put("minPrice", new TableInfo.Column("minPrice", "REAL", false, 0, (String) null, 1));
                hashMap21.put("excludeDiscount", new TableInfo.Column("excludeDiscount", "INTEGER", true, 0, (String) null, 1));
                hashMap21.put("excludeMarkup", new TableInfo.Column("excludeMarkup", "INTEGER", true, 0, (String) null, 1));
                hashMap21.put("cookingTime", new TableInfo.Column("cookingTime", "INTEGER", false, 0, (String) null, 1));
                hashMap21.put("barCode", new TableInfo.Column("barCode", "TEXT", false, 0, (String) null, 1));
                hashMap21.put("categoryName", new TableInfo.Column("categoryName", "TEXT", false, 0, (String) null, 1));
                hashMap21.put("unitWeight", new TableInfo.Column("unitWeight", "REAL", false, 0, (String) null, 1));
                hashMap21.put("gtin", new TableInfo.Column("gtin", "TEXT", false, 0, (String) null, 1));
                hashMap21.put("nomenclatureGuid", new TableInfo.Column("nomenclatureGuid", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo21 = new TableInfo("dish", hashMap21, new HashSet(0), new HashSet(0));
                TableInfo read21 = TableInfo.read(supportSQLiteDatabase2, "dish");
                if (!tableInfo21.equals(read21)) {
                    return new RoomOpenHelper.ValidationResult(false, "dish(ru.quickresto.terminal.client.database.DishDocument).\n Expected:\n" + tableInfo21 + "\n Found:\n" + read21);
                }
                HashMap hashMap22 = new HashMap(12);
                hashMap22.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                Object obj9 = obj3;
                hashMap22.put(obj9, new TableInfo.Column(LinkHeader.Parameters.Type, "TEXT", true, 0, (String) null, 1));
                hashMap22.put("amount", new TableInfo.Column("amount", "REAL", true, 0, (String) null, 1));
                hashMap22.put("replicationStatus", new TableInfo.Column("replicationStatus", "TEXT", true, 0, (String) null, 1));
                hashMap22.put("comment", new TableInfo.Column("comment", "TEXT", false, 0, (String) null, 1));
                hashMap22.put("timeEncashment", new TableInfo.Column("timeEncashment", "TEXT", true, 0, (String) null, 1));
                hashMap22.put("kkmDeviceId", new TableInfo.Column("kkmDeviceId", "TEXT", true, 0, (String) null, 1));
                hashMap22.put("shiftId", new TableInfo.Column("shiftId", "TEXT", false, 0, (String) null, 1));
                hashMap22.put(obj8, new TableInfo.Column("salePlaceId", "INTEGER", true, 0, (String) null, 1));
                hashMap22.put("emergency", new TableInfo.Column("emergency", "INTEGER", true, 0, (String) null, 1));
                hashMap22.put("employeeId", new TableInfo.Column("employeeId", "INTEGER", true, 0, (String) null, 1));
                hashMap22.put("documentShiftId", new TableInfo.Column("documentShiftId", "TEXT", true, 0, (String) null, 1));
                TableInfo tableInfo22 = new TableInfo("encashment", hashMap22, new HashSet(0), new HashSet(0));
                TableInfo read22 = TableInfo.read(supportSQLiteDatabase2, "encashment");
                if (!tableInfo22.equals(read22)) {
                    return new RoomOpenHelper.ValidationResult(false, "encashment(ru.quickresto.terminal.client.database.EncashmentDocument).\n Expected:\n" + tableInfo22 + "\n Found:\n" + read22);
                }
                HashMap hashMap23 = new HashMap(11);
                hashMap23.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap23.put("name", new TableInfo.Column("name", "TEXT", true, 0, (String) null, 1));
                hashMap23.put(obj9, new TableInfo.Column(LinkHeader.Parameters.Type, "TEXT", true, 0, (String) null, 1));
                hashMap23.put("kind", new TableInfo.Column("kind", "TEXT", true, 0, (String) null, 1));
                hashMap23.put("value", new TableInfo.Column("value", "REAL", true, 0, (String) null, 1));
                hashMap23.put("dishes", new TableInfo.Column("dishes", "TEXT", true, 0, (String) null, 1));
                hashMap23.put("tags", new TableInfo.Column("tags", "TEXT", true, 0, (String) null, 1));
                hashMap23.put("dishesGroups", new TableInfo.Column("dishesGroups", "TEXT", true, 0, (String) null, 1));
                hashMap23.put("modifiersGroups", new TableInfo.Column("modifiersGroups", "TEXT", true, 0, (String) null, 1));
                hashMap23.put("salePlaces", new TableInfo.Column("salePlaces", "TEXT", true, 0, (String) null, 1));
                hashMap23.put("deleted", new TableInfo.Column("deleted", "INTEGER", true, 0, (String) null, 1));
                Object obj10 = "organizationId";
                TableInfo tableInfo23 = new TableInfo("fixedDiscount", hashMap23, new HashSet(0), new HashSet(0));
                TableInfo read23 = TableInfo.read(supportSQLiteDatabase2, "fixedDiscount");
                if (!tableInfo23.equals(read23)) {
                    return new RoomOpenHelper.ValidationResult(false, "fixedDiscount(ru.quickresto.terminal.client.database.FixedDiscountDocument).\n Expected:\n" + tableInfo23 + "\n Found:\n" + read23);
                }
                HashMap hashMap24 = new HashMap(12);
                hashMap24.put("activeConditions", new TableInfo.Column("activeConditions", "TEXT", true, 0, (String) null, 1));
                hashMap24.put("id", new TableInfo.Column("id", "INTEGER", false, 1, (String) null, 1));
                hashMap24.put("name", new TableInfo.Column("name", "TEXT", false, 0, (String) null, 1));
                hashMap24.put("start", new TableInfo.Column("start", "TEXT", false, 0, (String) null, 1));
                hashMap24.put("end", new TableInfo.Column("end", "TEXT", false, 0, (String) null, 1));
                hashMap24.put(FirebaseAnalytics.Param.QUANTITY, new TableInfo.Column(FirebaseAnalytics.Param.QUANTITY, "REAL", false, 0, (String) null, 1));
                hashMap24.put("dishesFilters", new TableInfo.Column("dishesFilters", "TEXT", true, 0, (String) null, 1));
                hashMap24.put("weeklySchedule", new TableInfo.Column("weeklySchedule", "TEXT", true, 0, (String) null, 1));
                hashMap24.put("discountValue", new TableInfo.Column("discountValue", "REAL", false, 0, (String) null, 1));
                hashMap24.put("salePlaces", new TableInfo.Column("salePlaces", "TEXT", true, 0, (String) null, 1));
                hashMap24.put("deleted", new TableInfo.Column("deleted", "INTEGER", true, 0, (String) null, 1));
                hashMap24.put("crmGroups", new TableInfo.Column("crmGroups", "TEXT", true, 0, (String) null, 1));
                TableInfo tableInfo24 = new TableInfo("comboOffers", hashMap24, new HashSet(0), new HashSet(0));
                TableInfo read24 = TableInfo.read(supportSQLiteDatabase2, "comboOffers");
                if (!tableInfo24.equals(read24)) {
                    return new RoomOpenHelper.ValidationResult(false, "comboOffers(ru.quickresto.terminal.client.database.ComboDocument).\n Expected:\n" + tableInfo24 + "\n Found:\n" + read24);
                }
                HashMap hashMap25 = new HashMap(10);
                hashMap25.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap25.put("name", new TableInfo.Column("name", "TEXT", true, 0, (String) null, 1));
                hashMap25.put(obj9, new TableInfo.Column(LinkHeader.Parameters.Type, "TEXT", true, 0, (String) null, 1));
                hashMap25.put("value", new TableInfo.Column("value", "REAL", true, 0, (String) null, 1));
                hashMap25.put("dishes", new TableInfo.Column("dishes", "TEXT", true, 0, (String) null, 1));
                hashMap25.put("tags", new TableInfo.Column("tags", "TEXT", true, 0, (String) null, 1));
                hashMap25.put("dishesGroups", new TableInfo.Column("dishesGroups", "TEXT", true, 0, (String) null, 1));
                hashMap25.put("modifiersGroups", new TableInfo.Column("modifiersGroups", "TEXT", true, 0, (String) null, 1));
                hashMap25.put("salePlaces", new TableInfo.Column("salePlaces", "TEXT", true, 0, (String) null, 1));
                hashMap25.put("deleted", new TableInfo.Column("deleted", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo25 = new TableInfo("fixedMarkup", hashMap25, new HashSet(0), new HashSet(0));
                TableInfo read25 = TableInfo.read(supportSQLiteDatabase2, "fixedMarkup");
                if (!tableInfo25.equals(read25)) {
                    return new RoomOpenHelper.ValidationResult(false, "fixedMarkup(ru.quickresto.terminal.client.database.FixedMarkupDocument).\n Expected:\n" + tableInfo25 + "\n Found:\n" + read25);
                }
                HashMap hashMap26 = new HashMap(5);
                hashMap26.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap26.put("deleted", new TableInfo.Column("deleted", "INTEGER", true, 0, (String) null, 1));
                hashMap26.put("name", new TableInfo.Column("name", "TEXT", true, 0, (String) null, 1));
                hashMap26.put("useComment", new TableInfo.Column("useComment", "INTEGER", true, 0, (String) null, 1));
                hashMap26.put("withdrawFromStore", new TableInfo.Column("withdrawFromStore", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo26 = new TableInfo("cancellationReason", hashMap26, new HashSet(0), new HashSet(0));
                TableInfo read26 = TableInfo.read(supportSQLiteDatabase2, "cancellationReason");
                if (!tableInfo26.equals(read26)) {
                    return new RoomOpenHelper.ValidationResult(false, "cancellationReason(ru.quickresto.terminal.client.database.CancellationReasonDocument).\n Expected:\n" + tableInfo26 + "\n Found:\n" + read26);
                }
                HashMap hashMap27 = new HashMap(3);
                hashMap27.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap27.put(LinkHeader.Parameters.Title, new TableInfo.Column(LinkHeader.Parameters.Title, "TEXT", true, 0, (String) null, 1));
                hashMap27.put("deleted", new TableInfo.Column("deleted", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo27 = new TableInfo("tag", hashMap27, new HashSet(0), new HashSet(0));
                TableInfo read27 = TableInfo.read(supportSQLiteDatabase2, "tag");
                if (!tableInfo27.equals(read27)) {
                    return new RoomOpenHelper.ValidationResult(false, "tag(ru.quickresto.terminal.client.database.TagDocument).\n Expected:\n" + tableInfo27 + "\n Found:\n" + read27);
                }
                HashMap hashMap28 = new HashMap(14);
                hashMap28.put("triggerThreshold", new TableInfo.Column("triggerThreshold", "REAL", true, 0, (String) null, 1));
                hashMap28.put("conditionType", new TableInfo.Column("conditionType", "TEXT", true, 0, (String) null, 1));
                hashMap28.put("specialOfferAccountTypeId", new TableInfo.Column("specialOfferAccountTypeId", "INTEGER", false, 0, (String) null, 1));
                hashMap28.put("id", new TableInfo.Column("id", "INTEGER", false, 1, (String) null, 1));
                hashMap28.put("name", new TableInfo.Column("name", "TEXT", false, 0, (String) null, 1));
                hashMap28.put("start", new TableInfo.Column("start", "TEXT", false, 0, (String) null, 1));
                hashMap28.put("end", new TableInfo.Column("end", "TEXT", false, 0, (String) null, 1));
                hashMap28.put(FirebaseAnalytics.Param.QUANTITY, new TableInfo.Column(FirebaseAnalytics.Param.QUANTITY, "REAL", false, 0, (String) null, 1));
                hashMap28.put("dishesFilters", new TableInfo.Column("dishesFilters", "TEXT", true, 0, (String) null, 1));
                hashMap28.put("weeklySchedule", new TableInfo.Column("weeklySchedule", "TEXT", true, 0, (String) null, 1));
                hashMap28.put("discountValue", new TableInfo.Column("discountValue", "REAL", false, 0, (String) null, 1));
                hashMap28.put("salePlaces", new TableInfo.Column("salePlaces", "TEXT", true, 0, (String) null, 1));
                hashMap28.put("deleted", new TableInfo.Column("deleted", "INTEGER", true, 0, (String) null, 1));
                hashMap28.put("crmGroups", new TableInfo.Column("crmGroups", "TEXT", true, 0, (String) null, 1));
                TableInfo tableInfo28 = new TableInfo("specialSet", hashMap28, new HashSet(0), new HashSet(0));
                TableInfo read28 = TableInfo.read(supportSQLiteDatabase2, "specialSet");
                if (!tableInfo28.equals(read28)) {
                    return new RoomOpenHelper.ValidationResult(false, "specialSet(ru.quickresto.terminal.client.database.SpecialSetDocument).\n Expected:\n" + tableInfo28 + "\n Found:\n" + read28);
                }
                HashMap hashMap29 = new HashMap(18);
                hashMap29.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                hashMap29.put("replicationStatus", new TableInfo.Column("replicationStatus", "TEXT", true, 0, (String) null, 1));
                hashMap29.put("syncTime", new TableInfo.Column("syncTime", "TEXT", false, 0, (String) null, 1));
                hashMap29.put("shiftNumber", new TableInfo.Column("shiftNumber", "INTEGER", false, 0, (String) null, 1));
                hashMap29.put("shiftId", new TableInfo.Column("shiftId", "TEXT", false, 0, (String) null, 1));
                hashMap29.put("openUserId", new TableInfo.Column("openUserId", "INTEGER", true, 0, (String) null, 1));
                hashMap29.put("kkmId", new TableInfo.Column("kkmId", "TEXT", true, 0, (String) null, 1));
                hashMap29.put(obj7, new TableInfo.Column("deviceId", "TEXT", false, 0, (String) null, 1));
                hashMap29.put("deviceType", new TableInfo.Column("deviceType", "TEXT", true, 0, (String) null, 1));
                hashMap29.put("actionType", new TableInfo.Column("actionType", "TEXT", true, 0, (String) null, 1));
                hashMap29.put("closeShiftRequest", new TableInfo.Column("closeShiftRequest", "TEXT", false, 0, (String) null, 1));
                Object obj11 = obj6;
                hashMap29.put(obj11, new TableInfo.Column("createTime", "TEXT", true, 0, (String) null, 1));
                hashMap29.put("openedTime", new TableInfo.Column("openedTime", "TEXT", false, 0, (String) null, 1));
                hashMap29.put(obj8, new TableInfo.Column("salePlaceId", "INTEGER", false, 0, (String) null, 1));
                hashMap29.put("sellCounters", new TableInfo.Column("sellCounters", "TEXT", false, 0, (String) null, 1));
                hashMap29.put("nonFiscalCounters", new TableInfo.Column("nonFiscalCounters", "TEXT", false, 0, (String) null, 1));
                hashMap29.put("writeOffCounters", new TableInfo.Column("writeOffCounters", "TEXT", false, 0, (String) null, 1));
                hashMap29.put("registerValues", new TableInfo.Column("registerValues", "TEXT", false, 0, (String) null, 1));
                String str2 = str;
                TableInfo tableInfo29 = new TableInfo(str2, hashMap29, new HashSet(0), new HashSet(0));
                TableInfo read29 = TableInfo.read(supportSQLiteDatabase2, str2);
                if (!tableInfo29.equals(read29)) {
                    return new RoomOpenHelper.ValidationResult(false, "shift(ru.quickresto.terminal.client.database.ShiftDocument).\n Expected:\n" + tableInfo29 + "\n Found:\n" + read29);
                }
                HashMap hashMap30 = new HashMap(25);
                hashMap30.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                hashMap30.put("tableOrderDocumentId", new TableInfo.Column("tableOrderDocumentId", "TEXT", true, 0, (String) null, 1));
                hashMap30.put("guestIdxes", new TableInfo.Column("guestIdxes", "TEXT", true, 0, (String) null, 1));
                hashMap30.put(FirebaseAnalytics.Param.ITEMS, new TableInfo.Column(FirebaseAnalytics.Param.ITEMS, "TEXT", true, 0, (String) null, 1));
                hashMap30.put("replicationStatus", new TableInfo.Column("replicationStatus", "TEXT", false, 0, (String) null, 1));
                hashMap30.put("syncTime", new TableInfo.Column("syncTime", "TEXT", false, 0, (String) null, 1));
                hashMap30.put("paymentTransactions", new TableInfo.Column("paymentTransactions", "TEXT", true, 0, (String) null, 1));
                hashMap30.put("receipt", new TableInfo.Column("receipt", "TEXT", false, 0, (String) null, 1));
                hashMap30.put("atolReceiptResponse", new TableInfo.Column("atolReceiptResponse", "TEXT", false, 0, (String) null, 1));
                hashMap30.put("atolReturnResponse", new TableInfo.Column("atolReturnResponse", "TEXT", false, 0, (String) null, 1));
                hashMap30.put("returned", new TableInfo.Column("returned", "INTEGER", true, 0, (String) null, 1));
                hashMap30.put("updatable", new TableInfo.Column("updatable", "INTEGER", true, 0, (String) null, 1));
                hashMap30.put("returnedComment", new TableInfo.Column("returnedComment", "TEXT", false, 0, (String) null, 1));
                hashMap30.put("priceModifiers", new TableInfo.Column("priceModifiers", "TEXT", true, 0, (String) null, 1));
                hashMap30.put("customerPriceModifiers", new TableInfo.Column("customerPriceModifiers", "TEXT", true, 0, (String) null, 1));
                hashMap30.put("comments", new TableInfo.Column("comments", "TEXT", true, 0, (String) null, 1));
                hashMap30.put("customerSnapshots", new TableInfo.Column("customerSnapshots", "TEXT", true, 0, (String) null, 1));
                hashMap30.put("totalSum", new TableInfo.Column("totalSum", "REAL", true, 0, (String) null, 1));
                hashMap30.put("removed", new TableInfo.Column("removed", "INTEGER", true, 0, (String) null, 1));
                hashMap30.put("deliveryItem", new TableInfo.Column("deliveryItem", "TEXT", false, 0, (String) null, 1));
                hashMap30.put("orderDueDateDelta", new TableInfo.Column("orderDueDateDelta", "INTEGER", true, 0, (String) null, 1));
                hashMap30.put("courierCheckPrinted", new TableInfo.Column("courierCheckPrinted", "INTEGER", true, 0, (String) null, 1));
                hashMap30.put("promoCodes", new TableInfo.Column("promoCodes", "TEXT", true, 0, (String) null, 1));
                hashMap30.put("bonusTransactions", new TableInfo.Column("bonusTransactions", "TEXT", true, 0, (String) null, 1));
                hashMap30.put("customerSnapshot", new TableInfo.Column("customerSnapshot", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo30 = new TableInfo("ordersV2", hashMap30, new HashSet(0), new HashSet(0));
                TableInfo read30 = TableInfo.read(supportSQLiteDatabase2, "ordersV2");
                if (!tableInfo30.equals(read30)) {
                    return new RoomOpenHelper.ValidationResult(false, "ordersV2(ru.quickresto.terminal.client.database.OrderDocumentV2).\n Expected:\n" + tableInfo30 + "\n Found:\n" + read30);
                }
                HashMap hashMap31 = new HashMap(28);
                hashMap31.put("terminalId", new TableInfo.Column("terminalId", "TEXT", true, 0, (String) null, 1));
                hashMap31.put("kkmId", new TableInfo.Column("kkmId", "TEXT", false, 0, (String) null, 1));
                hashMap31.put("kkmManufacturerDeviceId", new TableInfo.Column("kkmManufacturerDeviceId", "TEXT", false, 0, (String) null, 1));
                hashMap31.put("openedUser", new TableInfo.Column("openedUser", "TEXT", true, 0, (String) null, 1));
                hashMap31.put("waiterUser", new TableInfo.Column("waiterUser", "TEXT", true, 0, (String) null, 1));
                hashMap31.put("closedUser", new TableInfo.Column("closedUser", "TEXT", false, 0, (String) null, 1));
                hashMap31.put(obj11, new TableInfo.Column("createTime", "TEXT", true, 0, (String) null, 1));
                hashMap31.put("localTimezoneOffsetMin", new TableInfo.Column("localTimezoneOffsetMin", "INTEGER", true, 0, (String) null, 1));
                hashMap31.put("updateTime", new TableInfo.Column("updateTime", "TEXT", true, 0, (String) null, 1));
                hashMap31.put("guestCount", new TableInfo.Column("guestCount", "INTEGER", false, 0, (String) null, 1));
                hashMap31.put("tableId", new TableInfo.Column("tableId", "INTEGER", false, 0, (String) null, 1));
                hashMap31.put("originalTableId", new TableInfo.Column("originalTableId", "INTEGER", false, 0, (String) null, 1));
                Object obj12 = obj5;
                hashMap31.put(obj12, new TableInfo.Column(NotificationCompat.CATEGORY_STATUS, "TEXT", true, 0, (String) null, 1));
                hashMap31.put("waiterName", new TableInfo.Column("waiterName", "TEXT", false, 0, (String) null, 1));
                hashMap31.put("tableName", new TableInfo.Column("tableName", "TEXT", false, 0, (String) null, 1));
                hashMap31.put("floorName", new TableInfo.Column("floorName", "TEXT", false, 0, (String) null, 1));
                hashMap31.put("comment", new TableInfo.Column("comment", "TEXT", false, 0, (String) null, 1));
                hashMap31.put("shiftId", new TableInfo.Column("shiftId", "TEXT", false, 0, (String) null, 1));
                hashMap31.put("shiftDocumentId", new TableInfo.Column("shiftDocumentId", "TEXT", false, 0, (String) null, 1));
                Object obj13 = obj10;
                hashMap31.put(obj13, new TableInfo.Column("organizationId", "INTEGER", true, 0, (String) null, 1));
                hashMap31.put("organizationName", new TableInfo.Column("organizationName", "TEXT", false, 0, (String) null, 1));
                hashMap31.put("organizationInn", new TableInfo.Column("organizationInn", "TEXT", false, 0, (String) null, 1));
                hashMap31.put("number", new TableInfo.Column("number", "TEXT", true, 0, (String) null, 1));
                hashMap31.put("basicPriceModifiers", new TableInfo.Column("basicPriceModifiers", "TEXT", true, 0, (String) null, 1));
                hashMap31.put("createLocalDate", new TableInfo.Column("createLocalDate", "TEXT", true, 0, (String) null, 1));
                hashMap31.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                hashMap31.put("onlineOfferId", new TableInfo.Column("onlineOfferId", "TEXT", false, 0, (String) null, 1));
                hashMap31.put("delivery", new TableInfo.Column("delivery", "TEXT", false, 0, (String) null, 1));
                Object obj14 = obj11;
                TableInfo tableInfo31 = new TableInfo("tableOrders", hashMap31, new HashSet(0), new HashSet(0));
                TableInfo read31 = TableInfo.read(supportSQLiteDatabase2, "tableOrders");
                if (!tableInfo31.equals(read31)) {
                    return new RoomOpenHelper.ValidationResult(false, "tableOrders(ru.quickresto.terminal.client.database.TableOrderDocument).\n Expected:\n" + tableInfo31 + "\n Found:\n" + read31);
                }
                HashMap hashMap32 = new HashMap(22);
                hashMap32.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                hashMap32.put("tableOrderId", new TableInfo.Column("tableOrderId", "TEXT", true, 0, (String) null, 1));
                hashMap32.put("subOrderId", new TableInfo.Column("subOrderId", "TEXT", true, 0, (String) null, 1));
                hashMap32.put("guestIdxes", new TableInfo.Column("guestIdxes", "TEXT", true, 0, (String) null, 1));
                hashMap32.put("waiterId", new TableInfo.Column("waiterId", "INTEGER", true, 0, (String) null, 1));
                hashMap32.put("cashierId", new TableInfo.Column("cashierId", "INTEGER", true, 0, (String) null, 1));
                hashMap32.put("cancellerId", new TableInfo.Column("cancellerId", "INTEGER", false, 0, (String) null, 1));
                hashMap32.put("printDeviceId", new TableInfo.Column("printDeviceId", "TEXT", false, 0, (String) null, 1));
                hashMap32.put("localPrintDate", new TableInfo.Column("localPrintDate", "TEXT", true, 0, (String) null, 1));
                hashMap32.put("localTimezoneOffsetMin", new TableInfo.Column("localTimezoneOffsetMin", "INTEGER", true, 0, (String) null, 1));
                hashMap32.put(obj12, new TableInfo.Column(NotificationCompat.CATEGORY_STATUS, "TEXT", true, 0, (String) null, 1));
                hashMap32.put("replicationStatus", new TableInfo.Column("replicationStatus", "TEXT", true, 0, (String) null, 1));
                hashMap32.put("cancellationReason", new TableInfo.Column("cancellationReason", "TEXT", false, 0, (String) null, 1));
                hashMap32.put(FirebaseAnalytics.Param.ITEMS, new TableInfo.Column(FirebaseAnalytics.Param.ITEMS, "TEXT", true, 0, (String) null, 1));
                hashMap32.put("baseSum", new TableInfo.Column("baseSum", "REAL", true, 0, (String) null, 1));
                hashMap32.put("sumWithDiscount", new TableInfo.Column("sumWithDiscount", "REAL", true, 0, (String) null, 1));
                hashMap32.put("totalDiscount", new TableInfo.Column("totalDiscount", "REAL", true, 0, (String) null, 1));
                hashMap32.put("markupSum", new TableInfo.Column("markupSum", "REAL", true, 0, (String) null, 1));
                hashMap32.put("terminalSalePlaceId", new TableInfo.Column("terminalSalePlaceId", "INTEGER", false, 0, (String) null, 1));
                hashMap32.put("tableId", new TableInfo.Column("tableId", "INTEGER", false, 0, (String) null, 1));
                hashMap32.put("terminalId", new TableInfo.Column("terminalId", "TEXT", true, 0, (String) null, 1));
                hashMap32.put("fictitious", new TableInfo.Column("fictitious", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo32 = new TableInfo("preorderInfo", hashMap32, new HashSet(0), new HashSet(0));
                TableInfo read32 = TableInfo.read(supportSQLiteDatabase2, "preorderInfo");
                if (!tableInfo32.equals(read32)) {
                    return new RoomOpenHelper.ValidationResult(false, "preorderInfo(ru.quickresto.terminal.client.database.PreorderDocument).\n Expected:\n" + tableInfo32 + "\n Found:\n" + read32);
                }
                HashMap hashMap33 = new HashMap(3);
                hashMap33.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap33.put("tableSchemeId", new TableInfo.Column("tableSchemeId", "INTEGER", true, 0, (String) null, 1));
                hashMap33.put("stopListDishes", new TableInfo.Column("stopListDishes", "TEXT", true, 0, (String) null, 1));
                TableInfo tableInfo33 = new TableInfo("soldout", hashMap33, new HashSet(0), new HashSet(0));
                TableInfo read33 = TableInfo.read(supportSQLiteDatabase2, "soldout");
                if (!tableInfo33.equals(read33)) {
                    return new RoomOpenHelper.ValidationResult(false, "soldout(ru.quickresto.terminal.client.database.SoldoutListDocument).\n Expected:\n" + tableInfo33 + "\n Found:\n" + read33);
                }
                HashMap hashMap34 = new HashMap(5);
                hashMap34.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap34.put("deleted", new TableInfo.Column("deleted", "INTEGER", true, 0, (String) null, 1));
                hashMap34.put("abbreviation", new TableInfo.Column("abbreviation", "TEXT", true, 0, (String) null, 1));
                hashMap34.put("name", new TableInfo.Column("name", "TEXT", true, 0, (String) null, 1));
                hashMap34.put("currencySign", new TableInfo.Column("currencySign", "TEXT", true, 0, (String) null, 1));
                TableInfo tableInfo34 = new TableInfo(FirebaseAnalytics.Param.CURRENCY, hashMap34, new HashSet(0), new HashSet(0));
                TableInfo read34 = TableInfo.read(supportSQLiteDatabase2, FirebaseAnalytics.Param.CURRENCY);
                if (!tableInfo34.equals(read34)) {
                    return new RoomOpenHelper.ValidationResult(false, "currency(ru.quickresto.terminal.client.database.CurrencyDocument).\n Expected:\n" + tableInfo34 + "\n Found:\n" + read34);
                }
                HashMap hashMap35 = new HashMap(19);
                hashMap35.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap35.put("name", new TableInfo.Column("name", "TEXT", true, 0, (String) null, 1));
                hashMap35.put(obj9, new TableInfo.Column(LinkHeader.Parameters.Type, "TEXT", true, 0, (String) null, 1));
                hashMap35.put("kind", new TableInfo.Column("kind", "TEXT", true, 0, (String) null, 1));
                hashMap35.put("value", new TableInfo.Column("value", "REAL", true, 0, (String) null, 1));
                hashMap35.put("cancellable", new TableInfo.Column("cancellable", "INTEGER", true, 0, (String) null, 1));
                hashMap35.put("weeklySchedule", new TableInfo.Column("weeklySchedule", "TEXT", true, 0, (String) null, 1));
                hashMap35.put("startDate", new TableInfo.Column("startDate", "TEXT", true, 0, (String) null, 1));
                hashMap35.put("endDate", new TableInfo.Column("endDate", "TEXT", true, 0, (String) null, 1));
                hashMap35.put("dishes", new TableInfo.Column("dishes", "TEXT", true, 0, (String) null, 1));
                hashMap35.put("tags", new TableInfo.Column("tags", "TEXT", true, 0, (String) null, 1));
                hashMap35.put("dishesGroups", new TableInfo.Column("dishesGroups", "TEXT", true, 0, (String) null, 1));
                hashMap35.put("salePlaces", new TableInfo.Column("salePlaces", "TEXT", true, 0, (String) null, 1));
                hashMap35.put("deleted", new TableInfo.Column("deleted", "INTEGER", true, 0, (String) null, 1));
                hashMap35.put("promoCustomerId", new TableInfo.Column("promoCustomerId", "INTEGER", false, 0, (String) null, 1));
                hashMap35.put("promoAccountTypeId", new TableInfo.Column("promoAccountTypeId", "INTEGER", false, 0, (String) null, 1));
                hashMap35.put("preorderOnly", new TableInfo.Column("preorderOnly", "INTEGER", true, 0, (String) null, 1));
                hashMap35.put("thresholdValue", new TableInfo.Column("thresholdValue", "REAL", false, 0, (String) null, 1));
                hashMap35.put("calcAfterDiscountsApplied", new TableInfo.Column("calcAfterDiscountsApplied", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo35 = new TableInfo("scheduledDiscount", hashMap35, new HashSet(0), new HashSet(0));
                TableInfo read35 = TableInfo.read(supportSQLiteDatabase2, "scheduledDiscount");
                if (!tableInfo35.equals(read35)) {
                    return new RoomOpenHelper.ValidationResult(false, "scheduledDiscount(ru.quickresto.terminal.client.database.ScheduledDiscountDocument).\n Expected:\n" + tableInfo35 + "\n Found:\n" + read35);
                }
                HashMap hashMap36 = new HashMap(13);
                hashMap36.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap36.put("createDate", new TableInfo.Column("createDate", "TEXT", true, 0, (String) null, 1));
                hashMap36.put("refId", new TableInfo.Column("refId", "TEXT", true, 0, (String) null, 1));
                hashMap36.put("offerStatus", new TableInfo.Column("offerStatus", "TEXT", true, 0, (String) null, 1));
                hashMap36.put("paystatus", new TableInfo.Column("paystatus", "TEXT", true, 0, (String) null, 1));
                hashMap36.put("cancellationaccepted", new TableInfo.Column("cancellationaccepted", "INTEGER", true, 0, (String) null, 1));
                hashMap36.put("version", new TableInfo.Column("version", "INTEGER", true, 0, (String) null, 1));
                hashMap36.put("cancellationComment", new TableInfo.Column("cancellationComment", "TEXT", false, 0, (String) null, 1));
                hashMap36.put("data", new TableInfo.Column("data", "TEXT", true, 0, (String) null, 1));
                hashMap36.put("replicationStatus", new TableInfo.Column("replicationStatus", "TEXT", false, 0, (String) null, 1));
                hashMap36.put("wlPreOrderStatus", new TableInfo.Column("wlPreOrderStatus", "TEXT", true, 0, (String) null, 1));
                hashMap36.put("deliveryAmount", new TableInfo.Column("deliveryAmount", "REAL", false, 0, (String) null, 1));
                hashMap36.put("ownerRefId", new TableInfo.Column("ownerRefId", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo36 = new TableInfo("onlineOffers", hashMap36, new HashSet(0), new HashSet(0));
                TableInfo read36 = TableInfo.read(supportSQLiteDatabase2, "onlineOffers");
                if (!tableInfo36.equals(read36)) {
                    return new RoomOpenHelper.ValidationResult(false, "onlineOffers(ru.quickresto.terminal.client.database.OnlineOfferDocument).\n Expected:\n" + tableInfo36 + "\n Found:\n" + read36);
                }
                HashMap hashMap37 = new HashMap(3);
                hashMap37.put("tenantId", new TableInfo.Column("tenantId", "TEXT", true, 1, (String) null, 1));
                hashMap37.put("layerStopTime", new TableInfo.Column("layerStopTime", "TEXT", false, 0, (String) null, 1));
                hashMap37.put("timeZone", new TableInfo.Column("timeZone", "TEXT", true, 0, (String) null, 1));
                TableInfo tableInfo37 = new TableInfo("sysExtras", hashMap37, new HashSet(0), new HashSet(0));
                TableInfo read37 = TableInfo.read(supportSQLiteDatabase2, "sysExtras");
                if (!tableInfo37.equals(read37)) {
                    return new RoomOpenHelper.ValidationResult(false, "sysExtras(ru.quickresto.terminal.client.database.SysExtrasDocument).\n Expected:\n" + tableInfo37 + "\n Found:\n" + read37);
                }
                HashMap hashMap38 = new HashMap(3);
                hashMap38.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap38.put("encodedCredentials", new TableInfo.Column("encodedCredentials", "TEXT", true, 0, (String) null, 1));
                hashMap38.put("serverUri", new TableInfo.Column("serverUri", "TEXT", true, 0, (String) null, 1));
                TableInfo tableInfo38 = new TableInfo("onlineInterface", hashMap38, new HashSet(0), new HashSet(0));
                TableInfo read38 = TableInfo.read(supportSQLiteDatabase2, "onlineInterface");
                if (!tableInfo38.equals(read38)) {
                    return new RoomOpenHelper.ValidationResult(false, "onlineInterface(ru.quickresto.terminal.client.database.OnlineInterfaceDocument).\n Expected:\n" + tableInfo38 + "\n Found:\n" + read38);
                }
                HashMap hashMap39 = new HashMap(2);
                hashMap39.put("name", new TableInfo.Column("name", "TEXT", true, 1, (String) null, 1));
                hashMap39.put("data", new TableInfo.Column("data", "TEXT", true, 0, (String) null, 1));
                TableInfo tableInfo39 = new TableInfo("template", hashMap39, new HashSet(0), new HashSet(0));
                TableInfo read39 = TableInfo.read(supportSQLiteDatabase2, "template");
                if (!tableInfo39.equals(read39)) {
                    return new RoomOpenHelper.ValidationResult(false, "template(ru.quickresto.terminal.client.database.TemplateDocument).\n Expected:\n" + tableInfo39 + "\n Found:\n" + read39);
                }
                HashMap hashMap40 = new HashMap(3);
                hashMap40.put("name", new TableInfo.Column("name", "TEXT", true, 1, (String) null, 1));
                hashMap40.put("data", new TableInfo.Column("data", "BLOB", true, 0, (String) null, 1));
                hashMap40.put("typeTemplate", new TableInfo.Column("typeTemplate", "TEXT", true, 0, (String) null, 1));
                TableInfo tableInfo40 = new TableInfo("image", hashMap40, new HashSet(0), new HashSet(0));
                TableInfo read40 = TableInfo.read(supportSQLiteDatabase2, "image");
                if (!tableInfo40.equals(read40)) {
                    return new RoomOpenHelper.ValidationResult(false, "image(ru.quickresto.terminal.client.database.ImageDocument).\n Expected:\n" + tableInfo40 + "\n Found:\n" + read40);
                }
                HashMap hashMap41 = new HashMap(5);
                hashMap41.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap41.put("name", new TableInfo.Column("name", "TEXT", true, 0, (String) null, 1));
                hashMap41.put("dishIdList", new TableInfo.Column("dishIdList", "TEXT", false, 0, (String) null, 1));
                hashMap41.put("salePlaceIdList", new TableInfo.Column("salePlaceIdList", "TEXT", false, 0, (String) null, 1));
                hashMap41.put("refId", new TableInfo.Column("refId", "TEXT", true, 0, (String) null, 1));
                TableInfo tableInfo41 = new TableInfo("menu", hashMap41, new HashSet(0), new HashSet(0));
                TableInfo read41 = TableInfo.read(supportSQLiteDatabase2, "menu");
                if (!tableInfo41.equals(read41)) {
                    return new RoomOpenHelper.ValidationResult(false, "menu(ru.quickresto.terminal.client.database.MenuDocument).\n Expected:\n" + tableInfo41 + "\n Found:\n" + read41);
                }
                HashMap hashMap42 = new HashMap(5);
                hashMap42.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                hashMap42.put(obj13, new TableInfo.Column("organizationId", "INTEGER", true, 0, (String) null, 1));
                Object obj15 = obj14;
                hashMap42.put(obj15, new TableInfo.Column("createTime", "TEXT", true, 0, (String) null, 1));
                hashMap42.put("hosts", new TableInfo.Column("hosts", "TEXT", true, 0, (String) null, 1));
                hashMap42.put("reasonAccident", new TableInfo.Column("reasonAccident", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo42 = new TableInfo("trueApi", hashMap42, new HashSet(0), new HashSet(0));
                TableInfo read42 = TableInfo.read(supportSQLiteDatabase2, "trueApi");
                if (!tableInfo42.equals(read42)) {
                    return new RoomOpenHelper.ValidationResult(false, "trueApi(ru.quickresto.terminal.client.database.TrueApiDocument).\n Expected:\n" + tableInfo42 + "\n Found:\n" + read42);
                }
                HashMap hashMap43 = new HashMap(11);
                hashMap43.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                hashMap43.put("orderDocumentId", new TableInfo.Column("orderDocumentId", "TEXT", true, 0, (String) null, 1));
                hashMap43.put("tableOrderDocumentId", new TableInfo.Column("tableOrderDocumentId", "TEXT", true, 0, (String) null, 1));
                hashMap43.put(obj13, new TableInfo.Column("organizationId", "INTEGER", true, 0, (String) null, 1));
                hashMap43.put(obj15, new TableInfo.Column("createTime", "TEXT", true, 0, (String) null, 1));
                hashMap43.put("responseTime", new TableInfo.Column("responseTime", "TEXT", false, 0, (String) null, 1));
                hashMap43.put(obj12, new TableInfo.Column(NotificationCompat.CATEGORY_STATUS, "TEXT", true, 0, (String) null, 1));
                hashMap43.put(obj9, new TableInfo.Column(LinkHeader.Parameters.Type, "TEXT", true, 0, (String) null, 1));
                hashMap43.put("request", new TableInfo.Column("request", "TEXT", false, 0, (String) null, 1));
                hashMap43.put("response", new TableInfo.Column("response", "TEXT", false, 0, (String) null, 1));
                hashMap43.put("error", new TableInfo.Column("error", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo43 = new TableInfo("dxBxTask", hashMap43, new HashSet(0), new HashSet(0));
                TableInfo read43 = TableInfo.read(supportSQLiteDatabase2, "dxBxTask");
                if (!tableInfo43.equals(read43)) {
                    return new RoomOpenHelper.ValidationResult(false, "dxBxTask(ru.quickresto.terminal.client.database.DxBxTaskDocument).\n Expected:\n" + tableInfo43 + "\n Found:\n" + read43);
                }
                return new RoomOpenHelper.ValidationResult(true, (String) null);
            }
        }, "62877b40e919f71777200cb6820bf78f", "3f41a5af08c4a4a1aeda18facd0fd8b9")).build());
    }

    /* access modifiers changed from: protected */
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "paymentType", "tableHash", ApplicationSettingsDocument.APPLICATION_SETTINGS_ID, "terminal", "kkmDevice", "posDevice", "virtualKkm", "virtualPos", "terminalUser", "tableScheme", "salePlace", "organization", "cookingPlaces", "orders__", "kitchenDisplays", "nomenclatureItemSale", "modifierGroup", "modifier", "modifierLink", "dishGroup", "dish", "encashment", "fixedDiscount", "comboOffers", "fixedMarkup", "cancellationReason", "tag", "specialSet", "shift", "ordersV2", "tableOrders", "preorderInfo", "soldout", FirebaseAnalytics.Param.CURRENCY, "scheduledDiscount", "onlineOffers", "sysExtras", "onlineInterface", "template", "image", "menu", "trueApi", "dxBxTask");
    }

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `paymentType`");
            writableDatabase.execSQL("DELETE FROM `tableHash`");
            writableDatabase.execSQL("DELETE FROM `applicationSettings`");
            writableDatabase.execSQL("DELETE FROM `terminal`");
            writableDatabase.execSQL("DELETE FROM `kkmDevice`");
            writableDatabase.execSQL("DELETE FROM `posDevice`");
            writableDatabase.execSQL("DELETE FROM `virtualKkm`");
            writableDatabase.execSQL("DELETE FROM `virtualPos`");
            writableDatabase.execSQL("DELETE FROM `terminalUser`");
            writableDatabase.execSQL("DELETE FROM `tableScheme`");
            writableDatabase.execSQL("DELETE FROM `salePlace`");
            writableDatabase.execSQL("DELETE FROM `organization`");
            writableDatabase.execSQL("DELETE FROM `cookingPlaces`");
            writableDatabase.execSQL("DELETE FROM `orders__`");
            writableDatabase.execSQL("DELETE FROM `kitchenDisplays`");
            writableDatabase.execSQL("DELETE FROM `nomenclatureItemSale`");
            writableDatabase.execSQL("DELETE FROM `modifierGroup`");
            writableDatabase.execSQL("DELETE FROM `modifier`");
            writableDatabase.execSQL("DELETE FROM `modifierLink`");
            writableDatabase.execSQL("DELETE FROM `dishGroup`");
            writableDatabase.execSQL("DELETE FROM `dish`");
            writableDatabase.execSQL("DELETE FROM `encashment`");
            writableDatabase.execSQL("DELETE FROM `fixedDiscount`");
            writableDatabase.execSQL("DELETE FROM `comboOffers`");
            writableDatabase.execSQL("DELETE FROM `fixedMarkup`");
            writableDatabase.execSQL("DELETE FROM `cancellationReason`");
            writableDatabase.execSQL("DELETE FROM `tag`");
            writableDatabase.execSQL("DELETE FROM `specialSet`");
            writableDatabase.execSQL("DELETE FROM `shift`");
            writableDatabase.execSQL("DELETE FROM `ordersV2`");
            writableDatabase.execSQL("DELETE FROM `tableOrders`");
            writableDatabase.execSQL("DELETE FROM `preorderInfo`");
            writableDatabase.execSQL("DELETE FROM `soldout`");
            writableDatabase.execSQL("DELETE FROM `currency`");
            writableDatabase.execSQL("DELETE FROM `scheduledDiscount`");
            writableDatabase.execSQL("DELETE FROM `onlineOffers`");
            writableDatabase.execSQL("DELETE FROM `sysExtras`");
            writableDatabase.execSQL("DELETE FROM `onlineInterface`");
            writableDatabase.execSQL("DELETE FROM `template`");
            writableDatabase.execSQL("DELETE FROM `image`");
            writableDatabase.execSQL("DELETE FROM `menu`");
            writableDatabase.execSQL("DELETE FROM `trueApi`");
            writableDatabase.execSQL("DELETE FROM `dxBxTask`");
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
        hashMap.put(PaymentTypeDocumentDao.class, PaymentTypeDocumentDao_Impl.getRequiredConverters());
        hashMap.put(TableHashDocumentDao.class, TableHashDocumentDao_Impl.getRequiredConverters());
        hashMap.put(ApplicationSettingsDocumentRepositoryImpl.ApplicationSettingsDocumentDao.class, ApplicationSettingsDocumentRepositoryImpl_ApplicationSettingsDocumentDao_Impl.getRequiredConverters());
        hashMap.put(TerminalDocumentDao.class, TerminalDocumentDao_Impl.getRequiredConverters());
        hashMap.put(KkmDeviceDocumentDao.class, KkmDeviceDocumentDao_Impl.getRequiredConverters());
        hashMap.put(PosDeviceDocumentDao.class, PosDeviceDocumentDao_Impl.getRequiredConverters());
        hashMap.put(VirtualKkmDeviceDocumentDao.class, VirtualKkmDeviceDocumentDao_Impl.getRequiredConverters());
        hashMap.put(VirtualPosDeviceDocumentDao.class, VirtualPosDeviceDocumentDao_Impl.getRequiredConverters());
        hashMap.put(TerminalUserDocumentDao.class, TerminalUserDocumentDao_Impl.getRequiredConverters());
        hashMap.put(TableSchemeDocumentDao.class, TableSchemeDocumentDao_Impl.getRequiredConverters());
        hashMap.put(SalePlaceDocumentDao.class, SalePlaceDocumentDao_Impl.getRequiredConverters());
        hashMap.put(OrganizationDocumentDao.class, OrganizationDocumentDao_Impl.getRequiredConverters());
        hashMap.put(CookingPlaceDocumentDao.class, CookingPlaceDocumentDao_Impl.getRequiredConverters());
        hashMap.put(OrderDocumentDao.class, OrderDocumentDao_Impl.getRequiredConverters());
        hashMap.put(OrderDocumentV2Dao.class, OrderDocumentV2Dao_AppDatabase_Impl.getRequiredConverters());
        hashMap.put(TableOrderDocumentDao.class, TableOrderDocumentDao_AppDatabase_Impl.getRequiredConverters());
        hashMap.put(KitchenDisplayDocumentDao.class, KitchenDisplayDocumentDao_Impl.getRequiredConverters());
        hashMap.put(NomenclatureItemSaleDocumentDao.class, NomenclatureItemSaleDocumentDao_Impl.getRequiredConverters());
        hashMap.put(ModifierGroupDocumentDao.class, ModifierGroupDocumentDao_Impl.getRequiredConverters());
        hashMap.put(ModifierDocumentDao.class, ModifierDocumentDao_Impl.getRequiredConverters());
        hashMap.put(ModifierLinkDocumentDao.class, ModifierLinkDocumentDao_Impl.getRequiredConverters());
        hashMap.put(DishGroupDocumentDao.class, DishGroupDocumentDao_Impl.getRequiredConverters());
        hashMap.put(DishDocumentDao.class, DishDocumentDao_Impl.getRequiredConverters());
        hashMap.put(EncashmentDocumentDao.class, EncashmentDocumentDao_AppDatabase_Impl.getRequiredConverters());
        hashMap.put(FixedDiscountDocumentDao.class, FixedDiscountDocumentDao_Impl.getRequiredConverters());
        hashMap.put(ComboDocumentDao.class, ComboDocumentDao_Impl.getRequiredConverters());
        hashMap.put(FixedMarkupDocumentDao.class, FixedMarkupDocumentDao_Impl.getRequiredConverters());
        hashMap.put(CancellationReasonDocumentRepositoryImpl.CancellationReasonDocumentDao.class, CancellationReasonDocumentRepositoryImpl_CancellationReasonDocumentDao_Impl.getRequiredConverters());
        hashMap.put(TagDocumentDao.class, TagDocumentDao_Impl.getRequiredConverters());
        hashMap.put(SpecialSetDocumentDao.class, SpecialSetDocumentDao_Impl.getRequiredConverters());
        hashMap.put(ShiftDocumentDao.class, ShiftDocumentDao_AppDatabase_Impl.getRequiredConverters());
        hashMap.put(PreorderInfoDocumentDao.class, PreorderInfoDocumentDao_AppDatabase_Impl.getRequiredConverters());
        hashMap.put(SoldoutListDocumentDao.class, SoldoutListDocumentDao_Impl.getRequiredConverters());
        hashMap.put(CurrencyDocumentDao.class, CurrencyDocumentDao_Impl.getRequiredConverters());
        hashMap.put(ScheduledDiscountDocumentDao.class, ScheduledDiscountDocumentDao_Impl.getRequiredConverters());
        hashMap.put(OnlineOfferDocumentDao.class, OnlineOfferDocumentDao_AppDatabase_Impl.getRequiredConverters());
        hashMap.put(SysExtrasDocumentDao.class, SysExtrasDocumentDao_Impl.getRequiredConverters());
        hashMap.put(OnlineInterfaceDocumentDao.class, OnlineInterfaceDocumentDao_Impl.getRequiredConverters());
        hashMap.put(TemplateDocumentDao.class, TemplateDocumentDao_Impl.getRequiredConverters());
        hashMap.put(ImageDocumentDao.class, ImageDocumentDao_Impl.getRequiredConverters());
        hashMap.put(MenuDocumentDao.class, MenuDocumentDao_Impl.getRequiredConverters());
        hashMap.put(TrueApiDocumentDao.class, TrueApiDocumentDao_Impl.getRequiredConverters());
        hashMap.put(DxBxTaskDocumentDao.class, DxBxTaskDocumentDao_Impl.getRequiredConverters());
        return hashMap;
    }

    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return Arrays.asList(new Migration[0]);
    }

    public PaymentTypeDocumentDao paymentTypeDocumentDao() {
        PaymentTypeDocumentDao paymentTypeDocumentDao;
        if (this._paymentTypeDocumentDao != null) {
            return this._paymentTypeDocumentDao;
        }
        synchronized (this) {
            if (this._paymentTypeDocumentDao == null) {
                this._paymentTypeDocumentDao = new PaymentTypeDocumentDao_Impl(this);
            }
            paymentTypeDocumentDao = this._paymentTypeDocumentDao;
        }
        return paymentTypeDocumentDao;
    }

    public TableHashDocumentDao tableHashDocumentDao() {
        TableHashDocumentDao tableHashDocumentDao;
        if (this._tableHashDocumentDao != null) {
            return this._tableHashDocumentDao;
        }
        synchronized (this) {
            if (this._tableHashDocumentDao == null) {
                this._tableHashDocumentDao = new TableHashDocumentDao_Impl(this);
            }
            tableHashDocumentDao = this._tableHashDocumentDao;
        }
        return tableHashDocumentDao;
    }

    public ApplicationSettingsDocumentRepositoryImpl.ApplicationSettingsDocumentDao applicationSettingsDocumentDao() {
        ApplicationSettingsDocumentRepositoryImpl.ApplicationSettingsDocumentDao applicationSettingsDocumentDao;
        if (this._applicationSettingsDocumentDao != null) {
            return this._applicationSettingsDocumentDao;
        }
        synchronized (this) {
            if (this._applicationSettingsDocumentDao == null) {
                this._applicationSettingsDocumentDao = new ApplicationSettingsDocumentRepositoryImpl_ApplicationSettingsDocumentDao_Impl(this);
            }
            applicationSettingsDocumentDao = this._applicationSettingsDocumentDao;
        }
        return applicationSettingsDocumentDao;
    }

    public TerminalDocumentDao terminalDocumentDao() {
        TerminalDocumentDao terminalDocumentDao;
        if (this._terminalDocumentDao != null) {
            return this._terminalDocumentDao;
        }
        synchronized (this) {
            if (this._terminalDocumentDao == null) {
                this._terminalDocumentDao = new TerminalDocumentDao_Impl(this);
            }
            terminalDocumentDao = this._terminalDocumentDao;
        }
        return terminalDocumentDao;
    }

    public KkmDeviceDocumentDao kkmDeviceDocumentDao() {
        KkmDeviceDocumentDao kkmDeviceDocumentDao;
        if (this._kkmDeviceDocumentDao != null) {
            return this._kkmDeviceDocumentDao;
        }
        synchronized (this) {
            if (this._kkmDeviceDocumentDao == null) {
                this._kkmDeviceDocumentDao = new KkmDeviceDocumentDao_Impl(this);
            }
            kkmDeviceDocumentDao = this._kkmDeviceDocumentDao;
        }
        return kkmDeviceDocumentDao;
    }

    public PosDeviceDocumentDao posDeviceDocumentDao() {
        PosDeviceDocumentDao posDeviceDocumentDao;
        if (this._posDeviceDocumentDao != null) {
            return this._posDeviceDocumentDao;
        }
        synchronized (this) {
            if (this._posDeviceDocumentDao == null) {
                this._posDeviceDocumentDao = new PosDeviceDocumentDao_Impl(this);
            }
            posDeviceDocumentDao = this._posDeviceDocumentDao;
        }
        return posDeviceDocumentDao;
    }

    public VirtualKkmDeviceDocumentDao virtualKkmDeviceDocumentDao() {
        VirtualKkmDeviceDocumentDao virtualKkmDeviceDocumentDao;
        if (this._virtualKkmDeviceDocumentDao != null) {
            return this._virtualKkmDeviceDocumentDao;
        }
        synchronized (this) {
            if (this._virtualKkmDeviceDocumentDao == null) {
                this._virtualKkmDeviceDocumentDao = new VirtualKkmDeviceDocumentDao_Impl(this);
            }
            virtualKkmDeviceDocumentDao = this._virtualKkmDeviceDocumentDao;
        }
        return virtualKkmDeviceDocumentDao;
    }

    public VirtualPosDeviceDocumentDao virtualPosDeviceDocumentDao() {
        VirtualPosDeviceDocumentDao virtualPosDeviceDocumentDao;
        if (this._virtualPosDeviceDocumentDao != null) {
            return this._virtualPosDeviceDocumentDao;
        }
        synchronized (this) {
            if (this._virtualPosDeviceDocumentDao == null) {
                this._virtualPosDeviceDocumentDao = new VirtualPosDeviceDocumentDao_Impl(this);
            }
            virtualPosDeviceDocumentDao = this._virtualPosDeviceDocumentDao;
        }
        return virtualPosDeviceDocumentDao;
    }

    public TerminalUserDocumentDao terminalUserDocumentDao() {
        TerminalUserDocumentDao terminalUserDocumentDao;
        if (this._terminalUserDocumentDao != null) {
            return this._terminalUserDocumentDao;
        }
        synchronized (this) {
            if (this._terminalUserDocumentDao == null) {
                this._terminalUserDocumentDao = new TerminalUserDocumentDao_Impl(this);
            }
            terminalUserDocumentDao = this._terminalUserDocumentDao;
        }
        return terminalUserDocumentDao;
    }

    public TableSchemeDocumentDao tableSchemeDocumentDao() {
        TableSchemeDocumentDao tableSchemeDocumentDao;
        if (this._tableSchemeDocumentDao != null) {
            return this._tableSchemeDocumentDao;
        }
        synchronized (this) {
            if (this._tableSchemeDocumentDao == null) {
                this._tableSchemeDocumentDao = new TableSchemeDocumentDao_Impl(this);
            }
            tableSchemeDocumentDao = this._tableSchemeDocumentDao;
        }
        return tableSchemeDocumentDao;
    }

    public SalePlaceDocumentDao salePlaceDocumentDao() {
        SalePlaceDocumentDao salePlaceDocumentDao;
        if (this._salePlaceDocumentDao != null) {
            return this._salePlaceDocumentDao;
        }
        synchronized (this) {
            if (this._salePlaceDocumentDao == null) {
                this._salePlaceDocumentDao = new SalePlaceDocumentDao_Impl(this);
            }
            salePlaceDocumentDao = this._salePlaceDocumentDao;
        }
        return salePlaceDocumentDao;
    }

    public OrganizationDocumentDao organizationDocumentDao() {
        OrganizationDocumentDao organizationDocumentDao;
        if (this._organizationDocumentDao != null) {
            return this._organizationDocumentDao;
        }
        synchronized (this) {
            if (this._organizationDocumentDao == null) {
                this._organizationDocumentDao = new OrganizationDocumentDao_Impl(this);
            }
            organizationDocumentDao = this._organizationDocumentDao;
        }
        return organizationDocumentDao;
    }

    public CookingPlaceDocumentDao cookingPlaceDocumentDao() {
        CookingPlaceDocumentDao cookingPlaceDocumentDao;
        if (this._cookingPlaceDocumentDao != null) {
            return this._cookingPlaceDocumentDao;
        }
        synchronized (this) {
            if (this._cookingPlaceDocumentDao == null) {
                this._cookingPlaceDocumentDao = new CookingPlaceDocumentDao_Impl(this);
            }
            cookingPlaceDocumentDao = this._cookingPlaceDocumentDao;
        }
        return cookingPlaceDocumentDao;
    }

    public OrderDocumentDao orderDocumentDao() {
        OrderDocumentDao orderDocumentDao;
        if (this._orderDocumentDao != null) {
            return this._orderDocumentDao;
        }
        synchronized (this) {
            if (this._orderDocumentDao == null) {
                this._orderDocumentDao = new OrderDocumentDao_Impl(this);
            }
            orderDocumentDao = this._orderDocumentDao;
        }
        return orderDocumentDao;
    }

    public OrderDocumentV2Dao orderDocumentV2Dao() {
        OrderDocumentV2Dao orderDocumentV2Dao;
        if (this._orderDocumentV2Dao != null) {
            return this._orderDocumentV2Dao;
        }
        synchronized (this) {
            if (this._orderDocumentV2Dao == null) {
                this._orderDocumentV2Dao = new OrderDocumentV2Dao_AppDatabase_Impl(this);
            }
            orderDocumentV2Dao = this._orderDocumentV2Dao;
        }
        return orderDocumentV2Dao;
    }

    public TableOrderDocumentDao tableOrderDocumentDao() {
        TableOrderDocumentDao tableOrderDocumentDao;
        if (this._tableOrderDocumentDao != null) {
            return this._tableOrderDocumentDao;
        }
        synchronized (this) {
            if (this._tableOrderDocumentDao == null) {
                this._tableOrderDocumentDao = new TableOrderDocumentDao_AppDatabase_Impl(this);
            }
            tableOrderDocumentDao = this._tableOrderDocumentDao;
        }
        return tableOrderDocumentDao;
    }

    public KitchenDisplayDocumentDao kitchenDisplayDocumentDao() {
        KitchenDisplayDocumentDao kitchenDisplayDocumentDao;
        if (this._kitchenDisplayDocumentDao != null) {
            return this._kitchenDisplayDocumentDao;
        }
        synchronized (this) {
            if (this._kitchenDisplayDocumentDao == null) {
                this._kitchenDisplayDocumentDao = new KitchenDisplayDocumentDao_Impl(this);
            }
            kitchenDisplayDocumentDao = this._kitchenDisplayDocumentDao;
        }
        return kitchenDisplayDocumentDao;
    }

    public NomenclatureItemSaleDocumentDao nomenclatureItemSaleDocumentDao() {
        NomenclatureItemSaleDocumentDao nomenclatureItemSaleDocumentDao;
        if (this._nomenclatureItemSaleDocumentDao != null) {
            return this._nomenclatureItemSaleDocumentDao;
        }
        synchronized (this) {
            if (this._nomenclatureItemSaleDocumentDao == null) {
                this._nomenclatureItemSaleDocumentDao = new NomenclatureItemSaleDocumentDao_Impl(this);
            }
            nomenclatureItemSaleDocumentDao = this._nomenclatureItemSaleDocumentDao;
        }
        return nomenclatureItemSaleDocumentDao;
    }

    public ModifierGroupDocumentDao modifierGroupDocumentDao() {
        ModifierGroupDocumentDao modifierGroupDocumentDao;
        if (this._modifierGroupDocumentDao != null) {
            return this._modifierGroupDocumentDao;
        }
        synchronized (this) {
            if (this._modifierGroupDocumentDao == null) {
                this._modifierGroupDocumentDao = new ModifierGroupDocumentDao_Impl(this);
            }
            modifierGroupDocumentDao = this._modifierGroupDocumentDao;
        }
        return modifierGroupDocumentDao;
    }

    public ModifierDocumentDao modifierDocumentDao() {
        ModifierDocumentDao modifierDocumentDao;
        if (this._modifierDocumentDao != null) {
            return this._modifierDocumentDao;
        }
        synchronized (this) {
            if (this._modifierDocumentDao == null) {
                this._modifierDocumentDao = new ModifierDocumentDao_Impl(this);
            }
            modifierDocumentDao = this._modifierDocumentDao;
        }
        return modifierDocumentDao;
    }

    public ModifierLinkDocumentDao modifierLinkDocumentDao() {
        ModifierLinkDocumentDao modifierLinkDocumentDao;
        if (this._modifierLinkDocumentDao != null) {
            return this._modifierLinkDocumentDao;
        }
        synchronized (this) {
            if (this._modifierLinkDocumentDao == null) {
                this._modifierLinkDocumentDao = new ModifierLinkDocumentDao_Impl(this);
            }
            modifierLinkDocumentDao = this._modifierLinkDocumentDao;
        }
        return modifierLinkDocumentDao;
    }

    public DishGroupDocumentDao dishGroupDocumentDao() {
        DishGroupDocumentDao dishGroupDocumentDao;
        if (this._dishGroupDocumentDao != null) {
            return this._dishGroupDocumentDao;
        }
        synchronized (this) {
            if (this._dishGroupDocumentDao == null) {
                this._dishGroupDocumentDao = new DishGroupDocumentDao_Impl(this);
            }
            dishGroupDocumentDao = this._dishGroupDocumentDao;
        }
        return dishGroupDocumentDao;
    }

    public DishDocumentDao dishDocumentDao() {
        DishDocumentDao dishDocumentDao;
        if (this._dishDocumentDao != null) {
            return this._dishDocumentDao;
        }
        synchronized (this) {
            if (this._dishDocumentDao == null) {
                this._dishDocumentDao = new DishDocumentDao_Impl(this);
            }
            dishDocumentDao = this._dishDocumentDao;
        }
        return dishDocumentDao;
    }

    public EncashmentDocumentDao encashmentDocumentDao() {
        EncashmentDocumentDao encashmentDocumentDao;
        if (this._encashmentDocumentDao != null) {
            return this._encashmentDocumentDao;
        }
        synchronized (this) {
            if (this._encashmentDocumentDao == null) {
                this._encashmentDocumentDao = new EncashmentDocumentDao_AppDatabase_Impl(this);
            }
            encashmentDocumentDao = this._encashmentDocumentDao;
        }
        return encashmentDocumentDao;
    }

    public FixedDiscountDocumentDao fixedDiscountDocumentDao() {
        FixedDiscountDocumentDao fixedDiscountDocumentDao;
        if (this._fixedDiscountDocumentDao != null) {
            return this._fixedDiscountDocumentDao;
        }
        synchronized (this) {
            if (this._fixedDiscountDocumentDao == null) {
                this._fixedDiscountDocumentDao = new FixedDiscountDocumentDao_Impl(this);
            }
            fixedDiscountDocumentDao = this._fixedDiscountDocumentDao;
        }
        return fixedDiscountDocumentDao;
    }

    public ComboDocumentDao comboDocumentDao() {
        ComboDocumentDao comboDocumentDao;
        if (this._comboDocumentDao != null) {
            return this._comboDocumentDao;
        }
        synchronized (this) {
            if (this._comboDocumentDao == null) {
                this._comboDocumentDao = new ComboDocumentDao_Impl(this);
            }
            comboDocumentDao = this._comboDocumentDao;
        }
        return comboDocumentDao;
    }

    public FixedMarkupDocumentDao fixedMarkupDocumentDao() {
        FixedMarkupDocumentDao fixedMarkupDocumentDao;
        if (this._fixedMarkupDocumentDao != null) {
            return this._fixedMarkupDocumentDao;
        }
        synchronized (this) {
            if (this._fixedMarkupDocumentDao == null) {
                this._fixedMarkupDocumentDao = new FixedMarkupDocumentDao_Impl(this);
            }
            fixedMarkupDocumentDao = this._fixedMarkupDocumentDao;
        }
        return fixedMarkupDocumentDao;
    }

    public CancellationReasonDocumentRepositoryImpl.CancellationReasonDocumentDao cancellationReasonDocumentDao() {
        CancellationReasonDocumentRepositoryImpl.CancellationReasonDocumentDao cancellationReasonDocumentDao;
        if (this._cancellationReasonDocumentDao != null) {
            return this._cancellationReasonDocumentDao;
        }
        synchronized (this) {
            if (this._cancellationReasonDocumentDao == null) {
                this._cancellationReasonDocumentDao = new CancellationReasonDocumentRepositoryImpl_CancellationReasonDocumentDao_Impl(this);
            }
            cancellationReasonDocumentDao = this._cancellationReasonDocumentDao;
        }
        return cancellationReasonDocumentDao;
    }

    public TagDocumentDao tagDocumentDao() {
        TagDocumentDao tagDocumentDao;
        if (this._tagDocumentDao != null) {
            return this._tagDocumentDao;
        }
        synchronized (this) {
            if (this._tagDocumentDao == null) {
                this._tagDocumentDao = new TagDocumentDao_Impl(this);
            }
            tagDocumentDao = this._tagDocumentDao;
        }
        return tagDocumentDao;
    }

    public SpecialSetDocumentDao specialSetDocumentDao() {
        SpecialSetDocumentDao specialSetDocumentDao;
        if (this._specialSetDocumentDao != null) {
            return this._specialSetDocumentDao;
        }
        synchronized (this) {
            if (this._specialSetDocumentDao == null) {
                this._specialSetDocumentDao = new SpecialSetDocumentDao_Impl(this);
            }
            specialSetDocumentDao = this._specialSetDocumentDao;
        }
        return specialSetDocumentDao;
    }

    public ShiftDocumentDao shiftDocumentDao() {
        ShiftDocumentDao shiftDocumentDao;
        if (this._shiftDocumentDao != null) {
            return this._shiftDocumentDao;
        }
        synchronized (this) {
            if (this._shiftDocumentDao == null) {
                this._shiftDocumentDao = new ShiftDocumentDao_AppDatabase_Impl(this);
            }
            shiftDocumentDao = this._shiftDocumentDao;
        }
        return shiftDocumentDao;
    }

    public PreorderInfoDocumentDao preorderInfoDocumentDao() {
        PreorderInfoDocumentDao preorderInfoDocumentDao;
        if (this._preorderInfoDocumentDao != null) {
            return this._preorderInfoDocumentDao;
        }
        synchronized (this) {
            if (this._preorderInfoDocumentDao == null) {
                this._preorderInfoDocumentDao = new PreorderInfoDocumentDao_AppDatabase_Impl(this);
            }
            preorderInfoDocumentDao = this._preorderInfoDocumentDao;
        }
        return preorderInfoDocumentDao;
    }

    public SoldoutListDocumentDao soldoutListDocumentDao() {
        SoldoutListDocumentDao soldoutListDocumentDao;
        if (this._soldoutListDocumentDao != null) {
            return this._soldoutListDocumentDao;
        }
        synchronized (this) {
            if (this._soldoutListDocumentDao == null) {
                this._soldoutListDocumentDao = new SoldoutListDocumentDao_Impl(this);
            }
            soldoutListDocumentDao = this._soldoutListDocumentDao;
        }
        return soldoutListDocumentDao;
    }

    public CurrencyDocumentDao currencyDocumentDao() {
        CurrencyDocumentDao currencyDocumentDao;
        if (this._currencyDocumentDao != null) {
            return this._currencyDocumentDao;
        }
        synchronized (this) {
            if (this._currencyDocumentDao == null) {
                this._currencyDocumentDao = new CurrencyDocumentDao_Impl(this);
            }
            currencyDocumentDao = this._currencyDocumentDao;
        }
        return currencyDocumentDao;
    }

    public ScheduledDiscountDocumentDao scheduledDiscountDocumentDao() {
        ScheduledDiscountDocumentDao scheduledDiscountDocumentDao;
        if (this._scheduledDiscountDocumentDao != null) {
            return this._scheduledDiscountDocumentDao;
        }
        synchronized (this) {
            if (this._scheduledDiscountDocumentDao == null) {
                this._scheduledDiscountDocumentDao = new ScheduledDiscountDocumentDao_Impl(this);
            }
            scheduledDiscountDocumentDao = this._scheduledDiscountDocumentDao;
        }
        return scheduledDiscountDocumentDao;
    }

    public OnlineOfferDocumentDao onlineOfferDocumentDao() {
        OnlineOfferDocumentDao onlineOfferDocumentDao;
        if (this._onlineOfferDocumentDao != null) {
            return this._onlineOfferDocumentDao;
        }
        synchronized (this) {
            if (this._onlineOfferDocumentDao == null) {
                this._onlineOfferDocumentDao = new OnlineOfferDocumentDao_AppDatabase_Impl(this);
            }
            onlineOfferDocumentDao = this._onlineOfferDocumentDao;
        }
        return onlineOfferDocumentDao;
    }

    public SysExtrasDocumentDao sysExtrasDocumentDao() {
        SysExtrasDocumentDao sysExtrasDocumentDao;
        if (this._sysExtrasDocumentDao != null) {
            return this._sysExtrasDocumentDao;
        }
        synchronized (this) {
            if (this._sysExtrasDocumentDao == null) {
                this._sysExtrasDocumentDao = new SysExtrasDocumentDao_Impl(this);
            }
            sysExtrasDocumentDao = this._sysExtrasDocumentDao;
        }
        return sysExtrasDocumentDao;
    }

    public OnlineInterfaceDocumentDao onlineInterfaceDocumentDao() {
        OnlineInterfaceDocumentDao onlineInterfaceDocumentDao;
        if (this._onlineInterfaceDocumentDao != null) {
            return this._onlineInterfaceDocumentDao;
        }
        synchronized (this) {
            if (this._onlineInterfaceDocumentDao == null) {
                this._onlineInterfaceDocumentDao = new OnlineInterfaceDocumentDao_Impl(this);
            }
            onlineInterfaceDocumentDao = this._onlineInterfaceDocumentDao;
        }
        return onlineInterfaceDocumentDao;
    }

    public TemplateDocumentDao templateDocumentDao() {
        TemplateDocumentDao templateDocumentDao;
        if (this._templateDocumentDao != null) {
            return this._templateDocumentDao;
        }
        synchronized (this) {
            if (this._templateDocumentDao == null) {
                this._templateDocumentDao = new TemplateDocumentDao_Impl(this);
            }
            templateDocumentDao = this._templateDocumentDao;
        }
        return templateDocumentDao;
    }

    public ImageDocumentDao imageDocumentDao() {
        ImageDocumentDao imageDocumentDao;
        if (this._imageDocumentDao != null) {
            return this._imageDocumentDao;
        }
        synchronized (this) {
            if (this._imageDocumentDao == null) {
                this._imageDocumentDao = new ImageDocumentDao_Impl(this);
            }
            imageDocumentDao = this._imageDocumentDao;
        }
        return imageDocumentDao;
    }

    public MenuDocumentDao menuDocumentDao() {
        MenuDocumentDao menuDocumentDao;
        if (this._menuDocumentDao != null) {
            return this._menuDocumentDao;
        }
        synchronized (this) {
            if (this._menuDocumentDao == null) {
                this._menuDocumentDao = new MenuDocumentDao_Impl(this);
            }
            menuDocumentDao = this._menuDocumentDao;
        }
        return menuDocumentDao;
    }

    public TrueApiDocumentDao trueApiDocumentDao() {
        TrueApiDocumentDao trueApiDocumentDao;
        if (this._trueApiDocumentDao != null) {
            return this._trueApiDocumentDao;
        }
        synchronized (this) {
            if (this._trueApiDocumentDao == null) {
                this._trueApiDocumentDao = new TrueApiDocumentDao_Impl(this);
            }
            trueApiDocumentDao = this._trueApiDocumentDao;
        }
        return trueApiDocumentDao;
    }

    public DxBxTaskDocumentDao dxBxTaskDocumentDao() {
        DxBxTaskDocumentDao dxBxTaskDocumentDao;
        if (this._dxBxTaskDocumentDao != null) {
            return this._dxBxTaskDocumentDao;
        }
        synchronized (this) {
            if (this._dxBxTaskDocumentDao == null) {
                this._dxBxTaskDocumentDao = new DxBxTaskDocumentDao_Impl(this);
            }
            dxBxTaskDocumentDao = this._dxBxTaskDocumentDao;
        }
        return dxBxTaskDocumentDao;
    }
}
