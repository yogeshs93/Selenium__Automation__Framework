package com.pages;

import org.openqa.selenium.By;

import com.enums.WaitStrategy;

public final class OrangeHRMHomePage extends BasePage{
	
	private final By link_welcome = By.id("welcome");
	private final By link_logout = By.xpath("//a[text()='Logout']");
	
	public OrangeHRMHomePage clickWelcome() {
		click(link_welcome , WaitStrategy.PRESENCE,"welcome link");
		return this;
	}

	public OrangeHRMLoginPage clickLogout() {
		
		click(link_logout , WaitStrategy.CLICKABLE,"logout button");
		return new OrangeHRMLoginPage();
	}
}
