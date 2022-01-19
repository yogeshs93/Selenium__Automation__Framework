package com.pages;

import org.openqa.selenium.By;

import com.enums.WaitStrategy;

public final class OrangeHRMLoginPage extends BasePage {
	
	private final By textbox_username=By.id("txtUsername");
	private final By textbox_password=By.id("txtPassword");
	private final By button_login = By.id("btnLogin");
	
	public OrangeHRMLoginPage enterUserame(String username) {
		sendKeys(textbox_username, username , WaitStrategy.PRESENCE,"username");
		return this;
	}
	
	public OrangeHRMLoginPage enterPassword(String password) {
		sendKeys(textbox_password, password , WaitStrategy.PRESENCE,"password");
		return this;
	}
	
	public OrangeHRMHomePage clickLogin() {
		click(button_login , WaitStrategy.PRESENCE,"login button");
		return new OrangeHRMHomePage();
	}

	public String getTitle() {
		return getPageTitle();
		
	}
	
	

}
