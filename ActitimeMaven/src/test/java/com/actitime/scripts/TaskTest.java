package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelLib;
import com.actitime.pageobjects.ActiveProjCustPage;
import com.actitime.pageobjects.CompletedTaskPage;
import com.actitime.pageobjects.CreateNewCustPage;
import com.actitime.pageobjects.CreateNewProjPage;
import com.actitime.pageobjects.CreateNewTaskPage;
import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.LoginPage;
import com.actitime.pageobjects.OpenTaskPage;

public class TaskTest extends BaseLib {
	
	     @Test
	     public void checkCompletedTask() {
	    	 String filepath="./testdata/testdata.xlsx";
	 		ExcelLib elib=new ExcelLib(filepath);
	 		String username = elib.readData("Sheet1", 3, 1);
	 		String password = elib.readData("Sheet1", 3, 2);
	 		String customerName = elib.readData("Sheet1", 3, 3);
	 		String projectName = elib.readData("Sheet1", 3, 4);
	 		String taskName = elib.readData("Sheet1", 3, 5);
	 		String billingType = elib.readData("Sheet1", 3, 6);
	 		
	 		LoginPage lp=new LoginPage(driver);
	 		lp.Login(username, password);
	 		
	 		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
	 		ettp.getTaskEle().click();
	 		
	 		OpenTaskPage otp=new OpenTaskPage(driver);
	 		otp.getProjCustLink().click();
	 		
	 		ActiveProjCustPage apcp=new ActiveProjCustPage(driver);
	 		apcp.getCreateNewCustBtn().click();
	 		
	 		CreateNewCustPage cncp=new CreateNewCustPage(driver);
	 		cncp.createCustomer(customerName);
	 		
	 		apcp.getCreateNewProjBtn().click();
	 		
	 		CreateNewProjPage cnpp=new CreateNewProjPage(driver);
	 		cnpp.createNewProject(customerName, projectName);
	 		
	 		apcp.getOpenTaskEle().click();
	 		
	 		otp.getCreateNewTaskBtn().click();
	 		
	 		CreateNewTaskPage cntp=new CreateNewTaskPage(driver);
	 		cntp.createSingleTask(customerName, projectName, taskName, billingType);
	 		
	 		otp.moveToCompletedTask();
	 		
	 		otp.getCompletedLinkTask().click();
	 		
	 		CompletedTaskPage ctp=new CompletedTaskPage(driver);
	 		ctp.validateCompletedTask(customerName, projectName, taskName);
	     }

}
