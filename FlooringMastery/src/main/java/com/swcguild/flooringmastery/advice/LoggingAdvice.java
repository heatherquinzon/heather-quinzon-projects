/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmastery.advice;

import com.swcguild.flooringmastery.dao.FMAuditDao;
import com.swcguild.flooringmastery.dao.FMDaoPersistenceException;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author heath
 */
public class LoggingAdvice {
    FMAuditDao dao;
    
    public LoggingAdvice(FMAuditDao dao){
        this.dao = dao;
    }
    
    public void createAuditEntry(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        try {
            dao.writeAuditEntry(auditEntry);
        } catch (FMDaoPersistenceException e) {
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
    
    public void createAuditEntryForExceptions(JoinPoint jp, Throwable ex) throws Throwable {
        Object[] args = jp.getArgs();
        String auditEntry = "EXCEPTION THROWN: " + ex.getClass().getSimpleName() +
                " : Method: " +  jp.getSignature().getName() +  
                " : Message: " + ex.getMessage();
        for(Object currentArg : args){
            auditEntry += " : ";
            auditEntry += currentArg;
        }
        
        try {
            dao.writeAuditEntry(auditEntry);
        } catch (FMDaoPersistenceException e){
            System.out.println(
                    "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
}
