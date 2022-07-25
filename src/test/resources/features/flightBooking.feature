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