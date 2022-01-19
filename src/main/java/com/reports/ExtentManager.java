package com.reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {
	
	private ExtentManager() {}
	
	private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>() ;

	static ExtentTest getExtentTest() {
		return extTest.get();
	}

	static void setExtentTest(ExtentTest test) {
		if(Objects.nonNull(test)) {
		extTest.set(test);
		}
	}

	static void unload() {
		extTest.remove();
	}
	
	

}
