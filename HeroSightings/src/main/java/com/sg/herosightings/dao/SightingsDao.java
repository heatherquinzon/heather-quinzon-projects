/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.herosightings.dao;

import com.sg.herosightings.dto.Sightings;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author heath
 */
public interface SightingsDao {

    public Sightings addSightings(Sightings sighting);

    public void removeSightings(int sightingsId);

    public void updateSightings(Sightings sighting);

    public Sightings getSightingsById(int sightingsId);

    public List getAllSightings();

    public List<Sightings> getllAllSightingsByDate(LocalDate date);
    
    public List getTenLatestSightings();
}
