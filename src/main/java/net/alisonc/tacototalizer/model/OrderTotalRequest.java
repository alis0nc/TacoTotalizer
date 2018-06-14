package net.alisonc.tacototalizer.model;

import java.util.HashMap;

/**
 * This class represents a web service request with a food order.
 * @author alisonc
 *
 */
public class OrderTotalRequest {
	private final String orderID;
	// name of food: quantity
	private final HashMap<String, Integer> foodOrder;
	
	public OrderTotalRequest(String orderID, HashMap<String, Integer> foodOrder) {
		this.orderID = orderID;
		this.foodOrder = foodOrder;
	}

	public String getOrderID() {
		return orderID;
	}

	public HashMap<String, Integer> getFoodOrder() {
		return foodOrder;
	}
}
