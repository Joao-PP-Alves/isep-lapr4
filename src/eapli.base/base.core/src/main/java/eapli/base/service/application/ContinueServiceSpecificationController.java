package eapli.base.service.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.service.domain.ApprovalTask;
import eapli.base.service.domain.Form;
import eapli.base.service.domain.ServiceDraft;
import eapli.base.service.repositories.ServiceDraftRepository;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.base.taskspec.domain.TaskSpec;

import java.util.ArrayList;
import java.util.List;

public class ContinueServiceSpecificationController {

    private final RepositoryFactory rf = PersistenceContext.repositories();

    public List<ServiceDraft> listServiceDrafts(){
        List<ServiceDraft> list = new ArrayList<>();
        ServiceDraftRepository sdr = rf.servicesDraft();
        sdr.findAll().forEach(list::add);
        return list;
    }

    public void updateServiceDraft(ServiceDraft sd, ServiceCatalog sc, Form form, ApprovalTask approvalTask, TaskSpec taskSpec){
        if (sd.getServiceCatalog()==null) {
            if (sc != null) {
                sd.setServiceCatalog(sc);
            }
        }
        if (sd.getForm()==null) {
            if (form != null) {
                sd.setForm(form);
            }
        }
        if (sd.getApprovalTask()==null) {
            if (approvalTask != null) {
                sd.setApprovalTask(approvalTask);
            }
        }
        if (sd.getTaskSpec()==null) {
            if (taskSpec != null) {
                sd.setTaskSpec(taskSpec);
            }
        }
        rf.servicesDraft().save(sd);
    }

    public void finishServiceSpecification(ServiceDraft sc){
        AddServiceController addServiceController = new AddServiceController();
        addServiceController.addService(sc.getName().toString(),sc.getServiceCatalog(),sc.getShortServiceDescription().toString(),sc.getLongServiceDescription().toString(),sc.getApprovalTask(),sc.getForm(),sc.getTaskSpec(),sc.getIcon().toString(),sc.getKeyWords());
        rf.servicesDraft().delete(sc);
    }
}
