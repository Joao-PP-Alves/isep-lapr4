package eapli.base.service.domain;

import eapli.framework.general.domain.model.Designation;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("Automatic")
@Entity
public class AutoTaskSpec extends TaskSpec{

    private Designation designation;
    private Script script;

    public AutoTaskSpec(Designation designation, Script script) {
        super();
        this.designation = designation;
        this.script = script;
    }

    protected AutoTaskSpec(){}

    public Script getScript() {
        return script;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public void setScript(Script script) {
        this.script = script;
    }

    public Designation getDesignation() {
        return designation;
    }
}
