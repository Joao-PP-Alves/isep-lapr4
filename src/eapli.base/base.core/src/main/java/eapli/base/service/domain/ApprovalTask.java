package eapli.base.service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private ManualTaskSpec manualTask;



    public ApprovalTask(boolean approved) {
        this.approved = approved;
    }

    public ApprovalTask(boolean approved, ManualTaskSpec mts) {
        this.approved = approved;
        this.manualTask = mts;
    }


    protected ApprovalTask() {
    }

    public void approveTask() {
        this.approved = true;
    }

    public boolean isApproved() {
        return this.approved;
    }
}
