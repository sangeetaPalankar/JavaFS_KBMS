package com.revature.kbms.dao;

public interface CancellationDao {
	
	public void getCancelOrderDetails(int orderId);//get
	
	public void setStatusCancelled(int orderId, String cancelTime);//update
	
	public String generateCancellationId(int orderId);
	
	public void getCancelTime();
	
	public void reflectChanges(int productId);
	
	public void displayCancellationDetails(int orderId);
	
}
