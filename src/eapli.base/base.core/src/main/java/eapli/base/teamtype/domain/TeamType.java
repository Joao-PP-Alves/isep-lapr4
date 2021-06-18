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


    public TeamType(TeamTypeId id, Description description, Color color) {
        setId(id);
        setColor(color);
        setDescription(description);
    }

    public TeamType() {
        //Needed
    }

    private void setId(TeamTypeId id) {
        if (id != null)
            this.id = id;
    }

    private void setColor(Color color) {
        if (color != null) this.color = color;
    }

    private void setDescription(Description description) {
        if (description != null)
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
        final TeamType that = (TeamType) other;
        return that.identity().equals(this.identity());
    }

    @Override
    public TeamTypeId identity() {
        return this.id;
    }

    public String getTeamId() {
        return id.toString();
    }
}
