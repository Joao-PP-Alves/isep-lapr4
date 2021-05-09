package eapli.base.servicecatalog.repositories;

import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.framework.domain.repositories.DomainRepository;

public interface ServiceCatalogRepository extends DomainRepository<Long, ServiceCatalog> {

    Iterable<ServiceCatalog> findTopCatalogs();
}
