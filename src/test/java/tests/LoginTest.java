package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest { // pure test scripts here
                                          // // this way it inherits BaseTest driver object and other variable/methods
    @Test // TestNG . this will. run after @BeforeMethod but before the @AfterMethod from
          // BaseTest.java class
    public void testValidLogin() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterTextAreaTextBox("TEXT AREA TEXTBOX");
        loginPage.enterInputTextBox("INPUT TEXTBOX");
        loginPage.clickSubmitButton();
        System.out.println("Title of the page is :" + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Web form - target page");

    }

}