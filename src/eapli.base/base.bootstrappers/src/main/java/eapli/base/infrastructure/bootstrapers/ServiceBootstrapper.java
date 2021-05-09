package eapli.base.infrastructure.bootstrapers;

import eapli.base.service.application.AddServiceController;
import eapli.base.service.domain.Service;
import eapli.base.servicecatalog.application.AddServiceCatalogController;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
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


    final AddServiceController addServController = new AddServiceController();
    final AddServiceCatalogController addServCatController = new AddServiceCatalogController();

    @Override
    public boolean execute() {

        Service serv1 = registerService(SERVICE_NAME1);
        Service serv2 = registerService(SERVICE_NAME2);

        if (serv1 != null && serv2 != null) {

            Set<Service> listServices1 = new HashSet<>();
            listServices1.add(serv1);

            Set<Service> listServices2 = new HashSet<>();
            listServices1.add(serv2);

            ServiceCatalog servCat1 = registerServiceCatalog(SERVICE_CATALOG_TITLE1, SERVICE_CATALOG_SHORTDESC1,
                    SERVICE_CATALOG_LONGDESC1, SERVICE_CATALOG_ICON1, new HashSet<>(), listServices1, false);

            if (servCat1 != null) {

                Set<ServiceCatalog> listServCatalogs = new HashSet<>();
                listServCatalogs.add(servCat1);

                ServiceCatalog servCat2 = registerServiceCatalog(SERVICE_CATALOG_TITLE2, SERVICE_CATALOG_SHORTDESC2,
                        SERVICE_CATALOG_LONGDESC2, SERVICE_CATALOG_ICON2, listServCatalogs, listServices2, true);

                return true;
            }
        }
        return false;
    }

    private Service registerService(String name) {

        try {
            Service serv = addServController.addService(name);
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
                                                  Set<ServiceCatalog> subCatalogs, Set<Service> listServices, boolean topCatalog) {

        try {
            ServiceCatalog servCat = addServCatController.addServiceCatalog(title, shortDescription, longDescription, icon,
                    subCatalogs, listServices, topCatalog);
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
}
