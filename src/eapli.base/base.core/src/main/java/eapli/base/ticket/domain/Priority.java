package eapli.base.ticket.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.xml.bind.annotation.XmlElement;

@Embeddable
public class Priority implements ValueObject {

    @XmlElement
    @JsonProperty
    private int priority;

    public Priority(int ticketId){
        this.priority = ticketId;
    }

    protected Priority() {}


    public int getPriority(){
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
