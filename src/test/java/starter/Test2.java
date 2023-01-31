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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test2 {
    private static final String TEST_NAME="start121zs";
    private static final String TEST_PWD="marte45szs";

    @Managed
    WebDriver driver;
    WebDriverWait wait;
    private HomePage homePage;
    private LogInPage logInPage;

    @Before
    public void setUp() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        homePage = new HomePage(driver);
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
