<%@page import="java.util.ArrayList"%>
<%@page import="com.tech.blog.entities.PostCategory"%>
<%@page import="com.tech.blog.dao.PostDao"%>
<%@page import="com.tech.blog.helper.FactoryProvider"%>
<%@page import="com.tech.blog.entities.User"%>


<%
    User user1 = (User)session.getAttribute("current_user");
%>

<nav class="navbar navbar-expand-lg navbar-dark primary-background">
    <a class="navbar-brand" href="index.jsp"><span class="fa fa-asterisk"></span>Tech Blog</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#"><span class="fa fa-bell-o"></span>LearnCode<span class="sr-only">(current)</span></a>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <span class="fa fa-check-square-o"></span>Categories
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Programming Language</a>
                    <a class="dropdown-item" href="#">Project Implementation</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Data Structure</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#"><span class="fa fa-address-book-o"></span>Contect</a>
            </li>


            <%                if (user1 == null) {
            %>


            <li class="nav-item">
                <a class="nav-link" href="login.jsp"><span class="fa fa-user-circle"></span>Login</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="register_page.jsp"><span class="fa fa-user-plus"></span>Sign up</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>
        </form>

        <%
        }
            else 
            {
        %>
        <li class="nav-item">
            <a class="nav-link" href="#" data-toggle="modal" data-target="#postModal"><span class="fa fa-plus-square"></span> Create new Post</a>
        </li>
        </ul>

        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="#" data-toggle="modal" data-target="#Profile-Modal"><span class="fa fa-user-circle"></span><%=user1.getUserName()%></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="LogoutServlet"><span class="fa fa-sign-out"></span>Logout</a>
            </li>
        </ul>

        <!--bootstrap modal-->
        <!--show user profile-->  

        <!-- Modal -->
        <div class="modal fade" id="Profile-Modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">TechBlog</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body" style="max-height: 450px; overflow-y: auto;">
                        <div class="container text-center">
                            <img src="./profile_pics/<%=user1.getProfilePic()%>" alt="profile" class="img-fluid" style="border-radius: 50%; max-width: 150px; max-height: 90px"/>
                            <h6 class="modal-title "><%=user1.getUserName()%></h6>
                            <!--Details-->

                            <div id="profile-detail">
                                <table class="table">

                                    <tbody>
                                        <tr>
                                            <th scope="row">ID : </th>
                                            <td><%=user1.getUserId()%></td>

                                        </tr>
                                        <tr>
                                            <th scope="row">Email : </th>
                                            <td><%=user1.getUserEmail()%></td>

                                        </tr>
                                        <tr>
                                            <th scope="row">Gender : </th>
                                            <td><%=user1.getUserGender()%></td>

                                        </tr>
                                        <tr>
                                            <th scope="row">Status : </th>
                                            <td><%=user1.getUserAbout()%></td>

                                        </tr>
                                        <tr>
                                            <th scope="row">Registered on : </th>
                                            <td><%=user1.getRegisterDate().toString()%></td>

                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div id="profile-edit" style="display:none;">

                                <h6 class="text-info mt-4">Please Edit Carefully</h6>
                                <form action="EditServlet" method="post" enctype="multipart/form-data">
                                    <table class="table">
                                        <tr>
                                            <td>ID :</td>
                                            <td><%=user1.getUserId()%></td>
                                        </tr>
                                        <tr>
                                            <td>Name :</td>
                                            <td><input type="text" class="form-control" name="user_name" value="<%=user1.getUserName()%>"></td>
                                        </tr>
                                        <tr>
                                            <td>Email :</td>
                                            <td><input type="email" class="form-control" name="user_email" value="<%=user1.getUserEmail()%>"></td>
                                        </tr>
                                        <tr>
                                            <td>Password :</td>
                                            <td><input type="password" class="form-control" name="user_password" value="<%=user1.getUserPassword()%>"></td>
                                        </tr>
                                        <tr>
                                            <td>Gender :</td>
                                            <td><%=user1.getUserGender().toUpperCase()%></td>
                                        </tr>
                                        <tr>
                                            <td>About yourself :</td>
                                            <td><textarea class="form-control" name="user_about" rows="4"><%=user1.getUserAbout()%></textarea></td>
                                        </tr>
                                        <tr>
                                            <td>Profile pic :</td>
                                            <td><input type="file" class="form-control" name="user_profile"></td>
                                        </tr>
                                    </table>   
                                    <div class="container text-center">
                                        <button type="submit" class="btn btn-outline-primary">Save</button>
                                        <button type="reset" class="btn btn-outline-danger">Reset</button>
                                    </div>
                                </form>
                            </div>

                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button id="edit-profile-btn" type="button" class="btn btn-primary">EDIT</button>
                    </div>

                </div>
            </div>
        </div>
        <%
            }
        %>
        

<!--Create Post modal-->
<!-- Modal -->

<div class="modal fade" id="postModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header primary-background text-white">
        <h5 class="modal-title" id="exampleModalLabel">Provide the Post details</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
        <div class="modal-body" style="max-height:450px;overflow-y:auto;">
        <!--modal body-->
        
        <!--Form--> 
        
        <form id="add-post-form" action="AddPostServlet" method="post" enctype="multipart/form-data">
            
            <div class="form-group">
                <select class="form-control" name="postcategoryid">
                    <option selected disabled>---Select Category---</option>
                    <%
                    PostDao dao=new PostDao(FactoryProvider.getFactory());
                    ArrayList<PostCategory> list=dao.getAllCategory();
                    for(PostCategory c:list)
                    {
                        
                    %>
                    <option value="<%=c.getCategoryId()%>"><%=c.getCategoryName()%></option>
                    <%
                        
                    }
                    %>
                </select>
            </div>
            <div class="form-group">
                <input type="text" name="posttitle" placeholder="Enter the post title" class="form-control"/>
            </div>
            <div class="form-group">
                <textarea type="text" name="postcontent" placeholder="Enter your Content" class="form-control" rows="5"></textarea>
            </div>
            <div class="form-group">
                <textarea type="text" name="code" placeholder="Enter your program (if any)" class="form-control" rows="5"></textarea>
            </div>
            <div class="form-group">
                <label>Add your image:</label>
                <input type="file" name="pic"  class="form-control"/>
            </div>
                <div class="container text-center">
                    <button type="submit" class="btn btn-primary">Post now</button>
                    
                </div>
        </form>
          
          
          
          
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<!--Create post modal End-->

    </div>
</nav>

