package Pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class HomePage extends PageObject {
    private static final By PHONES_LOCATOR = By.xpath("//a[@onclick=\"byCat('phone')\"]");
    private static final By LAPTOPS_LOCATOR = By.xpath("//a[@onclick=\"byCat('notebook')\"]");
    private static final By MONITOR_LOCATOR = By.xpath("//a[@onclick=\"byCat('monitor')\"]");
    private static final By SIGNUP_LOCATOR = By.id("signin2");
    private static final By LOGIN_LOCATOR = By.id("login2");
    private static final By IMAGE_LOCATOR = By.cssSelector(".card-img-top img-fluid");
    private static final By LOGGED_USER_LOCATOR = By.id("nameofuser");


    private WebDriver driver;

    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void navigateTo() {
        this.driver.get("https://www.demoblaze.com/index.html");
        this.driver.manage().window().maximize();
    }

    public void clickOnPhones() {
        this.driver.findElement(PHONES_LOCATOR).click();
    }

    public void clickOnLaptops() {
        this.driver.findElement(LAPTOPS_LOCATOR).click();
    }
    public void clickOnMonitors() {
        this.driver.findElement(MONITOR_LOCATOR).click();
    }
    public void clickOnSignIn() {
        wait.until(elementToBeClickable(SIGNUP_LOCATOR));
        this.driver.findElement(SIGNUP_LOCATOR).click();
    }
    public void clickOnLogIn() {
        wait.until(elementToBeClickable(LOGIN_LOCATOR));
        this.driver.findElement(LOGIN_LOCATOR).click();
    }

    public String getWelcomeMessage() {
        wait.until(visibilityOfElementLocated(LOGGED_USER_LOCATOR));
        String loggedUserName = driver.findElement(LOGGED_USER_LOCATOR).getText();
        return loggedUserName;
    }
}
