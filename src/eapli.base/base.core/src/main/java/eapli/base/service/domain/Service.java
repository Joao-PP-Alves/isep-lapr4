package eapli.base.service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.base.servicecatalog.domain.Icon;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import org.springframework.lang.Nullable;

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
    @Nullable
    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    private ApprovalTask approvalTask;

    @XmlElement
    @JsonProperty
    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    private TaskSpec taskSpec;

    @JsonProperty
    @XmlElement
    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    private Form form;

    @JsonProperty
    @XmlElement
    private boolean complete;

    public Service(Designation name, ServiceCatalog serviceCatalog, Set<KeyWord> keyWords, TaskSpec taskSpec,
                   Description shortServiceDescription, Description longServiceDescription, Icon icon, ApprovalTask approvalTask,
                   Form form) {
        this.name = name;
        this.serviceCatalog = serviceCatalog;
        this.keyWords = keyWords;
        this.taskSpec = taskSpec;
        this.longServiceDescription = longServiceDescription;
        this.shortServiceDescription = shortServiceDescription;
        this.form = form;
        this.approvalTask = approvalTask;
        this.icon = icon;
    }

    public void done() {
        this.complete = true;
    }

    public boolean verifyAttributes() {
        return this.name != null &&
                this.name.length() > 0 &&
                this.name.length() < 50 &&
                this.shortServiceDescription != null &&
                this.shortServiceDescription.length() > 0 &&
                this.shortServiceDescription.length() < 40 &&
                this.longServiceDescription != null &&
                this.longServiceDescription.length() > 0 &&
                this.longServiceDescription.length() < 500 &&
                this.keyWords != null &&
                !this.keyWords.isEmpty();
    }

    public ApprovalTask approvalTask() {
        return this.approvalTask;
    }

    public Form form() {
        return this.form;
    }

    public TaskSpec taskSpec() {
        return this.taskSpec;
    }

    public void updateAndCheckCatalog(ServiceCatalog catalog) {
        if (catalog() == null || (catalog != null && catalog() != catalog)) {
            this.serviceCatalog = catalog;
        }
    }

    public void updateAndCheckForm(Form form) {
        if (this.form == null || (form != null && this.form != form)) {
            this.form = form;
        }
    }

    public void updateAndCheckApprovalTask(ApprovalTask approvalTask) {
        if (this.approvalTask == null || (approvalTask != null && this.approvalTask != approvalTask)) {
            this.approvalTask = approvalTask;
        }
    }

    public void updateAndCheckTaskSpec(TaskSpec taskSpec) {
        if (this.taskSpec == null || (taskSpec != null && this.taskSpec != taskSpec)) {
            this.taskSpec = taskSpec;
        }
    }

    public boolean isComplete() {
        return this.complete;
    }

    public Service() {
        //
    }

    @Override
    public boolean sameAs(Object other) {
        Service se = (Service) other;
        return se.identity().equals(this.identity());
    }

    public ServiceCatalog catalog() {
        return serviceCatalog;
    }

    @Override
    public int compareTo(Long other) {
        if (other.equals(this.identity())) {
            return 1;
        }
        return -1;
    }

    public Designation name() {
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
