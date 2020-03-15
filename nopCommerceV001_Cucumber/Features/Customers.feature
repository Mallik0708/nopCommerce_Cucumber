Feature: Customers 

 Background: Below are common steps for each scenario
 	Given User Launch Chrome Browser
	When User opens URL "https://admin-demo.nopcommerce.com/"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Logon
	Then User can view Dashboard
	
@sanity
Scenario: Add a New Customer
	When User click on Customers Menu
	And User clicks on customers menu item
	And click on Add new button
	Then User can view Add New Customers Page
	When User enter customer info 		
	And click on save button
	Then user can view confirmation message "The new customer has been added successfully"
	And Close Browser
	
@regression	
Scenario: Search Customer by EmailID
	When User click on Customers Menu
	And User clicks on customers menu item
	And User Enters Customer Email
	When User click on search button
	Then user should found email in the Search table
	And Close Browser
	
@regression
Scenario: Search Customer by FirstName and LastName
	When User click on Customers Menu
	And User clicks on customers menu item
	And User Enters Customer FirstName and LastName
	When User click on search button
	Then user should found name in the Search table
	And Close Browser