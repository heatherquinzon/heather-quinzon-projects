/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmastery;

import com.swcguild.flooringmastery.controller.FMController;
import com.swcguild.flooringmastery.dao.FMDaoPersistenceException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author heath
 */
public class MainApp {
    
    public static void main(String[] args) throws FMDaoPersistenceException {
 
        ApplicationContext ctx = 
                new ClassPathXmlApplicationContext("applicationContext.xml");
        FMController controller = 
                ctx.getBean("controller", FMController.class);
        controller.run();
        
    }    
}
