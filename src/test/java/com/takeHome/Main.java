package com.takeHome;

import com.takeHome.core.Hook;
import com.takeHome.pages.LoginPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Main {

    public static AndroidDriver driver;
    private static LoginPage loginPage;

    @BeforeAll
    public static void setUp() throws MalformedURLException {
        driver = (AndroidDriver) Hook.createDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void installApp () throws MalformedURLException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Deu bom");
        loginPage.enterUsername("123");
        loginPage.enterPassword("123");
    }

  /*  @AfterAll
    public static void tearDown() {
        Hook.killDriver();
    } */
}
