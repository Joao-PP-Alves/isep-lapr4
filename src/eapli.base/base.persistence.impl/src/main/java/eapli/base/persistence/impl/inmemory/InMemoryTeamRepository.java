package eapli.base.persistence.impl.inmemory;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.team.domain.Team;
import eapli.base.teamtype.repository.TeamRepository;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryTeamRepository extends InMemoryDomainRepository<Team, Designation>
implements TeamRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<Team> findAll() {
        return match(e -> !e.identity().toString().equals(""));
    }

}
