package eapli.base.app.backoffice.console.presentation.collaborator;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.collaboratormanagement.application.*;
import eapli.base.collaboratormanagement.domain.Collaborator;
import eapli.base.team.domain.Team;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ModifyCollaboratorTeamUI extends AbstractUI {

    private final ModifyCollaboratorTeamController theController = new ModifyCollaboratorTeamController();

    @Override
    protected boolean doShow() {
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
        }
        return true;
    }

    @Override
    public String headline() {
        return "Modify Collaborator's team";
    }
}
