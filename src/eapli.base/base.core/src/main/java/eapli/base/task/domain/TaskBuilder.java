package eapli.base.task.domain;

import eapli.base.clientusermanagement.domain.ApprovalStatus;
import eapli.base.collaboratormanagement.domain.Collaborator;
import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Description;

import java.util.Calendar;


public class TaskBuilder implements DomainFactory<Task> {

    private Calendar date;
    private Description helpDescription;
    private Collaborator solverCollab;
    private ApprovalStatus approvalStatus;


    public TaskBuilder() {
    }

    @Override
    public Task build() {
        return new Task(this.date, this.helpDescription, this.solverCollab, this.approvalStatus);
    }

    public TaskBuilder with(Calendar date, String helpDescription, Collaborator solverCollab,
                            ApprovalStatus approval) {
        this.withCreationDate(date);
        this.withDescription(helpDescription);
        this.withCollaborator(solverCollab);
        this.withApprovalStatus(approval);

        return this;
    }


    private TaskBuilder withCreationDate(Calendar creationDate) {
        if (creationDate != null)
            this.date = creationDate;
        return this;
    }

    private TaskBuilder withDescription(final String helpDescription) {
        this.helpDescription = Description.valueOf(helpDescription);
        return this;
    }

    private TaskBuilder withCollaborator(final Collaborator collab) {
        this.solverCollab = collab;
        return this;
    }

    private TaskBuilder withApprovalStatus(final ApprovalStatus approvalStatus) {
        this.approvalStatus = approvalStatus;
        return this;
    }


}

