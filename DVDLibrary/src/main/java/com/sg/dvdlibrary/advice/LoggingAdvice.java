/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.advice;

import com.sg.dvdlibrary.dao.DVDAuditDao;
import com.sg.dvdlibrary.dao.DVDDaoException;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author heath
 */
public class LoggingAdvice {
    DVDAuditDao auditDao;
    
    public LoggingAdvice(DVDAuditDao auditDao){
        this.auditDao = auditDao;
    }
    
    public void createAuditEntry(JoinPoint jp){
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";
        for(Object currentArg : args){
            auditEntry += currentArg;
        }
        
        try{
            auditDao.writeAuditEntry(auditEntry);
        }catch (DVDDaoException ex){
            System.err.println(
            "ERROR: Could not creatid audit entry in LoggingAdvice."
            );
        }
        
    }
    
    
}
