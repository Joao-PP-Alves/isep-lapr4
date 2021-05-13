package eapli.base.service.repositories;

import eapli.base.service.domain.Service;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.framework.domain.repositories.DomainRepository;

public interface ServiceRepository extends DomainRepository<Long, Service> {

    Iterable<Service> findBelongingToCatalog(ServiceCatalog serviceCatalog);
}
