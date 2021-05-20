package eapli.base.service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlElement;

@Embeddable
public class RegularExpression implements ValueObject {

    @JsonProperty
    @XmlElement
    private String regularExpression;

    protected RegularExpression(){}

    public RegularExpression(String rge){
        if (rge!=null){
            regularExpression = rge;
        } else {
            regularExpression = "[A-Za-z 0-9]+";
        }
    }

    public String getRegularExpression() {
        return regularExpression;
    }

    public void setRegularExpression(String regularExpression) {
        this.regularExpression = regularExpression;
    }
}
