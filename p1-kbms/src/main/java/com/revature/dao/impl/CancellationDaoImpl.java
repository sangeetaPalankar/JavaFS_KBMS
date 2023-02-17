package com.revature.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.config.DatabaseConnection;
import com.revature.constants.Constants;
import com.revature.dao.CancellationDao;
import com.revature.model.Order;
import com.revature.servlets.AllOrdersServlet;
import com.revature.util.ConnectionFactory;
import com.revature.util.DateTimeUtil;
import com.revature.util.DbUtil;

public class CancellationDaoImpl implements CancellationDao {
	static  Logger logger = Logger.getLogger(CancellationDaoImpl.class);
	private Connection con;
	private PreparedStatement preparedStatment;

	Order order = new Order();
	public static int orderCount =0;
	public static boolean checkTest= false;

	public List<Order> displayOrderlist(String loginId) throws SQLException{
		try {
			con = ConnectionFactory.getConnection();
			con.setAutoCommit(false);
			Order order = null;

			String ORDER_DETAILS ="SELECT o.order_id, o.preferred_login_id, o.product_id, o.quantity, o.total_price, o.order_date,o.status, p.product_name FROM order_details o INNER JOIN product p ON o.product_id = p.product_id WHERE PREFERRED_LOGIN_ID = ?";
			CallableStatement cs = con.prepareCall(ORDER_DETAILS);
			cs.setString(1, loginId);
			logger.info("\n");
			logger.info("ORDER ID \t PRODUCT ID \t PRODUCT NAME \t LOGIN ID \t QUANTITY \t TOTAL PRICE\t ORDER DATE \t STATUS ");
			logger.info("\n");
			
			ResultSet rs = cs.executeQuery();
			while (rs.next()) {
				String orderId = rs.getString("order_id");
				String prefferedLoginId = rs.getString("preferred_login_id");
				String productId = rs.getString("product_id");
				String productName = rs.getString("product_name");
				String quantity = rs.getString("quantity");
				String totalPrice = rs.getString("total_price");
				String orderDate = rs.getString("order_date");
				String status = rs.getString("status");
				System.out.println(orderId + "\t\t" + productId + "\t\t" + productName+ "\t\t"+ prefferedLoginId+ "\t\t" + quantity + "\t\t" + totalPrice + "\t\t" + orderDate+"\t\t"+status);
			}
//			while(rs.next()) {
//				order = new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3),
//						rs.getDouble(4), rs.getString(5), rs.getString(6),
//						rs.getInt(7), rs.getString(8),
//						rs.getString(9), rs.getString(10), rs.getString(11));
//				orderlist.add(order);
//				
//				
//			}
			System.out.println(orderlist.isEmpty());
			for(Order i:orderlist) {
				System.out.println(i);
				
			}
		
		} catch (SQLException e) {
			//logger.info(e.getMessage());
		}
		finally {
			DbUtil.close(preparedStatment);
			DbUtil.close(con);
		}
		return orderlist;
	}
	
	
	
