/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.rockpaperscissorsspringmvc;

import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author heath
 */
@Controller
public class RPSController {

    int win;
    int tie;
    int lose;
    String message = "";
    String userChoice = "";
    String compChoice = "";

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("win", win);
        model.addAttribute("tie", tie);
        model.addAttribute("lose", lose);
        model.addAttribute("message", message);
        model.addAttribute("choice", userChoice);
        model.addAttribute("compChoice", compChoice);

        return "index";
    }

    @PostMapping("resultChoice")
    public String winner(HttpServletRequest request,
            Map<String, Object> model) {

        userChoice = request.getParameter("choice");
        int ans = 0;

        //1-Rock 2-Paper 3-Scissors
        if (userChoice.equalsIgnoreCase("Rock")) {
            ans = 1;
        }

        if (userChoice.equalsIgnoreCase("Paper")) {
            ans = 2;
        }

        if (userChoice.equalsIgnoreCase("Scissors")) {
            ans = 3;
        }

        Random r = new Random();
        int compChoiceNum = r.nextInt(3) + 1;

        if (compChoiceNum == 1) {
            compChoice = "Rock";
        } else if (compChoiceNum == 2) {
            compChoice = "Paper";
        } else if (compChoiceNum == 3) {
            compChoice = "Scissors";
        }

        if ((ans == 1) && (compChoiceNum == 3)) {
            message = "You Win";
            win++;
        } else if (ans > compChoiceNum) {
            message = "You Win";
            win++;
        } else if (ans == compChoiceNum) {
            message = "We Tied";
            tie++;
        } else if (ans < compChoiceNum) {
            message = "You Lose";
            lose++;
        }

        return "redirect:/";
    }

    @PostMapping("/reset")
    public String reset() {
        win = 0;
        tie = 0;
        lose = 0;

        return "redirect:/";
    }
}
