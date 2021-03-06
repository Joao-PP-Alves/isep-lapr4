/**
 *
 */
package eapli.base.infrastructure.persistence;

import eapli.base.clientusermanagement.repositories.ClientUserRepository;

import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.collaboratormanagement.repositories.CollaboratorRepository;
import eapli.base.service.repositories.ServiceRepository;
import eapli.base.servicecatalog.repositories.ServiceCatalogRepository;
import eapli.base.task.repositories.TaskRepository;
import eapli.base.team.repository.TeamRepository;
import eapli.base.teamtype.repository.TeamTypeRepository;
import eapli.base.ticket.repositories.TicketRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

/**
 * @author Paulo Gandra Sousa
 *
 */
public interface RepositoryFactory {

	/**
	 * factory method to create a transactional context to use in the repositories
	 *
	 * @return
	 */
	TransactionalContext newTransactionalContext();

	/**
	 *
	 * @param autoTx the transactional context to enrol
	 * @return
	 */
	UserRepository users(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	UserRepository users();

	/**
	 *
	 * @param autoTx the transactional context to enroll
	 * @return
	 */
	ClientUserRepository clientUsers(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	ClientUserRepository clientUsers();

	/**
	 *
	 * @param autoTx the transactional context to enroll
	 * @return
	 */
	SignupRequestRepository signupRequests(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	SignupRequestRepository signupRequests();

	/**
	 *
	 * @param autoTx the transactional context to enroll
	 * @return
	 */
	CollaboratorRepository collaborators(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	CollaboratorRepository collaborators();

	/**
	 *
	 * @param autoTx the transactional context to enroll
	 * @return
	 */
	TeamRepository teams(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	TeamRepository teams();

	/**
	 *
	 * @param autoTx the transactional context to enroll
	 * @return
	 */
	TeamTypeRepository teamTypes(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	TeamTypeRepository teamTypes();

	/**
	 *
	 * @param autoTx the transactional context to enroll
	 * @return
	 */
	ServiceRepository services(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	ServiceRepository services();

	/**
	 *
	 * @param autoTx the transactional context to enroll
	 * @return
	 */
	ServiceCatalogRepository serviceCatalogs(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	ServiceCatalogRepository serviceCatalogs();

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	TicketRepository tickets();

	/**
	 *
	 * @param autoTx the transactional context to enroll
	 * @return
	 */
	TicketRepository tickets(TransactionalContext autoTx);


	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	TaskRepository tasks();

	/**
	 *
	 * @param autoTx the transactional context to enroll
	 * @return
	 */
	TaskRepository tasks(TransactionalContext autoTx);
}
