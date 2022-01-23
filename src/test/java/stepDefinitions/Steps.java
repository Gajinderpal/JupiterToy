package stepDefinitions;

import Testbase.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CartPage;
import pages.ContactPage;
import pages.HomePage;
import pages.ProductListingPage;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Steps {
    private WebDriver driver =Hooks.driver;
    private WebDriverWait wait = new WebDriverWait(driver,60);
    HomePage home;
    ContactPage contact;
    ProductListingPage product;
    CartPage cart;
    @Given("user clicks on shop page on homepage")
    public void clickHomepage() throws InterruptedException {
        home = new HomePage(driver,wait);
        home.clickOn_ShopPage();
    }

    @And("user click on cart menu")
    public void clickCart() throws InterruptedException {
        home = new HomePage(driver,wait);
        home.clickOn_CartPage();
    }

    @And("^verify total items in cart$")
    public void verifyCart() throws InterruptedException {
        cart = new CartPage(driver,wait);
        cart.verifyItemsInCart(ProductListingPage.totalCount);
    }

    @And("^user add following toys in the cart:$")
    public void addToysToCart(List<Map<String, String>> inputs) throws InterruptedException {
        for(Map<String, String> input : inputs){
            String toyName= Optional.ofNullable(input.get("ToyName")).orElseThrow(()-> new IllegalArgumentException("Missing ToyName"));
            Integer quantity= Optional.of(Integer.parseInt(input.get("Quantity").trim())).orElseThrow(()-> new IllegalArgumentException("Missing Quantity"));
            product = new ProductListingPage(driver,wait);
            product.addToyToCartBuyButton(toyName,quantity);
        }
    }

    @Given("^User clicks on contact us on homepage$")
    public void userClicksOnContactUsOnHomepage() throws InterruptedException, NullPointerException {
        home = new HomePage(driver,wait);
        home.clickOn_ContactPage();
    }

    @And("^Customer submits \"(.*)\" \"(.*)\" \"(.*)\" and Successful acknowledgement message is displayed$")
    public void customerSubmitsMandatoryMnformation(String forename, String email, String message) throws InterruptedException {
        contact = new ContactPage(driver,wait);
        contact.fillMandatoryInformation(forename,email,message);
        contact.clickOnSubmitButton();
        contact.verifySuccessfulMessage();
    }
}
