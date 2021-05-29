package eapli.base.ticket.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.base.service.domain.ApprovalTask;
import eapli.base.service.domain.Form;
import eapli.base.service.domain.KeyWord;
import eapli.base.servicecatalog.domain.Icon;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.base.taskspec.domain.TaskSpec;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Calendar;
import java.util.Objects;
import java.util.Set;

@XmlRootElement
@Entity
public class Ticket implements AggregateRoot<Long> {

    @XmlElement
    @JsonProperty
    @Id
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
        return null;
    }

    @Override
    public boolean hasIdentity(Long otherId) {
        return otherId.equals(this.identity());
    }
}
