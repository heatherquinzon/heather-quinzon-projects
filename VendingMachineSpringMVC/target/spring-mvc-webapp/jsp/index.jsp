<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>VENDING MACHINE</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"> 
        <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/mycss.css" rel="stylesheet"> 
    </head>

    <body>
        <div class="containter">
            <h1>VENDING MACHINE</h1>
            <hr/>
            <ul class="list-group" id="errorMessages"></ul>

            <div class="row">
                <!-- for all vending items buttons -->
                <div class="col-md-9">
                    <h3>Items</h3>
                    <hr/>

                    <div id="items">
                    </div>

                </div>

                <!-- for the output stuff -->
                <div class="col-md-3">

                    <!-- TOTAL $ IN SECTION -->
                    <div class="col-md-12">
                        <h3>Total $ In</h3>
                        <hr/>

                        <!-- INPUT TO SHOW MONEY -->
                        <sf:form modelAttribute="money" action="showMoney" method="POST">
                        <div class="col-md-">
                            <center>
                                <sf:input type="text" id="money-shown" path="money" 
                                          placeholder="Money" readonly/>
                                ${message}
                            </center>
                        </div>
                        </sf:form>

                        <p/>

                        <!-- BUTTONS FOR DOLLAR AND QUARTER -->
                        <div class="row">
                            <div class="col-md-6">
                                <button type="button" id="add-dollar" value="Add Dollar"  class="btn btn-info">Add Dollar</button>
                            </div>
                            <div class="col-md-6">
                                <button type="button" id="add-quarter" value="Add Quarter" class="btn btn-info">Add Quarter</button>
                            </div>
                        </div>

                        <p/>
                        <!-- BUTTONS FOR DIME AND NICKEL -->
                        <div class="row">
                            <div class="col-md-6">
                                <button type="button" id="add-dime" value="Add Dime" class="btn btn-info">Add Dime</button>
                            </div>
                            <div class="col-md-6">
                                <button type="button" id="add-nickel" value="Add Nickel" class="btn btn-info">Add Nickel</button>
                            </div>
                        </div>

                    </div>
                    <p/>

                    <!-- MESSAGES SECTION -->
                    <div class="col-md-12">
                        <h3>Messages</h3>
                        <hr/>

                        <!--Message that Shows -->
                        <div class="col-md-12">
                            <input type="text" class="col-md-12" 
                                   id="message-given" readonly/>
                        </div>
                        <p/>

                        <!--Shows Item Number -->
                        <div id="shows-item-number">
                            Item: 
                            <center><input type="text" style="width: 20%" id="item-number" readonly/></center>
                        </div>
                        <p/>

                        <!--Make Purchase Button -->
                        <div class="col-md-12">
                            <center><button type="button" class="btn btn-success" id="purchase">Make Purchase</button></center>
                        </div>

                    </div>
                    <p/>

                    <!-- CHANGE SECTION -->
                    <div class="col-md-12">
                        <h3>Change</h3>
                        <hr/>

                        <center><textarea readonly name=text1 rows="5" id="change-message"></textarea></center>
                        <p/>

                        <center><button type="button" class="btn btn-danger" id="change-return">Change Return</button></center>
                        <p/>

                    </div>

                </div>
            </div>

        </div>

        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

