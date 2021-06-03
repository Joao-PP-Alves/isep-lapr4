package eapli.base.service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.general.domain.model.Designation;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.util.Set;

@Entity
public class Form implements ValueObject {

    @JsonProperty
    @XmlElement
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long identification;

    @JsonProperty
    @XmlElement
    private Designation name;

    @JsonProperty
    @XmlElement
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<Field> fields;

    @JsonProperty
    @XmlElement
    private Script script;

    protected Form(Long id){
        this.identification = id;
    }

    public Form (Designation name, Set<Field> fields, Script script){
        if (name!=null && !fields.isEmpty() && script!=null){
            setName(name);
            setFields(fields);
            setScript(script);
        }
    }

    public Form() {
    }

    public void setScript(Script script) {
        this.script = script;
    }

    public Script getScript() {
        return script;
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
