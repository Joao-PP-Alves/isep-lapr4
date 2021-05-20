package eapli.base.taskspec.domain;

import eapli.base.service.domain.Form;

import javax.persistence.Embeddable;

@Embeddable
public class ManualTaskSpec extends TaskSpec{

    private Form form;

    protected ManualTaskSpec(){}

    public ManualTaskSpec(Form form){
        if (form != null){
            this.form = form;
        }
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public Form getForm() {
        return form;
    }
}
