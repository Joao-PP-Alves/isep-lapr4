package eapli.base.service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.base.servicecatalog.domain.Icon;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;
import java.util.Set;

@XmlRootElement
@Entity
public class Service implements AggregateRoot<Long> {

    @XmlElement
    @JsonProperty
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long serviceId;

    @XmlElement
    @JsonProperty
    @AttributeOverride(name = "name", column = @Column(name = "serviceName"))
    private Designation name;

    @XmlElement
    @JsonProperty
    @AttributeOverride(name = "value", column = @Column(name = "shortServiceDescription"))
    private Description shortServiceDescription;

    @XmlElement
    @JsonProperty
    @AttributeOverride(name = "value", column = @Column(name = "longServiceDescription"))
    private Description longServiceDescription;

    @JsonProperty
    @XmlElement
    @ManyToOne
    private ServiceCatalog serviceCatalog;

    @JsonProperty
    @XmlElement
    @ElementCollection
    private Set<KeyWord> keyWords;

    @JsonProperty
    @XmlElement
    private Icon icon;

    @JsonProperty
    @XmlElement
    private ApprovalTask approvalTask;

    @XmlElement
    @JsonProperty
    @OneToOne
    private TaskSpec taskSpec;

    @JsonProperty
    @XmlElement
    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    private Form form;


    public Service(Designation name, ServiceCatalog serviceCatalog){
        if (name != null && serviceCatalog!= null){
            this.name=name;
            this.serviceCatalog = serviceCatalog;
        }
    }

    public Service(Designation name, ServiceCatalog serviceCatalog, Set<KeyWord> keyWords, TaskSpec taskSpec,
                   Description shortServiceDescription, Description longServiceDescription,Icon icon, ApprovalTask approvalTask,
                   Form form){
       this.name = Objects.requireNonNull(name);
       this.serviceCatalog = Objects.requireNonNull(serviceCatalog);
       this.keyWords = Objects.requireNonNull(keyWords);
       this.taskSpec = Objects.requireNonNull(taskSpec);
       this.longServiceDescription = Objects.requireNonNull(longServiceDescription);
       this.shortServiceDescription = Objects.requireNonNull(shortServiceDescription);
       this.form = Objects.requireNonNull(form);
       this.approvalTask = approvalTask;
       this.icon = icon;
    }

    public Service(){
        //
    }
    @Override
    public boolean sameAs(Object other) {
        Service se = (Service) other;
        return se.identity().equals(this.identity());
    }

    public ServiceCatalog getServiceCatalog() {
        return serviceCatalog;
    }

    @Override
    public int compareTo(Long other) {
        if (other.equals(this.identity())){
            return 1;
        }
        return -1;
    }

    public Designation getName() {
        return name;
    }


    @Override
    public Long identity() {
        return this.serviceId;
    }

    @Override
    public boolean hasIdentity(Long otherId) {
        return otherId.equals(this.identity());
    }
}
