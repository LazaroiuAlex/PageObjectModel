package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class NavigationExample extends BaseTest {
	
	@Test
	public void navigationTest() throws InterruptedException {
		
		driver.navigate().to("https://keyfood.ro/");
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.F5).perform();
		
	}

}
