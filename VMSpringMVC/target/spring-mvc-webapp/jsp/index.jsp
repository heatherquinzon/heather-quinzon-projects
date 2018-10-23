<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vending Machine</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/mine.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Unica One' rel='stylesheet'>        
    </head>
    <body>
        <div class="container">
            <h1>Vending Machine</h1>
            <hr/>

            <div class="row">

                <!-- ITEMS SECTION -->
                <div class="col-md-9" id="items-section">
                    <h2>Items</h2>
                    <c:forEach var="currentItem" items="${itemList}">
                        <form method="POST" action="userItem">
                            <button name="itemChoice" value="${currentItem.itemName}" class="btn btn-warning col-md-4">
                                <p><c:out value="${currentItem.itemName}"/></p>
                                <p><c:out value="${currentItem.itemDesc}"/></p>
                                <p><c:out value="$${currentItem.cost}"/></p>
                                <p><c:out value="Quantity: ${currentItem.inventoryAmount}"/></p>  
                            </button>
                        </form>
                    </c:forEach>
                </div>

                <!-- OUTPUT SECTION -->
                <div class="col-md-3">

                    <!-- Total $ Section -->
                    <div class="col-md-12" id="moneySection">
                        <h3>TOTAL $ IN</h3>
                        <hr/>

                        <input type="text" value="${moneyMessage}"/>
                        <p/>

                        <form method="POST" action="getMoney">
                            <!-- BUTTONS FOR DOLLAR AND QUARTER -->
                            <div class="row">
                                <div class="col-md-6">
                                    <button type="submit" id="add-dollar" name="coins" value="1.00" class="btn btn-info">Add Dollar</button>
                                </div>
                                <div class="col-md-6">
                                    <button type="submit" id="add-quarter" name="coins" value="0.25" class="btn btn-info">Add Quarter</button>
                                </div>
                            </div>

                            <p/>
                            <!-- BUTTONS FOR DIME AND NICKEL -->
                            <div class="row">
                                <div class="col-md-6">
                                    <button type="submit" id="add-dime" name="coins" value="0.10" class="btn btn-info">Add Dime</button>
                                </div>
                                <div class="col-md-6">
                                    <button type="submit" id="add-nickel" name="coins" value="0.05" class="btn btn-info">Add Nickel</button>
                                </div>
                            </div> 
                        </form>

                    </div>

                    <!-- Message Section -->
                    <div class="col-md-12">
                        <h3>MESSAGE</h3>
                        <hr/>

                        <input type="text" value="${message}"/>

                        <div class="row">
                            <label>Item:</label>
                            <p/>
                            <input type="text" value="${itemMessage}"/>
                            <p/>
                        </div>

                        <form method="POST" action="makePurchase">
                            <button name="make-purchase" class="btn btn-success">Make Purchase</button>
                        </form>
                    </div>

                    <!-- Change Section -->
                    <div class="col-md-12">
                        <h3>CHANGE</h3>
                        <hr/>

                        <textarea readonly rows="5">Quarters: ${quarters}&#13;&#10;Dimes: ${dimes}&#13;&#10;Nickels: ${nickels}&#13;&#10;Pennies: ${pennies}&#13;&#10;
                        </textarea>
                        <p/>

                        <form action="reset" method="POST">
                            <button type="submit" class="btn btn-danger" id="change-return">Change Return</button>
                        </form>

                    </div>

                </div>




            </div>




        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

