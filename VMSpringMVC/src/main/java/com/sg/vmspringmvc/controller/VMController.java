/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vmspringmvc.controller;

import com.sg.vmspringmvc.dao.VendingMachineDaoEmptyInventoryException;
import com.sg.vmspringmvc.dao.VendingMachineDaoPersistenceException;
import com.sg.vmspringmvc.dto.Currency;
import com.sg.vmspringmvc.dto.Inventory;
import com.sg.vmspringmvc.service.InsuffecientFundsException;
import com.sg.vmspringmvc.service.VMService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author heath
 */
@Controller
public class VMController {

    private String message = "";
    private BigDecimal moneyMessage = new BigDecimal("0.00");
    private String itemMessage = "";
    private Currency change = new Currency();
    private Inventory item = new Inventory();
    private BigDecimal quarters = new BigDecimal("0.00");
    private BigDecimal dimes = new BigDecimal("0.00");
    private BigDecimal nickels = new BigDecimal("0.00");
    private BigDecimal pennies = new BigDecimal("0.00");
    VMService service;

    @Inject
    public VMController(VMService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String getAllItems(Model model) throws VendingMachineDaoPersistenceException {
        List<Inventory> itemList = service.getAllInventory();

        model.addAttribute("itemList", itemList);
        model.addAttribute("moneyMessage", moneyMessage);
        model.addAttribute("itemMessage", itemMessage);
        model.addAttribute("quarters", quarters);
        model.addAttribute("dimes", dimes);
        model.addAttribute("nickels", nickels);
        model.addAttribute("pennies", pennies);
        model.addAttribute("message", message);

        return "index";
    }

    @PostMapping("/getMoney")
    public String getMoney(String coins) {

        if (coins.equals("1.00")) {
            moneyMessage = moneyMessage.add(new BigDecimal("1.00"));
            moneyMessage = moneyMessage.setScale(2, RoundingMode.HALF_UP);
        }
        if (coins.equals("0.25")) {
            moneyMessage = moneyMessage.add(new BigDecimal("0.25"));
            moneyMessage = moneyMessage.setScale(2, RoundingMode.HALF_UP);
        }
        if (coins.equals("0.10")) {
            moneyMessage = moneyMessage.add(new BigDecimal("0.10"));
            moneyMessage = moneyMessage.setScale(2, RoundingMode.HALF_UP);
        }
        if (coins.equals("0.05")) {
            moneyMessage = moneyMessage.add(new BigDecimal("0.05"));
            moneyMessage = moneyMessage.setScale(2, RoundingMode.HALF_UP);
        }

        return "redirect:/";
    }

    @PostMapping("/userItem")
    public String getItem(String itemChoice) {
        itemMessage = itemChoice;

        return "redirect:/";
    }

    @PostMapping("/makePurchase")
    public String makePurchase() {
        try {
            item = service.getInventory(itemMessage);
            BigDecimal userMoney = service.returnChange(item, moneyMessage);

            message = "Thank you!!";
            moneyMessage = new BigDecimal("0.00");
            change = service.calculatedChange(userMoney);
            service.updateInventoryAmount(item);

            quarters = change.getQuarters();
            dimes = change.getDimes();
            nickels = change.getNickels();
            pennies = change.getPennies();

        } catch (VendingMachineDaoPersistenceException | InsuffecientFundsException
                | VendingMachineDaoEmptyInventoryException ex) {
            
            if (itemMessage.isEmpty()) {
                message = "Please Select and Inventory Item:";
                return "redirect:/";
            }
            
            if (item.getInventoryAmount() == 0) {
                message = "There are no more " + item.getItemDesc() 
                        + " in the invenentory";
                return "redirect:/";
            }
            
            if (item.getCost().compareTo(moneyMessage) > 0) {
                BigDecimal neededMoney = item.getCost().subtract(moneyMessage);
                message = "Please deposit: " + neededMoney;
                return "redirect:/";
            }

        }
        return "redirect:/";
    }

    @PostMapping("/reset")
    public String reset() {
        itemMessage = "";
        moneyMessage = new BigDecimal("0.00");
        quarters = new BigDecimal("0");
        dimes = new BigDecimal("0");
        nickels = new BigDecimal("0");
        pennies = new BigDecimal("0");
        message = "";

        return "redirect:/";
    }
}
