package com.revature.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Order;

public interface CancellationDao {
	
	public static List<Order> cancelList = new ArrayList<>();
	public static List<Order> orderlist = new ArrayList<Order>();
	
	
	
	public List<Order> displayOrderlist(String LoginId) throws SQLException;
	
	public void checkOrder(int oId);
	
	public void cancelOrder(int orderId, String reason);
	
	public Order displayCancellationDetails(int orderId);
	
	public void reflectChanges(int productId);
	public Order getOrderDetail(int orderId);
	
	
	
	
}
