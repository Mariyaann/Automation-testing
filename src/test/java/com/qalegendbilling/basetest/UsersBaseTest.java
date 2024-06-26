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
import com.qalegendbilling.pages.AddUserPage;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.UsersPage;
import com.qalegendbilling.pages.ViewUserPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegendbilling.utilities.RandomUtility;

public class UsersBaseTest extends Base{
	HomePage home;
	LoginPage login;
	UsersPage user;
	AddUserPage adduser;
	ViewUserPage viewuser;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	
	public void userPageTitle() {
		extentTest.get().assignCategory("Regression");
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
		user=new UsersPage(driver);
		user=home.clickOnUsersTab();
		extentTest.get().log(Status.PASS,ExtentLogMessage.CLICK_USERS_TAB);
		List<ArrayList<String>> data1=ExcelUtility.excelDataReader("Users");
		String expectedTitle = data1.get(1).get(0);
		String actualTitle=user.getUserPageTitle();
		extentTest.get().log(Status.PASS,ExtentLogMessage.ACTUAL_TITLE_RECEIVED);
		Assert.assertEquals(expectedTitle,actualTitle,ErrorMessages.USERS_PAGE_TITLE);
		extentTest.get().log(Status.PASS,ExtentLogMessage.TITLE_VALIDATION);
	}
	
