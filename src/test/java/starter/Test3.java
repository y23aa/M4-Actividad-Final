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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.*;
@RunWith(SerenityRunner.class)
public class Test3 {

    //ToDo remove
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
        sleep1Sec(); //todo remove
        assertThat(productPage.hasPhones()).isTrue();
        assertThat(productPage.hasLaptops()).isFalse();
        assertThat(productPage.hasMonitors()).isFalse();

        homePage.clickOnLaptops();
        sleep1Sec(); //todo remove
        assertThat(productPage.hasPhones()).isFalse();
        assertThat(productPage.hasLaptops()).isTrue();
        assertThat(productPage.hasMonitors()).isFalse();

        homePage.clickOnMonitors();
        sleep1Sec(); //todo remove
        assertThat(productPage.hasPhones()).isFalse();
        assertThat(productPage.hasLaptops()).isFalse();
        assertThat(productPage.hasMonitors()).isTrue();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}