/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.herosightings.dao;

import com.sg.herosightings.dto.HeroVillain;
import com.sg.herosightings.dto.Organization;
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
public class OrgDBImpl implements OrgDao {

    @Inject
    JdbcTemplate jdbc;

    //ADD
    private static final String INSERT_ORG 
            = "INSERT INTO org(`name`, `description`, phone, email, city, "
            + "stateInitial, zipcode) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?)";
    @Override
    @Transactional
    public Organization addOrganization(Organization org) {
        jdbc.update(INSERT_ORG, 
                org.getName(),
                org.getDescription(),
                org.getPhone(),
                org.getEmail(),
                org.getCity(),
                org.getStateInitial(),
                org.getZipcode());
        int id = jdbc.queryForObject("select LAST_INSERT_ID()", Integer.class);
        org.setOrganizationId(id);
        
        return org;
    }

    //REMOVE
    private static final String DELETE_ORG
            = "DELETE FROM org WHERE id = ?";
    private static final String DELETE_HV_ORG = "DELETE FROM hvOrg WHERE orgId = ?";
    @Override
    public void removeOrganization(int orgId) {
        jdbc.update(DELETE_HV_ORG, orgId);
        jdbc.update(DELETE_ORG, orgId);
    }

    //UPDATE
    private static final String UPDATE_ORG
            = "UPDATE org SET `name` = ?, `description` = ?, phone = ?, "
            + "email = ?, city = ?, stateInitial = ?, zipcode = ? "
            + "WHERE id = ?";
    @Override
    public void updateOrganization(Organization org) {
        jdbc.update(UPDATE_ORG, 
            org.getName(),
            org.getDescription(),
            org.getPhone(),
            org.getEmail(),
            org.getCity(),
            org.getStateInitial(),
            org.getZipcode(),
            org.getOrganizationId());
    }
    
    //GET ONE
    private static final String SELECT_ORG = "SELECT * FROM org WHERE id = ?";
    @Override
    public Organization getOrgById(int orgId) {
        try{
            return jdbc.queryForObject(SELECT_ORG, new OrgMapper(),
                    orgId);
        } catch(EmptyResultDataAccessException ex) {
            return null;
        }
    }

    //GET ALL
    private static final String SELECT_ALL_ORG = "SELECT * FROM org";
    @Override
    public List getAllOrganization() {
        return jdbc.query(SELECT_ALL_ORG, new OrgMapper());
    }

    public static final class OrgMapper implements RowMapper<Organization> {

        @Override
        public Organization mapRow(ResultSet rs, int i) throws SQLException {
            Organization org = new Organization();
            org.setOrganizationId(rs.getInt("id"));
            org.setName(rs.getString("name"));
            org.setDescription(rs.getString("description"));
            org.setPhone(rs.getString("phone"));
            org.setEmail(rs.getString("email"));
            org.setCity(rs.getString("city"));
            org.setStateInitial(rs.getString("stateInitial"));
            org.setZipcode(rs.getString("zipcode"));
            return org;
        }
    }

}
