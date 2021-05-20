package eapli.base.service.application;

import eapli.base.service.domain.ApprovalTask;
import eapli.base.service.domain.Form;
import eapli.base.service.domain.KeyWord;
import eapli.base.service.domain.Service;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.base.taskspec.domain.TaskSpec;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Set;

@UseCaseController
public class AddServiceController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ServiceManagementService servSvc = new ServiceManagementService();

    public Service addService(String name, ServiceCatalog serviceCatalog, String shortDesc, String longDesc,
                              ApprovalTask approvalTask, Form form, TaskSpec taskSpec, String icon, Set<KeyWord> keyWords) {

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.ADMIN);

        return servSvc.registerNewService(name,serviceCatalog,shortDesc,longDesc,approvalTask,form,taskSpec,icon,keyWords);
    }
}
//Designation name, ServiceCatalog serviceCatalog, Set<KeyWord> keyWords, TaskSpec taskSpec,
//                   Description shortServiceDescription, Description longServiceDescription,Icon icon, ApprovalTask approvalTask,
//                   Form form
