package eapli.base.service.application;

import eapli.base.grammars.EvalVisitor;
import eapli.base.grammars.FormValidator;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.service.domain.ApprovalTask;
import eapli.base.service.domain.Form;
import eapli.base.service.domain.KeyWord;
import eapli.base.service.domain.Service;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.base.servicecatalog.repositories.ServiceCatalogRepository;
import eapli.base.service.domain.TaskSpec;
import eapli.base.team.domain.Team;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@UseCaseController
public class AddServiceController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ServiceManagementService servSvc = new ServiceManagementService();
    private final RepositoryFactory rf = PersistenceContext.repositories();

    public Service addService(String name, ServiceCatalog serviceCatalog, String shortDesc, String longDesc,
                              ApprovalTask approvalTask, Form form, TaskSpec taskSpec, String icon, Set<KeyWord> keyWords) {

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.ADMIN);

        return servSvc.registerNewService(name,serviceCatalog,shortDesc,longDesc,approvalTask,form,taskSpec,icon,keyWords);
    }


    public String makeStringFromFile(String sc){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(sc));
            System.out.println(FormValidator.validation(sc));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            String ls = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            reader.close();

            return stringBuilder.toString();
        } catch (IOException io){
            System.out.println(io);
            return "INVALID FILE PATH";
        }
    }

    public List<ServiceCatalog> getCatalogs(){
        ServiceCatalogRepository scr = rf.serviceCatalogs();
        List<ServiceCatalog> list = new ArrayList<>();
        scr.findAll().forEach(list::add);
        return list;
    }


    public boolean verifyIfPossible(Service s){
        return s.verifyAttributes();
    }

    public void done(Service s){
        s.done();
        rf.services().save(s);
    }

    public List<ServiceCatalog> catalogsAccessedByTeam(){

        ServiceCatalogRepository scr = rf.serviceCatalogs();
        List<ServiceCatalog> list = new ArrayList<>();
        for (ServiceCatalog servCat : list) {
            Set<Team> teamsWithAccess = servCat.getAccessCriteria().getTeamsWithAccess();
            for (Team team : teamsWithAccess) {
                /*
                 TODO needs to check if collaborator has access criteria to service catalog
                if (team has access to service catalog) {
                    if (!list.has(servCat)) {
                        list.add(servCat)
                    }
                }

                */
            }

        }
        //scr.findAll().forEach(list::add);
        return list;
    }


}