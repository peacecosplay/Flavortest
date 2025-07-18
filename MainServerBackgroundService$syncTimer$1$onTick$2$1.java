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
import ru.quickresto.terminal.client.ReplicationService;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "quickresto.webterminal.MainServerBackgroundService$syncTimer$1$onTick$2$1", f = "MainServerBackgroundService.kt", i = {0}, l = {55}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* compiled from: MainServerBackgroundService.kt */
final class MainServerBackgroundService$syncTimer$1$onTick$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReplicationService $this_run;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainServerBackgroundService$syncTimer$1$onTick$2$1(ReplicationService replicationService, Continuation<? super MainServerBackgroundService$syncTimer$1$onTick$2$1> continuation) {
        super(2, continuation);
        this.$this_run = replicationService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MainServerBackgroundService$syncTimer$1$onTick$2$1 mainServerBackgroundService$syncTimer$1$onTick$2$1 = new MainServerBackgroundService$syncTimer$1$onTick$2$1(this.$this_run, continuation);
        mainServerBackgroundService$syncTimer$1$onTick$2$1.L$0 = obj;
        return mainServerBackgroundService$syncTimer$1$onTick$2$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainServerBackgroundService$syncTimer$1$onTick$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.L$0 = (CoroutineScope) this.L$0;
            this.label = 1;
            if (this.$this_run.replicateAllTables(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e) {
                Logger cachedLoggerOf = LoggerKt.cachedLoggerOf(Reflection.getOrCreateKotlinClass(CoroutineScope.class));
                if (cachedLoggerOf.isErrorEnabled()) {
                    LoggerKt.error(cachedLoggerOf, (Throwable) e, (Object) "Replication replicateAllTables exception!");
                }
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
