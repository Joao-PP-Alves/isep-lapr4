package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.team.domain.Team;
import eapli.base.team.repository.TeamRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaTeamRepository extends JpaAutoTxRepository<Team, Designation,Designation>
implements TeamRepository {

    public JpaTeamRepository(TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaTeamRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    @Override
    public Iterable<Team> findAll(){
        return match("e.id!= null");
    }

}
