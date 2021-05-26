package eapli.base.taskspec.application;

import eapli.base.taskspec.domain.AutoTaskSpec;
import eapli.base.taskspec.domain.Script;
import eapli.framework.application.UseCaseController;

@UseCaseController
public class AddAutoTaskSpecController {

    public AutoTaskSpec addAutoTaskSpec(String designation, Script script){
        return new AutoTaskSpec(designation,script);
    }

    public Script addScript(String script){
        return new Script(script);
    }
}
