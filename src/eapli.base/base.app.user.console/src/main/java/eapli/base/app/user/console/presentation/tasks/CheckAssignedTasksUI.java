package eapli.base.app.user.console.presentation.tasks;

import eapli.base.servicecatalog.application.ListServiceCatalogsController;
import eapli.base.task.application.CheckPendingTasksController;
import eapli.base.task.domain.Task;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

import java.util.HashSet;
import java.util.Set;

public class CheckAssignedTasksUI extends AbstractUI {

    private final CheckPendingTasksController theController = new CheckPendingTasksController();

    @Override
    protected boolean doShow() {
        boolean show;
        Set<Task> tasks = new HashSet<>();
        do {
            show = showTasks(tasks);
        } while (!show);
        return true;
    }

    @Override
    public String headline() {
        return null;
    }

    private boolean showTasks(final Set<Task> tasks){
        final Menu tasksMenu = buildTasksMenu(tasks);
        final MenuRenderer renderer = new VerticalMenuRenderer(tasksMenu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildTasksMenu(final Set<Task> tasks){
        final Menu tasksMenu = new Menu();
        int counter = 0;
        tasksMenu.addItem(counter++,"Back", Actions.SUCCESS);
        for (Task task : theController.checkPendingTasks()){
            tasksMenu.addItem(counter++, String.valueOf(task.identity()),() -> tasks.add(task));
        }
        return tasksMenu;
    }
    
}
