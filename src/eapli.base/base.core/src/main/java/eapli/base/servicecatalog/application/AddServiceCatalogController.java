package eapli.base.servicecatalog.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.servicecatalog.domain.AccessCriteria;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.base.servicecatalog.repositories.ServiceCatalogRepository;
import eapli.base.team.domain.Team;
import eapli.base.team.repository.TeamRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@UseCaseController
public class AddServiceCatalogController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ServiceCatalogManagementService servCatSvc = new ServiceCatalogManagementService();
    private final RepositoryFactory rf = PersistenceContext.repositories();
    private ServiceCatalogRepository scr;
    private TeamRepository tr;

    public ServiceCatalog addServiceCatalog(String title, String shortDescription, String longDescription, String icon,
                                            ServiceCatalog topCatalog) {

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.ADMIN);
        //TODO add BaseRoles.HELP_SERV_MANAGER
        return servCatSvc.registerNewServiceCatalog(title, shortDescription, longDescription, icon, topCatalog);
    }

    public List<ServiceCatalog> listAllCatalogs() {
        List<ServiceCatalog> list = new ArrayList<>();
        scr = rf.serviceCatalogs();
        scr.findAll().forEach(list::add);
        return list;
    }

    public Iterable<Team> getTeams() {
        List<Team> list = new ArrayList<>();
        tr = rf.teams();
        tr.findAll().forEach(list::add);
        return list;
    }

    public ServiceCatalog manageAccessCriteria(ServiceCatalog sc, Set<Team> list) {
        sc.defineAccessCriteria(new AccessCriteria(list));
        return servCatSvc.updateServiceCatalog(sc);
    }

}
