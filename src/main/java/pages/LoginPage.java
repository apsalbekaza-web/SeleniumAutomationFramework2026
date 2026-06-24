package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver; // private WebDriver because LoginPage needs a way to use the same brwoser that
                              // BaseTest already opened.
                              // But LoginPage does not extend BaseTest
                              // soo we pass the driver into it: LoginPgae loginPage = new LoginPage(driver)
    private By textareaTextBox = By.className("form-control");
    private By textinputTextBox = By.id("my-text-id");
    //private By submitButton = By.xpath("/html/body/main/div/form/div/div[2]/label[3]/input");
    private By submitButton = By.xpath("//button[text()='Submit']");

    public LoginPage(WebDriver driver) { // creating a constuctor which then we will pass driver object in test class
                                         // and then we save that driver in this page objects variable so other mehtods
                                         // can use it in this class
        this.driver = driver;
    }

    public void enterTextAreaTextBox(String text) {
        driver.findElement(textareaTextBox).sendKeys(text); // is equivalent to driver.findElement(By.className("form-control")).sendKeys(text);
                                                            // were passing object inside findElement() so you can either create the object inside or could create those object in advance and just use the object variable
    }

    public void enterInputTextBox(String text) {
        driver.findElement(textinputTextBox).sendKeys(text);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();

    }

}
