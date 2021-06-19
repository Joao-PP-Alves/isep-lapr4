package eapli.base.task.repositories;

import eapli.base.collaboratormanagement.domain.Collaborator;
import eapli.base.task.domain.Task;
import eapli.framework.domain.repositories.DomainRepository;

public interface TaskRepository extends DomainRepository<Long, Task> {

    Iterable<Task> checkPendingTasks(Collaborator collaborator);

}
