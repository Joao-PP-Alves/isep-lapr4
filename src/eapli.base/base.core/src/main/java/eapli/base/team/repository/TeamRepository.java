package eapli.base.team.repository;
import eapli.base.team.domain.*;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.Designation;

import java.util.List;

public interface TeamRepository extends DomainRepository<Designation, Team> {

    /**
     * Find all teams.
     * @return
     */
    Iterable<Team> findAll();
}
