<%@page import="com.tech.blog.helper.Helper"%>
<%@page import="com.tech.blog.entities.PostCategory"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.tech.blog.entities.Post"%>
<%@page import="java.util.List"%>
<%@page import="com.tech.blog.dao.PostDao"%>
<%@page import="com.tech.blog.helper.FactoryProvider"%>

<%@include file="components/comman_css_js.jsp" %>
<div class="row">

    <%
        PostDao d = new PostDao(FactoryProvider.getFactory());
        
        int cid =Integer.parseInt(request.getParameter("cid"));
         PostCategory pc = d.getCategoryById(cid);          //convert interger to PostCategory type
//        System.out.println("Cat ID ;;;;;;;;;"+cid);
                
        List<Post> posts = null;
        if(cid==0) 
        {
            
            posts = d.getAllPost();
        } 
        else
        {
            posts = d.getPostById(pc);
        }
        %>
        
        <%
        for (Post p : posts)
        {
    %>
    <div class="col-md-6">
        <div class="card mb-4" style="height: 550px;">
            <img class="card-img-top" src="blog_pics/<%=p.getPostPic()%>" alt="Card image cap">
            <div class="card-body" id="cardid">
                <b><%=p.getPostTitle()%></b>
                <p><%=Helper.get50Word(p.getPostContent())%></p>
                <pre style="height: 100px;"><%=p.getPostCode()%></pre>
            </div>
        </div>
    </div>

    <%
            }%>


</div>