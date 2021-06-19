package eapli.base.service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Embeddable
public class KeyWord implements ValueObject {

    @JsonProperty
    @XmlElement
    private String keyWord;

    protected KeyWord() {
    }

    public KeyWord(String keyWord) {
        if (keyWord != null) {
            this.keyWord = keyWord;
        }
    }

}
