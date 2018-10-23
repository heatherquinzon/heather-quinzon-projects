package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDaoEmptyInventoryException;
import com.sg.vendingmachine.dao.VendingMachineDaoPersistenceException;
import com.sg.vendingmachine.dto.Currency;
import com.sg.vendingmachine.dto.Inventory;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author heath
 */
public interface VendingMachineServiceLayer {

    Inventory getInventory(String itemName) throws 
            VendingMachineDaoPersistenceException;

    void throwEmpty(Inventory inv) throws 
            VendingMachineDaoEmptyInventoryException;
    
    List<Inventory> getAllInventory() throws 
            VendingMachineDaoPersistenceException;

    int updateInventoryAmount(Inventory item) throws 
            VendingMachineDaoPersistenceException,
            VendingMachineDaoEmptyInventoryException;

    BigDecimal returnChange(Inventory itemName, BigDecimal money) throws 
            VendingMachineDaoPersistenceException,
            InsuffecientFundsException;

    Currency calculatedChange(BigDecimal money) throws 
            VendingMachineDaoPersistenceException,
            InsuffecientFundsException;
}
