package quickresto.webterminal;

import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientKt;
import io.ktor.client.engine.cio.CIO;
import java.util.concurrent.BlockingQueue;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.quickresto.terminal.client.ApplicationState;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u000f\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J'\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lquickresto/webterminal/LogsCollectorService;", "", "()V", "applicationState", "Lru/quickresto/terminal/client/ApplicationState;", "getApplicationState", "()Lru/quickresto/terminal/client/ApplicationState;", "logger", "Lorg/slf4j/Logger;", "monitoringUrl", "", "getMonitoringUrl", "()Ljava/lang/String;", "setMonitoringUrl", "(Ljava/lang/String;)V", "readLogs", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendLogs", "guid", "buffer", "Ljava/util/concurrent/BlockingQueue;", "(Ljava/lang/String;Ljava/util/concurrent/BlockingQueue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "webClient", "Lio/ktor/client/HttpClient;", "Companion", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LogsCollectorService.kt */
public final class LogsCollectorService {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MAX_QUEUE_SIZE = 100;
    public static final String preAuthorizationUrl = "https://wtmon.quickresto.ru/logs/unathorized";
    private final ApplicationState applicationState;
    /* access modifiers changed from: private */
    public final Logger logger;
    private String monitoringUrl;

    public LogsCollectorService() {
        Logger logger2 = LoggerFactory.getLogger((Class<?>) LogsCollectorService.class);
        Intrinsics.checkNotNullExpressionValue(logger2, "getLogger(...)");
        this.logger = logger2;
        ApplicationState applicationState2 = ServiceLocator.INSTANCE.applicationState();
        this.applicationState = applicationState2;
        String layer = applicationState2.getLayer();
        this.monitoringUrl = "https://wtmon.quickresto.ru/logs/" + layer + "/" + applicationState2.getTerminalId();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lquickresto/webterminal/LogsCollectorService$Companion;", "", "()V", "MAX_QUEUE_SIZE", "", "preAuthorizationUrl", "", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LogsCollectorService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final ApplicationState getApplicationState() {
        return this.applicationState;
    }

    public final String getMonitoringUrl() {
        return this.monitoringUrl;
    }

