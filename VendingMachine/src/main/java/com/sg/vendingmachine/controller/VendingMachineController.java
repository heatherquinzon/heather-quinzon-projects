
package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VendingMachineDaoEmptyInventoryException;
import com.sg.vendingmachine.dao.VendingMachineDaoPersistenceException;
import com.sg.vendingmachine.dto.Currency;
import com.sg.vendingmachine.dto.Inventory;
import com.sg.vendingmachine.service.InsuffecientFundsException;
import com.sg.vendingmachine.service.VendingMachineServiceLayer;
import com.sg.vendingmachine.view.VendingMachineView;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author heath
 */
public class VendingMachineController {

    VendingMachineView view;
    VendingMachineServiceLayer service;

    public VendingMachineController(VendingMachineView view, VendingMachineServiceLayer service) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        boolean repeat = true;
        String choice = "";

        while (repeat) {
            try {
                listInventory();
                choice = view.getMenuSelection();

                switch (choice) {
                    case "1":
                        Inventory inv = getItem();
                        service.throwEmpty(inv);
                        BigDecimal userMoney = view.getMoney();
                        BigDecimal change = service.returnChange(inv, userMoney);
                        Currency currency = service.calculatedChange(change);
                        view.returnCoins(currency);
                        service.updateInventoryAmount(inv);
                        break;
                    case "2":
                        repeat = false;
                        break;
                    default:
                        view.unknownBanner();
                        break;
                }
            } catch (VendingMachineDaoPersistenceException
                    | InsuffecientFundsException | VendingMachineDaoEmptyInventoryException ex) {
                view.errorMessage(ex.getMessage());
            }
        }
        view.exitMessage();
    }

    //lists all of the inventory inside the Inventory.txt
    private void listInventory() throws VendingMachineDaoPersistenceException {
        view.displayVendingMachineBanner();
        List<Inventory> inventoryList = service.getAllInventory();
        view.displayAllInventoryItem(inventoryList);
    }

    //just gets the item from the user(from view) and updates the inventory
    //returns the choice so can be used in the service layer
    public Inventory getItem() throws VendingMachineDaoPersistenceException,
            InsuffecientFundsException {
        String choice = view.getItemSelection();
        Inventory inventory = service.getInventory(choice);
        return inventory;
    }
    
}
