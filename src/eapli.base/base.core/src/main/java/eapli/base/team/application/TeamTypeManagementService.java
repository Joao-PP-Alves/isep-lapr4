/*
 * Copyright (c) 2013-2019 the original author or authors.
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

import eapli.base.collaboratormanagement.domain.Collaborator;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.team.domain.Team;
import eapli.base.team.domain.TeamBuilder;
import eapli.base.teamtype.domain.Color;
import eapli.base.teamtype.domain.TeamType;
import eapli.base.teamtype.domain.TeamTypeBuilder;
import eapli.base.teamtype.domain.TeamTypeId;
import eapli.base.teamtype.repository.TeamTypeRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.PasswordPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

/**
 * @author mcn
 */
public class TeamTypeManagementService {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final TeamTypeRepository repo = PersistenceContext.repositories().teamTypes();

    @Autowired
    public TeamTypeManagementService() {

    }

    @Autowired
    public TeamTypeManagementService(final PasswordPolicy policy, final PasswordEncoder encoder) {

    }

    public Optional<TeamType> findTeamTypeById(final String teamId) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.ADMIN);
        return repo.ofIdentity(TeamTypeId.valueOf(teamId));
    }


    public TeamType registerNewTeamType(final String teamTypeId, String color, final String description) {
        TeamTypeBuilder teamTypeBuilder = new TeamTypeBuilder();
        teamTypeBuilder.with(teamTypeId, color, description);
        TeamType newTeamType = teamTypeBuilder.build();
        return this.repo.save(newTeamType);

    }
}
