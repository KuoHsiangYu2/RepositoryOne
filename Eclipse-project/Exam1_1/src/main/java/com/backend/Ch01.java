package com.backend;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ch01
 */
@WebServlet("/Ch01")
public class Ch01 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ch01() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        // response.getWriter().append("Served at: ").append(request.getContextPath());
        System.out.println("Ch01 Servlet doGet() method");
        processRequest(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        // doGet(request, response);
        System.out.println("Ch01 Servlet doPost() method");
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        /* Setting the Encoding of Input Data */
        request.setCharacterEncoding("UTF-8");

        /* Setting the encoding of the output data to the web page */
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String cname = request.getParameter("cname");
        String start_date = request.getParameter("start_date");
        String end_date = request.getParameter("end_date");
        String start_time = request.getParameter("start_time");
        String end_time = request.getParameter("end_time");

        System.out.println("cname -> " + cname);
        System.out.println("start_date -> " + start_date);
        System.out.println("end_date -> " + end_date);
        System.out.println("start_time -> " + start_time);
        System.out.println("end_time -> " + end_time);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Test_Page_1.html");
        requestDispatcher.forward(request, response);
    }

}
