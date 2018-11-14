/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.herosightings.dao;

import com.sg.herosightings.dao.OrgDBImpl.OrgMapper;
import com.sg.herosightings.dao.SightingsDBImpl.SightingsMapper;
import com.sg.herosightings.dto.HeroVillain;
import com.sg.herosightings.dto.Location;
import com.sg.herosightings.dto.Organization;
import com.sg.herosightings.dto.Sightings;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.dao.DataAccessException;
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
public class HVDBImpl implements HVDao{

    @Inject
    JdbcTemplate jdbc;
    
    //ADD
    private static final String INSERT_HEROVILLAIN 
            = "INSERT INTO heroVillain(`name`, `description`, power, `type`) "
            + "VALUES(?,?,?,?)";
    @Override
    @Transactional
    public HeroVillain addHeroVillan(HeroVillain hv) {
      jdbc.update(INSERT_HEROVILLAIN,
              hv.getName(),
              hv.getDescription(),
              hv.getPower(),
              hv.getType());
      
      int id = jdbc.queryForObject("select LAST_INSERT_ID()", Integer.class);
      hv.setHeroVillainId(id);
      
      addHeroOrg(hv);
      addHeroSighting(hv);
      return hv;
    }
    
    //ADD HVORG
    private static final String INSERT_HV_ORG 
            = "INSERT INTO hvorg(heroVillainId, orgId) VALUES(?,?)";
    public void addHeroOrg(HeroVillain hv) throws DataAccessException {
        final int hvId = hv.getHeroVillainId();
        final List<Organization> orgs = hv.getOrgs();
        
        for(Organization currentOrg : orgs) {
            jdbc.update(INSERT_HV_ORG, hvId, currentOrg.getOrganizationId());
        }
    }
    
    //ADD HVSIGHTINGS
    private static final String INSERT_HV_SIGHTINGS
            = "INSERT INTO hvSightings(sightingsId, herovillainId) "
            + "VALUES(?,?)";
    public void addHeroSighting(HeroVillain hv) throws DataAccessException {
        final int hvId = hv.getHeroVillainId();
        final List<Sightings> sights = hv.getSightings();
        
        for(Sightings curS : sights) {
            jdbc.update(INSERT_HV_SIGHTINGS, curS.getSightingsId(), hvId);
        }
    }
    
    //REMOVE
    private static final String DELETE_HEROVILLAIN = "DELETE FROM heroVillain WHERE id = ?";
    private static final String DELETE_HV_SIGHTINGS = "DELETE FROM hvSightings WHERE heroVillainId = ?";
    private static final String DELETE_HV_ORG = "DELETE FROM hvOrg WHERE heroVillainId = ?";
    @Override
    public void removeHeroVillain(int heroVillainId) {
        jdbc.update(DELETE_HV_SIGHTINGS, heroVillainId);
        jdbc.update(DELETE_HV_ORG, heroVillainId);
        jdbc.update(DELETE_HEROVILLAIN, heroVillainId);
    }

    //UPDATE
    private static final String UPDATE_HEROVILLAIN = "UPDATE herovillain SET "
            + "`name` = ?, `description` = ?, power = ?, `type` = ? "
            + "WHERE id = ?";
    @Override
    @Transactional
    public void updateHeroVillan(HeroVillain hv) {
        jdbc.update(UPDATE_HEROVILLAIN, 
                hv.getName(),
                hv.getDescription(),
                hv.getPower(),
                hv.getType(),
                hv.getHeroVillainId());
        
        jdbc.update(DELETE_HV_ORG, hv.getHeroVillainId());
        jdbc.update(DELETE_HV_SIGHTINGS, hv.getHeroVillainId());
        addHeroOrg(hv);
        addHeroSighting(hv);
    }

