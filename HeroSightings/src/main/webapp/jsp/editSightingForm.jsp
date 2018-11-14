<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>EDIT SIGHTING</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/mycss.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Allerta Stencil' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Anton' rel='stylesheet'>      
        <link href='https://fonts.googleapis.com/css?family=Monoton' rel='stylesheet'> 
        <link href='https://fonts.googleapis.com/css?family=Monofett' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Nova Square' rel='stylesheet'>
    </head>
    <body>
        <h1>Edit ${sighting.name}</h1>
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

            <p/>

            <sf:form class="form-horizontal" role="form" modelAttribute="sighting"
                     action="editSighting" method="POST">
                <!-- LOCATION -->
                <div class="form-group">
                    <label for="add-sightings-location" class="col-md-4 control-label">Location:</label>
                    <div class="col-md-8">
                        <select style="width: 100%" class="form-control" name="locName">
                            <c:forEach var="currentLoc" items="${locList}">
                                <option value="${currentLoc.locationId}"
                                        <c:if test="${sighting.location.locationId == currentLoc.locationId}"> selected="selected"</c:if>
                                            >
                                        ${currentLoc.name}
                                </option>
                            </c:forEach>
                        </select>
                        <sf:errors path="location" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <!-- DATE -->
                    <div class="form-group">
                        <label for="add-sightings-date" class="col-md-4 control-label">Date:</label>
                        <div class="col-md-8">
                        <sf:input type="date" class="form-control" path="date" id="add-sightings-date"
                                  placeholder="YYYY-MM-DD" min="2000-01-01" max="2030-12-31" required="true"/>
                        <sf:errors path="date" cssclass="error"></sf:errors>
                        <sf:hidden path="sightingsId"/>
                    </div>
                </div>
                 <!-- SUBMIT -->
                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <input type="submit" class="btn btn-default" value="Update Sighting"/>
                    </div>
                </div>   
            </sf:form>

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
