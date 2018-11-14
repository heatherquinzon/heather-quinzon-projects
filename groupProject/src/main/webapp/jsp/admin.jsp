<%-- 
    Document   : admin
    Created on : Oct 24, 2018, 1:22:33 PM
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
            <h1>The Final Blog</h1>
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

            <h2>Admin Page</h2>
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
                    <button class="btn btn-link" 
                            id="submit" 
                            type="submit">Logout</button>
                </form>
            </sec:authorize>

            <div class="container">
                <div class ="row">
                    <p>
                        Only users with the ADMIN role can see this page.
                    </p>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <h3>Users</h3>
                        <table class="table table-bordered">
                            <tr>
                                <th>Username</th>
                                <th>Roles</th>
                                <th>Enabled</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                            <c:forEach items="${users}" var="currentUser">
                                <tr>
                                    <td><c:out value="${currentUser.username}"/></td>
                                    <td>
                                        <c:forEach items="${currentUser.roles}" var="currentRole">
                                            <c:out value="${currentRole.role}"/>&nbsp;
                                        </c:forEach>
                                    </td>
                                    <td><c:out value="${currentUser.enabled}"/></td>
                                    <td><a href="${pageContext.request.contextPath}/editUser?id=${currentUser.id}">Edit</a></td>
                                    <td>
                                        <form class="form-inline" 
                                              method="POST" 
                                              action="${pageContext.request.contextPath}/deleteUser">
                                            <input type="hidden" 
                                                   name="${_csrf.parameterName}" 
                                                   value="${_csrf.token}"/>
                                            <input type="hidden" 
                                                   name="id" 
                                                   value="${currentUser.id}"/>
                                            <button class="btn btn-link btn-xs" type="submit">Delete</button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
                <div class="container">
                    <div class="row">
                        <h3>Add User</h3>
                        <form class="form form-inline" 
                              method="POST" 
                              action="${pageContext.request.contextPath}/addUser">
                            <input type="hidden" 
                                   name="${_csrf.parameterName}" 
                                   value="${_csrf.token}"/>
                            <label for="username">Username:</label>
                            <input type="text" name="username" id="username">
                            <label for="password">Password:</label>
                            <input type="password" name="password" id="password">
                            <button type="submit">Add User</button>
                        </form>
                    </div>
                </div>
            </div>
        </sec:authorize>


    </div>
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>
</html>
