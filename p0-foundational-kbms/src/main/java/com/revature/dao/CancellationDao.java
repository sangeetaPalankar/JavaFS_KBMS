package com.revature.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Order;

public interface CancellationDao {
	
	public static List<Order> cancelList = new ArrayList<>();
	public static ArrayList<Order> orderlist = new ArrayList<>();
	
	
	public void displayOrderlist();
	
	public void checkOrder(int oId);
	
	public void cancelOrder(int orderId, String reason) throws SQLException;
	
	public int generateCancellationId();
	
	public void displayCancellationDetails(int orderId);
	
	public void reflectChanges(int productId);
	
	
	
}
