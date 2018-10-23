/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.tictactoe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author heath
 */
@Controller
public class TTTController {
    private String message1 = "";
    private String message2 = "";
    private String message3 = "";
    private String message4 = "";
    private String message5 = "";
    private String message6 = "";
    private String message7 = "";
    private String message8 = "";
    private String message9 = "";
    
    @GetMapping("/")
    public String idex(Model model){
        
        model.addAttribute("message1", message1);
        model.addAttribute("message2", message2);
        model.addAttribute("message3", message3);
        model.addAttribute("message4", message4);
        model.addAttribute("message5", message5);
        model.addAttribute("message6", message6);
        model.addAttribute("message7", message7);
        model.addAttribute("message8", message8);
        model.addAttribute("message9", message9);
        
        return "index";
    }
    
    @PostMapping("/playTTT")
    public String play(Integer grid){
        
        if(grid == 1){
            message1 = "X";
        } else if(grid == 2) {
            message2 = "X";
        } else if(grid == 3) {
            message3 = "X";
        } else if(grid == 4) {
            message4 = "X";
        } else if(grid == 5) {
            message5 = "X";
        } else if(grid == 6) {
            message6 =  "X";
        } else if(grid == 7) {
            message7 = "X";
        } else if(grid == 8) {
            message8 = "X";
        } else {
            message9 = "X";
        }
        
        int compChoice = (int)(Math.random()*9+1);
        if(compChoice == 1){
            message1 = "O";
        } else if(compChoice == 2) {
            message2 = "O";
        } else if(compChoice == 3) {
            message3 = "O";
        } else if(compChoice == 4) {
            message4 = "O";
        } else if(compChoice == 5) {
            message5 = "O";
        } else if(compChoice == 6) {
            message6 =  "O";
        } else if(compChoice == 7) {
            message7 = "O";
        } else if(compChoice == 8) {
            message8 = "O";
        } else {
            message9 = "O";
        }
        
        return "redirect:/";
    }
    

    
    
}
