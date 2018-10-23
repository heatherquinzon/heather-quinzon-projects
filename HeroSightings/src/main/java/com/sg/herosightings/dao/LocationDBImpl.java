/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.herosightings.dao;

import com.sg.herosightings.dto.HeroVillain;
import com.sg.herosightings.dto.Location;
import com.sg.herosightings.dto.Sightings;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author heath
 */
@Repository
public class LocationDBImpl implements LocationDao {

    @Inject
    JdbcTemplate jdbc;
    
    //ADD
    private static final String INSERT_LOCATION 
            = "INSERT INTO location(`name`, `description`, longitude, "
            + "lattitude, city, stateInitial, zipcode) " 
            + "VALUES(?, ?, ?, ?, ?, ?, ?)";
    @Override
    @Transactional
    public Location addLocation(Location location) {
        jdbc.update(INSERT_LOCATION,
                location.getName(),
                location.getDescription(),
                location.getLongitude(),
                location.getLattitude(),
                location.getCity(),
                location.getStateInitial(),
                location.getZipcode());
        
        int id = jdbc.queryForObject("select LAST_INSERT_ID()", Integer.class);
        location.setLocationId(id);
        
        return location;
    }
    
    //REMOVE
    private static final String DELETE_LOCATION
            = "DELETE FROM location where id = ?";
        private static final String DELETE_LOCATION_SIGHTING
            = "DELETE FROM sightings where locationId = ?";
    @Override
    public void removeLocation(int locationId) {
        jdbc.update(DELETE_LOCATION_SIGHTING, locationId);
        jdbc.update(DELETE_LOCATION, locationId);
    }

    //UPDATE
    private static final String UPDATE_LOCATION
            = "UPDATE location SET `name` = ?, `description` = ?, longitude = ?, "
            + "lattitude = ?, city = ?, stateInitial = ?, zipcode = ? "
            + "WHERE id = ?";
    @Override
    @Transactional
    public void updateLocation(Location location) {
        jdbc.update(UPDATE_LOCATION,
                location.getName(),
                location.getDescription(),
                location.getLongitude(),
                location.getLattitude(),
                location.getCity(),
                location.getStateInitial(),
                location.getZipcode(),
                location.getLocationId());
    }

    //GET ONE
    private static final String SELECT_LOCATION 
            = "SELECT * FROM location WHERE id = ?";
    @Override
    public Location getLocationById(int locationId) {
        try{
            return jdbc.queryForObject(SELECT_LOCATION, new LocationMapper(), 
                    locationId);
        } catch(EmptyResultDataAccessException ex) {
            return null;
        }
    }

    //GET ALL
    private static final String SELECT_ALL_LOCATION
            = "SELECT * FROM location";
    @Override
    public List getAllLocation() {
        return jdbc.query(SELECT_ALL_LOCATION, new LocationMapper());
    }

    //GET ALL LOCATION OF HERO
    private static final String SELECT_ALL_HERO_LOCATION
            = "SELECT l.`name` "
            + "FROM location l "
            + "JOIN sightings s ON l.id = s.locationId "
            + "JOIN hvsightings hs ON s.id = hs.sightingsid "
            + "JOIN herovillain hv ON hs.heroVillainId = hv.id "
            + "WHERE hv.id = 1";
    @Override
    public List<Location> getLocationsByHeroVillainId(HeroVillain heroVillainId) {
        return jdbc.query(SELECT_ALL_HERO_LOCATION, new LocationMapper());
    }

    public static final class LocationMapper implements RowMapper<Location> {

        @Override
        public Location mapRow(ResultSet rs, int i) throws SQLException {
            Location l = new Location();
            l.setLocationId(rs.getInt("id"));
            l.setName(rs.getString("name"));
            l.setDescription(rs.getString("description"));
            l.setLongitude(rs.getString("longitude"));
            l.setLattitude(rs.getString("lattitude"));
            l.setCity(rs.getString("city"));
            l.setStateInitial(rs.getString("stateInitial"));
            l.setZipcode(rs.getString("zipcode"));
            return l;
        }
    }

}
