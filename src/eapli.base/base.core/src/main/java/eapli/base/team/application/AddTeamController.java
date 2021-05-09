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
package eapli.base.team.application;

import eapli.base.collaboratormanagement.application.CollaboratorManagementService;
import eapli.base.collaboratormanagement.domain.Collaborator;
import eapli.base.collaboratormanagement.repositories.CollaboratorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.team.domain.Team;
import eapli.base.team.repository.TeamRepository;
import eapli.base.teamtype.domain.TeamType;
import eapli.base.teamtype.repository.TeamTypeRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.List;
import java.util.Set;

/**
 * Base on AddUserController
 * Created by João Correia
 */
@UseCaseController
public class AddTeamController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final UserManagementService userSvc = AuthzRegistry.userService();
    //private final TeamManagementService teamManSvc = new TeamManagementService();
    private final CollaboratorRepository collabsRepo = PersistenceContext.repositories().collaborators();
    private final TeamTypeRepository repo = PersistenceContext.repositories().teamTypes();
    private final TeamManagementService teamManSvc = new TeamManagementService();

    /**
     * Get existing TeamTypes available.
     *
     * @return a list of TeamTypes
     */
    public Iterable<TeamType>getTeamTypes() {
        return repo.findAll();
    }


    public Team addTeam(final String designation, final String description, final Set<TeamType> teamTypes, Collaborator responsibleCollab) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.HRR, BaseRoles.ADMIN);

        TeamType teamType = null;
        int counter = 0;

        for (TeamType i : teamTypes) {
            if (counter == 0) {
                teamType = i;
            }
            counter++;
        }
        return teamManSvc.registerNewTeam(designation, description, teamType, responsibleCollab);
    }

    public List<Collaborator> getCollaboratorsList() {
        return (List<Collaborator>) collabsRepo.findAll();
    }
}
