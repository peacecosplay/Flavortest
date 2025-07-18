package quickresto.webterminal;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.quickresto.slf4j.LoggerKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0011\u0010\u0017\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lquickresto/webterminal/StartActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "launch", "Lkotlinx/coroutines/Job;", "getLaunch", "()Lkotlinx/coroutines/Job;", "setLaunch", "(Lkotlinx/coroutines/Job;)V", "log", "", "", "getLog", "()Ljava/util/List;", "logger", "Lorg/slf4j/Logger;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onWindowFocusChanged", "hasFocus", "", "readLogs", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: StartActivity.kt */
public final class StartActivity extends AppCompatActivity {
    public static final int $stable = 8;
    public Job launch;
    private final List<String> log = new ArrayList();
    private final Logger logger;

    public StartActivity() {
        Logger logger2 = LoggerFactory.getLogger((Class<?>) StartActivity.class);
        Intrinsics.checkNotNullExpressionValue(logger2, "getLogger(...)");
        this.logger = logger2;
    }

    public final List<String> getLog() {
        return this.log;
    }

    public final Job getLaunch() {
        Job job = this.launch;
        if (job != null) {
            return job;
        }
        Intrinsics.throwUninitializedPropertyAccessException("launch");
        return null;
    }

    public final void setLaunch(Job job) {
        Intrinsics.checkNotNullParameter(job, "<set-?>");
        this.launch = job;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Logger logger2 = this.logger;
        if (logger2.isWarnEnabled()) {
            LoggerKt.warn(logger2, (Object) "Preparing services ...");
        }
        ServiceLocator.INSTANCE.objectMapper();
        startActivity(new Intent(this, MainActivity.class));
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

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006e, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0071, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readLogs(kotlin.coroutines.Continuation<? super kotlin.Unit> r4) {
        /*
            r3 = this;
            java.lang.Runtime r4 = java.lang.Runtime.getRuntime()
            java.lang.String r0 = "logcat -c"
            r4.exec(r0)
            java.lang.Runtime r4 = java.lang.Runtime.getRuntime()
            java.lang.String r0 = "logcat"
            java.lang.Process r4 = r4.exec(r0)
            java.io.InputStream r4 = r4.getInputStream()
            java.lang.String r0 = "getRuntime().exec(\"logca…\n            .inputStream"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            java.nio.charset.Charset r0 = kotlin.text.Charsets.UTF_8
            java.io.InputStreamReader r1 = new java.io.InputStreamReader
            r1.<init>(r4, r0)
            java.io.Reader r1 = (java.io.Reader) r1
            boolean r4 = r1 instanceof java.io.BufferedReader
            r0 = 8192(0x2000, float:1.14794E-41)
            if (r4 == 0) goto L_0x002e
            java.io.BufferedReader r1 = (java.io.BufferedReader) r1
            goto L_0x0034
        L_0x002e:
            java.io.BufferedReader r4 = new java.io.BufferedReader
            r4.<init>(r1, r0)
            r1 = r4
        L_0x0034:
            java.io.Reader r1 = (java.io.Reader) r1
            boolean r4 = r1 instanceof java.io.BufferedReader
            if (r4 == 0) goto L_0x003d
            java.io.BufferedReader r1 = (java.io.BufferedReader) r1
            goto L_0x0043
        L_0x003d:
            java.io.BufferedReader r4 = new java.io.BufferedReader
            r4.<init>(r1, r0)
            r1 = r4
        L_0x0043:
            java.io.Closeable r1 = (java.io.Closeable) r1
            r4 = r1
            java.io.BufferedReader r4 = (java.io.BufferedReader) r4     // Catch:{ all -> 0x006b }
            kotlin.sequences.Sequence r4 = kotlin.io.TextStreamsKt.lineSequence(r4)     // Catch:{ all -> 0x006b }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x006b }
        L_0x0050:
            boolean r0 = r4.hasNext()     // Catch:{ all -> 0x006b }
            if (r0 == 0) goto L_0x0062
            java.lang.Object r0 = r4.next()     // Catch:{ all -> 0x006b }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x006b }
            java.util.List<java.lang.String> r2 = r3.log     // Catch:{ all -> 0x006b }
            r2.add(r0)     // Catch:{ all -> 0x006b }
            goto L_0x0050
        L_0x0062:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x006b }
            r4 = 0
            kotlin.io.CloseableKt.closeFinally(r1, r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L_0x006b:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x006d }
        L_0x006d:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: quickresto.webterminal.StartActivity.readLogs(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
