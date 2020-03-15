package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.nopCommerce.PageObjects.AddCustomerPage;
import com.nopCommerce.PageObjects.LoginPage;
import com.nopCommerce.PageObjects.SearchCustomerPage;

import net.bytebuddy.utility.RandomString;

public class BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage addCust;
	public SearchCustomerPage searchCust;
	public static Logger logger;
	public static Properties configProp;
	//Created for generating random string for unique email
	public static String randomString()
	{
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return generatedString1;
	}
	
}
