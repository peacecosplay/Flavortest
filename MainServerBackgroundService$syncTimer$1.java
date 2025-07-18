package quickresto.webterminal;

import android.os.CountDownTimer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.slf4j.Logger;
import ru.quickresto.slf4j.LoggerKt;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"quickresto/webterminal/MainServerBackgroundService$syncTimer$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MainServerBackgroundService.kt */
public final class MainServerBackgroundService$syncTimer$1 extends CountDownTimer {
    final /* synthetic */ MainServerBackgroundService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainServerBackgroundService$syncTimer$1(MainServerBackgroundService mainServerBackgroundService) {
        super(60000, 60000);
        this.this$0 = mainServerBackgroundService;
    }

    public void onTick(long j) {
        if (!this.this$0.getSyncTimerLock().get()) {
            try {
                this.this$0.getSyncTimerLock().set(true);
                Logger cachedLoggerOf = LoggerKt.cachedLoggerOf(Reflection.getOrCreateKotlinClass(MainServerBackgroundService$syncTimer$1.class));
                if (cachedLoggerOf.isDebugEnabled()) {
                    LoggerKt.debug(cachedLoggerOf, (Object) "!!! fun syncTimer.onTick(" + j + ")");
                }
                Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(JobKt.Job$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO())), (CoroutineContext) null, (CoroutineStart) null, new MainServerBackgroundService$syncTimer$1$onTick$2$1(this.this$0.getReplicationService(), (Continuation<? super MainServerBackgroundService$syncTimer$1$onTick$2$1>) null), 3, (Object) null);
            } finally {
                this.this$0.getSyncTimerLock().set(false);
            }
        }
    }

    public void onFinish() {
        this.this$0.getSyncTimerLock().set(false);
        start();
    }
}
