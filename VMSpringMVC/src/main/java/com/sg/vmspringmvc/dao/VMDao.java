/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vmspringmvc.dao;

import com.sg.vmspringmvc.dto.Inventory;
import java.util.List;

/**
 *
 * @author heath
 */
public interface VMDao {
    
    Inventory getInventory(String itemName) throws VendingMachineDaoPersistenceException; 
    
    List<Inventory> getAllInventory() throws VendingMachineDaoPersistenceException;
   
    int updateInventoryAmount(Inventory item) throws VendingMachineDaoPersistenceException;
    
}
