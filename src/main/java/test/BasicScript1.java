package test; // package name

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicScript1 { // execution without TetsNG. uses Java itself

    public static void main(String[] args) { // entry point of execution

        WebDriver driver = new ChromeDriver(); // can select other drivers

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500)); // make sure that the element is on the page
                                                                           // before you attempt to locate it and the
                                                                           // element is in an interactable state before
                                                                           // you attempt to interact.
                                                                           // implicit wait is rarely the best solution,
                                                                           // but it’s the easiest to demonstrate here
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        String title = driver.getTitle();
        System.out.println("Title is:" + title);

        driver.findElement(By.id("my-text-id")).sendKeys("Hello");

        // OR

        // WebElement inputElement = driver.findElement(By.id("my-text-id"));
        // inputElement.sendKeys("HELLO");

        driver.findElement(By.xpath("/html/body/main/div/form/div/div[1]/label[2]/input")).sendKeys("password");

        // driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/button")).click();

        // OR

        WebElement submitWebElement = driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/button"));
        String submitGetTextValue = submitWebElement.getText();
        System.out.println("Text of Submit Button is: " + submitGetTextValue);

        submitWebElement.click();

        // driver.quit();

    }

}
