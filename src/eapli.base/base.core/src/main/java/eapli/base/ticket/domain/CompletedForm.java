package eapli.base.ticket.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.base.service.domain.Field;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.util.Set;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
@Entity
public class CompletedForm implements ValueObject {

    @Version
    private Long version;

    @Id
    @JsonProperty
    @XmlElement
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long completedFormId;

    @JsonProperty
    @XmlElement
    private Long identification;

    @JsonProperty
    @XmlElement
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<Field> fields;


    protected CompletedForm(Long identification) {
        Preconditions.nonNull(identification);
        this.identification = identification;
    }

    public CompletedForm(Long identification, Set<Field> fields) {
        Preconditions.noneNull(identification, fields);
        this.identification = identification;
        this.fields = fields;
    }

    public CompletedForm() {
    }

    public Set<Field> fields() {
        return fields;
    }
}
