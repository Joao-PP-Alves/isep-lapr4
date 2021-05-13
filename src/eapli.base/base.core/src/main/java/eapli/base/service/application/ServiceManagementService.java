package eapli.base.service.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.domain.Service;
import eapli.base.service.domain.ServiceBuilder;
import eapli.base.service.repositories.ServiceRepository;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceManagementService {

    private final ServiceRepository servRepo = PersistenceContext.repositories().services();

    @Autowired
    public ServiceManagementService() {
    }

    public Service registerNewService(String name, ServiceCatalog sc) {

        ServiceBuilder servBuilder = new ServiceBuilder();
        servBuilder.with(name,sc);
        Service serv = servBuilder.build();

        return this.servRepo.save(serv);
    }
}
