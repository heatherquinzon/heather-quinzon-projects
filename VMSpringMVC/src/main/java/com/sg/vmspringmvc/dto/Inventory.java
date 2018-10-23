/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vmspringmvc.dto;

import java.math.BigDecimal;

/**
 *
 * @author heath
 */
public class Inventory {
    private String itemName;
    private String itemDesc;
    private BigDecimal cost;
    private int inventoryAmount;

    public Inventory() {
    }

    public Inventory(String itemName){
        this.itemName = itemName;
    }

    public Inventory(String itemName, String itemDesc, BigDecimal cost, int inventoryAmount) {
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.cost = cost;
        this.inventoryAmount = inventoryAmount;
    }
    
    

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public int getInventoryAmount() {
        return inventoryAmount;
    }

    public void setInventoryAmount(int inventoryAmount) {
        this.inventoryAmount = inventoryAmount;
    }
    
    @Override
    public String toString(){
        return "Item Name: " + itemName +
                "Item Desc: " + itemDesc +
                "Cost: " + cost +
                "Amount: " + inventoryAmount;
    }
}
