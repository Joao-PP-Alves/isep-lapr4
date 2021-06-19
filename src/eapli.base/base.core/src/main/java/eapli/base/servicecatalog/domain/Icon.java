package eapli.base.servicecatalog.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlElement;

@Embeddable
public class Icon implements ValueObject {

    @JsonProperty
    @XmlElement
    private String icon;

    public Icon(String icon) {
        this.icon = icon;
    }

    public Icon() {
        this.icon = "Default-Icon";
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }
}
