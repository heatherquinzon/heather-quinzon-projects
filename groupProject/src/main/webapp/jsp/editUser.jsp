<%-- 
    Document   : editUser
    Created on : Oct 29, 2018, 2:09:52 PM
    Author     : Charlie
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>The Final Blog: Admin</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">  
        <link href="${pageContext.request.contextPath}/css/thecss.css" rel="stylesheet"> 
        <link href='https://fonts.googleapis.com/css?family=Bungee' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Cabin' rel='stylesheet'>
    </head>
    <body>
        <div class="container">
            <h1>Hello Security</h1>
            <hr/>
            
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="${pageContext.request.contextPath}/home">The Final Blog</a>
                    </div>
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="${pageContext.request.contextPath}/home">Home</a>
                        </li>
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown"
                               href="${pageContext.request.contextPath}/home">
                                User <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="${pageContext.request.contextPath}/post">
                                        Create Post
                                    </a></li>
                                <li><a href="${pageContext.request.contextPath}/displayCategorysPage">
                                        Category
                                    </a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown active">
                            <a class="dropdown-toggle" data-toggle="dropdown"
                               href="${pageContext.request.contextPath}/admin">
                                Admin <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="${pageContext.request.contextPath}/admin">
                                        Admin
                                    </a></li>
                                <li><a href="${pageContext.request.contextPath}/post">
                                        Create Post
                                    </a></li>
                                <li><a href="${pageContext.request.contextPath}/displayCategorysPage">
                                        Category
                                    </a></li>
                                <li><a href="${pageContext.request.contextPath}/approvePosts">
                                        Approve Post</a></li>
                            </ul>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
                    </ul>
                </div>
            </nav>
                            
            <h2>Edit User Page</h2>
            <sec:authorize access="isAuthenticated()">
                <form class="form-inline" 
                      method="POST" 
                      action="${pageContext.request.contextPath}/logout">
                    <input type="hidden" 
                           name="${_csrf.parameterName}" 
                           value="${_csrf.token}"/>
                    <label for="submit">
                        Hello : ${pageContext.request.userPrincipal.name}&nbsp;&nbsp;&nbsp;|
                    </label>
                    <button class="btn btn-link" id="submit" type="submit">Logout</button>
                </form>
            </sec:authorize>
            <div class="container">
                <div class="row">
                    <h3>Update User</h3>
                    <form method="POST" action="${pageContext.request.contextPath}/editUser">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <input type="hidden" name="id" value ="${user.id}"/>
                        <div class="form-group">
                            <label for="username" class="col-md-4 control-label">Username:</label>
                            <div class="col-md-8">
                                <input type="text" 
                                       class="form-control" 
                                       id="username"
                                       name="username" 
                                       placeholder="Username"
                                       value="${user.username}"
                                       disabled/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="enabled" class="col-md-4 control-label">Enabled:</label>
                            <div class="col-md-8">
                                <label>
                                    <input type="checkbox"  
                                           id="enabled"
                                           name="enabled"
                                           checked="${user.enabled}"/>
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="roleIdList" class="col-md-4 control-label">Roles:</label>
                            <div class="col-md-8">
                                <select id="roleIdList" 
                                        name="roleIdList" 
                                        multiple="multiple" 
                                        class="form-control">
                                    <c:forEach items="${roles}" var="currentRole">
                                        <option value="${currentRole.id}" 
                                                <c:if test="${user.roles.contains(currentRole)}">selected</c:if>>
                                            <c:out value="${currentRole.role}"/>
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" 
                                       class="btn btn-default" 
                                       id="search-button" 
                                       value="Update User"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <h3>Update Password</h3>
                    <c:if test="${error != null}">
                        <div class="alert alert-danger" role="alert">
                            <c:out value="${error}"/>
                        </div>
                    </c:if>
                    <form method="POST" 
                          action="${pageContext.request.contextPath}/editPassword">
                        <input type="hidden" 
                               name="${_csrf.parameterName}" 
                               value="${_csrf.token}"/>
                        <input type="hidden" name="id" value ="${user.id}"/>
                        <div class="form-group">
                            <label for="password" class="col-md-4 control-label">
                                New Password:
                            </label>
                            <div class="col-md-8">
                                <input type="password" 
                                       class="form-control" 
                                       id="password"
                                       name="password"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="confirmPassword" class="col-md-4 control-label">
                                Confirm New Password:
                            </label>
                            <div class="col-md-8">
                                <input type="password" 
                                       class="form-control" 
                                       id="confirmPassword"
                                       name="confirmPassword"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" 
                                       class="btn btn-default" 
                                       id="search-button" 
                                       value="Update Password"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <p>
                Only users with the ADMIN role can see this page.
            </p>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
