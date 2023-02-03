package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
public class LogInPage {
    private static final By LOGIN_BUTTON_LOCATOR = By.xpath("//button[@onclick=\"logIn()\"]");
    private static final By USERNAME_LOGIN_LOCATOR = By.id("loginusername");
    private static final By PASSWORD_LOGIN_LOCATOR = By.id("loginpassword");


    private WebDriver driver;
    private WebDriverWait wait;
    public LogInPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void logInUser(String testName, String testPwd) {
        wait.until(elementToBeClickable(LOGIN_BUTTON_LOCATOR));
        driver.findElement(USERNAME_LOGIN_LOCATOR).sendKeys(testName);
        driver.findElement(PASSWORD_LOGIN_LOCATOR).sendKeys(testPwd);
        driver.findElement(LOGIN_BUTTON_LOCATOR).click();
    }
}
