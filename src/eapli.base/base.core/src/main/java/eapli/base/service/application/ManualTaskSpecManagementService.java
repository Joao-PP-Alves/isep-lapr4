package eapli.base.service.application;

import eapli.base.service.domain.Form;
import eapli.base.service.domain.ManualTaskSpec;
import org.springframework.beans.factory.annotation.Autowired;

public class ManualTaskSpecManagementService {

    @Autowired
    public ManualTaskSpecManagementService() {
    }

    public ManualTaskSpec registerNewManualTaskSpec(String taskSpecId, Form form) {
        if (taskSpecId != null && form != null)
            return new ManualTaskSpec(taskSpecId, form);
        return null;
    }
}
