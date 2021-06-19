package eapli.base.ticket.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.general.domain.model.Designation;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlElement;

@Embeddable
public class AnnexedFile implements ValueObject {

    @XmlElement
    @JsonProperty
    private String fileName;

    public AnnexedFile(String fileName) {
        this.fileName = fileName;
    }

    protected AnnexedFile() {
    }

    public static AnnexedFile valueOf(final String name) {
        return new AnnexedFile(name);
    }

}

