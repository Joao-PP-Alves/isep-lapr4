package eapli.base.collaboratormanagement.application;

import eapli.base.collaboratormanagement.domain.CollaboratorBuilder;
import eapli.base.team.domain.Team;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.time.util.Calendars;

import java.util.Calendar;
import java.util.Set;

/**
 * Based on AddCollbaratorController
 * Created by João Correia
 */
@UseCaseController
public class AddCollaboratorController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final UserManagementService userSvc = AuthzRegistry.userService();
    private final CollaboratorBuilder collabBuilder = new CollaboratorBuilder();

    /**
     * Get existing RoleTypes available to the user.
     *
     * @return a list of RoleTypes
     */

    public Role[] getRoleTypes() {
        return BaseRoles.nonUserValues();
    }

    public Team[] getTeams() {
        //TODO get teams from repo.
        throw new UnsupportedOperationException("Not implemented yet. Should get teams from repository!");
    }


    public SystemUser addNewCollaborator(final String username, final String password, final String email,
                                         final Set<Role> roleTypes, final String fullName, final String shortName,
                                         final String address, final int phoneNumber, final Calendar createdOn) {
        String lastName = "";
        String firstName = "";
        if (fullName.split("\\w+").length > 1) {
            lastName = fullName.substring(fullName.lastIndexOf(" ") + 1);
            firstName = fullName.substring(0, fullName.lastIndexOf(' '));
        } else {
            firstName = fullName;
        }

        return userSvc.registerNewUser(username, password, firstName, lastName, email, roleTypes,
                createdOn);

    }

    public SystemUser addNewCollaborator(final String username, final String password, final String email,
                                         final Set<Role> roleTypes, final String fullName, final String shortName,
                                         final String address, final int phoneNumber) {
        return addNewCollaborator(username, password, email, roleTypes, fullName, shortName, address,
                phoneNumber, Calendars.now());
    }
}
