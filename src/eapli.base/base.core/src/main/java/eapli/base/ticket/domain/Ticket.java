package eapli.base.ticket.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.base.service.domain.Form;
import eapli.base.service.domain.Service;
import eapli.base.task.domain.Task;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Calendar;

@XmlRootElement
@Entity
public class Ticket implements AggregateRoot<Long> {

    @Version
    private Long version;

    @Id
    @XmlElement
    @JsonProperty
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

    @XmlElement
    @JsonProperty
    @OneToOne
    private Task task;

    @XmlElement
    @JsonProperty
    @OneToOne
    private CompletedForm completedForm;

    //TODO use service to smth and add/create Task

    public Ticket(UrgencyTypes urgency, Calendar deadline, Calendar creationDate,
                  Priority priority, Feedback feedback, AnnexedFile fileName, CompletedForm completedForm, Service service,
                  Task task) {
        this.ticketId = ticketId;
        this.urgency = urgency;
        this.deadline = deadline;
        this.creationDate = creationDate;
        this.priority = priority;
        this.feedback = feedback;
        this.fileName = fileName;
        this.completedForm = completedForm;
        this.service = service;
        this.task = task;
    }

    public Ticket(UrgencyTypes urgency, Calendar deadline, Calendar creationDate,
                  Priority priority, AnnexedFile fileName, CompletedForm completedForm, Service service, Task Task) {
        this.urgency = urgency;
        this.deadline = deadline;
        this.creationDate = creationDate;
        this.priority = priority;
        this.fileName = fileName;
        this.completedForm = completedForm;
        this.service = service;
        this.task = task;
    }

    public TicketState state(){return this.ticketState;}

    public boolean isSubmited(){ return state() == TicketState.SUBMETIDO; }
    public boolean isInApproval(){ return state() == TicketState.EM_APROVACAO; }
    public boolean isApproved(){ return state() == TicketState.APROVADO; }
    public boolean isRejected(){ return state() == TicketState.REJEITADO; }
    public boolean isInResolution(){ return state() == TicketState.EM_RESOLUCAO; }
    public boolean isSolved(){ return state() == TicketState.RESOLVIDO; }

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
