package starter;

import Pages.CartPage;
import Pages.HomePage;
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

    @Managed
    WebDriver driver;
    WebDriverWait wait;
    HomePage homePage;
    CartPage cartPage;

    @Before
    public void setUp() {
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    @Test
    public void test5_remove_s6_from_cart() {
        homePage.navigateTo();
        homePage.clickOnPhones();
        homePage.clickOnPhoneS6();
        homePage.addProductToCart();
        cartPage.navigateTo();
        assertThat(cartPage.getProductNamesFromCart()).contains("Samsung galaxy s6");
        cartPage.removeProductFromCart("Samsung galaxy s6");
        assertThat(cartPage.getProductNamesFromCart().size()).isLessThan(1);
    }
}