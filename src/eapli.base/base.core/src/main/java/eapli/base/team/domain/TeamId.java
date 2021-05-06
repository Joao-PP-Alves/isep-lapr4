package eapli.base.team.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlElement;

@Embeddable
public class TeamId implements ValueObject, Comparable<TeamId> {

    @JsonProperty
    @XmlElement
    private String id;

    public TeamId(String id){
        this.id = id;
    }

    public TeamId() {
        //needed
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public int compareTo(TeamId o) {
        if (o.getId().equalsIgnoreCase(this.getId())){
            return -1;
        } else {
            return 1;
        }
    }
}
