package quickresto.webterminal;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.runtime.CompositionContext;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import com.gazim.nulltermstream.android.extension.ExtensionKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.quickresto.slf4j.LoggerKt;
import ru.quickresto.weblogserver.AndroidWebLogServiceExtKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0010H\u0014J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lquickresto/webterminal/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "logger", "Lorg/slf4j/Logger;", "server", "Lquickresto/webterminal/MainServer;", "getServer", "()Lquickresto/webterminal/MainServer;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "hideSystemBars", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onWindowFocusChanged", "hasFocus", "", "Companion", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MainActivity.kt */
public final class MainActivity extends AppCompatActivity {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Channel<Unit> activationServer = ChannelKt.Channel$default(0, (BufferOverflow) null, (Function1) null, 7, (Object) null);
    /* access modifiers changed from: private */
    public final Logger logger;
    private final MainServer server = new MainServer();
    public View view;

    public MainActivity() {
        Logger logger2 = LoggerFactory.getLogger((Class<?>) MainActivity.class);
        Intrinsics.checkNotNullExpressionValue(logger2, "getLogger(...)");
        this.logger = logger2;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lquickresto/webterminal/MainActivity$Companion;", "", "()V", "activationServer", "Lkotlinx/coroutines/channels/Channel;", "", "getActivationServer", "()Lkotlinx/coroutines/channels/Channel;", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: MainActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Channel<Unit> getActivationServer() {
            return MainActivity.activationServer;
        }
    }

    public final View getView() {
        View view2 = this.view;
        if (view2 != null) {
            return view2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("view");
        return null;
    }

    public final void setView(View view2) {
        Intrinsics.checkNotNullParameter(view2, "<set-?>");
        this.view = view2;
    }

    public final MainServer getServer() {
        return this.server;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ComponentActivity componentActivity = this;
        AndroidWebLogServiceExtKt.configureWebLogService$default(componentActivity, 0, 1, (Object) null);
        ExtensionKt.configureNullTermStreamService(componentActivity);
        requestWindowFeature(1);
        ComponentActivityKt.setContent$default(componentActivity, (CompositionContext) null, ComposableSingletons$MainActivityKt.INSTANCE.m7224getLambda1$quickresto_webterminal_9_5_7_254__release(), 1, (Object) null);
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new MainActivity$onCreate$1(this, (Continuation<? super MainActivity$onCreate$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        stopService(new Intent(WTApplication.Companion.getContext(), MainServerBackgroundService.class));
        LoggerKt.info(this.logger, (Function0<? extends Object>) MainActivity$onDestroy$1.INSTANCE);
        this.server.stop();
    }

    public void onConfigurationChanged(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        if (configuration.hardKeyboardHidden == 1) {
            hideSystemBars();
        } else if (configuration.hardKeyboardHidden == 2) {
            hideSystemBars();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
            WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
            windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.systemBars());
            windowInsetsControllerCompat.setSystemBarsBehavior(2);
        }
    }

    private final void hideSystemBars() {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        if (this.view != null) {
            WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(getWindow(), getView());
            windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.systemBars());
            windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.captionBar());
            windowInsetsControllerCompat.setSystemBarsBehavior(2);
        }
    }
}
