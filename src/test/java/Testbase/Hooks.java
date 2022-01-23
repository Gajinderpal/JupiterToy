package Testbase;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    public static WebDriver driver;

    @Before
    public static void setup(){
        {
            System.setProperty("webdriver.chrome.driver", "/Users/phoenix/IdeaProjects/JupiterToys/src/test/resources/chromedriver");
            driver = new ChromeDriver(); //chrome driver initialization
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.get("https://jupiter.cloud.planittesting.com/#/");
        }
    }
    @After

    public static void closeBrowser(){
        driver.quit();
    }

}
