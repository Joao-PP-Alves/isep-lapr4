package eapli.base.service.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.service.domain.AutoTaskSpec;
import eapli.base.service.domain.Script;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Designation;

@UseCaseController
public class AddAutoTaskSpecController {

    public AutoTaskSpec addAutoTaskSpec(String designation, Script script){
        AutoTaskSpec autoTaskSpec = new AutoTaskSpec(Designation.valueOf(designation),script);
        return autoTaskSpec ;
    }

    public Script addScript(String script){
        return new Script(script);
    }
}
