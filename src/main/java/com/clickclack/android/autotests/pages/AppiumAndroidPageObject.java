package com.clickclack.android.autotests.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.List;

class AppiumAndroidPageObject {

    AndroidDriver driver;

    boolean isElementDisplayed(By selector) {
        return driver.findElement(selector).isDisplayed();
    }

    void clickTo(By selector) {
        driver.findElement(selector).click();
    }

    List listElements(By selector) {
        return driver.findElements(selector);
    }

    void fillWithText(By selector, String text) {
        driver.findElement(selector).sendKeys(text);
    }
}
