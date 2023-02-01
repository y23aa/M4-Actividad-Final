package starter;

import Pages.CartPage;
import Pages.HomePage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.*;
@RunWith(SerenityRunner.class)
public class Test4 {

    @Managed
    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;
    private static CartPage cartPage;

    @Before
    public void setUp() {
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    @Test
    public void testAddToCart() {
        // Add Samsung galaxy s7
        homePage.navigateTo();
        homePage.clickOnPhones();
        homePage.clickOnPhoneS7();
        homePage.addProductToCart();

        // Add Samsung galaxy s6
        homePage.navigateTo();
        homePage.clickOnPhones();
        homePage.clickOnPhoneS6();
        homePage.addProductToCart();

        // Add Sony vaio i7
        homePage.navigateTo();
        homePage.clickOnLaptops();
        homePage.clickOnLaptopVaioI7();
        homePage.addProductToCart();

        cartPage.navigateToWaitForProduct("Samsung galaxy s6");
        assertThat(cartPage.getProductNamesFromCart()).contains("Sony vaio i7");  //ToDo add this strings to a map with its selector
        assertThat(cartPage.getProductNamesFromCart()).contains("Samsung galaxy s7"); //ToDo add this strings to a map with its selector
        assertThat(cartPage.getProductNamesFromCart()).contains("Samsung galaxy s6");  //ToDo add this strings to a map with its selector
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
