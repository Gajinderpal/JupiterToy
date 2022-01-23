package pages;

import Testbase.Base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends Base {

    public CartPage(WebDriver driver, WebDriverWait wait){
        super(driver,wait);
        PageFactory.initElements(driver,this);
    }

    static String cartItemTotal = "body > div.container-fluid > div > p > span.cart-count.ng-binding"; //web element of cart page

    public void verifyItemsInCart(Integer num) throws InterruptedException {
        mediumWait();
        Assert.assertEquals(num.toString(), driver.findElement(By.cssSelector(cartItemTotal)).getText()); //asserts if the items present in the cart or not
    }

}