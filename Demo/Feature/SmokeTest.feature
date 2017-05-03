Feature: Smoke Test


Scenario: Successful Login with Valid Credentials
	Given User is on Home Page
	When User navigates to LogIn Page
	And User enters valid UserName and Password
	Then Login is successful
	
Scenario: Successful Logout 
	Given User is logged in
	When User clicks Sign Out
	Then User is signed out successfully

Scenario: Login with Invalid Credentials
	Given User is on Home Page
	When User navigates to LogIn Page
	And User enters invalid UserName and Password
	Then Error message is displayed
	
Scenario: Add item to cart
	Given User is on Home Page
	When User navigates to product page
	And User adds product to cart
	Then Product is displayed in cart
	
Scenario: Complete checkout as guest with valid information
	Given User is on Home Page
	When User navigates to product page
	And User adds product to cart
	When User completes checkout with valid information
	Then Order is placed successfully
	
	
	