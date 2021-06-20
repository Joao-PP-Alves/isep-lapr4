package eapli.base.service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.base.ticket.domain.FieldAnswer;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.general.domain.model.Description;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;
import java.util.Set;

@Entity
public class Field implements ValueObject, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long FieldId;

    @JsonProperty
    @XmlElement
    private RegularExpression regularExpression;

    @JsonProperty
    @XmlElement
    private String variableName;

    @JsonProperty
    @XmlElement
    private Description helpDescription;

    @JsonProperty
    @XmlElement
    @Nullable
    private FieldAnswer answer; //used only on CompletedForm

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<Field> fields;

    @JsonProperty
    @XmlElement
    private PresentationTicket presentationTicket;

    @JsonProperty
    @XmlElement
    private DataTypesAllowed dataType;

    protected Field() {
    }

    public Field(RegularExpression regularExpression, String variableName, Description helpDescription, Set<Field> fields, PresentationTicket presentationTicket, DataTypesAllowed dataTypesAllowed) {
        this.regularExpression = Objects.requireNonNull(regularExpression);
        this.variableName = Objects.requireNonNull(variableName);
        this.helpDescription = helpDescription;
        this.fields = fields;
        this.dataType = Objects.requireNonNull(dataTypesAllowed);
        this.presentationTicket = Objects.requireNonNull(presentationTicket);
    }

    public Set<Field> fields() {
        return fields;
    }

    public PresentationTicket presentationTicket() {
        return presentationTicket;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void putAnswer(String answer) {
        this.answer = FieldAnswer.valueOf(answer);
    }

}
