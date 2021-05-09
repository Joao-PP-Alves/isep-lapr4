package eapli.base.collaboratormanagement.repositories;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.collaboratormanagement.domain.Collaborator;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;


import java.util.Optional;

public interface CollaboratorRepository extends DomainRepository<MecanographicNumber,Collaborator> {

    /**
     * Find all collaborators.
     * @return
     */
    Iterable<Collaborator> findAll();

    Optional<Collaborator> findByUsername(Username user);
}
