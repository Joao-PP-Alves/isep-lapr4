package eapli.base.teamtype.repository;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.collaboratormanagement.domain.Collaborator;
import eapli.base.team.domain.*;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface TeamRepository extends DomainRepository<TeamId, Team> {

    /**
     * Find all teams.
     * @return
     */
    List<Team> all();
}
