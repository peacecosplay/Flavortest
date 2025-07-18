package quickresto.webterminal;

import androidx.room.RoomDatabase;
import kotlin.Metadata;
import quickresto.webterminal.database.ApplicationSettingsDocumentRepositoryImpl;
import quickresto.webterminal.database.CancellationReasonDocumentRepositoryImpl;
import quickresto.webterminal.database.ComboDocumentDao;
import quickresto.webterminal.database.CookingPlaceDocumentDao;
import quickresto.webterminal.database.CurrencyDocumentDao;
import quickresto.webterminal.database.DishDocumentDao;
import quickresto.webterminal.database.DishGroupDocumentDao;
import quickresto.webterminal.database.DxBxTaskDocumentDao;
import quickresto.webterminal.database.EncashmentDocumentDao;
import quickresto.webterminal.database.FixedDiscountDocumentDao;
import quickresto.webterminal.database.FixedMarkupDocumentDao;
import quickresto.webterminal.database.ImageDocumentDao;
import quickresto.webterminal.database.KitchenDisplayDocumentDao;
import quickresto.webterminal.database.KkmDeviceDocumentDao;
import quickresto.webterminal.database.MenuDocumentDao;
import quickresto.webterminal.database.ModifierDocumentDao;
import quickresto.webterminal.database.ModifierGroupDocumentDao;
import quickresto.webterminal.database.ModifierLinkDocumentDao;
import quickresto.webterminal.database.NomenclatureItemSaleDocumentDao;
import quickresto.webterminal.database.OnlineInterfaceDocumentDao;
import quickresto.webterminal.database.OnlineOfferDocumentDao;
import quickresto.webterminal.database.OrderDocumentDao;
import quickresto.webterminal.database.OrderDocumentV2Dao;
import quickresto.webterminal.database.OrganizationDocumentDao;
import quickresto.webterminal.database.PaymentTypeDocumentDao;
import quickresto.webterminal.database.PosDeviceDocumentDao;
import quickresto.webterminal.database.PreorderInfoDocumentDao;
import quickresto.webterminal.database.SalePlaceDocumentDao;
import quickresto.webterminal.database.ScheduledDiscountDocumentDao;
import quickresto.webterminal.database.ShiftDocumentDao;
import quickresto.webterminal.database.SoldoutListDocumentDao;
import quickresto.webterminal.database.SpecialSetDocumentDao;
import quickresto.webterminal.database.TableHashDocumentDao;
import quickresto.webterminal.database.TableOrderDocumentDao;
import quickresto.webterminal.database.TableSchemeDocumentDao;
import quickresto.webterminal.database.TagDocumentDao;
import quickresto.webterminal.database.TemplateDocumentDao;
import quickresto.webterminal.database.TerminalDocumentDao;
import quickresto.webterminal.database.TerminalUserDocumentDao;
import quickresto.webterminal.database.TrueApiDocumentDao;
import quickresto.webterminal.database.VirtualKkmDeviceDocumentDao;
import quickresto.webterminal.database.VirtualPosDeviceDocumentDao;
import ru.quickresto.terminal.client.database.SysExtrasDocumentDao;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\u0018H&J\b\u0010\u0019\u001a\u00020\u001aH&J\b\u0010\u001b\u001a\u00020\u001cH&J\b\u0010\u001d\u001a\u00020\u001eH&J\b\u0010\u001f\u001a\u00020 H&J\b\u0010!\u001a\u00020\"H&J\b\u0010#\u001a\u00020$H&J\b\u0010%\u001a\u00020&H&J\b\u0010'\u001a\u00020(H&J\b\u0010)\u001a\u00020*H&J\b\u0010+\u001a\u00020,H&J\b\u0010-\u001a\u00020.H&J\b\u0010/\u001a\u000200H&J\b\u00101\u001a\u000202H&J\b\u00103\u001a\u000204H&J\b\u00105\u001a\u000206H&J\b\u00107\u001a\u000208H&J\b\u00109\u001a\u00020:H&J\b\u0010;\u001a\u00020<H&J\b\u0010=\u001a\u00020>H&J\b\u0010?\u001a\u00020@H&J\b\u0010A\u001a\u00020BH&J\b\u0010C\u001a\u00020DH&J\b\u0010E\u001a\u00020FH&J\b\u0010G\u001a\u00020HH&J\b\u0010I\u001a\u00020JH&J\b\u0010K\u001a\u00020LH&J\b\u0010M\u001a\u00020NH&J\b\u0010O\u001a\u00020PH&J\b\u0010Q\u001a\u00020RH&J\b\u0010S\u001a\u00020TH&J\b\u0010U\u001a\u00020VH&J\b\u0010W\u001a\u00020XH&¨\u0006Y"}, d2 = {"Lquickresto/webterminal/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "applicationSettingsDocumentDao", "Lquickresto/webterminal/database/ApplicationSettingsDocumentRepositoryImpl$ApplicationSettingsDocumentDao;", "cancellationReasonDocumentDao", "Lquickresto/webterminal/database/CancellationReasonDocumentRepositoryImpl$CancellationReasonDocumentDao;", "comboDocumentDao", "Lquickresto/webterminal/database/ComboDocumentDao;", "cookingPlaceDocumentDao", "Lquickresto/webterminal/database/CookingPlaceDocumentDao;", "currencyDocumentDao", "Lquickresto/webterminal/database/CurrencyDocumentDao;", "dishDocumentDao", "Lquickresto/webterminal/database/DishDocumentDao;", "dishGroupDocumentDao", "Lquickresto/webterminal/database/DishGroupDocumentDao;", "dxBxTaskDocumentDao", "Lquickresto/webterminal/database/DxBxTaskDocumentDao;", "encashmentDocumentDao", "Lquickresto/webterminal/database/EncashmentDocumentDao;", "fixedDiscountDocumentDao", "Lquickresto/webterminal/database/FixedDiscountDocumentDao;", "fixedMarkupDocumentDao", "Lquickresto/webterminal/database/FixedMarkupDocumentDao;", "imageDocumentDao", "Lquickresto/webterminal/database/ImageDocumentDao;", "kitchenDisplayDocumentDao", "Lquickresto/webterminal/database/KitchenDisplayDocumentDao;", "kkmDeviceDocumentDao", "Lquickresto/webterminal/database/KkmDeviceDocumentDao;", "menuDocumentDao", "Lquickresto/webterminal/database/MenuDocumentDao;", "modifierDocumentDao", "Lquickresto/webterminal/database/ModifierDocumentDao;", "modifierGroupDocumentDao", "Lquickresto/webterminal/database/ModifierGroupDocumentDao;", "modifierLinkDocumentDao", "Lquickresto/webterminal/database/ModifierLinkDocumentDao;", "nomenclatureItemSaleDocumentDao", "Lquickresto/webterminal/database/NomenclatureItemSaleDocumentDao;", "onlineInterfaceDocumentDao", "Lquickresto/webterminal/database/OnlineInterfaceDocumentDao;", "onlineOfferDocumentDao", "Lquickresto/webterminal/database/OnlineOfferDocumentDao;", "orderDocumentDao", "Lquickresto/webterminal/database/OrderDocumentDao;", "orderDocumentV2Dao", "Lquickresto/webterminal/database/OrderDocumentV2Dao;", "organizationDocumentDao", "Lquickresto/webterminal/database/OrganizationDocumentDao;", "paymentTypeDocumentDao", "Lquickresto/webterminal/database/PaymentTypeDocumentDao;", "posDeviceDocumentDao", "Lquickresto/webterminal/database/PosDeviceDocumentDao;", "preorderInfoDocumentDao", "Lquickresto/webterminal/database/PreorderInfoDocumentDao;", "salePlaceDocumentDao", "Lquickresto/webterminal/database/SalePlaceDocumentDao;", "scheduledDiscountDocumentDao", "Lquickresto/webterminal/database/ScheduledDiscountDocumentDao;", "shiftDocumentDao", "Lquickresto/webterminal/database/ShiftDocumentDao;", "soldoutListDocumentDao", "Lquickresto/webterminal/database/SoldoutListDocumentDao;", "specialSetDocumentDao", "Lquickresto/webterminal/database/SpecialSetDocumentDao;", "sysExtrasDocumentDao", "Lru/quickresto/terminal/client/database/SysExtrasDocumentDao;", "tableHashDocumentDao", "Lquickresto/webterminal/database/TableHashDocumentDao;", "tableOrderDocumentDao", "Lquickresto/webterminal/database/TableOrderDocumentDao;", "tableSchemeDocumentDao", "Lquickresto/webterminal/database/TableSchemeDocumentDao;", "tagDocumentDao", "Lquickresto/webterminal/database/TagDocumentDao;", "templateDocumentDao", "Lquickresto/webterminal/database/TemplateDocumentDao;", "terminalDocumentDao", "Lquickresto/webterminal/database/TerminalDocumentDao;", "terminalUserDocumentDao", "Lquickresto/webterminal/database/TerminalUserDocumentDao;", "trueApiDocumentDao", "Lquickresto/webterminal/database/TrueApiDocumentDao;", "virtualKkmDeviceDocumentDao", "Lquickresto/webterminal/database/VirtualKkmDeviceDocumentDao;", "virtualPosDeviceDocumentDao", "Lquickresto/webterminal/database/VirtualPosDeviceDocumentDao;", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppDatabase.kt */
public abstract class AppDatabase extends RoomDatabase {
    public static final int $stable = 0;

    public abstract ApplicationSettingsDocumentRepositoryImpl.ApplicationSettingsDocumentDao applicationSettingsDocumentDao();

    public abstract CancellationReasonDocumentRepositoryImpl.CancellationReasonDocumentDao cancellationReasonDocumentDao();

    public abstract ComboDocumentDao comboDocumentDao();

    public abstract CookingPlaceDocumentDao cookingPlaceDocumentDao();

    public abstract CurrencyDocumentDao currencyDocumentDao();

    public abstract DishDocumentDao dishDocumentDao();

    public abstract DishGroupDocumentDao dishGroupDocumentDao();

    public abstract DxBxTaskDocumentDao dxBxTaskDocumentDao();

    public abstract EncashmentDocumentDao encashmentDocumentDao();

    public abstract FixedDiscountDocumentDao fixedDiscountDocumentDao();

    public abstract FixedMarkupDocumentDao fixedMarkupDocumentDao();

    public abstract ImageDocumentDao imageDocumentDao();

    public abstract KitchenDisplayDocumentDao kitchenDisplayDocumentDao();

    public abstract KkmDeviceDocumentDao kkmDeviceDocumentDao();

    public abstract MenuDocumentDao menuDocumentDao();

    public abstract ModifierDocumentDao modifierDocumentDao();

    public abstract ModifierGroupDocumentDao modifierGroupDocumentDao();

    public abstract ModifierLinkDocumentDao modifierLinkDocumentDao();

    public abstract NomenclatureItemSaleDocumentDao nomenclatureItemSaleDocumentDao();

    public abstract OnlineInterfaceDocumentDao onlineInterfaceDocumentDao();

    public abstract OnlineOfferDocumentDao onlineOfferDocumentDao();

    public abstract OrderDocumentDao orderDocumentDao();

    public abstract OrderDocumentV2Dao orderDocumentV2Dao();

    public abstract OrganizationDocumentDao organizationDocumentDao();

    public abstract PaymentTypeDocumentDao paymentTypeDocumentDao();

    public abstract PosDeviceDocumentDao posDeviceDocumentDao();

    public abstract PreorderInfoDocumentDao preorderInfoDocumentDao();

    public abstract SalePlaceDocumentDao salePlaceDocumentDao();

    public abstract ScheduledDiscountDocumentDao scheduledDiscountDocumentDao();

    public abstract ShiftDocumentDao shiftDocumentDao();

    public abstract SoldoutListDocumentDao soldoutListDocumentDao();

    public abstract SpecialSetDocumentDao specialSetDocumentDao();

    public abstract SysExtrasDocumentDao sysExtrasDocumentDao();

    public abstract TableHashDocumentDao tableHashDocumentDao();

    public abstract TableOrderDocumentDao tableOrderDocumentDao();

    public abstract TableSchemeDocumentDao tableSchemeDocumentDao();

    public abstract TagDocumentDao tagDocumentDao();

    public abstract TemplateDocumentDao templateDocumentDao();

    public abstract TerminalDocumentDao terminalDocumentDao();

    public abstract TerminalUserDocumentDao terminalUserDocumentDao();

    public abstract TrueApiDocumentDao trueApiDocumentDao();

    public abstract VirtualKkmDeviceDocumentDao virtualKkmDeviceDocumentDao();

    public abstract VirtualPosDeviceDocumentDao virtualPosDeviceDocumentDao();
}
