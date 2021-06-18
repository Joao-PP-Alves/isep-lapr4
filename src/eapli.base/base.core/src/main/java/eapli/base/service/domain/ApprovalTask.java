package eapli.base.service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.ValueObject;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

@Embeddable
public class ApprovalTask implements ValueObject, Serializable {

    @XmlElement
    @JsonProperty
    @Column(nullable = true)
    private boolean approved;

    public ApprovalTask(boolean approved) {
        this.approved = approved;
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
