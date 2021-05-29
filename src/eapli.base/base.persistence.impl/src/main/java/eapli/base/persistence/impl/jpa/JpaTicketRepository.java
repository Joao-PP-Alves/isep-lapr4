package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.repositories.TicketRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaTicketRepository extends JpaAutoTxRepository<Ticket,Long,Long> implements TicketRepository {

    public JpaTicketRepository(TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaTicketRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }
}
