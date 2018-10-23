<%-- 
    Document   : result
    Created on : Sep 26, 2018, 2:26:34 PM
    Author     : heath
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Result</title>
    </head>
    <body>
        <h1>Results</h1>
        <hr/>
        
        <p>You put in: </p>
        <p>Width: ${widthToCalculate} ft</p>
        <p>Length: ${lengthToCalculate} ft</p>
        <p>Total area: ${totalArea} square foot</p>
        <p>Cost per square foot: $${costPerSquareFoot}</p>
        
        <b>Total Material Cost(/sqrft): $${totalCost}</b>
        
        <hr/>
        <p>Labor Cost: $86.00/hour</p>
        <p>The team can install flooring material
            at a rate of 20 sqrft per hour. </p>
        <p>The company bills in 15 min increment.</p>
        
        <b>Total time it took to install: ${timeItTook} hr(s)</b>
        <p><b>Total Labor Cost: $${totalLaborCost}</b></p>
        <hr/>
        
        <b>Grand Total: $${grandTotal}</b>
        
        <p>
            <a href="index.jsp">Calculate Another!</a>
        </p>
    </body>
</html>
