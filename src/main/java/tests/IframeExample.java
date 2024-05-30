package tests;

import org.testng.annotations.Test;

import pages.ContactsPage;
import pages.MenuPage;
import utils.BaseTest;

public class IframeExample extends BaseTest {
	
	@Test
	public void iFrameExampleTest() throws InterruptedException {
		
		MenuPage menu = new MenuPage(driver);
		ContactsPage contacts = new ContactsPage(driver);
		
		menu.navigateTo(menu.contactsLink);
		
		//facem switch catre domul din interiorul iframe-ului
		driver.switchTo().frame(driver.findElement(contacts.iframe));
		
		contacts.zoomMap(contacts.zoomInBtn);
		
		//facem switch inapoi catre domul principal
		driver.switchTo().defaultContent();
		
		driver.findElement(contacts.name).sendKeys("Harry Poker");
		
	}

}
