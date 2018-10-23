<%-- 
    Document   : result
    Created on : Sep 27, 2018, 9:10:56 AM
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
        <h1>Alright! Let's See Who Won!</h1>
        
        <p>You picked: ${choice}</p>
        <p>Computer picked: ${compChoice}</p>
        <b>${outputAns}</b>
        
        <p>User Wins/Loss/Ties</p>
        <p>Wins: ${win}</p>
        <p>Ties: ${tie}</p>
        <p>Loss: ${loss}</p>
        
        <p>
            <a href="index.jsp">Play Again!</a>
        </p>
        
    </body>
</html>
