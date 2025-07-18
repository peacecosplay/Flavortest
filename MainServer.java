package quickresto.webterminal;

import kotlin.Metadata;
import quickresto.webterminal.api.AppContainerControllerImpl;
import quickresto.webterminal.api.ApplicationControllerImpl;
import quickresto.webterminal.api.CancellationReasonsControllerImpl;
import quickresto.webterminal.api.CookingPlacesControllerImpl;
import quickresto.webterminal.api.CrmCustomerControllerImpl;
import quickresto.webterminal.api.DictionariesControllerImpl;
import quickresto.webterminal.api.FindDevicesControllerImpl;
import quickresto.webterminal.api.FixedDiscountsControllerImpl;
import quickresto.webterminal.api.FixedMarkupsControllerImpl;
import quickresto.webterminal.api.KitchenDisplayControllerImpl;
import quickresto.webterminal.api.MenuControllerImpl;
import quickresto.webterminal.api.ModifierLinksControllerImpl;
import quickresto.webterminal.api.ModifiersControllerImpl;
import quickresto.webterminal.api.NomenclatureItemSalesControllerImpl;
import quickresto.webterminal.api.NomenclatureItemsControllerImpl;
import quickresto.webterminal.api.OffersControllerImpl;
import quickresto.webterminal.api.OnlineOfferControllerImpl;
import quickresto.webterminal.api.OrdersControllerImpl;
import quickresto.webterminal.api.OrganizationsControllerImpl;
import quickresto.webterminal.api.PaymentTypesControllerImpl;
import quickresto.webterminal.api.PreordersControllerImpl;
import quickresto.webterminal.api.RealKkmDevicesControllerImpl;
import quickresto.webterminal.api.RealPosDevicesControllerImpl;
import quickresto.webterminal.api.SalePlacesControllerImpl;
import quickresto.webterminal.api.SoldoutListControllerImpl;
import quickresto.webterminal.api.SupportServiceControllerImpl;
import quickresto.webterminal.api.TableSchemasControllerImpl;
import quickresto.webterminal.api.TagsControllerImpl;
import quickresto.webterminal.api.TerminalUsersControllerImpl;
import quickresto.webterminal.api.VirtualKkmDevicesControllerImpl;
import quickresto.webterminal.api.VirtualPosDevicesControllerImpl;
import ru.skornei.restserver.annotations.RestServer;
import ru.skornei.restserver.server.BaseRestServer;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lquickresto/webterminal/MainServer;", "Lru/skornei/restserver/server/BaseRestServer;", "()V", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@RestServer(authentication = MainServerAuth.class, controllers = {DebugServer.class, StaticServer.class, PaymentTypesControllerImpl.class, ApplicationControllerImpl.class, TableSchemasControllerImpl.class, SalePlacesControllerImpl.class, TerminalUsersControllerImpl.class, OrganizationsControllerImpl.class, CookingPlacesControllerImpl.class, VirtualKkmDevicesControllerImpl.class, VirtualPosDevicesControllerImpl.class, ModifierLinksControllerImpl.class, ModifiersControllerImpl.class, NomenclatureItemSalesControllerImpl.class, NomenclatureItemsControllerImpl.class, PaymentTypesControllerImpl.class, RealKkmDevicesControllerImpl.class, RealPosDevicesControllerImpl.class, KitchenDisplayControllerImpl.class, OrdersControllerImpl.class, FixedDiscountsControllerImpl.class, FixedMarkupsControllerImpl.class, CancellationReasonsControllerImpl.class, OffersControllerImpl.class, TagsControllerImpl.class, DictionariesControllerImpl.class, FindDevicesControllerImpl.class, CrmCustomerControllerImpl.class, PreordersControllerImpl.class, SoldoutListControllerImpl.class, OnlineOfferControllerImpl.class, AppContainerControllerImpl.class, SupportServiceControllerImpl.class, MenuControllerImpl.class}, converter = WebJsonConverter.class, port = 8181)
/* compiled from: MainServer.kt */
public final class MainServer extends BaseRestServer {
    public static final int $stable = 0;
}
