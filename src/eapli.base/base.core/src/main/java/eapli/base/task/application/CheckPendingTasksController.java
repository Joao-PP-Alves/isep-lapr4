package eapli.base.task.application;

import eapli.base.collaboratormanagement.domain.Collaborator;
import eapli.base.collaboratormanagement.repositories.CollaboratorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.domain.ApprovalTask;
import eapli.base.service.domain.Service;
import eapli.base.service.repositories.ServiceRepository;
import eapli.base.task.domain.Task;
import eapli.base.task.repositories.TaskRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class CheckPendingTasksController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private static TaskRepository tr = PersistenceContext.repositories().tasks();
    private static CollaboratorRepository cr = PersistenceContext.repositories().collaborators();

    public List<Task> checkPendingTasks(){
        SystemUser user = authz.session().get().authenticatedUser();
        Optional<Collaborator> collaborator = cr.findByUsername(user.username());
        return collaborator.map(value -> new ArrayList<Task>((Collection<? extends Task>) tr.checkPendingTasks(value))).orElse(null);
    }

    public List<ApprovalTask> checkPendingApprovalTasks(){
        SystemUser user = authz.session().get().authenticatedUser();
        ServiceRepository sr = PersistenceContext.repositories().services();
        List<ApprovalTask> listToReturn = new ArrayList<>();
        List<Service> list = new ArrayList<>();
        sr.findAll().forEach(list::add);
        for (Service s : list){
            if (s.approvalTask().assignedCollab().user().equals(user)){
                listToReturn.add(s.approvalTask());
            }
        }
        return listToReturn;
    }
}
