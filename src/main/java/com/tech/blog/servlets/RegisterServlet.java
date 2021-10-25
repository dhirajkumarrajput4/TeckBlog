/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.blog.servlets;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.User;
import com.tech.blog.helper.FactoryProvider;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author apptech
 */
@MultipartConfig
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        
            String check=request.getParameter("check");
                 
            if(check==null)
            {
                out.println("Box not checked");
            }
            else
            {
            
            String userName=request.getParameter("username");
            String userEmail=request.getParameter("useremail");
            String userPassword=request.getParameter("userpassword");
            String userGender=request.getParameter("usergender");
            String userAbout=request.getParameter("about");
                
            User user=new User();
            user.setUserName(userName);
            user.setUserEmail(userEmail);
            user.setUserPassword(userPassword);
            user.setUserGender(userGender);
            user.setUserAbout(userAbout);
            user.setRegisterDate(new Date());
            user.setProfilePic("default.png");
            
            UserDao dao=new UserDao(FactoryProvider.getFactory());
            
            
            if(dao.saveUser(user))
            {
                out.println("done");
            }
            else
            {
                out.println("Error");
            }
               
            
            
            }
            
            
            
        }
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
