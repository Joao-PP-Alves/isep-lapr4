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
import java.util.Set;

@Entity
public class ServiceDraft implements AggregateRoot<Long> {

    @XmlElement
    @JsonProperty
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
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

    public boolean isComplete() {
        return complete;
    }

    public Description getLongServiceDescription() {
        return longServiceDescription;
    }

    public Description getShortServiceDescription() {
        return shortServiceDescription;
    }

    public Icon getIcon() {
        return icon;
    }

    public Set<KeyWord> getKeyWords() {
        return keyWords;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public Form getForm() {
        return form;
    }

    public ApprovalTask getApprovalTask() {
        return approvalTask;
    }

    public TaskSpec getTaskSpec() {
        return taskSpec;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public void setApprovalTask(ApprovalTask approvalTask) {
        this.approvalTask = approvalTask;
    }

    public void setServiceCatalog(ServiceCatalog serviceCatalog) {
        this.serviceCatalog = serviceCatalog;
    }

    public void setTaskSpec(TaskSpec taskSpec) {
        this.taskSpec = taskSpec;
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
