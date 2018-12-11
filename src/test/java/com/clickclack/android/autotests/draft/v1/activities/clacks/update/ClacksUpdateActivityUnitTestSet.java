package com.clickclack.android.autotests.draft.v1.activities.clacks.update;

import com.clickclack.android.autotests.pages.ClackUpdatePage;
import com.clickclack.android.autotests.pages.ClacksListPage;
import com.clickclack.android.autotests.pages.HomePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ClacksUpdateActivityUnitTestSet {

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
                .gotoUpdateFirstClack();
    }

    @Test(
            groups = {"unit"},
            description = "Clack Update Page have Reset button"
    )
    public void testUpdatePageHasResetButton() {
        new ClackUpdatePage(mobileDriver)
                .verifyResetButtonIsPresent();
    }

    @Test(
            groups = {"unit"},
            description = "Clack Update Page have Add button"
    )
    public void testUpdatePageHasAddButton() {
        new ClackUpdatePage(mobileDriver)
                .verifyAddButtonIsPresent();
    }

    @Test(
            groups = {"unit"},
            description = "Clack Update Page have Submit button"
    )
    public void testUpdatePageHasSubmitButton() {
        new ClackUpdatePage(mobileDriver)
                .verifySubmitButtonIsPresent();
    }
}
