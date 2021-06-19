package eapli.base.persistence.impl.inmemory;


import eapli.base.collaboratormanagement.domain.Collaborator;
import eapli.base.task.domain.Task;
import eapli.base.task.repositories.TaskRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryTaskRepository extends InMemoryDomainRepository<Task, Long>
        implements TaskRepository {

    static {
        InMemoryInitializer.init();
    }


    @Override
    public Iterable<Task> checkPendingTasks(Collaborator collaborator) {
        return  match(e -> e.responsableCollab() == collaborator);
    }
}
