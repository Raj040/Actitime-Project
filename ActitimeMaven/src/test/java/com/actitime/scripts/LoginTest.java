package com.actitime.scripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelLib;
import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.LoginPage;

public class LoginTest extends BaseLib{
	@Test(priority = 1,groups= {"Smoke"})
	public void validLogin()
	{
		String filepath="./testdata/testdata.xlsx";
		ExcelLib elib=new ExcelLib(filepath);
		String username = elib.readData("Sheet1", 1, 1);
		String password = elib.readData("Sheet1", 1, 2);
		LoginPage lp=new LoginPage(driver);
		lp.Login(username, password);
		
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		Assert.assertTrue(ettp.getEnterTimeTrackEle().isDisplayed());
		
		String actualPageTitle="actiTIME - Enter Time-Track";
		String expectedHomePageTitle=driver.getTitle();
		Assert.assertEquals(actualPageTitle, expectedHomePageTitle);
		Reporter.log("home page is verified",true);
	}
	
	@Test(priority = 2,groups= {"Functional"})
	public void invalidLogin() {
		
		String filepath="./testdata/testdata.xlsx";
		ExcelLib elib=new ExcelLib(filepath);
		String username = elib.readData("Sheet1", 2, 1);
		String password = elib.readData("Sheet1", 2, 2);
		LoginPage lp=new LoginPage(driver);
		lp.Login(username, password);
		
		String expectedMsg="Username or Password is invalid. Please try again.";
		String actualMsg=lp.getInvalidLoginMsgEle().getText();
		Assert.assertEquals(actualMsg, expectedMsg);
		
		
		
		
	}

}
