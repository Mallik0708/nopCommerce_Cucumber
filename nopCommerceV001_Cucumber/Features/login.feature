Feature: Login into Application 

@sanity
Scenario: Successful Login with Valid Credentials
	Given User Launch Chrome Browser
	When User opens URL "https://admin-demo.nopcommerce.com/"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Logon
	Then Page Title should be "Dashboard / nopCommerce administration"
	Then User clicks on logout link 
	Then Page Title should be "Your store. Login"
	And Close Browser
	
@regression
Scenario Outline: Successful Login with Valid Credentials
	Given User Launch Chrome Browser
	When User opens URL "https://admin-demo.nopcommerce.com/"
	And User enters Email as "<email>" and Password as "<password>"
	And Click on Logon
	Then Page Title should be "Dashboard / nopCommerce administration"
	Then User clicks on logout link 
	Then Page Title should be "Your store. Login"
	And Close Browser
	
	Examples: 
		| email | password |
		| admin@yourstore.com | admin |
		| admin1@yourstore.com | admin123 |
		
	
		