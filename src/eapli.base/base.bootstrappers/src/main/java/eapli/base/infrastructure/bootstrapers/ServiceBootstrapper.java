package eapli.base.infrastructure.bootstrapers;

import eapli.base.service.application.AddServiceController;
import eapli.base.service.domain.*;
import eapli.base.servicecatalog.application.AddServiceCatalogController;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.base.taskspec.application.AddManualTaskSpecController;
import eapli.base.taskspec.domain.TaskSpec;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class ServiceBootstrapper implements Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceBootstrapper.class);

    private static final String SERVICE_NAME1 = "Do this.";
    private static final String SERVICE_NAME2 = "Do that.";

    private static final String SERVICE_CATALOG_TITLE1 = "Done this.";
    private static final String SERVICE_CATALOG_TITLE2 = "Done that.";

    private static final String SERVICE_CATALOG_SHORTDESC1 = "Hmm...";
    private static final String SERVICE_CATALOG_SHORTDESC2 = "Hmm...";

    private static final String SERVICE_CATALOG_LONGDESC1 = "HmmHmm...";
    private static final String SERVICE_CATALOG_LONGDESC2 = "HmmHmm...";

    private static final String SERVICE_CATALOG_ICON1 = "Icon1";
    private static final String SERVICE_CATALOG_ICON2 = "Icon2";

    private static final String MANUAL_TASK_SPEC_ID = "Manual Task Spec Bootstrapped";
    private static final String DESIGNATION = "Bootstrapped Form";


    final AddServiceController addServController = new AddServiceController();
    final AddServiceCatalogController addServCatController = new AddServiceCatalogController();
    final AddManualTaskSpecController addManualTaskSpecController = new AddManualTaskSpecController();

    @Override
    public boolean execute() {

        ServiceCatalog servCat1 = registerServiceCatalog(SERVICE_CATALOG_TITLE1, SERVICE_CATALOG_SHORTDESC1,
                SERVICE_CATALOG_LONGDESC1, SERVICE_CATALOG_ICON1, null);

        ServiceCatalog servCat2 = registerServiceCatalog(SERVICE_CATALOG_TITLE2, SERVICE_CATALOG_SHORTDESC2,
                SERVICE_CATALOG_LONGDESC2, SERVICE_CATALOG_ICON2,null);

        ApprovalTask approvalTask = new ApprovalTask(true);
        Set<Field> fields = new HashSet<>();
        Field field1 = new Field(new RegularExpression("(Test)"), "bootstrapper field",
                Description.valueOf("helpDescription"), new PresentationTicket("bootstrapper Pres. Ticket"),
                DataTypesAllowed.STRING);
        fields.add(field1);
        Form form = new Form(Designation.valueOf(DESIGNATION),  fields);
        TaskSpec manualTaskSpec = registerManualTaskSpec(MANUAL_TASK_SPEC_ID, form);

        Set<KeyWord> keyWords = new HashSet<>();
        keyWords.add(new KeyWord("keyWord1 Test"));
        keyWords.add(new KeyWord("keyWord2 Test"));


        registerService("Bootstrapped Service1", servCat1, "Service1(boot)",
                "Service 1 long description bootstrapped", approvalTask, form, manualTaskSpec,
                "test Icon", keyWords);
        return false;

    }

    private Service registerService(String name, ServiceCatalog serviceCatalog, String shortDesc, String longDesc,
                                    ApprovalTask approvalTask, Form form, TaskSpec taskSpec, String icon, Set<KeyWord> keyWords) {

        try {
            Service serv = addServController.addService(name,serviceCatalog,shortDesc,longDesc,approvalTask,form,taskSpec,icon,keyWords);
            LOGGER.info(name);
            return serv;

        } catch (final IntegrityViolationException | ConcurrencyException ex) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming the team already exists (activate trace log for details)", name);
            LOGGER.trace("Assuming existing record", ex);
            return null;
        }
    }

    private ServiceCatalog registerServiceCatalog(String title, String shortDescription, String longDescription, String icon,
                                                  ServiceCatalog topCatalog) {

        try {
            ServiceCatalog servCat = addServCatController.addServiceCatalog(title, shortDescription, longDescription, icon, topCatalog);
            LOGGER.info(title);

            return servCat;

        } catch (final IntegrityViolationException | ConcurrencyException ex) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming the team already exists (activate trace log for details)", title);
            LOGGER.trace("Assuming existing record", ex);
            return null;
        }
    }

    private TaskSpec registerManualTaskSpec(String manTaskSpecId, Form form) {

        try {
            TaskSpec manualTaskSpec = addManualTaskSpecController.addManualTaskSpec(manTaskSpecId, form);
            LOGGER.info(manTaskSpecId);
            return manualTaskSpec;

        } catch (final IntegrityViolationException | ConcurrencyException ex) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming the Manual Task Spec already exists (activate trace log for details)", manTaskSpecId);
            LOGGER.trace("Assuming existing record", ex);
            return null;
        }
    }
}
