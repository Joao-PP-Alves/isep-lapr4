package eapli.base.persistence.impl.inmemory;

import eapli.base.service.domain.Service;
import eapli.base.service.repositories.ServiceRepository;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryServiceRepository extends InMemoryDomainRepository<Service, Long>
        implements ServiceRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<Service> findBelongingToCatalog(ServiceCatalog serviceCatalog){
        return match(e -> e.catalog() == serviceCatalog);
    }

    @Override
    public Iterable<Service> findUncomplete() {
        return match(Service::isComplete);
    }
}
