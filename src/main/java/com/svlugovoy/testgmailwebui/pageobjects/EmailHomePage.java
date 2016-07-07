package com.svlugovoy.testgmailwebui.pageobjects;

import com.svlugovoy.testgmailwebui.utils.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Sergey Lugovoy <svlugovoy@gmail.com> 26.05.2016.
 */
public class EmailHomePage {

    public SignInPage signOut(WebDriver driver) {

        WebUtil.click(driver, By.cssSelector("a .gb_3a.gbii"));
        WebUtil.waitForElementVisible(driver, By.id("gb_71"));
        WebUtil.click(driver, By.id("gb_71"));

        return PageFactory.initElements(driver, SignInPage.class);
    }

    public boolean isInboxExist(WebDriver driver) {
        return WebUtil.isElementExist(driver, By.partialLinkText("Inbox"));
    }

    public void clickComposeButton(WebDriver driver) {
        WebUtil.click(driver, By.cssSelector("div[gh='cm']"));
    }

    public void fillFieldTo(WebDriver driver, String email) {
        WebUtil.waitForElementVisible(driver, By.cssSelector("textarea[aria-label='To']"));
        WebUtil.clearAndSendKeys(driver, By.cssSelector("textarea[aria-label='To']"), email);
    }

    public void fillFieldSubject(WebDriver driver, String subject) {
        WebUtil.clearAndSendKeys(driver, By.cssSelector("input[name='subjectbox']"), subject);
    }

    public void fillBodyEmail(WebDriver driver, String body) {
        WebUtil.clearAndSendKeys(driver, By.cssSelector("div[aria-label='Message Body']"), body);
    }

    public void clickSendButton(WebDriver driver) {
        WebUtil.click(driver, By.cssSelector("div[aria-label*='Send']"));
    }

    public void clickInboxLink(WebDriver driver) {
        WebUtil.click(driver, By.cssSelector("a[aria-label*='Inbox']"));
    }

    public EmailViewPage viewEmail(WebDriver driver, By by) {

        WebUtil.waitForElementVisible(driver, by);
        WebUtil.click(driver, by);

        return PageFactory.initElements(driver, EmailViewPage.class);
    }

    public boolean isAlertMessageHasBeenSendExist(WebDriver driver) {
        WebUtil.waitForElementVisible(driver, By.cssSelector("div[class='vh'] span"));
        return WebUtil.isElementExist(driver, By.cssSelector("div[class='vh'] span"));
    }
}
