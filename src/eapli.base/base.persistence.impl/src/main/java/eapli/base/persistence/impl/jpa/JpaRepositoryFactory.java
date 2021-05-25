package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.collaboratormanagement.repositories.CollaboratorRepository;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.service.repositories.ServiceDraftRepository;
import eapli.base.service.repositories.ServiceRepository;
import eapli.base.servicecatalog.repositories.ServiceCatalogRepository;
import eapli.base.taskspec.repositories.ManualTaskSpecRepository;
import eapli.base.team.repository.TeamRepository;
import eapli.base.teamtype.repository.TeamTypeRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.JpaAutoTxUserRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 *
 * Created by nuno on 21/03/16.
 */
public class JpaRepositoryFactory implements RepositoryFactory {

	@Override
	public UserRepository users(final TransactionalContext autoTx) {
		return new JpaAutoTxUserRepository(autoTx);
	}

	@Override
	public UserRepository users() {
		return new JpaAutoTxUserRepository(Application.settings().getPersistenceUnitName(),
				Application.settings().getExtendedPersistenceProperties());
	}


	@Override
	public JpaClientUserRepository clientUsers(final TransactionalContext autoTx) {
		return new JpaClientUserRepository(autoTx);
	}

	@Override
	public JpaClientUserRepository clientUsers() {
		return new JpaClientUserRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public SignupRequestRepository signupRequests(final TransactionalContext autoTx) {
		return new JpaSignupRequestRepository(autoTx);
	}

	@Override
	public SignupRequestRepository signupRequests() {
		return new JpaSignupRequestRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public CollaboratorRepository collaborators(TransactionalContext autoTx) {
		return new JpaCollaboratorRepository(autoTx);
	}

	@Override
	public CollaboratorRepository collaborators() {
		return new JpaCollaboratorRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public TeamRepository teams(TransactionalContext autoTx) {
		return new JpaTeamRepository(autoTx);
	}

	@Override
	public TeamRepository teams() {
		return new JpaTeamRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public TeamTypeRepository teamTypes(TransactionalContext autoTx) {
		return new JpaTeamTypeRepository(autoTx);
	}

	@Override
	public TeamTypeRepository teamTypes() {
		return new JpaTeamTypeRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public ServiceRepository services(TransactionalContext autoTx) {
		return new JpaServiceRepository(autoTx);
	}

	@Override
	public ServiceRepository services() {
		return new JpaServiceRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public ServiceCatalogRepository serviceCatalogs(TransactionalContext autoTx) {
		return new JpaServiceCatalogRepository(autoTx);
	}

	@Override
	public ServiceCatalogRepository serviceCatalogs() {
		return new JpaServiceCatalogRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public ServiceDraftRepository servicesDraft(TransactionalContext autoTx) {
		return null;
	}

	@Override
	public ServiceDraftRepository servicesDraft() {
		return null;
	}

	@Override
	public ManualTaskSpecRepository manualTasksSpec(TransactionalContext autoTx) {
		return null;
	}

	@Override
	public ManualTaskSpecRepository manualTasksSpec() {
		return null;
	}


	@Override
	public TransactionalContext newTransactionalContext() {
		return JpaAutoTxRepository.buildTransactionalContext(Application.settings().getPersistenceUnitName(),
				Application.settings().getExtendedPersistenceProperties());
	}


}
