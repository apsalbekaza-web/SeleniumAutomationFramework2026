package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver driver; // "this driver belongs to the whole BaseTest object, so other mehtods/classes that inherit from BaseTest can use it"

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver(); // actually opens/creates the browser. you sepereate variable and initialization because you want the driver to be available outside just the setUp() method.
                                    // if you just did WebDriver driver = new ChromeDriver(); then the driver will only exists inside setUp(). after that method finishes, LoginTest cannot use it.
                                    // so declate it outisde, initialize it inisde
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null){ // if driver is not null we need to close 
           // driver.quit();
        }
    }
}
