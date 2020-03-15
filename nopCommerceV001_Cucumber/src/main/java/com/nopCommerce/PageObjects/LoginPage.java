package com.nopCommerce.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='Email']")
	public static WebElement enterEmailField;
	
	@FindBy(xpath="//input[@id='Password']")
	public static WebElement enterPasswordField;
	
	@FindBy(xpath="//input[@value='Log in']")
	public static WebElement clickLoginBtn;
	
	@FindBy(xpath="//a[text()='Logout']")
	public static WebElement clickLogoutBtn;
	
	public static void setUsername(String uname)
	{
		enterEmailField.clear();
		enterEmailField.sendKeys(uname);
	}
	
	public static void setPassword(String pass)
	{
		enterPasswordField.clear();
		enterPasswordField.sendKeys(pass);
	}
	
	public static void clickLogon()
	{
		clickLoginBtn.click();
	}
	
	public static void clickLogout()
	{
		clickLogoutBtn.click();
	}
}
