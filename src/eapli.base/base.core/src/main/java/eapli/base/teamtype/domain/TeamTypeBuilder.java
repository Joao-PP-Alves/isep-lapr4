package eapli.base.teamtype.domain;

import eapli.base.collaboratormanagement.domain.Collaborator;
import eapli.base.team.domain.Team;
import eapli.base.team.domain.TeamDescription;
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
public class TeamTypeBuilder implements DomainFactory<TeamType> {

    private TeamTypeId teamTypeId;
    private Color color;
    private Description description;


    public TeamTypeBuilder() {
    }

    public static TeamTypeBuilder builder() {
        return new TeamTypeBuilder();
    }

    public TeamTypeBuilder withTeamTypeId(TeamTypeId teamTypeId) {
        this.teamTypeId = teamTypeId;
        return this;
    }

    public TeamTypeBuilder withTeamTypeId(String teamTypeId) {
        this.teamTypeId = TeamTypeId.valueOf(teamTypeId);
        return this;
    }

    public TeamTypeBuilder withDescription(Description description) {
        this.description = description;
        return this;
    }

    public TeamTypeBuilder withTeamDescription(String description) {
        this.description = new TeamDescription(description);
        return this;
    }

    public TeamTypeBuilder withColor(Color color) {
        this.color = color;
        return this;
    }

    public TeamTypeBuilder withColor(String color) {
        this.color = new Color(color);
        return this;
    }

    public TeamTypeBuilder with(String teamTypeId, String color, String description) {
        this.withTeamTypeId(teamTypeId);
        this.withColor(color);
        this.withTeamDescription(description);
        return this;
    }

    @Override
    public TeamType build() {
        // since the factory knows that all the parts are needed it could throw
        // an exception. however, we will leave that to the constructor

        return new TeamType(this.teamTypeId, this.description, this.color);
    }


}
