package pages;

import Testbase.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Base {

    public HomePage(WebDriver driver, WebDriverWait wait){
        super(driver,wait);
        PageFactory.initElements(
                driver,this);
    }
    @FindBy(css = "#nav-contact a")        //web elements of the Homepage
    private WebElement contactPageButton;

    @FindBy(css = "#nav-shop a")
    private WebElement shopPageButton;

    @FindBy(css = "#nav-cart a")
    private WebElement cartPageButton;

    public void clickOn_ContactPage()     //function to click on the contact page button
    {
        WaitUntilElementVisible(contactPageButton);
        contactPageButton.isEnabled();
        contactPageButton.click();
    }

    public void clickOn_ShopPage(){       //function to click on the shop page button
        WaitUntilElementVisible(shopPageButton);
        shopPageButton.isEnabled();
        shopPageButton.click();
    }

    public void clickOn_CartPage(){
        WaitUntilElementVisible(cartPageButton);
        cartPageButton.isEnabled();
        cartPageButton.click();
    }
}
