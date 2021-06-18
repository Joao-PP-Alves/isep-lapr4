package eapli.base.app.backoffice.console.presentation.ticket;

import eapli.base.clientusermanagement.domain.ApprovalStatus;
import eapli.base.collaboratormanagement.domain.*;
import eapli.base.service.domain.*;
import eapli.base.task.domain.Task;
import eapli.base.ticket.application.AddTicketController;
import eapli.base.ticket.domain.*;
import eapli.framework.actions.menu.Menu;
import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

import java.util.*;

public class AddTicketUI extends AbstractUI {

    private final AddTicketController ticketController = new AddTicketController();

    @Override
    protected boolean doShow() {


        boolean show;
        System.out.println("Choose a Service from the Catalog");
        Set<Service> services = new HashSet<>();
        do {
            show = showServices(services);
        } while (!show);

        List<Service> servicesList = new LinkedList<>(services);

        show = false;
        System.out.println("Choose Urgency");
        Set<UrgencyTypes> urgencies = new HashSet<>();
        do {
            show = showUrgencies(urgencies);
        } while (!show);

        List<UrgencyTypes> urgenciesList = new LinkedList<>(urgencies);

        Calendar creationDate = Calendar.getInstance();
        Calendar deadline = Calendar.getInstance();
        deadline.clear();

        final String date = Console.readLine("Deadline date (DD/MM/YYYY)");
        String[] splittedDate = date.split("/");
        int day = Integer.parseInt(splittedDate[0]);
        int month = Integer.parseInt(splittedDate[1]);
        int year = Integer.parseInt(splittedDate[2]);
        deadline.set(year, month, day);


        int priority = 1; //TODO Priority formula should be defined later

        //final String formName = Console.readLine("Form name to attach");

        CompletedForm completedform = ticketController.fillForm(servicesList.get(0));

        //TODO get Collaborator from access criteria of service catalog and description

        Collaborator collab = new Collaborator(FullName.valueOf("COLLABORATOR_FULLNAME"), ShortName.valueOf("COLLABORATOR_SHORTNAME") ,
                Address.valueOf("COLLABORATOR_ADDRESS"), PhoneNumber.valueOf(963852741),
                new LinkedList<Role>(), Calendar.getInstance(),CompanyRole.valueOf("COLLABORATOR_COMPANY_ROLE"));

        Task task = new Task(creationDate, Description.valueOf("test Description"), collab, ApprovalStatus.PENDING);
        final String fileName = Console.readLine("File name to attach");
        ticketController.addTicket(urgenciesList.get(0), servicesList.get(0), deadline, creationDate, priority, fileName, completedform, task);




        return true;
    }

    private boolean showUrgencies(Set<UrgencyTypes> urgencies) {
        final Menu urgenciesMenu = buildUrgenciesMenu(urgencies);
        final MenuRenderer renderer = new VerticalMenuRenderer(urgenciesMenu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildUrgenciesMenu(final Set<UrgencyTypes> urgencies) {
        final Menu urgenciesMenu = new Menu();
        int counter = 0;
        for (UrgencyTypes urg : ticketController.getUrgenciesList()) {
            urgenciesMenu.addItem(counter++, urg.toString(), () -> urgencies.add(urg));
        }
        return urgenciesMenu;
    }
    

    private boolean showServices(final Set<Service> services) {
        final Menu servicesMenu = buildServicesMenu(services);
        final MenuRenderer renderer = new VerticalMenuRenderer(servicesMenu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildServicesMenu(final Set<Service> services) {
        final Menu servicesMenu = new Menu();
        int counter = 0;
        for (Service serv : ticketController.getServices()) {
            servicesMenu.addItem(counter++, serv.name().toString(), () -> services.add(serv));
        }
        return servicesMenu;
    }

    @Override
    public String headline() {
        return "Create new Ticket";
    }
}
