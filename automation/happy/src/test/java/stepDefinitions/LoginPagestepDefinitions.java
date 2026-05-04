package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import drivers.Driver;
import pageObjects.LoginPage;

public class LoginPagestepDefinitions {

    
    WebDriver driver = Hooks.driver;   // ✅ IMPORTANT
    public LoginPage LP;
    
    By HomePageLogin = By.xpath("//a[contains(text(),'Log in')]");

    @Given("User Launch Chrome browser")
    public void Lauch_Chrome_browser() {

        Driver.initDriver();
        driver = Driver.driver;

    }

    @When("User opens URL {string}")
    public void Opens_Url(String url) {

        driver.get(url);

       
         LP = new LoginPage(driver);
    }

    @And("User enters Email as {string} and Password as {string}")
    public void Use_Credentials(String email, String password) {


        driver.findElement(HomePageLogin).click();
        
        LP.setUsername(email);
        LP.setPassword(password);
    }

    @And("User Clicks on Login")
    public void User_clicks_on_Login() {
        LP.clickLogin();
    }

    @Then("Page Title should be {string}")
    public void Page_Title(String title) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));


        wait.until(driver -> driver.getTitle().contains("Web Shop"));
        

        String actualTitle = driver.getTitle();
        System.out.println("Actual Title: " + actualTitle);

        // if (actualTitle.contains("Login")) {
        //     Assert.fail("Login failed or site blocked automation");
        // }

        Assert.assertEquals(title, actualTitle);
    }

    @When("User clicks on Log out link")
    public void User_clicks_on_Logout() {
        LP.clickLogout();
    }

    @And("close browser")
    public void Close_browser() {
        Driver.quitDriver();
    }
}