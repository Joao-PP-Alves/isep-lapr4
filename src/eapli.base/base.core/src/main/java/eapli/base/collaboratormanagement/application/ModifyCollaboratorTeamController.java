package eapli.base.collaboratormanagement.application;

import eapli.base.collaboratormanagement.domain.*;
import eapli.base.collaboratormanagement.repository.CollaboratorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.team.domain.Team;
import eapli.base.teamtype.repository.TeamRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import java.util.List;

public class ModifyCollaboratorTeamController {

    private final Collaborator collaborator = new Collaborator();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final RepositoryFactory rf = PersistenceContext.repositories();
    private CollaboratorRepository cr;

    public List<Collaborator> listCollaborators(){
        cr = rf.collaborators();
        return cr.all();
    }

    public List<Team> listTeams(){
        TeamRepository tr = rf.teams();
        return tr.all();
    }

    public Collaborator changeTeam(Team team, Collaborator col) {
        col.setTeam(team.identity());
        return cr.save(col);
    }

    public Collaborator changeTeam(Collaborator col) {
        col.setTeam(null);
        return cr.save(col);
    }


}
