package eapli.base.servicecatalog.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.base.team.domain.Team;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;

@Embeddable
public class AccessCriteria implements ValueObject {

    @JsonProperty
    @XmlElement
    @OneToOne
    private Team teamWithAccess;

    protected AccessCriteria() {
        //
    }

    public AccessCriteria(Team teamWithAccess) {
        this.teamWithAccess = teamWithAccess;
    }

    public Team getTeamWithAccess() {
        return this.teamWithAccess;
    }

    public void giveAccess(Team teamsWithAccess) {
        this.teamWithAccess = teamsWithAccess;
    }
}