    public final void setMonitoringUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.monitoringUrl = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x010c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x010d, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0110, code lost:
        throw r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00dd A[Catch:{ all -> 0x010c }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readLogs(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof quickresto.webterminal.LogsCollectorService$readLogs$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            quickresto.webterminal.LogsCollectorService$readLogs$1 r0 = (quickresto.webterminal.LogsCollectorService$readLogs$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            quickresto.webterminal.LogsCollectorService$readLogs$1 r0 = new quickresto.webterminal.LogsCollectorService$readLogs$1
            r0.<init>(r9, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x004a
            if (r2 != r3) goto L_0x0042
            java.lang.Object r2 = r0.L$4
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r0.L$3
            java.io.Closeable r4 = (java.io.Closeable) r4
            java.lang.Object r5 = r0.L$2
            java.util.concurrent.ArrayBlockingQueue r5 = (java.util.concurrent.ArrayBlockingQueue) r5
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r0.L$0
            quickresto.webterminal.LogsCollectorService r7 = (quickresto.webterminal.LogsCollectorService) r7
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x003f }
            goto L_0x00d7
        L_0x003f:
            r10 = move-exception
            goto L_0x010b
        L_0x0042:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x004a:
            kotlin.ResultKt.throwOnFailure(r10)
            java.util.UUID r10 = java.util.UUID.randomUUID()
            java.lang.String r10 = r10.toString()
            java.lang.String r2 = "randomUUID().toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r2)
            org.slf4j.Logger r2 = r9.logger
            boolean r4 = r2.isWarnEnabled()
            if (r4 == 0) goto L_0x007a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "!!!!!!!!!!!!!!! STARTING READING LOGS "
            r4.<init>(r5)
            java.lang.StringBuilder r4 = r4.append(r10)
            java.lang.String r5 = " !!!!!!!!!!!!!!!!!!!"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            ru.quickresto.slf4j.LoggerKt.warn((org.slf4j.Logger) r2, (java.lang.Object) r4)
        L_0x007a:
            java.util.concurrent.ArrayBlockingQueue r2 = new java.util.concurrent.ArrayBlockingQueue
            r4 = 100
            r2.<init>(r4)
            java.lang.Runtime r4 = java.lang.Runtime.getRuntime()
            java.lang.String r5 = "logcat -c"
            r4.exec(r5)
            java.lang.Runtime r4 = java.lang.Runtime.getRuntime()
            java.lang.String r5 = "logcat"
            java.lang.Process r4 = r4.exec(r5)
            java.io.InputStream r4 = r4.getInputStream()
            java.lang.String r5 = "getRuntime().exec(\"logca…\n            .inputStream"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            java.nio.charset.Charset r5 = kotlin.text.Charsets.UTF_8
            java.io.InputStreamReader r6 = new java.io.InputStreamReader
            r6.<init>(r4, r5)
            java.io.Reader r6 = (java.io.Reader) r6
            boolean r4 = r6 instanceof java.io.BufferedReader
            r5 = 8192(0x2000, float:1.14794E-41)
            if (r4 == 0) goto L_0x00af
            java.io.BufferedReader r6 = (java.io.BufferedReader) r6
            goto L_0x00b5
        L_0x00af:
            java.io.BufferedReader r4 = new java.io.BufferedReader
            r4.<init>(r6, r5)
            r6 = r4
        L_0x00b5:
            java.io.Reader r6 = (java.io.Reader) r6
            boolean r4 = r6 instanceof java.io.BufferedReader
            if (r4 == 0) goto L_0x00be
            java.io.BufferedReader r6 = (java.io.BufferedReader) r6
            goto L_0x00c4
        L_0x00be:
            java.io.BufferedReader r4 = new java.io.BufferedReader
            r4.<init>(r6, r5)
            r6 = r4
        L_0x00c4:
            r4 = r6
            java.io.Closeable r4 = (java.io.Closeable) r4
            r5 = r4
            java.io.BufferedReader r5 = (java.io.BufferedReader) r5     // Catch:{ all -> 0x003f }
            kotlin.sequences.Sequence r5 = kotlin.io.TextStreamsKt.lineSequence(r5)     // Catch:{ all -> 0x003f }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x003f }
            r7 = r9
            r6 = r10
            r8 = r5
            r5 = r2
            r2 = r8
        L_0x00d7:
            boolean r10 = r2.hasNext()     // Catch:{ all -> 0x003f }
            if (r10 == 0) goto L_0x0102
            java.lang.Object r10 = r2.next()     // Catch:{ all -> 0x003f }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x003f }
            r5.add(r10)     // Catch:{ all -> 0x003f }
            int r10 = r5.remainingCapacity()     // Catch:{ all -> 0x003f }
            if (r10 != 0) goto L_0x00d7
            r10 = r5
            java.util.concurrent.BlockingQueue r10 = (java.util.concurrent.BlockingQueue) r10     // Catch:{ all -> 0x003f }
            r0.L$0 = r7     // Catch:{ all -> 0x003f }
            r0.L$1 = r6     // Catch:{ all -> 0x003f }
            r0.L$2 = r5     // Catch:{ all -> 0x003f }
            r0.L$3 = r4     // Catch:{ all -> 0x003f }
            r0.L$4 = r2     // Catch:{ all -> 0x003f }
            r0.label = r3     // Catch:{ all -> 0x003f }
            java.lang.Object r10 = r7.sendLogs(r6, r10, r0)     // Catch:{ all -> 0x003f }
            if (r10 != r1) goto L_0x00d7
            return r1
        L_0x0102:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x003f }
            r10 = 0
            kotlin.io.CloseableKt.closeFinally(r4, r10)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x010b:
            throw r10     // Catch:{ all -> 0x010c }
        L_0x010c:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: quickresto.webterminal.LogsCollectorService.readLogs(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final HttpClient webClient() {
        return HttpClientKt.HttpClient$default(CIO.INSTANCE, (Function1) null, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object sendLogs(String str, BlockingQueue<String> blockingQueue, Continuation<Object> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new LogsCollectorService$sendLogs$2(this, blockingQueue, str, (Continuation<? super LogsCollectorService$sendLogs$2>) null), continuation);
    }
}
