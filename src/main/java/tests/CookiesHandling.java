package tests;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import utils.BaseTest;

public class CookiesHandling extends BaseTest {
	
	@Test(priority=1)
	public void addCookie() {
		
		Cookie cookie = new Cookie("My Cookie", "My cookie value");
		
		driver.manage().addCookie(new Cookie("MyOtherCookie", "My cookie value"));
		driver.manage().addCookie(cookie);
		
	}
	
	@Test(priority=2)
	public void getCookieNamed() {
		
		Cookie cookie = driver.manage().getCookieNamed("PHPSESSID");
		System.out.println(cookie);
		
	}
	
	@Test(priority=3)
	public void getAllCookies() {
		
		Set<Cookie> allCookies = driver.manage().getCookies();
		System.out.println(allCookies);
	}
	
	@Test(priority=4)
	public void deleteCookie() {
		
		driver.manage().deleteCookieNamed("PHPSESSID");
		
		Set<Cookie> allCookies = driver.manage().getCookies();
		System.out.println(allCookies);
		
	}
	
	@Test(priority=5)
	public void deleteAllCookie() {
		
		driver.manage().deleteAllCookies();;
		
		Set<Cookie> allCookies = driver.manage().getCookies();
		System.out.println(allCookies);
		
	}

}
