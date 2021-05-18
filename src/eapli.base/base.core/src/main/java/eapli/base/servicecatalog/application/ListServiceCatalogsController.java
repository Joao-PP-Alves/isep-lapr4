package eapli.base.servicecatalog.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.service.domain.Service;
import eapli.base.service.repositories.ServiceRepository;
import eapli.base.servicecatalog.domain.AccessCriteria;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.base.servicecatalog.repositories.ServiceCatalogRepository;
import eapli.base.team.domain.Team;
import eapli.base.team.repository.TeamRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.List;

public class ListServiceCatalogsController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final RepositoryFactory rf = PersistenceContext.repositories();

    private ServiceCatalogRepository scr;
    private ServiceRepository sr;
    private TeamRepository tr;

    public List<ServiceCatalog> listTopServiceCatalogs(){
        List<ServiceCatalog> list = new ArrayList<>();
        scr = rf.serviceCatalogs();
        scr.findTopCatalogs().forEach(list::add);
        /*List<ServiceCatalog> aux = new ArrayList<>();
        for (ServiceCatalog sc : list){
            AccessCriteria ac = sc.getAccessCriteria();
            for (Team t : ac.getTeamsWithAccess()){
               // if (t.getMembers().contains());;
            }
        }*/
        return list;
    }



    public List<Service> listServicesFromCatalog(ServiceCatalog serviceCatalog){
        List<Service> list = new ArrayList<>();
        sr = rf.services();
        sr.findBelongingToCatalog(serviceCatalog).forEach(list::add);
        return list;
    }
}
