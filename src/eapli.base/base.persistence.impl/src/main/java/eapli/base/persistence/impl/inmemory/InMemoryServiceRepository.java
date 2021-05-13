package eapli.base.persistence.impl.inmemory;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
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
        return match(e -> e.getServiceCatalog() == serviceCatalog);
    }
}
