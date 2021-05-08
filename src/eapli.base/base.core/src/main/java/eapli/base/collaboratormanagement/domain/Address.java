/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package eapli.base.collaboratormanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;

/**
 *
 * @author João Correia
 */
@Embeddable
public class Address implements ValueObject, Comparable<Address> {

    private static final long serialVersionUID = 1L;

    private String address;

    public Address(final String address) {
        if (StringPredicates.isNullOrEmpty(address)) {
            throw new IllegalArgumentException(
                    "Address should neither be null nor empty");
        }
        // TODO validate invariants, i.e., mecanographic number regular
        // expression
        this.address = address;
    }

    public Address() {
        // for ORM
    }

    public static Address valueOf(final String address) {
        return new Address(address);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Address)) {
            return false;
        }

        final Address that = (Address) o;
        return this.address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return this.address.hashCode();
    }

    @Override
    public String toString() {
        return this.address;
    }

    @Override
    public int compareTo(final Address arg0) {
        return address.compareTo(arg0.address);
    }
}
