package quickresto.webterminal;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "quickresto.webterminal.MainServerBackgroundService$onDestroy$2", f = "MainServerBackgroundService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: MainServerBackgroundService.kt */
final class MainServerBackgroundService$onDestroy$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MainServerBackgroundService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainServerBackgroundService$onDestroy$2(MainServerBackgroundService mainServerBackgroundService, Continuation<? super MainServerBackgroundService$onDestroy$2> continuation) {
        super(2, continuation);
        this.this$0 = mainServerBackgroundService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainServerBackgroundService$onDestroy$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainServerBackgroundService$onDestroy$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Job readLogsJob = this.this$0.getReadLogsJob();
            if (readLogsJob != null) {
                readLogsJob.cancel(new CancellationException("Enough"));
            }
            Job migrationJob = this.this$0.getMigrationJob();
            if (migrationJob != null) {
                migrationJob.cancel(new CancellationException("Enough"));
            }
            this.this$0.setReadLogsJob((Job) null);
            this.this$0.setMigrationJob((Job) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
