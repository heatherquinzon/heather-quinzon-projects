/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmastery.view;

import com.swcguild.flooringmastery.dao.FMDaoInvalidProductException;
import com.swcguild.flooringmastery.dao.FMDaoPersistenceException;
import com.swcguild.flooringmastery.dao.FMDaoUnlistedDateException;
import com.swcguild.flooringmastery.dto.Mode;
import com.swcguild.flooringmastery.dto.Orders;
import com.swcguild.flooringmastery.dto.Products;
import com.swcguild.flooringmastery.dto.Taxes;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;

/**
 *
 * @author heath
 */
public class FMView {

    UserIO io;
    
    public FMView(UserIO io) {
        this.io = io;
    }
        
    public void viewMode(String mode){
        if(!mode.equalsIgnoreCase("production")){
            io.print(" =====================");
            io.print("||   <<Trainging>>   ||");
            io.print("||     <<Mode>>      ||");
            io.print(" =====================");
            io.print("\nEverything Added/Edited/Removed"
                   + "\nwill not be saved to file.\n");
        }
    }
    
    
    public String printMenuAndGetSelection() {
        io.print("==================================");
        io.print("      << Flooring Program >>");
        io.print("      1) Display Orders"
                + "\n      2) Add An Order"
                + "\n      3) Edit An Order"
                + "\n      4) Remove An Order"
                + "\n      5) Exit");
        io.print("==================================");
        String choice = io.readString("What would you like to do: ");
        return choice;
    }

    public void errorNoMenu() {
        io.print("Invalid choice.");
    }

    public void displayAllOrders(List<Orders> orderList) {
        orderList.stream().forEach(c -> {
            io.print(c.getOrderNumber() + " : "
                    + c.getCustomerName() + " : "
                    + c.getState() + " : "
                    + c.getTaxRate() + " : "
                    + c.getProductType() + " : "
                    + c.getArea() + " : "
                    + c.getCostPerSquareFoot() + " : "
                    + c.getLaborCostPerSquareFoot() + " : "
                    + c.getMaterialCost() + " : "
                    + c.getLaborCost() + " : "
                    + c.getTax() + " : "
                    + c.getTotal() + " : ");
        });
        io.readString("Press enter to continue");

    }

    public LocalDate getDate() throws FMDaoUnlistedDateException {
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.now();

        boolean again = true;
        do {
            try {
                date = LocalDate.parse(io.readString("DATE (mm/dd/yyyy): "), formatter1);
                io.print("");
                again = false;
            } catch (DateTimeParseException ex) {
                io.print("Invalid date input\n");
            }
        } while (again);

        return date;
    }

    private Products getProd(List<Products> prodList) {
        Products prod = new Products();
        boolean tryAgain = true;
        do {
            String prodName = io.readString("Enter product: ");
            for (Products currentProd : prodList) {
                if (currentProd.getProductType().equalsIgnoreCase(prodName)) {
                    tryAgain = false;
                    prod.setProductType(prodName);
                    prod.setCostPerSquareFoot(currentProd.getCostPerSquareFoot());
                    prod.setLaborCosterPerSquareFoot(currentProd.getLaborCosterPerSquareFoot());
                }
            }
            if (prod.getProductType() == null) {
                io.print("Invalid Product, Try Again.\n");
            }
        } while (tryAgain);

        return prod;
    }

    private Taxes getTax(List<Taxes> taxList) {
        Taxes tax = new Taxes();
        boolean tryAgain = true;
        do {
            String stateName = io.readString("Enter State Initials: ");
            for (Taxes currentTax : taxList) {
                if (currentTax.getState().equalsIgnoreCase(stateName)) {
                    tryAgain = false;
                    tax.setState(stateName);
                    tax.setTaxRate(currentTax.getTaxRate());
                }
            }
            if (tax.getState() == null) {
                io.print("Invalid State Initial, Try Again.\n");
            }
        } while (tryAgain);

        return tax;
    }

    private String getName() {
        boolean emptyName = true;
        String name = "";
        do {
            name = io.readString("Enter Customer's Name: ");
            if (name.isEmpty()) {
                io.print("Can't have an empty name. Please try again.\n");
            } else {
                emptyName = false;
                return name;
            }
        } while (emptyName);
        return name;
    }

