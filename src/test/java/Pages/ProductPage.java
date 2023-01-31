package Pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ProductPage extends PageObject {
    private static final By LAPTOP_VAIO_I5_LOCATOR = By.xpath("//a[@href='prod.html?idp_=8']"); // ToDo: create locators from ids numbers
    private static final By MONITOR_APPLE_24_LOCATOR = By.xpath("//a[@href='prod.html?idp_=10']");
    private static final By PHONE_S6_LOCATOR = By.xpath("//a[@href='prod.html?idp_=1']");
    private static final By ADD_TO_CART_LOCATOR = By.xpath("//*[@id='tbodyid']/div[2]/div/a[text()='Add to cart']");
    private static final By PHONE_S7_LOCATOR = By.xpath("//a[@href='prod.html?idp_=4']");
    private static final By LAPTOP_VAIO_I7_LOCATOR = By.xpath("//a[@href='prod.html?idp_=9']");


    //ToDo remove
    private void sleep1Sec(){
        try {
            Thread.sleep(Duration.ofSeconds(1));
        }
        catch(InterruptedException ie){
        }
    }
    private WebDriver driver;
    private WebDriverWait wait;

    //*[@id="tbodyid"]/div[2]/div/a
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void clickOnProduct(By productName) {
        sleep1Sec();
        wait.until(elementToBeClickable(productName));
        driver.findElement(productName).click();
    }

    public void clickOnPhoneS7(){
        clickOnProduct(PHONE_S7_LOCATOR);
    }
    public void clickOnPhoneS6(){
        clickOnProduct(PHONE_S6_LOCATOR);
    }
    public void clickOnLaptopVaioI7(){
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
