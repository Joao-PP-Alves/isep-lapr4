package eapli.base.taskspec.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Script {

    private String script;

    public Script(String script){
        this.script = script;
    }

    protected Script(){}

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }
}
