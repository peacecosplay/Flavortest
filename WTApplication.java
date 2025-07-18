package quickresto.webterminal;

import android.app.Application;
import android.content.Context;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.crashlytics.ktx.FirebaseCrashlyticsKt;
import com.google.firebase.ktx.Firebase;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import org.slf4j.Logger;
import quickresto.webterminal.webviewcommand.IWebViewCommand;
import quickresto.webterminal.webviewcommand.LoadUrl;
import quickresto.webterminal.webviewcommand.SetWebContentsDebuggingEnabled;
import quickresto.webterminal.webviewcommand.SettingsJavaScript;
import ru.atol.drivers10.fptr.Fptr;
import ru.quickresto.slf4j.LoggerKt;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lquickresto/webterminal/WTApplication;", "Landroid/app/Application;", "()V", "logger", "Lorg/slf4j/Logger;", "getLogger", "()Lorg/slf4j/Logger;", "logger$delegate", "Lkotlin/Lazy;", "onCreate", "", "Companion", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: WTApplication.kt */
public final class WTApplication extends Application {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DATABASE_NAME = "wt";
    private static final boolean DEBUG_WEB_VIEW = true;
    private static final String INDEX_URI = "http://127.0.0.1:8181/#/openOrders";
    private static final String SHIFT_DATABASE_NAME = "shiftwt";
    private static final String SPECIAL_DATABASE_NAME = "swt";
    private static final String TABLE_ORDER_DATABASE_NAME = "tablewt";
    /* access modifiers changed from: private */
    public static Application app;
    /* access modifiers changed from: private */
    public static AppDatabase db;
    /* access modifiers changed from: private */
    public static SpecialAppDatabase sdb;
    /* access modifiers changed from: private */
    public static ShiftAppDatabase shiftdb;
    /* access modifiers changed from: private */
    public static TableOrderAppDatabase tabledb;
    /* access modifiers changed from: private */
    public static final Channel<IWebViewCommand> webViewCommands;
    private final Lazy logger$delegate = LazyKt.lazy(new WTApplication$logger$2(this));

    private final Logger getLogger() {
        return (Logger) this.logger$delegate.getValue();
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u000eJ\u0006\u0010\u001d\u001a\u00020\u0012J\u0006\u0010\u001e\u001a\u00020\u0010J\u0006\u0010\u001f\u001a\u00020\u0014J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\u0006\u0010#\u001a\u00020!R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006$"}, d2 = {"Lquickresto/webterminal/WTApplication$Companion;", "", "()V", "DATABASE_NAME", "", "DEBUG_WEB_VIEW", "", "INDEX_URI", "SHIFT_DATABASE_NAME", "SPECIAL_DATABASE_NAME", "TABLE_ORDER_DATABASE_NAME", "app", "Landroid/app/Application;", "db", "Lquickresto/webterminal/AppDatabase;", "sdb", "Lquickresto/webterminal/SpecialAppDatabase;", "shiftdb", "Lquickresto/webterminal/ShiftAppDatabase;", "tabledb", "Lquickresto/webterminal/TableOrderAppDatabase;", "webViewCommands", "Lkotlinx/coroutines/channels/Channel;", "Lquickresto/webterminal/webviewcommand/IWebViewCommand;", "getWebViewCommands", "()Lkotlinx/coroutines/channels/Channel;", "getContext", "Landroid/content/Context;", "getDatabase", "getShiftDatabase", "getSpecialDatabase", "getTableOrderDatabase", "loadBlank", "", "loadFrontend", "reloadFrontend", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: WTApplication.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Channel<IWebViewCommand> getWebViewCommands() {
            return WTApplication.webViewCommands;
        }

        public final Context getContext() {
            Application access$getApp$cp = WTApplication.app;
            if (access$getApp$cp == null) {
                Intrinsics.throwUninitializedPropertyAccessException("app");
                access$getApp$cp = null;
            }
            Context applicationContext = access$getApp$cp.getApplicationContext();
            Intrinsics.checkNotNull(applicationContext);
            return applicationContext;
        }

        public final AppDatabase getDatabase() {
            boolean z = WTApplication.db != null;
            Application application = null;
            if (z) {
                AppDatabase access$getDb$cp = WTApplication.db;
                if (access$getDb$cp != null) {
                    return access$getDb$cp;
                }
                Intrinsics.throwUninitializedPropertyAccessException("db");
                return null;
            } else if (!z) {
                Application access$getApp$cp = WTApplication.app;
                if (access$getApp$cp == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("app");
                } else {
                    application = access$getApp$cp;
                }
                Context applicationContext = application.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "app.applicationContext");
                AppDatabase createDatabase = AppDatabaseKt.createDatabase(WTApplication.DATABASE_NAME, applicationContext);
                Companion companion = WTApplication.Companion;
                WTApplication.db = createDatabase;
                return createDatabase;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }

