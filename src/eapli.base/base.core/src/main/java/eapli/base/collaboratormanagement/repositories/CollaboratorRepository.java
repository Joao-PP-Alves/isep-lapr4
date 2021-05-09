package eapli.base.collaboratormanagement.repositories;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.collaboratormanagement.domain.Collaborator;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public interface CollaboratorRepository extends DomainRepository<Long,Collaborator> {

    /**
     * Find all collaborators.
     * @return
     */
    Iterable<Collaborator> findAll();

    Optional<Collaborator> findByUsername(Username user);
}
