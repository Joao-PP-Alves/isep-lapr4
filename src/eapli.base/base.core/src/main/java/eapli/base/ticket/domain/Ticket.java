package eapli.base.ticket.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.base.service.domain.Service;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Calendar;

@XmlRootElement
@Entity
public class Ticket implements AggregateRoot<Long> {

    @XmlElement
    @JsonProperty
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ticketId;

    @XmlElement
    @JsonProperty
    private UrgencyTypes urgency;

    @XmlElement
    @JsonProperty
    private TicketState ticketState;

    @XmlElement
    @JsonProperty
    private Calendar deadline;

    @XmlElement
    @JsonProperty
    private Calendar creationDate;

    @XmlElement
    @JsonProperty
    private Priority priority;

    @XmlElement
    @JsonProperty
    private Feedback feedback;

    @XmlElement
    @JsonProperty
    private AnnexedFile fileName;

    @XmlElement
    @JsonProperty
    @OneToOne
    private Service service;

    //TODO use service to smth and add/create Task

    public Ticket(Long ticketId, UrgencyTypes urgency, TicketState ticketState, Calendar deadline,
                  Calendar creationDate, Priority priority, Feedback feedback, AnnexedFile fileName) {
        this.ticketId = ticketId;
        this.urgency = urgency;
        this.ticketState = ticketState;
        this.deadline = deadline;
        this.creationDate = creationDate;
        this.priority = priority;
        this.feedback = feedback;
        this.fileName = fileName;
    }

    public Ticket(Long ticketId, UrgencyTypes urgency, TicketState ticketState, Calendar deadline,
                  Calendar creationDate, Priority priority, AnnexedFile fileName) {
        this.ticketId = ticketId;
        this.urgency = urgency;
        this.ticketState = ticketState;
        this.deadline = deadline;
        this.creationDate = creationDate;
        this.priority = priority;
        this.fileName = fileName;
    }


    public Ticket() {
        //
    }

    @Override
    public boolean sameAs(Object other) {
        Ticket se = (Ticket) other;
        return se.identity().equals(this.identity());
    }


    @Override
    public int compareTo(Long other) {
        if (other.equals(this.identity())) {
            return 1;
        }
        return -1;
    }


    @Override
    public Long identity() {
        return ticketId;
    }

    @Override
    public boolean hasIdentity(Long otherId) {
        return otherId.equals(this.identity());
    }
}
