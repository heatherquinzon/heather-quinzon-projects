/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmastery.dao;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import com.swcguild.flooringmastery.dto.Orders;
import com.swcguild.flooringmastery.dto.Products;
import com.swcguild.flooringmastery.dto.Taxes;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author heath
 */
public class FMDaoStubImpl implements FMDao {

    Orders onlyOrder;
    List<Orders> ordList = new ArrayList<>();
    
    public FMDaoStubImpl() {
        onlyOrder = new Orders();
        onlyOrder.setOrderNumber(1);
        onlyOrder.setCustomerName("Billy");
        onlyOrder.setState("OH");
        onlyOrder.setTaxRate(new BigDecimal("6.25"));
        onlyOrder.setProductType("Wood");
        onlyOrder.setArea(100.00);
        onlyOrder.setCostPerSquareFoot(new BigDecimal("5.15"));
        onlyOrder.setLaborCostPerSquareFoot(new BigDecimal("4.75"));
        onlyOrder.setMaterialCost(new BigDecimal("515.00"));
        onlyOrder.setLaborCost(new BigDecimal("475.00"));
        onlyOrder.setTax(new BigDecimal("61.88"));
        onlyOrder.setTotal(new BigDecimal("1051.88"));

        ordList.add(onlyOrder);
    }

    @Override
    public List<Orders> getAllOrders(LocalDate orderDate) throws FMDaoPersistenceException {
        return ordList;
    }

    @Override
    public Orders getOrder(LocalDate orderDate, int orderNumber) throws FMDaoPersistenceException {
        if (orderNumber == onlyOrder.getOrderNumber()){
        return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public List<Products> getAllProducts() throws FMDaoPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Taxes> getAllTaxes() throws FMDaoPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Products getProduct(String productName) throws FMDaoPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Orders addOrder(Orders order) throws FMDaoPersistenceException {
        return onlyOrder;
    }

    @Override
    public Orders editOrder(LocalDate orderDate, Orders order) throws FMDaoPersistenceException {
        return onlyOrder;
    }

    @Override
    public Orders removeOrder(LocalDate orderDate, int orderNumber) throws FMDaoPersistenceException {
        
        if(orderNumber != onlyOrder.getOrderNumber()){
            return null;
        } else {
            return onlyOrder;
        }
        
    }

    @Override
    public String loadMode() throws FMDaoPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
