package eapli.base.teamtype.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlElement;

@Embeddable
public class TeamTypeId implements ValueObject, Comparable<TeamTypeId> {

    @XmlElement
    @JsonProperty
    private String id;

    public TeamTypeId(String id){
        this.id = id;
    }

    public TeamTypeId() {
        //Needed
    }

    public static TeamTypeId valueOf(String teamId) {
        return new TeamTypeId(teamId);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int compareTo(TeamTypeId o) {
        return 0;
    }

    @Override
    public String toString() {
        return id;
    }
}
