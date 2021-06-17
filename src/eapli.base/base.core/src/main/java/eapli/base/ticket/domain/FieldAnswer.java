package eapli.base.ticket.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;

@Embeddable
public class FieldAnswer implements ValueObject {

/*    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fieldAnswerId;*/

    @JsonProperty
    @XmlElement
    private String answer;


    protected FieldAnswer(){}

    public FieldAnswer(String answer){
        Preconditions.nonNull(answer);
        this.answer = answer;
    }

    public static FieldAnswer valueOf(final String answer) {
        return new FieldAnswer(answer);
    }


}
