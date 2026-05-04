package stepDefinitions;

import org.openqa.selenium.WebDriver;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.AddToCartPage;
public class AddToCartstepDefinitons {

    WebDriver driver = Hooks.driver;
    AddToCartPage atc = new AddToCartPage(driver);

    String selectedProductName;   // ✅ store globally

    @Then("User choose {string} Catagory")
    public void user_choose_Catagory(String catagory){
        atc.select_catagory(catagory);
        atc.pageTitle();
    }

    @Then("User select one product from Catagory")
    public void selectproducts(){
        selectedProductName = atc.select_Product();   // ✅ store here
    }

    @And("User Go to Shopping Cart")
    public void shoppingCart(){
        atc.shopping_Cart();
    }

    @And("Verify the shopping Cart")
    public void verify_ShoppingCart(){
        String cartProductName = atc.verify_shoppingCart();  // ✅ get cart product
        atc.shoppingCart_asssertion(selectedProductName, cartProductName);
    }
}

    


