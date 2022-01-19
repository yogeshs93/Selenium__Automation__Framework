package com.driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.constants.FrameworkConstants;
import com.enums.ConfigProperties;
import com.utils.JsonUtils;
import com.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class Driver {
	private Driver() {
		
	}
	
	public static void initDriver()  {
		if(Objects.isNull(DriverManager.getDriver())) {
		//System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriver());
			if(PropertyUtils.get(ConfigProperties.BROWSER).equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		DriverManager.setDriver( new ChromeDriver());
			}
			else if(PropertyUtils.get(ConfigProperties.BROWSER).equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				DriverManager.setDriver(new EdgeDriver());
			}
			else if(PropertyUtils.get(ConfigProperties.BROWSER).equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				DriverManager.setDriver(new FirefoxDriver());
			}
			else if(PropertyUtils.get(ConfigProperties.BROWSER).equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				DriverManager.setDriver(new InternetExplorerDriver());
			}
		DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
		}
	}
	
	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
