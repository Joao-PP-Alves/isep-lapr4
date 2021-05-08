package eapli.base.servicecatalog.repositories;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.framework.domain.repositories.DomainRepository;

public interface ServiceCatalogRepository extends DomainRepository<MecanographicNumber, ServiceCatalog> {

    Iterable<ServiceCatalog> findTopCatalogs();
}
