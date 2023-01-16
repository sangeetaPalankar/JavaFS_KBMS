package com.revature.kbms.model;

public class Cancellation {
	private static int cancellationId =100001;
	private String cancellationDate;
	private String CancellationReason;
	private int orderId;
	
	
	public Cancellation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cancellation(int cancellationId, String cancellationDate, String cancellationReason, int orderId) {
		super();
		this.cancellationId = cancellationId =100000;
		this.cancellationDate = cancellationDate;
		CancellationReason = cancellationReason;
		this.orderId = orderId;
	}
	
	public int getCancellationId() {
		return cancellationId;
	}
	public void setCancellationId() {
		this.cancellationId = cancellationId++;
	}
	public String getCancellationDate() {
		return cancellationDate;
	}
	public void setCancellationDate(String cancellationDate) {
		this.cancellationDate = cancellationDate;
	}
	public String getCancellationReason() {
		return CancellationReason;
	}
	public void setCancellationReason(String cancellationReason) {
		CancellationReason = cancellationReason;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	@Override
	public String toString() {
		return "Cancellation [cancellationId=" + cancellationId + ", cancellationDate=" + cancellationDate
				+ ", CancellationReason=" + CancellationReason + ", orderId=" + orderId + "]";
	}
	
	

}
