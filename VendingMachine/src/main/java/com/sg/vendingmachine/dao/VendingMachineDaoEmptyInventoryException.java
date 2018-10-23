/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

/**
 *
 * @author heath
 */
public class VendingMachineDaoEmptyInventoryException extends Exception{
    
    public VendingMachineDaoEmptyInventoryException (String message) {
        super(message);
    }
            
    public VendingMachineDaoEmptyInventoryException (String message, Throwable cause) {
        super(message, cause);
    }
}
