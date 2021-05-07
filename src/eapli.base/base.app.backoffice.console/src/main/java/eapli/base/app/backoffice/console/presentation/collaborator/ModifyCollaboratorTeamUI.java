package eapli.base.app.backoffice.console.presentation.collaborator;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.collaboratormanagement.application.*;
import eapli.base.collaboratormanagement.domain.Collaborator;
import eapli.base.team.domain.Team;
import eapli.base.team.domain.TeamId;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.List;

public class ModifyCollaboratorTeamUI extends AbstractUI {

    private final ModifyCollaboratorTeamController theController = new ModifyCollaboratorTeamController();

    @Override
    protected boolean doShow() {
        ArrayList<Collaborator> arrayList = (ArrayList<Collaborator>) theController.listCollaborators();
        int contador=0;
        for (Collaborator coll:arrayList){
            System.out.printf("%d - %s - %s\n",contador,coll.user().name().toString(),coll.identity());
            contador++;
        }
        int option= Console.readInteger("Select option.\n");
        Collaborator collaborator = arrayList.get(option);
        TeamId collaboratorTeam = collaborator.getTeamId();
        if (collaboratorTeam==null){
            System.out.println("This Collaborator doesn't belong to a team.");
            option = Console.readInteger("Add Collaborator to a team? (1-Yes | 2-No)\n");
            if (option==1){
                ArrayList<Team> listTeams = (ArrayList<Team>) theController.listTeams();
                contador=0;
                for (Team team:listTeams){
                    System.out.printf("%d - %s\n",contador,team.identity());
                    contador++;
                }
                option= Console.readInteger("Select option.\n");
                Team team = listTeams.get(option);
                if (!team.equals(new Team())){
                    if (!theController.changeTeam(team,collaborator).mecanographicNumber().toString().equals(new MecanographicNumber().toString())){
                        System.out.println("Collaborator was removed successfully from the team. Successful operation.");
                    } else {
                        System.out.println("Something went wrong. Aborting operation.");
                    }
                } else {
                    System.out.println("Invalid option. Canceling operation.");
                }
            } else {
                System.out.println("Collaborator wasn't added. Aborting operation.");
            }
        } else {
            System.out.println("This Collaborator belongs to a team.");
            option = Console.readInteger("Remove him from the team? (1-Yes | 2-No)\n");
            if (option==1){
                if (!theController.changeTeam(collaborator).mecanographicNumber().toString().equals(new MecanographicNumber().toString())) {
                    System.out.println("Collaborator was removed successfully from the team. Successful operation.");
                } else {
                    System.out.println("Something went wrong. Aborting operation.");
                }
            } else {
                System.out.println("Collaborator wasn't added. Aborting operation.");
            }

        }
        return true;
    }

    @Override
    public String headline() {
        return "Modify Collaborator's team";
    }
}
