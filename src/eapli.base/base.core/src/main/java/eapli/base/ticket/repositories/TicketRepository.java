package eapli.base.ticket.repositories;


import eapli.base.ticket.domain.Ticket;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface TicketRepository extends DomainRepository<Long, Ticket> {

    /**
     * Find all Tickets.
     * @return
     */
    Iterable<Ticket> findAll();

    Optional<Ticket> findById(Long id);

}
