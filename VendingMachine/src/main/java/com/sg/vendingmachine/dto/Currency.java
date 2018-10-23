package com.sg.vendingmachine.dto;

import java.math.BigDecimal;

/**
 *
 * @author heath
 */
public class Currency {
    
    private BigDecimal userMoney;
    private BigDecimal five;
    private BigDecimal one;
    private BigDecimal quarters;
    private BigDecimal dimes;
    private BigDecimal nickels;
    private BigDecimal pennies;

    public Currency() {
    }

    private BigDecimal userChangeTotal;
    public BigDecimal getUserChangeTotal() {
        return userChangeTotal;
    }
    public void setUserChangeTotal(BigDecimal userChange) {
        this.userChangeTotal = userChange;
    }
    
    public BigDecimal getUserMoney() {
        return userMoney;
    }
    
    public void setUserMoney(BigDecimal userMoney) {
        this.userMoney = userMoney;
    }

    public BigDecimal getFive() {
        return five;
    }

    public void setFive(BigDecimal five) {
        this.five = five;
    }

    public BigDecimal getOne() {
        return one;
    }

    public void setOne(BigDecimal one) {
        this.one = one;
    }

    public BigDecimal getQuarters() {
        return quarters;
    }

    public void setQuarters(BigDecimal quarters) {
        this.quarters = quarters;
    }

    public BigDecimal getDimes() {
        return dimes;
    }

    public void setDimes(BigDecimal dimes) {
        this.dimes = dimes;
    }

    public BigDecimal getNickels() {
        return nickels;
    }

    public void setNickels(BigDecimal nickels) {
        this.nickels = nickels;
    }

    public BigDecimal getPennies() {
        return pennies;
    }

    public void setPennies(BigDecimal pennies) {
        this.pennies = pennies;
    }
            
}
