package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.service.domain.Service;
import eapli.base.service.repositories.ServiceRepository;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.base.servicecatalog.repositories.ServiceCatalogRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaServiceCatalogRepository extends JpaAutoTxRepository<ServiceCatalog, MecanographicNumber, MecanographicNumber>
        implements ServiceCatalogRepository {

    public JpaServiceCatalogRepository(TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaServiceCatalogRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }
}
