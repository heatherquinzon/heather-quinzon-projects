<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Fake Twitter</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/thecss.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Audiowide' rel='stylesheet'>        
    </head>
    <body>
        <div class="container">
            <h1>WELCOME TO FAKE TWITTER</h1>
            <hr/>
            <h2>Comment all you'd like</h2>
            <hr/>
            
            <!-- This is the Home button -->
            <header>
                <a href="${pageContext.request.contextPath}/index.jsp">Home</a>
            </header>
            <p/>
            
            <!-- This is how the user puts in their post -->
            <div class="left-sidebar">
                <div class="col-md-12">
                    <form action="createPost">
                        <div class="row">
                            <input placeholder="Enter userName here"/>
                        </div>
                        <p/>
                        <div class="row">
                            <textarea rows="5" class="text-input" placeholder="Write Something"></textarea>
                        </div>
                        <p/>
                        <div class="row">
                            <span class="normal">240 characters left</span>
                            <button type="submit" class="btn btn-warning">Post</button>
                        </div>
                    </form>
                </div>
            </div>
            
            <!-- This will show the post -->
            <div class="main">
                blahablahabalahbalah
            </div>


        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

