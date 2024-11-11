package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import hooks.ExtentManager;
import hooks.ScreenshotUtil; // Ensure ScreenshotUtil is imported

public class Hooks {
    WebDriver driver;

    @Before
    public void setup(Scenario scenario) {
        driver = new EdgeDriver();
        ExtentManager.createTest(scenario.getName(), scenario.getId()); // Create a test in ExtentManager with scenario details
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Capture screenshot with specified name
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "Failed_" + scenario.getName());
            ExtentManager.getTest().fail("Test failed").addScreenCaptureFromPath(screenshotPath);
        } else {
            ExtentManager.getTest().pass("Test passed");
        }

        if (driver != null) {
            driver.quit();
        }

        ExtentManager.flush(); // Write to report
    }
}
