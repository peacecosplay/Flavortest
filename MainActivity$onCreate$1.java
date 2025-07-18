package quickresto.webterminal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "quickresto.webterminal.MainActivity$onCreate$1", f = "MainActivity.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: MainActivity.kt */
final class MainActivity$onCreate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ MainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainActivity$onCreate$1(MainActivity mainActivity, Continuation<? super MainActivity$onCreate$1> continuation) {
        super(2, continuation);
        this.this$0 = mainActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivity$onCreate$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivity$onCreate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            java.lang.Object r1 = r8.L$0
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            kotlin.ResultKt.throwOnFailure(r9)
            r3 = r1
            r1 = r0
            r0 = r8
            goto L_0x0040
        L_0x0016:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r9)
            quickresto.webterminal.MainActivity$Companion r9 = quickresto.webterminal.MainActivity.Companion
            kotlinx.coroutines.channels.Channel r9 = r9.getActivationServer()
            kotlinx.coroutines.channels.ChannelIterator r9 = r9.iterator()
            r1 = r9
            r9 = r8
        L_0x002d:
            r3 = r9
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r9.L$0 = r1
            r9.label = r2
            java.lang.Object r3 = r1.hasNext(r3)
            if (r3 != r0) goto L_0x003b
            return r0
        L_0x003b:
            r7 = r0
            r0 = r9
            r9 = r3
            r3 = r1
            r1 = r7
        L_0x0040:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x0090
            r3.next()
            quickresto.webterminal.MainActivity r9 = r0.this$0
            android.app.Application r9 = r9.getApplication()
            ru.skornei.restserver.RestServerManager.initialize(r9)
            quickresto.webterminal.MainActivity r9 = r0.this$0
            org.slf4j.Logger r9 = r9.logger
            quickresto.webterminal.MainActivity$onCreate$1$1 r4 = quickresto.webterminal.MainActivity$onCreate$1.AnonymousClass1.INSTANCE
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            ru.quickresto.slf4j.LoggerKt.info((org.slf4j.Logger) r9, (kotlin.jvm.functions.Function0<? extends java.lang.Object>) r4)
            quickresto.webterminal.MainActivity r9 = r0.this$0
            quickresto.webterminal.MainServer r9 = r9.getServer()
            java.lang.Boolean r9 = r9.isStarted()
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L_0x007a
            quickresto.webterminal.MainActivity r9 = r0.this$0
            quickresto.webterminal.MainServer r9 = r9.getServer()
            r9.start()
        L_0x007a:
            quickresto.webterminal.MainActivity r9 = r0.this$0
            android.content.Intent r4 = new android.content.Intent
            quickresto.webterminal.MainActivity r5 = r0.this$0
            android.content.Context r5 = r5.getApplicationContext()
            java.lang.Class<quickresto.webterminal.MainServerBackgroundService> r6 = quickresto.webterminal.MainServerBackgroundService.class
            r4.<init>(r5, r6)
            r9.startService(r4)
            r9 = r0
            r0 = r1
            r1 = r3
            goto L_0x002d
        L_0x0090:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: quickresto.webterminal.MainActivity$onCreate$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
