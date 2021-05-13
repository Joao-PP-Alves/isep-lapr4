package eapli.base.service.domain;

import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Designation;

public class ServiceBuilder implements DomainFactory<Service> {

    private Long id;
    private Designation name;
    private ServiceCatalog serviceCatalog;

    public ServiceBuilder() {
    }

    @Override
    public Service build() {
        return new Service(this.name, this.serviceCatalog);
    }

    public ServiceBuilder with(String name, ServiceCatalog serviceCatalog) {
        this.withName(name);
        this.withServiceCatalog(serviceCatalog);
        return this;
    }

    public ServiceBuilder with(String id, String name, ServiceCatalog serviceCatalog) {
        this.withId(id);
        this.withName(name);
        this.withServiceCatalog(serviceCatalog);

        return this;
    }

    public ServiceBuilder withName(final String name) {
        this.name = Designation.valueOf(name);
        return this;
    }

    public ServiceBuilder withId(final String id) {
        this.id = Long.valueOf(id);
        return this;
    }

    public ServiceBuilder withServiceCatalog(final ServiceCatalog sc){
        if (sc!=null)
            this.serviceCatalog = sc;
        return this;
    }
}
