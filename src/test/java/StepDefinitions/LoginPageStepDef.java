package StepDefinitions;

import Pages.LoginPage;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.observer.entity.AttributeEntity;
import hooks.ExtentManager;
import hooks.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class LoginPageStepDef {

    WebDriver driver;
    LoginPage loginPage;

    @Before                  //runs before every scenario
    public void setup(){
        driver=new EdgeDriver();
    }  //add class for browser name from properties file

    @After                  //runs after every scenario
    public void tearDown(){
        if(driver!=null) //**
            driver.quit();

    }

    //BACKGROUND
    @Given("I am on the Opencart login page")
    public void i_am_on_the_opencart_login_page() throws InterruptedException { //use try ...catch block insteaded of throws
        loginPage=new LoginPage(driver);
        loginPage.getUrl();

//        Thread.sleep(2000);
    }

    //successful credentials
    @Given("I have entered a valid {string} and {string}")
    public void i_have_entered_a_valid_username_and_password(String valid_username,String valid_password) {
//        loginPage.enterEmail(valid_username);    //**call single method and split in back end file
//        loginPage.enterPassword(valid_password);
        loginPage.Entercredentials(valid_username,valid_password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")  //i should be logged in successfully (in name)
    public void i_should_be_logged_in_successfully() {
        Assert.assertTrue(loginPage.isLoggedInSuccessfully(), "User was not logged in successfully.");


    }
    //with invalid credentials
    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String username, String password) {
//        loginPage.enterEmail(username); //single method and split in backend code [done]
//        loginPage.enterPassword(password);
        loginPage.Entercredentials(username,password); //[done]
    }

    @Then("I should see an error message indicating {string}")  //validate should be there
    public void i_should_see_an_error_message_indicating(String string) {
        //Assert.assertEquals(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(),true); [hidden is done]
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message was not displayed.");
    }

    //forgot password link
    @When("I click on the {string} link")
    public void i_click_on_the_link(String string) {
        loginPage.clickForgottenPasswordLink();
    }

    @Then("I should be redirected to the password reset page")
    public void i_should_be_redirected_to_the_password_reset_page() {
        Assert.assertTrue(loginPage.getforgotPwdPageurl(), "User is not on the forgotten password page.");
//        Assert.assertTrue(loginPage.getforgotPwdPageurl().contains("account/forgotten"));
    } // logic should be in page file[done]
}