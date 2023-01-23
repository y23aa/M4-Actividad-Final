package starter;

import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.SignInPage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test1 {
    private static final String TEST_NAME="start121zasaaaasdfs";
    private static final String TEST_PWD="marte45szasaadafass";

    @Managed
    WebDriver driver;
    WebDriverWait wait;
    private HomePage homePage;
    private CartPage cartPage;
    private ProductPage productPage;
    private SignInPage signInPage;
    @Before
    public void setUp() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        productPage = new ProductPage(driver);
        signInPage = new SignInPage(driver);
    }

    @Test
    public void test1_signup() {
        homePage.navigateTo();
        homePage.clickOnSignIn();
        String alertText = signInPage.createUser(TEST_NAME, TEST_PWD);
        assertThat(alertText).isEqualToIgnoringCase("Sign up successful.");
    }


    @After
    public void close_browser() {
        driver.quit();
    }
}