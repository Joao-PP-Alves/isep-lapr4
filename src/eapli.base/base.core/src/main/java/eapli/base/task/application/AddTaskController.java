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
package eapli.base.task.application;


import eapli.base.clientusermanagement.domain.ApprovalStatus;
import eapli.base.collaboratormanagement.domain.Collaborator;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.domain.Field;
import eapli.base.service.domain.Form;
import eapli.base.service.domain.Service;
import eapli.base.service.repositories.ServiceRepository;
import eapli.base.task.domain.Task;
import eapli.base.task.domain.TaskBuilder;
import eapli.base.task.repositories.TaskRepository;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.domain.TicketBuilder;
import eapli.base.ticket.domain.UrgencyTypes;
import eapli.base.ticket.repositories.TicketRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Calendar;
import java.util.List;


/**
 * Based on AddUserController
 * Created by João Correia
 */
@UseCaseController
public class AddTaskController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final TaskBuilder taskBuilder = new TaskBuilder();
    private final TaskRepository taskRepo = PersistenceContext.repositories().tasks();



    public Task addTask(Long version, Long id, Calendar date, String helpDescription, Collaborator solverCollab,
                          ApprovalStatus approval) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.HRR, BaseRoles.ADMIN, BaseRoles.POWER_USER, BaseRoles.COLLABORATOR);

        taskBuilder.with(date, helpDescription, solverCollab, approval);
        Task task = taskBuilder.build();
        return this.taskRepo.save(task);
    }


}
