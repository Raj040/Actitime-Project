package com.actitime.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class CompletedTaskPage {
	@FindBy(css="table[class='listTable']")
	private WebElement completedTaskTable;
	
	public CompletedTaskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCompletedTaskTable() {
		return completedTaskTable;
	}
	public void validateCompletedTask(String customerName,String projectName,String taskName) {
		List<WebElement> rows = completedTaskTable.findElements(By.tagName("tr"));
		for(int i=1;i<rows.size();i++) {
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			
			for(int j=0;j<cols.size();j++) {
				if (cols.get(i).getText().equalsIgnoreCase(customerName)&& cols.get(i).getText().equalsIgnoreCase(projectName)) {
					WebElement thirdcol = cols.get(2);
					String actualTaskName = thirdcol.findElement(By.tagName("a")).getText();
					Assert.assertEquals(actualTaskName, taskName);
					Reporter.log("Completed task" +taskName+" is verified");
					break;
				}
			}
		}
	}

}