	@Override
	public void checkOrder(int oId) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kbms_project", "root", "sangita123");
			Statement stm = con.createStatement();
			String GET_ORDER_DETAILS = "SELECT * FROM ORDER_DETAILS";
			ResultSet rs = stm.executeQuery(GET_ORDER_DETAILS);

//			while (rs.next()) {
//				Order order = new Order(rs.getInt("order_id"), rs.getInt("product_id"), rs.getInt("quantity"),
//						rs.getDouble("total_price"), rs.getString("order_date"), rs.getString("status"),
//						rs.getInt("cancellation_id"), rs.getString("cancellation_date"),
//						rs.getString("cancellation_reason"), rs.getString("preferred_login_id"));
//				CancellationDao.orderlist.add(order);
//			}
			boolean flag = false;
			for (Order i : CancellationDao.orderlist) {
				if (i.getOrderId() == oId) {
					flag = true;
					checkTest = true;
					if (i.getStatus().equals("Cancelled")) {
						logger.info("Order already Cancelled..");
						
					}
				}
			}
			if (!flag) {
				logger.info("No Order found with Order Id " + oId+" . Try with valid Order Id:");
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			logger.info(e.getMessage());
		}
		try {
			con.close();
		} catch (SQLException e) {
		}
	}

	
	@Override
	public void cancelOrder(int oId, String reason) {
		try {
			System.out.println("in dao fucn: ");
			con = ConnectionFactory.getConnection();
			con.setAutoCommit(false);
			
			CallableStatement update = con.prepareCall("{CALL CANCELLATION(?,?)}");
			update.setString(1, reason);
			update.setInt(2, oId);
			int n = update.executeUpdate();
			
			if (n > 0) {
				System.out.println("order " + oId + " was updated successfully!");
				con.commit();
			}
			
			Statement stm = con.createStatement();
			String GET_ORDER_DETAILS = "SELECT * FROM ORDER_DETAILS ";
			preparedStatment = con.prepareStatement(GET_ORDER_DETAILS);
		
			ResultSet rs = preparedStatment.executeQuery();
			
			while(rs.next()) {
				int oid = rs.getInt("order_id");
				int quantity =rs.getInt("quantity");
				String status = rs.getString("status");
				System.out.println(oid+" "+status);
			
			}
			
			
//			String getPid = "SELECT PRODUCT_ID FROM ORDER_DETAILS WHERE ORDER_ID ="+ String.valueOf(oId);
//			Statement stmt=con.createStatement();
//			
//			ResultSet rs=stmt.executeQuery(getPid);
//			int pId = 0;
//			while(rs.next()) {
//				pId=rs.getInt("product_id");
//			}
//			logger.info(pId);
//			reflectChanges(pId);

		} catch (SQLException e) {
			logger.info(e.getMessage());
		}
		finally {
			DbUtil.close(preparedStatment);
			DbUtil.close(con);
		}
	}


	@Override
	public Order displayCancellationDetails(int orderId) {
		Order invoice = new Order();
		try {
			
			con = ConnectionFactory.getConnection();
			con.setAutoCommit(false);
			Statement stm = con.createStatement();
			
	
			String CANCEL_RECEIPT ="SELECT o.order_id, o.preferred_login_id, o.product_id, o.quantity, o.total_price, o.order_date,o.status,o.cancellation_id, o.cancellation_date, o.cancellation_reason, p.product_name FROM order_details o INNER JOIN product p ON o.product_id = p.product_id WHERE ORDER_ID = ?";
			CallableStatement receipt = con.prepareCall(CANCEL_RECEIPT);
			receipt.setInt(1, orderId);
			ResultSet rs = receipt.executeQuery();
			logger.info("ORDER ID \t PRODUCT ID \t PRODUCT NAME \t LOGIN ID \t QUANTITY \t TOTAL PRICE\t ORDER DATE \t STATUS \t CANCELLATION ID \t CANCELLATION DATE \t CANCELLATION REASON");
			logger.info("\n");
			while (rs.next()) {
				int oId = rs.getInt("order_id");
				String prefferedLoginId = rs.getString("preferred_login_id");
				int productId = rs.getInt("product_id");
				String productName = rs.getString("product_name");
				int quantity = rs.getInt("quantity");
				double totalPrice = rs.getDouble("total_price");
				String orderDate = rs.getString("order_date");
				String status = rs.getString("status");
				String cancelId = rs.getString("cancellation_id");
				String cancelDate = rs.getString("cancellation_date");
				String reason = rs.getString("cancellation_reason");
				logger.info(orderId + "\t\t" + productId + "\t\t" + productName+ "\t\t"+ prefferedLoginId+ "\t\t"+ quantity + "\t\t" + totalPrice + "\t\t" + orderDate+ "\t\t"+status+ "\t\t"+ cancelId+ "\t\t"+cancelDate+ "\t\t"+ reason);
				
				invoice.setOrderId(oId);
				invoice.setProductId(productId);
				invoice.setPreffered_login_Id(prefferedLoginId);
				invoice.setQuantity(quantity);
				invoice.setOrderDate(orderDate);
				invoice.setTotalPrice(totalPrice);
				invoice.setStatus(status);
				invoice.setCancellationId(cancelId);
				invoice.setCancellationDate(cancelDate);
				invoice.setCancellationReason(reason);
				invoice.setProductName(productName);	
			}
		} catch ( SQLException e) {
			logger.info(e.getMessage());
		}
		finally {
			DbUtil.close(preparedStatment);
			DbUtil.close(con);
		}
		return invoice;
	}

	@Override
	public void reflectChanges(int productId) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kbms_project", "root", "sangita123");
			String updateQuery = Constants.UPDATE_COUNT;
			PreparedStatement ps = con.prepareStatement(updateQuery);
			ps.setInt(1, productId);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			logger.info(e.getMessage());
		}
		finally {
		DbUtil.close(preparedStatment);
		DbUtil.close(con);
	}


	}
	
	public Order getOrderDetail(int orderId) {
		Order order = new Order();
		try {
			
		
			con = ConnectionFactory.getConnection();
			con.setAutoCommit(false);			
			String ORDER_DETAILS ="SELECT * FROM ORDER_DETAILS WHERE ORDER_ID=?";
			CallableStatement cs = con.prepareCall(ORDER_DETAILS);
			cs.setInt(1, orderId);
			
			ResultSet rs = cs.executeQuery();
			while(rs.next()) {
				
				order.setOrderId(rs.getInt(1));
				order.setProductId(rs.getInt(3));
				order.setQuantity(rs.getInt(4));
				order.setTotalPrice(rs.getDouble(5));
				order.setOrderDate(rs.getString(6));
				order.setStatus(rs.getString(7));
				order.setProductName(AllOrdersServlet.productName);
				
			}
			System.out.println(order.getProductName());
			
			
			
		}catch (SQLException e) {
				//logger.info(e.getMessage());
			}
			finally {
				DbUtil.close(preparedStatment);
				DbUtil.close(con);
			}
		
	
		
		return order;
		
	}

}
