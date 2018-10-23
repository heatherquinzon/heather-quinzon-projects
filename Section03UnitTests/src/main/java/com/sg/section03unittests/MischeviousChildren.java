/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section03unittests;

/**
 *
 * @author heath
 */
public class MischeviousChildren {
    public boolean areWeInTrouble(boolean aSmile, boolean bSmile) {
        
        if((aSmile==true)&&(bSmile==true)){
            return true;
        } else if((aSmile==false)&&(bSmile==false)){
            return true;
        } else{
            return false;
        }

    }

}
