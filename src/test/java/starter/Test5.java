package starter;

//import io.cucumber.junit.CucumberSerenityRunner; TODO: USED WITH CUCUMBER
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

//@RunWith(CucumberSerenityRunner.class) TODO: USED WITH CUCUMBER
@RunWith(SerenityRunner.class)
public class Test5 {
    @Managed
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void remove_s6_from_cart(){
        driver.get("https://www.bing.com");

        driver.findElement(By.id("sb_form_q")).sendKeys("CHEESECAKE" + Keys.ENTER);
        wait.until(presenceOfElementLocated(By.cssSelector(".b_poleContent")));
        wait.until(elementToBeClickable(By.cssSelector("#b_filterTabBar > a:nth-child(1)")));
        String title=driver.findElement(By.cssSelector(".b_antiSideBleed")).getText();

        assertThat(title).isEqualToIgnoringCase("Recipes");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
