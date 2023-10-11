package cucumberSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;
import pageobjects.LoginPage;

public class LoginSteps {

    @Steps
    LoginPage loginPage;


    @Given("user is on the login page")
    public void userIsOnTheLoginPage(){
        loginPage.openOrangeHrmWeb();
    }

    @When("user enters a valid username")
    public void userEntersAValidUsername() {
        loginPage.inputUsername();
    }

    @And("user enters a valid password")
    public void userEntersAValidPassword() {
        loginPage.inputPassword();
    }

    @And("clicks the Login button")
    public void clicksTheLoginButton() {
        loginPage.clickOnLogin();
    }

    @Then("user should be redirected to the {string} page")
    public void userShouldBeRedirectedToTheDashboardPage(String title) {
        Assert.assertTrue(loginPage.verifyMenu(title));
    }

    @When("user enters a invalid username")
    public void userEntersAInvalidUsername() {

        loginPage.inputInvalidUsername();

    }

    @And("user enters a invalid password")
    public void userEntersAInvalidPassword() {
        loginPage.inputInvalidPassword();
    }

    @Then("user should see an error message {string}")
    public void userShouldSeeAnErrorMessage(String errorMessage) {
        Assert.assertTrue(loginPage.invalidCredentials(errorMessage));
    }
}
