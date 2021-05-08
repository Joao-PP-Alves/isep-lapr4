package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.collaboratormanagement.domain.Collaborator;
import eapli.base.collaboratormanagement.repositories.CollaboratorRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

class JpaCollaboratorRepository extends JpaAutoTxRepository<Collaborator, MecanographicNumber, MecanographicNumber>
implements CollaboratorRepository {

    public JpaCollaboratorRepository(TransactionalContext autoTx) {
        super(autoTx, "mecanographicNumber");
    }

    public JpaCollaboratorRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "mecanographicNumber");
    }

    @Override
    public Iterable<Collaborator> findAll(){
        return match("e.mecanographicNumber!= ");
    }

}