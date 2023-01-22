package starter;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;
import static org.junit.Assert.assertEquals;

@RunWith(SerenityRunner.class)
public class TestStepsGroup4ATest1y2 {

    @Managed
    WebDriver driver;
    private String username;
    private String password;

    @Given("I am on the website")
    public void i_am_on_the_website() {
        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com");
    }

    @When("I click on the signup button")
    public void i_click_on_the_signup_button() {
        WebElement signupButton = driver.findElement(By.id("signin2"));
        signupButton.click();
    }

    @When("I fill in {string} as the username")
    public void i_fill_in_as_the_username(String username) {
        WebElement usernameField = driver.findElement(By.id("sign-username"));
        usernameField.sendKeys("DTXaviH");
        this.username = "DTXaviH";
    }

    @When("I fill in {string} as the password")
    public void i_fill_in_as_the_password(String password) {
        WebElement passwordField = driver.findElement(By.id("sign-password"));
        passwordField.sendKeys("passw123456");
        this.password = "passw123456";
    }

    @When("I click on the signup button 2")
    public void i_click_on_the_signup_button_2() {
        WebElement submitButton = driver.findElement(By.className("btn btn-primary"));
        submitButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        WebElement loginButton = driver.findElement(By.id("login2"));
        loginButton.click();
    }

    @When("I fill in the same username as before")
    public void i_fill_in_the_same_username_as_before() {
        WebElement usernameField = driver.findElement(By.id("loginusername"));
        usernameField.sendKeys(this.username);
    }

    @When("I fill in the same password as before")
    public void i_fill_in_the_same_password_as_before() {
        WebElement passwordField = driver.findElement(By.id("loginpassword"));
        passwordField.sendKeys(this.password);
    }

    @When("I click on the login button 2")
    public void i_click_on_the_login_button_2() {
        WebElement loginSubmitButton = driver.findElement(By.className("btn btn-primary"));
        loginSubmitButton.click();
    }

    @Then("I should be logged in")
    public void i_should_be_logged_in() {
        String expectedUrl = "https://www.demoblaze.com";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
    }

    @After
    public void close_browser() {
        driver.quit();
    }
}