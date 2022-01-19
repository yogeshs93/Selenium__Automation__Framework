package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.driver.DriverManager;

public final class HomePageTest extends BaseTest {
	
	private HomePageTest() {
	}
	
	
	@Test
	public void test2() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("automation",Keys.ENTER);

	}
	

}