	public void userSearchWithValidData() {
		extentTest.get().assignCategory("Regression");
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
		user=new UsersPage(driver);
		user=home.clickOnUsersTab();
		extentTest.get().log(Status.PASS,ExtentLogMessage.CLICK_USERS_TAB);
		adduser=user.clickOnAddButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.CLICK_ADD_BUTTON);
		String fname=RandomUtility.getfName();
		String emailField=RandomUtility.getRandomEmail();
		String usernameField=fname;
		String passField=fname+"123";
		String confirmField=passField;
		adduser.enterFirstName(fname);
		extentTest.get().log(Status.PASS,ExtentLogMessage.FIRST_NAME_ENTER);
		adduser.enterEmail(emailField);
		extentTest.get().log(Status.PASS,ExtentLogMessage.EMAIL_ENTER);
		adduser.enterUsername(usernameField);
		extentTest.get().log(Status.PASS,ExtentLogMessage.USERNAME_CLICKED);
		adduser.enterPassword(passField);
		extentTest.get().log(Status.PASS,ExtentLogMessage.PASSWORD_CLICKED);
		adduser.enterConfirmPassword(confirmField);
		extentTest.get().log(Status.PASS,ExtentLogMessage.CONFIRM_PASSWORD_ENTER);
		user=adduser.clickOnSaveButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.SAVE_BUTTON_CLICK);
		List<ArrayList<String>> dataUser=ExcelUtility.excelDataReader("Users");
		String expUsernameField=dataUser.get(1).get(3);
		user.enterUsername(expUsernameField);
		extentTest.get().log(Status.PASS,ExtentLogMessage.USERNAME_CLICKED);
	}
	
	public void messageDisplayedWithInvalidData() {
		extentTest.get().assignCategory("Regression");
		login=new LoginPage(driver);
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("LoginPage");
		List<ArrayList<String>> data1=ExcelUtility.excelDataReader("Users");
		String uname=data.get(1).get(1);
		String passwd=data.get(1).get(2);
		String expMessage=data1.get(1).get(2);
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
		user=new UsersPage(driver);
		user=home.clickOnUsersTab();
		extentTest.get().log(Status.PASS,ExtentLogMessage.CLICK_USERS_TAB);
		String searchuser=RandomUtility.getRandomEmail();
		user.usermail(searchuser);
		extentTest.get().log(Status.PASS,ExtentLogMessage.USER_EMAIL_ENTER);
		String actMessage=user.getErrorMessage();
		Assert.assertEquals(expMessage,actMessage,ErrorMessages.USER_NOT_FOUND);
		extentTest.get().log(Status.PASS,ExtentLogMessage.MESSAGE_VALIDATION);
	}
	
	public void errorMessageDisplayed() {
		extentTest.get().assignCategory("Regression");
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
		user=new UsersPage(driver);
		user=home.clickOnUsersTab();
		extentTest.get().log(Status.PASS,ExtentLogMessage.CLICK_USERS_TAB);
		adduser=user.clickOnAddButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.CLICK_ADD_BUTTON);
		adduser.clickOnSavebutton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.SAVE_BUTTON_CLICK);
		List<ArrayList<String>> data1=ExcelUtility.excelDataReader("AddUserDetails");
		String validation=data1.get(1).get(6);
		adduser.validationMessage(validation);
		extentTest.get().log(Status.PASS,ExtentLogMessage.SAVE_BUTTON_CLICK);
	}
	
	public void userCanDeleteUser(){
		extentTest.get().assignCategory("Regression");
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
		user=new UsersPage(driver);
		user=home.clickOnUsersTab();
		extentTest.get().log(Status.PASS,ExtentLogMessage.CLICK_USERS_TAB);
		adduser=user.clickOnAddButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.CLICK_ADD_BUTTON);
		String fname=RandomUtility.getfName();
		String emailField=RandomUtility.getRandomEmail();
		String usernameField=fname+"12";
		String passField=fname+"123";
		String confirmField=passField;
		adduser.enterFirstName(fname);
		extentTest.get().log(Status.PASS,ExtentLogMessage.FIRST_NAME_ENTER);
		adduser.enterEmail(emailField);
		extentTest.get().log(Status.PASS,ExtentLogMessage.EMAIL_ENTER);
		adduser.enterUsername(usernameField);
		extentTest.get().log(Status.PASS,ExtentLogMessage.USERNAME_CLICKED);
		adduser.enterPassword(passField);
		extentTest.get().log(Status.PASS,ExtentLogMessage.PASSWORD_CLICKED);
		adduser.enterConfirmPassword(confirmField);
		extentTest.get().log(Status.PASS,ExtentLogMessage.CONFIRM_PASSWORD_ENTER);
		user=adduser.clickOnSaveButton();
		String edit=fname;
		user.enterUserNameToDelete(edit);
		extentTest.get().log(Status.PASS,ExtentLogMessage.ENTER_NAME_TO_DELETE);
		user.clickOnDeleteButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.DELETE_BUTTON_CLICK);
		user.clickOnPopupButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.POPUP_BUTTON_CLICK);
	}
	
	public void userCanViewDetails(){
		extentTest.get().assignCategory("Regression");
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
		user=new UsersPage(driver);
		user=home.clickOnUsersTab();
		extentTest.get().log(Status.PASS,ExtentLogMessage.CLICK_USERS_TAB);
		adduser=user.clickOnAddButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.CLICK_ADD_BUTTON);
		String fname=RandomUtility.getfName();
		String emailField=RandomUtility.getRandomEmail();
		String usernameField=fname;
		String passField=fname+"123";
		String confirmField=passField;
		adduser.enterFirstName(fname);
		extentTest.get().log(Status.PASS,ExtentLogMessage.FIRST_NAME_ENTER);
		adduser.enterEmail(emailField);
		extentTest.get().log(Status.PASS,ExtentLogMessage.EMAIL_ENTER);
		adduser.enterUsername(usernameField);
		extentTest.get().log(Status.PASS,ExtentLogMessage.USERNAME_CLICKED);
		adduser.enterPassword(passField);
		extentTest.get().log(Status.PASS,ExtentLogMessage.PASSWORD_CLICKED);
		adduser.enterConfirmPassword(confirmField);
		extentTest.get().log(Status.PASS,ExtentLogMessage.CONFIRM_PASSWORD_ENTER);
		user=adduser.clickOnSaveButton();
		//List<ArrayList<String>> dataEdit=ExcelUtility.excelDataReader("EditUserPage");
		//String expviewMessage=dataEdit.get(1).get(4);
		String expviewMessage=emailField;
		user.enterUserNameToView(expviewMessage);
		extentTest.get().log(Status.PASS,ExtentLogMessage.ENTER_NAME_TO_VIEW);
		viewuser=user.clickOnViewButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.VIEW_BUTTON_CLICK);
		viewuser.isDisplayed();
		//String actviewMessage=viewuser.getErrorMessage();
		//Assert.assertEquals(expviewMessage,actviewMessage,ErrorMessages.VIEW_EMAIL_VALIDATE);
		//extentTest.get().log(Status.PASS,ExtentLogMessage.MESSAGE_VALIDATION);
	}
}
