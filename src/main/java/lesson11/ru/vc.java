package lesson11.ru;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class vc {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public static void authorization() {
        driver.get("https://vc.ru/");
        driver.findElement(By.xpath("//html/body/div[2]/div/div[4]/div[2]/div/span")).click();
        driver.findElement(By.xpath("//html/body/div[14]/div/div/div[2]/div[2]/div[3]/div[3]/span/button/span")).click();
        driver.findElement(By.xpath("//html/body/div[14]/div/div/div[2]/div[2]/div[3]/div[2]/div/button[1]")).click();
        driver.findElement(By.xpath("//html/body/div[14]/div/div/div[2]/div[2]/div[3]/div[2]/div[1]/div/label/input")).sendKeys("miheytit@gmail.com");
        driver.findElement(By.xpath("//html/body/div[14]/div/div/div[2]/div[2]/div[3]/div[2]/div[2]/div/label/input")).sendKeys("pravdadom66");
        driver.findElement(By.xpath("//html/body/div[14]/div/div/div[2]/div[2]/div[3]/div[2]")).click();
        driver.switchTo().defaultContent();
    }

    public static void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void sendKeys(WebElement element, String phrase) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(phrase);
    }

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "d:\\дрова\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        authorization();
        driver.quit();
    }
}

