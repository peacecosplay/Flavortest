package quickresto.webterminal;

import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import com.google.firebase.crashlytics.ktx.FirebaseCrashlyticsKt;
import com.google.firebase.ktx.Firebase;
import java.lang.Thread;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lquickresto/webterminal/FirebaseCrashlyticsLogbackAppender;", "Lch/qos/logback/core/AppenderBase;", "Lch/qos/logback/classic/spi/ILoggingEvent;", "()V", "encoder", "Lch/qos/logback/classic/encoder/PatternLayoutEncoder;", "getEncoder", "()Lch/qos/logback/classic/encoder/PatternLayoutEncoder;", "setEncoder", "(Lch/qos/logback/classic/encoder/PatternLayoutEncoder;)V", "append", "", "eventObject", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FirebaseCrashlyticsLogbackAppender.kt */
public final class FirebaseCrashlyticsLogbackAppender extends AppenderBase<ILoggingEvent> {
    public static final int $stable = 8;
    public PatternLayoutEncoder encoder;

    public FirebaseCrashlyticsLogbackAppender() {
        Thread.setDefaultUncaughtExceptionHandler(new FirebaseCrashlyticsLogbackAppender$$ExternalSyntheticLambda0(Thread.getDefaultUncaughtExceptionHandler()));
    }

    public final PatternLayoutEncoder getEncoder() {
        PatternLayoutEncoder patternLayoutEncoder = this.encoder;
        if (patternLayoutEncoder != null) {
            return patternLayoutEncoder;
        }
        Intrinsics.throwUninitializedPropertyAccessException("encoder");
        return null;
    }

    public final void setEncoder(PatternLayoutEncoder patternLayoutEncoder) {
        Intrinsics.checkNotNullParameter(patternLayoutEncoder, "<set-?>");
        this.encoder = patternLayoutEncoder;
    }

    /* access modifiers changed from: protected */
    public void append(ILoggingEvent iLoggingEvent) {
        Intrinsics.checkNotNullParameter(iLoggingEvent, "eventObject");
        if (isStarted()) {
            FirebaseCrashlyticsKt.getCrashlytics(Firebase.INSTANCE).log(getEncoder().getLayout().doLayout(iLoggingEvent));
        }
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Thread thread, Throwable th) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException unused) {
        }
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
