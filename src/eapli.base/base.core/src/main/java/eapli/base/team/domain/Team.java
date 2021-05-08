package eapli.base.team.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.base.teamtype.domain.TeamType;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Team implements AggregateRoot<Designation> {

    @JsonProperty
    @XmlElement
    @EmbeddedId
    private Designation id;

    @JsonProperty
    @XmlElement
    @AttributeOverride(name = "value", column = @Column(name = "teamDescription"))
    private Description teamDescription;

    @JsonProperty
    @XmlElement
    private TeamType teamType;

    public Team(Designation teamId, Description description, TeamType teamType){
        setId(teamId);
        setDescription(description);
        setTeamType(teamType);
    }

    public Team() {
        //Needed
    }

    public void setId(Designation id) {
        this.id = id;
    }

    public void setDescription(Description description) {
        this.teamDescription = description;
    }

    public void setTeamType(TeamType teamType) {
        this.teamType = teamType;
    }

    public Designation getId() {
        return id;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Designation identity() {
        return null;
    }
}
