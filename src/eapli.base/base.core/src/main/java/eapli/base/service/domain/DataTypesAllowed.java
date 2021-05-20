package eapli.base.service.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public enum DataTypesAllowed implements ValueObject {
    STRING,
    INT,
    DOUBLE
}
