package eapli.base.servicecatalog.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlElement;

@Embeddable
public class AccessCriteria implements ValueObject {

    @JsonProperty
    @XmlElement
    private int access;

    public AccessCriteria(){
        access = 1;
    }

    public AccessCriteria(int access){
        this.access = access;
    }

    public int getAccess() {
        return access;
    }

    public void setAccess(int access) {
        this.access = access;
    }
}
