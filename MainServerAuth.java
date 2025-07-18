package quickresto.webterminal;

import io.ktor.http.HttpHeaders;
import java.util.Base64;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import ru.skornei.restserver.server.authentication.BaseAuthentication;
import ru.skornei.restserver.server.protocol.RequestInfo;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lquickresto/webterminal/MainServerAuth;", "Lru/skornei/restserver/server/authentication/BaseAuthentication;", "()V", "authentication", "", "requestInfo", "Lru/skornei/restserver/server/protocol/RequestInfo;", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MainServerAuth.kt */
public final class MainServerAuth implements BaseAuthentication {
    public static final int $stable = 0;

    public boolean authentication(RequestInfo requestInfo) {
        Map<String, String> headers;
        if (requestInfo == null || (headers = requestInfo.getHeaders()) == null) {
            return false;
        }
        String lowerCase = HttpHeaders.INSTANCE.getAuthorization().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str = headers.get(lowerCase);
        if (str == null) {
            return false;
        }
        byte[] decode = Base64.getDecoder().decode(StringsKt.substringAfter$default(str, "Basic ", (String) null, 2, (Object) null));
        Intrinsics.checkNotNullExpressionValue(decode, "getDecoder().decode(it.substringAfter(\"Basic \"))");
        ServiceLocator.INSTANCE.applicationState().setBackofficeLayer(StringsKt.trim((CharSequence) StringsKt.substringBefore$default(new String(decode, Charsets.UTF_8), ":", (String) null, 2, (Object) null)).toString(), str);
        return true;
    }
}
