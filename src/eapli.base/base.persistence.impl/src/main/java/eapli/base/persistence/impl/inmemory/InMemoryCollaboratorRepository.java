package eapli.base.persistence.impl.inmemory;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.collaboratormanagement.domain.Collaborator;
import eapli.base.collaboratormanagement.repositories.CollaboratorRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;


public class InMemoryCollaboratorRepository extends InMemoryDomainRepository<Collaborator, MecanographicNumber>
implements CollaboratorRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<Collaborator> findAll() {
        return match(e -> e.mecanographicNumber().toString().equals(new MecanographicNumber().toString()));
    }
}
