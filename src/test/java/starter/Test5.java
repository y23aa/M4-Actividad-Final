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

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

//@RunWith(CucumberSerenityRunner.class) TODO: USED WITH CUCUMBER
@RunWith(SerenityRunner.class)
public class Test5 {
    private static final By PHONE_S6_LOCATOR = By.xpath("//a[@href=\"prod.html?idp_=1\"]"); // ToDo: create locators from ids numbers

    private void sleepmSecs(int mSec) {
        try {
            Thread.sleep(Duration.ofMillis(mSec));
        } catch (InterruptedException ie) {
        }
    }

    @Managed
    WebDriver driver;
    WebDriverWait wait;
    HomePage homePage;
    CartPage cartPage;
    ProductPage productPage;

    @Before
    public void setUp() {
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        productPage = new ProductPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void test5_remove_s6_from_cart() {
        homePage.navigateTo();
        homePage.clickOnPhones();
        productPage.clickOnProduct(PHONE_S6_LOCATOR);
        productPage.addProductToCart();
        cartPage.navigateTo();
        assertThat(cartPage.getProductNamesFromCart()).contains("Samsung galaxy s6");
        cartPage.removeProductFromCart("Samsung galaxy s6");
        sleepmSecs(750);
        assertThat(cartPage.getProductNamesFromCart().size()).isLessThan(1);
    }
}