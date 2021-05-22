package eapli.base.service.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class PresentationTicket implements ValueObject {

    private String presTicket;

    protected PresentationTicket(){}

    public PresentationTicket(String s){
        this.presTicket = Objects.requireNonNull(s);
    }
}
