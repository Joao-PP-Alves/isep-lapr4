package eapli.base.service.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public enum DataTypesAllowed implements ValueObject {
    STRING{
        @Override
        public String toString() {
            return "String";
        }
    },
    INT{
        @Override
        public String toString() {
            return "int";
        }
    },
    DOUBLE{
        @Override
        public String toString() {
            return "double";
        }
    }
}
