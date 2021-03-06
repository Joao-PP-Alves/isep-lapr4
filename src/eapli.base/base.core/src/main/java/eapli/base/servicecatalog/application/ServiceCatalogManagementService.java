package eapli.base.servicecatalog.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.base.servicecatalog.domain.ServiceCatalogBuilder;
import eapli.base.servicecatalog.repositories.ServiceCatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceCatalogManagementService {

    private final ServiceCatalogRepository servCatRepo = PersistenceContext.repositories().serviceCatalogs();

    @Autowired
    public ServiceCatalogManagementService() {
    }

    public ServiceCatalog registerNewServiceCatalog(String title, String shortDescription, String longDescription, String icon,
                                                    ServiceCatalog topCatalog) {

        ServiceCatalogBuilder servCatBuilder = new ServiceCatalogBuilder();
        servCatBuilder.with(title, shortDescription, longDescription, icon, topCatalog);
        ServiceCatalog servCat = servCatBuilder.build();

        return this.servCatRepo.save(servCat);
    }

    public ServiceCatalog updateServiceCatalog(ServiceCatalog sc) {
        return this.servCatRepo.save(sc);
    }
}
