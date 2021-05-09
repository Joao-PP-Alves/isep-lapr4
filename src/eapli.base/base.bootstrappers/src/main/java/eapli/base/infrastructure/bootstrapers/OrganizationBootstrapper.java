package eapli.base.infrastructure.bootstrapers;

import eapli.base.collaboratormanagement.application.AddCollaboratorController;
import eapli.base.collaboratormanagement.domain.Collaborator;
import eapli.base.team.application.AddTeamController;
import eapli.base.teamtype.domain.TeamType;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;

import eapli.framework.infrastructure.authz.domain.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class OrganizationBootstrapper implements Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationBootstrapper.class);

    private static final String COLLABORATOR_NAME = "Dummy";
    private static final String COLLABORATOR_PASSWORD = "PASSWORD1";
    private static final String COLLABORATOR_EMAIL = ".@ok.com";
    private static final String COLLABORATOR_FULLNAME = "Mega Dummy";
    private static final String COLLABORATOR_SHORTNAME = "Dum";
    private static final String COLLABORATOR_ADDRESS = "There";
    private static final int COLLABORATOR_PHONE = 939392922;

    private static final String TEAMTYPE_DESIGNATION = "Dummy TeamType";
    private static final String TEAMTYPE_COLOR = "Colourless";

    private static final String TEAM_DESIGNATION = "Dummy Team";
    private static final String TEAM_DESCRIPTION = "Dummy Description";

    final AddCollaboratorController addCollabController = new AddCollaboratorController();
    final AddTeamController addTeamController = new AddTeamController();

    @Override
    public boolean execute() {

        registerCollaborator(COLLABORATOR_NAME, COLLABORATOR_PASSWORD, COLLABORATOR_EMAIL, new HashSet<>(),
                COLLABORATOR_FULLNAME, COLLABORATOR_SHORTNAME, COLLABORATOR_ADDRESS, COLLABORATOR_PHONE);

        return true;
    }

    private void registerCollaborator(final String username, final String password, final String email,
                                      final Set<Role> roleTypes, final String fullName, final String shortName,
                                      final String address, final int phoneNumber){

        try {
            addCollabController.addNewCollaborator(username, password, email, roleTypes, fullName,
                    shortName, address, phoneNumber);
            LOGGER.info(username);

        } catch (final IntegrityViolationException | ConcurrencyException ex) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming the team already exists (activate trace log for details)", username);
            LOGGER.trace("Assuming existing record", ex);
        }
    }

    private void registerTeamType(final String designation, final String color) {

        throw new UnsupportedOperationException("Method not yet implemented. Needs AddTeamtype implementation");
    }

    private void registerTeam(final String designation, final String description, final Set<TeamType> teamTypes,
                              Collaborator responsibleCollab) {

        try {
            addTeamController.addTeam(designation, description, teamTypes, responsibleCollab);
            LOGGER.info(designation);

        } catch (final IntegrityViolationException | ConcurrencyException ex) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming the team already exists (activate trace log for details)", designation);
            LOGGER.trace("Assuming existing record", ex);
        }
    }
}
