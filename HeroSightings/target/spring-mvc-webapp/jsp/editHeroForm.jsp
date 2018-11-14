<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>EDIT HERO</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/mycss.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Allerta Stencil' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Anton' rel='stylesheet'>  
        <link href='https://fonts.googleapis.com/css?family=Monoton' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Monofett' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Nova Square' rel='stylesheet'>
    </head>
    <body>
        <h1>Edit ${hero.name}</h1>
        <div class="container">

            <div class="navbar navbar-inverse" id="navBars">
                <ul class="nav nav-tabs">
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/displayherosandvillains">Heros and Villains</a>
                    </li>
                    <li role="presentation">
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

            <sf:form class="form-horizontal" role="form" modelAttribute="hero"
                     action="editHero" method="POST">
                <!-- HERO NAME -->
                <div class="form-group">
                    <label for="add-hero-name" class="col-md-4 control-label">Name:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-hero-name"
                                  path="name" placeholder="Name"/>
                        <sf:errors path="name" cssclass="error"></sf:errors>
                        <sf:hidden path="heroVillainId"/>
                    </div>
                </div>
                <!-- HERO POWER -->
                <div class="form-group">
                    <label for="add-hero-power" class="col-md-4 control-label">Power:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-hero-power"
                                  path="power" placeholder="Power"/>
                        <sf:errors path="power" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <!-- HERO TYPE -->
                    <div class="form-group">
                        <label for="add-hero-type" class="col-md-4 control-label">Type:</label>
                        <div class="col-md-8">
                            <p style="text-align: justify">
                            <sf:radiobutton path="type" value="Hero"/>Hero<br>
                            <sf:radiobutton path="type" value="Villain"/>Villain<br>
                        </p>
                        <sf:errors path="type" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <!-- HERO DESCRIPTION -->
                    <div class="form-group">
                        <label for="add-hero-description" class="col-md-4 control-label">Description:</label>
                        <div class="col-md-8">
                        <sf:textarea type="text" class="form-control" id="add-hero-description"
                                     path="description" placeholder="Description"/>
                        <sf:errors path="description" cssclass="error"></sf:errors>

                        </div>
                    </div>
                    <!-- HERO ORGS -->
                    <div class="form-group">
                        <label for="add-hero-organization" class="col-md-4 control-label">Organization:</label>
                        <div class="col-md-8">
                        <c:forEach var="currentOrg" items="${oList}">
                            <p style="text-align: justify">
                                <input type="checkbox" <c:if test="${hero.orgs.contains(currentOrg)}"> checked </c:if>
                                       name="orgId" path="orgs" value="${currentOrg.organizationId}"/>
                                ${currentOrg.name}
                            </p> 
                        </c:forEach>
                    </div>
                </div>
                <!-- HERO SIGHTINGS -->
                <div class="form-group">
                        <label for="add-hero-sightings" class="col-md-4 control-label">Sightings:</label>
                        <div class="col-md-8">
                        <c:forEach var="currentSight" items="${sList}">
                            <p style="text-align: justify">
                                <input type="checkbox" <c:if test="${hero.sightings.contains(currentSight)}"> checked </c:if>
                                       name="sightingsId" path="sightings" value="${currentSight.sightingsId}"/>
                                ${currentSight.location.name} ${currentSight.date}
                            </p> 
                        </c:forEach>
                    </div>
                </div>
                <!-- SUBMIT -->
                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <input type="submit" class="btn btn-default" value="Update Hero"/>
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
