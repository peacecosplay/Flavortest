package quickresto.webterminal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.kotlin.ExtensionsKt;
import java.time.LocalDateTime;
import kotlin.Metadata;
import ru.quickresto.terminal.common.TerminalDeviceShift;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\b"}, d2 = {"Lquickresto/webterminal/TerminalDeviceShiftConverter;", "Lquickresto/webterminal/JacksonConverter;", "()V", "fromJson", "Lru/quickresto/terminal/common/TerminalDeviceShift;", "value", "", "toJson", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppDatabase.kt */
public final class TerminalDeviceShiftConverter extends JacksonConverter {
    public static final int $stable = 0;

    public final String toJson(TerminalDeviceShift terminalDeviceShift) {
        if (terminalDeviceShift == null) {
            return null;
        }
        return getObjectMapper().writeValueAsString(terminalDeviceShift);
    }

    public final TerminalDeviceShift fromJson(String str) {
        if (str == null) {
            return null;
        }
        try {
            return (TerminalDeviceShift) getObjectMapper().readValue(str, TerminalDeviceShift.class);
        } catch (Throwable unused) {
            ObjectMapper objectMapper = new ObjectMapper();
            JavaTimeModule javaTimeModule = new JavaTimeModule();
            javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDoubleDeserializer());
            objectMapper.registerModule(javaTimeModule);
            ExtensionsKt.registerKotlinModule(objectMapper);
            return (TerminalDeviceShift) objectMapper.readValue(str, TerminalDeviceShift.class);
        }
    }
}
