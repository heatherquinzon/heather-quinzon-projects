package com.sg.vendingmachine.service;

/**
 *
 * @author heath
 */
public class InsuffecientFundsException extends Exception {
    
    public InsuffecientFundsException(String message){
        super(message);
    }
    
    public InsuffecientFundsException(String message, Throwable cause){
        super(message, cause);
    }
}
