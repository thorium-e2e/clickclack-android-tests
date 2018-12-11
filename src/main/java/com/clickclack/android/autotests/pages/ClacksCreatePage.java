package com.clickclack.android.autotests.pages;

import com.clickclack.android.autotests.common.ExtentLogger;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.testng.Assert;

@SuppressWarnings("UnusedReturnValue")
public class ClacksCreatePage extends AppiumAndroidPageObject{

    private final By btn_reset = By.id("clickclack.apothuaud.com.clickclack:id/clack-create-btn-reset");
    private final By btn_add = By.id("clickclack.apothuaud.com.clickclack:id/clack-create-btn-add");
    private final By btn_submit = By.id("clickclack.apothuaud.com.clickclack:id/clack-create-btn-submit");
    private final By fields_key = By.id("clickclack.apothuaud.com.clickclack:id/create_clack_key");
    private final By fields_value = By.id("clickclack.apothuaud.com.clickclack:id/create_clack_value");

    public ClacksCreatePage(AndroidDriver driver){
        this.driver = driver;
    }

    public ClacksCreatePage send() {
        ExtentLogger.INFO("Submit the form");
        clickTo(btn_submit);
        ExtentLogger.INFO("Button clicked");
        return this;
    }

    public ClacksCreatePage verifyKeyFieldIsPresent() {
        ExtentLogger.INFO("Verify KeyField is present");
        Assert.assertTrue(isElementDisplayed(fields_key));
        ExtentLogger.INFO("Element verified");
        return this;
    }

    public ClacksCreatePage verifyValueFieldIsPresent() {
        ExtentLogger.INFO("Verify ValueField is present");
        Assert.assertTrue(isElementDisplayed(fields_value));
        ExtentLogger.INFO("Element verified");
        return this;
    }

    public ClacksCreatePage verifyResetButtonIsPresent() {
        ExtentLogger.INFO("Verify Reset button is present");
        Assert.assertTrue(isElementDisplayed(btn_reset));
        ExtentLogger.INFO("Element verified");
        return this;
    }

    public ClacksCreatePage verifyAddButtonIsPresent() {
        ExtentLogger.INFO("Verify Add button is present");
        Assert.assertTrue(isElementDisplayed(btn_add));
        ExtentLogger.INFO("Element verified");
        return this;
    }

    public ClacksCreatePage verifySubmitButtonIsPresent() {
        ExtentLogger.INFO("Verify Submit button is present");
        Assert.assertTrue(isElementDisplayed(btn_submit));
        ExtentLogger.INFO("Element verified");
        return this;
    }

    public ClacksCreatePage verifyNbFieldsPair(int i) {
        ExtentLogger.INFO("Verify nb fields = " + i);
        Assert.assertEquals(listElements(fields_key).size(), i);
        ExtentLogger.INFO("Nb fields verified");
        return this;
    }

    public ClacksCreatePage addFields() {
        ExtentLogger.INFO("Add fields");
        clickTo(btn_add);
        ExtentLogger.INFO("Button clicked");
        return this;
    }

    public ClacksCreatePage fillKeyField(int pos, String key) {
        ExtentLogger.INFO("Fill key field n° " + pos + " with key: " + key);
        ((AndroidElement)driver.findElements(fields_key).get(pos)).sendKeys(key);
        ExtentLogger.INFO("Keys sent");
        return this;
    }

    public ClacksCreatePage fillValueField(int pos, String value) {
        ExtentLogger.INFO("Fill value field n° " + pos + " with key: " + value);
        ((AndroidElement)driver.findElements(fields_value).get(pos)).sendKeys(value);
        ExtentLogger.INFO("Keys sent");
        return this;
    }

    public ClacksCreatePage reset() {
        ExtentLogger.INFO("Reset fields");
        clickTo(btn_reset);
        ExtentLogger.INFO("Button clicked");
        return this;
    }

    public ClacksCreatePage verifyEmptyKeyField(int pos) {
        ExtentLogger.INFO("Verify empty key field at pos " + pos);
        Assert.assertEquals(((AndroidElement)driver.findElements(fields_key).get(pos)).getText(), "key");
        ExtentLogger.INFO("Verified");
        return this;
    }

    public ClacksCreatePage verifyEmptyValueField(int pos) {
        ExtentLogger.INFO("Verify empty value field at pos " + pos);
        Assert.assertEquals(((AndroidElement)driver.findElements(fields_value).get(pos)).getText(), "key");
        ExtentLogger.INFO("Verified");
        return this;
    }
}
