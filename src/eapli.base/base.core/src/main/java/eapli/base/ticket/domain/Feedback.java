package eapli.base.ticket.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlElement;


@Embeddable
public enum Feedback implements ValueObject {

    @XmlElement
    @JsonProperty
    ZERO{
        @Override
        public String toString() {
            return String.valueOf(0);
        }
    },
    ONE{
        @Override
        public String toString() {
            return String.valueOf(1);
        }
    },
    TWO{
        @Override
        public String toString() {
            return String.valueOf(2);
        }
    },
    THREE{
        @Override
        public String toString() {
            return String.valueOf(3);
        }
    },
    FOUR{
        @Override
        public String toString() {
            return String.valueOf(4);
        }
    },
    FIVE{
        @Override
        public String toString() {
            return String.valueOf(5);
        }
    };

    @Override
    public String toString() {
        return super.toString();
    }
}
