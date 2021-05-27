package eapli.base.app.backoffice.console.presentation.taskspec;

import eapli.base.service.domain.*;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.base.taskspec.application.AddManualTaskSpecController;
import eapli.base.taskspec.domain.ManualTaskSpec;
import eapli.base.taskspec.domain.TaskSpec;
import eapli.base.team.domain.Team;
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


public class AddManualTaskSpecUI extends AbstractUI {

    private final AddManualTaskSpecController theController = new AddManualTaskSpecController();
    @Override
    protected boolean doShow() {

        final String taskSpecId = Console.readLine("TaskSpec ID");
        //final String shortDescription = Console.readLine("TaskSpec Type");


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
        Form form = theController.createForm(formName, fieldSet);

        TaskSpec manualTaskSpec = theController.addManualTaskSpec(taskSpecId, form);


        //theController.manageAccessCriteria(sc,teamsSet);
        return true;
    }



    @Override
    public String headline() {
        return "Add Service";
    }
}
