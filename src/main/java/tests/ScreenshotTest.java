package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.MenuPage;
import utils.BaseTest;
import utils.ScreenShots;

public class ScreenshotTest extends BaseTest {
	
	@Test
	public void screenshotTest() {
		
		try {
			MenuPage menu = new MenuPage(driver);
			menu.navigateTo(menu.shopLink);
			ScreenShots sc = new ScreenShots();
			sc.takeScreenShot(driver);
			assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop-2/");

		}catch(Exception e) {
			ScreenShots sc = new ScreenShots();
			sc.takeScreenShot(driver);
		}
		
	}

}
