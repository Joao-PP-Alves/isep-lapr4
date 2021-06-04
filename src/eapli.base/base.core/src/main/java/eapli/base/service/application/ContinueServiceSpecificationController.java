package eapli.base.service.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.service.domain.*;
import eapli.base.service.repositories.ServiceRepository;
import eapli.base.servicecatalog.domain.ServiceCatalog;

import java.util.ArrayList;
import java.util.List;

public class ContinueServiceSpecificationController {

    private final RepositoryFactory rf = PersistenceContext.repositories();

    public List<Service> listUncompleteServices(){
        List<Service> list = new ArrayList<>();
        ServiceRepository sdr = rf.services();
        sdr.findUncomplete().forEach(list::add);
        return list;
    }

    public void updateService(Service sd, ServiceCatalog sc, Form form, ApprovalTask approvalTask, TaskSpec taskSpec){
        sd.updateAndCheckCatalog(sc);
        sd.updateAndCheckForm(form);
        sd.updateAndCheckApprovalTask(approvalTask);
        sd.updateAndCheckTaskSpec(taskSpec);
        rf.services().save(sd);
    }

    public void finishServiceSpecification(Service sc){
        AddServiceController addServiceController = new AddServiceController();
        addServiceController.verifyIfPossible(sc);
        rf.services().save(sc);
    }
}
