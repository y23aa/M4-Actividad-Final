package starter;

//import io.cucumber.junit.CucumberSerenityRunner; TODO: USED WITH CUCUMBER
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.*;
@RunWith(SerenityRunner.class)
public class Test3 {

    @Managed
    WebDriver driver;
    WebDriverWait wait;
    private HomePage homePage;

    @Before
    public void setUp() {
        homePage = new HomePage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    @Test
    public void test3_navigate_between_different_products() {
        homePage.navigateTo();
        homePage.clickOnPhones();
        assertThat(homePage.hasPhones()).isTrue();
        assertThat(homePage.hasLaptops()).isFalse();
        assertThat(homePage.hasMonitors()).isFalse();

        homePage.clickOnLaptops();
        assertThat(homePage.hasPhones()).isFalse();
        assertThat(homePage.hasLaptops()).isTrue();
        assertThat(homePage.hasMonitors()).isFalse();

        homePage.clickOnMonitors();
        assertThat(homePage.hasPhones()).isFalse();
        assertThat(homePage.hasLaptops()).isFalse();
        assertThat(homePage.hasMonitors()).isTrue();
    }

    @After
    public void tearDown() {
        String osName = System.getProperty("os.name");
        String osVersion = System.getProperty("os.version");
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE dd',' MMMM yyyy");
        String formattedDate = today.format(formatter);

        System.out.println("\nReport name : TEST3");
        System.out.println("O.S name    : " + osName + " version " + osVersion);
        System.out.println("Date        : " + formattedDate + "\n");
        driver.quit();
    }
}