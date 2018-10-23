/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.herosightings.dao;

import com.sg.herosightings.dto.HeroVillain;
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
            = "INSERT INTO heroVillain"
            + "(`name`, `description`, power, `type`) "
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
            = "INSERT INTO hvOrg(orgId, heroVillainId) "
            + "VALUES(?,?)";
    public void addHeroOrg(HeroVillain hv) throws DataAccessException {
        for(Organization org : hv.getOrgs()) {
            jdbc.update(INSERT_HV_ORG, org.getOrganizationId(), hv.getHeroVillainId());
        }
    }
    
    //ADD HVSIGHTINGS
    private static final String INSERT_HV_SIGHTINGS
            = "INSERT INTO hvSightings(sightingId, herovillainId) "
            + "VALUES(?,?)";
    public void addHeroSighting(HeroVillain hv) throws DataAccessException {
        for(Sightings s : hv.getSightings()) {
            jdbc.update(INSERT_HV_ORG, s.getSightingsId(), hv.getHeroVillainId());
        }
    }
    
    //REMOVE
    private static final String DELETE_HEROVILLAIN = "DELETE FROM heroVillain WHERE id = ?";
    private static final String DELETE_HV_ORG = "DELETE FROM hvOrg WHERE id = ?";
    private static final String DELETE_HV_SIGHTINGS = "DELETE FROM hvSightings WHERE ID = ?";
    @Override
    public void removeHeroVillain(int heroVillainId) {
        jdbc.update(DELETE_HEROVILLAIN, heroVillainId);
        jdbc.update(DELETE_HV_SIGHTINGS, heroVillainId);
        jdbc.update(DELETE_HV_ORG, heroVillainId);
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
        addHeroOrg(hv);
    }

    //GET ONE
    private static final String SELECT_HEROVILLAIN = "SELECT * FROM heroVillain WHERE id =?"; 
    @Override
    public HeroVillain getHVById(int heroVillainId) {
        try{
            return jdbc.queryForObject(SELECT_HEROVILLAIN, new HeroVillainMapper(),
                    heroVillainId);
        }catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    //GET ALL
    private static final String SELECT_ALL_ORG_FROM_HERO_ID 
            = "select o.`name` " 
            + "from org o " 
            + "join hvorg hv on o.id = hv.id " 
            + "where hv.herovillainid = ?";
    private List<Organization> getAllOrgsFromHeroId(int heroVillainId) {
        return jdbc.query(SELECT_ALL_ORG_FROM_HERO_ID, new OrgDBImpl.OrgMapper(), heroVillainId);
    }
    private static final String SELECT_ALL_HEROVILLAINS = "SELECT * FROM heroVillain";
    @Override
    public List getAllHeroVillains() {
        List<HeroVillain> hvList = jdbc.query(SELECT_ALL_HEROVILLAINS, new HeroVillainMapper());
        populateAllHeros(hvList);
        return hvList;
    }
    private void populateAllHeros(List<HeroVillain> hvList){
        for(HeroVillain hv : hvList){
            hv.setOrgs(getAllOrgsFromHeroId(hv.getHeroVillainId()));
        }
    }

    //GET ALL HEROS BY LOCATION
    private static final String SELECT_All_HEROVILLAIN_BY_LOCATION_ID 
            = "SELECT hv.`name` "
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
            = "SELECT hv.`name` "
            + "FROM hvorg ho "
            + "JOIN herovillain hv ON ho.heroVillainId = hv.id "
            + "JOIN org o ON ho.orgId = o.id "
            + "WHERE o.id = \"SuperEvil";
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
