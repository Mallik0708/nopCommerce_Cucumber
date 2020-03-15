package stepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.nopCommerce.PageObjects.AddCustomerPage;
import com.nopCommerce.PageObjects.LoginPage;
import com.nopCommerce.PageObjects.SearchCustomerPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class Steps extends BaseClass {

	//creating this methods for separating configurations, this method will execute first before the test case is started
	@Before
	public void setUp() throws IOException
	{
		//Reading Properties
		configProp = new Properties();
		FileInputStream configPropFile = new FileInputStream(System.getProperty("user.dir")+"//ConfigurationFiles//config.properties");
		configProp.load(configPropFile);
		 
		//Logs
		logger = logger.getLogger("nopCommerce"); //Added Logger
		PropertyConfigurator.configure(".//ConfigurationFiles//log4j.properties");
		
		String br = configProp.getProperty("browser");
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
		   	driver = new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefoxpath"));
		   	driver = new FirefoxDriver();
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", configProp.getProperty("iepath"));
		   	driver = new InternetExplorerDriver();
		}
		
	   	driver.manage().window().maximize();
	   	logger.info("*********Launching Browser***************");
	}
	
	@Given("User Launch Chrome Browser")
	public void user_Launch_Chrome_Browser() {
		
		
		lp = new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_URL(String url) {
	    logger.info("*********Opening URL***********");
		driver.get(url);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_Email_as_and_Password_as(String Email, String Password) {
		logger.info("*********Providing Login Details*************");
	    lp.setUsername(Email);
	    lp.setPassword(Password);
	}

	@When("Click on Logon")
	public void click_on_Logon() {
		logger.info("*********startedlogin**********");
		lp.clickLogon();
	}

	@Then("Page Title should be {string}")
	public void home_Page_Title_should_be(String expectedTitle) 
	{
	    if(driver.getPageSource().contains("Login was unsuccessful"))
	    {	
	    	Assert.assertTrue(false);
	    	logger.info("******Login Failed*********");
	    	driver.close();
	    }	
	    else
	    {
	    	logger.info("********Login Passed ***********");
	    	Assert.assertEquals(expectedTitle, driver.getTitle());
	    }
	}

	@Then("User clicks on logout link")
	public void user_clicks_on_logout_link() throws InterruptedException {
	    Thread.sleep(3000);
	    lp.clickLogout();
	    logger.info("****User is logged out**********");
	}

	

	@Then("Close Browser")
	public void close_Browser() throws InterruptedException {
	  Thread.sleep(3000);
	  logger.info("****closing the browser********");
	  driver.quit();
	}

// Customers Feature Step Definitions
	
	@Then("User can view Dashboard")
	public void user_can_view_Dashboard() throws InterruptedException {
		Thread.sleep(3000);
	   addCust = new AddCustomerPage(driver);
	   Assert.assertEquals("Dashboard / nopCommerce administration", driver.getTitle());
	}

	@When("User click on Customers Menu")
	public void user_click_on_Customers_Menu() throws InterruptedException {
	    Thread.sleep(3000);
		addCust.customersOption();
	}

	@When("User clicks on customers menu item")
	public void user_clicks_on_customers_menu_item() throws InterruptedException {
	    Thread.sleep(3000);
	    addCust.customerMenuItemOption();
	}

	@When("click on Add new button")
	public void click_on_Add_new_button() throws InterruptedException {
	   
	   addCust.addNewBtn();
	   Thread.sleep(3000);
	}

	@Then("User can view Add New Customers Page")
	public void user_can_view_Add_New_Customers_Page() {
	   
		Assert.assertEquals("Add a new customer / nopCommerce administration", driver.getTitle());
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
	    Thread.sleep(3000);
	    logger.info("******Adding New Customer********");
	    logger.info("*******Providing Customer Data*********");
	    String email = randomString()+"@gmail.com";
	    addCust.enterEmail(email);
	    addCust.enterPassword("test123");
	    addCust.enterFirstName("Pavan1");
	    addCust.enterLastName("Kumar1");
	    addCust.enterDOB("07/04/1995");
	    addCust.companyName("busyQA");
	    addCust.selectCustomerRoles("Vendors");
	    addCust.vendorManager("Vendor 2");
	    addCust.adminContent("This is just for testing...........");
	    
	    
	}

	@When("click on save button")
	public void click_on_save_button() throws InterruptedException {
	    logger.info("******Saving Customer Data********");
		addCust.clickSave();
	    Thread.sleep(3000);
	}

	@Then("user can view confirmation message {string}")
	public void user_can_view_confirmation_message(String message) {
	   
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully"));
	}


	//Searching a Customer by using Email ID
	@When("User Enters Customer Email")
	public void user_Enters_Customer_Email() {
		searchCust = new SearchCustomerPage(driver);
		logger.info("*********Searching a Customer by EmailID************");
		searchCust.setEmail("victoria_victoria@nopCommerce.com");
	}

	@When("User click on search button")
	public void user_click_on_search_button() throws InterruptedException {
	    searchCust.clickSearchButton();
	    Thread.sleep(3000);
	}

	@Then("user should found email in the Search table")
	public void user_should_found_in_the_Search_table() {
	   boolean status = searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
	   Assert.assertEquals(true, status);
	}

	//Steps for searching a customer by firstname and lastname
	
	@When("User Enters Customer FirstName and LastName")
	public void user_Enters_Customer_FirstName_and_LastName() {
		
		searchCust = new SearchCustomerPage(driver);
		logger.info("*********Searching a Customer by Firstname && Lastname************");
		searchCust.setFirstName("Victoria");
		searchCust.setLastName("Terces");
	}

	

	@Then("user should found name in the Search table")
	public void user_should_found_name_in_the_Search_table() {
	   boolean status = searchCust.searchCustomerByName("Victoria","Terces");
	   Assert.assertEquals(true, status);
	}

	
}
