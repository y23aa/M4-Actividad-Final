package Pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class SignInPage extends PageObject {
    private static final By USERNAME_LOCATOR = By.id("sign-username");
    private static final By PASSWORD_LOCATOR = By.id("sign-password");
    private static final By CREATE_BUTTON = By.xpath("//button[@onclick=\"register()\"]");

    private WebDriver driver;
    private WebDriverWait wait;
    public SignInPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String createUser(String testName, String testPwd) {
        wait.until(elementToBeClickable(CREATE_BUTTON));
        driver.findElement(USERNAME_LOCATOR).sendKeys(testName);
        driver.findElement(PASSWORD_LOCATOR).sendKeys(testPwd);
        driver.findElement(CREATE_BUTTON).click();
        wait.until(alertIsPresent());
        String alertText=driver.switchTo().alert().getText();
        return alertText;
    }
}
