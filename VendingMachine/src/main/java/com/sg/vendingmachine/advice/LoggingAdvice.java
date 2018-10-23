package com.sg.vendingmachine.advice;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineDaoPersistenceException;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author heath
 */

public class LoggingAdvice {

    VendingMachineAuditDao auditDao;

    public LoggingAdvice(VendingMachineAuditDao auditDao) {
        this.auditDao = auditDao;
    }

    public void createAuditEntry(JoinPoint jp, Throwable ex) throws Throwable {
        Object[] args = jp.getArgs();
        String auditEntry = "Exception: " + ex.getClass().getSimpleName() +
                " : Method: " +  jp.getSignature().getName() +  
                " : Message: " + ex.getMessage();
        for(Object currentArg : args){
            System.out.print(" : ");
            auditEntry += currentArg;
        }
        
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (VendingMachineDaoPersistenceException e){
            System.out.println(
                    "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }

}
