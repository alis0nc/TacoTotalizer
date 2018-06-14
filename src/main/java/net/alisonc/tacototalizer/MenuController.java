package net.alisonc.tacototalizer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.alisonc.tacototalizer.data.TacoLocoMenu;
import net.alisonc.tacototalizer.model.MenuResponse;

/**
 * This class is a controller for the api endpoint to get the menu. 
 * @author alisonc
 *
 */
@RestController
public class MenuController {
	@RequestMapping("/menu")
	public MenuResponse menu() {
		return new MenuResponse(TacoLocoMenu.MENU);
	}
}
