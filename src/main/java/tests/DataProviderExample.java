package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MenuPage;
import utils.BaseTest;
import utils.PropertiesFileProcessor;

public class DataProviderExample extends BaseTest {
	
	String user = PropertiesFileProcessor.readPropertiesFile("username", "credential.properties");
	String pass = PropertiesFileProcessor.readPropertiesFile("password", "credential.properties");
	String user2 = PropertiesFileProcessor.readPropertiesFile("username2", "credential.properties");
	String pass2 = PropertiesFileProcessor.readPropertiesFile("password2", "credential.properties");
	
	@DataProvider
	public Object[] [] loginTestData(){
		
		Object[][] data = new Object[4][3];
		
		data[0][0] = user;
		data[0][1] = pass;
		data[0][2] = true;
		
		data[1][0] = "usergresit";
		data[1][1] = "passgresit";
		data[1][2] = false;
		
		data[2][0] = user2;
		data[2][1] = pass2;
		data[2][2] = true;
		
		data[3][0] = user;
		data[3][1] = pass2;
		data[3][2] = false;
		
		return data;
				
	}
	
	@Test(dataProvider = "loginTestData")
	public void loginTest(String username, String password, boolean success) {
		
		MenuPage menu = new MenuPage(driver);
		LoginPage login = new LoginPage(driver);
		
		menu.navigateTo(menu.loginLink);
		login.loginInApp(username, password);
		
		if(success){
			assertTrue(login.checkMsgIsDisplayed(login.successLoginMessage));
			login.logoutFromApp();
		}else if(!success) { 
			assertTrue(login.checkMsgIsDisplayed(login.errorLoginMessage));
			login.closeLoginPopUp();
		}
	}
	

}
