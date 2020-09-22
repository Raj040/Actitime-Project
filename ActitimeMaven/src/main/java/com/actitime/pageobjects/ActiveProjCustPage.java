package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiveProjCustPage {
	@FindBy(css="input[value='Create New Customer']")
	private WebElement createNewCustBtn;
	@FindBy(css="input[value='Create New Project']")
	private WebElement createNewProjBtn;
	@FindBy(linkText = "Open Tasks")
	private WebElement openTaskEle;
	
	public ActiveProjCustPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateNewCustBtn() {
		return createNewCustBtn;
	}

	public WebElement getCreateNewProjBtn() {
		return createNewProjBtn;
	}

	public WebElement getOpenTaskEle() {
		return openTaskEle;
	}
	

}
