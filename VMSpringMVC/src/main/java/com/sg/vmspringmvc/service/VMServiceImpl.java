/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vmspringmvc.service;

import com.sg.vmspringmvc.dao.VMDao;
import com.sg.vmspringmvc.dao.VendingMachineDaoEmptyInventoryException;
import com.sg.vmspringmvc.dao.VendingMachineDaoPersistenceException;
import com.sg.vmspringmvc.dto.Currency;
import com.sg.vmspringmvc.dto.Inventory;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author heath
 */
public class VMServiceImpl implements VMService{
    VMDao dao;
    Inventory itemName = new Inventory();
    Currency currency = new Currency();
    
    public VMServiceImpl(VMDao dao) {
        this.dao = dao;
    }
    
    @Override
    public Inventory getInventory(String itemName) throws VendingMachineDaoPersistenceException {
        
        if (dao.getInventory(itemName) != null) {
            return dao.getInventory(itemName);
        } else {
            throw new VendingMachineDaoPersistenceException(
                    "Invalid Item Name");
        }
    }

    @Override
    public void throwEmpty(Inventory inv) throws VendingMachineDaoEmptyInventoryException{
        if(inv.getInventoryAmount() == 0){
            throw new VendingMachineDaoEmptyInventoryException(
            "No more item.");
        }
    }
    
    @Override
    public List<Inventory> getAllInventory() throws VendingMachineDaoPersistenceException {
        return dao.getAllInventory();
    }
    
    @Override
    public int updateInventoryAmount(Inventory item) throws
            VendingMachineDaoPersistenceException,
            VendingMachineDaoEmptyInventoryException {
        
        if (item.getInventoryAmount() != 0) {
            return dao.updateInventoryAmount(item);
        } else {
            throw new VendingMachineDaoEmptyInventoryException(
                    "There are no more " + item.getItemDesc()
                    + " in the vending machine.");
        }
    }
    
    @Override
    public BigDecimal returnChange(Inventory item, BigDecimal money)
            throws VendingMachineDaoPersistenceException,
            InsuffecientFundsException {
        
        currency.setUserMoney(money);
        
        BigDecimal change = new BigDecimal("0");
        
        if (money.compareTo(item.getCost()) >= 0) {
            change = money.subtract(item.getCost());
            currency.setUserMoney(change);
            return change;
        } else {
            throw new InsuffecientFundsException("Insuffecient funds. "
                    + "Your money has been returned to you.");
        }
        
    }
    
    @Override
    public Currency calculatedChange(BigDecimal money) throws VendingMachineDaoPersistenceException,
            InsuffecientFundsException {
        
        Currency userMoney = new Currency();
        
        userMoney.setUserMoney(money);
        userMoney.setUserChangeTotal(money);
        BigDecimal remainder;
        
        BigDecimal quarters;
        quarters = userMoney.getUserMoney().divide(new BigDecimal("0.25"), 0, RoundingMode.FLOOR);
        userMoney.setQuarters(quarters);
        remainder = userMoney.getUserMoney().subtract(quarters.multiply(new BigDecimal("0.25")));
        userMoney.setUserMoney(remainder);
        
        BigDecimal dimes;
        dimes = userMoney.getUserMoney().divide(new BigDecimal("0.10"), 0, RoundingMode.FLOOR);
        userMoney.setDimes(dimes);
        remainder = userMoney.getUserMoney().subtract(dimes.multiply(new BigDecimal("0.10")));
        userMoney.setUserMoney(remainder);
        
        BigDecimal nickels;
        nickels = userMoney.getUserMoney().divide(new BigDecimal("0.05"), 0, RoundingMode.FLOOR);
        userMoney.setNickels(nickels);
        remainder = userMoney.getUserMoney().subtract(nickels.multiply(new BigDecimal("0.05")));
        userMoney.setUserMoney(remainder);
        
        BigDecimal pennies;
        pennies = userMoney.getUserMoney().divide(new BigDecimal("0.01"), 0, RoundingMode.FLOOR);
        userMoney.setPennies(pennies);
        remainder = userMoney.getUserMoney().subtract(pennies.multiply(new BigDecimal("0.01")));
        userMoney.setUserMoney(remainder);
        
        return userMoney;
    }
}
