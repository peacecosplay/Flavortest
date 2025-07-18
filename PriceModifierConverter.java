package quickresto.webterminal;

import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.quickresto.terminal.common.PriceModifier;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J,\u0010\t\u001a\u00020\b2\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006H\u0007¨\u0006\u000b"}, d2 = {"Lquickresto/webterminal/PriceModifierConverter;", "Lquickresto/webterminal/JacksonConverter;", "()V", "fromBigDecimal", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "value", "Lru/quickresto/terminal/common/PriceModifier;", "toOrderItemDocument", "map", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppDatabase.kt */
public final class PriceModifierConverter extends JacksonConverter {
    public static final int $stable = 0;

    public final PriceModifier toOrderItemDocument(LinkedHashMap<Object, Object> linkedHashMap) {
        Intrinsics.checkNotNullParameter(linkedHashMap, "map");
        Object convertValue = getObjectMapper().convertValue((Object) linkedHashMap, PriceModifier.class);
        Intrinsics.checkNotNullExpressionValue(convertValue, "objectMapper.convertValu…riceModifier::class.java)");
        return (PriceModifier) convertValue;
    }

    public final LinkedHashMap<Object, Object> fromBigDecimal(PriceModifier priceModifier) {
        Intrinsics.checkNotNullParameter(priceModifier, "value");
        Object convertValue = getObjectMapper().convertValue((Object) priceModifier, new PriceModifierConverter$fromBigDecimal$1());
        Intrinsics.checkNotNullExpressionValue(convertValue, "objectMapper.convertValu…dHashMap<Any, Any>>() {})");
        return (LinkedHashMap) convertValue;
    }
}
