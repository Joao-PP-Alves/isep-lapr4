package eapli.base.service.domain;

import javax.persistence.*;

@DiscriminatorValue("Manual")
@Entity
public class ManualTaskSpec extends TaskSpec {

    private String designation;

    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    private Form form;


    protected ManualTaskSpec() {
    }

    public ManualTaskSpec(Form form) {
        if (form != null) {
            this.form = form;
        }
    }

    public ManualTaskSpec(String taskSpecId, Form form) {
        super();
        if (form != null && taskSpecId != null) {
            this.form = form;
            this.designation = taskSpecId;
        }
    }

}
