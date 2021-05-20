package eapli.base.service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlElement;

@Embeddable
public class ApprovalTask implements ValueObject {

    @XmlElement
    @JsonProperty
    private boolean approved;

    public ApprovalTask(boolean approved){
        this.approved = approved;
    }

    protected ApprovalTask() {}

    public void approveTask(){
        this.approved=true;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public boolean isApproved(){
        return this.approved;
    }
}
