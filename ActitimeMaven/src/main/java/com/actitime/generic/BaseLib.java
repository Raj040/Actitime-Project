package com.actitime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseLib {
	public static WebDriver driver;
	@BeforeMethod(groups= {"Smoke","Functional","Integration","System"})
	@Parameters({"browser","baseurl"})
	public void preCondition(String browserName, String Url) {
		driver=BrowserFactory.LaunchBrowser(browserName);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Url);
		Reporter.log( Url + " Url navigated : ",true);
	}
	 @AfterMethod(groups= {"Smoke","Functional","Integration","System"})
	 public void postCondition() {
		 driver.close();
		 Reporter.log("Browser closed:",true);
	 }

}
