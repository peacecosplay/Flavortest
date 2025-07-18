package quickresto.webterminal;

import com.fasterxml.jackson.databind.ObjectMapper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import quickresto.webterminal.container.AndroidAppContainerService;
import quickresto.webterminal.database.ApplicationSettingsDocumentRepositoryImpl;
import quickresto.webterminal.database.CancellationReasonDocumentRepositoryImpl;
import quickresto.webterminal.database.ComboOffersDocumentRepositoryImpl;
import quickresto.webterminal.database.CookingPlaceDocumentRepositoryImpl;
import quickresto.webterminal.database.CurrencyDocumentRepositoryImpl;
import quickresto.webterminal.database.DishDocumentRepositoryImpl;
import quickresto.webterminal.database.DishGroupDocumentRepositoryImpl;
import quickresto.webterminal.database.DxBxTaskDocumentRepositoryImpl;
import quickresto.webterminal.database.EncashmentDocumentRepositoryImpl;
import quickresto.webterminal.database.FixedDiscountDocumentRepositoryImpl;
import quickresto.webterminal.database.FixedMarkupDocumentRepositoryImpl;
import quickresto.webterminal.database.ImageDocumentRepositoryImpl;
import quickresto.webterminal.database.KitchenDisplayDocumentRepositoryImpl;
import quickresto.webterminal.database.KkmDeviceDocumentRepositoryImpl;
import quickresto.webterminal.database.MenuDocumentRepositoryImpl;
import quickresto.webterminal.database.ModifierDocumentRepositoryImpl;
import quickresto.webterminal.database.ModifierGroupDocumentRepositoryImpl;
import quickresto.webterminal.database.ModifierLinkDocumentRepositoryImpl;
import quickresto.webterminal.database.NomenclatureItemSaleDocumentRepositoryImpl;
import quickresto.webterminal.database.OnlineInterfaceDocumentRepositoryImpl;
import quickresto.webterminal.database.OnlineOfferDocumentRepositoryImpl;
import quickresto.webterminal.database.OrderDocumentRepositoryImpl;
import quickresto.webterminal.database.OrderDocumentV2RepositoryImpl;
import quickresto.webterminal.database.OrganizationDocumentRepositoryImpl;
import quickresto.webterminal.database.PaymentTypeDocumentRepositoryImpl;
import quickresto.webterminal.database.PosDeviceDocumentRepositoryImpl;
import quickresto.webterminal.database.PosPaymentDocumentRepositoryImpl;
import quickresto.webterminal.database.PosRefundDocumentRepositoryImpl;
import quickresto.webterminal.database.PosShiftDocumentRepositoryImpl;
import quickresto.webterminal.database.PreorderInfoDocumentRepositoryImpl;
import quickresto.webterminal.database.SalePlaceDocumentRepositoryImpl;
import quickresto.webterminal.database.ScheduledDiscountDocumentRepositoryImpl;
import quickresto.webterminal.database.ShiftDocumentRepositoryImpl;
import quickresto.webterminal.database.SoldoutListDocumentRepositoryImpl;
import quickresto.webterminal.database.SpecialSetDocumentRepositoryImpl;
import quickresto.webterminal.database.SysExtrasDocumentRepositoryImpl;
import quickresto.webterminal.database.TableHashDocumentRepositoryImpl;
import quickresto.webterminal.database.TableOrderDocumentRepositoryImpl;
import quickresto.webterminal.database.TableSchemeDocumentRepositoryImpl;
import quickresto.webterminal.database.TagDocumentRepositoryImpl;
import quickresto.webterminal.database.TemplateDocumentRepositoryImpl;
import quickresto.webterminal.database.TerminalDocumentRepositoryImpl;
import quickresto.webterminal.database.TerminalUserDocumentRepositoryImpl;
import quickresto.webterminal.database.TrueApiDocumentRepositoryImpl;
import quickresto.webterminal.database.VersionsDocumentRepositoryImpl;
import quickresto.webterminal.database.VirtualKkmDeviceDocumentRepositoryImpl;
import quickresto.webterminal.database.VirtualPosDeviceDocumentRepositoryImpl;
import quickresto.webterminal.log.AndroidLogService;
import quickresto.webterminal.support.AndroidImageProcessorService;
import quickresto.webterminal.support.AndroidSupportService;
import ru.quickresto.terminal.client.ApplicationState;
import ru.quickresto.terminal.client.BackofficeWebClientService;
import ru.quickresto.terminal.client.CoroutinesBridgeService;
import ru.quickresto.terminal.client.EnumConvertingService;
import ru.quickresto.terminal.client.HardwareStateService;
import ru.quickresto.terminal.client.ImagePathManagerService;
import ru.quickresto.terminal.client.OnlineStoreWebClientService;
import ru.quickresto.terminal.client.ReplicationService;
import ru.quickresto.terminal.client.ShiftManagerService;
import ru.quickresto.terminal.client.WebClientUtils;
import ru.quickresto.terminal.client.api.ApplicationController;
import ru.quickresto.terminal.client.api.cancellationReasons.CancellationReasonsController;
import ru.quickresto.terminal.client.api.container.AppContainerController;
import ru.quickresto.terminal.client.api.container.AppContainerService;
import ru.quickresto.terminal.client.api.cookingPlaces.CookingPlacesController;
import ru.quickresto.terminal.client.api.crmCustomer.CrmCustomerController;
import ru.quickresto.terminal.client.api.crmCustomer.crmcustomerservice.CrmCustomerService;
import ru.quickresto.terminal.client.api.crmCustomer.crmcustomerservice.CrmCustomerServiceImpl;
import ru.quickresto.terminal.client.api.crmCustomer.holdservice.CrmCustomerBonusHoldServiceImpl;
import ru.quickresto.terminal.client.api.dictionaries.DictionariesController;
import ru.quickresto.terminal.client.api.discounts.DiscountService;
import ru.quickresto.terminal.client.api.discounts.FixedDiscountController;
import ru.quickresto.terminal.client.api.findDevices.FindDevicesController;
import ru.quickresto.terminal.client.api.findDevices.FindDevicesService;
import ru.quickresto.terminal.client.api.images.ImageController;
import ru.quickresto.terminal.client.api.images.ImageManagerService;
import ru.quickresto.terminal.client.api.kds.KitchenDisplayController;
import ru.quickresto.terminal.client.api.kds.KitchenDisplayWebClientService;
import ru.quickresto.terminal.client.api.log.LogService;
import ru.quickresto.terminal.client.api.markups.FixedMarkupsController;
import ru.quickresto.terminal.client.api.mattermost.MattermostService;
import ru.quickresto.terminal.client.api.menu.MenuController;
import ru.quickresto.terminal.client.api.nomenclature.ModifierLinksController;
import ru.quickresto.terminal.client.api.nomenclature.ModifiersController;
import ru.quickresto.terminal.client.api.nomenclature.NomenclatureHandler;
import ru.quickresto.terminal.client.api.nomenclature.NomenclatureItemSalesController;
import ru.quickresto.terminal.client.api.nomenclature.NomenclatureItemsController;
import ru.quickresto.terminal.client.api.nomenclature.NomenclatureItemsSorter;
import ru.quickresto.terminal.client.api.offers.OffersController;
import ru.quickresto.terminal.client.api.onlineoffers.OnlineOfferController;
import ru.quickresto.terminal.client.api.onlineoffers.OnlineOfferConverter;
import ru.quickresto.terminal.client.api.onlineoffers.OnlineOfferService;
import ru.quickresto.terminal.client.api.order.KdsDeviceLocator;
import ru.quickresto.terminal.client.api.order.OrderItemService;
import ru.quickresto.terminal.client.api.order.OrderProcessingUtil;
import ru.quickresto.terminal.client.api.order.OrdersControllerV2;
import ru.quickresto.terminal.client.api.order.OrdersService;
import ru.quickresto.terminal.client.api.order.PriceModifiersController;
import ru.quickresto.terminal.client.api.order.PriceModifiersService;
import ru.quickresto.terminal.client.api.organizations.OrganizationsController;
import ru.quickresto.terminal.client.api.paymentTypes.PaymentTypesController;
import ru.quickresto.terminal.client.api.preorders.PreordersController;
import ru.quickresto.terminal.client.api.realKkm.RealKkmDevicesController;
import ru.quickresto.terminal.client.api.realKkm.atol.AtolService;
import ru.quickresto.terminal.client.api.realKkm.payload.KkmDriverReceiptConverter;
import ru.quickresto.terminal.client.api.realPos.PosDriverService;
import ru.quickresto.terminal.client.api.realPos.RealPosDevicesController;
import ru.quickresto.terminal.client.api.salePlaces.SalePlacesController;
import ru.quickresto.terminal.client.api.soldout.SoldoutListController;
import ru.quickresto.terminal.client.api.support.SupportController;
import ru.quickresto.terminal.client.api.support.SupportService;
import ru.quickresto.terminal.client.api.tableSchemas.TableSchemasController;
import ru.quickresto.terminal.client.api.tags.TagsController;
import ru.quickresto.terminal.client.api.terminalUsers.TerminalUsersController;
import ru.quickresto.terminal.client.api.ticketPrinters.AtolTicketPrinterService;
import ru.quickresto.terminal.client.api.ticketPrinters.NetworkTicketPrinterService;
import ru.quickresto.terminal.client.api.ticketPrinters.TicketPrinterSettingsDictionary;
import ru.quickresto.terminal.client.api.virtualKkm.VirtualKkmDeviceRepositoryWrapper;
import ru.quickresto.terminal.client.api.virtualKkm.VirtualKkmDevicesController;
import ru.quickresto.terminal.client.api.virtualPos.VirtualPosDeviceRepositoryWrapper;
import ru.quickresto.terminal.client.api.virtualPos.VirtualPosDevicesController;
import ru.quickresto.terminal.client.dxbx.DxBxService;
import ru.quickresto.terminal.client.dxbx.DxBxTaskManagerService;
import ru.quickresto.terminal.client.managers.PosShiftManagerService;
import ru.quickresto.terminal.client.marking.TrueApiService;
import ru.quickresto.terminal.client.scanner.NetworkScanner;
import ru.quickresto.terminal.client.scanner.ScannerHolder;
import ru.quickresto.terminal.client.scanner.discovery.ReceiverInterface;
import ru.quickresto.terminal.client.scanner.discovery.atolKKM.AtolKKMPrinterDiscovery;
import ru.quickresto.terminal.client.scanner.discovery.atolKKM.AtolKkmPrinterReceiver;
import ru.quickresto.terminal.client.scanner.discovery.atolticketprinter.AtolTicketPrinterDiscovery;
import ru.quickresto.terminal.client.scanner.discovery.atolticketprinter.AtolTicketPrinterReceiver;
import ru.quickresto.terminal.client.scanner.discovery.bixolon.BixolonTicketPrinterDiscovery;
import ru.quickresto.terminal.client.scanner.discovery.bixolon.BixolonTicketPrinterReceiver;
import ru.quickresto.terminal.client.scanner.discovery.epson.EpsonDiscovery;
import ru.quickresto.terminal.client.scanner.discovery.epson.EpsonReceiver;
import ru.quickresto.terminal.client.scanner.discovery.sams4.SamsDiscovery;
import ru.quickresto.terminal.client.scanner.discovery.sams4.SamsReceiver;
import ru.quickresto.terminal.client.validators.offers.checker.OfferAvailabilityHandler;
import ru.quickresto.terminal.client.validators.offers.common.OfferGiftProductsService;
import ru.quickresto.terminal.client.validators.offers.multiplicity.OfferComboMultiplicityService;
import ru.quickresto.terminal.client.validators.orders.ContactMethodValidatorService;