    //GET ONE
    private static final String SELECT_HEROVILLAIN = "SELECT * FROM heroVillain WHERE id =?"; 
    @Override
    public HeroVillain getHVById(int heroVillainId) {
        try{
            HeroVillain hv = jdbc.queryForObject(SELECT_HEROVILLAIN, new HeroVillainMapper(),
                    heroVillainId);
            hv.setOrgs(getOrgsByHeroId(heroVillainId));
            hv.setSightings(getSightingsByHeroId(heroVillainId));
            return hv;
//            return jdbc.queryForObject(SELECT_HEROVILLAIN, new HeroVillainMapper(),
//                    heroVillainId);
        }catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    private static final String SELECT_ORGS_FOR_HERO
            = "SELECT o.* FROM org o "
            + "JOIN hvorg ho on o.id = ho.orgId "
            + "where ho.herovillainid = ?";
    private List<Organization> getOrgsByHeroId(int id) {
        return jdbc.query(SELECT_ORGS_FOR_HERO, new OrgMapper(), id);
    }
    
    private static final String SELECT_ALL_SIGHTINGS_FOR_HERO
            = "SELECT s.* FROM sightings s "
            + "JOIN hvSightings hs on s.id = hs.sightingsId "
            + "WHERE hs.heroVillainId = ?";
    private List<Sightings> getSightingsByHeroId(int id) {
        List<Sightings> sList = jdbc.query(SELECT_ALL_SIGHTINGS_FOR_HERO, new SightingsMapper(), id);
        populateAllSightings(sList);
        return sList;
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
        return jdbc.queryForObject(SELECT_LOCATION_BY_SIGHTINGS_ID, new LocationDBImpl.LocationMapper(), 
                id);
        } catch (EmptyResultDataAccessException ex){
            return null;
        }
    }
    //Gets All Sightings with proper Location
    private void populateAllSightings(List<Sightings> sights){
        for(Sightings s : sights){
            s.setLocation(getLocationForSightingId(s.getSightingsId()));
        }
    }
    
    //Gets All Orgs from Hero Id
    private static final String SELECT_ALL_ORG_FROM_HERO_ID 
            = "select o.* " 
            + "from org o " 
            + "join hvorg hv on o.id = hv.id " 
            + "where hv.herovillainid = ?";
    private List<Organization> getAllOrgsFromHeroId(int heroVillainId) {
        return jdbc.query(SELECT_ALL_ORG_FROM_HERO_ID, new OrgDBImpl.OrgMapper(), heroVillainId);
    }
    private static final String SELECT_ALL_HEROVILLAINS = "SELECT * FROM heroVillain";
    //GET ALL
    @Override
    public List getAllHeroVillains() {
        List<HeroVillain> hvList = jdbc.query(SELECT_ALL_HEROVILLAINS, new HeroVillainMapper());
        populateAllHeros(hvList);
        return hvList;
    }
    private void populateAllHeros(List<HeroVillain> hvList){
        for(HeroVillain hv : hvList){
            hv.setOrgs(getAllOrgsFromHeroId(hv.getHeroVillainId()));
            hv.setSightings(getSightingsByHeroId(hv.getHeroVillainId()));
        }
    }

    //GET ALL HEROS BY LOCATION
    private static final String SELECT_All_HEROVILLAIN_BY_LOCATION_ID 
            = "SELECT hv.* "
            + "FROM heroVillain hv "
            + "JOIN hvsightings hs ON hv.id = hs.heroVillainId "
            + "JOIN sightings s ON hs.sightingsId = s.id "
            + "JOIN location l ON s.locationId = l.id "
            + "WHERE l.id = ?";
    @Override
    public List<HeroVillain> getAllHeroVillainByLocationId(int locationId) {
        return jdbc.query(SELECT_All_HEROVILLAIN_BY_LOCATION_ID, 
                new HeroVillainMapper(), locationId);
    }
    
    //GET ALL HEROS FROM ORG
    private static final String SELECT_ALL_HEROVILLAIN_BY_ORG_ID
            = "SELECT hv.* "
            + "FROM herovillain hv "
            + "JOIN hvorg ho ON hv.id = ho.herovillainId "
            + "WHERE ho.orgid = ?";
    @Override
    public List<HeroVillain> getAllMembersByOrgId(int orgId) {
        return jdbc.query(SELECT_ALL_HEROVILLAIN_BY_ORG_ID, 
                new HeroVillainMapper(), orgId);
    }
    
    public static final class HeroVillainMapper implements RowMapper<HeroVillain> {
        
        @Override
        public HeroVillain mapRow(ResultSet rs, int i) throws SQLException {
            HeroVillain hv = new HeroVillain();
            hv.setHeroVillainId(rs.getInt("id"));
            hv.setName(rs.getString("name"));
            hv.setDescription(rs.getString("description"));
            hv.setPower(rs.getString("power"));
            hv.setType(rs.getString("type"));
            return hv;
        }
    }
       
}
