package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.repositories.TicketRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Calendar;

public class JpaTicketRepository extends JpaAutoTxRepository<Ticket, Long, Long> implements TicketRepository {

    public JpaTicketRepository(TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaTicketRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    @Override
    public int findPendingAmount() {

        final Query q = createNativeQuery("SELECT COUNT(*) FROM TICKET INNER JOIN TASK t\n" +
                "ON t.approvedStatus = 'submetido'", Ticket.class);

        return (int) q.getSingleResult();
    }

    @Override
    public int findExpiredAmount() {

        final Query q = createNativeQuery("SELECT COUNT(*) FROM TICKET INNER JOIN TASK t\n" +
                "ON t.approvedStatus = 'resolvido'", Ticket.class);

        return (int) q.getSingleResult();
    }

    @Override
    public int findSoonToBeExpiredAmount(Calendar startDate, Calendar endDate) {

        final Query q = createNativeQuery("SELECT COUNT(*) FROM Ticket t\n" +
                "WHERE t.deadline BETWEEN :startDate AND :endDate", Ticket.class);
        q.setParameter("startDate", startDate);
        q.setParameter("endDate", endDate);

        return (int) q.getSingleResult();
    }
}
