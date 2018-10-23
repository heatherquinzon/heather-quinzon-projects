/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vmspringmvc.service;

/**
 *
 * @author heath
 */
public class InsuffecientFundsException extends Exception {

    public InsuffecientFundsException(String message) {
        super(message);
    }

    public InsuffecientFundsException(String message, Throwable cause) {
        super(message, cause);
    }
}
