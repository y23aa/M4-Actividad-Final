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
    private void sleep1Sec(){
        try {
            Thread.sleep(Duration.ofSeconds(1));
        }
        catch(InterruptedException ie){
        }
    }
    private WebDriver driver;
    private WebDriverWait wait;

    private static final By ADD_TO_CART_LOCATOR = By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a[text()='Add to cart']");
    //*[@id="tbodyid"]/div[2]/div/a
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickOnProduct(By productName) {
        sleep1Sec();
        wait.until(elementToBeClickable(productName));
        driver.findElement(productName).click();
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
}
