package eapli.base.app.backoffice.console.presentation.collaborator;

import eapli.base.app.backoffice.console.presentation.authz.AddUserUI;
import eapli.framework.actions.Action;

/**
 * Menu action for adding a new user to the application. Created by nuno on
 * 22/03/16.
 */
public class AddCollaboratorAction implements Action {

    @Override
    public boolean execute() {
        return new AddCollaboratorUI().show();
    }
}
