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
public class FullName implements ValueObject, Comparable<FullName> {

    private static final long serialVersionUID = 1L;

    private String fullName;

    public FullName(final String fullName) {
        if (StringPredicates.isNullOrEmpty(fullName)) {
            throw new IllegalArgumentException(
                    "Full name should neither be null nor empty");
        }
        // TODO validate invariants, i.e., mecanographic number regular
        // expression
        this.fullName = fullName;
    }

    public FullName() {
        // for ORM
    }

    public static FullName valueOf(final String fullName) {
        return new FullName(fullName);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FullName)) {
            return false;
        }

        final FullName that = (FullName) o;
        return this.fullName.equals(that.fullName);
    }

    @Override
    public int hashCode() {
        return this.fullName.hashCode();
    }

    @Override
    public String toString() {
        return this.fullName;
    }

    @Override
    public int compareTo(final FullName arg0) {
        return fullName.compareTo(arg0.fullName);
    }
}
