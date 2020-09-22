package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenTaskPage {
	@FindBy(linkText="Projects & Customers")
	private WebElement projCustLink;
	@FindBy(css="input[value='Create New Tasks']")
	private WebElement createNewTaskBtn;
	@FindBy(css="input[name*='taskSelected']")
	private WebElement selectTasksCheckBx;
	@FindBy(css="input[value='Complete Selected Tasks']")
	private WebElement completeSelectedTasksBtn;
	@FindBy(linkText="Completed Tasks")
	private WebElement completedLinkTask;
	
	
	public OpenTaskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getProjCustLink() {
		return projCustLink;
	}

	public WebElement getCreateNewTaskBtn() {
		return createNewTaskBtn;
	}

	public WebElement getSelectTasksCheckBx() {
		return selectTasksCheckBx;
	}

	public WebElement getCompleteSelectedTasksBtn() {
		return completeSelectedTasksBtn;
	}
	
	public WebElement getCompletedLinkTask() {
		return completedLinkTask;
	}

	public void moveToCompletedTask() {
		if (selectTasksCheckBx.isSelected()) {
			
		}
		else {
			selectTasksCheckBx.click();
		}
		completeSelectedTasksBtn.click();
		
	}

}
