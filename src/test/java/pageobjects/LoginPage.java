package pageobjects;

import base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.BaseTest;

public class LoginPage extends BasePage {

   
    @FindBy(css = "input[name='username']")
    private WebElementFacade usernameTf;

    @FindBy(css = "input[name='password']")
    private WebElementFacade passwordTf;

    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
    private WebElementFacade loginBtn;

    @FindBy(css = "div[class='oxd-alert oxd-alert--error']")
    private WebElementFacade errorMessageLoginFailed;


    public void inputUsername(){
        waitFor(ExpectedConditions.visibilityOf(usernameTf));
        usernameTf.sendKeys(BaseTest.getValidUser());
    }

    public void inputPassword(){
        passwordTf.sendKeys(BaseTest.getValidPassword());
    }

    public void clickOnLogin(){
        loginBtn.click();

    }


    public void inputInvalidUsername() {
        usernameTf.sendKeys(BaseTest.getInValidUser());
    }

    public void inputInvalidPassword() {
        passwordTf.sendKeys(BaseTest.getInValidPassword());
    }

    public boolean invalidCredentials(String errorMessage) {
        return errorMessageLoginFailed.getText().toLowerCase().contains(errorMessage.toLowerCase());
    }
}
