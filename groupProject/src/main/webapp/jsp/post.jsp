<%-- 
    Document   : content
    Created on : Oct 24, 2018, 1:37:21 PM
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
        <title>The Final Blog: Content</title>
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

            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="${pageContext.request.contextPath}/home">The Final Blog</a>
                    </div>
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="${pageContext.request.contextPath}/home">Home</a>
                        </li>
                        <li class="dropdown active">
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
                        <li class="dropdown">
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

            <h2>Create Blog Page</h2>
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

            <form method="POST" action="createPost" role="form" class="form-horizontal">
                <input type="hidden" 
                       name="${_csrf.parameterName}" 
                       value="${_csrf.token}"/>
                <div class="form-group">
                    <label for="title">Blog Title</label>
                    <input type="text" class="form-control" name="title" required>
                </div>
                <div class="form-group">
                    <label for="category">Category</label>
                    <select style="width: 100%" class="form-control" name="category">
                        <option selected value="">Select A Category</option>
                        <c:forEach var="currentCat" items="${catList}">
                            <option name="cat" value="${currentCat.id}">${currentCat.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">                
                    <textarea rows="15" name="content" required>Write your blog dude!!!</textarea>
                </div>
                <div class="form-group"><br/>
                    <label for="tags">Tags</label>
                    <input type="text" class="form-control" name="tags" id="tag">
                    <button type="button" id="tag-btn" name="tag-btn">Tag</button>
                    <div id="tagDiv"></div>
                </div><br/>
                <button type="submit" name="submitBlog" id="saveBtn">Submit Blog</button>  
            </form>
        </div>

        <script>
            $('#saveBtn').on('click' function(){
            tinyMCE.triggerSave();
            });
        </script>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="js/tags.js"></script>
    </body>
</html>