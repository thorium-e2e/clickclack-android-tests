package com.clickclack.android.autotests.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

@SuppressWarnings({"UnusedReturnValue", "unused", "FieldCanBeLocal"})
public class HomePage {

    @FindBy(id = "clickclack.apothuaud.com.clickclack:id/button_home_clacks")
    private MobileElement btn_clacks;

    private AndroidDriver driver;

    public HomePage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public HomePage gotoClacks() {
        btn_clacks.click();
        return this;
    }

    public HomePage verifyClacksButtonIsPresent() {
        Assert.assertTrue(btn_clacks.isDisplayed());
        return this;
    }
}
