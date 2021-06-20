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

    @Query("SELECT COUNT(t) FROM Ticket t INNER JOIN Task t2 ON t2.approvalStatus = 'PENDING'")
    Long findPendingAmount();

    @Query("SELECT COUNT(t) FROM Ticket t INNER JOIN Task t2 ON t2.approvalStatus = 'EXPIRED'")
    Long findExpiredAmount();

    @Query("SELECT COUNT(t) FROM Ticket t WHERE t.deadline BETWEEN :startDate AND :endDate")
    Long findSoonToBeExpiredAmount(@Param("startDate")Calendar startDate, @Param("endDate")Calendar endDate);
}
