package eapli.base.ticket.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;

@Embeddable
public class Priority implements ValueObject {

    @XmlElement
    @JsonProperty
    @Column(nullable = true)
    private int priority;

    public Priority(int ticketId){
        this.priority = ticketId;
    }

    protected Priority() {}

    public static Priority valueOf(final int name) {
        return new Priority(name);
    }
}
