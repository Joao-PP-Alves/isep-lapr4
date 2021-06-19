package eapli.base.app.backoffice.console.presentation.servicecatalog;

import eapli.base.servicecatalog.application.AddServiceCatalogController;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.base.team.domain.Team;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class AddServiceCatalogUI extends AbstractUI {

    private final AddServiceCatalogController theController = new AddServiceCatalogController();
    @Override
    protected boolean doShow() {
        final String title = Console.readLine("Title");
        final String shortDescription = Console.readLine("Short Description");
        final String longDescription = Console.readLine("Long Description");
        Set<ServiceCatalog> serviceCatalogs = new HashSet<>();
        boolean show;
        do {
            show = showServiceCatalogs(serviceCatalogs);
        } while(!show);

        List<ServiceCatalog> list = new ArrayList<>(serviceCatalogs);
        ServiceCatalog sc = theController.addServiceCatalog(title,shortDescription,longDescription,null, list.get(0));

        Set<Integer> ints = new HashSet<>();
        do {
            show = showOptions(ints);
        } while(!show);
        List<Integer> listInts = new ArrayList<>(ints);
        Set<Team> teamsSet= new HashSet<>();
        List<Team> teams = new ArrayList<>();
        while (listInts.get(0)==1){
            do {
                show = showTeams(teamsSet);
            } while(!show);
            teams.clear();
            teams.addAll(teamsSet);
            if (!teams.isEmpty()) {
                do {
                    ints.clear();
                    show = showOptions(ints);
                } while (!show);
                listInts.clear();
                listInts.addAll(ints);
            } else {
                System.out.println("Service Catalog already has all teams added");
            }
            ints.clear();
        }

/*
        Set<KeyWord> keyWords = new HashSet<>();

        while (!keepGoing){
            keyWords.add(new KeyWord(Console.readLine("Key Word")));
            String keepAdding = Console.readLine("Add more KeyWords? (Y/N)");
            if (keepAdding.equalsIgnoreCase("N") || keepAdding.equalsIgnoreCase("No")){
                keepGoing = true;
            }
        }
*/



/*        do {
            show = showTeams(teamsSet);
        } while(!show);
        */
        //teams.addAll(teamsSet);


        teamsSet.clear();
        teamsSet.addAll(teams);
        theController.manageAccessCriteria(sc,teamsSet);
        return true;
    }

    private boolean showServiceCatalogs(final Set<ServiceCatalog> serviceCatalogs) {
        final Menu serviceCatalogsMenu = buildServiceCatalogsMenu(serviceCatalogs);
        final MenuRenderer renderer = new VerticalMenuRenderer(serviceCatalogsMenu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildServiceCatalogsMenu(final Set<ServiceCatalog> serviceCatalogs){
        final Menu serviceCatalogsMenu = new Menu();
        int counter = 0;
        serviceCatalogsMenu.addItem(counter++,"None", () -> serviceCatalogs.add(null));
        for (ServiceCatalog sc: theController.listAllCatalogs()) {
            serviceCatalogsMenu.addItem(counter++, sc.getTitleAndBriefDescription(),() -> serviceCatalogs.add(sc));
        }
        return serviceCatalogsMenu;
    }

    private boolean showOptions(Set<Integer> options) {
        // TODO we could also use the "widget" classes from the framework...
        final Menu optionsMenu = buildOptionsMenu(options);
        final MenuRenderer renderer = new VerticalMenuRenderer(optionsMenu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildOptionsMenu(Set<Integer> options) {
        final Menu optionsMenu = new Menu();
        optionsMenu.addItem(MenuItem.of(1, "Grant Access to a Team", () -> options.add(1)));
        optionsMenu.addItem(MenuItem.of(2, "Continue", () -> options.add(2)));
        return optionsMenu;
    }

    private boolean showTeams(final Set<Team> teams) {
        final Menu teamsMenu = buildTeamsMenu(teams);
        final MenuRenderer renderer = new VerticalMenuRenderer(teamsMenu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildTeamsMenu(final Set<Team> teams) {
        final Menu teamsMenu = new Menu();
        int counter = 0;
        teamsMenu.addItem(MenuItem.of(counter++, "No Role", Actions.SUCCESS));
        for (final Team teamName : theController.getTeams()) {
            teamsMenu.addItem(MenuItem.of(counter++, teamName.toString(), () -> teams.add(teamName)));
        }
        return teamsMenu;
    }






    @Override
    public String headline() {
        return "Add Service";
    }
}
