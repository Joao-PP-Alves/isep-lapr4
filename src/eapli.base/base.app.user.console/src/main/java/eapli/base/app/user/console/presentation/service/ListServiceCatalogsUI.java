package eapli.base.app.user.console.presentation.service;

import eapli.base.collaboratormanagement.domain.Collaborator;
import eapli.base.service.domain.Service;
import eapli.base.servicecatalog.application.ListServiceCatalogsController;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ListServiceCatalogsUI extends AbstractUI {

    private final ListServiceCatalogsController theController = new ListServiceCatalogsController();
    @Override
    protected boolean doShow() {
        boolean back = true;
        while(back) {
            ArrayList<ServiceCatalog> list = (ArrayList<ServiceCatalog>) theController.listTopServiceCatalogs();
            int contador = 0;
            for (ServiceCatalog sc : list) {
                System.out.printf("%d -> %s - %s\n", contador, sc.getTitle(), sc.identity());
                contador++;
            }
            System.out.printf("%d -> Back.\n", contador);
            int option = Console.readInteger("Select catalog.\n");
            while (option < 0 || option > list.size()) {
                System.out.println("Invalid option. Try again.");
                option = Console.readInteger("Select collaborator.\n");
            }
            if (option == contador) {
                return true;
            }
            ServiceCatalog serviceCatalog = list.get(option);
            back = subCatalogsMenu(serviceCatalog);
        }
        return true;
    }

    private boolean subCatalogsMenu(ServiceCatalog serviceCatalog){
        boolean back = true;
        while(back) {
            assert serviceCatalog.getListServices() != null;
            List<Service> listS = new ArrayList<>(serviceCatalog.getListServices());
            assert serviceCatalog.getListSubCatalogs() != null;
            List<ServiceCatalog> listCS = new ArrayList<>(serviceCatalog.getListSubCatalogs());
            int contador = 0;
            for (ServiceCatalog sc : listCS) {
                System.out.printf("(Catalog) %d -> %s - %s\n", contador, sc.getTitle(), sc.identity());
                contador++;
            }

            for (Service s : listS) {

                contador++;
            }
            System.out.printf("%d -> Back.\n", contador);
            int option = Console.readInteger("Select catalog or service.\n");
            while (option < 0 || option > listCS.size()+listS.size()) {
                System.out.println("Invalid option. Try again.");
                option = Console.readInteger("Select collaborator.\n");
            }
            if (option == contador) {
                return true;
            } else if(option<listCS.size()){
                ServiceCatalog sc = listCS.get(option);
                subCatalogsMenu(serviceCatalog);
            } else {
                Service s = listS.get(option);
                System.out.printf("(Service) %d -> %s - %s\n", contador, s.getName(), s.identity());
                System.out.println("Not implemented yet!\n");
            }
        }
        return true;
    }

    @Override
    public String headline() {
        return "Catalogs and Services";
    }
}
