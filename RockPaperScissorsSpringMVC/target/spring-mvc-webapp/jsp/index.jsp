<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>RCP</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h2>Rock Paper Scissors</h2>
            <hr/>

            <p>Let's play Rock Paper Scissors!</p>
            <p>You know the rules! Give me either a rock, paper, or scissors</p>

            <p>Choose rock, paper of scissors: </p>
            <form method="POST" action="resultChoice">
                <input type="text" name="choice"/>
                <p/>
                <input type="submit" value="Submit"/>
            </form>

            <p>You picked: ${choice}</p>
            <p>Computer picked: ${compChoice}</p>
            <b>${message}</b>

            <p>User Wins/Loss/Ties</p>
            <p>Wins: ${win}</p>
            <p>Ties: ${tie}</p>
            <p>Loss: ${lose}</p>

            <form action="reset" method="POST">
                <button type="submit">Reset Scores</button>
            </form>

        </div>

        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

