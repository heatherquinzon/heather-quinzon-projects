/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmastery.dao;

/**
 *
 * @author heath
 */
public class FMDaoInvalidProductException extends Exception{
    
    public FMDaoInvalidProductException(String message) {
        super(message);
    }
    
    public FMDaoInvalidProductException(String message, Throwable ex) {
        super(message, ex);
    }
}
