<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register page</title>
        <%@include file="components/comman_css_js.jsp"%>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
    </head>
    <body>
        <%@include file="components/navbar.jsp"%>

        <main class="primary-background pt-4 pb-5 banner-background">
            <div class="container">
                <div class="col-md-6 offset-md-3">
                    <div class="card">
                        <div class="card-header  primary-background text-white text-center">
                            <span class="fa fa-user-circle fa-3x"></span>
                            <p>Register here</p>
                        </div>
                        <div class="card-body">
                            <!--form-->
                            <form id="reg-form" action="RegisterServlet" method="post">
                                <div class="form-group">
                                    <label for="Name">User Name</label>
                                    <input type="text" class="form-control" id="InputName" name="username" aria-describedby="emailHelp" placeholder="Enter name" required>
                                </div>
                                <div class="form-group">
                                    <label for="Email1">Email address</label>
                                    <input type="email" class="form-control" id="InputEmail1" name="useremail" aria-describedby="emailHelp" placeholder="Enter email" required>
                                </div>
                                <div class="form-group">
                                    <label for="Password">Password</label>
                                    <input type="password" class="form-control" id="InputPassword1" name="userpassword" placeholder="Password" required>
                                </div>
                                <div class="form-group">
                                    <label for="gender">Select gender</label>
                                    <br>
                                    <input type="radio" id="male" name="usergender" value="male" required>Male
                                    <input type="radio" id="female" name="usergender" value="female">Female

                                </div>
                                <div class="form-group">
                                    <textarea class="form-control" name="about" col="30" row="10" placeholder="Enter something yourself" required></textarea>
                                </div>

                                <div class="form-check">
                                    <input type="checkbox" name="check" class="form-check-input" id="exampleCheck1">
                                    <label class="form-check-label" for="exampleCheck1">Agree terms and conditions</label>
                                </div><br>
                                <div class="conainer text-center" id="loader" style="display: none;">
                                    <span class="fa fa-refresh fa-spin fa-3x"></span>
                                    <h5>Please wait...</h5>
                                </div>
                                <div class="container text-center">
                                    <button id="submit-btn" type="submit" class="btn btn-primary mt-2">Submit</button>
                                </div>
                            </form> 

                        </div>

                    </div>

                </div>
            </div>
        </main>

        <script>
            
        </script>

    </body>
</html>
