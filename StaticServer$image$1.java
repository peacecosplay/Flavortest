package quickresto.webterminal;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import ru.quickresto.terminal.client.api.images.ImageController;
import ru.skornei.restserver.server.protocol.RequestInfo;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "quickresto.webterminal.StaticServer$image$1", f = "StaticServer.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: StaticServer.kt */
final class StaticServer$image$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {
    final /* synthetic */ RequestInfo $requestInfo;
    int label;
    final /* synthetic */ StaticServer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StaticServer$image$1(StaticServer staticServer, RequestInfo requestInfo, Continuation<? super StaticServer$image$1> continuation) {
        super(2, continuation);
        this.this$0 = staticServer;
        this.$requestInfo = requestInfo;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StaticServer$image$1(this.this$0, this.$requestInfo, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super byte[]> continuation) {
        return ((StaticServer$image$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ImageController controller = this.this$0.getController();
            List<String> list = this.$requestInfo.getParameters().get("param1");
            Intrinsics.checkNotNull(list);
            Object obj2 = list.get(0);
            Intrinsics.checkNotNullExpressionValue(obj2, "requestInfo.parameters[\"param1\"]!![0]");
            this.label = 1;
            obj = controller.image(Integer.parseInt((String) obj2), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
