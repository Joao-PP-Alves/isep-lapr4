package eapli.base.persistence.impl.inmemory;

import eapli.base.service.domain.TaskSpec;
import eapli.base.service.repositories.TaskSpecRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryTaskSpecRepository extends InMemoryDomainRepository<TaskSpec, Long>
implements TaskSpecRepository {

    static {
        InMemoryInitializer.init();
    }

}
