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
import eapli.base.service.domain.Field;
import eapli.base.service.domain.Form;
import eapli.base.service.domain.Service;
import eapli.base.service.repositories.ServiceRepository;
import eapli.base.task.domain.Task;
import eapli.base.ticket.domain.*;
import eapli.base.ticket.repositories.TicketRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;

import java.util.*;


/**
 * Based on AddUserController
 * Created by João Correia
 */
@UseCaseController
public class AddTicketController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final TicketRepository ticketsRepo = PersistenceContext.repositories().tickets();
    private final TicketBuilder ticketBuilder = new TicketBuilder();
    private final ServiceRepository servRepo = PersistenceContext.repositories().services();


    public Ticket addTicket(UrgencyTypes urgency, Service service, Calendar deadline, Calendar creationDate, int priority,
                            String fileName, CompletedForm form, Task task) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.HRR, BaseRoles.ADMIN, BaseRoles.POWER_USER, BaseRoles.COLLABORATOR);

        ticketBuilder.with(urgency, deadline, creationDate, priority, fileName, form, service, task);
        Ticket ticket = ticketBuilder.build();
        ticket.isSubmited();
        return this.ticketsRepo.save(ticket);
    }

    public List<Ticket> getAllTicketsList() {
        return (List<Ticket>) ticketsRepo.findAll();
    }


    public UrgencyTypes[] getUrgenciesList() {
        return UrgencyTypes.values();
    }

    public Iterable<? extends Service> getServices() {
        return servRepo.findAll();
    }

    public CompletedForm fillForm(Service service) {
        Form form = service.form(); // unfilled form

        List<Field> fieldsToComplete = new LinkedList<>();
        getAllFieldsToFill(fieldsToComplete, service.form().fields());

        for (Field f : fieldsToComplete) {
            showFieldToComplete(f);
        }

        Long identification = form.identification();
        return new CompletedForm(identification, new HashSet<>(fieldsToComplete));
    }

    private List<Field> getAllFieldsToFill(List<Field> fieldsToComplete, Set<Field> fields) {
        if (fields.isEmpty()) {
            return null;
        } else {
            for (Field f : fields) {
                getAllFieldsToFill(fieldsToComplete, f.fields());
                try {
                    Field clonedField = (Field) f.clone();
                    fieldsToComplete.add(clonedField);
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        }
        return fieldsToComplete;
    }


    private void showFieldToComplete(Field f) {
        System.out.printf("Complete the following field:");
        f.putAnswer(Console.readLine(f.presentationTicket().toString()));
    }


}
