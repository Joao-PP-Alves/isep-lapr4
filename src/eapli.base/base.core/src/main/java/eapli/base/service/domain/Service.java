package eapli.base.service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Designation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;

@Entity
public class Service implements AggregateRoot<Long> {

    @XmlElement
    @JsonProperty
    @Id
    @GeneratedValue
    private Long id;

    @XmlElement
    @JsonProperty
    private Designation name;

    public Service(Designation name){
        this.name=name;
    }

    public Service(Long id, Designation name) {
        this.id = id;
        this.name=name;
    }

    public Service(){
        //
    }
    @Override
    public boolean sameAs(Object other) {
        Service se = (Service) other;
        return se.identity().equals(this.identity());
    }

    @Override
    public int compareTo(Long other) {
        if (other.equals(this.identity())){
            return 1;
        }
        return -1;
    }

    public Designation getName() {
        return name;
    }


    @Override
    public Long identity() {
        return this.id;
    }

    @Override
    public boolean hasIdentity(Long otherId) {
        return otherId.equals(this.identity());
    }
}
