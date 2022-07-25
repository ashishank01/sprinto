# sprinto
Sprinto repo for automation cleartrip booking 

# How to run the repo
1. Download/ Clone the repo on your local system
2. Open the project sprinto with any IDE (eclipse)
3. Make sure all maven dependency already resolved
4. Go to Runner class and run it.
5. It will start the execution of all steps defined in feature file

## Feature.feature
```
Feature: Cheapest flight booking after a week 

Scenario Outline: 
	User is able to book week after cheapest flight from "<fromLocation>" to "<toLocation>" 
	Given user open cleartrip homepage 
	And user goes to flight menu 
	When user select OneWay 
	And user select from location "<fromLocation>" as "<fromLocationCode>" 
	And user select to location "<toLocation>" as "<toLocationCode>" 
	And user enter one week later date for travel 
	And user click on Search Flights button 
	Then all available flight should be displayed 
	When user click on cheapest flight Book button 
	Then booking detail page should be displayed 
	Examples: 
		|fromLocation | toLocation|fromLocationCode | toLocationCode|
		|Bangalore |Delhi |BLR - Bangalore, IN|DEL - New Delhi, IN|
```
