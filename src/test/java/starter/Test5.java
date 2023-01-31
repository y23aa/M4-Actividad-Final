package starter;

import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductPage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class Test5 {

    //ToDo remove
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
        productPage.clickOnPhoneS6();
        productPage.addProductToCart();
        cartPage.navigateTo();
        assertThat(cartPage.getProductNamesFromCart()).contains("Samsung galaxy s6");
        cartPage.removeProductFromCart("Samsung galaxy s6");
        sleepmSecs(1500); // todo remove
        assertThat(cartPage.getProductNamesFromCart().size()).isLessThan(1);
    }
}