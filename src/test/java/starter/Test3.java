package starter;

//import io.cucumber.junit.CucumberSerenityRunner; TODO: USED WITH CUCUMBER
import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductPage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
//import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

//@RunWith(CucumberSerenityRunner.class) TODO: USED WITH CUCUMBER
@RunWith(SerenityRunner.class)
public class Test3 {
    private static final String WEBSITE = "https://www.demoblaze.com/index.html";
    private static final By PHONES_LOCATOR = By.xpath("//a[@onclick=\"byCat('phone')\"]");
    private static final By LAPTOPS_LOCATOR = By.xpath("//a[@onclick=\"byCat('notebook')\"]");
    private static final By LAPTOP_VAIO_I5_LOCATOR = By.xpath("//a[@href=\"prod.html?idp_=8\"]"); // ToDo: create locators from ids numbers
    private static final By MONITOR_LOCATOR = By.xpath("//a[@onclick=\"byCat('monitor')\"]");
    private static final By MONITOR_APPLE_24_LOCATOR = By.xpath("//a[@href=\"prod.html?idp_=10\"]");

    private static final By PHONE_S7_LOCATOR = By.xpath("//a[@href=\"prod.html?idp_=4\"]");
    private static final By ADD_TO_CART_MOBILE_S7_LOCATOR = By.xpath("//a[@onclick=\"addToCart(4)\"]");
    private static final By VIEW_CART_LOCATOR = By.id("cartur");
    private static final By HOME_PAGE_LOCATOR = By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a");
    private static final By CART_ROWS_NAME_LOCATOR = By.xpath("//*[@id='tbodyid']/tr/td[2]");

    private static final String[] WANTED_ITEMS = {"Samsung galaxy s7", "Samsung galaxy s6", "Sony vaio i7"};
    private static final By PHONE_S6_LOCATOR = By.xpath("//a[@href=\"prod.html?idp_=1\"]");
    private static final By ADD_TO_CART_MOBILE_S6_LOCATOR = By.xpath("//a[@onclick=\"addToCart(1)\"]");
    private static final By TOTAL_PRICE_LOCATOR = By.id("totalp");
    private static final By LAPTOP_VAIO_I7_LOCATOR = By.xpath("//a[@href=\"prod.html?idp_=9\"]");
    private static final By ADD_TO_CART_LAPTOP_VAIO_I7 = By.xpath("//a[@onclick=\"addToCart(9)\"]");

    private void sleep1Sec() {
        try {
            Thread.sleep(Duration.ofSeconds(1));
        } catch (InterruptedException ie) {
        }
    }

    @Managed
    WebDriver driver;
    WebDriverWait wait;
    private HomePage homePage;
    private CartPage cartPage;
    private ProductPage productPage;

    @Before
    public void setUp() {
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        productPage = new ProductPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void test3_navigate_between_different_products() {
        homePage.navigateTo();
        homePage.clickOnPhones();
        sleep1Sec();
        assertThat(productPage.findItemsByLocator(PHONE_S6_LOCATOR).size()).isGreaterThanOrEqualTo(1);
        assertThat(productPage.findItemsByLocator(LAPTOP_VAIO_I5_LOCATOR).size()).isLessThan(1);
        assertThat(productPage.findItemsByLocator(MONITOR_APPLE_24_LOCATOR).size()).isLessThan(1);

        homePage.clickOnLaptops();
        sleep1Sec();
        assertThat(productPage.findItemsByLocator(PHONE_S6_LOCATOR).size()).isLessThan(1);
        assertThat(productPage.findItemsByLocator(LAPTOP_VAIO_I5_LOCATOR).size()).isGreaterThanOrEqualTo(1);
        assertThat(productPage.findItemsByLocator(MONITOR_APPLE_24_LOCATOR).size()).isLessThan(1);

        homePage.clickOnMonitors();
        sleep1Sec();
        assertThat(productPage.findItemsByLocator(PHONE_S6_LOCATOR).size()).isLessThan(1);
        assertThat(productPage.findItemsByLocator(LAPTOP_VAIO_I5_LOCATOR).size()).isLessThan(1);
        assertThat(productPage.findItemsByLocator(MONITOR_APPLE_24_LOCATOR).size()).isGreaterThanOrEqualTo(1);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}