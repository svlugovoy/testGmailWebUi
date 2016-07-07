package com.svlugovoy.testgmailwebui.pageobjects;

import com.svlugovoy.testgmailwebui.utils.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Sergey Lugovoy <svlugovoy@gmail.com> 26.05.2016.
 */
public class SignInPage {

    public void fillUserName(WebDriver driver, String text) {
        WebUtil.clearAndSendKeys(driver, By.id("Email"), text);
    }

    public void fillPassword(WebDriver driver, String text) {
        WebUtil.waitForElementVisible(driver, By.id("Passwd"));
        WebUtil.clearAndSendKeys(driver, By.id("Passwd"), text);
    }

    public EmailHomePage clickSignIn(WebDriver driver) {
        WebUtil.click(driver, By.id("signIn"));
        WebUtil.waitForElementVisible(driver, By.partialLinkText("Inbox"));

        return PageFactory.initElements(driver, EmailHomePage.class);
    }

    public boolean isSignInButtonExist(WebDriver driver) {
        return WebUtil.isElementExist(driver, By.id("signIn"));
    }

    public void clickNextButton(WebDriver driver) {
        WebUtil.click(driver, By.id("next"));
    }
}
