package eapli.base.app.backoffice.console.presentation.collaborator;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.collaboratormanagement.application.*;
import eapli.base.collaboratormanagement.domain.Collaborator;
import eapli.base.team.domain.Team;
import eapli.base.teamtype.domain.TeamType;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ModifyCollaboratorTeamUI extends AbstractUI {

    private final ModifyCollaboratorTeamController theController = new ModifyCollaboratorTeamController();

    @Override
    protected boolean doShow() {

        Set<Collaborator> collaborators = new HashSet<>();
        boolean show;
        do {
            show = showCollaborators(collaborators);
        } while (!show);

        List<Collaborator> list = new ArrayList<>(collaborators);
        Set<Integer> options = new HashSet<>();

        do {
            show = showOptions(options);
        } while(!show);

        List<Integer> listOptions = new ArrayList<>(options);
        Set<Team> teams = new HashSet<>();

        do {
            show = showTeams(teams,listOptions.get(0),list.get(0));
        } while(!show);

        List<Team> listTeams = new ArrayList<>(teams);
        theController.changeTeam(listTeams.get(0),list.get(0),listOptions.get(0));
/*

        ArrayList<Collaborator> arrayList = (ArrayList<Collaborator>) theController.listCollaborators();
        int contador=0;
        if (arrayList.size()==0){
            System.out.println("There are no collaborators yet. Try again later!");
            return true;
        }
        for (Collaborator coll:arrayList){
            System.out.printf("%d -> %s - %s\n",contador,coll.getShortName(),coll.identity());
            contador++;
        }
        System.out.printf("%d -> Cancel Operation.\n",contador);
        int option= Console.readInteger("Select collaborator.\n");
        while (option < 0 || option > arrayList.size()){
            System.out.println("Invalid option. Try again.");
            option= Console.readInteger("Select collaborator.\n");
        }
        if (option==contador){
            System.out.println("Operation canceled");
            return true;
        }
        Collaborator collaborator = arrayList.get(option);
        int option2 = Console.readInteger("1 -> Add to a team.\n2 -> Remove from a team.\n3 -> Cancel Operation.\n");
        contador=0;
        while (option2 < 0 || option2 > 3){
            System.out.println("Invalid option. Try again.");
            option2 = Console.readInteger("1 -> Add to a team.\n2 -> Remove from a team.\n3 -> Cancel Operation.\n");
        }
        if(option2 == 1){
            ArrayList<Team> arrayListTeams =(ArrayList<Team>) theController.listTeams();
            List<Team> listToShow = new ArrayList<>();
            for (Team t: arrayListTeams){
                Set<Collaborator> listEach = t.getMembers();
                if (!listEach.contains(collaborator)){
                    listToShow.add(t);
                }
            }
            if (listToShow.size()==0){
                System.out.println("There are no teams yet. Try again later!");
                return true;
            }
            for (Team team:listToShow){
                System.out.printf("%d -> %s\n",contador,team.identity());
                contador++;
            }
            System.out.printf("%d -> Cancel Operation.\n",contador);
            option= Console.readInteger("Select Team.\n");
            while (option < 0 || option >= listToShow.size()){
                System.out.println("Invalid option. Try again.");
                option= Console.readInteger("Select Team.\n");
            }
            if (option==contador){
                System.out.println("Operation canceled");
                return true;
            }
            Team teamToAdd = listToShow.get(option);
            if (!theController.changeTeam(teamToAdd,collaborator,1).getId().isEmpty()){
                System.out.println("Collaborator was added successfully to the team. Successful operation.");
                return true;
            } else {
                System.out.println("Something went wrong. Aborting operation.");
                return false;
            }
        } else if(option==2) {
            ArrayList<Team> arrayListTeams =(ArrayList<Team>) theController.listTeams();
            List<Team> listToShow = new ArrayList<>();
            for (Team t: arrayListTeams){
                Set<Collaborator> listEach = t.getMembers();
                if (listEach.contains(collaborator)){
                    listToShow.add(t);
                }
            }
            if (listToShow.size()==0){
                System.out.println("There are no teams yet. Try again later!");
                return true;
            }
            for (Team team:listToShow){
                System.out.printf("%d -> %s\n",contador,team.identity());
                contador++;
            }
            System.out.printf("%d -> Cancel Operation.\n",contador);
            option= Console.readInteger("Select Team.\n");
            while (option < 0 || option >= listToShow.size()){
                System.out.println("Invalid option. Try again.");
                option= Console.readInteger("Select Team.\n");
            }
            if (option==contador){
                System.out.println("Operation canceled");
                return true;
            }
            Team teamToAdd = listToShow.get(option);
            if (!theController.changeTeam(teamToAdd,collaborator,2).getId().isEmpty()){
                System.out.println("Collaborator was removed successfully from the team. Successful operation.");
                return true;
            } else {
                System.out.println("Something went wrong. Aborting operation.");
                return false;
            }

        } else if(option==3){
            System.out.println("Operation canceled");
            return true;
        }*/
        return true;
    }

    private boolean showCollaborators(Set<Collaborator> responsibleCollab) {
        // TODO we could also use the "widget" classes from the framework...
        final Menu collanoratorsMenu = buildCollaboratorsMenu(responsibleCollab);
        final MenuRenderer renderer = new VerticalMenuRenderer(collanoratorsMenu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildCollaboratorsMenu(Set<Collaborator> responsibleCollab) {
        final Menu collanoratorsMenu = new Menu();
        int counter = 0;
        collanoratorsMenu.addItem(MenuItem.of(counter++, "Back", Actions.SUCCESS));
        for (Collaborator collab : theController.listCollaborators()) {
            collanoratorsMenu.addItem(MenuItem.of(counter++, collab.toString(), () -> responsibleCollab.add(collab)));
        }
        return collanoratorsMenu;
    }

    private boolean showOptions(Set<Integer> options) {
        // TODO we could also use the "widget" classes from the framework...
        final Menu optionsMenu = buildOptionsMenu(options);
        final MenuRenderer renderer = new VerticalMenuRenderer(optionsMenu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildOptionsMenu(Set<Integer> options) {
        final Menu optionsMenu = new Menu();
        optionsMenu.addItem(MenuItem.of(0, "Cancel", Actions.SUCCESS));
        optionsMenu.addItem(MenuItem.of(1, "Add to a Team", () -> options.add(1)));
        optionsMenu.addItem(MenuItem.of(2, "Delete from a Team", () -> options.add(2)));
        return optionsMenu;
    }

    private boolean showTeams(final Set<Team> teams,int option, Collaborator collaborator) {
        final Menu teamsMenu = buidlTeamsMenu(teams, option,collaborator);
        final MenuRenderer renderer = new VerticalMenuRenderer(teamsMenu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buidlTeamsMenu(final Set<Team> teams,int option,Collaborator collaborator) {
        final Menu teamsMenu = new Menu();
        int counter = 0;
        teamsMenu.addItem(MenuItem.of(counter++, "Cancel", Actions.SUCCESS));
        for (Team team : theController.listTeams()) {
            if (option==1 && !team.getMembers().contains(collaborator)) {
                teamsMenu.addItem(MenuItem.of(counter++, team.identity().toString(), () -> teams.add(team)));
            } else if (option==2 && team.getMembers().contains(collaborator)){
                teamsMenu.addItem(MenuItem.of(counter++, team.identity().toString(), () -> teams.add(team)));
            }
        }
        return teamsMenu;
    }


    @Override
    public String headline() {
        return "Modify Collaborator's team";
    }
}
