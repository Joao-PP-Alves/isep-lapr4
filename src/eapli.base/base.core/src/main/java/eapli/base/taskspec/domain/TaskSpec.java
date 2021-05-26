package eapli.base.taskspec.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class TaskSpec implements AggregateRoot<Long> {

    @Id
    @XmlElement
    @JsonProperty
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @XmlElement
    @JsonProperty
    private String type;

    @Override
    public boolean sameAs(Object other) {
        TaskSpec taskSpec = (TaskSpec) other;
        return taskSpec.identity().equals(this.identity());
    }

    @Override
    public Long identity() {
        return this.id;
    }

    protected TaskSpec(){}

    public TaskSpec(String type){
        if (type != null) {
            this.type = type;
        }
    }

}
