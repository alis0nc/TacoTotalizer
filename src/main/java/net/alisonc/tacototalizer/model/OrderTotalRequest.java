package net.alisonc.tacototalizer.model;

import java.util.HashMap;

/**
 * This class represents a web service request with a food order.
 * @author alisonc
 *
 */
public class OrderTotalRequest {
	private final long orderID;
	// name of food: quantity
	private final HashMap<String, Integer> foodOrder;
	
	public OrderTotalRequest(long ID, HashMap<String, Integer> foodOrder) {
		this.orderID = ID;
		this.foodOrder = foodOrder;
	}

	public long getID() {
		return orderID;
	}

	public HashMap<String, Integer> getFoodOrder() {
		return foodOrder;
	}
}
