<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SUPERSIGHTINGS</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/mycss.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Allerta Stencil' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Anton' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Monoton' rel='stylesheet'> 
        <link href='https://fonts.googleapis.com/css?family=Monofett' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Nova Square' rel='stylesheet'>
    </head>
    <body>
        <div class="container">

            <header>
                <div class="col-md-3">
                    <img src="images\supers.png" 
                         width="75%" alt="SuperLogo">
                </div>
                <br>
                <br>
                <br>

                <div class="navbar navbar-inverse col-md-9" id="navBars">
                    <ul class="nav nav-tabs">
                        <li role="presentation" class="active">
                            <a href="${pageContext.request.contextPath}/home">Home</a>
                        </li>
                        <li role="presentation">
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
            </header>
            <br>
            <br>
            
            <div class="row">
                <h2>About Supers!</h2>
                <div class="col-md-12" id="intro">
                    <p style="text-align: justify">Latest sightings for both Super Heros and Super Villains are on the rise. 
                        With more and more mutants ever since "The Smoke", we have risen to become either
                        a Hero or a Villain. Either way, we've got the latest news on the latest sightings for both.</p>

                    <p style="text-align: justify">SUPERS is here to help you keep track of Heros and Villains. 
                        Whether it's to keep track of your favorite Heros to the ability to keep away form well known villain, 
                        we've got the latest scoop on it all. Here at SUPERS you can add details for your Hero / Villain,
                        any known Super Organization, the locations they've been spotted, and the sighting details.</p>
                </div>

            </div>

            <div class="row">
                <h2>Latest Sightings</h2>
                <div class="col-md-9" id="latest-sightings">
                    <h3>The Latest Spottings</h3>
                    <table id="sightingsTable" class="table table-hover">
                        <tr>
                            <th width="30%">Hero / Villain</th>
                            <th width="40%">Location</th>
                            <th width="30%">Date</th>
                        </tr>
                        <c:forEach var="currentSight" items="${sList}">
                            <tr>
                                <td>
                                    <c:forEach var="currentHero" items="${hvList}">
                                        <p> <c:if test="${currentHero.sightings.contains(currentSight)}">${currentHero.name}</c:if>
                                            </p>
                                    </c:forEach>
                                </td>
                                <td>
                                    <c:out value="${currentSight.location.name}"/>
                                </td>
                                <td>
                                    <c:out value="${currentSight.date}"/>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>

        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

        <div id="footer">
            <hr />  
            <footer>
                <p>&copy; 2018 Heather Quinzon</p>
            </footer>   
        </div>

    </body>
</html>

