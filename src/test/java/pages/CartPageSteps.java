package pages;

import Testbase.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPageSteps extends Base {
    @Given("user clicks on shop page on homepage")
    public void click_homepage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement waitUntilPageLoad = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#nav-shop a")));
        driver.findElement(By.cssSelector("#nav-shop a")).click();
        Thread.sleep(3000);
    }

    @And("user adds Funny Cow 2 times")
    public void adding_fuuny_cows() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[6]/div/p/a")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[6]/div/p/a")).click();
    }

    @And("user adds Fluffy bunny 1 time")
    public void adding_fluffy_bunny() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[4]/div/p/a")).click();
    }

    @And("user click on cart menu")
    public void click_cart() throws InterruptedException {
        driver.findElement(By.cssSelector("#nav-cart a")).click();
        Thread.sleep(3000);
    }

    @And("^verify total (.*) items are in cart$")
    public void verify_cart(Integer num) throws InterruptedException {
        Assert.assertEquals(num.toString(),driver.findElement(By.cssSelector("body > div.container-fluid > div > p > span.cart-count.ng-binding")).getText());
    }

}
