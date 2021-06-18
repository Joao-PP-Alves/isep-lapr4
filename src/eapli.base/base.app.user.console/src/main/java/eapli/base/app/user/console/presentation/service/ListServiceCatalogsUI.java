package eapli.base.app.user.console.presentation.service;
import eapli.base.service.domain.Service;
import eapli.base.servicecatalog.application.ListServiceCatalogsController;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListServiceCatalogsUI extends AbstractUI {

    private final ListServiceCatalogsController theController = new ListServiceCatalogsController();
    @Override
    protected boolean doShow() {
        boolean back = true;
        final Set<ServiceCatalog> serviceCatalogs = new HashSet<>();
        boolean show;
        do {
            show = showServiceCatalogs(serviceCatalogs);
        } while(!show);
        List<ServiceCatalog> list = new ArrayList<>(serviceCatalogs);
        Set<Service> services = new HashSet<>();
        do {
            show = showServices(services,list.get(0));
        } while (!show);
        return true;
    }

    /*private boolean subCatalogsMenu(ServiceCatalog serviceCatalog){
        boolean back = true;
        while(back) {
            if (serviceCatalog.getListSubCatalogs()!=null) {
                List<ServiceCatalog> listCS = new ArrayList<>(serviceCatalog.getListSubCatalogs());
                int contador = 0;
                for (ServiceCatalog sc : listCS) {
                    System.out.printf("(Catalog) %d -> %s - %s\n", contador, sc.getTitle(), sc.identity());
                    contador++;
                }
                System.out.printf("%d -> Back.\n", contador);
                int option = Console.readInteger("Select catalog or service.\n");
                while (option < 0 || option > listCS.size()) {
                    System.out.println("Invalid option. Try again.");
                    option = Console.readInteger("Select collaborator.\n");
                }
                if (option == contador) {
                    return true;
                } else {
                    ServiceCatalog sc = listCS.get(option);
                    subCatalogsMenu(sc);
                }
            } else {
                List<Service> list = theController.listServicesFromCatalog(serviceCatalog);
            }
        }
        return true;
    }*/

    private boolean showServices(final Set<Service> services, ServiceCatalog serviceCatalog) {
        final Menu servicesMenu = buildServicesMenu(services,serviceCatalog);
        final MenuRenderer renderer = new VerticalMenuRenderer(servicesMenu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildServicesMenu(final Set<Service> services, ServiceCatalog serviceCatalog){
        final Menu servicesMenu = new Menu();
        int counter = 0;
        servicesMenu.addItem(counter++,"Back", Actions.SUCCESS);
        for (Service s: theController.listServicesFromCatalog(serviceCatalog)) {
            servicesMenu.addItem(counter++, s.name().toString(),() -> services.add(s));
        }
        return servicesMenu;
    }

    private boolean showServiceCatalogs(final Set<ServiceCatalog> serviceCatalogs) {
        final Menu serviceCatalogsMenu = buildServiceCatalogsMenu(serviceCatalogs);
        final MenuRenderer renderer = new VerticalMenuRenderer(serviceCatalogsMenu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildServiceCatalogsMenu(final Set<ServiceCatalog> serviceCatalogs){
        final Menu serviceCatalogsMenu = new Menu();
        int counter = 0;
        serviceCatalogsMenu.addItem(counter++,"Back", Actions.SUCCESS);
        for (ServiceCatalog sc: theController.listTopServiceCatalogs()) {
            serviceCatalogsMenu.addItem(counter++, sc.getTitleAndBriefDescription(),() -> serviceCatalogs.add(sc));
        }
        return serviceCatalogsMenu;
    }

    @Override
    public String headline() {
        return "Catalogs and Services";
    }
}
