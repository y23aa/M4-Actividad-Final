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

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;
//import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

//@RunWith(CucumberSerenityRunner.class) TODO: USED WITH CUCUMBER
@RunWith(SerenityRunner.class)
public class Test5_6 {
    private static final String WEBSITE = "https://www.demoblaze.com/index.html";
    private static final String PHONES_LOCATOR = "//a[@onclick=\"byCat('phone')\"]";
    private static final String PHONE_S6_LOCATOR = "//a[@href=\"prod.html?idp_=1\"]";
    private static final String ADD_TO_CART_LOCATOR = "//a[@onclick=\"addToCart(1)\"]";
    private static final String VIEW_CART_LOCATOR = "cartur";
    private static final String CART_FIRST_ROW_NAME_LOCATOR = "//*[@id='tbodyid']/tr/td[2]";
    @Managed
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void remove_s6_from_cart(){
        driver.get(WEBSITE);
        driver.findElement(By.xpath(PHONES_LOCATOR)).click();
        driver.findElement(By.xpath(PHONE_S6_LOCATOR)).click();
        WebElement addToCartButton = driver.findElement(By.xpath(ADD_TO_CART_LOCATOR));
        wait.until(elementToBeClickable(addToCartButton));
        addToCartButton.click();
        wait.until(alertIsPresent());
        driver.switchTo().alert().accept();
        driver.findElement(By.id(VIEW_CART_LOCATOR)).click();
        String title = driver.findElement(By.xpath(CART_FIRST_ROW_NAME_LOCATOR)).getText();
        assertThat(title).isEqualToIgnoringCase("Samsung galaxy s6");
    }


    @After
    public void tearDown(){
        driver.quit();
    }
}
