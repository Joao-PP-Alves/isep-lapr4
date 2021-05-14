package eapli.base.collaboratormanagement.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.PasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.*;
import eapli.framework.validations.Preconditions;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A factory for Collaborator entities.
 * <p>
 * This class demonstrates the use of the factory (DDD) pattern using a fluent
 * interface. it acts as a Builder (GoF).
 *
 * @author Jorge Santos ajs@isep.ipp.pt 02/04/2016
 */
public class CollaboratorBuilder implements DomainFactory<Collaborator> {

    private Username username;
    private Password password;
    private FullName fullName;
    private ShortName shortName;
    private Address address;
    private PhoneNumber phoneNumber;
    private EmailAddress email;
    private CompanyRole companyRole;
    private List<Role> roles = new LinkedList<Role>();

    private SystemUser systemUser;
    private MecanographicNumber mecanographicNumber;
    private final PasswordPolicy policy;
    private final PasswordEncoder encoder;
    private Calendar createdOn;

    public CollaboratorBuilder(final PasswordPolicy policy, final PasswordEncoder encoder) {
        this.policy = policy;
        this.encoder = encoder;

    }

    public CollaboratorBuilder withSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
        return this;
    }

    public CollaboratorBuilder withMecanographicNumber(MecanographicNumber mecanographicNumber) {
        this.mecanographicNumber = mecanographicNumber;
        return this;
    }

    public CollaboratorBuilder withMecanographicNumber(String mecanographicNumber) {
        this.mecanographicNumber = new MecanographicNumber(mecanographicNumber);
        return this;
    }

    @Override
    public Collaborator build() {
        // since the factory knows that all the parts are needed it could throw
        // an exception. however, we will leave that to the constructor

        Collaborator collab;
        if (this.createdOn != null) {
            collab = new Collaborator(this.fullName, this.shortName, this.address, this.phoneNumber, this.roles, this.createdOn, this.companyRole);
        } else {
            collab = new Collaborator(this.fullName, this.shortName, this.address, this.phoneNumber, this.roles, this.companyRole);
        }

        return collab;
    }

    public CollaboratorBuilder with(String username, String rawPassword, String firstName,
                                    String lastName, String email, String shortName, String address,
                                    int phoneNumber, String companyRole) {
        this.withUsername(username);
        this.withPassword(rawPassword);
        this.withName(firstName, lastName);
        this.withEmail(email);
        this.withShortName(shortName);
        this.withAddress(address);
        this.withPhoneNumber(phoneNumber);
        this.withCompanyRole(companyRole);
        return this;
    }

    private void withCompanyRole(String companyRole) {
        this.companyRole = CompanyRole.valueOf(companyRole);
    }


    public CollaboratorBuilder withUsername(final String username) {
        this.username = Username.valueOf(username);
        return this;
    }

    public CollaboratorBuilder withUsername(final Username username) {
        this.username = username;
        return this;
    }

    public CollaboratorBuilder withPassword(final String rawPassword) {
        this.password = (Password) Password.encodedAndValid(rawPassword, this.policy, this.encoder).orElseThrow(IllegalArgumentException::new);
        return this;
    }

    public CollaboratorBuilder withPassword(final Password password) {
        Preconditions.nonNull(password);
        this.password = password;
        return this;
    }

    public CollaboratorBuilder withName(final String firstName, final String lastName) {
        this.fullName = new FullName(firstName, lastName);
        return this;
    }

    public CollaboratorBuilder withName(final FullName name) {
        this.fullName = name;
        return this;
    }

    public CollaboratorBuilder withShortName(final String shortName) {
        this.shortName = new ShortName(shortName);
        return this;
    }

    public CollaboratorBuilder withAddress(final String address) {
        this.address = new Address(address);
        return this;
    }

    public CollaboratorBuilder withPhoneNumber(final int phoneNumber) {
        this.phoneNumber = new PhoneNumber(phoneNumber);
        return this;
    }

    public CollaboratorBuilder withEmail(final String email) {
        this.email = EmailAddress.valueOf(email);
        return this;
    }

    public CollaboratorBuilder withEmail(final EmailAddress email) {
        this.email = email;
        return this;
    }

    public CollaboratorBuilder withRoles(final Role... onlyWithThis) {
        Role[] var2 = onlyWithThis;
        int var3 = onlyWithThis.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            Role each = var2[var4];
            // TODO Changes made here, don't know if it will affect the outcome.
            this.roles.add(each);
        }

        return this;
    }

    public CollaboratorBuilder withRole(final Role role) {
        this.roles.add(role);
        return this;
    }

    public CollaboratorBuilder createdOn(final Calendar createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public CollaboratorBuilder withRoles(final Set<Role> someRoles) {
        List theRoles;
        if (this.createdOn == null) {
            theRoles = (List) someRoles.stream().map(RoleAssignment::new).collect(Collectors.toList());
        } else {
            theRoles = (List) someRoles.stream().map((rt) -> {
                return new RoleAssignment(rt, this.createdOn);
            }).collect(Collectors.toList());
        }

        this.roles.addAll(theRoles);
        return this;
    }


}
