package com.nopCommerce.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nopCommerce.utilities.WaitHelper;

public class AddCustomerPage {

public WebDriver driver;
public WaitHelper waitHelper;
	
	public AddCustomerPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}
	
	@FindBy(xpath="//a[@href='#']//span[text()='Customers']")
	public static WebElement CustomersOption;
	
	@FindBy(xpath="//span[@class='menu-item-title'][text()='Customers']")
	public static WebElement CustomersMenuOption;
	
	@FindBy(xpath="//a[@class='btn bg-blue']")
	public static WebElement AddNewBtn;
	
	@FindBy(xpath="//input[@id='Email']")
	public static WebElement EmailTxtField;
	
	@FindBy(xpath="//input[@id='Password']")
	public static WebElement PasswordTxtField;
	
	@FindBy(xpath="//input[@id='FirstName']")
	public static WebElement FirstNameTxtField;
	
	@FindBy(xpath="//input[@id='LastName']")
	public static WebElement LastNameTxtField;
	
	
	@FindBy(xpath="//input[@id='Gender_Male']")
	public static WebElement MaleGenderBtn;;
	
	@FindBy(xpath="//input[@id='Gender_Female']")
	public static WebElement FemaleGenderBtn;
	
	@FindBy(xpath="//input[@id='DateOfBirth']")
	public static WebElement DobField;
	
	@FindBy(xpath="//input[@id='Company']")
	public static WebElement companyNameField;
	
	@FindBy(xpath="//div[@class='k-multiselect-wrap k-floatwrap']")
	public static WebElement CustomerRolesField;
	
	@FindBy(xpath="//li[text()='Registered']")
	public static WebElement RegisteredListItem;
	
	@FindBy(xpath="//li[text()='Forum Moderators']")
	public static WebElement ForumModeratorsListItem;
	
	@FindBy(xpath="//li[text()='Administrators']")
	public static WebElement AdministratorsListItem;
	
	@FindBy(xpath="//li[text()='Guests']")
	public static WebElement GuestsListItem;
	
	@FindBy(xpath="//li[text()='Vendors']")
	public static WebElement VendorsListItem;
	
	@FindBy(xpath="//select[@id='VendorId']")
	public static WebElement drpMgrOfVendor;
	
	@FindBy(xpath="//*[@id='AdminComment']")
	public static WebElement AdminContentField;
	
	@FindBy(xpath="//button[@name='save']")
	public static WebElement SaveBtn;
	
	//Action Methods for every WebElement
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public void customersOption()
	{
		CustomersOption.click();
	}
	
	public void customerMenuItemOption()
	{
		CustomersMenuOption.click();
	}
	
	public void addNewBtn()
	{
		AddNewBtn.click();
	}
	
	public void enterEmail(String email)
	{	
		EmailTxtField.clear();
		EmailTxtField.sendKeys(email);
	}
	
	public void enterPassword(String pass)
	{
		PasswordTxtField.clear();
		PasswordTxtField.sendKeys(pass);
	}
	
	public void enterFirstName(String fname)
	{
		FirstNameTxtField.clear();
		FirstNameTxtField.sendKeys(fname);
	}
	
	public void enterLastName(String lname)
	{
		LastNameTxtField.clear();
		LastNameTxtField.sendKeys(lname);
	}
	
	public void selectGender(String gender)
	{
		if(gender.equalsIgnoreCase("male"))
		{
			MaleGenderBtn.click();
		}
		else 
		{
			FemaleGenderBtn.click();
		}
	
	}
	
	public void enterDOB(String dob)
	{
		DobField.clear();
		DobField.sendKeys(dob);
	}
	
	public void companyName(String cname)
	{
		companyNameField.clear();
		companyNameField.sendKeys(cname);
	}
	
	public void selectCustomerRoles(String customerRole) throws InterruptedException
	{
		waitHelper.waitForElement(CustomerRolesField, 30);
		CustomerRolesField.click();
		
		if(customerRole.equalsIgnoreCase("Registered"))
		{
			waitHelper.waitForElement(CustomerRolesField, 30);
			RegisteredListItem.click();
		}
		else if(customerRole.equalsIgnoreCase("Guests"))
		{
			waitHelper.waitForElement(CustomerRolesField, 30);
			GuestsListItem.click();
		}
		else if(customerRole.equalsIgnoreCase("Administrators"))
		{
			waitHelper.waitForElement(CustomerRolesField, 30);
			AdministratorsListItem.click();
		}
		else if(customerRole.equalsIgnoreCase("Vendors"))
		{
			waitHelper.waitForElement(CustomerRolesField, 30);
			VendorsListItem.click();
		}
		else
		{
			waitHelper.waitForElement(CustomerRolesField, 30);
			ForumModeratorsListItem.click();
		}
	}
	
	public void vendorManager(String manager)
	{
		Select select = new Select(drpMgrOfVendor);
		select.selectByVisibleText(manager);
	}
	
	public void adminContent(String content)
	{
		AdminContentField.clear();
		AdminContentField.sendKeys(content);
	}
	
	public void clickSave()
	{
		SaveBtn.click();
	}
	
	
}
