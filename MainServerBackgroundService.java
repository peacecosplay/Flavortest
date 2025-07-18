package quickresto.webterminal;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.crashlytics.ktx.FirebaseCrashlyticsKt;
import com.google.firebase.ktx.Firebase;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.quickresto.slf4j.LoggerKt;
import ru.quickresto.terminal.client.ApplicationState;
import ru.quickresto.terminal.client.ReplicationService;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020%H\u0016J\"\u0010'\u001a\u00020(2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020(H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006,"}, d2 = {"Lquickresto/webterminal/MainServerBackgroundService;", "Landroid/app/Service;", "()V", "logger", "Lorg/slf4j/Logger;", "migrationDatabaseService", "Lquickresto/webterminal/MigrationDatabaseService;", "getMigrationDatabaseService", "()Lquickresto/webterminal/MigrationDatabaseService;", "setMigrationDatabaseService", "(Lquickresto/webterminal/MigrationDatabaseService;)V", "migrationJob", "Lkotlinx/coroutines/Job;", "getMigrationJob", "()Lkotlinx/coroutines/Job;", "setMigrationJob", "(Lkotlinx/coroutines/Job;)V", "readLogsJob", "getReadLogsJob", "setReadLogsJob", "replicationService", "Lru/quickresto/terminal/client/ReplicationService;", "getReplicationService", "()Lru/quickresto/terminal/client/ReplicationService;", "setReplicationService", "(Lru/quickresto/terminal/client/ReplicationService;)V", "syncTimer", "Landroid/os/CountDownTimer;", "syncTimerLock", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getSyncTimerLock", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "", "onDestroy", "onStartCommand", "", "flags", "startId", "Companion", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MainServerBackgroundService.kt */
public final class MainServerBackgroundService extends Service {
    public static final int $stable = 8;
    public static final String CHANNEL_ID = "notify_channel";
    public static final String CHANNEL_NAME = "Notification channel";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int FOREGROUND_ID = 1;
    private final Logger logger;
    public MigrationDatabaseService migrationDatabaseService;
    private Job migrationJob;
    private Job readLogsJob;
    public ReplicationService replicationService;
    private final CountDownTimer syncTimer = new MainServerBackgroundService$syncTimer$1(this);
    private final AtomicBoolean syncTimerLock = new AtomicBoolean(false);

    public MainServerBackgroundService() {
        Logger logger2 = LoggerFactory.getLogger((Class<?>) MainServerBackgroundService.class);
        Intrinsics.checkNotNullExpressionValue(logger2, "getLogger(...)");
        this.logger = logger2;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lquickresto/webterminal/MainServerBackgroundService$Companion;", "", "()V", "CHANNEL_ID", "", "CHANNEL_NAME", "FOREGROUND_ID", "", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: MainServerBackgroundService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final ReplicationService getReplicationService() {
        ReplicationService replicationService2 = this.replicationService;
        if (replicationService2 != null) {
            return replicationService2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("replicationService");
        return null;
    }

    public final void setReplicationService(ReplicationService replicationService2) {
        Intrinsics.checkNotNullParameter(replicationService2, "<set-?>");
        this.replicationService = replicationService2;
    }

    public final MigrationDatabaseService getMigrationDatabaseService() {
        MigrationDatabaseService migrationDatabaseService2 = this.migrationDatabaseService;
        if (migrationDatabaseService2 != null) {
            return migrationDatabaseService2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("migrationDatabaseService");
        return null;
    }

    public final void setMigrationDatabaseService(MigrationDatabaseService migrationDatabaseService2) {
        Intrinsics.checkNotNullParameter(migrationDatabaseService2, "<set-?>");
        this.migrationDatabaseService = migrationDatabaseService2;
    }

    public final Job getReadLogsJob() {
        return this.readLogsJob;
    }

    public final void setReadLogsJob(Job job) {
        this.readLogsJob = job;
    }

    public final Job getMigrationJob() {
        return this.migrationJob;
    }

    public final void setMigrationJob(Job job) {
        this.migrationJob = job;
    }

    public final AtomicBoolean getSyncTimerLock() {
        return this.syncTimerLock;
    }

    public IBinder onBind(Intent intent) {
        Logger logger2 = this.logger;
        if (!logger2.isWarnEnabled()) {
            return null;
        }
        LoggerKt.warn(logger2, (Object) "!!!!!!!!!!!!!!! onBind !!!!!!!!!!!!!!!!!!!");
        return null;
    }

    public void onCreate() {
        super.onCreate();
        Logger logger2 = this.logger;
        if (logger2.isWarnEnabled()) {
            LoggerKt.warn(logger2, (Object) "!!!!!!!!!!!!!!! onCreate !!!!!!!!!!!!!!!!!!!");
        }
        Object systemService = getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).createNotificationChannel(new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, 3));
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        Logger logger2 = this.logger;
        if (logger2.isWarnEnabled()) {
            LoggerKt.warn(logger2, (Object) "!!!!!!!!!!!!!!! onStartCommand !!!!!!!!!!!!!!!!!!!");
        }
        if (this.migrationJob != null) {
            return super.onStartCommand(intent, i, i2);
        }
        LoggerKt.info(this.logger, (Function0<? extends Object>) MainServerBackgroundService$onStartCommand$2.INSTANCE);
        this.readLogsJob = JobKt.Job$default((Job) null, 1, (Object) null);
        this.migrationJob = JobKt.Job$default((Job) null, 1, (Object) null);
        setReplicationService(ServiceLocator.INSTANCE.replicationService());
        setMigrationDatabaseService(ServiceLocator.INSTANCE.migrationDatabaseService());
        ApplicationState applicationState = ServiceLocator.INSTANCE.applicationState();
        FirebaseCrashlytics crashlytics = FirebaseCrashlyticsKt.getCrashlytics(Firebase.INSTANCE);
        String layer = applicationState.getLayer();
        String str = "";
        if (layer == null) {
            layer = str;
        }
        crashlytics.setUserId(layer);
        String layer2 = applicationState.getLayer();
        if (layer2 == null) {
            layer2 = str;
        }
        crashlytics.setCustomKey("layer", layer2);
        String terminalId = applicationState.getTerminalId();
        if (terminalId != null) {
            str = terminalId;
        }
        crashlytics.setCustomKey("terminalId", str);
        WTApplication.Companion.loadFrontend();
        this.syncTimer.start();
        LogsCollectorService logsCollectorService = new LogsCollectorService();
        CoroutineDispatcher io2 = Dispatchers.getIO();
        Job job = this.readLogsJob;
        Intrinsics.checkNotNull(job);
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(io2.plus(job)), (CoroutineContext) null, (CoroutineStart) null, new MainServerBackgroundService$onStartCommand$3(logsCollectorService, (Continuation<? super MainServerBackgroundService$onStartCommand$3>) null), 3, (Object) null);
        CoroutineDispatcher io3 = Dispatchers.getIO();
        Job job2 = this.migrationJob;
        Intrinsics.checkNotNull(job2);
        Job unused2 = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(io3.plus(job2)), (CoroutineContext) null, (CoroutineStart) null, new MainServerBackgroundService$onStartCommand$4(this, (Continuation<? super MainServerBackgroundService$onStartCommand$4>) null), 3, (Object) null);
        Logger logger3 = this.logger;
        if (logger3.isWarnEnabled()) {
            LoggerKt.warn(logger3, (Object) "!!!!!!!!!!!!!!! onStartCommand end !!!!!!!!!!!!!!!!!!!");
        }
        return super.onStartCommand(intent, i, i2);
    }

    public void onDestroy() {
        super.onDestroy();
        Logger logger2 = this.logger;
        if (logger2.isWarnEnabled()) {
            LoggerKt.warn(logger2, (Object) "!!!!!!!!!!!!!!! onDestroy !!!!!!!!!!!!!!!!!!!");
        }
        Object unused = BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new MainServerBackgroundService$onDestroy$2(this, (Continuation<? super MainServerBackgroundService$onDestroy$2>) null), 1, (Object) null);
    }
}
