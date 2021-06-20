package eapli.base.persistence.impl.inmemory;

import eapli.base.collaboratormanagement.domain.Collaborator;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.domain.TicketId;
import eapli.base.ticket.repositories.TicketRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Calendar;
import java.util.Optional;

public class InMemoryTicketRepository extends InMemoryDomainRepository<Ticket,Long> implements TicketRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        return matchOne(e -> e.identity().equals(id));
    }

    @Override
    public Long findPendingAmount() {
        return null;
    }

    @Override
    public Long findExpiredAmount() {
        return null;
    }

    @Override
    public Long findSoonToBeExpiredAmount(Calendar startDate, Calendar endDate) {
        return null;
    }
}
