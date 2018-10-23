/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.herosightings.dao;

import com.sg.herosightings.dto.HeroVillain;
import com.sg.herosightings.dto.Location;
import java.util.List;

/**
 *
 * @author heath
 */
public interface LocationDao {

    public Location addLocation(Location location);

    public void removeLocation(int locationId);

    public void updateLocation(Location location);

    public Location getLocationById(int locationId);

    public List getAllLocation();

    public List<Location> getLocationsByHeroVillainId(HeroVillain heroVillainId);
}
