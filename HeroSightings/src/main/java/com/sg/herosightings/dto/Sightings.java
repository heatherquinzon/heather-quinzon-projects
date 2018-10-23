/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.herosightings.dto;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author heath
 */
public class Sightings {

    private int sightingsId;
    private Location location;
    private Date date;

    public int getSightingsId() {
        return sightingsId;
    }

    public void setSightingsId(int sightingsId) {
        this.sightingsId = sightingsId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.sightingsId;
        hash = 97 * hash + Objects.hashCode(this.location);
        hash = 97 * hash + Objects.hashCode(this.date);
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
        final Sightings other = (Sightings) obj;
        if (this.sightingsId != other.sightingsId) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }


    

}
