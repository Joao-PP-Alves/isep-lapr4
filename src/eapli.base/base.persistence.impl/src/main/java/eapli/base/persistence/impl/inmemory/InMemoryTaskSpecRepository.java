package eapli.base.persistence.impl.inmemory;

import eapli.base.taskspec.domain.TaskSpec;
import eapli.base.taskspec.repositories.TaskSpecRepository;
import eapli.base.team.domain.Team;
import eapli.base.team.repository.TeamRepository;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryTaskSpecRepository extends InMemoryDomainRepository<TaskSpec, Long>
implements TaskSpecRepository {

    static {
        InMemoryInitializer.init();
    }

}
