package eapli.base.servicecatalog.application;

import eapli.base.service.domain.Service;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Set;

@UseCaseController
public class AddServiceCatalogController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ServiceCatalogManagementService servCatSvc = new ServiceCatalogManagementService();

    public ServiceCatalog addServiceCatalog(String title, String shortDescription, String longDescription, String icon,
                                            Set<ServiceCatalog> subCatalogs, Set<Service> listServices, boolean topCatalog) {

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN);

        return servCatSvc.registerNewServiceCatalog(title, shortDescription, longDescription, icon,
                subCatalogs, listServices, topCatalog);
    }
}
