package stepDefinition;


import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


/**
 * Created by Ashish J on 25/07/2022.
 */

public class Hook extends BaseUtil{
	private BaseUtil base;
	public Hook(BaseUtil base) {
		this.base = base;
	}

    @Before
    public void InitializeTest(Scenario scenario) {
        // WebDriverManager.chromedriver().setup();
    	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        // chromeOptions.addArguments("--headless");
        base.driver = new ChromeDriver(chromeOptions);
		base.driver.manage().window().maximize();
		// base.driver.manage().deleteAllCookies();
		base.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }


    @After
    public void TearDownTest(Scenario scenario) {
        if (scenario.isFailed()) {
            //Take screenshot logic goes here
            System.out.println(scenario.getName());
        }
        base.driver.quit();
    }


}