/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package eapli.base.collaboratormanagement.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author João Correia
 */
@Embeddable
public class ShortName implements ValueObject, Comparable<ShortName> {

    private static final long serialVersionUID = 1L;

    @JsonProperty
    @XmlElement
    private String shortName;

    public ShortName(final String shortName) {
        if (StringPredicates.isNullOrEmpty(shortName)) {
            throw new IllegalArgumentException(
                    "Short name should neither be null nor empty");
        }
        // TODO validate invariants, i.e., mecanographic number regular
        // expression
        this.shortName = shortName;
    }

    public ShortName() {
        // for ORM
    }

    public static ShortName valueOf(final String shortName) {
        return new ShortName(shortName);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ShortName)) {
            return false;
        }

        final ShortName that = (ShortName) o;
        return this.shortName.equals(that.shortName);
    }

    @Override
    public int hashCode() {
        return this.shortName.hashCode();
    }

    @Override
    public String toString() {
        return this.shortName;
    }

    @Override
    public int compareTo(final ShortName arg0) {
        return shortName.compareTo(arg0.shortName);
    }
}
