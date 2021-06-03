package eapli.base.ticket.domain;

import eapli.framework.domain.model.DomainFactory;

import java.util.Calendar;

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


    public TicketBuilder with(UrgencyTypes urgency, TicketState ticketState, Calendar deadline,
                              Calendar creationDate, int priority, Feedback feedback, String fileName) {
        this.withUrgency(urgency);
        this.withState(ticketState);
        this.withDeadLine(deadline);
        this.withCreationDate(creationDate);
        this.withPriority(priority);
        this.withFeedback(feedback);
        this.withFile(fileName);
        return this;
    }

    public TicketBuilder with(UrgencyTypes urgency, Calendar deadline, Calendar creationDate, int priority, String fileName) {
        this.withUrgency(urgency);
        this.withState(TicketState.SUBMETIDO);
        this.withDeadLine(deadline);
        this.withCreationDate(creationDate);
        this.withPriority(priority);
        this.withFile(fileName);
        return this;
    }

    private TicketBuilder withFile(String fileName) {
        if (fileName != null)
            this.fileName = AnnexedFile.valueOf(fileName);
        return this;

    }

    private TicketBuilder withFeedback(Feedback feedback) {
        if (feedback != null)
            this.feedback = feedback;
        return this;
    }

    private TicketBuilder withPriority(int priority) {
        if (priority != 0)
            this.priority = Priority.valueOf(priority);
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

