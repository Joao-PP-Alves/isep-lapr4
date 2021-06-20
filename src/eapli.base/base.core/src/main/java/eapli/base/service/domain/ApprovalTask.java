package eapli.base.service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.base.collaboratormanagement.domain.Collaborator;
import eapli.framework.domain.model.ValueObject;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

@DiscriminatorValue("Approval")
@Entity
public class ApprovalTask implements ValueObject, Serializable {

    @Version
    private Long version;

    @XmlElement
    @JsonProperty
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @XmlElement
    @JsonProperty
    @Column(nullable = true)
    private boolean approved;

    @XmlElement
    @JsonProperty
    @OneToOne(cascade = CascadeType.ALL)
    private Form form;

    @JsonProperty
    @XmlElement
    @Nullable
    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    private Collaborator solverCollab;


    public ApprovalTask(boolean approved) {
        this.approved = approved;
    }

    public ApprovalTask(Form form, Collaborator solverCollab) {
        this.approved = false;
        this.form = form;
        this.solverCollab = solverCollab;
    }

    public ApprovalTask(Form form) {
        this.approved = false;
        this.form = form;
    }

    protected ApprovalTask() {
    }

    public void approveTask() {
        this.approved = true;
    }

    public boolean isApproved() {
        return this.approved;
    }

    public Collaborator assignedCollab() {
        return this.solverCollab;
    }

    public Long identity() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ApprovalTask{" +
                "id=" + id +
                ", approved=" + approved +
                ", form=" + form +
                '}';
    }
}
