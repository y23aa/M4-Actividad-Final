package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.stream.Collectors;

public class CartPage {
    private WebDriver driver;
    private static final By VIEW_CART_LOCATOR = By.id("cartur");
    private static final By HOME_PAGE_LOCATOR = By.xpath("//*[@id='navbarExample']/ul/li[1]/a");
    private static final By CART_ROWS_NAME_LOCATOR = By.xpath("//*[@id='tbodyid']/tr/td[2]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.findElement(VIEW_CART_LOCATOR).click();
    }

    public List<String> getProductNames() {
        return driver.findElements(CART_ROWS_NAME_LOCATOR)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void goToHomePage() {
        driver.findElement(HOME_PAGE_LOCATOR).click();
    }
}