/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.thefinalblog.dao;

import com.sg.thefinalblog.dto.Role;
import java.util.List;

/**
 *
 * @author heath
 */
public interface RoleDao {
    
    public Role addRole(Role role);
    
    public void removeRole(int id);
    
    public void updateRole(Role role);
    
    public Role getRoleById(int id);
    
    public Role getRoleByRole(String role);
    
    public List getAllRoles();
    
}
