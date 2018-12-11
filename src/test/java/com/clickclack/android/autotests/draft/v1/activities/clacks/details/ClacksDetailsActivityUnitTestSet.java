package com.clickclack.android.autotests.draft.v1.activities.clacks.details;

import com.clickclack.android.autotests.pages.ClacksListPage;
import com.clickclack.android.autotests.pages.HomePage;
import com.clickclack.android.autotests.pages.ClackDetailsPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ClacksDetailsActivityUnitTestSet {

    private AndroidDriver mobileDriver;

    @BeforeClass
    public void prepareTests() throws MalformedURLException {
        DesiredCapabilities capabilities = DesiredCapabilities.android();
        capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.9.1");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_API_24");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/adrian/GitHub/clickclack-android/app/build/outputs/apk/debug/app-debug.apk");
        mobileDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        mobileDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        new HomePage(mobileDriver)
                .gotoClacks();

        new ClacksListPage(mobileDriver)
                .gotoDetailsFirstClack();
    }

    @Test(
            groups = {"unit"},
            description = "Clack Details Page have ID text view"
    )
    public void testDetailsPageHasId() {
        new ClackDetailsPage(mobileDriver)
                .verifyIdIsPresent();
    }

    @Test(
            groups = {"unit"},
            description = "Clack Details Page have Attributes text view"
    )
    public void testDetailsPageHasAttributes() {
        new ClackDetailsPage(mobileDriver)
                .verifyAttributesIsPresent();
    }

    @Test(
            groups = {"unit"},
            description = "Clack Details Page have Update button"
    )
    public void testDetailsPageHasUpdateButton() {
        new ClackDetailsPage(mobileDriver)
                .verifyUpdateButtonIsPresent();
    }

    @Test(
            groups = {"unit"},
            description = "Clack Details Page have Delete button"
    )
    public void testDetailsPageHasDeleteButton() {
        new ClackDetailsPage(mobileDriver)
                .verifyDeleteButtonIsPresent();
    }
}
