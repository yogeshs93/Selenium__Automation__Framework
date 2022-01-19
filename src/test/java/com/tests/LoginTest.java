package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.driver.DriverManager;

public final class LoginTest extends BaseTest{
	
	private LoginTest() {
			
	}
	
	
	
	@Test
	public void test1() {
		
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("automation",Keys.ENTER);
	}
	
	

}
