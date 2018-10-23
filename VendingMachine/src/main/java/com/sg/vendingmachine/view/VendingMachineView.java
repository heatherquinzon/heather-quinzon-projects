package com.sg.vendingmachine.view;

import com.sg.vendingmachine.dto.Currency;
import com.sg.vendingmachine.dto.Inventory;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author heath
 */
public class VendingMachineView {

    UserIO io;
    Inventory inv = new Inventory();
    Currency change = new Currency();

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public void displayVendingMachineBanner() {
        io.print("=====VENDING MACHINE=====");
    }

    public void displayAllInventoryItem(List<Inventory> inventory) {
        if (inventory != null) {
            inventory.stream().filter(c -> c.getInventoryAmount() > 0)
                    .forEach((currentInventory) -> {
                io.print(currentInventory.getItemName() + "::"
                        + currentInventory.getItemDesc() + "::$"
                        + currentInventory.getCost());
            });
        } else {
            io.print("There are currently no more items in the inventory!");
        }
    }
    
    public String getMenuSelection() {
        io.print("\n=====MENU SELECTION=====");
        io.print("1) Vend An Item "
                + "\n2) Exit ");
        String choice = io.readString("What would you like to do? ");
        return choice;
    }

    public void unknownBanner() {
        io.print("Unknown command. Try again.");
        io.print("");
    }

    public void exitMessage() {
        io.print("\nThank you for vending!");
    }
    
    public void errorMessage(String message) {
        io.print("ERROR: " + message);
        io.print("");
    }

    public String getItemSelection() {
        String choice = io.readString("\nWhich item would you like to vend? ");
        return choice;
    }

    public BigDecimal getMoney() {
        io.print("\nHow much money would you like to add? ");
        String money = io.readString("$");
        BigDecimal bd = new BigDecimal(money);
        return bd;
    }

    public String continueVending() {
        String choice = io.readString("\nWould you like another item? (y/n) ");
        return choice;
    }

    public void returnCoins(Currency coins) {
        io.print("\nYour change (in amount of coins): ");
        io.print("Quarters: " + coins.getQuarters());
        io.print("Dimes: " + coins.getDimes());
        io.print("Nickels: " + coins.getNickels());
        io.print("Pennies:" + coins.getPennies());
        io.print("Total Change: $" + coins.getUserChangeTotal());
        io.print("");
    }

}
