/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.dao.UserDao;
import com.model.User;
import jakarta.servlet.RequestDispatcher;

/**
 *
 * @author
 */
@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
        private static String INSERT = "/user.jsp";
        private static String EDIT = "/editUser.jsp";
        private static String LIST_USER = "/listUser.jsp";
        private UserDao dao;
        
        public UserController() throws ClassNotFoundException {
            super();
            dao = new UserDao();
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String forward = "";

        if (action.equalsIgnoreCase("delete")) {
            String userId = request.getParameter("userId");
            dao.deleteUser(userId);
            forward = LIST_USER;
            request.setAttribute("users", dao.getAllUsers());
        } else if (action.equalsIgnoreCase("edit")) {
            String userId = request.getParameter("userId");
            User user = dao.getUserById(userId);
            forward = EDIT;
            request.setAttribute("user", user);
        } else if (action.equalsIgnoreCase("listUser")) {
            forward = LIST_USER;
            request.setAttribute("users", dao.getAllUsers());
        } else if (action.equalsIgnoreCase("insert")) {
            forward = INSERT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
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
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");

    User user = new User();
    user.setUserId(request.getParameter("userId"));
    user.setFirstName(request.getParameter("firstName"));
    user.setLastName(request.getParameter("lastName"));

    if (action.equalsIgnoreCase("edit")) {
        dao.updateUser(user);
    } else if (action.equalsIgnoreCase("insert")) {
        dao.addUser(user);
    }

    RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
    request.setAttribute("users", dao.getAllUsers());
    view.forward(request, response);
}

}


