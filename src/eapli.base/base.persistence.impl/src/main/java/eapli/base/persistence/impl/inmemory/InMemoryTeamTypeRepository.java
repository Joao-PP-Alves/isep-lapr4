package eapli.base.persistence.impl.inmemory;
import eapli.base.teamtype.domain.TeamType;
import eapli.base.teamtype.domain.TeamTypeId;
import eapli.base.teamtype.repository.TeamTypeRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryTeamTypeRepository extends InMemoryDomainRepository<TeamType, TeamTypeId>
        implements TeamTypeRepository {

    static {
        InMemoryInitializer.init();
    }
}
