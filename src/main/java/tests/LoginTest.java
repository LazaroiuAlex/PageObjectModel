package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MenuPage;
import utils.BaseTest;
import utils.PropertiesFileProcessor;

public class LoginTest extends BaseTest{
	
	String user = PropertiesFileProcessor.readPropertiesFile("username", "credential.properties");
	String pass = PropertiesFileProcessor.readPropertiesFile("password", "credential.properties");
	
	@Test(priority=1)
	public void validLoginTest() {
		
		MenuPage menu = new MenuPage(driver);
		LoginPage login = new LoginPage(driver);
		
		menu.navigateTo(menu.loginLink);
		login.loginInApp(user, pass);
		
		assertTrue(login.checkMsgIsDisplayed(login.successLoginMessage));
		login.logoutFromApp();
	}
	
	@Test(priority=2)
	public void invalidLoginTest() {
		
		MenuPage menu = new MenuPage(driver);
		LoginPage login = new LoginPage(driver);
		
		menu.navigateTo(menu.loginLink);
		login.loginInApp(user, "121231233");
		
		assertTrue(login.checkMsgIsDisplayed(login.errorLoginMessage));
		
	}

}
