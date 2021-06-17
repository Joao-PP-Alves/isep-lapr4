package eapli.base.servicecatalog.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.base.service.domain.Service;
import eapli.base.team.domain.Team;
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

    @Version
    private Long version;

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
    @ManyToOne
    @Nullable
    private ServiceCatalog topCatalog;

    @JsonProperty
    @XmlElement
    private AccessCriteria accessCriteria;

    public ServiceCatalog(Designation title, Description shortDescription, Icon icon, Description longDescription,
                          ServiceCatalog serviceCatalogs){
        this.title=title;
        this.shortDescription=shortDescription;
        this.longDescription=longDescription;
        this.topCatalog=serviceCatalogs;
        this.icon=icon;
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
    public ServiceCatalog getTopCatalog() {
        return this.topCatalog;
    }

    public boolean isTopCatalog(){
        if (this.topCatalog == null){
            return true;
        } else {
            return false;
        }
    }

    public void setAccessCriteria(AccessCriteria accessCriteria) {
        this.accessCriteria = accessCriteria;
    }

    public AccessCriteria getAccessCriteria() {
        return accessCriteria;
    }

    @Override
    public Long identity() {
        return this.id;
    }

    @Override
    public boolean hasIdentity(Long otherId) {
        return otherId.equals(this.identity());
    }

    public boolean checkIfTeamHasAccess(Team team) {
        for (Team t : accessCriteria.getTeamsWithAccess()) {
            if (t.equals(team)) {
                return true;
            }
        }
        return false;
    }
}
