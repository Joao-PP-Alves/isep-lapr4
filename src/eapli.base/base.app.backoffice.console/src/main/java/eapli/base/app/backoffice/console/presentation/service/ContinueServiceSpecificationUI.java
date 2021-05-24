package eapli.base.app.backoffice.console.presentation.service;

import eapli.base.service.application.AddServiceController;
import eapli.base.service.application.AddServiceDraftController;
import eapli.base.service.application.ContinueServiceSpecificationController;
import eapli.base.service.domain.*;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.base.taskspec.domain.TaskSpec;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContinueServiceSpecificationUI extends AbstractUI {

    private final AddServiceController theController = new AddServiceController();
    private final ContinueServiceSpecificationController theListController = new ContinueServiceSpecificationController();

    @Override
    protected boolean doShow() {
        boolean show = false;
        Set<ServiceDraft> serviceDrafts = new HashSet<>();
        while (!show){
            show = showServiceDrafts(serviceDrafts);
        }
        List<ServiceDraft> serviceDraftList = new ArrayList<>(serviceDrafts);
        if (serviceDraftList.get(0).getServiceCatalog()==null){
            System.out.println("Choose a catalog");
            Set<ServiceCatalog> serviceCatalogSet = new HashSet<>();
            do {
                show = showServiceCatalogs(serviceCatalogSet);
            } while (!show);
            List<ServiceCatalog> listCatalogs = new ArrayList<>(serviceCatalogSet);
            if (submenu()) {
                theListController.updateServiceDraft(serviceDraftList.get(0),listCatalogs.get(0),null,null,null);
                return true;
            }
        }
        if (serviceDraftList.get(0).getForm()==null){
            String formName = Console.readLine("Form name");
            System.out.println("Fill the form");
            Set<Field> fieldSet = new HashSet<>();
            boolean go=false;
            while (!go){
                String fname = Console.readLine("Variable name");
                String expr = Console.readLine("Regular expression to validate answer");
                String helpDescription = Console.readLine("Help to fill the field");
                String pres = Console.readLine("Presentation ticket");
                String dataType = Console.readLine("Type of data needed");
                DataTypesAllowed data;
                if (dataType.equalsIgnoreCase("double")){
                    data = DataTypesAllowed.DOUBLE;
                } else if (dataType.equalsIgnoreCase("int")){
                    data = DataTypesAllowed.INT;
                } else {
                    data = DataTypesAllowed.STRING;
                }
                fieldSet.add(new Field(new RegularExpression(expr),fname, Description.valueOf(helpDescription),new PresentationTicket(pres),data));
                String keepAdding = Console.readLine("Add more Fields?? (Y/N)");
                if (keepAdding.equalsIgnoreCase("N") || keepAdding.equalsIgnoreCase("No")){
                    go = true;
                }
            }
            Form form = new Form(Designation.valueOf(formName),fieldSet);
            if (submenu()) {
                theListController.updateServiceDraft(serviceDraftList.get(0),null,form,null,null);
                return true;
            }
        }
        if (serviceDraftList.get(0).getApprovalTask()==null){
            String approvalTaskS = Console.readLine("Need aproval Task?? (Y/N)");
            boolean apr;
            apr = !approvalTaskS.equalsIgnoreCase("y") && !approvalTaskS.equalsIgnoreCase("yes");
            ApprovalTask approvalTask = new ApprovalTask(apr);
            if (submenu()) {
                theListController.updateServiceDraft(serviceDraftList.get(0),null,null,approvalTask,null);
                return true;
            }
        }
        if (serviceDraftList.get(0).getTaskSpec()==null){
            String type = Console.readLine("Will the task be Manual or Automatic?");
            TaskSpec taskSpec = new TaskSpec(type);

            if (submenu()) {
                theListController.updateServiceDraft(serviceDraftList.get(0),null,null,null,taskSpec);
                return true;
            }
        }
        String finish = Console.readLine("Consider this service specification complete? (Y/N)");
        if (finish.equalsIgnoreCase("y") || finish.equalsIgnoreCase("yes")){
            theListController.finishServiceSpecification(serviceDraftList.get(0));
        } else {
            theListController.updateServiceDraft(serviceDraftList.get(0),null,null,null,null);
        }
        return true;
    }

    private boolean submenu(){
        boolean show;
        Set<Integer> integers = new HashSet<>();
        do{
            show = showOptions(integers);
        } while (!show);
        return integers.contains(1);
    }

    private boolean showOptions(Set<Integer> options) {
        final Menu optionsMenu = buildOptionsMenu(options);
        final MenuRenderer renderer = new VerticalMenuRenderer(optionsMenu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildOptionsMenu(Set<Integer> options) {
        final Menu optionsMenu = new Menu();
        optionsMenu.addItem(MenuItem.of(1, "Pause Specification", () -> options.add(1)));
        optionsMenu.addItem(MenuItem.of(2, "Continue Specification", () -> options.add(2)));
        return optionsMenu;
    }

    private boolean showServiceDrafts(final Set<ServiceDraft> serviceDrafts) {
        final Menu serviceDrafsMenu = buildServiceDraftsMenu(serviceDrafts);
        final MenuRenderer renderer = new VerticalMenuRenderer(serviceDrafsMenu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildServiceDraftsMenu(final Set<ServiceDraft> serviceDrafts){
        final Menu serviceDrafsMenu = new Menu();
        int counter = 0;
        for (ServiceDraft sc: theListController.listServiceDrafts()) {
            serviceDrafsMenu.addItem(counter++, sc.getName().toString(),() -> serviceDrafts.add(sc));
        }
        return serviceDrafsMenu;
    }
    private boolean showServiceCatalogs(final Set<ServiceCatalog> serviceCatalogs) {
        final Menu serviceCatalogsMenu = buildServiceCatalogsMenu(serviceCatalogs);
        final MenuRenderer renderer = new VerticalMenuRenderer(serviceCatalogsMenu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildServiceCatalogsMenu(final Set<ServiceCatalog> serviceCatalogs){
        final Menu serviceCatalogsMenu = new Menu();
        int counter = 0;
        for (ServiceCatalog sc: theController.getCatalogs()) {
            serviceCatalogsMenu.addItem(counter++, sc.getTitle().toString(),() -> serviceCatalogs.add(sc));
        }
        return serviceCatalogsMenu;
    }

    @Override
    public String headline() {
        return null;
    }
}
