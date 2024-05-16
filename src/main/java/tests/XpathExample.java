
package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.PropertiesFileProcessor;

public class XpathExample extends BaseTest {
	
	/*
	 * CSS: li[class='menu_user_login']
	 * XPATH: //li[@class='menu_user_login']
	 */
	
	String user = PropertiesFileProcessor.readPropertiesFile("username", "credential.properties");
	String pass = PropertiesFileProcessor.readPropertiesFile("password", "credential.properties");
	
	@Test (priority = 1)
	public void xPathExampleTest() {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		WebElement loginButton = driver.findElement(By.xpath("//li[@class='menu_user_login']"));
		
		jse.executeScript("arguments[0].setAttribute('style', 'background: yellow;border:6px solid green;')", loginButton);
		
		loginButton.click();
		
		//OR
		
		WebElement userField = driver.findElement(By.xpath("//input[@id='log' or @name='log']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background: yellow;border:6px solid green;')", userField);
		userField.sendKeys(user);
		
		//AND
		WebElement passField = driver.findElement(By.xpath("//input[@type='password' and @name='pwd']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background: yellow;border:6px solid green;')", passField);
		passField.sendKeys(pass);
		
		WebElement submitButton = driver.findElement(By.xpath("//div[@class='popup_form_field submit_field']/input"));
		submitButton.click();
		
		
	}
	@Test(priority = 2)
	public void xPathExampleTest2() throws InterruptedException {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		WebElement userName = driver.findElement(By.xpath("//span[@class='user_name']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background: gray;border:6px solid red;')", userName);
		Thread.sleep(2000); //just for visual feedback, bad practice to use
		userName.click();
		
		//text() --> referinta catre textul dintr tagurile HTML
		WebElement textSettings = driver.findElement(By.xpath("//a[text()='Settings']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background: gray;border:6px solid red;')", textSettings);
		Thread.sleep(2000);
		textSettings.click();
		//<a href="https://keybooks.ro/account/orders/">recent orders</a>
		//a[text()='recent orders']
		//daca cautam doar textul partial folosim contains()
		
		WebElement recentOrdersLink = driver.findElement(By.xpath("//a[contains(text(), 'rece')]"));
		jse.executeScript("arguments[0].setAttribute('style', 'background: gray;border:6px solid red;')", recentOrdersLink);
		Thread.sleep(2000);
		recentOrdersLink.click();
		
		WebElement orderTableHead = driver.findElement(By.xpath("//th[contains(@class,'woocommerce-orders-table__header-order-number')]"));
		jse.executeScript("arguments[0].setAttribute('style', 'background: pink;border:6px solid red;')", orderTableHead);
		Thread.sleep(2000);
		
		WebElement dateTableHead = driver.findElement(By.xpath("//th[contains(@class,'woocommerce-orders-table__header-order-date')]/span[contains(text(), 'Date')]"));
		jse.executeScript("arguments[0].setAttribute('style', 'background: pink;border:6px solid yellow;')", dateTableHead);
		Thread.sleep(2000);
		
		
		//identificare pe baza de index --> (//span[@class='nobr'])[3]
		WebElement statusTableHead = driver.findElement(By.xpath("(//span[@class='nobr'])[3]"));
		jse.executeScript("arguments[0].setAttribute('style', 'background: violet;border:6px solid blue;')", statusTableHead);
		Thread.sleep(2000);
		
		/*
		 * <a href="https://keybooks.ro/account/view-order/1720/">#1720</a>
		 * 
		 * //a[@href='https://keybooks.ro/account/view-order/1720/">#1720']
		 *  //a[contains(@href, '1720')]
		 *  //a[contains(text, '#1720')]
		 *  //td[contains(@class, 'woocommerce-orders-table-cell')][@data-title='Order']/a[not(contains(text, '#1720'))]
		 */
		
		List<WebElement> orderNumbers = driver.findElements(By.xpath("//td[contains(@class, 'woocommerce-orders-table__cell')][@data-title='Order']/a[not(contains(text(), '#1720'))]"));
		
		for(WebElement order : orderNumbers) {
			
			jse.executeScript("arguments[0].setAttribute('style', 'background: red;border:6px solid blue;')", order);
		}
		
		
		Thread.sleep(2000);
		
		
		
		
	}

	
}
