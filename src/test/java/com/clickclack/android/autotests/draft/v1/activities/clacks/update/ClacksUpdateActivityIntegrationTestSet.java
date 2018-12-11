package com.clickclack.android.autotests.draft.v1.activities.clacks.update;

import com.clickclack.android.autotests.pages.HomePage;
import com.clickclack.android.autotests.pages.ClackUpdatePage;
import com.clickclack.android.autotests.pages.ClacksListPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ClacksUpdateActivityIntegrationTestSet {

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
            groups = {"int"},
            description = "I am on Clacks List Page when I go back"
    )
    public void toClacksListPageWhenGoingBack() {
        mobileDriver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        String activity = mobileDriver.currentActivity();
        Assert.assertTrue(activity.contains("ClacksListActivity"));
    }

    @Test(
            groups = {"int"},
            description = "I am on Clacks List Page when I click Submit",
            dependsOnMethods = {"toClacksListPageWhenGoingBack"}
    )
    public void toClackListPageOnClickSubmit() {
        new ClacksListPage(mobileDriver)
                .gotoUpdateFirstClack();
        new ClackUpdatePage(mobileDriver)
                .send();
        String activity = mobileDriver.currentActivity();
        Assert.assertTrue(activity.contains("ClacksListActivity"));
    }
}
