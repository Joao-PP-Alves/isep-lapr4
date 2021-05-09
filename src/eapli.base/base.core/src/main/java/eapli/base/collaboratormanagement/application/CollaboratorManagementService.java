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
package eapli.base.collaboratormanagement.application;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.collaboratormanagement.domain.Collaborator;
import eapli.base.collaboratormanagement.domain.CollaboratorBuilder;
import eapli.base.collaboratormanagement.repositories.CollaboratorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.PasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.*;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Calendar;
import java.util.Optional;
import java.util.Set;

/**
 * @author mcn
 */
public class CollaboratorManagementService {


    private final PasswordEncoder encoder;
    private final PasswordPolicy policy;

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CollaboratorRepository repo = PersistenceContext.repositories().collaborators();

    @Autowired
    public CollaboratorManagementService() {
        this.policy = new BasePasswordPolicy();
        this.encoder = new PlainTextEncoder();
    }

    @Autowired
    public CollaboratorManagementService( final PasswordPolicy policy, final PasswordEncoder encoder) {
        this.policy = policy;
        this.encoder = encoder;
    }

    public Optional<Collaborator> findCollaboratorByMecNumber(final String mecNumber) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.ADMIN, BaseRoles.CASHIER);
        return repo.ofIdentity(MecanographicNumber.valueOf(mecNumber));
    }

    public Optional<Collaborator> findCollaboratorByUsername(final Username user) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.ADMIN);
        return repo.findByUsername(user);
    }


    public Collaborator registerNewCollaborator(String username, String rawPassword, String firstName, String lastName,
            String email, Set<Role> roleTypes, Calendar createdOn, String shortName, String address, int phoneNumber) {
        CollaboratorBuilder colabBuilder = new CollaboratorBuilder(this.policy, this.encoder);
        colabBuilder.with(username, rawPassword, firstName, lastName, email, shortName, address, phoneNumber).createdOn(createdOn).withRoles(roleTypes);
        Collaborator newCollab = colabBuilder.build();
        return (Collaborator)this.repo.save(newCollab);

    }
}
