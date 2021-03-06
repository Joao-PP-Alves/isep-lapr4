/*
 * Copyright (c) 2013-2019 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.collaboratormanagement.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

/**
 * A Collaborator.
 *
 * This class represents client users. It follows a DDD approach where User
 * is the root entity of the Base User Aggregate and all of its properties
 * are instances of value objects. A Client User references a System User
 *
 * This approach may seem a little more complex than just having String or
 * native type attributes but provides for real semantic of the domain and
 * follows the Single Responsibility Pattern
 *
 * @author Jorge Santos ajs@isep.ipp.pt
 *
 */
@XmlRootElement
@Entity
public class Collaborator implements AggregateRoot<Long> {

    @Version
    private Long version;

    @XmlElement
    @JsonProperty
    @Id
    @GeneratedValue
    private Long mecanographicNumber;

    @XmlElement
    @JsonProperty
    private FullName fullName;

    @XmlElement
    @JsonProperty
    private ShortName shortName;

    @XmlElement
    @JsonProperty
    private CompanyRole companyRole;

    @XmlElement
    @JsonProperty
    private PhoneNumber phoneNumber;

    @XmlElement
    @JsonProperty
    private Address address;

    @XmlElement
    @JsonProperty
    private Designation teamDesignation;

    @XmlElement
    @JsonProperty
    private Calendar date;


    /**
     * cascade = CascadeType.NONE as the systemUser is part of another aggregate
     */
    @OneToOne()
    private SystemUser systemUser;

    public Collaborator(final SystemUser user, final Long mecanographicNumber) {
        if (mecanographicNumber == null || user == null) {
            throw new IllegalArgumentException();
        }
        this.systemUser = user;
        this.mecanographicNumber = mecanographicNumber;
    }

    public Collaborator() {
        // for ORM only
    }

    public Collaborator(FullName fullName, ShortName shortName, Address address, PhoneNumber phoneNumber,
                        List<Role> roles, Calendar createdOn, CompanyRole companyRole) {
        if (fullName == null || shortName == null || address == null || phoneNumber == null || createdOn == null) {
            throw new IllegalArgumentException();
        }
        this.fullName = fullName;
        this.shortName = shortName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.date = createdOn;
        this.companyRole = companyRole;
        //this.role = roles;
    }

    public Collaborator(FullName fullName, ShortName shortName, Address address, PhoneNumber phoneNumber,
                        List<Role> roles, CompanyRole companyRole) {
        if (fullName == null || shortName == null || address == null || phoneNumber == null) {
            throw new IllegalArgumentException();
        }
        this.fullName = fullName;
        this.shortName = shortName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.companyRole = companyRole;
    }


    public SystemUser user() {
        return this.systemUser;
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(final Object other) {
        return DomainEntities.areEqual(this, other);
    }

    public Long mecanographicNumber() {
        return identity();
    }

    @Override
    public Long identity() {
        return this.mecanographicNumber;
    }

    public ShortName getShortName() {
        return shortName;
    }

    @Override
    public String toString() {
        return "Collaborator{" +
                ", mecanographicNumber=" + mecanographicNumber +
                ", fullName=" + fullName +
                '}';
    }
}
