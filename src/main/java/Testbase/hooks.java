package Testbase;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class hooks extends Base{
    @Before
    public static void setup(){


        {
            //  D:\project\testing\mercurytour_GP_0901\mercurytour\src\main\resources

//            System.setProperty("webdriver.chrome.driver", "/Users/singh/IdeaProjects/mercurytour/src/main/resources/chromedriver");
            System.setProperty("webdriver.chrome.driver", "/Users/phoenix/IdeaProjects/MercuryTour/src/main/resources/chromedriver");

            driver = new ChromeDriver();


            driver.manage().window().maximize();

            driver.get("https://jupiter.cloud.planittesting.com/#/");


            wait = new WebDriverWait(driver, 120);
        }






    }
    @After

    public static void closeBrowser(){

        driver.quit();
    }

}
