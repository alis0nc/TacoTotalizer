package net.alisonc.tacototalizer.model;

/**
 * This class represents a web service response with the order total.
 * @author alisonc
 *
 */
public class OrderTotalResponse {
	private final String orderID;
	private final double total;
	
	public OrderTotalResponse(String ID, double total) {
		this.orderID = ID;
		this.total = total;
	}

	public String getOrderID() {
		return orderID;
	}

	public double getTotal() {
		return total;
	}
}
