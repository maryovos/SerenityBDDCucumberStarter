# SerenityBDDCucumberStarter
Welcome to the Serenity BDD and Cucumber Starter project! This repository provides a solid foundation for getting started with Behavior-Driven Development (BDD) using Serenity and Cucumber in your Java test automation projects.

## Prerequisites
Before you begin, ensure you have met the following requirements:
1. Download [Java Open JDK](https://www.oracle.com/java/technologies/downloads/) ||
   [Tutorial Installation Java in Windows](https://www.kodingindonesia.com/cara-install-jdk/).
  You can check if it's installed by running **`java -version`** in your terminal.
2. Download [Apache Maven](https://maven.apache.org/download.cgi): Maven is used for building and managing the project. Download and install Maven by following the instructions on the official website.
   
`*If your computer already installed Java and Maven, you can skip step number 1 and 2.`

## Download Code Editor IntelliJ IDEA Community Edition (Optional)
Download [IntelliJ IDEA](https://www.jetbrains.com/idea/download/): IntelliJ IDEA is a popular Java IDE that provides great support for Maven projects. You can download the Community Edition for free.

`*IntelliJ IDEA for your code editor is optional, you can still used another code editor like Eclipse or Visual Studio Code.`

## Setup

1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/maryovos/SerenityBDDCucumberStarter.git

2. Navigate to the project directory:

    ```bash
   cd serenityBDDCucumberStarter

## Running Tests
You Can run the Serenity BDD test with the following command:

   ```bash
   mvn clean verify 
  ```
## Running Tests with Specific Tags
You can run tests with specific Cucumber tags using the `*-Dtags*` option. For example, to run tests with the `*@smoke*` tag, use:

 ```bash
  mvn clean verify -Dtags=smoke
```

## Running Test Case with Specific Environment (file `serenity.conf`)

file `serenity.conf` located in folder `src/test/resources`

```
mvn clean verify -Denvironment=value
```

## Test Reports
After running the tests, Serenity BDD generates detailed test reports in the `target/site` directory. You can open the `index.html` file in your web browser to view the test results and reports.

## Adding Your Own Tests
To create your own Serenity BDD tests, follow these steps:
1. **Create a Feature File**: In the `src/test/resources/features` directory, create a new feature file using the Gherkin syntax. Feature files define the behavior of your application in a human-readable format. Here's an example feature file:

   ```gherkin
   Feature: User Login
     As a user,
     I want to log in to my account,
     So that I can access my dashboard.

     Scenario: Successful Login
       Given the user is on the login page
       When the user enters valid credentials
       And clicks the login button
       Then the user should be logged in
       And should see the dashboard

2. **Create Step Definitions**: For each step in your feature file, you need to create corresponding step definition methods. These methods define the automation logic and interact with your application. Place your step definitions in the `src/test/java/cucumberSteps` directory. Here's an example step definition for the above feature:

```java
import net.thucydides.core.annotations.Steps;
import your.package.steps.LoginSteps;

public class LoginStepDefinitions {

    @Steps
    LoginSteps loginSteps;

    @Given("^the user is on the login page$")
    public void theUserIsOnTheLoginPage() {
        loginSteps.openLoginPage();
    }

    @When("^the user enters valid credentials$")
    public void theUserEntersValidCredentials() {
        loginSteps.enterCredentials("username", "password");
    }

    @When("^clicks the login button$")
    public void clicksTheLoginButton() {
        loginSteps.clickLoginButton();
    }

    @Then("^the user should be logged in$")
    public void theUserShouldBeLoggedIn() {
        loginSteps.verifyUserIsLoggedIn();
    }

    @Then("^should see the dashboard$")
    public void shouldSeeTheDashboard() {
        loginSteps.verifyDashboardIsDisplayed();
    }
}
```

3. **Create Page Objects**: To keep your test code maintainable and reusable, implement Page Object pattern. Create Page Object classes in the `src/test/java/pageobjects` directory. These classes should encapsulate the interactions with web elements on the pages you're testing. These classes should encapsulate the interactions with web elements on the pages you're testing. Here's an example Page Object:

```java
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By dashboard = By.id("dashboard");

    public void enterCredentials(String username, String password) {
        $(usernameField).type(username);
        $(passwordField).type(password);
    }

    public void clickLoginButton() {
        $(loginButton).click();
    }

    public boolean isDashboardDisplayed() {
        return $(dashboard).isCurrentlyVisible();
    }
}
```

4. **Write Your Test Logic**: In your step definitions, use the Page Object methods to interact with the application. Implement your test logic and assertions to verify the expected behavior of your application.
