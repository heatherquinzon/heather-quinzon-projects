<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>EDIT ORGANIZATION</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/mycss.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Allerta Stencil' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Anton' rel='stylesheet'> 
        <link href='https://fonts.googleapis.com/css?family=Monoton' rel='stylesheet'> 
        <link href='https://fonts.googleapis.com/css?family=Monofett' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Nova Square' rel='stylesheet'>
    </head>
    <body>
        <h1>Edit ${org.name}</h1>
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

            <sf:form class="form-horizontal" role="form" modelAttribute="org"
                     action="editOrg" method="POST">
                <!-- ORG NAME -->
                <div class="form-group">
                    <label for="add-org-name" class="col-md-4 control-label">Name:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-org-name"
                                  path="name" placeholder="Name"/>
                        <sf:errors path="name" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <!-- ORG PHONE -->
                    <div class="form-group">
                        <label for="add-org-phone" class="col-md-4 control-label">Phone:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-org-phone"
                                  path="phone" placeholder="Phone"/>
                        <sf:errors path="phone" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <!-- ORG EMAIL-->
                    <div class="form-group">
                        <label for="add-org-email" class="col-md-4 control-label">Email:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-org-email"
                                  path="email" placeholder="Email"/>
                        <sf:errors path="email" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <!-- ORG DESCRIPTION -->
                    <div class="form-group">
                        <label for="add-org-description" class="col-md-4 control-label">Description:</label>
                        <div class="col-md-8">
                        <sf:textarea type="text" class="form-control" id="add-org-description"
                                     path="description" placeholder="Description"/>
                        <sf:errors path="description" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <!-- ORG CITY -->
                    <div class="form-group">
                        <label for="add-org-city" class="col-md-4 control-label">City:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-org-city"
                                  path="city" placeholder="City"/>
                        <sf:errors path="city" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <!-- ORG STATE -->
                    <div class="form-group">
                        <label for="add-org-state-initial" class="col-md-4 control-label">State (Initial):</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-org-state-initial"
                                  path="stateInitial" placeholder="State Initial"/>
                        <sf:errors path="stateInitial" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <!-- ORG ZIPCODE -->
                    <div class="form-group">
                        <label for="add-org-zipcode" class="col-md-4 control-label">Zipcode:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-org-zipcode"
                                  path="zipcode" placeholder="Zipcode"/>
                        <sf:errors path="zipcode" cssclass="error"></sf:errors>
                        <sf:hidden path="organizationId"/>
                        </div>
                    </div>
                    <!-- SUBMIT -->
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <input type="submit" class="btn btn-default" value="Update Organization"/>
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
