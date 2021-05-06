package eapli.base.teamtype.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlElement;
import java.lang.reflect.Field;

@Embeddable
public class Color implements ValueObject {

    @XmlElement
    @JsonProperty
    private String color;

    public Color(String color){
        Color colorAsObject;
        try {
            Field field = Class.forName("java.awt.Color").getField(color);
            colorAsObject = (Color)field.get(null);
            this.color = color;
        } catch (Exception e) {
            this.color = null; // Not defined
        }
    }

    public Color() {
        //Needed
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
