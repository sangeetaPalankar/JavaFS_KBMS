package com.revature.kbms.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.kbms.model.Cancellation;
import com.revature.kbms.model.Order;

public interface CancellationDao {
	public static List<Order> orderlist = new ArrayList<>();
	public static List<Cancellation> cancelList = new ArrayList<>();
	

	
	public void getCancelOrderDetails(int orderId);//get
	
	public void setStatusCancelled(int orderId, String cancelTime);//update
	
	public String generateCancellationId(int orderId);
	
	public void getCancelTime();
	
	public void reflectChanges(int productId);
	
	public void displayCancellationDetails(int orderId);
	
}
