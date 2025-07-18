package quickresto.webterminal;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import quickresto.webterminal.database.EncashmentDocumentDao;
import quickresto.webterminal.database.OnlineOfferDocumentDao;
import quickresto.webterminal.database.OrderDocumentV2Dao;
import quickresto.webterminal.database.PreorderInfoDocumentDao;
import quickresto.webterminal.database.ShiftDocumentDao;
import quickresto.webterminal.database.TableOrderDocumentDao;
import ru.quickresto.terminal.client.ReplicationStatus;
import ru.quickresto.terminal.client.database.EncashmentDocument;
import ru.quickresto.terminal.client.database.OnlineOfferDocument;
import ru.quickresto.terminal.client.database.OrderDocumentV2;
import ru.quickresto.terminal.client.database.PreorderDocument;
import ru.quickresto.terminal.client.database.ShiftActionType;
import ru.quickresto.terminal.client.database.ShiftDocument;
import ru.quickresto.terminal.client.database.TableOrderDocument;
import ru.quickresto.terminal.client.migration.MigrationState;
import ru.quickresto.terminal.client.migration.TerminalMigrationService;
import ru.quickresto.terminal.orders.OrderStatus;
import ru.quickresto.terminal.orders.PreorderInfoStatus;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lquickresto/webterminal/MigrationDatabaseService;", "Lru/quickresto/terminal/client/migration/TerminalMigrationService;", "()V", "migrate", "", "migrationState", "Lru/quickresto/terminal/client/migration/MigrationState;", "Companion", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MigrationDatabaseService.kt */
public final class MigrationDatabaseService implements TerminalMigrationService {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static MigrationState state = MigrationState.PROCESSING;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lquickresto/webterminal/MigrationDatabaseService$Companion;", "", "()V", "state", "Lru/quickresto/terminal/client/migration/MigrationState;", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: MigrationDatabaseService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public MigrationState migrationState() {
        return state;
    }

    public final void migrate() {
        AppDatabase database = WTApplication.Companion.getDatabase();
        SpecialAppDatabase specialDatabase = WTApplication.Companion.getSpecialDatabase();
        TableOrderAppDatabase tableOrderDatabase = WTApplication.Companion.getTableOrderDatabase();
        ShiftAppDatabase shiftDatabase = WTApplication.Companion.getShiftDatabase();
        OrderDocumentV2Dao orderDocumentV2Dao = database.orderDocumentV2Dao();
        for (OrderDocumentV2 orderDocumentV2 : orderDocumentV2Dao.findByReplicationStatusAndRemovedFalse(ReplicationStatus.NEW)) {
            specialDatabase.orderDocumentV2Dao().insert(orderDocumentV2);
            orderDocumentV2Dao.delete(orderDocumentV2);
        }
        for (OrderDocumentV2 orderDocumentV22 : orderDocumentV2Dao.findByReplicationStatusAndRemovedFalse(ReplicationStatus.IN_PROGRESS)) {
            specialDatabase.orderDocumentV2Dao().insert(orderDocumentV22);
            orderDocumentV2Dao.delete(orderDocumentV22);
        }
        EncashmentDocumentDao encashmentDocumentDao = database.encashmentDocumentDao();
        for (EncashmentDocument encashmentDocument : encashmentDocumentDao.findByReplicationStatusAndRemovedFalse(ReplicationStatus.NEW)) {
            specialDatabase.encashmentDocumentDao().insert(encashmentDocument);
            encashmentDocumentDao.delete(encashmentDocument);
        }
        for (EncashmentDocument encashmentDocument2 : encashmentDocumentDao.findByReplicationStatusAndRemovedFalse(ReplicationStatus.IN_PROGRESS)) {
            specialDatabase.encashmentDocumentDao().insert(encashmentDocument2);
            encashmentDocumentDao.delete(encashmentDocument2);
        }
        PreorderInfoDocumentDao preorderInfoDocumentDao = database.preorderInfoDocumentDao();
        for (PreorderDocument preorderDocument : preorderInfoDocumentDao.findByReplicationStatusOrderByLocalPrintDateAsc(ReplicationStatus.NEW)) {
            specialDatabase.preorderInfoDocumentDao().insert(preorderDocument);
            preorderInfoDocumentDao.delete(preorderDocument);
        }
        for (PreorderDocument preorderDocument2 : preorderInfoDocumentDao.findByReplicationStatusOrderByLocalPrintDateAsc(ReplicationStatus.IN_PROGRESS)) {
            specialDatabase.preorderInfoDocumentDao().insert(preorderDocument2);
            preorderInfoDocumentDao.delete(preorderDocument2);
        }
        OnlineOfferDocumentDao onlineOfferDocumentDao = database.onlineOfferDocumentDao();
        for (OnlineOfferDocument onlineOfferDocument : onlineOfferDocumentDao.findByCreateTimeDescLimit1000()) {
            specialDatabase.onlineOfferDocumentDao().insert(onlineOfferDocument);
            onlineOfferDocumentDao.delete(onlineOfferDocument);
        }
        TableOrderDocumentDao tableOrderDocumentDao = database.tableOrderDocumentDao();
        for (TableOrderDocument tableOrderDocument : tableOrderDocumentDao.findByStatusInOrderByUpdateTimeDesc(CollectionsKt.listOf(OrderStatus.NEW, OrderStatus.INCOMPLETED), 0, -1)) {
            for (OrderDocumentV2 orderDocumentV23 : orderDocumentV2Dao.findByTableOrderDocumentId(tableOrderDocument.getId())) {
                specialDatabase.orderDocumentV2Dao().insert(orderDocumentV23);
                orderDocumentV2Dao.delete(orderDocumentV23);
                PreorderDocument findBySubOrderIdAndStatus = preorderInfoDocumentDao.findBySubOrderIdAndStatus(orderDocumentV23.getId(), PreorderInfoStatus.Created);
                specialDatabase.preorderInfoDocumentDao().insert(findBySubOrderIdAndStatus);
                preorderInfoDocumentDao.delete(findBySubOrderIdAndStatus);
            }
            tableOrderDatabase.tableOrderDocumentDao().insert(tableOrderDocument);
            tableOrderDocumentDao.delete(tableOrderDocument);
        }
        ShiftDocumentDao shiftDocumentDao = database.shiftDocumentDao();
        for (ShiftDocument shiftDocument : shiftDocumentDao.findByActionType(ShiftActionType.OPEN)) {
            shiftDatabase.shiftDocumentDao().insert(shiftDocument);
            shiftDocumentDao.delete(shiftDocument);
        }
        for (ShiftDocument shiftDocument2 : shiftDocumentDao.findByReplicationStatus(ReplicationStatus.NEW)) {
            shiftDatabase.shiftDocumentDao().insert(shiftDocument2);
            shiftDocumentDao.delete(shiftDocument2);
        }
        state = MigrationState.IDLE;
        for (TableOrderDocument tableOrderDocument2 : tableOrderDocumentDao.findByUpdateTimeDescLimit1000()) {
            for (OrderDocumentV2 orderDocumentV24 : orderDocumentV2Dao.findByTableOrderDocumentId(tableOrderDocument2.getId())) {
                specialDatabase.orderDocumentV2Dao().insert(orderDocumentV24);
                orderDocumentV2Dao.delete(orderDocumentV24);
                PreorderDocument findBySubOrderIdAndStatus2 = preorderInfoDocumentDao.findBySubOrderIdAndStatus(orderDocumentV24.getId(), PreorderInfoStatus.Created);
                specialDatabase.preorderInfoDocumentDao().insert(findBySubOrderIdAndStatus2);
                preorderInfoDocumentDao.delete(findBySubOrderIdAndStatus2);
            }
            tableOrderDatabase.tableOrderDocumentDao().insert(tableOrderDocument2);
            tableOrderDocumentDao.delete(tableOrderDocument2);
        }
    }
}
