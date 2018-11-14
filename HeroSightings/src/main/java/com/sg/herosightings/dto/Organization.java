/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.herosightings.dto;

import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author heath
 */
public class Organization {
   
    private int organizationId;
    
    @NotEmpty(message = "You must supply a value for Organization Name.")
    @Length(max = 20, message = "Organization Name can't exceed 20 characters.")
    private String name;
    
    @NotEmpty(message = "You must supply a value for Description.")
    @Length(max = 300, message = "Description can't exceed 300 characters.")
    private String description;
    
    @NotEmpty(message = "You must supply a value for Phone.")
    @Length(max = 12, message = "Phone can't exceed 12 characters. xxx-xxx-xxxx")
    private String phone;
    
    @Email(message = "Please enter a valid email address.")
    @Length(max = 50, message = "Email can't exceed 50 characters.")
    private String email;
    
    @NotEmpty(message = "You must supply a value for City.")
    @Length(max = 20, message = "City can't exceed 20 characters.")
    private String city;
    
    @NotEmpty(message = "You must supply a value for State Initial.")
    @Length(max = 2, message = "State Initial must only be 2 characters.")
    private String stateInitial;
    
    @NotEmpty(message = "You must supply a value for Phone.")
    @Length(max = 10, message = "Zipcode can't exceed 10 characters.")
    private String zipcode;

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateInitial() {
        return stateInitial;
    }

    public void setStateInitial(String stateInitial) {
        this.stateInitial = stateInitial;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.organizationId;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.description);
        hash = 29 * hash + Objects.hashCode(this.phone);
        hash = 29 * hash + Objects.hashCode(this.email);
        hash = 29 * hash + Objects.hashCode(this.city);
        hash = 29 * hash + Objects.hashCode(this.stateInitial);
        hash = 29 * hash + Objects.hashCode(this.zipcode);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Organization other = (Organization) obj;
        if (this.organizationId != other.organizationId) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.stateInitial, other.stateInitial)) {
            return false;
        }
        if (!Objects.equals(this.zipcode, other.zipcode)) {
            return false;
        }
        return true;
    }



}
