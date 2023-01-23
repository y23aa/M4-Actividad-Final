package starter;

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
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.*;
@RunWith(SerenityRunner.class)
public class Test4 {

    private static final By PHONE_S7_LOCATOR = By.xpath("//a[@href=\"prod.html?idp_=4\"]");

    private static final By PHONE_S6_LOCATOR = By.xpath("//a[@href=\"prod.html?idp_=1\"]");
    private static final By LAPTOP_VAIO_I7_LOCATOR = By.xpath("//a[@href=\"prod.html?idp_=9\"]");

    private void sleep1Sec(){
        try {
            Thread.sleep(Duration.ofSeconds(1));
        }
        catch(InterruptedException ie){
        }
    }

    @Managed
    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;
    private static CartPage cartPage;
    private static ProductPage productPage;

    @Before
    public void setUp() {
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        productPage = new ProductPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void testAddToCart() {
        // Add Samsung galaxy s7
        homePage.navigateTo();
        homePage.clickOnPhones();
        productPage.clickOnProduct(PHONE_S7_LOCATOR);
        productPage.addProductToCart();
        cartPage.navigateTo();
        assertThat(cartPage.getProductNamesFromCart()).contains("Samsung galaxy s7");

        // Add Samsung galaxy s6
        homePage.navigateTo();
        homePage.clickOnPhones();
        productPage.clickOnProduct(PHONE_S6_LOCATOR);
        productPage.addProductToCart();
        cartPage.navigateTo();
        assertThat(cartPage.getProductNamesFromCart()).contains("Samsung galaxy s6");

        // Add Sony vaio i7
        homePage.navigateTo();
        homePage.clickOnLaptops();
        productPage.clickOnProduct(LAPTOP_VAIO_I7_LOCATOR);
        productPage.addProductToCart();
        cartPage.navigateTo();
        assertThat(cartPage.getProductNamesFromCart()).contains("Sony vaio i7");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
