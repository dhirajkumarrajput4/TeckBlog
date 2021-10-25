<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sorry ! something went wrong...</title>
        
        <%@include file="components/comman_css_js.jsp"%>
        
    </head>
    <body>
        <div class="container text-center">
            <image src="img/error.png" class="img-fluid" style="max-width: 300px;">
            <h3>Sorry ! something went wrong...</h3>
            <%=exception%>
            <a href="index.jsp" class="btn btn-lg primary-background text-white mt-4">Home</a>
        </div>
    </body>
</html>
