package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class HomePage {
    private static final By PHONES_LOCATOR = By.xpath("//a[@onclick=\"byCat('phone')\"]");
    private static final By LAPTOPS_LOCATOR = By.xpath("//a[@onclick=\"byCat('notebook')\"]");
    private static final By MONITOR_LOCATOR = By.xpath("//a[@onclick=\"byCat('monitor')\"]");
    private WebDriver driver;

    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void navigateTo() {
        this.driver.get("https://www.demoblaze.com/index.html");
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

    public List<WebElement> findItemByLocator(By value) {
        return this.driver.findElements(value);

    }
}
