package eapli.base.servicecatalog.domain;

import eapli.base.service.domain.Service;
import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;

import java.util.HashSet;
import java.util.Set;

public class ServiceCatalogBuilder implements DomainFactory<ServiceCatalog> {

    private Designation title;
    private Description shortDescription;
    private Description longDescription;
    private Icon icon;
    private Set<ServiceCatalog> listSubCatalogs = new HashSet<>();
    private boolean topCatalog;

    public ServiceCatalogBuilder() {
    }

    @Override
    public ServiceCatalog build() {

        ServiceCatalog servCat = new ServiceCatalog(this.title, this.shortDescription, this.icon,
                this.longDescription, this.listSubCatalogs, this.topCatalog);

        return servCat;
    }

    public ServiceCatalogBuilder with(String title, String shortDescription, String longDescription, String icon,
                                      Set<ServiceCatalog> listSubCatalogs, boolean topCatalog) {

        this.withTitle(title);
        this.withShortDescription(shortDescription);
        this.withLongDescription(longDescription);
        this.withIcon(icon);
        this.withSubCatalogs(listSubCatalogs);
        this.isTopCatalog(topCatalog);

        return this;
    }

    public ServiceCatalogBuilder withTitle(final String title) {
        this.title = Designation.valueOf(title);
        return this;
    }

    public ServiceCatalogBuilder withShortDescription(final String shortDescription) {
        this.shortDescription = Description.valueOf(shortDescription);
        return this;
    }

    public ServiceCatalogBuilder withLongDescription(final String longDescription) {
        this.longDescription = Description.valueOf(longDescription);
        return this;
    }

    public ServiceCatalogBuilder withIcon(final String icon) {
        this.icon = new Icon(icon);
        return this;
    }

    public ServiceCatalogBuilder withSubCatalogs(final Set<ServiceCatalog> listSubCatalogs) {
        this.listSubCatalogs = listSubCatalogs;
        return this;
    }

    public ServiceCatalogBuilder isTopCatalog(final boolean topCatalog) {
        this.topCatalog = topCatalog;
        return this;
    }
}
