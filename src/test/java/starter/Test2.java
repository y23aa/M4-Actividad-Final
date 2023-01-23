package starter;

import Pages.*;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test2 {
    private static final String WEBSITE = "https://www.demoblaze.com/index.html";
    private static final By SIGNUP_LOCATOR = By.id("signin2");
    private static final By USERNAME_LOCATOR = By.id("sign-username");
    private static final By PASSWORD_LOCATOR = By.id("sign-password");
    private static final By SIGNUP_2_LOCATOR = By.xpath("//button[@onclick=\"register()\"]");
    private static final By LOGIN_LOCATOR = By.id("login2");
    //private static final By OK_LOCATOR = By.name("Ok");
    private static final By LOGIN_2_LOCATOR = By.xpath("//button[@onclick=\"logIn()\"]");
    private static final By USERNAME2_LOCATOR = By.id("loginusername");
    private static final By PASSWORD2_LOCATOR = By.id("loginpassword");
    private static final By LOGGED_USER_LOCATOR = By.id("nameofuser");

    private static final String TEST_NAME="start121zs";
    private static final String TEST_PWD="marte45szs";

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
    private SignInPage signInPage;
    private LogInPage logInPage;

    @Before
    public void setUp() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        productPage = new ProductPage(driver);
        signInPage = new SignInPage(driver);
        logInPage = new LogInPage(driver);
    }

    @Test
    public void test2_login() {
        homePage.navigateTo();
        homePage.clickOnLogIn();
        logInPage.logInUser(TEST_NAME, TEST_PWD);
        String loggedUserName = homePage.getWelcomeMessage();
        assertThat(loggedUserName).isEqualToIgnoringCase("Welcome " + TEST_NAME);
    }

    @After
    public void close_browser() {
        driver.quit();
    }
}
