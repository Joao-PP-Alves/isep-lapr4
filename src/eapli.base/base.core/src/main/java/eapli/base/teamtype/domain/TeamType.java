package eapli.base.teamtype.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.lang.reflect.Field;

@Entity
public class TeamType implements AggregateRoot<TeamTypeId> {

    @Version
    private Long version;

    @JsonProperty
    @XmlElement
    @EmbeddedId
    private TeamTypeId id;

    @JsonProperty
    @XmlElement
    @AttributeOverride(name = "value", column = @Column(name = "teamTypeDescription"))
    private Description teamTypeDescription;

    @JsonProperty
    @XmlElement
    private Color color;


    public TeamType(TeamTypeId id, Description description, Color color){
        setId(id);
        setColor(color);
        setDescription(description);
    }

    public TeamType() {
        //Needed
    }

    public void setId(TeamTypeId id) {
        if (id != null)
        this.id = id;
    }

    public void setColor(Color color) {
        //Color colorAsObject;
        try {
            if (color!= null)
            this.color = color;

/*            java.awt.Color c = java.awt.Color.getColor(color);

            Field field = Class.forName("java.awt.Color").getField(color);
            colorAsObject = (Color)field.get(null);
            this.color = colorAsObject;*/
        } catch (Exception e) {
            this.color = null; // Not defined
        }
    }

    public void setDescription(Description description) {
        if (description!= null)
        this.teamTypeDescription = description;
    }

    @Override
    public boolean equals(Object other) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(TeamTypeId other) {
        return 0;
    }

    @Override
    public TeamTypeId identity() {
        return null;
    }

    @Override
    public boolean hasIdentity(TeamTypeId otherId) {
        return false;
    }

    public String getTeamId() {
        return id.toString();
    }
}
