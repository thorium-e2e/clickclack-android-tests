package com.clickclack.android.autotests.common;

import com.relevantcodes.extentreports.LogStatus;

public class ExtentLogger {

    public static void INFO(String log) {
        try {
            ExtentManager.getCurrentTestMethod().log(LogStatus.INFO, log);
            String screenshot = AndroidDriverManager.getScreenshot("InfoScreenshot - " + ExtentManager.getCurrentTestMethod().getTest().getName());
            Thread.sleep(250);
            ExtentManager.getCurrentTestMethod().log(LogStatus.INFO, ExtentManager.getCurrentTestMethod().addScreenCapture(screenshot));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
