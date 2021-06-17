package eapli.base.service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;
import java.util.Set;

@Entity
public class Form implements ValueObject {

    @Version
    private Long version;

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
        Preconditions.noneNull(name, fields, String.valueOf(script));
        if (name!=null && !fields.isEmpty() && script!=null){
            this.name = name;
            this.fields = fields;
            this.script = script;
        }
    }

    public Form() {
    }

    public Set<Field> fields() {
        return fields;
    }

    public Long identification() {
        return identification;
    }
}
