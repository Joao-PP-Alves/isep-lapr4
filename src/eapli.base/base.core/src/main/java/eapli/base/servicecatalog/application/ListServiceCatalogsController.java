package eapli.base.servicecatalog.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.base.servicecatalog.repositories.ServiceCatalogRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.List;

public class ListServiceCatalogsController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final RepositoryFactory rf = PersistenceContext.repositories();

    private ServiceCatalogRepository scr;

    public List<ServiceCatalog> listTopServiceCatalogs(){
        List<ServiceCatalog> list = new ArrayList<>();
        scr = rf.serviceCatalogs();
        scr.findTopCatalogs().forEach(list::add);
        return list;
    }
}
