package eapli.base.persistence.impl.inmemory;

import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.repositories.TicketRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import javax.persistence.Query;
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

        final Query q = createNativeQuery("SELECT COUNT(*) FROM TICKET INNER JOIN TASK t\n" +
                "ON t.approvedStatus = 'PENDING'", Ticket.class);

        return (Long) q.getSingleResult();
    }

    @Override
    public Long findExpiredAmount() {

        final Query q = createNativeQuery("SELECT COUNT(*) FROM TICKET INNER JOIN TASK t\n" +
                "ON t.approvedStatus = 'EXPIRED'", Ticket.class);

        return (Long) q.getSingleResult();
    }

    @Override
    public Long findSoonToBeExpiredAmount(Calendar startDate, Calendar endDate) {

        final Query q = createNativeQuery("SELECT COUNT(*) FROM Ticket t\n" +
                "WHERE t.deadline BETWEEN :startDate AND :endDate", Ticket.class);
        q.setParameter("startDate", startDate);
        q.setParameter("endDate", endDate);

        return (Long) q.getSingleResult();
    }
}
