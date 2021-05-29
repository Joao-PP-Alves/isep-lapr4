package eapli.base.persistence.impl.inmemory;

import eapli.base.service.domain.ServiceDraft;
import eapli.base.service.repositories.ServiceDraftRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryServiceDraftRepository extends InMemoryDomainRepository<ServiceDraft,Long> implements ServiceDraftRepository {

    static {
        InMemoryInitializer.init();
    }

}
