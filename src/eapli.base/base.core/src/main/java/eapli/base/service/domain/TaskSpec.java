package eapli.base.service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.general.domain.model.Designation;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.lang.annotation.Annotation;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
@Entity
public class TaskSpec implements ValueObject {

    @Version
    private Long version;

    @Id
    @XmlElement
    @JsonProperty
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @XmlElement
    @JsonProperty
    private String type;    //THIS ATTIBUTE IS TO BE DELETED

    protected TaskSpec() {
    }

    public TaskSpec(String type) {   //CONSTRUCTOR TO DELETE, NEEDS CODE REFACTORING
        if (type != null) {
            this.type = type;
        }
    }


}
