package com.clickclack.android.autotests.pages;

import com.clickclack.android.autotests.common.ExtentLogger;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

@SuppressWarnings("UnusedReturnValue")
public class ClackDetailsPage extends AppiumAndroidPageObject {

    private final By id_label = By.id("clickclack.apothuaud.com.clickclack:id/clack_details_id_label");
    private final By id_value = By.id("clickclack.apothuaud.com.clickclack:id/clack_details_id_value");
    private final By attrs_label = By.id("clickclack.apothuaud.com.clickclack:id/clack_details_attrs_label");
    private final By attrs_value = By.id("clickclack.apothuaud.com.clickclack:id/clack_details_attrs_value");
    private final By btn_update = By.id("clickclack.apothuaud.com.clickclack:id/clack_details_btn_update");
    private final By btn_delete = By.id("clickclack.apothuaud.com.clickclack:id/clack_details_delete_btn");

    public ClackDetailsPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public ClackDetailsPage verifyIdIsPresent() {
        ExtentLogger.INFO("Verify ID element is present");
        Assert.assertTrue(isElementDisplayed(id_label));
        Assert.assertTrue(isElementDisplayed(id_value));
        ExtentLogger.INFO("Element verified");
        return this;
    }

    public ClackDetailsPage verifyAttributesIsPresent() {
        ExtentLogger.INFO("Verify Attribute element is present");
        Assert.assertTrue(isElementDisplayed(attrs_label));
        Assert.assertTrue(isElementDisplayed(attrs_value));
        ExtentLogger.INFO("Element verified");
        return this;
    }

    public ClackDetailsPage verifyUpdateButtonIsPresent() {
        ExtentLogger.INFO("Verify Update button is present");
        Assert.assertTrue(isElementDisplayed(btn_update));
        ExtentLogger.INFO("Element verified");
        return this;
    }

    public ClackDetailsPage verifyDeleteButtonIsPresent() {
        ExtentLogger.INFO("Verify Delete button is present");
        Assert.assertTrue(isElementDisplayed(btn_delete));
        ExtentLogger.INFO("Element verified");
        return this;
    }

    public ClackDetailsPage gotoUpdatePage() {
        ExtentLogger.INFO("Go to update page");
        clickTo(btn_update);
        ExtentLogger.INFO("Button clicked");
        return this;
    }

    public ClackDetailsPage delete() {
        ExtentLogger.INFO("Go to details page");
        clickTo(btn_delete);
        ExtentLogger.INFO("Button clicked");
        return this;
    }
}
