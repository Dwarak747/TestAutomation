Feature: Account Page Feature


Background: 
Given user has already logged in to the application
|username|password|
|aldwarak5@gmail.com|Friday25|


Scenario: Accounts page title
Given user is on Accounts page
When user gets the title of the page
Then page title should be "My account - My Store"

@SmokeTest
Scenario: Accounts sections count
Given user is on Accounts page
Then user gets accounts section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|  
|Home|
And accounts section count should be 6
