package stepDefinitions;

import drivers.DriverHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

public class LoginStepDefinitions {

    WebDriver driver = DriverHelper.getDriver();
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        homePage.getTopNavigationBar().goToLogin();
    }

    @When("user login with valid credentials {string} and {string}")
    public void user_login_with_valid_credentials(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("home page displays")
    public void home_page_displays() {
        Assert.assertTrue(homePage.isPageLoaded(), "Home page not displayed !");
    }
}
