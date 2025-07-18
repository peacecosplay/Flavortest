package quickresto.webterminal;

import java.util.concurrent.BlockingQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "quickresto.webterminal.LogsCollectorService$sendLogs$2", f = "LogsCollectorService.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LogsCollectorService.kt */
final class LogsCollectorService$sendLogs$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
    final /* synthetic */ BlockingQueue<String> $buffer;
    final /* synthetic */ String $guid;
    Object L$0;
    int label;
    final /* synthetic */ LogsCollectorService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LogsCollectorService$sendLogs$2(LogsCollectorService logsCollectorService, BlockingQueue<String> blockingQueue, String str, Continuation<? super LogsCollectorService$sendLogs$2> continuation) {
        super(2, continuation);
        this.this$0 = logsCollectorService;
        this.$buffer = blockingQueue;
        this.$guid = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LogsCollectorService$sendLogs$2(this.this$0, this.$buffer, this.$guid, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<Object> continuation) {
        return ((LogsCollectorService$sendLogs$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.io.Closeable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            r19 = this;
            r1 = r19
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0026
            if (r2 != r3) goto L_0x001e
            java.lang.Object r0 = r1.L$0
            r2 = r0
            java.io.Closeable r2 = (java.io.Closeable) r2
            kotlin.ResultKt.throwOnFailure(r20)     // Catch:{ all -> 0x001a }
            r3 = r20
            goto L_0x00d5
        L_0x001a:
            r0 = move-exception
            r3 = r0
            goto L_0x00e0
        L_0x001e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r20)
            quickresto.webterminal.LogsCollectorService r2 = r1.this$0     // Catch:{ Exception -> 0x00e9 }
            io.ktor.client.HttpClient r2 = r2.webClient()     // Catch:{ Exception -> 0x00e9 }
            java.io.Closeable r2 = (java.io.Closeable) r2     // Catch:{ Exception -> 0x00e9 }
            quickresto.webterminal.LogsCollectorService r5 = r1.this$0     // Catch:{ Exception -> 0x00e9 }
            java.util.concurrent.BlockingQueue<java.lang.String> r6 = r1.$buffer     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r7 = r1.$guid     // Catch:{ Exception -> 0x00e9 }
            r8 = r2
            io.ktor.client.HttpClient r8 = (io.ktor.client.HttpClient) r8     // Catch:{ all -> 0x001a }
            ru.quickresto.terminal.client.ApplicationState r9 = r5.getApplicationState()     // Catch:{ all -> 0x001a }
            java.lang.String r9 = r9.getLayer()     // Catch:{ all -> 0x001a }
            if (r9 == 0) goto L_0x004a
            java.lang.String r5 = r5.getMonitoringUrl()     // Catch:{ all -> 0x001a }
            if (r5 != 0) goto L_0x004c
        L_0x004a:
            java.lang.String r5 = "https://wtmon.quickresto.ru/logs/unathorized"
        L_0x004c:
            io.ktor.client.request.HttpRequestBuilder r9 = new io.ktor.client.request.HttpRequestBuilder     // Catch:{ all -> 0x001a }
            r9.<init>()     // Catch:{ all -> 0x001a }
            io.ktor.client.request.HttpRequestKt.url((io.ktor.client.request.HttpRequestBuilder) r9, (java.lang.String) r5)     // Catch:{ all -> 0x001a }
            r10 = r6
            java.lang.Iterable r10 = (java.lang.Iterable) r10     // Catch:{ all -> 0x001a }
            java.lang.String r5 = java.lang.System.lineSeparator()     // Catch:{ all -> 0x001a }
            java.lang.String r6 = "lineSeparator()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch:{ all -> 0x001a }
            r11 = r5
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ all -> 0x001a }
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            quickresto.webterminal.LogsCollectorService$sendLogs$2$1$2$1 r5 = new quickresto.webterminal.LogsCollectorService$sendLogs$2$1$2$1     // Catch:{ all -> 0x001a }
            r5.<init>(r7)     // Catch:{ all -> 0x001a }
            r16 = r5
            kotlin.jvm.functions.Function1 r16 = (kotlin.jvm.functions.Function1) r16     // Catch:{ all -> 0x001a }
            r17 = 30
            r18 = 0
            java.lang.String r5 = kotlin.collections.CollectionsKt.joinToString$default(r10, r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x001a }
            if (r5 != 0) goto L_0x0097
            io.ktor.http.content.NullBody r5 = io.ktor.http.content.NullBody.INSTANCE     // Catch:{ all -> 0x001a }
            r9.setBody(r5)     // Catch:{ all -> 0x001a }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            kotlin.reflect.KType r5 = kotlin.jvm.internal.Reflection.typeOf((java.lang.Class) r5)     // Catch:{ all -> 0x001a }
            java.lang.reflect.Type r6 = kotlin.reflect.TypesJVMKt.getJavaType((kotlin.reflect.KType) r5)     // Catch:{ all -> 0x001a }
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            kotlin.reflect.KClass r7 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r7)     // Catch:{ all -> 0x001a }
            io.ktor.util.reflect.TypeInfo r5 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r6, r7, r5)     // Catch:{ all -> 0x001a }
            r9.setBodyType(r5)     // Catch:{ all -> 0x001a }
            goto L_0x00bc
        L_0x0097:
            boolean r6 = r5 instanceof io.ktor.http.content.OutgoingContent     // Catch:{ all -> 0x001a }
            if (r6 == 0) goto L_0x00a2
            r9.setBody(r5)     // Catch:{ all -> 0x001a }
            r9.setBodyType(r4)     // Catch:{ all -> 0x001a }
            goto L_0x00bc
        L_0x00a2:
            r9.setBody(r5)     // Catch:{ all -> 0x001a }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            kotlin.reflect.KType r5 = kotlin.jvm.internal.Reflection.typeOf((java.lang.Class) r5)     // Catch:{ all -> 0x001a }
            java.lang.reflect.Type r6 = kotlin.reflect.TypesJVMKt.getJavaType((kotlin.reflect.KType) r5)     // Catch:{ all -> 0x001a }
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            kotlin.reflect.KClass r7 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r7)     // Catch:{ all -> 0x001a }
            io.ktor.util.reflect.TypeInfo r5 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r6, r7, r5)     // Catch:{ all -> 0x001a }
            r9.setBodyType(r5)     // Catch:{ all -> 0x001a }
        L_0x00bc:
            io.ktor.http.HttpMethod$Companion r5 = io.ktor.http.HttpMethod.Companion     // Catch:{ all -> 0x001a }
            io.ktor.http.HttpMethod r5 = r5.getPost()     // Catch:{ all -> 0x001a }
            r9.setMethod(r5)     // Catch:{ all -> 0x001a }
            io.ktor.client.statement.HttpStatement r5 = new io.ktor.client.statement.HttpStatement     // Catch:{ all -> 0x001a }
            r5.<init>(r9, r8)     // Catch:{ all -> 0x001a }
            r1.L$0 = r2     // Catch:{ all -> 0x001a }
            r1.label = r3     // Catch:{ all -> 0x001a }
            java.lang.Object r3 = r5.execute(r1)     // Catch:{ all -> 0x001a }
            if (r3 != r0) goto L_0x00d5
            return r0
        L_0x00d5:
            io.ktor.client.statement.HttpResponse r3 = (io.ktor.client.statement.HttpResponse) r3     // Catch:{ all -> 0x001a }
            kotlin.io.CloseableKt.closeFinally(r2, r4)     // Catch:{ Exception -> 0x00e9 }
        L_0x00da:
            java.util.concurrent.BlockingQueue<java.lang.String> r0 = r1.$buffer
            r0.clear()
            goto L_0x00f9
        L_0x00e0:
            throw r3     // Catch:{ all -> 0x00e1 }
        L_0x00e1:
            r0 = move-exception
            r5 = r0
            kotlin.io.CloseableKt.closeFinally(r2, r3)     // Catch:{ Exception -> 0x00e9 }
            throw r5     // Catch:{ Exception -> 0x00e9 }
        L_0x00e7:
            r0 = move-exception
            goto L_0x00fa
        L_0x00e9:
            r0 = move-exception
            quickresto.webterminal.LogsCollectorService r2 = r1.this$0     // Catch:{ all -> 0x00e7 }
            org.slf4j.Logger r2 = r2.logger     // Catch:{ all -> 0x00e7 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x00e7 }
            r3 = 2
            ru.quickresto.slf4j.LoggerKt.error$default(r2, r0, r4, r3, r4)     // Catch:{ all -> 0x00e7 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00e7 }
            goto L_0x00da
        L_0x00f9:
            return r3
        L_0x00fa:
            java.util.concurrent.BlockingQueue<java.lang.String> r2 = r1.$buffer
            r2.clear()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: quickresto.webterminal.LogsCollectorService$sendLogs$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
