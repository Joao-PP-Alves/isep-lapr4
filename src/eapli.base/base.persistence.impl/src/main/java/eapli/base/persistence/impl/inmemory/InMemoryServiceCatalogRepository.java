package eapli.base.persistence.impl.inmemory;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.base.servicecatalog.repositories.ServiceCatalogRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryServiceCatalogRepository extends InMemoryDomainRepository<ServiceCatalog, MecanographicNumber>
        implements ServiceCatalogRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<ServiceCatalog> findTopCatalogs() {
        return match(ServiceCatalog::isTopCatalog);
    }
}
