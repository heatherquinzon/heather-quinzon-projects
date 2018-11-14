<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <title>The Final Blog: Approve</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"> 
        <link href="${pageContext.request.contextPath}/css/thecss.css" rel="stylesheet"> 
        <link href='https://fonts.googleapis.com/css?family=Bungee' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Cabin' rel='stylesheet'>
        <script src="https://cloud.tinymce.com/stable/tinymce.min.js"></script>
        <script>tinymce.init({selector: 'textarea'});</script>
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

            <p>Only Admins can approve posts</p>

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


            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <!-- ALL POSTS THAT NEED APPROVAL  -->
                <div class="col-md-8">
                    <div class="card" style="width: 100%;">
                        <h2>All Posts That Need Approval</h2>
                        <hr/>
                        <c:forEach var="currentPost" items="${postList}">
                            <c:if test="${currentPost.state == 2}">
                                <form method="POST" action="approveThisPost">
                                    <div class="card-body">
                                        <input type="hidden" 
                                               name="${_csrf.parameterName}" 
                                               value="${_csrf.token}"/>
                                        <input type="hidden" 
                                               name="postId" 
                                               value="${currentPost.id}"/>
                                        <h3><c:out value="${currentPost.title}"/></h3>
                                        <b><p>Date: <c:out value="${currentPost.date}"/></p></b>
                                        <b><p>Category: <c:out value="${currentPost.category.name}"/></p></b>
                                        <p readonly class="card-text" style="width: 50%; height: 50%">
                                            ${currentPost.content}
                                        </p>
                                        <c:forEach var="currentTag" items="${currentPost.tags}">
                                            <a href="displayTagPosts?id=${currentTag.id}" class="badge badge-pill badge-light">${currentTag.name} </a>
                                        </c:forEach>
                                        <p/>
                                        <p>
                                            <button type="submit" class="btn btn-success" name="submitBlog">Approve</button>

                                            <a href="deletePost?id=${currentPost.id}" style="color: white" class="btn btn-danger">
                                                Delete
                                            </a>
                                        </p>
                                    </div>
                                </form>
                                <hr/>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>

            </sec:authorize>

        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="js/tags.js"></script>
    </body>
</html>
