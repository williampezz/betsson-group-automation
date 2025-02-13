package com.takeHome;

import com.takeHome.core.Hook;
import com.takeHome.pages.LoginPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.*;

import java.net.MalformedURLException;
import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Main {

    public static AndroidDriver driver;
    private static LoginPage loginPage;

    @BeforeAll
    public static void setUp() throws MalformedURLException {
        driver = (AndroidDriver) Hook.createDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    @DisplayName("Valid Login Test")
    public void testValidLogin () throws MalformedURLException {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        assertTrue(loginPage.isLoggedIn(), "Login não foi realizado com sucesso.");

    }

    @Test
    @DisplayName("Invalid Login Test")
    public void testInvalidLogin () throws MalformedURLException {
        loginPage.enterUsername("fake_user");
        loginPage.enterPassword("fake_sauce");
    }

    @AfterEach
    public void tearDown() {
        driver.terminateApp("com.swaglabsmobileapp"); // Fecha o app
        driver.activateApp("com.swaglabsmobileapp"); // Reabre o app do zero

    }
}
