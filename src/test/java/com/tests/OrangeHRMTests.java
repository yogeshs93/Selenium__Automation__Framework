package com.tests;

import java.io.IOException;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.annotations.FrameworkAnnotations;
import com.enums.CategoryType;
import com.listeners.RetryFailedTests;
import com.pages.OrangeHRMLoginPage;
import com.utils.DataProviderUtils;

public final class OrangeHRMTests extends BaseTest{

	private OrangeHRMTests() {
	}
	@FrameworkAnnotations(author={"yogesh","sachin"},category={CategoryType.REGRESSION,CategoryType.SMOKE})
	@Test(dataProvider = "getData",retryAnalyzer=RetryFailedTests.class)
	public void loginLogoutTest(Map<String,String> map) {



		OrangeHRMLoginPage ohlp = new OrangeHRMLoginPage();




		String title = ohlp.enterUserame(map.get("username")).enterPassword(map.get("password")).clickLogin()
				.clickWelcome().clickLogout().getTitle();

		Assertions.assertThat(title)
		.isEqualTo("OrangeHRM");

	}


	@FrameworkAnnotations(author={"yogesh","virat"},category={CategoryType.REGRESSION,CategoryType.SMOKE})
	@Test(dataProvider = "getData",retryAnalyzer=RetryFailedTests.class)
	public void newTest(Map<String,String> map) {



		OrangeHRMLoginPage ohlp = new OrangeHRMLoginPage();




		String title = ohlp.enterUserame(map.get("username")).enterPassword(map.get("password")).clickLogin()
				.clickWelcome().clickLogout().getTitle();

		Assertions.assertThat(title)
		.isEqualTo("OrangeHRM");

	}
	/*
	@DataProvider(name="LoginTestDataProvider",parallel=true)
	public Object[][] getData(){

		return new Object[][] {
			{"Admin","admin123"},
			{"Admin","admin1234"}
			{"Admin","admin123"},
			{"admin","admin"}
		};
		}*/
	@DataProvider(parallel=true)
	public Object[] getData() throws IOException {
		return DataProviderUtils.getData("logindata");
	}

}
