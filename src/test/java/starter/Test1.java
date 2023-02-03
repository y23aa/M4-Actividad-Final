package starter;

import Pages.HomePage;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test1 {
    private static final String TEST_NAME="bddp11";
    private static final String TEST_PWD="marrtrrasadfgs";

    @Managed
    WebDriver driver;
    WebDriverWait wait;
    private HomePage homePage;
    private SignInPage signInPage;
    @Before
    public void setUp() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        homePage = new HomePage(driver);
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
        String osName = System.getProperty("os.name");
        String osVersion = System.getProperty("os.version");
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE dd',' MMMM yyyy");
        String formattedDate = today.format(formatter);

        System.out.println("\nReport name : TEST1");
        System.out.println("O.S name    : " + osName + " version " + osVersion);
        System.out.println("Date        : " + formattedDate + "\n");
        driver.quit();
    }
}