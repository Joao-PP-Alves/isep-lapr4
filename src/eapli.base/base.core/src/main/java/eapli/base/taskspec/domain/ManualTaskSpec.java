package eapli.base.taskspec.domain;

import eapli.base.service.domain.Form;
import eapli.framework.general.domain.model.Designation;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Entity
public class ManualTaskSpec extends TaskSpec{

    private Designation id;
    private Form form;

    protected ManualTaskSpec(){}

    public ManualTaskSpec(Form form){
        if (form != null){
            this.form = form;
        }
    }

    public ManualTaskSpec(Designation taskSpecId, Form form){
        if (form != null && taskSpecId != null){
            this.form = form;
            this.id = taskSpecId;
        }
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public Form getForm() {
        return form;
    }
}
