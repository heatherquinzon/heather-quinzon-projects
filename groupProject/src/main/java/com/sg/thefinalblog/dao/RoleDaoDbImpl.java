/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.thefinalblog.dao;

import com.sg.thefinalblog.dto.Role;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author heath
 */
public class RoleDaoDbImpl implements RoleDao {

    @Inject
    JdbcTemplate jdbc;

    private final String INSERT_ROLE = "INSERT INTO role(role) VALUES(?)";
    @Override
    @Transactional
    public Role addRole(Role role) {
        jdbc.update(INSERT_ROLE, role.getRole());
        int newId = jdbc.queryForObject("select LAST_INSERT_ID()", Integer.class);
        role.setId(newId);
        return role;
    }

    //DELETE
    private static String DELETE_ROLE = "DELETE FROM role WHERE id = ?";
    final String DELETE_USER_ROLE = "DELETE FROM usersRole WHERE roleId = ?"; 
    @Override
    public void removeRole(int id) {
        jdbc.update(DELETE_USER_ROLE, id);
        jdbc.update(DELETE_ROLE, id);
    }

    final String UPDATE_ROLE = "UPDATE role SET role = ? WHERE id = ?";
    @Override
    public void updateRole(Role role) {
        jdbc.update(UPDATE_ROLE, role.getRole(), role.getId());
    }

    private static final String SELECT_ROLE_BY_ID = "SELECT * FROM role WHERE id = ?";
    @Override
    public Role getRoleById(int id) {
        try {
            return jdbc.queryForObject(SELECT_ROLE_BY_ID, new RoleMapper(), id);
        } catch (DataAccessException ex) {
            return null;
        }
    }
           
    private static final String SELECT_ROLE_BY_ROLE = "SELECT * FROM role WHERE role = ?";
    @Override
    public Role getRoleByRole(String role) {
        try {
            return jdbc.queryForObject(SELECT_ROLE_BY_ROLE, new RoleMapper(), role);
        } catch (DataAccessException ex) {
            return null;
        }
    }
       
    private static final String SELECT_ALL_ROLES = "SELECT * FROM role";
    @Override
    public List getAllRoles() {
        return jdbc.query(SELECT_ALL_ROLES, new RoleMapper());
    }

    public static final class RoleMapper implements RowMapper<Role> {

        @Override
        public Role mapRow(ResultSet rs, int i) throws SQLException {
            Role r = new Role();
            r.setId(rs.getInt("id"));
            r.setRole(rs.getString("role"));
            return r;
        }

    }

}
