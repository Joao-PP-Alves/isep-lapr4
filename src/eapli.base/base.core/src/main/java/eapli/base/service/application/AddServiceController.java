package eapli.base.service.application;

import eapli.base.service.domain.Service;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

@UseCaseController
public class AddServiceController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ServiceManagementService servSvc = new ServiceManagementService();

    public Service addService(String name, ServiceCatalog sc) {

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.ADMIN);

        return servSvc.registerNewService(name,sc);
    }
}
