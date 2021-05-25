package eapli.base.team.domain;

import eapli.base.collaboratormanagement.domain.*;
import eapli.base.teamtype.domain.TeamType;
import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;


/**
 * A factory for Collaborator entities.
 * <p>
 * This class demonstrates the use of the factory (DDD) pattern using a fluent
 * interface. it acts as a Builder (GoF).
 *
 * @author Jorge Santos ajs@isep.ipp.pt 02/04/2016
 */
public class TeamBuilder implements DomainFactory<Team> {

    private Designation designation;
    private Description description;
    private TeamType teamType;
    private Collaborator responsibleCollab;


    public TeamBuilder() {
    }

    public static TeamBuilder builder() {
        return new TeamBuilder();
    }

    public TeamBuilder withDesignation(Designation designation) {
        this.designation = designation;
        return this;
    }

    public TeamBuilder withDesignation(String designation) {
        this.designation = Designation.valueOf(designation);
        return this;
    }

    public TeamBuilder withDescription(Description description) {
        this.description = description;
        return this;
    }

    public TeamBuilder withTeamDescription(String description) {
        this.description = new TeamDescription(description);
        return this;
    }

    public TeamBuilder withTeamType(TeamType teamType) {
        this.teamType = teamType;
        return this;
    }

    public TeamBuilder withRespCollaborator(Collaborator responsibleCollab) {
        this.responsibleCollab = responsibleCollab;
        return this;
    }

    public TeamBuilder with(String designation, String description, TeamType teamType,
                            Collaborator responsibleCollab) {
        this.withDesignation(designation);
        this.withTeamDescription(description);
        this.withTeamType(teamType);
        this.withRespCollaborator(responsibleCollab);
        return this;
    }

    @Override
    public Team build() {
        // since the factory knows that all the parts are needed it could throw
        // an exception. however, we will leave that to the constructor

        return new Team(this.designation, this.description, this.teamType, this.responsibleCollab);
    }


}
