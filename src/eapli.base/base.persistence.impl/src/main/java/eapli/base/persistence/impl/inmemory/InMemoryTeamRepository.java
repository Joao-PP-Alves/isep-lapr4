package eapli.base.persistence.impl.inmemory;

import eapli.base.team.domain.Team;
import eapli.base.team.repository.TeamRepository;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryTeamRepository extends InMemoryDomainRepository<Team, Designation>
implements TeamRepository {

    static {
        InMemoryInitializer.init();
    }

}
