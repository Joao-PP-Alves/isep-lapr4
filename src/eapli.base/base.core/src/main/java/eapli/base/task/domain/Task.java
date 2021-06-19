package eapli.base.task.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.base.clientusermanagement.domain.ApprovalStatus;
import eapli.base.collaboratormanagement.domain.Collaborator;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.util.Calendar;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
@Entity
public class Task implements AggregateRoot<Long> {

    @Version
    private Long version;

    @Id
    @XmlElement
    @JsonProperty
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @XmlElement
    @JsonProperty
    private Calendar date;

    @JsonProperty
    @XmlElement
    private Description helpDescription;

    @JsonProperty
    @XmlElement
    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    private Collaborator solverCollab;

    @JsonProperty
    @XmlElement
    private ApprovalStatus approvalStatus;


    public Task(Calendar date, Description helpDescription, Collaborator solverCollab, ApprovalStatus approval) {
        this.date = date;
        this.helpDescription = helpDescription;
        this.solverCollab = solverCollab;
        this.approvalStatus = approval;
    }

    public Task() {}

    public Collaborator responsableCollab(){
        return this.solverCollab;
    }


    @Override
    public boolean sameAs(Object other) {
        Task t = (Task) other;
        return t.identity().equals(this.identity());
    }

    @Override
    public Long identity() {
        return id;
    }

    @Override
    public int compareTo(Long o) {
        if (o.equals(this.identity())){
            return 1;
        }
        return -1;
    }
}
