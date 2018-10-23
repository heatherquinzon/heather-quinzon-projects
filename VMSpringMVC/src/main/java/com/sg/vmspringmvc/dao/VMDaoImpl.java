/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vmspringmvc.dao;

import com.sg.vmspringmvc.dto.Inventory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author heath
 */
public class VMDaoImpl implements VMDao{
    private Map<String, Inventory> inventory = new HashMap<>();
    public static final String DELIMITER = "::";
    File f = new File(getClass().getClassLoader().getResource("Inventory.txt").getFile());

    @Override
    public Inventory getInventory(String itemName) throws VendingMachineDaoPersistenceException {
        loadInventory();
        return inventory.get(itemName);
    }

    @Override
    public List<Inventory> getAllInventory() throws VendingMachineDaoPersistenceException {
        loadInventory();
        return new ArrayList<Inventory>(inventory.values());
    }
    
    @Override
    public int updateInventoryAmount(Inventory item) throws VendingMachineDaoPersistenceException {
        int invAmount = item.getInventoryAmount() - 1;
        item.setInventoryAmount(invAmount);
        writeInventory();
        return invAmount;
    }

    private void loadInventory() throws VendingMachineDaoPersistenceException {
        Scanner sc;

        try {
            sc = new Scanner(new BufferedReader(
                    new FileReader(f)));
        } catch (FileNotFoundException ex) {
            throw new VendingMachineDaoPersistenceException(
                    "Could not load Inventory File.");
        }

        String currentLine;
        String[] parts;

        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            parts = currentLine.split(DELIMITER);

            Inventory currentInv = new Inventory();
            currentInv.setItemName(parts[0]);
            currentInv.setItemDesc(parts[1]);
            currentInv.setCost(new BigDecimal(parts[2]));
            currentInv.setInventoryAmount(Integer.parseInt(parts[3]));

            inventory.put(currentInv.getItemName(), currentInv);
        }
        sc.close();
    }

    private void writeInventory() throws VendingMachineDaoPersistenceException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(f));
        } catch (IOException ex) {
            throw new VendingMachineDaoPersistenceException("Could not save DVD data.", ex);
        }

        List<Inventory> invList = this.getAllInventory();

        for (Inventory items : invList) {
            out.println(items.getItemName() + DELIMITER
                    + items.getItemDesc() + DELIMITER
                    + items.getCost() + DELIMITER
                    + items.getInventoryAmount());
            out.flush();
        }
        out.close();
    }

}
