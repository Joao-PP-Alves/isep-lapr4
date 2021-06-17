package eapli.base.app.backoffice.console.presentation.taskspec;

import eapli.base.service.domain.*;
import eapli.base.service.application.AddManualTaskSpecController;
import eapli.base.service.domain.Script;
import eapli.base.service.domain.TaskSpec;
import eapli.framework.general.domain.model.Description;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.HashSet;
import java.util.Set;


public class AddManualTaskSpecUI extends AbstractUI {

    private final AddManualTaskSpecController theController = new AddManualTaskSpecController();
    @Override
    protected boolean doShow() {

        final String taskSpecId = Console.readLine("TaskSpec ID");
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
        String sc = Console.readLine("Introduce the file containing the script");
        Script script = new Script(theController.makeStringFromFile(sc));
        Form form = theController.createForm(formName, fieldSet,script);

        TaskSpec manualTaskSpec = theController.addManualTaskSpec(taskSpecId, form);


        //theController.manageAccessCriteria(sc,teamsSet);
        return true;
    }



    @Override
    public String headline() {
        return "Add Service";
    }
}
