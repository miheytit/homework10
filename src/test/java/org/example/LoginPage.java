package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public WebDriver driver;


    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    @FindBy(xpath = "//span[contains(text(), 'Войти')]")
    private WebElement loginWindowLink;
    @FindBy(xpath = "//button//span[contains(text(), 'Войти')]")
    private WebElement loginButtonLink;
    @FindBy(xpath = "//button[contains(@data-gtm, \"Login — Mail — Click\")]")
    private WebElement loginFieldLink;
    @FindBy(xpath = "//*[contains(@name, 'login')]")
    private WebElement loginField;

    @FindBy(xpath = "//*[contains(@name, 'password')]")
    private WebElement passwdField;

    @FindBy(xpath = "//button[contains(@data-gtm, \"Login Mail — Login — Click\")]")
    private WebElement loginBtn;
    @FindBy(xpath = "//a[contains(@class, \"navigation-user-profile__avatar\")]")
    private WebElement avatar;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }

    public void openLoginWindow() {
        loginWindowLink.click();
        loginButtonLink.click();
        loginFieldLink.click();
    }


    public void clickLoginBtn() {
        loginBtn.click();
    }

    public boolean loginWindowLinkExists() {
        return !driver.findElements(By.xpath("//span[contains(text(), 'Войти')]")).isEmpty();
    }

    public void waitAfterSubmit() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(avatar));
    }


}