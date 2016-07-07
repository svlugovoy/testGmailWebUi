package com.svlugovoy.testgmailwebui.tests;

import com.svlugovoy.testgmailwebui.categories.Major;
import com.svlugovoy.testgmailwebui.pageobjects.EmailHomePage;
import com.svlugovoy.testgmailwebui.pageobjects.SignInPage;
import com.svlugovoy.testgmailwebui.utils.WebUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Sergey Lugovoy <svlugovoy@gmail.com> 26.05.2016.
 */
public class GmailSendEmailTest {

    WebDriver driver = new FirefoxDriver();

    @Category({Major.class})
    @Test
    public void canSendEmail() {
        SignInPage signInPage = WebUtil.goToSignInPage(driver);
        signInPage.fillUserName(driver, "petrovpetr120@gmail.com");
        signInPage.clickNextButton(driver);
        signInPage.fillPassword(driver, "qwertypassword");
        EmailHomePage emailHomePage = signInPage.clickSignIn(driver);
        emailHomePage.clickComposeButton(driver);
        emailHomePage.fillFieldTo(driver, "petrovpetr120@gmail.com");
        emailHomePage.fillFieldSubject(driver, "some subject");
        emailHomePage.fillBodyEmail(driver, "Hello, world");
        emailHomePage.clickSendButton(driver);

        Assert.assertTrue("Sign in button should exist", emailHomePage.isAlertMessageHasBeenSendExist(driver));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
