package eapli.base.ticket.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ticket.repositories.TicketRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Calendar;

public class GetTicketTaskInfoController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final TicketRepository ticketsRepo = PersistenceContext.repositories().tickets();

    public void getTicketTaskInfo(int[] taskTypeAmount) {

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.HRR, BaseRoles.ADMIN, BaseRoles.POWER_USER, BaseRoles.COLLABORATOR);

        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.HOUR_OF_DAY, 1);

        taskTypeAmount[0] = Long.valueOf(ticketsRepo.findPendingAmount()).intValue();
        taskTypeAmount[1] = Long.valueOf(ticketsRepo.findExpiredAmount()).intValue();
        taskTypeAmount[2] = Long.valueOf(ticketsRepo.findSoonToBeExpiredAmount(startDate, endDate)).intValue();
    }
}
