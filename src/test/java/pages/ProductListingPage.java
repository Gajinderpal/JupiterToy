package pages;

import Testbase.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductListingPage extends Base {

    public ProductListingPage(WebDriver driver, WebDriverWait wait){
        super(driver,wait);
        PageFactory.initElements(driver,this);
    }
    public static int totalCount = 0;

    @FindBy(xpath = "//li[@id='product-1']//div//p//a") //web elements of ProductListingPage
    private static WebElement teddyBearBuyButton;
    @FindBy(xpath = "//li[@id='product-2']//div//p//a")
    private static WebElement stuffedFrogBuyButton;
    @FindBy(xpath = "//li[@id='product-3']//div//p//a")
    private static WebElement handmadeDollBuyButton;
    @FindBy(xpath = "//li[@id='product-4']//div//p//a")
    private static WebElement fluffyBunnyBuyButton;
    @FindBy(xpath = "//li[@id='product-5']//div//p//a")
    private static WebElement smileyBearBuyButton;
    @FindBy(xpath = "//li[@id='product-6']//div//p//a")
    private static WebElement funnyCowBuyButton;
    @FindBy(xpath = "//li[@id='product-7']//div//p//a")
    private static WebElement valentineBearBuyButton;
    @FindBy(xpath = "//li[@id='product-8']//div//p//a")
    private static WebElement smileyFaceBuyButton;


    public void addToyToCartBuyButton(String toyName, Integer num) throws InterruptedException {
        WaitUntilElementVisible(teddyBearBuyButton);
        teddyBearBuyButton.isEnabled();
        int i = 1;
        while (i<=num){                                           //running while loop to add the quantity of the toys requested
            switch (toyName.toLowerCase().trim()) {               //running switch over the toys to select the user's choice
                case "teddybear" -> teddyBearBuyButton.click();
                case "stuffedfrog" -> stuffedFrogBuyButton.click();
                case "handmadedoll" -> handmadeDollBuyButton.click();
                case "fluffybunny" -> fluffyBunnyBuyButton.click();
                case "smileybear" -> smileyBearBuyButton.click();
                case "funnycow" -> funnyCowBuyButton.click();
                case "valentinebear" -> valentineBearBuyButton.click();
                case "smileyface" -> smileyFaceBuyButton.click();
                default -> throw new IllegalArgumentException("Invalid toy name");
            }
            totalCount++;
            i++;
            mediumWait();
        }
    }
}
