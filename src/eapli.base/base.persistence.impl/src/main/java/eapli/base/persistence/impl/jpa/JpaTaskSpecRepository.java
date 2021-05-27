package eapli.base.persistence.impl.jpa;


import eapli.base.Application;
import eapli.base.taskspec.domain.ManualTaskSpec;
import eapli.base.taskspec.domain.TaskSpec;
import eapli.base.taskspec.repositories.TaskSpecRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaTaskSpecRepository extends JpaAutoTxRepository<TaskSpec, Long, Long>
implements TaskSpecRepository {

    public JpaTaskSpecRepository(TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaTaskSpecRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    public Iterable<TaskSpec> findAll(){
        return this.repo.findAll();
    }


}
