package eapli.base.persistence.impl.inmemory;

import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.domain.TicketState;
import eapli.base.ticket.repositories.TicketRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Calendar;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
    public int findPendingAmount() {
        List<Ticket> list = new ArrayList<>();
        match(e -> e.state().equals(TicketState.SUBMETIDO)).forEach(list::add);
        return list.size();
    }

    @Override
    public int findExpiredAmount() {

        List<Ticket> list = new ArrayList<>();
        match(e -> e.state().equals(TicketState.RESOLVIDO)).forEach(list::add);
        return list.size();
    }

    @Override
    public int findSoonToBeExpiredAmount(Calendar startDate, Calendar endDate) {

        List<Ticket> list = new ArrayList<>();
        match(e -> e.deadLine().before(endDate)).forEach(list::add);
        List<Ticket> list2 = new ArrayList<>();
        match(e -> e.deadLine().after(startDate)).forEach(list2::add);
        List<Ticket> theFinalOne = new ArrayList<>();
        for (Ticket t : list){
            for (Ticket t2 : list2){
                if (t.equals(t2)){
                    theFinalOne.add(t);
                }
            }
        }
        return theFinalOne.size();
    }
}
