package quickresto.webterminal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import ru.quickresto.terminal.client.api.images.ImageController;
import ru.skornei.restserver.URIListener;
import ru.skornei.restserver.annotations.Produces;
import ru.skornei.restserver.annotations.RestController;
import ru.skornei.restserver.annotations.methods.GET;
import ru.skornei.restserver.server.protocol.RequestInfo;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\b\u0010\u0014\u001a\u00020\u0010H\u0007J\b\u0010\u0015\u001a\u00020\u0010H\u0002J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0007J\b\u0010\u0019\u001a\u00020\u0010H\u0007J\b\u0010\u001a\u001a\u00020\u0010H\u0007J\b\u0010\u001b\u001a\u00020\u0010H\u0007R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lquickresto/webterminal/StaticServer;", "Lru/skornei/restserver/URIListener;", "()V", "controller", "Lru/quickresto/terminal/client/api/images/ImageController;", "getController", "()Lru/quickresto/terminal/client/api/images/ImageController;", "setController", "(Lru/quickresto/terminal/client/api/images/ImageController;)V", "path", "", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "favicon", "", "image", "requestInfo", "Lru/skornei/restserver/server/protocol/RequestInfo;", "index", "response", "setUri", "", "static", "staticCSS", "staticJS", "staticPNG", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@RestController("")
/* compiled from: StaticServer.kt */
public final class StaticServer implements URIListener {
    public static final int $stable = 8;
    private ImageController controller = ServiceLocator.INSTANCE.imageController();
    public String path;

    public final String getPath() {
        String str = this.path;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("path");
        return null;
    }

    public final void setPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.path = str;
    }

    public final ImageController getController() {
        return this.controller;
    }

    public final void setController(ImageController imageController) {
        Intrinsics.checkNotNullParameter(imageController, "<set-?>");
        this.controller = imageController;
    }

    public void setUri(String str) {
        Intrinsics.checkNotNull(str);
        if (Intrinsics.areEqual((Object) str, (Object) "/")) {
            str = "/index.html";
        }
        setPath(str);
    }

    @GET("/static/js/")
    @Produces("text/javascript")
    public final byte[] staticJS() {
        return response();
    }

    @GET("/static/css/")
    @Produces("text/css")
    public final byte[] staticCSS() {
        return response();
    }

    @GET("/images/")
    @Produces("image/png")
    public final byte[] staticPNG() {
        return response();
    }

    @GET("/image/{imageId}")
    @Produces("image/png")
    public final byte[] image(RequestInfo requestInfo) {
        Intrinsics.checkNotNullParameter(requestInfo, "requestInfo");
        return (byte[]) BuildersKt.runBlocking(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null), new StaticServer$image$1(this, requestInfo, (Continuation<? super StaticServer$image$1>) null));
    }

    @GET("/favicon.ico")
    @Produces("image/png")
    public final byte[] favicon() {
        setPath("/favicon.svg");
        return response();
    }

    @GET("/files/")
    @Produces("image/png")
    /* renamed from: static  reason: not valid java name */
    public final byte[] m7226static() {
        setPath("/favicon.svg");
        return response();
    }

    @GET("/")
    @Produces("text/html")
    public final byte[] index() {
        return response();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003a, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0036, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0037, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final byte[] response() {
        /*
            r4 = this;
            quickresto.webterminal.WTApplication$Companion r0 = quickresto.webterminal.WTApplication.Companion
            android.content.Context r0 = r0.getContext()
            android.content.res.AssetManager r0 = r0.getAssets()
            java.lang.String r1 = r4.getPath()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "build"
            r2.<init>(r3)
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r1 = r1.toString()
            java.io.InputStream r0 = r0.open(r1)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = r0
            java.io.InputStream r1 = (java.io.InputStream) r1     // Catch:{ all -> 0x0034 }
            byte[] r1 = org.apache.commons.io.IOUtils.toByteArray((java.io.InputStream) r1)     // Catch:{ all -> 0x0034 }
            r2 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r2)
            java.lang.String r0 = "WTApplication.getContext…IOUtils.toByteArray(it) }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            return r1
        L_0x0034:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0036 }
        L_0x0036:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: quickresto.webterminal.StaticServer.response():byte[]");
    }
}
