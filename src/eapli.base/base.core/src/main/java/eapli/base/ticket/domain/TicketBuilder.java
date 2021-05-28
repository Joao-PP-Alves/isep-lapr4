package eapli.base.ticket.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.base.service.domain.ApprovalTask;
import eapli.base.service.domain.Form;
import eapli.base.service.domain.KeyWord;
import eapli.base.service.domain.Service;
import eapli.base.servicecatalog.domain.Icon;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.base.taskspec.domain.TaskSpec;
import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;

import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import java.util.Calendar;
import java.util.Set;

public class TicketBuilder implements DomainFactory<Ticket> {

    private Long ticketId;
    private UrgencyTypes urgency;
    private TicketState ticketState;
    private Calendar deadline;
    private Calendar creationDate;
    private Priority priority;
    private Feedback feedback;
    private AnnexedFile fileName;

    public TicketBuilder() {
    }

    @Override
    public Ticket build() {
        return new Ticket(ticketId, urgency, ticketState, deadline, creationDate, priority, feedback, fileName);
    }


    public TicketBuilder with(Long ticketId, UrgencyTypes urgency, TicketState ticketState, Calendar deadline,
                              Calendar creationDate, Priority priority, Feedback feedback, AnnexedFile fileName) {
        this.withTicketId(ticketId);
        this.withUrgency(urgency);
        this.withState(ticketState);
        this.withDeadLine(deadline);
        this.withCreationDate(creationDate);
        this.withPriority(priority);
        this.withFeedback(feedback);
        this.withFile(fileName);
        return this;
    }

    private TicketBuilder withFile(AnnexedFile fileName) {
        if (fileName != null)
            this.fileName = fileName;
        return this;

    }

    private TicketBuilder withFeedback(Feedback feedback) {
        if (feedback != null)
            this.feedback = feedback;
        return this;
    }

    private TicketBuilder withPriority(Priority priority) {
        if (priority != null)
            this.priority = priority;
        return this;
    }

    private TicketBuilder withCreationDate(Calendar creationDate) {
        if (creationDate != null)
            this.creationDate = creationDate;
        return this;
    }

    private TicketBuilder withDeadLine(Calendar deadline) {
        if (deadline != null)
            this.deadline = deadline;
        return this;
    }

    private TicketBuilder withState(TicketState ticketState) {
        if (ticketState != null)
            this.ticketState = ticketState;
        return this;
    }


    public TicketBuilder withUrgency(UrgencyTypes urgency) {
        if (urgency != null)
            this.urgency = urgency;
        return this;
    }

    public TicketBuilder withTicketId(final Long ticketId) {
        if (ticketId != null)
            this.ticketId = ticketId;
        return this;
    }

}

