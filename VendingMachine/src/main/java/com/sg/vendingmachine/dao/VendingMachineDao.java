package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Inventory;
import java.util.List;

/**
 *
 * @author heath
 */
public interface VendingMachineDao {

    Inventory getInventory(String itemName) throws VendingMachineDaoPersistenceException;
    
    List<Inventory> getAllInventory() throws VendingMachineDaoPersistenceException;
   
    int updateInventoryAmount(Inventory item) throws VendingMachineDaoPersistenceException;

    
}
