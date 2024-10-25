//package hooks;//package hooks;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.*;
//
//import com.aventstack.extentreports.ExtentTest;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//import org.openqa.selenium.WebDriver;
//
//import java.io.IOException;
//import java.sql.DriverManager;
//
//public class Hooks {
//
//    private WebDriver driver;
//    private ExtentReports extent;
//    private ExtentTest test;
//
//    @Before
//    public void setUp() {
//        // Initialize WebDriver
//        driver = (WebDriver) DriverManager.getDrivers();
//
//        // Initialize ExtentReports
//        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReport.html");
//        extent = new ExtentReports();
//        extent.attachReporter(htmlReporter);
//    }
//
//    @After
//    public void tearDown(Scenario scenario) throws IOException {
//        if (scenario.isFailed()) {
//            ScreenshotUtil.takeScreenshot(driver, scenario.getName());
//            test.fail("Scenario failed");
//        }
//        else {
//            ScreenshotUtil.takeScreenshot(driver, scenario.getName()); // Take screenshot even if successful
//            test.pass("Scenario passed");
//        }
//        // Quit the driver after each scenario
//        driver.quit();
//    }
//}
//
