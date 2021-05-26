package eapli.base.taskspec.domain;

import eapli.base.service.domain.Form;

import javax.persistence.*;

@Entity
public class ManualTaskSpec extends TaskSpec{

    private String designation;
    private Form form;


    protected ManualTaskSpec(){}

    public ManualTaskSpec(Form form){
        if (form != null){
            this.form = form;
        }
    }

    public ManualTaskSpec(String taskSpecId, Form form){
        super();
        if (form != null && taskSpecId != null){
            this.form = form;
            this.designation = taskSpecId;
        }
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public Form getForm() {
        return form;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }
}
