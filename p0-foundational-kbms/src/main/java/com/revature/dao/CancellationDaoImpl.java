package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.app.menu.MenuDrivenApplication;
import com.revature.config.DatabaseConnection;
import com.revature.constants.Constants;
import com.revature.model.Order;
import com.revature.util.DateTimeUtil;

public class CancellationDaoImpl implements CancellationDao {

	private static Connection con = DatabaseConnection.getConnection();
	MenuDrivenApplication menu = new MenuDrivenApplication();
	public static int cancellationId = 10001;
	Order order = new Order();

	public static void displayOrderlist() {
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kbms_project", "root", "sangita123");
			java.sql.Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(Constants.SELECT_ORDER_QUERY);
			System.out.println();
			System.out.println(
					"ORDER ID \t LOGIN ID\t  PRODUCT ID \t PRODUCT NAME\t QUANTITY \t TOTAL PRICE\t ORDER DATE");
			System.out.println();
			while (rs.next()) {
				String orderId = rs.getString("order_id");
				String prefferedLoginId = rs.getString("preferred_login_id");
				String productId = rs.getString("product_id");
				String productName = rs.getString("product_name");
				String quantity = rs.getString("quantity");
				String totalPrice = rs.getString("total_price");
				String orderDate = rs.getString("order_date");
				System.out.println(orderId + "\t\t" + prefferedLoginId + "\t\t" + productId + "\t\t" + productName
						+ "\t\t" + quantity + "\t\t" + totalPrice + "\t\t" + orderDate);
			}
			String GET_ORDER_DETAILS = "SELECT * FROM ORDER_DETAILS";
			ResultSet o = stm.executeQuery(GET_ORDER_DETAILS);
			while (rs.next()) {
				Order order = new Order(rs.getInt("order_id"), rs.getInt("product_id"), rs.getInt("quantity"),
						rs.getDouble("total_price"), rs.getString("order_date"), rs.getString("status"),
						rs.getInt("cancellation_id"), rs.getString("cancellation_date"),
						rs.getString("cancellation_reason"), rs.getString("preferred_login_id"));
				CancellationDao.orderlist.add(order);
			}
			System.out.println(CancellationDao.orderlist);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		try {
			con.close();
		} catch (SQLException e) {
		}
	}
	
	

	@Override
	public void checkOrder(int oId) {

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kbms_project", "root", "sangita123");
			Statement stm = con.createStatement();
			String GET_ORDER_DETAILS = "SELECT * FROM ORDER_DETAILS";
			ResultSet rs = stm.executeQuery(GET_ORDER_DETAILS);

			while (rs.next()) {
				Order order = new Order(rs.getInt("order_id"), rs.getInt("product_id"), rs.getInt("quantity"),
						rs.getDouble("total_price"), rs.getString("order_date"), rs.getString("status"),
						rs.getInt("cancellation_id"), rs.getString("cancellation_date"),
						rs.getString("cancellation_reason"), rs.getString("preferred_login_id"));
				CancellationDao.orderlist.add(order);
			}
			boolean flag = false;
			for (Order i : CancellationDao.orderlist) {
				if (i.getOrderId() == oId) {
					flag = true;
					if (i.getStatus().equals("Cancelled")) {
						System.out.println("Order already Cancelled..");
						menu.cancelOrders();
					}
				}
			}
			if (!flag) {
				System.out.println("No Order found with Order Id " + oId+" . Try with valid Order Id:(");
				menu.cancelOrders();
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		try {
			con.close();
		} catch (SQLException e) {
		}
	}

	
	@Override
	public void getCancelOrderDetails(int oId, String reason) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kbms_project", "root", "sangita123");

			String updateQuery = Constants.UPDATE_STATUS;
			PreparedStatement ps = con.prepareStatement(updateQuery);

			ps.setInt(1, generateCancellationId());
			ps.setString(2, DateTimeUtil.getCurrentDateTime());
			ps.setString(3, reason);
			ps.setInt(4, oId);
			int n = ps.executeUpdate();
			ps.close();
			String getPid = "SELECT PRODUCT_ID FROM ORDER_DETAILS WHERE ORDER_ID ="+ String.valueOf(oId);
			Statement stmt=con.createStatement();
			
			ResultSet rs=stmt.executeQuery(getPid);
			int pId = 0;
			while(rs.next()) {
				pId=rs.getInt("product_id");
			}
			System.out.println(pId);
			reflectChanges(pId);

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		try {
			con.close();
		} catch (SQLException e) {
		}
	}

	@Override
	public int generateCancellationId() {

		return cancellationId++;
	}

	@Override
	public void displayCancellationDetails(int orderId) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kbms_project", "root", "sangita123");
			java.sql.Statement stm = con.createStatement();
			String GET_CANCEL_ORDER = "SELECT * FROM ORDER_DETAILS WHERE ORDER_ID=?";
			PreparedStatement ps = con.prepareStatement(GET_CANCEL_ORDER);
			ps.setInt(1, orderId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Order order = new Order(rs.getInt("order_id"), rs.getInt("product_id"), rs.getInt("quantity"),
						rs.getDouble("total_price"), rs.getString("order_date"), rs.getString("status"),
						rs.getInt("cancellation_id"), rs.getString("cancellation_date"),
						rs.getString("cancellation_reason"), rs.getString("preferred_login_id"));
				CancellationDao.cancelList.add(order);

			}

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		try {
			con.close();
		} catch (SQLException e) {
		}
	}

	@Override
	public void reflectChanges(int productId) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kbms_project", "root", "sangita123");

			String updateQuery = Constants.UPDATE_COUNT;
			PreparedStatement ps = con.prepareStatement(updateQuery);
			ps.setInt(1, productId);
			

			int n = ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		try {

			con.close();
		} catch (SQLException e) {
		}

	}

}
