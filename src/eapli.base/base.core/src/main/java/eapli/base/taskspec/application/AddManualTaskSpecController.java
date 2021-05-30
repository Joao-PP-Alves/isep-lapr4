package eapli.base.taskspec.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.service.domain.Field;
import eapli.base.service.domain.Form;
import eapli.base.servicecatalog.domain.AccessCriteria;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.base.taskspec.domain.ManualTaskSpec;
import eapli.base.taskspec.domain.Script;
import eapli.base.taskspec.domain.TaskSpec;
import eapli.base.team.domain.Team;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Set;

@UseCaseController
public class AddManualTaskSpecController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ManualTaskSpecManagementService manTaskSpecSvc = new ManualTaskSpecManagementService();
    private final RepositoryFactory rf = PersistenceContext.repositories();



    public TaskSpec addManualTaskSpec(String taskSpecId, Form form) {

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.ADMIN);
        //TODO add BaseRoles.HELP_SERV_MANAGER or other
        return manTaskSpecSvc.registerNewManualTaskSpec(taskSpecId, form);
    }


    public void manageAccessCriteria(ServiceCatalog sc, Set<Team> list){
        sc.setAccessCriteria(new AccessCriteria(list));
    }

    public Form createForm(String formName, Set<Field> fieldSet, Script script) {
        return new Form(Designation.valueOf(formName), fieldSet, script);
    }
}
