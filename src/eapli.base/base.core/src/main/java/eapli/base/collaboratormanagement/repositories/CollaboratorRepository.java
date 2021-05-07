package eapli.base.collaboratormanagement.repositories;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.collaboratormanagement.domain.Collaborator;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Iterator;
import java.util.List;

public interface CollaboratorRepository extends DomainRepository<MecanographicNumber,Collaborator> {

    /**
     * Find all collaborators.
     * @return
     */
    Iterable<Collaborator> findAll();
}
