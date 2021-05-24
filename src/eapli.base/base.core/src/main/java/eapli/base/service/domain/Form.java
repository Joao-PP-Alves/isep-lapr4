package eapli.base.service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.general.domain.model.Designation;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import java.util.Set;

@Embeddable
public class Form implements ValueObject {

    @JsonProperty
    @XmlElement
    @GeneratedValue
    private Long id;

    @JsonProperty
    @XmlElement
    private Designation name;

    @JsonProperty
    @XmlElement
    @OneToMany
    private Set<Field> fields;

    protected Form(){}

    public Form (Designation name, Set<Field> fields){
        if (name!=null && !fields.isEmpty()){
            this.name = name;
            this.fields = fields;
        }
    }

    public void setFields(Set<Field> fields) {
        this.fields = fields;
    }

    public void setName(Designation name) {
        this.name = name;
    }

    public Designation getName() {
        return name;
    }

    public Set<Field> getFields() {
        return fields;
    }

    public Long getId() {
        return id;
    }
}
