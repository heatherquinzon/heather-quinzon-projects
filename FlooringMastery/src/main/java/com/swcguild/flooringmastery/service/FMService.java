/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmastery.service;

import com.swcguild.flooringmastery.dao.FMDaoInvalidProductException;
import com.swcguild.flooringmastery.dao.FMDaoPersistenceException;
import com.swcguild.flooringmastery.dao.FMDaoUnlistedDateException;
import com.swcguild.flooringmastery.dto.Orders;
import com.swcguild.flooringmastery.dto.Products;
import com.swcguild.flooringmastery.dto.Taxes;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author heath
 */
public interface FMService {

    List<Orders> getAllOrders(LocalDate orderDate) throws 
            FMDaoPersistenceException, FMDaoUnlistedDateException;
    
    Orders getOrder(LocalDate orderDate, int orderNumber) throws 
            FMDaoPersistenceException, FMDaoUnlistedDateException;
    
    List<Products> getAllProducts() throws FMDaoPersistenceException;
    
    List<Taxes> getAllTaxes() throws FMDaoPersistenceException;

    Orders addOrder(Orders order) throws FMDaoPersistenceException;

    Orders editOrder(LocalDate orderDate, Orders order) throws 
            FMDaoPersistenceException, FMDaoUnlistedDateException;

    Orders removeOrder(LocalDate orderDate, int orderNumber) throws 
            FMDaoPersistenceException, FMDaoUnlistedDateException;
    
    Orders calculations(Orders order) throws
            FMDaoPersistenceException, FMDaoUnlistedDateException;
    
    Orders setOrderNum(Orders order) throws
            FMDaoPersistenceException;
    
    String loadMode() throws FMDaoPersistenceException;
}
