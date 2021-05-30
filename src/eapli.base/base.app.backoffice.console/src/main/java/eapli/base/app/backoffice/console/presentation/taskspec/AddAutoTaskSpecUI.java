package eapli.base.app.backoffice.console.presentation.taskspec;

import eapli.base.taskspec.application.AddAutoTaskSpecController;
import eapli.base.taskspec.domain.Script;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class AddAutoTaskSpecUI  extends AbstractUI {

    private final AddAutoTaskSpecController theController = new AddAutoTaskSpecController();

    @Override
    protected boolean doShow() {
        final String taskSpecId = Console.readLine("TaskSpec ID");
        String formName = Console.readLine("Put in the script");

        Script script = theController.addScript(formName);
        theController.addAutoTaskSpec(taskSpecId,script);
        return true;
    }

    @Override
    public String headline() {
        return "Automatic Task Specification";
    }
}
