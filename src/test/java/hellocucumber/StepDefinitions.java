package hellocucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitions {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver_win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        loginPage = new LoginPage(driver);
    }
    @When("the user enters valid username and password")
    public void the_user_enters_valid_username_and_password() {
        loginPage.enterUsername("student");
        loginPage.enterPassword("Password123");
        loginPage.clickLoginButton();
    }
    @And("I wait for the page to load")
    public void i_wait_for_the_page_to_load() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
    }
//    @And("I wait for the element to display")
//    public void i_wait_for_element_to_display() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
//    }
    @Then("the message should say {string}")
    public void the_success_message_should_say(String expectedMessage) {
        assertThat(loginPage.isSuccessMessageDisplayed()).isTrue();
    }
}
