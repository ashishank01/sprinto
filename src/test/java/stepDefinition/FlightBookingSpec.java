package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import Base.BaseUtil;
import cucumber.api.java.en.*;
import pages.FlightBookingPage;
import pages.HomePage;


public class FlightBookingSpec extends BaseUtil {

	FlightBookingPage flightBookingPage;
	HomePage homepage;
	private BaseUtil base;
	public FlightBookingSpec(BaseUtil base) {
			this.base = base;
		}

	@When("^user select OneWay$")
	public void user_select_OneWay()  {
		flightBookingPage = new FlightBookingPage(base.driver);
		flightBookingPage.selectOneWay();
	}

	@When("^user select from location \"([^\"]*)\" as \"([^\"]*)\"$")
	public void user_select_from_location_as(String fromLocation, String fromLocationCode) throws InterruptedException  {
		flightBookingPage = new FlightBookingPage(base.driver);
		flightBookingPage.enterFromLocation(fromLocation);
		flightBookingPage.selectTopMatchedFromLocation();
		Assert.assertEquals("Selected from location code is not matching. Please check the From Location.", fromLocationCode, flightBookingPage.getSelectedFromLocation());
	}

	@When("^user select to location \"([^\"]*)\" as \"([^\"]*)\"$")
	public void user_select_to_location_as(String toLocation, String toLocationCode) throws InterruptedException  {
		flightBookingPage = new FlightBookingPage(base.driver);
		flightBookingPage.enterToLocation(toLocation);
	    flightBookingPage.selectTopMatchedToLocation();
		Assert.assertEquals("Selected to location code is not matching. Please check the To Location.", toLocationCode, flightBookingPage.getSelectedToLocation());
	}
	
	@When("^user enter one week later date for travel$")
	public void user_enter_one_week_later_date_for_travel() throws InterruptedException {
		flightBookingPage = new FlightBookingPage(base.driver);
		flightBookingPage.clickDate();
		flightBookingPage.selectDateAfterWeek();
	}

	@When("^user click on Search Flights button$")
	public void user_click_on_Search_Flights_button()  {
		flightBookingPage = new FlightBookingPage(base.driver);
	    flightBookingPage.clickSearchFlight();
	}

	@Then("^all available flight should be displayed$")
	public void all_available_flight_should_be_displayed() {
		flightBookingPage = new FlightBookingPage(base.driver);
	    Assert.assertTrue("Flight Search Result is not available to Book Flight", flightBookingPage.getNumberOfFlightAvailable()>0);
	}

	@When("^user click on cheapest flight Book button$")
	public void user_click_on_cheapest_flight_Book_button()  {
		flightBookingPage = new FlightBookingPage(base.driver);
	    flightBookingPage.clickBookFlight();
	    Actions action = new Actions(base.driver);
	    action.sendKeys(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
	}

	@Then("^booking detail page should be displayed$")
	public void booking_detail_page_should_be_displayed()  {
		homepage = new HomePage(base.driver);
	    homepage.closeLoginPopUp();
	    flightBookingPage = new FlightBookingPage(base.driver);
	    Assert.assertTrue("Review itinerary page is not displaying", base.driver.getCurrentUrl().startsWith("https://www.cleartrip.com/flights/itinerary/"));
	}	

}
