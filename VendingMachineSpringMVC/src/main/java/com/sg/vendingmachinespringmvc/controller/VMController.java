/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author heath
 */
@Controller
public class VMController {
    
    private String message = "moneyHere";
    
//    @GetMapping("/")
//    public String index(Model model){
//        
//        model.addAttribute("message", message);
//        
//        return "index";
//    }
    
    @GetMapping("/showMoney")
    public String getMoney(HttpServletRequest request, Model model){
        
        model.addAttribute("money", message);
        
        return "index";
    }
    
}
