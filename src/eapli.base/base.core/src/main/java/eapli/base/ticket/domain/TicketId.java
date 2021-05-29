package eapli.base.ticket.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.xml.bind.annotation.XmlElement;

@Embeddable
public class TicketId implements ValueObject {

    @XmlElement
    @JsonProperty
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String ticketId;

    public TicketId(String ticketId){
        this.ticketId = ticketId;
    }

    protected TicketId() {}


    public String getTicketId(){
        return this.ticketId;
    }
}
