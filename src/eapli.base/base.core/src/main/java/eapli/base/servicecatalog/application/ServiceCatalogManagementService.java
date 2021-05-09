package eapli.base.servicecatalog.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.domain.Service;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.base.servicecatalog.domain.ServiceCatalogBuilder;
import eapli.base.servicecatalog.repositories.ServiceCatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class ServiceCatalogManagementService {

    private final ServiceCatalogRepository servCatRepo = PersistenceContext.repositories().serviceCatalogs();

    @Autowired
    public ServiceCatalogManagementService() {
    }

    public ServiceCatalog registerNewServiceCatalog(String title, String shortDescription, String longDescription, String icon,
                                                    Set<ServiceCatalog> subCatalogs, Set<Service> listServices, boolean topCatalog) {

        ServiceCatalogBuilder servCatBuilder = new ServiceCatalogBuilder();
        servCatBuilder.with(title, shortDescription, longDescription, icon, subCatalogs, listServices, topCatalog);
        ServiceCatalog servCat = servCatBuilder.build();

        return this.servCatRepo.save(servCat);
    }
}
