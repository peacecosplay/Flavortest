package quickresto.webterminal;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import reactor.core.publisher.Mono;
import ru.quickresto.terminal.client.versioning.TerminalVersionService;
import ru.quickresto.terminal.common.ApplyResponse;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u001c\u0010\r\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000e0\u0007H\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000f"}, d2 = {"quickresto/webterminal/ServiceLocator$terminalVersionService$1", "Lru/quickresto/terminal/client/versioning/TerminalVersionService;", "appVersion", "", "getAppVersion", "()Ljava/lang/String;", "applyVersion", "Lreactor/core/publisher/Mono;", "Lru/quickresto/terminal/common/ApplyResponse;", "notifyCurrentVersion", "", "version", "notifyNewVersion", "versions", "Lkotlin/Pair;", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ServiceLocator.kt */
public final class ServiceLocator$terminalVersionService$1 implements TerminalVersionService {
    public String getAppVersion() {
        return "9.5.7 (254)";
    }

    public void notifyCurrentVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "version");
    }

    public void notifyNewVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "version");
    }

    ServiceLocator$terminalVersionService$1() {
    }

    public Mono<Pair<String, String>> versions() {
        Mono<Pair<String, String>> just = Mono.just(new Pair(getAppVersion(), null));
        Intrinsics.checkNotNullExpressionValue(just, "just(Pair(appVersion, null))");
        return just;
    }

    public Mono<ApplyResponse> applyVersion() {
        Mono<ApplyResponse> just = Mono.just(new ApplyResponse("", (List) null, 2, (DefaultConstructorMarker) null));
        Intrinsics.checkNotNullExpressionValue(just, "just(\n                Ap…          )\n            )");
        return just;
    }
}
