<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>ORGANIZATIONS</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/mycss.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Allerta Stencil' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Anton' rel='stylesheet'>        
        <link href='https://fonts.googleapis.com/css?family=Monoton' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Monofett' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Nova Square' rel='stylesheet'>
    </head>
    <body>
        <h1>ORGANIZATIONS!</h1>

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
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/displaysightings">Super Sightings</a>
                    </li>
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/displayorganization">Super Organizations</a>
                    </li>
                </ul> 
            </div>

            <div class="row">
                <div class="col-md-6">
                    <h2>Organization List</h2>
                    <table id="orgTable" class="table table-hover">
                        <tr>
                            <th width="50%">Name</th>
                            <th width="25%"></th>
                            <th width="25%"></th>
                        </tr>
                        <c:forEach var="currentOrg" items="${oList}">
                            <tr>
                                <td>
                                    <a href="displayorgdetails?orgId=${currentOrg.organizationId}">
                                        <c:out value="${currentOrg.name}"/></a>
                                </td>
                                <td>
                                    <a href="displayeditorgform?orgId=${currentOrg.organizationId}">
                                        Edit</a>
                                </td>
                                <td>
                                    <a href="deleteorg?orgId=${currentOrg.organizationId}">
                                        Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>

                <div class="col-md-6">
                    <h2>Add New Organization</h2>
                    <hr/>
                    <form class="form-horizontal" role="form" method="POST" action="createOrg">
                        <!-- ORG NAME -->
                        <div class="form-group">
                            <label for="add-org-name" class="col-md-4 control-label">Name:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="name" placeholder="Name" required/>
                            </div>
                        </div>
                        <!-- PHONE -->
                        <div class="form-group">
                            <label for="add-org-phone" class="col-md-4 control-label">Phone:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="phone" placeholder="Phone" required/>
                            </div>
                        </div>
                        <!-- EMAIL -->
                        <div class="form-group">
                            <label for="add-org-email" class="col-md-4 control-label">Email:</label>
                            <div class="col-md-8">
                                <input type="email" class="form-control" name="email" placeholder="Email" required/>
                            </div>
                        </div>
                        <!-- CITY -->
                        <div class="form-group">
                            <label for="add-org-city" class="col-md-4 control-label">City:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="city" placeholder="City" required/>
                            </div>
                        </div>
                        <!-- STATE INITIAL -->
                        <div class="form-group">
                            <label for="add-org-state-initial" class="col-md-4 control-label">State Initial:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="stateInitial" placeholder="State Initial" required/>
                            </div>
                        </div>
                        <!-- ZIPCODE -->
                        <div class="form-group">
                            <label for="add-org-zipcode" class="col-md-4 control-label">Zipcode:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="zipcode" placeholder="Zipcode" required/>
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
                                <input type="submit" class="btn btn-default" value="Create Organization"/>
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
