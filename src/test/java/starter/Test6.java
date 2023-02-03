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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RunWith(SerenityRunner.class)
public class Test6 {

    @Managed
    WebDriver driver;
    WebDriverWait wait;
    private HomePage homePage;
    private CartPage cartPage;
    @Before
    public void setUp(){
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    @Test
    public void test6_do_checkout(){
        homePage.navigateTo();
        homePage.clickOnLaptops();
        homePage.clickOnLaptopVaioI7();
        homePage.addProductToCart();
        cartPage.navigateTo();
        cartPage.buyItemsInCart();
    }

    @After
    public void tearDown(){
        String osName = System.getProperty("os.name");
        String osVersion = System.getProperty("os.version");
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE dd',' MMMM yyyy");
        String formattedDate = today.format(formatter);

        System.out.println("\nReport name : TEST6");
        System.out.println("O.S name    : " + osName + " version " + osVersion);
        System.out.println("Date        : " + formattedDate + "\n");
        driver.quit();
    }
}