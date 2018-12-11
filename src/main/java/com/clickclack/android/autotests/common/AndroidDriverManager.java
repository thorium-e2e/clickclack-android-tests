package com.clickclack.android.autotests.common;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AndroidDriverManager {

    public static AndroidDriver currentDriver;

    public static String getScreenshot(String screenshotName) throws Exception {
        //below line is just to append the date format with the screenshot name to avoid duplicate names
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        File srcFiler=currentDriver.getScreenshotAs(OutputType.FILE);
        //after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "/target/ExtentReports/TestsScreenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(srcFiler, finalDestination);
        //Returns the captured file path
        return destination;
    }
}
