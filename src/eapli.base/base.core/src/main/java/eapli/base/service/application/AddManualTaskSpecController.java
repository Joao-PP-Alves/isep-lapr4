package eapli.base.service.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.service.domain.Field;
import eapli.base.service.domain.Form;
import eapli.base.servicecatalog.domain.AccessCriteria;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.base.service.domain.ManualTaskSpec;
import eapli.base.service.domain.Script;
import eapli.base.team.domain.Team;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

@UseCaseController
public class AddManualTaskSpecController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();



    public ManualTaskSpec addManualTaskSpec(String taskSpecId, Form form) {

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.ADMIN);
        //TODO add BaseRoles.HELP_SERV_MANAGER or other

        if (taskSpecId != null && form != null)
            return new ManualTaskSpec(taskSpecId, form);
        return null;
    }

    public String makeStringFromFile(String sc){
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            String ls = System.getProperty("line.separator");
            BufferedReader rdr = new BufferedReader(new FileReader(sc));
            while ((line = rdr.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            rdr.close();
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            return stringBuilder.toString();
        } catch (IOException io){
            System.out.println(io);
            return "INVALID FILE PATH";
        }
    }


    public Form createForm(String formName, Set<Field> fieldSet, Script script) {
        return new Form(Designation.valueOf(formName), fieldSet, script);
    }
}
