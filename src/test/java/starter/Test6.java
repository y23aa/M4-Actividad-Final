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

@RunWith(SerenityRunner.class)
public class Test6 {
    private static final By LAPTOP_VAIO_I7_LOCATOR = By.xpath("//a[@href=\"prod.html?idp_=9\"]");


    private void sleepmSecs(int mSec){
        try {
            Thread.sleep(Duration.ofMillis(mSec));
        }
        catch(InterruptedException ie){
        }
    }

    @Managed
    WebDriver driver;
    WebDriverWait wait;
    private HomePage homePage;
    private CartPage cartPage;
    private ProductPage productPage;
    @Before
    public void setUp(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        productPage = new ProductPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void test6_do_checkout(){
        homePage.navigateTo();
        homePage.clickOnLaptops();
        productPage.clickOnProduct(LAPTOP_VAIO_I7_LOCATOR);
        productPage.addProductToCart();
        cartPage.navigateTo();
        cartPage.buyItemsInCart();
    }


    @After
    public void tearDown(){
        driver.quit();
    }
}