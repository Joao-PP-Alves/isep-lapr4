package eapli.base.team.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.base.teamtype.domain.TeamType;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Team implements AggregateRoot<TeamId> {

    @JsonProperty
    @XmlElement
    @EmbeddedId
    private TeamId id;

    @JsonProperty
    @XmlElement
    private Description description;

    @JsonProperty
    @XmlElement
    private TeamType teamType;

    public Team(TeamId teamId, Description description, TeamType teamType){
        setId(teamId);
        setDescription(description);
        setTeamType(teamType);
    }

    public Team() {
        //Needed
    }

    public void setId(TeamId id) {
        this.id = id;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public void setTeamType(TeamType teamType) {
        this.teamType = teamType;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(TeamId other) {
        return 0;
    }

    @Override
    public TeamId identity() {
        return null;
    }

    @Override
    public boolean hasIdentity(TeamId otherId) {
        return false;
    }
}
