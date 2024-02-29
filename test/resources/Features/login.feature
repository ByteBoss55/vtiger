Feature: feature description
Background:
Given user should on be login page

@TC01	
Scenario: valid_login_TC01
When user enters valid credentials 
And click on login the button
Then user should be on home page
And user can see logout option
	
@smoke	
Scenario: valid_login_TC02
When user enters valid credentials user id  "<userid>" and password  "<password>" 
|TCID|userid| password|
|TC01|admin1|pass1|
|TC02|admin2|pass2|
And click on login the button
Then user should be on home page
And user can see logout option

@Hello
Scenario Outline: valid_login2
When user enters valid credentials user id as "<userid>" and password as "<password>"
And click on the login button
Examples:
|TCID|userid| password|
|TC01|admin1|pass1|
|TC02|admin2|pass2|
@TC06
Scenario: valid_login_with_theme_TC06
When user enters valid credentials 
And click on login the button
Then user should be on home page
And user can see logout option