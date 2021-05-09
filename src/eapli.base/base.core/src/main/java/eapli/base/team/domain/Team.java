package eapli.base.team.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.base.collaboratormanagement.domain.Collaborator;
import eapli.base.teamtype.domain.TeamType;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

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
    @ManyToOne
    private TeamType teamType;

    @JsonProperty
    @XmlElement
    @OneToMany
    @Nullable
    private Set<Collaborator> members;

    @JsonProperty
    @XmlElement
    @OneToOne
    @Nullable
    private Collaborator responsibleCollab;

    public Team(Designation teamId, Description description, TeamType teamType, Set<Collaborator> collaboratorSet, Collaborator responsibleCollab){
        setId(teamId);
        setDescription(description);
        setTeamType(teamType);
        setMembers(collaboratorSet);
        setResponsibleCollaborator(responsibleCollab);
    }

    public Team(Designation designation, Description description, TeamType teamType, Collaborator responsibleCollab) {
        setId(designation);
        setDescription(description);
        setTeamType(teamType);
        setResponsibleCollaborator(responsibleCollab);
    }

    public Set<Collaborator> getMembers() {
        return members;
    }

    public Team() {
        //Needed
    }

    public void setMembers(Set<Collaborator> members) {
        this.members = members;
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

    private void setResponsibleCollaborator(Collaborator responsibleCollab) {
        this.responsibleCollab=responsibleCollab;
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
