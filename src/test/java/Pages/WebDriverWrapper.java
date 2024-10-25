package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverWrapper {
    WebDriver driver;

     By emailInputLocator = By.name("email");
     By passwordInputLocator = By.name("password");
     By loginButtonLocator = By.xpath("//input[@value='Login']");
     By logoutLinkLocator = By.linkText("Logout");

    public WebDriverWrapper(WebDriver driver) {
        this.driver = driver;
    }

    public void Entercredentials(String email, String password){
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);
    }
    
}
