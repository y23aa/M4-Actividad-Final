package starter;

//import io.cucumber.junit.CucumberSerenityRunner; TODO: USED WITH CUCUMBER
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
public class Test3_4 {
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

    private void sleep1Sec(){
        try {
            Thread.sleep(Duration.ofSeconds(1));
        }
        catch(InterruptedException ie){
        }
    }

    @Managed
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(WEBSITE);
    }

    @Test
    public void test3_navigate_between_different_products(){
        driver.findElement(PHONES_LOCATOR).click();
        sleep1Sec();
        assertThat(driver.findElements(PHONE_S6_LOCATOR).size()).isGreaterThanOrEqualTo(1);
        assertThat(driver.findElements(LAPTOP_VAIO_I5_LOCATOR).size()).isLessThan(1);
        assertThat(driver.findElements(MONITOR_APPLE_24_LOCATOR).size()).isLessThan(1);

        driver.findElement(LAPTOPS_LOCATOR).click();
        sleep1Sec();
        assertThat(driver.findElements(PHONE_S6_LOCATOR).size()).isLessThan(1);
        assertThat(driver.findElements(LAPTOP_VAIO_I5_LOCATOR).size()).isGreaterThanOrEqualTo(1);
        assertThat(driver.findElements(MONITOR_APPLE_24_LOCATOR).size()).isLessThan(1);

        driver.findElement(MONITOR_LOCATOR).click();
        sleep1Sec();
        assertThat(driver.findElements(PHONE_S6_LOCATOR).size()).isLessThan(1);
        assertThat(driver.findElements(LAPTOP_VAIO_I5_LOCATOR).size()).isLessThan(1);
        assertThat(driver.findElements(MONITOR_APPLE_24_LOCATOR).size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void test4_add_samsung_s7_samsung_s6_vaio_i7() {
        // add samsung s7
        driver.findElement(PHONES_LOCATOR).click();
        wait.until(elementToBeClickable((PHONE_S7_LOCATOR)));
        driver.findElement(PHONE_S7_LOCATOR).click();
        WebElement addToCartS7Button = driver.findElement(ADD_TO_CART_MOBILE_S7_LOCATOR);
        wait.until(elementToBeClickable(addToCartS7Button));
        addToCartS7Button.click();
        wait.until(alertIsPresent());
        driver.switchTo().alert().accept();


        // back to home
        driver.findElement(HOME_PAGE_LOCATOR).click();
        wait.until(elementToBeClickable((PHONES_LOCATOR)));

        // add samsung s6
        driver.findElement(PHONES_LOCATOR).click();
        wait.until(elementToBeClickable((PHONE_S6_LOCATOR)));
        driver.findElement(PHONE_S6_LOCATOR).click();
        WebElement addToCartS6Button = driver.findElement(ADD_TO_CART_MOBILE_S6_LOCATOR);
        wait.until(elementToBeClickable(addToCartS6Button));
        addToCartS6Button.click();
        wait.until(alertIsPresent());
        driver.switchTo().alert().accept();
        driver.findElement(VIEW_CART_LOCATOR).click();

        // back to home
        driver.findElement(HOME_PAGE_LOCATOR).click();
        wait.until(elementToBeClickable((LAPTOPS_LOCATOR)));

        // add samsung s6
        driver.findElement(LAPTOPS_LOCATOR).click();
        wait.until(elementToBeClickable((LAPTOP_VAIO_I7_LOCATOR)));
        driver.findElement(LAPTOP_VAIO_I7_LOCATOR).click();
        WebElement addToCartVaioI7Button = driver.findElement(ADD_TO_CART_LAPTOP_VAIO_I7);
        wait.until(elementToBeClickable(addToCartVaioI7Button));
        addToCartVaioI7Button.click();
        wait.until(alertIsPresent());
        driver.switchTo().alert().accept();

        // check
        driver.findElement(VIEW_CART_LOCATOR).click();
        wait.until(elementToBeClickable(TOTAL_PRICE_LOCATOR));
        List<WebElement> itemsInCart = driver.findElements(CART_ROWS_NAME_LOCATOR);
        System.out.println(itemsInCart.size());
        for (int i = 0; i < itemsInCart.size(); i++) {
            assertThat(itemsInCart.get(i).getText()).isIn(WANTED_ITEMS);
        }
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
