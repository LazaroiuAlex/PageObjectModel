package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class ScrollExample extends BaseTest {
	
	//@Test
	public void scrollByAmountTest() {
		
		Actions action = new Actions(driver);
		
		action.scrollByAmount(0, 2000).perform();
		
	}
	
	@Test
	public void scrollToElement() {
		
		Actions action = new Actions(driver);
		WebElement signUpButton = driver.findElement(By.cssSelector("input[value='Sign up']"));
		action.scrollToElement(signUpButton).perform();
		
	}
	
	@Test
	public void scrollToAndDown() throws InterruptedException {
		
		Actions action = new Actions(driver);
		
		action.sendKeys(Keys.END).perform();
		
		Thread.sleep(3000);
		
		action.sendKeys(Keys.HOME).perform();
		
		
	}

}
