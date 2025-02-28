package stepDefinitions;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert; 
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        BaseTest.setUp();
        driver = BaseTest.getDriver();
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown() {
        BaseTest.tearDown();
    }

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("User enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("User clicks the login button")
    public void user_clicks_the_login_button() {
        loginPage.clickLogin();
    }

    @Then("User should see an error message {string}")
    public void user_should_see_an_error_message(String expectedError) {
        Assert.assertEquals(expectedError, loginPage.getErrorMessage());
    }

    @Then("User should be redirected to the homepage")
    public void user_should_be_redirected_to_the_homepage() {
        Assert.assertTrue("Login failed!", driver.getCurrentUrl().contains("inventory.html"));
    }


}
