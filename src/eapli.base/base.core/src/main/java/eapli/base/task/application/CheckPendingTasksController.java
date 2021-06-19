package eapli.base.task.application;

import eapli.base.collaboratormanagement.domain.Collaborator;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.task.domain.Task;
import eapli.base.task.repositories.TaskRepository;

import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CheckPendingTasksController {

    private static TaskRepository tr = PersistenceContext.repositories().tasks();

    public List<Task> checkPendingTasks(Collaborator collaborator){
        return new ArrayList<Task>((Collection<? extends Task>) tr.checkPendingTasks(collaborator));
    }
}
