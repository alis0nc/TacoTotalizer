package net.alisonc.tacototalizer.model;

/**
 * This class represents a web service response with the order total.
 * @author alisonc
 *
 */
public class OrderTotalResponse {
	private final long orderID;
	private final double total;
	
	public OrderTotalResponse(long ID, double total) {
		this.orderID = ID;
		this.total = total;
	}

	public long getID() {
		return orderID;
	}

	public double getTotal() {
		return total;
	}
}
