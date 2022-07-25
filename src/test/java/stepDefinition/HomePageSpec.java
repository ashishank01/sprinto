package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Base.BaseUtil;
import cucumber.api.java.en.*;
import pages.HomePage;


public class HomePageSpec extends BaseUtil {
	WebDriver driver;
	HomePage homepage;
	private BaseUtil base;
	public HomePageSpec(BaseUtil base) {
			this.base = base;
		}
	
	@Given("^user open cleartrip homepage$")
	public void user_open_cleartrip_homepage() {
	    base.driver.get("https://www.cleartrip.com/");
	    homepage = new HomePage(base.driver);
	    homepage.closeLoginPopUp();
	    Assert.assertEquals("ClearTrip homepage is not open successfully. Please check the base cleartrip website url", "Cleartrip: #1 Site for Booking Flights Tickets & Hotels Online - Get Best Travel Deals", homepage.getPageTitle());
	}
	
	@Given("^user goes to flight menu$")
	public void user_goes_to_flight_menu() {
		homepage = new HomePage(base.driver);
		homepage.clickFlightMenu();
	    homepage.closeLoginPopUp();
		Assert.assertEquals("Flight menu is not redirecting to flight page. Please check Flight menu", "https://www.cleartrip.com/flights", homepage.getCurrentUrl());
	}

	

}
