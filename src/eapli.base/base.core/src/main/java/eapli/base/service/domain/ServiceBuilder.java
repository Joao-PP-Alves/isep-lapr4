package eapli.base.service.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.collaboratormanagement.domain.CollaboratorBuilder;
import eapli.base.collaboratormanagement.domain.FullName;
import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Designation;

public class ServiceBuilder implements DomainFactory<Service> {

    private MecanographicNumber id;
    private Designation name;

    public ServiceBuilder(){}

    @Override
    public Service build() {
       return new Service(name);
    }

    public ServiceBuilder withName(final Designation name) {
        this.name = name;
        return this;
    }

    public ServiceBuilder withId(final MecanographicNumber id) {
        this.id = id;
        return this;
    }

    public ServiceBuilder with(Designation name, MecanographicNumber id){
        this.withId(id);
        this.withName(name);
        return this;
    }
}
