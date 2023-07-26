Feature: Account information of Cyclos Web Application 
	user Should be able to perform Banking Functionality
	
		
	  Background:
    Given User login into Cyclos
    Then User should click on banking menu
    
	@testcase1
	Scenario: Banking Functioality of Cyclos Application		
		Then check the memberAccount
		
	
	@testcase2
	Scenario: user check the current balance
		Then check member account balance
		
	@testcase3
	Scenario: user should check the payment history
		And click on notifications
		Then able to see payment history
		
	@testcase4
	Scenario: print and export payments 
		Then should click payment to users
		Then select one user from userlist and select a user
		And Enter amount
		Then click anyOption from Scheduling
		And click on Next button
		Then click on confirm
		Then click on print to download
	
	@testcase5
	Scenario: Searching the payments
		And click the showfilter button
		And select a user from userlist
		Then click on period menu and select any opton
		And select description and enter content
		Then click on from amout and enter value
		Then click on to amount and enter value
		And click on filter and select one option
		Then click on transaction number and enter value
		And click on direction and select one option
		Then click on orderby and select one option
		
	
	@testcase6
	Scenario: view payment details
		When click a user from Account summary
		Then payment details should be display
		
	@testcase7
	Scenario: payment details should be print
		When click any user from 	account summary
		Then print the transferDetails
		
		
		
				