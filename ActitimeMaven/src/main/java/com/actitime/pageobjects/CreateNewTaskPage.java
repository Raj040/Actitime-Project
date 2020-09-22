package com.actitime.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewTaskPage {
	  @FindBy(name="customerId")
	  private WebElement customerDrpdwn;
	  @FindBy(name="projectId")
	  private WebElement projectDrpDwn;
	  @FindBy(css="input[name*='.name']")
	  private List<WebElement> taskNameTxtBx;
	  @FindBy(css="select[name*='.billingType']")
	  private List<WebElement> billingTyppeDrpDwn;
	  @FindBy(css="input[name*='markedToBeAddedToUserTasks']")
	  private List<WebElement> addMyTimeTrackCheckBox;
	  @FindBy(css="input[value='Create Tasks']")
	  private WebElement createTasksBtn;
	  
	  public CreateNewTaskPage(WebDriver driver) {
		  PageFactory.initElements(driver,this);
	  }

	public WebElement getCustomerDrpdwn() {
		return customerDrpdwn;
	}

	public WebElement getProjectDrpDwn() {
		return projectDrpDwn;
	}

	public List<WebElement> getTaskNameTxtBx() {
		return taskNameTxtBx;
	}

	public List<WebElement> getBillingTyppeDrpDwn() {
		return billingTyppeDrpDwn;
	}

	public List<WebElement> getAddMyTimeTrackCheckBox() {
		return addMyTimeTrackCheckBox;
	}

	public WebElement getCreateTasksBtn() {
		return createTasksBtn;
	}
	  public void createSingleTask(String customerName, String projectName, String taskName, String billingType) {
		  Select sel1=new Select(customerDrpdwn);
		  sel1.selectByVisibleText(customerName);
		  
		  Select sel2=new Select(projectDrpDwn);
		  sel2.selectByVisibleText(projectName);
		  
		  taskNameTxtBx.get(0).sendKeys(taskName);
		  
		  Select sel3=new Select(billingTyppeDrpDwn.get(0));
		  sel3.selectByVisibleText(billingType);
		  WebElement chkbx = addMyTimeTrackCheckBox.get(0);
		  if (chkbx.isSelected()) {
			}
		  else {
			chkbx.click();
		}
		  createTasksBtn.click();
		  
		  
	  }
	  

}
