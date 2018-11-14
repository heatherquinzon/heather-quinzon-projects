<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>SUPERHEROS</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/mycss.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Allerta Stencil' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Anton' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Monoton' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Monofett' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Nova Square' rel='stylesheet'>
    </head>
    <body>
        <h1>SUPERHEROS!</h1>

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

            <div class="row">

                <div class="col-md-6">
                    <div class="card" style="width: 100%">
                        <h2>Hero List</h2>
                        <hr/>
                        <c:forEach var="currentHero" items="${hvList}">
                            <h3><a href="displayherodetails?heroId=${currentHero.heroVillainId}">
                                    <c:out value="${currentHero.name}"/></a></h3>
                            <b><p>Type: <c:out value="${currentHero.type}"/></p></b>
                            <p readonly class="card-text" style="width: 75%; height: 50%">
                                <c:out value="${currentHero.description}"/>
                            </p>
                            <a href="displayeditheroform?heroId=${currentHero.heroVillainId}" class="btn btn-default" 
                               style="color: white">
                                Edit</a>
                            <a href="deletehero?heroId=${currentHero.heroVillainId}" class="btn btn-default">
                                Delete</a>
                            <hr/>
                        </c:forEach>
                    </div>
                </div>

                <div class="col-md-6">
                    <h2>Add New Super</h2>
                    <hr/>
                    <form class="form-horizontal" role="form" method="POST" action="createHero">
                        <!-- HERO NAME -->
                        <div class="form-group">
                            <label for="add-hero-name" class="col-md-4 control-label">Name:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="name" placeholder="Name" required/>
                            </div>
                        </div>
                        <!-- POWER -->
                        <div class="form-group">
                            <label for="add-hero-power" class="col-md-4 control-label">Power:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="power" placeholder="Power" required/>
                            </div>
                        </div>
                        <!-- TYPE -->
                        <div class="form-group">
                            <label for="add-hero-type" class="col-md-4 control-label">Type:</label>
                            <div class="col-md-8">
                                <p style="text-align: justify">
                                    <input type="radio" name="type" value="Hero">Hero<br>
                                    <input type="radio" name="type" value="Villain">Villain<br></p>
                            </div>
                        </div>
                        <!-- DESCRIPTION -->
                        <div class="form-group">
                            <label for="add-hero-description" class="col-md-4 control-label">Description:</label>
                            <div class="col-md-8">
                                <textarea type="text" class="form-control" name="description" required></textarea>
                            </div>
                        </div>
                        <!-- ORGANIZATION -->
                        <div class="form-group">
                            <label for="add-hero-organization" class="col-md-4 control-label">Organization:</label>
                            <div class="col-md-8">
                                <c:forEach var="currentOrg" items="${oList}">
                                    <p style="text-align: justify">
                                        <input type="checkbox" name="orgId" value="${currentOrg.organizationId}"/>${currentOrg.name}</p> 
                                    </c:forEach>
                            </div>
                        </div>
                        <!-- SIGHTINGS -->
                        <div class="form-group">
                            <label for="add-hero-sightings" class="col-md-4 control-label">Sightings:</label>
                            <div class="col-md-8">
                                <c:forEach var="currentSight" items="${sList}">
                                    <p style="text-align: justify">
                                        <input type="checkbox" name="sightingsId" value="${currentSight.sightingsId}"/>
                                        ${currentSight.location.name} ${currentSight.date}</p> 
                                    </c:forEach>
                            </div>
                        </div>
                        <!-- SUBMIT -->
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" class="btn btn-default" value="Create Super"/>
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
