package quickresto.webterminal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;
import ru.quickresto.slf4j.LoggerKt;
import ru.skornei.restserver.server.converter.BaseConverter;
import ru.skornei.restserver.server.dictionary.ContentType;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J-\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u0002H\n\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lquickresto/webterminal/WebJsonConverter;", "Lru/skornei/restserver/server/converter/BaseConverter;", "()V", "logger", "Lorg/slf4j/Logger;", "mapper", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "getMapper", "()Lcom/fasterxml/jackson/databind/ObjectMapper;", "writeValue", "T", "src", "", "valueType", "Ljava/lang/Class;", "([BLjava/lang/Class;)Ljava/lang/Object;", "writeValueAsBytes", "value", "", "contentType", "", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: WebJsonConverter.kt */
public final class WebJsonConverter implements BaseConverter {
    public static final int $stable = 8;
    private final Logger logger;
    private final ObjectMapper mapper = ServiceLocator.INSTANCE.objectMapper();

    public WebJsonConverter() {
        Logger logger2 = LoggerFactory.getLogger((Class<?>) WebJsonConverter.class);
        Intrinsics.checkNotNullExpressionValue(logger2, "getLogger(...)");
        this.logger = logger2;
    }

    public final ObjectMapper getMapper() {
        return this.mapper;
    }

    public byte[] writeValueAsBytes(Object obj) {
        byte[] bytes = String.valueOf(obj).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    public byte[] writeValueAsBytes(Object obj, String str) {
        if (Intrinsics.areEqual((Object) "application/json", (Object) str)) {
            if (obj instanceof Mono) {
                try {
                    Object block = ((Mono) obj).block();
                    if (block == null) {
                        return new byte[0];
                    }
                    byte[] writeValueAsBytes = this.mapper.writeValueAsBytes(block);
                    Intrinsics.checkNotNullExpressionValue(writeValueAsBytes, "mapper.writeValueAsBytes(resultValue)");
                    return writeValueAsBytes;
                } catch (Exception e) {
                    LoggerKt.error$default(this.logger, e, (Object) null, 2, (Object) null);
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                byte[] writeValueAsBytes2 = this.mapper.writeValueAsBytes(obj);
                Logger logger2 = this.logger;
                if (logger2.isWarnEnabled()) {
                    Intrinsics.checkNotNullExpressionValue(writeValueAsBytes2, "bytes");
                    LoggerKt.warn(logger2, (Object) "RS (" + (((double) (System.currentTimeMillis() - currentTimeMillis)) / 1000.0d) + ")>" + new String(writeValueAsBytes2, Charsets.UTF_8));
                }
                Intrinsics.checkNotNullExpressionValue(writeValueAsBytes2, "bytes");
                return writeValueAsBytes2;
            }
        } else if (Intrinsics.areEqual((Object) ContentType.IMAGE_PNG, (Object) str)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.ByteArray");
            return (byte[]) obj;
        } else {
            if (Intrinsics.areEqual((Object) "text/plain", (Object) str)) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                byte[] bytes = ((String) obj).getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                return bytes;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.ByteArray");
            return (byte[]) obj;
        }
    }

    public <T> T writeValue(byte[] bArr, Class<T> cls) {
        try {
            return this.mapper.readValue(bArr, cls);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
