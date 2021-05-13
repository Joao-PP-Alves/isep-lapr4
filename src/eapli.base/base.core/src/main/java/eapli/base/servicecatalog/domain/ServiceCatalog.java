package eapli.base.servicecatalog.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.base.service.domain.Service;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement
@Entity
public class ServiceCatalog implements AggregateRoot<Long> {

    @JsonProperty
    @XmlElement
    @Id
    @GeneratedValue
    private Long id;

    @JsonProperty
    @XmlElement
    private Designation title;

    @JsonProperty
    @XmlElement
    @AttributeOverride(name = "value", column = @Column(name = "shortDescription"))
    private Description shortDescription;

    @JsonProperty
    @XmlElement
    @AttributeOverride(name = "value", column = @Column(name = "longDescription"))
    private Description longDescription;

    @JsonProperty
    @XmlElement
    private Icon icon;

    @JsonProperty
    @XmlElement
    @OneToMany
    @Nullable
    private Set<ServiceCatalog> listSubCatalogs;

    @JsonProperty
    @XmlElement
    private boolean topCatalog;

    public ServiceCatalog(Designation title, Description shortDescription, Icon icon, Description longDescription,
                          Set<ServiceCatalog> serviceCatalogs, boolean topCatalog){
        this.title=title;
        this.shortDescription=shortDescription;
        this.longDescription=longDescription;
        this.listSubCatalogs=serviceCatalogs;
        this.icon=icon;
        this.topCatalog = topCatalog;
    }

    public ServiceCatalog() {
        //
    }

    @Override
    public boolean sameAs(Object other) {
        ServiceCatalog sc = (ServiceCatalog) other;
        return sc.identity().equals(this.identity());
    }

    @Override
    public int compareTo(Long other) {
        if (other.equals(this.identity())){
            return 1;
        }
        return -1;
    }

    public Designation getTitle() {
        return title;
    }

    @Nullable
    public Set<ServiceCatalog> getListSubCatalogs() {
        return listSubCatalogs;
    }

    public boolean isTopCatalog() {
        return topCatalog;
    }

    @Override
    public Long identity() {
        return this.id;
    }

    @Override
    public boolean hasIdentity(Long otherId) {
        return otherId.equals(this.identity());
    }
}
