package rev.project.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import rev.project.driver.BrowserType;
import rev.project.driver.DriverManager;

public class Hooks {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @Before
    @Parameters("browser")  // Use TestNG @Parameters to get browser value from XML
    public void setup(String browser) {
        // Map the string browser value to BrowserType enum
        BrowserType browserType = BrowserType.valueOf(browser.toUpperCase());
        // Get the WebDriver instance based on browser type
        driver = DriverManager.getDriver(browserType);
    }

    @After
    public void tearDown(Scenario scenario) {
        // You can access scenario details here for logging purposes
        DriverManager.quitDriver();
    }
}
