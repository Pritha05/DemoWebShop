package pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    By email = By.xpath("//input[@id='Email']");
    By Password = By.xpath("//input[@id='Password']");

    By btnLogin = By.xpath("//input[@value='Log in']");

    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement btnLogout;

    public void setUsername(String username) {
        
        driver.findElement(email).sendKeys(username);
    }

    public void setPassword(String password) {
        
        driver.findElement(Password).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(btnLogin).click();
    }

    public boolean isLogoutVisible() {
        return btnLogout.isDisplayed();
    }

    public void clickLogout() {
        btnLogout.click();
    }
}