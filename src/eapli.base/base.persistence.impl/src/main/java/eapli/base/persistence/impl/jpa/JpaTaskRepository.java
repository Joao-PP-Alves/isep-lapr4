package eapli.base.persistence.impl.jpa;


import eapli.base.Application;
import eapli.base.collaboratormanagement.domain.Collaborator;
import eapli.base.service.domain.Service;
import eapli.base.service.repositories.ServiceRepository;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.base.task.domain.Task;
import eapli.base.task.repositories.TaskRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaTaskRepository extends JpaAutoTxRepository<Task, Long, Long>
implements TaskRepository {

    public JpaTaskRepository(TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaTaskRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    public Iterable<Task> findAll(){
        return this.repo.findAll();
    }

    @Override
    public Iterable<Task> checkPendingTasks(Collaborator collaborator) {
        return match("e.solverCollab = :collaborator",collaborator);
    }
}
