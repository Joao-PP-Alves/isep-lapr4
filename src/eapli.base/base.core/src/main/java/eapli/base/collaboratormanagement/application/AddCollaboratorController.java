package eapli.base.collaboratormanagement.application;

import eapli.base.collaboratormanagement.domain.Collaborator;
import eapli.base.collaboratormanagement.domain.CollaboratorBuilder;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;

import java.util.Date;

/**
 * Based on AddCollbaratorController
 * Created by João Correia
 */
@UseCaseController
public class AddCollaboratorController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final UserManagementService userSvc = AuthzRegistry.userService();
    private final  CollaboratorBuilder collabBuilder = new CollaboratorBuilder();
    /**
     * Get existing RoleTypes available to the user.
     *
     * @return a list of RoleTypes
     */
/*    public Role[] getRoleTypes() {
        return BaseRoles.nonUserValues();
    }*/

/*    public Collaborator addNewCollaborator(String fullName, String shortName, String address, Date creationDate,
                                           int phoneNumber, String role) {

        return collabBuilder.registerNewCollaborator(fullName, shortName, address, creationDate, phoneNumber, role);
    }*/

/*    public SystemUser addUser(String username, String password, String firstName, String lastName,
            String email, Set<Role> roles) {
        return addUser(username, password, firstName, lastName, email, roles, Calendars.now());
    }*/
}
