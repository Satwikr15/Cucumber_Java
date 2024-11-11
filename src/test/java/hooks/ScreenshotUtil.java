package hooks;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {
    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = "target/ExtentReports/" + screenshotName + ".png";
        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }
}


//public static String saveScreenshot(WebDriver driver, String filename) {
//    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
//    File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
//    File destFile = new File("Screenshots/" + filename);
//    try {
//        FileUtils.copyFile(sourceFile, destFile);
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//    return destFile.getAbsolutePath();
//}
