package Testbase;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class hooks extends Base{
    @Before
    public static void setup(){


        {
            System.setProperty("webdriver.chrome.driver", "/Users/phoenix/IdeaProjects/JupiterToys/src/test/resources/chromedriver");

            driver = new ChromeDriver(); //chrome driver initialiastion


            driver.manage().window().maximize();

            driver.get("https://jupiter.cloud.planittesting.com/#/");


            wait = new WebDriverWait(driver, 120); //wait intialised
        }






    }
    @After

    public static void closeBrowser(){

        driver.quit();
    }

}