@Metadata(d1 = {"\u0000\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0004;Iª\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010:\u001a\u00020;H\u0002¢\u0006\u0002\u0010<J\b\u0010=\u001a\u00020>H\u0002J\u0006\u0010?\u001a\u00020@J\u0006\u0010A\u001a\u00020BJ\u0006\u0010C\u001a\u00020DJ\b\u0010E\u001a\u00020FH\u0002J\u0006\u0010G\u001a\u00020\u0006J\r\u0010H\u001a\u00020IH\u0002¢\u0006\u0002\u0010JJ\b\u0010K\u001a\u00020LH\u0002J\b\u0010M\u001a\u00020NH\u0002J\b\u0010O\u001a\u00020\nH\u0002J\b\u0010P\u001a\u00020QH\u0002J\b\u0010R\u001a\u00020SH\u0002J\b\u0010T\u001a\u00020UH\u0002J\b\u0010V\u001a\u00020\fH\u0002J\b\u0010W\u001a\u00020SH\u0002J\b\u0010X\u001a\u00020YH\u0002J\b\u0010Z\u001a\u00020[H\u0002J\u0006\u0010\\\u001a\u00020]J\b\u0010^\u001a\u00020_H\u0002J\b\u0010`\u001a\u00020aH\u0002J\b\u0010b\u001a\u00020cH\u0002J\u0006\u0010d\u001a\u00020eJ\b\u0010f\u001a\u00020gH\u0002J\b\u0010h\u001a\u00020\u000eH\u0002J\u0006\u0010i\u001a\u00020jJ\b\u0010k\u001a\u00020lH\u0002J\b\u0010m\u001a\u00020nH\u0002J\b\u0010o\u001a\u00020pH\u0002J\u0006\u0010q\u001a\u00020\u0010J\b\u0010r\u001a\u00020sH\u0002J\b\u0010t\u001a\u00020uH\u0002J\b\u0010v\u001a\u00020wH\u0002J\b\u0010x\u001a\u00020yH\u0002J\b\u0010z\u001a\u00020{H\u0002J\b\u0010|\u001a\u00020\u0013H\u0002J\b\u0010}\u001a\u00020~H\u0002J\t\u0010\u001a\u00030\u0001H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\t\u0010\u0001\u001a\u00020SH\u0002J\b\u0010\u0001\u001a\u00030\u0001J\b\u0010\u0001\u001a\u00030\u0001J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\b\u0010\u0001\u001a\u00030\u0001J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\b\u0010\u0001\u001a\u00030\u0001J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\t\u0010\u0001\u001a\u00020\u001bH\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\b\u0010\u0001\u001a\u00030\u0001J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010 \u0001\u001a\u00030¡\u0001H\u0002J\b\u0010¢\u0001\u001a\u00030£\u0001J\b\u0010¤\u0001\u001a\u00030¥\u0001J\b\u0010¦\u0001\u001a\u00030§\u0001J\n\u0010¨\u0001\u001a\u00030©\u0001H\u0002J\b\u0010ª\u0001\u001a\u00030«\u0001J\n\u0010¬\u0001\u001a\u00030­\u0001H\u0002J\n\u0010®\u0001\u001a\u00030¯\u0001H\u0002J\n\u0010°\u0001\u001a\u00030±\u0001H\u0002J\b\u0010²\u0001\u001a\u00030³\u0001J\b\u0010´\u0001\u001a\u00030µ\u0001J\t\u0010¶\u0001\u001a\u00020!H\u0002J\n\u0010·\u0001\u001a\u00030¸\u0001H\u0002J\n\u0010¹\u0001\u001a\u00030º\u0001H\u0002J\n\u0010»\u0001\u001a\u00030¼\u0001H\u0002J\b\u0010½\u0001\u001a\u00030¾\u0001J\b\u0010¿\u0001\u001a\u00030À\u0001J\u0006\u0010#\u001a\u00020$J\n\u0010Á\u0001\u001a\u00030Â\u0001H\u0002J\n\u0010Ã\u0001\u001a\u00030Ä\u0001H\u0002J\n\u0010Å\u0001\u001a\u00030Æ\u0001H\u0002J\b\u0010Ç\u0001\u001a\u00030È\u0001J\n\u0010É\u0001\u001a\u00030Ê\u0001H\u0002J\b\u0010Ë\u0001\u001a\u00030Ì\u0001J\n\u0010Í\u0001\u001a\u00030Î\u0001H\u0002J\n\u0010Ï\u0001\u001a\u00030Ð\u0001H\u0002J\t\u0010Ñ\u0001\u001a\u00020(H\u0002J\t\u0010Ò\u0001\u001a\u00020+H\u0002J\n\u0010Ó\u0001\u001a\u00030Ô\u0001H\u0002J\n\u0010Õ\u0001\u001a\u00030Ö\u0001H\u0002J\n\u0010×\u0001\u001a\u00030Ø\u0001H\u0002J\t\u0010Ù\u0001\u001a\u00020-H\u0002J\b\u0010Ú\u0001\u001a\u00030Û\u0001J\t\u0010Ü\u0001\u001a\u00020/H\u0002J\n\u0010Ý\u0001\u001a\u00030Þ\u0001H\u0002J\b\u0010ß\u0001\u001a\u00030à\u0001J\n\u0010á\u0001\u001a\u00030â\u0001H\u0002J\b\u0010ã\u0001\u001a\u00030ä\u0001J\n\u0010å\u0001\u001a\u00030æ\u0001H\u0002J\t\u0010ç\u0001\u001a\u000202H\u0002J\n\u0010è\u0001\u001a\u00030é\u0001H\u0002J\n\u0010ê\u0001\u001a\u00030ë\u0001H\u0002J\n\u0010ì\u0001\u001a\u00030í\u0001H\u0002J\n\u0010î\u0001\u001a\u00030ï\u0001H\u0002J\n\u0010ð\u0001\u001a\u00030ñ\u0001H\u0002J\b\u0010ò\u0001\u001a\u00030ó\u0001J\b\u0010ô\u0001\u001a\u00030õ\u0001J\n\u0010ö\u0001\u001a\u00030÷\u0001H\u0002J\b\u0010ø\u0001\u001a\u00030ù\u0001J\b\u0010ú\u0001\u001a\u00030û\u0001J\u0007\u0010ü\u0001\u001a\u000205J\n\u0010ý\u0001\u001a\u00030þ\u0001H\u0002J\b\u0010ÿ\u0001\u001a\u00030\u0002J\n\u0010\u0002\u001a\u00030\u0002H\u0002J\t\u0010\u0002\u001a\u00020SH\u0002J\t\u0010\u0002\u001a\u000208H\u0002J\n\u0010\u0002\u001a\u00030\u0002H\u0002J\n\u0010\u0002\u001a\u00030\u0002H\u0002J\n\u0010\u0002\u001a\u00030\u0002H\u0002J\b\u0010\u0002\u001a\u00030\u0002J\n\u0010\u0002\u001a\u00030\u0002H\u0002J\n\u0010\u0002\u001a\u00030\u0002H\u0002J\b\u0010\u0002\u001a\u00030\u0002J\b\u0010\u0002\u001a\u00030\u0002J\n\u0010\u0002\u001a\u00030\u0002H\u0002J\n\u0010\u0002\u001a\u00030\u0002H\u0002J\b\u0010\u0002\u001a\u00030\u0002J\n\u0010\u0002\u001a\u00030\u0002H\u0002J\n\u0010\u0002\u001a\u00030\u0002H\u0002J\b\u0010\u0002\u001a\u00030 \u0002J\n\u0010¡\u0002\u001a\u00030¢\u0002H\u0002J\n\u0010£\u0002\u001a\u00030¤\u0002H\u0002J\n\u0010¥\u0002\u001a\u00030¦\u0002H\u0002J\b\u0010§\u0002\u001a\u00030¨\u0002J\u0010\u0010©\u0002\u001a\u00030ª\u0002H\u0002¢\u0006\u0003\u0010«\u0002J\n\u0010¬\u0002\u001a\u00030­\u0002H\u0002J\n\u0010®\u0002\u001a\u00030¯\u0002H\u0002J\n\u0010°\u0002\u001a\u00030±\u0002H\u0002J\n\u0010²\u0002\u001a\u00030³\u0002H\u0002J\n\u0010´\u0002\u001a\u00030µ\u0002H\u0002J\n\u0010¶\u0002\u001a\u00030·\u0002H\u0002J\b\u0010¸\u0002\u001a\u00030¹\u0002J\n\u0010º\u0002\u001a\u00030»\u0002H\u0002J\n\u0010¼\u0002\u001a\u00030½\u0002H\u0002J\b\u0010¾\u0002\u001a\u00030¿\u0002J\n\u0010À\u0002\u001a\u00030Á\u0002H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010#\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X.¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X.¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006Â\u0002"}, d2 = {"Lquickresto/webterminal/ServiceLocator;", "", "()V", "APPLICATION_PROFILE", "", "applicationStateValue", "Lru/quickresto/terminal/client/ApplicationState;", "applicationStateValueLock", "Ljava/lang/Object;", "atolServiceValue", "Lru/quickresto/terminal/client/api/realKkm/atol/AtolService;", "backofficeWebClientServiceValue", "Lru/quickresto/terminal/client/BackofficeWebClientService;", "crmCustomerBonusHoldServiceValue", "Lru/quickresto/terminal/client/api/crmCustomer/holdservice/CrmCustomerBonusHoldServiceImpl;", "dictionariesControllerValue", "Lru/quickresto/terminal/client/api/dictionaries/DictionariesController;", "dictionariesControllerValueLock", "dxBxTaskManagerServiceValue", "Lru/quickresto/terminal/client/dxbx/DxBxTaskManagerService;", "findDevicesService", "Lru/quickresto/terminal/client/api/findDevices/FindDevicesService;", "getFindDevicesService", "()Lru/quickresto/terminal/client/api/findDevices/FindDevicesService;", "findDevicesService$delegate", "Lkotlin/Lazy;", "imagePathManagerServiceValue", "Lru/quickresto/terminal/client/ImagePathManagerService;", "log", "Lorg/slf4j/Logger;", "getLog", "()Lorg/slf4j/Logger;", "networkScannerValue", "Lru/quickresto/terminal/client/scanner/NetworkScanner;", "networkScannerValueLock", "objectMapper", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "getObjectMapper", "()Lcom/fasterxml/jackson/databind/ObjectMapper;", "onlineOfferServiceValue", "Lru/quickresto/terminal/client/api/onlineoffers/OnlineOfferService;", "onlineOfferServiceValueLock", "onlineStoreWebClientServiceValue", "Lru/quickresto/terminal/client/OnlineStoreWebClientService;", "orderProcessingUtilValue", "Lru/quickresto/terminal/client/api/order/OrderProcessingUtil;", "ordersServiceValue", "Lru/quickresto/terminal/client/api/order/OrdersService;", "ordersServiceValueLock", "posDriverServiceValue", "Lru/quickresto/terminal/client/api/realPos/PosDriverService;", "posDriverServiceValueLock", "replicationServiceValue", "Lru/quickresto/terminal/client/ReplicationService;", "replicationServiceValueLock", "scannerHolderValue", "Lru/quickresto/terminal/client/scanner/ScannerHolder;", "scannerHolderValueLock", "androidDeviceInformationService", "quickresto/webterminal/ServiceLocator$androidDeviceInformationService$1", "()Lquickresto/webterminal/ServiceLocator$androidDeviceInformationService$1;", "androidImageProcessorService", "Lquickresto/webterminal/support/AndroidImageProcessorService;", "appContainerController", "Lru/quickresto/terminal/client/api/container/AppContainerController;", "appContainerService", "Lru/quickresto/terminal/client/api/container/AppContainerService;", "applicationController", "Lru/quickresto/terminal/client/api/ApplicationController;", "applicationSettingsDocumentRepository", "Lquickresto/webterminal/database/ApplicationSettingsDocumentRepositoryImpl;", "applicationState", "atolFactoryService", "quickresto/webterminal/ServiceLocator$atolFactoryService$1", "()Lquickresto/webterminal/ServiceLocator$atolFactoryService$1;", "atolKKMPrinterDiscovery", "Lru/quickresto/terminal/client/scanner/discovery/atolKKM/AtolKKMPrinterDiscovery;", "atolKKMReceiver", "Lru/quickresto/terminal/client/scanner/discovery/atolKKM/AtolKkmPrinterReceiver;", "atolService", "atolTicketPrinterDiscovery", "Lru/quickresto/terminal/client/scanner/discovery/atolticketprinter/AtolTicketPrinterDiscovery;", "atolTicketPrinterReceiver", "Lru/quickresto/terminal/client/scanner/discovery/ReceiverInterface;", "atolTicketPrinterService", "Lru/quickresto/terminal/client/api/ticketPrinters/AtolTicketPrinterService;", "backofficeWebClientService", "bixolonReceiver", "bixolonTicketPrinterDiscovery", "Lru/quickresto/terminal/client/scanner/discovery/bixolon/BixolonTicketPrinterDiscovery;", "cancellationReasonDocumentRepository", "Lquickresto/webterminal/database/CancellationReasonDocumentRepositoryImpl;", "cancellationReasonsController", "Lru/quickresto/terminal/client/api/cancellationReasons/CancellationReasonsController;", "comboDocumentRepository", "Lquickresto/webterminal/database/ComboOffersDocumentRepositoryImpl;", "contactMethodValidatorService", "Lru/quickresto/terminal/client/validators/orders/ContactMethodValidatorService;", "cookingPlaceDocumentRepository", "Lquickresto/webterminal/database/CookingPlaceDocumentRepositoryImpl;", "cookingPlacesController", "Lru/quickresto/terminal/client/api/cookingPlaces/CookingPlacesController;", "coroutinesBridgeService", "Lru/quickresto/terminal/client/CoroutinesBridgeService;", "crmCustomerBonusHoldService", "crmCustomerController", "Lru/quickresto/terminal/client/api/crmCustomer/CrmCustomerController;", "crmCustomerService", "Lru/quickresto/terminal/client/api/crmCustomer/crmcustomerservice/CrmCustomerService;", "currencyDocumentRepository", "Lquickresto/webterminal/database/CurrencyDocumentRepositoryImpl;", "deviceDocumentRepository", "Lquickresto/webterminal/database/KkmDeviceDocumentRepositoryImpl;", "dictionariesController", "discountService", "Lru/quickresto/terminal/client/api/discounts/DiscountService;", "dishDocumentRepository", "Lquickresto/webterminal/database/DishDocumentRepositoryImpl;", "dishGroupDocumentRepository", "Lquickresto/webterminal/database/DishGroupDocumentRepositoryImpl;", "dxBxService", "Lru/quickresto/terminal/client/dxbx/DxBxService;", "dxBxTaskDocumentRepository", "Lquickresto/webterminal/database/DxBxTaskDocumentRepositoryImpl;", "dxBxTaskManagerService", "encashmentDocumentRepository", "Lquickresto/webterminal/database/EncashmentDocumentRepositoryImpl;", "enumConvertingService", "Lru/quickresto/terminal/client/EnumConvertingService;", "epsonDiscovery", "Lru/quickresto/terminal/client/scanner/discovery/epson/EpsonDiscovery;", "epsonReceiver", "findDevicesController", "Lru/quickresto/terminal/client/api/findDevices/FindDevicesController;", "fixedDiscountController", "Lru/quickresto/terminal/client/api/discounts/FixedDiscountController;", "fixedDiscountDocumentRepository", "Lquickresto/webterminal/database/FixedDiscountDocumentRepositoryImpl;", "fixedMarkupDocumentRepository", "Lquickresto/webterminal/database/FixedMarkupDocumentRepositoryImpl;", "fixedMarkupsController", "Lru/quickresto/terminal/client/api/markups/FixedMarkupsController;", "hardwareStateService", "Lru/quickresto/terminal/client/HardwareStateService;", "imageController", "Lru/quickresto/terminal/client/api/images/ImageController;", "imageDocumentRepository", "Lquickresto/webterminal/database/ImageDocumentRepositoryImpl;", "imageManagerService", "Lru/quickresto/terminal/client/api/images/ImageManagerService;", "imagePathManagerService", "kdsDeviceLocator", "Lru/quickresto/terminal/client/api/order/KdsDeviceLocator;", "kitchenDeviceTypeLocator", "kitchenDisplayController", "Lru/quickresto/terminal/client/api/kds/KitchenDisplayController;", "kitchenDisplayDocumentRepository", "Lquickresto/webterminal/database/KitchenDisplayDocumentRepositoryImpl;", "kitchenDisplayService", "Lru/quickresto/terminal/client/api/kds/KitchenDisplayWebClientService;", "kkmDriverReceiptConverter", "Lru/quickresto/terminal/client/api/realKkm/payload/KkmDriverReceiptConverter;", "logService", "Lru/quickresto/terminal/client/api/log/LogService;", "mattermostService", "Lru/quickresto/terminal/client/api/mattermost/MattermostService;", "menuController", "Lru/quickresto/terminal/client/api/menu/MenuController;", "menuDocumentRepository", "Lquickresto/webterminal/database/MenuDocumentRepositoryImpl;", "migrationDatabaseService", "Lquickresto/webterminal/MigrationDatabaseService;", "modifierDocumentRepository", "Lquickresto/webterminal/database/ModifierDocumentRepositoryImpl;", "modifierGroupDocumentRepository", "Lquickresto/webterminal/database/ModifierGroupDocumentRepositoryImpl;", "modifierLinkDocumentRepository", "Lquickresto/webterminal/database/ModifierLinkDocumentRepositoryImpl;", "modifierLinksController", "Lru/quickresto/terminal/client/api/nomenclature/ModifierLinksController;", "modifiersController", "Lru/quickresto/terminal/client/api/nomenclature/ModifiersController;", "networkScanner", "networkTicketPrinterService", "Lru/quickresto/terminal/client/api/ticketPrinters/NetworkTicketPrinterService;", "nomenclatureHandler", "Lru/quickresto/terminal/client/api/nomenclature/NomenclatureHandler;", "nomenclatureItemSaleDocumentRepository", "Lquickresto/webterminal/database/NomenclatureItemSaleDocumentRepositoryImpl;", "nomenclatureItemSalesController", "Lru/quickresto/terminal/client/api/nomenclature/NomenclatureItemSalesController;", "nomenclatureItemsController", "Lru/quickresto/terminal/client/api/nomenclature/NomenclatureItemsController;", "offerAvailabilityHandler", "Lru/quickresto/terminal/client/validators/offers/checker/OfferAvailabilityHandler;", "offerComboMultiplicityService", "Lru/quickresto/terminal/client/validators/offers/multiplicity/OfferComboMultiplicityService;", "offerGiftProductsService", "Lru/quickresto/terminal/client/validators/offers/common/OfferGiftProductsService;", "offersController", "Lru/quickresto/terminal/client/api/offers/OffersController;", "onlineInterfaceDocumentRepository", "Lquickresto/webterminal/database/OnlineInterfaceDocumentRepositoryImpl;", "onlineOfferController", "Lru/quickresto/terminal/client/api/onlineoffers/OnlineOfferController;", "onlineOfferConverter", "Lru/quickresto/terminal/client/api/onlineoffers/OnlineOfferConverter;", "onlineOfferDocumentRepository", "Lquickresto/webterminal/database/OnlineOfferDocumentRepositoryImpl;", "onlineOfferService", "onlineStoreWebClientService", "orderDocumentRepository", "Lquickresto/webterminal/database/OrderDocumentRepositoryImpl;", "orderDocumentV2Repository", "Lquickresto/webterminal/database/OrderDocumentV2RepositoryImpl;", "orderItemService", "Lru/quickresto/terminal/client/api/order/OrderItemService;", "orderProcessingUtil", "ordersControllerV2", "Lru/quickresto/terminal/client/api/order/OrdersControllerV2;", "ordersService", "organizationDocumentRepository", "Lquickresto/webterminal/database/OrganizationDocumentRepositoryImpl;", "organizationsController", "Lru/quickresto/terminal/client/api/organizations/OrganizationsController;", "paymentTypeDocumentRepository", "Lquickresto/webterminal/database/PaymentTypeDocumentRepositoryImpl;", "paymentTypesController", "Lru/quickresto/terminal/client/api/paymentTypes/PaymentTypesController;", "posDeviceDocumentRepository", "Lquickresto/webterminal/database/PosDeviceDocumentRepositoryImpl;", "posDriverService", "posPaymentDocumentRepository", "Lquickresto/webterminal/database/PosPaymentDocumentRepositoryImpl;", "posRefundDocumentRepository", "Lquickresto/webterminal/database/PosRefundDocumentRepositoryImpl;", "posShiftDocumentRepository", "Lquickresto/webterminal/database/PosShiftDocumentRepositoryImpl;", "posShiftManagerService", "Lru/quickresto/terminal/client/managers/PosShiftManagerService;", "preorderInfoDocumentRepository", "Lquickresto/webterminal/database/PreorderInfoDocumentRepositoryImpl;", "preordersController", "Lru/quickresto/terminal/client/api/preorders/PreordersController;", "priceModifiersController", "Lru/quickresto/terminal/client/api/order/PriceModifiersController;", "priceModifiersService", "Lru/quickresto/terminal/client/api/order/PriceModifiersService;", "realKkmDevicesController", "Lru/quickresto/terminal/client/api/realKkm/RealKkmDevicesController;", "realPosDevicesController", "Lru/quickresto/terminal/client/api/realPos/RealPosDevicesController;", "replicationService", "salePlaceDocumentRepository", "Lquickresto/webterminal/database/SalePlaceDocumentRepositoryImpl;", "salePlacesController", "Lru/quickresto/terminal/client/api/salePlaces/SalePlacesController;", "samsDiscovery", "Lru/quickresto/terminal/client/scanner/discovery/sams4/SamsDiscovery;", "samsReceiver", "scannerHolder", "scheduledDiscountDocumentRepository", "Lquickresto/webterminal/database/ScheduledDiscountDocumentRepositoryImpl;", "shiftDocumentRepository", "Lquickresto/webterminal/database/ShiftDocumentRepositoryImpl;", "shiftManagerService", "Lru/quickresto/terminal/client/ShiftManagerService;", "soldoutListController", "Lru/quickresto/terminal/client/api/soldout/SoldoutListController;", "soldoutListDocumentRepository", "Lquickresto/webterminal/database/SoldoutListDocumentRepositoryImpl;", "specialSetDocumentRepository", "Lquickresto/webterminal/database/SpecialSetDocumentRepositoryImpl;", "supportService", "Lru/quickresto/terminal/client/api/support/SupportService;", "supportServiceController", "Lru/quickresto/terminal/client/api/support/SupportController;", "sysExtrasDocumentRepository", "Lquickresto/webterminal/database/SysExtrasDocumentRepositoryImpl;", "tableOrderDocumentRepository", "Lquickresto/webterminal/database/TableOrderDocumentRepositoryImpl;", "tableSchemasController", "Lru/quickresto/terminal/client/api/tableSchemas/TableSchemasController;", "tableSchemeDocumentRepository", "Lquickresto/webterminal/database/TableSchemeDocumentRepositoryImpl;", "tagDocumentRepository", "Lquickresto/webterminal/database/TagDocumentRepositoryImpl;", "tagsController", "Lru/quickresto/terminal/client/api/tags/TagsController;", "templateDocumentRepository", "Lquickresto/webterminal/database/TemplateDocumentRepositoryImpl;", "terminalDocumentRepository", "Lquickresto/webterminal/database/TerminalDocumentRepositoryImpl;", "terminalUserDocumentRepository", "Lquickresto/webterminal/database/TerminalUserDocumentRepositoryImpl;", "terminalUsersController", "Lru/quickresto/terminal/client/api/terminalUsers/TerminalUsersController;", "terminalVersionService", "quickresto/webterminal/ServiceLocator$terminalVersionService$1", "()Lquickresto/webterminal/ServiceLocator$terminalVersionService$1;", "ticketPrinterSettingsDictionary", "Lru/quickresto/terminal/client/api/ticketPrinters/TicketPrinterSettingsDictionary;", "trueApiDocumentRepository", "Lquickresto/webterminal/database/TrueApiDocumentRepositoryImpl;", "trueApiService", "Lru/quickresto/terminal/client/marking/TrueApiService;", "versionsDocumentRepository", "Lquickresto/webterminal/database/VersionsDocumentRepositoryImpl;", "virtualKkmDeviceDocumentRepository", "Lquickresto/webterminal/database/VirtualKkmDeviceDocumentRepositoryImpl;", "virtualKkmDeviceRepositoryWrapper", "Lru/quickresto/terminal/client/api/virtualKkm/VirtualKkmDeviceRepositoryWrapper;", "virtualKkmDevicesController", "Lru/quickresto/terminal/client/api/virtualKkm/VirtualKkmDevicesController;", "virtualPosDeviceDocumentRepository", "Lquickresto/webterminal/database/VirtualPosDeviceDocumentRepositoryImpl;", "virtualPosDeviceRepositoryWrapper", "Lru/quickresto/terminal/client/api/virtualPos/VirtualPosDeviceRepositoryWrapper;", "virtualPosDevicesController", "Lru/quickresto/terminal/client/api/virtualPos/VirtualPosDevicesController;", "webClientUtils", "Lru/quickresto/terminal/client/WebClientUtils;", "quickresto.webterminal-9.5.7(254)_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ServiceLocator.kt */
public final class ServiceLocator {
    public static final int $stable = 8;
    private static final String APPLICATION_PROFILE = "production";
    public static final ServiceLocator INSTANCE;
    private static ApplicationState applicationStateValue;
    private static final Object applicationStateValueLock = new Object();
    private static AtolService atolServiceValue;
    private static BackofficeWebClientService backofficeWebClientServiceValue;
    private static CrmCustomerBonusHoldServiceImpl crmCustomerBonusHoldServiceValue;
    private static DictionariesController dictionariesControllerValue;
    private static final Object dictionariesControllerValueLock = new Object();
    private static DxBxTaskManagerService dxBxTaskManagerServiceValue;
    private static final Lazy findDevicesService$delegate = LazyKt.lazy(ServiceLocator$findDevicesService$2.INSTANCE);
    private static ImagePathManagerService imagePathManagerServiceValue;
    private static final Logger log;
    private static NetworkScanner networkScannerValue;
    private static final Object networkScannerValueLock = new Object();
    private static final ObjectMapper objectMapper = new JsonObjectMapper().mapper();
    private static OnlineOfferService onlineOfferServiceValue;
    private static final Object onlineOfferServiceValueLock = new Object();
    private static OnlineStoreWebClientService onlineStoreWebClientServiceValue;
    private static OrderProcessingUtil orderProcessingUtilValue;
    private static OrdersService ordersServiceValue;
    private static final Object ordersServiceValueLock = new Object();
    private static PosDriverService posDriverServiceValue;
    private static final Object posDriverServiceValueLock = new Object();
    private static ReplicationService replicationServiceValue;
    private static final Object replicationServiceValueLock = new Object();
    private static ScannerHolder scannerHolderValue;
    private static final Object scannerHolderValueLock = new Object();

    private ServiceLocator() {
    }

    static {
        ServiceLocator serviceLocator = new ServiceLocator();
        INSTANCE = serviceLocator;
        Logger logger = LoggerFactory.getLogger(serviceLocator.getClass().getSimpleName());
        Intrinsics.checkNotNullExpressionValue(logger, "getLogger(this::class.java.simpleName)");
        log = logger;
    }

    public final ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public final Logger getLog() {
        return log;
    }

    public final ObjectMapper objectMapper() {
        return objectMapper;
    }

    private final BackofficeWebClientService backofficeWebClientService() {
        BackofficeWebClientService backofficeWebClientService = backofficeWebClientServiceValue;
        boolean z = backofficeWebClientService != null;
        if (z) {
            if (backofficeWebClientService != null) {
                return backofficeWebClientService;
            }
            Intrinsics.throwUninitializedPropertyAccessException("backofficeWebClientServiceValue");
            return null;
        } else if (!z) {
            ServiceLocator serviceLocator = INSTANCE;
            BackofficeWebClientService backofficeWebClientService2 = new BackofficeWebClientService(serviceLocator.applicationState(), serviceLocator.objectMapper(), serviceLocator.androidDeviceInformationService(), serviceLocator.imagePathManagerService());
            backofficeWebClientServiceValue = backofficeWebClientService2;
            return backofficeWebClientService2;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final OnlineStoreWebClientService onlineStoreWebClientService() {
        OnlineStoreWebClientService onlineStoreWebClientService = onlineStoreWebClientServiceValue;
        boolean z = onlineStoreWebClientService != null;
        if (z) {
            if (onlineStoreWebClientService != null) {
                return onlineStoreWebClientService;
            }
            Intrinsics.throwUninitializedPropertyAccessException("onlineStoreWebClientServiceValue");
            return null;
        } else if (!z) {
            ServiceLocator serviceLocator = INSTANCE;
            OnlineStoreWebClientService onlineStoreWebClientService2 = new OnlineStoreWebClientService(serviceLocator.applicationState(), serviceLocator.backofficeWebClientService());
            onlineStoreWebClientServiceValue = onlineStoreWebClientService2;
            return onlineStoreWebClientService2;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final ServiceLocator$atolFactoryService$1 atolFactoryService() {
        return new ServiceLocator$atolFactoryService$1();
    }

    public final ApplicationState applicationState() {
        ApplicationState applicationState;
        synchronized (applicationStateValueLock) {
            applicationState = applicationStateValue;
            boolean z = applicationState != null;
            if (z) {
                if (applicationState == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("applicationStateValue");
                    applicationState = null;
                }
            } else if (!z) {
                ServiceLocator serviceLocator = INSTANCE;
                applicationState = new ApplicationState(serviceLocator.applicationSettingsDocumentRepository(), serviceLocator.deviceDocumentRepository(), serviceLocator.posDeviceDocumentRepository(), serviceLocator.virtualKkmDeviceDocumentRepository(), serviceLocator.virtualPosDeviceDocumentRepository(), serviceLocator.soldoutListDocumentRepository(), serviceLocator.specialSetDocumentRepository(), serviceLocator.sysExtrasDocumentRepository(), serviceLocator.dishDocumentRepository(), serviceLocator.modifierLinkDocumentRepository(), serviceLocator.cookingPlaceDocumentRepository(), serviceLocator.tableOrderDocumentRepository(), serviceLocator.orderDocumentV2Repository(), serviceLocator.preorderInfoDocumentRepository(), serviceLocator.shiftDocumentRepository(), serviceLocator.shiftManagerService(), serviceLocator.paymentTypeDocumentRepository(), serviceLocator.onlineInterfaceDocumentRepository(), serviceLocator.kitchenDisplayDocumentRepository(), serviceLocator.salePlaceDocumentRepository(), serviceLocator.tableSchemeDocumentRepository());
                applicationState.setClientApiVersion("/v1/");
                applicationState.setServerApiVersion(BuildConfig.SERVER_VERSION);
                applicationState.setBackofficeDomain("https://%s.quickresto.ru/wt" + applicationState.getServerApiVersion());
                applicationState.loadSettings().block();
                applicationStateValue = applicationState;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return applicationState;
    }

    public final ReplicationService replicationService() {
        ReplicationService replicationService;
        synchronized (replicationServiceValueLock) {
            replicationService = replicationServiceValue;
            boolean z = replicationService != null;
            if (z) {
                if (replicationService == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("replicationServiceValue");
                    replicationService = null;
                }
            } else if (!z) {
                ServiceLocator serviceLocator = INSTANCE;
                replicationService = new ReplicationService(serviceLocator.backofficeWebClientService(), serviceLocator.applicationSettingsDocumentRepository(), new TableHashDocumentRepositoryImpl(), serviceLocator.orderDocumentV2Repository(), serviceLocator.tableOrderDocumentRepository(), serviceLocator.encashmentDocumentRepository(), serviceLocator.applicationState(), serviceLocator.shiftDocumentRepository(), serviceLocator.virtualKkmDeviceDocumentRepository(), serviceLocator.deviceDocumentRepository(), serviceLocator.cookingPlaceDocumentRepository(), serviceLocator.dishDocumentRepository(), serviceLocator.dishGroupDocumentRepository(), serviceLocator.virtualKkmDeviceRepositoryWrapper(), serviceLocator.virtualPosDeviceRepositoryWrapper(), serviceLocator.paymentTypeDocumentRepository(), serviceLocator.terminalUserDocumentRepository(), serviceLocator.modifierLinkDocumentRepository(), serviceLocator.comboDocumentRepository(), serviceLocator.specialSetDocumentRepository(), serviceLocator.tagDocumentRepository(), serviceLocator.tableSchemeDocumentRepository(), serviceLocator.salePlaceDocumentRepository(), serviceLocator.cancellationReasonDocumentRepository(), serviceLocator.fixedDiscountDocumentRepository(), serviceLocator.fixedMarkupDocumentRepository(), serviceLocator.scheduledDiscountDocumentRepository(), serviceLocator.modifierDocumentRepository(), serviceLocator.modifierGroupDocumentRepository(), serviceLocator.organizationDocumentRepository(), serviceLocator.preorderInfoDocumentRepository(), serviceLocator.soldoutListDocumentRepository(), serviceLocator.currencyDocumentRepository(), serviceLocator.onlineOfferDocumentRepository(), serviceLocator.onlineStoreWebClientService(), serviceLocator.sysExtrasDocumentRepository(), serviceLocator.onlineInterfaceDocumentRepository(), serviceLocator.templateDocumentRepository(), serviceLocator.imageDocumentRepository(), serviceLocator.menuDocumentRepository(), serviceLocator.terminalVersionService(), serviceLocator.androidDeviceInformationService(), serviceLocator.supportService(), serviceLocator.nomenclatureHandler(), serviceLocator.trueApiService());
                replicationServiceValue = replicationService;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return replicationService;
    }

    private final OnlineOfferService onlineOfferService() {
        OnlineOfferService onlineOfferService;
        synchronized (onlineOfferServiceValueLock) {
            onlineOfferService = onlineOfferServiceValue;
            boolean z = onlineOfferService != null;
            if (z) {
                if (onlineOfferService == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("onlineOfferServiceValue");
                    onlineOfferService = null;
                }
            } else if (!z) {
                ServiceLocator serviceLocator = INSTANCE;
                onlineOfferService = new OnlineOfferService(serviceLocator.applicationSettingsDocumentRepository(), serviceLocator.onlineOfferDocumentRepository(), serviceLocator.orderDocumentV2Repository(), serviceLocator.tableOrderDocumentRepository(), serviceLocator.applicationState(), serviceLocator.deviceDocumentRepository(), serviceLocator.virtualKkmDeviceDocumentRepository(), serviceLocator.organizationDocumentRepository(), serviceLocator.paymentTypeDocumentRepository(), serviceLocator.backofficeWebClientService(), serviceLocator.preorderInfoDocumentRepository(), serviceLocator.onlineOfferConverter());
                onlineOfferServiceValue = onlineOfferService;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return onlineOfferService;
    }

    private final NomenclatureHandler nomenclatureHandler() {
        return new NomenclatureHandler(new NomenclatureItemsSorter());
    }

    public final ApplicationController applicationController() {
        return new ApplicationController(applicationState(), backofficeWebClientService(), applicationSettingsDocumentRepository(), terminalDocumentRepository(), terminalUserDocumentRepository(), replicationService(), terminalVersionService(), hardwareStateService(), migrationDatabaseService(), androidDeviceInformationService(), APPLICATION_PROFILE, tableSchemeDocumentRepository(), salePlaceDocumentRepository());
    }

    private final HardwareStateService hardwareStateService() {
        return new HardwareStateService(backofficeWebClientService(), applicationSettingsDocumentRepository(), applicationState(), deviceDocumentRepository(), virtualKkmDeviceDocumentRepository(), virtualPosDeviceDocumentRepository());
    }

    public final TableSchemasController tableSchemasController() {
        return new TableSchemasController(tableSchemeDocumentRepository(), replicationService());
    }

    public final SalePlacesController salePlacesController() {
        return new SalePlacesController(salePlaceDocumentRepository(), replicationService());
    }

    public final TerminalUsersController terminalUsersController() {
        return new TerminalUsersController(terminalUserDocumentRepository(), replicationService());
    }

    public final OrganizationsController organizationsController() {
        return new OrganizationsController(organizationDocumentRepository(), replicationService());
    }

    public final CookingPlacesController cookingPlacesController() {
        return new CookingPlacesController(cookingPlaceDocumentRepository(), replicationService());
    }

    public final PreordersController preordersController() {
        return new PreordersController(backofficeWebClientService(), preorderInfoDocumentRepository(), orderDocumentV2Repository(), tableOrderDocumentRepository(), shiftDocumentRepository(), applicationState(), virtualKkmDeviceDocumentRepository(), kitchenDisplayDocumentRepository(), kitchenDeviceTypeLocator(), applicationSettingsDocumentRepository(), orderProcessingUtil());
    }

    public final MenuController menuController() {
        return new MenuController(menuDocumentRepository(), applicationState(), replicationService());
    }

    private final VirtualKkmDeviceRepositoryWrapper virtualKkmDeviceRepositoryWrapper() {
        return new VirtualKkmDeviceRepositoryWrapper(virtualKkmDeviceDocumentRepository(), backofficeWebClientService(), applicationState(), deviceDocumentRepository());
    }

    private final VirtualPosDeviceRepositoryWrapper virtualPosDeviceRepositoryWrapper() {
        return new VirtualPosDeviceRepositoryWrapper(virtualPosDeviceDocumentRepository(), backofficeWebClientService(), applicationState());
    }

    private final KitchenDisplayWebClientService kitchenDisplayService() {
        return new KitchenDisplayWebClientService(objectMapper());
    }

    private final TicketPrinterSettingsDictionary ticketPrinterSettingsDictionary() {
        return new TicketPrinterSettingsDictionary();
    }

    private final AtolService atolService() {
        AtolService atolService = atolServiceValue;
        boolean z = atolService != null;
        if (z) {
            if (atolService != null) {
                return atolService;
            }
            Intrinsics.throwUninitializedPropertyAccessException("atolServiceValue");
            return null;
        } else if (!z) {
            ServiceLocator serviceLocator = INSTANCE;
            AtolService atolService2 = new AtolService(serviceLocator.atolFactoryService(), serviceLocator.contactMethodValidatorService(), serviceLocator.coroutinesBridgeService(), serviceLocator.androidImageProcessorService());
            atolServiceValue = atolService2;
            return atolService2;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final CoroutinesBridgeService coroutinesBridgeService() {
        return new CoroutinesBridgeService(replicationService());
    }

    private final AtolTicketPrinterService atolTicketPrinterService() {
        return new AtolTicketPrinterService(atolService(), ticketPrinterSettingsDictionary(), ordersService(), imageDocumentRepository(), templateDocumentRepository(), specialSetDocumentRepository());
    }

    private final KdsDeviceLocator kdsDeviceLocator() {
        return new KdsDeviceLocator(kitchenDisplayService(), networkTicketPrinterService(), atolTicketPrinterService());
    }

    public final VirtualKkmDevicesController virtualKkmDevicesController() {
        return new VirtualKkmDevicesController(backofficeWebClientService(), replicationService(), applicationState(), virtualKkmDeviceRepositoryWrapper(), orderDocumentV2Repository(), tableOrderDocumentRepository(), kitchenDisplayDocumentRepository(), kdsDeviceLocator(), terminalUserDocumentRepository(), shiftDocumentRepository(), shiftManagerService(), encashmentDocumentRepository());
    }

    public final VirtualPosDevicesController virtualPosDevicesController() {
        return new VirtualPosDevicesController(backofficeWebClientService(), replicationService(), applicationState(), virtualPosDeviceRepositoryWrapper(), tableOrderDocumentRepository());
    }

    public final NomenclatureItemsController nomenclatureItemsController() {
        return new NomenclatureItemsController(dishDocumentRepository(), dishGroupDocumentRepository(), applicationState(), imagePathManagerService(), backofficeWebClientService());
    }

    public final NomenclatureItemSalesController nomenclatureItemSalesController() {
        return new NomenclatureItemSalesController(nomenclatureItemSaleDocumentRepository(), dishDocumentRepository(), replicationService());
    }

    public final ModifiersController modifiersController() {
        return new ModifiersController(modifierDocumentRepository(), modifierGroupDocumentRepository(), replicationService(), applicationState(), backofficeWebClientService());
    }

    public final ModifierLinksController modifierLinksController() {
        return new ModifierLinksController(modifierLinkDocumentRepository(), dishDocumentRepository(), replicationService(), applicationState(), backofficeWebClientService());
    }

    public final PaymentTypesController paymentTypesController() {
        return new PaymentTypesController(paymentTypeDocumentRepository());
    }

    public final RealKkmDevicesController realKkmDevicesController() {
        return new RealKkmDevicesController(backofficeWebClientService(), replicationService(), deviceDocumentRepository(), applicationSettingsDocumentRepository(), atolService(), applicationState(), encashmentDocumentRepository(), tableOrderDocumentRepository(), orderDocumentV2Repository(), virtualKkmDeviceDocumentRepository(), kitchenDisplayDocumentRepository(), shiftDocumentRepository(), ticketPrinterSettingsDictionary(), shiftManagerService());
    }

    public final RealPosDevicesController realPosDevicesController() {
        return new RealPosDevicesController(backofficeWebClientService(), posShiftDocumentRepository(), posPaymentDocumentRepository(), posRefundDocumentRepository(), posDeviceDocumentRepository(), posDriverService(), posShiftManagerService(), applicationState());
    }

    public final KitchenDisplayController kitchenDisplayController() {
        return new KitchenDisplayController(backofficeWebClientService(), replicationService(), kitchenDisplayDocumentRepository(), kitchenDisplayService(), ticketPrinterSettingsDictionary(), networkTicketPrinterService());
    }

    public final OrdersControllerV2 ordersControllerV2() {
        return new OrdersControllerV2(backofficeWebClientService(), replicationService(), applicationSettingsDocumentRepository(), orderDocumentV2Repository(), tableOrderDocumentRepository(), paymentTypeDocumentRepository(), applicationState(), atolService(), deviceDocumentRepository(), posShiftManagerService(), terminalUserDocumentRepository(), virtualKkmDeviceDocumentRepository(), virtualPosDeviceDocumentRepository(), orderItemService(), ordersService(), fixedDiscountDocumentRepository(), cookingPlaceDocumentRepository(), kitchenDisplayDocumentRepository(), kitchenDeviceTypeLocator(), organizationDocumentRepository(), specialSetDocumentRepository(), shiftDocumentRepository(), preorderInfoDocumentRepository(), priceModifiersService(), discountService(), offerAvailabilityHandler(), kkmDriverReceiptConverter(), onlineOfferService(), cancellationReasonDocumentRepository(), crmCustomerController(), orderProcessingUtil(), crmCustomerBonusHoldService(), templateDocumentRepository(), imageDocumentRepository(), crmCustomerService(), shiftManagerService(), trueApiService(), dxBxTaskManagerService());
    }

    public final OnlineOfferController onlineOfferController() {
        return new OnlineOfferController(onlineOfferService());
    }

    public final SoldoutListController soldoutListController() {
        return new SoldoutListController(soldoutListDocumentRepository(), replicationService(), applicationState(), backofficeWebClientService());
    }

    private final KkmDriverReceiptConverter kkmDriverReceiptConverter() {
        return new KkmDriverReceiptConverter();
    }

    private final KdsDeviceLocator kitchenDeviceTypeLocator() {
        return new KdsDeviceLocator(kitchenDisplayService(), networkTicketPrinterService(), atolTicketPrinterService());
    }

    private final OrdersService ordersService() {
        OrdersService ordersService;
        synchronized (ordersServiceValueLock) {
            ordersService = ordersServiceValue;
            boolean z = ordersService != null;
            if (z) {
                if (ordersService == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ordersServiceValue");
                    ordersService = null;
                }
            } else if (!z) {
                ServiceLocator serviceLocator = INSTANCE;
                ordersService = new OrdersService(serviceLocator.applicationState(), serviceLocator.orderDocumentV2Repository(), serviceLocator.tableOrderDocumentRepository(), serviceLocator.cookingPlaceDocumentRepository(), serviceLocator.kitchenDisplayDocumentRepository(), serviceLocator.kitchenDisplayService(), serviceLocator.enumConvertingService(), serviceLocator.onlineOfferService(), serviceLocator.salePlaceDocumentRepository(), serviceLocator.tableSchemeDocumentRepository(), serviceLocator.applicationSettingsDocumentRepository());
                ordersServiceValue = ordersService;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return ordersService;
    }

    private final CrmCustomerService crmCustomerService() {
        return new CrmCustomerServiceImpl(applicationState(), backofficeWebClientService());
    }

    private final ShiftManagerService shiftManagerService() {
        return new ShiftManagerService(shiftDocumentRepository(), orderDocumentV2Repository(), tableOrderDocumentRepository(), encashmentDocumentRepository());
    }

    private final EnumConvertingService enumConvertingService() {
        return new EnumConvertingService();
    }

    private final OrderItemService orderItemService() {
        return new OrderItemService(organizationDocumentRepository(), dishDocumentRepository(), modifierLinkDocumentRepository(), modifierDocumentRepository(), modifierGroupDocumentRepository(), applicationState(), replicationService());
    }

    private final OfferAvailabilityHandler offerAvailabilityHandler() {
        return new OfferAvailabilityHandler(applicationState(), offerGiftProductsService(), offerComboMultiplicityService(), specialSetDocumentRepository(), comboDocumentRepository());
    }

    private final OfferComboMultiplicityService offerComboMultiplicityService() {
        return new OfferComboMultiplicityService();
    }

    private final OfferGiftProductsService offerGiftProductsService() {
        return new OfferGiftProductsService(dishDocumentRepository());
    }

    public final FixedDiscountController fixedDiscountController() {
        return new FixedDiscountController(fixedDiscountDocumentRepository(), replicationService(), applicationState());
    }

    public final FixedMarkupsController fixedMarkupsController() {
        return new FixedMarkupsController(fixedMarkupDocumentRepository(), replicationService(), applicationState());
    }

    public final CancellationReasonsController cancellationReasonsController() {
        return new CancellationReasonsController(cancellationReasonDocumentRepository(), replicationService());
    }

    public final OffersController offersController() {
        return new OffersController(replicationService(), applicationState(), comboDocumentRepository(), specialSetDocumentRepository());
    }

    public final TagsController tagsController() {
        return new TagsController(tagDocumentRepository(), replicationService());
    }

    public final DictionariesController dictionariesController() {
        DictionariesController dictionariesController;
        synchronized (dictionariesControllerValueLock) {
            dictionariesController = dictionariesControllerValue;
            boolean z = dictionariesController != null;
            if (z) {
                if (dictionariesController == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dictionariesControllerValue");
                    dictionariesController = null;
                }
            } else if (!z) {
                dictionariesController = new DictionariesController(INSTANCE.replicationService());
                dictionariesControllerValue = dictionariesController;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return dictionariesController;
    }

    private final FindDevicesService getFindDevicesService() {
        return (FindDevicesService) findDevicesService$delegate.getValue();
    }

    public final FindDevicesController findDevicesController() {
        return new FindDevicesController(backofficeWebClientService(), kitchenDisplayController(), realKkmDevicesController(), realPosDevicesController(), networkTicketPrinterService(), networkScanner(), getFindDevicesService());
    }

    public final SupportController supportServiceController() {
        return new SupportController(supportService());
    }

    public final SupportService supportService() {
        return new AndroidSupportService(androidDeviceInformationService(), mattermostService(), appContainerService(), applicationSettingsDocumentRepository());
    }

    private final ScannerHolder scannerHolder() {
        ScannerHolder scannerHolder;
        synchronized (scannerHolderValueLock) {
            scannerHolder = scannerHolderValue;
            boolean z = scannerHolder != null;
            if (z) {
                if (scannerHolder == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("scannerHolderValue");
                    scannerHolder = null;
                }
            } else if (!z) {
                scannerHolder = new ScannerHolder();
                scannerHolderValue = scannerHolder;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return scannerHolder;
    }

    private final PosDriverService posDriverService() {
        PosDriverService posDriverService;
        synchronized (posDriverServiceValueLock) {
            posDriverService = posDriverServiceValue;
            boolean z = posDriverService != null;
            if (z) {
                if (posDriverService == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("posDriverServiceValue");
                    posDriverService = null;
                }
            } else if (!z) {
                posDriverService = new PosDriverService(INSTANCE.posDeviceDocumentRepository());
                posDriverServiceValue = posDriverService;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return posDriverService;
    }

    private final NetworkScanner networkScanner() {
        NetworkScanner networkScanner;
        synchronized (networkScannerValueLock) {
            networkScanner = networkScannerValue;
            boolean z = networkScanner != null;
            if (z) {
                if (networkScanner == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("networkScannerValue");
                    networkScanner = null;
                }
            } else if (!z) {
                ServiceLocator serviceLocator = INSTANCE;
                networkScanner = new NetworkScanner(serviceLocator.scannerHolder(), serviceLocator.epsonDiscovery(), serviceLocator.samsDiscovery(), serviceLocator.bixolonTicketPrinterDiscovery(), serviceLocator.atolTicketPrinterDiscovery(), serviceLocator.atolKKMPrinterDiscovery());
                networkScannerValue = networkScanner;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return networkScanner;
    }

    private final OrderProcessingUtil orderProcessingUtil() {
        OrderProcessingUtil orderProcessingUtil = orderProcessingUtilValue;
        boolean z = orderProcessingUtil != null;
        if (z) {
            if (orderProcessingUtil != null) {
                return orderProcessingUtil;
            }
            Intrinsics.throwUninitializedPropertyAccessException("orderProcessingUtilValue");
            return null;
        } else if (!z) {
            ServiceLocator serviceLocator = INSTANCE;
            OrderProcessingUtil orderProcessingUtil2 = new OrderProcessingUtil(serviceLocator.orderDocumentV2Repository(), serviceLocator.preorderInfoDocumentRepository(), serviceLocator.discountService(), serviceLocator.tableOrderDocumentRepository());
            orderProcessingUtilValue = orderProcessingUtil2;
            return orderProcessingUtil2;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final CrmCustomerBonusHoldServiceImpl crmCustomerBonusHoldService() {
        CrmCustomerBonusHoldServiceImpl crmCustomerBonusHoldServiceImpl = crmCustomerBonusHoldServiceValue;
        boolean z = crmCustomerBonusHoldServiceImpl != null;
        if (z) {
            if (crmCustomerBonusHoldServiceImpl != null) {
                return crmCustomerBonusHoldServiceImpl;
            }
            Intrinsics.throwUninitializedPropertyAccessException("crmCustomerBonusHoldServiceValue");
            return null;
        } else if (!z) {
            ServiceLocator serviceLocator = INSTANCE;
            CrmCustomerBonusHoldServiceImpl crmCustomerBonusHoldServiceImpl2 = new CrmCustomerBonusHoldServiceImpl(serviceLocator.applicationState(), serviceLocator.backofficeWebClientService());
            crmCustomerBonusHoldServiceValue = crmCustomerBonusHoldServiceImpl2;
            return crmCustomerBonusHoldServiceImpl2;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final ReceiverInterface atolTicketPrinterReceiver() {
        return new AtolTicketPrinterReceiver();
    }

    private final ReceiverInterface bixolonReceiver() {
        return new BixolonTicketPrinterReceiver();
    }

    private final ReceiverInterface epsonReceiver() {
        return new EpsonReceiver();
    }

    private final ReceiverInterface samsReceiver() {
        return new SamsReceiver(networkTicketPrinterService());
    }

    private final NetworkTicketPrinterService networkTicketPrinterService() {
        return new NetworkTicketPrinterService(ticketPrinterSettingsDictionary(), ordersService(), imageDocumentRepository(), templateDocumentRepository(), androidImageProcessorService(), specialSetDocumentRepository());
    }

    private final AtolKKMPrinterDiscovery atolKKMPrinterDiscovery() {
        return new AtolKKMPrinterDiscovery(atolKKMReceiver(), scannerHolder(), ticketPrinterSettingsDictionary());
    }

    private final AtolKkmPrinterReceiver atolKKMReceiver() {
        return new AtolKkmPrinterReceiver(atolService());
    }

    private final AtolTicketPrinterDiscovery atolTicketPrinterDiscovery() {
        return new AtolTicketPrinterDiscovery(atolTicketPrinterReceiver(), scannerHolder(), ticketPrinterSettingsDictionary());
    }

    private final BixolonTicketPrinterDiscovery bixolonTicketPrinterDiscovery() {
        return new BixolonTicketPrinterDiscovery(bixolonReceiver(), scannerHolder(), ticketPrinterSettingsDictionary());
    }

    private final SamsDiscovery samsDiscovery() {
        return new SamsDiscovery(samsReceiver(), scannerHolder(), ticketPrinterSettingsDictionary());
    }

    private final EpsonDiscovery epsonDiscovery() {
        return new EpsonDiscovery(epsonReceiver(), scannerHolder(), ticketPrinterSettingsDictionary());
    }

    public final ImageController imageController() {
        return new ImageController(imageManagerService());
    }

    private final ImageManagerService imageManagerService() {
        return new ImageManagerService(backofficeWebClientService());
    }

    public final PriceModifiersController priceModifiersController() {
        return new PriceModifiersController(orderDocumentV2Repository(), tableOrderDocumentRepository(), priceModifiersService(), orderProcessingUtil());
    }

    public final CrmCustomerController crmCustomerController() {
        return new CrmCustomerController(backofficeWebClientService(), replicationService(), orderDocumentV2Repository(), ordersService(), crmCustomerService(), specialSetDocumentRepository());
    }

    public final AppContainerController appContainerController() {
        return new AppContainerController(appContainerService());
    }

    public final AppContainerService appContainerService() {
        return new AndroidAppContainerService(WTApplication.Companion.getContext(), applicationSettingsDocumentRepository());
    }

    private final ServiceLocator$terminalVersionService$1 terminalVersionService() {
        return new ServiceLocator$terminalVersionService$1();
    }

    private final AndroidImageProcessorService androidImageProcessorService() {
        return new AndroidImageProcessorService();
    }

    private final ServiceLocator$androidDeviceInformationService$1 androidDeviceInformationService() {
        return new ServiceLocator$androidDeviceInformationService$1();
    }

    private final ContactMethodValidatorService contactMethodValidatorService() {
        return new ContactMethodValidatorService();
    }

    public final MigrationDatabaseService migrationDatabaseService() {
        return new MigrationDatabaseService();
    }

    private final DiscountService discountService() {
        return new DiscountService(scheduledDiscountDocumentRepository(), priceModifiersService());
    }

    private final PriceModifiersService priceModifiersService() {
        return new PriceModifiersService(fixedDiscountDocumentRepository(), fixedMarkupDocumentRepository(), scheduledDiscountDocumentRepository(), orderDocumentV2Repository(), crmCustomerBonusHoldService());
    }

    public final LogService logService() {
        return new AndroidLogService();
    }

    public final MattermostService mattermostService() {
        return new MattermostService(logService(), androidDeviceInformationService(), applicationSettingsDocumentRepository());
    }

    private final OnlineOfferConverter onlineOfferConverter() {
        return new OnlineOfferConverter(paymentTypeDocumentRepository(), specialSetDocumentRepository());
    }

    private final PosShiftManagerService posShiftManagerService() {
        return new PosShiftManagerService(applicationState(), posDeviceDocumentRepository(), posDriverService(), posShiftDocumentRepository(), posPaymentDocumentRepository(), posRefundDocumentRepository(), orderDocumentV2Repository(), kitchenDisplayDocumentRepository(), kitchenDeviceTypeLocator());
    }

    private final TrueApiService trueApiService() {
        return new TrueApiService(objectMapper(), trueApiDocumentRepository(), organizationDocumentRepository(), applicationState(), virtualKkmDeviceDocumentRepository(), deviceDocumentRepository(), tableOrderDocumentRepository(), orderDocumentV2Repository(), webClientUtils());
    }

    private final WebClientUtils webClientUtils() {
        return new WebClientUtils(applicationState(), objectMapper());
    }

    private final DxBxService dxBxService() {
        return new DxBxService(applicationState(), androidDeviceInformationService(), objectMapper(), webClientUtils());
    }

    private final DxBxTaskManagerService dxBxTaskManagerService() {
        DxBxTaskManagerService dxBxTaskManagerService = dxBxTaskManagerServiceValue;
        boolean z = dxBxTaskManagerService != null;
        if (z) {
            if (dxBxTaskManagerService != null) {
                return dxBxTaskManagerService;
            }
            Intrinsics.throwUninitializedPropertyAccessException("dxBxTaskManagerServiceValue");
            return null;
        } else if (!z) {
            ServiceLocator serviceLocator = INSTANCE;
            DxBxTaskManagerService dxBxTaskManagerService2 = new DxBxTaskManagerService(serviceLocator.dxBxTaskDocumentRepository(), serviceLocator.dxBxService(), serviceLocator.organizationDocumentRepository(), serviceLocator.tableOrderDocumentRepository(), serviceLocator.kitchenDeviceTypeLocator(), serviceLocator.virtualKkmDeviceDocumentRepository(), serviceLocator.deviceDocumentRepository(), serviceLocator.kitchenDisplayDocumentRepository());
            dxBxTaskManagerServiceValue = dxBxTaskManagerService2;
            return dxBxTaskManagerService2;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final ImagePathManagerService imagePathManagerService() {
        ImagePathManagerService imagePathManagerService = imagePathManagerServiceValue;
        boolean z = imagePathManagerService != null;
        if (z) {
            if (imagePathManagerService != null) {
                return imagePathManagerService;
            }
            Intrinsics.throwUninitializedPropertyAccessException("imagePathManagerServiceValue");
            return null;
        } else if (!z) {
            ImagePathManagerService imagePathManagerService2 = new ImagePathManagerService();
            imagePathManagerServiceValue = imagePathManagerService2;
            return imagePathManagerService2;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final ApplicationSettingsDocumentRepositoryImpl applicationSettingsDocumentRepository() {
        return new ApplicationSettingsDocumentRepositoryImpl();
    }

    private final TerminalDocumentRepositoryImpl terminalDocumentRepository() {
        return new TerminalDocumentRepositoryImpl();
    }

    private final KkmDeviceDocumentRepositoryImpl deviceDocumentRepository() {
        return new KkmDeviceDocumentRepositoryImpl();
    }

    private final PosDeviceDocumentRepositoryImpl posDeviceDocumentRepository() {
        return new PosDeviceDocumentRepositoryImpl();
    }

    private final VirtualKkmDeviceDocumentRepositoryImpl virtualKkmDeviceDocumentRepository() {
        return new VirtualKkmDeviceDocumentRepositoryImpl();
    }

    private final VirtualPosDeviceDocumentRepositoryImpl virtualPosDeviceDocumentRepository() {
        return new VirtualPosDeviceDocumentRepositoryImpl();
    }

    private final TerminalUserDocumentRepositoryImpl terminalUserDocumentRepository() {
        return new TerminalUserDocumentRepositoryImpl();
    }

    private final SalePlaceDocumentRepositoryImpl salePlaceDocumentRepository() {
        return new SalePlaceDocumentRepositoryImpl();
    }

    private final TableSchemeDocumentRepositoryImpl tableSchemeDocumentRepository() {
        return new TableSchemeDocumentRepositoryImpl();
    }

    private final OrganizationDocumentRepositoryImpl organizationDocumentRepository() {
        return new OrganizationDocumentRepositoryImpl();
    }

    private final CookingPlaceDocumentRepositoryImpl cookingPlaceDocumentRepository() {
        return new CookingPlaceDocumentRepositoryImpl();
    }

    private final OrderDocumentRepositoryImpl orderDocumentRepository() {
        return new OrderDocumentRepositoryImpl();
    }

    private final OrderDocumentV2RepositoryImpl orderDocumentV2Repository() {
        return new OrderDocumentV2RepositoryImpl();
    }

    private final TableOrderDocumentRepositoryImpl tableOrderDocumentRepository() {
        return new TableOrderDocumentRepositoryImpl();
    }

    private final KitchenDisplayDocumentRepositoryImpl kitchenDisplayDocumentRepository() {
        return new KitchenDisplayDocumentRepositoryImpl();
    }

    private final NomenclatureItemSaleDocumentRepositoryImpl nomenclatureItemSaleDocumentRepository() {
        return new NomenclatureItemSaleDocumentRepositoryImpl();
    }

    private final ModifierGroupDocumentRepositoryImpl modifierGroupDocumentRepository() {
        return new ModifierGroupDocumentRepositoryImpl();
    }

    private final ModifierDocumentRepositoryImpl modifierDocumentRepository() {
        return new ModifierDocumentRepositoryImpl();
    }

    private final ModifierLinkDocumentRepositoryImpl modifierLinkDocumentRepository() {
        return new ModifierLinkDocumentRepositoryImpl();
    }

    private final DishGroupDocumentRepositoryImpl dishGroupDocumentRepository() {
        return new DishGroupDocumentRepositoryImpl();
    }

    private final DishDocumentRepositoryImpl dishDocumentRepository() {
        return new DishDocumentRepositoryImpl();
    }

    private final PaymentTypeDocumentRepositoryImpl paymentTypeDocumentRepository() {
        return new PaymentTypeDocumentRepositoryImpl();
    }

    private final EncashmentDocumentRepositoryImpl encashmentDocumentRepository() {
        return new EncashmentDocumentRepositoryImpl();
    }

    private final FixedDiscountDocumentRepositoryImpl fixedDiscountDocumentRepository() {
        return new FixedDiscountDocumentRepositoryImpl();
    }

    private final ComboOffersDocumentRepositoryImpl comboDocumentRepository() {
        return new ComboOffersDocumentRepositoryImpl();
    }

    private final FixedMarkupDocumentRepositoryImpl fixedMarkupDocumentRepository() {
        return new FixedMarkupDocumentRepositoryImpl();
    }

    private final ScheduledDiscountDocumentRepositoryImpl scheduledDiscountDocumentRepository() {
        return new ScheduledDiscountDocumentRepositoryImpl();
    }

    private final CancellationReasonDocumentRepositoryImpl cancellationReasonDocumentRepository() {
        return new CancellationReasonDocumentRepositoryImpl();
    }

    private final TagDocumentRepositoryImpl tagDocumentRepository() {
        return new TagDocumentRepositoryImpl();
    }

    private final SpecialSetDocumentRepositoryImpl specialSetDocumentRepository() {
        return new SpecialSetDocumentRepositoryImpl();
    }

    private final VersionsDocumentRepositoryImpl versionsDocumentRepository() {
        return new VersionsDocumentRepositoryImpl();
    }

    private final ShiftDocumentRepositoryImpl shiftDocumentRepository() {
        return new ShiftDocumentRepositoryImpl();
    }

    private final PosShiftDocumentRepositoryImpl posShiftDocumentRepository() {
        return new PosShiftDocumentRepositoryImpl();
    }

    private final PosPaymentDocumentRepositoryImpl posPaymentDocumentRepository() {
        return new PosPaymentDocumentRepositoryImpl();
    }

    private final PosRefundDocumentRepositoryImpl posRefundDocumentRepository() {
        return new PosRefundDocumentRepositoryImpl();
    }

    private final PreorderInfoDocumentRepositoryImpl preorderInfoDocumentRepository() {
        return new PreorderInfoDocumentRepositoryImpl();
    }

    private final SoldoutListDocumentRepositoryImpl soldoutListDocumentRepository() {
        return new SoldoutListDocumentRepositoryImpl();
    }

    private final CurrencyDocumentRepositoryImpl currencyDocumentRepository() {
        return new CurrencyDocumentRepositoryImpl();
    }

    private final OnlineOfferDocumentRepositoryImpl onlineOfferDocumentRepository() {
        return new OnlineOfferDocumentRepositoryImpl();
    }

    private final SysExtrasDocumentRepositoryImpl sysExtrasDocumentRepository() {
        return new SysExtrasDocumentRepositoryImpl();
    }

    private final OnlineInterfaceDocumentRepositoryImpl onlineInterfaceDocumentRepository() {
        return new OnlineInterfaceDocumentRepositoryImpl();
    }

    private final TemplateDocumentRepositoryImpl templateDocumentRepository() {
        return new TemplateDocumentRepositoryImpl();
    }

    private final ImageDocumentRepositoryImpl imageDocumentRepository() {
        return new ImageDocumentRepositoryImpl();
    }

    private final MenuDocumentRepositoryImpl menuDocumentRepository() {
        return new MenuDocumentRepositoryImpl();
    }

    private final TrueApiDocumentRepositoryImpl trueApiDocumentRepository() {
        return new TrueApiDocumentRepositoryImpl();
    }

    private final DxBxTaskDocumentRepositoryImpl dxBxTaskDocumentRepository() {
        return new DxBxTaskDocumentRepositoryImpl();
    }
}
