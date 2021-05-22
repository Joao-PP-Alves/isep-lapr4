package eapli.base.service.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.domain.*;
import eapli.base.service.repositories.ServiceDraftRepository;
import eapli.base.service.repositories.ServiceRepository;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.base.taskspec.domain.TaskSpec;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class ServiceDraftManagementService {

    private final ServiceDraftRepository servRepo = PersistenceContext.repositories().servicesDraft();

    @Autowired
    public ServiceDraftManagementService() {
    }

    public ServiceDraft registerNewServiceDraft(String name, ServiceCatalog serviceCatalog, String shortDesc, String longDesc,
                                      ApprovalTask approvalTask, Form form, TaskSpec taskSpec, String icon, Set<KeyWord> keyWords, boolean complete) {

        ServiceDraftBuilder servBuilder = new ServiceDraftBuilder();
        servBuilder.with(name,serviceCatalog,shortDesc,longDesc,approvalTask,form,taskSpec,icon,keyWords,complete);
        ServiceDraft serv = servBuilder.build();

        return this.servRepo.save(serv);
    }
}
