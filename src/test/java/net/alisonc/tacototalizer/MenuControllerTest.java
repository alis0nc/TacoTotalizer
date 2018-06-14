/**
 * 
 */
package net.alisonc.tacototalizer;

import static org.junit.Assert.*;

import org.junit.Test;

import net.alisonc.tacototalizer.data.TacoLocoMenu;
import net.alisonc.tacototalizer.model.MenuResponse;

/**
 * Tests for MenuController.
 * @author alisonc
 *
 */
public class MenuControllerTest {

	/**
	 * Test method for {@link net.alisonc.tacototalizer.MenuController#menu()}.
	 */
	@Test
	public void testMenu() {
		MenuResponse resp = new MenuController().menu();
		assertEquals(resp.getMenu(), TacoLocoMenu.MENU);
	}

}
