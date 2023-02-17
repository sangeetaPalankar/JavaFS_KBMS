package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.CancellationDao;
import com.revature.dao.impl.CancellationDaoImpl;
import com.revature.model.Order;
import com.revature.util.ConnectionFactory;

/**
 * Servlet implementation class AllOrdersServlet
 */
@WebServlet("/allOrders")
public class AllOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CancellationDao cancel = new CancellationDaoImpl();
	public static List<Order> orderList = null;
	public static String productName;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllOrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();  
        response.setContentType("text/html");  
        out.println("<html><head>");
        out.println("\r\n"
        		+ "\r\n"
        		+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\r\n"
        		+ "        integrity=\"sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD\" crossorigin=\"anonymous\">"
        		+ "<style>\r\n"
        		+"	.textContent{\r\n"
        		+ " 	font-size: 18px;\r\n"
        		+ "		}\r\n"
        		+ "		.textSmall{\r\n"
        		+ " 	font-size: 16px;\r\n"
        		+ "		}\r\n"
        		+ "        .maindiv{\r\n"
        		+ "            background-color: white;\r\n"
        		+ "            border-radius: 5px;\r\n"
        		+ "            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);\r\n"
        		+ "            margin-right: 30px;\r\n"
        		+ "            width: 50%;\r\n"
        		+ "            padding: 30px;\r\n"
        		+ "            margin-left: 25%;\r\n"
        		+ "            margin-top: 20px;\r\n"
        		+ " 		font-size: 16px;\r\n"
    
        		+ "        }\r\n"
        		+ "			.Button{\r\n"
        		+ "            background-color: #F65005; \r\n"
        		+ "            border: none;\r\n"
        		+ "            color: white;\r\n"
        		+ "            padding: 10px;\r\n"
        		+ "            text-align: center;\r\n"
        		+ "            display: inline-block;\r\n"
        		+ "            font-size: 16px;\r\n"
        
        		+ "            cursor: pointer;\r\n"
        		+ "            border-radius: 10px; */\r\n"
        		+ "            margin-top: 30px;\r\n"
        		+ "            margin-right: 30px;}\r\n"
        		+ "            width:300px;}\r\n"
        		
        		+ " 			.topnav { \r\n"
        		+ "    			background-color: yellow; \r\n"
                   + "  		 \r\n"
                   + "			width : 100%}   \r\n"
                   + "			.navButton{"
                   + "			background-color:black;"
                   + "			padding: 5px;"
                   + "			border-radius: 12px;"
                   + "		.navButton {\r\n"
                   + "            background-color: black;\r\n"
                   + "            border-radius: 10%;\r\n"
                   + "            padding: 10px;\r\n"
                   + "        }"
        		+ "    </style>");

        out.println("</head><body>");
        out.println(" <div style=\"background-color:gold; width:100%; margin-left:0%;\" <br><br>"
        		+ "<nav class=\"navbar navbar-expand-lg  \" style=\"background-color: gold ;\" >\r\n"
        		+ "        <div class=\"container-fluid \" >\r\n"
        		
        		+ "            <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarScroll\"\r\n"
        		+ "                aria-controls=\"navbarScroll\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n"
        		+ "                <span class=\"navbar-toggler-icon\"></span>\r\n"
        		+ "            </button>\r\n"
        		+ "            <div class=\"collapse navbar-collapse\" id=\"navbarScroll\">\r\n"
        		+ "                <ul class=\"navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll\" style=\"--bs-scroll-height: 100px;\">\r\n"
        		+ "                    <li class=\"nav-item\">\r\n"
        		+ "                        <a class=\"nav-link active\" aria-current=\"page\" href=\"#category\">\r\n"
        		+ "\r\n"
        		+ "                            <!-- Button trigger modal -->\r\n"
        		+ "\r\n"
        		+ "                            <button type=\"button\" class=\"btn btn-dark\" data-bs-toggle=\"modal\"\r\n"
        		+ "                                data-bs-target=\"#exampleModal\" id=\"category\">\r\n"
        		+ "                                Shop by Category\r\n"
        		+ "                            </button>\r\n"
        		+ "\r\n"
        		+ "                        </a>\r\n"
        		+ "\r\n"
        		+ "                        <!-- Modal pop down category of veg fruits spices -->\r\n"
        		+ "\r\n"
        		+ "                        <div class=\"modal fade\" id=\"exampleModal\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\"\r\n"
        		+ "                            aria-hidden=\"true\">\r\n"
        		+ "                            <div class=\"modal-dialog modal-xl\">\r\n"
        		+ "                                <div class=\"modal-content \" style=\"height: 400px;\">\r\n"
        		+ "\r\n"
        		+ "                                    <!--header for modal-->\r\n"
        		+ "                                    <div class=\"modal-header bg-primary\">\r\n"
        		+ "                                        <h1 class=\"modal-title fs-3 \" id=\"exampleModalLabel\">Shop Category\r\n"
        		+ "                                        </h1>\r\n"
        		+ "                                        <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\"\r\n"
        		+ "                                            aria-label=\"Close\"></button>\r\n"
        		+ "                                    </div>\r\n"
        		+ "\r\n"
        		+ "                                    <!---body for modal-->\r\n"
        		+ "                                    <div class=\"modal-body bg-dark\">\r\n"
        		+ "                                        <div class=\"container-fluid\">\r\n"
        		+ "                                            <div class=\"row\">\r\n"
        		+ "\r\n"
        		+ "                                                <!---card for vegetable to connect to vegetable page -->\r\n"
        		+ "                                                <a href=\"vegetable.html\">\r\n"
        		+ "                                                    <div class=\" col-md-4 col-sm-12 card mb-3 h-75 w-25 position-absolute top-0\"\r\n"
        		+ "                                                        style=\"margin-top: 3%;margin-left: 3%; \">\r\n"
        		+ "\r\n"
        		+ "                                                        <!---card for vegess-->\r\n"
        		+ "                                                        <div class=\"card-body\"\r\n"
        		+ "                                                            style=\"background-image: url('product-1.jpg'); background-size:cover; \">\r\n"
        		+ "                                                            <h5\r\n"
        		+ "                                                                class=\"card-title text-dark fs-2 fw-bolder position-absolute top-0 start-0\">\r\n"
        		+ "                                                                VEGETABLES\r\n"
        		+ "                                                            </h5>\r\n"
        		+ "\r\n"
        		+ "                                                        </div>\r\n"
        		+ "                                                    </div>\r\n"
        		+ "                                                </a>\r\n"
        		+ "\r\n"
        		+ "                                                <!---card to connect fruit_html page -->\r\n"
        		+ "                                                <a href=\"fruits.html\">\r\n"
        		+ "\r\n"
        		+ "                                                    <div class=\" col-md-4 col-sm-12 card mb-3  h-75 w-25  position-absolute top-0\"\r\n"
        		+ "                                                        style=\"margin-left: 35%;margin-top: 3%;\">\r\n"
        		+ "\r\n"
        		+ "                                                        <!---cards for fruit -->\r\n"
        		+ "                                                        <div class=\"card-body\"\r\n"
        		+ "                                                            style=\"background-image:url(img/tina-bach-WooBe_2VOcA-unsplash.jpg);background-size: cover;\">\r\n"
        		+ "                                                            <h5\r\n"
        		+ "                                                                class=\"card-title text-dark fs-2 fw-bolder position-absolute top-0 start-0\">\r\n"
        		+ "                                                                FRUITS</h5>\r\n"
        		+ "\r\n"
        		+ "                                                        </div>\r\n"
        		+ "                                                    </div>\r\n"
        		+ "                                                </a>\r\n"
        		+ "\r\n"
        		+ "\r\n"
        		+ "\r\n"
        		+ "                                                <!---card to connect spices_html page-->\r\n"
        		+ "                                                <a href=\"spices.html\">\r\n"
        		+ "                                                    <div class=\" col-md-4 col-sm-12 card mb-3 h-75 w-25  position-absolute top-0\"\r\n"
        		+ "                                                        style=\"margin-top: 3%;margin-left: 67%;\">\r\n"
        		+ "\r\n"
        		+ "                                                        <!---cards for spices -->\r\n"
        		+ "                                                        <div class=\"card-body\"\r\n"
        		+ "                                                            style=\"background-image:url(img/ratul-ghosh-NPrWYa69Mz0-unsplash.jpg);background-size: cover;\">\r\n"
        		+ "                                                            <h5\r\n"
        		+ "                                                                class=\"card-title text-dark fs-2 fw-bolder position-absolute top-0 start-0\">\r\n"
        		+ "                                                                SPICES</h5>\r\n"
        		+ "\r\n"
        		+ "                                                        </div>\r\n"
        		+ "                                                    </div>\r\n"
        		+ "                                                </a>\r\n"
        		+ "\r\n"
        		+ "                                            </div>\r\n"
        		+ "                                        </div>\r\n"
        		+ "                                    </div>\r\n"
        		+ "\r\n"
        		+ "                                    <!--footer modal include close button-->\r\n"
        		+ "                                    <div class=\"modal-footer bg-primary\">\r\n"
        		+ "                                        <button type=\"button\" class=\"btn btn-dark\"\r\n"
        		+ "                                            data-bs-dismiss=\"modal\">Close</button>\r\n"
        		+ "\r\n"
        		+ "                                    </div>\r\n"
        		+ "                                </div>\r\n"
        		+ "                            </div>\r\n"
        		+ "                        </div>\r\n"
        		+ "                    </li>\r\n"
        		+ "\r\n"
        		+ "                    <!--basket button to jump on my basket page-->\r\n"
        		+ "                    <li class=\"nav-item\">\r\n"
        		+ "                        <a class=\"nav-link\" href=\"basket.html\">\r\n"
        		+ "                            <button class=\"btn btn-dark\" type=\"button\">My\r\n"
        		+ "                                Basket</button></a>\r\n"
        		+ "                    </li>\r\n"
        		+ "\r\n"
        		+ "                    <!---for address button to choose address-->\r\n"
        		+ "                    <div style=\"margin-top: 2.3%;\">\r\n"
        		+ "                        <li class=\"nav-item \">\r\n"
        		+ "                            <label for=\"address\">Address</label>\r\n"
        		+ "                            <select class=\"bg-light text-dark\" name=\"address\" id=\"address\" aria-placeholder=\"Address\">\r\n"
        		+ "                                <option value=\"mumbai\">Mumbai</option>\r\n"
        		+ "                                <option value=\"pune\">Pune</option>\r\n"
        		+ "                                <option value=\"delhi\">Delhi</option>\r\n"
        		+ "                                <option value=\"banglore\">Banglore</option>\r\n"
        		+ "                            </select>\r\n"
        		+ "                        </li>\r\n"
        		+ "                    </div>\r\n"
        		+ "\r\n"
        		+ "                    <!-- myorder button to jump on my my order page-->\r\n"
        		+ "\r\n"
        		+ "                    <li class=\"nav-item\">\r\n"
        		+ "                        <a class=\"nav-link \" href=\"allOrders\" >\r\n"
        		+ "                            <!-- Button trigger modal -->\r\n"
        		+ "                            <button type=\"button\" class=\"btn btn-dark \">\r\n"
        		+ "                                My Orders\r\n"
        		+ "                            </button>\r\n"
        		+ "                        </a>\r\n"
        		+ "\r\n"
        		+ "\r\n"
        		+ "                    </li>\r\n"
        		+ "                </ul>\r\n"
        		+ "\r\n"
        		+ "                <!--for search button-->\r\n"
        		+ "                <form class=\"d-flex\" role=\"search\">\r\n"
        		+ "                    <input class=\"form-control me-2\" type=\"search\" placeholder=\"Search\" aria-label=\"Search\">\r\n"
        		+ "                    <button class=\"btn btn-dark\" type=\"submit\">Search</button>\r\n"
        		+ "                </form>\r\n"
        		+ "            </div>\r\n"
        		+ "        </div>\r\n"
        		+ "    </nav></div></div>");
        
        out.println("<h2 style=\"margin-left:400px; margin-top:20px\">Your Orders:</h2><br>");
        try 
        {  
            Connection connection = ConnectionFactory.getConnection();  
            String ORDER_DETAILS ="SELECT o.order_id, o.preferred_login_id, o.product_id, o.quantity, o.total_price, o.order_date,o.status, p.product_name FROM order_details o INNER JOIN product p ON o.product_id = p.product_id WHERE PREFERRED_LOGIN_ID = ?";
			CallableStatement cs = connection.prepareCall(ORDER_DETAILS);
			cs.setString(1, DoLoginServlet.userName);
			
   
            ResultSet rs = cs.executeQuery();
			while (rs.next()) {
				String orderId = rs.getString("order_id");
				String prefferedLoginId = rs.getString("preferred_login_id");
				String productId = rs.getString("product_id");
				productName = rs.getString("product_name");
				String quantity = rs.getString("quantity");
				String totalPrice = rs.getString("total_price");
				String orderDate = rs.getString("order_date");
				String status = rs.getString("status");
				
				out.println("<form action=\"CancellationReasonServlet\" method=\"get\">");
				
				out.println("<div class=\"maindiv\">\r\n"
						+ "        <div>Status:  "+status+"</div>\r\n"
						+ "        <div>Product:  "+productName+"</div>\r\n"
						+ "        <div>Order Id:  "+orderId+"</div>\r\n"
						+ "        <div>Order Date:  "+orderDate+"</div>\r\n"
						+ "        <div>Quantity:  "+quantity+"</div>\r\n"
						+ "        <div>Total:  "+totalPrice+"</div>\r\n");
				
				if(status.equals("Confirmed")) {
					out.println("<button class=\"Button\" id=oid type=\"submit\" value="+orderId +" name=\"orderId\">Cancel</button>");
				}
		
				out.println("</div></form>");
			}
				   
			 
          
            out.println("</html></body>");  
            connection.close();  
    }
        catch (Exception e) 
        {  
         out.println("error");  
     }
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
