package eapli.base.service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.general.domain.model.Description;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;
import java.util.Set;

@Entity
public class Field implements ValueObject {

    @Id
    private Long id;

    @JsonProperty
    @XmlElement
    private RegularExpression regularExpression;

    private String variableName;

    private Description helpDescription;

    @OneToMany
    private Set<Field> fields;

    private PresentationTicket presentationTicket;

    @JsonProperty
    @XmlElement
    private DataTypesAllowed dataType;

    protected Field(){}

    public Field(RegularExpression regularExpression, String variableName, Description helpDescription, /*Set<Field> fields, */PresentationTicket presentationTicket, DataTypesAllowed dataTypesAllowed){
        this.regularExpression = Objects.requireNonNull(regularExpression);
        this.variableName = Objects.requireNonNull(variableName);
        this.helpDescription = helpDescription;
        /*this.fields = fields;*/
        this.dataType = Objects.requireNonNull(dataTypesAllowed);
        this.presentationTicket = Objects.requireNonNull(presentationTicket);
    }
}
