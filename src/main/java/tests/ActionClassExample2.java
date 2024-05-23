package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class ActionClassExample2 extends BaseTest {
	
	@Test
	public void copyPasteTeste() {
		
		WebElement discoverText = driver.findElement(By.tagName("em"));
		WebElement loginButton = driver.findElement(By.cssSelector("li[class='menu_user_login']"));
		WebElement userField = driver.findElement(By.id("log"));
		
		Keys cmdCtrl = Platform.getCurrent().is(Platform.WINDOWS) ? Keys.CONTROL : Keys.COMMAND; //folosit ternery pentru a stabily ce system de operare este folosit
		
		Actions action = new Actions(driver);
		
		action.moveToElement(discoverText).doubleClick().keyDown(Keys.SHIFT).sendKeys(Keys.ARROW_LEFT).keyUp(Keys.SHIFT).perform();
		
		action
			.keyDown(cmdCtrl)
			.sendKeys("c")
			.keyUp(cmdCtrl)
			.perform();
		
		
		loginButton.click();
		userField.click();
		
		action
		.keyDown(cmdCtrl)
		.sendKeys("v")
		.keyUp(cmdCtrl)
		.perform();
		
	}

}
