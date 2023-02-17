package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.CancellationDao;
import com.revature.dao.impl.CancellationDaoImpl;
import com.revature.model.Order;

/**
 * Servlet implementation class CancellationReasonServlet
 */
@WebServlet("/CancellationReasonServlet")
public class CancellationReasonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CancellationDao cancel = new CancellationDaoImpl();
	public static List<String> orderDetail = new ArrayList();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancellationReasonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        int orderId =Integer.parseInt(request.getParameter("orderId")); 
        
        
        CancellationDao cancel = new CancellationDaoImpl();
        Order orderDetail =cancel.getOrderDetail(orderId);
        
        request.setAttribute("orderDetail", orderDetail);
     
        
	 getServletContext().getRequestDispatcher("/WEB-INF/views/CancellationReason.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
