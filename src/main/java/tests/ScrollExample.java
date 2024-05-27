package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class ScrollExample extends BaseTest {
	
	//@Test
	public void scrollByAmountTest() {
		//jsExecutor scroll
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0, 1500)");
				
		//action class scroll
		Actions action = new Actions(driver);
		action.scrollByAmount(0, 2000).perform();
		
	}
	
	//@Test
	public void scrollToElement() {
		WebElement signUpButton = driver.findElement(By.cssSelector("input[value='Sign up']"));
		
		//jsExecutor scroll to element
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()",signUpButton);
		
		//action class scroll to element
		Actions action = new Actions(driver);
		
		//action.scrollToElement(signUpButton).perform();
		
	}
	
	@Test
	public void scrollToAndDown() throws InterruptedException {
		
		//jsExecutor scroll
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		jse.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		///action class scroll
		Actions action = new Actions(driver);
		action.sendKeys(Keys.END).perform();
		Thread.sleep(3000);
		action.sendKeys(Keys.HOME).perform();
		
		
	}

}
