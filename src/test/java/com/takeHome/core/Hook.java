package com.takeHome.core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Hook {

    private static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        return driver;
    }

    public static AppiumDriver createDriver() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setDeviceName("sdk_gphone64_arm64");
        options.setAutomationName("uiautomator2");
        options.setApp("/Users/williampez/Documents/TakeHome/src/test/resources/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        options.setAppPackage("com.swaglabsmobileapp");
        options.setAppActivity("com.swaglabsmobileapp.MainActivity");


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        return driver;

    }

    public static void killDriver( ) {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
