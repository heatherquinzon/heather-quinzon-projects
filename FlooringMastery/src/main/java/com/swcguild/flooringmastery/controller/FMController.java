/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmastery.controller;

import com.swcguild.flooringmastery.dao.FMDaoInvalidProductException;
import com.swcguild.flooringmastery.dao.FMDaoPersistenceException;
import com.swcguild.flooringmastery.dao.FMDaoUnlistedDateException;
import com.swcguild.flooringmastery.dto.Orders;
import com.swcguild.flooringmastery.dto.Products;
import com.swcguild.flooringmastery.dto.Taxes;
import com.swcguild.flooringmastery.service.FMService;
import com.swcguild.flooringmastery.view.FMView;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author heath
 */
public class FMController {

    FMService service;
    FMView view;

    public FMController(FMService service, FMView view) {
        this.service = service;
        this.view = view;
    }

    public void run() throws FMDaoPersistenceException {
        String choice = "";
        boolean keepGoing = true;

        while (keepGoing) {
            try {
                String mode = service.loadMode();
                view.viewMode(mode);
                choice = view.printMenuAndGetSelection();;
                switch (choice) {
                    case "1":
                        listAllOrders();
                        break;
                    case "2":
                        addAnOrder();
                        break;
                    case "3":
                        editOrder();
                        break;
                    case "4":
                        removeOrder();
                        break;
                    case "5":
                        keepGoing = false;
                        break;
                    default:
                        view.errorNoMenu();
                }
            } catch (FMDaoPersistenceException | FMDaoUnlistedDateException
                    | FMDaoInvalidProductException ex) {
                view.errorMessage(ex.getMessage());
            }
        }
    }

    private void listAllOrders() throws
            FMDaoPersistenceException, FMDaoUnlistedDateException {
        LocalDate date = view.getDate();
        List<Orders> order = new ArrayList<>();
        order = service.getAllOrders(date);
        view.displayAllOrders(order);
    }

    private void addAnOrder() throws FMDaoPersistenceException,
            FMDaoUnlistedDateException, FMDaoInvalidProductException {
        List<Products> newProd = service.getAllProducts();
        List<Taxes> newTax = service.getAllTaxes();
        Orders newOrder = view.getNewOrder(newProd, newTax);
        newOrder = service.setOrderNum(newOrder);
        newOrder = service.calculations(newOrder);
        view.displayOrder(newOrder);

        String ans = view.askToSave();

        if (ans.contains("y")) {
            service.addOrder(newOrder);
            view.displaySavedBanner();
        } else {
            view.displayNotSavedBanner();
        }
    }

    private void editOrder() throws FMDaoPersistenceException,
            FMDaoUnlistedDateException, FMDaoInvalidProductException {

        try {
            LocalDate date = view.getDate();
            List<Orders> order = service.getAllOrders(date);
            view.displayAllOrders(order);

            int orderNum = view.getOrderNum();
            Orders editOrder = service.getOrder(date, orderNum);
            view.displayOrder(editOrder);

            List<Products> prodList = service.getAllProducts();
            List<Taxes> taxList = service.getAllTaxes();

            boolean keepEditing = true;
            String choice = "";

            while (keepEditing) {
                choice = view.getEditOrderChoice();

                switch (choice) {
                    case "1":
                        editOrder = view.changeName(editOrder);
                        break;
                    case "2":
                        editOrder = view.editStateTax(taxList, editOrder);
                        editOrder = service.calculations(editOrder);
                        break;
                    case "3":
                        editOrder = view.editProduct(prodList, editOrder);
                        editOrder = service.calculations(editOrder);
                        break;
                    case "4":
                        editOrder = view.changeArea(editOrder);
                        break;
                    case "5":
                        keepEditing = false;
                        break;
                    default:
                        break;
                }
            }

            view.displayOrder(editOrder);
            view.editBannerSuccess();
            service.editOrder(date, editOrder);
        } catch (FMDaoPersistenceException ex) {
            view.errorMessage(ex.getMessage());
        }
    }

    private void removeOrder() throws FMDaoUnlistedDateException, FMDaoPersistenceException {

        LocalDate date = view.getDate();
        List<Orders> order = service.getAllOrders(date);
        view.displayAllOrders(order);

        int orderNum = view.getOrderNum();
        try {
            String ans = view.askToRemove();
            if (ans.contains("y")) {
                service.removeOrder(date, orderNum);
                view.removeSuccess();
            } else {
                view.removeNotHappen();
            }
        } catch (FMDaoPersistenceException ex) {
            view.errorMessage(ex.getMessage());
        }
    }

}
