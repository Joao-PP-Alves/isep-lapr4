package eapli.base.ticket.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.xml.bind.annotation.XmlElement;

@Embeddable
public class Feedback implements ValueObject {

    @XmlElement
    @JsonProperty
    private String feedback;

    public Feedback(String feedback){
        this.feedback = feedback;
    }

    protected Feedback() {}


    public String getFeedback(){
        return this.feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
