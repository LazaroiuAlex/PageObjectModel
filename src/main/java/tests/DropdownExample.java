package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.MenuPage;
import pages.ShopPage;
import utils.BaseTest;

public class DropdownExample extends BaseTest {
	
	@Test (priority = 1)
	public void selectByValueTest() {
		
		MenuPage menuPage = new MenuPage(driver);
		menuPage.navigateTo(menuPage.shopLink);
		
		ShopPage shopPage = new ShopPage(driver);
		shopPage.filterByValue("price-desc");
		
		assertEquals(shopPage.getCurrentSelectedOption(), "Sort by price: high to low");
	}
	
	@Test(priority = 2)
	public void selectByIndexTest() {
		
		ShopPage shopPage = new ShopPage(driver);
		shopPage.filterByIndex(3);
		
		assertEquals(shopPage.getCurrentSelectedOption(), "Sort by latest");
	}
	
	@Test(priority = 3)
	public void selectByVisibleTest() {
		
		ShopPage shopPage = new ShopPage(driver);
		shopPage.filterByVisibleText("Sort by popularity");
		
		assertEquals(shopPage.getCurrentSelectedOption(), "Sort by popularity");
	}
	
	
}
