package eapli.base.service.application;

import eapli.base.grammars.EvalTaskScriptVisitor;
import eapli.base.grammars.TaskHandler;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.service.domain.AutoTaskSpec;
import eapli.base.service.domain.Script;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Designation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@UseCaseController
public class AddAutoTaskSpecController {

    public AutoTaskSpec addAutoTaskSpec(String designation, Script script){
        AutoTaskSpec autoTaskSpec = new AutoTaskSpec(Designation.valueOf(designation),script);
        return autoTaskSpec ;
    }

    public Script addScript(String script){
        String completeScript;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(script));
            TaskHandler.validation(script);
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            String ls = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            reader.close();

            completeScript = stringBuilder.toString();
            return new Script(completeScript);
        } catch (IOException io){
            System.out.println(io);
        }
        return null;
    }
}
