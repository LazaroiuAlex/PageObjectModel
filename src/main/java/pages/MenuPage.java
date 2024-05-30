package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MenuPage {
	
	public WebDriver driver;
	
	public MenuPage(WebDriver driver) {
		this.driver = driver;	
	}
	
	//locator scris pentru a putea fi refolosit
	public By loginLink = By.linkText("Login");
	public By contactsLink = By.linkText("CONTACTS");
	public By shopLink = By.linkText("BOOKS");
	public By aboutLink = By.linkText("ABOUT");
	public By blogLink = By.linkText("BLOG");
	public By eventsLink = By.linkText("EVENTS");
	
	public void navigateTo(By locator) {
		driver.findElement(locator).click();
		
	}
	
	public void hoverElement(By locator) {
		
		WebElement element = driver.findElement(locator);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
}
