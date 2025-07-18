package quickresto.webterminal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import org.slf4j.Logger;
import ru.quickresto.slf4j.LoggerKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "quickresto.webterminal.MainServerBackgroundService$onStartCommand$3", f = "MainServerBackgroundService.kt", i = {0}, l = {140}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* compiled from: MainServerBackgroundService.kt */
final class MainServerBackgroundService$onStartCommand$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LogsCollectorService $logsCollectorService;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainServerBackgroundService$onStartCommand$3(LogsCollectorService logsCollectorService, Continuation<? super MainServerBackgroundService$onStartCommand$3> continuation) {
        super(2, continuation);
        this.$logsCollectorService = logsCollectorService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MainServerBackgroundService$onStartCommand$3 mainServerBackgroundService$onStartCommand$3 = new MainServerBackgroundService$onStartCommand$3(this.$logsCollectorService, continuation);
        mainServerBackgroundService$onStartCommand$3.L$0 = obj;
        return mainServerBackgroundService$onStartCommand$3;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainServerBackgroundService$onStartCommand$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Logger cachedLoggerOf = LoggerKt.cachedLoggerOf(Reflection.getOrCreateKotlinClass(CoroutineScope.class));
            if (cachedLoggerOf.isWarnEnabled()) {
                LoggerKt.warn(cachedLoggerOf, (Object) "!!!!!!!!!!!!!!! readLogs !!!!!!!!!!!!!!!!!!!");
            }
            this.L$0 = coroutineScope;
            this.label = 1;
            if (this.$logsCollectorService.readLogs(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e) {
                Logger cachedLoggerOf2 = LoggerKt.cachedLoggerOf(Reflection.getOrCreateKotlinClass(CoroutineScope.class));
                if (cachedLoggerOf2.isWarnEnabled()) {
                    LoggerKt.warn(cachedLoggerOf2, (Object) "!!!!!!!!!!!!!!! Exception: " + e.getMessage() + " !!!!!!!!!!!!!!!!!!!");
                }
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Logger cachedLoggerOf3 = LoggerKt.cachedLoggerOf(Reflection.getOrCreateKotlinClass(CoroutineScope.class));
        if (cachedLoggerOf3.isWarnEnabled()) {
            LoggerKt.warn(cachedLoggerOf3, (Object) "!!!!!!!!!!!!!!! readLogs end !!!!!!!!!!!!!!!!!!!");
        }
        return Unit.INSTANCE;
    }
}
