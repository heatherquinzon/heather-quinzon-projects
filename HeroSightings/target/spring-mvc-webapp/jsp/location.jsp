<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>LOCATIONS</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/mycss.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Allerta Stencil' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Anton' rel='stylesheet'>        
        <link href='https://fonts.googleapis.com/css?family=Monoton' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Monofett' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Nova Square' rel='stylesheet'>
    </head>
    <body>
        <h1>LOCATIONS!</h1>

        <div class="container">
            <div class="navbar navbar-inverse" id="navBars">
                <ul class="nav nav-tabs">
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/displayherosandvillains">Heros and Villains</a>
                    </li>
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/displaylocations">Super Locations</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/displaysightings">Super Sightings</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/displayorganization">Super Organizations</a>
                    </li>
                </ul> 
            </div>

            <div class="row">
                <div class="col-md-6">
                    <h2>Location List</h2>
                    <table id="locationTable" class="table table-hover">
                        <tr>
                            <th width="40%">Name</th>
                            <th width="15%">City</th>
                            <th width="15%">State</th>
                            <th width="15%"></th>
                            <th width="15%"></th>
                        </tr>
                        <c:forEach var="currentLocation" items="${locList}">
                            <tr>
                                <td>
                                    <a href="displaylocationdetails?locationId=${currentLocation.locationId}">
                                        <c:out value="${currentLocation.name}"/></a>
                                </td>
                                <td>
                                    <c:out value="${currentLocation.city}"/>
                                </td>
                                <td>
                                    <c:out value="${currentLocation.stateInitial}"/>
                                </td>
                                <td>
                                    <a href="displaylocationform?locationId=${currentLocation.locationId}">
                                        Edit</a>
                                </td>
                                <td>
                                    <a href="deletelocation?locationId=${currentLocation.locationId}">
                                        Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>

                <div class="col-md-6">
                    <h2>Add New Location</h2>
                    <form class="form-horizontal" role="form" method="POST" action="createLocation">
                        <!-- NAME -->
                        <div class="form-group">
                            <label for="add-loc-name" class="col-md-4 control-label">Name:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="name" placeholder="Name" required/>
                            </div>
                        </div>
                        <!-- CITY -->
                        <div class="form-group">
                            <label for="add-loc-city" class="col-md-4 control-label">City:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="city" placeholder="City" required/>
                            </div>
                        </div>
                        <!-- STATE INITIAL -->
                        <div class="form-group">
                            <label for="add-loc-state-initial" class="col-md-4 control-label">State Initial:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="stateInitial" placeholder="State Initial" 
                                       required maxlength="2">
                            </div>
                        </div>
                        <!-- ZIPCODE -->
                        <div class="form-group">
                            <label for="add-loc-zipcode" class="col-md-4 control-label">Zipcode:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="zipcode" placeholder="Zipcode" required/>
                            </div>
                        </div> 
                        <!-- LONGITUDE -->
                        <div class="form-group">
                            <label for="add-loc-longitude" class="col-md-4 control-label">Longitude</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="longitude" placeholder="Longitude" />
                            </div>
                        </div> 
                        <!-- LATTITUDE -->
                        <div class="form-group">
                            <label for="add-loc-lattitude" class="col-md-4 control-label">Lattitude:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="lattitude" placeholder="Lattitude" />
                            </div>
                        </div> 
                        <!-- DESCRIPTION -->
                        <div class="form-group">
                            <label for="add-hero-description" class="col-md-4 control-label">Description:</label>
                            <div class="col-md-8">
                                <textarea type="text" class="form-control" name="description" required></textarea>
                            </div>
                        </div>
                        <!-- SUBMIT -->
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" class="btn btn-default" value="Create Location"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
                    
        <div id="footer">
            <hr />  
            <footer>
                <p>&copy; 2018 Heather Quinzon</p>
            </footer>   
        </div>

        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
