package pages;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Flights']/parent::a")
	private WebElement menuFlight;
	
	@FindBy(xpath="//div[contains(@class, 'brLoginNew')]")
	private List<WebElement> listLoginPopUp;
	
	@FindBy(xpath="//div[contains(@class, 'brLoginNew')]//div[contains(@class, 'plNew')]")
	private WebElement brnCloseLoginPopUp;
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
		
	public void clickFlightMenu() {
		menuFlight.click();
	}

	public void clickCloseLoginPopUp() {
		brnCloseLoginPopUp.click();
	}
	
	public void closeLoginPopUp() {
		if(listLoginPopUp.size()>=1) {
			clickCloseLoginPopUp();
		}
	}
	
	

}
