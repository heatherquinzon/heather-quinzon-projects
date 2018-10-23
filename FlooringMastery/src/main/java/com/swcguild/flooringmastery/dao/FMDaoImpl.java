/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmastery.dao;

import com.swcguild.flooringmastery.dto.Mode;
import com.swcguild.flooringmastery.dto.Orders;
import com.swcguild.flooringmastery.dto.Products;
import com.swcguild.flooringmastery.dto.Taxes;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author heath
 */
public class FMDaoImpl implements FMDao {

    public static final String PRODUCTS_FILE = "Products.txt";
    public static final String TAXES_FILE = "Taxes.txt";
    public static final String MODE_FILE = "Mode.txt";
    public static final String DELIMITER = ",";

    private Scanner sc;
    private String currentLine;
    private String[] parts;

    private Map<Integer, Orders> orders = new HashMap<>();
    private Map<String, Products> products = new HashMap<>();
    private Map<String, Taxes> taxes = new HashMap<>();

    @Override
    public List<Orders> getAllOrders(LocalDate orderDate) throws FMDaoPersistenceException {
        loadOrders(orderDate);
        return new ArrayList<Orders>(orders.values());
    }

    @Override
    public Orders getOrder(LocalDate orderDate, int orderNumber) throws FMDaoPersistenceException {
        loadOrders(orderDate);
        return orders.get(orderNumber);
    }

    @Override
    public List<Products> getAllProducts() throws FMDaoPersistenceException {
        loadProducts();
        return new ArrayList<Products>(products.values());
    }
    
    @Override
    public List<Taxes> getAllTaxes() throws FMDaoPersistenceException {
        loadTaxes();
        return new ArrayList<Taxes>(taxes.values());
    }
    
    @Override
    public Products getProduct(String productName) throws FMDaoPersistenceException{
        loadProducts();
        return products.get(productName);
    }
    
    @Override
    public Orders addOrder(Orders order) throws FMDaoPersistenceException {
        LocalDate date = LocalDate.now();
        Orders newOrder = orders.put(order.getOrderNumber(), order);
        String mode = loadMode();
        if(mode.equalsIgnoreCase("Production")){
        writeOrder(date);
        }
        return newOrder;
    }

    @Override
    public Orders editOrder(LocalDate orderDate, Orders order) throws FMDaoPersistenceException {
        loadOrders(orderDate);
        Orders editedOrder = orders.put(order.getOrderNumber(), order);
        String mode = loadMode();
        if(mode.equalsIgnoreCase("Production")){
        writeOrder(orderDate);
        }
        return editedOrder;
    }

    @Override
    public Orders removeOrder(LocalDate orderDate, int orderNumber) throws FMDaoPersistenceException {
        Orders removedOrder = orders.remove(orderNumber);
        String mode = loadMode();
        if(mode.equalsIgnoreCase("Production")){
        writeOrder(orderDate);
        }
        return removedOrder;
    }

    private void loadOrders(LocalDate date) throws FMDaoPersistenceException {
        orders.clear();
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MMddyyyy");
        String formatted2 = date.format(formatter2);//formats to MMddyyy which is what we want

        try {
            sc = new Scanner(new BufferedReader(
                    new FileReader("Orders_" + formatted2 + ".txt")));
        } catch (FileNotFoundException ex) {
            throw new FMDaoPersistenceException(
                    "Could not load: " + ex.getMessage());
        }

        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            parts = currentLine.split(DELIMITER);

            Orders currentOrder = new Orders();
            currentOrder.setOrderNumber(Integer.parseInt(parts[0]));
            currentOrder.setCustomerName(parts[1]);
            currentOrder.setState(parts[2]);
            currentOrder.setTaxRate(new BigDecimal(parts[3]));
            currentOrder.setProductType(parts[4]);
            currentOrder.setArea(Double.parseDouble(parts[5]));
            currentOrder.setCostPerSquareFoot(new BigDecimal(parts[6]));
            currentOrder.setLaborCostPerSquareFoot(new BigDecimal(parts[7]));
            currentOrder.setMaterialCost(new BigDecimal(parts[8]));
            currentOrder.setLaborCost(new BigDecimal(parts[9]));
            currentOrder.setTax(new BigDecimal(parts[10]));
            currentOrder.setTotal(new BigDecimal(parts[11]));

            orders.put(currentOrder.getOrderNumber(), currentOrder);
        }
        sc.close();
    }

    private void writeOrder(LocalDate date) throws FMDaoPersistenceException {
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MMddyyyy");
        String formatted2 = date.format(formatter2);

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter("Orders_" + formatted2 + ".txt"));
        } catch (IOException ex) {
            throw new FMDaoPersistenceException("Could not save "
                    + "Orders data. ", ex);
        }

        List<Orders> orderList = new ArrayList<Orders>(orders.values());

        for (Orders currentOrder : orderList) {
            out.println(currentOrder.getOrderNumber() + DELIMITER
                    + currentOrder.getCustomerName() + DELIMITER
                    + currentOrder.getState() + DELIMITER
                    + currentOrder.getTaxRate() + DELIMITER
                    + currentOrder.getProductType() + DELIMITER
                    + currentOrder.getArea() + DELIMITER
                    + currentOrder.getCostPerSquareFoot() + DELIMITER
                    + currentOrder.getLaborCostPerSquareFoot() + DELIMITER
                    + currentOrder.getMaterialCost() + DELIMITER
                    + currentOrder.getLaborCost() + DELIMITER
                    + currentOrder.getTax() + DELIMITER
                    + currentOrder.getTotal() + DELIMITER);
            out.flush();
        }
        out.close();
    }

    private void loadProducts() throws FMDaoPersistenceException {

        try {
            sc = new Scanner(new BufferedReader(
                    new FileReader(PRODUCTS_FILE)));
        } catch (FileNotFoundException ex) {
            throw new FMDaoPersistenceException(
                    "Could not load Products data into memory." + ex);
        }

        currentLine = sc.nextLine();
        
        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            parts = currentLine.split(DELIMITER);

            Products currentProduct = new Products();
            currentProduct.setProductType(parts[0]);
            currentProduct.setCostPerSquareFoot(new BigDecimal(parts[1]));
            currentProduct.setLaborCosterPerSquareFoot(new BigDecimal(parts[2]));

            products.put(currentProduct.getProductType(), currentProduct);
        }
        sc.close();
    }

    private void loadTaxes() throws FMDaoPersistenceException {

        try {
            sc = new Scanner(new BufferedReader(
                    new FileReader(TAXES_FILE)));
        } catch (FileNotFoundException ex) {
            throw new FMDaoPersistenceException(
                    "Could not load Taxes data into memory." + ex);
        }

        currentLine = sc.nextLine();
        
        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            parts = currentLine.split(DELIMITER);

            Taxes currentTax = new Taxes();
            currentTax.setState(parts[0]);
            currentTax.setTaxRate(new BigDecimal(parts[1]));

            taxes.put(currentTax.getState(), currentTax);
        }
        sc.close();
    }
    
    @Override
    public String loadMode() throws FMDaoPersistenceException {
        String mode = "";
        
        try {
            sc = new Scanner(new BufferedReader(
                    new FileReader(MODE_FILE)));
        } catch (FileNotFoundException ex) {
            throw new FMDaoPersistenceException(
                    "Mode not Set");
        }
        
        mode = sc.nextLine();
        sc.close();
        
        return mode;
    }
    
    
    
}