        public final SpecialAppDatabase getSpecialDatabase() {
            boolean z = WTApplication.sdb != null;
            Application application = null;
            if (z) {
                SpecialAppDatabase access$getSdb$cp = WTApplication.sdb;
                if (access$getSdb$cp != null) {
                    return access$getSdb$cp;
                }
                Intrinsics.throwUninitializedPropertyAccessException("sdb");
                return null;
            } else if (!z) {
                Application access$getApp$cp = WTApplication.app;
                if (access$getApp$cp == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("app");
                } else {
                    application = access$getApp$cp;
                }
                Context applicationContext = application.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "app.applicationContext");
                SpecialAppDatabase createSpecialDatabase = AppDatabaseKt.createSpecialDatabase(WTApplication.SPECIAL_DATABASE_NAME, applicationContext);
                Companion companion = WTApplication.Companion;
                WTApplication.sdb = createSpecialDatabase;
                return createSpecialDatabase;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }

        public final TableOrderAppDatabase getTableOrderDatabase() {
            boolean z = WTApplication.tabledb != null;
            Application application = null;
            if (z) {
                TableOrderAppDatabase access$getTabledb$cp = WTApplication.tabledb;
                if (access$getTabledb$cp != null) {
                    return access$getTabledb$cp;
                }
                Intrinsics.throwUninitializedPropertyAccessException("tabledb");
                return null;
            } else if (!z) {
                Application access$getApp$cp = WTApplication.app;
                if (access$getApp$cp == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("app");
                } else {
                    application = access$getApp$cp;
                }
                Context applicationContext = application.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "app.applicationContext");
                TableOrderAppDatabase createTableOrderDatabase = AppDatabaseKt.createTableOrderDatabase(WTApplication.TABLE_ORDER_DATABASE_NAME, applicationContext);
                Companion companion = WTApplication.Companion;
                WTApplication.tabledb = createTableOrderDatabase;
                return createTableOrderDatabase;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }

        public final ShiftAppDatabase getShiftDatabase() {
            boolean z = WTApplication.shiftdb != null;
            Application application = null;
            if (z) {
                ShiftAppDatabase access$getShiftdb$cp = WTApplication.shiftdb;
                if (access$getShiftdb$cp != null) {
                    return access$getShiftdb$cp;
                }
                Intrinsics.throwUninitializedPropertyAccessException("shiftdb");
                return null;
            } else if (!z) {
                Application access$getApp$cp = WTApplication.app;
                if (access$getApp$cp == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("app");
                } else {
                    application = access$getApp$cp;
                }
                Context applicationContext = application.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "app.applicationContext");
                ShiftAppDatabase createShiftDatabase = AppDatabaseKt.createShiftDatabase(WTApplication.SHIFT_DATABASE_NAME, applicationContext);
                Companion companion = WTApplication.Companion;
                WTApplication.shiftdb = createShiftDatabase;
                return createShiftDatabase;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }

        public final void loadFrontend() {
            getWebViewCommands().m7061trySendJP2dKIU(new LoadUrl(WTApplication.INDEX_URI));
        }

        public final void loadBlank() {
            getWebViewCommands().m7061trySendJP2dKIU(new LoadUrl("about:blank"));
        }

        public final void reloadFrontend() {
            loadBlank();
            loadFrontend();
        }
    }

    static {
        Channel<IWebViewCommand> Channel$default = ChannelKt.Channel$default(Integer.MAX_VALUE, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        Channel$default.m7061trySendJP2dKIU(new SettingsJavaScript(true));
        Channel$default.m7061trySendJP2dKIU(new SetWebContentsDebuggingEnabled(true));
        webViewCommands = Channel$default;
    }

    public void onCreate() {
        super.onCreate();
        Companion companion = Companion;
        app = this;
        Logger logger = getLogger();
        if (logger.isWarnEnabled()) {
            LoggerKt.warn(logger, (Object) "App version = 9.5.7 (254)");
        }
        Logger logger2 = getLogger();
        if (logger2.isWarnEnabled()) {
            LoggerKt.warn(logger2, (Object) "Atol driver version = " + new Fptr(companion.getContext()).version());
        }
        FirebaseCrashlytics crashlytics = FirebaseCrashlyticsKt.getCrashlytics(Firebase.INSTANCE);
        crashlytics.setCustomKey("app_version", "9.5.7 (254)");
        crashlytics.setCustomKey("atol_version", new Fptr(companion.getContext()).version());
        LoggerKt.info(getLogger(), (Function0<? extends Object>) WTApplication$onCreate$3.INSTANCE);
    }
}
