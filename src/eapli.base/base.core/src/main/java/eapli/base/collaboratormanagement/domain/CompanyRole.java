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
public class CompanyRole implements ValueObject, Comparable<CompanyRole> {

    private static final long serialVersionUID = 1L;

    @JsonProperty
    @XmlElement
    private String companyRole;

    public CompanyRole(final String companyRole) {
        if (StringPredicates.isNullOrEmpty(companyRole)) {
            throw new IllegalArgumentException(
                    "Full name should neither be null nor empty");
        }
        // TODO validate invariants, i.e., mecanographic number regular
        // expression
        this.companyRole = companyRole;
    }


    public CompanyRole() {
        // for ORM
    }

    public static CompanyRole valueOf(final String fullName) {
        return new CompanyRole(fullName);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CompanyRole)) {
            return false;
        }

        final CompanyRole that = (CompanyRole) o;
        return this.companyRole.equals(that.companyRole);
    }

    @Override
    public int hashCode() {
        return this.companyRole.hashCode();
    }

    @Override
    public String toString() {
        return this.companyRole;
    }

    @Override
    public int compareTo(final CompanyRole arg0) {
        return companyRole.compareTo(arg0.companyRole);
    }
}
