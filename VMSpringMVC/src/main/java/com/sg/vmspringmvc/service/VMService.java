/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vmspringmvc.service;

import com.sg.vmspringmvc.dao.VendingMachineDaoEmptyInventoryException;
import com.sg.vmspringmvc.dao.VendingMachineDaoPersistenceException;
import com.sg.vmspringmvc.dto.Currency;
import com.sg.vmspringmvc.dto.Inventory;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author heath
 */
public interface VMService {

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
