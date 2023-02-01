package Pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class HomePage extends PageObject {
    private static final By PHONES_LOCATOR = By.xpath("//a[@onclick=\"byCat('phone')\"]");
    private static final By LAPTOPS_LOCATOR = By.xpath("//a[@onclick=\"byCat('notebook')\"]");
    private static final By MONITOR_LOCATOR = By.xpath("//a[@onclick=\"byCat('monitor')\"]");
    private static final By SIGNUP_LOCATOR = By.id("signin2");
    private static final By LOGIN_LOCATOR = By.id("login2");
    private static final By LOGGED_USER_LOCATOR = By.id("nameofuser");

    private static final By LAPTOP_VAIO_I5_LOCATOR = By.xpath("//a[@href='prod.html?idp_=8']"); // ToDo: create locators from ids numbers
    private static final By MONITOR_APPLE_24_LOCATOR = By.xpath("//a[@href='prod.html?idp_=10']");
    private static final By PHONE_S6_LOCATOR = By.xpath("//a[@href='prod.html?idp_=1']");
    private static final By ADD_TO_CART_LOCATOR = By.xpath("//*[@id='tbodyid']/div[2]/div/a[text()='Add to cart']");
    private static final By PHONE_S7_LOCATOR = By.xpath("//a[@href='prod.html?idp_=4']");
    private static final By LAPTOP_VAIO_I7_LOCATOR = By.xpath("//a[@href='prod.html?idp_=9']");

    private WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void navigateTo() {
        this.driver.get("https://www.demoblaze.com/index.html");
        this.driver.manage().window().maximize();
    }

    public void clickOnPhones() {
        this.driver.findElement(PHONES_LOCATOR).click();
        wait.until(ExpectedConditions.and(
                ExpectedConditions.invisibilityOfElementLocated(LAPTOP_VAIO_I5_LOCATOR),
                ExpectedConditions.invisibilityOfElementLocated(MONITOR_APPLE_24_LOCATOR))
        );
    }

    public void clickOnLaptops(){
        this.driver.findElement(LAPTOPS_LOCATOR).click();
        wait.until(ExpectedConditions.and(
                ExpectedConditions.invisibilityOfElementLocated(PHONE_S6_LOCATOR),
                ExpectedConditions.invisibilityOfElementLocated(MONITOR_APPLE_24_LOCATOR))
        );
    }

    public void clickOnMonitors() {
        this.driver.findElement(MONITOR_LOCATOR).click();
        wait.until(ExpectedConditions.and(
                ExpectedConditions.invisibilityOfElementLocated(LAPTOP_VAIO_I5_LOCATOR),
                ExpectedConditions.invisibilityOfElementLocated(PHONE_S6_LOCATOR))
        );
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
        return driver.findElement(LOGGED_USER_LOCATOR).getText();
    }


    // Product methods
    private void clickOnProduct(By productName) {
        wait.until(elementToBeClickable(productName));
        driver.findElement(productName).click();
    }

    public void clickOnPhoneS7(){
        wait.until(elementToBeClickable(PHONE_S7_LOCATOR));
        clickOnProduct(PHONE_S7_LOCATOR);
    }
    public void clickOnPhoneS6(){
        wait.until(elementToBeClickable(PHONE_S6_LOCATOR));
        clickOnProduct(PHONE_S6_LOCATOR);
    }
    public void clickOnLaptopVaioI7(){
        wait.until(elementToBeClickable(LAPTOP_VAIO_I7_LOCATOR));
        clickOnProduct(LAPTOP_VAIO_I7_LOCATOR);
    }

    public void addProductToCart() {
        wait.until(elementToBeClickable((ADD_TO_CART_LOCATOR)));
        driver.findElement(ADD_TO_CART_LOCATOR).click();
        wait.until(alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public List<WebElement> findItemsByLocator(By value) {
        return this.driver.findElements(value);
    }

    private boolean hasItemsByLocator(By locator) {
        return this.findItemsByLocator(locator).size() > 0;
    }
    public boolean hasPhones() {
        return hasItemsByLocator(PHONE_S6_LOCATOR);
    }
    public boolean hasLaptops() {
        return hasItemsByLocator(LAPTOP_VAIO_I5_LOCATOR);
    }
    public boolean hasMonitors() {
        return hasItemsByLocator(MONITOR_APPLE_24_LOCATOR);
    }

}
