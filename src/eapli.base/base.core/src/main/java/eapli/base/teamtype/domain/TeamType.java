package eapli.base.teamtype.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;

import javax.persistence.Embeddable;
import java.lang.reflect.Field;

@Embeddable
public class TeamType implements AggregateRoot<TeamTypeId> {


    private TeamTypeId id;

    private Description description;
    private Color color;


    public TeamType(TeamTypeId id, Description description, String color){
        setId(id);
        setColor(color);
        setDescription(description);
    }

    public TeamType() {
        //Needed
    }

    public void setId(TeamTypeId id) {
        this.id = id;
    }

    public void setColor(String color) {
        Color colorAsObject;
        try {
            Field field = Class.forName("java.awt.Color").getField(color);
            colorAsObject = (Color)field.get(null);
            this.color = colorAsObject;
        } catch (Exception e) {
            this.color = null; // Not defined
        }
    }

    public void setDescription(Description description) {
        this.description = description;
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
}
