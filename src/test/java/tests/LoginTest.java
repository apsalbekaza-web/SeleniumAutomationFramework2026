package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.Log;

public class LoginTest extends BaseTest { // pure test scripts here
                                          // // this way it inherits BaseTest driver object and other variable/methods
    @Test // TestNG . this will. run after @BeforeMethod but before the @AfterMethod from
          // BaseTest.java class
    public void testValidLogin() {

        Log.info("Starting login test...");
        LoginPage loginPage = new LoginPage(driver);

        Log.info("Entering text into TextboxArea TextBox");
        loginPage.enterTextAreaTextBox("TEXT AREA TEXTBOX");
        Log.info("Entering text into Textbox");
        loginPage.enterInputTextBox("INPUT TEXTBOX");
        loginPage.clickSubmitButton();

        System.out.println("Title of the page is :" + driver.getTitle());
        Log.info("Verifying page title");
        Assert.assertEquals(driver.getTitle(), "Web form - target page");

    }

}