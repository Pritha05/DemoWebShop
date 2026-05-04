package pageObjects;

import java.time.Duration;
import org.junit.Assert; 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepDefinitions.Hooks;

public class AddToCartPage {

    // public WebDriver driver;
    WebDriver driver = Hooks.driver;

    public final String Catagory = "//div[@class='header-menu']/following::a[contains(text(),'%s')]";
    By pageTitle = By.xpath("//div[@class='page-title']/h1");
    By selectProduct = By.xpath("//div[@class='item-box'][1]//input[@value='Add to cart']");
    By shoppingCart = By.xpath("//span[contains(text(),'Shopping cart')]");
    By firstProduct = By.xpath("(//h2[@class='product-title']/a)[1]");
    By cartProduct = By.xpath("//td[@class='product']/a");

    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void select_catagory(String cat) {
        driver.findElement(By.xpath(String.format(Catagory, cat))).click();

    }

    public void pageTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(driver -> driver.findElement(pageTitle));
    }

    public String select_Product() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(driver -> driver.findElement(selectProduct));

        String actualProductName = driver.findElement(firstProduct).getText();
        System.out.println("Selected Product: " + actualProductName);
        driver.findElement(selectProduct).click();
        return actualProductName;

    }

    public void shopping_Cart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(driver -> driver.findElement(shoppingCart));
        driver.findElement(shoppingCart).click();
    }

    public String verify_shoppingCart() {

        String expectedProductName = driver.findElement(cartProduct).getText();
        System.out.println("Cart Product: " + expectedProductName);
        return expectedProductName;
        
        

    }
    public void shoppingCart_asssertion(String actualProductName, String expectedProductName){
        Assert.assertEquals(actualProductName, expectedProductName);
    }

}
