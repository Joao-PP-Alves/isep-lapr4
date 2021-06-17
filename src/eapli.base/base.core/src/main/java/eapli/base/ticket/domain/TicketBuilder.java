package eapli.base.ticket.domain;

import eapli.base.service.domain.Service;
import eapli.base.task.domain.Task;
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
    private CompletedForm form;
    private Service service;
    private Task task;

    public TicketBuilder() {
    }

    @Override
    public Ticket build() {
        return new Ticket(urgency, deadline, creationDate, priority, feedback, fileName, form, service, task);
    }


    public TicketBuilder with(UrgencyTypes urgency, Calendar deadline, Calendar creationDate, int priority,
                              Feedback feedback, String fileName, CompletedForm form, Service service, Task task) {
        this.withUrgency(urgency);
        this.withDeadLine(deadline);
        this.withCreationDate(creationDate);
        this.withPriority(priority);
        this.withFeedback(feedback);
        this.withFile(fileName);
        this.withCompletedForm(form);
        this.withService(service);
        this.withTask(task);
        return this;
    }



    public TicketBuilder with(UrgencyTypes urgency, Calendar deadline, Calendar creationDate, int priority,
                              String fileName, CompletedForm form, Service service, Task task) {
        this.withUrgency(urgency);
        this.withDeadLine(deadline);
        this.withCreationDate(creationDate);
        this.withPriority(priority);
        this.withFile(fileName);
        this.withCompletedForm(form);
        this.withService(service);
        this.withTask(task);
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


    private TicketBuilder withUrgency(UrgencyTypes urgency) {
        if (urgency != null)
            this.urgency = urgency;
        return this;
    }

    private TicketBuilder withTicketId(final Long ticketId) {
        if (ticketId != null)
            this.ticketId = ticketId;
        return this;
    }

    private TicketBuilder withCompletedForm(CompletedForm form) {
        if (form != null)
            this.form = form;
        return this;
    }

    private TicketBuilder withService(Service service) {
        if (service != null)
            this.service = service;
        return this;
    }

    private TicketBuilder withTask(Task task) {
        if (task != null)
            this.task = task;
        return this;
    }
}

