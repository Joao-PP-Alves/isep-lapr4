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

public class ModifyCollaboratorTeamController {

    private final Collaborator collaborator = new Collaborator();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final RepositoryFactory rf = PersistenceContext.repositories();
    private CollaboratorRepository cr;

    public List<Collaborator> listCollaborators(){
        List<Collaborator> list = new ArrayList<>();
        cr = rf.collaborators();
        cr.findAll().forEach(list::add);
        return list;
    }

    public List<Team> listTeams(){
        List<Team> list = new ArrayList<>();
        TeamRepository tr = rf.teams();
        tr.findAll().forEach(list::add);
        return list;
    }

    public Collaborator changeTeam(Team team, Collaborator col) {
        col.setTeam(team);
        return cr.save(col);
    }

    public Collaborator changeTeam(Collaborator col) {
        col.setTeam(null);
        return cr.save(col);
    }


}
