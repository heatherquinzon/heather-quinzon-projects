/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.herosightings.dto;

import java.util.List;
import java.util.Objects;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author heath
 */
public class Location {

    private int locationId;
    
    @NotEmpty(message = "You must supply a value for Name.")
    @Length(max = 20, message = "Name can't exceed 20 characters.")
    private String name;
    
    @NotEmpty(message = "You must supply a value for Description.")
    @Length(max = 300, message = "Description can't exceed 300 characters.")
    private String description;
    
    @NotEmpty(message = "You must supply a value for City.")
    @Length(max = 20, message = "City can't exceed 20 characters.")
    private String city;
    
    @NotEmpty(message = "You must supply a value for State Initial.")
    @Length(max = 2, message = "State Initial must only be 2 characters.")
    private String stateInitial;
    
    @NotEmpty(message = "You must supply a value for Phone.")
    @Length(max = 10, message = "Zipcode can't exceed 10 characters.")
    private String zipcode;
    
    private String longitude;
    
    private String lattitude;

    public Location(){
        
    }
    
    public Location(int locationId) {
        this.locationId = locationId;
    }
    
    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
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

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLattitude() {
        return lattitude;
    }

    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.locationId;
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.description);
        hash = 47 * hash + Objects.hashCode(this.city);
        hash = 47 * hash + Objects.hashCode(this.stateInitial);
        hash = 47 * hash + Objects.hashCode(this.zipcode);
        hash = 47 * hash + Objects.hashCode(this.longitude);
        hash = 47 * hash + Objects.hashCode(this.lattitude);
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
        final Location other = (Location) obj;
        if (this.locationId != other.locationId) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
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
        if (!Objects.equals(this.longitude, other.longitude)) {
            return false;
        }
        if (!Objects.equals(this.lattitude, other.lattitude)) {
            return false;
        }
        return true;
    }

}
