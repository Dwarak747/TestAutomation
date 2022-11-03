Feature: Login page feature

Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "Login - My Store"

Scenario: Forgot password link
Given user is on login page
Then forgot your password link should be displayed

Scenario: Login with the correct credentials
Given user is on login page
When user enters username "aldwarak5@gmail.com"
And user enter password "Friday25"
And user clicks the login button
Then user gets the title of the page
And page title should be "My account - My Store"
