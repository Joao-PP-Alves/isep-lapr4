package eapli.base.persistence.impl.jpa;


import eapli.base.Application;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.service.domain.Service;
import eapli.base.service.repositories.ServiceRepository;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaServiceRepository extends JpaAutoTxRepository<Service, Long, Long>
implements ServiceRepository {

    public JpaServiceRepository(TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaServiceRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    public Iterable<Service> findAll(){
        return this.repo.findAll();
    }

    @Override
    public Iterable<Service> findBelongingToCatalog(ServiceCatalog serviceCatalog) {
        return match("e.serviceCatalog == serviceCatalog");
    }
}
