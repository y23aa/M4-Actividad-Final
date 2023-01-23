package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private static final By PRODUCT_LOCATOR = By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a");
    private static final By ADD_TO_CART_LOCATOR = By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a[text()='Add to cart']");
    //*[@id="tbodyid"]/div[2]/div/a
    public ProductPage(WebDriver driver) {
            this.driver = driver;
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

    public void clickOnProduct(By productName) {
        wait.until(elementToBeClickable(productName));
        driver.findElement(productName).click();
    }

    public void addProductToCart() {
        wait.until(elementToBeClickable((ADD_TO_CART_LOCATOR)));
        driver.findElement(ADD_TO_CART_LOCATOR).click();
    }
}
