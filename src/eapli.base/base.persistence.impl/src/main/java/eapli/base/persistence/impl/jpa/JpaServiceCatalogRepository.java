package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.base.servicecatalog.repositories.ServiceCatalogRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaServiceCatalogRepository extends JpaAutoTxRepository<ServiceCatalog, Long, Long>
        implements ServiceCatalogRepository {

    public JpaServiceCatalogRepository(TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaServiceCatalogRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    @Override
    public Iterable<ServiceCatalog> findTopCatalogs() {
        return match("e.topCatalog == true");
    }
}
