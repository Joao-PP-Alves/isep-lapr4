package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.service.domain.ServiceDraft;
import eapli.base.service.repositories.ServiceDraftRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaServiceDraftRepository extends JpaAutoTxRepository<ServiceDraft,Long,Long> implements ServiceDraftRepository {

    public JpaServiceDraftRepository(TransactionalContext autoTx) {
        super(autoTx, "draftId");
    }

    public JpaServiceDraftRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "draftId");
    }
}
