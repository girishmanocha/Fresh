Feature: Login Functionality 



@Regrassion 
Scenario: Verify login feature With Valid credential 

	When User Enter valid Userid and Password 
	And User click on Submit button 
	Then Validate user Navigate to Home Page 
	
	
@Regrassion 
Scenario Outline: Verify login feature With InValid credential 

	When User Enter Invalid "<UserName>" and "<PassWord>" 
	And User click on Submit button 
	Then Validate user Should Get Error massege 
	
	
	Examples: 
		|UserName			|PassWord			|
		|Invalid1@gmail.com	|akeidk				|	
		|Invalid2@gmail.com	|AAAAAAAA			|
		|Invalid3@gmail.com	|aaaaaaaaaaa		|
		|Invalid4@gmail.com	|11111111111111111	|
		
		