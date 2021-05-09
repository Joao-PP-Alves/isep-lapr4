package eapli.base.teamtype.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.base.teamtype.application.ColorUtils;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlElement;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Embeddable
public class Color implements ValueObject {

    @XmlElement
    @JsonProperty
    private String color;

    public Color(String color) {
        try {
            ColorUtils utils = new ColorUtils();
            ColorUtils.ColorName c = utils.getColorFromName(color);
            this.color = c.getName();
        } catch (Exception e) {
            this.color = null; // Not defined
        }
    }

    public Color(java.awt.Color color) {
        Color colorAsObject;
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


    @Override
    public String toString() {
        return color;
    }
}
