/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.thefinalblog.controller;

import com.sg.thefinalblog.config.PWEnc;
import com.sg.thefinalblog.dao.RoleDao;
import com.sg.thefinalblog.dao.UserDao;
import com.sg.thefinalblog.dto.Role;
import com.sg.thefinalblog.dto.User;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Charlie
 */
@Controller
public class AdminController {

    @Inject
    UserDao users;

    @Inject
    RoleDao roles;

    @Inject
    PasswordEncoder encoder;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String displayAdminPage(Model model) {
        model.addAttribute("users", users.getAllUsers());
        return "admin";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(String username, String password) {
        User user = new User();

        user.setUsername(username);
        user.setPassword(encoder.encode(password));
        user.setEnabled(true);
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(roles.getRoleByRole("ROLE_USER"));
        user.setRoles(userRoles);

        users.addUser(user);

        return "redirect:/admin";
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public String deleteUser(Integer id) {
        users.removeUser(id);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public String editUserDisplay(Model model, Integer id, Integer error) {
        User user = users.getUserById(id);
        List<Role> roleList = (List<Role>) roles.getAllRoles();

        model.addAttribute("user", user);
        model.addAttribute("roles", roleList);

        if (error != null) {
            if (error == 1) {
                model.addAttribute("error", "Passwords did not match, password was not updated.");
            }
        }
        return "editUser";
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public String editUserAction(String[] roleIdList, Boolean enabled, Integer id) {
        User user = users.getUserById(id);
        if (enabled != null) {
            user.setEnabled(enabled);
        } else {
            user.setEnabled(false);
        }

        Set<Role> roleList = new HashSet<>();
        for (String roleId : roleIdList) {
            Role role = roles.getRoleById(Integer.parseInt(roleId));
            roleList.add(role);
        }
        user.setRoles(roleList);
        users.updateUser(user);

        return "redirect:/admin";
    }

    @RequestMapping(value = "editPassword", method = RequestMethod.POST)
    public String editPassword(Integer id, String password, String confirmPassword) {
        User user = users.getUserById(id);

        if (password.equals(confirmPassword)) {
            user.setPassword(encoder.encode(password));
            users.updateUser(user);
            return "redirect:/admin";
        } else {
            return "redirect:/editUser?id=" + id + "&error=1";
        }
    }
}
