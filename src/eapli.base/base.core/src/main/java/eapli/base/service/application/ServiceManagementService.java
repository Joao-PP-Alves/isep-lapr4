package eapli.base.service.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.domain.*;
import eapli.base.service.repositories.ServiceRepository;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.base.service.domain.TaskSpec;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class ServiceManagementService {

    private final ServiceRepository servRepo = PersistenceContext.repositories().services();

    @Autowired
    public ServiceManagementService() {
    }

    public Service registerNewService(String name, ServiceCatalog serviceCatalog, String shortDesc, String longDesc,
                                      ApprovalTask approvalTask, Form form, TaskSpec taskSpec, String icon, Set<KeyWord> keyWords) {

        ServiceBuilder servBuilder = new ServiceBuilder();
        servBuilder.with(name,serviceCatalog,shortDesc,longDesc,approvalTask,form,taskSpec,icon,keyWords);
        Service serv = servBuilder.build();

        return this.servRepo.save(serv);
    }
}
