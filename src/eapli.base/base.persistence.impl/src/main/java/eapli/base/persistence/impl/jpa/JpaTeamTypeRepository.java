package eapli.base.persistence.impl.jpa;
import eapli.base.Application;
import eapli.base.teamtype.domain.TeamType;
import eapli.base.teamtype.domain.TeamTypeId;
import eapli.base.teamtype.repository.TeamTypeRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaTeamTypeRepository extends JpaAutoTxRepository<TeamType, TeamTypeId, TeamTypeId>
        implements TeamTypeRepository {

    public JpaTeamTypeRepository(TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaTeamTypeRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

}
