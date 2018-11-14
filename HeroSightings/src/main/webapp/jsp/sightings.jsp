<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>SIGHTINGS</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/mycss.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Allerta Stencil' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Anton' rel='stylesheet'>        
        <link href='https://fonts.googleapis.com/css?family=Monoton' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Monofett' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Nova Square' rel='stylesheet'>
    </head>
    <body>
        <h1>SIGHTINGS!</h1>

        <div class="container">
            <div class="navbar navbar-inverse" id="navBars">
                <ul class="nav nav-tabs">
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/displayherosandvillains">Heros and Villains</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/displaylocations">Super Locations</a>
                    </li>
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/displaysightings">Super Sightings</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/displayorganization">Super Organizations</a>
                    </li>
                </ul> 
            </div>

            <div class="row">
                <div class="col-md-8">
                    <h2>All Sightings</h2>
                    <table id="sightingsTable" class="table table-hover">
                        <tr>
                            <th width="40%">Location</th>
                            <th width="30%">Date</th>
                            <th width="15%"></th>
                            <th width="15%"></th>
                        </tr>
                        <c:forEach var="currentSight" items="${sList}">
                            <tr>
                                <td>
                                    <c:out value="${currentSight.location.name}"/>
                                </td>
                                <td>
                                    <c:out value="${currentSight.date}"/>
                                </td>
                                <td>
                                    <a href="displayeditsightingform?sightingsId=${currentSight.sightingsId}">
                                        Edit</a>
                                </td>
                                <td>
                                    <a href="deletesighting?sightingsId=${currentSight.sightingsId}">
                                        Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>

                <div class="col-md-4">
                    <h2>Add New Sighting</h2>
                    <hr/>
                    <form class="form-horizontal" role="form" method="POST" action="createSighting">
                        <!-- LOCATION -->
                        <div class="form-group">
                            <label for="add-sightings-location" class="col-md-4 control-label">Location:</label>
                            <div class="col-md-8">
                                <select style="width: 100%" class="form-control" name="locName">
                                    <c:forEach var="currentLoc" items="${locList}">
                                        <option name="locName" value="${currentLoc.locationId}">${currentLoc.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <!-- DATE -->
                        <div class="form-group">
                            <label for="add-sightings-date" class="col-md-4 control-label">Date:</label>
                            <div class="col-md-8">
                                <input type="date" class="form-control" name="date" placeholder="Date" min="2000-01-01" max="2030-12-31" required/>
                            </div>
                        </div>
                        <!-- SUBMIT -->
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" class="btn btn-default" value="Create Sighting"/>
                            </div>
                        </div>
                    </form>
                </div>

            </div>


            <div id="footer">
                <hr />  
                <footer>
                    <p>&copy; 2018 Heather Quinzon</p>
                </footer>   
            </div>

        </div>

        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
