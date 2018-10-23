<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Tic Tac Toe</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"> 
        <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/mine.css" rel="stylesheet"> 
    </head>
    <body>
        <div class="container">
            <h1>Tic Tac Toe</h1>
            <hr/>

            <form class="form-inline" method="POST" action="playTTT">
                <div class="grid">
                    <div class="cell">
                        <button type="submit" name="grid" value="1"/>
                        <p>${message1}</p>
                    </div>
                    <div class="cell">
                        <button type="submit" name="grid" value="2"/>
                        <p>${message2}</p>
                    </div>
                    <div class="cell">
                        <button type="submit" name="grid" value="3"/>
                        <p>${message3}</p>
                    </div>
                    <div class="cell">
                        <button type="submit" name="grid" value="4"/>
                        <p>${message4}</p>
                    </div>
                    <div class="cell">
                        <button type="submit" name="grid" value="5"/>
                        <p>${message5}</p>
                    </div>
                    <div class="cell">
                        <button type="submit" name="grid" value="6"/>
                        <p>${message6}</p>
                    </div>
                    <div class="cell">
                        <button type="submit" name="grid" value="7"/>
                        <p>${message7}</p>
                    </div>
                    <div class="cell">
                        <button type="submit" name="grid" value="8"/>
                        <p>${message8}</p>
                    </div>
                    <div class="cell">
                        <button type="submit" name="grid" value="9"/>
                        <p>${message9}</p>
                    </div>
                </div>
            </form>



        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

