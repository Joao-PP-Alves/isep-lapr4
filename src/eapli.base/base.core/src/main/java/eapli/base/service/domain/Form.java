package eapli.base.service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.general.domain.model.Designation;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.util.Set;

@Embeddable
public class Form implements ValueObject {

    @JsonProperty
    @XmlElement
    //@AttributeOverride(name = "identification", column = @Column(name = "FormId"))
    private Long identification;

    @JsonProperty
    @XmlElement
    private Designation name;

    @JsonProperty
    @XmlElement
    @OneToMany
    private Set<Field> fields;

    protected Form(Long id){
        this.identification = id;
    }

    public Form (Designation name, Set<Field> fields){
        if (name!=null && !fields.isEmpty()){
            setName(name);
            setFields(fields);
        }
    }

    public Form() {
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

    public Long getIdentification() {
        return identification;
    }
}
