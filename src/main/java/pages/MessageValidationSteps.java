package pages;

import Testbase.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageValidationSteps extends Base {
    @Given("User clicks on contact us on homepage")
    public void user_clicks_on_contact_us_on_homepage() throws InterruptedException, NullPointerException {
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement waitUntilPageLoad = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#nav-contact a")));
        driver.findElement(By.cssSelector("#nav-contact a")).click();
        Thread.sleep(3000);
    }

    @And("^Customer submits \"(.*)\" \"(.*)\" \"(.*)\" and Successful acknowledgement messsage is displayed$")
    public void customer_submits_all_mandatory_information(String forename, String email, String message) throws InterruptedException {
            driver.findElement(By.id("forename")).sendKeys(forename);
            driver.findElement(By.id("email")).sendKeys(email);
            driver.findElement(By.id("message")).sendKeys(message);
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/div[2]/div/form/div/a")).click();
            String ack = wait.until(d->d.findElement(By.className("alert-success"))).getText();
            assertEquals("Thanks "+forename +", we appreciate your feedback.",ack);
        }
}