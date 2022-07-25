package pages;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightBookingPage {
	WebDriver driver;
	public FlightBookingPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p[text()='One way']/parent::div")
	private WebElement radioOneWay;
	
	@FindBy(xpath="//div/h4[text()='From']/following-sibling::div/div/div/input")
	private WebElement txtFrom;
	
	@FindBy(xpath="//div/h4[text()='From']/following-sibling::div/div/div/ul/div[text()='Suggestions']/following-sibling::li")
	private WebElement fromTopLocationSuggestions;
	
	@FindBy(xpath="//div/h4[text()='To']/following-sibling::div/div/div/input")
	private WebElement txtTo;
	
	@FindBy(xpath="//div/h4[text()='To']/following-sibling::div/div/div/ul/div[text()='Suggestions']/following-sibling::li")
	private WebElement toTopLocationSuggestions;
	
	@FindBy(xpath="//div[contains(@class,'homeCalender')]/button")
	private WebElement btnDate;
	
	@FindBy(xpath="//div[contains(@class,'DayPicker-Day')][@aria-disabled='false']")
	private List<WebElement> listDate;
	
	@FindBy(xpath="//div/button[text()='Search flights']")
	private WebElement btnSearchFlight;
	
	@FindBy(xpath="//div[@data-testid='airlineBlock']/div[4]/div[2]/button")
	private List<WebElement> btnBookFlight;
	
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public void selectOneWay() {
		radioOneWay.click();
	}
	
	public void enterFromLocation(String keyword) {
		txtFrom.sendKeys(keyword);
	}
	
	public void selectTopMatchedFromLocation() throws InterruptedException {
		Thread.sleep(3000);
		fromTopLocationSuggestions.click();
	}
	
	public String getSelectedFromLocation() throws InterruptedException {
		return txtFrom.getAttribute("value");
	}
	
	public void enterToLocation(String keyword) {
		txtTo.sendKeys(keyword);
	}

	public void selectTopMatchedToLocation() throws InterruptedException {
		Thread.sleep(3000);
		toTopLocationSuggestions.click();
	}
	
	public String getSelectedToLocation() throws InterruptedException {
		return txtTo.getAttribute("value");
	}
	
	public void clickDate() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", btnDate);
		btnDate.click();
	}
	
	public void selectDateAfterWeek() throws InterruptedException {
		Date date= new Date();
		long ldate = date.getTime() + 8*24*60*60*1000;
		Date weekafterdate = new Date(ldate);
		SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd yyyy");
		sdf.format(weekafterdate);
		System.out.println("00000000000000000000000000===>" + sdf.format(weekafterdate));
		for(WebElement ele: listDate) {
			//Thread.sleep(3000);
			System.out.println("#########################===>" + ele.getAttribute("aria-label"));
			if(ele.getAttribute("aria-label").equals(sdf.format(weekafterdate)))
			{
				ele.click();
				break;
			}
		}
	}
	
	public void clickSearchFlight() {
		btnSearchFlight.click();
	}
	
	public void clickBookFlight() {
		btnBookFlight.get(0).click();
	}
	
	public int getNumberOfFlightAvailable() {
		return btnBookFlight.size();
	}
	
	
	

}
