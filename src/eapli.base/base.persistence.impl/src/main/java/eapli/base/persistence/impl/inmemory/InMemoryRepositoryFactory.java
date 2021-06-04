package eapli.base.persistence.impl.inmemory;

import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.collaboratormanagement.repositories.CollaboratorRepository;
import eapli.base.infrastructure.bootstrapers.BaseBootstrapper;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.service.repositories.ServiceRepository;
import eapli.base.servicecatalog.repositories.ServiceCatalogRepository;
import eapli.base.team.repository.TeamRepository;
import eapli.base.teamtype.repository.TeamTypeRepository;
import eapli.base.ticket.repositories.TicketRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.InMemoryUserRepository;

/**
 *
 * Created by nuno on 20/03/16.
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {

	static {
		// only needed because of the in memory persistence
		new BaseBootstrapper().execute();
	}

	@Override
	public UserRepository users(final TransactionalContext tx) {
		return new InMemoryUserRepository();
	}

	@Override
	public UserRepository users() {
		return users(null);
	}


	@Override
	public ClientUserRepository clientUsers(final TransactionalContext tx) {
		return new InMemoryClientUserRepository();
	}

	@Override
	public ClientUserRepository clientUsers() {
		return clientUsers(null);
	}

	@Override
	public SignupRequestRepository signupRequests() {
		return signupRequests(null);
	}

	@Override
	public CollaboratorRepository collaborators(TransactionalContext autoTx) {
		return new InMemoryCollaboratorRepository();
	}

	@Override
	public CollaboratorRepository collaborators() {
		return collaborators(null);
	}

	@Override
	public TeamRepository teams(TransactionalContext autoTx) {
		return new InMemoryTeamRepository();
	}

	@Override
	public TeamRepository teams() {
		return teams(null);
	}

	@Override
	public TeamTypeRepository teamTypes(TransactionalContext autoTx) {
		return new InMemoryTeamTypeRepository();
	}

	@Override
	public TeamTypeRepository teamTypes() {
		return teamTypes(null);
	}

	@Override
	public ServiceRepository services(TransactionalContext autoTx) {
		return new InMemoryServiceRepository();
	}

	@Override
	public ServiceRepository services() {
		return services(null);
	}

	@Override
	public ServiceCatalogRepository serviceCatalogs(TransactionalContext autoTx) {
		return new InMemoryServiceCatalogRepository();
	}

	@Override
	public ServiceCatalogRepository serviceCatalogs() {
		return serviceCatalogs(null);
	}

	@Override
	public TicketRepository tickets() {
		return tickets(null);
	}

	@Override
	public TicketRepository tickets(TransactionalContext autoTx) {
		return new InMemoryTicketRepository();
	}

	@Override
	public SignupRequestRepository signupRequests(final TransactionalContext tx) {
		return new InMemorySignupRequestRepository();
	}


	@Override
	public TransactionalContext newTransactionalContext() {
		// in memory does not support transactions...
		return null;
	}



}
