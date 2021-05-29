package eapli.base.ticket.repositories;

import eapli.base.collaboratormanagement.domain.Collaborator;
import eapli.base.service.domain.Service;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.domain.TicketId;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.Optional;

public interface TicketRepository extends DomainRepository<Long, Ticket> {

    /**
     * Find all Tickets.
     * @return
     */
    Iterable<Ticket> findAll();

    Optional<Collaborator> findById(TicketId id);

}
