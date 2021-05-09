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

    public ServiceBuilder with(String id, String name){
        this.withId(id);
        this.withName(name);
        return this;
    }

    public ServiceBuilder withName(final String name) {
        this.name = Designation.valueOf(name);
        return this;
    }

    public ServiceBuilder withId(final String id) {
        this.id = MecanographicNumber.valueOf(id);
        return this;
    }
}
