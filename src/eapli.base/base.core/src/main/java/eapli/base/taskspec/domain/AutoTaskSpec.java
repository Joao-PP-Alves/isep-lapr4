package eapli.base.taskspec.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("Automatic")
@Entity
public class AutoTaskSpec extends TaskSpec{

    private String designation;
    private Script script;

    public AutoTaskSpec(String designation, Script script) {
        super();
        this.designation = designation;
        this.script = script;
    }

    protected AutoTaskSpec(){}

    public Script getScript() {
        return script;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setScript(Script script) {
        this.script = script;
    }

    public String getDesignation() {
        return designation;
    }
}
