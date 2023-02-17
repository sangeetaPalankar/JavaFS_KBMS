package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.CancellationDao;
import com.revature.dao.impl.CancellationDaoImpl;
import com.revature.model.Order;

/**
 * Servlet implementation class OrderReceiptServlet
 */
@WebServlet("/OrderReceiptServlet")
public class OrderReceiptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderReceiptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int orderId = Integer.valueOf(request.getParameter("receiptOid"));
		
		System.out.println("order id for receipt "+orderId);
		
		CancellationDao cancel = new CancellationDaoImpl();
		Order receipt = new Order();
		
		receipt = cancel.displayCancellationDetails(orderId);
		
		request.setAttribute("receipt", receipt);
		
		
		getServletContext().getRequestDispatcher("/WEB-INF/views/receipt.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}