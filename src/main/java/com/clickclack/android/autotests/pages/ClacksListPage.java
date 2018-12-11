package com.clickclack.android.autotests.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

@SuppressWarnings({"UnusedReturnValue", "unused", "FieldCanBeLocal"})
public class ClacksListPage {

    private static final String BTN_CREATE_ID = "clickclack.apothuaud.com.clickclack:id/create_clack_btn";

    private static final String CLACKS_LIST_ID = "clickclack.apothuaud.com.clickclack:id/clack_list";

    private static final String ID_LABEL_ID = "clickclack.apothuaud.com.clickclack:id/clack_id_label";
    private static final String ID_VALUE_ID = "clickclack.apothuaud.com.clickclack:id/clack_id_value";
    private static final String ATTRS_LABEL_ID = "clickclack.apothuaud.com.clickclack:id/clack_attrs_label";
    private static final String ATTRS_VALUE_ID = "clickclack.apothuaud.com.clickclack:id/clack_attrs_value";
    private static final String BTN_DETAILS_ID = "clickclack.apothuaud.com.clickclack:id/clack_details_button";
    private static final String BTN_UPDATE_ID = "clickclack.apothuaud.com.clickclack:id/clack_btn_update";
    private static final String BTN_DELETE_ID = "clickclack.apothuaud.com.clickclack:id/clack_btn_delete";

    private AndroidDriver driver;

    public ClacksListPage(AndroidDriver driver) {
        this.driver = driver;
        // wait for th load of list elements
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CLACKS_LIST_ID)));
    }

    public ClacksListPage gotoCreateClack() {
        driver.findElement(By.id(BTN_CREATE_ID)).click();
        return this;
    }

    public ClacksListPage gotoDetailsFirstClack() {
        driver.findElementById(BTN_DETAILS_ID).click();
        return this;
    }

    public ClacksListPage verifyCreateButtonIsPresent() {
        Assert.assertTrue(
                driver.findElementById(BTN_CREATE_ID)
                .isDisplayed()
        );
        return this;
    }

    public ClacksListPage verifyClackIdLabelIsPresent() {
        Assert.assertTrue(
                driver.findElementById(ID_LABEL_ID)
                        .isDisplayed()
        );
        return this;
    }

    public ClacksListPage verifyClackIdValueIsPresent() {
        Assert.assertTrue(
                driver.findElementById(ID_VALUE_ID)
                        .isDisplayed()
        );
        return this;
    }

    public ClacksListPage verifyClackAttrsLabelIsPresent() {
        Assert.assertTrue(
                driver.findElementById(ATTRS_LABEL_ID)
                        .isDisplayed()
        );
        return this;
    }

    public ClacksListPage verifyClackAttrsValueIsPresent() {
        Assert.assertTrue(
                driver.findElementById(ATTRS_VALUE_ID)
                        .isDisplayed()
        );
        return this;
    }

    public ClacksListPage verifyDetailsButtonIsPresent() {
        Assert.assertTrue(
                driver.findElementById(BTN_DETAILS_ID)
                        .isDisplayed()
        );
        return this;
    }

    public ClacksListPage verifyUpdateButtonIsPresent() {
        Assert.assertTrue(
                driver.findElementById(BTN_UPDATE_ID)
                        .isDisplayed()
        );
        return this;
    }

    public ClacksListPage verifyDeleteButtonIsPresent() {
        Assert.assertTrue(
                driver.findElementById(BTN_DELETE_ID)
                        .isDisplayed()
        );
        return this;
    }

    public ClacksListPage gotoUpdateFirstClack() {
        driver.findElementById(BTN_UPDATE_ID)
                .click();
        return this;
    }

    public ClacksListPage gotoDeleteFirstClack() {
        driver.findElementById(BTN_DELETE_ID)
                .click();
        return this;
    }
}
