package eapli.base.taskspec.repositories;

import eapli.base.taskspec.domain.ManualTaskSpec;
import eapli.framework.domain.repositories.DomainRepository;

public interface ManualTaskSpecRepository extends DomainRepository<Long, ManualTaskSpec> {

    Iterable<ManualTaskSpec> findAllManualTasksSpec();
}
