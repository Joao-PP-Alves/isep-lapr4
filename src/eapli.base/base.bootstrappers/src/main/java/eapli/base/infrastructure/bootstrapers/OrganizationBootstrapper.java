package eapli.base.infrastructure.bootstrapers;

import eapli.base.collaboratormanagement.application.AddCollaboratorController;
import eapli.base.collaboratormanagement.domain.Collaborator;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.team.application.AddTeamController;
import eapli.base.team.domain.Team;
import eapli.base.teamtype.domain.TeamType;
import eapli.base.teamtype.domain.TeamTypeBuilder;
import eapli.base.teamtype.repository.TeamTypeRepository;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;

import eapli.framework.infrastructure.authz.domain.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class OrganizationBootstrapper implements Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationBootstrapper.class);

    private static final String COLLABORATOR_NAME = "Dummy";
    private static final String COLLABORATOR_PASSWORD = "PASSWORD1";
    private static final String COLLABORATOR_COMPANY_ROLE = "Team Responsible";
    private static final String COLLABORATOR_EMAIL = ".@ok.com";
    private static final String COLLABORATOR_FULLNAME = "Mega Dummy";
    private static final String COLLABORATOR_SHORTNAME = "Dum";
    private static final String COLLABORATOR_ADDRESS = "There";
    private static final int COLLABORATOR_PHONE = 939392922;
    private static final String COLLABORATOR_ROLE = "COLLABORATOR";

    private static final String TEAMTYPE_DESIGNATION = "Dummy TeamType";
    private static final String TEAMTYPE_COLOR = "Colourless";

    private static final String TEAM_DESIGNATION = "Dummy Team";
    private static final String TEAM_DESCRIPTION = "Dummy Description";

    final AddCollaboratorController addCollabController = new AddCollaboratorController();
    final AddTeamController addTeamController = new AddTeamController();
    private final TeamTypeRepository teamTypeRepository = PersistenceContext.repositories().teamTypes();

    @Override
    public boolean execute() {

        Collaborator collab = registerCollaborator(COLLABORATOR_NAME, COLLABORATOR_PASSWORD, COLLABORATOR_EMAIL, new HashSet<>(),
                COLLABORATOR_FULLNAME, COLLABORATOR_SHORTNAME, COLLABORATOR_ADDRESS, COLLABORATOR_PHONE, COLLABORATOR_COMPANY_ROLE);

        TeamType teamType = registerTeamType("Test Team Type", "Yellow", "Test Team Type Description");
        Team team = registerTeam("Test Team designation", "Test team description", teamType, collab);

        return true;
    }

    private Collaborator registerCollaborator(final String username, final String password, final String email,
                                              final Set<Role> roleTypes, final String fullName, final String shortName,
                                              final String address, final int phoneNumber, final String companyRole) {

        try {
            Collaborator collab = addCollabController.addNewCollaborator(username, password, email, roleTypes, fullName,
                    shortName, address, phoneNumber, companyRole);
            LOGGER.info(username);
            return collab;
        } catch (final IntegrityViolationException | ConcurrencyException ex) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming the team already exists (activate trace log for details)", username);
            LOGGER.trace("Assuming existing record", ex);
            return null;
        }
    }

    private TeamType registerTeamType(final String designation, final String color, final String description) {
        final TeamTypeBuilder teamTypeBuilder = TeamTypeBuilder.builder();
        teamTypeBuilder.with(designation, color, description);
        final TeamType newTeamType = teamTypeBuilder.build();

        TeamType teamType;
        try {
            teamType = teamTypeRepository.save(newTeamType);
            assert teamType != null;
            return teamType;
        } catch (ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", newTeamType.getTeamId());
            LOGGER.trace("Assuming existing record", e);
            return null;
        }
    }

    private Team registerTeam(final String designation, final String description, final TeamType teamTypes,
                              Collaborator responsibleCollab) {

        try {
            Set<TeamType> listTeamTypes = new HashSet<>();
            listTeamTypes.add(teamTypes);
            Set<Collaborator> listCollabs = new HashSet<>();
            listCollabs.add(responsibleCollab);
            Team team =  addTeamController.addTeam(designation, description, listTeamTypes, listCollabs);
            LOGGER.info(designation);
            return team;
        } catch (final IntegrityViolationException | ConcurrencyException ex) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming the team already exists (activate trace log for details)", designation);
            LOGGER.trace("Assuming existing record", ex);
            return null;
        }
    }
}
