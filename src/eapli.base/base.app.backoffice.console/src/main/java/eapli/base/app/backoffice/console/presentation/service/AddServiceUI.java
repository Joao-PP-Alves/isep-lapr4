package eapli.base.app.backoffice.console.presentation.service;

import eapli.base.service.application.AddServiceController;
import eapli.base.service.application.AddServiceDraftController;
import eapli.base.service.domain.*;
import eapli.base.servicecatalog.application.AddServiceCatalogController;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.base.taskspec.application.AddAutoTaskSpecController;
import eapli.base.taskspec.application.AddManualTaskSpecController;
import eapli.base.taskspec.domain.AutoTaskSpec;
import eapli.base.taskspec.domain.ManualTaskSpec;
import eapli.base.taskspec.domain.Script;
import eapli.base.taskspec.domain.TaskSpec;
import eapli.framework.actions.Actions;
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

public class AddServiceUI extends AbstractUI {

    private final AddServiceController theController = new AddServiceController();
    private final AddServiceDraftController theDraftController = new AddServiceDraftController();
    private final AddManualTaskSpecController theManController = new AddManualTaskSpecController();
    private final AddAutoTaskSpecController theAutoController = new AddAutoTaskSpecController();


    @Override
    protected boolean doShow() {
        final String name = Console.readLine("Name");
        final String shortServiceDescription = Console.readLine("Short Description");
        final String longServiceDescription = Console.readLine("Long Description");
        boolean keepGoing = false;
        Set<KeyWord> keyWords = new HashSet<>();
        while (!keepGoing){
            keyWords.add(new KeyWord(Console.readLine("Key Word")));
            String keepAdding = Console.readLine("Add more KeyWords? (Y/N)");
            if (keepAdding.equalsIgnoreCase("N") || keepAdding.equalsIgnoreCase("No")){
                keepGoing = true;
            }
        }
        if (submenu()) {
            theDraftController.addServiceDraft(name, null, shortServiceDescription, longServiceDescription, null, null, null, "icon", keyWords, false);
            return true;
        }
        boolean show;
        System.out.println("Choose a catalog");
        Set<ServiceCatalog> serviceCatalogSet = new HashSet<>();
        do {
            show = showServiceCatalogs(serviceCatalogSet);
        } while (!show);
        List<ServiceCatalog> listCatalogs = new ArrayList<>(serviceCatalogSet);
        if (submenu()) {
            theDraftController.addServiceDraft(name, listCatalogs.get(0), shortServiceDescription, longServiceDescription, null, null, null, "icon", keyWords, false);
            return true;
        }
        String formName = Console.readLine("Form name");
        System.out.println("Fill the form");
        Set<Field> fieldSet = new HashSet<>();
        keepGoing=false;
        while (!keepGoing){
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
                keepGoing = true;
            }
        }
        String sc = Console.readLine("Introduce the script");
        Script script = new Script(sc);
        Form form = new Form(Designation.valueOf(formName), fieldSet,script);
        if (submenu()) {
            theDraftController.addServiceDraft(name, listCatalogs.get(0), shortServiceDescription, longServiceDescription, null, form, null, "icon", keyWords, false);
            return true;
        }
        String approvalTaskS = Console.readLine("Need aproval Task?? (Y/N)");
        boolean apr;
        if (approvalTaskS.equalsIgnoreCase("y") || approvalTaskS.equalsIgnoreCase("yes")){
            apr = false;
        } else {
            apr = true;
        }
        ApprovalTask approvalTask = new ApprovalTask(apr);
        if (submenu()) {
            theDraftController.addServiceDraft(name, listCatalogs.get(0), shortServiceDescription, longServiceDescription, approvalTask, form, null, "icon", keyWords, false);
            return true;
        }

        ManualTaskSpec manualTaskSpec;
        AutoTaskSpec autoTaskSpec;
        String type = Console.readLine("Will the task be Manual(1) or Automatic(2)?");
        TaskSpec taskSpec = new TaskSpec(type);
        //TODO Let User choose from Manual or Automatic Task
        if (type.equalsIgnoreCase("Manual") || type.equalsIgnoreCase("1")){
            final String taskSpecId = Console.readLine("TaskSpec ID");
            formName = Console.readLine("Form name");
            System.out.println("Fill the form");
            fieldSet = new HashSet<>();
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
            sc = Console.readLine("Introduce the script");
            script = new Script(sc);
            form = theManController.createForm(formName, fieldSet,script);

            manualTaskSpec = theManController.addManualTaskSpec(taskSpecId, form);
            taskSpec = manualTaskSpec;
        } else if (type.equalsIgnoreCase("Automatic") || type.equalsIgnoreCase("2") || type.equalsIgnoreCase("Auto") ){
            final String taskSpecId = Console.readLine("TaskSpec ID");
            formName = Console.readLine("Put in the script");

            script = theAutoController.addScript(formName);
            autoTaskSpec = theAutoController.addAutoTaskSpec(taskSpecId,script);
            taskSpec = autoTaskSpec;
        } else {
            return false;
        }
        if (submenu()) {
            theDraftController.addServiceDraft(name, listCatalogs.get(0), shortServiceDescription, longServiceDescription, approvalTask, form, taskSpec, "icon", keyWords, false);
            return true;
        }

        String completion = Console.readLine("Consider this service specification complete? (Y/N)");
        if (completion.equalsIgnoreCase("y") || completion.equalsIgnoreCase("yes")){
            theController.addService(name, listCatalogs.get(0), shortServiceDescription, longServiceDescription, approvalTask, form, taskSpec, null, keyWords);
        } else {
            theDraftController.addServiceDraft(name, listCatalogs.get(0), shortServiceDescription, longServiceDescription, approvalTask, form, taskSpec, "icon", keyWords, false);
        }
        return true;
    }


    private boolean submenu(){
        boolean show;
        Set<Integer> integers = new HashSet<>();
        do{
            show = showOptions(integers);
        } while (!show);
        if (integers.contains(1)) {
           return true;
        }
        return false;
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

    @Override
    public String headline() {
        return "Add a new Service";
    }
}
