package org.Lesson14;


import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertFalse;

@Data
@AllArgsConstructor

public class LoginTest {
    public static LoginPage loginPage;
    public static WebDriver driver;

    @Step("Запуск браузера")
    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.get(ConfProperties.getProperty("loginpage"));
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
    }

    @Step("Авторизация")
    @Test
    public void LoginCheckTest() {
        loginPage.openLoginWindow();
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.submitLoginForm();
        loginPage.waitAfterSubmit();
        assertFalse(loginPage.loginWindowLinkExists(), "logged in successfully");
    }


    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}

