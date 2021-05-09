package eapli.base.service.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.domain.Service;
import eapli.base.service.domain.ServiceBuilder;
import eapli.base.service.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceManagementService {

    private final ServiceRepository servRepo = PersistenceContext.repositories().services();

    @Autowired
    public ServiceManagementService() {
    }

    public Service registerNewService(String name) {

        ServiceBuilder servBuilder = new ServiceBuilder();
        servBuilder.with(name);
        Service serv = servBuilder.build();

        return this.servRepo.save(serv);
    }
}
