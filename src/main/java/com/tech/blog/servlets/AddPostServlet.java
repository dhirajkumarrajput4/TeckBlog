/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.blog.servlets;

import com.tech.blog.dao.PostDao;
import com.tech.blog.entities.Post;
import com.tech.blog.entities.PostCategory;
import com.tech.blog.entities.User;
import com.tech.blog.helper.FactoryProvider;
import com.tech.blog.helper.Helper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author apptech
 */
@MultipartConfig
@WebServlet(name = "AddPostServlet", urlPatterns = {"/AddPostServlet"})
public class AddPostServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            /* TODO output your page here. You may use following sample code. */
            System.out.println("+++++++++++++++++++AddproductServlet called");
            PostDao pdao = new PostDao(FactoryProvider.getFactory());
            int pcid = Integer.parseInt(request.getParameter("postcategoryid"));
            PostCategory pc = pdao.getCategoryById(pcid);

            String pTitle = request.getParameter("posttitle");
            String pContent = request.getParameter("postcontent");
            String pCode = request.getParameter("code");
            Part part = request.getPart("pic");

            HttpSession httpsession = request.getSession();
            User user = (User) httpsession.getAttribute("current_user");

            System.out.println("++++++++++Constructor before called of Post Class++++++++++++++");
            Post post = new Post(pTitle, pContent, pCode, part.getSubmittedFileName(), pc, user);
//            post.setCategory_Id(pc);
//            System.out.println("PC is :============> " + pc);
//            System.out.println("++++++++++Constructor called of Post Class++++++++++++++");
//            PostDao pdao=new PostDao(FactoryProvider.getFactory());

           if(pdao.savePost(post))
           {
            
             String path = request.getRealPath("/") + "blog_pics" + File.separator + part.getSubmittedFileName();
             Helper.saveFile(part.getInputStream(), path);
                
               out.println("Done");
           }
           else
           {
                out.println("Error");
               
           }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
