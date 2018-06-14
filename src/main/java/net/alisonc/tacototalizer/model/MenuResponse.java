package net.alisonc.tacototalizer.model;

import java.util.HashMap;

/**
 * This class represents a web service response with the menu.
 * @author alisonc
 *
 */
public class MenuResponse {
	private final HashMap<String, Double> menu;
	
	public MenuResponse(HashMap<String, Double> menu) {
		this.menu = menu;
	}

	public HashMap<String, Double> getMenu() {
		return menu;
	}
}
