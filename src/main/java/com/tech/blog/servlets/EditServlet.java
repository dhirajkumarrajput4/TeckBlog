package com.tech.blog.servlets;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.User;
import com.tech.blog.helper.FactoryProvider;
import com.tech.blog.helper.Helper;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet(name = "EditServlet", urlPatterns = {"/EditServlet"})
public class EditServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            System.out.println("called edit servlet");

            String user_email = request.getParameter("user_email");
            String user_name = request.getParameter("user_name");
            String user_password = request.getParameter("user_password");
            String user_about = request.getParameter("user_about");

            Part part = request.getPart("user_profile");

            String imageName = part.getSubmittedFileName();

            //get the use from the session
            HttpSession s = request.getSession();
            User user = (User) s.getAttribute("current_user");
//            set and replace data in old user
            user.setUserEmail(user_email);
            user.setUserName(user_name);
            user.setUserPassword(user_password);
            user.setUserAbout(user_about);
            String oldFile = user.getProfilePic();
            if (!imageName.isEmpty()) {
                System.out.println("==============set image in user");

                user.setProfilePic(imageName);
            } 
            else {

                user.setProfilePic(oldFile);

                System.out.println("==============set old image in user========");

            }

            //update data in database 
            UserDao userdao = new UserDao(FactoryProvider.getFactory());
            boolean ans = userdao.updateUser(user);
            if (ans == true) {

                System.out.println("+++++++++++++++++is not Emptyp++++++++++++++");
//                     out.println("updated");
//                    System.out.println("old Path: " + oldFile);
//                    System.out.println("profile pic: " + user.getProfilePic());

                String path = request.getRealPath("/") + "profile_pics" + File.separator + user.getProfilePic();

                String pathOldFile = request.getRealPath("/") + "profile_pics" + File.separator + oldFile;

                if (user.getProfilePic().equals("default.png"))
                { 
                    System.out.println("is default.png");

                    if (Helper.saveFile(part.getInputStream(), path)) {
                        System.out.println("profile pic updated");

                        Message msg = new Message("Profile Details update successfully", "success", "alert-success");
                        s.setAttribute("msg", msg);
                        response.sendRedirect("profile.jsp");
                    } else {
                        Message msg = new Message("Sorry ! something went wrong try again..", "error", "alert-danger");
                        s.setAttribute("msg", msg);
                        response.sendRedirect("profile.jsp");
                    }
                } 

                else{
                    //Delete old pic
                    Helper.deleteFile(pathOldFile);

                    //  set new pic
                    if (Helper.saveFile(part.getInputStream(), path)) {
                        System.out.println("profile pic updated");

                        Message msg = new Message("Profile Details update successfully", "success", "alert-success");
                        s.setAttribute("msg", msg);

                    } else {
                        Message msg = new Message("Sorry ! something went wrong try again..", "error", "alert-danger");
                        s.setAttribute("msg", msg);

                    }

                }
                response.sendRedirect("profile.jsp");

            } else {
//                out.println("not updated");
                Message msg = new Message("Sorry ! something went wrong try again..", "error", "alert-danger");
                s.setAttribute("msg", msg);
                response.sendRedirect("profile.jsp");

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
