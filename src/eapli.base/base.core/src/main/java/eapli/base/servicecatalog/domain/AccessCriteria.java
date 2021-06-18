package eapli.base.servicecatalog.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.base.team.domain.Team;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import java.util.Set;

@Embeddable
public class AccessCriteria implements ValueObject {

    @JsonProperty
    @XmlElement
    @OneToMany
    private Set<Team> teamsWithAccess;

    protected AccessCriteria() {
        //
    }

    public AccessCriteria(Set<Team> teamsWithAccess) {
        this.teamsWithAccess = teamsWithAccess;
    }

    public Set<Team> getTeamsWithAccess() {
        return this.teamsWithAccess;
    }

    public void setAccess(Set<Team> teamsWithAccess) {
        this.teamsWithAccess = teamsWithAccess;
    }
}
