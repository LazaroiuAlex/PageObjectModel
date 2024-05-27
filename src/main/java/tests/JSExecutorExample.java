package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class JSExecutorExample extends BaseTest{
	
	//@Test
	public void example1() {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Actions action = new Actions(driver);
		jse.executeScript("window.location='https://keyfood.ro'");
		
		//driver.navigate().back()
		jse.executeScript("window.history.go(-1)");
		
		//driver.navigate().forward()
		jse.executeScript("window.history.forward()");
		
		//1
		driver.navigate().refresh();
		//2
		jse.executeScript("window.history.go(0)");
		//3
		action.sendKeys(Keys.F5).perform();
		//4
		driver.get(driver.getCurrentUrl());
	}
	
	//@Test
	public void example2() {
		
		WebElement searchIcon = driver.findElement(By.cssSelector("button[class*='icon-search']"));
		WebElement searchInput = driver.findElement(By.cssSelector("input[class='search_field']"));
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		//alternativa pentru click()
		//jse.executeScript("arguments[0].click()", searchIcon);
		
		//alternativa pentru sendKeys()
		//jse.executeScript("arguments[0].value='cooking'", searchInput);
		
		//alternativa pentru click()
		//jse.executeScript("arguments[0].click()", searchIcon);
		
		//bypass selenium for above alternatives
		jse.executeScript("document.getElementsByClassName('icon-search')[0].click()");
		jse.executeScript("document.getElementsByClassName('search_field')[0].value='cooking'");
		jse.executeScript("document.getElementsByClassName('icon-search')[0].click()");
		
		//sau asa but not recommended because of harder readability
		/*
		 * jse.executeScript("document.getElementsByClassName('icon-search')[0].click();"
				+"document.getElementsByClassName('search_field')[0].value='cooking';"
				+"document.getElementsByClassName('icon-search')[0].click();");
		*/
		
		//alternativa pentru getText()
		String bookTitle = jse.executeScript("return document.getElementsByClassName('post_title')[0].childNodes[0].innerText").toString();
		System.out.println(bookTitle);
		
		//alternativa pentru isDisplayed()
		boolean titleVisible = (boolean) jse.executeScript("return document.getElementsByClassName('post_title')[0].childNodes[0].checkVisibility()");
		System.out.println(titleVisible);
		
		//alternativa pentru getTitle()
		String pageTitle = jse.executeScript("return document.title").toString();
		System.out.println(pageTitle);
		System.out.println(driver.getTitle());
		
		//alternativa pentru getCurrentURL()
		String pageUrl = jse.executeScript("return document.URL").toString();
		System.out.println(pageUrl);
		System.out.println(driver.getCurrentUrl());
		
		
		jse.executeScript("document.getElementsByClassName('popup_link')[0].click()");
		
		//alternativa pentru isSelected
		boolean checkBoxSelected = (boolean) jse.executeScript("return document.getElementById('rememberme').checked");
		System.out.println(checkBoxSelected);
		
		jse.executeScript("document.getElementById('rememberme').click()");
		boolean checkBoxSelectedAfterClick = (boolean) jse.executeScript("return document.getElementById('rememberme').checked");
		System.out.println(checkBoxSelectedAfterClick);
		
		//alternativa pentru isEnabled()
		boolean isPasswordFieldDisabled = (boolean) jse.executeScript(" return document.getElementById('password').disabled");
		System.out.println(isPasswordFieldDisabled);
		
	}
	
	@Test
	public void example3() {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		System.out.println(driver.getTitle());
		
		jse.executeScript("window.altTitlu = function(){document.title = 'Alt Titlu'};" + "window.altTitlu.call()");
		
		System.out.println(driver.getTitle());
	}

}
