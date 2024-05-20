package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import pages.ContactsPage;
import pages.MenuPage;
import pages.ShopPage;
import utils.BaseTest;

public class ActionClassExample extends BaseTest {
	
	//@Test
	public void hoverExample() throws InterruptedException {
		
		MenuPage menu = new MenuPage(driver);
		menu.hoverElement(menu.aboutLink);
		Thread.sleep(3000);
		menu.hoverElement(menu.blogLink);
	}
	
	//@Test
	public void dragAndDropExample () {
		
		MenuPage menu = new MenuPage(driver);
		menu.navigateTo(menu.shopLink);
		
		ShopPage shop = new ShopPage(driver);
		shop.dragAndDrop(shop.sliderInitialPosition, 100, 0);
		shop.dragAndDrop(shop.sliderFinalPosition, -100, 0);
	}
	
	@Test
	public void sendKeysExample() {
		
		MenuPage menu = new MenuPage(driver);
		menu.navigateTo(menu.contactsLink);
		
		ContactsPage contact = new ContactsPage(driver);
		WebElement nameElement = driver.findElement(contact.name);
		
		Actions action = new Actions(driver);
		action
			.moveToElement(nameElement)
			.click(nameElement)
			.sendKeys("nume")
			.sendKeys(Keys.TAB, "email@email.com")
			.sendKeys(Keys.TAB, "Subiect")
			.sendKeys(Keys.TAB, "Acesta este un test")
			.sendKeys(Keys.TAB, Keys.ENTER)
			.perform();
			
		
	}

}
