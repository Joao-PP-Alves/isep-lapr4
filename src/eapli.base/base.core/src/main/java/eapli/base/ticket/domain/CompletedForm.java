package eapli.base.ticket.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.base.service.domain.Field;
import eapli.base.service.domain.Script;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.general.domain.model.Designation;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.util.Set;

@Entity
public class CompletedForm implements ValueObject {

    @Version
    private Long version;

    @JsonProperty
    @XmlElement
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty
    @XmlElement
    private Long identification;

    @JsonProperty
    @XmlElement
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<Field> fields;


    protected CompletedForm(Long identification){
        if (identification != null){
            this.identification = identification;
        }
    }

    public CompletedForm(Long identification, Set<Field> fields){
        if (!fields.isEmpty() && identification != null){
            this.identification = identification;
            this.fields = fields;
        }
    }

    public CompletedForm() {
    }

    public Set<Field> fields() {
        return fields;
    }
}
