package pages;

import Testbase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactPage extends Base {

    public ContactPage(WebDriver driver, WebDriverWait wait){
        super(driver,wait);
        PageFactory.initElements(driver,this);
    }
    static String fName;

    @FindBy(id = "forename")                      //web elements of contact page
    private static WebElement foreNameTextField;

    @FindBy(id = "email")
    private static WebElement emailTextField;

    @FindBy(id = "message")
    private static WebElement messageTextField;

    @FindBy(xpath = "//div[@class='container-fluid']//div//form//a")
    private static WebElement submitFormButton;

    @FindBy(className = "alert-success")
    private static WebElement alertMessage;

    public void fillMandatoryInformation(String forename, String email, String message) throws InterruptedException {  //function to add mandatory data
        WaitUntilElementVisible(foreNameTextField);
        foreNameTextField.sendKeys(forename);
        emailTextField.sendKeys(email);
        messageTextField.sendKeys(message);
        fName = forename;
    }

    public void clickOnSubmitButton(){
        WaitUntilElementVisible(submitFormButton);
        submitFormButton.click();
    }

    public void verifySuccessfulMessage() {
        String ack = wait.until(d -> d.findElement(By.className("alert-success"))).getText();
    assertEquals("Thanks "+fName +", we appreciate your feedback.",ack); //checks if the successful message appears or not
    }
}
