package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterTimeTrackPage extends BasePage {
	@FindBy(xpath="//td[text()='Enter Time-Track']")
	private WebElement enterTimeTrackEle;
	
	public EnterTimeTrackPage(WebDriver driver) {
		 super(driver);
		PageFactory.initElements(driver, this);
	}

	public WebElement getEnterTimeTrackEle() {
		return enterTimeTrackEle;
	}
	
	

}
