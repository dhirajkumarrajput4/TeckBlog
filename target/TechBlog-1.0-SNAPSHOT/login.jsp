<%@page import="com.tech.blog.entities.Message"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
        <%@include file="components/comman_css_js.jsp"%>
    </head>
    <body>
        <!--navbar-->

        <%@include file="components/navbar.jsp"%>

        <main class="d-flex align-items-center primary-background banner-background" style="height: 80vh;">

            <div class="container">
                <div class="row">
                    <div class="col-md-4 offset-md-4">
                        <div class="card">
                            <div class="card-header primary-background text-white text-center">
                                <span class="fa fa-user-plus fa-3x"></span>
                                <br>

                                <p>Login here</p>
                            </div>
                            <%
                                Message m = (Message) session.getAttribute("msg");
                                if (m != null) {
                            %>
                            <div class="alert <%=m.getCssClass()%>" role="alert">
                                <%=m.getContent()%>
                            </div>
                            <%
                                session.removeAttribute("msg");
                                }
                            %>
                            
                           
                            <div class="card-body">
                                <form action="Login_servlet" method="post">
                                    <div class="form-group">
                                        <label for="Email1">Email address</label>
                                        <input type="email" class="form-control" id="InputEmail1" name="email" aria-describedby="emailHelp" placeholder="Enter email">
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputPassword1">Password</label>
                                        <input type="password" class="form-control" id="exampleInputPassword1" name="password" placeholder="Password">
                                    </div>
                                    <div class="form-check">
                                        <input type="checkbox" class="form-check-input" id="exampleCheck1">
                                        <label class="form-check-label" for="exampleCheck1">Check me out</label>
                                    </div>
                                    <button type="submit" class="btn btn-primary">Submit</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </body>
</html>
