/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.thefinalblog.dao;

import com.sg.thefinalblog.dao.RoleDaoDbImpl.RoleMapper;
import com.sg.thefinalblog.dto.Role;
import com.sg.thefinalblog.dto.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author heath
 */
@Repository
public class UserDaoDbImpl implements UserDao {

    @Inject
    JdbcTemplate jdbc;

    private static final String INSERT_USER = "INSERT INTO users(username, pass, enabled) VALUES(?, ?, ?)";
    private static final String INSERT_USER_ROLE = "INSERT INTO usersRole(usersId, roleId) VALUES(?,?)";

    @Override
    public User addUser(User user) {
        jdbc.update(INSERT_USER, user.getUsername(), user.getPassword(), user.isEnabled());

        int id = jdbc.queryForObject("select LAST_INSERT_ID()", Integer.class);
        user.setId(id);

        addUserRole(user);
        return user;
    }

    private void addUserRole(User user) {
        for (Role r : user.getRoles()) {
            jdbc.update(INSERT_USER_ROLE, user.getId(), r.getId());
        }
    }

    //DELETE
    private static final String DELETE_USER = "DELETE FROM users WHERE id = ?";
    private static final String DELETE_USER_ROLE = "DELETE FROM usersRole WHERE usersId = ?";
    private static final String UPDATE_POST_AFTER_DELETE
            = "UPDATE post set "
            + "userId = 1 "
            + "WHERE userId = ?";

    @Override
    public void removeUser(int id) {
        jdbc.update(DELETE_USER_ROLE, id);
        jdbc.update(UPDATE_POST_AFTER_DELETE, id);
        jdbc.update(DELETE_USER, id);
    }

    private static final String UPDATE_USER
            = "UPDATE users SET "
            + "username = ?, pass = ?, enabled = ? "
            + "WHERE id = ?";

    @Override
    public void updateUser(User user) {
        jdbc.update(UPDATE_USER,
                user.getUsername(),
                user.getPassword(),
                user.isEnabled(),
                user.getId());
        jdbc.update(DELETE_USER_ROLE, user.getId());
        addUserRole(user);
    }

    private static final String GET_USER_BY_ID
            = "select * from users where id = ?";

    @Override
    public User getUserById(int userId) {
        try {
            User user = jdbc.queryForObject(GET_USER_BY_ID, new UserMapper(), userId);
            user.setRoles(getRolesForUser(userId));
            user.setRoles(getRolesForUser(user.getId()));
            return user;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    private static final String GET_ALL_SUPERS = "select * from users";

    private static final String SELECT_ALL_USERS
            = "select * from users";

//    @Override
//    public List<User> getAllUsers() {
//        return jdbc.query(GET_ALL_SUPERS, new UserMapper());
//    }
    @Override
    public List<User> getAllUsers() {
        List<User> users = jdbc.query(SELECT_ALL_USERS, new UserMapper());
        populateUsers(users);
        return users;
    }

    private void populateUsers(List<User> users) {
        for (User u : users) {
            u.setRoles(getRolesForUser(u.getId()));
        }
    }

    private static final String SELECT_USER_BY_USERNAME
            = "SELECT * FROM users WHERE username = ?";

    public User getUserByUsername(String username) {
        try {
            User user = jdbc.queryForObject(SELECT_USER_BY_USERNAME, new UserMapper(), username);
            user.setRoles(getRolesForUser(user.getId()));
            return user;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    private static final String SELECT_ROLES_FOR_USER
            = "SELECT r.* FROM usersRole ur "
            + "JOIN role r ON ur.roleId = r.id "
            + "WHERE ur.usersId = ?";

    private Set<Role> getRolesForUser(int id) throws DataAccessException {
        Set<Role> roles = new HashSet(jdbc.query(SELECT_ROLES_FOR_USER, new RoleMapper(), id));
        return roles;
    }

    public static final class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int i) throws SQLException {
            User u = new User();
            u.setId(rs.getInt("id"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("pass"));
            u.setEnabled(rs.getBoolean("enabled"));
            return u;
        }
    }

}
