/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package eapli.base.collaboratormanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import org.assertj.core.api.IntPredicateAssert;

import javax.persistence.Embeddable;
import java.util.function.IntPredicate;

/**
 *
 * @author João Correia
 */
@Embeddable
public class PhoneNumber implements ValueObject, Comparable<PhoneNumber> {

    private static final long serialVersionUID = 1L;

    private int phoneNumber;

    public PhoneNumber(final int phoneNumber) {
        if (phoneNumber == 0) {
            throw new IllegalArgumentException(
                    "Phone number should neither be null nor empty");
        }
        // TODO validate invariants, i.e., mecanographic number regular
        // expression
        this.phoneNumber = phoneNumber;
    }

    public PhoneNumber() {
        // for ORM
    }

    public static PhoneNumber valueOf(final int phoneNumber) {
        return new PhoneNumber(phoneNumber);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PhoneNumber)) {
            return false;
        }

        final PhoneNumber that = (PhoneNumber) o;
        return this.phoneNumber==(that.phoneNumber);
    }

    //TODO HashCode method needed?
/*    @Override
    public int hashCode() {
        return this.phoneNumber.hashCode();
    }*/

    @Override
    public String toString() {
        return String.valueOf(this.phoneNumber);
    }

    @Override
    public int compareTo(final PhoneNumber arg0) {
        return Integer.compare(this.phoneNumber, arg0.phoneNumber);
    }
}
