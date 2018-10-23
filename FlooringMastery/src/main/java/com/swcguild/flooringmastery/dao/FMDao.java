/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmastery.dao;

import com.swcguild.flooringmastery.dto.Orders;
import com.swcguild.flooringmastery.dto.Products;
import com.swcguild.flooringmastery.dto.Taxes;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author heath
 */
public interface FMDao {

    List<Orders> getAllOrders(LocalDate orderDate) throws FMDaoPersistenceException;

    Orders getOrder(LocalDate orderDate, int orderNumber) throws FMDaoPersistenceException;
    
    List<Products> getAllProducts() throws FMDaoPersistenceException;
    
    List<Taxes> getAllTaxes() throws FMDaoPersistenceException;
    
    Products getProduct(String productName) throws FMDaoPersistenceException;
    
    Orders addOrder(Orders order) throws FMDaoPersistenceException;
    
    Orders editOrder(LocalDate orderDate, Orders order) throws FMDaoPersistenceException;
    
    Orders removeOrder(LocalDate orderDate, int orderNumber) throws FMDaoPersistenceException;
    
    String loadMode() throws FMDaoPersistenceException;
}
