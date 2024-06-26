package com.qalegendbilling.basetest;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.constants.ExtentLogMessage;
import com.qalegendbilling.listeners.TestListener;
import com.qalegendbilling.pages.EditSalesPage;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.ResetPage;
import com.qalegendbilling.pages.SalesCommissionPage;
import com.qalegendbilling.pages.UsersPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegendbilling.utilities.RandomUtility;

public class SalesCommissionBaseTest extends Base{
	HomePage home;
	LoginPage login;
	UsersPage user;
	ResetPage reset;
	SalesCommissionPage sales;
	EditSalesPage editsales;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	
	public void salesCommissionPageTitle() {
		extentTest.get().assignCategory("Exploratory");
		login=new LoginPage(driver);
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("LoginPage");
		String uname=data.get(1).get(1);
		String passwd=data.get(1).get(2);
		login.enterUserName(uname);
		extentTest.get().log(Status.PASS,ExtentLogMessage.USERNAME_CLICKED);
		login.enterPassword(passwd);
		extentTest.get().log(Status.PASS,ExtentLogMessage.PASSWORD_CLICKED);
		home=login.clickLoginButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.LOGIN_BUTTON_CLICKED);
		login.clickOnEndTourButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.ENDTOUR_BUTTON_CLICKED);
		home.clickOnUsermanageSubTab();
		extentTest.get().log(Status.PASS,ExtentLogMessage.USER_MANAGEMENT_SUBTAB);
		sales=home.clickOnSalesCommissionTab();
		extentTest.get().log(Status.PASS,ExtentLogMessage.SALES_COMMISSION_TAB);
		sales=new SalesCommissionPage(driver);
		List<ArrayList<String>> data1=ExcelUtility.excelDataReader("SalesPage");
		String expectedTitle = data1.get(1).get(0);
		String actualTitle=sales.getSalesCommissionPageTitle();
		Assert.assertEquals(expectedTitle,actualTitle,ErrorMessages.SALES_PAGE_TITLE);
		extentTest.get().log(Status.PASS,ExtentLogMessage.TITLE_VALIDATION);
	}
	
	public void userCanAddSalesAgent() {
		extentTest.get().assignCategory("Smoke");
		login=new LoginPage(driver);
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("LoginPage");
		String uname=data.get(1).get(1);
		String passwd=data.get(1).get(2);
		login.enterUserName(uname);
		extentTest.get().log(Status.PASS,ExtentLogMessage.USERNAME_CLICKED);
		login.enterPassword(passwd);
		extentTest.get().log(Status.PASS,ExtentLogMessage.PASSWORD_CLICKED);
		home=login.clickLoginButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.LOGIN_BUTTON_CLICKED);
		login.clickOnEndTourButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.ENDTOUR_BUTTON_CLICKED);
		home.clickOnUsermanageSubTab();
		sales=new SalesCommissionPage(driver);
		sales=home.clickOnSalesCommissionTab();
		sales.clickOnAddButton();
		String firstName=RandomUtility.getfName();
		String lastName=RandomUtility.getlName();
		String email=RandomUtility.getRandomEmail();
		String percent="10";
	    sales.enterDetails(firstName,lastName,email,percent);
		sales.clickOnSaveButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.SAVE_BUTTON_CLICK);
	}
	
	public void userCanEditSales() {
		extentTest.get().assignCategory("Smoke");
		login=new LoginPage(driver);
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("LoginPage");
		String uname=data.get(1).get(1);
		String passwd=data.get(1).get(2);
		login.enterUserName(uname);
		extentTest.get().log(Status.PASS,ExtentLogMessage.USERNAME_CLICKED);
		login.enterPassword(passwd);
		extentTest.get().log(Status.PASS,ExtentLogMessage.PASSWORD_CLICKED);
		home=login.clickLoginButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.LOGIN_BUTTON_CLICKED);
		login.clickOnEndTourButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.ENDTOUR_BUTTON_CLICKED);
		home.clickOnUsermanageSubTab();
		extentTest.get().log(Status.PASS,ExtentLogMessage.USER_MANAGEMENT_SUBTAB);
		sales=new SalesCommissionPage(driver);
		sales=home.clickOnSalesCommissionTab();
		sales.clickOnAddButton();
		String fName=RandomUtility.getfName();
		String lName=RandomUtility.getlName();
		String email=RandomUtility.getRandomEmail();
		String percent="5";
	    sales.enterDetails(fName,lName,email,percent);
		sales.clickOnSaveButton();
		String firstName=fName;
		sales.enterSalesFname(firstName);
		editsales=sales.clickOnEditButton();
		String lastName =RandomUtility.getlName();
		sales.enterlastName(lastName);
		sales.clickOnSaveButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.SAVE_BUTTON_CLICK);
	}
	
	public void userCanDeleteSales() {
		extentTest.get().assignCategory("Sanity");
		login=new LoginPage(driver);
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("LoginPage");
		String uname=data.get(1).get(1);
		String passwd=data.get(1).get(2);
		login.enterUserName(uname);
		extentTest.get().log(Status.PASS,ExtentLogMessage.USERNAME_CLICKED);
		login.enterPassword(passwd);
		extentTest.get().log(Status.PASS,ExtentLogMessage.PASSWORD_CLICKED);
		home=login.clickLoginButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.LOGIN_BUTTON_CLICKED);
		login.clickOnEndTourButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.ENDTOUR_BUTTON_CLICKED);
		home.clickOnUsermanageSubTab();
		extentTest.get().log(Status.PASS,ExtentLogMessage.USER_MANAGEMENT_SUBTAB);
		sales=new SalesCommissionPage(driver);
		sales=home.clickOnSalesCommissionTab();
		extentTest.get().log(Status.PASS,ExtentLogMessage.SALES_COMMISSION_TAB);
		sales.clickOnAddButton();
		String fName=RandomUtility.getfName();
		String lName=RandomUtility.getlName();
		String email=RandomUtility.getRandomEmail();
		String percent="15";
	    sales.enterDetails(fName,lName,email,percent);
		sales.clickOnSaveButton();
		String deleteName=fName;
		sales.enterDeleteSales(deleteName);
		extentTest.get().log(Status.PASS,ExtentLogMessage.ENTER_DELETE_SALES);
		sales.clickOnDeleteButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.DELETE_BUTTON_CLICK);
		sales.clickOnPopupButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.POPUP_BUTTON_CLICK);
	}
}
