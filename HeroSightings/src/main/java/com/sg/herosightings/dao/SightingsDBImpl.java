/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.herosightings.dao;

import com.sg.herosightings.dao.LocationDBImpl.LocationMapper;
import com.sg.herosightings.dto.Location;
import com.sg.herosightings.dto.Sightings;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
public class SightingsDBImpl implements SightingsDao{

    @Inject
    JdbcTemplate jdbc;
    
    //ADD
    private static final String INSERT_SIGHTINGS
            = "INSERT INTO sightings(locationId, date) "
            + "VALUES(?, ?)";
    @Override
    @Transactional
    public Sightings addSightings(Sightings sighting) {
        jdbc.update(INSERT_SIGHTINGS,
                sighting.getLocation().getLocationId(),
                sighting.getDate());
        
        int id = jdbc.queryForObject("select LAST_INSERT_ID()", Integer.class);
        sighting.setSightingsId(id);
        
        return sighting;
    }

    //REMOVE
    private static final String DELETE_SIGHTING = "DELETE FROM sightings WHERE id = ?";
    private static final String DELETE_HERO_SIGHTING = "DELETE FROM hvSightings WHERE sightingsId = ?";
    @Override
    public void removeSightings(int sightingsId) {
        jdbc.update(DELETE_HERO_SIGHTING, sightingsId);
        jdbc.update(DELETE_SIGHTING, sightingsId);
    }

    private static final String UPDATE_SIGHTING 
            = "UPDATE sightings SET locationId = ?, `date` = ? "
            + "WHERE id = ?";
    //UPDATE
    @Override
    @Transactional
    public void updateSightings(Sightings sighting) {
        jdbc.update(UPDATE_SIGHTING,
            sighting.getLocation().getLocationId(),
            sighting.getDate(),
            sighting.getSightingsId());
    }

    //GET ONE
    private static final String SELECT_SIGHTING = "SELECT * FROM sightings WHERE id = ?";
    @Override
    public Sightings getSightingsById(int sightingsId) {
        try {
            Sightings sighting = jdbc.queryForObject(SELECT_SIGHTING, new SightingsMapper(), 
                    sightingsId);
            sighting.setLocation(getLocationForSightingId(sightingsId));
            return sighting;

            //return jdbc.queryForObject(SELECT_SIGHTING, new SightingsMapper(), 
                    //sightingsId);
        } catch(EmptyResultDataAccessException ex) {
            return null;
        }
    }

    //Get All Locations for Sightings
    private static final String SELECT_LOCATION_BY_SIGHTINGS_ID
            = "select l.id, l.`name`, l.`description`, l.longitude, l.lattitude, "
            + "l.city, l.stateInitial, l.zipcode "
            + "from location l "
            + "join sightings s on l.id = s.locationId "
            + "where s.id = ?";
    private Location getLocationForSightingId(int id){
        try {
        return jdbc.queryForObject(SELECT_LOCATION_BY_SIGHTINGS_ID, new LocationMapper(), 
                id);
        } catch (EmptyResultDataAccessException ex){
            return null;
        }
    }
    
    //GET ALL
    private static final String SELECT_ALL_SIGHTINGS = "SELECT * FROM sightings";
    @Override
    public List getAllSightings() {
        List<Sightings> sList = jdbc.query(SELECT_ALL_SIGHTINGS, new SightingsMapper());
        populateAllSightings(sList);
        return sList;
    }
    private void populateAllSightings(List<Sightings> sights){
        for(Sightings s : sights){
            s.setLocation(getLocationForSightingId(s.getSightingsId()));
        }
    }
    
    //GET ALL SIGHTINGS (HERO AND LOCATION) BY DATE
    private static final String SELECT_ALL_HERO_AND_LOCATION_BY_DATE 
            = "SELECT * FROM sightings "
            + "WHERE `date` = ?";
    @Override
    public List<Sightings> getllAllSightingsByDate(LocalDate date) {
        
//        String formatted = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
//        date = LocalDate.parse(formatted,
//                DateTimeFormatter.ISO_LOCAL_DATE);
        
        return jdbc.query(SELECT_ALL_HERO_AND_LOCATION_BY_DATE, 
                new SightingsMapper(), java.sql.Date.valueOf(date));
    }

    //GET THE LATEST 10 SIGHTINGS
    private static final String SELECT_TEN_LATEST_SIGHTINGS 
            = "SELECT s.* FROM hvsightings hs "
            + "JOIN sightings s ON s.id = hs.sightingsId "
            + "ORDER BY s.`date` DESC "
            + "LIMIT 0,10";
    @Override
    public List getTenLatestSightings() {
        List<Sightings> sList = jdbc.query(SELECT_TEN_LATEST_SIGHTINGS, new SightingsMapper());
        populateAllSightings(sList);
        return sList;
    }
         
    public static final class SightingsMapper implements RowMapper<Sightings> {
        
        @Override
        public Sightings mapRow(ResultSet rs, int i) throws SQLException {
            Sightings s = new Sightings();
            s.setSightingsId(rs.getInt("id"));
            s.setDate(rs.getDate("date").toLocalDate());
            return s;
        }
    }
}
