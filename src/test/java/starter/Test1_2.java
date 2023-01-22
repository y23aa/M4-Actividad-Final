package starter;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

@RunWith(SerenityRunner.class)
public class Test1_2 {
    private static final String WEBSITE = "https://www.demoblaze.com/index.html";
    private static final By SIGNUP_LOCATOR = By.xpath("//*[@id=\"signin2\"]");
    private static final By USERNAME_LOCATOR = By.xpath("//*[@id=\"sign-username\"]");

    @Managed
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(WEBSITE);
    }

    @Test
    public void test1_signup() {
        WebElement SignupButton = driver.findElement(SIGNUP_LOCATOR);
        wait.until(elementToBeClickable(SignupButton));
        SignupButton.click();
        driver.findElement(USERNAME_LOCATOR).click();
        driver.findElement(By.cssSelector("#signin2")).click();
        driver.findElement(By.name("Username")).click();
        driver.findElement(By.name("Username")).sendKeys("UserSiglo12");
        driver.findElement(By.name("Password")).click();
        driver.findElement(By.name("Password")).sendKeys("passw123456");
        driver.findElement(By.name("Sign up")).click();
        driver.findElement(By.name("Ok")).click();
        driver.switchTo().alert().accept();
    }

//    @Test
//    public void test2_login() {
//        driver.get("https://www.demoblaze.com/index.html");
//        driver.findElement(By.cssSelector("#login2")).click();
//        driver.findElement(By.name("Username")).click();
//        driver.findElement(By.name("Username")).sendKeys("UserSiglo12");
//        driver.findElement(By.name("Password")).click();
//        driver.findElement(By.name("Password")).sendKeys("passw123456");
//        driver.findElement(By.name("Log in")).click();
//        driver.findElement(By.name("Ok")).click();
//        String expectedUrl = "https://www.demoblaze.com/index.html";
//        String actualUrl = driver.getCurrentUrl();
//        assertThat(actualUrl).isEqualTo(expectedUrl);
//    }

    @After
    public void close_browser() {
        driver.quit();
    }
}