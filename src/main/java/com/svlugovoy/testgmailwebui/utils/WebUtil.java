package com.svlugovoy.testgmailwebui.utils;

import com.svlugovoy.testgmailwebui.pageobjects.SignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Sergey Lugovoy <svlugovoy@gmail.com> 26.05.2016.
 */
public class WebUtil {

    public static SignInPage goToSignInPage(WebDriver driver){
        driver.get("http://gmail.com");
        return PageFactory.initElements(driver, SignInPage.class);
    }

    public static void click(WebDriver driver, By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }

    public static void waitForElementVisible(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static boolean isElementExist(WebDriver driver, By by) {
        return driver.findElements(by).size() > 0;
    }

    public static void clearAndSendKeys(WebDriver driver, By by, String text) {
        WebElement element = driver.findElement(by);
        element.clear();
        element.sendKeys(text);
    }

    public static String getElementText(WebDriver driver, By by) {
        WebElement element = driver.findElement(by);
        return element.getText();
    }
}
