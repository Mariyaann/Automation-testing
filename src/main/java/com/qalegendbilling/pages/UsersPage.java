package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;
import com.qalegendbilling.utilities.WaitUtility;

public class UsersPage extends TestHelperUtility{
	public WebDriver driver;
	public UsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	private final String _addButton="//a[@class='btn btn-block btn-primary']";  
	@FindBy(xpath=_addButton)
	private WebElement addButton;
	private final String _searchField="//input[@class='form-control input-sm']";  
	@FindBy(xpath=_searchField)
	private WebElement searchField;
	private final String _usernameField="username";  
	@FindBy(id=_usernameField)
	private WebElement usernameField;
	private final String _errorMessage="//td[text()='No matching records found']";  
	@FindBy(xpath=_errorMessage)
	private WebElement errorMessage;
	private final String _editButton="//i[@class='glyphicon glyphicon-edit']";  
	@FindBy(xpath=_editButton)
	private WebElement editButton;
	public final String _deleteUser="//input[@class='form-control input-sm']";
	@FindBy(xpath=_deleteUser)
	private WebElement deleteUser;
	private final String _deleteButton="//button[@class='btn btn-xs btn-danger delete_user_button'][1]";  
	@FindBy(xpath=_deleteButton)
	private WebElement deleteButton;
	private final String _popupButton="//button[@class='swal-button swal-button--confirm swal-button--danger']";  
	@FindBy(xpath=_popupButton)
	private WebElement popupButton;
	private final String _viewButton="//a[@class='btn btn-xs btn-info']";  
	@FindBy(xpath=_viewButton)
	private WebElement viewButton;
	
	
	public String getUserPageTitle() {
		String title=page.getPageTitle(driver);
		return title;
	}
	public AddUserPage clickOnAddButton() {
		page.clickOnElement(addButton);
		return new AddUserPage(driver);
	}
	public void enterSearchField(String username) {
		page.enterText(usernameField,username);
	}
	public void clickOnSearchField() {
		page.clickOnElement(searchField);
	}
	public void enterUsername(String username) {
		wait.setHardWait();
		wait.waitForElementToBeVisible(driver, _searchField,WaitUtility.LocatorType.Xpath);
		page.enterText(searchField,username);
	}
	public void usermail(String umail) {
		page.enterText(searchField,umail);
	}
	public String getErrorMessage() {
		wait.setHardWait();
		wait.waitForElementToBeVisible(driver, _errorMessage,WaitUtility.LocatorType.Xpath);
		String errMessage=page.getElementText(errorMessage);
		return errMessage;
	}
	public void enterUserNameForEditing(String editname) {
		page.enterText(searchField,editname);
	}
	public EditUserPage clickOnEditButton() {
		wait.setHardWait();
		wait.waitForElementToBeVisible(driver, _editButton,WaitUtility.LocatorType.Xpath);
		page.clickOnElement(editButton);
		return new EditUserPage(driver);
	}
	public void enterUserNameToDelete(String delUser) {
		wait.setHardWait();
		wait.waitForElementToBeVisible(driver, _deleteUser,WaitUtility.LocatorType.Xpath);
		page.enterText(deleteUser,delUser);
	}
	public void clickOnDeleteButton() {
		wait.setHardWait();
		wait.waitForElementToBeVisible(driver, _deleteButton,WaitUtility.LocatorType.Xpath);
		page.clickOnElement(deleteButton);
	}
	public void clickOnPopupButton() {
		page.clickOnElement(popupButton);
	}
	public void enterUserNameToView(String viewuser) {
		page.enterText(searchField,viewuser);
	}
	public ViewUserPage clickOnViewButton() {
		wait.setHardWait();
		wait.waitForElementToBeVisible(driver, _viewButton,WaitUtility.LocatorType.Xpath);
		page.clickOnElement(viewButton);
		return new ViewUserPage(driver);
	}
	
}
