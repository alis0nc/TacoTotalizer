package net.alisonc.tacototalizer.data;

import java.util.HashMap;

/**
 * This class is a data-only class for the Taco Loco menu.
 * @author alisonc
 *
 */
public class TacoLocoMenu {
	public static final HashMap<String, Double> MENU = new HashMap<>();
	static {
		MENU.put("Veggie Taco", 2.50);
		MENU.put("Chicken Taco", 3.00);
		MENU.put("Beef Taco", 3.00);
		MENU.put("Chorizo Taco", 3.50);
	}
}
