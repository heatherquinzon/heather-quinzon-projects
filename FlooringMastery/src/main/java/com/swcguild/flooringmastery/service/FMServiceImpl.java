/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmastery.service;

import com.swcguild.flooringmastery.dao.FMDao;
import com.swcguild.flooringmastery.dao.FMDaoInvalidProductException;
import com.swcguild.flooringmastery.dao.FMDaoPersistenceException;
import com.swcguild.flooringmastery.dao.FMDaoUnlistedDateException;
import com.swcguild.flooringmastery.dto.Orders;
import com.swcguild.flooringmastery.dto.Products;
import com.swcguild.flooringmastery.dto.Taxes;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author heath
 */
public class FMServiceImpl implements FMService {

    FMDao dao;

    public FMServiceImpl(FMDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Orders> getAllOrders(LocalDate orderDate) throws
            FMDaoPersistenceException, FMDaoUnlistedDateException {

        if (dao.getAllOrders(orderDate).isEmpty()) {
            throw new FMDaoPersistenceException(
                    "Empty file");
        } else {
            return dao.getAllOrders(orderDate);
        }

    }

    @Override
    public Orders getOrder(LocalDate orderDate, int orderNumber) throws
            FMDaoPersistenceException, FMDaoUnlistedDateException {

        if (dao.getOrder(orderDate, orderNumber) == null) {
            throw new FMDaoPersistenceException(
                    "Empty order number");
        } else {
            return dao.getOrder(orderDate, orderNumber);
        }

    }

    @Override
    public List<Products> getAllProducts() throws
            FMDaoPersistenceException {
        return dao.getAllProducts();
    }

    @Override
    public List<Taxes> getAllTaxes() throws FMDaoPersistenceException {
        return dao.getAllTaxes();
    }
    
    @Override
    public Orders addOrder(Orders order) throws FMDaoPersistenceException {
        return dao.addOrder(order);
    }

    @Override
    public Orders editOrder(LocalDate orderDate, Orders order) throws
            FMDaoPersistenceException, FMDaoUnlistedDateException {
        if (orderDate != null) {
            return dao.editOrder(orderDate, order);
        } else {
            throw new FMDaoUnlistedDateException(
                    "Date does not exist in file");
        }

    }

    @Override
    public Orders removeOrder(LocalDate orderDate, int orderNumber) throws
            FMDaoPersistenceException, FMDaoUnlistedDateException {
        
        if (dao.removeOrder(orderDate, orderNumber) == null) {
            throw new FMDaoPersistenceException(
                    "Empty order number");
        } else {
            return dao.removeOrder(orderDate, orderNumber);
        }

    }

    @Override
    public Orders calculations(Orders order) throws
            FMDaoPersistenceException, FMDaoUnlistedDateException {

        double dArea = order.getArea();
        BigDecimal area = BigDecimal.valueOf(dArea);
        BigDecimal costPerSqrFt = order.getCostPerSquareFoot();
        BigDecimal laborPerSqrFt = order.getLaborCostPerSquareFoot();

        BigDecimal materialCost = order.getMaterialCost();
        materialCost = costPerSqrFt.multiply(area);
        materialCost = materialCost.setScale(2, RoundingMode.HALF_UP);
        order.setMaterialCost(materialCost);

        BigDecimal laborCost = order.getLaborCost();
        laborCost = laborPerSqrFt.multiply(area);
        laborCost = laborCost.setScale(2, RoundingMode.HALF_UP);
        order.setLaborCost(laborCost);

        BigDecimal totalCost = materialCost.add(laborCost);
        totalCost = totalCost.setScale(2, RoundingMode.HALF_UP);

        BigDecimal tax = order.getTaxRate().divide(new BigDecimal("100"));
        BigDecimal totalTax = totalCost.multiply(tax);
        totalTax = totalTax.setScale(2, RoundingMode.HALF_UP);
        order.setTax(totalTax);

        BigDecimal actualTotal = totalCost.add(totalTax);
        actualTotal = actualTotal.setScale(2, RoundingMode.HALF_UP);
        order.setTotal(actualTotal);

        return order;
    }

    @Override
    public Orders setOrderNum(Orders order) throws
            FMDaoPersistenceException {
        LocalDate date = LocalDate.now();

        try {
            List<Orders> orderList = dao.getAllOrders(date);
            int num = order.getOrderNumber();

            for (Orders currentOrder : orderList) {
                num = currentOrder.getOrderNumber() + 1;
                order.setOrderNumber(num);
            }
        } catch (FMDaoPersistenceException ex) {
            order.setOrderNumber(1);
        }

        return order;
    }

    @Override
    public String loadMode() throws FMDaoPersistenceException {
        return dao.loadMode();
    }

}
