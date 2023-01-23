package starter;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test1_2 {
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

    @Before
    public void setUp() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get(WEBSITE);
    }

    @Test
    public void test1_signup() {
        sleepmSecs(250);
        WebElement SignupButton = driver.findElement(SIGNUP_LOCATOR);
        wait.until(elementToBeClickable(SignupButton));
        SignupButton.click();
        driver.findElement(USERNAME_LOCATOR).sendKeys(TEST_NAME);
        driver.findElement(PASSWORD_LOCATOR).sendKeys(TEST_PWD);
        driver.findElement(SIGNUP_2_LOCATOR).click();
        wait.until(alertIsPresent());
        String alertText=driver.switchTo().alert().getText();
        assertThat(alertText).isEqualToIgnoringCase("Sign up successful.");
        driver.switchTo().alert().accept();  //ToDo: Not sure if necessary
    }

    @Test
    public void test2_login() {
        sleepmSecs(250);
        WebElement LoginButton = driver.findElement(LOGIN_LOCATOR);
        wait.until(elementToBeClickable(LoginButton));
        LoginButton.click();
        driver.findElement(USERNAME2_LOCATOR).sendKeys(TEST_NAME);
        driver.findElement(PASSWORD2_LOCATOR).sendKeys(TEST_PWD);
        driver.findElement(LOGIN_2_LOCATOR).click();
        sleepmSecs(2000);
        wait.until(presenceOfElementLocated(LOGGED_USER_LOCATOR));
        String loggedUserName = driver.findElement(LOGGED_USER_LOCATOR).getText();
        assertThat(loggedUserName).isEqualToIgnoringCase("Welcome " + TEST_NAME);
    }

    @After
    public void close_browser() {
        driver.quit();
    }
}