package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
	//to store the common elements
	@FindBy(xpath="//div[text()='Tasks']")
	private WebElement taskEle;
	
	 public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getTaskEle() {
		return taskEle;
	}
          
}
