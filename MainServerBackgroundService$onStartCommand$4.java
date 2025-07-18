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
@DebugMetadata(c = "quickresto.webterminal.MainServerBackgroundService$onStartCommand$4", f = "MainServerBackgroundService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: MainServerBackgroundService.kt */
final class MainServerBackgroundService$onStartCommand$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MainServerBackgroundService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainServerBackgroundService$onStartCommand$4(MainServerBackgroundService mainServerBackgroundService, Continuation<? super MainServerBackgroundService$onStartCommand$4> continuation) {
        super(2, continuation);
        this.this$0 = mainServerBackgroundService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MainServerBackgroundService$onStartCommand$4 mainServerBackgroundService$onStartCommand$4 = new MainServerBackgroundService$onStartCommand$4(this.this$0, continuation);
        mainServerBackgroundService$onStartCommand$4.L$0 = obj;
        return mainServerBackgroundService$onStartCommand$4;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainServerBackgroundService$onStartCommand$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Logger cachedLoggerOf = LoggerKt.cachedLoggerOf(Reflection.getOrCreateKotlinClass(CoroutineScope.class));
            if (cachedLoggerOf.isWarnEnabled()) {
                LoggerKt.warn(cachedLoggerOf, (Object) "!!!!!!!!!!!!!!! Migration Start !!!!!!!!!!!!!!!!!!!");
            }
            try {
                this.this$0.getMigrationDatabaseService().migrate();
            } catch (Exception e) {
                LoggerKt.warn$default(LoggerKt.cachedLoggerOf(Reflection.getOrCreateKotlinClass(CoroutineScope.class)), e, (Object) null, 2, (Object) null);
            }
            Logger cachedLoggerOf2 = LoggerKt.cachedLoggerOf(Reflection.getOrCreateKotlinClass(CoroutineScope.class));
            if (cachedLoggerOf2.isWarnEnabled()) {
                LoggerKt.warn(cachedLoggerOf2, (Object) "!!!!!!!!!!!!!!! Migration End !!!!!!!!!!!!!!!!!!!");
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
