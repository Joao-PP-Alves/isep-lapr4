/*
 * Copyright (c) 2013-2020 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.teamtype.application;

import eapli.base.collaboratormanagement.repositories.CollaboratorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.team.application.TeamTypeManagementService;
import eapli.base.teamtype.domain.Color;
import eapli.base.teamtype.domain.TeamType;
import eapli.base.teamtype.repository.TeamTypeRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;

import java.util.List;

/**
 * Base on AddUserController
 * Created by João Correia
 */
@UseCaseController
public class AddTeamTypeController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final UserManagementService userSvc = AuthzRegistry.userService();
    //private final TeamManagementService teamManSvc = new TeamManagementService();
    private final CollaboratorRepository collabsRepo = PersistenceContext.repositories().collaborators();
    private final TeamTypeRepository repo = PersistenceContext.repositories().teamTypes();
    private final TeamTypeManagementService teamTypeManSvc = new TeamTypeManagementService();

    /**
     * Get existing TeamTypes available.
     *
     * @return a list of TeamTypes
     */
    public List<String>getTeamColors() {
        return ColorUtils.getPalete();
    }


    public TeamType addTeamType(final String teamTypeId, List<String> color, String description) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.HRR, BaseRoles.ADMIN);

        String choosenColor = null;
        int counter = 0;
        for (String i : color) {
            if (counter == 0) {
                choosenColor = i;
            }
            counter++;
        }
        return teamTypeManSvc.registerNewTeamType(teamTypeId, choosenColor, description);
    }

}
