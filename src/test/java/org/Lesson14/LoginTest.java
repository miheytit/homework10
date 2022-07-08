package org.Lesson14;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.jupiter.api.Assertions.assertFalse;


public class LoginTest {
    public static LoginPage loginPage;
    public static WebDriver driver;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.get(ConfProperties.getProperty("loginpage"));
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
    }

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
//        LogEntries browserLogs = driver.manage().logs().get(LogType.BROWSER);
//        List<LogEntry> allLogRows = browserLogs.getAll();
//        if (allLogRows.size() > 0)
//        {
//
//        }
        driver.quit();
    }
}

