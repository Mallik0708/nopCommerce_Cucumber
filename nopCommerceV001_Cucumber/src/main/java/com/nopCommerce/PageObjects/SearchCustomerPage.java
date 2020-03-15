package com.nopCommerce.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.nopCommerce.utilities.WaitHelper;

public class SearchCustomerPage {

	
	public WebDriver driver;
	public WaitHelper waitHelper;
	public SearchCustomerPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		 waitHelper = new WaitHelper(driver);
	}
	
	//Page WebElements
	@FindBy(xpath="//input[@id='SearchEmail']")
	public static WebElement searchEmailTxt;
	
	@FindBy(xpath="//input[@id='SearchFirstName']")
	public static WebElement searchFirstName;
	
	@FindBy(xpath="//input[@id='SearchLastName']")
	public static WebElement searchLastName;
	
	@FindBy(xpath="//select[@id='SearchMonthOfBirth']")
	public static WebElement dobMonth;
	
	@FindBy(xpath="//select[@id='SearchDayOfBirth']")
	public static WebElement dobDay;
	
	@FindBy(xpath="//button[@id='search-customers']")
	public static WebElement searchBtn;
	
	@FindBy(xpath="//table[@role='grid']")
	public static WebElement tableSearchResults;
	
	@FindBy(xpath="//table[@id='customers-grid']")
	public static WebElement table;
	
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
	public static List<WebElement> tableRows;
	
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr/td")
	public static List<WebElement> tableColumns;
	
	//Action Methods
	
	public void setEmail(String email)
	{
		waitHelper.waitForElement(searchEmailTxt, 30);
		searchEmailTxt.clear();
		searchEmailTxt.sendKeys(email);
	}
	
	public void setFirstName(String fname)
	{
		waitHelper.waitForElement(searchFirstName, 30);
		searchFirstName.clear();
		searchFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		waitHelper.waitForElement(searchLastName, 30);
		searchLastName.clear();
		searchLastName.sendKeys(lname);
	}
	
	public void setMonth(String month,String day)
	{
		Select select = new Select(dobMonth);
		select.selectByValue(month);
		Select select1 = new Select(dobDay);
		select1.selectByVisibleText(day);
		
	}
	
	public void clickSearchButton()
	{
		searchBtn.click();
		waitHelper.waitForElement(searchLastName, 30);
	}
	
	public int getNoOfRows()
	{
		return(tableRows.size());
		
	}
	
	public int getNoOfColumns()
	{
		return(tableColumns.size());
	}
	
	public boolean searchCustomerByEmail(String email)
	{
		boolean flag = false;
		for(int i=1;i<=getNoOfRows();i++)
		{
			String emailID = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(emailID);
			if(emailID.equals(email))
			{
				flag=true;
			}
		}
		return flag;
	}
	
	
	public boolean searchCustomerByName(String firstname,String lastname)
	{
		boolean flag =false;
		for(int i=1;i<=getNoOfRows();i++)
		{
			String name = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[\"+i+\"]/td[3]")).getText();
			String[] names = name.split(" ");
			if(names[0].equals(firstname) && names[1].equals(lastname))
			{
				flag = true;
			}
		}
		
		return flag;
	}
}
