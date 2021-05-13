package eapli.base.app.backoffice.console.presentation.servicecatalog;

import eapli.base.servicecatalog.application.AddServiceCatalogController;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.HashSet;


public class AddServiceCatalogUI extends AbstractUI {

    private final AddServiceCatalogController theController = new AddServiceCatalogController();
    @Override
    protected boolean doShow() {
        final String title = Console.readLine("Title");
        final String shortDescription = Console.readLine("Short Description");
        final String longDescription = Console.readLine("Long Description");
        //Missing ICON, SubCatalogs and topCatalog option.
        theController.addServiceCatalog(title,shortDescription,longDescription,null,new HashSet<>(),true);
        return true;
    }



    @Override
    public String headline() {
        return "Add Service";
    }
}
