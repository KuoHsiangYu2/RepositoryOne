package com.backend;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Inquire1
 */
@WebServlet("/Inquire1")
public class Inquire1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inquire1() {
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
        System.out.println("Inquire1 doGet");
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
        System.out.println("Inquire1 doPost");
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
        
        String country1 = request.getParameter("country1");
        String cardId = request.getParameter("cardId");

        System.out.println("country1 -> " + country1);
        System.out.println("cardId -> " + cardId);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/restrictEnterString.html");
        requestDispatcher.forward(request, response);
    }

}
