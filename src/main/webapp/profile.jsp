
<%@page import="com.tech.blog.entities.Message"%>
<%@page import="com.tech.blog.entities.User"%>
<%@page errorPage="error_page.jsp" %>
<%
    User user = (User) session.getAttribute("current_user");

    if (user == null) {
        response.sendRedirect("login.jsp");
    }

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>
        <%@include file="components/comman_css_js.jsp"%>
    </head>
    <body>
        <%@include file="components/navbar.jsp" %>

        <%            Message m = (Message) session.getAttribute("msg");
            if (m != null) {
        %>
        <div class="alert <%=m.getCssClass()%> text-center" role="alert">
            <%=m.getContent()%>
        </div>
        <%
                session.removeAttribute("msg");
            }
        %>

        <main>

            <div class="container">
                <div class="row mt-4">
                    <!--//first colom-->
                    <div class="col-md-4">
                        <!--Categories-->
                        <div class="list-group">
                            <a href="#" class="list-group-item list-group-item-action active" onclick="getPost(0)" id="allpost">
                                All Posts
                            </a>
                            <%
                                PostDao pdao=new PostDao(FactoryProvider.getFactory());
                                ArrayList<PostCategory> list2=pdao.getAllCategory();
                                for(PostCategory pc:list2)
                                {
                                    %>
                                    <a href="#" onclick="getPost(<%=pc.getCategoryId()%>)" class="list-group-item list-group-item-action"><%=pc.getCategoryName()%></a>
                                    <%
                                    
                                }
                            %>
                            
                            
                            
                            
                            
                        </div>
                    </div>

                    <!--second colomn-->
                    <div class="col-md-8">
                        <!--Posts-->
                            
                        <div class="container text-center" id="loader">
                            <i class="fa fa-refresh fa-4x fa-spin"></i>
                            <h4 class="mt-2">Loading posts...</h4>
                            
                        </div>
                        
                        <div class="container-fluid" id="post-container">
                            
                        </div>
                        

                    </div>
                </div>
            </div>
        </main>


        <!--CDN sweet alert-->     

        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js" integrity="sha512-AA1Bzp5Q0K1KanKKmvN/4d3IRKVlv9PYgwFPvm32nPO6QS8yH1HO7LbgB1pgiOxPtfeg5zEn2ba64MUcqJx6CA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    </body>
</html>
