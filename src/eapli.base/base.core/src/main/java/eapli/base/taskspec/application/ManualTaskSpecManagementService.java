package eapli.base.taskspec.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.domain.Form;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.base.servicecatalog.domain.ServiceCatalogBuilder;
import eapli.base.servicecatalog.repositories.ServiceCatalogRepository;
import eapli.base.taskspec.domain.ManualTaskSpec;
import eapli.base.taskspec.domain.ManualTaskSpecBuilder;
import eapli.base.taskspec.repositories.ManualTaskSpecRepository;
import eapli.framework.general.domain.model.Designation;
import org.springframework.beans.factory.annotation.Autowired;

public class ManualTaskSpecManagementService {

    private final ManualTaskSpecRepository manualTasksSpecRepo = PersistenceContext.repositories().manualTasksSpec();


    @Autowired
    public ManualTaskSpecManagementService() {
    }

    public ManualTaskSpec registerNewManualTaskSpec(String taskSpecId, Form form) {

        ManualTaskSpec mtsss = new ManualTaskSpec(Designation.valueOf(taskSpecId), form);
        ManualTaskSpecBuilder mtsBuilder = new ManualTaskSpecBuilder();
        mtsBuilder.withId(taskSpecId).withForm(form);
        ManualTaskSpec manualTaskSpec = mtsBuilder.build();

        return this.manualTasksSpecRepo.save(manualTaskSpec);
    }
}
