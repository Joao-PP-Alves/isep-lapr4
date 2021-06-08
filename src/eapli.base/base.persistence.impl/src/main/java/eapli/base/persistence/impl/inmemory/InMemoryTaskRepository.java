package eapli.base.persistence.impl.inmemory;


import eapli.base.task.domain.Task;
import eapli.base.task.repositories.TaskRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryTaskRepository extends InMemoryDomainRepository<Task, Long>
        implements TaskRepository {

    static {
        InMemoryInitializer.init();
    }


}
