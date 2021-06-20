package eapli.base.ticket.repositories;


import eapli.base.ticket.domain.Ticket;
import eapli.framework.domain.repositories.DomainRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Calendar;
import java.util.Optional;

public interface TicketRepository extends DomainRepository<Long, Ticket> {

    /**
     * Find all Tickets.
     * @return
     */
    Iterable<Ticket> findAll();

    Optional<Ticket> findById(Long id);

    int findPendingAmount();

    int findExpiredAmount();

    int findSoonToBeExpiredAmount(@Param("startDate")Calendar startDate, @Param("endDate")Calendar endDate);
}
