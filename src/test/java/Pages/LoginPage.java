package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;
    ConfigManager config;
    By emailinputlocator=By.name("email"); // for text box txt  or for button btn or dropdown (camelcase)
    By passwordinputlocator=By.name("password");
    By loginButtonlocator=By.xpath("//input[@value=\"Login\"]");
    By forgottenPasswordlinklocator=By.linkText("Forgotten Password");  //no need to define here, define in method from feature file
    By logoutLinkLocator=By.linkText("Logout");

    By errorAlertLocator = By.cssSelector(".alert-danger");
    public LoginPage(WebDriver driver) {
        this.driver=driver;
        this.config = new ConfigManager();
    }

    public void getUrl(){

        String baseUrl = config.getProperty("baseUrl");  // Get base URL from properties file [done]
        driver.get(baseUrl);
    }

//    public void enterEmail(String email){
//        WebElement emailInput = driver.findElement(emailinputlocator);
//        emailInput.sendKeys(email);
//    }
//
//    public void enterPassword(String password){
//        WebElement passwordInput = driver.findElement(passwordinputlocator);
//        passwordInput.sendKeys(password);
//    }

    public void Entercredentials(String email, String password){
        WebElement emailInput = driver.findElement(emailinputlocator);
        emailInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(passwordinputlocator);
        passwordInput.sendKeys(password);
    }



    public void clickLoginButton(){
        WebElement loginButton=driver.findElement(loginButtonlocator);
        loginButton.click();
    }

    public boolean isLoggedInSuccessfully() {
        return driver.findElement(logoutLinkLocator).isDisplayed();
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorAlertLocator).isDisplayed();
    }


    public void clickForgottenPasswordLink(){
        WebElement forgottenPasswordLink=driver.findElement(forgottenPasswordlinklocator);
        forgottenPasswordLink.click();
    }

    public boolean checkForgotPwdlink(){
        return driver.findElement(forgottenPasswordlinklocator).isDisplayed();
    }

    public boolean checkLogoutLink(){
        return driver.findElement(logoutLinkLocator).isDisplayed();

    }

//    public void login(String email,String password){
//        enterEmail(email);
//        enterPassword(password);
//        clickLoginButton();
//    }

    public Boolean getforgotPwdPageurl(){
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.contains("account/forgotten");
    }
}
