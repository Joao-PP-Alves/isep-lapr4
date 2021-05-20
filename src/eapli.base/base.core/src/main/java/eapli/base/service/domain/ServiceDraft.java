package eapli.base.service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.base.servicecatalog.domain.Icon;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.base.taskspec.domain.TaskSpec;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;
import java.util.Set;

@Entity
public class ServiceDraft implements AggregateRoot<Long> {

    @XmlElement
    @JsonProperty
    @Id
    @GeneratedValue
    private Long draftId;

    @XmlElement
    @JsonProperty
    @AttributeOverride(name = "name", column = @Column(name = "draftName"))
    private Designation name;

    @XmlElement
    @JsonProperty
    @AttributeOverride(name = "value", column = @Column(name = "shortDraftDescription"))
    private Description shortServiceDescription;

    @XmlElement
    @JsonProperty
    @AttributeOverride(name = "value", column = @Column(name = "longDraftDescription"))
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
    private Form form;

    @JsonProperty
    @XmlElement
    private boolean complete;


    public ServiceDraft(Designation name, ServiceCatalog serviceCatalog, Set<KeyWord> keyWords, TaskSpec taskSpec,
                   Description shortServiceDescription, Description longServiceDescription,Icon icon, ApprovalTask approvalTask,
                   Form form, boolean complete){
        this.name = name;
        this.serviceCatalog = serviceCatalog;
        this.keyWords = keyWords;
        this.taskSpec = taskSpec;
        this.longServiceDescription = longServiceDescription;
        this.shortServiceDescription = shortServiceDescription;
        this.form = form;
        this.approvalTask = approvalTask;
        this.icon = icon;
        this.complete = complete;
    }

    public ServiceDraft(){
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
        return this.draftId;
    }

    @Override
    public boolean hasIdentity(Long otherId) {
        return otherId.equals(this.identity());
    }
}
