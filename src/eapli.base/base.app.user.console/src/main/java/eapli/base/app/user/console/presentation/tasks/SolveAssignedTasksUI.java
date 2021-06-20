package eapli.base.app.user.console.presentation.tasks;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.domain.ApprovalTask;
import eapli.base.service.domain.Service;
import eapli.base.service.repositories.ServiceRepository;
import eapli.base.task.application.CheckPendingTasksController;
import eapli.base.task.domain.Task;
import eapli.base.ticket.repositories.TicketRepository;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SolveAssignedTasksUI extends AbstractUI {

    private final CheckPendingTasksController theController = new CheckPendingTasksController();


    @Override
    protected boolean doShow() {

        boolean show, more;

        System.out.println("Solve which Tasks?");
        do {
            String kindOfTasks = Console.readLine("ApprovalTasks(1) or ManualTasks(2)");
            if (kindOfTasks.equalsIgnoreCase("1")) {
                Set<ApprovalTask> apTasks = new HashSet<>();
                do {
                    show = showApprovalTasks(apTasks);
                } while (!show);

                String approved = Console.readLine("Approve task to be solved? (Y/N)");
                if (approved.equalsIgnoreCase("y") || approved.equalsIgnoreCase("yes")) {
                    List<ApprovalTask> list = new LinkedList<>(apTasks);
                    ApprovalTask appTask = list.get(0);
                    theController.ApproveApprovalTask(appTask);

                }

            } else if (kindOfTasks.equalsIgnoreCase("2")) {
                Set<Task> tasks = new HashSet<>();
                do {
                    show = showTasks(tasks);
                } while (!show);

                //TODO solve Manualtask


            }

            String another = Console.readLine("Want to solve another Task? (Y/N)");
            if (another.equalsIgnoreCase("y") || another.equalsIgnoreCase("yes")) {
                more = false;
            } else {
                more = true;
            }
        } while (!more);


        return false;
    }

    @Override
    public String headline() {
        return "My Pending Tasks";
    }

    private boolean showApprovalTasks(final Set<ApprovalTask> approvalTasks) {
        final Menu apTasksMenu = buildApTasksMenu(approvalTasks);
        final MenuRenderer renderer = new VerticalMenuRenderer(apTasksMenu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildApTasksMenu(final Set<ApprovalTask> approvalTasks) {
        final Menu apTasksMenu = new Menu();
        int counter = 0;
        apTasksMenu.addItem(counter++, "See Non-Approval Tasks", Actions.SUCCESS);
        for (ApprovalTask task : theController.checkPendingApprovalTasks()) {
            apTasksMenu.addItem(counter++, task.toString(), () -> approvalTasks.add(task));
        }
        return apTasksMenu;
    }

    private boolean showTasks(final Set<Task> tasks) {
        final Menu tasksMenu = buildTasksMenu(tasks);
        final MenuRenderer renderer = new VerticalMenuRenderer(tasksMenu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildTasksMenu(final Set<Task> tasks) {
        final Menu tasksMenu = new Menu();
        int counter = 0;
        tasksMenu.addItem(counter++, "Back", Actions.SUCCESS);
        for (Task task : theController.checkPendingTasks()) {
            tasksMenu.addItem(counter++, task.toString(), () -> tasks.add(task));
        }
        return tasksMenu;
    }
}
