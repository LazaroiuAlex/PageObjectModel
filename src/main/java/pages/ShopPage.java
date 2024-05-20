package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import utils.BaseTest;

public class ShopPage extends BaseTest {
	
	public WebDriver driver;
	
	public ShopPage(WebDriver driver) {
		this.driver = driver;
		
	}

	//locatori
	public By orderDropdown = By.name("orderby");
	public By sliderInitialPosition = By.xpath("//span[@style='left: 0%;']");
	public By sliderFinalPosition = By.xpath("//span[@style='left: 100%;']");
	
	//metode
	public void filterByValue(String value) {
		
		WebElement element = driver.findElement(orderDropdown);
		Select selectDropdown = new Select(element);
		selectDropdown.selectByValue(value);
		
	}
	
	public void filterByIndex(int index) {
		
		WebElement element = driver.findElement(orderDropdown);
		Select selectDropdown = new Select(element);
		selectDropdown.selectByIndex(index);
		
	}
	
	public void filterByVisibleText(String visibleText) {
		
		WebElement element = driver.findElement(orderDropdown);
		Select selectDropdown = new Select(element);
		selectDropdown.selectByVisibleText(visibleText);
		
	}
		
	
	public String getCurrentSelectedOption() {
		
		WebElement element = driver.findElement(orderDropdown);
		Select selectDropdown = new Select(element);
		return selectDropdown.getFirstSelectedOption().getText();
	}
	
	public void dragAndDrop(By locator, int x, int y) {
		
		WebElement element = driver.findElement(locator);
		Actions action = new Actions(driver);
		action.dragAndDropBy(element, x, y).perform();
		
		//action.moveToElement(element).clickAndHold(element).moveByOffset(x, y).release().perform(); --> same as above doar ca este scris ca un action chain in loc sa folosim dragAndDrop
		
	}
	
	
	
}
