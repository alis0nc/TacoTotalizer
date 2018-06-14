/**
 * 
 */
package net.alisonc.tacototalizer;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import net.alisonc.tacototalizer.model.OrderTotalRequest;
import net.alisonc.tacototalizer.model.OrderTotalResponse;

/**
 * Tests for OrderTotalController.
 * @author alisonc
 *
 */
public class OrderTotalControllerTest {
	OrderTotalController otc = new OrderTotalController();
	final double EPSILON = 0.0001; // one hundredth of a cent
	/**
	 * Test method for {@link net.alisonc.tacototalizer.OrderTotalController#orderTotal(net.alisonc.tacototalizer.model.OrderTotalRequest)}.
	 * Tests a typical order.
	 */
	@Test
	public void testOrderTotal_SmallOrder() {
		final HashMap<String, Integer> smallOrder = new HashMap<>();
		smallOrder.put("Chicken Taco", 1);
		smallOrder.put("Veggie Taco",  1);
		final OrderTotalRequest smallOrderRequest = new OrderTotalRequest("smallOrder", smallOrder);
		final OrderTotalResponse smallOrderResponse = otc.orderTotal(smallOrderRequest);
		assertEquals(smallOrderResponse.getTotal(), 5.5, EPSILON);
		assertEquals(smallOrderResponse.getOrderID(), smallOrderRequest.getOrderID());
	}
	
	/**
	 * Test method for {@link net.alisonc.tacototalizer.OrderTotalController#orderTotal(net.alisonc.tacototalizer.model.OrderTotalRequest)}.
	 * Tests an empty order. The controller should handle this happily and return 0.
	 */
	@Test
	public void testOrderTotal_EmptyOrder() {
		final HashMap<String, Integer> emptyOrder = new HashMap<>();
		final OrderTotalRequest emptyOrderRequest = new OrderTotalRequest("emptyOrder", emptyOrder);
		final OrderTotalResponse emptyOrderResponse = otc.orderTotal(emptyOrderRequest);
		assertEquals(emptyOrderResponse.getTotal(), 0, EPSILON);
	}
	
	/**
	 * Test method for {@link net.alisonc.tacototalizer.OrderTotalController#orderTotal(net.alisonc.tacototalizer.model.OrderTotalRequest)}.
	 * Tests large quantity orders. The controller should apply 20% discount for the entire order, whenever the whole order is at least 4 tacos.
	 */
	@Test
	public void testOrderTotal_LargeOrder() {
		final HashMap<String, Integer> largeOrder = new HashMap<>();
		largeOrder.put("Chorizo Taco", 5);
		final OrderTotalRequest largeOrderRequest = new OrderTotalRequest("largeOrder", largeOrder);
		final OrderTotalResponse largeOrderResponse = otc.orderTotal(largeOrderRequest);
		final HashMap<String, Integer> largeVarietyOrder = new HashMap<>();
		largeVarietyOrder.put("Chorizo Taco", 1);
		largeVarietyOrder.put("Chicken Taco", 1);
		largeVarietyOrder.put("Beef Taco", 1);
		largeVarietyOrder.put("Veggie Taco", 1);
		final OrderTotalRequest largeVarietyOrderRequest = new OrderTotalRequest("largeVarietyOrder", largeVarietyOrder);
		final OrderTotalResponse largeVarietyOrderResponse = otc.orderTotal(largeVarietyOrderRequest);
		assertEquals(largeVarietyOrderResponse.getTotal(), 9.6, EPSILON);
	}
	
	/**
	 * Test method for {@link net.alisonc.tacototalizer.OrderTotalController#orderTotal(net.alisonc.tacototalizer.model.OrderTotalRequest)}.
	 * Tests order with a nonexistent menu item. We should get a {@link net.alisonc.tacototalizer.NotOnMenuException}.
	 */
	@Test(expected = NotOnMenuException.class)
	public void testOrderTotal_nonexistentItem() {
		final HashMap<String, Integer> nonexistentItemOrder = new HashMap<>();
		nonexistentItemOrder.put("Falafel Pita", 1);
		final OrderTotalRequest nonexistentItemOrderRequest = new OrderTotalRequest("nonexistentItemOrder", nonexistentItemOrder);
		@SuppressWarnings("unused")
		final OrderTotalResponse nonexistentItemOrderResponse = otc.orderTotal(nonexistentItemOrderRequest);
	}
	
	/**
	 * Test method for {@link net.alisonc.tacototalizer.OrderTotalController#orderTotal(net.alisonc.tacototalizer.model.OrderTotalRequest)}.
	 * Tests order with a negative quantity. We should get a {@link net.alisonc.tacototalizer.OrderQuantityException}.
	 */
	@Test(expected = OrderQuantityException.class)
	public void testOrderTotal_negativeQuantity() {
		final HashMap<String, Integer> negativeQuantityOrder = new HashMap<>();
		negativeQuantityOrder.put("Veggie Taco", -1);
		final OrderTotalRequest negativeQuantityOrderRequest = new OrderTotalRequest("negativeQuantityOrder", negativeQuantityOrder);
		@SuppressWarnings("unused")
		final OrderTotalResponse negativeQuantityOrderResponse = otc.orderTotal(negativeQuantityOrderRequest);
	}

}
