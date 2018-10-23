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
public class FMDaoUnlistedDateException extends Exception{
    
    public FMDaoUnlistedDateException(String message){
        super(message);
    }
    
    public FMDaoUnlistedDateException(String message, Throwable cause){
        super(message, cause);
    }
}
