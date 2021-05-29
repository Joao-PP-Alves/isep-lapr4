/*
 * Copyright (c) 2013-2020 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.ticket.application;


import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ticket.domain.*;
import eapli.base.ticket.repositories.TicketRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Calendar;
import java.util.List;


/**
 * Base on AddUserController
 * Created by João Correia
 */
@UseCaseController
public class AddTicketController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final TicketRepository ticketsRepo = PersistenceContext.repositories().tickets();
    private final TicketBuilder ticketBuilder = new TicketBuilder();


    public Ticket addTicket(Long ticketId, UrgencyTypes urgency, TicketState ticketState, Calendar deadline,
                            Calendar creationDate, Priority priority, Feedback feedback, AnnexedFile fileName) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.HRR, BaseRoles.ADMIN, BaseRoles.POWER_USER, BaseRoles.COLLABORATOR);
        ticketBuilder.with(ticketId, urgency, ticketState, deadline, creationDate, priority, feedback, fileName);
        return ticketBuilder.build();

    }

    public List<Ticket> getAllTicketsList() {
        return (List<Ticket>) ticketsRepo.findAll();
    }
}