    private Double getArea() {
        double num = 0.0;
        boolean again = true;
        do {
            try {
                num = io.readDouble("Enter Total Area: ");
                if (num < 0) {
                    io.print("Please enter a positive number.\n");
                } else {
                    again = false;
                }
            } catch (NumberFormatException ex) {
                io.print("Invalid input");
            }
        } while (again);

        return num;
    }

    public Orders getNewOrder(List<Products> prodList, List<Taxes> taxList)
            throws FMDaoPersistenceException, FMDaoInvalidProductException {
        Orders newOrder = new Orders();

        String name = getName();
        newOrder.setCustomerName(name);

        Products newProd = getProd(prodList);
        newOrder.setProductType(newProd.getProductType());
        newOrder.setCostPerSquareFoot(newProd.getCostPerSquareFoot());
        newOrder.setLaborCostPerSquareFoot(newProd.getLaborCosterPerSquareFoot());

        Taxes newTax = getTax(taxList);
        newOrder.setState(newTax.getState());
        newOrder.setTaxRate(newTax.getTaxRate());

        double area = getArea();
        newOrder.setArea(area);

        return newOrder;
    }

    public void displayOrder(Orders order) {
        io.print("");
        io.print("Order Number:                 " + order.getOrderNumber());
        io.print("Customer name:                " + order.getCustomerName());
        io.print("State:                        " + order.getState());
        io.print("State Tax Rate:               " + order.getTaxRate() + "%");
        io.print("Product Type:                 " + order.getProductType());
        io.print("Total Area:                   " + order.getArea() + " sqft");
        io.print("Material Cost:                $" + order.getCostPerSquareFoot() + " /sqft");
        io.print("Labor Cost:                   $" + order.getLaborCostPerSquareFoot() + " /sqft");
        io.print("Total Material Cost:          $" + order.getMaterialCost());
        io.print("Total Labor Cost:             $" + order.getLaborCost());
        io.print("Total Tax:                    $" + order.getTax());
        io.print("Grand Total:                  $" + order.getTotal());
    }

    public String askToSave() {
        String ans = io.readString("\nAre you sure you want to save the data? (y/n): ");
        return ans;
    }

    public void displaySavedBanner() {
        io.print("New order data saved.\n");
    }

    public void displayNotSavedBanner() {
        io.print("New order data has not been saved to file.\n");
    }

    public int getOrderNum() {
        int num = 0;
        boolean again = true;
        do {
            try {
                num = io.readInt("\nOrder number: ");
                again = false;
            } catch (NumberFormatException ex) {
                io.print("Invalid input");
            }
        } while (again);

        return num;
    }

    public String getEditOrderChoice() {
        io.print("\nWhat would you like to change? ");
        io.print("1) Customer Name");
        io.print("2) State");
        io.print("3) Product Type");
        io.print("4) Total Area");
        io.print("5) Nothing");
        String choice = io.readString("Choice: ");
        return choice;
    }

    public Orders changeName(Orders order) {
        String name = getName();
        order.setCustomerName(name);
        return order;
    }

    public Orders changeArea(Orders order) {
        double area = getArea();
        order.setArea(area);
        return order;
    }

    public Orders editProduct(List<Products> prodList, Orders order) throws FMDaoPersistenceException {
        Products newProd = getProd(prodList);
        order.setProductType(newProd.getProductType());
        order.setCostPerSquareFoot(newProd.getCostPerSquareFoot());
        order.setLaborCostPerSquareFoot(newProd.getLaborCosterPerSquareFoot());

        return order;
    }

    public Orders editStateTax(List<Taxes> taxList, Orders order) {
        Taxes newTax = getTax(taxList);
        order.setState(newTax.getState());
        order.setTaxRate(newTax.getTaxRate());

        return order;
    }

    public void editBannerSuccess() {
        io.print("Succesfully edited order\n");
    }

    public String askToRemove() {
        String ans = io.readString("\nAre you sure you want to remove the data? (y/n): ");
        return ans;
    }

    public void removeSuccess() {
        io.print("Order removed from file\n");
    }

    public void removeNotHappen() {
        io.print("Order is still in file\n");
    }

    public void errorMessage(String message) {
        io.print("ERROR: " + message);
        io.print("");
    }

}
