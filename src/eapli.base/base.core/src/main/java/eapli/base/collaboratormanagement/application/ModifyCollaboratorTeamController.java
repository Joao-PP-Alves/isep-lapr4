package eapli.base.collaboratormanagement.application;

import eapli.base.collaboratormanagement.domain.*;
import eapli.base.team.domain.Team;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.List;

public class ModifyCollaboratorTeamController {

    private final Collaborator collaborator = new Collaborator();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    public List<Collaborator> listCollaborators(){

        return new ArrayList<Collaborator>();
    }

    public List<Team> listTeams(){
        return new ArrayList<Team>();
    }

    public boolean changeTeam(Team team, Collaborator col){return true;}
}
