package eapli.base.taskspec.domain;

import eapli.base.service.domain.Form;
import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Designation;

public class ManualTaskSpecBuilder implements DomainFactory<ManualTaskSpec> {

    private Designation manualTaskSpecId;
    private Form form;


    public ManualTaskSpecBuilder() {
    }

    @Override
    public ManualTaskSpec build() {
        return new ManualTaskSpec(this.manualTaskSpecId, this.form);
    }

    public ManualTaskSpecBuilder with(String id, Form form) {
        this.withId(id);
        this.withForm(form);
        return this;
    }


    public ManualTaskSpecBuilder withId(final String id) {
        if (id!= null)
            this.manualTaskSpecId = Designation.valueOf(id);
        return this;
    }

    public ManualTaskSpecBuilder withForm (final Form form){
        if (form!= null)
            this.form = form;
        return this;
    }

}

