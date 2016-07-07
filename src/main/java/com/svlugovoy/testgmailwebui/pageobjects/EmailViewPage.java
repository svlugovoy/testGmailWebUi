package com.svlugovoy.testgmailwebui.pageobjects;

import com.svlugovoy.testgmailwebui.utils.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Sergey Lugovoy <svlugovoy@gmail.com> 26.05.2016.
 */
public class EmailViewPage {

    public String getEmailSubjectText(WebDriver driver){
        return WebUtil.getElementText(driver, By.cssSelector("h2[class='hP']"));
    }

    public String getEmailBodyText(WebDriver driver){
        return WebUtil.getElementText(driver, By.cssSelector("div[dir='ltr']"));
    }
}
