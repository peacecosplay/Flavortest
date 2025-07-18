package quickresto.webterminal;

import android.os.Build;
import java.net.InetAddress;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.quickresto.terminal.client.DeviceInformationService;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\f\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u001c\u0010\u000e\u001a\n \u000f*\u0004\u0018\u00010\u00030\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0005R\u0014\u0010\u0011\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0005R\u001c\u0010\u0013\u001a\n \u000f*\u0004\u0018\u00010\u00030\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0005R\u001c\u0010\u0015\u001a\n \u000f*\u0004\u0018\u00010\u00030\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0005¨\u0006\u0017"}, d2 = {"quickresto/webterminal/ServiceLocator$androidDeviceInformationService$1", "Lru/quickresto/terminal/client/DeviceInformationService;", "appPlatform", "", "getAppPlatform", "()Ljava/lang/String;", "appVersion", "getAppVersion", "applicationId", "getApplicationId", "buildVersion", "getBuildVersion", "deviceIP", "getDeviceIP", "deviceManufacturer", "kotlin.jvm.PlatformType", "getDeviceManufacturer", "deviceModel", "getDeviceModel", "deviceTitle", "getDeviceTitle", "osVersion", "getOsVersion", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ServiceLocator.kt */
public final class ServiceLocator$androidDeviceInformationService$1 implements DeviceInformationService {
    private final String appPlatform;
    private final String appVersion;
    private final String applicationId;
    private final String buildVersion;
    private final String deviceManufacturer;
    private final String deviceModel;
    private final String deviceTitle;
    private final String osVersion = Build.VERSION.RELEASE;

    ServiceLocator$androidDeviceInformationService$1() {
        String str = Build.BRAND;
        this.deviceModel = str + ", " + Build.MODEL;
        this.deviceTitle = Build.BOARD;
        this.deviceManufacturer = Build.MANUFACTURER;
        this.appVersion = BuildConfig.VERSION_NAME;
        this.buildVersion = "254";
        this.appPlatform = "android";
        this.applicationId = BuildConfig.APPLICATION_ID;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public String getDeviceTitle() {
        return this.deviceTitle;
    }

    public String getDeviceManufacturer() {
        return this.deviceManufacturer;
    }

    public String getDeviceIP() {
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        Intrinsics.checkNotNull(hostAddress);
        return hostAddress;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getBuildVersion() {
        return this.buildVersion;
    }

    public String getAppPlatform() {
        return this.appPlatform;
    }

    public String getApplicationId() {
        return this.applicationId;
    }
}
