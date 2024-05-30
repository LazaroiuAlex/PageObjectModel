package tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import pages.EventsPage;
import pages.GenericEventPage;
import pages.MenuPage;
import utils.BaseTest;

public class WindowHandleExample extends BaseTest {
	
	@Test
	public void windowHanddleTest() {
		
		MenuPage menu = new MenuPage(driver);
		EventsPage events = new EventsPage(driver);
		
		menu.navigateTo(menu.eventsLink);
		
		Actions action = new Actions(driver);
		action.scrollByAmount(0, 800).perform();
		
		events.clickOnEvent(events.seminarEventLink);
		
		GenericEventPage  genericEvent = new GenericEventPage(driver);
		action.scrollByAmount(0, 800).perform();
		
		//citesc care este fereastra curenta
		System.out.println("Current window: " + driver.getWindowHandle());
		//citesc care sunt toate ferestrele deschise
		System.out.println("All open windows: " + driver.getWindowHandles());
		
		genericEvent.openMap();
		
		System.out.println("----------------------------------------");
		
		//citesc care este fereastra curenta
		System.out.println("Current window: " + driver.getWindowHandle());
		//citesc care sunt toate ferestrele deschise
		System.out.println("All open windows: " + driver.getWindowHandles());
		
		System.out.println("----------------------------------------");
		
		List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
		//schimb focusul pe nou tab deschis
		driver.switchTo().window(browserTabs.get(1));
		
		System.out.println("Current window: " + driver.getWindowHandle());
		
		driver.findElement(By.xpath("//span[contains(text(), 'Accept all')]")).click();
		//inchid tabul
		driver.close();
		
		System.out.println("----------------------------------------");
		
		driver.switchTo().window(browserTabs.get(0));
		
		genericEvent.openMap();
	}

}
