package eapli.base.collaboratormanagement.application;

import eapli.base.collaboratormanagement.domain.*;
import eapli.base.collaboratormanagement.repositories.CollaboratorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.team.domain.Team;
import eapli.base.team.repository.TeamRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ModifyCollaboratorTeamController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final RepositoryFactory rf = PersistenceContext.repositories();
    private CollaboratorRepository cr;
    private TeamRepository tr;

    public List<Collaborator> listCollaborators(){
        List<Collaborator> list = new ArrayList<>();
        cr = rf.collaborators();
        cr.findAll().forEach(list::add);
        return list;
    }

    public List<Team> listTeams(){
        List<Team> list = new ArrayList<>();
        tr = rf.teams();
        tr.findAll().forEach(list::add);
        return list;
    }

    public Team changeTeam(Team team, Collaborator col, int option) {
        Set<Collaborator> collaboratorSet = team.getMembers();
        if (option ==1){
            collaboratorSet.add(col);
        } else if(option==2){
            collaboratorSet.remove(col);
        }
        team.setMembers(collaboratorSet);
        return tr.save(team);
    }

}
