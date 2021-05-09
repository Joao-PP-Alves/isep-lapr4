package eapli.base.persistence.impl.inmemory;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.collaboratormanagement.domain.Collaborator;
import eapli.base.collaboratormanagement.repositories.CollaboratorRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;


public class InMemoryCollaboratorRepository extends InMemoryDomainRepository<Collaborator, Long>
implements CollaboratorRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<Collaborator> findAll() {
        return match(e -> e.mecanographicNumber().toString().equals(new MecanographicNumber().toString()));
    }

    @Override
    public Optional<Collaborator> findByUsername(Username user) {
        throw new UnsupportedOperationException("Collaborator - findByUsername not implemented yet");
    }
}
