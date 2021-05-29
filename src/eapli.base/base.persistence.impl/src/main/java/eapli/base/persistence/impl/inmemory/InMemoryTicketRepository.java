package eapli.base.persistence.impl.inmemory;

import eapli.base.collaboratormanagement.domain.Collaborator;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.domain.TicketId;
import eapli.base.ticket.repositories.TicketRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryTicketRepository extends InMemoryDomainRepository<Ticket,Long> implements TicketRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        return matchOne(e -> e.identity().equals(id));
    }
}
