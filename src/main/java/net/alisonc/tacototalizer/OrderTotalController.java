package net.alisonc.tacototalizer;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.alisonc.tacototalizer.data.TacoLocoMenu;
import net.alisonc.tacototalizer.model.OrderTotalRequest;
import net.alisonc.tacototalizer.model.OrderTotalResponse;

/**
 * This class is a controller for the order totals web service.
 * @author alisonc
 *
 */
@RestController
public class OrderTotalController {
	@RequestMapping("/ordertotal")
	public OrderTotalResponse orderTotal(@RequestBody OrderTotalRequest request) {
		double total = 0;
		int totalQuantity = 0;
		for(Map.Entry<String, Integer> itemAndQuantity: request.getFoodOrder().entrySet()) {
			String item = itemAndQuantity.getKey();
			if(!TacoLocoMenu.MENU.containsKey(item)) {
				throw new NotOnMenuException();
			}
			int quantity = itemAndQuantity.getValue();
			if(quantity < 0) {
				throw new OrderQuantityException();
			}
			totalQuantity += quantity;
			double pricePerItem = TacoLocoMenu.MENU.get(item);
			double extPrice = quantity * pricePerItem;
			total += extPrice;
		}
		if(totalQuantity >= 4) {
			total *= 0.8;
		}
		return new OrderTotalResponse(request.getOrderID(), total);
	}
}
