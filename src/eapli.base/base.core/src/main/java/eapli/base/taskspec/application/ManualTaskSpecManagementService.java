package eapli.base.taskspec.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.domain.Form;
import eapli.base.taskspec.domain.ManualTaskSpec;
import eapli.base.taskspec.domain.ManualTaskSpecBuilder;
import eapli.base.taskspec.domain.TaskSpec;
import eapli.base.taskspec.repositories.TaskSpecRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ManualTaskSpecManagementService {

    private final TaskSpecRepository tasksSpecRepo = PersistenceContext.repositories().tasksSpec();


    @Autowired
    public ManualTaskSpecManagementService() {
    }

    public TaskSpec registerNewManualTaskSpec(String taskSpecId, Form form) {

        //ManualTaskSpec mtsss = new ManualTaskSpec(taskSpecId, form);
        ManualTaskSpecBuilder mtsBuilder = new ManualTaskSpecBuilder();
        mtsBuilder.with(taskSpecId, form);
        ManualTaskSpec manualTaskSpec = mtsBuilder.build();

        return this.tasksSpecRepo.save(manualTaskSpec);
    }
}
