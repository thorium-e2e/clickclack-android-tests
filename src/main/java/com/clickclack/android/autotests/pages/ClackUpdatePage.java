package com.clickclack.android.autotests.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

@SuppressWarnings({"FieldCanBeLocal", "unused", "WeakerAccess"})
public class ClackUpdatePage {

    @AndroidFindBy(id = "clack_update_btn_reset")
    AndroidElement btn_reset;

    @AndroidFindBy(id = "clack_update_btn_add")
    AndroidElement btn_add;

    @AndroidFindBy(id = "clack_update_btn_submit")
    AndroidElement btn_submit;

    private static final String KEY_FIELD_ID = "clickclack.apothuaud.com.clickclack:id/create_clack_key";
    private static final String VALUE_FIELD_ID = "clickclack.apothuaud.com.clickclack:id/create_clack_value";

    private AndroidDriver<AndroidElement> driver;

    public ClackUpdatePage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(KEY_FIELD_ID)));
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public ClackUpdatePage addFields() {
        btn_add.click();
        return this;
    }

    public ClackUpdatePage send() {
        btn_submit.click();
        return this;
    }

    public void verifyResetButtonIsPresent() {
        Assert.assertTrue(btn_reset.isDisplayed());
    }

    public void verifyAddButtonIsPresent() {
        Assert.assertTrue(btn_add.isDisplayed());
    }

    public void verifySubmitButtonIsPresent() {
        Assert.assertTrue(btn_submit.isDisplayed());
    }

    public int getNbFieldsPair() {
        return driver.findElementsById(KEY_FIELD_ID).size();
    }

    public ClackUpdatePage reset() {
        btn_reset.click();
        return this;
    }

    public ClackUpdatePage verifyEmptyKeyField(int pos) {
        Assert.assertEquals(driver.findElementsById(KEY_FIELD_ID).get(pos).getText(), "key");
        return this;
    }

    public ClackUpdatePage verifyEmptyValueField(int pos) {
        Assert.assertEquals(driver.findElementsById(VALUE_FIELD_ID).get(pos).getText(), "value");
        return this;
    }
}
