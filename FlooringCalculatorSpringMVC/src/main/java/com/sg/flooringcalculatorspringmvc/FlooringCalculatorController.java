/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringcalculatorspringmvc;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author heath
 */
@Controller
public class FlooringCalculatorController {
    
    @RequestMapping(value="/calculateArea", 
            method=RequestMethod.POST) 
    public String calculationOfArea(HttpServletRequest request,
            Map<String, Object> model){
        
        String wtc = request.getParameter("widthToCalculate");
        int w = Integer.parseInt(wtc);
        String ltc = request.getParameter("lengthToCalculate");
        int l = Integer.parseInt(ltc);
        String cpsf = request.getParameter("costPerSquareFoot");
        int cost = Integer.parseInt(cpsf);

        int totalArea = w * l;
        int totalCost = w * l * cost;
        
        double time = (w*l) / 20;
        double moneyLC = time * 86;
        
        double grandTotal = totalCost + moneyLC;
        
        model.put("widthToCalculate", wtc);
        model.put("lengthToCalculate", ltc);
        model.put("totalArea", totalArea);
        
        model.put("costPerSquareFoot", cost);
        model.put("totalCost", totalCost);
        
        model.put("timeItTook", time);
        model.put("totalLaborCost", moneyLC);
        
        model.put("grandTotal", grandTotal);
        
        return "result";
    }
    
    
    
}
