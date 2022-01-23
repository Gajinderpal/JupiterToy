package Testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Base {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public Base(WebDriver driver, WebDriverWait wait){
        Base.driver=driver;
        Base.wait=wait;
    }

    protected void WaitUntilElementVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void mediumWait() throws InterruptedException {
        Thread.sleep(3000);
    }

}
