package com.svlugovoy.testgmailwebui.tests;

import com.svlugovoy.testgmailwebui.categories.Critical;
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
public class GmailSignInTest {

    WebDriver driver = new FirefoxDriver();

    @Category({Critical.class})
    @Test
    public void canLoginWithValidCredentialsAndThenLogOut() {

        SignInPage signInPage = WebUtil.goToSignInPage(driver);
        signInPage.fillUserName(driver, "petrovpetr120@gmail.com");
        signInPage.clickNextButton(driver);
        signInPage.fillPassword(driver, "qwertypasswordW");

        EmailHomePage emailHomePage = signInPage.clickSignIn(driver);
        Assert.assertTrue("Inbox should exist", emailHomePage.isInboxExist(driver));

        signInPage = emailHomePage.signOut(driver);
        Assert.assertTrue("Sign in button should exist", signInPage.isSignInButtonExist(driver));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
