package eapli.base.service.application;

import eapli.base.service.domain.*;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.base.service.domain.TaskSpec;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Set;

@UseCaseController
public class AddServiceDraftController {


    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ServiceDraftManagementService servSvc = new ServiceDraftManagementService();

    public ServiceDraft addServiceDraft(String name, ServiceCatalog serviceCatalog, String shortDesc, String longDesc,
                                   ApprovalTask approvalTask, Form form, TaskSpec taskSpec, String icon, Set<KeyWord> keyWords, boolean complete) {

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.ADMIN);
        return servSvc.registerNewServiceDraft(name, serviceCatalog, shortDesc, longDesc, approvalTask, form, taskSpec, icon,keyWords, complete);
    }
}
