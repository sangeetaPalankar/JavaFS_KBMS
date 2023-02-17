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
 * Servlet implementation class OrderCancellationServlet
 */
@WebServlet("/OrderCancellationServlet")
public class OrderCancellationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderCancellationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reason = request.getParameter("reason");
		String oid = request.getParameter("oid");
		int orderId = Integer.valueOf(oid);
		CancellationDao cancel = new CancellationDaoImpl();
	
		cancel.cancelOrder(orderId, reason);
		
		Order cancelDetail =cancel.displayCancellationDetails(orderId);
        
        request.setAttribute("cancelDetail", cancelDetail);
		
	
		getServletContext().getRequestDispatcher("/WEB-INF/views/CancelledSuccess.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
