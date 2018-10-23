/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.herosightings.dao;

import com.sg.herosightings.dto.Sightings;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
                (sighting.getLocation() == null) ? null : sighting.getLocation().getLocationId(),
                sighting.getDate());
        
        int id = jdbc.queryForObject("select LAST_INSERT_ID()", Integer.class);
        sighting.setSightingsId(id);
        
        return sighting;
    }

    //REMOVE
    private static final String DELETE_SIGHTING = "DELETE FROM sightings WHERE id = ?";
    private static final String DELETE_LOCATION_SIGHTING
            = "DELETE FROM sightings where locationId = ?";
    @Override
    public void removeSightings(int sightingsId) {
        //jdbc.update(DELETE_LOCATION_SIGHTING, locationId);
        jdbc.update(DELETE_SIGHTING, sightingsId);
    }

    //UPDATE
    @Override
    @Transactional
    public void updateSightings(Sightings sighting) {
        jdbc.update(INSERT_SIGHTINGS,
            sighting.getLocation().getLocationId(),
            sighting.getDate(),
            sighting.getSightingsId());
        jdbc.update(DELETE_SIGHTING, sighting.getSightingsId());
    }

    //GET ONE
    private static final String SELECT_SIGHTING = "SELECT * FROM sightings WHERE id = ?";
    @Override
    public Sightings getSightingsById(int sightingsId) {
        try {
            return jdbc.queryForObject(SELECT_SIGHTING, new SightingsMapper(), 
                    sightingsId);
        } catch(EmptyResultDataAccessException ex) {
            return null;
        }
    }

    //GET ALL
    private static final String SELECT_ALL_SIGHTINGS = "SELECT * FROM sightings";
    @Override
    public List getAllSightings() {
        return jdbc.query(SELECT_ALL_SIGHTINGS, new SightingsMapper());
    }

    //GET ALL SIGHTINGS (HERO AND LOCATION) BY DATE
    private static final String SELECT_ALL_HERO_AND_LOCATION_BY_DATE 
            = "SELECT hv.`name`, l.`name` "
            + "FROM hvsightings hs "
            + "JOIN herovillain hv ON hs.heroVillainId = hv.id " 
            + "JOIN sightings s ON hs.sightingsId = s.id " 
            + "JOIN location l ON s.locationId = l.id " 
            + "WHERE s.`date` = ?";
    @Override
    public List<Sightings> getllAllSightingsByDate(LocalDate date) {
        return jdbc.query(SELECT_ALL_HERO_AND_LOCATION_BY_DATE, 
                new SightingsMapper(), date);
    }
     
    public static final class SightingsMapper implements RowMapper<Sightings> {
        
        @Override
        public Sightings mapRow(ResultSet rs, int i) throws SQLException {
            Sightings s = new Sightings();
            s.setDate(rs.getDate("date"));
            return s;
        }
    }
}
